Function createmap%()
    Local local0%
    Local local1%
    Local local2%
    Local local3%
    Local local4%
    Local local5%
    Local local6%
    Local local7%
    Local local8%
    Local local9%
    Local local10%
    Local local11%
    Local local12.rooms
    Local local13#
    Local local15%
    For local8 = $00 To $00 Step $01
        Dim mapname$(mapwidth, mapheight)
        local9 = $32
        Dim maproomid%($06)
        Dim maproom$($06, local9)
        local10 = local8
        If (local10 = $00) Then
            maproom($01, $00) = "start"
            maproom($01, $01) = "roompj"
            maproom($01, $02) = "914"
            maproom($01, $03) = "coffin"
            maproom($02, $00) = "room2closets"
            maproom($02, rand($06, $0A)) = "room2sroom"
            maproom($02, rand($0B, $0F)) = "room2testroom2"
            maproom($02, rand($10, $12)) = "testroom"
            maproom($02, rand($13, $16)) = "room2poffices"
            maproom($03, $00) = "lockroom"
            maproom($03, rand($01, $02)) = "room2ccont"
        EndIf
        local0 = (Int floor((Float (mapwidth Sar $01))))
        local1 = (mapheight - rand($04, $07))
        For local3 = local1 To (mapheight - $02) Step $01
            maptemp(local8, local0, local3) = $01
        Next
        Repeat
            local6 = rand($03, $08)
            If ((local0 - local6) >= $02) Then
                If ((local0 + local6) > (mapwidth - $02)) Then
                    local6 = (- local6)
                ElseIf (rand($02, $01) = $01) Then
                    local6 = (- local6)
                EndIf
            EndIf
            local0 = (Int min((Float local0), (Float (local0 + local6))))
            local6 = (Abs local6)
            For local3 = local0 To (local0 + local6) Step $01
                debuglog((((Str local3) + ", ") + (Str local1)))
                maptemp(local8, local3, local1) = $01
            Next
            local7 = rand($03, $05)
            If ((local1 - local7) <= $03) Then
                local7 = $01
            EndIf
            For local3 = $01 To rand($03, $01) Step $01
                local4 = rand(local0, (local0 + local6))
                debuglog((((Str local4) + ", ") + (Str local1)))
                If (((maptemp(local8, (local4 - $01), (local1 - $01)) = $00) And (maptemp(local8, (local4 + $01), (local1 - $01)) = $00)) <> 0) Then
                    For local5 = (local1 - local7) To local1 Step $01
                        maptemp(local8, local4, local5) = $01
                    Next
                    local2 = local4
                EndIf
            Next
            local0 = local2
            local1 = (local1 - local7)
        Until (local1 <= $03)
        local1 = (local1 - $01)
        debuglog((Str local1))
        maptemp(local8, local0, local1) = $01
        local11 = local8
        If (local11 = $00) Then
            mapname(local0, local1) = "exit1"
        EndIf
        local2 = $00
        local13 = 8.0
        local1 = (mapheight - $02)
        While (local1 >= $01)
            For local0 = $01 To (mapwidth - $02) Step $01
                If (maptemp(local8, local0, local1) > $00) Then
                    local2 = (((maptemp(local8, (local0 + $01), local1) + maptemp(local8, (local0 - $01), local1)) + maptemp(local8, local0, (local1 + $01))) + maptemp(local8, local0, (local1 - $01)))
                    Select local2
                        Case $01
                            If (((maproomid($01) < local9) And (mapname(local0, local1) = "")) <> 0) Then
                                If (maproom($01, maproomid($01)) <> "") Then
                                    mapname(local0, local1) = maproom($01, maproomid($01))
                                EndIf
                            EndIf
                            local12 = createroom(local8, $01, (Float (local0 Shl $03)), 0.0, (Float (local1 Shl $03)), mapname(local0, local1))
                            If (maptemp(local8, local0, (local1 + $01)) <> 0) Then
                                turnentity(local12\Field1, 0.0, 180.0, 0.0, $00)
                                local12\Field5 = $B4
                            ElseIf (maptemp(local8, (local0 - $01), local1) <> 0) Then
                                turnentity(local12\Field1, 0.0, -90.0, 0.0, $00)
                                local12\Field5 = $10E
                            ElseIf (maptemp(local8, (local0 + $01), local1) <> 0) Then
                                turnentity(local12\Field1, 0.0, 90.0, 0.0, $00)
                                local12\Field5 = $5A
                            EndIf
                            maproomid($01) = (maproomid($01) + $01)
                        Case $02
                            If ((maptemp(local8, (local0 - $01), local1) And maptemp(local8, (local0 + $01), local1)) <> 0) Then
                                If (((maproomid($02) < local9) And (mapname(local0, local1) = "")) <> 0) Then
                                    If (maproom($02, maproomid($02)) <> "") Then
                                        mapname(local0, local1) = maproom($02, maproomid($02))
                                    EndIf
                                EndIf
                                local12 = createroom(local8, $02, (Float (local0 Shl $03)), 0.0, (Float (local1 Shl $03)), mapname(local0, local1))
                                turnentity(local12\Field1, 0.0, 90.0, 0.0, $00)
                                local12\Field5 = $5A
                                maproomid($02) = (maproomid($02) + $01)
                            ElseIf ((maptemp(local8, local0, (local1 - $01)) And maptemp(local8, local0, (local1 + $01))) <> 0) Then
                                If (((maproomid($02) < local9) And (mapname(local0, local1) = "")) <> 0) Then
                                    If (maproom($02, maproomid($02)) <> "") Then
                                        mapname(local0, local1) = maproom($02, maproomid($02))
                                    EndIf
                                EndIf
                                local12 = createroom(local8, $02, (Float (local0 Shl $03)), 0.0, (Float (local1 Shl $03)), mapname(local0, local1))
                                maproomid($02) = (maproomid($02) + $01)
                            ElseIf ((maptemp(local8, (local0 - $01), local1) And maptemp(local8, local0, (local1 + $01))) <> 0) Then
                                If (((maproomid($03) < local9) And (mapname(local0, local1) = "")) <> 0) Then
                                    If (maproom($03, maproomid($03)) <> "") Then
                                        mapname(local0, local1) = maproom($03, maproomid($03))
                                    EndIf
                                EndIf
                                local12 = createroom(local8, $03, (Float (local0 Shl $03)), 0.0, (Float (local1 Shl $03)), mapname(local0, local1))
                                turnentity(local12\Field1, 0.0, 180.0, 0.0, $00)
                                local12\Field5 = $B4
                                maproomid($03) = (maproomid($03) + $01)
                            ElseIf ((maptemp(local8, (local0 + $01), local1) And maptemp(local8, local0, (local1 + $01))) <> 0) Then
                                If (((maproomid($03) < local9) And (mapname(local0, local1) = "")) <> 0) Then
                                    If (maproom($03, maproomid($03)) <> "") Then
                                        mapname(local0, local1) = maproom($03, maproomid($03))
                                    EndIf
                                EndIf
                                local12 = createroom(local8, $03, (Float (local0 Shl $03)), 0.0, (Float (local1 Shl $03)), mapname(local0, local1))
                                turnentity(local12\Field1, 0.0, 90.0, 0.0, $00)
                                local12\Field5 = $5A
                                maproomid($03) = (maproomid($03) + $01)
                            ElseIf ((maptemp(local8, (local0 - $01), local1) And maptemp(local8, local0, (local1 - $01))) <> 0) Then
                                If (((maproomid($03) < local9) And (mapname(local0, local1) = "")) <> 0) Then
                                    If (maproom($03, maproomid($03)) <> "") Then
                                        mapname(local0, local1) = maproom($03, maproomid($03))
                                    EndIf
                                EndIf
                                local12 = createroom(local8, $03, (Float (local0 Shl $03)), 0.0, (Float (local1 Shl $03)), mapname(local0, local1))
                                turnentity(local12\Field1, 0.0, 270.0, 0.0, $00)
                                local12\Field5 = $10E
                                maproomid($03) = (maproomid($03) + $01)
                            Else
                                If (((maproomid($03) < local9) And (mapname(local0, local1) = "")) <> 0) Then
                                    If (maproom($03, maproomid($03)) <> "") Then
                                        mapname(local0, local1) = maproom($03, maproomid($03))
                                    EndIf
                                EndIf
                                local12 = createroom(local8, $03, (Float (local0 Shl $03)), 0.0, (Float (local1 Shl $03)), mapname(local0, local1))
                                maproomid($03) = (maproomid($03) + $01)
                            EndIf
                        Case $03
                            If (((maproomid($04) < local9) And (mapname(local0, local1) = "")) <> 0) Then
                                If (maproom($04, maproomid($04)) <> "") Then
                                    mapname(local0, local1) = maproom($04, maproomid($04))
                                EndIf
                            EndIf
                            local12 = createroom(local8, $04, (Float (local0 Shl $03)), 0.0, (Float (local1 Shl $03)), mapname(local0, local1))
                            If (maptemp(local8, local0, (local1 - $01)) = $00) Then
                                turnentity(local12\Field1, 0.0, 180.0, 0.0, $00)
                                local12\Field5 = $B4
                            ElseIf (maptemp(local8, (local0 - $01), local1) = $00) Then
                                turnentity(local12\Field1, 0.0, 90.0, 0.0, $00)
                                local12\Field5 = $5A
                            ElseIf (maptemp(local8, (local0 + $01), local1) = $00) Then
                                turnentity(local12\Field1, 0.0, -90.0, 0.0, $00)
                                local12\Field5 = $10E
                            EndIf
                            maproomid($04) = (maproomid($04) + $01)
                        Case $04
                            If (((maproomid($05) < local9) And (mapname(local0, local1) = "")) <> 0) Then
                                If (maproom($05, maproomid($05)) <> "") Then
                                    mapname(local0, local1) = maproom($05, maproomid($05))
                                EndIf
                            EndIf
                            local12 = createroom(local8, $05, (Float (local0 Shl $03)), 0.0, (Float (local1 Shl $03)), mapname(local0, local1))
                            maproomid($05) = (maproomid($05) + $01)
                    End Select
                    If (ceil(((Float (local0 + local1)) / 2.0)) = floor(((Float (local0 + local1)) / 2.0))) Then
                        If (maptemp(local8, (local0 + $01), local1) <> 0) Then
                            createdoor(local12\Field0, (((Float local0) * local13) + (local13 / 2.0)), 0.0, ((Float local1) * local13), 90.0, (Int max((Float rand($FFFFFFFD, $01)), 0.0)), $00, $00, $00, "")
                        EndIf
                        If (maptemp(local8, (local0 - $01), local1) <> 0) Then
                            createdoor(local12\Field0, (((Float local0) * local13) - (local13 / 2.0)), 0.0, ((Float local1) * local13), 90.0, (Int max((Float rand($FFFFFFFD, $01)), 0.0)), $00, $00, $00, "")
                        EndIf
                        If (maptemp(local8, local0, (local1 + $01)) <> 0) Then
                            createdoor(local12\Field0, ((Float local0) * local13), 0.0, (((Float local1) * local13) + (local13 / 2.0)), 0.0, (Int max((Float rand($FFFFFFFD, $01)), 0.0)), $00, $00, $00, "")
                        EndIf
                        If (maptemp(local8, local0, (local1 - $01)) <> 0) Then
                            createdoor(local12\Field0, ((Float local0) * local13), 0.0, (((Float local1) * local13) - (local13 / 2.0)), 0.0, (Int max((Float rand($FFFFFFFD, $01)), 0.0)), $00, $00, $00, "")
                        EndIf
                    EndIf
                EndIf
            Next
            local1 = (local1 + $FFFFFFFF)
        Wend
    Next
    local0 = $02
    local1 = (mapheight - $02)
    local12 = createroom($00, $01, (Float (local0 Shl $03)), 0.0, (Float (local1 Shl $03)), "room173")
    maproomid($01) = (maproomid($01) + $01)
    local0 = (mapwidth - $02)
    local1 = (mapheight - $02)
    local12 = createroom($00, $01, (Float (local0 Shl $03)), 0.0, (Float (local1 Shl $03)), "pocketdimension")
    maproomid($01) = (maproomid($01) + $01)
    Return $00
End Function
