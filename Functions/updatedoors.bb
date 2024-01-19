Function updatedoors%()
    Local local0%
    Local local1.doors
    Local local2#
    Local local3%
    Local local4#
    Local local5#
    Local local6%
    closestbutton = $00
    closestdoor = Null
    For local1 = Each doors
        If ((((180.0 <= local1\Field7) Or (0.0 >= local1\Field7)) And (grabbedentity = $00)) <> 0) Then
            For local0 = $00 To $01 Step $01
                If (local1\Field3[local0] <> $00) Then
                    If (1.0 > (Abs (entityx(collider, $00) - entityx(local1\Field3[local0], $01)))) Then
                        If (1.0 > (Abs (entityz(collider, $00) - entityz(local1\Field3[local0], $01)))) Then
                            local2 = distance(entityx(collider, $01), entityz(collider, $01), entityx(local1\Field3[local0], $01), entityz(local1\Field3[local0], $01))
                            If (0.7 > local2) Then
                                local3 = createpivot($00)
                                positionentity(local3, entityx(camera, $00), entityy(camera, $00), entityz(camera, $00), $00)
                                pointentity(local3, local1\Field3[local0], 0.0)
                                If (entitypick(local3, 0.6) = local1\Field3[local0]) Then
                                    If (closestbutton = $00) Then
                                        closestbutton = local1\Field3[local0]
                                        closestdoor = local1
                                    ElseIf (local2 < entitydistance(collider, closestbutton)) Then
                                        closestbutton = local1\Field3[local0]
                                        closestdoor = local1
                                    EndIf
                                EndIf
                                freeentity(local3)
                            EndIf
                        EndIf
                    EndIf
                EndIf
            Next
        EndIf
        If (local1\Field5 <> 0) Then
            If (180.0 > local1\Field7) Then
                If (local1\Field8 = $00) Then
                    local1\Field7 = min(180.0, ((fpsfactor * 2.0) + local1\Field7))
                    moveentity(local1\Field0, ((sin(local1\Field7) * fpsfactor) / 80.0), 0.0, 0.0)
                    If (local1\Field1 <> $00) Then
                        moveentity(local1\Field1, ((sin(local1\Field7) * fpsfactor) / 80.0), 0.0, 0.0)
                    EndIf
                Else
                    local1\Field7 = min(180.0, ((fpsfactor * 0.8) + local1\Field7))
                    moveentity(local1\Field0, ((sin(local1\Field7) * fpsfactor) / 180.0), 0.0, 0.0)
                    If (local1\Field1 <> $00) Then
                        moveentity(local1\Field1, (((- sin(local1\Field7)) * fpsfactor) / 180.0), 0.0, 0.0)
                    EndIf
                EndIf
            Else
                resetentity(local1\Field0)
                If (local1\Field1 <> $00) Then
                    resetentity(local1\Field1)
                EndIf
                If (0.0 < local1\Field10) Then
                    local1\Field10 = max(0.0, (local1\Field10 - fpsfactor))
                    If (((110.0 < (local1\Field10 + fpsfactor)) And (110.0 >= local1\Field10)) <> 0) Then
                        playsound2(cautionsfx, camera, local1\Field0, 10.0, 1.0, $01)
                    EndIf
                    If (0.0 = local1\Field10) Then
                        local1\Field5 = (local1\Field5 = $00)
                        playsound2(closedoorsfx(rand($00, $02)), camera, local1\Field0, 10.0, 1.0, $01)
                    EndIf
                EndIf
                If ((local1\Field18 And (remotedooron = $01)) <> 0) Then
                    If (1.8 > entitydistance(camera, local1\Field0)) Then
                        playsound(horrorsfx($07))
                        local1\Field5 = $00
                        playsound2(closedoorsfx(rand($00, $02)), camera, local1\Field0, 10.0, 1.0, $01)
                        local1\Field18 = $00
                    EndIf
                EndIf
            EndIf
        ElseIf (0.0 < local1\Field7) Then
            If (local1\Field8 = $00) Then
                local1\Field7 = max(0.0, (local1\Field7 - (fpsfactor * 2.0)))
                moveentity(local1\Field0, ((sin(local1\Field7) * (- fpsfactor)) / 80.0), 0.0, 0.0)
                If (local1\Field1 <> $00) Then
                    moveentity(local1\Field1, ((sin(local1\Field7) * (- fpsfactor)) / 80.0), 0.0, 0.0)
                EndIf
            Else
                local1\Field7 = max(0.0, (local1\Field7 - (fpsfactor * 0.8)))
                moveentity(local1\Field0, ((sin(local1\Field7) * (- fpsfactor)) / 180.0), 0.0, 0.0)
                If (local1\Field1 <> $00) Then
                    moveentity(local1\Field1, ((sin(local1\Field7) * fpsfactor) / 180.0), 0.0, 0.0)
                EndIf
            EndIf
            local4 = entityx(local1\Field2, $01)
            local5 = entityz(local1\Field2, $01)
            If ((0.15 * (Float ((local1\Field8 Shl $01) + $01))) > distance(entityx(collider, $00), entityz(collider, $00), local4, local5)) Then
                local6 = createpivot($00)
                positionentity(local6, local4, 0.0, local5, $00)
                rotateentity(local6, 0.0, (entityyaw(local1\Field2, $00) + 90.0), 0.0, $01)
                moveentity(local6, 0.0, 0.0, 1.0)
                pointentity(local6, collider, 0.0)
                If (0.0 < (entityyaw(local6, $00) - wrapangle((entityyaw(local1\Field2, $00) - 90.0)))) Then
                    rotateentity(local6, 0.0, (entityyaw(local1\Field2, $00) - 180.0), 0.0, $00)
                Else
                    rotateentity(local6, 0.0, entityyaw(local1\Field2, $00), 0.0, $00)
                EndIf
                positionentity(local6, local4, entityy(collider, $00), local5, $00)
                moveentity(local6, 0.0, 0.0, (0.15 * (Float ((local1\Field8 Shl $01) + $01))))
                positionentity(collider, curvevalue(entityx(local6, $00), entityx(collider, $00), 5.0), entityy(collider, $00), curvevalue(entityz(local6, $00), entityz(collider, $00), 5.0), $00)
            EndIf
        Else
            positionentity(local1\Field0, entityx(local1\Field2, $01), entityy(local1\Field2, $01), entityz(local1\Field2, $01), $00)
            If (local1\Field1 <> $00) Then
                positionentity(local1\Field1, entityx(local1\Field2, $01), entityy(local1\Field2, $01), entityz(local1\Field2, $01), $00)
            EndIf
            If (((local1\Field1 <> $00) And (local1\Field8 = $00)) <> 0) Then
                moveentity(local1\Field0, 0.0, 0.0, (8.0 * roomscale))
                moveentity(local1\Field1, 0.0, 0.0, (8.0 * roomscale))
            EndIf
        EndIf
        If (local1\Field17 <> $42) Then
            local1\Field5 = $00
        EndIf
    Next
    Return $00
End Function
