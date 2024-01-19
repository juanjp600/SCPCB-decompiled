Function updateelevators#(arg0#, arg1.doors, arg2.doors, arg3%, arg4%, arg5.events)
    Local local0%
    If (((arg1\Field5 = $01) And (arg2\Field5 = $00)) <> 0) Then
        arg0 = -1.0
        If ((((closestbutton = arg2\Field3[$00]) Or (closestbutton = arg2\Field3[$01])) And mousehit1) <> 0) Then
            usedoor(arg1)
        EndIf
    ElseIf (((arg2\Field5 = $01) And (arg1\Field5 = $00)) <> 0) Then
        arg0 = 1.0
        If ((((closestbutton = arg1\Field3[$00]) Or (closestbutton = arg1\Field3[$01])) And mousehit1) <> 0) Then
            usedoor(arg2)
        EndIf
    EndIf
    debuglog((((((Str arg0) + " - ") + (Str arg1\Field5)) + ", ") + (Str arg2\Field5)))
    local0 = $00
    If (((arg1\Field5 = $00) And (arg2\Field5 = $00)) <> 0) Then
        debuglog("bim")
        arg1\Field4 = $01
        arg2\Field4 = $01
        If (0.0 > arg0) Then
            arg0 = (arg0 - fpsfactor)
            If ((280.0 * roomscale) > (Abs (entityx(collider, $00) - entityx(arg3, $01)))) Then
                If ((280.0 * roomscale) > (Abs (entityz(collider, $00) - entityz(arg3, $01)))) Then
                    local0 = $01
                    If (arg5\Field5 = $00) Then
                        arg5\Field5 = playsound(elevatormovesfx)
                    ElseIf (channelplaying(arg5\Field5) = $00) Then
                        arg5\Field5 = playsound(elevatormovesfx)
                    EndIf
                    camerashake = (sin((arg0 / 3.0)) * 0.3)
                EndIf
            EndIf
            If (-400.0 > arg0) Then
                arg1\Field4 = $00
                arg2\Field4 = $00
                arg0 = 0.0
                usedoor(arg2)
                If (local0 <> 0) Then
                    positionentity(collider, ((entityx(collider, $00) - entityx(arg3, $01)) + entityx(arg4, $01)), ((entityy(collider, $00) - entityy(arg3, $01)) + (entityy(arg4, $01) + 0.05)), ((entityz(collider, $00) - entityz(arg3, $01)) + entityz(arg4, $01)), $01)
                    resetentity(collider)
                EndIf
                playsound2(elevatorbeepsfx, camera, arg3, 4.0, 1.0)
            EndIf
        Else
            arg0 = (arg0 + fpsfactor)
            If ((280.0 * roomscale) > (Abs (entityx(collider, $00) - entityx(arg4, $01)))) Then
                If ((280.0 * roomscale) > (Abs (entityz(collider, $00) - entityz(arg4, $01)))) Then
                    local0 = $01
                    If (arg5\Field5 = $00) Then
                        arg5\Field5 = playsound(elevatormovesfx)
                    ElseIf (channelplaying(arg5\Field5) = $00) Then
                        arg5\Field5 = playsound(elevatormovesfx)
                    EndIf
                    camerashake = (sin((arg0 / 3.0)) * 0.3)
                EndIf
            EndIf
            If (400.0 < arg0) Then
                arg1\Field4 = $00
                arg2\Field4 = $00
                arg0 = 0.0
                usedoor(arg1)
                If (local0 <> 0) Then
                    positionentity(collider, ((entityx(collider, $00) - entityx(arg4, $01)) + entityx(arg3, $01)), ((entityy(collider, $00) - entityy(arg4, $01)) + (entityy(arg3, $01) + 0.05)), ((entityz(collider, $00) - entityz(arg4, $01)) + entityz(arg3, $01)), $01)
                    resetentity(collider)
                EndIf
                playsound2(elevatorbeepsfx, camera, arg4, 4.0, 1.0)
            EndIf
        EndIf
    EndIf
    Return arg0
    Return 0.0
End Function
