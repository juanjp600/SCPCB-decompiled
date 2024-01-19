Function initwaypoints%(arg0%)
    Local local0%
    Local local1#
    Local local2.doors
    Local local3.rooms
    Local local4.rooms
    Local local5#
    Local local6#
    Local local7.waypoints
    Local local8%
    Local local9%
    Local local10.waypoints
    Local local11%
    Local local12%
    Local local13%
    Local local14%
    Local local15%
    local0 = millisecs()
    For local2 = Each doors
        If (local2\Field0 <> $00) Then
            hideentity(local2\Field0)
        EndIf
        If (local2\Field1 <> $00) Then
            hideentity(local2\Field1)
        EndIf
        If (local2\Field2 <> $00) Then
            hideentity(local2\Field2)
        EndIf
        If (local2\Field12 = Null) Then
            local3 = Null
            local1 = 20.0
            For local4 = Each rooms
                local5 = distance(entityx(local4\Field2, $01), entityz(local4\Field2, $01), entityx(local2\Field2, $01), entityz(local2\Field2, $01))
                If (local1 > local5) Then
                    local3 = local4
                    local1 = local5
                EndIf
            Next
        Else
            local3 = local2\Field12
        EndIf
        createwaypoint(entityx(local2\Field2, $01), (entityy(local2\Field2, $01) + 0.18), entityz(local2\Field2, $01), local2, local3)
    Next
    local6 = 0.0
    For local7 = Each waypoints
        entitypickmode(local7\Field0, $01, $01)
        entityradius(local7\Field0, 0.15, 0.0)
        local6 = (local6 + 1.0)
    Next
    local8 = $00
    For local7 = Each waypoints
        local8 = (local8 + $01)
        If ((local8 Mod $0A) = $01) Then
            drawloading((Int (floor(((19.0 / local6) * (Float local8))) + (Float arg0))), $00)
            debuglog(("aaaaaaaaaaaaaaa: " + (Str local8)))
        EndIf
        local9 = createpivot($00)
        local10 = (After local7)
        While (local10 <> Null)
            If (6.0 > (Abs (entityx(local7\Field0, $01) - entityx(local10\Field0, $01)))) Then
                If (6.0 > (Abs (entityz(local7\Field0, $01) - entityz(local10\Field0, $01)))) Then
                    If (6.0 > (Abs (entityy(local7\Field0, $01) - entityy(local10\Field0, $01)))) Then
                        local1 = entitydistance(local10\Field0, local7\Field0)
                        local5 = 0.0
                        local11 = $00
                        If (6.0 > local1) Then
                            positionentity(local9, entityx(local7\Field0, $01), entityy(local7\Field0, $01), entityz(local7\Field0, $01), $00)
                            pointentity(local9, local10\Field0, 0.0)
                            If (entitypick(local9, 6.0) = local10\Field0) Then
                                local12 = $00
                                For local13 = $00 To $04 Step $01
                                    If (local7\Field4[local13] = Null) Then
                                        local12 = $01
                                        local7\Field4[local13] = local10
                                        local7\Field5[local13] = local1
                                        Exit
                                    EndIf
                                Next
                                If (((local12 = $00) And $00) <> 0) Then
                                    local5 = local1
                                    local11 = $00
                                    For local13 = $00 To $04 Step $01
                                        If (local5 < local7\Field5[local13]) Then
                                            local11 = local13
                                            local5 = local7\Field5[local13]
                                        EndIf
                                    Next
                                    If (local5 > local1) Then
                                        local7\Field4[local11] = local10
                                        local7\Field5[local11] = local1
                                    EndIf
                                EndIf
                                local12 = $00
                                For local14 = $00 To $04 Step $01
                                    If (local10\Field4[local14] = Null) Then
                                        local12 = $01
                                        local10\Field4[local14] = local7
                                        local10\Field5[local14] = local1
                                        Exit
                                    EndIf
                                Next
                                If (((local12 = $00) And $00) <> 0) Then
                                    local5 = local1
                                    local11 = $00
                                    For local13 = $00 To $04 Step $01
                                        If (local5 < local10\Field5[local13]) Then
                                            local11 = local13
                                            local5 = local10\Field5[local13]
                                        EndIf
                                    Next
                                    If (local5 > local1) Then
                                        local10\Field4[local11] = local7
                                        local10\Field5[local11] = local1
                                    EndIf
                                EndIf
                            EndIf
                        EndIf
                    EndIf
                EndIf
            EndIf
            local10 = (After local10)
        Wend
        freeentity(local9)
    Next
    For local2 = Each doors
        If (local2\Field0 <> $00) Then
            showentity(local2\Field0)
        EndIf
        If (local2\Field1 <> $00) Then
            showentity(local2\Field1)
        EndIf
        If (local2\Field2 <> $00) Then
            showentity(local2\Field2)
        EndIf
    Next
    For local7 = Each waypoints
        entitypickmode(local7\Field0, $00, $00)
        entityradius(local7\Field0, 0.0, 0.0)
        For local13 = $00 To $04 Step $01
            If (local7\Field4[local13] <> Null) Then
                local15 = createline(entityx(local7\Field0, $01), entityy(local7\Field0, $01), entityz(local7\Field0, $01), entityx(local7\Field4[local13]\Field0, $01), entityy(local7\Field4[local13]\Field0, $01), entityz(local7\Field4[local13]\Field0, $01), $00)
                entitycolor(local15, 255.0, 0.0, 0.0)
                entityparent(local15, local7\Field0, $01)
            EndIf
        Next
    Next
    debuglog(("InitWaypoints() - " + (Str (millisecs() - local0))))
    Return $00
End Function
