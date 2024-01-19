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
    Local local10.emitters
    Local local11#
    Local local13%
    Local local14#
    Local local15#
    Local local16.doors
    Local local17.waypoints
    Local local18#
    Local local19#
    Local local20.decals
    Local local21%
    Local local22.rooms
    Local local23%
    Local local24.decals
    Local local27%
    Local local28%
    Local local29%
    Local local30#
    Local local31%
    Local local32%
    Local local33$
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
                        While (180.0 > local7\Field1\Field12[$01]\Field7)
                            local7\Field1\Field12[$01]\Field7 = min(180.0, (local7\Field1\Field12[$01]\Field7 + 0.8))
                            moveentity(local7\Field1\Field12[$01]\Field0, (sin(local7\Field1\Field12[$01]\Field7) / 180.0), 0.0, 0.0)
                            moveentity(local7\Field1\Field12[$01]\Field1, ((- sin(local7\Field1\Field12[$01]\Field7)) / 180.0), 0.0, 0.0)
                        Wend
                        If (local7\Field1\Field13[$00] <> Null) Then
                            setanimtime(local7\Field1\Field13[$00]\Field0, 10.0, $00)
                        EndIf
                        local7\Field2 = 1.0
                    EndIf
                Else
                    If (local7\Field1\Field13[$00] <> Null) Then
                        animate2(local7\Field1\Field13[$00]\Field0, animtime(local7\Field1\Field13[$00]\Field0), $0A, $1C, 0.12, $00)
                    EndIf
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
                            If (local7\Field1\Field13[$00] <> Null) Then
                                removenpc(local7\Field1\Field13[$00])
                            EndIf
                            Delete local7
                        EndIf
                    EndIf
                EndIf
            Case "room173"
                If (((0.0 <= killtimer) And (0.0 = local7\Field3)) <> 0) Then
                    If (0.0 < local7\Field4) Then
                        If (music($05) = $00) Then
                            music($05) = loadsound("SFX\Music\Blue Feather.ogg")
                        EndIf
                        shouldplay = $05
                        If (150.0 > local7\Field4) Then
                            local7\Field4 = ((fpsfactor / 30.0) + local7\Field4)
                            If (30.0 > local7\Field4) Then
                                If (5.0 < local7\Field4) Then
                                    local7\Field4 = ((fpsfactor / 3.0) + local7\Field4)
                                    msg = "Pick up the paper on the desk and open the inventory by pressing tab"
                                    msgtimer = 490.0
                                    local7\Field4 = 30.0
                                EndIf
                            EndIf
                            If (selecteditem <> Null) Then
                                local7\Field4 = ((fpsfactor / 5.0) + local7\Field4)
                            EndIf
                        ElseIf (((150.0 <= local7\Field4) And (700.0 > local7\Field4)) <> 0) Then
                            If (local7\Field1\Field13[$03] = Null) Then
                                blinktimer = -10.0
                                local7\Field1\Field13[$03] = createnpc($03, ((local7\Field1\Field3 - (3072.0 * roomscale)) + rnd(-0.3, 0.3)), 0.3, (((Float rand($35C, $380)) * roomscale) + local7\Field1\Field5))
                                local7\Field1\Field13[$04] = createnpc($03, (local7\Field1\Field3 - (2560.0 * roomscale)), 0.3, ((768.0 * roomscale) + local7\Field1\Field5))
                                local7\Field1\Field13[$05] = createnpc($03, (local7\Field1\Field3 - (6400.0 * roomscale)), 0.3, ((768.0 * roomscale) + local7\Field1\Field5))
                                local7\Field1\Field13[$06] = createnpc($04, (local7\Field1\Field3 - (3712.0 * roomscale)), -0.3, (local7\Field1\Field5 - (2208.0 * roomscale)))
                                local13 = loadtexture("GFX\npcs\scientist.jpg", $01)
                                entitytexture(local7\Field1\Field13[$06]\Field0, local13, $00, $00)
                                local7\Field7 = loadsound("SFX\intro\guard1.ogg")
                                playsound2(local7\Field7, camera, local7\Field1\Field13[$03]\Field4, 10.0, 1.0, $01)
                                local7\Field1\Field13[$03]\Field9 = 7.0
                                local7\Field1\Field13[$04]\Field9 = 7.0
                                local7\Field1\Field13[$05]\Field9 = 7.0
                                local7\Field1\Field12[$06]\Field4 = $00
                                usedoor(local7\Field1\Field12[$06], $00)
                                local7\Field1\Field12[$06]\Field4 = $01
                            EndIf
                            local7\Field1\Field13[$03]\Field9 = 7.0
                            pointentity(local7\Field1\Field13[$03]\Field4, collider, 0.0)
                            pointentity(local7\Field1\Field13[$04]\Field4, collider, 0.0)
                            pointentity(local7\Field1\Field13[$05]\Field4, collider, 0.0)
                            local7\Field4 = min(((fpsfactor / 4.0) + local7\Field4), 699.0)
                            If (1.5 < distance(entityx(collider, $00), entityz(collider, $00), (playerroom\Field3 - (3072.0 * roomscale)), ((192.0 * roomscale) + playerroom\Field5))) Then
                                local7\Field1\Field13[$03]\Field9 = 5.0
                                local7\Field1\Field13[$03]\Field28 = entityx(collider, $00)
                                local7\Field1\Field13[$03]\Field29 = entityy(collider, $00)
                                local7\Field1\Field13[$03]\Field30 = entityz(collider, $00)
                                If (250.0 < local7\Field4) Then
                                    If (local7\Field1\Field13[$03]\Field15 <> $00) Then
                                        If (channelplaying(local7\Field1\Field13[$03]\Field15) <> 0) Then
                                            stopchannel(local7\Field1\Field13[$03]\Field15)
                                        EndIf
                                    EndIf
                                    local7\Field7 = loadsound("SFX\intro\guard4.ogg")
                                    playsound2(local7\Field7, camera, local7\Field1\Field13[$03]\Field4, 10.0, 1.0, $01)
                                    local7\Field1\Field13[$03]\Field32 = findpath(local7\Field1\Field13[$03], (playerroom\Field3 - (1584.0 * roomscale)), 0.3, (playerroom\Field5 - (1040.0 * roomscale)))
                                    debuglog((Str local7\Field1\Field13[$03]\Field32))
                                    local7\Field4 = 710.0
                                EndIf
                            ElseIf (((350.0 > (local7\Field4 - (fpsfactor / 4.0))) And (350.0 <= local7\Field4)) <> 0) Then
                                local7\Field7 = loadsound("SFX\intro\guard2.ogg")
                                local7\Field1\Field13[$03]\Field15 = playsound2(local7\Field7, camera, local7\Field1\Field13[$03]\Field4, 10.0, 1.0, $01)
                            ElseIf (((550.0 > (local7\Field4 - (fpsfactor / 4.0))) And (550.0 <= local7\Field4)) <> 0) Then
                                local7\Field7 = loadsound("SFX\intro\guard3.ogg")
                                local7\Field1\Field13[$03]\Field15 = playsound2(local7\Field7, camera, local7\Field1\Field13[$03]\Field4, 10.0, 1.0, $01)
                            ElseIf (630.0 < local7\Field4) Then
                                positionentity(collider, entityx(collider, $00), entityy(collider, $00), min(entityz(collider, $00), (entityz(local7\Field1\Field2, $01) + (490.0 * roomscale))), $00)
                                If (local7\Field1\Field12[$06]\Field5 = $01) Then
                                    local7\Field1\Field12[$06]\Field4 = $00
                                    usedoor(local7\Field1\Field12[$06], $00)
                                    local7\Field1\Field12[$06]\Field4 = $01
                                    local10 = createemitter((playerroom\Field3 - (2976.0 * roomscale)), (373.0 * roomscale), ((204.0 * roomscale) + playerroom\Field5), $00)
                                    turnentity(local10\Field0, 90.0, 0.0, 0.0, $01)
                                    local10\Field10 = 7.0
                                    local10\Field9 = 0.03
                                    local10\Field11 = 0.003
                                    local10\Field7 = playerroom
                                    local10 = createemitter((playerroom\Field3 - (3168.0 * roomscale)), (373.0 * roomscale), ((204.0 * roomscale) + playerroom\Field5), $00)
                                    turnentity(local10\Field0, 90.0, 0.0, 0.0, $01)
                                    local10\Field10 = 7.0
                                    local10\Field9 = 0.03
                                    local10\Field11 = 0.003
                                    local10\Field7 = playerroom
                                EndIf
                                eyeirritation = max(((fpsfactor * 4.0) + eyeirritation), 1.0)
                            ElseIf (670.0 < local7\Field4) Then
                            EndIf
                        ElseIf (800.0 > local7\Field4) Then
                            local7\Field4 = ((fpsfactor / 4.0) + local7\Field4)
                            debuglog("***********************************")
                            debuglog((Str local7\Field1\Field13[$03]\Field9))
                            local7\Field1\Field13[$03]\Field9 = 5.0
                            local7\Field1\Field13[$03]\Field28 = entityx(collider, $00)
                            local7\Field1\Field13[$03]\Field29 = entityy(collider, $00)
                            local7\Field1\Field13[$03]\Field30 = entityz(collider, $00)
                        ElseIf (900.0 > local7\Field4) Then
                            If (local7\Field1\Field13[$06] <> Null) Then
                                If (0.0 = local7\Field1\Field13[$06]\Field9) Then
                                    If (5.0 > distance(entityx(collider, $00), entityz(collider, $00), (entityx(local7\Field1\Field2, $01) - (3328.0 * roomscale)), (entityz(local7\Field1\Field2, $01) - (1232.0 * roomscale)))) Then
                                        local7\Field1\Field13[$06]\Field9 = 1.0
                                    EndIf
                                ElseIf (entityz(local7\Field1\Field13[$06]\Field4, $00) > (entityz(local7\Field1\Field2, $01) - (64.0 * roomscale))) Then
                                    rotateentity(local7\Field1\Field13[$06]\Field4, 0.0, curveangle(90.0, entityyaw(local7\Field1\Field13[$06]\Field4, $00), 15.0), 0.0, $00)
                                    If (local7\Field1\Field12[$07]\Field5 <> 0) Then
                                        usedoor(local7\Field1\Field12[$07], $00)
                                    EndIf
                                    If (1.0 > local7\Field1\Field12[$07]\Field7) Then
                                        removenpc(local7\Field1\Field13[$06])
                                        local7\Field1\Field13[$06] = Null
                                    EndIf
                                EndIf
                            EndIf
                            local0 = distance(entityx(collider, $00), entityz(collider, $00), entityx(local7\Field1\Field13[$03]\Field4, $00), entityz(local7\Field1\Field13[$03]\Field4, $00))
                            If (3.0 > local0) Then
                                local7\Field1\Field13[$03]\Field11 = min(max((local7\Field1\Field13[$03]\Field11 - fpsfactor), 0.0), 50.0)
                            Else
                                local7\Field1\Field13[$03]\Field11 = max((local7\Field1\Field13[$03]\Field11 + fpsfactor), 50.0)
                                If ((((560.0 <= local7\Field1\Field13[$03]\Field11) And (560.0 > (local7\Field1\Field13[$03]\Field11 - fpsfactor))) And (7.0 = local7\Field1\Field13[$03]\Field9)) <> 0) Then
                                    If (2.0 > local7\Field1\Field13[$03]\Field10) Then
                                        local7\Field7 = loadsound("SFX\intro\guard6.ogg")
                                        playsound2(local7\Field7, camera, local7\Field1\Field13[$03]\Field4, 10.0, 1.0, $01)
                                        local7\Field1\Field13[$03]\Field11 = 50.0
                                        local7\Field1\Field13[$03]\Field10 = 3.0
                                    ElseIf (3.0 = local7\Field1\Field13[$03]\Field10) Then
                                        local7\Field7 = loadsound("SFX\intro\guard7.ogg")
                                        playsound2(local7\Field7, camera, local7\Field1\Field13[$03]\Field4, 10.0, 1.0, $01)
                                        local7\Field1\Field13[$03]\Field11 = 50.0
                                        local7\Field1\Field13[$03]\Field10 = 4.0
                                    ElseIf (4.0 = local7\Field1\Field13[$03]\Field10) Then
                                        local7\Field7 = loadsound("SFX\intro\guard8.ogg")
                                        playsound2(local7\Field7, camera, local7\Field1\Field13[$03]\Field4, 10.0, 1.0, $01)
                                        local7\Field1\Field13[$03]\Field11 = 225.0
                                        local7\Field1\Field13[$03]\Field10 = 5.0
                                    ElseIf (5.0 = local7\Field1\Field13[$03]\Field10) Then
                                        local7\Field1\Field13[$03]\Field9 = 1.0
                                        local7\Field1\Field13[$04]\Field9 = 1.0
                                        local7\Field1\Field13[$05]\Field9 = 1.0
                                    EndIf
                                EndIf
                            EndIf
                            If (local7\Field1\Field13[$03]\Field14 <> $00) Then
                                If (channelplaying(local7\Field1\Field13[$03]\Field15) = $00) Then
                                    local7\Field1\Field13[$03]\Field14 = $00
                                Else
                                    local7\Field1\Field13[$03]\Field15 = loopsound2(local7\Field1\Field13[$03]\Field14, local7\Field1\Field13[$03]\Field15, camera, local7\Field1\Field13[$03]\Field4, 10.0, 1.0)
                                EndIf
                            EndIf
                            debuglog((Str local7\Field1\Field13[$03]\Field11))
                            If (1.0 <> local7\Field1\Field13[$03]\Field9) Then
                                local7\Field1\Field13[$04]\Field9 = 5.0
                                local7\Field1\Field13[$04]\Field28 = entityx(collider, $00)
                                local7\Field1\Field13[$04]\Field29 = entityy(collider, $00)
                                local7\Field1\Field13[$04]\Field30 = entityz(collider, $00)
                                pointentity(local7\Field1\Field13[$05]\Field4, collider, 0.0)
                                If (local0 < min(max((4.0 - (local7\Field1\Field13[$03]\Field11 * 0.05)), 1.5), 4.0)) Then
                                    If (local7\Field1\Field13[$03]\Field32 <> $01) Then
                                        local7\Field1\Field13[$03]\Field9 = 7.0
                                        pointentity(local7\Field1\Field13[$03]\Field0, collider, 0.0)
                                        rotateentity(local7\Field1\Field13[$03]\Field4, 0.0, curvevalue(entityyaw(local7\Field1\Field13[$03]\Field0, $00), entityyaw(local7\Field1\Field13[$03]\Field4, $00), 20.0), 0.0, $01)
                                        If (local7\Field1\Field13[$03]\Field32 = $02) Then
                                            local7\Field1\Field13[$03]\Field32 = findpath(local7\Field1\Field13[$03], (playerroom\Field3 - (1584.0 * roomscale)), 0.3, (playerroom\Field5 - (1040.0 * roomscale)))
                                            local7\Field1\Field13[$03]\Field9 = 3.0
                                        EndIf
                                    Else
                                        local7\Field1\Field13[$03]\Field9 = 3.0
                                    EndIf
                                Else
                                    debuglog("state = 7")
                                    local7\Field1\Field13[$03]\Field9 = 7.0
                                    pointentity(local7\Field1\Field13[$03]\Field0, collider, 0.0)
                                    rotateentity(local7\Field1\Field13[$03]\Field4, 0.0, curvevalue(entityyaw(local7\Field1\Field13[$03]\Field0, $00), entityyaw(local7\Field1\Field13[$03]\Field4, $00), 20.0), 0.0, $01)
                                    If (5.5 < local0) Then
                                        local7\Field1\Field13[$03]\Field32 = $02
                                        If (0.0 = local7\Field1\Field13[$03]\Field10) Then
                                            local7\Field7 = loadsound("SFX\intro\guard5.ogg")
                                            playsound2(local7\Field7, camera, local7\Field1\Field13[$03]\Field4, 10.0, 1.0, $01)
                                            local7\Field1\Field13[$03]\Field10 = 1.0
                                        EndIf
                                        local7\Field1\Field13[$03]\Field9 = 5.0
                                        local7\Field1\Field13[$03]\Field28 = entityx(collider, $00)
                                        local7\Field1\Field13[$03]\Field29 = entityy(collider, $00)
                                        local7\Field1\Field13[$03]\Field30 = entityz(collider, $00)
                                    EndIf
                                EndIf
                            EndIf
                            If (1.5 > distance(entityx(collider, $00), entityz(collider, $00), entityx(local7\Field1\Field12[$02]\Field2, $01), entityz(local7\Field1\Field12[$02]\Field2, $01))) Then
                                local7\Field7 = loadsound("SFX\intro\guard10.ogg")
                                playsound2(local7\Field7, camera, local7\Field1\Field13[$03]\Field4, 10.0, 1.0, $01)
                                local7\Field4 = 910.0
                                local7\Field1\Field12[$03]\Field4 = $00
                                usedoor(local7\Field1\Field12[$03], $00)
                                local7\Field1\Field12[$03]\Field4 = $01
                                local7\Field1\Field12[$02]\Field4 = $00
                                usedoor(local7\Field1\Field12[$02], $00)
                                local7\Field1\Field12[$02]\Field4 = $01
                            EndIf
                        Else
                            local7\Field1\Field13[$03]\Field9 = 7.0
                            pointentity(local7\Field1\Field13[$03]\Field0, collider, 0.0)
                            rotateentity(local7\Field1\Field13[$03]\Field4, 0.0, curvevalue(entityyaw(local7\Field1\Field13[$03]\Field0, $00), entityyaw(local7\Field1\Field13[$03]\Field4, $00), 20.0), 0.0, $01)
                            local7\Field1\Field13[$04]\Field9 = 7.0
                            pointentity(local7\Field1\Field13[$04]\Field0, collider, 0.0)
                            rotateentity(local7\Field1\Field13[$04]\Field4, 0.0, curvevalue(entityyaw(local7\Field1\Field13[$03]\Field0, $00), entityyaw(local7\Field1\Field13[$03]\Field4, $00), 20.0), 0.0, $01)
                            If (2.7 > distance(entityx(collider, $00), entityz(collider, $00), entityx(local7\Field1\Field2, $00), entityz(local7\Field1\Field2, $00))) Then
                                local7\Field1\Field12[$02]\Field4 = $00
                                usedoor(local7\Field1\Field12[$02], $00)
                                local7\Field1\Field12[$02]\Field4 = $01
                                local7\Field4 = 0.0
                                local7\Field1\Field13[$03]\Field9 = 0.0
                                local7\Field1\Field13[$04]\Field9 = 0.0
                                local7\Field1\Field13[$05]\Field9 = 0.0
                                usedoor(local7\Field1\Field12[$01], $00)
                            EndIf
                        EndIf
                    ElseIf (0.0 = local7\Field2) Then
                        If (playerroom = local7\Field1) Then
                            For local1 = $00 To $03 Step $01
                                introsfx(local1) = loadsound((("SFX\intro\intro" + (Str (local1 + $01))) + ".ogg"))
                            Next
                            For local1 = $04 To $06 Step $01
                                introsfx(local1) = loadsound((("SFX\intro\refuse" + (Str (local1 - $03))) + ".ogg"))
                            Next
                            introsfx($10) = loadsound("SFX\intro\horror.ogg")
                            curr173\Field19 = 1.0
                            local7\Field1\Field13[$00] = createnpc($03, entityx(local7\Field1\Field11[$00], $01), entityy(local7\Field1\Field11[$00], $01), entityz(local7\Field1\Field11[$00], $01))
                            local7\Field1\Field13[$00]\Field13 = 180.0
                            local7\Field1\Field13[$01] = createnpc($04, entityx(local7\Field1\Field11[$01], $01), 0.5, entityz(local7\Field1\Field11[$01], $01))
                            pointentity(local7\Field1\Field13[$01]\Field4, local7\Field1\Field11[$05], 0.0)
                            local7\Field1\Field13[$02] = createnpc($04, entityx(local7\Field1\Field11[$02], $01), 0.5, entityz(local7\Field1\Field11[$02], $01))
                            pointentity(local7\Field1\Field13[$02]\Field4, local7\Field1\Field11[$05], 0.0)
                            local13 = loadtexture("GFX\npcs\classd2.jpg", $01)
                            entitytexture(local7\Field1\Field13[$02]\Field0, local13, $00, $00)
                            positionentity(curr173\Field4, entityx(local7\Field1\Field11[$05], $01), 0.5, entityz(local7\Field1\Field11[$05], $01), $00)
                            resetentity(curr173\Field4)
                            positionentity(collider, (playerroom\Field3 - (3072.0 * roomscale)), 0.3, ((192.0 * roomscale) + playerroom\Field5), $00)
                            resetentity(collider)
                            local7\Field2 = 1.0
                            local7\Field4 = 1.0
                        EndIf
                    ElseIf (10000.0 > local7\Field2) Then
                        local7\Field2 = min(((fpsfactor / 3.0) + local7\Field2), 5000.0)
                        If (((130.0 <= local7\Field2) And (130.0 > (local7\Field2 - (fpsfactor / 3.0)))) <> 0) Then
                            local7\Field5 = playsound(introsfx($00))
                        ElseIf (230.0 < local7\Field2) Then
                            local2 = $01
                            For local1 = $01 To $02 Step $01
                                If (0.3 < distance(entityx(local7\Field1\Field13[local1]\Field4, $00), entityz(local7\Field1\Field13[local1]\Field4, $00), entityx(local7\Field1\Field11[(local1 + $02)], $01), entityz(local7\Field1\Field11[(local1 + $02)], $01))) Then
                                    pointentity(local7\Field1\Field13[local1]\Field0, local7\Field1\Field11[(local1 + $02)], 0.0)
                                    rotateentity(local7\Field1\Field13[local1]\Field4, 0.0, curvevalue(entityyaw(local7\Field1\Field13[local1]\Field0, $00), entityyaw(local7\Field1\Field13[local1]\Field4, $00), 15.0), 0.0, $00)
                                    If ((Float ((local1 * $1E) + $C8)) < local7\Field2) Then
                                        local7\Field1\Field13[local1]\Field9 = 1.0
                                    EndIf
                                    local2 = $00
                                Else
                                    local7\Field1\Field13[local1]\Field9 = 0.0
                                    pointentity(local7\Field1\Field13[local1]\Field0, local7\Field1\Field11[$05], 0.0)
                                    rotateentity(local7\Field1\Field13[local1]\Field4, 0.0, curvevalue(entityyaw(local7\Field1\Field13[local1]\Field0, $00), entityyaw(local7\Field1\Field13[local1]\Field4, $00), 15.0), 0.0, $00)
                                EndIf
                            Next
                            If (entityx(collider, $00) < (entityx(local7\Field1\Field2, $00) + (408.0 * roomscale))) Then
                                If (((450.0 <= local7\Field2) And (450.0 > (local7\Field2 - (fpsfactor / 3.0)))) <> 0) Then
                                    local7\Field5 = playsound(introsfx($04))
                                ElseIf (((650.0 <= local7\Field2) And (650.0 > (local7\Field2 - (fpsfactor / 3.0)))) <> 0) Then
                                    local7\Field5 = playsound(introsfx($05))
                                ElseIf (((850.0 <= local7\Field2) And (850.0 > (local7\Field2 - (fpsfactor / 3.0)))) <> 0) Then
                                    local7\Field1\Field12[$01]\Field5 = $00
                                    local7\Field5 = playsound(introsfx($06))
                                ElseIf (1000.0 < local7\Field2) Then
                                    local7\Field1\Field13[$00]\Field9 = 1.0
                                    local7\Field3 = 1.0
                                    Exit
                                EndIf
                                If (850.0 < local7\Field2) Then
                                    positionentity(collider, min(entityx(collider, $00), (entityx(local7\Field1\Field2, $00) + (352.0 * roomscale))), entityy(collider, $00), entityz(collider, $00), $00)
                                EndIf
                            ElseIf (local2 = $01) Then
                                local7\Field2 = 10000.0
                                usedoor(local7\Field1\Field12[$01], $00)
                            EndIf
                        EndIf
                        positionentity(curr173\Field4, entityx(local7\Field1\Field11[$05], $01), entityy(curr173\Field4, $00), entityz(local7\Field1\Field11[$05], $01), $00)
                        rotateentity(curr173\Field4, 0.0, 0.0, 0.0, $01)
                        resetentity(curr173\Field4)
                    ElseIf (14000.0 > local7\Field2) Then
                        local7\Field2 = min((local7\Field2 + fpsfactor), 13000.0)
                        If (10300.0 > local7\Field2) Then
                            positionentity(collider, max(entityx(collider, $00), (entityx(local7\Field1\Field2, $00) + (352.0 * roomscale))), entityy(collider, $00), entityz(collider, $00), $00)
                        EndIf
                        If (((10300.0 <= local7\Field2) And (10300.0 > (local7\Field2 - fpsfactor))) <> 0) Then
                            local7\Field5 = playsound(introsfx($01))
                            positionentity(collider, max(entityx(collider, $00), (entityx(local7\Field1\Field2, $00) + (352.0 * roomscale))), entityy(collider, $00), entityz(collider, $00), $00)
                        ElseIf (((10440.0 <= local7\Field2) And (10440.0 > (local7\Field2 - fpsfactor))) <> 0) Then
                            usedoor(local7\Field1\Field12[$01], $00)
                            local7\Field5 = playsound(introsfx($07))
                        ElseIf (((10740.0 <= local7\Field2) And (10740.0 > (local7\Field2 - fpsfactor))) <> 0) Then
                            local7\Field5 = playsound(introsfx($02))
                        ElseIf (((11490.0 <= local7\Field2) And (11490.0 > (local7\Field2 - fpsfactor))) <> 0) Then
                            local7\Field5 = playsound(introsfx($0A))
                        ElseIf (((11561.0 <= local7\Field2) And (11561.0 > (local7\Field2 - fpsfactor))) <> 0) Then
                            local7\Field2 = 14000.0
                            playsound(introsfx($10))
                            tempsound = loadsound("SFX\intro\wtf.ogg")
                            playsound2(tempsound, camera, local7\Field1\Field13[$01]\Field4, 8.0, 1.0, $01)
                        EndIf
                        positionentity(curr173\Field4, entityx(local7\Field1\Field11[$05], $01), entityy(curr173\Field4, $00), entityz(local7\Field1\Field11[$05], $01), $00)
                        rotateentity(curr173\Field4, 0.0, 0.0, 0.0, $01)
                        resetentity(curr173\Field4)
                    ElseIf (20000.0 > local7\Field2) Then
                        local7\Field2 = min((local7\Field2 + fpsfactor), 19000.0)
                        If (14100.0 > local7\Field2) Then
                            pointentity(local7\Field1\Field13[$02]\Field4, curr173\Field4, 0.0)
                            If (14005.0 < local7\Field2) Then
                                animate2(local7\Field1\Field13[$00]\Field0, animtime(local7\Field1\Field13[$00]\Field0), $6E, $78, 0.1, $00)
                                local7\Field1\Field13[$00]\Field9 = 8.0
                                setanimtime(local7\Field1\Field13[$01]\Field0, 19.0, $00)
                                local7\Field1\Field13[$01]\Field9 = 2.0
                                positionentity(curr173\Field4, entityx(local7\Field1\Field13[$01]\Field0, $00), entityy(curr173\Field4, $00), entityz(local7\Field1\Field13[$01]\Field0, $00), $00)
                                resetentity(curr173\Field4)
                                pointentity(curr173\Field4, local7\Field1\Field13[$02]\Field4, 0.0)
                                local7\Field1\Field13[$02]\Field9 = 3.0
                                rotateentity(local7\Field1\Field13[$02]\Field4, 0.0, entityyaw(local7\Field1\Field13[$02]\Field4, $00), 0.0, $00)
                                animate2(local7\Field1\Field13[$02]\Field0, animtime(local7\Field1\Field13[$02]\Field0), $196, $17E, -0.15, $01)
                                moveentity(local7\Field1\Field13[$02]\Field4, 0.0, 0.0, (-0.01 * fpsfactor))
                            EndIf
                            If (14030.0 > local7\Field2) Then
                                blinktimer = -10.0
                                lightblink = 1.0
                            ElseIf (local7\Field1\Field13[$02]\Field14 = $00) Then
                                local7\Field1\Field13[$02]\Field14 = loadsound("SFX\intro\gasp.ogg")
                                playsound2(local7\Field1\Field13[$02]\Field14, camera, local7\Field1\Field13[$02]\Field4, 8.0, 1.0, $01)
                            EndIf
                            If (((14080.0 < local7\Field2) And (14080.0 > (local7\Field2 - fpsfactor))) <> 0) Then
                                playsound(introsfx($0C))
                            EndIf
                            camerashake = 3.0
                        ElseIf (14200.0 > local7\Field2) Then
                            animate2(local7\Field1\Field13[$00]\Field0, animtime(local7\Field1\Field13[$00]\Field0), $6E, $78, 0.2, $00)
                            local7\Field1\Field13[$00]\Field9 = 8.0
                            If (14105.0 < local7\Field2) Then
                                If (60.0 <> animtime(local7\Field1\Field13[$02]\Field0)) Then
                                    playsound2(damagesfx($01), camera, local7\Field1\Field13[$00]\Field4, 8.0, 1.0, $01)
                                EndIf
                                setanimtime(local7\Field1\Field13[$02]\Field0, 60.0, $00)
                                local7\Field1\Field13[$02]\Field9 = 2.0
                                positionentity(curr173\Field4, entityx(local7\Field1\Field13[$02]\Field0, $00), entityy(curr173\Field4, $00), entityz(local7\Field1\Field13[$02]\Field0, $00), $00)
                                resetentity(curr173\Field4)
                                pointentity(curr173\Field4, collider, 0.0)
                            EndIf
                            If (14130.0 > local7\Field2) Then
                                blinktimer = -10.0
                                lightblink = 1.0
                            Else
                                curr173\Field19 = 0.0
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
                                positionentity(local7\Field1\Field13[$00]\Field4, (entityx(local7\Field1\Field2, $00) - (160.0 * roomscale)), (entityy(local7\Field1\Field13[$00]\Field4, $00) + 0.1), (entityz(local7\Field1\Field2, $00) + (1280.0 * roomscale)), $00)
                                resetentity(local7\Field1\Field13[$00]\Field4)
                            EndIf
                            If (20105.0 < local7\Field2) Then
                                curr173\Field19 = 1.0
                                pointentity(local7\Field1\Field13[$00]\Field4, curr173\Field0, 0.0)
                                positionentity(curr173\Field4, (entityx(local7\Field1\Field2, $00) - (608.0 * roomscale)), (entityy(local7\Field1\Field2, $00) + (480.0 * roomscale)), (entityz(local7\Field1\Field2, $00) + (1312.0 * roomscale)), $00)
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
                            curr173\Field19 = 0.0
                            local7\Field5 = playsound(introsfx($0F))
                            positionentity(curr173\Field4, (entityx(playerroom\Field2, $00) - (400.0 * roomscale)), 100.0, (entityz(playerroom\Field2, $00) + (1072.0 * roomscale)), $00)
                            resetentity(curr173\Field4)
                            For local6 = Each rooms
                                If (local6\Field7\Field4 = "start") Then
                                    playerroom = local6
                                    local14 = entityx(local6\Field2, $01)
                                    local15 = entityz(local6\Field2, $01)
                                    positionentity(collider, ((entityx(collider, $00) - entityx(local7\Field1\Field2, $00)) + local14), 1.0, ((entityz(collider, $00) - entityz(local7\Field1\Field2, $00)) + local15), $00)
                                    resetentity(collider)
                                    For local1 = $00 To $02 Step $01
                                        positionentity(local7\Field1\Field13[local1]\Field4, ((entityx(local7\Field1\Field13[local1]\Field4, $00) - entityx(local7\Field1\Field2, $00)) + local14), (entityy(local7\Field1\Field13[local1]\Field4, $00) + 0.05), ((entityz(local7\Field1\Field13[local1]\Field4, $00) - entityz(local7\Field1\Field2, $00)) + local15), $00)
                                        resetentity(local7\Field1\Field13[local1]\Field4)
                                    Next
                                    freesound(music($05))
                                    shouldplay = $00
                                    local6\Field13[$00] = local7\Field1\Field13[$00]
                                    local6\Field13[$00]\Field9 = 8.0
                                    For local16 = Each doors
                                        If (local16\Field13 = local7\Field1) Then
                                            Delete local16
                                        EndIf
                                    Next
                                    For local17 = Each waypoints
                                        If (local17\Field2 = local7\Field1) Then
                                            freeentity(local17\Field0)
                                            Delete local17
                                        EndIf
                                    Next
                                    For local1 = $03 To $05 Step $01
                                        Delete local7\Field1\Field13[local1]
                                    Next
                                    freeentity(local7\Field1\Field2)
                                    Delete local7\Field1
                                    showentity(fog)
                                    ambientlight((Float brightness), (Float brightness), (Float brightness))
                                    camerafogrange(camera, camerafognear, camerafogfar)
                                    camerafogmode(camera, $01)
                                    local7\Field3 = 1.0
                                    Exit
                                EndIf
                            Next
                        EndIf
                    EndIf
                Else
                    If (0.0 > killtimer) Then
                        If (1.0 = local7\Field1\Field13[$03]\Field9) Then
                            local7\Field7 = loadsound("SFX\intro\guard9.ogg")
                            playsound(local7\Field7)
                        EndIf
                    EndIf
                    For local1 = $00 To $06 Step $01
                        If (introsfx(local1) <> $00) Then
                            freesound(introsfx(local1))
                            introsfx(local1) = $00
                        EndIf
                    Next
                    freesound(introsfx($10))
                    introsfx($10) = $00
                    local7\Field3 = 1.0
                EndIf
                If (playerroom = local7\Field1) Then
                    camerafogmode(camera, $00)
                    ambientlight(140.0, 140.0, 140.0)
                    hideentity(fog)
                    lightvolume = 4.0
                    templightvolume = 4.0
                Else
                    Delete local7
                EndIf
            Case "gatea"
                If (playerroom = local7\Field1) Then
                    If (0.0 = local7\Field2) Then
                        drawloading($00, $00)
                        local7\Field1\Field11[$00] = loadmesh("GFX\MAP\gateatunnel.b3d", $00)
                        positionentity(local7\Field1\Field11[$00], entityx(local7\Field1\Field2, $01), entityy(local7\Field1\Field2, $01), entityz(local7\Field1\Field2, $01), $00)
                        scaleentity(local7\Field1\Field11[$00], roomscale, roomscale, roomscale, $00)
                        entitytype(local7\Field1\Field11[$00], $01, $00)
                        entitypickmode(local7\Field1\Field11[$00], $03, $01)
                        entityparent(local7\Field1\Field11[$00], local7\Field1\Field2, $01)
                        drawloading($1E, $00)
                        For local1 = $00 To $13 Step $01
                            If (local7\Field1\Field10[local1] <> $00) Then
                                entityfx(local7\Field1\Field10[local1], $09)
                            EndIf
                        Next
                        hidedistance = 35.0
                        For local1 = $02 To $04 Step $01
                            local7\Field1\Field13[local1] = createnpc($07, local7\Field1\Field3, 100.0, local7\Field1\Field5)
                            local7\Field1\Field13[local1]\Field9 = 1.0
                        Next
                        music($05) = loadsound("SFX\Music\Satiate.ogg")
                        createconsolemsg("WARNING! Teleporting away from this area may cause bugs or crashing.")
                        positionentity(sky1, entityx(local7\Field1\Field2, $01), entityy(sky1, $01), entityz(local7\Field1\Field2, $01), $01)
                        positionentity(sky2, entityx(local7\Field1\Field2, $01), entityy(sky2, $01), entityz(local7\Field1\Field2, $01), $01)
                        translateentity(local7\Field1\Field2, 0.0, (12000.0 * roomscale), 0.0, $00)
                        translateentity(collider, 0.0, (12000.0 * roomscale), 0.0, $00)
                        drawloading($3C, $00)
                        For local5 = Each npcs
                            If (local5\Field5 = $08) Then
                                Delete local5
                            EndIf
                        Next
                        For local1 = $00 To $01 Step $01
                            local7\Field1\Field13[local1] = createnpc($03, entityx(local7\Field1\Field11[(local1 + $05)], $01), entityy(local7\Field1\Field11[(local1 + $05)], $01), entityz(local7\Field1\Field11[(local1 + $05)], $01))
                            local7\Field1\Field13[local1]\Field9 = 0.0
                            pointentity(local7\Field1\Field13[local1]\Field4, local7\Field1\Field11[$03], 0.0)
                        Next
                        For local1 = $07 To $08 Step $01
                            local7\Field1\Field13[local1] = createnpc($08, (entityx(local7\Field1\Field11[local1], $01) + 0.8), entityy(local7\Field1\Field11[local1], $01), (entityz(local7\Field1\Field11[local1], $01) + 0.8))
                            local7\Field1\Field13[local1]\Field9 = 5.0
                            local7\Field1\Field13[local1]\Field12 = $01
                            pointentity(local7\Field1\Field13[local1]\Field4, local7\Field1\Field11[$03], 0.0)
                        Next
                        For local1 = $05 To $06 Step $01
                            local7\Field1\Field13[local1] = createnpc($08, entityx(local7\Field1\Field11[(local1 + $02)], $01), entityy(local7\Field1\Field11[(local1 + $02)], $01), entityz(local7\Field1\Field11[(local1 + $02)], $01))
                            local7\Field1\Field13[local1]\Field9 = 5.0
                            local7\Field1\Field13[local1]\Field12 = $01
                            pointentity(local7\Field1\Field13[local1]\Field4, local7\Field1\Field11[$03], 0.0)
                        Next
                        If (contained106 <> 0) Then
                            local7\Field1\Field12[$02]\Field4 = $01
                            For local1 = $05 To $06 Step $01
                                positionentity(local7\Field1\Field13[local1]\Field4, (entityx(local7\Field1\Field11[$0F], $01) + ((Float (local1 - $06)) * 0.2)), entityy(local7\Field1\Field11[$0F], $01), (entityz(local7\Field1\Field11[$0F], $01) + ((Float (local1 - $06)) * 0.2)), $01)
                                resetentity(local7\Field1\Field13[local1]\Field4)
                            Next
                            For local1 = $05 To $08 Step $01
                                local7\Field1\Field13[local1]\Field9 = 2.0
                            Next
                        EndIf
                        local18 = entityx(local7\Field1\Field11[$09], $01)
                        local19 = entityz(local7\Field1\Field11[$09], $01)
                        freeentity(local7\Field1\Field11[$09])
                        local7\Field1\Field11[$09] = loadmesh("GFX\map\lightgunbase.b3d", $00)
                        scaleentity(local7\Field1\Field11[$09], roomscale, roomscale, roomscale, $00)
                        positionentity(local7\Field1\Field11[$09], local18, (12992.0 * roomscale), local19, $00)
                        local7\Field1\Field11[$0A] = loadmesh("GFX\map\lightgun.b3d", $00)
                        scaleentity(local7\Field1\Field11[$0A], roomscale, roomscale, roomscale, $00)
                        positionentity(local7\Field1\Field11[$0A], local18, (13280.0 * roomscale), (local19 - (176.0 * roomscale)), $01)
                        entityparent(local7\Field1\Field11[$0A], local7\Field1\Field11[$09], $01)
                        rotateentity(local7\Field1\Field11[$09], 0.0, 48.0, 0.0, $00)
                        rotateentity(local7\Field1\Field11[$0A], 40.0, 0.0, 0.0, $00)
                        For local2 = $00 To $14 Step $01
                            For local1 = $00 To $01 Step $01
                                translateentity(local7\Field1\Field13[local1]\Field4, 0.0, -0.04, 0.0, $00)
                            Next
                            For local1 = $05 To $08 Step $01
                                translateentity(local7\Field1\Field13[local1]\Field4, 0.0, -0.04, 0.0, $00)
                            Next
                        Next
                        resetentity(collider)
                        local7\Field2 = 1.0
                        tempsound = loadsound("SFX\106escape2.ogg")
                        drawloading($64, $00)
                        playsound(tempsound)
                    Else
                        shouldplay = $05
                        local7\Field2 = (local7\Field2 + fpsfactor)
                        hideentity(fog)
                        camerafogrange(camera, 5.0, 30.0)
                        camerafogcolor(camera, 200.0, 200.0, 200.0)
                        cameraclscolor(camera, 200.0, 200.0, 200.0)
                        camerarange(camera, 0.05, 30.0)
                        For local1 = $02 To $04 Step $01
                            If (local7\Field1\Field13[local1] <> Null) Then
                                If (2.0 > local7\Field1\Field13[local1]\Field9) Then
                                    positionentity(local7\Field1\Field13[local1]\Field4, (entityx(local7\Field1\Field11[$03], $01) + ((cos(((local7\Field2 / 10.0) + (Float ($78 * local1)))) * 6000.0) * roomscale)), (15000.0 * roomscale), (entityz(local7\Field1\Field11[$03], $01) + ((sin(((local7\Field2 / 10.0) + (Float ($78 * local1)))) * 6000.0) * roomscale)), $00)
                                    rotateentity(local7\Field1\Field13[local1]\Field4, 7.0, ((local7\Field2 / 10.0) + (Float ($78 * local1))), 20.0, $00)
                                EndIf
                            EndIf
                        Next
                        positiontexture(local7\Field1\Field11[$01], (local7\Field2 / 1500.0), 0.0)
                        positiontexture(local7\Field1\Field11[$02], (local7\Field2 / 2500.0), 0.0)
                        If (350.0 <= local7\Field2) Then
                            If (contained106 = $00) Then
                                If (350.0 > (local7\Field2 - fpsfactor)) Then
                                    curr106\Field9 = -0.1
                                    curr106\Field19 = 1.0
                                    setanimtime(curr106\Field0, 110.0, $00)
                                    positionentity(curr106\Field4, entityx(local7\Field1\Field11[$03], $01), (entityy(collider, $00) - 14.0), entityz(local7\Field1\Field11[$03], $01), $01)
                                    positionentity(curr106\Field0, entityx(local7\Field1\Field11[$03], $01), (entityy(collider, $00) - 14.0), entityz(local7\Field1\Field11[$03], $01), $01)
                                    local20 = createdecal($00, entityx(local7\Field1\Field11[$03], $01), (entityy(local7\Field1\Field11[$03], $01) + 0.01), entityz(local7\Field1\Field11[$03], $01), 90.0, (Float rand($168, $01)), 0.0)
                                    local20\Field2 = 0.05
                                    local20\Field1 = 0.001
                                    entityalpha(local20\Field0, 0.8)
                                    updatedecals()
                                    playsound(horrorsfx($05))
                                    playsound(decaysfx($00))
                                ElseIf (0.0 > curr106\Field9) Then
                                    hideentity(curr106\Field1)
                                    curr106\Field33 = 7000.0
                                    If (0.0 = curr106\Field11) Then
                                        If (curr106\Field32 <> $01) Then
                                            If (-10.0 >= curr106\Field9) Then
                                                local0 = entityy(curr106\Field4, $00)
                                                positionentity(curr106\Field4, entityx(curr106\Field4, $00), (entityy(local7\Field1\Field11[$03], $01) + 0.3), entityz(curr106\Field4, $00), $01)
                                                curr106\Field32 = findpath(curr106, entityx(local7\Field1\Field11[$04], $01), entityy(local7\Field1\Field11[$04], $01), entityz(local7\Field1\Field11[$04], $01))
                                                positionentity(curr106\Field4, entityx(curr106\Field4, $00), local0, entityz(curr106\Field4, $00), $01)
                                                curr106\Field34 = $01
                                                curr106\Field19 = 0.0
                                            Else
                                                positionentity(curr106\Field4, entityx(local7\Field1\Field11[$03], $01), entityy(local7\Field1\Field11[$03], $01), entityz(local7\Field1\Field11[$03], $01), $01)
                                                curr106\Field19 = 1.0
                                                animate2(curr106\Field0, animtime(curr106\Field0), $6E, $103, 0.15, $00)
                                                If (259.0 <= animtime(curr106\Field0)) Then
                                                    curr106\Field19 = 0.0
                                                EndIf
                                            EndIf
                                        Else
                                            For local1 = $02 To $04 Step $01
                                                local7\Field1\Field13[local1]\Field9 = 3.0
                                                local7\Field1\Field13[local1]\Field28 = entityx(curr106\Field0, $01)
                                                local7\Field1\Field13[local1]\Field29 = (entityy(curr106\Field0, $01) + 5.0)
                                                local7\Field1\Field13[local1]\Field30 = entityz(curr106\Field0, $01)
                                            Next
                                            For local1 = $05 To $08 Step $01
                                                local7\Field1\Field13[local1]\Field9 = 5.0
                                                local7\Field1\Field13[local1]\Field28 = entityx(curr106\Field0, $01)
                                                local7\Field1\Field13[local1]\Field29 = (entityy(curr106\Field0, $01) + 0.4)
                                                local7\Field1\Field13[local1]\Field30 = entityz(curr106\Field0, $01)
                                            Next
                                            local3 = createpivot($00)
                                            positionentity(local3, entityx(local7\Field1\Field11[$0A], $01), entityy(local7\Field1\Field11[$0A], $01), entityz(local7\Field1\Field11[$0A], $01), $00)
                                            pointentity(local3, curr106\Field4, 0.0)
                                            rotateentity(local7\Field1\Field11[$09], 0.0, curveangle(entityyaw(local3, $00), entityyaw(local7\Field1\Field11[$09], $00), 150.0), 0.0, $00)
                                            rotateentity(local7\Field1\Field11[$0A], curveangle(entitypitch(local3, $00), entitypitch(local7\Field1\Field11[$0A], $01), 200.0), entityyaw(local7\Field1\Field11[$09], $00), 0.0, $01)
                                            freeentity(local3)
                                            If (0.0 < fpsfactor) Then
                                                If (((50.0 >= ((local7\Field2 - fpsfactor) Mod 100.0)) And (50.0 < (local7\Field2 Mod 100.0))) <> 0) Then
                                                    local20 = createdecal($00, entityx(curr106\Field4, $01), (entityy(local7\Field1\Field11[$03], $01) + 0.01), entityz(curr106\Field4, $01), 90.0, (Float rand($168, $01)), 0.0)
                                                    local20\Field2 = 0.2
                                                    local20\Field1 = 0.004
                                                    local20\Field9 = 90000.0
                                                    entityalpha(local20\Field0, 0.8)
                                                    updatedecals()
                                                EndIf
                                            EndIf
                                        EndIf
                                    EndIf
                                    local0 = distance(entityx(curr106\Field4, $00), entityz(curr106\Field4, $00), entityx(local7\Field1\Field11[$04], $01), entityz(local7\Field1\Field11[$04], $01))
                                    curr106\Field18 = curvevalue(0.0, curr106\Field18, max((5.0 * local0), 2.0))
                                    If (15.0 > local0) Then
                                        If (local7\Field6 = $00) Then
                                            tempsound = loadsound("SFX\106escape.ogg")
                                            local7\Field6 = playsound(tempsound)
                                        EndIf
                                        If (0.4 > local0) Then
                                            curr106\Field32 = $00
                                            curr106\Field33 = 14000.0
                                            If (0.0 = curr106\Field11) Then
                                                setanimtime(curr106\Field0, 259.0, $00)
                                                If (local7\Field7 <> $00) Then
                                                    freesound(local7\Field7)
                                                EndIf
                                                local7\Field7 = loadsound("SFX\Oldman6.ogg")
                                                local7\Field5 = playsound2(local7\Field7, camera, curr106\Field4, 35.0, 1.0, $01)
                                            EndIf
                                            If (0.0 < fpsfactor) Then
                                                If (((50.0 >= ((local7\Field2 - fpsfactor) Mod 160.0)) And (50.0 < (local7\Field2 Mod 160.0))) <> 0) Then
                                                    local20 = createdecal($00, entityx(curr106\Field4, $01), (entityy(local7\Field1\Field11[$03], $01) + 0.01), entityz(curr106\Field4, $01), 90.0, (Float rand($168, $01)), 0.0)
                                                    local20\Field2 = 0.05
                                                    local20\Field1 = 0.004
                                                    local20\Field9 = 90000.0
                                                    entityalpha(local20\Field0, 0.8)
                                                    updatedecals()
                                                EndIf
                                            EndIf
                                            debuglog(("anim1: " + (Str animtime(curr106\Field0))))
                                            animate2(curr106\Field0, animtime(curr106\Field0), $103, $6E, -0.1, $00)
                                            debuglog(("anim2: " + (Str animtime(curr106\Field0))))
                                            curr106\Field11 = (curr106\Field11 + fpsfactor)
                                            positionentity(curr106\Field4, entityx(curr106\Field4, $01), curvevalue((entityy(local7\Field1\Field11[$03], $01) - (curr106\Field11 / 4500.0)), entityy(curr106\Field4, $01), 100.0), entityz(curr106\Field4, $01), $00)
                                            If (700.0 < curr106\Field11) Then
                                                curr106\Field9 = 100000.0
                                                local7\Field3 = 0.0
                                                For local1 = $05 To $08 Step $01
                                                    local7\Field1\Field13[local1]\Field9 = 2.0
                                                Next
                                                For local1 = $02 To $04 Step $01
                                                    local7\Field1\Field13[local1]\Field9 = 2.0
                                                Next
                                                hideentity(curr106\Field0)
                                            EndIf
                                        ElseIf (8.5 > local0) Then
                                            If (channelplaying(local7\Field6) = $00) Then
                                                tempsound = loadsound("SFX\LightGun.ogg")
                                                local7\Field6 = playsound(tempsound)
                                                local7\Field3 = 1.0
                                            EndIf
                                            If (0.0 < local7\Field3) Then
                                                local7\Field3 = (local7\Field3 + fpsfactor)
                                                If (525.0 <= local7\Field3) Then
                                                    If (525.0 > (local7\Field3 - fpsfactor)) Then
                                                        local4 = createparticle(entityx(curr106\Field0, $01), (entityy(curr106\Field0, $01) + 0.4), entityz(curr106\Field0, $01), $04, 7.0, 0.0, $1D5)
                                                        local4\Field8 = 0.0
                                                        local4\Field6 = 1.0
                                                        entityparent(local4\Field1, curr106\Field4, $01)
                                                        local4 = createparticle(entityx(local7\Field1\Field11[$0A], $01), entityy(local7\Field1\Field11[$0A], $01), entityz(local7\Field1\Field11[$0A], $01), $04, 2.0, 0.0, $1D5)
                                                        rotateentity(local4\Field1, entitypitch(local7\Field1\Field11[$0A], $01), entityyaw(local7\Field1\Field11[$0A], $01), 0.0, $01)
                                                        moveentity(local4\Field1, 0.0, (92.0 * roomscale), (512.0 * roomscale))
                                                        local4\Field8 = 0.0
                                                        local4\Field6 = 1.0
                                                        entityparent(local4\Field1, local7\Field1\Field11[$0A], $01)
                                                    ElseIf (1001.0 > local7\Field3) Then
                                                        camerashake = 0.5
                                                        lightflash = (((Float entityinview(local7\Field1\Field11[$0A], camera)) * 0.5) + 0.3)
                                                    EndIf
                                                EndIf
                                            EndIf
                                            For local1 = $00 To (rand($02, $10) - (Int local0)) Step $01
                                                local4 = createparticle(entityx(curr106\Field0, $01), (entityy(curr106\Field0, $01) + rnd(0.4, 0.9)), entityz(curr106\Field0, $00), $00, 0.006, -0.002, $28)
                                                local4\Field8 = 0.005
                                                local4\Field6 = 0.8
                                                local4\Field14 = -0.01
                                                rotateentity(local4\Field1, (- rnd(70.0, 110.0)), rnd(360.0, 0.0), 0.0, $00)
                                            Next
                                        EndIf
                                    EndIf
                                EndIf
                                If (0.0 = local7\Field4) Then
                                    If (1.0 > (Abs (entityy(collider, $00) - entityy(local7\Field1\Field11[$0B], $01)))) Then
                                        If (12.0 > distance(entityx(collider, $00), entityz(collider, $00), entityx(local7\Field1\Field11[$0B], $01), entityz(local7\Field1\Field11[$0B], $01))) Then
                                            curr106\Field9 = 100000.0
                                            hideentity(curr106\Field0)
                                            For local1 = $05 To $08 Step $01
                                                local7\Field1\Field13[local1]\Field9 = 3.0
                                                positionentity(local7\Field1\Field13[local1]\Field4, (entityx(local7\Field1\Field11[$0F], $01) + ((Float (local1 - $06)) * 0.3)), entityy(local7\Field1\Field11[$0F], $01), (entityz(local7\Field1\Field11[$0F], $01) + ((Float (local1 - $06)) * 0.3)), $01)
                                                resetentity(local7\Field1\Field13[local1]\Field4)
                                                local7\Field1\Field13[local1]\Field32 = findpath(local7\Field1\Field13[local1], entityx(collider, $00), (entityy(collider, $00) + 0.2), entityz(collider, $00))
                                                local7\Field1\Field13[local1]\Field33 = 140.0
                                                local7\Field1\Field13[local1]\Field21 = $1B58
                                            Next
                                            local7\Field1\Field13[$05]\Field14 = loadsound("SFX\MTF\ThereHeIs.ogg")
                                            playsound2(local7\Field1\Field13[$05]\Field14, camera, local7\Field1\Field13[$05]\Field4, 25.0, 1.0, $01)
                                            local7\Field1\Field12[$02]\Field5 = $01
                                            For local1 = $02 To $04 Step $01
                                                Delete local7\Field1\Field13[local1]
                                                local7\Field1\Field13[local1] = Null
                                            Next
                                            local7\Field4 = 1.0
                                        EndIf
                                    EndIf
                                ElseIf (1.0 = local7\Field4) Then
                                    For local1 = $05 To $08 Step $01
                                        If (4.0 < entitydistance(local7\Field1\Field13[local1]\Field4, collider)) Then
                                            local7\Field1\Field13[local1]\Field9 = 3.0
                                        EndIf
                                    Next
                                    If (1.0 > (Abs (entityy(collider, $00) - entityy(local7\Field1\Field11[$0B], $01)))) Then
                                        If (7.0 > distance(entityx(collider, $00), entityz(collider, $00), entityx(local7\Field1\Field11[$0B], $01), entityz(local7\Field1\Field11[$0B], $01))) Then
                                            local7\Field1\Field11[$0C] = loadmesh("GFX\npcs\s2.b3d", $00)
                                            entitycolor(local7\Field1\Field11[$0C], 0.0, 0.0, 0.0)
                                            scalemesh(local7\Field1\Field11[$0C], (1.0 / 66.5625), (1.0 / 66.5625), (1.0 / 66.5625))
                                            positionentity(local7\Field1\Field11[$0C], entityx(local7\Field1\Field11[$0B], $01), entityy(local7\Field1\Field11[$0B], $01), entityz(local7\Field1\Field11[$0B], $01), $00)
                                            local21 = copyentity(local7\Field1\Field11[$0C], $00)
                                            positionentity(local21, (entityx(local7\Field1\Field2, $01) - (3968.0 * roomscale)), entityy(local7\Field1\Field11[$0B], $01), (entityz(local7\Field1\Field2, $01) - (1920.0 * roomscale)), $00)
                                            local21 = copyentity(local7\Field1\Field11[$0C], $00)
                                            positionentity(local21, (entityx(local7\Field1\Field2, $01) - (4160.0 * roomscale)), entityy(local7\Field1\Field11[$0B], $01), (entityz(local7\Field1\Field2, $01) - (1920.0 * roomscale)), $00)
                                            local21 = copyentity(local7\Field1\Field11[$0C], $00)
                                            positionentity(local21, (entityx(local7\Field1\Field2, $01) - (4064.0 * roomscale)), entityy(local7\Field1\Field11[$0B], $01), (entityz(local7\Field1\Field2, $01) - (2112.0 * roomscale)), $00)
                                            If (tempsound <> $00) Then
                                                freesound(tempsound)
                                            EndIf
                                            tempsound = loadsound("SFX\Bell.ogg")
                                            local7\Field5 = playsound2(tempsound, camera, local7\Field1\Field11[$0C], 10.0, 1.0, $01)
                                            local4 = createparticle(entityx(local7\Field1\Field11[$0B], $01), entityy(camera, $01), entityz(local7\Field1\Field11[$0B], $01), $04, 8.0, 0.0, $32)
                                            local4\Field8 = 0.15
                                            local4\Field6 = 0.5
                                            local4 = createparticle(entityx(local7\Field1\Field11[$0B], $01), entityy(camera, $01), entityz(local7\Field1\Field11[$0B], $01), $04, 8.0, 0.0, $32)
                                            local4\Field8 = 0.25
                                            local4\Field6 = 0.5
                                            pointentity(local4\Field1, collider, 0.0)
                                            camerashake = 1.0
                                            lightflash = 1.0
                                            local7\Field4 = 2.0
                                        EndIf
                                    EndIf
                                Else
                                    local7\Field4 = (local7\Field4 + fpsfactor)
                                    pointentity(local7\Field1\Field11[$0C], collider, 0.0)
                                    rotateentity(local7\Field1\Field11[$0C], 0.0, entityyaw(local7\Field1\Field11[$0C], $00), 0.0, $00)
                                    stamina = -5.0
                                    blurtimer = (sin((local7\Field4 * 0.7)) * 1000.0)
                                    If (0.0 = killtimer) Then
                                        camerazoom(camera, ((sin((local7\Field4 * 0.8)) * 0.2) + 1.0))
                                        local0 = entitydistance(collider, local7\Field1\Field11[$0B])
                                        If (6.5 > local0) Then
                                            positionentity(collider, curvevalue(entityx(local7\Field1\Field11[$0B], $01), entityx(collider, $00), (local0 * 80.0)), entityy(collider, $00), curvevalue(entityz(local7\Field1\Field11[$00], $01), entityz(collider, $00), (local0 * 80.0)), $00)
                                        EndIf
                                    EndIf
                                    If (((50.0 < local7\Field4) And (230.0 > local7\Field4)) <> 0) Then
                                        camerashake = (sin((local7\Field4 - 50.0)) * 3.0)
                                        turnentity(local7\Field1\Field11[$0D], 0.0, (sin((local7\Field4 - 50.0)) * -0.85), 0.0, $01)
                                        turnentity(local7\Field1\Field11[$0E], 0.0, (sin((local7\Field4 - 50.0)) * 0.85), 0.0, $01)
                                        For local1 = $05 To $08 Step $01
                                            positionentity(local7\Field1\Field13[local1]\Field4, curvevalue(entityx(local7\Field1\Field12[$02]\Field2, $01), entityx(local7\Field1\Field13[local1]\Field4, $01), 50.0), entityy(local7\Field1\Field13[local1]\Field4, $01), curvevalue(entityz(local7\Field1\Field12[$02]\Field2, $01), entityz(local7\Field1\Field13[local1]\Field4, $01), 50.0), $01)
                                            resetentity(local7\Field1\Field13[local1]\Field4)
                                        Next
                                    EndIf
                                    If (230.0 <= local7\Field4) Then
                                        If (230.0 > (local7\Field4 - fpsfactor)) Then
                                            If (tempsound <> $00) Then
                                                freesound(tempsound)
                                            EndIf
                                            tempsound = loadsound("SFX\mst.ogg")
                                            local7\Field5 = playsound(tempsound)
                                        EndIf
                                        If (((channelplaying(local7\Field5) = $00) And (selectedending = "")) <> 0) Then
                                            tempsound = loadsound("SFX\Bell.ogg")
                                            playsound(tempsound)
                                            local4 = createparticle(entityx(local7\Field1\Field11[$0B], $01), entityy(camera, $01), entityz(local7\Field1\Field11[$0B], $01), $04, 8.0, 0.0, $32)
                                            local4\Field8 = 0.15
                                            local4\Field6 = 0.5
                                            local4 = createparticle(entityx(local7\Field1\Field11[$0B], $01), entityy(camera, $01), entityz(local7\Field1\Field11[$0B], $01), $04, 8.0, 0.0, $32)
                                            local4\Field8 = 0.25
                                            local4\Field6 = 0.5
                                            selectedending = "A1"
                                            godmode = $00
                                            noclip = $00
                                            killtimer = -0.1
                                            kill()
                                        EndIf
                                        If (selectedending <> "") Then
                                            camerashake = curvevalue(2.0, camerashake, 10.0)
                                            lightflash = curvevalue(2.0, lightflash, 8.0)
                                        EndIf
                                    EndIf
                                EndIf
                            ElseIf (0.0 = local7\Field3) Then
                                positionentity(local7\Field1\Field13[$05]\Field4, (entityx(local7\Field1\Field2, $01) - (3408.0 * roomscale)), (entityy(local7\Field1\Field2, $01) - (796.0 * roomscale)), (entityz(local7\Field1\Field2, $01) + 4976.0), $01)
                                resetentity(local7\Field1\Field13[$05]\Field4)
                                local7\Field3 = 1.0
                            EndIf
                        EndIf
                    EndIf
                EndIf
            Case "gateaentrance"
                If (playerroom = local7\Field1) Then
                    local22 = Null
                    For local6 = Each rooms
                        If (local6\Field7\Field4 = "gatea") Then
                            local22 = local6
                            Exit
                        EndIf
                    Next
                    local7\Field2 = updateelevators(local7\Field2, local7\Field1\Field12[$00], local22\Field12[$01], local7\Field1\Field11[$00], local7\Field1\Field11[$01], local7)
                    If (contained106 = $00) Then
                        If (((-1.5 > local7\Field2) And (-1.5 <= (local7\Field2 + fpsfactor))) <> 0) Then
                            playsound(oldmansfx($03))
                        EndIf
                    EndIf
                    If (4.0 > entitydistance(collider, local7\Field1\Field11[$01])) Then
                        local22\Field12[$01]\Field4 = $01
                        playerroom = local22
                        Delete local7
                    EndIf
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
                                If (-10.0 >= blinktimer) Then
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
                                local10 = createemitter(entityx(local7\Field1\Field11[local1], $01), entityy(local7\Field1\Field11[local1], $01), entityz(local7\Field1\Field11[local1], $01), $00)
                                turnentity(local10\Field0, 90.0, 0.0, 0.0, $01)
                                local10\Field10 = 5.0
                                local10\Field9 = 0.042
                                local10\Field11 = (1.0 / 400.0)
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
                    If (0.0 = local7\Field2) Then
                        music($04) = loadsound("SFX\Music\AI.ogg")
                        local7\Field1\Field13[$00] = createnpc($03, entityx(local7\Field1\Field11[$02], $01), (entityy(local7\Field1\Field11[$02], $01) + 0.5), entityz(local7\Field1\Field11[$02], $01))
                        pointentity(local7\Field1\Field13[$00]\Field4, local7\Field1\Field2, 0.0)
                        rotateentity(local7\Field1\Field13[$00]\Field4, 0.0, entityyaw(local7\Field1\Field13[$00]\Field4, $00), 0.0, $01)
                        setanimtime(local7\Field1\Field13[$00]\Field0, 28.0, $00)
                        local7\Field1\Field13[$00]\Field9 = 8.0
                        local7\Field2 = 1.0
                    EndIf
                    shouldplay = $04
                    If (remotedooron <> 0) Then
                        If (((50.0 < local7\Field1\Field12[$00]\Field7) And local7\Field1\Field12[$00]\Field5) <> 0) Then
                            local7\Field1\Field12[$00]\Field5 = $00
                        EndIf
                    ElseIf (10000.0 > local7\Field2) Then
                        If (1.0 = local7\Field2) Then
                            local7\Field2 = 2.0
                        ElseIf (2.0 = local7\Field2) Then
                            If (2.5 > entitydistance(local7\Field1\Field11[$00], collider)) Then
                                achv079 = $01
                                local7\Field2 = 3.0
                                local7\Field3 = 1.0
                                local7\Field7 = loadsound("SFX\079_1.ogg")
                                local7\Field5 = playsound(local7\Field7)
                            EndIf
                        ElseIf (3.0 = local7\Field2) Then
                            If (3500.0 > local7\Field2) Then
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
                        curr106\Field19 = 1.0
                        If (0.0 = local7\Field2) Then
                            drawloading($00, $01)
                            positionentity(sky1, entityx(local7\Field1\Field2, $01), entityy(sky1, $01), entityz(local7\Field1\Field2, $01), $01)
                            rotateentity(sky1, 0.0, entityyaw(local7\Field1\Field2, $01), 0.0, $01)
                            positionentity(sky2, entityx(local7\Field1\Field2, $01), entityy(sky2, $01), entityz(local7\Field1\Field2, $01), $01)
                            rotateentity(sky2, 0.0, entityyaw(local7\Field1\Field2, $01), 0.0, $01)
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
                                local23 = (millisecs() + $05)
                                Repeat
                                Until (millisecs() > local23)
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
                                                local10 = createemitter(entityx(local7\Field1\Field11[local1], $01), entityy(local7\Field1\Field11[local1], $01), entityz(local7\Field1\Field11[local1], $01), $00)
                                                turnentity(local10\Field0, 90.0, 0.0, 0.0, $01)
                                                local10\Field7 = playerroom
                                                local10\Field10 = 5.0
                                                local10\Field9 = 0.019
                                                local10\Field11 = 0.0027
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
                                    local11 = wrapangle(entityroll(local7\Field1\Field11[$0C], $00))
                                    turnentity(local7\Field1\Field11[$0C], 0.0, 0.0, ((((Abs sin(local11)) * 2.0) + 5.0) * fpsfactor), $00)
                                    If (((270.0 > local11) And (270.0 <= wrapangle(entityroll(local7\Field1\Field11[$0C], $00)))) <> 0) Then
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
                                        local10 = createemitter(entityx(local7\Field1\Field13[$03]\Field4, $00), entityy(local7\Field1\Field13[$03]\Field4, $00), entityz(local7\Field1\Field13[$03]\Field4, $00), $00)
                                        local10\Field7 = playerroom
                                        local10\Field10 = 45.0
                                        local10\Field4 = -0.18
                                        local10\Field5 = $190
                                        local10\Field12 = -0.002
                                        turnentity(local10\Field0, (Float (($14 * local1) + $FFFFFFB0)), 0.0, 0.0, $00)
                                        entityparent(local10\Field0, local7\Field1\Field13[$03]\Field4, $01)
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
            Case "room3servers"
                If (playerroom = local7\Field1) Then
                    If (((-8.0 > blinktimer) And (-12.0 < blinktimer)) <> 0) Then
                        If (2.0 < entitydistance(curr173\Field4, collider)) Then
                            local0 = 0.0
                            If (entityinview(curr173\Field4, camera) = $00) Then
                                Repeat
                                    local2 = rand($00, $02)
                                    positionentity(curr173\Field4, entityx(local7\Field1\Field11[local2], $01), entityy(local7\Field1\Field11[local2], $01), entityz(local7\Field1\Field11[local2], $01), $00)
                                    resetentity(curr173\Field4)
                                    local0 = (local0 + 1.0)
                                    If (((5.0 < local0) Or (-5.0 > blinktimer)) <> 0) Then
                                        Exit
                                    EndIf
                                Until (entityinview(curr173\Field4, camera) = $00)
                            EndIf
                        EndIf
                    EndIf
                EndIf
            Case "room2tesla"
                local2 = $01
                If (((245.0 < local7\Field3) And (6300.0 > local7\Field3)) <> 0) Then
                    local2 = $00
                EndIf
                If (((playerroom = local7\Field1) And local2) <> 0) Then
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
                                            camerashake = 1.0
                                            kill()
                                        EndIf
                                    Next
                                EndIf
                                If (-10.0 > curr106\Field9) Then
                                    For local1 = $00 To $02 Step $01
                                        If ((250.0 * roomscale) > distance(entityx(curr106\Field4, $00), entityz(curr106\Field4, $00), entityx(local7\Field1\Field11[local1], $01), entityz(local7\Field1\Field11[local1], $01))) Then
                                            showentity(light)
                                            lightflash = 0.3
                                            For local1 = $00 To $0A Step $01
                                                local4 = createparticle(entityx(curr106\Field4, $01), entityy(curr106\Field4, $01), entityz(curr106\Field4, $01), $00, 0.015, -0.2, $FA)
                                                local4\Field7 = 0.03
                                                local4\Field10 = -0.2
                                                local4\Field16 = 200.0
                                                local4\Field15 = 0.005
                                                local4\Field8 = 0.001
                                                rotateentity(local4\Field1, rnd(360.0, 0.0), rnd(360.0, 0.0), 0.0, $01)
                                            Next
                                            curr106\Field9 = -20000.0
                                            translateentity(curr106\Field4, 0.0, -50.0, 0.0, $01)
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
                If (0.0 = local7\Field3) Then
                    local2 = $00
                    For local5 = Each npcs
                        If (local5\Field5 = $08) Then
                            If (4.0 > (Abs (entityx(local5\Field4, $00) - entityx(local7\Field1\Field2, $01)))) Then
                                If (4.0 > (Abs (entityz(local5\Field4, $00) - entityz(local7\Field1\Field2, $01)))) Then
                                    local2 = $01
                                    If (0.0 = local7\Field3) Then
                                        local5\Field14 = loadsound("SFX\MTF\Tesla0.ogg")
                                        playsound2(local5\Field14, camera, local5\Field4, 10.0, 1.0, $01)
                                        playmtfmessage(local5\Field14)
                                        local7\Field7 = loadsound("SFX\MTF\Tesla1.ogg")
                                        local7\Field5 = playsound(local7\Field7)
                                        local5\Field19 = 700.0
                                        local7\Field3 = 7000.0
                                    EndIf
                                EndIf
                            EndIf
                        EndIf
                    Next
                    If (local2 = $00) Then
                        local7\Field3 = 245.0
                    EndIf
                Else
                    local7\Field3 = max((local7\Field3 - fpsfactor), 0.0)
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
                            local20 = createdecal($00, entityx(collider, $01), (-2493.0 * roomscale), entityz(collider, $01), 90.0, (Float rand($168, $01)), 0.0)
                            local20\Field2 = 0.05
                            local20\Field1 = 0.001
                            entityalpha(local20\Field0, 0.8)
                            updatedecals()
                            curr106\Field9 = -0.1
                            local7\Field2 = 2.0
                        ElseIf (0.9 > entitydistance(collider, local7\Field1\Field11[$01])) Then
                            local20 = createdecal($00, entityx(collider, $01), (-2493.0 * roomscale), entityz(collider, $01), 90.0, (Float rand($168, $01)), 0.0)
                            local20\Field2 = 0.05
                            local20\Field1 = 0.001
                            entityalpha(local20\Field0, 0.8)
                            updatedecals()
                            positionentity(curr106\Field4, entityx(local7\Field1\Field11[$01], $01), entityy(curr106\Field4, $00), entityz(local7\Field1\Field11[$01], $01), $00)
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
                        If (50.0 > local7\Field2) Then
                            curr106\Field19 = 1.0
                            positionentity(curr106\Field4, entityx(local7\Field1\Field11[$00], $01), (entityy(collider, $00) - 0.15), entityz(local7\Field1\Field11[$00], $01), $00)
                            pointentity(curr106\Field4, local7\Field1\Field11[$01], 0.0)
                            moveentity(curr106\Field4, 0.0, 0.0, ((entitydistance(local7\Field1\Field11[$00], local7\Field1\Field11[$01]) * 0.5) * (local7\Field2 / 50.0)))
                            animate2(curr106\Field0, animtime(curr106\Field0), $11C, $14D, 0.7, $01)
                        ElseIf (200.0 > local7\Field2) Then
                            curr106\Field19 = 1.0
                            animate2(curr106\Field0, animtime(curr106\Field0), $14E, $1EE, 0.2, $01)
                            positionentity(curr106\Field4, ((entityx(local7\Field1\Field11[$00], $01) + entityx(local7\Field1\Field11[$01], $01)) / 2.0), (entityy(collider, $00) - 0.15), ((entityz(local7\Field1\Field11[$00], $01) + entityz(local7\Field1\Field11[$01], $01)) / 2.0), $00)
                            rotateentity(curr106\Field4, 0.0, curvevalue(local7\Field2, entityyaw(curr106\Field4, $00), 30.0), 0.0, $01)
                            If (4.0 > entitydistance(curr106\Field4, collider)) Then
                                local3 = createpivot($00)
                                positionentity(local3, entityx(curr106\Field4, $00), entityy(curr106\Field4, $00), entityz(curr106\Field4, $00), $00)
                                pointentity(local3, collider, 0.0)
                                If (80.0 > wrapangle((entityyaw(local3, $00) - entityyaw(curr106\Field4, $00)))) Then
                                    curr106\Field9 = -11.0
                                    curr106\Field19 = 0.0
                                    playsound(horrorsfx($0A))
                                    local7\Field2 = 260.0
                                EndIf
                                freeentity(local3)
                            EndIf
                        ElseIf (250.0 > local7\Field2) Then
                            curr106\Field19 = 1.0
                            positionentity(curr106\Field4, entityx(local7\Field1\Field11[$00], $01), (entityy(collider, $00) - 0.15), entityz(local7\Field1\Field11[$00], $01), $00)
                            pointentity(curr106\Field4, local7\Field1\Field11[$01], 0.0)
                            moveentity(curr106\Field4, 0.0, 0.0, (entitydistance(local7\Field1\Field11[$00], local7\Field1\Field11[$01]) * ((local7\Field2 - 150.0) / 100.0)))
                            animate2(curr106\Field0, animtime(curr106\Field0), $11C, $14D, 0.7, $01)
                        EndIf
                        resetentity(curr106\Field4)
                        If (((0.3 < (local7\Field2 / 250.0)) And (0.3 >= ((local7\Field2 - (fpsfactor * 0.7)) / 250.0))) <> 0) Then
                            local7\Field5 = playsound(horrorsfx($06))
                            blurtimer = 800.0
                            local24 = createdecal($00, entityx(local7\Field1\Field11[$02], $01), entityy(local7\Field1\Field11[$02], $01), entityz(local7\Field1\Field11[$02], $01), 0.0, (Float (local7\Field1\Field6 - $5A)), rnd(360.0, 0.0))
                            local24\Field9 = 90000.0
                            local24\Field5 = 0.01
                            local24\Field4 = 0.005
                            local24\Field2 = 0.1
                            local24\Field1 = 0.003
                        EndIf
                        If (((0.65 < (local7\Field2 / 250.0)) And (0.65 >= ((local7\Field2 - (fpsfactor * 0.7)) / 250.0))) <> 0) Then
                            local24 = createdecal($00, entityx(local7\Field1\Field11[$03], $01), entityy(local7\Field1\Field11[$03], $01), entityz(local7\Field1\Field11[$03], $01), 0.0, (Float (local7\Field1\Field6 + $5A)), rnd(360.0, 0.0))
                            local24\Field9 = 90000.0
                            local24\Field5 = 0.01
                            local24\Field4 = 0.005
                            local24\Field2 = 0.1
                            local24\Field1 = 0.003
                        EndIf
                        If (250.0 < local7\Field2) Then
                            curr106\Field19 = 0.0
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
                        curr106\Field19 = 1.0
                        If (800.0 < local7\Field2) Then
                            If (-5.0 > blinktimer) Then
                                curr106\Field19 = 0.0
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
            Case "toiletguard"
                If (0.0 = local7\Field2) Then
                    If (0.0 >= local7\Field3) Then
                        local7\Field3 = 140.0
                        If (6.0 > (Abs (entityx(local7\Field1\Field2, $00) - entityx(collider, $00)))) Then
                            If (6.0 > (Abs (entityz(local7\Field1\Field2, $00) - entityz(collider, $00)))) Then
                                local7\Field2 = 1.0
                            EndIf
                        EndIf
                    Else
                        local7\Field3 = (local7\Field3 - fpsfactor)
                    EndIf
                ElseIf (1.0 = local7\Field2) Then
                    local7\Field1\Field13[$00] = createnpc($03, entityx(local7\Field1\Field11[$01], $01), (entityy(local7\Field1\Field11[$01], $01) + 0.5), entityz(local7\Field1\Field11[$01], $01))
                    pointentity(local7\Field1\Field13[$00]\Field4, local7\Field1\Field2, 0.0)
                    rotateentity(local7\Field1\Field13[$00]\Field4, 0.0, (entityyaw(local7\Field1\Field13[$00]\Field4, $00) - 20.0), 0.0, $01)
                    setanimtime(local7\Field1\Field13[$00]\Field0, 28.0, $00)
                    local7\Field1\Field13[$00]\Field9 = 8.0
                    local7\Field2 = 2.0
                Else
                    If (local7\Field7 = $00) Then
                        local7\Field7 = loadsound("SFX\SuicideGuard1.ogg")
                    EndIf
                    local7\Field5 = loopsound2(local7\Field7, local7\Field5, camera, local7\Field1\Field11[$01], 15.0, 1.0)
                    If (((4.0 > entitydistance(collider, local7\Field1\Field2)) And (1.0 < playersoundvolume)) <> 0) Then
                        local20 = createdecal($03, entityx(local7\Field1\Field11[$02], $01), 0.01, entityz(local7\Field1\Field11[$02], $01), 90.0, rnd(360.0, 0.0), 0.0)
                        local20\Field2 = 0.3
                        scalesprite(local20\Field0, local20\Field2, local20\Field2)
                        local20 = createdecal($11, entityx(local7\Field1\Field11[$02], $01), 0.01, entityz(local7\Field1\Field11[$02], $01), 90.0, rnd(360.0, 0.0), 0.0)
                        local20\Field2 = 0.1
                        local20\Field3 = 0.45
                        local20\Field1 = 0.0002
                        updatedecals()
                        stopchannel(local7\Field5)
                        freesound(local7\Field7)
                        local7\Field7 = loadsound("SFX\SuicideGuard2.ogg")
                        local7\Field5 = playsound2(local7\Field7, camera, local7\Field1\Field11[$01], 15.0, 1.0, $01)
                        Delete local7
                    EndIf
                EndIf
            Case "room3tunnel"
                If (0.0 = local7\Field2) Then
                    local7\Field1\Field13[$00] = createnpc($03, entityx(local7\Field1\Field11[$00], $01), (entityy(local7\Field1\Field11[$00], $01) + 0.5), entityz(local7\Field1\Field11[$00], $01))
                    pointentity(local7\Field1\Field13[$00]\Field4, local7\Field1\Field2, 0.0)
                    rotateentity(local7\Field1\Field13[$00]\Field4, 0.0, (entityyaw(local7\Field1\Field13[$00]\Field4, $00) + rnd(-20.0, 20.0)), 0.0, $01)
                    setanimtime(local7\Field1\Field13[$00]\Field0, 28.0, $00)
                    local7\Field1\Field13[$00]\Field9 = 8.0
                    local7\Field2 = 1.0
                    Delete local7
                EndIf
            Case "tunnel2smoke"
                If (0.0 = local7\Field2) Then
                    If (3.5 > distance(entityx(collider, $00), entityz(collider, $00), entityx(local7\Field1\Field2, $00), entityz(local7\Field1\Field2, $00))) Then
                        playsound2(burstsfx, camera, local7\Field1\Field2, 10.0, 1.0, $01)
                        For local1 = $00 To $01 Step $01
                            local10 = createemitter(entityx(local7\Field1\Field11[local1], $01), entityy(local7\Field1\Field11[local1], $01), entityz(local7\Field1\Field11[local1], $01), $00)
                            turnentity(local10\Field0, 90.0, 0.0, 0.0, $01)
                            entityparent(local10\Field0, local7\Field1\Field2, $01)
                            local10\Field10 = 3.0
                            local10\Field9 = 0.04
                            local10\Field11 = 0.0027
                            For local15 = 0.0 To 10.0 Step 1.0
                                local4 = createparticle(entityx(local10\Field0, $01), (448.0 * roomscale), entityz(local10\Field0, $01), rand(local10\Field2, local10\Field3), local10\Field1, local10\Field4, local10\Field5)
                                local4\Field8 = local10\Field9
                                rotateentity(local4\Field1, rnd(360.0, 0.0), rnd(360.0, 0.0), 0.0, $01)
                                local4\Field15 = local10\Field11
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
                            curr173\Field19 = 1.0
                        EndIf
                        lightblink = 1.0
                        local7\Field2 = (local7\Field2 + fpsfactor)
                    Else
                        blinktimer = 560.0
                        curr173\Field19 = 0.0
                        Delete local7
                    EndIf
                EndIf
            Case "coffin"
                local0 = entitydistance(camera, local7\Field1\Field11[$00])
                coffindistance = local0
                If (1.5 > coffindistance) Then
                    achv895 = $01
                EndIf
                If (0.0 = local7\Field2) Then
                    local7\Field1\Field13[$00] = createnpc($03, entityx(local7\Field1\Field11[$01], $01), (entityy(local7\Field1\Field11[$01], $01) + 0.5), entityz(local7\Field1\Field11[$01], $01))
                    pointentity(local7\Field1\Field13[$00]\Field4, local7\Field1\Field2, 0.0)
                    rotateentity(local7\Field1\Field13[$00]\Field4, 0.0, (entityyaw(local7\Field1\Field13[$00]\Field4, $00) + rnd(-10.0, 10.0)), 0.0, $01)
                    setanimtime(local7\Field1\Field13[$00]\Field0, 28.0, $00)
                    local7\Field1\Field13[$00]\Field9 = 8.0
                    local7\Field2 = 1.0
                EndIf
            Case "coffin106"
                local0 = entitydistance(camera, local7\Field1\Field11[$00])
                coffindistance = local0
                If (0.0 = local7\Field2) Then
                    local7\Field1\Field13[$00] = createnpc($03, entityx(local7\Field1\Field11[$01], $01), (entityy(local7\Field1\Field11[$01], $01) + 0.5), entityz(local7\Field1\Field11[$01], $01))
                    pointentity(local7\Field1\Field13[$00]\Field4, local7\Field1\Field2, 0.0)
                    rotateentity(local7\Field1\Field13[$00]\Field4, 0.0, (entityyaw(local7\Field1\Field13[$00]\Field4, $00) + rnd(-10.0, 10.0)), 0.0, $01)
                    setanimtime(local7\Field1\Field13[$00]\Field0, 28.0, $00)
                    local7\Field1\Field13[$00]\Field9 = 8.0
                    local7\Field2 = 1.0
                EndIf
                If (1.0 = local7\Field2) Then
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
                            local20 = createdecal($00, entityx(collider, $01), (-1531.0 * roomscale), entityz(collider, $01), 90.0, (Float rand($168, $01)), 0.0)
                            local20\Field2 = 0.05
                            local20\Field1 = 0.001
                            entityalpha(local20\Field0, 0.8)
                            updatedecals()
                            curr106\Field9 = -0.1
                            local7\Field2 = 2.0
                        EndIf
                    EndIf
                EndIf
            Case "tunnel106"
                If (contained106 = $00) Then
                    If (0.0 = local7\Field2) Then
                        If (((0.0 <= curr106\Field9) And (rand($0A, $01) = $01)) <> 0) Then
                            If (5.0 > entitydistance(camera, local7\Field1\Field2)) Then
                                local7\Field2 = 1.0
                            EndIf
                        EndIf
                    ElseIf (1.0 = local7\Field2) Then
                        local0 = distance(entityx(local7\Field1\Field2, $00), entityz(local7\Field1\Field2, $00), entityx(collider, $00), entityz(collider, $00))
                        If (((3.0 > local0) Or (rand($1B58, $01) = $01)) <> 0) Then
                            local7\Field2 = 2.0
                            local24 = createdecal($00, entityx(local7\Field1\Field2, $00), (445.0 * roomscale), entityz(local7\Field1\Field2, $00), -90.0, (Float rand($168, $01)), 0.0)
                            local24\Field2 = rnd(0.5, 0.7)
                            entityalpha(local24\Field0, 0.7)
                            local24\Field8 = $01
                            scalesprite(local24\Field0, local24\Field2, local24\Field2)
                            entityalpha(local24\Field0, rnd(0.7, 0.85))
                            playsound(horrorsfx($0A))
                        ElseIf (8.0 < local0) Then
                            If (rand($05, $01) = $01) Then
                                curr106\Field19 = 0.0
                                Delete local7
                            Else
                                curr106\Field19 = 0.0
                                curr106\Field9 = -10000.0
                                Delete local7
                            EndIf
                        EndIf
                    Else
                        local7\Field2 = (local7\Field2 + fpsfactor)
                        positionentity(curr106\Field4, (entityx(local7\Field1\Field2, $01) - (sin(((Float millisecs()) / 150.0)) / 4.0)), ((entityy(collider, $00) + 1.0) - min((sin(local7\Field2) * 1.5), 1.1)), (entityz(local7\Field1\Field2, $01) - (sin(((Float millisecs()) / 190.0)) / 4.0)), $00)
                        pointentity(curr106\Field4, camera, 0.0)
                        curr106\Field9 = -11.0
                        animate2(curr106\Field0, animtime(curr106\Field0), $37, $68, 0.1, $01)
                        curr106\Field19 = 1.0
                        If (180.0 < local7\Field2) Then
                            curr106\Field19 = 0.0
                            positionentity(curr106\Field4, entityx(curr106\Field4, $00), -3.0, entityz(curr106\Field4, $00), $01)
                            Delete local7
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
            Case "lockroom096"
                If (((playerroom = local7\Field1) And (0.0 = local7\Field2)) <> 0) Then
                    For local5 = Each npcs
                        If (local5\Field5 = $09) Then
                            local7\Field2 = 1.0
                            Delete local7
                            Exit
                        EndIf
                    Next
                    If (local7 <> Null) Then
                        local5 = createnpc($09, entityx(local7\Field1\Field2, $01), 0.3, entityz(local7\Field1\Field2, $01))
                        rotateentity(local5\Field4, 0.0, (Float (local7\Field1\Field6 + $2D)), 0.0, $01)
                        local7\Field2 = 1.0
                        Delete local7
                    EndIf
                EndIf
            Case "pocketdimension"
                If (playerroom = local7\Field1) Then
                    achvpd = $01
                    If (0.0 = local7\Field2) Then
                        camerafogcolor(camera, 0.0, 0.0, 0.0)
                        cameraclscolor(camera, 0.0, 0.0, 0.0)
                        local7\Field2 = 0.1
                    EndIf
                    If (music($03) = $00) Then
                        music($03) = loadsound("SFX\Music\PocketDimension.ogg")
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
                            local11 = ((local7\Field2 / 10.0) Mod 360.0)
                            positionentity(curr106\Field4, entityx(local7\Field1\Field2, $00), ((sin(((local7\Field2 / 14.0) + ((Float local1) * 20.0))) * 0.4) + 0.55), entityx(local7\Field1\Field2, $00), $00)
                            rotateentity(curr106\Field4, 0.0, local11, 0.0, $00)
                            moveentity(curr106\Field4, 0.0, 0.0, (6.0 - sin((local7\Field2 / 10.0))))
                            debuglog(("1: " + (Str animtime(curr106\Field0))))
                            animate2(curr106\Field0, animtime(curr106\Field0), $37, $68, 0.5, $01)
                            debuglog(("2: " + (Str animtime(curr106\Field0))))
                            debuglog("----")
                            rotateentity(curr106\Field4, 0.0, (local11 + 90.0), 0.0, $00)
                            curr106\Field19 = 1.0
                        EndIf
                    EndIf
                    If (0.3 > entitydistance(collider, curr106\Field4)) Then
                        curr106\Field19 = 0.0
                        curr106\Field9 = -11.0
                    EndIf
                    If (1.0 = local7\Field3) Then
                        local0 = entitydistance(collider, local7\Field1\Field11[$08])
                        If (local0 > (1700.0 * roomscale)) Then
                            blinktimer = -10.0
                            Select rand($02, $01)
                                Case $01
                                    local3 = createpivot($00)
                                    positionentity(local3, entityx(collider, $00), entityy(collider, $00), entityz(collider, $00), $00)
                                    pointentity(local3, local7\Field1\Field11[$08], 0.0)
                                    moveentity(local3, 0.0, 0.0, (local0 * 1.9))
                                    positionentity(collider, entityx(local3, $00), entityy(local3, $00), entityz(local3, $00), $00)
                                    resetentity(collider)
                                    local11 = (Float ((Int (entityyaw(local3, $00) / 90.0)) * $5A))
                                    rotateentity(local3, 0.0, local11, 0.0, $00)
                                    moveentity(local3, 0.0, 0.0, 0.8)
                                    positionentity(local7\Field1\Field11[$0A], entityx(local3, $00), 0.0, entityz(local3, $00), $00)
                                    rotateentity(local7\Field1\Field11[$0A], 0.0, entityyaw(local3, $00), 0.0, $01)
                                    positionentity(local3, entityx(local7\Field1\Field11[$08], $00), 0.0, entityz(local7\Field1\Field11[$08], $00), $00)
                                    rotateentity(local3, 0.0, ((Float (rand($01, $03) * $5A)) + local11), 0.0, $00)
                                    moveentity(local3, 0.0, 0.0, (520.0 * roomscale))
                                    positionentity(local7\Field1\Field11[$09], entityx(local3, $00), 0.0, entityz(local3, $00), $00)
                                    freeentity(local3)
                                Case $02
                                    local3 = createpivot($00)
                                    positionentity(local3, entityx(local7\Field1\Field2, $00), entityy(local7\Field1\Field2, $00), entityz(local7\Field1\Field2, $00), $00)
                                    local11 = wrapangle((getangle(entityx(local7\Field1\Field11[$08], $00), entityz(local7\Field1\Field11[$08], $00), entityx(collider, $00), entityz(collider, $00)) - 22.5))
                                    local11 = (Float (Int ((Float local3) / 90.0)))
                                    rotateentity(local3, 0.0, ((Float rand($00, $08)) * 45.0), 0.0, $00)
                                    moveentity(local3, 0.0, 0.0, (1400.0 * roomscale))
                                    positionentity(collider, entityx(local3, $00), entityy(collider, $00), entityz(local3, $00), $00)
                                    rotateentity(collider, 0.0, ((entityyaw(collider, $00) - (local11 * 45.0)) - 270.0), 0.0, $01)
                                    moveentity(local3, 0.0, 0.0, 0.8)
                                    positionentity(local7\Field1\Field11[$0A], entityx(local3, $00), 0.0, entityz(local3, $00), $00)
                                    rotateentity(local7\Field1\Field11[$0A], 0.0, entityyaw(local3, $00), 0.0, $01)
                                    resetentity(collider)
                                    freeentity(local3)
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
                                    local3 = createpivot($00)
                                    positionentity(local3, entityx(collider, $00), entityy(collider, $00), entityz(collider, $00), $00)
                                    pointentity(local3, local7\Field1\Field2, 0.0)
                                    moveentity(local3, 0.0, 0.0, (local0 * 1.9))
                                    positionentity(collider, entityx(local3, $00), entityy(collider, $00), entityz(local3, $00), $00)
                                    resetentity(collider)
                                    moveentity(local3, 0.0, 0.0, 0.8)
                                    positionentity(local7\Field1\Field11[$0A], entityx(local3, $00), 0.0, entityz(local3, $00), $00)
                                    rotateentity(local7\Field1\Field11[$0A], 0.0, entityyaw(local3, $00), 0.0, $01)
                                    freeentity(local3)
                                Case $08,$09,$0A,$0B,$0C
                                    local7\Field3 = 1.0
                                    blinktimer = -10.0
                                    playsound(oldmansfx($03))
                                    local3 = createpivot($00)
                                    positionentity(local3, entityx(local7\Field1\Field11[$08], $00), entityy(local7\Field1\Field11[$08], $00), entityz(local7\Field1\Field11[$08], $00), $00)
                                    local11 = wrapangle((getangle(entityx(local7\Field1\Field2, $00), entityz(local7\Field1\Field2, $00), entityx(collider, $00), entityz(collider, $00)) - 22.5))
                                    local11 = (Float (Int (local11 / 45.0)))
                                    moveentity(local3, 0.0, 0.0, (-1400.0 * roomscale))
                                    positionentity(collider, entityx(local3, $00), entityy(collider, $00), entityz(local3, $00), $00)
                                    rotateentity(collider, 0.0, ((entityyaw(collider, $00) - (local11 * 45.0)) - 270.0), 0.0, $01)
                                    resetentity(collider)
                                    moveentity(local3, 0.0, 0.0, -0.8)
                                    positionentity(local7\Field1\Field11[$0A], entityx(local3, $00), 0.0, entityz(local3, $00), $00)
                                    rotateentity(local7\Field1\Field11[$0A], 0.0, entityyaw(local3, $00), 0.0, $01)
                                    positionentity(local3, entityx(local7\Field1\Field11[$08], $00), 0.0, entityz(local7\Field1\Field11[$08], $00), $00)
                                    rotateentity(local3, 0.0, ((Float (rand($01, $03) * $5A)) + local11), 0.0, $00)
                                    moveentity(local3, 0.0, 0.0, (520.0 * roomscale))
                                    positionentity(local7\Field1\Field11[$09], entityx(local3, $00), 0.0, entityz(local3, $00), $00)
                                    freeentity(local3)
                                Case $0D,$0E,$0F
                                    blurtimer = 500.0
                                    positionentity(collider, entityx(local7\Field1\Field2, $00), 0.5, entityz(local7\Field1\Field2, $00), $00)
                                Case $10,$11
                                    blurtimer = 1500.0
                                    For local6 = Each rooms
                                        If (local6\Field7\Field4 = "room106") Then
                                            debuglog("106")
                                            local7\Field2 = 0.0
                                            local7\Field3 = 0.0
                                            freesound(music($03))
                                            music($03) = $00
                                            positionentity(collider, entityx(local6\Field2, $00), 0.4, entityz(local6\Field2, $00), $00)
                                            resetentity(collider)
                                            curr106\Field9 = 10000.0
                                            curr106\Field19 = 0.0
                                            Exit
                                        EndIf
                                    Next
                                Case $12,$13
                                    blurtimer = 1500.0
                                    For local6 = Each rooms
                                        If (local6\Field7\Field4 = "room2offices") Then
                                            debuglog("room2offices")
                                            local7\Field2 = 0.0
                                            local7\Field3 = 0.0
                                            freesound(music($03))
                                            music($03) = $00
                                            positionentity(collider, entityx(local6\Field2, $00), 0.4, entityz(local6\Field2, $00), $00)
                                            resetentity(collider)
                                            curr106\Field19 = 0.0
                                            Exit
                                        EndIf
                                    Next
                                Case $14,$15,$16,$17
                                    debuglog("tornihuone")
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
                            local11 = (entityyaw(camera, $01) + rnd(150.0, 210.0))
                            local4 = createparticle((entityx(collider, $00) + (cos(local11) * 7.5)), 0.0, (entityz(collider, $00) + (sin(local11) * 7.5)), $03, 4.0, 0.0, $9C4)
                            entityblend(local4\Field0, $02)
                            local4\Field8 = 0.01
                            local4\Field15 = 0.0
                            pointentity(local4\Field1, camera, 0.0)
                            turnentity(local4\Field1, 0.0, 145.0, 0.0, $01)
                            turnentity(local4\Field1, (Float rand($0A, $14)), 0.0, 0.0, $01)
                        EndIf
                        If (12.0 < local7\Field3) Then
                            curr106\Field19 = 1.0
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
                            curr106\Field19 = 0.0
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
                local27 = $00
                local28 = $00
                If (soundtransmission <> 0) Then
                    local7\Field4 = min((local7\Field4 + fpsfactor), 4000.0)
                    If (channelplaying(local7\Field5) = $00) Then
                        local7\Field5 = playsound(radiostatic)
                    EndIf
                EndIf
                If (playerroom = local7\Field1) Then
                    showentity(local7\Field1\Field13[$00]\Field0)
                    shouldplay = $42
                    If (0.0 = local7\Field1\Field13[$00]\Field19) Then
                        animate2(local7\Field1\Field13[$00]\Field0, animtime(local7\Field1\Field13[$00]\Field0), $0E, $12, 0.01, $00)
                        If (18.0 = animtime(local7\Field1\Field13[$00]\Field0)) Then
                            local7\Field1\Field13[$00]\Field19 = 1.0
                        EndIf
                    Else
                        animate2(local7\Field1\Field13[$00]\Field0, animtime(local7\Field1\Field13[$00]\Field0), $12, $0E, -0.01, $00)
                        If (14.0 = animtime(local7\Field1\Field13[$00]\Field0)) Then
                            local7\Field1\Field13[$00]\Field19 = 0.0
                        EndIf
                    EndIf
                    positionentity(local7\Field1\Field13[$00]\Field4, entityx(local7\Field1\Field11[$05], $01), entityy(local7\Field1\Field11[$05], $01), entityz(local7\Field1\Field11[$05], $01), $01)
                    rotateentity(local7\Field1\Field13[$00]\Field4, entitypitch(local7\Field1\Field11[$05], $01), entityyaw(local7\Field1\Field11[$05], $01), 0.0, $01)
                    resetentity(local7\Field1\Field13[$00]\Field4)
                    local2 = (Int local7\Field3)
                    local29 = updatelever(local7\Field1\Field11[$01], (((-990.0 * roomscale) > entityy(local7\Field1\Field11[$06], $01)) And ((-1275.0 * roomscale) < entityy(local7\Field1\Field11[$06], $01))))
                    If (((grabbedentity = local7\Field1\Field11[$01]) And (drawhandicon = $01)) <> 0) Then
                        local7\Field3 = (Float local29)
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
                    ElseIf (1.0 = local7\Field2) Then
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
                        If (2500.0 <= local7\Field4) Then
                            shouldplay = $01
                            positionentity(curr106\Field4, entityx(local7\Field1\Field11[$05], $01), ((((min((local7\Field4 - 2500.0), 800.0) / 320.0) * 108.0) + 700.0) * roomscale), entityz(local7\Field1\Field11[$05], $01), $00)
                            hideentity(curr106\Field1)
                            rotateentity(curr106\Field4, 0.0, (entityyaw(local7\Field1\Field11[$05], $01) + 180.0), 0.0, $01)
                            curr106\Field9 = -11.0
                            animate2(curr106\Field0, animtime(curr106\Field0), $CE, $FA, 0.1, $01)
                            curr106\Field19 = 1.0
                            If (2500.0 > (local7\Field4 - fpsfactor)) Then
                                local24 = createdecal($00, entityx(local7\Field1\Field11[$05], $01), (936.0 * roomscale), entityz(local7\Field1\Field11[$05], $01), 90.0, 0.0, rnd(360.0, 0.0))
                                local24\Field9 = 90000.0
                                local24\Field5 = 0.01
                                local24\Field4 = 0.005
                                local24\Field2 = 0.1
                                local24\Field1 = 0.003
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
                                local24 = createdecal($00, entityx(local7\Field1\Field11[$07], $01), entityy(local7\Field1\Field11[$07], $01), entityz(local7\Field1\Field11[$07], $01), 0.0, 0.0, 0.0)
                                rotateentity(local24\Field0, (entitypitch(local7\Field1\Field11[$07], $01) + (Float rand($0A, $14))), (entityyaw(local7\Field1\Field11[$07], $01) + 30.0), entityroll(local24\Field0, $00), $00)
                                moveentity(local24\Field0, 0.0, 0.0, 0.15)
                                rotateentity(local24\Field0, entitypitch(local7\Field1\Field11[$07], $01), entityyaw(local7\Field1\Field11[$07], $01), entityroll(local24\Field0, $00), $00)
                                entityparent(local24\Field0, local7\Field1\Field11[$07], $01)
                                local24\Field9 = 90000.0
                                local24\Field5 = 0.01
                                local24\Field4 = 0.005
                                local24\Field2 = 0.05
                                local24\Field1 = 0.002
                            ElseIf (3200.0 < local7\Field4) Then
                                positionentity(local7\Field1\Field11[$08], 0.0, 1000.0, 0.0, $01)
                                positionentity(local7\Field1\Field11[$07], 0.0, 1000.0, 0.0, $01)
                                If (1.0 = local7\Field3) Then
                                    contained106 = $01
                                Else
                                    positionentity(curr106\Field4, entityx(local7\Field1\Field11[$06], $01), entityy(local7\Field1\Field11[$06], $01), entityz(local7\Field1\Field11[$06], $01), $00)
                                    contained106 = $00
                                    showentity(curr106\Field0)
                                    curr106\Field19 = 0.0
                                    curr106\Field9 = -11.0
                                    local7\Field2 = 2.0
                                    Exit
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
                EndIf
            Case "room2offices2"
                If (playerroom = local7\Field1) Then
                    If (((-8.0 > blinktimer) And (-12.0 < blinktimer)) <> 0) Then
                        local2 = rand($01, $04)
                        positionentity(local7\Field1\Field11[$00], entityx(local7\Field1\Field11[local2], $01), entityy(local7\Field1\Field11[local2], $01), entityz(local7\Field1\Field11[local2], $01), $01)
                        rotateentity(local7\Field1\Field11[$00], 0.0, rnd(360.0, 0.0), 0.0, $00)
                    EndIf
                EndIf
            Case "room3pit"
                If (playerroom = local7\Field1) Then
                    If (local7\Field1\Field11[$02] = $00) Then
                        local7\Field1\Field11[$02] = loadmesh("GFX\npcs\duck_low_res.b3d", $00)
                        scaleentity(local7\Field1\Field11[$02], 0.07, 0.07, 0.07, $00)
                        local13 = loadtexture("GFX\npcs\duck1.png", $01)
                        entitytexture(local7\Field1\Field11[$02], local13, $00, $00)
                        positionentity(local7\Field1\Field11[$02], entityx(local7\Field1\Field11[$00], $01), entityy(local7\Field1\Field11[$00], $01), entityz(local7\Field1\Field11[$00], $01), $00)
                        pointentity(local7\Field1\Field11[$02], local7\Field1\Field2, 0.0)
                        rotateentity(local7\Field1\Field11[$02], 0.0, entityyaw(local7\Field1\Field11[$02], $01), 0.0, $01)
                        local7\Field7 = loadsound("SFX\sax.ogg")
                    ElseIf (entityinview(local7\Field1\Field11[$02], camera) = $00) Then
                        local7\Field2 = (local7\Field2 + fpsfactor)
                        If (((rand($C8, $01) = $01) And (300.0 < local7\Field2)) <> 0) Then
                            local7\Field2 = 0.0
                            local7\Field5 = playsound2(local7\Field7, camera, local7\Field1\Field11[$02], 6.0, 1.0, $01)
                        EndIf
                    ElseIf (local7\Field5 <> $00) Then
                        If (channelplaying(local7\Field5) <> 0) Then
                            stopchannel(local7\Field5)
                        EndIf
                    EndIf
                EndIf
            Case "room2closets"
                If (playerroom = local7\Field1) Then
                    If (((-8.0 > blinktimer) And (-12.0 < blinktimer)) <> 0) Then
                        pointentity(local7\Field1\Field11[$00], camera, 0.0)
                        rotateentity(local7\Field1\Field11[$00], 0.0, entityyaw(local7\Field1\Field11[$00], $01), 0.0, $01)
                    EndIf
                    If (0.0 = local7\Field3) Then
                        local7\Field2 = curvevalue(0.0, local7\Field2, 15.0)
                        If (rand($320, $01) = $01) Then
                            local7\Field3 = 1.0
                        EndIf
                    Else
                        local7\Field2 = ((fpsfactor * 0.5) + local7\Field2)
                        If (360.0 < local7\Field2) Then
                            local7\Field2 = 0.0
                        EndIf
                        If (rand($4B0, $01) = $01) Then
                            local7\Field3 = 0.0
                        EndIf
                    EndIf
                    positionentity(local7\Field1\Field11[$00], entityx(local7\Field1\Field11[$00], $01), (((160.0 * roomscale) + 0.05) + (sin((local7\Field2 + 270.0)) * 0.05)), entityz(local7\Field1\Field11[$00], $01), $01)
                EndIf
            Case "room2offices3"
                If (playerroom = local7\Field1) Then
                    local7\Field2 = (local7\Field2 + fpsfactor)
                    If (700.0 < local7\Field2) Then
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
                        local30 = entitypitch(local7\Field1\Field11[local1], $00)
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
                            If (83.0 >= local30) Then
                                playsound2(leversfx, camera, local7\Field1\Field11[local1], 10.0, 1.0, $01)
                            EndIf
                            If (local1 = $03) Then
                                secondarylighton = curvevalue(1.0, secondarylighton, 10.0)
                                If (83.0 >= local30) Then
                                    playsound2(lightsfx, camera, local7\Field1\Field11[local1], 10.0, 1.0, $01)
                                EndIf
                            Else
                                remotedooron = $01
                            EndIf
                        ElseIf (-83.0 > entitypitch(local7\Field1\Field11[local1], $00)) Then
                            If (-83.0 <= local30) Then
                                playsound2(leversfx, camera, local7\Field1\Field11[local1], 10.0, 1.0, $01)
                            EndIf
                            If (local1 = $03) Then
                                If (-83.0 <= local30) Then
                                    playsound2(lightsfx, camera, local7\Field1\Field11[local1], 10.0, 1.0, $01)
                                    For local6 = Each rooms
                                        For local15 = 0.0 To 19.0 Step 1.0
                                            If (local6\Field10[(Int local15)] <> $00) Then
                                                hideentity(local6\Field10[(Int local15)])
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
            Case "forest"
                If (playerroom = local7\Field1) Then
                    If (0.0 = local7\Field2) Then
                        local7\Field1\Field11[$00] = loadanimmesh("GFX\map\forestterrain.b3d", $00)
                        scaleentity(local7\Field1\Field11[$00], roomscale, roomscale, roomscale, $00)
                        positionentity(local7\Field1\Field11[$00], local7\Field1\Field3, 0.0, local7\Field1\Field5, $00)
                        entitytype(local7\Field1\Field11[$00], $01, $00)
                        entitypickmode(local7\Field1\Field11[$00], $03, $01)
                        For local31 = $01 To countchildren(local7\Field1\Field11[$00]) Step $01
                            local32 = getchild(local7\Field1\Field11[$00], local31)
                            entityautofade(local32, 2.0, 6.0)
                        Next
                        local7\Field2 = 1.0
                    Else
                        camerafogrange(camera, 2.0, 5.0)
                        camerafogcolor(camera, 130.0, 171.0, 196.0)
                        cameraclscolor(camera, 130.0, 171.0, 196.0)
                        camerarange(camera, 0.05, 10.0)
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
                                    local11 = wrapangle(entityroll(local7\Field1\Field11[$00], $00))
                                    If (181.0 < local11) Then
                                        drawarrowicon($03) = $01
                                    EndIf
                                    drawarrowicon($01) = $01
                                    If (90.0 > local11) Then
                                        rotateentity(grabbedentity, 0.0, 0.0, 361.0, $00)
                                    ElseIf (180.0 > local11) Then
                                        rotateentity(grabbedentity, 0.0, 0.0, 180.0, $00)
                                    EndIf
                                    If (((181.0 > local11) And (90.0 < local11)) <> 0) Then
                                        For local9 = Each items
                                            If (((local9\Field0 <> $00) And (local9\Field9 = $00)) <> 0) Then
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
                                    local11 = wrapangle(entityroll(local7\Field1\Field11[$01], $00))
                                    drawarrowicon($03) = $01
                                    drawarrowicon($01) = $01
                                    If (90.0 < local11) Then
                                        If (180.0 > local11) Then
                                            rotateentity(grabbedentity, 0.0, 0.0, 90.0, $00)
                                        ElseIf (270.0 > local11) Then
                                            rotateentity(grabbedentity, 0.0, 0.0, 270.0, $00)
                                        EndIf
                                    EndIf
                                EndIf
                            EndIf
                        EndIf
                    Else
                        grabbedentity = $00
                    EndIf
                    local33 = ""
                    If (grabbedentity <> local7\Field1\Field11[$01]) Then
                        local11 = wrapangle(entityroll(local7\Field1\Field11[$01], $00))
                        If (22.5 > local11) Then
                            local11 = 0.0
                            local33 = "1:1"
                        ElseIf (67.5 > local11) Then
                            local11 = 40.0
                            local33 = "coarse"
                        ElseIf (180.0 > local11) Then
                            local11 = 90.0
                            local33 = "rough"
                        ElseIf (337.5 < local11) Then
                            local11 = -1.0
                            local33 = "1:1"
                        ElseIf (292.5 < local11) Then
                            local11 = -40.0
                            local33 = "fine"
                        Else
                            local11 = -90.0
                            local33 = "very fine"
                        EndIf
                        rotateentity(local7\Field1\Field11[$01], 0.0, 0.0, curvevalue(local11, entityroll(local7\Field1\Field11[$01], $00), 20.0), $00)
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
                        local7\Field1\Field12[$01]\Field5 = $00
                        If (140.0 < local7\Field2) Then
                            local7\Field1\Field12[$00]\Field5 = $00
                        EndIf
                        If ((170.0 * roomscale) > distance(entityx(collider, $00), entityz(collider, $00), entityx(local7\Field1\Field11[$02], $01), entityz(local7\Field1\Field11[$02], $01))) Then
                            If (((local33 = "rough") Or (local33 = "coarse")) <> 0) Then
                                If (((182.0 < local7\Field2) And (182.0 > (local7\Field2 - fpsfactor2))) <> 0) Then
                                    playsound(death914sfx)
                                EndIf
                            EndIf
                            If (210.0 < local7\Field2) Then
                                Select local33
                                    Case "rough"
                                        killtimer = min(-1.0, killtimer)
                                        blinktimer = -10.0
                                        If (local7\Field5 <> $00) Then
                                            stopchannel(local7\Field5)
                                        EndIf
                                    Case "coarse"
                                        blinktimer = -10.0
                                        If (210.0 > (local7\Field2 - fpsfactor2)) Then
                                            playsound(use914sfx)
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
                        If (420.0 < local7\Field2) Then
                            rotateentity(local7\Field1\Field11[$00], entitypitch(local7\Field1\Field11[$00], $00), entityyaw(local7\Field1\Field11[$00], $00), curveangle(0.0, entityroll(local7\Field1\Field11[$00], $00), 10.0), $00)
                        Else
                            rotateentity(local7\Field1\Field11[$00], entitypitch(local7\Field1\Field11[$00], $00), entityyaw(local7\Field1\Field11[$00], $00), 180.0, $00)
                        EndIf
                        If (840.0 < local7\Field2) Then
                            For local9 = Each items
                                If (((local9\Field0 <> $00) And (local9\Field9 = $00)) <> 0) Then
                                    If ((180.0 * roomscale) > distance(entityx(local9\Field0, $00), entityz(local9\Field0, $00), entityx(local7\Field1\Field11[$02], $01), entityz(local7\Field1\Field11[$02], $01))) Then
                                        use914(local9, local33, entityx(local7\Field1\Field11[$03], $01), entityy(local7\Field1\Field11[$03], $01), entityz(local7\Field1\Field11[$03], $01))
                                    EndIf
                                EndIf
                            Next
                            If ((160.0 * roomscale) > distance(entityx(collider, $00), entityz(collider, $00), entityx(local7\Field1\Field11[$02], $01), entityz(local7\Field1\Field11[$02], $01))) Then
                                Select local33
                                    Case "coarse"
                                        injuries = 4.0
                                        msg = "You notice countless small incisions all around your body. They're bleeding heavily."
                                        msgtimer = 560.0
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
