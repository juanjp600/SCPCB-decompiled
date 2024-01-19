Function updatenpcs%()
    Local local0.npcs
    Local local1.npcs
    Local local2.doors
    Local local3.decals
    Local local4.rooms
    Local local5%
    Local local6#
    Local local7#
    Local local9%
    Local local10#
    Local local12%
    Local local13%
    Local local14#
    Local local16.particles
    Local local18%
    Local local19%
    Local local20#
    Local local22%
    Local local23%
    For local0 = Each npcs
        Select local0\Field5
            Case $01
                positionentity(local0\Field0, entityx(local0\Field4, $00), (entityy(local0\Field4, $00) - 0.32), entityz(local0\Field4, $00), $00)
                rotateentity(local0\Field0, 0.0, entityyaw(local0\Field4, $00), 0.0, $00)
                local9 = $00
                local6 = entitydistance(local0\Field4, collider)
                If (((8.0 > local6) And entityvisible(local0\Field4, collider)) <> 0) Then
                    local9 = $01
                    local0\Field28 = entityx(collider, $01)
                    local0\Field29 = entityy(collider, $01)
                    local0\Field30 = entityz(collider, $01)
                EndIf
                If (local0\Field19 = $00) Then
                    local10 = max(min((distance(entityx(local0\Field4, $00), entityz(local0\Field4, $00), local0\Field23, local0\Field25) * 2.5), 1.0), 0.0)
                    local0\Field15 = loopsound2(stonedragsfx, local0\Field15, camera, local0\Field4, 10.0, local0\Field9)
                    local0\Field23 = entityx(local0\Field4, $00)
                    local0\Field25 = entityz(local0\Field4, $00)
                    If ((entityinview(local0\Field0, camera) And ((-6.0 < blinktimer) Or (-16.0 > blinktimer))) <> 0) Then
                        blurvolume = max(max(min(((4.0 - local6) / 6.0), 0.9), 0.1), blurvolume)
                        If (local9 <> 0) Then
                            If (((3.5 > local6) And ((millisecs() - local0\Field21) > $EA60)) <> 0) Then
                                playsound(horrorsfx($03))
                                local0\Field21 = millisecs()
                            EndIf
                        EndIf
                        If (((1.5 > local6) And (rand($2BC, $01) = $01)) <> 0) Then
                            playsound2(scp173sfx(rand($00, $02)), camera, local0\Field0, 10.0, 1.0, $01)
                        EndIf
                        If (((1.5 > local6) And (2.0 < local0\Field22)) <> 0) Then
                            Select rand($03, $01)
                                Case $01
                                    playsound(horrorsfx($02))
                                Case $02
                                    playsound(horrorsfx($09))
                                Case $0A
                                    playsound(horrorsfx($0A))
                            End Select
                        EndIf
                        local0\Field22 = local6
                        local0\Field9 = max(0.0, (local0\Field9 - (fpsfactor / 20.0)))
                    Else
                        local0\Field9 = curvevalue(local10, local0\Field9, 3.0)
                        If (rand($0F, $01) = $01) Then
                            For local2 = Each doors
                                If ((((local2\Field4 = $00) And (local2\Field5 = $00)) And (local2\Field15 = "")) <> 0) Then
                                    For local5 = $00 To $01 Step $01
                                        If (local2\Field3[local5] <> $00) Then
                                            If (((0.5 > (Abs (entityx(local0\Field4, $00) - entityx(local2\Field3[local5], $00)))) And (0.5 > (Abs (entityz(local0\Field4, $00) - entityz(local2\Field3[local5], $00))))) <> 0) Then
                                                If (((180.0 <= local2\Field7) Or (0.0 >= local2\Field7)) <> 0) Then
                                                    local9 = createpivot($00)
                                                    positionentity(local9, entityx(local0\Field4, $00), (entityy(local0\Field4, $00) + 0.5), entityz(local0\Field4, $00), $00)
                                                    pointentity(local9, local2\Field3[local5], 0.0)
                                                    moveentity(local9, 0.0, 0.0, (local0\Field17 * 0.6))
                                                    If (entitypick(local9, 0.5) = local2\Field3[local5]) Then
                                                        usedoor(local2, $00)
                                                    EndIf
                                                    freeentity(local9)
                                                EndIf
                                            EndIf
                                        EndIf
                                    Next
                                EndIf
                            Next
                        ElseIf (rand($0F, $01) = $01) Then
                        EndIf
                        If (local9 <> 0) Then
                            If (0.65 > local6) Then
                                If (((0.0 <= killtimer) And (godmode = $00)) <> 0) Then
                                    If (godmode = $00) Then
                                        local0\Field19 = $01
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
                                pointentity(local0\Field4, collider, 0.0)
                                rotateentity(local0\Field4, 0.0, entityyaw(local0\Field4, $00), entityroll(local0\Field4, $00), $00)
                                moveentity(local0\Field4, 0.0, 0.0, (local0\Field17 * fpsfactor))
                            EndIf
                        ElseIf (0.0 <> local0\Field28) Then
                            If (0.2 < distance(entityx(local0\Field4, $00), entityz(local0\Field4, $00), local0\Field28, local0\Field30)) Then
                                local12 = createpivot($00)
                                positionentity(local12, local0\Field28, local0\Field29, local0\Field30, $01)
                                pointentity(local0\Field4, local12, 0.0)
                                rotateentity(local0\Field4, 0.0, entityyaw(local0\Field4, $00), entityroll(local0\Field4, $00), $00)
                                moveentity(local0\Field4, 0.0, 0.0, (local0\Field17 * fpsfactor))
                                freeentity(local12)
                                If (rand($1E, $01) = $01) Then
                                    local0\Field28 = 0.0
                                    local0\Field29 = 0.0
                                    local0\Field30 = 0.0
                                EndIf
                            Else
                                local0\Field28 = 0.0
                                local0\Field29 = 0.0
                                local0\Field30 = 0.0
                            EndIf
                        Else
                            moveentity(local0\Field4, 0.0, 0.0, ((local0\Field17 * 0.8) * fpsfactor))
                            turnentity(local0\Field4, 0.0, (8.0 * fpsfactor), 0.0, $00)
                        EndIf
                    EndIf
                EndIf
            Case $02
                If (contained106 <> 0) Then
                    local0\Field19 = $01
                    hideentity(local0\Field0)
                    positionentity(local0\Field0, 0.0, 500.0, 0.0, $01)
                Else
                    local6 = entitydistance(local0\Field4, collider)
                    If (local0\Field19 = $00) Then
                        If (0.0 >= local0\Field9) Then
                            debuglog((Str local0\Field9))
                            If (((entityy(collider, $00) - 20.0) - 0.55) > entityy(local0\Field4, $00)) Then
                                If (playerroom\Field7\Field7 = $00) Then
                                    local3 = createdecal($00, entityx(collider, $00), 0.01, entityz(collider, $00), 90.0, (Float rand($168, $01)), 0.0)
                                    local3\Field2 = 0.05
                                    local3\Field1 = 0.001
                                    entityalpha(local3\Field0, 0.8)
                                    updatedecals()
                                EndIf
                                positionentity(local0\Field4, entityx(collider, $00), (entityy(collider, $00) - 15.0), entityz(collider, $00), $00)
                                playsound(horrorsfx($05))
                                playsound(decaysfx($00))
                            EndIf
                            If (rand($1F4, $01) = $01) Then
                                playsound2(oldmansfx(rand($00, $02)), camera, local0\Field4, 10.0, 1.0, $01)
                            EndIf
                            local0\Field15 = loopsound2(oldmansfx($04), local0\Field15, camera, local0\Field4, 8.0, 0.8)
                            If (-10.0 < local0\Field9) Then
                                shouldplay = $42
                                If (0.05 < (Abs ((entityy(collider, $00) - 0.35) - entityy(local0\Field4, $00)))) Then
                                    translateentity(local0\Field4, 0.0, (((entityy(collider, $00) - 0.35) - entityy(local0\Field4, $00)) / 100.0), 0.0, $00)
                                    animate2(local0\Field0, animtime(local0\Field0), $CE, $FA, 0.3)
                                Else
                                    local0\Field9 = -10.0
                                EndIf
                            Else
                                shouldplay = $01
                                local13 = entityvisible(local0\Field4, collider)
                                If (entityinview(local0\Field4, camera) <> 0) Then
                                    achv106 = $01
                                    blurvolume = max(max(min(((4.0 - local6) / 6.0), 0.9), 0.1), blurvolume)
                                    If ((millisecs() - local0\Field21) > $EA60) Then
                                        playsound(horrorsfx($06))
                                        local0\Field21 = millisecs()
                                    EndIf
                                ElseIf (local13 = $00) Then
                                    local0\Field9 = (local0\Field9 - fpsfactor)
                                EndIf
                                If (0.8 < local6) Then
                                    If (((((40.0 < local6) Or (local0\Field32 = $02)) Or (playerroom\Field7\Field4 = "pocketdimension")) Or local13) <> 0) Then
                                        If (40.0 < local6) Then
                                            debuglog("noclip - dist > 40")
                                        EndIf
                                        If (local0\Field32 = $02) Then
                                            debuglog("noclip - n\pathstatus = 2")
                                        EndIf
                                        If (local13 <> 0) Then
                                            debuglog("noclip - visible")
                                        EndIf
                                        translateentity(local0\Field4, 0.0, (((entityy(collider, $00) - 0.15) - entityy(local0\Field4, $00)) / 50.0), 0.0, $00)
                                        pointentity(local0\Field0, collider, 0.0)
                                        rotateentity(local0\Field4, 0.0, curveangle(entityyaw(local0\Field0, $00), entityyaw(local0\Field4, $00), 10.0), 0.0, $00)
                                        If (0.0 <= killtimer) Then
                                            local0\Field18 = curvevalue(local0\Field17, local0\Field18, 10.0)
                                            local14 = animtime(local0\Field0)
                                            animate2(local0\Field0, animtime(local0\Field0), $00, $0E, 0.15)
                                            If (((13.0 < local14) And (1.0 > animtime(local0\Field0))) <> 0) Then
                                                playsound2(steppdsfx(rand($00, $02)), camera, local0\Field4, 6.0, rnd(0.8, 1.0), $01)
                                            ElseIf (((7.0 >= local14) And (7.0 < animtime(local0\Field0))) <> 0) Then
                                                playsound2(steppdsfx(rand($00, $02)), camera, local0\Field4, 6.0, rnd(0.8, 1.0), $01)
                                            EndIf
                                        Else
                                            local0\Field18 = 0.0
                                        EndIf
                                        local0\Field33 = max((local0\Field33 - fpsfactor), 0.0)
                                        If (0.0 >= local0\Field33) Then
                                            local0\Field32 = $00
                                        EndIf
                                    Else
                                        debuglog("pathfinding")
                                        If (0.0 >= local0\Field33) Then
                                            local0\Field32 = findpath(local0, entityx(collider, $01), entityy(collider, $01), entityz(collider, $01))
                                            local0\Field33 = 700.0
                                            local0\Field18 = 0.0
                                        Else
                                            local0\Field33 = max((local0\Field33 - fpsfactor), 0.0)
                                            If (local0\Field32 = $02) Then
                                                debuglog("ei reitti?")
                                            ElseIf (local0\Field32 = $01) Then
                                                debuglog("reitti l?ydetty")
                                                If (local0\Field31[local0\Field34] = Null) Then
                                                    If (local0\Field34 > $13) Then
                                                        local0\Field34 = $00
                                                        local0\Field32 = $00
                                                    Else
                                                        local0\Field34 = (local0\Field34 + $01)
                                                    EndIf
                                                Else
                                                    translateentity(local0\Field4, 0.0, (((entityy(local0\Field31[local0\Field34]\Field0, $01) - 0.15) - entityy(local0\Field4, $00)) / 50.0), 0.0, $00)
                                                    pointentity(local0\Field0, local0\Field31[local0\Field34]\Field0, 0.0)
                                                    rotateentity(local0\Field4, 0.0, curveangle(entityyaw(local0\Field0, $00), entityyaw(local0\Field4, $00), 10.0), 0.0, $00)
                                                    local0\Field18 = curvevalue(local0\Field17, local0\Field18, 10.0)
                                                    local14 = animtime(local0\Field0)
                                                    animate2(local0\Field0, animtime(local0\Field0), $00, $0E, 0.15)
                                                    If (((13.0 < local14) And (1.0 > animtime(local0\Field0))) <> 0) Then
                                                        playsound2(steppdsfx(rand($00, $02)), camera, local0\Field4, 6.0, rnd(0.8, 1.0), $01)
                                                    ElseIf (((7.0 >= local14) And (7.0 < animtime(local0\Field0))) <> 0) Then
                                                        playsound2(steppdsfx(rand($00, $02)), camera, local0\Field4, 6.0, rnd(0.8, 1.0), $01)
                                                    EndIf
                                                    If (0.2 > entitydistance(local0\Field4, local0\Field31[local0\Field34]\Field0)) Then
                                                        local0\Field34 = (local0\Field34 + $01)
                                                    EndIf
                                                EndIf
                                            ElseIf (local0\Field32 = $00) Then
                                                animate2(local0\Field0, animtime(local0\Field0), $CE, $FA, 0.3)
                                            EndIf
                                        EndIf
                                    EndIf
                                Else
                                    pointentity(local0\Field0, collider, 0.0)
                                    rotateentity(local0\Field4, 0.0, curveangle(entityyaw(local0\Field0, $00), entityyaw(local0\Field4, $00), 10.0), 0.0, $00)
                                    If (0.5 < local6) Then
                                        local0\Field18 = curvevalue((local0\Field17 * 2.0), local0\Field18, 10.0)
                                    Else
                                        local0\Field18 = 0.0
                                    EndIf
                                    animate2(local0\Field0, animtime(local0\Field0), $20, $2C, 0.45)
                                    If (43.0 = floor(animtime(local0\Field0))) Then
                                        setanimtime(local0\Field0, 43.0, $00)
                                    EndIf
                                    If (((0.0 <= killtimer) And (0.0 <= falltimer)) <> 0) Then
                                        If (36.0 = floor(animtime(local0\Field0))) Then
                                            If (playerroom\Field7\Field4 = "pocketdimension") Then
                                                playsound(deathsfx($01))
                                                kill()
                                            Else
                                                playsound(deathsfx($01))
                                                playsound(oldmansfx($03))
                                                falltimer = min(-1.0, falltimer)
                                                positionentity(head, entityx(camera, $01), entityy(camera, $01), entityz(camera, $01), $01)
                                                resetentity(head)
                                                rotateentity(head, 0.0, (entityyaw(camera, $00) + (Float rand($FFFFFFD3, $2D))), 0.0, $00)
                                            EndIf
                                        EndIf
                                    EndIf
                                EndIf
                            EndIf
                            moveentity(local0\Field4, 0.0, 0.0, (local0\Field18 * fpsfactor))
                            local0\Field7 = 0.0
                            If (local0\Field9 <= (Float rand($FFFFF510, $FFFFF768))) Then
                                local0\Field9 = (Float rand($55F0, $6978))
                            EndIf
                            If (-250.0 > falltimer) Then
                                debuglog("dskljdnfkmndgfkljmnjetklmesnrbr")
                                For local4 = Each rooms
                                    If (local4\Field7\Field4 = "pocketdimension") Then
                                        falltimer = 0.0
                                        updatedoors()
                                        updaterooms()
                                        showentity(collider)
                                        playsound(use914sfx)
                                        playsound(oldmansfx($05))
                                        positionentity(collider, entityx(local4\Field2, $00), 0.8, entityz(local4\Field2, $00), $00)
                                        dropspeed = 0.0
                                        resetentity(collider)
                                        local0\Field9 = -2500.0
                                        blinktimer = -10.0
                                        Exit
                                    EndIf
                                Next
                            EndIf
                        Else
                            local0\Field18 = 0.0
                            moveentity(local0\Field4, 0.0, (((entityy(collider, $00) - 30.0) - entityy(local0\Field4, $00)) / 200.0), 0.0)
                            local0\Field7 = 0.0
                            If (playerroom\Field7\Field7 = $00) Then
                                local0\Field9 = (local0\Field9 - fpsfactor)
                            EndIf
                        EndIf
                    EndIf
                    resetentity(local0\Field4)
                    positionentity(local0\Field0, entityx(local0\Field4, $00), (entityy(local0\Field4, $00) - 0.15), entityz(local0\Field4, $00), $00)
                    rotateentity(local0\Field0, 0.0, entityyaw(local0\Field4, $00), 0.0, $00)
                    positionentity(local0\Field1, entityx(local0\Field0, $00), entityy(local0\Field0, $00), entityz(local0\Field0, $00), $00)
                    rotateentity(local0\Field1, 0.0, (entityyaw(local0\Field4, $00) - 180.0), 0.0, $00)
                    moveentity(local0\Field1, 0.0, 0.89572, -0.147)
                    If (playerroom\Field7\Field4 = "pocketdimension") Then
                        entityalpha(local0\Field1, 0.0)
                    ElseIf (5.5 < local6) Then
                        entityalpha(local0\Field1, 1.0)
                    ElseIf (4.5 < local6) Then
                        entityalpha(local0\Field1, min((local6 - 4.5), 1.0))
                    Else
                        entityalpha(local0\Field1, 0.0)
                    EndIf
                EndIf
            Case $03
                Select local0\Field9
                    Case 1.0
                        If (0.0 <= killtimer) Then
                            local6 = entitydistance(local0\Field4, collider)
                            If (11.0 > local6) Then
                                local12 = createpivot($00)
                                positionentity(local12, entityx(local0\Field4, $00), (entityy(local0\Field4, $00) + 0.8), entityz(local0\Field4, $00), $00)
                                pointentity(local12, collider, 0.0)
                                rotateentity(local12, min(entitypitch(local12, $00), 40.0), entityyaw(local12, $00), 0.0, $00)
                                rotateentity(local0\Field4, curveangle((entitypitch(local12, $00) - 10.0), entitypitch(local0\Field4, $00), 10.0), curveangle((entityyaw(local12, $00) + 5.0), entityyaw(local0\Field4, $00), 10.0), 0.0, $01)
                                rotateentity(local12, (entitypitch(local0\Field4, $00) + 10.0), (entityyaw(local0\Field4, $00) - 5.0), 0.0, $01)
                                If (0.0 = local0\Field20) Then
                                    entitypick(local12, 15.0)
                                    If (pickedentity() = collider) Then
                                        playsound2(gunshotsfx, camera, local0\Field4, 20.0, 1.0, $01)
                                        local16 = createparticle(entityx(local0\Field0, $01), entityy(local0\Field0, $01), entityz(local0\Field0, $01), $01, 0.2, 0.0, $05)
                                        rotateentity(local16\Field1, entitypitch(local0\Field4, $00), entityyaw(local0\Field4, $00), 0.0, $00)
                                        moveentity(local16\Field1, 0.0, 0.74, 0.55)
                                        local0\Field20 = 5.0
                                        playsound(bullethitsfx)
                                        user_camera_pitch = (rnd(5.0, 10.0) + user_camera_pitch)
                                        kill()
                                    Else
                                        local0\Field18 = local0\Field17
                                    EndIf
                                EndIf
                                freeentity(local12)
                            EndIf
                            If (6.0 < local6) Then
                                local7 = entitypitch(local0\Field4, $00)
                                rotateentity(local0\Field4, 20.0, entityyaw(local0\Field4, $00), 0.0, $01)
                                moveentity(local0\Field4, 0.0, 0.0, (local0\Field18 * fpsfactor))
                                rotateentity(local0\Field4, local7, entityyaw(local0\Field4, $00), 0.0, $01)
                            EndIf
                            local0\Field18 = curvevalue(0.0, local0\Field18, 100.0)
                        Else
                            local0\Field9 = 0.0
                        EndIf
                    Case 2.0
                        If (0.0 = local0\Field20) Then
                            playsound2(gunshotsfx, camera, local0\Field4, 20.0, 1.0, $01)
                            local16 = createparticle(entityx(local0\Field0, $01), entityy(local0\Field0, $01), entityz(local0\Field0, $01), $01, 0.2, 0.0, $05)
                            rotateentity(local16\Field1, entitypitch(local0\Field4, $00), entityyaw(local0\Field4, $00), 0.0, $00)
                            moveentity(local16\Field1, 0.0, 0.74, 0.55)
                            local0\Field20 = 5.0
                        EndIf
                    Case 3.0
                        If (local0\Field32 = $02) Then
                            local0\Field9 = 4.0
                            local0\Field18 = 0.0
                        ElseIf (local0\Field32 = $01) Then
                            If (local0\Field31[local0\Field34] = Null) Then
                                If (local0\Field34 > $13) Then
                                    local0\Field34 = $00
                                    local0\Field32 = $00
                                Else
                                    local0\Field34 = (local0\Field34 + $01)
                                EndIf
                            Else
                                pointentity(local0\Field0, local0\Field31[local0\Field34]\Field0, 0.0)
                                rotateentity(local0\Field4, 0.0, curveangle(entityyaw(local0\Field0, $00), entityyaw(local0\Field4, $00), 10.0), 0.0, $00)
                                local0\Field18 = curvevalue(local0\Field17, local0\Field18, 20.0)
                                moveentity(local0\Field4, 0.0, 0.0, (local0\Field18 * fpsfactor))
                                If (0.2 > entitydistance(local0\Field4, local0\Field31[local0\Field34]\Field0)) Then
                                    local0\Field34 = (local0\Field34 + $01)
                                EndIf
                            EndIf
                        Else
                            local0\Field18 = 0.0
                            local0\Field9 = 4.0
                        EndIf
                    Case 4.0
                        If (rand($190, $01) = $01) Then
                            local0\Field12 = (Int rnd(-180.0, 180.0))
                        EndIf
                        rotateentity(local0\Field4, (sin((Float (millisecs() / $19))) * 1.5), curveangle(((local0\Field13 + (Float local0\Field12)) + (sin((Float (millisecs() / $32))) * 2.0)), entityyaw(local0\Field4, $00), 150.0), 0.0, $01)
                        local6 = entitydistance(local0\Field4, collider)
                        If (15.0 > local6) Then
                            local12 = createpivot($00)
                            positionentity(local12, entityx(local0\Field4, $00), (entityy(local0\Field4, $00) + 0.8), entityz(local0\Field4, $00), $00)
                            pointentity(local12, collider, 0.0)
                            If (90.0 > wrapangle((entityyaw(local0\Field4, $00) - entityyaw(local12, $00)))) Then
                                If (entityvisible(local12, collider) <> 0) Then
                                    local0\Field9 = 1.0
                                EndIf
                            EndIf
                            freeentity(local12)
                        EndIf
                    Default
                        If (rand($190, $01) = $01) Then
                            local0\Field12 = (Int rnd(-30.0, 30.0))
                        EndIf
                        rotateentity(local0\Field4, (sin((Float (millisecs() / $19))) * 1.5), curveangle(((local0\Field13 + (Float local0\Field12)) + (sin((Float (millisecs() / $32))) * 2.0)), entityyaw(local0\Field4, $00), 50.0), 0.0, $01)
                End Select
                local0\Field20 = max(0.0, (local0\Field20 - fpsfactor))
                positionentity(local0\Field0, entityx(local0\Field4, $00), (entityy(local0\Field4, $00) - 0.1), entityz(local0\Field4, $00), $00)
                rotateentity(local0\Field0, entitypitch(local0\Field4, $00), entityyaw(local0\Field4, $00), 0.0, $00)
            Case $08
                local6 = entitydistance(collider, local0\Field4)
                Select local0\Field9
                    Case 2.0
                        debuglog(((((((("n\state = " + (Str local0\Field9)) + ", n\state2 = ") + (Str local0\Field10)) + ", n\pathstatus: ") + (Str local0\Field32)) + ", n\pathtimer: ") + (Str local0\Field33)))
                        local9 = $00
                        If (8.0 > local6) Then
                            local12 = createpivot($00)
                            positionentity(local12, entityx(local0\Field4, $00), (entityy(local0\Field4, $00) + 0.6), entityz(local0\Field4, $00), $00)
                            pointentity(local12, collider, 0.0)
                            entitypick(local12, 8.0)
                            If (pickedentity() = collider) Then
                                local9 = $01
                            EndIf
                        EndIf
                        If (local9 = $01) Then
                            debuglog("player in sight")
                            local0\Field32 = $00
                            local0\Field33 = 0.0
                            local0\Field10 = 3150.0
                            If (0.0 = local0\Field11) Then
                                playsound2(mtfsfx(rand($00, $02)), camera, local0\Field4, 7.0, 1.0, $01)
                                playmtfmessage(mtfsfx(rand($00, $02)))
                                local0\Field11 = 10500.0
                                local0\Field20 = 200.0
                                For local1 = Each npcs
                                    If (local1\Field26 = local0) Then
                                        local1\Field11 = 10500.0
                                        local1\Field20 = 200.0
                                    EndIf
                                Next
                                If (local0\Field26 <> Null) Then
                                    local0\Field26\Field11 = 10500.0
                                    local0\Field26\Field20 = 200.0
                                EndIf
                            EndIf
                            local12 = createpivot($00)
                            positionentity(local12, entityx(local0\Field4, $00), (entityy(local0\Field4, $00) + 0.6), entityz(local0\Field4, $00), $00)
                            pointentity(local12, collider, 0.0)
                            rotateentity(local0\Field4, entitypitch(local0\Field4, $00), curveangle(entityyaw(local12, $00), entityyaw(local0\Field4, $00), 10.0), 0.0, $01)
                            If (0.0 = local0\Field20) Then
                                entitypick(local12, 7.0)
                                If (pickedentity() = collider) Then
                                    local18 = (Int killtimer)
                                    rotateentity(local12, (entitypitch(local0\Field4, $00) + 10.0), (entityyaw(local0\Field4, $00) - 5.0), 0.0, $01)
                                    playsound2(gunshotsfx, camera, local0\Field4, 35.0, 1.0, $01)
                                    local16 = createparticle(entityx(local0\Field0, $01), entityy(local0\Field0, $01), entityz(local0\Field0, $01), $01, 0.2, 0.0, $05)
                                    rotateentity(local16\Field1, entitypitch(local0\Field4, $00), entityyaw(local0\Field4, $00), 0.0, $00)
                                    moveentity(local16\Field1, 0.0, 0.8, 0.45)
                                    pointentity(local16\Field1, collider, 0.0)
                                    shoot(entityx(local16\Field1, $00), entityy(local16\Field1, $00), entityz(local16\Field1, $00), (entitypitch(local16\Field1, $00) - rnd(-3.0, 3.0)), (entityyaw(local16\Field1, $00) - rnd(-4.0, 4.0)), (local6 + 0.5), $00)
                                    local0\Field20 = 6.0
                                    If (((local18 >= $00) And (0.0 > killtimer)) <> 0) Then
                                        If (local0\Field14 <> $00) Then
                                            freesound(local0\Field14)
                                            local0\Field14 = $00
                                        EndIf
                                        local0\Field14 = loadsound("SFX\MTF\Targetterminated.ogg")
                                        playsound2(local0\Field14, camera, local0\Field4, 10.0, 1.0, $01)
                                        playmtfmessage(local0\Field14)
                                    EndIf
                                EndIf
                                freeentity(local12)
                            EndIf
                            If (1.7 < local6) Then
                                local0\Field18 = curvevalue(local0\Field17, local0\Field18, 20.0)
                                moveentity(local0\Field4, 0.0, 0.0, (local0\Field18 * fpsfactor))
                            Else
                                local0\Field18 = 0.0
                            EndIf
                        Else
                            If (50.0 > local6) Then
                                local0\Field18 = 0.0
                                If (0.0 >= local0\Field33) Then
                                    local0\Field32 = findpath(local0, entityx(collider, $00), (entityy(collider, $00) + 0.1), entityz(collider, $00))
                                    If (local0\Field32 = $01) Then
                                        local0\Field33 = (rnd(10.0, 15.0) * 70.0)
                                        local0\Field9 = 3.0
                                        debuglog("n\state -> 3")
                                    ElseIf (local0\Field32 = $02) Then
                                        local0\Field33 = (rnd(15.0, 25.0) * 70.0)
                                    Else
                                        local0\Field33 = (rnd(5.0, 10.0) * 70.0)
                                    EndIf
                                Else
                                    local0\Field33 = max((local0\Field33 - fpsfactor), 0.0)
                                    rotateentity(local0\Field4, (sin((Float (millisecs() / $19))) * 1.5), curveangle(((local0\Field13 + (Float local0\Field12)) + (sin((Float (millisecs() / $64))) * 100.0)), entityyaw(local0\Field4, $00), 50.0), 0.0, $01)
                                EndIf
                            Else
                                local0\Field10 = 0.0
                            EndIf
                            If (0.0 >= local0\Field10) Then
                                If (local0\Field26 = Null) Then
                                    If (local0\Field14 <> $00) Then
                                        freesound(local0\Field14)
                                        local0\Field14 = $00
                                    EndIf
                                    local0\Field14 = loadsound("SFX\MTF\Targetlost.ogg")
                                    playsound2(local0\Field14, camera, local0\Field4, 10.0, 1.0, $01)
                                    playmtfmessage(local0\Field14)
                                EndIf
                                local0\Field9 = 0.0
                                local0\Field32 = $00
                                local0\Field34 = $00
                                If (local0\Field26 <> Null) Then
                                    local0\Field9 = 4.0
                                EndIf
                            EndIf
                        EndIf
                    Case 3.0
                        If (local0\Field32 = $02) Then
                            local0\Field9 = 0.0
                            local0\Field18 = 0.0
                        ElseIf (local0\Field32 = $01) Then
                            If (local0\Field31[local0\Field34] = Null) Then
                                If (local0\Field34 > $13) Then
                                    local0\Field34 = $00
                                    local0\Field32 = $00
                                    If (0.0 < local0\Field10) Then
                                        local0\Field9 = 2.0
                                        local0\Field33 = 0.0
                                    EndIf
                                Else
                                    local0\Field34 = (local0\Field34 + $01)
                                EndIf
                            Else
                                If (local0\Field31[local0\Field34]\Field1 <> Null) Then
                                    If (local0\Field31[local0\Field34]\Field1\Field5 = $00) Then
                                        local0\Field31[local0\Field34]\Field1\Field5 = $01
                                        local0\Field31[local0\Field34]\Field1\Field10 = 350.0
                                        playsound2(mtfsfx($05), camera, local0\Field31[local0\Field34]\Field1\Field0, 8.0, 1.0, $01)
                                        playmtfmessage(mtfsfx($05))
                                    EndIf
                                EndIf
                                pointentity(local0\Field0, local0\Field31[local0\Field34]\Field0, 0.0)
                                rotateentity(local0\Field4, 0.0, curveangle((entityyaw(local0\Field0, $00) + local0\Field13), entityyaw(local0\Field4, $00), 10.0), 0.0, $00)
                                local0\Field18 = curvevalue(local0\Field17, ((min(0.5, local0\Field10) + 0.5) * local0\Field17), 20.0)
                                moveentity(local0\Field4, 0.0, 0.0, (local0\Field18 * fpsfactor))
                                If (0.2 > entitydistance(local0\Field4, local0\Field31[local0\Field34]\Field0)) Then
                                    local0\Field34 = (local0\Field34 + $01)
                                EndIf
                            EndIf
                        Else
                            local0\Field18 = 0.0
                            local0\Field9 = 0.0
                        EndIf
                        local0\Field13 = curvevalue(0.0, local0\Field13, 10.0)
                    Case 4.0
                        If (local0\Field26 <> Null) Then
                            local0\Field20 = 200.0
                            pointentity(local0\Field0, local0\Field26\Field0, 0.0)
                            rotateentity(local0\Field4, 0.0, curveangle((entityyaw(local0\Field0, $00) + local0\Field13), entityyaw(local0\Field4, $00), 10.0), 0.0, $00)
                            local6 = entitydistance(local0\Field0, local0\Field26\Field0)
                            If (1.0 < local6) Then
                                local0\Field18 = curvevalue((min(1.0, ((local6 - 1.0) * 3.0)) * local0\Field17), local0\Field18, 20.0)
                                moveentity(local0\Field4, 0.0, 0.0, (local0\Field18 * fpsfactor))
                                If (7.0 < local6) Then
                                    If (0.0 >= local0\Field33) Then
                                        debuglog("seurattava hukattu -> etsit??n reitti")
                                        local0\Field32 = findpath(local0, entityx(local0\Field26\Field4, $00), (entityy(local0\Field26\Field4, $00) + 0.3), entityz(local0\Field26\Field4, $00))
                                        local0\Field33 = (rnd(10.0, 14.0) * 70.0)
                                        If (local0\Field32 = $01) Then
                                            local0\Field9 = 3.0
                                        EndIf
                                    Else
                                        local0\Field33 = max((local0\Field33 - fpsfactor), 0.0)
                                    EndIf
                                EndIf
                            EndIf
                        Else
                            local0\Field9 = 0.0
                        EndIf
                        local0\Field13 = curvevalue(0.0, local0\Field13, 10.0)
                    Default
                        local0\Field32 = $00
                        local0\Field18 = 0.0
                        If (rand($190, $01) = $01) Then
                            local0\Field13 = rnd(360.0, 0.0)
                        EndIf
                        rotateentity(local0\Field4, (sin((Float (millisecs() / $19))) * 1.5), curveangle(((local0\Field13 + (Float local0\Field12)) + (sin((Float (millisecs() / $64))) * 100.0)), entityyaw(local0\Field4, $00), 50.0), 0.0, $01)
                End Select
                local0\Field10 = max((local0\Field10 - fpsfactor), 0.0)
                local0\Field11 = max((local0\Field11 - fpsfactor), 0.0)
                If (local0\Field26 = Null) Then
                    If ((((10290.0 > local0\Field11) And (10290.0 <= (local0\Field11 + fpsfactor))) And (0.0 <> fpsfactor)) <> 0) Then
                        playsound2(mtfsfx(rand($03, $04)), camera, local0\Field4, 8.0, 1.0, $01)
                    EndIf
                EndIf
                local0\Field16 = ((local0\Field18 * fpsfactor) + local0\Field16)
                If (1.3 < local0\Field16) Then
                    debuglog("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA")
                    playsound2(stepsfx($02, $00, rand($00, $02)), camera, local0\Field4, 8.0, rnd(0.8, 1.0), $01)
                    local0\Field16 = 0.0
                EndIf
                If (rand($0A, $01) = $01) Then
                    local12 = createpivot($00)
                    positionentity(local12, entityx(local0\Field4, $00), (entityy(local0\Field4, $00) + 0.6), entityz(local0\Field4, $00), $00)
                    pointentity(local12, collider, 0.0)
                    entitypick(local12, 0.4)
                    If (pickedentity() <> $00) Then
                        local0\Field13 = 90.0
                    EndIf
                    local9 = $00
                    If (playersoundvolume > local6) Then
                        local9 = $01
                    ElseIf (15.0 > local6) Then
                        positionentity(local12, entityx(local0\Field4, $00), (entityy(local0\Field4, $00) + 0.6), entityz(local0\Field4, $00), $00)
                        pointentity(local12, collider, 0.0)
                        If (90.0 > wrapangle((entityyaw(local0\Field4, $00) - entityyaw(local12, $00)))) Then
                            If (entityvisible(local0\Field4, collider) <> 0) Then
                                local9 = $01
                            EndIf
                        EndIf
                    EndIf
                    If (local9 <> 0) Then
                        local0\Field10 = 3150.0
                        local0\Field9 = 2.0
                        For local1 = Each npcs
                            If (((local0 <> local1) And (local1\Field5 = $08)) <> 0) Then
                                If (0.0 >= local1\Field10) Then
                                    If (8.0 > (Abs (entityx(local0\Field4, $00) - entityx(local1\Field4, $00)))) Then
                                        If (8.0 > (Abs (entityz(local0\Field4, $00) - entityz(local1\Field4, $00)))) Then
                                            local1\Field10 = 3150.0
                                            local1\Field9 = 2.0
                                        EndIf
                                    EndIf
                                EndIf
                            EndIf
                        Next
                    EndIf
                    freeentity(local12)
                EndIf
                local0\Field20 = max(0.0, (local0\Field20 - fpsfactor))
                positionentity(local0\Field0, entityx(local0\Field4, $00), (entityy(local0\Field4, $00) - 0.25), entityz(local0\Field4, $00), $00)
                rotateentity(local0\Field0, entitypitch(local0\Field4, $00), entityyaw(local0\Field4, $00), 0.0, $00)
            Case $04
                rotateentity(local0\Field4, 0.0, entityyaw(local0\Field4, $00), 0.0, $01)
                If (1.0 = local0\Field9) Then
                    moveentity(local0\Field4, 0.0, 0.0, (0.015 * fpsfactor))
                    animate2(local0\Field0, animtime(local0\Field0), $00, $0E, 0.15)
                EndIf
                positionentity(local0\Field0, entityx(local0\Field4, $00), (entityy(local0\Field4, $00) - 0.25), entityz(local0\Field4, $00), $00)
                rotateentity(local0\Field0, entitypitch(local0\Field4, $00), entityyaw(local0\Field4, $00), 0.0, $00)
            Case $06
                If (playerroom\Field7\Field4 <> "pocketdimension") Then
                    If (local0\Field19 <> 0) Then
                        hideentity(local0\Field0)
                        If (((rand($32, $01) = $01) And ((-5.0 > blinktimer) And (-15.0 < blinktimer))) <> 0) Then
                            showentity(local0\Field0)
                            local7 = (entityyaw(collider, $00) + rnd(-90.0, 90.0))
                            local6 = rnd(1.5, 2.0)
                            positionentity(local0\Field4, (entityx(collider, $00) + (sin(local7) * local6)), (entityy(collider, $00) + 0.2), (entityz(collider, $00) + (cos(local7) * local6)), $00)
                            local0\Field19 = $00
                            local0\Field9 = (Float rand($14, $3C))
                            If (rand($12C, $01) = $01) Then
                                playsound2(rustlesfx(rand($00, $02)), camera, local0\Field0, 8.0, rnd(0.0, 0.2), $01)
                            EndIf
                        EndIf
                    Else
                        positionentity(local0\Field0, (entityx(local0\Field4, $00) + rnd(-0.005, 0.005)), ((entityy(local0\Field4, $00) + 0.3) + (0.1 * sin((Float (millisecs() Sar $01))))), (entityz(local0\Field4, $00) + rnd(-0.005, 0.005)), $00)
                        rotateentity(local0\Field0, 0.0, entityyaw(local0\Field4, $00), (Float ((millisecs() / $05) Mod $168)), $00)
                        animate2(local0\Field0, animtime(local0\Field0), $20, $71, 0.4)
                        If (entityinview(local0\Field0, camera) <> 0) Then
                            achv372 = $01
                            If (rand($1E, $01) = $01) Then
                                If (channelplaying(local0\Field15) = $00) Then
                                    If (entityvisible(camera, local0\Field0) <> 0) Then
                                        local0\Field15 = playsound2(rustlesfx(rand($00, $02)), camera, local0\Field0, 8.0, 0.3, $01)
                                    EndIf
                                EndIf
                            EndIf
                            local9 = createpivot($00)
                            positionentity(local9, entityx(collider, $00), entityy(collider, $00), entityz(collider, $00), $00)
                            pointentity(local9, local0\Field4, 0.0)
                            local7 = wrapangle((entityyaw(collider, $00) - entityyaw(local9, $00)))
                            If (180.0 > local7) Then
                                rotateentity(local0\Field4, 0.0, (entityyaw(collider, $00) - 80.0), 0.0, $00)
                            Else
                                rotateentity(local0\Field4, 0.0, (entityyaw(collider, $00) + 80.0), 0.0, $00)
                            EndIf
                            freeentity(local9)
                            moveentity(local0\Field4, 0.0, 0.0, (0.03 * fpsfactor))
                            local0\Field9 = (local0\Field9 - fpsfactor)
                        EndIf
                        local0\Field9 = (local0\Field9 - (fpsfactor / 80.0))
                        If (0.0 >= local0\Field9) Then
                            local0\Field19 = $01
                        EndIf
                    EndIf
                EndIf
                local0\Field7 = 0.0
                resetentity(local0\Field4)
            Case $07
                local6 = entitydistance(collider, local0\Field4)
                If (60.0 > local6) Then
                    If (playerroom\Field7\Field4 = "exit1") Then
                        local20 = max(min((entitydistance(local0\Field4, playerroom\Field11[$03]) / (8000.0 * roomscale)), 1.0), 0.0)
                    Else
                        local20 = 1.0
                    EndIf
                    local0\Field15 = loopsound2(apachesfx, local0\Field15, camera, local0\Field4, 50.0, local20)
                EndIf
                local0\Field7 = 0.0
                Select local0\Field9
                    Case 0.0
                    Case 1.0
                        turnentity(local0\Field1, 0.0, (20.0 * fpsfactor), 0.0, $00)
                        turnentity(local0\Field2, (20.0 * fpsfactor), 0.0, 0.0, $00)
                        If (30.0 > (Abs (entityx(collider, $00) - entityx(local0\Field4, $00)))) Then
                            If (30.0 > (Abs (entityz(collider, $00) - entityz(local0\Field4, $00)))) Then
                                If (20.0 > (Abs (entityy(collider, $00) - entityy(local0\Field4, $00)))) Then
                                    If (rand($14, $01) = $01) Then
                                        If (entityvisible(collider, local0\Field4) <> 0) Then
                                            local0\Field9 = 2.0
                                            playsound2(alarmsfx($02), camera, local0\Field4, 50.0, 1.0, $01)
                                        EndIf
                                    EndIf
                                EndIf
                            EndIf
                        EndIf
                    Case 2.0,3.0
                        If (2.0 = local0\Field9) Then
                            local22 = collider
                        ElseIf (3.0 = local0\Field9) Then
                            local22 = createpivot($00)
                            positionentity(local22, local0\Field28, local0\Field29, local0\Field30, $01)
                        EndIf
                        turnentity(local0\Field1, 0.0, (20.0 * fpsfactor), 0.0, $00)
                        turnentity(local0\Field2, (20.0 * fpsfactor), 0.0, 0.0, $00)
                        If (55.0 > (Abs (entityx(local22, $00) - entityx(local0\Field4, $00)))) Then
                            If (55.0 > (Abs (entityz(local22, $00) - entityz(local0\Field4, $00)))) Then
                                If (20.0 > (Abs (entityy(local22, $00) - entityy(local0\Field4, $00)))) Then
                                    pointentity(local0\Field0, local22, 0.0)
                                    rotateentity(local0\Field4, curveangle(min(wrapangle(entitypitch(local0\Field0, $00)), 40.0), entitypitch(local0\Field4, $00), 40.0), curveangle(entityyaw(local0\Field0, $00), entityyaw(local0\Field4, $00), 90.0), entityroll(local0\Field4, $00), $01)
                                    positionentity(local0\Field4, entityx(local0\Field4, $00), curvevalue((entityy(local22, $00) + 8.0), entityy(local0\Field4, $00), 70.0), entityz(local0\Field4, $00), $00)
                                    local6 = distance(entityx(local22, $00), entityz(local22, $00), entityx(local0\Field4, $00), entityz(local0\Field4, $00))
                                    local0\Field18 = curvevalue((min((local6 - 6.5), 6.5) * 0.008), local0\Field18, 50.0)
                                    moveentity(local0\Field4, 0.0, 0.0, (local0\Field18 * fpsfactor))
                                    If (0.0 = local0\Field33) Then
                                        local0\Field32 = entityvisible(local0\Field4, local22)
                                        local0\Field33 = (Float rand($64, $C8))
                                    Else
                                        local0\Field33 = min((local0\Field33 - fpsfactor), 0.0)
                                    EndIf
                                    If (local0\Field32 = $01) Then
                                        rotateentity(local0\Field4, entitypitch(local0\Field4, $00), entityyaw(local0\Field4, $00), curveangle(0.0, entityroll(local0\Field4, $00), 40.0), $01)
                                        If (0.0 >= local0\Field20) Then
                                            If (20.0 > local6) Then
                                                local12 = createpivot($00)
                                                positionentity(local12, entityx(local0\Field4, $00), entityy(local0\Field4, $00), entityz(local0\Field4, $00), $00)
                                                rotateentity(local12, entitypitch(local0\Field4, $00), entityyaw(local0\Field4, $00), entityroll(local0\Field4, $00), $00)
                                                moveentity(local12, 0.0, (1.0 / 4.831696), 1.675444)
                                                pointentity(local12, local22, 0.0)
                                                If (10.0 > wrapangle((entityyaw(local12, $00) - entityyaw(local0\Field4, $00)))) Then
                                                    playsound2(gunshot2sfx, camera, local0\Field4, 20.0, 1.0, $01)
                                                    shoot(entityx(local12, $00), entityy(local12, $00), entityz(local12, $00), (entitypitch(local12, $00) + rnd(-2.0, 2.0)), (entityyaw(local0\Field4, $00) + rnd(-2.0, 2.0)), 20.0, (2.0 = local0\Field9))
                                                    local0\Field20 = 5.0
                                                EndIf
                                                freeentity(local12)
                                            EndIf
                                        EndIf
                                    Else
                                        rotateentity(local0\Field4, entitypitch(local0\Field4, $00), entityyaw(local0\Field4, $00), curveangle(-20.0, entityroll(local0\Field4, $00), 40.0), $01)
                                    EndIf
                                    moveentity(local0\Field4, ((- entityroll(local0\Field4, $00)) * 0.002), 0.0, 0.0)
                                    local0\Field20 = (local0\Field20 - fpsfactor)
                                EndIf
                            EndIf
                        EndIf
                        If (3.0 = local0\Field9) Then
                            freeentity(local22)
                        EndIf
                    Case 4.0
                        If (300.0 > local0\Field10) Then
                            turnentity(local0\Field1, 0.0, (20.0 * fpsfactor), 0.0, $00)
                            turnentity(local0\Field2, (20.0 * fpsfactor), 0.0, 0.0, $00)
                            turnentity(local0\Field4, 0.0, ((- fpsfactor) * 7.0), 0.0, $00)
                            local0\Field10 = ((fpsfactor * 0.3) + local0\Field10)
                            local22 = createpivot($00)
                            positionentity(local22, local0\Field28, local0\Field29, local0\Field30, $01)
                            pointentity(local0\Field0, local22, 0.0)
                            moveentity(local0\Field0, 0.0, 0.0, ((fpsfactor * 0.001) * local0\Field10))
                            positionentity(local0\Field4, entityx(local0\Field0, $00), entityy(local0\Field0, $00), entityz(local0\Field0, $00), $00)
                            If (0.3 > entitydistance(local0\Field0, local22)) Then
                                If (tempsound2 <> $00) Then
                                    freesound(tempsound2)
                                    tempsound2 = $00
                                EndIf
                                tempsound2 = loadsound("SFX\apachecrash2.ogg")
                                camerashake = max(camerashake, 3.0)
                                playsound(tempsound2)
                                local0\Field9 = 5.0
                            EndIf
                            freeentity(local22)
                        EndIf
                End Select
                positionentity(local0\Field0, entityx(local0\Field4, $00), entityy(local0\Field4, $00), entityz(local0\Field4, $00), $00)
                rotateentity(local0\Field0, entitypitch(local0\Field4, $00), entityyaw(local0\Field4, $00), entityroll(local0\Field4, $00), $01)
        End Select
        If ((hidedistance * 0.7) > distance(entityx(collider, $00), entityz(collider, $00), entityx(local0\Field4, $00), entityz(local0\Field4, $00))) Then
            translateentity(local0\Field4, 0.0, local0\Field7, 0.0, $00)
            local23 = $00
            For local5 = $01 To countcollisions(local0\Field4) Step $01
                If ((entityy(local0\Field4, $00) - 0.01) > collisiony(local0\Field4, local5)) Then
                    local23 = $01
                EndIf
            Next
            If (local23 = $01) Then
                local0\Field7 = 0.0
            Else
                local0\Field7 = max((local0\Field7 - (0.001 * fpsfactor)), -0.1)
            EndIf
        Else
            local0\Field7 = 0.0
        EndIf
    Next
    Return $00
End Function
