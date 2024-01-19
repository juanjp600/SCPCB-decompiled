Function drawtiledimagerect%(arg0%, arg1%, arg2%, arg3#, arg4#, arg5%, arg6%, arg7%, arg8%)
    Local local0%
    Local local1%
    local0 = arg5
    While (local0 < (arg5 + arg7))
        local1 = arg6
        While (local1 < (arg6 + arg8))
            If ((Float (arg5 + arg7)) < ((Float local0) + arg3)) Then
                arg3 = (arg3 - max((((Float local0) + arg3) - (Float (arg5 + arg7))), 1.0))
            EndIf
            If ((Float (arg6 + arg8)) < ((Float local1) + arg4)) Then
                arg4 = (arg4 - max((((Float local1) + arg4) - (Float (arg6 + arg8))), 1.0))
            EndIf
            drawimagerect(arg0, local0, local1, arg1, arg2, (Int arg3), (Int arg4), $00)
            local1 = (Int ((Float local1) + arg4))
        Wend
        local0 = (Int ((Float local0) + arg3))
    Wend
    Return $00
End Function
