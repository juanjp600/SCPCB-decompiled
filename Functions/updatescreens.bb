Function updatescreens%()
    Local local0.screens
    If (selectedscreen <> Null) Then
        Return $00
    EndIf
    If (selecteddoor <> Null) Then
        Return $00
    EndIf
    For local0 = Each screens
        If (local0\Field3 = playerroom) Then
            If (1.2 > entitydistance(collider, local0\Field0)) Then
                entitypick(camera, 1.2)
                If (pickedentity() = local0\Field0) Then
                    drawhandicon = $01
                    If (mouseup1 <> 0) Then
                        selectedscreen = local0
                        debuglog(local0\Field1)
                        local0\Field2 = loadimage(("GFX\screens\" + local0\Field1))
                        maskimage(local0\Field2, $FF, $00, $FF)
                        playsound(buttonsfx)
                        mouseup1 = $00
                    EndIf
                EndIf
            EndIf
        EndIf
    Next
    Return $00
End Function
