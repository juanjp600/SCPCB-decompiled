Function drawbutton%(arg0%, arg1%, arg2%, arg3%, arg4$, arg5%)
    Local local0%
    local0 = $00
    drawframe(arg0, arg1, arg2, arg3)
    If (mouseon(arg0, arg1, arg2, arg3) <> 0) Then
        color($1E, $1E, $1E)
        If (mousehit1 <> 0) Then
            local0 = $01
            playsound(buttonsfx)
        EndIf
    Else
        color($00, $00, $00)
    EndIf
    rect((arg0 + $04), (arg1 + $04), (arg2 - $08), (arg3 - $08), $01)
    color($FF, $FF, $FF)
    If (arg5 <> 0) Then
        setfont(font2)
    Else
        setfont(font1)
    EndIf
    text(((arg2 Sar $01) + arg0), ((arg3 Sar $01) + arg1), arg4, $01, $01)
    Return local0
    Return $00
End Function
