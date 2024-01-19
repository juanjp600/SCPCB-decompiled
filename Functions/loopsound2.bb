Function loopsound2%(arg0%, arg1%, arg2%, arg3%, arg4#, arg5#)
    Local local0#
    Local local1%
    Local local2#
    arg4 = max(arg4, 1.0)
    local0 = entitydistance(arg2, arg3)
    If (((0.0 < (1.0 - (local0 / arg4))) And (1.0 > (1.0 - (local0 / arg4)))) <> 0) Then
        local1 = createpivot($00)
        positionentity(local1, entityx(arg2, $00), entityy(arg2, $00), entityz(arg2, $00), $00)
        pointentity(local1, arg3, 0.0)
        local2 = sin((entityyaw(arg2, $00) - entityyaw(local1, $00)))
        If (arg1 = $00) Then
            arg1 = playsound(arg0)
        ElseIf (channelplaying(arg1) = $00) Then
            arg1 = playsound(arg0)
        EndIf
        channelvolume(arg1, ((1.0 - (local0 / arg4)) * arg5))
        channelpan(arg1, local2)
        freeentity(local1)
    EndIf
    Return arg1
    Return $00
End Function
