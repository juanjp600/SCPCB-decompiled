Function initloadgame%()
    Local local0.doors
    Local local1.securitycams
    Local local2.roomtemplates
    drawloading($50, $00)
    For local0 = Each doors
        entityparent(local0\Field0, $00, $01)
        If (local0\Field1 > $00) Then
            entityparent(local0\Field1, $00, $01)
        EndIf
        If (local0\Field2 > $00) Then
            entityparent(local0\Field2, $00, $01)
        EndIf
        If (local0\Field3[$00] > $00) Then
            entityparent(local0\Field3[$00], $00, $01)
        EndIf
        If (local0\Field3[$01] > $00) Then
            entityparent(local0\Field3[$01], $00, $01)
        EndIf
        If (local0\Field1 <> $00) Then
            positionentity(local0\Field0, entityx(local0\Field2, $01), entityy(local0\Field2, $01), entityz(local0\Field2, $01), $00)
            moveentity(local0\Field0, 0.0, 0.0, (8.0 * roomscale))
            positionentity(local0\Field1, entityx(local0\Field2, $01), entityy(local0\Field2, $01), entityz(local0\Field2, $01), $00)
            moveentity(local0\Field1, 0.0, 0.0, (8.0 * roomscale))
        EndIf
    Next
    For local1 = Each securitycams
        local1\Field11 = (entityyaw(local1\Field0, $00) + local1\Field11)
        entityparent(local1\Field0, $00, $01)
    Next
    resetentity(collider)
    initevents()
    drawloading($5A, $00)
    movemouse($140, $F0)
    setfont(font1)
    hidepointer()
    blinktimer = 560.0
    stamina = 100.0
    For local2 = Each roomtemplates
        If (local2\Field0 <> $00) Then
            freeentity(local2\Field0)
            local2\Field0 = $00
        EndIf
    Next
    dropspeed = 0.01
    drawloading($64, $00)
    prevtime = millisecs()
    fpsfactor = 0.0
    Return $00
End Function
