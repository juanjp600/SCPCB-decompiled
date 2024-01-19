Function playsound2%(arg0%, arg1%, arg2%, arg3#, arg4#)
    Local local0%
    Local local1#
    Local local2%
    Local local3#
    arg3 = max(arg3, 1.0)
    local0 = $00
    local1 = entitydistance(arg1, arg2)
    If (((0.0 < (1.0 - (local1 / arg3))) And (1.0 > (1.0 - (local1 / arg3)))) <> 0) Then
        local2 = createpivot($00)
        positionentity(local2, entityx(arg1, $00), entityy(arg1, $00), entityz(arg1, $00), $00)
        pointentity(local2, arg2, 0.0)
        local3 = sin((entityyaw(arg1, $00) - entityyaw(local2, $00)))
        local0 = playsound(arg0)
        channelvolume(local0, ((1.0 - (local1 / arg3)) * arg4))
        channelpan(local0, local3)
        freeentity(local2)
    EndIf
    Return local0
    Return $00
End Function
