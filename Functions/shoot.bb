Function shoot%(arg0#, arg1#, arg2#, arg3#, arg4#, arg5#, arg6%)
    Local local0%
    Local local1.particles
    Local local4%
    Local local5.decals
    local0 = createpivot($00)
    positionentity(local0, arg0, arg1, arg2, $00)
    rotateentity(local0, arg3, arg4, 0.0, $01)
    entitypick(local0, arg5)
    local1 = createparticle(arg0, arg1, arg2, $01, rnd(0.1, 0.15), 0.0, $05)
    turnentity(local1\Field0, 0.0, 0.0, rnd(360.0, 0.0), $00)
    local1\Field14 = -0.15
    If (godmode = $00) Then
        If (pickedentity() = collider) Then
            turnentity(camera, rnd(-3.0, 3.0), rnd(-3.0, 3.0), 0.0, $00)
            If (wearingvest > $00) Then
                If (wearingvest = $01) Then
                    Select rand($08, $01)
                        Case $01,$02,$03,$04,$05
                            blurtimer = 500.0
                            stamina = 0.0
                            msg = "Air escapes from your lungs as something hits your vest"
                            msgtimer = 420.0
                            injuries = (rnd(0.1, 0.5) + injuries)
                        Case $06
                            blurtimer = 500.0
                            msg = "You feel a burning pain in your left leg"
                            msgtimer = 420.0
                            injuries = (rnd(0.8, 1.2) + injuries)
                        Case $07
                            blurtimer = 500.0
                            msg = "You feel a burning pain in your right leg"
                            msgtimer = 420.0
                            injuries = (rnd(0.8, 1.2) + injuries)
                        Case $08
                            kill()
                    End Select
                ElseIf (rand($0A, $01) = $01) Then
                    kill()
                Else
                    msg = "You feel something hitting your vest"
                    msgtimer = 420.0
                    injuries = (rnd(0.1, 0.5) + injuries)
                EndIf
            Else
                Select rand($06, $01)
                    Case $01
                        kill()
                    Case $02
                        blurtimer = 500.0
                        msg = "You feel a burning pain in your left leg"
                        msgtimer = 420.0
                        injuries = (rnd(0.8, 1.2) + injuries)
                    Case $03
                        blurtimer = 500.0
                        msg = "You feel a burning pain in your right leg"
                        msgtimer = 420.0
                        injuries = (rnd(0.8, 1.2) + injuries)
                    Case $04
                        blurtimer = 500.0
                        msg = "You feel a burning pain in your right shoulder"
                        msgtimer = 420.0
                        injuries = (rnd(0.8, 1.2) + injuries)
                    Case $05
                        blurtimer = 500.0
                        msg = "You feel a burning pain in your left shoulder"
                        msgtimer = 420.0
                        injuries = (rnd(0.8, 1.2) + injuries)
                    Case $06
                        blurtimer = 500.0
                        msg = "You feel a burning pain in your abdomen"
                        msgtimer = 420.0
                        injuries = (rnd(2.5, 4.0) + injuries)
                End Select
            EndIf
            injuries = min(injuries, 4.0)
            playsound(bullethitsfx)
        ElseIf (pickedentity() <> $00) Then
            positionentity(local0, pickedx(), pickedy(), pickedz(), $00)
            playsound2(gunshot3sfx, camera, local0, 0.4, rnd(0.8, 1.0), $01)
            If (arg6 <> 0) Then
                local1 = createparticle(pickedx(), pickedy(), pickedz(), $00, 0.03, 0.0, $50)
                local1\Field8 = 0.001
                local1\Field15 = 0.003
                local1\Field6 = 0.8
                local1\Field14 = -0.01
                rotateentity(local1\Field1, (entitypitch(local0, $00) - 180.0), entityyaw(local0, $00), 0.0, $00)
                For local4 = $00 To rand($02, $03) Step $01
                    local1 = createparticle(pickedx(), pickedy(), pickedz(), $00, 0.006, 0.003, $50)
                    local1\Field8 = 0.02
                    local1\Field6 = 0.8
                    local1\Field14 = -0.01
                    rotateentity(local1\Field1, (entitypitch(local0, $00) + rnd(170.0, 190.0)), (entityyaw(local0, $00) + rnd(-10.0, 10.0)), 0.0, $00)
                Next
                local5 = createdecal(rand($0D, $0E), pickedx(), pickedy(), pickedz(), 0.0, 0.0, 0.0)
                aligntovector(local5\Field0, (- pickednx()), (- pickedny()), (- pickednz()), $03, 1.0)
                moveentity(local5\Field0, 0.0, 0.0, -0.001)
                entityfx(local5\Field0, $01)
                local5\Field10 = 1400.0
                entityblend(local5\Field0, $02)
                local5\Field2 = rnd(0.028, 0.034)
                scalesprite(local5\Field0, local5\Field2, local5\Field2)
            EndIf
        EndIf
    EndIf
    freeentity(local0)
    Return $00
End Function
