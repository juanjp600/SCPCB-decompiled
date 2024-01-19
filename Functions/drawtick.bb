Function drawtick%(arg0%, arg1%, arg2%)
    Local local0%
    Local local1%
    local0 = (Int (20.0 * menuscale))
    local1 = (Int (20.0 * menuscale))
    color($FF, $FF, $FF)
    rect(arg0, arg1, local0, local1, $01)
    If (mouseon(arg0, arg1, local0, local1) <> 0) Then
        color($1E, $1E, $1E)
        If (mousehit1 <> 0) Then
            arg2 = (arg2 = $00)
        EndIf
    Else
        color($00, $00, $00)
    EndIf
    rect((Int ((3.0 * menuscale) + (Float arg0))), (Int ((3.0 * menuscale) + (Float arg1))), (Int ((Float local0) - (6.0 * menuscale))), (Int ((Float local1) - (6.0 * menuscale))), $01)
    If (arg2 <> 0) Then
        color($FF, $FF, $FF)
        rect((Int ((7.0 * menuscale) + (Float arg0))), (Int ((7.0 * menuscale) + (Float arg1))), (Int ((Float local0) - (14.0 * menuscale))), (Int ((Float local1) - (14.0 * menuscale))), $01)
    EndIf
    Return arg2
    Return $00
End Function
