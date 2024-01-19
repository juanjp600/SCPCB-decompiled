Function removeitem%(arg0.items)
    Local local0%
    freeentity(arg0\Field0)
    arg0\Field0 = $00
    For local0 = $00 To $09 Step $01
        If (inventory(local0) = arg0) Then
            inventory(local0) = Null
        EndIf
    Next
    If (selecteditem = arg0) Then
        If (((selecteditem\Field1\Field1 = "gasmask") Or (selecteditem\Field1\Field1 = "supergasmask")) <> 0) Then
            wearinggasmask = $00
        EndIf
        selecteditem = Null
    EndIf
    Delete arg0
    Return $00
End Function
