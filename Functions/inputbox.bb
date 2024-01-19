Function inputbox$(arg0%, arg1%, arg2%, arg3%, arg4$, arg5%)
    Local local0%
    color($FF, $FF, $FF)
    rect(arg0, arg1, arg2, arg3, $01)
    color($00, $00, $00)
    rect((arg0 + $02), (arg1 + $02), (arg2 - $04), (arg3 - $04), $01)
    color($FF, $FF, $FF)
    text(((arg2 Sar $01) + arg0), ((arg3 Sar $01) + arg1), arg4, $01, $01)
    local0 = $00
    If (mouseon(arg0, arg1, arg2, arg3) <> 0) Then
        local0 = $01
        If (mousehit1 <> 0) Then
            selectedinputbox = arg5
            flushkeys()
        EndIf
    EndIf
    If ((((local0 = $00) And mousehit1) And (selectedinputbox = arg5)) <> 0) Then
        selectedinputbox = $00
    EndIf
    If (selectedinputbox = arg5) Then
        arg4 = rinput(arg4)
        If ((millisecs() Mod $320) < $190) Then
            rect(((((arg2 Sar $01) + arg0) + (stringwidth(arg4) Sar $01)) + $02), (((arg3 Sar $01) + arg1) - $05), $02, $0C, $01)
        EndIf
    EndIf
    Return arg4
    Return ""
End Function
