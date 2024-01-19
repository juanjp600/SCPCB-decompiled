Function initwaypoints%()
    Local local0#
    Local local1.doors
    Local local2.rooms
    Local local3.rooms
    Local local4#
    Local local5.waypoints
    Local local6.waypoints
    Local local7%
    Return $00
    For local1 = Each doors
        If (local1\Field0 <> $00) Then
            hideentity(local1\Field0)
        EndIf
        If (local1\Field1 <> $00) Then
            hideentity(local1\Field1)
        EndIf
        If (local1\Field2 <> $00) Then
            hideentity(local1\Field2)
        EndIf
        local2 = Null
        local0 = 16.0
        For local3 = Each rooms
            local4 = entitydistance(local3\Field1, local1\Field2)
            If (local0 > local4) Then
                local2 = local3
                local0 = local4
            EndIf
        Next
        createwaypoint(entityx(local1\Field2, $01), (entityy(local1\Field2, $01) + 0.15), entityz(local1\Field2, $01), local1, local2)
    Next
    For local5 = Each waypoints
        For local6 = Each waypoints
            If (local5 <> local6) Then
                local0 = entitydistance(local6\Field0, local5\Field0)
                If (6.0 > local0) Then
                    If (entityvisible(local5\Field0, local6\Field0) <> 0) Then
                        For local7 = $00 To $04 Step $01
                            If (local5\Field4[local7] = Null) Then
                                local5\Field4[local7] = local6
                                local5\Field5[local7] = local0
                                Exit
                            EndIf
                        Next
                    EndIf
                EndIf
            EndIf
        Next
    Next
    For local1 = Each doors
        If (local1\Field0 <> $00) Then
            showentity(local1\Field0)
        EndIf
        If (local1\Field1 <> $00) Then
            showentity(local1\Field1)
        EndIf
        If (local1\Field2 <> $00) Then
            showentity(local1\Field2)
        EndIf
    Next
    Return $00
End Function
