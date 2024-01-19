Function updaterooms%()
    Local local0.rooms
    Local local1#
    Local local2%
    templightvolume = 0.0
    For local0 = Each rooms
        local1 = distance(entityx(collider, $00), entityz(collider, $00), local0\Field2, local0\Field4)
        If (((hidedistance <= local1) And (playerroom <> local0)) <> 0) Then
            hideentity(local0\Field1)
            For local2 = $00 To $13 Step $01
                If (local0\Field7[local2] <> $00) Then
                    hideentity(local0\Field7[local2])
                EndIf
            Next
        Else
            showentity(local0\Field1)
            For local2 = $00 To $13 Step $01
                If (local0\Field7[local2] <> $00) Then
                    local1 = entitydistance(collider, local0\Field7[local2])
                    templightvolume = (((local0\Field8[local2] * local0\Field8[local2]) * ((hidedistance - local1) / hidedistance)) + templightvolume)
                    showentity(local0\Field7[local2])
                EndIf
            Next
        EndIf
    Next
    templightvolume = max((templightvolume / 5.0), 0.8)
    Return $00
End Function
