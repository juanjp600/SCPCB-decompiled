Function mouseon%(arg0%, arg1%, arg2%, arg3%)
    If (((mousex() > arg0) And (mousex() < (arg0 + arg2))) <> 0) Then
        If (((mousey() > arg1) And (mousey() < (arg1 + arg3))) <> 0) Then
            Return $01
        EndIf
    EndIf
    Return $00
    Return $00
End Function
