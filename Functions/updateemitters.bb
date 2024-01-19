Function updateemitters%()
    Local local0.emitters
    Local local1.particles
    Local local2#
    insmoke = $00
    For local0 = Each emitters
        If (((0.0 < fpsfactor) And (playerroom = local0\Field7)) <> 0) Then
            If (6.0 > entitydistance(camera, local0\Field0)) Then
                local1 = createparticle(entityx(local0\Field0, $01), entityy(local0\Field0, $01), entityz(local0\Field0, $01), rand(local0\Field2, local0\Field3), local0\Field1, local0\Field4, local0\Field5)
                local1\Field8 = local0\Field9
                rotateentity(local1\Field1, entitypitch(local0\Field0, $01), entityyaw(local0\Field0, $01), entityroll(local0\Field0, $01), $01)
                turnentity(local1\Field1, rnd((- local0\Field10), local0\Field10), rnd((- local0\Field10), local0\Field10), 0.0, $00)
                local1\Field15 = local0\Field11
                local0\Field8 = loopsound2(hisssfx, local0\Field8, camera, local0\Field0, 10.0, 1.0)
                If (wearinggasmask = $00) Then
                    local2 = distance(entityx(camera, $01), entityz(camera, $01), entityx(local0\Field0, $01), entityz(local0\Field0, $01))
                    If (0.8 > local2) Then
                        insmoke = $01
                    EndIf
                EndIf
            EndIf
        EndIf
    Next
    If (insmoke <> 0) Then
        If (420.0 < eyeirritation) Then
            blurvolume = max(blurvolume, ((eyeirritation - 420.0) / 1680.0))
        EndIf
        If (1680.0 < eyeirritation) Then
            kill()
        EndIf
        If (rand($96, $01) = $01) Then
            If (coughchn = $00) Then
                coughchn = playsound(coughsfx(rand($00, $02)))
            ElseIf (channelplaying(coughchn) = $00) Then
                coughchn = playsound(coughsfx(rand($00, $02)))
            EndIf
        EndIf
        eyeirritation = ((fpsfactor * 4.0) + eyeirritation)
    EndIf
    Return $00
End Function
