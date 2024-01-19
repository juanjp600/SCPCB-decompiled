Function limittext%(arg0$, arg1%, arg2%, arg3%)
    Local local0%
    Local local1%
    Local local2%
    If (((arg0 = "") Or (arg3 = $00)) <> 0) Then
        Return $00
    EndIf
    local0 = stringwidth(arg0)
    local1 = (local0 - arg3)
    If (local1 <= $00) Then
        text(arg1, arg2, arg0, $00, $00)
    Else
        local2 = (local0 / len(arg0))
        text(arg1, arg2, (left(arg0, (Int max((Float ((len(arg0) - (local1 / local2)) - $04)), 1.0))) + "..."), $00, $00)
    EndIf
    Return $00
End Function
