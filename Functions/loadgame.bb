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
    Local local13%
    Local local14.roomtemplates
    Local local15.rooms
    Local local16#
    Local local17%
    Local local18#
    Local local19%
    Local local20%
    Local local21#
    Local local22#
    Local local23#
    Local local24#
    Local local25%
    Local local26#
    Local local27.doors
    Local local28%
    Local local29.npcs
    Local local31#
    Local local33%
    Local local34.npcs
    Local local35%
    Local local36#
    Local local37#
    Local local38#
    Local local39.decals
    Local local40.events
    Local local41.items
    Local local42$
    Local local43$
    Local local44%
    Local local45.itemtemplates
    Local local46#
    Local local47.rooms
    Local local48#
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
    If (local5 <> versionnumber) Then
        runtimeerror((((("The save files of v" + (Str local7)) + " aren't compatible with SCP - Containment Breach v") + versionnumber) + "."))
    EndIf
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
    For local8 = $00 To $00 Step $01
        For local0 = 0.0 To (Float (mapwidth - $01)) Step 1.0
            For local1 = 0.0 To (Float (mapheight - $01)) Step 1.0
                maptemp(local8, (Int local0), (Int local1)) = readint(local6)
                mapfound(local8, (Int local0), (Int local1)) = readbyte(local6)
            Next
        Next
    Next
    If (readint(local6) <> $278) Then
        runtimeerror("Couldn't load the game, save file corrupted (error 1)")
    EndIf
    local4 = readint(local6)
    For local3 = $01 To local4 Step $01
        local9 = readint(local6)
        local10 = readint(local6)
        local0 = readfloat(local6)
        local1 = readfloat(local6)
        local2 = readfloat(local6)
        local11 = readbyte(local6)
        local12 = readint(local6)
        local13 = readbyte(local6)
        For local14 = Each roomtemplates
            If (local14\Field1 = local9) Then
                local15 = createroom(local12, local14\Field3, local0, local1, local2, local14\Field4)
                turnentity(local15\Field2, 0.0, (Float local10), 0.0, $00)
                local15\Field6 = local10
                local15\Field1 = local11
                Exit
            EndIf
        Next
        If (local13 = $01) Then
            playerroom = local15
        EndIf
    Next
    initwaypoints($3C)
    If (readint(local6) <> $3BA) Then
        runtimeerror("Couldn't load the game, save file may be corrupted (error 2)")
    EndIf
    local16 = 8.0
    For local8 = $00 To $00 Step $01
        local1 = (Float (mapheight - $02))
        While (1.0 <= local1)
            For local0 = 1.0 To (Float (mapwidth - $02)) Step 1.0
                If (maptemp(local8, (Int local0), (Int local1)) > $00) Then
                    If (ceil(((local0 + local1) / 2.0)) = floor(((local0 + local1) / 2.0))) Then
                        If (maptemp(local8, (Int (local0 + 1.0)), (Int local1)) <> 0) Then
                            createdoor(local8, ((local0 * local16) + (local16 / 2.0)), 0.0, (local1 * local16), 90.0, Null, (Int max((Float rand($FFFFFFFD, $01)), 0.0)), $00, $00, "")
                        EndIf
                        If (maptemp(local8, (Int (local0 - 1.0)), (Int local1)) <> 0) Then
                            createdoor(local8, ((local0 * local16) - (local16 / 2.0)), 0.0, (local1 * local16), 90.0, Null, (Int max((Float rand($FFFFFFFD, $01)), 0.0)), $00, $00, "")
                        EndIf
                        If (maptemp(local8, (Int local0), (Int (local1 + 1.0))) <> 0) Then
                            createdoor(local8, (local0 * local16), 0.0, ((local1 * local16) + (local16 / 2.0)), 0.0, Null, (Int max((Float rand($FFFFFFFD, $01)), 0.0)), $00, $00, "")
                        EndIf
                        If (maptemp(local8, (Int local0), (Int (local1 - 1.0))) <> 0) Then
                            createdoor(local8, (local0 * local16), 0.0, ((local1 * local16) - (local16 / 2.0)), 0.0, Null, (Int max((Float rand($FFFFFFFD, $01)), 0.0)), $00, $00, "")
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
        local17 = readbyte(local6)
        local18 = readfloat(local6)
        local19 = readbyte(local6)
        local20 = readbyte(local6)
        local21 = readfloat(local6)
        local22 = readfloat(local6)
        local23 = readfloat(local6)
        local24 = readfloat(local6)
        local25 = (Int readfloat(local6))
        local26 = readfloat(local6)
        For local27 = Each doors
            If (((local0 = entityx(local27\Field2, $01)) And (local2 = entityz(local27\Field2, $01))) <> 0) Then
                local27\Field5 = local17
                local27\Field7 = local18
                local27\Field4 = local19
                local27\Field21 = local20
                local27\Field10 = local25
                local27\Field11 = local26
                positionentity(local27\Field0, local21, entityy(local27\Field0, $00), local22, $01)
                If (local27\Field1 <> $00) Then
                    positionentity(local27\Field1, local23, entityy(local27\Field1, $00), local24, $01)
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
        local28 = readbyte(local6)
        local0 = readfloat(local6)
        local1 = readfloat(local6)
        local2 = readfloat(local6)
        local29 = createnpc(local28, local0, local1, local2)
        Select local28
            Case $01
                curr173 = local29
            Case $02
                curr106 = local29
        End Select
        local0 = readfloat(local6)
        local1 = readfloat(local6)
        local2 = readfloat(local6)
        rotateentity(local29\Field4, local0, local1, local2, $00)
        local29\Field9 = readfloat(local6)
        local29\Field10 = readfloat(local6)
        local29\Field11 = readfloat(local6)
        local29\Field12 = readint(local6)
        local29\Field19 = (Float readbyte(local6))
        local29\Field22 = readfloat(local6)
        local29\Field21 = readint(local6)
        local29\Field18 = (Float readint(local6))
        local29\Field13 = readfloat(local6)
        local29\Field20 = readfloat(local6)
        local29\Field6 = readint(local6)
        local29\Field27 = readint(local6)
        local29\Field28 = readfloat(local6)
        local29\Field29 = readfloat(local6)
        local29\Field30 = readfloat(local6)
        local31 = readfloat(local6)
        Select local28
            Case $02,$04,$03,local33,$08
                setanimtime(local29\Field0, local31, $00)
        End Select
    Next
    For local29 = Each npcs
        If (local29\Field27 <> $00) Then
            For local34 = Each npcs
                If (local34 <> local29) Then
                    If (local34\Field6 = local29\Field27) Then
                        local29\Field26 = local34
                    EndIf
                EndIf
            Next
        EndIf
    Next
    mtftimer = readfloat(local6)
    For local3 = $00 To $06 Step $01
        local5 = readstring(local6)
        If (local5 <> "a") Then
            For local15 = Each rooms
                If (local15\Field7\Field4 = local5) Then
                    mtfrooms[local3] = local15
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
        local35 = readint(local6)
        local0 = readfloat(local6)
        local1 = readfloat(local6)
        local2 = readfloat(local6)
        local36 = readfloat(local6)
        local37 = readfloat(local6)
        local38 = readfloat(local6)
        local39 = createdecal(local35, local0, local1, local2, local36, local37, local38)
        local39\Field6 = readbyte(local6)
        local39\Field7 = readint(local6)
        local39\Field2 = readfloat(local6)
        local39\Field5 = readfloat(local6)
        local39\Field4 = readfloat(local6)
        local39\Field9 = readfloat(local6)
        local39\Field10 = readfloat(local6)
        scalesprite(local39\Field0, local39\Field2, local39\Field2)
        entityblend(local39\Field0, local39\Field6)
        entityfx(local39\Field0, local39\Field7)
    Next
    local4 = readint(local6)
    For local3 = $01 To local4 Step $01
        local40 = (New events)
        local40\Field0 = readstring(local6)
        local40\Field2 = readfloat(local6)
        local40\Field3 = readfloat(local6)
        local40\Field4 = readfloat(local6)
        local0 = readfloat(local6)
        local2 = readfloat(local6)
        For local15 = Each rooms
            If (((local0 = entityx(local15\Field2, $00)) And (local2 = entityz(local15\Field2, $00))) <> 0) Then
                local40\Field1 = local15
                Exit
            EndIf
        Next
    Next
    For local41 = Each items
        removeitem(local41)
    Next
    local4 = readint(local6)
    For local3 = $01 To local4 Step $01
        local42 = readstring(local6)
        local43 = readstring(local6)
        local0 = readfloat(local6)
        local1 = readfloat(local6)
        local2 = readfloat(local6)
        local41 = createitem(local42, local43, local0, local1, local2)
        entitytype(local41\Field0, $03, $00)
        local0 = readfloat(local6)
        local1 = readfloat(local6)
        rotateentity(local41\Field0, local0, local1, 0.0, $00)
        local41\Field7 = readfloat(local6)
        local41\Field9 = readbyte(local6)
        If (local41\Field9 <> 0) Then
            hideentity(local41\Field0)
        EndIf
        local44 = readbyte(local6)
        If (local44 = $01) Then
            selecteditem = local41
        EndIf
        local44 = readbyte(local6)
        If (local44 < $42) Then
            inventory(local44) = local41
        EndIf
    Next
    For local45 = Each itemtemplates
        local45\Field3 = readbyte(local6)
    Next
    For local27 = Each doors
        If (local27\Field13 <> Null) Then
            local46 = 20.0
            For local15 = Each rooms
                local48 = entitydistance(local15\Field2, local27\Field0)
                If (local46 > local48) Then
                    local46 = local48
                    local47 = local15
                EndIf
            Next
            local27\Field13 = local47
        EndIf
    Next
    If (readint(local6) <> $3E2) Then
        runtimeerror("Couldn't load the game, save file corrupted (error 4)")
    EndIf
    closefile(local6)
    Return $00
End Function
