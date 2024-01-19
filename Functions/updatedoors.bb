Function updatedoors%()
    Local local0%
    Local local1.doors
    Local local2#
    Local local3#
    Local local4#
    Local local5%
    Local local6#
    Local local7#
    Local local8%
    If (0.0 >= updatedoorstimer) Then
        For local1 = Each doors
            local2 = (Abs (entityx(collider, $00) - entityx(local1\Field0, $01)))
            local3 = (Abs (entityx(collider, $00) - entityx(local1\Field0, $01)))
            If (32.0 < (local2 + local3)) Then
                local1\Field15 = (local2 + local3)
            Else
                local1\Field15 = entitydistance(collider, local1\Field0)
            EndIf
            If (local1\Field15 > (hidedistance * 2.0)) Then
                If (local1\Field0 <> $00) Then
                    hideentity(local1\Field0)
                EndIf
                If (local1\Field2 <> $00) Then
                    hideentity(local1\Field2)
                EndIf
                If (local1\Field1 <> $00) Then
                    hideentity(local1\Field1)
                EndIf
                If (local1\Field3[$00] <> $00) Then
                    hideentity(local1\Field3[$00])
                EndIf
                If (local1\Field3[$01] <> $00) Then
                    hideentity(local1\Field3[$01])
                EndIf
            Else
                If (local1\Field0 <> $00) Then
                    showentity(local1\Field0)
                EndIf
                If (local1\Field2 <> $00) Then
                    showentity(local1\Field2)
                EndIf
                If (local1\Field1 <> $00) Then
                    showentity(local1\Field1)
                EndIf
                If (local1\Field3[$00] <> $00) Then
                    showentity(local1\Field3[$00])
                EndIf
                If (local1\Field3[$01] <> $00) Then
                    showentity(local1\Field3[$01])
                EndIf
            EndIf
        Next
        updatedoorstimer = 30.0
    Else
        updatedoorstimer = max((updatedoorstimer - fpsfactor), 0.0)
    EndIf
    closestbutton = $00
    closestdoor = Null
    For local1 = Each doors
        If (local1\Field15 < (hidedistance * 2.0)) Then
            If ((((180.0 <= local1\Field7) Or (0.0 >= local1\Field7)) And (grabbedentity = $00)) <> 0) Then
                For local0 = $00 To $01 Step $01
                    If (local1\Field3[local0] <> $00) Then
                        If (1.0 > (Abs (entityx(collider, $00) - entityx(local1\Field3[local0], $01)))) Then
                            If (1.0 > (Abs (entityz(collider, $00) - entityz(local1\Field3[local0], $01)))) Then
                                local4 = distance(entityx(collider, $01), entityz(collider, $01), entityx(local1\Field3[local0], $01), entityz(local1\Field3[local0], $01))
                                If (0.7 > local4) Then
                                    local5 = createpivot($00)
                                    positionentity(local5, entityx(camera, $00), entityy(camera, $00), entityz(camera, $00), $00)
                                    pointentity(local5, local1\Field3[local0], 0.0)
                                    If (entitypick(local5, 0.6) = local1\Field3[local0]) Then
                                        If (closestbutton = $00) Then
                                            closestbutton = local1\Field3[local0]
                                            closestdoor = local1
                                        ElseIf (local4 < entitydistance(collider, closestbutton)) Then
                                            closestbutton = local1\Field3[local0]
                                            closestdoor = local1
                                        EndIf
                                    EndIf
                                    freeentity(local5)
                                EndIf
                            EndIf
                        EndIf
                    EndIf
                Next
            EndIf
            If (local1\Field5 <> 0) Then
                If (180.0 > local1\Field7) Then
                    If (local1\Field9 = $00) Then
                        local1\Field7 = min(180.0, (((fpsfactor * 2.0) * (Float (local1\Field8 + $01))) + local1\Field7))
                        moveentity(local1\Field0, (((sin(local1\Field7) * (Float (local1\Field8 + $01))) * fpsfactor) / 80.0), 0.0, 0.0)
                        If (local1\Field1 <> $00) Then
                            moveentity(local1\Field1, (((sin(local1\Field7) * (Float (local1\Field8 + $01))) * fpsfactor) / 80.0), 0.0, 0.0)
                        EndIf
                    Else
                        local1\Field7 = min(180.0, ((fpsfactor * 0.8) + local1\Field7))
                        moveentity(local1\Field0, ((sin(local1\Field7) * fpsfactor) / 180.0), 0.0, 0.0)
                        If (local1\Field1 <> $00) Then
                            moveentity(local1\Field1, (((- sin(local1\Field7)) * fpsfactor) / 180.0), 0.0, 0.0)
                        EndIf
                    EndIf
                Else
                    local1\Field8 = $00
                    resetentity(local1\Field0)
                    If (local1\Field1 <> $00) Then
                        resetentity(local1\Field1)
                    EndIf
                    If (((local1\Field10 > $00) And (0.0 < local1\Field11)) <> 0) Then
                        local1\Field11 = max(0.0, (local1\Field11 - fpsfactor))
                        If (((110.0 < (local1\Field11 + fpsfactor)) And (110.0 >= local1\Field11)) <> 0) Then
                            playsound2(cautionsfx, camera, local1\Field0, 10.0, 1.0, $01)
                        EndIf
                        If (0.0 = local1\Field11) Then
                            local1\Field5 = (local1\Field5 = $00)
                            playsound2(closedoorsfx(rand($00, $02)), camera, local1\Field0, 10.0, 1.0, $01)
                        EndIf
                    EndIf
                    If ((local1\Field21 And (remotedooron = $01)) <> 0) Then
                        If (2.1 > entitydistance(camera, local1\Field0)) Then
                            If (wearing714 = $00) Then
                                playsound(horrorsfx($07))
                            EndIf
                            local1\Field5 = $00
                            playsound2(closedoorsfx(rand($00, $02)), camera, local1\Field0, 10.0, 1.0, $01)
                            local1\Field21 = $00
                        EndIf
                    EndIf
                EndIf
            ElseIf (0.0 < local1\Field7) Then
                If (local1\Field9 = $00) Then
                    local1\Field7 = max(0.0, (local1\Field7 - ((fpsfactor * 2.0) * (Float (local1\Field8 + $01)))))
                    moveentity(local1\Field0, (((sin(local1\Field7) * (- fpsfactor)) * (Float (local1\Field8 + $01))) / 80.0), 0.0, 0.0)
                    If (local1\Field1 <> $00) Then
                        moveentity(local1\Field1, (((sin(local1\Field7) * (Float (local1\Field8 + $01))) * (- fpsfactor)) / 80.0), 0.0, 0.0)
                    EndIf
                Else
                    local1\Field7 = max(0.0, (local1\Field7 - (fpsfactor * 0.8)))
                    moveentity(local1\Field0, ((sin(local1\Field7) * (- fpsfactor)) / 180.0), 0.0, 0.0)
                    If (local1\Field1 <> $00) Then
                        moveentity(local1\Field1, ((sin(local1\Field7) * fpsfactor) / 180.0), 0.0, 0.0)
                    EndIf
                EndIf
                local6 = entityx(local1\Field2, $01)
                local7 = entityz(local1\Field2, $01)
                If ((0.15 * (Float ((local1\Field9 Shl $01) + $01))) > distance(entityx(collider, $00), entityz(collider, $00), local6, local7)) Then
                    local8 = createpivot($00)
                    positionentity(local8, local6, 0.0, local7, $00)
                    rotateentity(local8, 0.0, (entityyaw(local1\Field2, $00) + 90.0), 0.0, $01)
                    moveentity(local8, 0.0, 0.0, 1.0)
                    pointentity(local8, collider, 0.0)
                    If (0.0 < (entityyaw(local8, $00) - wrapangle((entityyaw(local1\Field2, $00) - 90.0)))) Then
                        rotateentity(local8, 0.0, (entityyaw(local1\Field2, $00) - 180.0), 0.0, $00)
                    Else
                        rotateentity(local8, 0.0, entityyaw(local1\Field2, $00), 0.0, $00)
                    EndIf
                    positionentity(local8, local6, entityy(collider, $00), local7, $00)
                    moveentity(local8, 0.0, 0.0, (0.15 * (Float ((local1\Field9 Shl $01) + $01))))
                    positionentity(collider, curvevalue(entityx(local8, $00), entityx(collider, $00), 5.0), entityy(collider, $00), curvevalue(entityz(local8, $00), entityz(collider, $00), 5.0), $00)
                EndIf
            Else
                local1\Field8 = $00
                positionentity(local1\Field0, entityx(local1\Field2, $01), entityy(local1\Field2, $01), entityz(local1\Field2, $01), $00)
                If (local1\Field1 <> $00) Then
                    positionentity(local1\Field1, entityx(local1\Field2, $01), entityy(local1\Field2, $01), entityz(local1\Field2, $01), $00)
                EndIf
                If (((local1\Field1 <> $00) And (local1\Field9 = $00)) <> 0) Then
                    moveentity(local1\Field0, 0.0, 0.0, (8.0 * roomscale))
                    moveentity(local1\Field1, 0.0, 0.0, (8.0 * roomscale))
                EndIf
            EndIf
        EndIf
    Next
    Return $00
End Function
