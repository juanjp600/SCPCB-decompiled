Function updatesecuritycams%()
    Local local0.securitycams
    Local local1%
    Local local2#
    Local local3%
    movelock = $00
    For local0 = Each securitycams
        local1 = $00
        If (4.0 > (Abs (entityx(collider, $00) - entityx(local0\Field0, $01)))) Then
            If (4.0 > (Abs (entityz(collider, $00) - entityz(local0\Field0, $01)))) Then
                If (4.0 > entitydistance(camera, local0\Field0)) Then
                    local1 = $01
                EndIf
            EndIf
        EndIf
        If (local1 = $00) Then
            If (local0\Field4 <> $00) Then
                If (3.0 > (Abs (entityx(collider, $00) - entityx(local0\Field4, $01)))) Then
                    If (3.0 > (Abs (entityz(collider, $00) - entityz(local0\Field4, $01)))) Then
                        If (3.0 > entitydistance(camera, local0\Field4)) Then
                            local1 = $01
                        EndIf
                    EndIf
                EndIf
            EndIf
        EndIf
        If (local1 = $01) Then
            If (local0\Field19 <> 0) Then
                pointentity(local0\Field3, camera, 0.0)
                local2 = entitypitch(local0\Field3, $00)
                rotateentity(local0\Field0, 0.0, curveangle(entityyaw(local0\Field3, $00), entityyaw(local0\Field0, $00), 75.0), 0.0, $00)
                If (40.0 > local2) Then
                    local2 = 40.0
                EndIf
                If (70.0 < local2) Then
                    local2 = 70.0
                EndIf
                rotateentity(local0\Field3, curveangle(local2, entitypitch(local0\Field3, $00), 75.0), entityyaw(local0\Field0, $00), 0.0, $00)
                positionentity(local0\Field3, entityx(local0\Field0, $01), (entityy(local0\Field0, $01) - 0.083), entityz(local0\Field0, $01), $00)
                rotateentity(local0\Field3, entitypitch(local0\Field3, $00), entityyaw(local0\Field0, $00), 0.0, $00)
            Else
                If (0.0 < local0\Field12) Then
                    If (local0\Field23 = $00) Then
                        local0\Field13 = ((0.2 * fpsfactor) + local0\Field13)
                        If (local0\Field13 > (local0\Field12 * 1.3)) Then
                            local0\Field23 = $01
                        EndIf
                    Else
                        local0\Field13 = (local0\Field13 - (0.2 * fpsfactor))
                        If (local0\Field13 < ((- local0\Field12) * 1.3)) Then
                            local0\Field23 = $00
                        EndIf
                    EndIf
                EndIf
                rotateentity(local0\Field0, 0.0, (((Float local0\Field18\Field5) + local0\Field11) + max(min(local0\Field13, local0\Field12), (- local0\Field12))), 0.0, $00)
                positionentity(local0\Field3, entityx(local0\Field0, $01), (entityy(local0\Field0, $01) - 0.083), entityz(local0\Field0, $01), $00)
                rotateentity(local0\Field3, entitypitch(local0\Field3, $00), entityyaw(local0\Field0, $00), 0.0, $00)
                positionentity(local0\Field8, entityx(local0\Field3, $01), entityy(local0\Field3, $01), entityz(local0\Field3, $01), $00)
                rotateentity(local0\Field8, entitypitch(local0\Field3, $00), entityyaw(local0\Field3, $00), 0.0, $00)
                moveentity(local0\Field8, 0.0, 0.0, 0.1)
            EndIf
            local0\Field14 = (local0\Field14 + fpsfactor)
            If ((local0\Field7 And (12.0 <= local0\Field14)) <> 0) Then
                local0\Field17 = $00
                If (entityinview(local0\Field4, camera) <> 0) Then
                    If (entityvisible(camera, local0\Field4) <> 0) Then
                        If (-5.0 < blinktimer) Then
                            local0\Field17 = $01
                            If (local0\Field20 <> 0) Then
                                If (-5.0 < blinktimer) Then
                                    sanity = (sanity - (fpsfactor * 16.0))
                                EndIf
                                If (-1000.0 > sanity) Then
                                    kill()
                                EndIf
                            EndIf
                            hideentity(camera)
                            showentity(local0\Field8)
                            cls($01, $01)
                            renderworld(1.0)
                            copyrect($00, $00, $200, $200, $00, $00, $00, texturebuffer(local0\Field9, $00))
                            hideentity(local0\Field8)
                            showentity(camera)
                        EndIf
                    EndIf
                EndIf
                local0\Field14 = 0.0
            EndIf
            If (local0\Field20 <> 0) Then
                If (local0\Field17 <> 0) Then
                    local3 = createpivot($00)
                    positionentity(local3, entityx(camera, $00), entityy(camera, $00), entityz(camera, $00), $00)
                    pointentity(local3, local0\Field4, 0.0)
                    turnentity(local3, 90.0, 0.0, 0.0, $00)
                    user_camera_pitch = curveangle(entitypitch(local3, $00), (user_camera_pitch + 90.0), min(max((15000.0 / (- sanity)), 15.0), 200.0))
                    user_camera_pitch = (user_camera_pitch - 90.0)
                    rotateentity(collider, entitypitch(collider, $00), curveangle(entityyaw(local3, $00), entityyaw(collider, $00), min(max((15000.0 / (- sanity)), 15.0), 200.0)), 0.0, $00)
                    freeentity(local3)
                    If (-800.0 > sanity) Then
                        If (rand($03, $01) = $01) Then
                            entitytexture(local0\Field10, monitortexture, $00, $00)
                        EndIf
                        If (rand($06, $01) < $05) Then
                            entitytexture(local0\Field10, gorepics(rand($00, $05)), $00, $00)
                            If (local0\Field15 = $01) Then
                                playsound(horrorsfx($01))
                            EndIf
                            local0\Field15 = $02
                            If (local0\Field16 = $00) Then
                                local0\Field16 = playsound(horrorsfx($04))
                            ElseIf (channelplaying(local0\Field16) = $00) Then
                                local0\Field16 = playsound(horrorsfx($04))
                            EndIf
                        EndIf
                        blurtimer = 1000.0
                    ElseIf (-500.0 > sanity) Then
                        If (rand($07, $01) = $01) Then
                            entitytexture(local0\Field10, monitortexture, $00, $00)
                        EndIf
                        If (rand($32, $01) = $01) Then
                            entitytexture(local0\Field10, gorepics(rand($00, $05)), $00, $00)
                            If (local0\Field15 = $00) Then
                                playsound(horrorsfx($00))
                            EndIf
                            local0\Field15 = (Int max((Float local0\Field15), 1.0))
                        EndIf
                    Else
                        entitytexture(local0\Field10, monitortexture, $00, $00)
                    EndIf
                EndIf
            ElseIf (local0\Field17 <> 0) Then
                If (local0\Field15 = $00) Then
                    local0\Field15 = rand($EA60, $FDE8)
                EndIf
                If (rand($1F4, $01) = $01) Then
                    entitytexture(local0\Field10, oldaipics($00), $00, $00)
                EndIf
                If ((millisecs() Mod local0\Field15) >= rand($1F4, $01)) Then
                    entitytexture(local0\Field10, monitortexture, $00, $00)
                Else
                    entitytexture(local0\Field10, oldaipics($00), $00, $00)
                EndIf
            EndIf
        EndIf
    Next
    cls($01, $01)
    Return $00
End Function
