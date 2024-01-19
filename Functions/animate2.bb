Function animate2%(arg0%, arg1#, arg2%, arg3%, arg4#)
    setanimtime(arg0, ((arg4 * fpsfactor) + arg1), $00)
    If ((Float arg3) < animtime(arg0)) Then
        setanimtime(arg0, (Float arg2), $00)
    EndIf
    If ((Float arg2) > animtime(arg0)) Then
        setanimtime(arg0, (Float arg3), $00)
    EndIf
    Return $00
End Function
