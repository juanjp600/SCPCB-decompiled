Function drawtick%(arg0%, arg1%, arg2%, arg3%)
    Local local0%
    Local local1%
    Local local2%
    local0 = (Int (20.0 * menuscale))
    local1 = (Int (20.0 * menuscale))
    color($FF, $FF, $FF)
    rect(arg0, arg1, local0, local1, $01)
    local2 = (mouseon(arg0, arg1, local0, local1) And (arg3 = $00))
    If (local2 <> 0) Then
        color($32, $32, $32)
        If (mousehit1 <> 0) Then
            arg2 = (arg2 = $00)
            playsound(buttonsfx)
        EndIf
    Else
        color($00, $00, $00)
    EndIf
    rect((arg0 + $02), (arg1 + $02), (local0 - $04), (local1 - $04), $01)
    If (arg2 <> 0) Then
        If (local2 <> 0) Then
            color($FF, $FF, $FF)
        Else
            color($C8, $C8, $C8)
        EndIf
        rect((arg0 + $06), (arg1 + $06), (local0 - $0C), (local1 - $0C), $01)
    EndIf
    color($FF, $FF, $FF)
    Return arg2
    Return $00
End Function
