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
    Local local9.rooms
    Local local10#
    Dim mapname$(mapwidth, mapheight)
    local8 = $32
    Dim maproomid%($06)
    Dim maproom$($06, local8)
    maproom($01, $00) = "start"
    maproom($01, $01) = "coffin"
    maproom($01, $02) = "914"
    maproom($02, $00) = "room2closets"
    maproom($02, rand($06, $0A)) = "room2sroom"
    maproom($02, rand($0B, $0F)) = "room2testroom2"
    maproom($02, rand($10, $14)) = "testroom"
    maproom($03, $00) = "lockroom"
    maproom($03, rand($01, $02)) = "room2ccont"
    local0 = (Int floor((Float (mapwidth Sar $01))))
    local1 = (mapheight - rand($04, $07))
    For local3 = local1 To (mapheight - $02) Step $01
        maptemp(local0, local3) = $01
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
            maptemp(local3, local1) = $01
        Next
        local7 = rand($03, $05)
        If ((local1 - local7) < $01) Then
            local7 = (local1 - $01)
        EndIf
        For local3 = $01 To rand($03, $01) Step $01
            local4 = rand(local0, (local0 + local6))
            debuglog((((Str local4) + ", ") + (Str local1)))
            If (((maptemp((local4 - $01), (local1 - $01)) = $00) And (maptemp((local4 + $01), (local1 - $01)) = $00)) <> 0) Then
                For local5 = (local1 - local7) To local1 Step $01
                    maptemp(local4, local5) = $01
                Next
                local2 = local4
            EndIf
        Next
        local0 = local2
        local1 = (local1 - local7)
    Until (local1 <= $01)
    local2 = $00
    local10 = 8.0
    local1 = (mapheight - $02)
    While (local1 >= $01)
        For local0 = $01 To (mapwidth - $02) Step $01
            If (maptemp(local0, local1) > $00) Then
                local2 = (((maptemp((local0 + $01), local1) + maptemp((local0 - $01), local1)) + maptemp(local0, (local1 + $01))) + maptemp(local0, (local1 - $01)))
                Select local2
                    Case $01
                        If (maproomid($01) < local8) Then
                            If (maproom($01, maproomid($01)) <> "") Then
                                mapname(local0, local1) = maproom($01, maproomid($01))
                            EndIf
                        EndIf
                        local9 = createroom($01, (Float (local0 Shl $03)), 0.0, (Float (local1 Shl $03)), mapname(local0, local1))
                        If (maptemp(local0, (local1 + $01)) <> 0) Then
                            turnentity(local9\Field0, 0.0, 180.0, 0.0, $00)
                            local9\Field4 = $B4
                        ElseIf (maptemp((local0 - $01), local1) <> 0) Then
                            turnentity(local9\Field0, 0.0, -90.0, 0.0, $00)
                            local9\Field4 = $10E
                        ElseIf (maptemp((local0 + $01), local1) <> 0) Then
                            turnentity(local9\Field0, 0.0, 90.0, 0.0, $00)
                            local9\Field4 = $5A
                        EndIf
                        maproomid($01) = (maproomid($01) + $01)
                    Case $02
                        If ((maptemp((local0 - $01), local1) And maptemp((local0 + $01), local1)) <> 0) Then
                            If (maproomid($02) < local8) Then
                                If (maproom($02, maproomid($02)) <> "") Then
                                    mapname(local0, local1) = maproom($02, maproomid($02))
                                EndIf
                            EndIf
                            local9 = createroom($02, (Float (local0 Shl $03)), 0.0, (Float (local1 Shl $03)), mapname(local0, local1))
                            turnentity(local9\Field0, 0.0, 90.0, 0.0, $00)
                            local9\Field4 = $5A
                            maproomid($02) = (maproomid($02) + $01)
                        ElseIf ((maptemp(local0, (local1 - $01)) And maptemp(local0, (local1 + $01))) <> 0) Then
                            If (maproomid($02) < local8) Then
                                If (maproom($02, maproomid($02)) <> "") Then
                                    mapname(local0, local1) = maproom($02, maproomid($02))
                                EndIf
                            EndIf
                            local9 = createroom($02, (Float (local0 Shl $03)), 0.0, (Float (local1 Shl $03)), mapname(local0, local1))
                            maproomid($02) = (maproomid($02) + $01)
                        ElseIf ((maptemp((local0 - $01), local1) And maptemp(local0, (local1 + $01))) <> 0) Then
                            If (maproomid($03) < local8) Then
                                If (maproom($03, maproomid($03)) <> "") Then
                                    mapname(local0, local1) = maproom($03, maproomid($03))
                                EndIf
                            EndIf
                            local9 = createroom($03, (Float (local0 Shl $03)), 0.0, (Float (local1 Shl $03)), mapname(local0, local1))
                            turnentity(local9\Field0, 0.0, 180.0, 0.0, $00)
                            local9\Field4 = $B4
                            maproomid($03) = (maproomid($03) + $01)
                        ElseIf ((maptemp((local0 + $01), local1) And maptemp(local0, (local1 + $01))) <> 0) Then
                            If (maproomid($03) < local8) Then
                                If (maproom($03, maproomid($03)) <> "") Then
                                    mapname(local0, local1) = maproom($03, maproomid($03))
                                EndIf
                            EndIf
                            local9 = createroom($03, (Float (local0 Shl $03)), 0.0, (Float (local1 Shl $03)), mapname(local0, local1))
                            turnentity(local9\Field0, 0.0, 90.0, 0.0, $00)
                            local9\Field4 = $5A
                            maproomid($03) = (maproomid($03) + $01)
                        ElseIf ((maptemp((local0 - $01), local1) And maptemp(local0, (local1 - $01))) <> 0) Then
                            If (maproomid($03) < local8) Then
                                If (maproom($03, maproomid($03)) <> "") Then
                                    mapname(local0, local1) = maproom($03, maproomid($03))
                                EndIf
                            EndIf
                            local9 = createroom($03, (Float (local0 Shl $03)), 0.0, (Float (local1 Shl $03)), mapname(local0, local1))
                            turnentity(local9\Field0, 0.0, 270.0, 0.0, $00)
                            local9\Field4 = $10E
                            maproomid($03) = (maproomid($03) + $01)
                        Else
                            If (maproomid($03) < local8) Then
                                If (maproom($03, maproomid($03)) <> "") Then
                                    mapname(local0, local1) = maproom($03, maproomid($03))
                                EndIf
                            EndIf
                            local9 = createroom($03, (Float (local0 Shl $03)), 0.0, (Float (local1 Shl $03)), mapname(local0, local1))
                            maproomid($03) = (maproomid($03) + $01)
                        EndIf
                    Case $03
                        If (maproomid($04) < local8) Then
                            If (maproom($04, maproomid($04)) <> "") Then
                                mapname(local0, local1) = maproom($04, maproomid($04))
                            EndIf
                        EndIf
                        local9 = createroom($04, (Float (local0 Shl $03)), 0.0, (Float (local1 Shl $03)), mapname(local0, local1))
                        If (maptemp(local0, (local1 - $01)) = $00) Then
                            turnentity(local9\Field0, 0.0, 180.0, 0.0, $00)
                            local9\Field4 = $B4
                        ElseIf (maptemp((local0 - $01), local1) = $00) Then
                            turnentity(local9\Field0, 0.0, 90.0, 0.0, $00)
                            local9\Field4 = $5A
                        ElseIf (maptemp((local0 + $01), local1) = $00) Then
                            turnentity(local9\Field0, 0.0, -90.0, 0.0, $00)
                            local9\Field4 = $10E
                        EndIf
                        maproomid($04) = (maproomid($04) + $01)
                    Case $04
                        If (maproomid($05) < local8) Then
                            If (maproom($05, maproomid($05)) <> "") Then
                                mapname(local0, local1) = maproom($05, maproomid($05))
                            EndIf
                        EndIf
                        local9 = createroom($05, (Float (local0 Shl $03)), 0.0, (Float (local1 Shl $03)), mapname(local0, local1))
                        maproomid($05) = (maproomid($05) + $01)
                End Select
                If (ceil(((Float (local0 + local1)) / 2.0)) = floor(((Float (local0 + local1)) / 2.0))) Then
                    If (maptemp((local0 + $01), local1) <> 0) Then
                        createdoor((((Float local0) * local10) + (local10 / 2.0)), 0.0, ((Float local1) * local10), 90.0, (Int max((Float rand($FFFFFFFD, $01)), 0.0)), $00, $00, $00)
                    EndIf
                    If (maptemp((local0 - $01), local1) <> 0) Then
                        createdoor((((Float local0) * local10) - (local10 / 2.0)), 0.0, ((Float local1) * local10), 90.0, (Int max((Float rand($FFFFFFFD, $01)), 0.0)), $00, $00, $00)
                    EndIf
                    If (maptemp(local0, (local1 + $01)) <> 0) Then
                        createdoor(((Float local0) * local10), 0.0, (((Float local1) * local10) + (local10 / 2.0)), 0.0, (Int max((Float rand($FFFFFFFD, $01)), 0.0)), $00, $00, $00)
                    EndIf
                    If (maptemp(local0, (local1 - $01)) <> 0) Then
                        createdoor(((Float local0) * local10), 0.0, (((Float local1) * local10) - (local10 / 2.0)), 0.0, (Int max((Float rand($FFFFFFFD, $01)), 0.0)), $00, $00, $00)
                    EndIf
                EndIf
            EndIf
        Next
        local1 = (local1 + $FFFFFFFF)
    Wend
    local0 = $02
    local1 = (mapheight - $02)
    local9 = createroom($01, (Float (local0 Shl $03)), 0.0, (Float (local1 Shl $03)), "room173")
    maproomid($01) = (maproomid($01) + $01)
    local0 = (mapwidth - $02)
    local1 = (mapheight - $02)
    local9 = createroom($01, (Float (local0 Shl $03)), 0.0, (Float (local1 Shl $03)), "pocketdimension")
    maproomid($01) = (maproomid($01) + $01)
    Return $00
End Function
