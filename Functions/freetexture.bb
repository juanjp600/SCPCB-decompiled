Function freetexture%(arg0%)
    If (arg0 <> $00) Then
        Return freetexture_(arg0, texturebuffer(arg0, $00))
    Else
        Return $00
    EndIf
    Return $00
End Function
