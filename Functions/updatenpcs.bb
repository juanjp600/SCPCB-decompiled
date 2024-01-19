Function updatenpcs%()
    Local local0#
    Local local1.npcs
    Local local3%
    Local local4#
    Local local5.doors
    Local local6%
    Local local7%
    Local local8.decals
    Local local9.rooms
    Local local11.particles
    Local local12#
    Local local13%
    For local1 = Each npcs
        Select local1\Field3
            Case $01
                positionentity(local1\Field0, entityx(local1\Field2, $00), (entityy(local1\Field2, $00) - 0.32), entityz(local1\Field2, $00), $00)
                rotateentity(local1\Field0, 0.0, entityyaw(local1\Field2, $00), 0.0, $00)
                local3 = $00
                local0 = entitydistance(local1\Field2, collider)
                If (((8.0 > local0) And entityvisible(local1\Field2, collider)) <> 0) Then
                    local3 = $01
                    local1\Field19 = entityx(collider, $01)
                    local1\Field20 = entityy(collider, $01)
                    local1\Field21 = entityz(collider, $01)
                EndIf
                If (local1\Field12 = $00) Then
                    local4 = max(min((distance(entityx(local1\Field2, $00), entityz(local1\Field2, $00), local1\Field16, local1\Field18) * 2.5), 1.0), 0.0)
                    local1\Field9 = loopsound2(stonedragsfx, local1\Field9, camera, local1\Field2, 10.0, local1\Field6)
                    local1\Field16 = entityx(local1\Field2, $00)
                    local1\Field18 = entityz(local1\Field2, $00)
                    If ((entityinview(local1\Field0, camera) And ((-6.0 < blinktimer) Or (-16.0 > blinktimer))) <> 0) Then
                        blurvolume = max(max(min(((4.0 - local0) / 6.0), 0.9), 0.1), blurvolume)
                        If (local3 <> 0) Then
                            If (((3.5 > local0) And ((millisecs() - local1\Field14) > $EA60)) <> 0) Then
                                playsound(horrorsfx($03))
                                local1\Field14 = millisecs()
                            EndIf
                        EndIf
                        If (((1.5 > local0) And (rand($2BC, $01) = $01)) <> 0) Then
                            playsound2(scp173sfx(rand($00, $02)), camera, local1\Field0, 10.0, 1.0)
                        EndIf
                        If (((1.5 > local0) And (2.0 < local1\Field15)) <> 0) Then
                            playsound(horrorsfx($02))
                        EndIf
                        local1\Field15 = local0
                        local1\Field6 = max(0.0, (local1\Field6 - (fpsfactor / 20.0)))
                    Else
                        local1\Field6 = curvevalue(local4, local1\Field6, 3.0)
                        If (rand($0F, $01) = $01) Then
                            For local5 = Each doors
                                If ((local5\Field4 And (local5\Field5 = $00)) = $00) Then
                                    For local6 = $00 To $01 Step $01
                                        If (local5\Field3[local6] <> $00) Then
                                            If (((0.5 > (Abs (entityx(local1\Field2, $00) - entityx(local5\Field3[local6], $00)))) And (0.5 > (Abs (entityz(local1\Field2, $00) - entityz(local5\Field3[local6], $00))))) <> 0) Then
                                                If (((180.0 <= local5\Field7) Or (0.0 >= local5\Field7)) <> 0) Then
                                                    local3 = createpivot($00)
                                                    positionentity(local3, entityx(local1\Field2, $00), (entityy(local1\Field2, $00) + 0.5), entityz(local1\Field2, $00), $00)
                                                    pointentity(local3, local5\Field3[local6], 0.0)
                                                    moveentity(local3, 0.0, 0.0, (local1\Field11 * 0.6))
                                                    If (entitypick(local3, 0.5) = local5\Field3[local6]) Then
                                                        usedoor(local5)
                                                    EndIf
                                                    freeentity(local3)
                                                EndIf
                                            EndIf
                                        EndIf
                                    Next
                                EndIf
                            Next
                        ElseIf (rand($0F, $01) = $01) Then
                        EndIf
                        If (local3 <> 0) Then
                            If (0.65 > local0) Then
                                If (((0.0 <= killtimer) And (godmode = $00)) <> 0) Then
                                    If (godmode = $00) Then
                                        local1\Field12 = $01
                                    EndIf
                                    If (rand($02, $01) = $01) Then
                                        turnentity(camera, 0.0, 120.0, 0.0, $00)
                                    Else
                                        turnentity(camera, 0.0, -120.0, 0.0, $00)
                                    EndIf
                                    playsound(damagesfx(rand($00, $01)))
                                EndIf
                                kill()
                            Else
                                pointentity(local1\Field2, collider, 0.0)
                                rotateentity(local1\Field2, 0.0, entityyaw(local1\Field2, $00), entityroll(local1\Field2, $00), $00)
                                moveentity(local1\Field2, 0.0, 0.0, (local1\Field11 * fpsfactor))
                            EndIf
                        ElseIf (0.0 <> local1\Field19) Then
                            If (0.2 < distance(entityx(local1\Field2, $00), entityz(local1\Field2, $00), local1\Field19, local1\Field21)) Then
                                local7 = createpivot($00)
                                positionentity(local7, local1\Field19, local1\Field20, local1\Field21, $01)
                                pointentity(local1\Field2, local7, 0.0)
                                rotateentity(local1\Field2, 0.0, entityyaw(local1\Field2, $00), entityroll(local1\Field2, $00), $00)
                                moveentity(local1\Field2, 0.0, 0.0, (local1\Field11 * fpsfactor))
                                freeentity(local7)
                                If (rand($1E, $01) = $01) Then
                                    local1\Field19 = 0.0
                                    local1\Field20 = 0.0
                                    local1\Field21 = 0.0
                                EndIf
                            Else
                                local1\Field19 = 0.0
                                local1\Field20 = 0.0
                                local1\Field21 = 0.0
                            EndIf
                        Else
                            moveentity(local1\Field2, 0.0, 0.0, ((local1\Field11 * 0.8) * fpsfactor))
                            turnentity(local1\Field2, 0.0, 1.0, 0.0, $00)
                        EndIf
                    EndIf
                EndIf
            Case $02
                local0 = entitydistance(local1\Field2, collider)
                If (local1\Field12 = $00) Then
                    If (0.0 >= local1\Field6) Then
                        If (((entityy(collider, $00) - 20.0) - 0.55) > entityy(local1\Field2, $00)) Then
                            If (playerroom\Field5\Field7 = $00) Then
                                local8 = createdecal($00, entityx(collider, $00), 0.01, entityz(collider, $00), 90.0, (Float rand($168, $01)), 0.0)
                                local8\Field2 = 0.05
                                local8\Field1 = 0.001
                                entityalpha(local8\Field0, 0.8)
                                updatedecals()
                            EndIf
                            positionentity(local1\Field2, entityx(collider, $00), (entityy(collider, $00) - 15.0), entityz(collider, $00), $00)
                            playsound(horrorsfx($05))
                            playsound(decaysfx($00))
                        EndIf
                        If (rand($1F4, $01) = $01) Then
                            playsound2(oldmansfx(rand($00, $02)), camera, local1\Field2, 10.0, 1.0)
                        EndIf
                        local1\Field9 = loopsound2(oldmansfx($04), local1\Field9, camera, local1\Field2, 8.0, 0.8)
                        If (-10.0 < local1\Field6) Then
                            shouldplay = $42
                            If (0.05 < (Abs ((entityy(collider, $00) - 0.35) - entityy(local1\Field2, $00)))) Then
                                translateentity(local1\Field2, 0.0, (((entityy(collider, $00) - 0.35) - entityy(local1\Field2, $00)) / 100.0), 0.0, $00)
                                animate2(local1\Field0, animtime(local1\Field0), $CE, $FA, 0.3)
                            Else
                                local1\Field6 = -10.0
                            EndIf
                        Else
                            shouldplay = $01
                            translateentity(local1\Field2, 0.0, (((entityy(collider, $00) - 0.15) - entityy(local1\Field2, $00)) / 50.0), 0.0, $00)
                            If (entityinview(local1\Field2, camera) <> 0) Then
                                blurvolume = max(max(min(((4.0 - local0) / 6.0), 0.9), 0.1), blurvolume)
                                If ((millisecs() - local1\Field14) > $EA60) Then
                                    playsound(horrorsfx($06))
                                    local1\Field14 = millisecs()
                                EndIf
                            ElseIf (entityvisible(local1\Field2, collider) = $00) Then
                                local1\Field6 = (local1\Field6 - fpsfactor)
                            EndIf
                            pointentity(local1\Field0, collider, 0.0)
                            rotateentity(local1\Field2, 0.0, curveangle(entityyaw(local1\Field0, $00), entityyaw(local1\Field2, $00), 10.0), 0.0, $00)
                            If (0.7 < local0) Then
                                If (0.0 <= killtimer) Then
                                    moveentity(local1\Field2, 0.0, 0.0, (local1\Field11 * fpsfactor))
                                    animate2(local1\Field0, animtime(local1\Field0), $00, $0E, 0.15)
                                EndIf
                            Else
                                animate2(local1\Field0, animtime(local1\Field0), $20, $2C, 0.45)
                                If (43.0 = floor(animtime(local1\Field0))) Then
                                    setanimtime(local1\Field0, 43.0, $00)
                                EndIf
                                If (0.0 <= killtimer) Then
                                    If (36.0 = floor(animtime(local1\Field0))) Then
                                        If (playerroom\Field5\Field4 = "pocketdimension") Then
                                            playsound(deathsfx($01))
                                            kill()
                                        Else
                                            For local9 = Each rooms
                                                If (local9\Field5\Field4 = "pocketdimension") Then
                                                    playsound(use914sfx)
                                                    playsound(oldmansfx($05))
                                                    positionentity(collider, entityx(local9\Field0, $00), 0.5, entityz(local9\Field0, $00), $00)
                                                    resetentity(collider)
                                                    local1\Field6 = -2000.0
                                                    blinktimer = -10.0
                                                    Exit
                                                EndIf
                                            Next
                                        EndIf
                                    EndIf
                                EndIf
                            EndIf
                        EndIf
                        local1\Field4 = 0.0
                        If (local1\Field6 <= (Float rand($FFFFF9C0, $FFFFFAEC))) Then
                            local1\Field6 = (Float rand($55F0, $6978))
                        EndIf
                    Else
                        moveentity(local1\Field2, 0.0, (((entityy(collider, $00) - 30.0) - entityy(local1\Field2, $00)) / 200.0), 0.0)
                        local1\Field4 = 0.0
                        If (playerroom\Field5\Field7 = $00) Then
                            local1\Field6 = (local1\Field6 - fpsfactor)
                        EndIf
                    EndIf
                EndIf
                resetentity(local1\Field2)
                positionentity(local1\Field0, entityx(local1\Field2, $00), (entityy(local1\Field2, $00) - 0.15), entityz(local1\Field2, $00), $00)
                rotateentity(local1\Field0, 0.0, entityyaw(local1\Field2, $00), 0.0, $00)
                positionentity(local1\Field1, entityx(local1\Field0, $00), entityy(local1\Field0, $00), entityz(local1\Field0, $00), $00)
                rotateentity(local1\Field1, 0.0, (entityyaw(local1\Field2, $00) - 180.0), 0.0, $00)
                moveentity(local1\Field1, 0.0, 0.89572, -0.147)
                If (5.5 < local0) Then
                    entityalpha(local1\Field1, 1.0)
                ElseIf (4.5 < local0) Then
                    entityalpha(local1\Field1, min((local0 - 4.5), 1.0))
                Else
                    entityalpha(local1\Field1, 0.0)
                EndIf
            Case $03
                Select local1\Field6
                    Case 1.0
                        If (0.0 < killtimer) Then
                            local7 = createpivot($00)
                            positionentity(local7, entityx(local1\Field2, $00), (entityy(local1\Field2, $00) + 0.8), entityz(local1\Field2, $00), $00)
                            pointentity(local7, collider, 0.0)
                            rotateentity(local7, min(entitypitch(local7, $00), 40.0), entityyaw(local7, $00), 0.0, $00)
                            debuglog((Str entitypitch(local7, $00)))
                            rotateentity(local1\Field2, curveangle((entitypitch(local7, $00) - 10.0), entitypitch(local1\Field2, $00), 10.0), curveangle((entityyaw(local7, $00) + 5.0), entityyaw(local1\Field2, $00), 10.0), 0.0, $01)
                            rotateentity(local7, (entitypitch(local1\Field2, $00) + 10.0), (entityyaw(local1\Field2, $00) - 5.0), 0.0, $01)
                            entitypick(local7, 6.0)
                            If (pickedentity() = collider) Then
                                If (0.0 = local1\Field13) Then
                                    playsound2(gunshotsfx, camera, local1\Field2, 20.0, 1.0)
                                    local11 = createparticle(entityx(local1\Field0, $01), entityy(local1\Field0, $01), entityz(local1\Field0, $01), $01, 0.2, 0.0, $05)
                                    rotateentity(local11\Field1, entitypitch(local1\Field2, $00), entityyaw(local1\Field2, $00), 0.0, $00)
                                    moveentity(local11\Field1, 0.0, 0.74, 0.55)
                                    local1\Field13 = 5.0
                                    playsound(bullethitsfx)
                                    user_camera_pitch = (rnd(5.0, 10.0) + user_camera_pitch)
                                    kill()
                                EndIf
                            EndIf
                            freeentity(local7)
                        Else
                            local1\Field6 = 0.0
                        EndIf
                    Case 2.0
                        If (0.0 = local1\Field13) Then
                            playsound2(gunshotsfx, camera, local1\Field2, 20.0, 1.0)
                            local11 = createparticle(entityx(local1\Field0, $01), entityy(local1\Field0, $01), entityz(local1\Field0, $01), $01, 0.2, 0.0, $05)
                            rotateentity(local11\Field1, entitypitch(local1\Field2, $00), entityyaw(local1\Field2, $00), 0.0, $00)
                            moveentity(local11\Field1, 0.0, 0.74, 0.55)
                            local1\Field13 = 5.0
                        EndIf
                    Default
                        If (rand($190, $01) = $01) Then
                            local1\Field7 = (Int rnd(-30.0, 30.0))
                        EndIf
                        rotateentity(local1\Field2, (sin((Float (millisecs() / $19))) * 1.5), curveangle(((local1\Field8 + (Float local1\Field7)) + (sin((Float (millisecs() / $32))) * 2.0)), entityyaw(local1\Field2, $00), 50.0), 0.0, $01)
                End Select
                local1\Field13 = max(0.0, (local1\Field13 - fpsfactor))
                positionentity(local1\Field0, entityx(local1\Field2, $00), (entityy(local1\Field2, $00) - 0.1), entityz(local1\Field2, $00), $00)
                rotateentity(local1\Field0, entitypitch(local1\Field2, $00), entityyaw(local1\Field2, $00), 0.0, $00)
            Case $04
                rotateentity(local1\Field2, 0.0, entityyaw(local1\Field2, $00), 0.0, $01)
                If (1.0 = local1\Field6) Then
                    moveentity(local1\Field2, 0.0, 0.0, (0.015 * fpsfactor))
                    animate2(local1\Field0, animtime(local1\Field0), $00, $0E, 0.15)
                EndIf
                positionentity(local1\Field0, entityx(local1\Field2, $00), (entityy(local1\Field2, $00) - 0.25), entityz(local1\Field2, $00), $00)
                rotateentity(local1\Field0, entitypitch(local1\Field2, $00), entityyaw(local1\Field2, $00), 0.0, $00)
            Case $05
                If (local1\Field12 <> 0) Then
                    hideentity(local1\Field0)
                    If (rand($C8, $01) = $01) Then
                        showentity(local1\Field0)
                        local12 = rnd(360.0, 0.0)
                        local0 = rnd(3.5, 4.0)
                        positionentity(local1\Field2, (entityx(collider, $00) + (sin(local12) * local0)), 0.5, (entityz(collider, $00) + (cos(local12) * local0)), $00)
                        local1\Field12 = $00
                        local1\Field6 = (Float rand($14, $3C))
                    EndIf
                ElseIf (rand($03, $01) = $01) Then
                    showentity(local1\Field0)
                EndIf
                If (rand($0D, $01) = $01) Then
                    hideentity(local1\Field0)
                EndIf
                positionentity(local1\Field0, (entityx(local1\Field2, $00) + rnd(-0.005, 0.005)), ((entityy(local1\Field2, $00) + 0.05) + rnd(-0.005, 0.005)), (entityz(local1\Field2, $00) + rnd(-0.005, 0.005)), $00)
                If (entityinview(local1\Field0, camera) <> 0) Then
                    If (entityvisible(local1\Field2, collider) <> 0) Then
                        local1\Field6 = (local1\Field6 - fpsfactor)
                    EndIf
                EndIf
                local1\Field6 = (local1\Field6 - (fpsfactor / 100.0))
                If (0.0 >= local1\Field6) Then
                    local1\Field12 = $01
                EndIf
                local1\Field4 = 0.0
                resetentity(local1\Field2)
        End Select
        If (hidedistance > distance(entityx(collider, $00), entityz(collider, $00), entityx(local1\Field2, $00), entityz(local1\Field2, $00))) Then
            translateentity(local1\Field2, 0.0, local1\Field4, 0.0, $00)
            local13 = $00
            For local6 = $01 To countcollisions(local1\Field2) Step $01
                If ((entityy(local1\Field2, $00) - 0.01) > collisiony(local1\Field2, local6)) Then
                    local13 = $01
                EndIf
            Next
            If (local13 = $01) Then
                local1\Field4 = 0.0
            Else
                local1\Field4 = (local1\Field4 - (0.0006 * fpsfactor))
            EndIf
        EndIf
    Next
    Return $00
End Function
