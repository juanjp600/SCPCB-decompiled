Function animate2%(arg0%, arg1#, arg2%, arg3%, arg4#, arg5%)
    If (0.0 < arg4) Then
        If (arg5 <> 0) Then
            setanimtime(arg0, max(min(((arg4 * fpsfactor) + arg1), (Float arg3)), (Float arg2)), $00)
            If ((Float arg3) <= animtime(arg0)) Then
                setanimtime(arg0, (Float arg2), $00)
            EndIf
        Else
            setanimtime(arg0, max(min(((arg4 * fpsfactor) + arg1), (Float arg3)), (Float arg2)), $00)
        EndIf
    ElseIf (arg5 <> 0) Then
        setanimtime(arg0, ((arg4 * fpsfactor) + arg1), $00)
        If ((Float arg3) > animtime(arg0)) Then
            setanimtime(arg0, (Float arg2), $00)
        EndIf
        If ((Float arg2) < animtime(arg0)) Then
            setanimtime(arg0, (Float arg3), $00)
        EndIf
    Else
        setanimtime(arg0, max(min(((arg4 * fpsfactor) + arg1), (Float arg2)), (Float arg3)), $00)
    EndIf
    Return $00
End Function
