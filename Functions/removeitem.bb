Function removeitem%(arg0.items)
    Local local0%
    freeentity(arg0\Field0)
    arg0\Field0 = $00
    If (arg0\Field1 <> $00) Then
        freeimage(arg0\Field1)
        arg0\Field1 = $00
    EndIf
    If (arg0\Field2 <> $00) Then
        freeimage(arg0\Field2)
        arg0\Field2 = $00
    EndIf
    For local0 = $00 To $04 Step $01
        If (inventory(local0) = arg0) Then
            inventory(local0) = Null
        EndIf
    Next
    If (selecteditem = arg0) Then
        If (selecteditem\Field10 = "gasmask") Then
            wearinggasmask = $00
        EndIf
        selecteditem = Null
    EndIf
    Delete arg0
    Return $00
End Function
