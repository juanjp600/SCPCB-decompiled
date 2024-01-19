Function loadgame%(arg0$)
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
    Local local13.roomtemplates
    Local local14.rooms
    Local local15#
    Local local16%
    Local local17#
    Local local18%
    Local local19%
    Local local20#
    Local local21#
    Local local22#
    Local local23#
    Local local24%
    Local local25#
    Local local26.doors
    Local local27%
    Local local28.npcs
    Local local30#
    Local local32.npcs
    Local local33%
    Local local34#
    Local local35#
    Local local36#
    Local local37.decals
    Local local38.events
    Local local39.items
    Local local40$
    Local local41$
    Local local42%
    Local local43.itemtemplates
    Local local44#
    Local local45.rooms
    Local local46#
    gamesaved = $01
    local6 = readfile((arg0 + "save.txt"))
    playtime = readint(local6)
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
        For local13 = Each roomtemplates
            If (local13\Field1 = local8) Then
                local14 = createroom(local11, local13\Field3, local0, local1, local2, local13\Field4)
                turnentity(local14\Field2, 0.0, (Float local9), 0.0, $00)
                local14\Field6 = local9
                local14\Field1 = local10
                Exit
            EndIf
        Next
        If (local12 = $01) Then
            playerroom = local14
        EndIf
    Next
    initwaypoints($3C)
    If (readint(local6) <> $3BA) Then
        runtimeerror("Couldn't load the game, save file may be corrupted (error 2)")
    EndIf
    local15 = 8.0
    For local7 = $00 To $00 Step $01
        local1 = (Float (mapheight - $02))
        While (1.0 <= local1)
            For local0 = 1.0 To (Float (mapwidth - $02)) Step 1.0
                If (maptemp(local7, (Int local0), (Int local1)) > $00) Then
                    If (ceil(((local0 + local1) / 2.0)) = floor(((local0 + local1) / 2.0))) Then
                        If (maptemp(local7, (Int (local0 + 1.0)), (Int local1)) <> 0) Then
                            createdoor(local7, ((local0 * local15) + (local15 / 2.0)), 0.0, (local1 * local15), 90.0, Null, (Int max((Float rand($FFFFFFFD, $01)), 0.0)), $00, $00, "")
                        EndIf
                        If (maptemp(local7, (Int (local0 - 1.0)), (Int local1)) <> 0) Then
                            createdoor(local7, ((local0 * local15) - (local15 / 2.0)), 0.0, (local1 * local15), 90.0, Null, (Int max((Float rand($FFFFFFFD, $01)), 0.0)), $00, $00, "")
                        EndIf
                        If (maptemp(local7, (Int local0), (Int (local1 + 1.0))) <> 0) Then
                            createdoor(local7, (local0 * local15), 0.0, ((local1 * local15) + (local15 / 2.0)), 0.0, Null, (Int max((Float rand($FFFFFFFD, $01)), 0.0)), $00, $00, "")
                        EndIf
                        If (maptemp(local7, (Int local0), (Int (local1 - 1.0))) <> 0) Then
                            createdoor(local7, (local0 * local15), 0.0, ((local1 * local15) - (local15 / 2.0)), 0.0, Null, (Int max((Float rand($FFFFFFFD, $01)), 0.0)), $00, $00, "")
                        EndIf
                    EndIf
                EndIf
            Next
            local1 = (local1 + -1.0)
        Wend
    Next
    local4 = readint(local6)
    For local3 = $01 To local4 Step $01
        local0 = readfloat(local6)
        local2 = readfloat(local6)
        local16 = readbyte(local6)
        local17 = readfloat(local6)
        local18 = readbyte(local6)
        local19 = readbyte(local6)
        local20 = readfloat(local6)
        local21 = readfloat(local6)
        local22 = readfloat(local6)
        local23 = readfloat(local6)
        local24 = readbyte(local6)
        local25 = readfloat(local6)
        For local26 = Each doors
            If (((local0 = entityx(local26\Field2, $00)) And (local2 = entityz(local26\Field2, $00))) <> 0) Then
                local26\Field5 = local16
                local26\Field7 = local17
                local26\Field4 = local18
                local26\Field21 = local19
                local26\Field10 = local24
                local26\Field11 = local25
                positionentity(local26\Field0, local20, entityy(local26\Field0, $00), local21, $01)
                If (local26\Field1 <> $00) Then
                    positionentity(local26\Field1, local22, entityy(local26\Field1, $00), local23, $01)
                EndIf
                Exit
            EndIf
        Next
    Next
    If (readint(local6) <> $71) Then
        runtimeerror("Couldn't load the game, save file corrupted (error 2.5)")
    EndIf
    local4 = readint(local6)
    For local3 = $01 To local4 Step $01
        local27 = readbyte(local6)
        local0 = readfloat(local6)
        local1 = readfloat(local6)
        local2 = readfloat(local6)
        local28 = createnpc(local27, local0, local1, local2)
        Select local27
            Case $01
                curr173 = local28
            Case $02
                curr106 = local28
        End Select
        local0 = readfloat(local6)
        local1 = readfloat(local6)
        local2 = readfloat(local6)
        rotateentity(local28\Field4, local0, local1, local2, $00)
        local28\Field9 = readfloat(local6)
        local28\Field10 = readfloat(local6)
        local28\Field11 = readfloat(local6)
        local28\Field12 = readint(local6)
        local28\Field19 = (Float readbyte(local6))
        local28\Field22 = readfloat(local6)
        local28\Field21 = readint(local6)
        local28\Field18 = (Float readint(local6))
        local28\Field13 = readfloat(local6)
        local28\Field20 = readfloat(local6)
        local28\Field6 = readint(local6)
        local28\Field27 = readint(local6)
        local28\Field28 = readfloat(local6)
        local28\Field29 = readfloat(local6)
        local28\Field30 = readfloat(local6)
        local30 = readfloat(local6)
        Select local27
            Case $02,$04
                setanimtime(local28\Field0, local30, $00)
        End Select
    Next
    For local28 = Each npcs
        If (local28\Field27 <> $00) Then
            For local32 = Each npcs
                If (local32 <> local28) Then
                    If (local32\Field6 = local28\Field27) Then
                        local28\Field26 = local32
                    EndIf
                EndIf
            Next
        EndIf
    Next
    mtftimer = readfloat(local6)
    For local3 = $00 To $06 Step $01
        local5 = readstring(local6)
        If (local5 <> "a") Then
            For local14 = Each rooms
                If (local14\Field7\Field4 = local5) Then
                    mtfrooms[local3] = local14
                EndIf
            Next
        EndIf
        mtfroomstate[local3] = readint(local6)
    Next
    If (readint(local6) <> $735) Then
        runtimeerror("Couldn't load the game, save file corrupted (error 3)")
    EndIf
    local4 = readint(local6)
    For local3 = $01 To local4 Step $01
        local33 = readint(local6)
        local0 = readfloat(local6)
        local1 = readfloat(local6)
        local2 = readfloat(local6)
        local34 = readfloat(local6)
        local35 = readfloat(local6)
        local36 = readfloat(local6)
        local37 = createdecal(local33, local0, local1, local2, local34, local35, local36)
        local37\Field5 = readbyte(local6)
        local37\Field6 = readint(local6)
        local37\Field2 = readfloat(local6)
        local37\Field4 = readfloat(local6)
        local37\Field3 = readfloat(local6)
        local37\Field8 = readfloat(local6)
        local37\Field9 = readfloat(local6)
        scalesprite(local37\Field0, local37\Field2, local37\Field2)
        entityblend(local37\Field0, local37\Field5)
        entityfx(local37\Field0, local37\Field6)
    Next
    local4 = readint(local6)
    For local3 = $01 To local4 Step $01
        local38 = (New events)
        local38\Field0 = readstring(local6)
        local38\Field2 = readfloat(local6)
        local38\Field3 = readfloat(local6)
        local38\Field4 = readfloat(local6)
        local0 = readfloat(local6)
        local2 = readfloat(local6)
        For local14 = Each rooms
            If (((local0 = entityx(local14\Field2, $00)) And (local2 = entityz(local14\Field2, $00))) <> 0) Then
                local38\Field1 = local14
                Exit
            EndIf
        Next
    Next
    For local39 = Each items
        removeitem(local39)
    Next
    local4 = readint(local6)
    For local3 = $01 To local4 Step $01
        local40 = readstring(local6)
        local41 = readstring(local6)
        local0 = readfloat(local6)
        local1 = readfloat(local6)
        local2 = readfloat(local6)
        local39 = createitem(local40, local41, local0, local1, local2)
        entitytype(local39\Field0, $03, $00)
        local0 = readfloat(local6)
        local1 = readfloat(local6)
        rotateentity(local39\Field0, local0, local1, 0.0, $00)
        local39\Field7 = readfloat(local6)
        local39\Field9 = readbyte(local6)
        If (local39\Field9 <> 0) Then
            hideentity(local39\Field0)
        EndIf
        local42 = readbyte(local6)
        If (local42 = $01) Then
            selecteditem = local39
        EndIf
        local42 = readbyte(local6)
        If (local42 < $42) Then
            inventory(local42) = local39
        EndIf
    Next
    For local43 = Each itemtemplates
        local43\Field3 = readbyte(local6)
    Next
    For local26 = Each doors
        If (local26\Field13 <> Null) Then
            local44 = 20.0
            For local14 = Each rooms
                local46 = entitydistance(local14\Field2, local26\Field0)
                If (local44 > local46) Then
                    local44 = local46
                    local45 = local14
                EndIf
            Next
            local26\Field13 = local45
        EndIf
    Next
    If (readint(local6) <> $3E2) Then
        runtimeerror("Couldn't load the game, save file corrupted (error 4)")
    EndIf
    closefile(local6)
    Return $00
End Function
