Function updateparticles%()
    Local local0.particles
    For local0 = Each particles
        moveentity(local0\Field1, 0.0, 0.0, (local0\Field8 * fpsfactor))
        local0\Field9 = (local0\Field9 - (local0\Field10 * fpsfactor))
        translateentity(local0\Field1, 0.0, local0\Field9, 0.0, $01)
        positionentity(local0\Field0, entityx(local0\Field1, $00), entityy(local0\Field1, $00), entityz(local0\Field1, $00), $01)
        local0\Field16 = (local0\Field16 - fpsfactor)
        turnentity(local0\Field0, 0.0, 0.0, fpsfactor, $00)
        scalesprite(local0\Field0, local0\Field7, local0\Field7)
        local0\Field7 = ((local0\Field15 * fpsfactor) + local0\Field7)
        If (((0.0 >= local0\Field16) Or (0.00001 > local0\Field7)) <> 0) Then
            removeparticle(local0)
        EndIf
    Next
    Return $00
End Function
