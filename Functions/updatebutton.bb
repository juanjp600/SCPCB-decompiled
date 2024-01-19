Function updatebutton%(arg0%)
    Local local0#
    Local local1%
    local0 = distance(entityx(collider, $01), entityz(collider, $01), entityx(arg0, $01), entityz(arg0, $01))
    If (0.7 > local0) Then
        local1 = createpivot($00)
        positionentity(local1, entityx(camera, $00), entityy(camera, $00), entityz(camera, $00), $00)
        pointentity(local1, arg0, 0.0)
        If (entitypick(local1, 0.45) = arg0) Then
            If (closestbutton = $00) Then
                closestbutton = arg0
            ElseIf (local0 < entitydistance(collider, closestbutton)) Then
                closestbutton = arg0
            EndIf
        EndIf
        freeentity(local1)
    EndIf
    Return $00
End Function
