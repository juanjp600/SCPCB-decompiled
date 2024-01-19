Function loadgamequick%(arg0$)
    Local local0#
    Local local1#
    Local local2#
    Local local3%
    Local local4%
    Local local5$
    Local local6%
    Local local7%
    Local local8%
    Local local9%
    Local local10%
    Local local11%
    Local local12%
    Local local13%
    Local local14#
    Local local15%
    Local local16%
    Local local17#
    Local local18#
    Local local19#
    Local local20#
    Local local21%
    Local local22#
    Local local23.doors
    Local local24.npcs
    Local local25%
    Local local27#
    Local local29.npcs
    Local local30.rooms
    Local local31.decals
    Local local32%
    Local local33#
    Local local34#
    Local local35#
    Local local36.events
    Local local37.items
    Local local38$
    Local local39$
    Local local40%
    Local local41.itemtemplates
    Local local42#
    Local local43.rooms
    Local local44#
    gamesaved = $01
    local6 = readfile((arg0 + "save.txt"))
    dropspeed = 0.0
    shake = 0.0
    currspeed = 0.0
    heartbeatvolume = 0.0
    camerashake = 0.0
    shake = 0.0
    lightflash = 0.0
    blurtimer = 0.0
    killtimer = 0.0
    falltimer = 0.0
    menuopen = $00
    godmode = $00
    noclip = $00
    playtime = readint(local6)
    hideentity(head)
    showentity(collider)
    local0 = readfloat(local6)
    local1 = readfloat(local6)
    local2 = readfloat(local6)
    positionentity(collider, local0, (local1 + 0.05), local2, $00)
    resetentity(collider)
    playerlevel = readbyte(local6)
    accesscode = (Int readstring(local6))
    local0 = readfloat(local6)
    local1 = readfloat(local6)
    rotateentity(collider, local0, local1, 0.0, $00)
    local5 = readstring(local6)
    blinktimer = readfloat(local6)
    stamina = readfloat(local6)
    eyesuper = readfloat(local6)
    eyestuck = readfloat(local6)
    eyeirritation = readfloat(local6)
    injuries = readfloat(local6)
    bloodloss = readfloat(local6)
    selectedmode = readbyte(local6)
    sanity = readfloat(local6)
    wearinggasmask = readbyte(local6)
    wearingvest = readbyte(local6)
    superman = readbyte(local6)
    supermantimer = readfloat(local6)
    lightson = readbyte(local6)
    randomseed = readstring(local6)
    secondarylighton = readfloat(local6)
    remotedooron = readbyte(local6)
    soundtransmission = readbyte(local6)
    contained106 = readbyte(local6)
    achv420 = readbyte(local6)
    achv106 = readbyte(local6)
    achv372 = readbyte(local6)
    achv895 = readbyte(local6)
    achv079 = readbyte(local6)
    achv914 = readbyte(local6)
    achv789 = readbyte(local6)
    achv096 = readbyte(local6)
    achvtesla = readbyte(local6)
    achvmaynard = readbyte(local6)
    achvharp = readbyte(local6)
    achvpd = readbyte(local6)
    achvsnav = readbyte(local6)
    achvomni = readbyte(local6)
    achvconsole = readbyte(local6)
    refineditems = readint(local6)
    mapwidth = readint(local6)
    mapheight = readint(local6)
    For local7 = $00 To $00 Step $01
        For local0 = 0.0 To (Float (mapwidth - $01)) Step 1.0
            For local1 = 0.0 To (Float (mapheight - $01)) Step 1.0
                maptemp(local7, (Int local0), (Int local1)) = readint(local6)
                mapfound(local7, (Int local0), (Int local1)) = readbyte(local6)
            Next
        Next
    Next
    If (readint(local6) <> $278) Then
        runtimeerror("Couldn't load the game, save file corrupted (error 1)")
    EndIf
    local4 = readint(local6)
    For local3 = $01 To local4 Step $01
        local8 = readint(local6)
        local9 = readint(local6)
        local0 = readfloat(local6)
        local1 = readfloat(local6)
        local2 = readfloat(local6)
        local10 = readbyte(local6)
        local11 = readint(local6)
        local12 = readbyte(local6)
    Next
    If (readint(local6) <> $3BA) Then
        runtimeerror("Couldn't load the game, save file may be corrupted (error 2)")
    EndIf
    local4 = readint(local6)
    For local3 = $01 To local4 Step $01
        local0 = readfloat(local6)
        local2 = readfloat(local6)
        local13 = readbyte(local6)
        local14 = readfloat(local6)
        local15 = readbyte(local6)
        local16 = readbyte(local6)
        local17 = readfloat(local6)
        local18 = readfloat(local6)
        local19 = readfloat(local6)
        local20 = readfloat(local6)
        local21 = readbyte(local6)
        local22 = readfloat(local6)
        For local23 = Each doors
            If (((local0 = entityx(local23\Field2, $00)) And (local2 = entityz(local23\Field2, $00))) <> 0) Then
                local23\Field5 = local13
                local23\Field7 = local14
                local23\Field4 = local15
                local23\Field21 = local16
                local23\Field10 = local21
                local23\Field11 = local22
                positionentity(local23\Field0, local17, entityy(local23\Field0, $00), local18, $01)
                If (local23\Field1 <> $00) Then
                    positionentity(local23\Field1, local19, entityy(local23\Field1, $00), local20, $01)
                EndIf
                Exit
            EndIf
        Next
    Next
    If (readint(local6) <> $71) Then
        runtimeerror("Couldn't load the game, save file corrupted (error 2.5)")
    EndIf
    For local24 = Each npcs
        freeentity(local24\Field0)
        Delete local24
    Next
    local4 = readint(local6)
    For local3 = $01 To local4 Step $01
        local25 = readbyte(local6)
        local0 = readfloat(local6)
        local1 = readfloat(local6)
        local2 = readfloat(local6)
        local24 = createnpc(local25, local0, local1, local2)
        Select local25
            Case $01
                curr173 = local24
            Case $02
                curr106 = local24
        End Select
        local0 = readfloat(local6)
        local1 = readfloat(local6)
        local2 = readfloat(local6)
        rotateentity(local24\Field4, local0, local1, local2, $00)
        local24\Field9 = readfloat(local6)
        local24\Field10 = readfloat(local6)
        local24\Field11 = readfloat(local6)
        local24\Field12 = readint(local6)
        local24\Field19 = (Float readbyte(local6))
        local24\Field22 = readfloat(local6)
        local24\Field21 = readint(local6)
        local24\Field18 = (Float readint(local6))
        local24\Field13 = readfloat(local6)
        local24\Field20 = readfloat(local6)
        local24\Field6 = readint(local6)
        local24\Field27 = readint(local6)
        local24\Field28 = readfloat(local6)
        local24\Field29 = readfloat(local6)
        local24\Field30 = readfloat(local6)
        local27 = readfloat(local6)
        Select local25
            Case $02,$04,$09,$08,$03
                setanimtime(local24\Field0, local27, $00)
        End Select
    Next
    For local24 = Each npcs
        If (local24\Field27 <> $00) Then
            For local29 = Each npcs
                If (local29 <> local24) Then
                    If (local29\Field6 = local24\Field27) Then
                        local24\Field26 = local29
                    EndIf
                EndIf
            Next
        EndIf
    Next
    mtftimer = readfloat(local6)
    For local3 = $00 To $06 Step $01
        local5 = readstring(local6)
        If (local5 <> "a") Then
            For local30 = Each rooms
                If (local30\Field7\Field4 = local5) Then
                    mtfrooms[local3] = local30
                EndIf
            Next
        EndIf
        mtfroomstate[local3] = readint(local6)
    Next
    If (readint(local6) <> $735) Then
        runtimeerror("Couldn't load the game, save file corrupted (error 3)")
    EndIf
    For local31 = Each decals
        freeentity(local31\Field0)
        Delete local31
    Next
    local4 = readint(local6)
    For local3 = $01 To local4 Step $01
        local32 = readint(local6)
        local0 = readfloat(local6)
        local1 = readfloat(local6)
        local2 = readfloat(local6)
        local33 = readfloat(local6)
        local34 = readfloat(local6)
        local35 = readfloat(local6)
        local31 = createdecal(local32, local0, local1, local2, local33, local34, local35)
        local31\Field5 = readbyte(local6)
        local31\Field6 = readint(local6)
        local31\Field2 = readfloat(local6)
        local31\Field4 = readfloat(local6)
        local31\Field3 = readfloat(local6)
        local31\Field8 = readfloat(local6)
        local31\Field9 = readfloat(local6)
        scalesprite(local31\Field0, local31\Field2, local31\Field2)
        entityblend(local31\Field0, local31\Field5)
        entityfx(local31\Field0, local31\Field6)
    Next
    For local36 = Each events
        If (local36\Field7 <> $00) Then
            freesound(local36\Field7)
        EndIf
        Delete local36
    Next
    local4 = readint(local6)
    For local3 = $01 To local4 Step $01
        local36 = (New events)
        local36\Field0 = readstring(local6)
        local36\Field2 = readfloat(local6)
        local36\Field3 = readfloat(local6)
        local36\Field4 = readfloat(local6)
        local0 = readfloat(local6)
        local2 = readfloat(local6)
        For local30 = Each rooms
            If (((local0 = entityx(local30\Field2, $00)) And (local2 = entityz(local30\Field2, $00))) <> 0) Then
                local36\Field1 = local30
                Exit
            EndIf
        Next
    Next
    For local37 = Each items
        removeitem(local37)
    Next
    local4 = readint(local6)
    For local3 = $01 To local4 Step $01
        local38 = readstring(local6)
        local39 = readstring(local6)
        local0 = readfloat(local6)
        local1 = readfloat(local6)
        local2 = readfloat(local6)
        local37 = createitem(local38, local39, local0, local1, local2)
        entitytype(local37\Field0, $03, $00)
        local0 = readfloat(local6)
        local1 = readfloat(local6)
        rotateentity(local37\Field0, local0, local1, 0.0, $00)
        local37\Field7 = readfloat(local6)
        local37\Field9 = readbyte(local6)
        If (local37\Field9 <> 0) Then
            hideentity(local37\Field0)
        EndIf
        local40 = readbyte(local6)
        If (local40 = $01) Then
            selecteditem = local37
        EndIf
        local40 = readbyte(local6)
        If (local40 < $42) Then
            inventory(local40) = local37
        EndIf
    Next
    For local41 = Each itemtemplates
        local41\Field3 = readbyte(local6)
    Next
    For local23 = Each doors
        If (local23\Field13 <> Null) Then
            local42 = 20.0
            For local30 = Each rooms
                local44 = entitydistance(local30\Field2, local23\Field0)
                If (local42 > local44) Then
                    local42 = local44
                    local43 = local30
                EndIf
            Next
            local23\Field13 = local43
        EndIf
    Next
    If (readint(local6) <> $3E2) Then
        runtimeerror("Couldn't load the game, save file corrupted (error 4)")
    EndIf
    closefile(local6)
    Return $00
End Function
