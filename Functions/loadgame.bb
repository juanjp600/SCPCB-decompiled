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
    Local local11.roomtemplates
    Local local12.rooms
    Local local13#
    Local local14%
    Local local15#
    Local local16%
    Local local17%
    Local local18#
    Local local19#
    Local local20#
    Local local21#
    Local local22%
    Local local23#
    Local local24.doors
    Local local25%
    Local local26.npcs
    Local local28#
    Local local30%
    Local local31#
    Local local32#
    Local local33#
    Local local34.decals
    Local local35.events
    Local local36.items
    Local local37$
    Local local38$
    Local local39$
    Local local40$
    Local local41$
    Local local42#
    Local local43%
    gamesaved = $01
    local6 = readfile((arg0 + "save.txt"))
    playtime = readint(local6)
    local0 = readfloat(local6)
    local1 = readfloat(local6)
    local2 = readfloat(local6)
    positionentity(collider, local0, local1, local2, $00)
    resetentity(collider)
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
    timer513 = readfloat(local6)
    mapwidth = readint(local6)
    mapheight = readint(local6)
    For local0 = 0.0 To (Float (mapwidth - $01)) Step 1.0
        For local1 = 0.0 To (Float (mapheight - $01)) Step 1.0
            maptemp((Int local0), (Int local1)) = readint(local6)
            mapfound((Int local0), (Int local1)) = readbyte(local6)
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
        For local11 = Each roomtemplates
            If (local11\Field1 = local8) Then
                local12 = createroom(local11\Field3, local0, local1, local2, local11\Field4)
                turnentity(local12\Field0, 0.0, (Float local9), 0.0, $00)
                local12\Field4 = local9
                Exit
            EndIf
        Next
        If (local10 = $01) Then
            playerroom = local12
        EndIf
    Next
    If (readint(local6) <> $3BA) Then
        runtimeerror("Couldn't load the game, save file may be corrupted (error 2)")
    EndIf
    local13 = 8.0
    local1 = (Float (mapheight - $02))
    While (1.0 <= local1)
        For local0 = 1.0 To (Float (mapwidth - $02)) Step 1.0
            If (maptemp((Int local0), (Int local1)) > $00) Then
                If (ceil(((local0 + local1) / 2.0)) = floor(((local0 + local1) / 2.0))) Then
                    If (maptemp((Int (local0 + 1.0)), (Int local1)) <> 0) Then
                        createdoor(((local0 * local13) + (local13 / 2.0)), 0.0, (local1 * local13), 90.0, (Int max((Float rand($FFFFFFFD, $01)), 0.0)), $00, $00, $00)
                    EndIf
                    If (maptemp((Int (local0 - 1.0)), (Int local1)) <> 0) Then
                        createdoor(((local0 * local13) - (local13 / 2.0)), 0.0, (local1 * local13), 90.0, (Int max((Float rand($FFFFFFFD, $01)), 0.0)), $00, $00, $00)
                    EndIf
                    If (maptemp((Int local0), (Int (local1 + 1.0))) <> 0) Then
                        createdoor((local0 * local13), 0.0, ((local1 * local13) + (local13 / 2.0)), 0.0, (Int max((Float rand($FFFFFFFD, $01)), 0.0)), $00, $00, $00)
                    EndIf
                    If (maptemp((Int local0), (Int (local1 - 1.0))) <> 0) Then
                        createdoor((local0 * local13), 0.0, ((local1 * local13) - (local13 / 2.0)), 0.0, (Int max((Float rand($FFFFFFFD, $01)), 0.0)), $00, $00, $00)
                    EndIf
                EndIf
            EndIf
        Next
        local1 = (local1 + -1.0)
    Wend
    local4 = readint(local6)
    For local3 = $01 To local4 Step $01
        local0 = readfloat(local6)
        local2 = readfloat(local6)
        local14 = readbyte(local6)
        local15 = readfloat(local6)
        local16 = readbyte(local6)
        local17 = readbyte(local6)
        local18 = readfloat(local6)
        local19 = readfloat(local6)
        local20 = readfloat(local6)
        local21 = readfloat(local6)
        local22 = readbyte(local6)
        local23 = readfloat(local6)
        For local24 = Each doors
            If (((local0 = entityx(local24\Field2, $00)) And (local2 = entityz(local24\Field2, $00))) <> 0) Then
                local24\Field5 = local14
                local24\Field7 = local15
                local24\Field4 = local16
                local24\Field13 = local17
                local24\Field9 = local22
                local24\Field10 = local23
                positionentity(local24\Field0, local18, entityy(local24\Field0, $00), local19, $01)
                If (local24\Field1 <> $00) Then
                    positionentity(local24\Field1, local20, entityy(local24\Field1, $00), local21, $01)
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
        local25 = readbyte(local6)
        local0 = readfloat(local6)
        local1 = readfloat(local6)
        local2 = readfloat(local6)
        local26 = createnpc(local25, local0, local1, local2)
        Select local25
            Case $01
                curr173 = local26
            Case $02
                curr106 = local26
        End Select
        local0 = readfloat(local6)
        local1 = readfloat(local6)
        local2 = readfloat(local6)
        rotateentity(local26\Field2, local0, local1, local2, $00)
        local26\Field6 = readfloat(local6)
        local26\Field7 = readint(local6)
        local26\Field12 = readbyte(local6)
        local26\Field15 = readfloat(local6)
        local26\Field14 = readint(local6)
        local26\Field19 = readfloat(local6)
        local26\Field20 = readfloat(local6)
        local26\Field21 = readfloat(local6)
        local28 = readfloat(local6)
        Select local25
            Case $02,$04
                setanimtime(local26\Field0, local28, $00)
        End Select
    Next
    If (readint(local6) <> $735) Then
        runtimeerror("Couldn't load the game, save file corrupted (error 3)")
    EndIf
    local4 = readint(local6)
    For local3 = $01 To local4 Step $01
        local30 = readint(local6)
        local0 = readfloat(local6)
        local1 = readfloat(local6)
        local2 = readfloat(local6)
        local31 = readfloat(local6)
        local32 = readfloat(local6)
        local33 = readfloat(local6)
        local34 = createdecal(local30, local0, local1, local2, local31, local32, local33)
        local34\Field2 = readfloat(local6)
        local34\Field4 = readfloat(local6)
        local34\Field3 = readfloat(local6)
        local34\Field6 = readfloat(local6)
        scalesprite(local34\Field0, local34\Field2, local34\Field2)
    Next
    local4 = readint(local6)
    For local3 = $01 To local4 Step $01
        local35 = (New events)
        local35\Field0 = readstring(local6)
        local35\Field2 = readfloat(local6)
        local0 = readfloat(local6)
        local2 = readfloat(local6)
        For local12 = Each rooms
            If (((local0 = entityx(local12\Field0, $00)) And (local2 = entityz(local12\Field0, $00))) <> 0) Then
                local35\Field1 = local12
                Exit
            EndIf
        Next
    Next
    For local36 = Each items
        removeitem(local36)
    Next
    local4 = readint(local6)
    For local3 = $01 To local4 Step $01
        local37 = readstring(local6)
        local38 = readstring(local6)
        local39 = readstring(local6)
        local40 = readstring(local6)
        local41 = readstring(local6)
        local42 = readfloat(local6)
        local0 = readfloat(local6)
        local1 = readfloat(local6)
        local2 = readfloat(local6)
        local36 = createitem(local37, local38, local0, local1, local2, local39, local41, local40, local42, "")
        entitytype(local36\Field0, $03, $00)
        local0 = readfloat(local6)
        local1 = readfloat(local6)
        rotateentity(local36\Field0, local0, local1, 0.0, $00)
        local36\Field8 = readfloat(local6)
        local36\Field9 = readbyte(local6)
        local36\Field12 = readbyte(local6)
        If (local36\Field12 <> 0) Then
            hideentity(local36\Field0)
        EndIf
        local43 = readbyte(local6)
        If (local43 = $01) Then
            selecteditem = local36
        EndIf
        local43 = readbyte(local6)
        If (local43 < $42) Then
            inventory(local43) = local36
        EndIf
    Next
    If (readint(local6) <> $3E2) Then
        runtimeerror("Couldn't load the game, save file corrupted (error 4)")
    EndIf
    closefile(local6)
    Return $00
End Function
