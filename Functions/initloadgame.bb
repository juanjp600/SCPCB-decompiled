Function initloadgame%()
    Local local0.doors
    Local local1.securitycams
    Local local2.roomtemplates
    drawloading($3C)
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
            moveentity(local0\Field0, 0.0, 0.0, (8.0 * roomscale))
            moveentity(local0\Field1, 0.0, 0.0, (8.0 * roomscale))
        EndIf
    Next
    burntnote = loadimage("GFX\items\bn.it")
    setbuffer(imagebuffer(burntnote, $00))
    cls($01, $01)
    color($00, $00, $00)
    text($115, $1D5, accesscode, $01, $01)
    color($FF, $FF, $FF)
    setbuffer(backbuffer())
    drawloading($41)
    For local1 = Each securitycams
        local1\Field11 = (entityyaw(local1\Field0, $00) + local1\Field11)
        entityparent(local1\Field0, $00, $01)
    Next
    resetentity(collider)
    initevents()
    drawloading($46)
    movemouse($140, $F0)
    setfont(font1)
    drawloading($50)
    hidepointer()
    blinktimer = 560.0
    stamina = 100.0
    For local2 = Each roomtemplates
        freeentity(local2\Field0)
    Next
    prevtime = millisecs()
    drawloading($64)
    Return $00
End Function
