Function updatenpcs%()
    Local local0#
    Local local1#
    Local local2.npcs
    Local local4%
    Local local5#
    Local local7.doors
    Local local8%
    Local local9%
    Local local10.decals
    Local local11.rooms
    Local local13.particles
    Local local14%
    For local2 = Each npcs
        Select local2\Field3
            Case $01
                positionentity(local2\Field0, entityx(local2\Field2, $00), (entityy(local2\Field2, $00) - 0.32), entityz(local2\Field2, $00), $00)
                rotateentity(local2\Field0, 0.0, entityyaw(local2\Field2, $00), 0.0, $00)
                local4 = $00
                local0 = entitydistance(local2\Field2, collider)
                If (((8.0 > local0) And entityvisible(local2\Field2, collider)) <> 0) Then
                    local4 = $01
                    local2\Field19 = entityx(collider, $01)
                    local2\Field20 = entityy(collider, $01)
                    local2\Field21 = entityz(collider, $01)
                EndIf
                If (local2\Field12 = $00) Then
                    local5 = max(min((distance(entityx(local2\Field2, $00), entityz(local2\Field2, $00), local2\Field16, local2\Field18) * 2.5), 1.0), 0.0)
                    local2\Field9 = loopsound2(stonedragsfx, local2\Field9, camera, local2\Field2, 10.0, local2\Field6)
                    local2\Field16 = entityx(local2\Field2, $00)
                    local2\Field18 = entityz(local2\Field2, $00)
                    If ((entityinview(local2\Field0, camera) And ((-6.0 < blinktimer) Or (-16.0 > blinktimer))) <> 0) Then
                        blurvolume = max(max(min(((4.0 - local0) / 6.0), 0.9), 0.1), blurvolume)
                        If (local4 <> 0) Then
                            If (((3.5 > local0) And ((millisecs() - local2\Field14) > $EA60)) <> 0) Then
                                playsound(horrorsfx($03))
                                local2\Field14 = millisecs()
                            EndIf
                        EndIf
                        If (((1.5 > local0) And (rand($2BC, $01) = $01)) <> 0) Then
                            playsound2(scp173sfx(rand($00, $02)), camera, local2\Field0, 10.0, 1.0)
                        EndIf
                        If (((1.5 > local0) And (2.0 < local2\Field15)) <> 0) Then
                            Select rand($03, $01)
                                Case $01
                                    playsound(horrorsfx($02))
                                Case $02
                                    playsound(horrorsfx($09))
                                Case $0A
                                    playsound(horrorsfx($0A))
                            End Select
                        EndIf
                        local2\Field15 = local0
                        local2\Field6 = max(0.0, (local2\Field6 - (fpsfactor / 20.0)))
                    Else
                        local2\Field6 = curvevalue(local5, local2\Field6, 3.0)
                        If (rand($0F, $01) = $01) Then
                            For local7 = Each doors
                                If ((((local7\Field4 = $00) And (local7\Field5 = $00)) And (local7\Field12 = "")) <> 0) Then
                                    For local8 = $00 To $01 Step $01
                                        If (local7\Field3[local8] <> $00) Then
                                            If (((0.5 > (Abs (entityx(local2\Field2, $00) - entityx(local7\Field3[local8], $00)))) And (0.5 > (Abs (entityz(local2\Field2, $00) - entityz(local7\Field3[local8], $00))))) <> 0) Then
                                                If (((180.0 <= local7\Field7) Or (0.0 >= local7\Field7)) <> 0) Then
                                                    local4 = createpivot($00)
                                                    positionentity(local4, entityx(local2\Field2, $00), (entityy(local2\Field2, $00) + 0.5), entityz(local2\Field2, $00), $00)
                                                    pointentity(local4, local7\Field3[local8], 0.0)
                                                    moveentity(local4, 0.0, 0.0, (local2\Field11 * 0.6))
                                                    If (entitypick(local4, 0.5) = local7\Field3[local8]) Then
                                                        usedoor(local7)
                                                    EndIf
                                                    freeentity(local4)
                                                EndIf
                                            EndIf
                                        EndIf
                                    Next
                                EndIf
                            Next
                        ElseIf (rand($0F, $01) = $01) Then
                        EndIf
                        If (local4 <> 0) Then
                            If (0.65 > local0) Then
                                If (((0.0 <= killtimer) And (godmode = $00)) <> 0) Then
                                    If (godmode = $00) Then
                                        local2\Field12 = $01
                                    EndIf
                                    If (rand($02, $01) = $01) Then
                                        turnentity(camera, 0.0, 120.0, 0.0, $00)
                                    Else
                                        turnentity(camera, 0.0, -120.0, 0.0, $00)
                                    EndIf
                                    playsound(damagesfx(rand($00, $02)))
                                EndIf
                                kill()
                            Else
                                pointentity(local2\Field2, collider, 0.0)
                                rotateentity(local2\Field2, 0.0, entityyaw(local2\Field2, $00), entityroll(local2\Field2, $00), $00)
                                moveentity(local2\Field2, 0.0, 0.0, (local2\Field11 * fpsfactor))
                            EndIf
                        ElseIf (0.0 <> local2\Field19) Then
                            If (0.2 < distance(entityx(local2\Field2, $00), entityz(local2\Field2, $00), local2\Field19, local2\Field21)) Then
                                local9 = createpivot($00)
                                positionentity(local9, local2\Field19, local2\Field20, local2\Field21, $01)
                                pointentity(local2\Field2, local9, 0.0)
                                rotateentity(local2\Field2, 0.0, entityyaw(local2\Field2, $00), entityroll(local2\Field2, $00), $00)
                                moveentity(local2\Field2, 0.0, 0.0, (local2\Field11 * fpsfactor))
                                freeentity(local9)
                                If (rand($1E, $01) = $01) Then
                                    local2\Field19 = 0.0
                                    local2\Field20 = 0.0
                                    local2\Field21 = 0.0
                                EndIf
                            Else
                                local2\Field19 = 0.0
                                local2\Field20 = 0.0
                                local2\Field21 = 0.0
                            EndIf
                        Else
                            moveentity(local2\Field2, 0.0, 0.0, ((local2\Field11 * 0.8) * fpsfactor))
                            turnentity(local2\Field2, 0.0, 1.0, 0.0, $00)
                        EndIf
                    EndIf
                EndIf
            Case $02
                If (contained106 <> 0) Then
                    local2\Field12 = $01
                    hideentity(local2\Field0)
                    positionentity(local2\Field0, 0.0, 500.0, 0.0, $01)
                Else
                    local0 = entitydistance(local2\Field2, collider)
                    If (local2\Field12 = $00) Then
                        If (0.0 >= local2\Field6) Then
                            If (((entityy(collider, $00) - 20.0) - 0.55) > entityy(local2\Field2, $00)) Then
                                If (playerroom\Field6\Field7 = $00) Then
                                    local10 = createdecal($00, entityx(collider, $00), 0.01, entityz(collider, $00), 90.0, (Float rand($168, $01)), 0.0)
                                    local10\Field2 = 0.05
                                    local10\Field1 = 0.001
                                    entityalpha(local10\Field0, 0.8)
                                    updatedecals()
                                EndIf
                                positionentity(local2\Field2, entityx(collider, $00), (entityy(collider, $00) - 15.0), entityz(collider, $00), $00)
                                playsound(horrorsfx($05))
                                playsound(decaysfx($00))
                            EndIf
                            If (rand($1F4, $01) = $01) Then
                                playsound2(oldmansfx(rand($00, $02)), camera, local2\Field2, 10.0, 1.0)
                            EndIf
                            local2\Field9 = loopsound2(oldmansfx($04), local2\Field9, camera, local2\Field2, 8.0, 0.8)
                            If (-10.0 < local2\Field6) Then
                                shouldplay = $42
                                If (0.05 < (Abs ((entityy(collider, $00) - 0.35) - entityy(local2\Field2, $00)))) Then
                                    translateentity(local2\Field2, 0.0, (((entityy(collider, $00) - 0.35) - entityy(local2\Field2, $00)) / 100.0), 0.0, $00)
                                    animate2(local2\Field0, animtime(local2\Field0), $CE, $FA, 0.3)
                                Else
                                    local2\Field6 = -10.0
                                EndIf
                            Else
                                shouldplay = $01
                                translateentity(local2\Field2, 0.0, (((entityy(collider, $00) - 0.15) - entityy(local2\Field2, $00)) / 50.0), 0.0, $00)
                                If (entityinview(local2\Field2, camera) <> 0) Then
                                    blurvolume = max(max(min(((4.0 - local0) / 6.0), 0.9), 0.1), blurvolume)
                                    If ((millisecs() - local2\Field14) > $EA60) Then
                                        playsound(horrorsfx($06))
                                        local2\Field14 = millisecs()
                                    EndIf
                                ElseIf (entityvisible(local2\Field2, collider) = $00) Then
                                    local2\Field6 = (local2\Field6 - fpsfactor)
                                EndIf
                                pointentity(local2\Field0, collider, 0.0)
                                rotateentity(local2\Field2, 0.0, curveangle(entityyaw(local2\Field0, $00), entityyaw(local2\Field2, $00), 10.0), 0.0, $00)
                                If (0.7 < local0) Then
                                    If (0.0 <= killtimer) Then
                                        moveentity(local2\Field2, 0.0, 0.0, (local2\Field11 * fpsfactor))
                                        animate2(local2\Field0, animtime(local2\Field0), $00, $0E, 0.15)
                                    EndIf
                                Else
                                    If (0.4 > local0) Then
                                        moveentity(local2\Field2, 0.0, 0.0, ((local2\Field11 * fpsfactor) * 1.5))
                                    EndIf
                                    animate2(local2\Field0, animtime(local2\Field0), $20, $2C, 0.45)
                                    If (43.0 = floor(animtime(local2\Field0))) Then
                                        setanimtime(local2\Field0, 43.0, $00)
                                    EndIf
                                    If (0.0 <= killtimer) Then
                                        If (36.0 = floor(animtime(local2\Field0))) Then
                                            If (playerroom\Field6\Field4 = "pocketdimension") Then
                                                playsound(deathsfx($01))
                                                kill()
                                            Else
                                                For local11 = Each rooms
                                                    If (local11\Field6\Field4 = "pocketdimension") Then
                                                        playsound(use914sfx)
                                                        playsound(oldmansfx($05))
                                                        positionentity(collider, entityx(local11\Field1, $00), 0.5, entityz(local11\Field1, $00), $00)
                                                        resetentity(collider)
                                                        local2\Field6 = -2000.0
                                                        blinktimer = -10.0
                                                        Exit
                                                    EndIf
                                                Next
                                            EndIf
                                        EndIf
                                    EndIf
                                EndIf
                            EndIf
                            local2\Field4 = 0.0
                            If (local2\Field6 <= (Float rand($FFFFF9C0, $FFFFFAEC))) Then
                                local2\Field6 = (Float rand($55F0, $6978))
                            EndIf
                        Else
                            moveentity(local2\Field2, 0.0, (((entityy(collider, $00) - 30.0) - entityy(local2\Field2, $00)) / 200.0), 0.0)
                            local2\Field4 = 0.0
                            If (playerroom\Field6\Field7 = $00) Then
                                local2\Field6 = (local2\Field6 - fpsfactor)
                            EndIf
                        EndIf
                    EndIf
                    resetentity(local2\Field2)
                    positionentity(local2\Field0, entityx(local2\Field2, $00), (entityy(local2\Field2, $00) - 0.15), entityz(local2\Field2, $00), $00)
                    rotateentity(local2\Field0, 0.0, entityyaw(local2\Field2, $00), 0.0, $00)
                    positionentity(local2\Field1, entityx(local2\Field0, $00), entityy(local2\Field0, $00), entityz(local2\Field0, $00), $00)
                    rotateentity(local2\Field1, 0.0, (entityyaw(local2\Field2, $00) - 180.0), 0.0, $00)
                    moveentity(local2\Field1, 0.0, 0.89572, -0.147)
                    If (playerroom\Field6\Field4 = "pocketdimension") Then
                        entityalpha(local2\Field1, 0.0)
                    ElseIf (5.5 < local0) Then
                        entityalpha(local2\Field1, 1.0)
                    ElseIf (4.5 < local0) Then
                        entityalpha(local2\Field1, min((local0 - 4.5), 1.0))
                    Else
                        entityalpha(local2\Field1, 0.0)
                    EndIf
                EndIf
            Case $03
                Select local2\Field6
                    Case 1.0
                        If (0.0 <= killtimer) Then
                            local9 = createpivot($00)
                            positionentity(local9, entityx(local2\Field2, $00), (entityy(local2\Field2, $00) + 0.8), entityz(local2\Field2, $00), $00)
                            pointentity(local9, collider, 0.0)
                            rotateentity(local9, min(entitypitch(local9, $00), 40.0), entityyaw(local9, $00), 0.0, $00)
                            debuglog((Str entitypitch(local9, $00)))
                            rotateentity(local2\Field2, curveangle((entitypitch(local9, $00) - 10.0), entitypitch(local2\Field2, $00), 10.0), curveangle((entityyaw(local9, $00) + 5.0), entityyaw(local2\Field2, $00), 10.0), 0.0, $01)
                            rotateentity(local9, (entitypitch(local2\Field2, $00) + 10.0), (entityyaw(local2\Field2, $00) - 5.0), 0.0, $01)
                            entitypick(local9, 6.0)
                            If (pickedentity() = collider) Then
                                If (0.0 = local2\Field13) Then
                                    playsound2(gunshotsfx, camera, local2\Field2, 20.0, 1.0)
                                    local13 = createparticle(entityx(local2\Field0, $01), entityy(local2\Field0, $01), entityz(local2\Field0, $01), $01, 0.2, 0.0, $05)
                                    rotateentity(local13\Field1, entitypitch(local2\Field2, $00), entityyaw(local2\Field2, $00), 0.0, $00)
                                    moveentity(local13\Field1, 0.0, 0.74, 0.55)
                                    local2\Field13 = 5.0
                                    playsound(bullethitsfx)
                                    user_camera_pitch = (rnd(5.0, 10.0) + user_camera_pitch)
                                    kill()
                                EndIf
                            EndIf
                            freeentity(local9)
                        Else
                            local2\Field6 = 0.0
                        EndIf
                    Case 2.0
                        If (0.0 = local2\Field13) Then
                            playsound2(gunshotsfx, camera, local2\Field2, 20.0, 1.0)
                            local13 = createparticle(entityx(local2\Field0, $01), entityy(local2\Field0, $01), entityz(local2\Field0, $01), $01, 0.2, 0.0, $05)
                            rotateentity(local13\Field1, entitypitch(local2\Field2, $00), entityyaw(local2\Field2, $00), 0.0, $00)
                            moveentity(local13\Field1, 0.0, 0.74, 0.55)
                            local2\Field13 = 5.0
                        EndIf
                    Default
                        If (rand($190, $01) = $01) Then
                            local2\Field7 = (Int rnd(-30.0, 30.0))
                        EndIf
                        rotateentity(local2\Field2, (sin((Float (millisecs() / $19))) * 1.5), curveangle(((local2\Field8 + (Float local2\Field7)) + (sin((Float (millisecs() / $32))) * 2.0)), entityyaw(local2\Field2, $00), 50.0), 0.0, $01)
                End Select
                local2\Field13 = max(0.0, (local2\Field13 - fpsfactor))
                positionentity(local2\Field0, entityx(local2\Field2, $00), (entityy(local2\Field2, $00) - 0.1), entityz(local2\Field2, $00), $00)
                rotateentity(local2\Field0, entitypitch(local2\Field2, $00), entityyaw(local2\Field2, $00), 0.0, $00)
            Case $04
                rotateentity(local2\Field2, 0.0, entityyaw(local2\Field2, $00), 0.0, $01)
                If (1.0 = local2\Field6) Then
                    moveentity(local2\Field2, 0.0, 0.0, (0.015 * fpsfactor))
                    animate2(local2\Field0, animtime(local2\Field0), $00, $0E, 0.15)
                EndIf
                positionentity(local2\Field0, entityx(local2\Field2, $00), (entityy(local2\Field2, $00) - 0.25), entityz(local2\Field2, $00), $00)
                rotateentity(local2\Field0, entitypitch(local2\Field2, $00), entityyaw(local2\Field2, $00), 0.0, $00)
            Case $06
                If (local2\Field12 <> 0) Then
                    hideentity(local2\Field0)
                    If (((rand($32, $01) = $01) And ((-5.0 > blinktimer) And (-15.0 < blinktimer))) <> 0) Then
                        showentity(local2\Field0)
                        local1 = (entityyaw(collider, $00) + rnd(-90.0, 90.0))
                        local0 = rnd(1.5, 2.0)
                        positionentity(local2\Field2, (entityx(collider, $00) + (sin(local1) * local0)), (entityy(collider, $00) + 0.2), (entityz(collider, $00) + (cos(local1) * local0)), $00)
                        local2\Field12 = $00
                        local2\Field6 = (Float rand($14, $3C))
                        If (rand($12C, $01) = $01) Then
                            playsound2(rustlesfx(rand($00, $02)), camera, local2\Field0, 8.0, rnd(0.0, 0.2))
                        EndIf
                    EndIf
                Else
                    positionentity(local2\Field0, (entityx(local2\Field2, $00) + rnd(-0.005, 0.005)), ((entityy(local2\Field2, $00) + 0.3) + (0.1 * sin((Float (millisecs() Sar $01))))), (entityz(local2\Field2, $00) + rnd(-0.005, 0.005)), $00)
                    rotateentity(local2\Field0, 0.0, entityyaw(local2\Field2, $00), (Float ((millisecs() / $05) Mod $168)), $00)
                    animate2(local2\Field0, animtime(local2\Field0), $20, $71, 0.4)
                    If (entityinview(local2\Field0, camera) <> 0) Then
                        If (rand($1E, $01) = $01) Then
                            If (channelplaying(local2\Field9) = $00) Then
                                If (entityvisible(camera, local2\Field0) <> 0) Then
                                    local2\Field9 = playsound2(rustlesfx(rand($00, $02)), camera, local2\Field0, 8.0, 0.3)
                                EndIf
                            EndIf
                        EndIf
                        local4 = createpivot($00)
                        positionentity(local4, entityx(collider, $00), entityy(collider, $00), entityz(collider, $00), $00)
                        pointentity(local4, local2\Field2, 0.0)
                        local1 = wrapangle((entityyaw(collider, $00) - entityyaw(local4, $00)))
                        If (180.0 > local1) Then
                            rotateentity(local2\Field2, 0.0, (entityyaw(collider, $00) - 80.0), 0.0, $00)
                        Else
                            rotateentity(local2\Field2, 0.0, (entityyaw(collider, $00) + 80.0), 0.0, $00)
                        EndIf
                        freeentity(local4)
                        moveentity(local2\Field2, 0.0, 0.0, (0.03 * fpsfactor))
                        local2\Field6 = (local2\Field6 - fpsfactor)
                    EndIf
                    local2\Field6 = (local2\Field6 - (fpsfactor / 80.0))
                    If (0.0 >= local2\Field6) Then
                        local2\Field12 = $01
                    EndIf
                EndIf
                local2\Field4 = 0.0
                resetentity(local2\Field2)
        End Select
        If (hidedistance > distance(entityx(collider, $00), entityz(collider, $00), entityx(local2\Field2, $00), entityz(local2\Field2, $00))) Then
            translateentity(local2\Field2, 0.0, local2\Field4, 0.0, $00)
            local14 = $00
            For local8 = $01 To countcollisions(local2\Field2) Step $01
                If ((entityy(local2\Field2, $00) - 0.01) > collisiony(local2\Field2, local8)) Then
                    local14 = $01
                EndIf
            Next
            If (local14 = $01) Then
                local2\Field4 = 0.0
            Else
                local2\Field4 = (local2\Field4 - (0.0006 * fpsfactor))
            EndIf
        EndIf
    Next
    Return $00
End Function
