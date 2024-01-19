Function shoot%(arg0#, arg1#, arg2#, arg3#, arg4#, arg5#, arg6%)
    Local local0%
    Local local1.particles
    Local local2%
    Local local3.decals
    local0 = createpivot($00)
    positionentity(local0, arg0, arg1, arg2, $00)
    rotateentity(local0, arg3, arg4, 0.0, $01)
    entitypick(local0, arg5)
    local1 = createparticle(arg0, arg1, arg2, $01, 0.2, 0.0, $05)
    turnentity(local1\Field0, 0.0, 0.0, rnd(360.0, 0.0), $00)
    local1\Field14 = -0.15
    If (pickedentity() = collider) Then
        turnentity(camera, rnd(-3.0, 3.0), rnd(-3.0, 3.0), 0.0, $00)
        kill()
        playsound(bullethitsfx)
    ElseIf (pickedentity() <> $00) Then
        positionentity(local0, pickedx(), pickedy(), pickedz(), $00)
        playsound2(gunshot3sfx, camera, local0, 0.4, rnd(0.8, 1.0), $01)
        If (arg6 <> 0) Then
            local1 = createparticle(pickedx(), pickedy(), pickedz(), $00, 0.03, 0.0, $50)
            local1\Field8 = 0.001
            local1\Field15 = 0.003
            local1\Field6 = 0.8
            local1\Field14 = -0.01
            rotateentity(local1\Field1, (entitypitch(local0, $00) - 180.0), entityyaw(local0, $00), 0.0, $00)
            For local2 = $00 To rand($02, $04) Step $01
                local1 = createparticle(pickedx(), pickedy(), pickedz(), $00, 0.006, 0.003, $50)
                local1\Field8 = 0.02
                local1\Field6 = 0.8
                local1\Field14 = -0.01
                rotateentity(local1\Field1, (entitypitch(local0, $00) + rnd(170.0, 190.0)), (entityyaw(local0, $00) + rnd(-10.0, 10.0)), 0.0, $00)
            Next
            local3 = createdecal(rand($0D, $0E), pickedx(), pickedy(), pickedz(), 0.0, 0.0, 0.0)
            aligntovector(local3\Field0, (- pickednx()), (- pickedny()), (- pickednz()), $03, 1.0)
            moveentity(local3\Field0, 0.0, 0.0, -0.001)
            entityfx(local3\Field0, $01)
            local3\Field9 = 1400.0
            entityblend(local3\Field0, $02)
            local3\Field2 = rnd(0.028, 0.034)
            scalesprite(local3\Field0, local3\Field2, local3\Field2)
        EndIf
    EndIf
    freeentity(local0)
    Return $00
End Function
