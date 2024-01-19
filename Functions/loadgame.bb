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
    Local local33.npcs
    Local local34%
    Local local35#
    Local local36#
    Local local37#
    Local local38.decals
    Local local39.events
    Local local40.items
    Local local41$
    Local local42$
    Local local43%
    Local local44.itemtemplates
    gamesaved = $01
    local6 = readfile((arg0 + "save.txt"))
    playtime = readint(local6)
    local0 = readfloat(local6)
    local1 = readfloat(local6)
    local2 = readfloat(local6)
    positionentity(collider, local0, (local1 + 0.01), local2, $00)
    resetentity(collider)
    playerlevel = readbyte(local6)
    accesscode = readstring(local6)
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
    selectedmode = readbyte(local6)
    sanity = readfloat(local6)
    wearinggasmask = readbyte(local6)
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
        local25 = readbyte(local6)
        local26 = readfloat(local6)
        For local27 = Each doors
            If (((local0 = entityx(local27\Field2, $00)) And (local2 = entityz(local27\Field2, $00))) <> 0) Then
                local27\Field5 = local17
                local27\Field7 = local18
                local27\Field4 = local19
                local27\Field19 = local20
                local27\Field9 = local25
                local27\Field10 = local26
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
        local29\Field19 = readbyte(local6)
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
            Case $02,$04
                setanimtime(local29\Field0, local31, $00)
        End Select
    Next
    For local29 = Each npcs
        If (local29\Field27 <> $00) Then
            For local33 = Each npcs
                If (local33 <> local29) Then
                    If (local33\Field6 = local29\Field27) Then
                        local29\Field26 = local33
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
        local34 = readint(local6)
        local0 = readfloat(local6)
        local1 = readfloat(local6)
        local2 = readfloat(local6)
        local35 = readfloat(local6)
        local36 = readfloat(local6)
        local37 = readfloat(local6)
        local38 = createdecal(local34, local0, local1, local2, local35, local36, local37)
        local38\Field5 = readbyte(local6)
        local38\Field6 = readint(local6)
        local38\Field2 = readfloat(local6)
        local38\Field4 = readfloat(local6)
        local38\Field3 = readfloat(local6)
        local38\Field8 = readfloat(local6)
        local38\Field9 = readfloat(local6)
        scalesprite(local38\Field0, local38\Field2, local38\Field2)
        entityblend(local38\Field0, local38\Field5)
        entityfx(local38\Field0, local38\Field6)
    Next
    local4 = readint(local6)
    For local3 = $01 To local4 Step $01
        local39 = (New events)
        local39\Field0 = readstring(local6)
        local39\Field2 = readfloat(local6)
        local39\Field3 = readfloat(local6)
        local39\Field4 = readfloat(local6)
        local0 = readfloat(local6)
        local2 = readfloat(local6)
        For local15 = Each rooms
            If (((local0 = entityx(local15\Field2, $00)) And (local2 = entityz(local15\Field2, $00))) <> 0) Then
                local39\Field1 = local15
                Exit
            EndIf
        Next
    Next
    For local40 = Each items
        removeitem(local40)
    Next
    local4 = readint(local6)
    For local3 = $01 To local4 Step $01
        local41 = readstring(local6)
        local42 = readstring(local6)
        local0 = readfloat(local6)
        local1 = readfloat(local6)
        local2 = readfloat(local6)
        local40 = createitem(local41, local42, local0, local1, local2)
        entitytype(local40\Field0, $03, $00)
        local0 = readfloat(local6)
        local1 = readfloat(local6)
        rotateentity(local40\Field0, local0, local1, 0.0, $00)
        local40\Field5 = readfloat(local6)
        local40\Field7 = readbyte(local6)
        If (local40\Field7 <> 0) Then
            hideentity(local40\Field0)
        EndIf
        local43 = readbyte(local6)
        If (local43 = $01) Then
            selecteditem = local40
        EndIf
        local43 = readbyte(local6)
        If (local43 < $42) Then
            inventory(local43) = local40
        EndIf
    Next
    For local44 = Each itemtemplates
        local44\Field3 = readbyte(local6)
    Next
    If (readint(local6) <> $3E2) Then
        runtimeerror("Couldn't load the game, save file corrupted (error 4)")
    EndIf
    closefile(local6)
    Return $00
End Function
