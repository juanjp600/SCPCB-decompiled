Function updaterooms%()
    Local local0.rooms
    Local local1%
    For local0 = Each rooms
        If (hidedistance <= distance(entityx(collider, $00), entityz(collider, $00), local0\Field1, local0\Field3)) Then
            hideentity(local0\Field0)
            For local1 = $00 To $13 Step $01
                If (local0\Field6[local1] <> $00) Then
                    hideentity(local0\Field6[local1])
                EndIf
            Next
        Else
            showentity(local0\Field0)
            For local1 = $00 To $13 Step $01
                If (local0\Field6[local1] <> $00) Then
                    showentity(local0\Field6[local1])
                EndIf
            Next
        EndIf
    Next
    Return $00
End Function
