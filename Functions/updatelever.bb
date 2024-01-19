Function updatelever%(arg0%, arg1%)
    Local local0#
    Local local1#
    local0 = entitydistance(camera, arg0)
    If (8.0 > local0) Then
        If (((0.45 > local0) And (arg1 = $00)) <> 0) Then
            If (entityinview(arg0, camera) <> 0) Then
                entitypick(camera, 0.45)
                If (pickedentity() = arg0) Then
                    drawhandicon = $01
                    If (mousehit1 <> 0) Then
                        grabbedentity = arg0
                    EndIf
                EndIf
                local1 = entitypitch(arg0, $00)
                If ((mousedown1 Or mousehit1) <> 0) Then
                    If (grabbedentity <> $00) Then
                        If (grabbedentity = arg0) Then
                            drawhandicon = $01
                            rotateentity(grabbedentity, max(min((entitypitch(arg0, $00) + min((mouse_y_speed_1 * 4.0), 5.0)), 82.0), -82.0), entityyaw(arg0, $00), 0.0, $00)
                            drawarrowicon($00) = $01
                            drawarrowicon($02) = $01
                        EndIf
                    EndIf
                EndIf
                If (80.0 < entitypitch(arg0, $01)) Then
                    If (80.0 >= local1) Then
                        playsound2(leversfx, camera, arg0, 3.0, 1.0)
                    EndIf
                ElseIf (-80.0 > entitypitch(arg0, $01)) Then
                    If (-80.0 <= local1) Then
                        playsound2(leversfx, camera, arg0, 3.0, 1.0)
                    EndIf
                EndIf
            EndIf
        EndIf
        If (((mousedown1 = $00) And (mousehit1 = $00)) <> 0) Then
            If (0.0 < entitypitch(arg0, $01)) Then
                rotateentity(arg0, curvevalue(82.0, entitypitch(arg0, $00), 10.0), entityyaw(arg0, $00), 0.0, $00)
            Else
                rotateentity(arg0, curvevalue(-82.0, entitypitch(arg0, $00), 10.0), entityyaw(arg0, $00), 0.0, $00)
            EndIf
            grabbedentity = $00
        EndIf
        If (0.0 < entitypitch(arg0, $01)) Then
            Return $01
        Else
            Return $00
        EndIf
    EndIf
    Return $00
End Function
