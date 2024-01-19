Function removenpc%(arg0.npcs)
    freeentity(arg0\Field0)
    arg0\Field0 = $00
    freeentity(arg0\Field2)
    arg0\Field2 = $00
    If (arg0\Field1 <> $00) Then
        freeentity(arg0\Field1)
        arg0\Field1 = $00
    EndIf
    Delete arg0
    Return $00
End Function
