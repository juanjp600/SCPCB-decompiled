Function initwaypoints%(arg0%)
    Local local0.doors
    Local local1.waypoints
    Local local2.waypoints
    Local local3.rooms
    Local local4.rooms
    Local local5%
    Local local6#
    Local local7#
    Local local8#
    Local local9#
    Local local10#
    Local local11%
    Local local12%
    Local local13%
    Local local14#
    Local local15%
    Local local16%
    Local local17%
    Local local18%
    Local local19%
    local5 = millisecs()
    For local0 = Each doors
        If (local0\Field0 <> $00) Then
            hideentity(local0\Field0)
        EndIf
        If (local0\Field1 <> $00) Then
            hideentity(local0\Field1)
        EndIf
        If (local0\Field2 <> $00) Then
            hideentity(local0\Field2)
        EndIf
        If (local0\Field13 = Null) Then
            local4 = Null
            local6 = 400.0
            For local3 = Each rooms
                local8 = (Abs (entityx(local3\Field2, $01) - entityx(local0\Field2, $01)))
                If (20.0 > local8) Then
                    local9 = (Abs (entityz(local3\Field2, $01) - entityz(local0\Field2, $01)))
                    If (20.0 > local9) Then
                        local7 = ((local8 * local8) + (local9 * local9))
                        If (local6 > local7) Then
                            local4 = local3
                            local6 = local7
                        EndIf
                    EndIf
                EndIf
            Next
        Else
            local4 = local0\Field13
        EndIf
        If (local0\Field14 = $00) Then
            createwaypoint(entityx(local0\Field2, $01), (entityy(local0\Field2, $01) + 0.18), entityz(local0\Field2, $01), local0, local4)
        EndIf
    Next
    local10 = 0.0
    For local1 = Each waypoints
        entitypickmode(local1\Field0, $01, $01)
        entityradius(local1\Field0, 0.15, 0.0)
        local10 = (local10 + 1.0)
    Next
    local11 = createpivot($00)
    local12 = $00
    local13 = $00
    For local1 = Each waypoints
        local12 = (local12 + $01)
        local13 = (local13 + $01)
        If (local13 = $14) Then
            drawloading((Int (floor(((19.0 / local10) * (Float local12))) + (Float arg0))), $00)
            local13 = $00
        EndIf
        local2 = (After local1)
        While (local2 <> Null)
            local8 = (Abs (entityx(local1\Field0, $01) - entityx(local2\Field0, $01)))
            If (6.0 > local8) Then
                local9 = (Abs (entityz(local1\Field0, $01) - entityz(local2\Field0, $01)))
                If (6.0 > local9) Then
                    local14 = (Abs (entityy(local1\Field0, $01) - entityy(local2\Field0, $01)))
                    If (6.0 > local14) Then
                        local6 = (((local8 * local8) + (local14 * local14)) + (local9 * local9))
                        local15 = $00
                        If (36.0 > local6) Then
                            local6 = sqr(local6)
                            positionentity(local11, entityx(local1\Field0, $01), entityy(local1\Field0, $01), entityz(local1\Field0, $01), $00)
                            pointentity(local11, local2\Field0, 0.0)
                            If (entitypick(local11, 6.0) = local2\Field0) Then
                                local16 = $00
                                For local17 = $00 To $04 Step $01
                                    If (local1\Field4[local17] = Null) Then
                                        local16 = $01
                                        local1\Field4[local17] = local2
                                        local1\Field5[local17] = local6
                                        Exit
                                    EndIf
                                Next
                                local16 = $00
                                For local18 = $00 To $04 Step $01
                                    If (local2\Field4[local18] = Null) Then
                                        local16 = $01
                                        local2\Field4[local18] = local1
                                        local2\Field5[local18] = local6
                                        Exit
                                    EndIf
                                Next
                            EndIf
                        EndIf
                    EndIf
                EndIf
            EndIf
            local2 = (After local2)
        Wend
    Next
    freeentity(local11)
    For local0 = Each doors
        If (local0\Field0 <> $00) Then
            showentity(local0\Field0)
        EndIf
        If (local0\Field1 <> $00) Then
            showentity(local0\Field1)
        EndIf
        If (local0\Field2 <> $00) Then
            showentity(local0\Field2)
        EndIf
    Next
    For local1 = Each waypoints
        entitypickmode(local1\Field0, $00, $00)
        entityradius(local1\Field0, 0.0, 0.0)
        For local17 = $00 To $04 Step $01
            If (local1\Field4[local17] <> Null) Then
                local19 = createline(entityx(local1\Field0, $01), entityy(local1\Field0, $01), entityz(local1\Field0, $01), entityx(local1\Field4[local17]\Field0, $01), entityy(local1\Field4[local17]\Field0, $01), entityz(local1\Field4[local17]\Field0, $01), $00)
                entitycolor(local19, 255.0, 0.0, 0.0)
                entityparent(local19, local1\Field0, $01)
            EndIf
        Next
    Next
    debuglog(("InitWaypoints() - " + (Str (millisecs() - local5))))
    Return $00
End Function
