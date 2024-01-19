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
        Select selecteditem\Field1\Field1
            Case "gasmask","supergasmask"
                wearinggasmask = $00
            Case "vest","finevest"
                wearingvest = $00
            Case "scp714"
                wearing714 = $00
        End Select
        selecteditem = Null
    EndIf
    Delete arg0
    Return $00
End Function
