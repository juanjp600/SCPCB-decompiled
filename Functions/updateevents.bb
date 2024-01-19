Function updateevents%()
    Local local0#
    Local local1%
    Local local2%
    Local local3%
    Local local4#
    Local local5.rooms
    Local local6.events
    Local local8#
    Local local9#
    Local local10.emitters
    Local local11%
    Local local12.decals
    Local local15#
    Local local16.items
    Local local17$
    For local5 = Each rooms
        If (((12.0 > (Abs (entityx(collider, $00) - entityx(local5\Field1, $00)))) And (12.0 > (Abs (entityz(collider, $00) - entityz(local5\Field1, $00))))) <> 0) Then
            mapfound(playerlevel, (Int floor((entityx(local5\Field1, $00) / 8.0))), (Int floor((entityz(local5\Field1, $00) / 8.0)))) = (Int max((Float mapfound(playerlevel, (Int floor((entityx(local5\Field1, $00) / 8.0))), (Int floor((entityz(local5\Field1, $00) / 8.0))))), 1.0))
            If (((4.0 > (Abs (entityx(collider, $00) - entityx(local5\Field1, $00)))) And (4.0 > (Abs (entityz(collider, $00) - entityz(local5\Field1, $00))))) <> 0) Then
                If (1.5 > (Abs (entityy(collider, $00) - entityy(local5\Field1, $00)))) Then
                    playerroom = local5
                EndIf
                mapfound(playerlevel, (Int floor((entityx(local5\Field1, $00) / 8.0))), (Int floor((entityz(local5\Field1, $00) / 8.0)))) = $02
            EndIf
        EndIf
    Next
    For local6 = Each events
        Select local6\Field0
            Case "alarm"
                If (0.0 = local6\Field2) Then
                    If (playerroom = local6\Field1) Then
                        showentity(fog)
                        ambientlight((Float brightness), (Float brightness), (Float brightness))
                        camerafogrange(camera, camerafognear, camerafogfar)
                        camerafogmode(camera, $01)
                        local6\Field2 = 1.0
                    EndIf
                Else
                    local6\Field2 = (local6\Field2 + fpsfactor)
                    If (500.0 < local6\Field2) Then
                        If (((520.0 < local6\Field2) And (520.0 >= (local6\Field2 - fpsfactor))) <> 0) Then
                            blinktimer = 0.0
                        EndIf
                        If (2000.0 > local6\Field2) Then
                            If (local6\Field4 = $00) Then
                                local6\Field4 = playsound(alarmsfx($00))
                            ElseIf (channelplaying(local6\Field4) = $00) Then
                                local6\Field4 = playsound(alarmsfx($00))
                            EndIf
                            If (rand($258, $01) = $01) Then
                                playsound(introsfx(rand($07, $09)))
                            EndIf
                            If (rand($190, $01) = $01) Then
                                playsound(introsfx(rand($0D, $0E)))
                            EndIf
                        Else
                            If (rand($4B0, $01) = $01) Then
                                playsound(introsfx(rand($07, $09)))
                            EndIf
                            If (rand($320, $01) = $01) Then
                                playsound(introsfx(rand($0D, $0E)))
                            EndIf
                        EndIf
                        If (((900.0 < local6\Field2) And (900.0 >= (local6\Field2 - fpsfactor))) <> 0) Then
                            playsound(alarmsfx($01))
                        EndIf
                        If (((2000.0 < local6\Field2) And (2000.0 >= (local6\Field2 - fpsfactor))) <> 0) Then
                            playsound(introsfx($07))
                        EndIf
                        If (3500.0 < local6\Field2) Then
                            playsound(introsfx($07))
                            Delete local6
                        EndIf
                    EndIf
                EndIf
            Case "room173"
                shouldplay = $42
                If (0.0 <= killtimer) Then
                    If (0.0 = local6\Field2) Then
                        If (playerroom = local6\Field1) Then
                            camerafogmode(camera, $00)
                            ambientlight(250.0, 250.0, 250.0)
                            hideentity(fog)
                            curr173\Field12 = $01
                            local6\Field1\Field12[$00] = createnpc($03, entityx(local6\Field1\Field10[$00], $01), entityy(local6\Field1\Field10[$00], $01), entityz(local6\Field1\Field10[$00], $01))
                            local6\Field1\Field12[$00]\Field8 = 180.0
                            local6\Field1\Field12[$01] = createnpc($04, entityx(local6\Field1\Field10[$01], $01), 0.5, entityz(local6\Field1\Field10[$01], $01))
                            pointentity(local6\Field1\Field12[$01]\Field2, local6\Field1\Field10[$05], 0.0)
                            local6\Field1\Field12[$02] = createnpc($04, entityx(local6\Field1\Field10[$02], $01), 0.5, entityz(local6\Field1\Field10[$02], $01))
                            pointentity(local6\Field1\Field12[$02]\Field2, local6\Field1\Field10[$05], 0.0)
                            positionentity(curr173\Field2, entityx(local6\Field1\Field10[$05], $01), 0.5, entityz(local6\Field1\Field10[$05], $01), $00)
                            resetentity(curr173\Field2)
                            local6\Field2 = 1.0
                        EndIf
                    ElseIf (10000.0 > local6\Field2) Then
                        local6\Field2 = min(((fpsfactor / 3.0) + local6\Field2), 5000.0)
                        If (((100.0 < local6\Field2) And (100.0 > (local6\Field2 - fpsfactor))) = 0) Then
                            If (((130.0 <= local6\Field2) And (130.0 > (local6\Field2 - fpsfactor))) <> 0) Then
                                playsound(introsfx($00))
                            ElseIf (230.0 < local6\Field2) Then
                                local3 = $01
                                For local2 = $01 To $02 Step $01
                                    If (0.3 < distance(entityx(local6\Field1\Field12[local2]\Field2, $00), entityz(local6\Field1\Field12[local2]\Field2, $00), entityx(local6\Field1\Field10[(local2 + $02)], $01), entityz(local6\Field1\Field10[(local2 + $02)], $01))) Then
                                        pointentity(local6\Field1\Field12[local2]\Field2, local6\Field1\Field10[(local2 + $02)], 0.0)
                                        If ((Float ((local2 * $1E) + $C8)) < local6\Field2) Then
                                            local6\Field1\Field12[local2]\Field6 = 1.0
                                        EndIf
                                        local3 = $00
                                    Else
                                        local6\Field1\Field12[local2]\Field6 = 0.0
                                        pointentity(local6\Field1\Field12[local2]\Field2, local6\Field1\Field10[$05], 0.0)
                                    EndIf
                                Next
                                If (entityx(collider, $00) < (entityx(local6\Field1\Field1, $00) + (408.0 * roomscale))) Then
                                    If (((450.0 < local6\Field2) And (450.0 > (local6\Field2 - fpsfactor))) <> 0) Then
                                        playsound(introsfx($04))
                                    ElseIf (((650.0 < local6\Field2) And (650.0 > (local6\Field2 - fpsfactor))) <> 0) Then
                                        playsound(introsfx($05))
                                    ElseIf (((800.0 < local6\Field2) And (800.0 > (local6\Field2 - fpsfactor))) <> 0) Then
                                        usedoor(local6\Field1\Field11[$01])
                                        playsound(introsfx($06))
                                    ElseIf (900.0 < local6\Field2) Then
                                        local6\Field1\Field12[$00]\Field6 = 1.0
                                        Delete local6
                                        Exit
                                    EndIf
                                    If (800.0 < local6\Field2) Then
                                        positionentity(collider, min(entityx(collider, $00), (entityx(local6\Field1\Field1, $00) + (352.0 * roomscale))), entityy(collider, $00), entityz(collider, $00), $00)
                                    EndIf
                                ElseIf (local3 = $01) Then
                                    local6\Field2 = 10000.0
                                    usedoor(local6\Field1\Field11[$01])
                                EndIf
                            EndIf
                        EndIf
                        positionentity(curr173\Field2, entityx(local6\Field1\Field10[$05], $01), entityy(curr173\Field2, $00), entityz(local6\Field1\Field10[$05], $01), $00)
                        rotateentity(curr173\Field2, 0.0, 0.0, 0.0, $01)
                        resetentity(curr173\Field2)
                    ElseIf (14000.0 > local6\Field2) Then
                        local6\Field2 = min((local6\Field2 + fpsfactor), 13000.0)
                        If (10300.0 > (local6\Field2 - fpsfactor)) Then
                            positionentity(collider, max(entityx(collider, $00), (entityx(local6\Field1\Field1, $00) + (352.0 * roomscale))), entityy(collider, $00), entityz(collider, $00), $00)
                        EndIf
                        If (((10300.0 < local6\Field2) And (10300.0 > (local6\Field2 - fpsfactor))) <> 0) Then
                            playsound(introsfx($01))
                            positionentity(collider, max(entityx(collider, $00), (entityx(local6\Field1\Field1, $00) + (352.0 * roomscale))), entityy(collider, $00), entityz(collider, $00), $00)
                        ElseIf (((10440.0 < local6\Field2) And (10440.0 > (local6\Field2 - fpsfactor))) <> 0) Then
                            usedoor(local6\Field1\Field11[$01])
                            playsound(introsfx($07))
                        ElseIf (((10740.0 < local6\Field2) And (10740.0 > (local6\Field2 - fpsfactor))) <> 0) Then
                            playsound(introsfx($02))
                        ElseIf (((11490.0 < local6\Field2) And (11490.0 > (local6\Field2 - fpsfactor))) <> 0) Then
                            playsound(introsfx($0A))
                        ElseIf (((11561.0 < local6\Field2) And (11561.0 > (local6\Field2 - fpsfactor))) <> 0) Then
                            local6\Field2 = 14000.0
                        EndIf
                        positionentity(curr173\Field2, entityx(local6\Field1\Field10[$05], $01), entityy(curr173\Field2, $00), entityz(local6\Field1\Field10[$05], $01), $00)
                        rotateentity(curr173\Field2, 0.0, 0.0, 0.0, $01)
                        resetentity(curr173\Field2)
                    ElseIf (20000.0 > local6\Field2) Then
                        local6\Field2 = min((local6\Field2 + fpsfactor), 19000.0)
                        If (14100.0 > local6\Field2) Then
                            If (14005.0 < local6\Field2) Then
                                setanimtime(local6\Field1\Field12[$01]\Field0, 171.0, $00)
                                positionentity(curr173\Field2, entityx(local6\Field1\Field12[$01]\Field0, $00), entityy(curr173\Field2, $00), entityz(local6\Field1\Field12[$01]\Field0, $00), $00)
                                resetentity(curr173\Field2)
                                pointentity(curr173\Field2, local6\Field1\Field12[$02]\Field2, 0.0)
                            EndIf
                            pointentity(local6\Field1\Field12[$02]\Field2, curr173\Field2, 0.0)
                            If (14030.0 > local6\Field2) Then
                                blinktimer = -10.0
                                lightblink = 1.0
                            EndIf
                            If (((14032.0 < local6\Field2) And (14032.0 > (local6\Field2 - fpsfactor))) <> 0) Then
                                playsound(horrorsfx($02))
                            EndIf
                            If (((14080.0 < local6\Field2) And (14080.0 > (local6\Field2 - fpsfactor))) <> 0) Then
                                playsound(introsfx($0C))
                            EndIf
                            camerashake = 3.0
                        ElseIf (14200.0 > local6\Field2) Then
                            If (14105.0 < local6\Field2) Then
                                setanimtime(local6\Field1\Field12[$02]\Field0, 171.0, $00)
                                positionentity(curr173\Field2, entityx(local6\Field1\Field12[$02]\Field0, $00), entityy(curr173\Field2, $00), entityz(local6\Field1\Field12[$02]\Field0, $00), $00)
                                resetentity(curr173\Field2)
                                pointentity(curr173\Field2, collider, 0.0)
                            EndIf
                            If (14130.0 > local6\Field2) Then
                                blinktimer = -10.0
                                lightblink = 1.0
                            Else
                                curr173\Field12 = $00
                            EndIf
                            If (((14100.0 < local6\Field2) And (14100.0 > (local6\Field2 - fpsfactor))) <> 0) Then
                                playsound(introsfx($08))
                            EndIf
                            If (14150.0 > local6\Field2) Then
                                camerashake = 5.0
                            EndIf
                        ElseIf (14300.0 < local6\Field2) Then
                            If (((14600.0 < local6\Field2) And (14700.0 > local6\Field2)) <> 0) Then
                                blinktimer = -10.0
                                lightblink = 1.0
                            EndIf
                            If (entityx(collider, $00) < (entityx(local6\Field1\Field1, $00) + (448.0 * roomscale))) Then
                                local6\Field2 = 20000.0
                            EndIf
                        EndIf
                    ElseIf (30000.0 > local6\Field2) Then
                        local6\Field2 = min((local6\Field2 + fpsfactor), 30000.0)
                        If (20100.0 > local6\Field2) Then
                            camerashake = 2.0
                        ElseIf (20200.0 > local6\Field2) Then
                            If (((20105.0 < local6\Field2) And (20105.0 > (local6\Field2 - fpsfactor))) <> 0) Then
                                playsound(introsfx($09))
                            EndIf
                            If (20105.0 < local6\Field2) Then
                                curr173\Field12 = $01
                                pointentity(local6\Field1\Field12[$00]\Field2, curr173\Field0, 0.0)
                                positionentity(curr173\Field2, (entityx(local6\Field1\Field1, $00) - (448.0 * roomscale)), (entityy(local6\Field1\Field1, $00) + (480.0 * roomscale)), (entityz(local6\Field1\Field1, $00) + (1398.0 * roomscale)), $00)
                                resetentity(curr173\Field2)
                                pointentity(curr173\Field2, local6\Field1\Field12[$00]\Field2, 0.0)
                            EndIf
                            blinktimer = -10.0
                            lightblink = 1.0
                            camerashake = 3.0
                        ElseIf (20300.0 > local6\Field2) Then
                            pointentity(local6\Field1\Field12[$00]\Field2, curr173\Field2, 0.0)
                            moveentity(local6\Field1\Field12[$00]\Field2, 0.0, 0.0, -0.002)
                            local6\Field1\Field12[$00]\Field6 = 2.0
                            If (((20260.0 < local6\Field2) And (20260.0 > (local6\Field2 - fpsfactor))) <> 0) Then
                                playsound(introsfx($0C))
                            EndIf
                        ElseIf (20300.0 > (local6\Field2 - fpsfactor)) Then
                            blinktimer = -10.0
                            lightblink = 1.0
                            camerashake = 3.0
                            playsound(introsfx($0B))
                            curr173\Field12 = $00
                            removenpc(local6\Field1\Field12[$00])
                            playsound(introsfx($0F))
                            positionentity(curr173\Field2, (entityx(playerroom\Field1, $00) - (400.0 * roomscale)), 100.0, (entityz(playerroom\Field1, $00) + (1072.0 * roomscale)), $00)
                            resetentity(curr173\Field2)
                            For local5 = Each rooms
                                If (local5\Field6\Field4 = "start") Then
                                    local8 = entityx(local5\Field1, $01)
                                    local9 = entityz(local5\Field1, $01)
                                    positionentity(collider, ((entityx(collider, $00) - entityx(local6\Field1\Field1, $00)) + local8), 1.0, ((entityz(collider, $00) - entityz(local6\Field1\Field1, $00)) + local9), $00)
                                    resetentity(collider)
                                    positionentity(curr173\Field2, ((entityx(curr173\Field2, $00) - entityx(local6\Field1\Field1, $00)) + local8), entityy(curr173\Field2, $00), ((entityz(curr173\Field2, $00) - entityz(local6\Field1\Field1, $00)) + local9), $00)
                                    resetentity(curr173\Field2)
                                    For local2 = $01 To $02 Step $01
                                        positionentity(local6\Field1\Field12[local2]\Field2, ((entityx(local6\Field1\Field12[local2]\Field2, $00) - entityx(local6\Field1\Field1, $00)) + local8), 1.0, ((entityz(local6\Field1\Field12[local2]\Field2, $00) - entityz(local6\Field1\Field1, $00)) + local9), $00)
                                        resetentity(local6\Field1\Field12[local2]\Field2)
                                    Next
                                    showentity(fog)
                                    ambientlight((Float brightness), (Float brightness), (Float brightness))
                                    camerafogrange(camera, camerafognear, camerafogfar)
                                    camerafogmode(camera, $01)
                                    Delete local6
                                    Exit
                                EndIf
                            Next
                        EndIf
                    EndIf
                Else
                    Delete local6
                EndIf
            Case "room2doors173"
                If (0.0 = local6\Field2) Then
                    If (playerroom = local6\Field1) Then
                        If (entityinview(curr173\Field0, camera) = $00) Then
                            local6\Field2 = 1.0
                            positionentity(curr173\Field2, entityx(local6\Field1\Field10[$00], $01), 0.5, entityz(local6\Field1\Field10[$00], $01), $00)
                            resetentity(curr173\Field2)
                            Delete local6
                        EndIf
                    EndIf
                EndIf
            Case "buttghost"
                If (playerroom = local6\Field1) Then
                    debuglog("aaaaaaaa")
                    If (1.8 > entitydistance(collider, local6\Field1\Field10[$00])) Then
                        debuglog("beeeeeeeeeeeeeeee")
                        playsound2(buttghostsfx, camera, local6\Field1\Field10[$00], 10.0, 1.0)
                        Delete local6
                    EndIf
                EndIf
            Case "testroom173"
                If (playerroom = local6\Field1) Then
                    If (0.0 = local6\Field2) Then
                        positionentity(curr173\Field2, entityx(local6\Field1\Field10[$00], $01), 0.5, entityz(local6\Field1\Field10[$00], $01), $00)
                        resetentity(curr173\Field2)
                        local6\Field2 = 1.0
                    Else
                        local6\Field2 = (local6\Field2 + 1.0)
                        local0 = entitydistance(collider, local6\Field1\Field10[$01])
                        If (1.0 > local0) Then
                            local6\Field2 = max(local6\Field2, 840.0)
                        ElseIf (1.4 < local0) Then
                            If (840.0 < local6\Field2) Then
                                If ((entityinview(curr173\Field0, camera) Or (-10.0 >= blinktimer)) = $00) Then
                                    playsound2(glassbreaksfx, camera, curr173\Field0, 10.0, 1.0)
                                    freeentity(local6\Field1\Field10[$02])
                                    positionentity(curr173\Field2, entityx(local6\Field1\Field10[$01], $01), 0.5, entityz(local6\Field1\Field10[$01], $01), $00)
                                    resetentity(curr173\Field2)
                                    Delete local6
                                EndIf
                            EndIf
                        EndIf
                    EndIf
                EndIf
            Case "testroom"
                If (0.0 = local6\Field2) Then
                    If (playerroom = local6\Field1) Then
                        If (2.5 > entitydistance(collider, local6\Field1\Field10[$06])) Then
                            playsound(msg079)
                            For local2 = $00 To $05 Step $01
                                local10 = createemitter(entityx(local6\Field1\Field10[local2], $01), entityy(local6\Field1\Field10[local2], $01), entityz(local6\Field1\Field10[local2], $01), $00)
                                turnentity(local10\Field0, 90.0, 0.0, 0.0, $01)
                                local10\Field10 = 5.0
                                local10\Field9 = 0.042
                                local10\Field11 = (1.0 / 400.0)
                            Next
                            local6\Field2 = 1.0
                            Delete local6
                        EndIf
                    EndIf
                EndIf
            Case "pj"
                If (0.0 = local6\Field2) Then
                    If (playerroom = local6\Field1) Then
                        If (2.5 > entitydistance(collider, local6\Field1\Field1)) Then
                            playsound(rustlesfx(rand($00, $02)))
                            createnpc($06, 0.0, 0.0, 0.0)
                            local6\Field2 = 1.0
                            Delete local6
                        EndIf
                    EndIf
                EndIf
            Case "room2tunnel"
                If (0.0 = local6\Field2) Then
                    If (playerroom = local6\Field1) Then
                        local6\Field2 = 1.0
                    EndIf
                ElseIf (1.0 = local6\Field2) Then
                    If (0.9 > entitydistance(collider, local6\Field1\Field10[$00])) Then
                        curr106\Field6 = -0.1
                        local6\Field2 = 2.0
                    ElseIf (0.9 > entitydistance(collider, local6\Field1\Field10[$01])) Then
                        curr106\Field6 = -0.1
                        local6\Field2 = 3.0
                    EndIf
                ElseIf (2.0 = local6\Field2) Then
                    local0 = distance(entityx(collider, $00), entityz(collider, $00), entityx(local6\Field1\Field10[$01], $01), entityz(local6\Field1\Field10[$01], $01))
                    debuglog((Str local0))
                    If (1.0 > local0) Then
                        local11 = createpivot($00)
                        positionentity(local11, entityx(collider, $00), entityy(collider, $00), entityz(collider, $00), $00)
                        pointentity(local11, local6\Field1\Field10[$01], 0.0)
                        rotateentity(local11, 0.0, entityyaw(local11, $00), 0.0, $00)
                        moveentity(local11, 0.0, 0.0, (local0 + 3.0))
                        positionentity(curr106\Field2, entityx(local11, $00), entityy(local11, $00), entityz(local11, $00), $00)
                        freeentity(local11)
                        curr106\Field10 = $00
                        local6\Field2 = 4.0
                        Delete local6
                    EndIf
                ElseIf (3.0 = local6\Field2) Then
                    local0 = distance(entityx(collider, $00), entityz(collider, $00), entityx(local6\Field1\Field10[$00], $01), entityz(local6\Field1\Field10[$00], $01))
                    If (1.0 > local0) Then
                        local11 = createpivot($00)
                        positionentity(local11, entityx(collider, $00), entityy(collider, $00), entityz(collider, $00), $00)
                        pointentity(local11, local6\Field1\Field10[$00], 0.0)
                        rotateentity(local11, 0.0, entityyaw(local11, $00), 0.0, $00)
                        moveentity(local11, 0.0, 0.0, (local0 + 3.0))
                        positionentity(curr106\Field2, entityx(local11, $00), entityy(local11, $00), entityz(local11, $00), $00)
                        freeentity(local11)
                        curr106\Field10 = $00
                        local6\Field2 = 4.0
                        Delete local6
                    EndIf
                EndIf
            Case "room2pipes106"
                If (0.0 = local6\Field2) Then
                    If (playerroom = local6\Field1) Then
                        local6\Field2 = 1.0
                    EndIf
                Else
                    local6\Field2 = (local6\Field2 + fpsfactor)
                    positionentity(curr106\Field2, entityx(local6\Field1\Field10[$00], $01), entityy(collider, $00), entityz(local6\Field1\Field10[$00], $01), $00)
                    pointentity(curr106\Field2, local6\Field1\Field10[$01], 0.0)
                    moveentity(curr106\Field2, 0.0, 0.0, (entitydistance(local6\Field1\Field10[$00], local6\Field1\Field10[$01]) * (local6\Field2 / 100.0)))
                    positionentity(curr106\Field2, entityx(curr106\Field2, $00), (entityy(collider, $00) - 0.3), entityz(curr106\Field2, $00), $00)
                    animate2(curr106\Field0, animtime(curr106\Field0), $00, $0E, 0.2)
                    resetentity(curr106\Field2)
                    If (((0.3 < (local6\Field2 / 100.0)) And (0.3 >= ((local6\Field2 - fpsfactor) / 100.0))) <> 0) Then
                        playsound(horrorsfx($06))
                        blurtimer = 800.0
                        local12 = createdecal($00, entityx(local6\Field1\Field10[$02], $01), entityy(local6\Field1\Field10[$02], $01), entityz(local6\Field1\Field10[$02], $01), 0.0, (Float (local6\Field1\Field5 - $5A)), rnd(360.0, 0.0))
                        local12\Field6 = 90000.0
                        local12\Field4 = 0.01
                        local12\Field3 = 0.005
                        local12\Field2 = 0.1
                        local12\Field1 = 0.003
                    EndIf
                    If (((0.65 < (local6\Field2 / 100.0)) And (0.65 >= ((local6\Field2 - fpsfactor) / 100.0))) <> 0) Then
                        local12 = createdecal($00, entityx(local6\Field1\Field10[$03], $01), entityy(local6\Field1\Field10[$03], $01), entityz(local6\Field1\Field10[$03], $01), 0.0, (Float (local6\Field1\Field5 + $5A)), rnd(360.0, 0.0))
                        local12\Field6 = 90000.0
                        local12\Field4 = 0.01
                        local12\Field3 = 0.005
                        local12\Field2 = 0.1
                        local12\Field1 = 0.003
                    EndIf
                    curr106\Field12 = $01
                    If (100.0 < local6\Field2) Then
                        curr106\Field12 = $00
                        Delete local6
                    EndIf
                EndIf
            Case "room2pit106"
                If (0.0 = local6\Field2) Then
                    If (playerroom = local6\Field1) Then
                        local6\Field2 = 1.0
                    EndIf
                Else
                    local6\Field2 = (local6\Field2 + 1.0)
                    positionentity(curr106\Field2, entityx(local6\Field1\Field10[$07], $01), entityy(local6\Field1\Field10[$07], $01), entityz(local6\Field1\Field10[$07], $01), $00)
                    resetentity(curr106\Field2)
                    pointentity(curr106\Field2, camera, 0.0)
                    turnentity(curr106\Field2, 0.0, (sin((Float (millisecs() / $14))) * 6.0), 0.0, $01)
                    moveentity(curr106\Field2, 0.0, 0.0, (sin((Float (millisecs() / $0F))) * 0.06))
                    curr106\Field12 = $01
                    If (800.0 < local6\Field2) Then
                        If (-5.0 > blinktimer) Then
                            curr106\Field12 = $00
                            Delete local6
                        EndIf
                    EndIf
                EndIf
            Case "room2pit"
                If (0.0 = local6\Field2) Then
                    If (5.0 > distance(entityx(collider, $00), entityz(collider, $00), entityx(local6\Field1\Field1, $00), entityz(local6\Field1\Field1, $00))) Then
                        positionentity(curr173\Field2, entityx(local6\Field1\Field10[$06], $01), 0.5, entityz(local6\Field1\Field10[$06], $01), $00)
                        resetentity(curr173\Field2)
                        Delete local6
                    EndIf
                EndIf
            Case "coffin"
                local0 = entitydistance(camera, local6\Field1\Field10[$00])
                coffindistance = local0
            Case "coffin106"
                local0 = entitydistance(camera, local6\Field1\Field10[$00])
                coffindistance = local0
                If (0.0 = local6\Field2) Then
                    If (playerroom = local6\Field1) Then
                        If (shouldplay = $00) Then
                            shouldplay = $42
                        EndIf
                    ElseIf (shouldplay = $42) Then
                        shouldplay = $00
                    EndIf
                    If (1.5 > entitydistance(camera, local6\Field1\Field10[$00])) Then
                        curr106\Field6 = -0.1
                        local6\Field2 = 1.0
                    EndIf
                EndIf
            Case "tunnel106"
                If (0.0 = local6\Field2) Then
                    If (0.0 <= curr106\Field6) Then
                        If (5.0 > entitydistance(camera, local6\Field1\Field1)) Then
                            local12 = createdecal($00, entityx(local6\Field1\Field1, $00), 0.0011, entityz(local6\Field1\Field1, $00), 90.0, (Float rand($168, $01)), 0.0)
                            local12\Field2 = rnd(0.5, 0.7)
                            entityalpha(local12\Field0, 0.7)
                            local12\Field5 = $01
                            scalesprite(local12\Field0, local12\Field2, local12\Field2)
                            entityalpha(local12\Field0, rnd(0.7, 0.85))
                            local6\Field2 = 1.0
                        EndIf
                    EndIf
                Else
                    positionentity(curr106\Field2, (entityx(local6\Field1\Field1, $01) - (sin(((Float millisecs()) / 150.0)) / 4.0)), ((entityy(collider, $00) - 0.4) - ((sin(((Float millisecs()) / 100.0)) + 1.0) / 4.0)), (entityz(local6\Field1\Field1, $01) - (sin(((Float millisecs()) / 190.0)) / 4.0)), $00)
                    pointentity(curr106\Field2, camera, 0.0)
                    curr106\Field6 = -11.0
                    animate2(curr106\Field0, animtime(curr106\Field0), $CE, $FA, 0.1)
                    curr106\Field12 = $01
                    local0 = entitydistance(collider, curr106\Field2)
                    If (((3.5 > local0) Or (rand($1B58, $01) = $01)) <> 0) Then
                        curr106\Field12 = $00
                        Delete local6
                    ElseIf (8.0 < local0) Then
                        If (rand($05, $01) = $01) Then
                            curr106\Field12 = $00
                            Delete local6
                        Else
                            curr106\Field12 = $00
                            curr106\Field6 = -10000.0
                            Delete local6
                        EndIf
                    EndIf
                EndIf
            Case "statue"
                If (0.0 = local6\Field2) Then
                    If (playerroom = local6\Field1) Then
                        If (entityvisible(camera, local6\Field1\Field10[$00]) <> 0) Then
                            If (entityinview(local6\Field1\Field10[$00], camera) <> 0) Then
                                local6\Field2 = 1.0
                            EndIf
                        EndIf
                    EndIf
                ElseIf (1.0 = local6\Field2) Then
                    If (entityinview(local6\Field1\Field10[$00], camera) = $00) Then
                        local6\Field2 = 2.0
                        hideentity(local6\Field1\Field10[$00])
                        playsound(horrorsfx($00))
                    EndIf
                Else
                    local6\Field2 = (local6\Field2 + 1.0)
                    If (910.0 < local6\Field2) Then
                        showentity(local6\Field1\Field10[$00])
                        positionentity(local6\Field1\Field10[$00], entityx(camera, $01), entityy(camera, $01), entityz(camera, $01), $01)
                        rotateentity(local6\Field1\Field10[$00], (entitypitch(camera, $00) + 25.0), entityyaw(camera, $00), entityroll(camera, $00), $00)
                        moveentity(local6\Field1\Field10[$00], 0.0, 0.0, (1.0 - ((local6\Field2 - 910.0) / 240.0)))
                    EndIf
                    If (840.0 < local6\Field2) Then
                        If (0.0 <= killtimer) Then
                            kill()
                        EndIf
                    EndIf
                    If (1400.0 < local6\Field2) Then
                        Delete local6
                    EndIf
                EndIf
            Case "lockroom173"
                If (((0.0 = local6\Field2) And (rand($05, $01) = $01)) <> 0) Then
                    If (5.0 > distance(entityx(collider, $00), entityz(collider, $00), entityx(local6\Field1\Field1, $00), entityz(local6\Field1\Field1, $00))) Then
                        If (entityinview(curr106\Field0, camera) = $00) Then
                            local6\Field2 = 1.0
                            positionentity(curr173\Field2, ((cos((Float (local6\Field1\Field5 + $87))) * 2.0) + local6\Field1\Field2), (local6\Field1\Field3 + 1.0), ((sin((Float (local6\Field1\Field5 + $87))) * 2.0) + local6\Field1\Field4), $00)
                            resetentity(curr173\Field2)
                            Delete local6
                        EndIf
                    EndIf
                EndIf
            Case "pocketdimension"
                If (playerroom = local6\Field1) Then
                    shouldplay = $03
                    If (600.0 > local6\Field2) Then
                        blurtimer = 1000.0
                        blinktimer = (-10.0 - (local6\Field2 / 60.0))
                    EndIf
                    scaleentity(local6\Field1\Field1, roomscale, (((sin((local6\Field2 / 14.0)) * 0.2) + 1.0) * roomscale), roomscale, $00)
                    For local2 = $00 To $07 Step $01
                        scaleentity(local6\Field1\Field10[local2], (((Abs (sin(((local6\Field2 / 21.0) + ((Float local2) * 45.0))) * 0.1)) + 1.0) * roomscale), (((sin(((local6\Field2 / 14.0) + ((Float local2) * 20.0))) * 0.1) + 1.0) * roomscale), (((Abs (sin(((local6\Field2 / 14.0) + ((Float local2) * 90.0))) * 0.3)) + 1.5) * roomscale), $01)
                    Next
                    scaleentity(local6\Field1\Field10[$08], (((Abs (sin(((local6\Field2 / 21.0) + ((Float local2) * 45.0))) * 0.1)) + 1.5) * roomscale), (((sin(((local6\Field2 / 14.0) + ((Float local2) * 20.0))) * 0.1) + 1.0) * roomscale), (((Abs (sin(((local6\Field2 / 14.0) + ((Float local2) * 90.0))) * 0.1)) + 1.5) * roomscale), $01)
                    scaleentity(local6\Field1\Field10[$09], (((Abs (sin(((local6\Field2 / 21.0) + ((Float local2) * 45.0))) * 0.1)) + 1.5) * roomscale), (((sin(((local6\Field2 / 14.0) + ((Float local2) * 20.0))) * 0.1) + 1.0) * roomscale), (((Abs (sin(((local6\Field2 / 14.0) + ((Float local2) * 90.0))) * 0.1)) + 1.5) * roomscale), $01)
                    local6\Field2 = (local6\Field2 + fpsfactor)
                    If (4550.0 < local6\Field2) Then
                        If (rand($320, $01) = $01) Then
                            curr106\Field6 = -0.1
                            local6\Field2 = 601.0
                        EndIf
                    ElseIf (0.0 < curr106\Field6) Then
                        local4 = ((local6\Field2 / 10.0) Mod 360.0)
                        positionentity(curr106\Field2, entityx(local6\Field1\Field1, $00), 0.35, entityx(local6\Field1\Field1, $00), $00)
                        rotateentity(curr106\Field2, 0.0, local4, 0.0, $00)
                        moveentity(curr106\Field2, 0.0, 0.0, (6.0 - sin((local6\Field2 / 10.0))))
                        animate2(curr106\Field0, animtime(curr106\Field0), $00, $0E, 0.17)
                        rotateentity(curr106\Field2, 0.0, (local4 + 90.0), 0.0, $00)
                        If (0.3 > entitydistance(collider, curr106\Field2)) Then
                            curr106\Field12 = $00
                            curr106\Field6 = -1.0
                        EndIf
                    EndIf
                    If (1.0 = local6\Field3) Then
                        local0 = entitydistance(collider, local6\Field1\Field10[$08])
                        If (local0 > (1700.0 * roomscale)) Then
                            blinktimer = -10.0
                            Select rand($02, $01)
                                Case $01
                                    local3 = createpivot($00)
                                    positionentity(local3, entityx(collider, $00), entityy(collider, $00), entityz(collider, $00), $00)
                                    pointentity(local3, local6\Field1\Field10[$08], 0.0)
                                    moveentity(local3, 0.0, 0.0, (local0 * 1.9))
                                    positionentity(collider, entityx(local3, $00), entityy(collider, $00), entityz(local3, $00), $00)
                                    resetentity(collider)
                                    local4 = (Float ((Int (entityyaw(local3, $00) / 90.0)) * $5A))
                                    rotateentity(local3, 0.0, local4, 0.0, $00)
                                    moveentity(local3, 0.0, 0.0, 0.8)
                                    positionentity(local6\Field1\Field10[$0A], entityx(local3, $00), 0.0, entityz(local3, $00), $00)
                                    rotateentity(local6\Field1\Field10[$0A], 0.0, entityyaw(local3, $00), 0.0, $01)
                                    positionentity(local3, entityx(local6\Field1\Field10[$08], $00), 0.0, entityz(local6\Field1\Field10[$08], $00), $00)
                                    rotateentity(local3, 0.0, ((Float (rand($01, $03) * $5A)) + local4), 0.0, $00)
                                    moveentity(local3, 0.0, 0.0, (520.0 * roomscale))
                                    positionentity(local6\Field1\Field10[$09], entityx(local3, $00), 0.0, entityz(local3, $00), $00)
                                    freeentity(local3)
                                    debuglog("eee")
                                Case $02
                                    local3 = createpivot($00)
                                    positionentity(local3, entityx(local6\Field1\Field1, $00), entityy(local6\Field1\Field1, $00), entityz(local6\Field1\Field1, $00), $00)
                                    local4 = wrapangle((getangle(entityx(local6\Field1\Field10[$08], $00), entityz(local6\Field1\Field10[$08], $00), entityx(collider, $00), entityz(collider, $00)) - 22.5))
                                    debuglog((Str local4))
                                    local4 = (Float (Int (local4 / 90.0)))
                                    rotateentity(local3, 0.0, ((Float rand($00, $08)) * 45.0), 0.0, $00)
                                    moveentity(local3, 0.0, 0.0, (1400.0 * roomscale))
                                    positionentity(collider, entityx(local3, $00), entityy(collider, $00), entityz(local3, $00), $00)
                                    rotateentity(collider, 0.0, ((entityyaw(collider, $00) - (local4 * 45.0)) - 270.0), 0.0, $01)
                                    moveentity(local3, 0.0, 0.0, 0.8)
                                    positionentity(local6\Field1\Field10[$0A], entityx(local3, $00), 0.0, entityz(local3, $00), $00)
                                    rotateentity(local6\Field1\Field10[$0A], 0.0, entityyaw(local3, $00), 0.0, $01)
                                    resetentity(collider)
                                    freeentity(local3)
                                    debuglog("oooo")
                                    local6\Field3 = 0.0
                            End Select
                        EndIf
                    Else
                        local0 = entitydistance(collider, local6\Field1\Field1)
                        If (local0 > (1700.0 * roomscale)) Then
                            blinktimer = -10.0
                            Select rand($13, $01)
                                Case $01,$02,$03,$05,$06,$07
                                    playsound(oldmansfx($03))
                                    local3 = createpivot($00)
                                    positionentity(local3, entityx(collider, $00), entityy(collider, $00), entityz(collider, $00), $00)
                                    pointentity(local3, local6\Field1\Field1, 0.0)
                                    moveentity(local3, 0.0, 0.0, (local0 * 1.9))
                                    positionentity(collider, entityx(local3, $00), entityy(collider, $00), entityz(local3, $00), $00)
                                    resetentity(collider)
                                    moveentity(local3, 0.0, 0.0, 0.8)
                                    positionentity(local6\Field1\Field10[$0A], entityx(local3, $00), 0.0, entityz(local3, $00), $00)
                                    rotateentity(local6\Field1\Field10[$0A], 0.0, entityyaw(local3, $00), 0.0, $01)
                                    freeentity(local3)
                                Case $08,$09,$0A,$0B,$0C
                                    local6\Field3 = 1.0
                                    blinktimer = -10.0
                                    playsound(oldmansfx($03))
                                    local3 = createpivot($00)
                                    positionentity(local3, entityx(local6\Field1\Field10[$08], $00), entityy(local6\Field1\Field10[$08], $00), entityz(local6\Field1\Field10[$08], $00), $00)
                                    debuglog("---")
                                    local4 = wrapangle((getangle(entityx(local6\Field1\Field1, $00), entityz(local6\Field1\Field1, $00), entityx(collider, $00), entityz(collider, $00)) - 22.5))
                                    debuglog((Str local4))
                                    local4 = (Float (Int (local4 / 45.0)))
                                    debuglog((Str local4))
                                    debuglog((Str entityyaw(collider, $00)))
                                    moveentity(local3, 0.0, 0.0, (-1400.0 * roomscale))
                                    positionentity(collider, entityx(local3, $00), entityy(collider, $00), entityz(local3, $00), $00)
                                    rotateentity(collider, 0.0, ((entityyaw(collider, $00) - (local4 * 45.0)) - 270.0), 0.0, $01)
                                    resetentity(collider)
                                    moveentity(local3, 0.0, 0.0, -0.8)
                                    positionentity(local6\Field1\Field10[$0A], entityx(local3, $00), 0.0, entityz(local3, $00), $00)
                                    rotateentity(local6\Field1\Field10[$0A], 0.0, entityyaw(local3, $00), 0.0, $01)
                                    positionentity(local3, entityx(local6\Field1\Field10[$08], $00), 0.0, entityz(local6\Field1\Field10[$08], $00), $00)
                                    rotateentity(local3, 0.0, ((Float (rand($01, $03) * $5A)) + local4), 0.0, $00)
                                    moveentity(local3, 0.0, 0.0, (520.0 * roomscale))
                                    positionentity(local6\Field1\Field10[$09], entityx(local3, $00), 0.0, entityz(local3, $00), $00)
                                    freeentity(local3)
                                Case $0D,$0E,$0F
                                    blurtimer = 500.0
                                    local3 = createpivot($00)
                                    positionentity(local3, entityx(local6\Field1\Field1, $00), 0.5, entityz(local6\Field1\Field1, $00), $00)
                                Case $10,$11
                                    blurtimer = 1500.0
                                    For local5 = Each rooms
                                        If (local5\Field6\Field4 = "start") Then
                                            local6\Field2 = 0.0
                                            positionentity(collider, entityx(local5\Field1, $00), 0.4, entityz(local5\Field1, $00), $00)
                                            resetentity(collider)
                                            Exit
                                        EndIf
                                    Next
                                Case $12,$13
                                    blurtimer = 1500.0
                                    For local5 = Each rooms
                                        If (local5\Field6\Field4 = "room2offices") Then
                                            local6\Field2 = 0.0
                                            positionentity(collider, entityx(local5\Field1, $00), 0.4, entityz(local5\Field1, $00), $00)
                                            resetentity(collider)
                                            Exit
                                        EndIf
                                    Next
                            End Select
                        EndIf
                    EndIf
                Else
                    local6\Field2 = 0.0
                    local6\Field3 = 0.0
                EndIf
            Case "room2ccont"
                If (playerroom = local6\Field1) Then
                    entitypick(camera, 1.5)
                    For local2 = $01 To $05 Step $02
                        If (pickedentity() = local6\Field1\Field10[local2]) Then
                            drawhandicon = $01
                            If (mousehit1 <> 0) Then
                                grabbedentity = local6\Field1\Field10[local2]
                            EndIf
                            If (0.0 = local6\Field2) Then
                                If (local2 = $03) Then
                                    local6\Field2 = max(local6\Field2, 1.0)
                                    playsound(horrorsfx($07))
                                    playsound(leversfx)
                                EndIf
                            EndIf
                        EndIf
                        local15 = entitypitch(local6\Field1\Field10[local2], $00)
                        If ((mousedown1 Or mousehit1) <> 0) Then
                            If (grabbedentity <> $00) Then
                                If (grabbedentity = local6\Field1\Field10[local2]) Then
                                    drawhandicon = $01
                                    turnentity(local6\Field1\Field10[local2], (mouse_y_speed_1 * 2.5), 0.0, 0.0, $00)
                                    rotateentity(grabbedentity, max(min(entitypitch(local6\Field1\Field10[local2], $00), 85.0), -85.0), entityyaw(local6\Field1\Field10[local2], $00), 0.0, $00)
                                    drawarrowicon($00) = $01
                                    drawarrowicon($02) = $01
                                EndIf
                            EndIf
                        Else
                            If (0.0 < entitypitch(local6\Field1\Field10[local2], $00)) Then
                                rotateentity(local6\Field1\Field10[local2], curvevalue(85.0, entitypitch(local6\Field1\Field10[local2], $00), 10.0), entityyaw(local6\Field1\Field10[local2], $00), 0.0, $00)
                            Else
                                rotateentity(local6\Field1\Field10[local2], curvevalue(-85.0, entitypitch(local6\Field1\Field10[local2], $00), 10.0), entityyaw(local6\Field1\Field10[local2], $00), 0.0, $00)
                            EndIf
                            grabbedentity = $00
                        EndIf
                        If (83.0 < entitypitch(local6\Field1\Field10[local2], $00)) Then
                            If (83.0 >= local15) Then
                                playsound2(leversfx, camera, local6\Field1\Field10[local2], 10.0, 1.0)
                            EndIf
                            If (local2 = $03) Then
                                secondarylighton = curvevalue(1.0, secondarylighton, 10.0)
                                If (83.0 >= local15) Then
                                    playsound2(lightsfx, camera, local6\Field1\Field10[local2], 10.0, 1.0)
                                EndIf
                            Else
                                remotedooron = $01
                            EndIf
                        ElseIf (-83.0 > entitypitch(local6\Field1\Field10[local2], $00)) Then
                            If (-83.0 <= local15) Then
                                playsound2(leversfx, camera, local6\Field1\Field10[local2], 10.0, 1.0)
                            EndIf
                            If (local2 = $03) Then
                                If (-83.0 <= local15) Then
                                    playsound2(lightsfx, camera, local6\Field1\Field10[local2], 10.0, 1.0)
                                    For local5 = Each rooms
                                        For local9 = 0.0 To 19.0 Step 1.0
                                            If (local5\Field9[(Int local9)] <> $00) Then
                                                hideentity(local5\Field9[(Int local9)])
                                            EndIf
                                        Next
                                    Next
                                EndIf
                                secondarylighton = curvevalue(0.0, secondarylighton, 10.0)
                            Else
                                remotedooron = $00
                            EndIf
                        EndIf
                    Next
                    If (((0.0 < local6\Field2) And (200.0 > local6\Field2)) <> 0) Then
                        local6\Field2 = (local6\Field2 + fpsfactor)
                        rotateentity(local6\Field1\Field10[$03], curvevalue(-85.0, entitypitch(local6\Field1\Field10[$03], $00), 5.0), entityyaw(local6\Field1\Field10[$03], $00), 0.0, $00)
                    EndIf
                EndIf
            Case "914"
                If (playerroom = local6\Field1) Then
                    entitypick(camera, 1.0)
                    If (pickedentity() = local6\Field1\Field10[$00]) Then
                        drawhandicon = $01
                        If (mousehit1 <> 0) Then
                            grabbedentity = local6\Field1\Field10[$00]
                        EndIf
                    ElseIf (pickedentity() = local6\Field1\Field10[$01]) Then
                        drawhandicon = $01
                        If (mousehit1 <> 0) Then
                            grabbedentity = local6\Field1\Field10[$01]
                        EndIf
                    EndIf
                    If ((mousedown1 Or mousehit1) <> 0) Then
                        If (grabbedentity <> $00) Then
                            If (grabbedentity = local6\Field1\Field10[$00]) Then
                                If (0.0 = local6\Field2) Then
                                    drawhandicon = $01
                                    turnentity(grabbedentity, 0.0, 0.0, ((- mouse_x_speed_1) * 2.5), $00)
                                    local4 = wrapangle(entityroll(local6\Field1\Field10[$00], $00))
                                    If (181.0 < local4) Then
                                        drawarrowicon($03) = $01
                                    EndIf
                                    drawarrowicon($01) = $01
                                    If (90.0 > local4) Then
                                        rotateentity(grabbedentity, 0.0, 0.0, 361.0, $00)
                                    ElseIf (180.0 > local4) Then
                                        rotateentity(grabbedentity, 0.0, 0.0, 180.0, $00)
                                    EndIf
                                    If (((181.0 > local4) And (90.0 < local4)) <> 0) Then
                                        For local16 = Each items
                                            If (((local16\Field0 <> $00) And (local16\Field7 = $00)) <> 0) Then
                                                If (200.0 > (Abs (entityx(local16\Field0, $00) - (local6\Field1\Field2 - (712.0 * roomscale))))) Then
                                                    If (104.0 > (Abs (entityy(local16\Field0, $00) - ((648.0 * roomscale) + local6\Field1\Field3)))) Then
                                                        local6\Field2 = 1.0
                                                        local6\Field4 = playsound2(machinesfx, camera, local6\Field1\Field10[$01], 10.0, 1.0)
                                                        Exit
                                                    EndIf
                                                EndIf
                                            EndIf
                                        Next
                                    EndIf
                                EndIf
                            ElseIf (grabbedentity = local6\Field1\Field10[$01]) Then
                                If (0.0 = local6\Field2) Then
                                    drawhandicon = $01
                                    turnentity(grabbedentity, 0.0, 0.0, ((- mouse_x_speed_1) * 2.5), $00)
                                    local4 = wrapangle(entityroll(local6\Field1\Field10[$01], $00))
                                    drawarrowicon($03) = $01
                                    drawarrowicon($01) = $01
                                    If (90.0 < local4) Then
                                        If (180.0 > local4) Then
                                            rotateentity(grabbedentity, 0.0, 0.0, 90.0, $00)
                                        ElseIf (270.0 > local4) Then
                                            rotateentity(grabbedentity, 0.0, 0.0, 270.0, $00)
                                        EndIf
                                    EndIf
                                EndIf
                            EndIf
                        EndIf
                    Else
                        grabbedentity = $00
                    EndIf
                    local17 = ""
                    If (grabbedentity <> local6\Field1\Field10[$01]) Then
                        local4 = wrapangle(entityroll(local6\Field1\Field10[$01], $00))
                        If (22.5 > local4) Then
                            local4 = 0.0
                            local17 = "1:1"
                        ElseIf (67.5 > local4) Then
                            local4 = 45.0
                            local17 = "coarse"
                        ElseIf (180.0 > local4) Then
                            local4 = 90.0
                            local17 = "rough"
                        ElseIf (337.5 < local4) Then
                            local4 = -1.0
                            local17 = "1:1"
                        ElseIf (292.5 < local4) Then
                            local4 = -45.0
                            local17 = "fine"
                        Else
                            local4 = -90.0
                            local17 = "very fine"
                        EndIf
                        rotateentity(local6\Field1\Field10[$01], 0.0, 0.0, curvevalue(local4, entityroll(local6\Field1\Field10[$01], $00), 10.0), $00)
                    EndIf
                    For local2 = $00 To $01 Step $01
                        If (grabbedentity = local6\Field1\Field10[local2]) Then
                            If (entityinview(local6\Field1\Field10[local2], camera) = $00) Then
                                grabbedentity = $00
                            ElseIf (1.0 < entitydistance(local6\Field1\Field10[local2], camera)) Then
                                grabbedentity = $00
                            EndIf
                        EndIf
                    Next
                    If (0.0 < local6\Field2) Then
                        local6\Field2 = (local6\Field2 + fpsfactor)
                        rotateentity(local6\Field1\Field10[$00], entitypitch(local6\Field1\Field10[$00], $00), entityyaw(local6\Field1\Field10[$00], $00), 180.0, $00)
                        local6\Field1\Field11[$01]\Field5 = $00
                        If (140.0 < local6\Field2) Then
                            local6\Field1\Field11[$00]\Field5 = $00
                        EndIf
                        If ((170.0 * roomscale) > distance(entityx(collider, $00), entityz(collider, $00), entityx(local6\Field1\Field10[$02], $01), entityz(local6\Field1\Field10[$02], $01))) Then
                            If (((local17 = "rough") Or (local17 = "coarse")) <> 0) Then
                                If (((182.0 < local6\Field2) And (182.0 > (local6\Field2 - fpsfactor2))) <> 0) Then
                                    playsound(death914sfx)
                                EndIf
                            EndIf
                            If (210.0 < local6\Field2) Then
                                Select local17
                                    Case "rough","coarse"
                                        killtimer = min(-1.0, killtimer)
                                        blinktimer = -10.0
                                        If (local6\Field4 <> $00) Then
                                            stopchannel(local6\Field4)
                                        EndIf
                                    Case "1:1"
                                        blinktimer = -10.0
                                        If (210.0 > (local6\Field2 - fpsfactor2)) Then
                                            playsound(use914sfx)
                                        EndIf
                                    Case "fine","very fine"
                                        blinktimer = -10.0
                                        If (210.0 > (local6\Field2 - fpsfactor2)) Then
                                            playsound(use914sfx)
                                        EndIf
                                End Select
                            EndIf
                        EndIf
                        If (840.0 < local6\Field2) Then
                            For local16 = Each items
                                If (((local16\Field0 <> $00) And (local16\Field7 = $00)) <> 0) Then
                                    If ((180.0 * roomscale) > distance(entityx(local16\Field0, $00), entityz(local16\Field0, $00), entityx(local6\Field1\Field10[$02], $01), entityz(local6\Field1\Field10[$02], $01))) Then
                                        debuglog(((local16\Field1\Field0 + " - ") + local17))
                                        use914(local16, local17, entityx(local6\Field1\Field10[$03], $01), entityy(local6\Field1\Field10[$03], $01), entityz(local6\Field1\Field10[$03], $01))
                                    EndIf
                                EndIf
                            Next
                            If ((160.0 * roomscale) > distance(entityx(collider, $00), entityz(collider, $00), entityx(local6\Field1\Field10[$02], $01), entityz(local6\Field1\Field10[$02], $01))) Then
                                Select local17
                                    Case "1:1"
                                        invertmouse = (invertmouse = $00)
                                    Case "fine","very fine"
                                        superman = $01
                                End Select
                                blurtimer = 1000.0
                                positionentity(collider, entityx(local6\Field1\Field10[$03], $01), (entityy(local6\Field1\Field10[$03], $01) + 1.0), entityz(local6\Field1\Field10[$03], $01), $00)
                                resetentity(collider)
                                dropspeed = 0.0
                            EndIf
                            local6\Field1\Field11[$00]\Field5 = $01
                            local6\Field1\Field11[$01]\Field5 = $01
                            rotateentity(local6\Field1\Field10[$00], 0.0, 0.0, 0.0, $00)
                            local6\Field2 = 0.0
                        EndIf
                    EndIf
                EndIf
        End Select
    Next
    Return $00
End Function
