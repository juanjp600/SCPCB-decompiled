Function updateparticles%()
    Local local0.particles
    For local0 = Each particles
        moveentity(local0\Field1, 0.0, 0.0, (local0\Field8 * fpsfactor))
        If (0.0 <> local0\Field10) Then
            local0\Field9 = (local0\Field9 - (local0\Field10 * fpsfactor))
        EndIf
        translateentity(local0\Field1, 0.0, local0\Field9, 0.0, $01)
        positionentity(local0\Field0, entityx(local0\Field1, $01), entityy(local0\Field1, $01), entityz(local0\Field1, $01), $01)
        local0\Field16 = (local0\Field16 - fpsfactor)
        turnentity(local0\Field0, 0.0, 0.0, fpsfactor, $00)
        entityalpha(local0\Field0, local0\Field6)
        scalesprite(local0\Field0, local0\Field7, local0\Field7)
        local0\Field6 = min(max(((local0\Field14 * fpsfactor) + local0\Field6), 0.0), 1.0)
        local0\Field7 = ((local0\Field15 * fpsfactor) + local0\Field7)
        If ((((0.0 >= local0\Field16) Or (0.00001 > local0\Field7)) Or (0.0 >= local0\Field6)) <> 0) Then
            removeparticle(local0)
        EndIf
    Next
    Return $00
End Function
