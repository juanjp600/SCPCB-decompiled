Function EntryPoint%()
    Local local0%
    Local local1%
    Local local2%
    Local local3%
    Local local4%
    Local local5%
    Local local6%
    Local local7%
    Local local8#
    Local local9%
    Local local10$
    Local local11$
    Local local12%
    Local local13%
    Local local14%
    Local local15%
    Local local16#
    gfxdrivercapsex = (New gfxdrivercapsex_type)
    fe_pivotsys = $00
    fe_initextflag = $00
    fe_initpostprocessflag = $00
    fe_postprocesstexture1 = $00
    fe_postprocesstexture2 = $00
    fe_postprocesstexture3 = $00
    fe_postprocesstexture4 = $00
    fe_postprocesstexture5 = $00
    mirrorcameralast = $00
    mirrorcamerax = 0.0
    mirrorcameray = 0.0
    mirrorcameraz = 0.0
    mirrorcameraax = 0.0
    mirrorcameraay = 0.0
    mirrorcameraaz = 0.0
    mirrorcameraparent = $00
    optionfile = "options.ini"
    versionnumber = "0.6.3"
    local0 = $00
    Dim arrowimg%($04)
    launcherwidth = (Int min((Float getiniint(optionfile, "launcher", "launcher width")), 1024.0))
    launcherheight = (Int min((Float getiniint(optionfile, "launcher", "launcher height")), 768.0))
    launcherenabled = getiniint(optionfile, "launcher", "launcher enabled")
    graphicwidth = getiniint(optionfile, "options", "width")
    graphicheight = getiniint(optionfile, "options", "height")
    depth = $00
    fullscreen = getiniint(optionfile, "options", "fullscreen")
    selectedgfxdriver = (Int max((Float getiniint(optionfile, "options", "gfx driver")), 1.0))
    selectedaudiodriver = getiniint(optionfile, "options", "audio driver")
    showfps = getiniint(optionfile, "options", "show FPS")
    totalgfxmodes = countgfxmodes3d()
    Dim gfxmodewidths%(totalgfxmodes)
    Dim gfxmodeheights%(totalgfxmodes)
    If (launcherenabled <> 0) Then
        updatelauncher()
        If (fullscreen <> 0) Then
            graphics3d(graphicwidth, graphicheight, depth, $01)
        Else
            graphics3d(graphicwidth, graphicheight, depth, $02)
        EndIf
    Else
        For local1 = $01 To totalgfxmodes Step $01
            local2 = $00
            For local3 = $00 To (totalgfxmodes - $01) Step $01
                If (((gfxmodewidths(local3) = gfxmodewidth(local1)) And (gfxmodeheights(local3) = gfxmodeheight(local1))) <> 0) Then
                    local2 = $01
                    Exit
                EndIf
            Next
            If (local2 = $00) Then
                If (((graphicwidth = gfxmodewidth(local1)) And (graphicheight = gfxmodeheight(local1))) <> 0) Then
                    selectedgfxmode = gfxmodes
                EndIf
                gfxmodewidths(gfxmodes) = gfxmodewidth(local1)
                gfxmodeheights(gfxmodes) = gfxmodeheight(local1)
                gfxmodes = (gfxmodes + $01)
            EndIf
        Next
        graphicwidth = gfxmodewidths(selectedgfxmode)
        graphicheight = gfxmodeheights(selectedgfxmode)
        If (fullscreen <> 0) Then
            graphics3d(graphicwidth, graphicheight, depth, $01)
        Else
            graphics3d(graphicwidth, graphicheight, depth, $02)
        EndIf
        initext()
    EndIf
    local0 = (Int ("SCP - Containment Breach v" + versionnumber))
    setbuffer(backbuffer())
    local7 = $3C
    seedrnd(millisecs())
    cursorimg = loadimage("GFX\cursor.png")
    loadingback = loadimage("Loadingscreens\loadingback.jpg")
    initloadingscreens("Loadingscreens\loadingscreens.ini")
    font1 = loadfont("GFX\TI-83.ttf", (Int (((Float graphicheight) / 1024.0) * 18.0)), $00, $00, $00)
    font2 = loadfont("GFX\TI-83.ttf", (Int (((Float graphicheight) / 1024.0) * 60.0)), $00, $00, $00)
    setfont(font2)
    blinkmeterimg = loadimage("GFX\blinkmeter.jpg")
    drawloading($00, $01)
    viewport_center_x = (graphicwidth Sar $01)
    viewport_center_y = (graphicheight Sar $01)
    mouselook_x_inc = 0.3
    mouselook_y_inc = 0.3
    mouse_left_limit = $FA
    mouse_right_limit = (graphicswidth() - $FA)
    mouse_top_limit = $FA
    mouse_bottom_limit = (graphicsheight() - $FA)
    key_right = getiniint(optionfile, "options", "Right key")
    key_left = getiniint(optionfile, "options", "Left key")
    key_up = getiniint(optionfile, "options", "Up key")
    key_down = getiniint(optionfile, "options", "Down key")
    key_blink = getiniint(optionfile, "options", "Blink key")
    key_sprint = getiniint(optionfile, "options", "Sprint key")
    key_inv = getiniint(optionfile, "options", "Inventory key")
    key_crouch = getiniint(optionfile, "options", "Crouch key")
    invertmouse = getiniint(optionfile, "options", "invert mouse y")
    Dim drawarrowicon%($04)
    lightson = $01
    Dim radiostate#($0A)
    Dim radiochn%($08)
    Dim oldaipics%($0A)
    createconsolemsg("Console commands: ")
    createconsolemsg("  - teleport [room name] ")
    createconsolemsg("  - godmode on/off")
    createconsolemsg("  - noclip on/off")
    createconsolemsg("  - spawnitem [item name]")
    createconsolemsg("  - heal")
    createconsolemsg("  - 173speed [x] (default = 35)")
    createconsolemsg("  - disable173/enable173")
    createconsolemsg("  - disable106/enable106")
    createconsolemsg("  - 173state")
    createconsolemsg("  - 106state")
    createconsolemsg("  - status")
    createconsolemsg("  - wireframe on/off")
    bumpenabled = getiniint("options.ini", "options", "bump mapping enabled")
    hudenabled = getiniint("options.ini", "options", "HUD enabled")
    brightness = $23
    camerafognear = getinifloat("options.ini", "options", "camera fog near")
    camerafogfar = getinifloat("options.ini", "options", "camera fog far")
    mousesens = getinifloat("options.ini", "options", "mouse sensitivity")
    Dim lightspritetex%($0A)
    Dim music%($08)
    music($00) = loadsound("SFX\Music\The Dread.ogg")
    music($01) = loadsound("SFX\Music\Bump in the Night.ogg")
    music($02) = loadsound("SFX\Music\MenuAmbience.ogg")
    musicvolume = getinifloat(optionfile, "options", "music volume")
    musicchn = playsound(music($02))
    channelvolume(musicchn, musicvolume)
    drawloading($0A, $01)
    Dim opendoorsfx%($03)
    Dim closedoorsfx%($03)
    For local1 = $00 To $02 Step $01
        opendoorsfx(local1) = loadsound((("SFX\DoorOpen" + (Str (local1 + $01))) + ".ogg"))
        closedoorsfx(local1) = loadsound((("SFX\DoorClose" + (Str (local1 + $01))) + ".ogg"))
    Next
    opendoorfastsfx = loadsound("SFX\DoorOpenFast.ogg")
    cautionsfx = loadsound("SFX\caution.ogg")
    bigdoorclosesfx = loadsound("SFX\bigdoorclose.ogg")
    bigdooropensfx = loadsound("SFX\bigdooropen.ogg")
    stonedragsfx = loadsound("SFX\StoneDrag.ogg")
    gunshotsfx = loadsound("SFX\gunshot.ogg")
    gunshot2sfx = loadsound("SFX\gunshot2.ogg")
    gunshot3sfx = loadsound("SFX\bulletmiss.ogg")
    bullethitsfx = loadsound("SFX\bullethit.ogg")
    teslaidlesfx = loadsound("SFX\teslaidle.ogg")
    teslaactivatesfx = loadsound("SFX\teslaactivate.ogg")
    teslapowerupsfx = loadsound("SFX\teslapowerup.ogg")
    magnetupsfx = loadsound("SFX\MagnetUp.ogg")
    magnetdownsfx = loadsound("SFX\MagnetDown.ogg")
    Dim decaysfx%($05)
    For local1 = $00 To $03 Step $01
        decaysfx(local1) = loadsound((("SFX\decay" + (Str local1)) + ".ogg"))
    Next
    burstsfx = loadsound("SFX\burst.ogg")
    drawloading($14, $01)
    Dim rustlesfx%($03)
    For local1 = $00 To $02 Step $01
        rustlesfx(local1) = loadsound((("SFX\rustle" + (Str local1)) + ".ogg"))
    Next
    death914sfx = loadsound("SFX\914death.ogg")
    use914sfx = loadsound("SFX\914use.ogg")
    Dim dripsfx%($04)
    For local1 = $00 To $03 Step $01
        dripsfx(local1) = loadsound((("SFX\drip" + (Str local1)) + ".ogg"))
    Next
    leversfx = loadsound("SFX\lever.ogg")
    lightsfx = loadsound("SFX\lightswitch.ogg")
    gasmaskbreath = loadsound("SFX\GasmaskBreath.ogg")
    buttghostsfx = loadsound("SFX\BuGh.ogg")
    Dim radiosfx%($05, $0A)
    radiosfx($01, $00) = loadsound("SFX\Radio\RadioAlarm.ogg")
    radiosfx($01, $01) = loadsound("SFX\Radio\RadioAlarm2.ogg")
    For local1 = $00 To $08 Step $01
        radiosfx($02, local1) = loadsound((("SFX\Radio\scpradio" + (Str local1)) + ".ogg"))
    Next
    radiosquelch = loadsound("SFX\Radio\squelch.ogg")
    radiostatic = loadsound("SFX\Radio\static.ogg")
    radiobuzz = loadsound("SFX\Radio\buzz.ogg")
    elevatorbeepsfx = loadsound("SFX\ElevatorBeep.ogg")
    elevatormovesfx = loadsound("SFX\ElevatorMove.ogg")
    Dim picksfx%($0A)
    For local1 = $00 To $02 Step $01
        picksfx(local1) = loadsound((("SFX\PickItem" + (Str local1)) + ".ogg"))
    Next
    ambientsfxamount = $13
    Dim ambientsfx%(ambientsfxamount)
    Dim oldmansfx%($06)
    For local1 = $00 To $04 Step $01
        oldmansfx(local1) = loadsound((("SFX\oldman" + (Str (local1 + $01))) + ".ogg"))
    Next
    oldmansfx($05) = loadsound("SFX\oldmandrag.ogg")
    Dim scp173sfx%($03)
    For local1 = $00 To $02 Step $01
        scp173sfx(local1) = loadsound((("SFX\173sound" + (Str (local1 + $01))) + ".ogg"))
    Next
    Dim horrorsfx%($14)
    For local1 = $00 To $0A Step $01
        horrorsfx(local1) = loadsound((("SFX\horror" + (Str (local1 + $01))) + ".ogg"))
    Next
    drawloading($19, $01)
    Dim introsfx%($10)
    For local1 = $07 To $09 Step $01
        introsfx(local1) = loadsound((("SFX\intro\bang" + (Str (local1 - $06))) + ".ogg"))
    Next
    For local1 = $0A To $0C Step $01
        introsfx(local1) = loadsound((("SFX\intro\elec" + (Str (local1 - $09))) + ".ogg"))
    Next
    introsfx($0D) = loadsound("SFX\intro\shoot1.ogg")
    introsfx($0E) = loadsound("SFX\intro\shoot2.ogg")
    introsfx($0F) = loadsound("SFX\intro\metal173.ogg")
    Dim alarmsfx%($05)
    alarmsfx($00) = loadsound("SFX\alarm.ogg")
    alarmsfx($01) = loadsound("SFX\alarm2.ogg")
    alarmsfx($02) = loadsound("SFX\alarm3.ogg")
    Dim damagesfx%($05)
    For local1 = $00 To $02 Step $01
        damagesfx(local1) = loadsound((("SFX\NeckSnap" + (Str (local1 + $01))) + ".ogg"))
    Next
    heartbeatsfx = loadsound("SFX\heartbeat.ogg")
    Dim deathsfx%($05)
    deathsfx($00) = loadsound("SFX\death1.ogg")
    deathsfx($01) = loadsound("SFX\death2.ogg")
    Dim mtfsfx%($0A)
    glassbreaksfx = loadsound("SFX\glassbreak.ogg")
    Dim coughsfx%($03)
    For local1 = $00 To $02 Step $01
        coughsfx(local1) = loadsound((("SFX\cough" + (Str (local1 + $01))) + ".ogg"))
    Next
    machinesfx = loadsound("SFX\Machine.ogg")
    apachesfx = loadsound("SFX\apache.ogg")
    Dim stepsfx%($03, $02, $04)
    For local1 = $00 To $03 Step $01
        stepsfx($00, $00, local1) = loadsound((("SFX\step" + (Str (local1 + $01))) + ".ogg"))
        stepsfx($01, $00, local1) = loadsound((("SFX\stepmetal" + (Str (local1 + $01))) + ".ogg"))
        stepsfx($00, $01, local1) = loadsound((("SFX\run" + (Str (local1 + $01))) + ".ogg"))
        stepsfx($01, $01, local1) = loadsound((("SFX\runmetal" + (Str (local1 + $01))) + ".ogg"))
        If (local1 < $03) Then
            stepsfx($02, $00, local1) = loadsound((("SFX\MTF\StepMTF" + (Str (local1 + $01))) + ".ogg"))
        EndIf
    Next
    Dim steppdsfx%($04)
    For local1 = $00 To $02 Step $01
        steppdsfx(local1) = loadsound((("SFX\stepPD" + (Str (local1 + $01))) + ".ogg"))
    Next
    drawloading($1E, $01)
    pausemenuimg = loadimage("GFX\menu\pausemenu.jpg")
    maskimage(pausemenuimg, $FF, $FF, $00)
    sprinticon = loadimage("GFX\sprinticon.png")
    blinkicon = loadimage("GFX\blinkicon.png")
    crouchicon = loadimage("GFX\sneakicon.png")
    handicon = loadimage("GFX\handsymbol.png")
    staminameterimg = loadimage("GFX\staminameter.jpg")
    signimg = loadimage("GFX\map\sign.jpg")
    keypadhud = loadimage("GFX\keypadhud.jpg")
    maskimage(keypadhud, $FF, $00, $FF)
    buttonup = loadimage("GFX\buttonup.png")
    buttondown = loadimage("GFX\buttondown.png")
    drawloading($23, $01)
    Dim inventory.items($0B)
    Dim particletextures%($0A)
    hisssfx = loadsound("SFX\hiss.ogg")
    Dim bigdoorobj%($02)
    drawloading($28, $01)
    loadroomtemplates("Data\rooms.ini")
    roomscale = (1.0 / 256.0)
    mapwidth = getiniint("options.ini", "options", "map size")
    mapheight = getiniint("options.ini", "options", "map size")
    Dim maptemp%($03, mapwidth, mapheight)
    Dim mapfound%($03, mapwidth, mapheight)
    hidedistance = 15.0
    secondarylighton = 1.0
    remotedooron = $01
    contained106 = $00
    disabled173 = $00
    Dim mapname$(mapwidth, mapheight)
    Dim maproomid%($06)
    Dim maproom$($06, $00)
    drawloading($50, $01)
    collisions($02, $01, $02, $02)
    collisions($02, $02, $01, $03)
    collisions($03, $01, $02, $02)
    collisions($04, $04, $01, $02)
    drawloading($5A, $01)
    Dim lightspritetex%($05)
    Dim bigdoorobj%($02)
    Dim gorepics%($0A)
    Dim decaltextures%($14)
    bumppower(0.03)
    menuback = loadimage("GFX\menu\back.jpg")
    menutext = loadimage("GFX\menu\scptext.jpg")
    menu173 = loadimage("GFX\menu\173back.jpg")
    menuwhite = loadimage("GFX\menu\menuwhite.jpg")
    menublack = loadimage("GFX\menu\menublack.jpg")
    maskimage(menublack, $FF, $FF, $00)
    menuscale = ((Float graphicheight) / 1024.0)
    resizeimage(menuback, ((Float imagewidth(menuback)) * menuscale), ((Float imageheight(menuback)) * menuscale))
    resizeimage(menutext, ((Float imagewidth(menutext)) * menuscale), ((Float imageheight(menutext)) * menuscale))
    resizeimage(menu173, ((Float imagewidth(menu173)) * menuscale), ((Float imageheight(menu173)) * menuscale))
    For local1 = $00 To $03 Step $01
        arrowimg(local1) = loadimage("GFX\menu\arrow.png")
        rotateimage(arrowimg(local1), (Float ($5A * local1)))
        handleimage(arrowimg(local1), $00, $00)
    Next
    Dim menublinktimer%($02)
    Dim menublinkduration%($02)
    menublinktimer($00) = $01
    menublinktimer($01) = $01
    introenabled = $01
    savepath = "Saves\"
    local9 = readdir(savepath)
    Repeat
        local10 = nextfile(local9)
        If (local10 = "") Then
            Exit
        EndIf
        If (filetype(((local11 + "\") + local10)) = $02) Then
            savegameamount = (savegameamount + $01)
        EndIf
    Forever
    closedir(local9)
    Dim savegames$((savegameamount + $01))
    local9 = readdir(savepath)
    local1 = $00
    Repeat
        local10 = nextfile(local9)
        If (local10 = "") Then
            Exit
        EndIf
        If (filetype(((local11 + "\") + local10)) = $02) Then
            savegames(local1) = local10
            local1 = (local1 + $01)
        EndIf
    Forever
    closedir(local9)
    Dim savegametime%((savegameamount + $01))
    Dim savegamedate%((local12 + $01))
    For local1 = $01 To local12 Step $01
        local13 = readfile(((savepath + savegames((local1 - $01))) + "\save.txt"))
        savegametime((local1 - $01)) = readint(local13)
        closefile(local13)
    Next
    Dim keyname$($D3)
    keyname($01) = "Esc"
    For local1 = $02 To $0A Step $01
        keyname(local1) = (Str (local1 - $01))
    Next
    keyname($0B) = "0"
    keyname($0C) = "-"
    keyname($0D) = "="
    keyname($0E) = "Backspace"
    keyname($0F) = "Tab"
    keyname($10) = "Q"
    keyname($11) = "W"
    keyname($12) = "E"
    keyname($13) = "R"
    keyname($14) = "T"
    keyname($15) = "Y"
    keyname($16) = "U"
    keyname($17) = "I"
    keyname($18) = "O"
    keyname($19) = "P"
    keyname($1A) = "["
    keyname($1B) = "]"
    keyname($1C) = "Enter"
    keyname($1D) = "Left Ctrl"
    keyname($1E) = "A"
    keyname($1F) = "S"
    keyname($20) = "D"
    keyname($21) = "F"
    keyname($22) = "G"
    keyname($23) = "H"
    keyname($24) = "J"
    keyname($25) = "K"
    keyname($26) = "L"
    keyname($27) = ";"
    keyname($28) = "'"
    keyname($2A) = "Left Shift"
    keyname($2B) = "\"
    keyname($2C) = "Z"
    keyname($2D) = "X"
    keyname($2E) = "C"
    keyname($2F) = "V"
    keyname($30) = "B"
    keyname($31) = "N"
    keyname($32) = "M"
    keyname($33) = ","
    keyname($34) = "."
    keyname($36) = "Right Shift"
    keyname($38) = "Left Alt"
    keyname($39) = "Space"
    keyname($3A) = "Caps Lock"
    keyname($3B) = "F1"
    keyname($3C) = "F2"
    keyname($3D) = "F3"
    keyname($3E) = "F4"
    keyname($3F) = "F5"
    keyname($40) = "F6"
    keyname($41) = "F7"
    keyname($42) = "F8"
    keyname($43) = "F9"
    keyname($44) = "F10"
    keyname($9D) = "Right Control"
    keyname($B8) = "Right Alt"
    keyname($C8) = "Up"
    keyname($CB) = "Left"
    keyname($CD) = "Right"
    keyname($D0) = "Down"
    mainmenuopen = $01
    flushkeys()
    flushmouse()
    drawloading($64, $01)
    loopdelay = millisecs()
    Repeat
        cls($01, $01)
        curtime = millisecs()
        local8 = ((Float (curtime - prevtime)) / 1000.0)
        prevtime = curtime
        fpsfactor = max(min((local8 * 70.0), 5.0), 0.2)
        fpsfactor2 = fpsfactor
        If (((((menuopen Or invopen) Or consoleopen) Or (selecteddoor <> Null)) Or (selectedscreen <> Null)) <> 0) Then
            fpsfactor = 0.0
        EndIf
        If (((local7 > $00) Or (local7 < $FF)) <> 0) Then
            local14 = (Int ((1000.0 / (Float local7)) - (Float (millisecs() - loopdelay))))
            delay(local14)
            loopdelay = millisecs()
        EndIf
        If (local4 < millisecs()) Then
            local6 = local5
            local5 = $00
            local4 = (millisecs() + $3E8)
        EndIf
        local5 = (local5 + $01)
        doubleclick = $00
        mousehit1 = mousehit($01)
        If (mousehit1 <> 0) Then
            If ((millisecs() - lastmousehit1) < $320) Then
                doubleclick = $01
            EndIf
            lastmousehit1 = millisecs()
        EndIf
        local15 = mousedown1
        mousedown1 = mousedown($01)
        If (((local15 = $01) And (mousedown1 = $00)) <> 0) Then
            mouseup1 = $01
        Else
            mouseup1 = $00
        EndIf
        mousehit2 = mousehit($02)
        If (((mousedown1 = $00) And (mousehit1 = $00)) <> 0) Then
            grabbedentity = $00
        EndIf
        updatemusic()
        If (mainmenuopen <> 0) Then
            shouldplay = $02
            updatemainmenu()
        Else
            shouldplay = $00
            drawhandicon = $00
            If (0.0 < fpsfactor) Then
                updatesecuritycams()
            EndIf
            If (keyhit(key_inv) <> 0) Then
                If (invopen <> 0) Then
                    resumesounds()
                Else
                    pausesounds()
                EndIf
                invopen = (invopen = $00)
                selecteditem = Null
            EndIf
            If (((playerroom\Field7\Field4 <> "pocketdimension") And (playerroom\Field7\Field4 <> "gatea")) <> 0) Then
                If (rand($5DC, $01) = $01) Then
                    positionentity(soundemitter, (entityx(camera, $00) + rnd(-1.0, 1.0)), 0.0, (entityz(camera, $00) + rnd(-1.0, 1.0)), $00)
                    currambientsfx = rand($00, (ambientsfxamount - $01))
                    If (ambientsfx(currambientsfx) = $00) Then
                        ambientsfx(currambientsfx) = loadsound((("SFX\ambient\ambient" + (Str (currambientsfx + $01))) + ".ogg"))
                    EndIf
                    ambientsfxchn = playsound2(ambientsfx(currambientsfx), camera, soundemitter, 10.0, 1.0, $01)
                EndIf
            EndIf
            If (ambientsfx(currambientsfx) <> $00) Then
                If (channelplaying(ambientsfxchn) = $00) Then
                    freesound(ambientsfx(currambientsfx))
                    ambientsfx(currambientsfx) = $00
                EndIf
            EndIf
            If (0.0 < fpsfactor) Then
                lightvolume = curvevalue(templightvolume, lightvolume, 50.0)
                camerafogrange(camera, (camerafognear * lightvolume), (camerafogfar * lightvolume))
                camerafogcolor(camera, 0.0, 0.0, 0.0)
                camerafogmode(camera, $01)
                camerarange(camera, 0.05, min(((camerafogfar * lightvolume) * 1.5), 28.0))
            EndIf
            updateroomtimer = (updateroomtimer - fpsfactor2)
            If (0.0 >= updateroomtimer) Then
                updaterooms()
                updateroomtimer = 15.0
            EndIf
            If (((((menuopen = $00) And (invopen = $00)) And (selecteddoor = Null)) And (consoleopen = $00)) <> 0) Then
                ambientlight((Float brightness), (Float brightness), (Float brightness))
                playersoundvolume = curvevalue(0.0, playersoundvolume, 5.0)
                updateemitters()
                mouselook()
                moveplayer()
                updatedoors()
                updateevents()
                updatedecals()
                updatemtf()
                updatenpcs()
                updateitems()
                updateparticles()
                updatescreens()
            EndIf
            updateworld(1.0)
            renderworld(1.0)
            blurvolume = min(curvevalue(0.1, blurvolume, 20.0), 0.95)
            If (0.0 < blurtimer) Then
                blurvolume = max(min(0.95, (blurtimer / 1000.0)), blurvolume)
                blurtimer = max((blurtimer - fpsfactor), 0.0)
            EndIf
            updateblur(blurvolume)
            local16 = (sin((Float (millisecs() / $1388))) * 0.08)
            If (menuopen = $00) Then
                If (0.0 > sanity) Then
                    sanity = min((sanity + fpsfactor), 0.0)
                    If (-200.0 > sanity) Then
                        local16 = max(min((((- sanity) - 200.0) / 500.0), 0.8), local16)
                    EndIf
                EndIf
                If (0.0 < eyestuck) Then
                    blinktimer = 560.0
                    eyestuck = max((eyestuck - fpsfactor), 1.0)
                    debuglog(("eyestuck: " + (Str eyestuck)))
                    If (9000.0 > eyestuck) Then
                        blurtimer = max(blurtimer, ((9000.0 - eyestuck) * 0.5))
                    EndIf
                    If (6000.0 > eyestuck) Then
                        local16 = min(max(local16, ((6000.0 - eyestuck) / 5000.0)), 1.0)
                    EndIf
                    If (((9000.0 > eyestuck) And (9000.0 <= (eyestuck + fpsfactor))) <> 0) Then
                        msg = "Your eyes are starting to hurt"
                        msgtimer = 420.0
                    EndIf
                EndIf
                If (0.0 > blinktimer) Then
                    If (-5.0 < blinktimer) Then
                        local16 = max(local16, sin((Abs (blinktimer * 18.0))))
                    ElseIf (-15.0 < blinktimer) Then
                        local16 = 1.0
                    Else
                        local16 = max(local16, (Abs sin((blinktimer * 18.0))))
                    EndIf
                    If (-20.0 >= blinktimer) Then
                        blinktimer = 560.0
                    EndIf
                    blinktimer = (blinktimer - fpsfactor)
                Else
                    blinktimer = (blinktimer - (fpsfactor * 0.6))
                    If (0.0 < eyeirritation) Then
                        blinktimer = (blinktimer - (min(((eyeirritation / 100.0) + 1.0), 4.0) * fpsfactor))
                    EndIf
                    If (0.0 < eyesuper) Then
                        blinktimer = ((min((eyesuper / 1000.0), 0.3) * fpsfactor) + blinktimer)
                    EndIf
                    local16 = max(local16, 0.0)
                EndIf
                eyeirritation = max(0.0, (eyeirritation - fpsfactor))
                eyesuper = max(0.0, (eyesuper - fpsfactor))
                lightblink = max((lightblink - (fpsfactor / 35.0)), 0.0)
                If (0.0 < lightblink) Then
                    local16 = min(max(local16, (((1.0 - lightblink) * rnd(0.3, 0.8)) + lightblink)), 1.0)
                EndIf
                local16 = max(((1.0 - secondarylighton) * 0.91), local16)
                If (0.0 > killtimer) Then
                    invopen = $00
                    selecteditem = Null
                    selectedscreen = Null
                    blurtimer = (Abs (killtimer * 10.0))
                    killtimer = (killtimer - fpsfactor)
                    If (-360.0 > killtimer) Then
                        menuopen = $01
                        If (selectedending <> "") Then
                            endingtimer = min(killtimer, -0.1)
                        EndIf
                    EndIf
                    local16 = max(local16, min((Abs (killtimer / 400.0)), 1.0))
                EndIf
                If (0.0 > falltimer) Then
                    invopen = $00
                    selecteditem = Null
                    selectedscreen = Null
                    blurtimer = (Abs (falltimer * 10.0))
                    falltimer = (falltimer - fpsfactor)
                    local16 = max(local16, min((Abs (falltimer / 400.0)), 1.0))
                EndIf
                If (selecteditem <> Null) Then
                    If (((selecteditem\Field1\Field1 = "navigator") Or (selecteditem\Field1\Field1 = "nav")) <> 0) Then
                        local16 = max(local16, 0.5)
                    EndIf
                EndIf
                If (selectedscreen <> Null) Then
                    local16 = max(local16, 0.5)
                EndIf
                entityalpha(dark, local16)
            EndIf
            If (0.0 < lightflash) Then
                showentity(light)
                debuglog(("lightflash: " + (Str lightflash)))
                entityalpha(light, max(min((rnd(-0.2, 0.2) + lightflash), 1.0), 0.0))
                lightflash = max((lightflash - (fpsfactor / 70.0)), 0.0)
            Else
                hideentity(light)
            EndIf
            If (keyhit($3F) <> 0) Then
                If ((((playerroom\Field7\Field4 = "exit1") Or (playerroom\Field7\Field4 = "room173")) Or (playerroom\Field7\Field4 = "gatea")) <> 0) Then
                    msg = "You can't save in this location"
                    msgtimer = 280.0
                Else
                    savegame(((savepath + currsave) + "\"))
                    msg = "Game saved"
                    msgtimer = 280.0
                EndIf
            EndIf
            If (keyhit($3D) <> 0) Then
                consoleopen = (consoleopen = $00)
                flushkeys()
            EndIf
            drawgui()
            drawmenu()
            If (0.0 > endingtimer) Then
                If (selectedending <> "") Then
                    drawending()
                EndIf
            EndIf
            updateconsole()
            If (0.0 < msgtimer) Then
                color($00, $00, $00)
                text(((graphicwidth Sar $01) + $01), ((graphicheight Sar $01) + $C9), msg, $01, $00)
                color((Int min((msgtimer / 2.0), 255.0)), (Int min((msgtimer / 2.0), 255.0)), (Int min((msgtimer / 2.0), 255.0)))
                text((graphicwidth Sar $01), ((graphicheight Sar $01) + $C8), msg, $01, $00)
                msgtimer = (msgtimer - fpsfactor2)
            EndIf
            color($FF, $FF, $FF)
            If (showfps <> 0) Then
                text($14, $14, ("FPS: " + (Str local6)), $00, $00)
            EndIf
        EndIf
        flip($01)
    Forever
End Function
