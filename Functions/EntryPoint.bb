Function EntryPoint%()
    Local local0%
    Local local1%
    Local local2%
    Local local3%
    Local local4%
    Local local5#
    Local local6%
    Local local7%
    Local local8%
    Local local9$
    Local local10$
    Local local11%
    Local local12%
    Local local13%
    Local local14%
    Local local15%
    Local local16#
    Local local17%
    Local local18%
    Local local19.rooms
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
    versionnumber = "0.3.1"
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
    EndIf
    local0 = (Int ("SCP - Containment Breach v" + versionnumber))
    If (fullscreen <> 0) Then
        graphics3d(graphicwidth, graphicheight, depth, $01)
    Else
        graphics3d(graphicwidth, graphicheight, depth, $02)
    EndIf
    setbuffer(backbuffer())
    local4 = $3C
    seedrnd(millisecs())
    cursorimg = loadimage("GFX\cursor.png")
    cwmimg = loadimage("GFX\cwm.jpg")
    font1 = loadfont("GFX\TI-83.ttf", (Int (((Float graphicheight) / 1024.0) * 18.0)), $00, $00, $00)
    font2 = loadfont("GFX\TI-83.ttf", (Int (((Float graphicheight) / 1024.0) * 60.0)), $00, $00, $00)
    setfont(font2)
    blinkmeterimg = loadimage("GFX\blinkmeter.jpg")
    drawloading($00)
    viewport_center_x = (graphicwidth Sar $01)
    viewport_center_y = (graphicheight Sar $01)
    mouselook_x_inc = 0.3
    mouselook_y_inc = 0.3
    mouse_left_limit = $FA
    mouse_right_limit = (graphicswidth() - $FA)
    mouse_top_limit = $FA
    mouse_bottom_limit = (graphicsheight() - $FA)
    invertmouse = getiniint(optionfile, "options", "invert mouse y")
    accesscode = "4192"
    Dim drawarrowicon%($04)
    lightson = $01
    Dim radiostate#($0A)
    Dim radiochn%($08)
    Dim oldaipics%($0A)
    createconsolemsg("Console commands: ")
    createconsolemsg("  - teleport [room name] ")
    createconsolemsg("  - godmode on/off")
    createconsolemsg("  - noclip on/off")
    createconsolemsg("  - 173speed [x] (default = 35)")
    createconsolemsg("  - disable173/enable173")
    createconsolemsg("  - disable106/enable106")
    createconsolemsg("  - 173state")
    createconsolemsg("  - 106state")
    createconsolemsg("  - status")
    bumpenabled = getiniint("options.ini", "options", "bump mapping enabled")
    hudenabled = getiniint("options.ini", "options", "HUD enabled")
    brightness = $23
    camerafognear = getinifloat("options.ini", "options", "camera fog near")
    camerafogfar = getinifloat("options.ini", "options", "camera fog far")
    mousesens = getinifloat("options.ini", "options", "mouse sensitivity")
    Dim lightspritetex%($0A)
    Dim music%($05)
    music($00) = loadsound("SFX\Music\The Dread.ogg")
    music($01) = loadsound("SFX\Music\Bump in the Night.ogg")
    music($02) = loadsound("SFX\Music\MenuAmbience.ogg")
    music($03) = loadsound("SFX\Ambient\PocketDimension.ogg")
    music($04) = loadsound("SFX\Music\AI.ogg")
    musicvolume = getinifloat(optionfile, "options", "music volume")
    musicchn = playsound(music($02))
    channelvolume(musicchn, musicvolume)
    drawloading($0A)
    Dim opendoorsfx%($03)
    Dim closedoorsfx%($03)
    For local6 = $00 To $02 Step $01
        opendoorsfx(local6) = loadsound((("SFX\DoorOpen" + (Str (local6 + $01))) + ".ogg"))
        closedoorsfx(local6) = loadsound((("SFX\DoorClose" + (Str (local6 + $01))) + ".ogg"))
    Next
    cautionsfx = loadsound("SFX\caution.ogg")
    bigdoorclosesfx = loadsound("SFX\bigdoorclose.ogg")
    bigdooropensfx = loadsound("SFX\bigdooropen.ogg")
    stonedragsfx = loadsound("SFX\StoneDrag.ogg")
    stonestopsfx = loadsound("SFX\StoneDrag2.ogg")
    gunshotsfx = loadsound("SFX\gunshot.ogg")
    bullethitsfx = loadsound("SFX\bullethit.ogg")
    msg079 = loadsound("SFX\msg.ogg")
    error079 = loadsound("SFX\error.ogg")
    teslaidlesfx = loadsound("SFX\teslaidle.ogg")
    teslaactivatesfx = loadsound("SFX\teslaactivate.ogg")
    teslapowerupsfx = loadsound("SFX\teslapowerup.ogg")
    magnetupsfx = loadsound("SFX\MagnetUp.ogg")
    magnetdownsfx = loadsound("SFX\MagnetDown.ogg")
    Dim decaysfx%($05)
    For local6 = $00 To $03 Step $01
        decaysfx(local6) = loadsound((("SFX\decay" + (Str local6)) + ".ogg"))
    Next
    burstsfx = loadsound("SFX\burst.ogg")
    drawloading($14)
    Dim rustlesfx%($03)
    For local6 = $00 To $02 Step $01
        rustlesfx(local6) = loadsound((("SFX\rustle" + (Str local6)) + ".ogg"))
    Next
    death914sfx = loadsound("SFX\914death.ogg")
    use914sfx = loadsound("SFX\914use.ogg")
    leversfx = loadsound("SFX\lever.ogg")
    lightsfx = loadsound("SFX\lightswitch.ogg")
    gasmaskbreath = loadsound("SFX\GasmaskBreath.ogg")
    buttghostsfx = loadsound("SFX\BuGh.ogg")
    Dim radiosfx%($05, $0A)
    radiosfx($01, $00) = loadsound("SFX\Radio\RadioAlarm.ogg")
    radiosfx($01, $01) = loadsound("SFX\Radio\RadioAlarm2.ogg")
    For local6 = $00 To $08 Step $01
        radiosfx($02, local6) = loadsound((("SFX\Radio\scpradio" + (Str local6)) + ".ogg"))
    Next
    radiosquelch = loadsound("SFX\Radio\squelch.ogg")
    radiostatic = loadsound("SFX\Radio\static.ogg")
    radiobuzz = loadsound("SFX\Radio\buzz.ogg")
    elevatorbeepsfx = loadsound("SFX\ElevatorBeep.ogg")
    elevatormovesfx = loadsound("SFX\ElevatorMove.ogg")
    Dim picksfx%($0A)
    For local6 = $00 To $02 Step $01
        picksfx(local6) = loadsound((("SFX\PickItem" + (Str local6)) + ".ogg"))
    Next
    ambientsfxamount = $0B
    Dim ambientsfx%(ambientsfxamount)
    For local6 = $00 To (ambientsfxamount - $01) Step $01
        ambientsfx(local6) = loadsound((("SFX\Ambient\Ambient" + (Str (local6 + $01))) + ".ogg"))
    Next
    Dim oldmansfx%($06)
    For local6 = $00 To $04 Step $01
        oldmansfx(local6) = loadsound((("SFX\oldman" + (Str (local6 + $01))) + ".ogg"))
    Next
    oldmansfx($05) = loadsound("SFX\oldmandrag.ogg")
    Dim scp173sfx%($03)
    For local6 = $00 To $02 Step $01
        scp173sfx(local6) = loadsound((("SFX\173sound" + (Str (local6 + $01))) + ".ogg"))
    Next
    Dim horrorsfx%($14)
    For local6 = $00 To $0A Step $01
        horrorsfx(local6) = loadsound((("SFX\horror" + (Str (local6 + $01))) + ".ogg"))
    Next
    drawloading($19)
    Dim introsfx%($10)
    For local6 = $07 To $09 Step $01
        introsfx(local6) = loadsound((("SFX\intro\bang" + (Str (local6 - $06))) + ".ogg"))
    Next
    For local6 = $0A To $0C Step $01
        introsfx(local6) = loadsound((("SFX\intro\elec" + (Str (local6 - $09))) + ".ogg"))
    Next
    introsfx($0D) = loadsound("SFX\intro\shoot1.ogg")
    introsfx($0E) = loadsound("SFX\intro\shoot2.ogg")
    introsfx($0F) = loadsound("SFX\intro\metal173.ogg")
    Dim alarmsfx%($05)
    alarmsfx($00) = loadsound("SFX\alarm.ogg")
    alarmsfx($01) = loadsound("SFX\alarm2.ogg")
    Dim damagesfx%($05)
    damagesfx($00) = loadsound("SFX\NeckSnap1.ogg")
    damagesfx($01) = loadsound("SFX\NeckSnap2.ogg")
    damagesfx($02) = loadsound("SFX\NeckSnap3.ogg")
    Dim deathsfx%($05)
    deathsfx($00) = loadsound("SFX\death1.ogg")
    deathsfx($01) = loadsound("SFX\death2.ogg")
    glassbreaksfx = loadsound("SFX\glassbreak.ogg")
    Dim coughsfx%($03)
    For local6 = $00 To $02 Step $01
        coughsfx(local6) = loadsound((("SFX\cough" + (Str (local6 + $01))) + ".ogg"))
    Next
    machinesfx = loadsound("SFX\Machine.ogg")
    Dim stepsfx%($02, $02, $04)
    For local6 = $00 To $03 Step $01
        stepsfx($00, $00, local6) = loadsound((("SFX\step" + (Str (local6 + $01))) + ".ogg"))
        stepsfx($01, $00, local6) = loadsound((("SFX\stepmetal" + (Str (local6 + $01))) + ".ogg"))
        stepsfx($00, $01, local6) = loadsound((("SFX\run" + (Str (local6 + $01))) + ".ogg"))
        stepsfx($01, $01, local6) = loadsound((("SFX\runmetal" + (Str (local6 + $01))) + ".ogg"))
    Next
    Dim steppdsfx%($04)
    For local6 = $00 To $02 Step $01
        steppdsfx(local6) = loadsound((("SFX\stepPD" + (Str (local6 + $01))) + ".ogg"))
    Next
    drawloading($1E)
    sprinticon = loadimage("GFX\sprinticon.jpg")
    blinkicon = loadimage("GFX\blinkicon.jpg")
    handicon = loadimage("GFX\handsymbol.png")
    staminameterimg = loadimage("GFX\staminameter.jpg")
    signimg = loadimage("GFX\map\sign.jpg")
    keypadhud = loadimage("GFX\keypadhud.jpg")
    maskimage(keypadhud, $FF, $00, $FF)
    buttonup = loadimage("GFX\buttonup.png")
    buttondown = loadimage("GFX\buttondown.png")
    drawloading($23)
    Dim inventory.items($0B)
    Dim particletextures%($0A)
    hisssfx = loadsound("SFX\hiss.ogg")
    Dim bigdoorobj%($02)
    drawloading($28)
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
    Dim mapname$(mapwidth, mapheight)
    Dim maproomid%($06)
    Dim maproom$($06, local7)
    drawloading($50)
    collisions($02, $01, $02, $02)
    collisions($02, $02, $01, $03)
    collisions($03, $01, $02, $02)
    drawloading($5A)
    Dim lightspritetex%($05)
    Dim bigdoorobj%($02)
    Dim gorepics%($0A)
    Dim decaltextures%($14)
    bumppower(0.05)
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
    For local6 = $00 To $03 Step $01
        arrowimg(local6) = loadimage("GFX\menu\arrow.png")
        rotateimage(arrowimg(local6), (Float ($5A * local6)))
        handleimage(arrowimg(local6), $00, $00)
    Next
    Dim menublinktimer%($02)
    Dim menublinkduration%($02)
    menublinktimer($00) = $01
    menublinktimer($01) = $01
    introenabled = $01
    savepath = "Saves\"
    local8 = readdir(savepath)
    Repeat
        local9 = nextfile(local8)
        If (local9 = "") Then
            Exit
        EndIf
        If (filetype(((local10 + "\") + local9)) = $02) Then
            savegameamount = (savegameamount + $01)
        EndIf
    Forever
    closedir(local8)
    Dim savegames$((savegameamount + $01))
    local8 = readdir(savepath)
    local6 = $00
    Repeat
        local9 = nextfile(local8)
        If (local9 = "") Then
            Exit
        EndIf
        If (filetype(((local10 + "\") + local9)) = $02) Then
            savegames(local6) = local9
            local6 = (local6 + $01)
        EndIf
    Forever
    closedir(local8)
    Dim savegametime%((savegameamount + $01))
    Dim savegamedate%((local11 + $01))
    For local6 = $01 To local11 Step $01
        local12 = readfile(((savepath + savegames((local6 - $01))) + "\save.txt"))
        savegametime((local6 - $01)) = readint(local12)
        closefile(local12)
    Next
    mainmenuopen = $01
    flushkeys()
    flushmouse()
    drawloading($64)
    Repeat
        cls($01, $01)
        curtime = millisecs()
        local5 = ((Float (curtime - prevtime)) / 1000.0)
        prevtime = curtime
        fpsfactor = max(min((local5 * 70.0), 5.0), 0.2)
        fpsfactor2 = fpsfactor
        If ((((menuopen Or invopen) Or consoleopen) Or (selecteddoor <> Null)) <> 0) Then
            fpsfactor = 0.0
        EndIf
        If (((local4 > $00) Or (local4 < $FF)) <> 0) Then
            local13 = (Int ((1000.0 / (Float local4)) - (Float (millisecs() - loopdelay))))
            delay(local13)
            loopdelay = millisecs()
        EndIf
        If (local1 < millisecs()) Then
            local3 = local2
            local2 = $00
            local1 = (millisecs() + $3E8)
        EndIf
        local2 = (local2 + $01)
        doubleclick = $00
        mousehit1 = mousehit($01)
        If (mousehit1 <> 0) Then
            If ((millisecs() - lastmousehit1) < $320) Then
                doubleclick = $01
            EndIf
            lastmousehit1 = millisecs()
        EndIf
        local14 = mousedown1
        mousedown1 = mousedown($01)
        If (((local14 = $01) And (mousedown1 = $00)) <> 0) Then
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
            ambientlight((Float brightness), (Float brightness), (Float brightness))
            updatesecuritycams()
            If (keyhit($0F) <> 0) Then
                invopen = (invopen = $00)
                selecteditem = Null
            EndIf
            If (playerroom\Field6\Field4 <> "pocketdimension") Then
                If (rand($5DC, $01) = $01) Then
                    positionentity(soundemitter, (entityx(camera, $00) + rnd(-1.0, 1.0)), 0.0, (entityz(camera, $00) + rnd(-1.0, 1.0)), $00)
                    playsound2(ambientsfx(rand($00, (ambientsfxamount - $01))), camera, soundemitter, 10.0, 1.0)
                EndIf
            EndIf
            If ((keyhit(local15) And $00) <> 0) Then
                kill()
            EndIf
            lightvolume = curvevalue(templightvolume, lightvolume, 50.0)
            If (((((menuopen = $00) And (invopen = $00)) And (selecteddoor = Null)) And (consoleopen = $00)) <> 0) Then
                camerafogrange(camera, (camerafognear * lightvolume), (camerafogfar * lightvolume))
                updateroomtimer = (updateroomtimer - fpsfactor)
                If (0.0 >= updateroomtimer) Then
                    updaterooms()
                    updateroomtimer = 10.0
                EndIf
                updateemitters()
                mouselook()
                moveplayer()
                updatedoors()
                updateevents()
                updatedecals()
                updatenpcs()
                updateitems()
                updateparticles()
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
                    eyestuck = max((eyestuck - fpsfactor), 0.0)
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
                    blurtimer = (Abs (killtimer * 10.0))
                    killtimer = (killtimer - fpsfactor)
                    If (-360.0 > killtimer) Then
                        menuopen = $01
                    EndIf
                    local16 = max(local16, min((Abs (killtimer / 400.0)), 1.0))
                EndIf
                If (selecteditem <> Null) Then
                    If (((selecteditem\Field1\Field1 = "navigator") Or (selecteditem\Field1\Field1 = "nav")) <> 0) Then
                        local16 = max(local16, 0.5)
                    EndIf
                EndIf
                entityalpha(dark, local16)
            EndIf
            If (0.0 < lightflash) Then
                lightflash = max((lightflash - (fpsfactor / 70.0)), 0.0)
                entityalpha(light, max(min((rnd(-0.2, 0.2) + lightflash), 1.0), 0.0))
            Else
                entityalpha(light, lightflash)
            EndIf
            If (keyhit($3B) <> 0) Then
                savegame(((savepath + currsave) + "\"))
                msg = "Game saved"
                msgtimer = 280.0
            EndIf
            If (keyhit($3D) <> 0) Then
                consoleopen = (consoleopen = $00)
                flushkeys()
            EndIf
            drawgui()
            drawmenu()
            updateconsole()
            local17 = millisecs()
            If (0.0 < msgtimer) Then
                color((Int min((msgtimer / 2.0), 255.0)), (Int min((msgtimer / 2.0), 255.0)), (Int min((msgtimer / 2.0), 255.0)))
                text((graphicwidth Sar $01), ((graphicheight Sar $01) + $C8), msg, $01, $00)
                msgtimer = (msgtimer - fpsfactor2)
            EndIf
            color($FF, $FF, $FF)
            If (showfps <> 0) Then
                text($14, $14, ("FPS: " + (Str local3)), $00, $00)
            EndIf
        EndIf
        If ((keyhit(local18) And $00) <> 0) Then
            For local19 = Each rooms
                If (local19\Field6\Field4 = "coffin") Then
                    positionentity(collider, entityx(local19\Field1, $00), 0.7, entityz(local19\Field1, $00), $00)
                    Exit
                EndIf
            Next
            resetentity(collider)
        EndIf
        flip($01)
    Forever
End Function
