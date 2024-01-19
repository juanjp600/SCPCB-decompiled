Function updateevents%()
    Local local0#
    Local local1%
    Local local2%
    Local local3%
    Local local4.particles
    Local local5#
    Local local6.rooms
    Local local7.events
    Local local9#
    Local local10#
    Local local11.emitters
    Local local12%
    Local local13%
    Local local14.decals
    Local local17%
    Local local18%
    Local local19%
    Local local20%
    Local local21#
    Local local22.items
    Local local23$
    For local6 = Each rooms
        If (((12.0 > (Abs (entityx(collider, $00) - entityx(local6\Field1, $00)))) And (12.0 > (Abs (entityz(collider, $00) - entityz(local6\Field1, $00))))) <> 0) Then
            mapfound(playerlevel, (Int floor((entityx(local6\Field1, $00) / 8.0))), (Int floor((entityz(local6\Field1, $00) / 8.0)))) = (Int max((Float mapfound(playerlevel, (Int floor((entityx(local6\Field1, $00) / 8.0))), (Int floor((entityz(local6\Field1, $00) / 8.0))))), 1.0))
            If (((4.0 > (Abs (entityx(collider, $00) - entityx(local6\Field1, $00)))) And (4.0 > (Abs (entityz(collider, $00) - entityz(local6\Field1, $00))))) <> 0) Then
                If (1.5 > (Abs (entityy(collider, $00) - entityy(local6\Field1, $00)))) Then
                    playerroom = local6
                EndIf
                mapfound(playerlevel, (Int floor((entityx(local6\Field1, $00) / 8.0))), (Int floor((entityz(local6\Field1, $00) / 8.0)))) = $02
            EndIf
        EndIf
    Next
    For local7 = Each events
        Select local7\Field0
            Case "alarm"
                If (0.0 = local7\Field2) Then
                    If (playerroom = local7\Field1) Then
                        showentity(fog)
                        ambientlight((Float brightness), (Float brightness), (Float brightness))
                        camerafogrange(camera, camerafognear, camerafogfar)
                        camerafogmode(camera, $01)
                        local7\Field2 = 1.0
                    EndIf
                Else
                    local7\Field2 = (local7\Field2 + fpsfactor)
                    If (500.0 < local7\Field2) Then
                        If (((520.0 < local7\Field2) And (520.0 >= (local7\Field2 - fpsfactor))) <> 0) Then
                            blinktimer = 0.0
                        EndIf
                        If (2000.0 > local7\Field2) Then
                            If (local7\Field5 = $00) Then
                                local7\Field5 = playsound(alarmsfx($00))
                            ElseIf (channelplaying(local7\Field5) = $00) Then
                                local7\Field5 = playsound(alarmsfx($00))
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
                        If (((900.0 < local7\Field2) And (900.0 >= (local7\Field2 - fpsfactor))) <> 0) Then
                            playsound(alarmsfx($01))
                        EndIf
                        If (((2000.0 < local7\Field2) And (2000.0 >= (local7\Field2 - fpsfactor))) <> 0) Then
                            playsound(introsfx($07))
                        EndIf
                        If (3500.0 < local7\Field2) Then
                            playsound(introsfx($07))
                            Delete local7
                        EndIf
                    EndIf
                EndIf
            Case "room173"
                shouldplay = $42
                If (0.0 <= killtimer) Then
                    If (0.0 = local7\Field2) Then
                        If (playerroom = local7\Field1) Then
                            For local2 = $00 To $03 Step $01
                                introsfx(local2) = loadsound((("SFX\intro\intro" + (Str (local2 + $01))) + ".ogg"))
                            Next
                            For local2 = $04 To $06 Step $01
                                introsfx(local2) = loadsound((("SFX\intro\refuse" + (Str (local2 - $03))) + ".ogg"))
                            Next
                            camerafogmode(camera, $00)
                            ambientlight(250.0, 250.0, 250.0)
                            hideentity(fog)
                            curr173\Field12 = $01
                            local7\Field1\Field12[$00] = createnpc($03, entityx(local7\Field1\Field10[$00], $01), entityy(local7\Field1\Field10[$00], $01), entityz(local7\Field1\Field10[$00], $01))
                            local7\Field1\Field12[$00]\Field8 = 180.0
                            local7\Field1\Field12[$01] = createnpc($04, entityx(local7\Field1\Field10[$01], $01), 0.5, entityz(local7\Field1\Field10[$01], $01))
                            pointentity(local7\Field1\Field12[$01]\Field2, local7\Field1\Field10[$05], 0.0)
                            local7\Field1\Field12[$02] = createnpc($04, entityx(local7\Field1\Field10[$02], $01), 0.5, entityz(local7\Field1\Field10[$02], $01))
                            pointentity(local7\Field1\Field12[$02]\Field2, local7\Field1\Field10[$05], 0.0)
                            positionentity(curr173\Field2, entityx(local7\Field1\Field10[$05], $01), 0.5, entityz(local7\Field1\Field10[$05], $01), $00)
                            resetentity(curr173\Field2)
                            local7\Field2 = 1.0
                        EndIf
                    ElseIf (10000.0 > local7\Field2) Then
                        local7\Field2 = min(((fpsfactor / 3.0) + local7\Field2), 5000.0)
                        If (((100.0 < local7\Field2) And (100.0 > (local7\Field2 - fpsfactor))) = 0) Then
                            If (((130.0 <= local7\Field2) And (130.0 > (local7\Field2 - fpsfactor))) <> 0) Then
                                playsound(introsfx($00))
                            ElseIf (230.0 < local7\Field2) Then
                                local3 = $01
                                For local2 = $01 To $02 Step $01
                                    If (0.3 < distance(entityx(local7\Field1\Field12[local2]\Field2, $00), entityz(local7\Field1\Field12[local2]\Field2, $00), entityx(local7\Field1\Field10[(local2 + $02)], $01), entityz(local7\Field1\Field10[(local2 + $02)], $01))) Then
                                        pointentity(local7\Field1\Field12[local2]\Field2, local7\Field1\Field10[(local2 + $02)], 0.0)
                                        If ((Float ((local2 * $1E) + $C8)) < local7\Field2) Then
                                            local7\Field1\Field12[local2]\Field6 = 1.0
                                        EndIf
                                        local3 = $00
                                    Else
                                        local7\Field1\Field12[local2]\Field6 = 0.0
                                        pointentity(local7\Field1\Field12[local2]\Field2, local7\Field1\Field10[$05], 0.0)
                                    EndIf
                                Next
                                If (entityx(collider, $00) < (entityx(local7\Field1\Field1, $00) + (408.0 * roomscale))) Then
                                    If (((450.0 < local7\Field2) And (450.0 > (local7\Field2 - fpsfactor))) <> 0) Then
                                        playsound(introsfx($04))
                                    ElseIf (((650.0 < local7\Field2) And (650.0 > (local7\Field2 - fpsfactor))) <> 0) Then
                                        playsound(introsfx($05))
                                    ElseIf (((850.0 < local7\Field2) And (850.0 > (local7\Field2 - fpsfactor))) <> 0) Then
                                        local7\Field1\Field11[$01]\Field5 = $00
                                        playsound(introsfx($06))
                                    ElseIf (1000.0 < local7\Field2) Then
                                        local7\Field1\Field12[$00]\Field6 = 1.0
                                        Delete local7
                                        Exit
                                    EndIf
                                    If (850.0 < local7\Field2) Then
                                        positionentity(collider, min(entityx(collider, $00), (entityx(local7\Field1\Field1, $00) + (352.0 * roomscale))), entityy(collider, $00), entityz(collider, $00), $00)
                                    EndIf
                                ElseIf (local3 = $01) Then
                                    local7\Field2 = 10000.0
                                    usedoor(local7\Field1\Field11[$01])
                                EndIf
                            EndIf
                        EndIf
                        positionentity(curr173\Field2, entityx(local7\Field1\Field10[$05], $01), entityy(curr173\Field2, $00), entityz(local7\Field1\Field10[$05], $01), $00)
                        rotateentity(curr173\Field2, 0.0, 0.0, 0.0, $01)
                        resetentity(curr173\Field2)
                    ElseIf (14000.0 > local7\Field2) Then
                        local7\Field2 = min((local7\Field2 + fpsfactor), 13000.0)
                        If (10300.0 > (local7\Field2 - fpsfactor)) Then
                            positionentity(collider, max(entityx(collider, $00), (entityx(local7\Field1\Field1, $00) + (352.0 * roomscale))), entityy(collider, $00), entityz(collider, $00), $00)
                        EndIf
                        If (((10300.0 < local7\Field2) And (10300.0 > (local7\Field2 - fpsfactor))) <> 0) Then
                            playsound(introsfx($01))
                            positionentity(collider, max(entityx(collider, $00), (entityx(local7\Field1\Field1, $00) + (352.0 * roomscale))), entityy(collider, $00), entityz(collider, $00), $00)
                        ElseIf (((10440.0 < local7\Field2) And (10440.0 > (local7\Field2 - fpsfactor))) <> 0) Then
                            usedoor(local7\Field1\Field11[$01])
                            playsound(introsfx($07))
                        ElseIf (((10740.0 < local7\Field2) And (10740.0 > (local7\Field2 - fpsfactor))) <> 0) Then
                            playsound(introsfx($02))
                        ElseIf (((11490.0 < local7\Field2) And (11490.0 > (local7\Field2 - fpsfactor))) <> 0) Then
                            playsound(introsfx($0A))
                        ElseIf (((11561.0 < local7\Field2) And (11561.0 > (local7\Field2 - fpsfactor))) <> 0) Then
                            local7\Field2 = 14000.0
                        EndIf
                        positionentity(curr173\Field2, entityx(local7\Field1\Field10[$05], $01), entityy(curr173\Field2, $00), entityz(local7\Field1\Field10[$05], $01), $00)
                        rotateentity(curr173\Field2, 0.0, 0.0, 0.0, $01)
                        resetentity(curr173\Field2)
                    ElseIf (20000.0 > local7\Field2) Then
                        local7\Field2 = min((local7\Field2 + fpsfactor), 19000.0)
                        If (14100.0 > local7\Field2) Then
                            If (14005.0 < local7\Field2) Then
                                setanimtime(local7\Field1\Field12[$01]\Field0, 171.0, $00)
                                positionentity(curr173\Field2, entityx(local7\Field1\Field12[$01]\Field0, $00), entityy(curr173\Field2, $00), entityz(local7\Field1\Field12[$01]\Field0, $00), $00)
                                resetentity(curr173\Field2)
                                pointentity(curr173\Field2, local7\Field1\Field12[$02]\Field2, 0.0)
                            EndIf
                            pointentity(local7\Field1\Field12[$02]\Field2, curr173\Field2, 0.0)
                            If (14030.0 > local7\Field2) Then
                                blinktimer = -10.0
                                lightblink = 1.0
                            EndIf
                            If (((14032.0 < local7\Field2) And (14032.0 > (local7\Field2 - fpsfactor))) <> 0) Then
                                playsound(horrorsfx($02))
                            EndIf
                            If (((14080.0 < local7\Field2) And (14080.0 > (local7\Field2 - fpsfactor))) <> 0) Then
                                playsound(introsfx($0C))
                            EndIf
                            camerashake = 3.0
                        ElseIf (14200.0 > local7\Field2) Then
                            If (14105.0 < local7\Field2) Then
                                setanimtime(local7\Field1\Field12[$02]\Field0, 171.0, $00)
                                positionentity(curr173\Field2, entityx(local7\Field1\Field12[$02]\Field0, $00), entityy(curr173\Field2, $00), entityz(local7\Field1\Field12[$02]\Field0, $00), $00)
                                resetentity(curr173\Field2)
                                pointentity(curr173\Field2, collider, 0.0)
                            EndIf
                            If (14130.0 > local7\Field2) Then
                                blinktimer = -10.0
                                lightblink = 1.0
                            Else
                                curr173\Field12 = $00
                            EndIf
                            If (((14100.0 < local7\Field2) And (14100.0 > (local7\Field2 - fpsfactor))) <> 0) Then
                                playsound(introsfx($08))
                            EndIf
                            If (14150.0 > local7\Field2) Then
                                camerashake = 5.0
                            EndIf
                        ElseIf (14300.0 < local7\Field2) Then
                            If (((14600.0 < local7\Field2) And (14700.0 > local7\Field2)) <> 0) Then
                                blinktimer = -10.0
                                lightblink = 1.0
                            EndIf
                            If (entityx(collider, $00) < (entityx(local7\Field1\Field1, $00) + (448.0 * roomscale))) Then
                                local7\Field2 = 20000.0
                            EndIf
                        EndIf
                    ElseIf (30000.0 > local7\Field2) Then
                        local7\Field2 = min((local7\Field2 + fpsfactor), 30000.0)
                        If (20100.0 > local7\Field2) Then
                            camerashake = 2.0
                        ElseIf (20200.0 > local7\Field2) Then
                            If (((20105.0 < local7\Field2) And (20105.0 > (local7\Field2 - fpsfactor))) <> 0) Then
                                playsound(introsfx($09))
                            EndIf
                            If (20105.0 < local7\Field2) Then
                                curr173\Field12 = $01
                                pointentity(local7\Field1\Field12[$00]\Field2, curr173\Field0, 0.0)
                                positionentity(curr173\Field2, (entityx(local7\Field1\Field1, $00) - (448.0 * roomscale)), (entityy(local7\Field1\Field1, $00) + (480.0 * roomscale)), (entityz(local7\Field1\Field1, $00) + (1398.0 * roomscale)), $00)
                                resetentity(curr173\Field2)
                                pointentity(curr173\Field2, local7\Field1\Field12[$00]\Field2, 0.0)
                            EndIf
                            blinktimer = -10.0
                            lightblink = 1.0
                            camerashake = 3.0
                        ElseIf (20300.0 > local7\Field2) Then
                            pointentity(local7\Field1\Field12[$00]\Field2, curr173\Field2, 0.0)
                            moveentity(local7\Field1\Field12[$00]\Field2, 0.0, 0.0, -0.002)
                            local7\Field1\Field12[$00]\Field6 = 2.0
                            If (((20260.0 < local7\Field2) And (20260.0 > (local7\Field2 - fpsfactor))) <> 0) Then
                                playsound(introsfx($0C))
                            EndIf
                        ElseIf (20300.0 > (local7\Field2 - fpsfactor)) Then
                            blinktimer = -10.0
                            lightblink = 1.0
                            camerashake = 3.0
                            playsound(introsfx($0B))
                            curr173\Field12 = $00
                            removenpc(local7\Field1\Field12[$00])
                            playsound(introsfx($0F))
                            positionentity(curr173\Field2, (entityx(playerroom\Field1, $00) - (400.0 * roomscale)), 100.0, (entityz(playerroom\Field1, $00) + (1072.0 * roomscale)), $00)
                            resetentity(curr173\Field2)
                            For local6 = Each rooms
                                If (local6\Field6\Field4 = "start") Then
                                    local9 = entityx(local6\Field1, $01)
                                    local10 = entityz(local6\Field1, $01)
                                    positionentity(collider, ((entityx(collider, $00) - entityx(local7\Field1\Field1, $00)) + local9), 1.0, ((entityz(collider, $00) - entityz(local7\Field1\Field1, $00)) + local10), $00)
                                    resetentity(collider)
                                    positionentity(curr173\Field2, ((entityx(curr173\Field2, $00) - entityx(local7\Field1\Field1, $00)) + local9), entityy(curr173\Field2, $00), ((entityz(curr173\Field2, $00) - entityz(local7\Field1\Field1, $00)) + local10), $00)
                                    resetentity(curr173\Field2)
                                    For local2 = $01 To $02 Step $01
                                        positionentity(local7\Field1\Field12[local2]\Field2, ((entityx(local7\Field1\Field12[local2]\Field2, $00) - entityx(local7\Field1\Field1, $00)) + local9), 1.0, ((entityz(local7\Field1\Field12[local2]\Field2, $00) - entityz(local7\Field1\Field1, $00)) + local10), $00)
                                        resetentity(local7\Field1\Field12[local2]\Field2)
                                    Next
                                    showentity(fog)
                                    ambientlight((Float brightness), (Float brightness), (Float brightness))
                                    camerafogrange(camera, camerafognear, camerafogfar)
                                    camerafogmode(camera, $01)
                                    Delete local7
                                    Exit
                                EndIf
                            Next
                        EndIf
                    EndIf
                Else
                    For local2 = $00 To $06 Step $01
                        freesound(introsfx(local2))
                    Next
                    Delete local7
                EndIf
            Case "room2doors173"
                If (0.0 = local7\Field2) Then
                    If (playerroom = local7\Field1) Then
                        If (entityinview(curr173\Field0, camera) = $00) Then
                            local7\Field2 = 1.0
                            positionentity(curr173\Field2, entityx(local7\Field1\Field10[$00], $01), 0.5, entityz(local7\Field1\Field10[$00], $01), $00)
                            resetentity(curr173\Field2)
                            Delete local7
                        EndIf
                    EndIf
                EndIf
            Case "buttghost"
                If (playerroom = local7\Field1) Then
                    If (1.8 > entitydistance(collider, local7\Field1\Field10[$00])) Then
                        playsound2(buttghostsfx, camera, local7\Field1\Field10[$00], 10.0, 1.0)
                        Delete local7
                    EndIf
                EndIf
            Case "682roar"
                If (0.0 = local7\Field2) Then
                    If (playerroom = local7\Field1) Then
                        local7\Field2 = (Float (rand($12C, $3E8) * $46))
                    EndIf
                Else
                    local7\Field2 = (local7\Field2 - fpsfactor)
                    If (1190.0 > local7\Field2) Then
                        If (1190.0 <= (local7\Field2 + fpsfactor)) Then
                            roar682sfx = loadsound("SFX\roar.ogg")
                            playsound(roar682sfx)
                        EndIf
                        If (980.0 < local7\Field2) Then
                            camerashake = 0.5
                        EndIf
                        If (((665.0 > local7\Field2) And (420.0 < local7\Field2)) <> 0) Then
                            camerashake = 2.0
                        EndIf
                        If (70.0 > local7\Field2) Then
                            freesound(roar682sfx)
                            Delete local7
                        EndIf
                    EndIf
                EndIf
            Case "testroom173"
                If (playerroom = local7\Field1) Then
                    If (0.0 = local7\Field2) Then
                        positionentity(curr173\Field2, entityx(local7\Field1\Field10[$00], $01), 0.5, entityz(local7\Field1\Field10[$00], $01), $00)
                        resetentity(curr173\Field2)
                        local7\Field2 = 1.0
                    Else
                        local7\Field2 = (local7\Field2 + 1.0)
                        local0 = entitydistance(collider, local7\Field1\Field10[$01])
                        If (1.0 > local0) Then
                            local7\Field2 = max(local7\Field2, 840.0)
                        ElseIf (1.4 < local0) Then
                            If (840.0 < local7\Field2) Then
                                If ((entityinview(curr173\Field0, camera) Or (-10.0 >= blinktimer)) = $00) Then
                                    playsound2(glassbreaksfx, camera, curr173\Field0, 10.0, 1.0)
                                    freeentity(local7\Field1\Field10[$02])
                                    positionentity(curr173\Field2, entityx(local7\Field1\Field10[$01], $01), 0.5, entityz(local7\Field1\Field10[$01], $01), $00)
                                    resetentity(curr173\Field2)
                                    Delete local7
                                EndIf
                            EndIf
                        EndIf
                    EndIf
                EndIf
            Case "testroom"
                If (0.0 = local7\Field2) Then
                    If (playerroom = local7\Field1) Then
                        If (2.5 > entitydistance(collider, local7\Field1\Field10[$06])) Then
                            playsound(msg079)
                            For local2 = $00 To $05 Step $01
                                local11 = createemitter(entityx(local7\Field1\Field10[local2], $01), entityy(local7\Field1\Field10[local2], $01), entityz(local7\Field1\Field10[local2], $01), $00)
                                turnentity(local11\Field0, 90.0, 0.0, 0.0, $01)
                                local11\Field10 = 5.0
                                local11\Field9 = 0.042
                                local11\Field11 = (1.0 / 400.0)
                            Next
                            local7\Field2 = 1.0
                            Delete local7
                        EndIf
                    EndIf
                EndIf
            Case "room079"
                If (playerroom = local7\Field1) Then
                    shouldplay = $04
                    If (remotedooron <> 0) Then
                        If (((70.0 < local7\Field1\Field11[$00]\Field7) And local7\Field1\Field11[$00]\Field5) <> 0) Then
                            local7\Field1\Field11[$00]\Field5 = $00
                        EndIf
                    ElseIf (10000.0 > local7\Field2) Then
                        If (0.0 = local7\Field2) Then
                            If (2.5 > entitydistance(local7\Field1\Field10[$00], collider)) Then
                                local7\Field2 = 1.0
                                local7\Field3 = 1.0
                                local7\Field6 = loadsound("SFX\079_1.ogg")
                                local7\Field5 = playsound(local7\Field6)
                            EndIf
                        ElseIf (3500.0 > local7\Field2) Then
                            If (channelplaying(local7\Field5) <> 0) Then
                                If (rand($03, $01) = $01) Then
                                    entitytexture(local7\Field1\Field10[$01], oldaipics($00), $00, $00)
                                    showentity(local7\Field1\Field10[$01])
                                ElseIf (rand($0A, $01) = $01) Then
                                    hideentity(local7\Field1\Field10[$01])
                                EndIf
                            Else
                                entitytexture(local7\Field1\Field10[$01], oldaipics($01), $00, $00)
                                showentity(local7\Field1\Field10[$01])
                            EndIf
                        ElseIf (2.5 > entitydistance(local7\Field1\Field10[$00], collider)) Then
                            local7\Field2 = 10001.0
                            local7\Field6 = loadsound("SFX\079_2.ogg")
                            local7\Field5 = playsound(local7\Field6)
                            entitytexture(local7\Field1\Field10[$01], oldaipics($01), $00, $00)
                            showentity(local7\Field1\Field10[$01])
                        EndIf
                    EndIf
                EndIf
                If (0.0 < local7\Field3) Then
                    local7\Field3 = (local7\Field3 + fpsfactor)
                    If (350.0 < local7\Field3) Then
                        If (remotedooron <> 0) Then
                            local7\Field6 = loadsound("SFX\079_3.ogg")
                            local7\Field5 = playsound(local7\Field6)
                            local7\Field3 = 0.0
                        EndIf
                    EndIf
                EndIf
                If (((0.0 < local7\Field2) And (11000.0 > local7\Field2)) <> 0) Then
                    local7\Field2 = (local7\Field2 + fpsfactor)
                    If (((7000.0 < local7\Field2) And (7000.0 >= (local7\Field2 - fpsfactor))) <> 0) Then
                        freesound(local7\Field6)
                    EndIf
                    If (((10700.0 < local7\Field2) And (10700.0 >= (local7\Field2 - fpsfactor))) <> 0) Then
                        freesound(local7\Field6)
                    EndIf
                EndIf
            Case "room2tesla"
                If (playerroom = local7\Field1) Then
                    If (0.0 = local7\Field2) Then
                        If (local7\Field5 = $00) Then
                            local7\Field5 = playsound2(teslaidlesfx, camera, local7\Field1\Field10[$03], 4.0, 0.5)
                        ElseIf (channelplaying(local7\Field5) = $00) Then
                            local7\Field5 = playsound2(teslaidlesfx, camera, local7\Field1\Field10[$03], 4.0, 0.5)
                        EndIf
                        For local2 = $00 To $02 Step $01
                            If ((300.0 * roomscale) > distance(entityx(collider, $00), entityz(collider, $00), entityx(local7\Field1\Field10[local2], $01), entityz(local7\Field1\Field10[local2], $01))) Then
                                If (0.0 <= killtimer) Then
                                    stopchannel(local7\Field5)
                                    local7\Field5 = playsound2(teslaactivatesfx, camera, local7\Field1\Field10[$03], 4.0, 0.5)
                                    local7\Field2 = 1.0
                                    Exit
                                EndIf
                            EndIf
                        Next
                        If (((-10.0 > curr106\Field6) And (0.0 = local7\Field2)) <> 0) Then
                            For local2 = $00 To $02 Step $01
                                If ((300.0 * roomscale) > distance(entityx(curr106\Field2, $00), entityz(curr106\Field2, $00), entityx(local7\Field1\Field10[local2], $01), entityz(local7\Field1\Field10[local2], $01))) Then
                                    If (0.0 <= killtimer) Then
                                        stopchannel(local7\Field5)
                                        local7\Field5 = playsound2(teslaactivatesfx, camera, local7\Field1\Field10[$03], 4.0, 0.5)
                                        local7\Field2 = 1.0
                                        Exit
                                    EndIf
                                EndIf
                            Next
                        EndIf
                    Else
                        local7\Field2 = (local7\Field2 + fpsfactor)
                        If (40.0 < local7\Field2) Then
                            If (40.0 >= (local7\Field2 - fpsfactor)) Then
                                playsound(introsfx($0B))
                            EndIf
                            If (70.0 > local7\Field2) Then
                                If (0.0 <= killtimer) Then
                                    For local2 = $00 To $02 Step $01
                                        If ((250.0 * roomscale) > distance(entityx(collider, $00), entityz(collider, $00), entityx(local7\Field1\Field10[local2], $01), entityz(local7\Field1\Field10[local2], $01))) Then
                                            showentity(light)
                                            lightflash = 0.4
                                            kill()
                                        EndIf
                                    Next
                                EndIf
                                If (-10.0 > curr106\Field6) Then
                                    For local2 = $00 To $02 Step $01
                                        If ((250.0 * roomscale) > distance(entityx(curr106\Field2, $00), entityz(curr106\Field2, $00), entityx(local7\Field1\Field10[local2], $01), entityz(local7\Field1\Field10[local2], $01))) Then
                                            showentity(light)
                                            lightflash = 0.4
                                            For local2 = $00 To $0A Step $01
                                                local4 = createparticle(entityx(curr106\Field2, $01), entityy(curr106\Field2, $01), entityz(curr106\Field2, $01), $00, 0.015, -0.2, $FA)
                                                local4\Field7 = 0.03
                                                local4\Field10 = -0.2
                                                local4\Field16 = 200.0
                                                local4\Field15 = 0.005
                                                local4\Field8 = 0.001
                                                rotateentity(local4\Field1, rnd(360.0, 0.0), rnd(360.0, 0.0), 0.0, $01)
                                            Next
                                            curr106\Field6 = -2000.0
                                        EndIf
                                    Next
                                EndIf
                                hideentity(local7\Field1\Field10[$03])
                                If (rand($05, $01) < $05) Then
                                    positiontexture(teslatexture, 0.0, rnd(0.0, 1.0))
                                    showentity(local7\Field1\Field10[$03])
                                EndIf
                            Else
                                If (70.0 > (local7\Field2 - fpsfactor)) Then
                                    stopchannel(local7\Field5)
                                    local7\Field5 = playsound2(teslapowerupsfx, camera, local7\Field1\Field10[$03], 4.0, 0.5)
                                EndIf
                                hideentity(local7\Field1\Field10[$03])
                                If (150.0 < local7\Field2) Then
                                    local7\Field2 = 0.0
                                EndIf
                            EndIf
                        EndIf
                    EndIf
                EndIf
            Case "pj"
                If (0.0 = local7\Field2) Then
                    If (playerroom = local7\Field1) Then
                        If (2.5 > entitydistance(collider, local7\Field1\Field1)) Then
                            playsound(rustlesfx(rand($00, $02)))
                            createnpc($06, 0.0, 0.0, 0.0)
                            local7\Field2 = 1.0
                            Delete local7
                        EndIf
                    EndIf
                EndIf
            Case "room2tunnel"
                If (contained106 = $00) Then
                    If (0.0 = local7\Field2) Then
                        If (playerroom = local7\Field1) Then
                            local7\Field2 = 1.0
                        EndIf
                    ElseIf (1.0 = local7\Field2) Then
                        If (0.9 > entitydistance(collider, local7\Field1\Field10[$00])) Then
                            curr106\Field6 = -0.1
                            local7\Field2 = 2.0
                        ElseIf (0.9 > entitydistance(collider, local7\Field1\Field10[$01])) Then
                            curr106\Field6 = -0.1
                            local7\Field2 = 3.0
                        EndIf
                    ElseIf (2.0 = local7\Field2) Then
                        local0 = distance(entityx(collider, $00), entityz(collider, $00), entityx(local7\Field1\Field10[$01], $01), entityz(local7\Field1\Field10[$01], $01))
                        If (1.0 > local0) Then
                            local12 = createpivot($00)
                            positionentity(local12, entityx(collider, $00), entityy(collider, $00), entityz(collider, $00), $00)
                            pointentity(local12, local7\Field1\Field10[$01], 0.0)
                            rotateentity(local12, 0.0, entityyaw(local12, $00), 0.0, $00)
                            moveentity(local12, 0.0, 0.0, (local0 + 3.0))
                            positionentity(curr106\Field2, entityx(local12, $00), entityy(local12, $00), entityz(local12, $00), $00)
                            freeentity(local12)
                            curr106\Field10 = $00
                            local7\Field2 = 4.0
                        EndIf
                    ElseIf (3.0 = local7\Field2) Then
                        local0 = distance(entityx(collider, $00), entityz(collider, $00), entityx(local7\Field1\Field10[$00], $01), entityz(local7\Field1\Field10[$00], $01))
                        If (1.0 > local0) Then
                            local12 = createpivot($00)
                            positionentity(local12, entityx(collider, $00), entityy(collider, $00), entityz(collider, $00), $00)
                            pointentity(local12, local7\Field1\Field10[$00], 0.0)
                            rotateentity(local12, 0.0, entityyaw(local12, $00), 0.0, $00)
                            moveentity(local12, 0.0, 0.0, (local0 + 3.0))
                            positionentity(curr106\Field2, entityx(local12, $00), entityy(local12, $00), entityz(local12, $00), $00)
                            freeentity(local12)
                            curr106\Field10 = $00
                            local7\Field2 = 4.0
                        EndIf
                    EndIf
                EndIf
                If (playerroom = local7\Field1) Then
                    local7\Field3 = updateelevators(local7\Field3, local7\Field1\Field11[$00], local7\Field1\Field11[$01], local7\Field1\Field10[$02], local7\Field1\Field10[$03], local7)
                    local7\Field4 = updateelevators(local7\Field4, local7\Field1\Field11[$02], local7\Field1\Field11[$03], local7\Field1\Field10[$04], local7\Field1\Field10[$05], local7)
                EndIf
                If (((playerroom = local7\Field1) And $00) <> 0) Then
                    If (((local7\Field1\Field11[$00]\Field5 = $01) And (local7\Field1\Field11[$01]\Field5 = $00)) <> 0) Then
                        local7\Field3 = -1.0
                        If ((((closestbutton = local7\Field1\Field11[$01]\Field3[$00]) Or (closestbutton = local7\Field1\Field11[$01]\Field3[$01])) And mousehit1) <> 0) Then
                            usedoor(local7\Field1\Field11[$00])
                        EndIf
                    ElseIf (((local7\Field1\Field11[$01]\Field5 = $01) And (local7\Field1\Field11[$00]\Field5 = $00)) <> 0) Then
                        local7\Field3 = 1.0
                        If ((((closestbutton = local7\Field1\Field11[$00]\Field3[$00]) Or (closestbutton = local7\Field1\Field11[$00]\Field3[$01])) And mousehit1) <> 0) Then
                            usedoor(local7\Field1\Field11[$01])
                        EndIf
                    EndIf
                    debuglog((((((Str local7\Field3) + " - ") + (Str local7\Field1\Field11[$00]\Field5)) + ", ") + (Str local7\Field1\Field11[$01]\Field5)))
                    local13 = $00
                    If (((local7\Field1\Field11[$00]\Field5 = $00) And (local7\Field1\Field11[$01]\Field5 = $00)) <> 0) Then
                        debuglog("bim")
                        local7\Field1\Field11[$00]\Field4 = $01
                        local7\Field1\Field11[$01]\Field4 = $01
                        If (0.0 > local7\Field3) Then
                            local7\Field3 = (local7\Field3 - fpsfactor)
                            If ((280.0 * roomscale) > (Abs (entityx(collider, $00) - entityx(local7\Field1\Field10[$02], $01)))) Then
                                If ((280.0 * roomscale) > (Abs (entityz(collider, $00) - entityz(local7\Field1\Field10[$02], $01)))) Then
                                    local13 = $01
                                    camerashake = 0.4
                                EndIf
                            EndIf
                            If (-300.0 > local7\Field3) Then
                                local7\Field1\Field11[$00]\Field4 = $00
                                local7\Field1\Field11[$01]\Field4 = $00
                                local7\Field3 = 0.0
                                usedoor(local7\Field1\Field11[$01])
                                If (local13 <> 0) Then
                                    positionentity(collider, ((entityx(collider, $00) - entityx(local7\Field1\Field10[$02], $01)) + entityx(local7\Field1\Field10[$03], $01)), ((entityy(collider, $00) - entityy(local7\Field1\Field10[$02], $01)) + (entityy(local7\Field1\Field10[$03], $01) + 0.05)), ((entityz(collider, $00) - entityz(local7\Field1\Field10[$02], $01)) + entityz(local7\Field1\Field10[$03], $01)), $01)
                                    resetentity(collider)
                                EndIf
                            EndIf
                        Else
                            local7\Field3 = (local7\Field3 + fpsfactor)
                            If (300.0 < local7\Field3) Then
                                local7\Field1\Field11[$00]\Field4 = $00
                                local7\Field1\Field11[$01]\Field4 = $00
                                local7\Field3 = 0.0
                                usedoor(local7\Field1\Field11[$00])
                                If ((280.0 * roomscale) > (Abs (entityx(collider, $00) - entityx(local7\Field1\Field10[$03], $01)))) Then
                                    If ((280.0 * roomscale) > (Abs (entityz(collider, $00) - entityz(local7\Field1\Field10[$03], $01)))) Then
                                        positionentity(collider, ((entityx(collider, $00) - entityx(local7\Field1\Field10[$03], $01)) + entityx(local7\Field1\Field10[$02], $01)), ((entityy(collider, $00) - entityy(local7\Field1\Field10[$03], $01)) + entityy(local7\Field1\Field10[$02], $01)), ((entityz(collider, $00) - entityz(local7\Field1\Field10[$03], $01)) + entityz(local7\Field1\Field10[$02], $01)), $00)
                                        resetentity(collider)
                                    EndIf
                                EndIf
                            EndIf
                        EndIf
                    EndIf
                EndIf
            Case "room2pipes106"
                If (contained106 = $00) Then
                    If (0.0 = local7\Field2) Then
                        If (playerroom = local7\Field1) Then
                            local7\Field2 = 1.0
                        EndIf
                    Else
                        local7\Field2 = (local7\Field2 + fpsfactor)
                        positionentity(curr106\Field2, entityx(local7\Field1\Field10[$00], $01), (entityy(collider, $00) - 0.15), entityz(local7\Field1\Field10[$00], $01), $00)
                        pointentity(curr106\Field2, local7\Field1\Field10[$01], 0.0)
                        moveentity(curr106\Field2, 0.0, 0.0, (entitydistance(local7\Field1\Field10[$00], local7\Field1\Field10[$01]) * (local7\Field2 / 100.0)))
                        positionentity(curr106\Field2, entityx(curr106\Field2, $00), (entityy(collider, $00) - 0.3), entityz(curr106\Field2, $00), $00)
                        animate2(curr106\Field0, animtime(curr106\Field0), $00, $0E, 0.2)
                        resetentity(curr106\Field2)
                        If (((0.3 < (local7\Field2 / 100.0)) And (0.3 >= ((local7\Field2 - fpsfactor) / 100.0))) <> 0) Then
                            playsound(horrorsfx($06))
                            blurtimer = 800.0
                            local14 = createdecal($00, entityx(local7\Field1\Field10[$02], $01), entityy(local7\Field1\Field10[$02], $01), entityz(local7\Field1\Field10[$02], $01), 0.0, (Float (local7\Field1\Field5 - $5A)), rnd(360.0, 0.0))
                            local14\Field6 = 90000.0
                            local14\Field4 = 0.01
                            local14\Field3 = 0.005
                            local14\Field2 = 0.1
                            local14\Field1 = 0.003
                        EndIf
                        If (((0.65 < (local7\Field2 / 100.0)) And (0.65 >= ((local7\Field2 - fpsfactor) / 100.0))) <> 0) Then
                            local14 = createdecal($00, entityx(local7\Field1\Field10[$03], $01), entityy(local7\Field1\Field10[$03], $01), entityz(local7\Field1\Field10[$03], $01), 0.0, (Float (local7\Field1\Field5 + $5A)), rnd(360.0, 0.0))
                            local14\Field6 = 90000.0
                            local14\Field4 = 0.01
                            local14\Field3 = 0.005
                            local14\Field2 = 0.1
                            local14\Field1 = 0.003
                        EndIf
                        curr106\Field12 = $01
                        If (100.0 < local7\Field2) Then
                            curr106\Field12 = $00
                            Delete local7
                        EndIf
                    EndIf
                EndIf
            Case "room2pit106"
                If (contained106 = $00) Then
                    If (0.0 = local7\Field2) Then
                        If (playerroom = local7\Field1) Then
                            local7\Field2 = 1.0
                        EndIf
                    Else
                        local7\Field2 = (local7\Field2 + 1.0)
                        positionentity(curr106\Field2, entityx(local7\Field1\Field10[$07], $01), entityy(local7\Field1\Field10[$07], $01), entityz(local7\Field1\Field10[$07], $01), $00)
                        resetentity(curr106\Field2)
                        pointentity(curr106\Field2, camera, 0.0)
                        turnentity(curr106\Field2, 0.0, (sin((Float (millisecs() / $14))) * 6.0), 0.0, $01)
                        moveentity(curr106\Field2, 0.0, 0.0, (sin((Float (millisecs() / $0F))) * 0.06))
                        curr106\Field12 = $01
                        If (800.0 < local7\Field2) Then
                            If (-5.0 > blinktimer) Then
                                curr106\Field12 = $00
                                Delete local7
                            EndIf
                        EndIf
                    EndIf
                EndIf
            Case "room2pit"
                If (0.0 = local7\Field2) Then
                    If (5.0 > distance(entityx(collider, $00), entityz(collider, $00), entityx(local7\Field1\Field1, $00), entityz(local7\Field1\Field1, $00))) Then
                        positionentity(curr173\Field2, entityx(local7\Field1\Field10[$06], $01), 0.5, entityz(local7\Field1\Field10[$06], $01), $00)
                        resetentity(curr173\Field2)
                        Delete local7
                    EndIf
                EndIf
            Case "tunnel2smoke"
                If (0.0 = local7\Field2) Then
                    If (3.5 > distance(entityx(collider, $00), entityz(collider, $00), entityx(local7\Field1\Field1, $00), entityz(local7\Field1\Field1, $00))) Then
                        playsound2(burstsfx, camera, local7\Field1\Field1, 10.0, 1.0)
                        For local2 = $00 To $01 Step $01
                            local11 = createemitter(entityx(local7\Field1\Field10[local2], $01), entityy(local7\Field1\Field10[local2], $01), entityz(local7\Field1\Field10[local2], $01), $00)
                            turnentity(local11\Field0, 90.0, 0.0, 0.0, $01)
                            entityparent(local11\Field0, local7\Field1\Field1, $01)
                            local11\Field10 = 3.0
                            local11\Field9 = 0.04
                            local11\Field11 = 0.0027
                            For local10 = 0.0 To 10.0 Step 1.0
                                local4 = createparticle(entityx(local11\Field0, $01), (448.0 * roomscale), entityz(local11\Field0, $01), rand(local11\Field2, local11\Field3), local11\Field1, local11\Field4, local11\Field5)
                                local4\Field8 = local11\Field9
                                rotateentity(local4\Field1, rnd(360.0, 0.0), rnd(360.0, 0.0), 0.0, $01)
                                local4\Field15 = local11\Field11
                            Next
                        Next
                        Delete local7
                    EndIf
                EndIf
            Case "tunnel2"
                If (0.0 = local7\Field2) Then
                    If (3.5 > distance(entityx(collider, $00), entityz(collider, $00), entityx(local7\Field1\Field1, $00), entityz(local7\Field1\Field1, $00))) Then
                        playsound(lightsfx)
                        lightblink = (rnd(0.0, 1.0) * (local7\Field2 / 200.0))
                        local7\Field2 = 1.0
                    EndIf
                ElseIf (200.0 > local7\Field2) Then
                    blinktimer = -10.0
                    If (30.0 < local7\Field2) Then
                        lightblink = 1.0
                        If (30.0 >= (local7\Field2 - fpsfactor)) Then
                            playsound(ambientsfx($04))
                        EndIf
                    EndIf
                    If (((100.0 >= (local7\Field2 - fpsfactor)) And (100.0 < local7\Field2)) <> 0) Then
                        playsound(ambientsfx($0A))
                        positionentity(curr173\Field2, entityx(local7\Field1\Field1, $00), 0.6, entityz(local7\Field1\Field1, $00), $00)
                        resetentity(curr173\Field2)
                        curr173\Field12 = $01
                    EndIf
                    lightblink = 1.0
                    local7\Field2 = (local7\Field2 + fpsfactor)
                Else
                    blinktimer = 560.0
                    curr173\Field12 = $00
                    Delete local7
                EndIf
            Case "coffin"
                local0 = entitydistance(camera, local7\Field1\Field10[$00])
                coffindistance = local0
            Case "coffin106"
                local0 = entitydistance(camera, local7\Field1\Field10[$00])
                coffindistance = local0
                If (0.0 = local7\Field2) Then
                    If (playerroom = local7\Field1) Then
                        If (shouldplay = $00) Then
                            shouldplay = $42
                        EndIf
                    ElseIf (shouldplay = $42) Then
                        shouldplay = $00
                    EndIf
                    If (contained106 = $00) Then
                        If (1.5 > entitydistance(camera, local7\Field1\Field10[$00])) Then
                            curr106\Field6 = -0.1
                            local7\Field2 = 1.0
                        EndIf
                    EndIf
                EndIf
            Case "tunnel106"
                If (contained106 = $00) Then
                    If (0.0 = local7\Field2) Then
                        If (0.0 <= curr106\Field6) Then
                            If (5.0 > entitydistance(camera, local7\Field1\Field1)) Then
                                local14 = createdecal($00, entityx(local7\Field1\Field1, $00), 0.0011, entityz(local7\Field1\Field1, $00), 90.0, (Float rand($168, $01)), 0.0)
                                local14\Field2 = rnd(0.5, 0.7)
                                entityalpha(local14\Field0, 0.7)
                                local14\Field5 = $01
                                scalesprite(local14\Field0, local14\Field2, local14\Field2)
                                entityalpha(local14\Field0, rnd(0.7, 0.85))
                                local7\Field2 = 1.0
                            EndIf
                        EndIf
                    Else
                        positionentity(curr106\Field2, (entityx(local7\Field1\Field1, $01) - (sin(((Float millisecs()) / 150.0)) / 4.0)), ((entityy(collider, $00) - 0.4) - ((sin(((Float millisecs()) / 100.0)) + 1.0) / 4.0)), (entityz(local7\Field1\Field1, $01) - (sin(((Float millisecs()) / 190.0)) / 4.0)), $00)
                        pointentity(curr106\Field2, camera, 0.0)
                        curr106\Field6 = -11.0
                        animate2(curr106\Field0, animtime(curr106\Field0), $CE, $FA, 0.1)
                        curr106\Field12 = $01
                        local0 = entitydistance(collider, curr106\Field2)
                        If (((3.5 > local0) Or (rand($1B58, $01) = $01)) <> 0) Then
                            curr106\Field12 = $00
                            Delete local7
                        ElseIf (8.0 < local0) Then
                            If (rand($05, $01) = $01) Then
                                curr106\Field12 = $00
                                Delete local7
                            Else
                                curr106\Field12 = $00
                                curr106\Field6 = -10000.0
                                Delete local7
                            EndIf
                        EndIf
                    EndIf
                EndIf
            Case "lockroom173"
                If (((0.0 = local7\Field2) And (rand($05, $01) = $01)) <> 0) Then
                    If (5.0 > distance(entityx(collider, $00), entityz(collider, $00), entityx(local7\Field1\Field1, $00), entityz(local7\Field1\Field1, $00))) Then
                        If (entityinview(curr106\Field0, camera) = $00) Then
                            local7\Field2 = 1.0
                            positionentity(curr173\Field2, ((cos((Float (local7\Field1\Field5 + $87))) * 2.0) + local7\Field1\Field2), (local7\Field1\Field3 + 1.0), ((sin((Float (local7\Field1\Field5 + $87))) * 2.0) + local7\Field1\Field4), $00)
                            resetentity(curr173\Field2)
                            Delete local7
                        EndIf
                    EndIf
                EndIf
            Case "pocketdimension"
                If (playerroom = local7\Field1) Then
                    shouldplay = $03
                    If (600.0 > local7\Field2) Then
                        blurtimer = 1000.0
                        blinktimer = (-10.0 - (local7\Field2 / 60.0))
                    EndIf
                    scaleentity(local7\Field1\Field1, roomscale, (((sin((local7\Field2 / 14.0)) * 0.2) + 1.0) * roomscale), roomscale, $00)
                    For local2 = $00 To $07 Step $01
                        scaleentity(local7\Field1\Field10[local2], (((Abs (sin(((local7\Field2 / 21.0) + ((Float local2) * 45.0))) * 0.1)) + 1.0) * roomscale), (((sin(((local7\Field2 / 14.0) + ((Float local2) * 20.0))) * 0.1) + 1.0) * roomscale), roomscale, $01)
                    Next
                    scaleentity(local7\Field1\Field10[$08], (((Abs (sin(((local7\Field2 / 21.0) + ((Float local2) * 45.0))) * 0.1)) + 1.5) * roomscale), (((sin(((local7\Field2 / 14.0) + ((Float local2) * 20.0))) * 0.1) + 1.0) * roomscale), roomscale, $01)
                    scaleentity(local7\Field1\Field10[$09], (((Abs (sin(((local7\Field2 / 21.0) + ((Float local2) * 45.0))) * 0.1)) + 1.5) * roomscale), (((sin(((local7\Field2 / 14.0) + ((Float local2) * 20.0))) * 0.1) + 1.0) * roomscale), roomscale, $01)
                    local7\Field2 = (local7\Field2 + fpsfactor)
                    If (0.0 = local7\Field3) Then
                        If (4550.0 < local7\Field2) Then
                            If (((rand($320, $01) = $01) And (0.0 <= curr106\Field6)) <> 0) Then
                                curr106\Field6 = -0.1
                                local7\Field2 = 601.0
                            EndIf
                        ElseIf (0.0 < curr106\Field6) Then
                            local5 = ((local7\Field2 / 10.0) Mod 360.0)
                            positionentity(curr106\Field2, entityx(local7\Field1\Field1, $00), 0.35, entityx(local7\Field1\Field1, $00), $00)
                            rotateentity(curr106\Field2, 0.0, local5, 0.0, $00)
                            moveentity(curr106\Field2, 0.0, 0.0, (6.0 - sin((local7\Field2 / 10.0))))
                            animate2(curr106\Field0, animtime(curr106\Field0), $00, $0E, 0.17)
                            rotateentity(curr106\Field2, 0.0, (local5 + 90.0), 0.0, $00)
                        EndIf
                    EndIf
                    If (0.3 > entitydistance(collider, curr106\Field2)) Then
                        curr106\Field12 = $00
                        curr106\Field6 = -11.0
                    EndIf
                    If (1.0 = local7\Field3) Then
                        local0 = entitydistance(collider, local7\Field1\Field10[$08])
                        If (local0 > (1700.0 * roomscale)) Then
                            blinktimer = -10.0
                            Select rand($02, $01)
                                Case $01
                                    local3 = createpivot($00)
                                    positionentity(local3, entityx(collider, $00), entityy(collider, $00), entityz(collider, $00), $00)
                                    pointentity(local3, local7\Field1\Field10[$08], 0.0)
                                    moveentity(local3, 0.0, 0.0, (local0 * 1.9))
                                    positionentity(collider, entityx(local3, $00), entityy(collider, $00), entityz(local3, $00), $00)
                                    resetentity(collider)
                                    local5 = (Float ((Int (entityyaw(local3, $00) / 90.0)) * $5A))
                                    rotateentity(local3, 0.0, local5, 0.0, $00)
                                    moveentity(local3, 0.0, 0.0, 0.8)
                                    positionentity(local7\Field1\Field10[$0A], entityx(local3, $00), 0.0, entityz(local3, $00), $00)
                                    rotateentity(local7\Field1\Field10[$0A], 0.0, entityyaw(local3, $00), 0.0, $01)
                                    positionentity(local3, entityx(local7\Field1\Field10[$08], $00), 0.0, entityz(local7\Field1\Field10[$08], $00), $00)
                                    rotateentity(local3, 0.0, ((Float (rand($01, $03) * $5A)) + local5), 0.0, $00)
                                    moveentity(local3, 0.0, 0.0, (520.0 * roomscale))
                                    positionentity(local7\Field1\Field10[$09], entityx(local3, $00), 0.0, entityz(local3, $00), $00)
                                    freeentity(local3)
                                Case $02
                                    local3 = createpivot($00)
                                    positionentity(local3, entityx(local7\Field1\Field1, $00), entityy(local7\Field1\Field1, $00), entityz(local7\Field1\Field1, $00), $00)
                                    local5 = wrapangle((getangle(entityx(local7\Field1\Field10[$08], $00), entityz(local7\Field1\Field10[$08], $00), entityx(collider, $00), entityz(collider, $00)) - 22.5))
                                    debuglog((Str local5))
                                    local5 = (Float (Int (local5 / 90.0)))
                                    rotateentity(local3, 0.0, ((Float rand($00, $08)) * 45.0), 0.0, $00)
                                    moveentity(local3, 0.0, 0.0, (1400.0 * roomscale))
                                    positionentity(collider, entityx(local3, $00), entityy(collider, $00), entityz(local3, $00), $00)
                                    rotateentity(collider, 0.0, ((entityyaw(collider, $00) - (local5 * 45.0)) - 270.0), 0.0, $01)
                                    moveentity(local3, 0.0, 0.0, 0.8)
                                    positionentity(local7\Field1\Field10[$0A], entityx(local3, $00), 0.0, entityz(local3, $00), $00)
                                    rotateentity(local7\Field1\Field10[$0A], 0.0, entityyaw(local3, $00), 0.0, $01)
                                    resetentity(collider)
                                    freeentity(local3)
                                    debuglog("oooo")
                                    local7\Field3 = 0.0
                            End Select
                        EndIf
                    ElseIf (0.0 = local7\Field3) Then
                        local0 = entitydistance(collider, local7\Field1\Field1)
                        If (local0 > (1700.0 * roomscale)) Then
                            blinktimer = -10.0
                            Select rand($1A, $01)
                                Case $01,$02,$03,$05,$06,$07
                                    playsound(oldmansfx($03))
                                    local3 = createpivot($00)
                                    positionentity(local3, entityx(collider, $00), entityy(collider, $00), entityz(collider, $00), $00)
                                    pointentity(local3, local7\Field1\Field1, 0.0)
                                    moveentity(local3, 0.0, 0.0, (local0 * 1.9))
                                    positionentity(collider, entityx(local3, $00), entityy(collider, $00), entityz(local3, $00), $00)
                                    resetentity(collider)
                                    moveentity(local3, 0.0, 0.0, 0.8)
                                    positionentity(local7\Field1\Field10[$0A], entityx(local3, $00), 0.0, entityz(local3, $00), $00)
                                    rotateentity(local7\Field1\Field10[$0A], 0.0, entityyaw(local3, $00), 0.0, $01)
                                    freeentity(local3)
                                Case $08,$09,$0A,$0B,$0C
                                    local7\Field3 = 1.0
                                    blinktimer = -10.0
                                    playsound(oldmansfx($03))
                                    local3 = createpivot($00)
                                    positionentity(local3, entityx(local7\Field1\Field10[$08], $00), entityy(local7\Field1\Field10[$08], $00), entityz(local7\Field1\Field10[$08], $00), $00)
                                    debuglog("---")
                                    local5 = wrapangle((getangle(entityx(local7\Field1\Field1, $00), entityz(local7\Field1\Field1, $00), entityx(collider, $00), entityz(collider, $00)) - 22.5))
                                    debuglog((Str local5))
                                    local5 = (Float (Int (local5 / 45.0)))
                                    debuglog((Str local5))
                                    debuglog((Str entityyaw(collider, $00)))
                                    moveentity(local3, 0.0, 0.0, (-1400.0 * roomscale))
                                    positionentity(collider, entityx(local3, $00), entityy(collider, $00), entityz(local3, $00), $00)
                                    rotateentity(collider, 0.0, ((entityyaw(collider, $00) - (local5 * 45.0)) - 270.0), 0.0, $01)
                                    resetentity(collider)
                                    moveentity(local3, 0.0, 0.0, -0.8)
                                    positionentity(local7\Field1\Field10[$0A], entityx(local3, $00), 0.0, entityz(local3, $00), $00)
                                    rotateentity(local7\Field1\Field10[$0A], 0.0, entityyaw(local3, $00), 0.0, $01)
                                    positionentity(local3, entityx(local7\Field1\Field10[$08], $00), 0.0, entityz(local7\Field1\Field10[$08], $00), $00)
                                    rotateentity(local3, 0.0, ((Float (rand($01, $03) * $5A)) + local5), 0.0, $00)
                                    moveentity(local3, 0.0, 0.0, (520.0 * roomscale))
                                    positionentity(local7\Field1\Field10[$09], entityx(local3, $00), 0.0, entityz(local3, $00), $00)
                                    freeentity(local3)
                                Case $0D,$0E,$0F
                                    blurtimer = 500.0
                                    local3 = createpivot($00)
                                    positionentity(local3, entityx(local7\Field1\Field1, $00), 0.5, entityz(local7\Field1\Field1, $00), $00)
                                Case $10,$11
                                    blurtimer = 1500.0
                                    For local6 = Each rooms
                                        If (local6\Field6\Field4 = "room106") Then
                                            local7\Field2 = 0.0
                                            positionentity(collider, entityx(local6\Field1, $00), 0.4, entityz(local6\Field1, $00), $00)
                                            resetentity(collider)
                                            Exit
                                        EndIf
                                    Next
                                Case $12,$13
                                    blurtimer = 1500.0
                                    For local6 = Each rooms
                                        If (local6\Field6\Field4 = "room2offices") Then
                                            local7\Field2 = 0.0
                                            positionentity(collider, entityx(local6\Field1, $00), 0.4, entityz(local6\Field1, $00), $00)
                                            resetentity(collider)
                                            Exit
                                        EndIf
                                    Next
                                Case $14,$15,$16,$17,$18,$19,$1A
                                    blinktimer = -10.0
                                    positionentity(collider, entityx(local7\Field1\Field10[$0C], $01), 0.6, entityz(local7\Field1\Field10[$0C], $01), $00)
                                    resetentity(collider)
                                    local7\Field3 = 15.0
                            End Select
                        EndIf
                    Else
                        camerafogcolor(camera, 19.0, 27.5, 23.5)
                        cameraclscolor(camera, 19.0, 27.5, 23.5)
                        If (rand($320, $01) = $01) Then
                            local5 = (entityyaw(camera, $01) + rnd(150.0, 210.0))
                            local4 = createparticle((entityx(collider, $00) + (cos(local5) * 7.5)), 0.0, (entityz(collider, $00) + (sin(local5) * 7.5)), $03, 4.0, 0.0, $9C4)
                            entityblend(local4\Field0, $02)
                            local4\Field8 = 0.01
                            local4\Field15 = 0.0
                            pointentity(local4\Field1, camera, 0.0)
                            turnentity(local4\Field1, 0.0, 145.0, 0.0, $01)
                            turnentity(local4\Field1, (Float rand($0A, $14)), 0.0, 0.0, $01)
                        EndIf
                        If (12.0 < local7\Field3) Then
                            curr106\Field12 = $01
                            positionentity(curr106\Field2, entityx(local7\Field1\Field10[(Int local7\Field3)], $01), 0.27, entityz(local7\Field1\Field10[(Int local7\Field3)], $01), $00)
                            pointentity(curr106\Field2, camera, 0.0)
                            turnentity(curr106\Field2, 0.0, (sin((Float (millisecs() / $14))) * 6.0), 0.0, $01)
                            moveentity(curr106\Field2, 0.0, 0.0, (sin((Float (millisecs() / $0F))) * 0.06))
                            If (((rand($2EE, $01) = $01) And (12.0 < local7\Field3)) <> 0) Then
                                blinktimer = -10.0
                                local7\Field3 = (local7\Field3 - 1.0)
                                playsound(horrorsfx($08))
                            EndIf
                            If (12.0 = local7\Field3) Then
                                camerashake = 1.0
                                positionentity(curr106\Field2, entityx(local7\Field1\Field10[(Int local7\Field3)], $01), -1.0, entityz(local7\Field1\Field10[(Int local7\Field3)], $01), $00)
                                curr106\Field6 = -11.0
                                resetentity(curr106\Field2)
                            EndIf
                        Else
                            curr106\Field6 = -11.0
                            curr106\Field12 = $00
                        EndIf
                        If ((-1600.0 * roomscale) > entityy(collider, $00)) Then
                            If ((144.0 * roomscale) > distance(entityx(local7\Field1\Field10[$10], $01), entityz(local7\Field1\Field10[$10], $01), entityx(collider, $00), entityz(collider, $00))) Then
                                camerafogcolor(camera, 0.0, 0.0, 0.0)
                                cameraclscolor(camera, 0.0, 0.0, 0.0)
                                dropspeed = 0.0
                                blurtimer = 500.0
                                positionentity(collider, entityx(local7\Field1\Field1, $00), 0.5, entityz(local7\Field1\Field1, $00), $00)
                                resetentity(collider)
                                local7\Field3 = 0.0
                            Else
                                If (0.0 <= killtimer) Then
                                    playsound(horrorsfx($08))
                                EndIf
                                killtimer = min(-1.0, killtimer)
                                blurtimer = 3000.0
                            EndIf
                        EndIf
                    EndIf
                Else
                    cameraclscolor(camera, 0.0, 0.0, 0.0)
                    local7\Field2 = 0.0
                    local7\Field3 = 0.0
                EndIf
            Case "room106"
                local17 = $00
                local18 = $00
                local19 = $00
                If (local19 <> 0) Then
                    local7\Field4 = min((local7\Field4 + fpsfactor), 2500.0)
                    If (channelplaying(local7\Field5) = $00) Then
                        local7\Field5 = playsound(radiostatic)
                    EndIf
                EndIf
                If (playerroom = local7\Field1) Then
                    shouldplay = $42
                    If (local7\Field1\Field12[$00]\Field12 = $00) Then
                        animate2(local7\Field1\Field12[$00]\Field0, animtime(local7\Field1\Field12[$00]\Field0), $AB, $AD, 0.01)
                        If (171.0 = animtime(local7\Field1\Field12[$00]\Field0)) Then
                            setanimtime(local7\Field1\Field12[$00]\Field0, 172.99, $00)
                            local7\Field1\Field12[$00]\Field12 = $01
                        EndIf
                    Else
                        animate2(local7\Field1\Field12[$00]\Field0, animtime(local7\Field1\Field12[$00]\Field0), $AD, $AB, -0.01)
                        If (173.0 = animtime(local7\Field1\Field12[$00]\Field0)) Then
                            setanimtime(local7\Field1\Field12[$00]\Field0, 171.01, $00)
                            local7\Field1\Field12[$00]\Field12 = $00
                        EndIf
                    EndIf
                    positionentity(local7\Field1\Field12[$00]\Field2, entityx(local7\Field1\Field10[$05], $01), entityy(local7\Field1\Field10[$05], $01), entityz(local7\Field1\Field10[$05], $01), $01)
                    rotateentity(local7\Field1\Field12[$00]\Field2, entitypitch(local7\Field1\Field10[$05], $01), entityyaw(local7\Field1\Field10[$05], $01), 0.0, $01)
                    resetentity(local7\Field1\Field12[$00]\Field2)
                    local3 = (Int local7\Field3)
                    debuglog((((Str entityy(local7\Field1\Field10[$06], $00)) + " - ") + (Str (((-988.5 * roomscale) > entityy(local7\Field1\Field10[$06], $01)) And ((-1275.0 * roomscale) < entityy(local7\Field1\Field10[$06], $01))))))
                    local20 = updatelever(local7\Field1\Field10[$01], (((-988.5 * roomscale) > entityy(local7\Field1\Field10[$06], $01)) And ((-1275.0 * roomscale) < entityy(local7\Field1\Field10[$06], $01))))
                    If (((grabbedentity = local7\Field1\Field10[$01]) And (drawhandicon = $01)) <> 0) Then
                        local7\Field3 = (Float local20)
                    EndIf
                    If ((Float local3) <> local7\Field3) Then
                        If (0.0 = local7\Field3) Then
                            playsound(magnetdownsfx)
                        Else
                            playsound(magnetupsfx)
                        EndIf
                    EndIf
                    local19 = updatelever(local7\Field1\Field10[$03], $00)
                    If (0.0 = local7\Field2) Then
                        updatebutton(local7\Field1\Field10[$04])
                        If (((closestbutton = local7\Field1\Field10[$04]) And mousehit1) <> 0) Then
                            local7\Field2 = 1.0
                            If (local19 = $01) Then
                                femurbreakersfx = loadsound("SFX\FemurBreaker.ogg")
                                playsound(femurbreakersfx)
                            EndIf
                        EndIf
                    Else
                        local7\Field2 = (local7\Field2 + fpsfactor)
                        If (600.0 <= local7\Field4) Then
                            shouldplay = $01
                            positionentity(curr106\Field2, entityx(local7\Field1\Field10[$05], $01), ((((min((local7\Field4 - 600.0), 800.0) / 320.0) * 108.0) + 700.0) * roomscale), entityz(local7\Field1\Field10[$05], $01), $00)
                            hideentity(curr106\Field1)
                            rotateentity(curr106\Field2, 0.0, (entityyaw(local7\Field1\Field10[$05], $01) + 180.0), 0.0, $01)
                            curr106\Field6 = -11.0
                            animate2(curr106\Field0, animtime(curr106\Field0), $CE, $FA, 0.1)
                            curr106\Field12 = $01
                            If (600.0 > (local7\Field4 - fpsfactor)) Then
                                local14 = createdecal($00, entityx(local7\Field1\Field10[$05], $01), (936.0 * roomscale), entityz(local7\Field1\Field10[$05], $01), 90.0, 0.0, rnd(360.0, 0.0))
                                local14\Field6 = 90000.0
                                local14\Field4 = 0.01
                                local14\Field3 = 0.005
                                local14\Field2 = 0.1
                                local14\Field1 = 0.003
                            EndIf
                            If (((1000.0 > (local7\Field4 - fpsfactor)) And (1000.0 <= local7\Field4)) <> 0) Then
                                If (femurbreakersfx <> $00) Then
                                    freesound(femurbreakersfx)
                                EndIf
                                local14 = createdecal($00, entityx(local7\Field1\Field10[$07], $01), entityy(local7\Field1\Field10[$07], $01), entityz(local7\Field1\Field10[$05], $01), 0.0, 0.0, 0.0)
                                rotateentity(local14\Field0, (entitypitch(local7\Field1\Field10[$07], $01) + 30.0), (entityyaw(local7\Field1\Field10[$07], $01) + 20.0), entityroll(local14\Field0, $00), $00)
                                moveentity(local14\Field0, 0.0, 0.0, 0.15)
                                rotateentity(local14\Field0, entitypitch(local7\Field1\Field10[$07], $01), entityyaw(local7\Field1\Field10[$07], $01), entityroll(local14\Field0, $00), $00)
                                entityparent(local14\Field0, local7\Field1\Field10[$07], $01)
                                local14\Field6 = 90000.0
                                local14\Field4 = 0.01
                                local14\Field3 = 0.005
                                local14\Field2 = 0.05
                                local14\Field1 = 0.002
                            EndIf
                            If (1800.0 < local7\Field4) Then
                                positionentity(local7\Field1\Field10[$07], 0.0, 1000.0, 0.0, $01)
                                If (1.0 = local7\Field3) Then
                                    contained106 = $01
                                Else
                                    positionentity(curr106\Field2, entityx(local7\Field1\Field10[$06], $01), entityy(local7\Field1\Field10[$06], $01), entityz(local7\Field1\Field10[$06], $01), $00)
                                    curr106\Field12 = $00
                                    curr106\Field6 = -10000.0
                                EndIf
                            EndIf
                        EndIf
                    EndIf
                    If ((Int local7\Field3) <> 0) Then
                        positionentity(local7\Field1\Field10[$06], entityx(local7\Field1\Field10[$06], $01), curvevalue(((-980.0 * roomscale) + (sin(((Float millisecs()) * 0.04)) * 0.07)), entityy(local7\Field1\Field10[$06], $01), 200.0), entityz(local7\Field1\Field10[$06], $01), $01)
                        rotateentity(local7\Field1\Field10[$06], sin(((Float millisecs()) * 0.03)), entityyaw(local7\Field1\Field10[$06], $01), (- sin(((Float millisecs()) * 0.025))), $01)
                    Else
                        positionentity(local7\Field1\Field10[$06], entityx(local7\Field1\Field10[$06], $01), curvevalue((-1280.0 * roomscale), entityy(local7\Field1\Field10[$06], $01), 200.0), entityz(local7\Field1\Field10[$06], $01), $01)
                        rotateentity(local7\Field1\Field10[$06], 0.0, entityyaw(local7\Field1\Field10[$06], $01), 0.0, $01)
                    EndIf
                EndIf
            Case "room2ccont"
                If (playerroom = local7\Field1) Then
                    entitypick(camera, 1.5)
                    For local2 = $01 To $05 Step $02
                        If (pickedentity() = local7\Field1\Field10[local2]) Then
                            drawhandicon = $01
                            If (mousehit1 <> 0) Then
                                grabbedentity = local7\Field1\Field10[local2]
                            EndIf
                            If (0.0 = local7\Field2) Then
                                If (local2 = $03) Then
                                    local7\Field2 = max(local7\Field2, 1.0)
                                    playsound(horrorsfx($07))
                                    playsound(leversfx)
                                EndIf
                            EndIf
                        EndIf
                        local21 = entitypitch(local7\Field1\Field10[local2], $00)
                        If ((mousedown1 Or mousehit1) <> 0) Then
                            If (grabbedentity <> $00) Then
                                If (grabbedentity = local7\Field1\Field10[local2]) Then
                                    drawhandicon = $01
                                    turnentity(local7\Field1\Field10[local2], (mouse_y_speed_1 * 2.5), 0.0, 0.0, $00)
                                    rotateentity(grabbedentity, max(min(entitypitch(local7\Field1\Field10[local2], $00), 85.0), -85.0), entityyaw(local7\Field1\Field10[local2], $00), 0.0, $00)
                                    drawarrowicon($00) = $01
                                    drawarrowicon($02) = $01
                                EndIf
                            EndIf
                        Else
                            If (0.0 < entitypitch(local7\Field1\Field10[local2], $00)) Then
                                rotateentity(local7\Field1\Field10[local2], curvevalue(85.0, entitypitch(local7\Field1\Field10[local2], $00), 10.0), entityyaw(local7\Field1\Field10[local2], $00), 0.0, $00)
                            Else
                                rotateentity(local7\Field1\Field10[local2], curvevalue(-85.0, entitypitch(local7\Field1\Field10[local2], $00), 10.0), entityyaw(local7\Field1\Field10[local2], $00), 0.0, $00)
                            EndIf
                            grabbedentity = $00
                        EndIf
                        If (83.0 < entitypitch(local7\Field1\Field10[local2], $00)) Then
                            If (83.0 >= local21) Then
                                playsound2(leversfx, camera, local7\Field1\Field10[local2], 10.0, 1.0)
                            EndIf
                            If (local2 = $03) Then
                                secondarylighton = curvevalue(1.0, secondarylighton, 10.0)
                                If (83.0 >= local21) Then
                                    playsound2(lightsfx, camera, local7\Field1\Field10[local2], 10.0, 1.0)
                                EndIf
                            Else
                                remotedooron = $01
                            EndIf
                        ElseIf (-83.0 > entitypitch(local7\Field1\Field10[local2], $00)) Then
                            If (-83.0 <= local21) Then
                                playsound2(leversfx, camera, local7\Field1\Field10[local2], 10.0, 1.0)
                            EndIf
                            If (local2 = $03) Then
                                If (-83.0 <= local21) Then
                                    playsound2(lightsfx, camera, local7\Field1\Field10[local2], 10.0, 1.0)
                                    For local6 = Each rooms
                                        For local10 = 0.0 To 19.0 Step 1.0
                                            If (local6\Field9[(Int local10)] <> $00) Then
                                                hideentity(local6\Field9[(Int local10)])
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
                    If (((0.0 < local7\Field2) And (200.0 > local7\Field2)) <> 0) Then
                        local7\Field2 = (local7\Field2 + fpsfactor)
                        rotateentity(local7\Field1\Field10[$03], curvevalue(-85.0, entitypitch(local7\Field1\Field10[$03], $00), 5.0), entityyaw(local7\Field1\Field10[$03], $00), 0.0, $00)
                    EndIf
                EndIf
            Case "914"
                If (playerroom = local7\Field1) Then
                    entitypick(camera, 1.0)
                    If (pickedentity() = local7\Field1\Field10[$00]) Then
                        drawhandicon = $01
                        If (mousehit1 <> 0) Then
                            grabbedentity = local7\Field1\Field10[$00]
                        EndIf
                    ElseIf (pickedentity() = local7\Field1\Field10[$01]) Then
                        drawhandicon = $01
                        If (mousehit1 <> 0) Then
                            grabbedentity = local7\Field1\Field10[$01]
                        EndIf
                    EndIf
                    If ((mousedown1 Or mousehit1) <> 0) Then
                        If (grabbedentity <> $00) Then
                            If (grabbedentity = local7\Field1\Field10[$00]) Then
                                If (0.0 = local7\Field2) Then
                                    drawhandicon = $01
                                    turnentity(grabbedentity, 0.0, 0.0, ((- mouse_x_speed_1) * 2.5), $00)
                                    local5 = wrapangle(entityroll(local7\Field1\Field10[$00], $00))
                                    If (181.0 < local5) Then
                                        drawarrowicon($03) = $01
                                    EndIf
                                    drawarrowicon($01) = $01
                                    If (90.0 > local5) Then
                                        rotateentity(grabbedentity, 0.0, 0.0, 361.0, $00)
                                    ElseIf (180.0 > local5) Then
                                        rotateentity(grabbedentity, 0.0, 0.0, 180.0, $00)
                                    EndIf
                                    If (((181.0 > local5) And (90.0 < local5)) <> 0) Then
                                        For local22 = Each items
                                            If (((local22\Field0 <> $00) And (local22\Field7 = $00)) <> 0) Then
                                                If (200.0 > (Abs (entityx(local22\Field0, $00) - (local7\Field1\Field2 - (712.0 * roomscale))))) Then
                                                    If (104.0 > (Abs (entityy(local22\Field0, $00) - ((648.0 * roomscale) + local7\Field1\Field3)))) Then
                                                        local7\Field2 = 1.0
                                                        local7\Field5 = playsound2(machinesfx, camera, local7\Field1\Field10[$01], 10.0, 1.0)
                                                        Exit
                                                    EndIf
                                                EndIf
                                            EndIf
                                        Next
                                    EndIf
                                EndIf
                            ElseIf (grabbedentity = local7\Field1\Field10[$01]) Then
                                If (0.0 = local7\Field2) Then
                                    drawhandicon = $01
                                    turnentity(grabbedentity, 0.0, 0.0, ((- mouse_x_speed_1) * 2.5), $00)
                                    local5 = wrapangle(entityroll(local7\Field1\Field10[$01], $00))
                                    drawarrowicon($03) = $01
                                    drawarrowicon($01) = $01
                                    If (90.0 < local5) Then
                                        If (180.0 > local5) Then
                                            rotateentity(grabbedentity, 0.0, 0.0, 90.0, $00)
                                        ElseIf (270.0 > local5) Then
                                            rotateentity(grabbedentity, 0.0, 0.0, 270.0, $00)
                                        EndIf
                                    EndIf
                                EndIf
                            EndIf
                        EndIf
                    Else
                        grabbedentity = $00
                    EndIf
                    local23 = ""
                    If (grabbedentity <> local7\Field1\Field10[$01]) Then
                        local5 = wrapangle(entityroll(local7\Field1\Field10[$01], $00))
                        If (22.5 > local5) Then
                            local5 = 0.0
                            local23 = "1:1"
                        ElseIf (67.5 > local5) Then
                            local5 = 45.0
                            local23 = "coarse"
                        ElseIf (180.0 > local5) Then
                            local5 = 90.0
                            local23 = "rough"
                        ElseIf (337.5 < local5) Then
                            local5 = -1.0
                            local23 = "1:1"
                        ElseIf (292.5 < local5) Then
                            local5 = -45.0
                            local23 = "fine"
                        Else
                            local5 = -90.0
                            local23 = "very fine"
                        EndIf
                        rotateentity(local7\Field1\Field10[$01], 0.0, 0.0, curvevalue(local5, entityroll(local7\Field1\Field10[$01], $00), 10.0), $00)
                    EndIf
                    For local2 = $00 To $01 Step $01
                        If (grabbedentity = local7\Field1\Field10[local2]) Then
                            If (entityinview(local7\Field1\Field10[local2], camera) = $00) Then
                                grabbedentity = $00
                            ElseIf (1.0 < entitydistance(local7\Field1\Field10[local2], camera)) Then
                                grabbedentity = $00
                            EndIf
                        EndIf
                    Next
                    If (0.0 < local7\Field2) Then
                        local7\Field2 = (local7\Field2 + fpsfactor)
                        rotateentity(local7\Field1\Field10[$00], entitypitch(local7\Field1\Field10[$00], $00), entityyaw(local7\Field1\Field10[$00], $00), 180.0, $00)
                        local7\Field1\Field11[$01]\Field5 = $00
                        If (140.0 < local7\Field2) Then
                            local7\Field1\Field11[$00]\Field5 = $00
                        EndIf
                        If ((170.0 * roomscale) > distance(entityx(collider, $00), entityz(collider, $00), entityx(local7\Field1\Field10[$02], $01), entityz(local7\Field1\Field10[$02], $01))) Then
                            If (((local23 = "rough") Or (local23 = "coarse")) <> 0) Then
                                If (((182.0 < local7\Field2) And (182.0 > (local7\Field2 - fpsfactor2))) <> 0) Then
                                    playsound(death914sfx)
                                EndIf
                            EndIf
                            If (210.0 < local7\Field2) Then
                                Select local23
                                    Case "rough","coarse"
                                        killtimer = min(-1.0, killtimer)
                                        blinktimer = -10.0
                                        If (local7\Field5 <> $00) Then
                                            stopchannel(local7\Field5)
                                        EndIf
                                    Case "1:1"
                                        blinktimer = -10.0
                                        If (210.0 > (local7\Field2 - fpsfactor2)) Then
                                            playsound(use914sfx)
                                        EndIf
                                    Case "fine","very fine"
                                        blinktimer = -10.0
                                        If (210.0 > (local7\Field2 - fpsfactor2)) Then
                                            playsound(use914sfx)
                                        EndIf
                                End Select
                            EndIf
                        EndIf
                        If (840.0 < local7\Field2) Then
                            For local22 = Each items
                                If (((local22\Field0 <> $00) And (local22\Field7 = $00)) <> 0) Then
                                    If ((180.0 * roomscale) > distance(entityx(local22\Field0, $00), entityz(local22\Field0, $00), entityx(local7\Field1\Field10[$02], $01), entityz(local7\Field1\Field10[$02], $01))) Then
                                        use914(local22, local23, entityx(local7\Field1\Field10[$03], $01), entityy(local7\Field1\Field10[$03], $01), entityz(local7\Field1\Field10[$03], $01))
                                    EndIf
                                EndIf
                            Next
                            If ((160.0 * roomscale) > distance(entityx(collider, $00), entityz(collider, $00), entityx(local7\Field1\Field10[$02], $01), entityz(local7\Field1\Field10[$02], $01))) Then
                                Select local23
                                    Case "1:1"
                                        invertmouse = (invertmouse = $00)
                                    Case "fine","very fine"
                                        superman = $01
                                End Select
                                blurtimer = 1000.0
                                positionentity(collider, entityx(local7\Field1\Field10[$03], $01), (entityy(local7\Field1\Field10[$03], $01) + 1.0), entityz(local7\Field1\Field10[$03], $01), $00)
                                resetentity(collider)
                                dropspeed = 0.0
                            EndIf
                            local7\Field1\Field11[$00]\Field5 = $01
                            local7\Field1\Field11[$01]\Field5 = $01
                            rotateentity(local7\Field1\Field10[$00], 0.0, 0.0, 0.0, $00)
                            local7\Field2 = 0.0
                        EndIf
                    EndIf
                EndIf
        End Select
    Next
    Return $00
End Function
