Function createmap%()
    Local local0%
    Local local1%
    Local local2%
    Local local3%
    Local local4%
    Local local5%
    Local local6%
    Local local7%
    Local local8$
    Local local9%
    Local local10%
    Local local11%
    Local local12%
    Local local13%
    Local local14%
    Local local15%
    Local local16%
    Local local17%
    Local local18%
    Local local19%
    Local local20%
    Local local21%
    Local local22.rooms
    Local local23#
    local8 = ""
    For local3 = $01 To len(randomseed) Step $01
        local8 = (local8 + (Str asc(mid(local8, local3, $01))))
    Next
    seedrnd((Abs (Int local8)))
    For local9 = $00 To $00 Step $01
        Dim mapname$(mapwidth, mapheight)
        local10 = $32
        Dim maproomid%($06)
        Dim maproom$($06, local10)
        local0 = (Int floor((Float (mapwidth Sar $01))))
        local1 = (mapheight - rand($04, $07))
        For local3 = local1 To (mapheight - $02) Step $01
            maptemp(local9, local0, local3) = $01
        Next
        Repeat
            local6 = rand($04, $0D)
            If ((local0 - local6) >= $02) Then
                If ((local0 + local6) > (mapwidth - $02)) Then
                    local6 = (- local6)
                Else
                    local0 = rand(((local0 - local6) + $01), local0)
                EndIf
            EndIf
            If ((local0 + local6) > (mapwidth - $02)) Then
                local6 = (local6 + ((mapwidth - $02) - (local0 + local6)))
            EndIf
            local0 = (Int min((Float local0), (Float (local0 + local6))))
            local6 = (Abs local6)
            For local3 = local0 To (local0 + local6) Step $01
                debuglog((((((Str local9) + ", ") + (Str local3)) + ", ") + (Str local1)))
                maptemp(local9, (Int min((Float local3), (Float mapwidth))), local1) = $01
            Next
            local7 = rand($03, $05)
            If ((local1 - local7) <= $02) Then
                local7 = (local1 - $01)
            EndIf
            local11 = rand($01, $04)
            For local3 = $01 To local11 Step $01
                local4 = (Int max(min((Float rand(local0, (local0 + local6))), (Float (mapwidth - $02))), 2.0))
                debuglog(((("aaa: " + (Str local4)) + ", ") + (Str local1)))
                If (((maptemp(local9, (local4 - $01), (local1 - $01)) = $00) And (maptemp(local9, (local4 + $01), (local1 - $01)) = $00)) <> 0) Then
                    If (local3 = $01) Then
                        local12 = local7
                    Else
                        local12 = (Int max((Float rand((local7 - rand($00, $02)), $01)), 1.0))
                    EndIf
                    debuglog((((Str local12) + " - ") + (Str local7)))
                    For local5 = (local1 - local12) To local1 Step $01
                        maptemp(local9, local4, local5) = $01
                        If (rand($02, $01) = $01) Then
                            If ((((((local4 > $02) And (local4 < (mapwidth - $02))) And (local5 > $02)) And (local5 < (mapheight - $02))) And (local5 < local1)) <> 0) Then
                                If (rand($02, $01) = $01) Then
                                    local13 = $FFFFFFFF
                                Else
                                    local13 = $01
                                EndIf
                                local14 = $01
                                For local15 = (Int min((Float ((local13 Shl $01) + local4)), (Float (local4 + local13)))) To (Int max((Float ((local13 Shl $01) + local4)), (Float (local4 + local13)))) Step $01
                                    For local16 = (local5 - $01) To (local5 + $01) Step $01
                                        If (maptemp(local9, local15, local16) = $01) Then
                                            local14 = $00
                                            Exit
                                        EndIf
                                    Next
                                    If (local14 = $00) Then
                                        Exit
                                    EndIf
                                Next
                                If (local14 <> 0) Then
                                    maptemp(local9, (local4 + local13), local5) = $01
                                EndIf
                            EndIf
                        EndIf
                    Next
                    If (local12 = local7) Then
                        local2 = local4
                    EndIf
                EndIf
            Next
            local0 = local2
            local1 = (local1 - local7)
        Until (local1 <= $02)
        local17 = $00
        local18 = $00
        local19 = $00
        local20 = $00
        local21 = $00
        For local1 = $01 To (mapheight - $01) Step $01
            For local0 = $01 To (mapwidth - $01) Step $01
                If (maptemp(local9, local0, local1) > $00) Then
                    local2 = $00
                    local2 = (Int ((min((Float maptemp(local9, (local0 + $01), local1)), 1.0) + (Float local2)) + min((Float maptemp(local9, (local0 - $01), local1)), 1.0)))
                    local2 = (Int ((min((Float maptemp(local9, local0, (local1 + $01))), 1.0) + (Float local2)) + min((Float maptemp(local9, local0, (local1 - $01))), 1.0)))
                    maptemp(local9, local0, local1) = local2
                    If (maptemp(local9, local0, local1) = $01) Then
                        local17 = (local17 + $01)
                    EndIf
                    If (maptemp(local9, local0, local1) = $02) Then
                        If (2.0 = (min((Float maptemp(local9, (local0 + $01), local1)), 1.0) + min((Float maptemp(local9, (local0 - $01), local1)), 1.0))) Then
                            local18 = (local18 + $01)
                        ElseIf (2.0 = (min((Float maptemp(local9, local0, (local1 + $01))), 1.0) + min((Float maptemp(local9, local0, (local1 - $01))), 1.0))) Then
                            local18 = (local18 + $01)
                        Else
                            local19 = (local19 + $01)
                        EndIf
                    EndIf
                    If (maptemp(local9, local0, local1) = $03) Then
                        local20 = (local20 + $01)
                    EndIf
                    If (maptemp(local9, local0, local1) = $04) Then
                        local21 = (local21 + $01)
                    EndIf
                EndIf
            Next
        Next
        local2 = ((- local17) + $09)
        If (local2 > $00) Then
            For local1 = $02 To (mapheight - $02) Step $01
                For local0 = $02 To (mapwidth - $02) Step $01
                    If (((maptemp(local9, local0, local1) = $00) And (rand($07, $01) = $01)) <> 0) Then
                        If (1.0 = (((min((Float maptemp(local9, (local0 + $01), local1)), 1.0) + min((Float maptemp(local9, (local0 - $01), local1)), 1.0)) + min((Float maptemp(local9, local0, (local1 + $01))), 1.0)) + min((Float maptemp(local9, local0, (local1 - $01))), 1.0))) Then
                            If ((((maptemp(local9, (local0 + $01), local1) + maptemp(local9, (local0 - $01), local1)) + maptemp(local9, local0, (local1 + $01))) + maptemp(local9, local0, (local1 - $01))) > $01) Then
                                maptemp(local9, local0, local1) = $01
                                local17 = (local17 + $01)
                                local2 = (local2 - $01)
                            EndIf
                        EndIf
                    EndIf
                    If (local2 = $00) Then
                        Exit
                    EndIf
                Next
                If (local2 = $00) Then
                    Exit
                EndIf
            Next
        EndIf
        debuglog((Str local17))
        debuglog((Str local18))
        debuglog((Str local19))
        debuglog((Str local20))
        debuglog((Str local21))
        maproom($01, (Int floor((0.15 * (Float local17))))) = "roompj"
        maproom($01, (Int floor((0.25 * (Float local17))))) = "914"
        maproom($01, (Int floor((0.4 * (Float local17))))) = "coffin"
        maproom($01, (Int floor((0.6 * (Float local17))))) = "room079"
        maproom($01, (Int floor((0.7 * (Float local17))))) = "room106"
        maproom($01, (local17 - $02)) = "exit1"
        maproom($01, (local17 - $01)) = "gateaentrance"
        maproom($01, $00) = "start"
        maproom($02, (Int floor((0.42 * (Float local18))))) = "room2offices2"
        maproom($02, (Int floor((rnd(0.1, 0.15) * (Float local18))))) = "room2offices"
        maproom($02, (Int floor((rnd(0.2, 0.25) * (Float local18))))) = "room2testroom2"
        maproom($02, (Int floor((rnd(0.3, 0.38) * (Float local18))))) = "room2sroom"
        maproom($02, (Int floor((rnd(0.45, 0.5) * (Float local18))))) = "room2tunnel"
        maproom($02, (Int (0.55 * (Float local18)))) = "room2scps"
        maproom($02, (Int floor((rnd(0.6, 0.65) * (Float local18))))) = "room2nuke"
        maproom($02, (Int floor((rnd(0.8, 0.86) * (Float local18))))) = "testroom"
        maproom($02, (Int floor((rnd(0.9, 0.95) * (Float local18))))) = "room2poffices"
        maproom($02, $00) = "room2closets"
        maproom($03, $00) = "lockroom"
        maproom($03, $01) = "room2ccont"
        maproom($03, $02) = "lockroom2"
        maproom($04, (Int floor((0.3 * (Float local20))))) = "room3servers"
        maproom($04, (Int floor((0.7 * (Float local20))))) = "room3servers2"
        For local1 = $00 To mapheight Step $01
            For local0 = $00 To mapwidth Step $01
                maptemp(local9, local0, local1) = (Int min((Float maptemp(local9, local0, local1)), 1.0))
            Next
        Next
        local2 = $00
        local23 = 8.0
        local1 = (mapheight - $02)
        While (local1 >= $01)
            For local0 = $01 To (mapwidth - $02) Step $01
                If (maptemp(local9, local0, local1) > $00) Then
                    local2 = (((maptemp(local9, (local0 + $01), local1) + maptemp(local9, (local0 - $01), local1)) + maptemp(local9, local0, (local1 + $01))) + maptemp(local9, local0, (local1 - $01)))
                    Select local2
                        Case $01
                            If (((maproomid($01) < local10) And (mapname(local0, local1) = "")) <> 0) Then
                                If (maproom($01, maproomid($01)) <> "") Then
                                    mapname(local0, local1) = maproom($01, maproomid($01))
                                EndIf
                            EndIf
                            local22 = createroom(local9, $01, (Float (local0 Shl $03)), 0.0, (Float (local1 Shl $03)), mapname(local0, local1))
                            If (maptemp(local9, local0, (local1 + $01)) <> 0) Then
                                local22\Field6 = $B4
                                turnentity(local22\Field2, 0.0, (Float local22\Field6), 0.0, $00)
                            ElseIf (maptemp(local9, (local0 - $01), local1) <> 0) Then
                                local22\Field6 = $10E
                                turnentity(local22\Field2, 0.0, (Float local22\Field6), 0.0, $00)
                            ElseIf (maptemp(local9, (local0 + $01), local1) <> 0) Then
                                local22\Field6 = $5A
                                turnentity(local22\Field2, 0.0, (Float local22\Field6), 0.0, $00)
                            Else
                                local22\Field6 = $00
                            EndIf
                            maproomid($01) = (maproomid($01) + $01)
                        Case $02
                            If ((maptemp(local9, (local0 - $01), local1) And maptemp(local9, (local0 + $01), local1)) <> 0) Then
                                If (((maproomid($02) < local10) And (mapname(local0, local1) = "")) <> 0) Then
                                    If (maproom($02, maproomid($02)) <> "") Then
                                        mapname(local0, local1) = maproom($02, maproomid($02))
                                    EndIf
                                EndIf
                                local22 = createroom(local9, $02, (Float (local0 Shl $03)), 0.0, (Float (local1 Shl $03)), mapname(local0, local1))
                                If (rand($02, $01) = $01) Then
                                    local22\Field6 = $5A
                                Else
                                    local22\Field6 = $10E
                                EndIf
                                turnentity(local22\Field2, 0.0, (Float local22\Field6), 0.0, $00)
                                maproomid($02) = (maproomid($02) + $01)
                            ElseIf ((maptemp(local9, local0, (local1 - $01)) And maptemp(local9, local0, (local1 + $01))) <> 0) Then
                                If (((maproomid($02) < local10) And (mapname(local0, local1) = "")) <> 0) Then
                                    If (maproom($02, maproomid($02)) <> "") Then
                                        mapname(local0, local1) = maproom($02, maproomid($02))
                                    EndIf
                                EndIf
                                local22 = createroom(local9, $02, (Float (local0 Shl $03)), 0.0, (Float (local1 Shl $03)), mapname(local0, local1))
                                If (rand($02, $01) = $01) Then
                                    local22\Field6 = $B4
                                Else
                                    local22\Field6 = $00
                                EndIf
                                turnentity(local22\Field2, 0.0, (Float local22\Field6), 0.0, $00)
                                maproomid($02) = (maproomid($02) + $01)
                            ElseIf ((maptemp(local9, (local0 - $01), local1) And maptemp(local9, local0, (local1 + $01))) <> 0) Then
                                If (((maproomid($03) < local10) And (mapname(local0, local1) = "")) <> 0) Then
                                    If (maproom($03, maproomid($03)) <> "") Then
                                        mapname(local0, local1) = maproom($03, maproomid($03))
                                    EndIf
                                EndIf
                                local22 = createroom(local9, $03, (Float (local0 Shl $03)), 0.0, (Float (local1 Shl $03)), mapname(local0, local1))
                                local22\Field6 = $B4
                                turnentity(local22\Field2, 0.0, (Float local22\Field6), 0.0, $00)
                                maproomid($03) = (maproomid($03) + $01)
                            ElseIf ((maptemp(local9, (local0 + $01), local1) And maptemp(local9, local0, (local1 + $01))) <> 0) Then
                                If (((maproomid($03) < local10) And (mapname(local0, local1) = "")) <> 0) Then
                                    If (maproom($03, maproomid($03)) <> "") Then
                                        mapname(local0, local1) = maproom($03, maproomid($03))
                                    EndIf
                                EndIf
                                local22 = createroom(local9, $03, (Float (local0 Shl $03)), 0.0, (Float (local1 Shl $03)), mapname(local0, local1))
                                local22\Field6 = $5A
                                turnentity(local22\Field2, 0.0, (Float local22\Field6), 0.0, $00)
                                maproomid($03) = (maproomid($03) + $01)
                            ElseIf ((maptemp(local9, (local0 - $01), local1) And maptemp(local9, local0, (local1 - $01))) <> 0) Then
                                If (((maproomid($03) < local10) And (mapname(local0, local1) = "")) <> 0) Then
                                    If (maproom($03, maproomid($03)) <> "") Then
                                        mapname(local0, local1) = maproom($03, maproomid($03))
                                    EndIf
                                EndIf
                                local22 = createroom(local9, $03, (Float (local0 Shl $03)), 0.0, (Float (local1 Shl $03)), mapname(local0, local1))
                                turnentity(local22\Field2, 0.0, 270.0, 0.0, $00)
                                local22\Field6 = $10E
                                maproomid($03) = (maproomid($03) + $01)
                            Else
                                If (((maproomid($03) < local10) And (mapname(local0, local1) = "")) <> 0) Then
                                    If (maproom($03, maproomid($03)) <> "") Then
                                        mapname(local0, local1) = maproom($03, maproomid($03))
                                    EndIf
                                EndIf
                                local22 = createroom(local9, $03, (Float (local0 Shl $03)), 0.0, (Float (local1 Shl $03)), mapname(local0, local1))
                                maproomid($03) = (maproomid($03) + $01)
                            EndIf
                        Case $03
                            If (((maproomid($04) < local10) And (mapname(local0, local1) = "")) <> 0) Then
                                If (maproom($04, maproomid($04)) <> "") Then
                                    mapname(local0, local1) = maproom($04, maproomid($04))
                                EndIf
                            EndIf
                            local22 = createroom(local9, $04, (Float (local0 Shl $03)), 0.0, (Float (local1 Shl $03)), mapname(local0, local1))
                            If (maptemp(local9, local0, (local1 - $01)) = $00) Then
                                turnentity(local22\Field2, 0.0, 180.0, 0.0, $00)
                                local22\Field6 = $B4
                            ElseIf (maptemp(local9, (local0 - $01), local1) = $00) Then
                                turnentity(local22\Field2, 0.0, 90.0, 0.0, $00)
                                local22\Field6 = $5A
                            ElseIf (maptemp(local9, (local0 + $01), local1) = $00) Then
                                turnentity(local22\Field2, 0.0, -90.0, 0.0, $00)
                                local22\Field6 = $10E
                            EndIf
                            maproomid($04) = (maproomid($04) + $01)
                        Case $04
                            If (((maproomid($05) < local10) And (mapname(local0, local1) = "")) <> 0) Then
                                If (maproom($05, maproomid($05)) <> "") Then
                                    mapname(local0, local1) = maproom($05, maproomid($05))
                                EndIf
                            EndIf
                            local22 = createroom(local9, $05, (Float (local0 Shl $03)), 0.0, (Float (local1 Shl $03)), mapname(local0, local1))
                            maproomid($05) = (maproomid($05) + $01)
                    End Select
                    If (ceil(((Float (local0 + local1)) / 2.0)) = floor(((Float (local0 + local1)) / 2.0))) Then
                        If (maptemp(local9, (local0 + $01), local1) <> 0) Then
                            createdoor(local22\Field0, (((Float local0) * local23) + (local23 / 2.0)), 0.0, ((Float local1) * local23), 90.0, Null, (Int max((Float rand($FFFFFFFD, $01)), 0.0)), $00, $00, "")
                        EndIf
                        If (maptemp(local9, (local0 - $01), local1) <> 0) Then
                            createdoor(local22\Field0, (((Float local0) * local23) - (local23 / 2.0)), 0.0, ((Float local1) * local23), 90.0, Null, (Int max((Float rand($FFFFFFFD, $01)), 0.0)), $00, $00, "")
                        EndIf
                        If (maptemp(local9, local0, (local1 + $01)) <> 0) Then
                            createdoor(local22\Field0, ((Float local0) * local23), 0.0, (((Float local1) * local23) + (local23 / 2.0)), 0.0, Null, (Int max((Float rand($FFFFFFFD, $01)), 0.0)), $00, $00, "")
                        EndIf
                        If (maptemp(local9, local0, (local1 - $01)) <> 0) Then
                            createdoor(local22\Field0, ((Float local0) * local23), 0.0, (((Float local1) * local23) - (local23 / 2.0)), 0.0, Null, (Int max((Float rand($FFFFFFFD, $01)), 0.0)), $00, $00, "")
                        EndIf
                    EndIf
                EndIf
            Next
            local1 = (local1 + $FFFFFFFF)
        Wend
    Next
    local0 = $02
    local1 = (mapheight - $02)
    local22 = createroom($00, $01, (Float (local0 Shl $03)), 0.0, (Float (local1 Shl $03)), "room173")
    maproomid($01) = (maproomid($01) + $01)
    local0 = (mapwidth - $02)
    local1 = (mapheight - $02)
    local22 = createroom($00, $01, (Float (local0 Shl $03)), 0.0, (Float (local1 Shl $03)), "pocketdimension")
    maproomid($01) = (maproomid($01) + $01)
    local22 = createroom($00, $01, 0.0, 0.0, (Float ((mapheight Sar $01) Shl $03)), "gatea")
    maproomid($01) = (maproomid($01) + $01)
    Return $00
End Function
