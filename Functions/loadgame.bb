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
    Local local32%
    Local local33#
    Local local34#
    Local local35#
    Local local36.decals
    Local local37.events
    Local local38.items
    Local local39$
    Local local40$
    Local local41%
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
    secondarylighton = readfloat(local6)
    remotedooron = readbyte(local6)
    contained106 = readbyte(local6)
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
        local11 = readint(local6)
        local12 = readbyte(local6)
        For local13 = Each roomtemplates
            If (local13\Field1 = local9) Then
                local14 = createroom(local11, local13\Field3, local0, local1, local2, local13\Field4)
                turnentity(local14\Field1, 0.0, (Float local10), 0.0, $00)
                local14\Field5 = local10
                Exit
            EndIf
        Next
        If (local12 = $01) Then
            playerroom = local14
        EndIf
    Next
    If (readint(local6) <> $3BA) Then
        runtimeerror("Couldn't load the game, save file may be corrupted (error 2)")
    EndIf
    local15 = 8.0
    For local8 = $00 To $00 Step $01
        local1 = (Float (mapheight - $02))
        While (1.0 <= local1)
            For local0 = 1.0 To (Float (mapwidth - $02)) Step 1.0
                If (maptemp(local8, (Int local0), (Int local1)) > $00) Then
                    If (ceil(((local0 + local1) / 2.0)) = floor(((local0 + local1) / 2.0))) Then
                        If (maptemp(local8, (Int (local0 + 1.0)), (Int local1)) <> 0) Then
                            createdoor(local8, ((local0 * local15) + (local15 / 2.0)), 0.0, (local1 * local15), 90.0, (Int max((Float rand($FFFFFFFD, $01)), 0.0)), $00, $00, $00, "")
                        EndIf
                        If (maptemp(local8, (Int (local0 - 1.0)), (Int local1)) <> 0) Then
                            createdoor(local8, ((local0 * local15) - (local15 / 2.0)), 0.0, (local1 * local15), 90.0, (Int max((Float rand($FFFFFFFD, $01)), 0.0)), $00, $00, $00, "")
                        EndIf
                        If (maptemp(local8, (Int local0), (Int (local1 + 1.0))) <> 0) Then
                            createdoor(local8, (local0 * local15), 0.0, ((local1 * local15) + (local15 / 2.0)), 0.0, (Int max((Float rand($FFFFFFFD, $01)), 0.0)), $00, $00, $00, "")
                        EndIf
                        If (maptemp(local8, (Int local0), (Int (local1 - 1.0))) <> 0) Then
                            createdoor(local8, (local0 * local15), 0.0, ((local1 * local15) - (local15 / 2.0)), 0.0, (Int max((Float rand($FFFFFFFD, $01)), 0.0)), $00, $00, $00, "")
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
                local26\Field16 = local19
                local26\Field9 = local24
                local26\Field10 = local25
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
        rotateentity(local28\Field2, local0, local1, local2, $00)
        local28\Field6 = readfloat(local6)
        local28\Field7 = readint(local6)
        local28\Field12 = readbyte(local6)
        local28\Field15 = readfloat(local6)
        local28\Field14 = readint(local6)
        local28\Field19 = readfloat(local6)
        local28\Field20 = readfloat(local6)
        local28\Field21 = readfloat(local6)
        local30 = readfloat(local6)
        Select local27
            Case $02,$04
                setanimtime(local28\Field0, local30, $00)
        End Select
    Next
    If (readint(local6) <> $735) Then
        runtimeerror("Couldn't load the game, save file corrupted (error 3)")
    EndIf
    local4 = readint(local6)
    For local3 = $01 To local4 Step $01
        local32 = readint(local6)
        local0 = readfloat(local6)
        local1 = readfloat(local6)
        local2 = readfloat(local6)
        local33 = readfloat(local6)
        local34 = readfloat(local6)
        local35 = readfloat(local6)
        local36 = createdecal(local32, local0, local1, local2, local33, local34, local35)
        local36\Field2 = readfloat(local6)
        local36\Field4 = readfloat(local6)
        local36\Field3 = readfloat(local6)
        local36\Field6 = readfloat(local6)
        scalesprite(local36\Field0, local36\Field2, local36\Field2)
    Next
    local4 = readint(local6)
    For local3 = $01 To local4 Step $01
        local37 = (New events)
        local37\Field0 = readstring(local6)
        local37\Field2 = readfloat(local6)
        local37\Field3 = readfloat(local6)
        local37\Field4 = readfloat(local6)
        local0 = readfloat(local6)
        local2 = readfloat(local6)
        For local14 = Each rooms
            If (((local0 = entityx(local14\Field1, $00)) And (local2 = entityz(local14\Field1, $00))) <> 0) Then
                local37\Field1 = local14
                Exit
            EndIf
        Next
    Next
    For local38 = Each items
        removeitem(local38)
    Next
    local4 = readint(local6)
    For local3 = $01 To local4 Step $01
        local39 = readstring(local6)
        local40 = readstring(local6)
        local0 = readfloat(local6)
        local1 = readfloat(local6)
        local2 = readfloat(local6)
        local38 = createitem(local39, local40, local0, local1, local2)
        entitytype(local38\Field0, $03, $00)
        local0 = readfloat(local6)
        local1 = readfloat(local6)
        rotateentity(local38\Field0, local0, local1, 0.0, $00)
        local38\Field5 = readfloat(local6)
        local38\Field7 = readbyte(local6)
        If (local38\Field7 <> 0) Then
            hideentity(local38\Field0)
        EndIf
        local41 = readbyte(local6)
        If (local41 = $01) Then
            selecteditem = local38
        EndIf
        local41 = readbyte(local6)
        If (local41 < $42) Then
            inventory(local41) = local38
        EndIf
    Next
    If (readint(local6) <> $3E2) Then
        runtimeerror("Couldn't load the game, save file corrupted (error 4)")
    EndIf
    closefile(local6)
    Return $00
End Function
