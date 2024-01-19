Function updaterooms%()
    Local local0#
    Local local1%
    Local local2.rooms
    Local local3%
    Local local4%
    templightvolume = 0.0
    For local2 = Each rooms
        local3 = $00
        If (playerroom = local2) Then
            local2\Field1 = $01
        ElseIf (hidedistance < (Abs (entityx(collider, $00) - local2\Field3))) Then
            local3 = $01
        ElseIf (hidedistance < (Abs (entityz(collider, $00) - local2\Field5))) Then
            local3 = $01
        Else
            local0 = distance(entityx(collider, $00), entityz(collider, $00), local2\Field3, local2\Field5)
            If (hidedistance < local0) Then
                local3 = $01
            EndIf
        EndIf
        If (local3 = $01) Then
            hideentity(local2\Field2)
            For local4 = $00 To $13 Step $01
                If (local2\Field8[local4] <> $00) Then
                    hideentity(local2\Field8[local4])
                EndIf
            Next
        Else
            showentity(local2\Field2)
            For local4 = $00 To $13 Step $01
                If (local2\Field8[local4] <> $00) Then
                    local0 = entitydistance(collider, local2\Field8[local4])
                    templightvolume = (((local2\Field9[local4] * local2\Field9[local4]) * ((hidedistance - local0) / hidedistance)) + templightvolume)
                    showentity(local2\Field8[local4])
                EndIf
            Next
        EndIf
    Next
    templightvolume = max((templightvolume / 5.0), 0.8)
    Return $00
End Function
