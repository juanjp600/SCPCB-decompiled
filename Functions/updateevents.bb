Function updateevents%()
    Local local0#
    Local local1%
    Local local2%
    Local local3%
    Local local4.particles
    Local local5.npcs
    Local local6.rooms
    Local local7.events
    Local local8.events
    Local local9.items
    Local local10#
    Local local12#
    Local local13#
    Local local14.emitters
    Local local15%
    Local local16.decals
    Local local19%
    Local local20%
    Local local21%
    Local local22#
    Local local23$
    For local6 = Each rooms
        If (((12.0 > (Abs (entityx(collider, $00) - entityx(local6\Field2, $00)))) And (12.0 > (Abs (entityz(collider, $00) - entityz(local6\Field2, $00))))) <> 0) Then
            mapfound(playerlevel, (Int floor((entityx(local6\Field2, $00) / 8.0))), (Int floor((entityz(local6\Field2, $00) / 8.0)))) = (Int max((Float mapfound(playerlevel, (Int floor((entityx(local6\Field2, $00) / 8.0))), (Int floor((entityz(local6\Field2, $00) / 8.0))))), 1.0))
            If (((4.0 > (Abs (entityx(collider, $00) - entityx(local6\Field2, $00)))) And (4.0 > (Abs (entityz(collider, $00) - entityz(local6\Field2, $00))))) <> 0) Then
                If (1.5 > (Abs (entityy(collider, $00) - entityy(local6\Field2, $00)))) Then
                    playerroom = local6
                EndIf
                mapfound(playerlevel, (Int floor((entityx(local6\Field2, $00) / 8.0))), (Int floor((entityz(local6\Field2, $00) / 8.0)))) = $02
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
                            local7\Field6 = playsound(alarmsfx($01))
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
                If (playerroom = local7\Field1) Then
                    shouldplay = $42
                    camerafogmode(camera, $00)
                    ambientlight(250.0, 250.0, 250.0)
                    hideentity(fog)
                EndIf
                lightvolume = 1.5
                templightvolume = 1.5
                If (0.0 <= killtimer) Then
                    If (0.0 = local7\Field2) Then
                        If (playerroom = local7\Field1) Then
                            For local1 = $00 To $03 Step $01
                                introsfx(local1) = loadsound((("SFX\intro\intro" + (Str (local1 + $01))) + ".ogg"))
                            Next
                            For local1 = $04 To $06 Step $01
                                introsfx(local1) = loadsound((("SFX\intro\refuse" + (Str (local1 - $03))) + ".ogg"))
                            Next
                            curr173\Field19 = $01
                            local7\Field1\Field13[$00] = createnpc($03, entityx(local7\Field1\Field11[$00], $01), entityy(local7\Field1\Field11[$00], $01), entityz(local7\Field1\Field11[$00], $01))
                            local7\Field1\Field13[$00]\Field13 = 180.0
                            local7\Field1\Field13[$01] = createnpc($04, entityx(local7\Field1\Field11[$01], $01), 0.5, entityz(local7\Field1\Field11[$01], $01))
                            pointentity(local7\Field1\Field13[$01]\Field4, local7\Field1\Field11[$05], 0.0)
                            local7\Field1\Field13[$02] = createnpc($04, entityx(local7\Field1\Field11[$02], $01), 0.5, entityz(local7\Field1\Field11[$02], $01))
                            pointentity(local7\Field1\Field13[$02]\Field4, local7\Field1\Field11[$05], 0.0)
                            positionentity(curr173\Field4, entityx(local7\Field1\Field11[$05], $01), 0.5, entityz(local7\Field1\Field11[$05], $01), $00)
                            resetentity(curr173\Field4)
                            local7\Field2 = 1.0
                        EndIf
                    ElseIf (10000.0 > local7\Field2) Then
                        local7\Field2 = min(((fpsfactor / 3.0) + local7\Field2), 5000.0)
                        If (((100.0 < local7\Field2) And (100.0 > (local7\Field2 - fpsfactor))) = 0) Then
                            If (((130.0 <= local7\Field2) And (130.0 > (local7\Field2 - (fpsfactor / 3.0)))) <> 0) Then
                                local7\Field5 = playsound(introsfx($00))
                            ElseIf (230.0 < local7\Field2) Then
                                local2 = $01
                                For local1 = $01 To $02 Step $01
                                    If (0.3 < distance(entityx(local7\Field1\Field13[local1]\Field4, $00), entityz(local7\Field1\Field13[local1]\Field4, $00), entityx(local7\Field1\Field11[(local1 + $02)], $01), entityz(local7\Field1\Field11[(local1 + $02)], $01))) Then
                                        pointentity(local7\Field1\Field13[local1]\Field4, local7\Field1\Field11[(local1 + $02)], 0.0)
                                        If ((Float ((local1 * $1E) + $C8)) < local7\Field2) Then
                                            local7\Field1\Field13[local1]\Field9 = 1.0
                                        EndIf
                                        local2 = $00
                                    Else
                                        local7\Field1\Field13[local1]\Field9 = 0.0
                                        pointentity(local7\Field1\Field13[local1]\Field4, local7\Field1\Field11[$05], 0.0)
                                    EndIf
                                Next
                                If (entityx(collider, $00) < (entityx(local7\Field1\Field2, $00) + (408.0 * roomscale))) Then
                                    If (((450.0 < local7\Field2) And (450.0 > (local7\Field2 - (fpsfactor / 3.0)))) <> 0) Then
                                        local7\Field5 = playsound(introsfx($04))
                                    ElseIf (((650.0 < local7\Field2) And (650.0 > (local7\Field2 - (fpsfactor / 3.0)))) <> 0) Then
                                        local7\Field5 = playsound(introsfx($05))
                                    ElseIf (((850.0 < local7\Field2) And (850.0 > (local7\Field2 - (fpsfactor / 3.0)))) <> 0) Then
                                        local7\Field1\Field12[$01]\Field5 = $00
                                        local7\Field5 = playsound(introsfx($06))
                                    ElseIf (1000.0 < local7\Field2) Then
                                        local7\Field1\Field13[$00]\Field9 = 1.0
                                        Delete local7
                                        Exit
                                    EndIf
                                    If (850.0 < local7\Field2) Then
                                        positionentity(collider, min(entityx(collider, $00), (entityx(local7\Field1\Field2, $00) + (352.0 * roomscale))), entityy(collider, $00), entityz(collider, $00), $00)
                                    EndIf
                                ElseIf (local2 = $01) Then
                                    local7\Field2 = 10000.0
                                    usedoor(local7\Field1\Field12[$01], $01)
                                EndIf
                            EndIf
                        EndIf
                        positionentity(curr173\Field4, entityx(local7\Field1\Field11[$05], $01), entityy(curr173\Field4, $00), entityz(local7\Field1\Field11[$05], $01), $00)
                        rotateentity(curr173\Field4, 0.0, 0.0, 0.0, $01)
                        resetentity(curr173\Field4)
                    ElseIf (14000.0 > local7\Field2) Then
                        local7\Field2 = min((local7\Field2 + fpsfactor), 13000.0)
                        If (10300.0 > (local7\Field2 - (fpsfactor / 3.0))) Then
                            positionentity(collider, max(entityx(collider, $00), (entityx(local7\Field1\Field2, $00) + (352.0 * roomscale))), entityy(collider, $00), entityz(collider, $00), $00)
                        EndIf
                        If (((10300.0 < local7\Field2) And (10300.0 > (local7\Field2 - fpsfactor))) <> 0) Then
                            local7\Field5 = playsound(introsfx($01))
                            positionentity(collider, max(entityx(collider, $00), (entityx(local7\Field1\Field2, $00) + (352.0 * roomscale))), entityy(collider, $00), entityz(collider, $00), $00)
                        ElseIf (((10440.0 < local7\Field2) And (10440.0 > (local7\Field2 - fpsfactor))) <> 0) Then
                            usedoor(local7\Field1\Field12[$01], $01)
                            local7\Field5 = playsound(introsfx($07))
                        ElseIf (((10740.0 < local7\Field2) And (10740.0 > (local7\Field2 - fpsfactor))) <> 0) Then
                            local7\Field5 = playsound(introsfx($02))
                        ElseIf (((11490.0 < local7\Field2) And (11490.0 > (local7\Field2 - fpsfactor))) <> 0) Then
                            local7\Field5 = playsound(introsfx($0A))
                        ElseIf (((11561.0 < local7\Field2) And (11561.0 > (local7\Field2 - fpsfactor))) <> 0) Then
                            local7\Field2 = 14000.0
                        EndIf
                        positionentity(curr173\Field4, entityx(local7\Field1\Field11[$05], $01), entityy(curr173\Field4, $00), entityz(local7\Field1\Field11[$05], $01), $00)
                        rotateentity(curr173\Field4, 0.0, 0.0, 0.0, $01)
                        resetentity(curr173\Field4)
                    ElseIf (20000.0 > local7\Field2) Then
                        local7\Field2 = min((local7\Field2 + fpsfactor), 19000.0)
                        If (14100.0 > local7\Field2) Then
                            If (14005.0 < local7\Field2) Then
                                setanimtime(local7\Field1\Field13[$01]\Field0, 171.0, $00)
                                positionentity(curr173\Field4, entityx(local7\Field1\Field13[$01]\Field0, $00), entityy(curr173\Field4, $00), entityz(local7\Field1\Field13[$01]\Field0, $00), $00)
                                resetentity(curr173\Field4)
                                pointentity(curr173\Field4, local7\Field1\Field13[$02]\Field4, 0.0)
                            EndIf
                            pointentity(local7\Field1\Field13[$02]\Field4, curr173\Field4, 0.0)
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
                                setanimtime(local7\Field1\Field13[$02]\Field0, 171.0, $00)
                                positionentity(curr173\Field4, entityx(local7\Field1\Field13[$02]\Field0, $00), entityy(curr173\Field4, $00), entityz(local7\Field1\Field13[$02]\Field0, $00), $00)
                                resetentity(curr173\Field4)
                                pointentity(curr173\Field4, collider, 0.0)
                            EndIf
                            If (14130.0 > local7\Field2) Then
                                blinktimer = -10.0
                                lightblink = 1.0
                            Else
                                curr173\Field19 = $00
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
                            If (entityx(collider, $00) < (entityx(local7\Field1\Field2, $00) + (448.0 * roomscale))) Then
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
                                curr173\Field19 = $01
                                pointentity(local7\Field1\Field13[$00]\Field4, curr173\Field0, 0.0)
                                positionentity(curr173\Field4, (entityx(local7\Field1\Field2, $00) - (448.0 * roomscale)), (entityy(local7\Field1\Field2, $00) + (480.0 * roomscale)), (entityz(local7\Field1\Field2, $00) + (1398.0 * roomscale)), $00)
                                resetentity(curr173\Field4)
                                pointentity(curr173\Field4, local7\Field1\Field13[$00]\Field4, 0.0)
                            EndIf
                            blinktimer = -10.0
                            lightblink = 1.0
                            camerashake = 3.0
                        ElseIf (20300.0 > local7\Field2) Then
                            pointentity(local7\Field1\Field13[$00]\Field4, curr173\Field4, 0.0)
                            moveentity(local7\Field1\Field13[$00]\Field4, 0.0, 0.0, -0.002)
                            local7\Field1\Field13[$00]\Field9 = 2.0
                            If (((20260.0 < local7\Field2) And (20260.0 > (local7\Field2 - fpsfactor))) <> 0) Then
                                playsound(introsfx($0C))
                            EndIf
                        ElseIf (20300.0 > (local7\Field2 - fpsfactor)) Then
                            blinktimer = -10.0
                            lightblink = 1.0
                            camerashake = 3.0
                            playsound(introsfx($0B))
                            curr173\Field19 = $00
                            removenpc(local7\Field1\Field13[$00])
                            local7\Field5 = playsound(introsfx($0F))
                            positionentity(curr173\Field4, (entityx(playerroom\Field2, $00) - (400.0 * roomscale)), 100.0, (entityz(playerroom\Field2, $00) + (1072.0 * roomscale)), $00)
                            resetentity(curr173\Field4)
                            For local6 = Each rooms
                                If (local6\Field7\Field4 = "start") Then
                                    local12 = entityx(local6\Field2, $01)
                                    local13 = entityz(local6\Field2, $01)
                                    positionentity(collider, ((entityx(collider, $00) - entityx(local7\Field1\Field2, $00)) + local12), 1.0, ((entityz(collider, $00) - entityz(local7\Field1\Field2, $00)) + local13), $00)
                                    resetentity(collider)
                                    positionentity(curr173\Field4, ((entityx(curr173\Field4, $00) - entityx(local7\Field1\Field2, $00)) + local12), entityy(curr173\Field4, $00), ((entityz(curr173\Field4, $00) - entityz(local7\Field1\Field2, $00)) + local13), $00)
                                    resetentity(curr173\Field4)
                                    For local1 = $01 To $02 Step $01
                                        positionentity(local7\Field1\Field13[local1]\Field4, ((entityx(local7\Field1\Field13[local1]\Field4, $00) - entityx(local7\Field1\Field2, $00)) + local12), 1.0, ((entityz(local7\Field1\Field13[local1]\Field4, $00) - entityz(local7\Field1\Field2, $00)) + local13), $00)
                                        resetentity(local7\Field1\Field13[local1]\Field4)
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
                    For local1 = $00 To $06 Step $01
                        freesound(introsfx(local1))
                    Next
                    Delete local7
                EndIf
            Case "room2doors173"
                If (0.0 = local7\Field2) Then
                    If (playerroom = local7\Field1) Then
                        If (entityinview(curr173\Field0, camera) = $00) Then
                            local7\Field2 = 1.0
                            positionentity(curr173\Field4, entityx(local7\Field1\Field11[$00], $01), 0.5, entityz(local7\Field1\Field11[$00], $01), $00)
                            resetentity(curr173\Field4)
                            Delete local7
                        EndIf
                    EndIf
                EndIf
            Case "buttghost"
                If (playerroom = local7\Field1) Then
                    If (1.8 > entitydistance(collider, local7\Field1\Field11[$00])) Then
                        achv789 = $01
                        local7\Field5 = playsound2(buttghostsfx, camera, local7\Field1\Field11[$00], 10.0, 1.0, $01)
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
                            local7\Field5 = playsound(roar682sfx)
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
                        positionentity(curr173\Field4, entityx(local7\Field1\Field11[$00], $01), 0.5, entityz(local7\Field1\Field11[$00], $01), $00)
                        resetentity(curr173\Field4)
                        local7\Field2 = 1.0
                    Else
                        local7\Field2 = (local7\Field2 + 1.0)
                        local0 = entitydistance(collider, local7\Field1\Field11[$01])
                        If (1.0 > local0) Then
                            local7\Field2 = max(local7\Field2, 840.0)
                        ElseIf (1.4 < local0) Then
                            If (840.0 < local7\Field2) Then
                                If ((entityinview(curr173\Field0, camera) Or (-10.0 >= blinktimer)) = $00) Then
                                    playsound2(glassbreaksfx, camera, curr173\Field0, 10.0, 1.0, $01)
                                    freeentity(local7\Field1\Field11[$02])
                                    positionentity(curr173\Field4, entityx(local7\Field1\Field11[$01], $01), 0.5, entityz(local7\Field1\Field11[$01], $01), $00)
                                    resetentity(curr173\Field4)
                                    Delete local7
                                EndIf
                            EndIf
                        EndIf
                    EndIf
                EndIf
            Case "testroom"
                If (0.0 = local7\Field2) Then
                    If (playerroom = local7\Field1) Then
                        If (2.5 > entitydistance(collider, local7\Field1\Field11[$06])) Then
                            msg079 = loadsound("SFX\msg.ogg")
                            local7\Field5 = playsound(msg079)
                            For local1 = $00 To $05 Step $01
                                local14 = createemitter(entityx(local7\Field1\Field11[local1], $01), entityy(local7\Field1\Field11[local1], $01), entityz(local7\Field1\Field11[local1], $01), $00)
                                turnentity(local14\Field0, 90.0, 0.0, 0.0, $01)
                                local14\Field10 = 5.0
                                local14\Field9 = 0.042
                                local14\Field11 = (1.0 / 400.0)
                            Next
                            local7\Field2 = 1.0
                            Delete local7
                        EndIf
                    EndIf
                ElseIf (local7\Field5 = $00) Then
                    freesound(msg079)
                    Delete local7
                ElseIf (channelplaying(local7\Field5) = $00) Then
                    freesound(msg079)
                    Delete local7
                EndIf
            Case "room079"
                If (playerroom = local7\Field1) Then
                    shouldplay = $04
                    If (remotedooron <> 0) Then
                        If (((70.0 < local7\Field1\Field12[$00]\Field7) And local7\Field1\Field12[$00]\Field5) <> 0) Then
                            local7\Field1\Field12[$00]\Field5 = $00
                        EndIf
                    ElseIf (10000.0 > local7\Field2) Then
                        If (0.0 = local7\Field2) Then
                            music($04) = loadsound("SFX\Music\AI.ogg")
                            local7\Field2 = 1.0
                        ElseIf (1.0 = local7\Field2) Then
                            If (2.5 > entitydistance(local7\Field1\Field11[$00], collider)) Then
                                achv079 = $01
                                local7\Field2 = 2.0
                                local7\Field3 = 1.0
                                local7\Field7 = loadsound("SFX\079_1.ogg")
                                local7\Field5 = playsound(local7\Field7)
                            EndIf
                        ElseIf (3500.0 > local7\Field2) Then
                            If (channelplaying(local7\Field5) <> 0) Then
                                If (rand($03, $01) = $01) Then
                                    entitytexture(local7\Field1\Field11[$01], oldaipics($00), $00, $00)
                                    showentity(local7\Field1\Field11[$01])
                                ElseIf (rand($0A, $01) = $01) Then
                                    hideentity(local7\Field1\Field11[$01])
                                EndIf
                            Else
                                If (local7\Field7 <> $00) Then
                                    freesound(local7\Field7)
                                    local7\Field7 = $00
                                EndIf
                                entitytexture(local7\Field1\Field11[$01], oldaipics($01), $00, $00)
                                showentity(local7\Field1\Field11[$01])
                            EndIf
                        ElseIf (2.5 > entitydistance(local7\Field1\Field11[$00], collider)) Then
                            local7\Field2 = 10001.0
                            local7\Field7 = loadsound("SFX\079_2.ogg")
                            local7\Field5 = playsound(local7\Field7)
                            entitytexture(local7\Field1\Field11[$01], oldaipics($01), $00, $00)
                            showentity(local7\Field1\Field11[$01])
                        EndIf
                    EndIf
                EndIf
                If (0.0 < local7\Field3) Then
                    If (350.0 < local7\Field3) Then
                        If (360.0 > local7\Field3) Then
                            local7\Field3 = min((local7\Field3 + fpsfactor), 355.0)
                            If (remotedooron <> 0) Then
                                local7\Field7 = loadsound("SFX\079_3.ogg")
                                local7\Field5 = playsound(local7\Field7)
                                local7\Field3 = 400.0
                                For local6 = Each rooms
                                    If (local6\Field7\Field4 = "exit1") Then
                                        local6\Field12[$04]\Field5 = $01
                                        Exit
                                    EndIf
                                Next
                            EndIf
                        Else
                            local7\Field3 = (local7\Field3 + fpsfactor)
                            If (800.0 < local7\Field3) Then
                                For local6 = Each rooms
                                    If (local6\Field7\Field4 = "exit1") Then
                                        local6\Field12[$04]\Field5 = remotedooron
                                        Exit
                                    EndIf
                                Next
                                local7\Field3 = 400.0
                            EndIf
                        EndIf
                    Else
                        local7\Field3 = (local7\Field3 + fpsfactor)
                    EndIf
                EndIf
            Case "room2nuke"
                If (playerroom = local7\Field1) Then
                    local7\Field3 = updateelevators(local7\Field3, local7\Field1\Field12[$00], local7\Field1\Field12[$01], local7\Field1\Field11[$04], local7\Field1\Field11[$05], local7)
                    local7\Field2 = (Float updatelever(local7\Field1\Field11[$01], $00))
                    updatelever(local7\Field1\Field11[$03], $00)
                EndIf
            Case "exit1"
                If (playerroom = local7\Field1) Then
                    If ((1040.0 * roomscale) < entityy(collider, $00)) Then
                        curr106\Field9 = 20000.0
                        curr106\Field19 = $01
                        If (0.0 = local7\Field2) Then
                            drawloading($00, $01)
                            For local1 = $00 To $13 Step $01
                                If (local7\Field1\Field10[local1] <> $00) Then
                                    entityfx(local7\Field1\Field10[local1], $09)
                                EndIf
                            Next
                            music($05) = loadsound("SFX\Music\Satiate Strings.ogg")
                            drawloading($14, $01)
                            music($06) = loadsound("SFX\Music\Medusa.ogg")
                            drawloading($1E, $01)
                            local7\Field1\Field13[$01] = createnpc($03, entityx(local7\Field1\Field11[$04], $01), (entityy(local7\Field1\Field11[$04], $01) + 0.5), entityz(local7\Field1\Field11[$04], $01))
                            local7\Field1\Field13[$01]\Field9 = 1.0
                            local7\Field2 = 1.0
                            For local1 = $00 To $46 Step $01
                                drawloading(($1E + local1), $01)
                                local15 = (millisecs() + $05)
                                Repeat
                                Until (millisecs() > local15)
                            Next
                        Else
                            If (2.0 > local7\Field2) Then
                                If (2.0 = local7\Field1\Field13[$00]\Field9) Then
                                    shouldplay = $06
                                Else
                                    local7\Field3 = ((local7\Field3 + fpsfactor) Mod 3600.0)
                                    positionentity(local7\Field1\Field13[$00]\Field4, (entityx(local7\Field1\Field2, $01) + ((cos((local7\Field3 / 10.0)) * 6000.0) * roomscale)), (14000.0 * roomscale), (entityz(local7\Field1\Field2, $01) + ((sin((local7\Field3 / 10.0)) * 6000.0) * roomscale)), $00)
                                    rotateentity(local7\Field1\Field13[$00]\Field4, 7.0, (local7\Field3 / 10.0), 20.0, $00)
                                    shouldplay = $05
                                EndIf
                                If ((320.0 * roomscale) > entitydistance(collider, local7\Field1\Field11[$0A])) Then
                                    local7\Field2 = 2.0
                                    local7\Field1\Field12[$02]\Field5 = $00
                                    local7\Field1\Field12[$02]\Field4 = $06
                                    local7\Field1\Field12[$03]\Field5 = $00
                                    local7\Field1\Field12[$03]\Field4 = $06
                                    local7\Field1\Field13[$02] = createnpc($07, entityx(local7\Field1\Field11[$09], $01), (entityy(local7\Field1\Field11[$09], $01) + 0.5), entityz(local7\Field1\Field11[$09], $01))
                                    local7\Field1\Field13[$02]\Field9 = 3.0
                                    local7\Field1\Field13[$03] = createnpc($07, entityx(local7\Field1\Field11[$07], $01), (entityy(local7\Field1\Field11[$07], $01) - 2.0), entityz(local7\Field1\Field11[$07], $01))
                                    local7\Field1\Field13[$03]\Field9 = 3.0
                                    local7\Field1\Field13[$00]\Field9 = 3.0
                                    tempsound = loadsound("SFX\682battle.ogg")
                                    local7\Field5 = playsound(tempsound)
                                EndIf
                            Else
                                shouldplay = $06
                                local7\Field2 = (local7\Field2 + fpsfactor)
                                If (2800.0 > local7\Field2) Then
                                    local7\Field1\Field13[$00]\Field28 = (entityx(local7\Field1\Field11[$0B], $01) + (sin(((Float millisecs()) / 25.0)) * 3.0))
                                    local7\Field1\Field13[$00]\Field29 = ((entityy(local7\Field1\Field11[$0B], $01) + cos(((Float millisecs()) / 85.0))) + 9.0)
                                    local7\Field1\Field13[$00]\Field30 = (entityz(local7\Field1\Field11[$0B], $01) + (cos(((Float millisecs()) / 25.0)) * 3.0))
                                    local7\Field1\Field13[$02]\Field28 = (entityx(local7\Field1\Field11[$0B], $01) + (sin(((Float millisecs()) / 23.0)) * 3.0))
                                    local7\Field1\Field13[$02]\Field29 = ((entityy(local7\Field1\Field11[$0B], $01) + cos(((Float millisecs()) / 83.0))) + 5.0)
                                    local7\Field1\Field13[$02]\Field30 = (entityz(local7\Field1\Field11[$0B], $01) + (cos(((Float millisecs()) / 23.0)) * 3.0))
                                    If (3.0 = local7\Field1\Field13[$03]\Field9) Then
                                        local7\Field1\Field13[$03]\Field28 = (entityx(local7\Field1\Field11[$0B], $01) + (sin(((Float millisecs()) / 20.0)) * 3.0))
                                        local7\Field1\Field13[$03]\Field29 = ((entityy(local7\Field1\Field11[$0B], $01) + cos(((Float millisecs()) / 80.0))) + 3.5)
                                        local7\Field1\Field13[$03]\Field30 = (entityz(local7\Field1\Field11[$0B], $01) + (cos(((Float millisecs()) / 20.0)) * 3.0))
                                    EndIf
                                EndIf
                            EndIf
                            If (((42.0 < local7\Field2) And (2954.0 > local7\Field2)) <> 0) Then
                                If (49.0 > local7\Field2) Then
                                    camerashake = 0.5
                                ElseIf (((224.0 < local7\Field2) And (231.0 > local7\Field2)) <> 0) Then
                                    camerashake = 0.5
                                ElseIf (((427.0 < local7\Field2) And (434.0 > local7\Field2)) <> 0) Then
                                    camerashake = 0.5
                                ElseIf (((756.0 > local7\Field2) And (763.0 > local7\Field2)) <> 0) Then
                                    camerashake = 0.5
                                ElseIf (((847.0 < local7\Field2) And (861.0 > local7\Field2)) <> 0) Then
                                    camerashake = 1.0
                                ElseIf (((931.0 < local7\Field2) And (945.0 > local7\Field2)) <> 0) Then
                                    camerashake = 1.5
                                ElseIf (((1155.0 < local7\Field2) And (1295.0 > local7\Field2)) <> 0) Then
                                    camerashake = 3.0
                                ElseIf (((1505.0 < local7\Field2) And (1680.0 > local7\Field2)) <> 0) Then
                                    camerashake = 2.0
                                ElseIf (((1785.0 < local7\Field2) And (1890.0 > local7\Field2)) <> 0) Then
                                    camerashake = 2.0
                                ElseIf (((2170.0 < local7\Field2) And (2205.0 > local7\Field2)) <> 0) Then
                                    camerashake = 0.5
                                ElseIf (((2450.0 < local7\Field2) And (2555.0 > local7\Field2)) <> 0) Then
                                    camerashake = 1.5
                                    If (2450.0 >= (local7\Field2 - fpsfactor)) Then
                                        If (tempsound2 <> $00) Then
                                            freesound(tempsound2)
                                            tempsound2 = $00
                                        EndIf
                                        tempsound2 = loadsound("SFX\nuke1.ogg")
                                        local7\Field6 = playsound(tempsound2)
                                    EndIf
                                ElseIf (((2765.0 < local7\Field2) And (2786.0 > local7\Field2)) <> 0) Then
                                    camerashake = 1.0
                                ElseIf (2940.0 < local7\Field2) Then
                                    camerashake = 0.5
                                    local7\Field1\Field13[$00]\Field28 = (entityx(local7\Field1\Field11[$13], $01) + 4.0)
                                    local7\Field1\Field13[$00]\Field29 = (entityy(local7\Field1\Field11[$13], $01) + 4.0)
                                    local7\Field1\Field13[$00]\Field30 = (entityz(local7\Field1\Field11[$13], $01) + 4.0)
                                    local7\Field1\Field13[$02]\Field28 = entityx(local7\Field1\Field11[$13], $01)
                                    local7\Field1\Field13[$02]\Field29 = entityy(local7\Field1\Field11[$13], $01)
                                    local7\Field1\Field13[$02]\Field30 = entityz(local7\Field1\Field11[$13], $01)
                                EndIf
                            EndIf
                            If (3150.0 <= local7\Field2) Then
                                If (5250.0 > local7\Field2) Then
                                    If (nuclearsirensfx = $00) Then
                                        nuclearsirensfx = loadsound("SFX\nukesiren.ogg")
                                    EndIf
                                    If (local7\Field5 = $00) Then
                                        local7\Field5 = playsound(nuclearsirensfx)
                                    ElseIf (channelplaying(local7\Field5) = $00) Then
                                        local7\Field5 = playsound(nuclearsirensfx)
                                    EndIf
                                ElseIf (selectedending = "") Then
                                    If (channelplaying(local7\Field5) = $00) Then
                                        local2 = $01
                                        For local8 = Each events
                                            If (local8\Field0 = "room2nuke") Then
                                                local2 = (Int local8\Field2)
                                                Exit
                                            EndIf
                                        Next
                                        If (local2 = $01) Then
                                            explosiontimer = max(explosiontimer, 0.1)
                                            selectedending = "B2"
                                        Else
                                            local7\Field7 = loadsound("SFX\nuke2.ogg")
                                            local7\Field5 = playsound(local7\Field7)
                                            local5 = createnpc($07, entityx(local7\Field1\Field11[$09], $01), (entityy(local7\Field1\Field11[$09], $01) + 0.5), entityz(local7\Field1\Field11[$09], $01))
                                            local5\Field9 = 2.0
                                            local7\Field1\Field13[$02]\Field9 = 2.0
                                            For local1 = $0E To $11 Step $01
                                                local14 = createemitter(entityx(local7\Field1\Field11[local1], $01), entityy(local7\Field1\Field11[local1], $01), entityz(local7\Field1\Field11[local1], $01), $00)
                                                turnentity(local14\Field0, 90.0, 0.0, 0.0, $01)
                                                local14\Field7 = playerroom
                                                local14\Field10 = 5.0
                                                local14\Field9 = 0.019
                                                local14\Field11 = 0.0027
                                            Next
                                            selectedending = "B3"
                                        EndIf
                                    EndIf
                                Else
                                    debuglog("ewrgdsfgfdghjgfhj")
                                    If (selectedending = "B3") Then
                                        debuglog("qwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww")
                                        local7\Field1\Field13[$00]\Field28 = (entityx(local7\Field1\Field11[$0B], $01) + (sin(((Float millisecs()) / 25.0)) * 3.0))
                                        local7\Field1\Field13[$00]\Field29 = ((entityy(local7\Field1\Field11[$0B], $01) + cos(((Float millisecs()) / 85.0))) + 9.0)
                                        local7\Field1\Field13[$00]\Field30 = (entityz(local7\Field1\Field11[$0B], $01) + (cos(((Float millisecs()) / 25.0)) * 3.0))
                                        local7\Field1\Field13[$02]\Field28 = (entityx(local7\Field1\Field11[$0B], $01) + (sin(((Float millisecs()) / 23.0)) * 3.0))
                                        local7\Field1\Field13[$02]\Field29 = ((entityy(local7\Field1\Field11[$0B], $01) + cos(((Float millisecs()) / 83.0))) + 5.0)
                                        local7\Field1\Field13[$02]\Field30 = (entityz(local7\Field1\Field11[$0B], $01) + (cos(((Float millisecs()) / 23.0)) * 3.0))
                                        If (((5600.0 > (local7\Field2 - fpsfactor)) And (5600.0 <= local7\Field2)) <> 0) Then
                                            For local1 = $00 To $01 Step $01
                                                local5 = createnpc($08, (entityx(local7\Field1\Field11[$12], $01) + ((Float local1) * 0.4)), (entityy(local7\Field1\Field11[$12], $01) + (0.29 * (Float (local1 + $01)))), (entityz(local7\Field1\Field11[$12], $01) + ((Float local1) * 0.4)))
                                                local5\Field10 = 1000.0
                                                local5\Field9 = 2.0
                                            Next
                                            local5 = createnpc($08, entityx(local7\Field1\Field12[$02]\Field0, $01), (entityy(local7\Field1\Field12[$02]\Field0, $01) + 0.29), ((entityz(local7\Field1\Field12[$02]\Field0, $01) + entityz(local7\Field1\Field12[$03]\Field0, $01)) / 2.0))
                                            local5\Field10 = 1000.0
                                            local5\Field9 = 2.0
                                            local7\Field2 = 5950.0
                                        EndIf
                                    EndIf
                                EndIf
                            EndIf
                            If (1855.0 < local7\Field2) Then
                                If (local7\Field1\Field11[$0C] = $00) Then
                                    local7\Field1\Field11[$0C] = loadmesh("GFX\NPCs\682arm.b3d", $00)
                                    scaleentity(local7\Field1\Field11[$0C], 0.15, 0.15, 0.15, $00)
                                    local2 = (Int ((min((((entitydistance(local7\Field1\Field13[$03]\Field4, collider) / roomscale) - 3000.0) / 4.0), 1000.0) + 12192.0) * roomscale))
                                    positionentity(local7\Field1\Field11[$0C], entityx(local7\Field1\Field13[$03]\Field4, $00), (12192.0 * roomscale), entityz(local7\Field1\Field13[$03]\Field4, $00), $00)
                                    rotateentity(local7\Field1\Field11[$0C], 0.0, (rnd(-10.0, 10.0) + (Float local7\Field1\Field6)), 0.0, $01)
                                    turnentity(local7\Field1\Field11[$0C], 0.0, 0.0, 180.0, $00)
                                ElseIf (340.0 > wrapangle(entityroll(local7\Field1\Field11[$0C], $00))) Then
                                    local10 = wrapangle(entityroll(local7\Field1\Field11[$0C], $00))
                                    turnentity(local7\Field1\Field11[$0C], 0.0, 0.0, ((((Abs sin(local10)) * 2.0) + 5.0) * fpsfactor), $00)
                                    If (((270.0 > local10) And (270.0 <= wrapangle(entityroll(local7\Field1\Field11[$0C], $00)))) <> 0) Then
                                        If (tempsound2 <> $00) Then
                                            freesound(tempsound2)
                                            tempsound2 = $00
                                        EndIf
                                        tempsound2 = loadsound("SFX\apachecrash1.ogg")
                                        playsound(tempsound2)
                                        local7\Field1\Field13[$03]\Field9 = 4.0
                                        local7\Field1\Field13[$03]\Field10 = 1.0
                                        local7\Field1\Field13[$03]\Field28 = entityx(local7\Field1\Field11[$07], $01)
                                        local7\Field1\Field13[$03]\Field29 = (entityy(local7\Field1\Field11[$07], $01) - 2.5)
                                        local7\Field1\Field13[$03]\Field30 = entityz(local7\Field1\Field11[$07], $01)
                                        local14 = createemitter(entityx(local7\Field1\Field13[$03]\Field4, $00), entityy(local7\Field1\Field13[$03]\Field4, $00), entityz(local7\Field1\Field13[$03]\Field4, $00), $00)
                                        local14\Field7 = playerroom
                                        local14\Field10 = 45.0
                                        local14\Field4 = -0.18
                                        local14\Field5 = $190
                                        local14\Field12 = -0.002
                                        turnentity(local14\Field0, (Float (($14 * local1) + $FFFFFFB0)), 0.0, 0.0, $00)
                                        entityparent(local14\Field0, local7\Field1\Field13[$03]\Field4, $01)
                                        For local1 = $00 To $07 Step $01
                                            local4 = createparticle(entityx(local7\Field1\Field13[$03]\Field4, $00), entityy(local7\Field1\Field13[$03]\Field4, $00), entityz(local7\Field1\Field13[$03]\Field4, $00), $00, rnd(0.5, 1.0), -0.1, $C8)
                                            local4\Field8 = 0.01
                                            local4\Field15 = 0.01
                                            local4\Field6 = 0.8
                                            local4\Field14 = -0.005
                                            rotateentity(local4\Field1, rnd(360.0, 0.0), rnd(360.0, 0.0), 0.0, $00)
                                            moveentity(local4\Field1, 0.0, 0.0, 0.3)
                                        Next
                                        For local1 = $00 To $0C Step $01
                                            local4 = createparticle(entityx(local7\Field1\Field13[$03]\Field4, $00), entityy(local7\Field1\Field13[$03]\Field4, $00), entityz(local7\Field1\Field13[$03]\Field4, $00), $00, 0.02, 0.003, $C8)
                                            local4\Field8 = 0.08
                                            local4\Field6 = 0.8
                                            local4\Field14 = -0.005
                                            rotateentity(local4\Field1, rnd(360.0, 0.0), rnd(360.0, 0.0), 0.0, $00)
                                        Next
                                    EndIf
                                Else
                                    hideentity(local7\Field1\Field11[$0C])
                                EndIf
                            EndIf
                        EndIf
                        hideentity(fog)
                        camerafogrange(camera, 5.0, 45.0)
                        camerafogcolor(camera, 200.0, 200.0, 200.0)
                        cameraclscolor(camera, 200.0, 200.0, 200.0)
                        camerarange(camera, 0.05, 60.0)
                        If (rand($03, $01) = $01) Then
                            local4 = createparticle((entityx(camera, $00) + rnd(-2.0, 2.0)), (entityy(camera, $00) + rnd(0.9, 2.0)), (entityz(camera, $00) + rnd(-2.0, 2.0)), $02, 0.006, 0.0, $12C)
                            local4\Field8 = rnd(0.002, 0.003)
                            rotateentity(local4\Field1, rnd(-20.0, 20.0), (rnd(-15.0, 15.0) + (Float (local7\Field1\Field6 - $5A))), 0.0, $00)
                            local4\Field15 = -0.00001
                            freeentity(local3)
                        EndIf
                        If (((rand($FA, $01) = $01) And (1.0 <> local7\Field1\Field13[$01]\Field9)) <> 0) Then
                            If (local7\Field1\Field13[$01]\Field32 = $00) Then
                                If (entitydistance(local7\Field1\Field13[$01]\Field4, local7\Field1\Field11[$05]) > entitydistance(local7\Field1\Field13[$01]\Field4, local7\Field1\Field11[$04])) Then
                                    local7\Field1\Field13[$01]\Field32 = findpath(local7\Field1\Field13[$01], entityx(local7\Field1\Field11[$05], $01), entityy(local7\Field1\Field11[$05], $01), entityz(local7\Field1\Field11[$05], $01))
                                    debuglog(("<   -   " + (Str local7\Field1\Field13[$01]\Field32)))
                                    local7\Field1\Field13[$01]\Field9 = 3.0
                                Else
                                    local7\Field1\Field13[$01]\Field32 = findpath(local7\Field1\Field13[$01], entityx(local7\Field1\Field11[$04], $01), entityy(local7\Field1\Field11[$04], $01), entityz(local7\Field1\Field11[$04], $01))
                                    debuglog(("- > - " + (Str local7\Field1\Field13[$01]\Field32)))
                                    local7\Field1\Field13[$01]\Field9 = 3.0
                                EndIf
                            EndIf
                        EndIf
                        positiontexture(local7\Field1\Field11[$01], (local7\Field2 / 1500.0), 0.0)
                        positiontexture(local7\Field1\Field11[$02], (local7\Field2 / 2500.0), 0.0)
                        If (entityvisible(local7\Field1\Field13[$00]\Field4, collider) <> 0) Then
                            local7\Field1\Field13[$01]\Field9 = 1.0
                        EndIf
                    Else
                        local7\Field3 = updateelevators(local7\Field3, local7\Field1\Field12[$00], local7\Field1\Field12[$01], local7\Field1\Field11[$08], local7\Field1\Field11[$09], local7)
                        entityalpha(fog, 1.0)
                        If (rand($14, $01) = $01) Then
                        EndIf
                    EndIf
                EndIf
            Case "room2tesla"
                If (playerroom = local7\Field1) Then
                    If (0.0 = local7\Field2) Then
                        If (local7\Field5 = $00) Then
                            local7\Field5 = playsound2(teslaidlesfx, camera, local7\Field1\Field11[$03], 4.0, 0.5, $01)
                        ElseIf (channelplaying(local7\Field5) = $00) Then
                            local7\Field5 = playsound2(teslaidlesfx, camera, local7\Field1\Field11[$03], 4.0, 0.5, $01)
                        EndIf
                        For local1 = $00 To $02 Step $01
                            If ((300.0 * roomscale) > distance(entityx(collider, $00), entityz(collider, $00), entityx(local7\Field1\Field11[local1], $01), entityz(local7\Field1\Field11[local1], $01))) Then
                                If (0.0 <= killtimer) Then
                                    playersoundvolume = max(8.0, playersoundvolume)
                                    stopchannel(local7\Field5)
                                    local7\Field5 = playsound2(teslaactivatesfx, camera, local7\Field1\Field11[$03], 4.0, 0.5, $01)
                                    local7\Field2 = 1.0
                                    Exit
                                EndIf
                            EndIf
                        Next
                        If (((-10.0 > curr106\Field9) And (0.0 = local7\Field2)) <> 0) Then
                            For local1 = $00 To $02 Step $01
                                If ((300.0 * roomscale) > distance(entityx(curr106\Field4, $00), entityz(curr106\Field4, $00), entityx(local7\Field1\Field11[local1], $01), entityz(local7\Field1\Field11[local1], $01))) Then
                                    If (0.0 <= killtimer) Then
                                        stopchannel(local7\Field5)
                                        local7\Field5 = playsound2(teslaactivatesfx, camera, local7\Field1\Field11[$03], 4.0, 0.5, $01)
                                        local7\Field2 = 1.0
                                        achvtesla = $01
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
                                    For local1 = $00 To $02 Step $01
                                        If ((250.0 * roomscale) > distance(entityx(collider, $00), entityz(collider, $00), entityx(local7\Field1\Field11[local1], $01), entityz(local7\Field1\Field11[local1], $01))) Then
                                            showentity(light)
                                            lightflash = 0.4
                                            kill()
                                        EndIf
                                    Next
                                EndIf
                                If (-10.0 > curr106\Field9) Then
                                    For local1 = $00 To $02 Step $01
                                        If ((250.0 * roomscale) > distance(entityx(curr106\Field4, $00), entityz(curr106\Field4, $00), entityx(local7\Field1\Field11[local1], $01), entityz(local7\Field1\Field11[local1], $01))) Then
                                            showentity(light)
                                            lightflash = 0.4
                                            For local1 = $00 To $0A Step $01
                                                local4 = createparticle(entityx(curr106\Field4, $01), entityy(curr106\Field4, $01), entityz(curr106\Field4, $01), $00, 0.015, -0.2, $FA)
                                                local4\Field7 = 0.03
                                                local4\Field10 = -0.2
                                                local4\Field16 = 200.0
                                                local4\Field15 = 0.005
                                                local4\Field8 = 0.001
                                                rotateentity(local4\Field1, rnd(360.0, 0.0), rnd(360.0, 0.0), 0.0, $01)
                                            Next
                                            curr106\Field9 = -2000.0
                                        EndIf
                                    Next
                                EndIf
                                hideentity(local7\Field1\Field11[$03])
                                If (rand($05, $01) < $05) Then
                                    positiontexture(teslatexture, 0.0, rnd(0.0, 1.0))
                                    showentity(local7\Field1\Field11[$03])
                                EndIf
                            Else
                                If (70.0 > (local7\Field2 - fpsfactor)) Then
                                    stopchannel(local7\Field5)
                                    local7\Field5 = playsound2(teslapowerupsfx, camera, local7\Field1\Field11[$03], 4.0, 0.5, $01)
                                EndIf
                                hideentity(local7\Field1\Field11[$03])
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
                        If (2.5 > entitydistance(collider, local7\Field1\Field2)) Then
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
                        If (0.9 > entitydistance(collider, local7\Field1\Field11[$00])) Then
                            curr106\Field9 = -0.1
                            local7\Field2 = 2.0
                        ElseIf (0.9 > entitydistance(collider, local7\Field1\Field11[$01])) Then
                            curr106\Field9 = -0.1
                            local7\Field2 = 3.0
                        EndIf
                    ElseIf (2.0 = local7\Field2) Then
                        local0 = distance(entityx(collider, $00), entityz(collider, $00), entityx(local7\Field1\Field11[$01], $01), entityz(local7\Field1\Field11[$01], $01))
                        If (1.0 > local0) Then
                            local3 = createpivot($00)
                            positionentity(local3, entityx(collider, $00), entityy(collider, $00), entityz(collider, $00), $00)
                            pointentity(local3, local7\Field1\Field11[$01], 0.0)
                            rotateentity(local3, 0.0, entityyaw(local3, $00), 0.0, $00)
                            moveentity(local3, 0.0, 0.0, (local0 + 3.0))
                            positionentity(curr106\Field4, entityx(local3, $00), entityy(local3, $00), entityz(local3, $00), $00)
                            freeentity(local3)
                            curr106\Field16 = 0.0
                            local7\Field2 = 4.0
                        EndIf
                    ElseIf (3.0 = local7\Field2) Then
                        local0 = distance(entityx(collider, $00), entityz(collider, $00), entityx(local7\Field1\Field11[$00], $01), entityz(local7\Field1\Field11[$00], $01))
                        If (1.0 > local0) Then
                            local3 = createpivot($00)
                            positionentity(local3, entityx(collider, $00), entityy(collider, $00), entityz(collider, $00), $00)
                            pointentity(local3, local7\Field1\Field11[$00], 0.0)
                            rotateentity(local3, 0.0, entityyaw(local3, $00), 0.0, $00)
                            moveentity(local3, 0.0, 0.0, (local0 + 3.0))
                            positionentity(curr106\Field4, entityx(local3, $00), entityy(local3, $00), entityz(local3, $00), $00)
                            freeentity(local3)
                            curr106\Field16 = 0.0
                            local7\Field2 = 4.0
                        EndIf
                    EndIf
                EndIf
                If (playerroom = local7\Field1) Then
                    local7\Field3 = updateelevators(local7\Field3, local7\Field1\Field12[$00], local7\Field1\Field12[$01], local7\Field1\Field11[$02], local7\Field1\Field11[$03], local7)
                    local7\Field4 = updateelevators(local7\Field4, local7\Field1\Field12[$02], local7\Field1\Field12[$03], local7\Field1\Field11[$04], local7\Field1\Field11[$05], local7)
                EndIf
            Case "room2pipes106"
                If (contained106 = $00) Then
                    If (0.0 = local7\Field2) Then
                        If (playerroom = local7\Field1) Then
                            local7\Field2 = 1.0
                        EndIf
                    Else
                        local7\Field2 = ((fpsfactor * 0.7) + local7\Field2)
                        curr106\Field19 = $01
                        If (50.0 > local7\Field2) Then
                            positionentity(curr106\Field4, entityx(local7\Field1\Field11[$00], $01), (entityy(collider, $00) - 0.15), entityz(local7\Field1\Field11[$00], $01), $00)
                            pointentity(curr106\Field4, local7\Field1\Field11[$01], 0.0)
                            moveentity(curr106\Field4, 0.0, 0.0, ((entitydistance(local7\Field1\Field11[$00], local7\Field1\Field11[$01]) * 0.5) * (local7\Field2 / 50.0)))
                            animate2(curr106\Field0, animtime(curr106\Field0), $00, $0E, 0.2)
                        ElseIf (200.0 > local7\Field2) Then
                            animate2(curr106\Field0, animtime(curr106\Field0), $CE, $FA, 0.1)
                            positionentity(curr106\Field4, entityx(local7\Field1\Field11[$00], $01), (entityy(collider, $00) - 0.15), entityz(local7\Field1\Field11[$00], $01), $00)
                            moveentity(curr106\Field4, 0.0, 0.0, (entitydistance(local7\Field1\Field11[$00], local7\Field1\Field11[$01]) * 0.5))
                            rotateentity(curr106\Field4, 0.0, curvevalue(local7\Field2, entityyaw(curr106\Field4, $00), 30.0), 0.0, $01)
                            If (4.0 > entitydistance(curr106\Field4, collider)) Then
                                local3 = createpivot($00)
                                positionentity(local3, entityx(curr106\Field4, $00), entityy(curr106\Field4, $00), entityz(curr106\Field4, $00), $00)
                                pointentity(local3, collider, 0.0)
                                If (80.0 > wrapangle((entityyaw(local3, $00) - entityyaw(curr106\Field4, $00)))) Then
                                    curr106\Field9 = -11.0
                                    curr106\Field19 = $00
                                    playsound(horrorsfx($0A))
                                    local7\Field2 = 260.0
                                EndIf
                            EndIf
                        ElseIf (250.0 > local7\Field2) Then
                            positionentity(curr106\Field4, entityx(local7\Field1\Field11[$00], $01), (entityy(collider, $00) - 0.15), entityz(local7\Field1\Field11[$00], $01), $00)
                            pointentity(curr106\Field4, local7\Field1\Field11[$01], 0.0)
                            moveentity(curr106\Field4, 0.0, 0.0, (entitydistance(local7\Field1\Field11[$00], local7\Field1\Field11[$01]) * ((local7\Field2 - 150.0) / 100.0)))
                            animate2(curr106\Field0, animtime(curr106\Field0), $00, $0E, 0.2)
                        EndIf
                        resetentity(curr106\Field4)
                        If (((0.3 < (local7\Field2 / 250.0)) And (0.3 >= ((local7\Field2 - fpsfactor) / 250.0))) <> 0) Then
                            local7\Field5 = playsound(horrorsfx($06))
                            blurtimer = 800.0
                            local16 = createdecal($00, entityx(local7\Field1\Field11[$02], $01), entityy(local7\Field1\Field11[$02], $01), entityz(local7\Field1\Field11[$02], $01), 0.0, (Float (local7\Field1\Field6 - $5A)), rnd(360.0, 0.0))
                            local16\Field8 = 90000.0
                            local16\Field4 = 0.01
                            local16\Field3 = 0.005
                            local16\Field2 = 0.1
                            local16\Field1 = 0.003
                        EndIf
                        If (((0.65 < (local7\Field2 / 250.0)) And (0.65 >= ((local7\Field2 - fpsfactor) / 250.0))) <> 0) Then
                            local16 = createdecal($00, entityx(local7\Field1\Field11[$03], $01), entityy(local7\Field1\Field11[$03], $01), entityz(local7\Field1\Field11[$03], $01), 0.0, (Float (local7\Field1\Field6 + $5A)), rnd(360.0, 0.0))
                            local16\Field8 = 90000.0
                            local16\Field4 = 0.01
                            local16\Field3 = 0.005
                            local16\Field2 = 0.1
                            local16\Field1 = 0.003
                        EndIf
                        If (250.0 < local7\Field2) Then
                            curr106\Field19 = $00
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
                        positionentity(curr106\Field4, entityx(local7\Field1\Field11[$07], $01), entityy(local7\Field1\Field11[$07], $01), entityz(local7\Field1\Field11[$07], $01), $00)
                        resetentity(curr106\Field4)
                        pointentity(curr106\Field4, camera, 0.0)
                        turnentity(curr106\Field4, 0.0, (sin((Float (millisecs() / $14))) * 6.0), 0.0, $01)
                        moveentity(curr106\Field4, 0.0, 0.0, (sin((Float (millisecs() / $0F))) * 0.06))
                        curr106\Field19 = $01
                        If (800.0 < local7\Field2) Then
                            If (-5.0 > blinktimer) Then
                                curr106\Field19 = $00
                                Delete local7
                            EndIf
                        EndIf
                    EndIf
                EndIf
            Case "room2pit"
                If (0.0 = local7\Field2) Then
                    If (5.0 > distance(entityx(collider, $00), entityz(collider, $00), entityx(local7\Field1\Field2, $00), entityz(local7\Field1\Field2, $00))) Then
                        positionentity(curr173\Field4, entityx(local7\Field1\Field11[$06], $01), 0.5, entityz(local7\Field1\Field11[$06], $01), $00)
                        resetentity(curr173\Field4)
                        Delete local7
                    EndIf
                EndIf
            Case "tunnel2smoke"
                If (0.0 = local7\Field2) Then
                    If (3.5 > distance(entityx(collider, $00), entityz(collider, $00), entityx(local7\Field1\Field2, $00), entityz(local7\Field1\Field2, $00))) Then
                        playsound2(burstsfx, camera, local7\Field1\Field2, 10.0, 1.0, $01)
                        For local1 = $00 To $01 Step $01
                            local14 = createemitter(entityx(local7\Field1\Field11[local1], $01), entityy(local7\Field1\Field11[local1], $01), entityz(local7\Field1\Field11[local1], $01), $00)
                            turnentity(local14\Field0, 90.0, 0.0, 0.0, $01)
                            entityparent(local14\Field0, local7\Field1\Field2, $01)
                            local14\Field10 = 3.0
                            local14\Field9 = 0.04
                            local14\Field11 = 0.0027
                            For local13 = 0.0 To 10.0 Step 1.0
                                local4 = createparticle(entityx(local14\Field0, $01), (448.0 * roomscale), entityz(local14\Field0, $01), rand(local14\Field2, local14\Field3), local14\Field1, local14\Field4, local14\Field5)
                                local4\Field8 = local14\Field9
                                rotateentity(local4\Field1, rnd(360.0, 0.0), rnd(360.0, 0.0), 0.0, $01)
                                local4\Field15 = local14\Field11
                            Next
                        Next
                        Delete local7
                    EndIf
                EndIf
            Case "tunnel2"
                If (playerroom = local7\Field1) Then
                    If (0.0 = local7\Field2) Then
                        If (3.5 > distance(entityx(collider, $00), entityz(collider, $00), entityx(local7\Field1\Field2, $00), entityz(local7\Field1\Field2, $00))) Then
                            playsound(lightsfx)
                            lightblink = (rnd(0.0, 1.0) * (local7\Field2 / 200.0))
                            local7\Field2 = 1.0
                        EndIf
                    ElseIf (200.0 > local7\Field2) Then
                        blinktimer = -10.0
                        If (30.0 < local7\Field2) Then
                            lightblink = 1.0
                            If (30.0 >= (local7\Field2 - fpsfactor)) Then
                                If (ambientsfx($04) = $00) Then
                                    ambientsfx($04) = loadsound("SFX\ambient\ambient5.ogg")
                                EndIf
                                playsound(ambientsfx($04))
                            EndIf
                        EndIf
                        If (((100.0 >= (local7\Field2 - fpsfactor)) And (100.0 < local7\Field2)) <> 0) Then
                            If (ambientsfx($0A) = $00) Then
                                ambientsfx($0A) = loadsound("SFX\ambient\ambient11.ogg")
                            EndIf
                            playsound(ambientsfx($0A))
                            positionentity(curr173\Field4, entityx(local7\Field1\Field2, $00), 0.6, entityz(local7\Field1\Field2, $00), $00)
                            resetentity(curr173\Field4)
                            curr173\Field19 = $01
                        EndIf
                        lightblink = 1.0
                        local7\Field2 = (local7\Field2 + fpsfactor)
                    Else
                        blinktimer = 560.0
                        curr173\Field19 = $00
                        Delete local7
                    EndIf
                EndIf
            Case "coffin"
                local0 = entitydistance(camera, local7\Field1\Field11[$00])
                coffindistance = local0
                If (1.5 > coffindistance) Then
                    achv895 = $01
                EndIf
            Case "coffin106"
                local0 = entitydistance(camera, local7\Field1\Field11[$00])
                coffindistance = local0
                If (0.0 = local7\Field2) Then
                    If (playerroom = local7\Field1) Then
                        If (shouldplay = $00) Then
                            shouldplay = $42
                        EndIf
                    ElseIf (shouldplay = $42) Then
                        shouldplay = $00
                    EndIf
                    If (1.5 > coffindistance) Then
                        achv895 = $01
                        If (contained106 = $00) Then
                            curr106\Field9 = -0.1
                            local7\Field2 = 1.0
                        EndIf
                    EndIf
                EndIf
            Case "tunnel106"
                If (contained106 = $00) Then
                    If (0.0 = local7\Field2) Then
                        If (0.0 <= curr106\Field9) Then
                            If (5.0 > entitydistance(camera, local7\Field1\Field2)) Then
                                local16 = createdecal($00, entityx(local7\Field1\Field2, $00), 0.0011, entityz(local7\Field1\Field2, $00), 90.0, (Float rand($168, $01)), 0.0)
                                local16\Field2 = rnd(0.5, 0.7)
                                entityalpha(local16\Field0, 0.7)
                                local16\Field7 = $01
                                scalesprite(local16\Field0, local16\Field2, local16\Field2)
                                entityalpha(local16\Field0, rnd(0.7, 0.85))
                                local7\Field2 = 1.0
                            EndIf
                        EndIf
                    Else
                        positionentity(curr106\Field4, (entityx(local7\Field1\Field2, $01) - (sin(((Float millisecs()) / 150.0)) / 4.0)), ((entityy(collider, $00) - 0.4) - ((sin(((Float millisecs()) / 100.0)) + 1.0) / 4.0)), (entityz(local7\Field1\Field2, $01) - (sin(((Float millisecs()) / 190.0)) / 4.0)), $00)
                        pointentity(curr106\Field4, camera, 0.0)
                        curr106\Field9 = -11.0
                        animate2(curr106\Field0, animtime(curr106\Field0), $CE, $FA, 0.1)
                        curr106\Field19 = $01
                        local0 = entitydistance(collider, curr106\Field4)
                        If (((3.5 > local0) Or (rand($1B58, $01) = $01)) <> 0) Then
                            curr106\Field19 = $00
                            Delete local7
                        ElseIf (8.0 < local0) Then
                            If (rand($05, $01) = $01) Then
                                curr106\Field19 = $00
                                Delete local7
                            Else
                                curr106\Field19 = $00
                                curr106\Field9 = -10000.0
                                Delete local7
                            EndIf
                        EndIf
                    EndIf
                EndIf
            Case "lockroom173"
                If (((0.0 = local7\Field2) And (rand($05, $01) = $01)) <> 0) Then
                    If (5.0 > distance(entityx(collider, $00), entityz(collider, $00), entityx(local7\Field1\Field2, $00), entityz(local7\Field1\Field2, $00))) Then
                        If (entityinview(curr106\Field0, camera) = $00) Then
                            local7\Field2 = 1.0
                            positionentity(curr173\Field4, ((cos((Float (local7\Field1\Field6 + $87))) * 2.0) + local7\Field1\Field3), (local7\Field1\Field4 + 1.0), ((sin((Float (local7\Field1\Field6 + $87))) * 2.0) + local7\Field1\Field5), $00)
                            resetentity(curr173\Field4)
                            Delete local7
                        EndIf
                    EndIf
                EndIf
            Case "pocketdimension"
                If (playerroom = local7\Field1) Then
                    achvpd = $01
                    If (0.0 = local7\Field2) Then
                        music($03) = loadsound("SFX\Music\PocketDimension.ogg")
                        local7\Field2 = 0.1
                    EndIf
                    shouldplay = $03
                    If (600.0 > local7\Field2) Then
                        blurtimer = 1000.0
                        blinktimer = (-10.0 - (local7\Field2 / 60.0))
                    EndIf
                    scaleentity(local7\Field1\Field2, roomscale, (((sin((local7\Field2 / 14.0)) * 0.2) + 1.0) * roomscale), roomscale, $00)
                    For local1 = $00 To $07 Step $01
                        scaleentity(local7\Field1\Field11[local1], (((Abs (sin(((local7\Field2 / 21.0) + ((Float local1) * 45.0))) * 0.1)) + 1.0) * roomscale), (((sin(((local7\Field2 / 14.0) + ((Float local1) * 20.0))) * 0.1) + 1.0) * roomscale), roomscale, $01)
                    Next
                    scaleentity(local7\Field1\Field11[$08], (((Abs (sin(((local7\Field2 / 21.0) + ((Float local1) * 45.0))) * 0.1)) + 1.5) * roomscale), (((sin(((local7\Field2 / 14.0) + ((Float local1) * 20.0))) * 0.1) + 1.0) * roomscale), roomscale, $01)
                    scaleentity(local7\Field1\Field11[$09], (((Abs (sin(((local7\Field2 / 21.0) + ((Float local1) * 45.0))) * 0.1)) + 1.5) * roomscale), (((sin(((local7\Field2 / 14.0) + ((Float local1) * 20.0))) * 0.1) + 1.0) * roomscale), roomscale, $01)
                    local7\Field2 = (local7\Field2 + fpsfactor)
                    If (0.0 = local7\Field3) Then
                        If (4550.0 < local7\Field2) Then
                            If (((rand($320, $01) = $01) And (0.0 <= curr106\Field9)) <> 0) Then
                                playsound(horrorsfx($08))
                                curr106\Field9 = -0.1
                                local7\Field2 = 601.0
                            EndIf
                        ElseIf (0.0 < curr106\Field9) Then
                            local10 = ((local7\Field2 / 10.0) Mod 360.0)
                            positionentity(curr106\Field4, entityx(local7\Field1\Field2, $00), 0.35, entityx(local7\Field1\Field2, $00), $00)
                            rotateentity(curr106\Field4, 0.0, local10, 0.0, $00)
                            moveentity(curr106\Field4, 0.0, 0.0, (6.0 - sin((local7\Field2 / 10.0))))
                            animate2(curr106\Field0, animtime(curr106\Field0), $00, $0E, 0.17)
                            rotateentity(curr106\Field4, 0.0, (local10 + 90.0), 0.0, $00)
                        EndIf
                    EndIf
                    If (0.3 > entitydistance(collider, curr106\Field4)) Then
                        curr106\Field19 = $00
                        curr106\Field9 = -11.0
                    EndIf
                    If (1.0 = local7\Field3) Then
                        local0 = entitydistance(collider, local7\Field1\Field11[$08])
                        If (local0 > (1700.0 * roomscale)) Then
                            blinktimer = -10.0
                            Select rand($02, $01)
                                Case $01
                                    local2 = createpivot($00)
                                    positionentity(local2, entityx(collider, $00), entityy(collider, $00), entityz(collider, $00), $00)
                                    pointentity(local2, local7\Field1\Field11[$08], 0.0)
                                    moveentity(local2, 0.0, 0.0, (local0 * 1.9))
                                    positionentity(collider, entityx(local2, $00), entityy(collider, $00), entityz(local2, $00), $00)
                                    resetentity(collider)
                                    local10 = (Float ((Int (entityyaw(local2, $00) / 90.0)) * $5A))
                                    rotateentity(local2, 0.0, local10, 0.0, $00)
                                    moveentity(local2, 0.0, 0.0, 0.8)
                                    positionentity(local7\Field1\Field11[$0A], entityx(local2, $00), 0.0, entityz(local2, $00), $00)
                                    rotateentity(local7\Field1\Field11[$0A], 0.0, entityyaw(local2, $00), 0.0, $01)
                                    positionentity(local2, entityx(local7\Field1\Field11[$08], $00), 0.0, entityz(local7\Field1\Field11[$08], $00), $00)
                                    rotateentity(local2, 0.0, ((Float (rand($01, $03) * $5A)) + local10), 0.0, $00)
                                    moveentity(local2, 0.0, 0.0, (520.0 * roomscale))
                                    positionentity(local7\Field1\Field11[$09], entityx(local2, $00), 0.0, entityz(local2, $00), $00)
                                    freeentity(local2)
                                Case $02
                                    local2 = createpivot($00)
                                    positionentity(local2, entityx(local7\Field1\Field2, $00), entityy(local7\Field1\Field2, $00), entityz(local7\Field1\Field2, $00), $00)
                                    local10 = wrapangle((getangle(entityx(local7\Field1\Field11[$08], $00), entityz(local7\Field1\Field11[$08], $00), entityx(collider, $00), entityz(collider, $00)) - 22.5))
                                    local10 = (Float (Int (local10 / 90.0)))
                                    rotateentity(local2, 0.0, ((Float rand($00, $08)) * 45.0), 0.0, $00)
                                    moveentity(local2, 0.0, 0.0, (1400.0 * roomscale))
                                    positionentity(collider, entityx(local2, $00), entityy(collider, $00), entityz(local2, $00), $00)
                                    rotateentity(collider, 0.0, ((entityyaw(collider, $00) - (local10 * 45.0)) - 270.0), 0.0, $01)
                                    moveentity(local2, 0.0, 0.0, 0.8)
                                    positionentity(local7\Field1\Field11[$0A], entityx(local2, $00), 0.0, entityz(local2, $00), $00)
                                    rotateentity(local7\Field1\Field11[$0A], 0.0, entityyaw(local2, $00), 0.0, $01)
                                    resetentity(collider)
                                    freeentity(local2)
                                    debuglog("oooo")
                                    local7\Field3 = 0.0
                            End Select
                            updatedoors()
                            updaterooms()
                        EndIf
                    ElseIf (0.0 = local7\Field3) Then
                        local0 = entitydistance(collider, local7\Field1\Field2)
                        If (local0 > (1700.0 * roomscale)) Then
                            blinktimer = -10.0
                            Select rand($17, $01)
                                Case $01,$02,$03,$05,$06,$07
                                    playsound(oldmansfx($03))
                                    local2 = createpivot($00)
                                    positionentity(local2, entityx(collider, $00), entityy(collider, $00), entityz(collider, $00), $00)
                                    pointentity(local2, local7\Field1\Field2, 0.0)
                                    moveentity(local2, 0.0, 0.0, (local0 * 1.9))
                                    positionentity(collider, entityx(local2, $00), entityy(collider, $00), entityz(local2, $00), $00)
                                    resetentity(collider)
                                    moveentity(local2, 0.0, 0.0, 0.8)
                                    positionentity(local7\Field1\Field11[$0A], entityx(local2, $00), 0.0, entityz(local2, $00), $00)
                                    rotateentity(local7\Field1\Field11[$0A], 0.0, entityyaw(local2, $00), 0.0, $01)
                                    freeentity(local2)
                                Case $08,$09,$0A,$0B,$0C
                                    local7\Field3 = 1.0
                                    blinktimer = -10.0
                                    playsound(oldmansfx($03))
                                    local2 = createpivot($00)
                                    positionentity(local2, entityx(local7\Field1\Field11[$08], $00), entityy(local7\Field1\Field11[$08], $00), entityz(local7\Field1\Field11[$08], $00), $00)
                                    debuglog("---")
                                    local10 = wrapangle((getangle(entityx(local7\Field1\Field2, $00), entityz(local7\Field1\Field2, $00), entityx(collider, $00), entityz(collider, $00)) - 22.5))
                                    local10 = (Float (Int (local10 / 45.0)))
                                    moveentity(local2, 0.0, 0.0, (-1400.0 * roomscale))
                                    positionentity(collider, entityx(local2, $00), entityy(collider, $00), entityz(local2, $00), $00)
                                    rotateentity(collider, 0.0, ((entityyaw(collider, $00) - (local10 * 45.0)) - 270.0), 0.0, $01)
                                    resetentity(collider)
                                    moveentity(local2, 0.0, 0.0, -0.8)
                                    positionentity(local7\Field1\Field11[$0A], entityx(local2, $00), 0.0, entityz(local2, $00), $00)
                                    rotateentity(local7\Field1\Field11[$0A], 0.0, entityyaw(local2, $00), 0.0, $01)
                                    positionentity(local2, entityx(local7\Field1\Field11[$08], $00), 0.0, entityz(local7\Field1\Field11[$08], $00), $00)
                                    rotateentity(local2, 0.0, ((Float (rand($01, $03) * $5A)) + local10), 0.0, $00)
                                    moveentity(local2, 0.0, 0.0, (520.0 * roomscale))
                                    positionentity(local7\Field1\Field11[$09], entityx(local2, $00), 0.0, entityz(local2, $00), $00)
                                    freeentity(local2)
                                Case $0D,$0E,$0F
                                    blurtimer = 500.0
                                    local2 = createpivot($00)
                                    positionentity(local2, entityx(local7\Field1\Field2, $00), 0.5, entityz(local7\Field1\Field2, $00), $00)
                                Case $10,$11
                                    blurtimer = 1500.0
                                    For local6 = Each rooms
                                        If (local6\Field7\Field4 = "room106") Then
                                            local7\Field2 = 0.0
                                            freesound(music($03))
                                            positionentity(collider, entityx(local6\Field2, $00), 0.4, entityz(local6\Field2, $00), $00)
                                            resetentity(collider)
                                            Exit
                                        EndIf
                                    Next
                                Case $12,$13
                                    blurtimer = 1500.0
                                    For local6 = Each rooms
                                        If (local6\Field7\Field4 = "room2offices") Then
                                            local7\Field2 = 0.0
                                            freesound(music($03))
                                            positionentity(collider, entityx(local6\Field2, $00), 0.4, entityz(local6\Field2, $00), $00)
                                            resetentity(collider)
                                            Exit
                                        EndIf
                                    Next
                                Case $14,$15,$16,$17
                                    blinktimer = -10.0
                                    positionentity(collider, entityx(local7\Field1\Field11[$0C], $01), 0.6, entityz(local7\Field1\Field11[$0C], $01), $00)
                                    resetentity(collider)
                                    local7\Field3 = 15.0
                            End Select
                            updatedoors()
                            updaterooms()
                        EndIf
                    Else
                        camerafogcolor(camera, 19.0, 27.5, 23.5)
                        cameraclscolor(camera, 19.0, 27.5, 23.5)
                        If (rand($320, $01) = $01) Then
                            local10 = (entityyaw(camera, $01) + rnd(150.0, 210.0))
                            local4 = createparticle((entityx(collider, $00) + (cos(local10) * 7.5)), 0.0, (entityz(collider, $00) + (sin(local10) * 7.5)), $03, 4.0, 0.0, $9C4)
                            entityblend(local4\Field0, $02)
                            local4\Field8 = 0.01
                            local4\Field15 = 0.0
                            pointentity(local4\Field1, camera, 0.0)
                            turnentity(local4\Field1, 0.0, 145.0, 0.0, $01)
                            turnentity(local4\Field1, (Float rand($0A, $14)), 0.0, 0.0, $01)
                        EndIf
                        If (12.0 < local7\Field3) Then
                            curr106\Field19 = $01
                            positionentity(curr106\Field4, entityx(local7\Field1\Field11[(Int local7\Field3)], $01), 0.27, entityz(local7\Field1\Field11[(Int local7\Field3)], $01), $00)
                            pointentity(curr106\Field4, camera, 0.0)
                            turnentity(curr106\Field4, 0.0, (sin((Float (millisecs() / $14))) * 6.0), 0.0, $01)
                            moveentity(curr106\Field4, 0.0, 0.0, (sin((Float (millisecs() / $0F))) * 0.06))
                            If (((rand($2EE, $01) = $01) And (12.0 < local7\Field3)) <> 0) Then
                                blinktimer = -10.0
                                local7\Field3 = (local7\Field3 - 1.0)
                                playsound(horrorsfx($08))
                            EndIf
                            If (12.0 = local7\Field3) Then
                                camerashake = 1.0
                                positionentity(curr106\Field4, entityx(local7\Field1\Field11[(Int local7\Field3)], $01), -1.0, entityz(local7\Field1\Field11[(Int local7\Field3)], $01), $00)
                                curr106\Field9 = -11.0
                                resetentity(curr106\Field4)
                            EndIf
                        Else
                            curr106\Field9 = -11.0
                            curr106\Field19 = $00
                        EndIf
                        If ((-1600.0 * roomscale) > entityy(collider, $00)) Then
                            If ((144.0 * roomscale) > distance(entityx(local7\Field1\Field11[$10], $01), entityz(local7\Field1\Field11[$10], $01), entityx(collider, $00), entityz(collider, $00))) Then
                                camerafogcolor(camera, 0.0, 0.0, 0.0)
                                cameraclscolor(camera, 0.0, 0.0, 0.0)
                                dropspeed = 0.0
                                blurtimer = 500.0
                                positionentity(collider, entityx(local7\Field1\Field2, $00), 0.5, entityz(local7\Field1\Field2, $00), $00)
                                resetentity(collider)
                                local7\Field3 = 0.0
                                updatedoors()
                                updaterooms()
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
                local19 = $00
                local20 = $00
                If (soundtransmission <> 0) Then
                    local7\Field4 = min((local7\Field4 + fpsfactor), 4000.0)
                    If (channelplaying(local7\Field5) = $00) Then
                        local7\Field5 = playsound(radiostatic)
                    EndIf
                EndIf
                If (playerroom = local7\Field1) Then
                    showentity(local7\Field1\Field13[$00]\Field0)
                    shouldplay = $42
                    If (local7\Field1\Field13[$00]\Field19 = $00) Then
                        animate2(local7\Field1\Field13[$00]\Field0, animtime(local7\Field1\Field13[$00]\Field0), $AB, $AD, 0.01)
                        If (171.0 = animtime(local7\Field1\Field13[$00]\Field0)) Then
                            setanimtime(local7\Field1\Field13[$00]\Field0, 172.99, $00)
                            local7\Field1\Field13[$00]\Field19 = $01
                        EndIf
                    Else
                        animate2(local7\Field1\Field13[$00]\Field0, animtime(local7\Field1\Field13[$00]\Field0), $AD, $AB, -0.01)
                        If (173.0 = animtime(local7\Field1\Field13[$00]\Field0)) Then
                            setanimtime(local7\Field1\Field13[$00]\Field0, 171.01, $00)
                            local7\Field1\Field13[$00]\Field19 = $00
                        EndIf
                    EndIf
                    positionentity(local7\Field1\Field13[$00]\Field4, entityx(local7\Field1\Field11[$05], $01), entityy(local7\Field1\Field11[$05], $01), entityz(local7\Field1\Field11[$05], $01), $01)
                    rotateentity(local7\Field1\Field13[$00]\Field4, entitypitch(local7\Field1\Field11[$05], $01), entityyaw(local7\Field1\Field11[$05], $01), 0.0, $01)
                    resetentity(local7\Field1\Field13[$00]\Field4)
                    local2 = (Int local7\Field3)
                    debuglog((((Str entityy(local7\Field1\Field11[$06], $00)) + " - ") + (Str (((-990.0 * roomscale) > entityy(local7\Field1\Field11[$06], $01)) And ((-1275.0 * roomscale) < entityy(local7\Field1\Field11[$06], $01))))))
                    local21 = updatelever(local7\Field1\Field11[$01], (((-990.0 * roomscale) > entityy(local7\Field1\Field11[$06], $01)) And ((-1275.0 * roomscale) < entityy(local7\Field1\Field11[$06], $01))))
                    If (((grabbedentity = local7\Field1\Field11[$01]) And (drawhandicon = $01)) <> 0) Then
                        local7\Field3 = (Float local21)
                    EndIf
                    If ((Float local2) <> local7\Field3) Then
                        If (0.0 = local7\Field3) Then
                            playsound(magnetdownsfx)
                        Else
                            playsound(magnetupsfx)
                        EndIf
                    EndIf
                    soundtransmission = updatelever(local7\Field1\Field11[$03], $00)
                    If (0.0 = local7\Field2) Then
                        If ((soundtransmission And (rand($64, $01) = $01)) <> 0) Then
                            If (local7\Field6 = $00) Then
                                tempsound = loadsound((("SFX\LureSubject" + (Str rand($02, $07))) + ".ogg"))
                                local7\Field6 = playsound(tempsound)
                            EndIf
                            If (channelplaying(local7\Field6) = $00) Then
                                tempsound = loadsound((("SFX\LureSubject" + (Str rand($02, $07))) + ".ogg"))
                                local7\Field6 = playsound(tempsound)
                            EndIf
                        EndIf
                        updatebutton(local7\Field1\Field11[$04])
                        If (((closestbutton = local7\Field1\Field11[$04]) And mousehit1) <> 0) Then
                            local7\Field2 = 1.0
                            If (soundtransmission = $01) Then
                                If (local7\Field6 <> $00) Then
                                    If (channelplaying(local7\Field6) <> 0) Then
                                        stopchannel(local7\Field6)
                                    EndIf
                                EndIf
                                femurbreakersfx = loadsound("SFX\FemurBreaker.ogg")
                                local7\Field6 = playsound(femurbreakersfx)
                            EndIf
                        EndIf
                    Else
                        If ((soundtransmission And (2000.0 > local7\Field4)) <> 0) Then
                            If (local7\Field6 = $00) Then
                                tempsound = loadsound("SFX\LureSubject1.ogg")
                                local7\Field6 = playsound(tempsound)
                            EndIf
                            If (channelplaying(local7\Field6) = $00) Then
                                tempsound = loadsound("SFX\LureSubject1.ogg")
                                local7\Field6 = playsound(tempsound)
                            EndIf
                        EndIf
                        debuglog(("e\eventstate3: " + (Str local7\Field4)))
                        If (2500.0 <= local7\Field4) Then
                            shouldplay = $01
                            positionentity(curr106\Field4, entityx(local7\Field1\Field11[$05], $01), ((((min((local7\Field4 - 2500.0), 800.0) / 320.0) * 108.0) + 700.0) * roomscale), entityz(local7\Field1\Field11[$05], $01), $00)
                            hideentity(curr106\Field1)
                            rotateentity(curr106\Field4, 0.0, (entityyaw(local7\Field1\Field11[$05], $01) + 180.0), 0.0, $01)
                            curr106\Field9 = -11.0
                            animate2(curr106\Field0, animtime(curr106\Field0), $CE, $FA, 0.1)
                            curr106\Field19 = $01
                            If (2500.0 > (local7\Field4 - fpsfactor)) Then
                                local16 = createdecal($00, entityx(local7\Field1\Field11[$05], $01), (936.0 * roomscale), entityz(local7\Field1\Field11[$05], $01), 90.0, 0.0, rnd(360.0, 0.0))
                                local16\Field8 = 90000.0
                                local16\Field4 = 0.01
                                local16\Field3 = 0.005
                                local16\Field2 = 0.1
                                local16\Field1 = 0.003
                                If (local7\Field6 <> $00) Then
                                    If (channelplaying(local7\Field6) <> 0) Then
                                        stopchannel(local7\Field6)
                                    EndIf
                                EndIf
                                tempsound = loadsound("SFX\LureSubject8.ogg")
                                playsound(tempsound)
                            ElseIf (((2900.0 > (local7\Field4 - fpsfactor)) And (2900.0 <= local7\Field4)) <> 0) Then
                                If (femurbreakersfx <> $00) Then
                                    freesound(femurbreakersfx)
                                EndIf
                                local16 = createdecal($00, entityx(local7\Field1\Field11[$07], $01), entityy(local7\Field1\Field11[$07], $01), entityz(local7\Field1\Field11[$07], $01), 0.0, 0.0, 0.0)
                                rotateentity(local16\Field0, (entitypitch(local7\Field1\Field11[$07], $01) + (Float rand($0A, $14))), (entityyaw(local7\Field1\Field11[$07], $01) + 30.0), entityroll(local16\Field0, $00), $00)
                                moveentity(local16\Field0, 0.0, 0.0, 0.15)
                                rotateentity(local16\Field0, entitypitch(local7\Field1\Field11[$07], $01), entityyaw(local7\Field1\Field11[$07], $01), entityroll(local16\Field0, $00), $00)
                                entityparent(local16\Field0, local7\Field1\Field11[$07], $01)
                                local16\Field8 = 90000.0
                                local16\Field4 = 0.01
                                local16\Field3 = 0.005
                                local16\Field2 = 0.05
                                local16\Field1 = 0.002
                            ElseIf (3200.0 < local7\Field4) Then
                                positionentity(local7\Field1\Field11[$08], 0.0, 1000.0, 0.0, $01)
                                positionentity(local7\Field1\Field11[$07], 0.0, 1000.0, 0.0, $01)
                                If (1.0 = local7\Field3) Then
                                    contained106 = $01
                                Else
                                    positionentity(curr106\Field4, entityx(local7\Field1\Field11[$06], $01), entityy(local7\Field1\Field11[$06], $01), entityz(local7\Field1\Field11[$06], $01), $00)
                                    contained106 = $00
                                    showentity(curr106\Field0)
                                    curr106\Field19 = $00
                                    curr106\Field9 = -10000.0
                                EndIf
                            EndIf
                        EndIf
                    EndIf
                    If ((Int local7\Field3) <> 0) Then
                        positionentity(local7\Field1\Field11[$06], entityx(local7\Field1\Field11[$06], $01), curvevalue(((-980.0 * roomscale) + (sin(((Float millisecs()) * 0.04)) * 0.07)), entityy(local7\Field1\Field11[$06], $01), 200.0), entityz(local7\Field1\Field11[$06], $01), $01)
                        rotateentity(local7\Field1\Field11[$06], sin(((Float millisecs()) * 0.03)), entityyaw(local7\Field1\Field11[$06], $01), (- sin(((Float millisecs()) * 0.025))), $01)
                    Else
                        positionentity(local7\Field1\Field11[$06], entityx(local7\Field1\Field11[$06], $01), curvevalue((-1280.0 * roomscale), entityy(local7\Field1\Field11[$06], $01), 200.0), entityz(local7\Field1\Field11[$06], $01), $01)
                        rotateentity(local7\Field1\Field11[$06], 0.0, entityyaw(local7\Field1\Field11[$06], $01), 0.0, $01)
                    EndIf
                Else
                    hideentity(local7\Field1\Field13[$00]\Field0)
                EndIf
            Case "room2offices3"
                If (playerroom = local7\Field1) Then
                    local7\Field2 = (local7\Field2 + fpsfactor)
                    debuglog("bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb")
                    If (700.0 < local7\Field2) Then
                        debuglog("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa")
                        If (0.5 < entitydistance(local7\Field1\Field12[$00]\Field0, collider)) Then
                            If (entityinview(local7\Field1\Field12[$00]\Field0, camera) = $00) Then
                                local7\Field1\Field12[$00]\Field5 = $00
                                local7\Field1\Field12[$00]\Field7 = 0.0
                                Delete local7
                            EndIf
                        EndIf
                    EndIf
                EndIf
            Case "room2ccont"
                If (playerroom = local7\Field1) Then
                    entitypick(camera, 1.5)
                    For local1 = $01 To $05 Step $02
                        If (pickedentity() = local7\Field1\Field11[local1]) Then
                            drawhandicon = $01
                            If (mousehit1 <> 0) Then
                                grabbedentity = local7\Field1\Field11[local1]
                            EndIf
                            If (0.0 = local7\Field2) Then
                                If (local1 = $03) Then
                                    local7\Field2 = max(local7\Field2, 1.0)
                                    playsound(horrorsfx($07))
                                    playsound(leversfx)
                                EndIf
                            EndIf
                        EndIf
                        local22 = entitypitch(local7\Field1\Field11[local1], $00)
                        If ((mousedown1 Or mousehit1) <> 0) Then
                            If (grabbedentity <> $00) Then
                                If (grabbedentity = local7\Field1\Field11[local1]) Then
                                    drawhandicon = $01
                                    turnentity(local7\Field1\Field11[local1], (mouse_y_speed_1 * 2.5), 0.0, 0.0, $00)
                                    rotateentity(grabbedentity, max(min(entitypitch(local7\Field1\Field11[local1], $00), 85.0), -85.0), entityyaw(local7\Field1\Field11[local1], $00), 0.0, $00)
                                    drawarrowicon($00) = $01
                                    drawarrowicon($02) = $01
                                EndIf
                            EndIf
                        Else
                            If (0.0 < entitypitch(local7\Field1\Field11[local1], $00)) Then
                                rotateentity(local7\Field1\Field11[local1], curvevalue(85.0, entitypitch(local7\Field1\Field11[local1], $00), 10.0), entityyaw(local7\Field1\Field11[local1], $00), 0.0, $00)
                            Else
                                rotateentity(local7\Field1\Field11[local1], curvevalue(-85.0, entitypitch(local7\Field1\Field11[local1], $00), 10.0), entityyaw(local7\Field1\Field11[local1], $00), 0.0, $00)
                            EndIf
                            grabbedentity = $00
                        EndIf
                        If (83.0 < entitypitch(local7\Field1\Field11[local1], $00)) Then
                            If (83.0 >= local22) Then
                                playsound2(leversfx, camera, local7\Field1\Field11[local1], 10.0, 1.0, $01)
                            EndIf
                            If (local1 = $03) Then
                                secondarylighton = curvevalue(1.0, secondarylighton, 10.0)
                                If (83.0 >= local22) Then
                                    playsound2(lightsfx, camera, local7\Field1\Field11[local1], 10.0, 1.0, $01)
                                EndIf
                            Else
                                remotedooron = $01
                            EndIf
                        ElseIf (-83.0 > entitypitch(local7\Field1\Field11[local1], $00)) Then
                            If (-83.0 <= local22) Then
                                playsound2(leversfx, camera, local7\Field1\Field11[local1], 10.0, 1.0, $01)
                            EndIf
                            If (local1 = $03) Then
                                If (-83.0 <= local22) Then
                                    playsound2(lightsfx, camera, local7\Field1\Field11[local1], 10.0, 1.0, $01)
                                    For local6 = Each rooms
                                        For local13 = 0.0 To 19.0 Step 1.0
                                            If (local6\Field10[(Int local13)] <> $00) Then
                                                hideentity(local6\Field10[(Int local13)])
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
                        rotateentity(local7\Field1\Field11[$03], curvevalue(-85.0, entitypitch(local7\Field1\Field11[$03], $00), 5.0), entityyaw(local7\Field1\Field11[$03], $00), 0.0, $00)
                    EndIf
                EndIf
            Case "914"
                If (playerroom = local7\Field1) Then
                    achv914 = $01
                    entitypick(camera, 1.0)
                    If (pickedentity() = local7\Field1\Field11[$00]) Then
                        drawhandicon = $01
                        If (mousehit1 <> 0) Then
                            grabbedentity = local7\Field1\Field11[$00]
                        EndIf
                    ElseIf (pickedentity() = local7\Field1\Field11[$01]) Then
                        drawhandicon = $01
                        If (mousehit1 <> 0) Then
                            grabbedentity = local7\Field1\Field11[$01]
                        EndIf
                    EndIf
                    If ((mousedown1 Or mousehit1) <> 0) Then
                        If (grabbedentity <> $00) Then
                            If (grabbedentity = local7\Field1\Field11[$00]) Then
                                If (0.0 = local7\Field2) Then
                                    drawhandicon = $01
                                    turnentity(grabbedentity, 0.0, 0.0, ((- mouse_x_speed_1) * 2.5), $00)
                                    local10 = wrapangle(entityroll(local7\Field1\Field11[$00], $00))
                                    If (181.0 < local10) Then
                                        drawarrowicon($03) = $01
                                    EndIf
                                    drawarrowicon($01) = $01
                                    If (90.0 > local10) Then
                                        rotateentity(grabbedentity, 0.0, 0.0, 361.0, $00)
                                    ElseIf (180.0 > local10) Then
                                        rotateentity(grabbedentity, 0.0, 0.0, 180.0, $00)
                                    EndIf
                                    If (((181.0 > local10) And (90.0 < local10)) <> 0) Then
                                        For local9 = Each items
                                            If (((local9\Field0 <> $00) And (local9\Field7 = $00)) <> 0) Then
                                                If (200.0 > (Abs (entityx(local9\Field0, $00) - (local7\Field1\Field3 - (712.0 * roomscale))))) Then
                                                    If (104.0 > (Abs (entityy(local9\Field0, $00) - ((648.0 * roomscale) + local7\Field1\Field4)))) Then
                                                        local7\Field2 = 1.0
                                                        local7\Field5 = playsound2(machinesfx, camera, local7\Field1\Field11[$01], 10.0, 1.0, $01)
                                                        Exit
                                                    EndIf
                                                EndIf
                                            EndIf
                                        Next
                                    EndIf
                                EndIf
                            ElseIf (grabbedentity = local7\Field1\Field11[$01]) Then
                                If (0.0 = local7\Field2) Then
                                    drawhandicon = $01
                                    turnentity(grabbedentity, 0.0, 0.0, ((- mouse_x_speed_1) * 2.5), $00)
                                    local10 = wrapangle(entityroll(local7\Field1\Field11[$01], $00))
                                    drawarrowicon($03) = $01
                                    drawarrowicon($01) = $01
                                    If (90.0 < local10) Then
                                        If (180.0 > local10) Then
                                            rotateentity(grabbedentity, 0.0, 0.0, 90.0, $00)
                                        ElseIf (270.0 > local10) Then
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
                    If (grabbedentity <> local7\Field1\Field11[$01]) Then
                        local10 = wrapangle(entityroll(local7\Field1\Field11[$01], $00))
                        If (22.5 > local10) Then
                            local10 = 0.0
                            local23 = "1:1"
                        ElseIf (67.5 > local10) Then
                            local10 = 45.0
                            local23 = "coarse"
                        ElseIf (180.0 > local10) Then
                            local10 = 90.0
                            local23 = "rough"
                        ElseIf (337.5 < local10) Then
                            local10 = -1.0
                            local23 = "1:1"
                        ElseIf (292.5 < local10) Then
                            local10 = -45.0
                            local23 = "fine"
                        Else
                            local10 = -90.0
                            local23 = "very fine"
                        EndIf
                        rotateentity(local7\Field1\Field11[$01], 0.0, 0.0, curvevalue(local10, entityroll(local7\Field1\Field11[$01], $00), 10.0), $00)
                    EndIf
                    For local1 = $00 To $01 Step $01
                        If (grabbedentity = local7\Field1\Field11[local1]) Then
                            If (entityinview(local7\Field1\Field11[local1], camera) = $00) Then
                                grabbedentity = $00
                            ElseIf (1.0 < entitydistance(local7\Field1\Field11[local1], camera)) Then
                                grabbedentity = $00
                            EndIf
                        EndIf
                    Next
                    If (0.0 < local7\Field2) Then
                        local7\Field2 = (local7\Field2 + fpsfactor)
                        rotateentity(local7\Field1\Field11[$00], entitypitch(local7\Field1\Field11[$00], $00), entityyaw(local7\Field1\Field11[$00], $00), 180.0, $00)
                        local7\Field1\Field12[$01]\Field5 = $00
                        If (140.0 < local7\Field2) Then
                            local7\Field1\Field12[$00]\Field5 = $00
                        EndIf
                        If ((170.0 * roomscale) > distance(entityx(collider, $00), entityz(collider, $00), entityx(local7\Field1\Field11[$02], $01), entityz(local7\Field1\Field11[$02], $01))) Then
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
                            For local9 = Each items
                                If (((local9\Field0 <> $00) And (local9\Field7 = $00)) <> 0) Then
                                    If ((180.0 * roomscale) > distance(entityx(local9\Field0, $00), entityz(local9\Field0, $00), entityx(local7\Field1\Field11[$02], $01), entityz(local7\Field1\Field11[$02], $01))) Then
                                        use914(local9, local23, entityx(local7\Field1\Field11[$03], $01), entityy(local7\Field1\Field11[$03], $01), entityz(local7\Field1\Field11[$03], $01))
                                    EndIf
                                EndIf
                            Next
                            If ((160.0 * roomscale) > distance(entityx(collider, $00), entityz(collider, $00), entityx(local7\Field1\Field11[$02], $01), entityz(local7\Field1\Field11[$02], $01))) Then
                                Select local23
                                    Case "1:1"
                                        invertmouse = (invertmouse = $00)
                                    Case "fine","very fine"
                                        superman = $01
                                End Select
                                blurtimer = 1000.0
                                positionentity(collider, entityx(local7\Field1\Field11[$03], $01), (entityy(local7\Field1\Field11[$03], $01) + 1.0), entityz(local7\Field1\Field11[$03], $01), $00)
                                resetentity(collider)
                                dropspeed = 0.0
                            EndIf
                            local7\Field1\Field12[$00]\Field5 = $01
                            local7\Field1\Field12[$01]\Field5 = $01
                            rotateentity(local7\Field1\Field11[$00], 0.0, 0.0, 0.0, $00)
                            local7\Field2 = 0.0
                        EndIf
                    EndIf
                EndIf
        End Select
    Next
    If (0.0 < explosiontimer) Then
        explosiontimer = (explosiontimer + fpsfactor)
        If (140.0 > explosiontimer) Then
            If (5.0 > (explosiontimer - fpsfactor)) Then
                explosionsfx = loadsound("SFX\nuclear1.ogg")
                playsound(explosionsfx)
                camerashake = 10.0
                explosiontimer = 5.0
            EndIf
            camerashake = curvevalue((explosiontimer / 60.0), camerashake, 50.0)
        Else
            camerashake = min((explosiontimer / 20.0), 20.0)
            If (140.0 > (explosiontimer - fpsfactor)) Then
                blinktimer = 1.0
                explosionsfx = loadsound("SFX\nuclear2.ogg")
                playsound(explosionsfx)
                For local1 = $00 To $28 Step $01
                    local4 = createparticle((entityx(collider, $00) + rnd(-0.5, 0.5)), (entityy(collider, $00) - rnd(0.2, 1.5)), (entityz(collider, $00) + rnd(-0.5, 0.5)), $00, rnd(0.2, 0.6), 0.0, $15E)
                    rotateentity(local4\Field1, -90.0, 0.0, 0.0, $01)
                    local4\Field8 = rnd(0.05, 0.07)
                Next
            EndIf
            lightflash = min(((explosiontimer - 160.0) / 40.0), 2.0)
            debuglog((Str lightflash))
            If (160.0 < explosiontimer) Then
                killtimer = min(killtimer, -0.1)
                endingtimer = min(killtimer, -0.1)
            EndIf
            If (500.0 < explosiontimer) Then
                explosiontimer = 0.0
            EndIf
        EndIf
    EndIf
    Return $00
End Function
