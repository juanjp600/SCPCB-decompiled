Function updatedoors%()
    Local local0.doors
    Local local1%
    Local local2#
    Local local3%
    Local local4#
    Local local5#
    Local local6%
    closestbutton = $00
    closestdoor = Null
    For local0 = Each doors
        If (((180.0 <= local0\Field7) Or (0.0 >= local0\Field7)) <> 0) Then
            For local1 = $00 To $01 Step $01
                If (local0\Field3[local1] <> $00) Then
                    local2 = distance(entityx(collider, $01), entityz(collider, $01), entityx(local0\Field3[local1], $01), entityz(local0\Field3[local1], $01))
                    If (0.7 > local2) Then
                        local3 = createpivot($00)
                        positionentity(local3, entityx(camera, $00), entityy(camera, $00), entityz(camera, $00), $00)
                        pointentity(local3, local0\Field3[local1], 0.0)
                        If (entitypick(local3, 0.45) = local0\Field3[local1]) Then
                            If (closestbutton = $00) Then
                                If (local0\Field15 <> $42) Then
                                    msg = "ENTER ROOM"
                                    msgtimer = 255.0
                                EndIf
                                closestbutton = local0\Field3[local1]
                                closestdoor = local0
                            ElseIf (local2 < entitydistance(collider, closestbutton)) Then
                                closestbutton = local0\Field3[local1]
                                closestdoor = local0
                            EndIf
                        EndIf
                        freeentity(local3)
                    EndIf
                EndIf
            Next
        EndIf
        If (local0\Field5 <> 0) Then
            If (180.0 > local0\Field7) Then
                If (local0\Field8 = $00) Then
                    local0\Field7 = min(180.0, ((fpsfactor * 2.0) + local0\Field7))
                    moveentity(local0\Field0, ((sin(local0\Field7) * fpsfactor) / 80.0), 0.0, 0.0)
                    If (local0\Field1 <> $00) Then
                        moveentity(local0\Field1, ((sin(local0\Field7) * fpsfactor) / 80.0), 0.0, 0.0)
                    EndIf
                Else
                    local0\Field7 = min(180.0, ((fpsfactor * 0.8) + local0\Field7))
                    moveentity(local0\Field0, ((sin(local0\Field7) * fpsfactor) / 180.0), 0.0, 0.0)
                    If (local0\Field1 <> $00) Then
                        moveentity(local0\Field1, (((- sin(local0\Field7)) * fpsfactor) / 180.0), 0.0, 0.0)
                    EndIf
                EndIf
            Else
                resetentity(local0\Field0)
                If (local0\Field1 <> $00) Then
                    resetentity(local0\Field1)
                EndIf
                If (0.0 < local0\Field10) Then
                    local0\Field10 = max(0.0, (local0\Field10 - fpsfactor))
                    If (((110.0 < (local0\Field10 + fpsfactor)) And (110.0 >= local0\Field10)) <> 0) Then
                        playsound2(cautionsfx, camera, local0\Field0, 10.0, 1.0)
                    EndIf
                    If (0.0 = local0\Field10) Then
                        local0\Field5 = (local0\Field5 = $00)
                        playsound2(closedoorsfx(rand($00, $02)), camera, local0\Field0, 10.0, 1.0)
                    EndIf
                EndIf
                If ((local0\Field16 And (remotedooron = $01)) <> 0) Then
                    If (1.8 > entitydistance(camera, local0\Field0)) Then
                        playsound(horrorsfx($07))
                        local0\Field5 = $00
                        playsound2(closedoorsfx(rand($00, $02)), camera, local0\Field0, 10.0, 1.0)
                        local0\Field16 = $00
                    EndIf
                EndIf
            EndIf
        ElseIf (0.0 < local0\Field7) Then
            If (local0\Field8 = $00) Then
                local0\Field7 = max(0.0, (local0\Field7 - (fpsfactor * 2.0)))
                moveentity(local0\Field0, ((sin(local0\Field7) * (- fpsfactor)) / 80.0), 0.0, 0.0)
                If (local0\Field1 <> $00) Then
                    moveentity(local0\Field1, ((sin(local0\Field7) * (- fpsfactor)) / 80.0), 0.0, 0.0)
                EndIf
            Else
                local0\Field7 = max(0.0, (local0\Field7 - (fpsfactor * 0.8)))
                moveentity(local0\Field0, ((sin(local0\Field7) * (- fpsfactor)) / 180.0), 0.0, 0.0)
                If (local0\Field1 <> $00) Then
                    moveentity(local0\Field1, ((sin(local0\Field7) * fpsfactor) / 180.0), 0.0, 0.0)
                EndIf
            EndIf
            local4 = entityx(local0\Field2, $01)
            local5 = entityz(local0\Field2, $01)
            If ((0.15 * (Float ((local0\Field8 Shl $01) + $01))) > distance(entityx(collider, $00), entityz(collider, $00), local4, local5)) Then
                local6 = createpivot($00)
                positionentity(local6, local4, 0.0, local5, $00)
                rotateentity(local6, 0.0, (entityyaw(local0\Field2, $00) + 90.0), 0.0, $01)
                moveentity(local6, 0.0, 0.0, 1.0)
                pointentity(local6, collider, 0.0)
                If (0.0 < (entityyaw(local6, $00) - wrapangle((entityyaw(local0\Field2, $00) - 90.0)))) Then
                    rotateentity(local6, 0.0, (entityyaw(local0\Field2, $00) - 180.0), 0.0, $00)
                Else
                    rotateentity(local6, 0.0, entityyaw(local0\Field2, $00), 0.0, $00)
                EndIf
                positionentity(local6, local4, entityy(collider, $00), local5, $00)
                moveentity(local6, 0.0, 0.0, (0.15 * (Float ((local0\Field8 Shl $01) + $01))))
                positionentity(collider, curvevalue(entityx(local6, $00), entityx(collider, $00), 5.0), entityy(collider, $00), curvevalue(entityz(local6, $00), entityz(collider, $00), 5.0), $00)
            EndIf
        Else
            positionentity(local0\Field0, entityx(local0\Field2, $01), entityy(local0\Field2, $01), entityz(local0\Field2, $01), $00)
            If (local0\Field1 <> $00) Then
                positionentity(local0\Field1, entityx(local0\Field2, $01), entityy(local0\Field2, $01), entityz(local0\Field2, $01), $00)
            EndIf
            If (((local0\Field1 <> $00) And (local0\Field8 = $00)) <> 0) Then
                moveentity(local0\Field0, 0.0, 0.0, (8.0 * roomscale))
                moveentity(local0\Field1, 0.0, 0.0, (8.0 * roomscale))
            EndIf
        EndIf
        If (local0\Field15 <> $42) Then
            local0\Field5 = $00
        EndIf
    Next
    Return $00
End Function
