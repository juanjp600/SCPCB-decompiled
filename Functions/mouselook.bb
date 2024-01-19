Function mouselook%()
    Local local0%
    Local local1#
    Local local2#
    Local local3#
    Local local4#
    Local local5#
    Local local6#
    Local local7%
    Local local8%
    Local local9.particles
    camerashake = max((camerashake - (fpsfactor / 10.0)), 0.0)
    If (0.0 <= killtimer) Then
        local1 = 0.0
        local2 = (0.0 / local1)
        If ((Int entityx(collider, $00)) = (Int local2)) Then
            positionentity(collider, entityx(camera, $01), (entityy(camera, $01) - 0.5), entityz(camera, $01), $01)
            msg = ("EntityX(Collider) = NaN, RESETTING COORDINATES    -    New coordinates: " + (Str entityx(collider, $00)))
            msgtimer = 300.0
        EndIf
        positionentity(camera, entityx(collider, $00), (entityy(collider, $00) + 0.5), entityz(collider, $00), $00)
        local3 = (sin(shake) / 20.0)
        local4 = (cos((shake / 2.0)) / 35.0)
        moveentity(camera, local4, local3, 0.0)
        mouse_x_speed_1 = curvevalue(((mousesens + 0.6) * (Float mousexspeed())), mouse_x_speed_1, (6.0 / (mousesens + 1.0)))
        If ((Int mouse_x_speed_1) = (Int local2)) Then
            mouse_x_speed_1 = 0.0
        EndIf
        If (invertmouse <> 0) Then
            mouse_y_speed_1 = curvevalue(((mousesens + 0.6) * (Float (- mouseyspeed()))), mouse_y_speed_1, (6.0 / (mousesens + 1.0)))
        Else
            mouse_y_speed_1 = curvevalue(((mousesens + 0.6) * (Float mouseyspeed())), mouse_y_speed_1, (6.0 / (mousesens + 1.0)))
        EndIf
        If ((Int mouse_y_speed_1) = (Int local2)) Then
            mouse_y_speed_1 = 0.0
        EndIf
        local5 = (mouse_x_speed_1 * mouselook_x_inc)
        local6 = (mouse_y_speed_1 * mouselook_y_inc)
        turnentity(collider, 0.0, (- local5), 0.0, $00)
        user_camera_pitch = (user_camera_pitch + local6)
        If (70.0 < user_camera_pitch) Then
            user_camera_pitch = 70.0
        EndIf
        If (-70.0 > user_camera_pitch) Then
            user_camera_pitch = -70.0
        EndIf
        rotateentity(camera, (rnd((- camerashake), camerashake) + user_camera_pitch), (entityyaw(collider, $00) + rnd((- camerashake), camerashake)), 0.0, $00)
        If (playerroom\Field6\Field4 = "pocketdimension") Then
            rotateentity(camera, entitypitch(camera, $00), entityyaw(camera, $00), (sin(((Float millisecs()) / 150.0)) * 30.0), $00)
        EndIf
    Else
        hideentity(collider)
        positionentity(camera, entityx(head, $00), entityy(head, $00), entityz(head, $00), $00)
        local7 = $00
        For local0 = $01 To countcollisions(head) Step $01
            If ((entityy(head, $00) - 0.01) > collisiony(head, local0)) Then
                local7 = $01
            EndIf
        Next
        If (invertmouse <> 0) Then
            turnentity(camera, (((Float (- mouseyspeed())) * 0.05) * fpsfactor), (((Float (- mousexspeed())) * 0.15) * fpsfactor), 0.0, $00)
        Else
            turnentity(camera, (((Float mouseyspeed()) * 0.05) * fpsfactor), (((Float (- mousexspeed())) * 0.15) * fpsfactor), 0.0, $00)
        EndIf
        If (local7 = $01) Then
            headdropspeed = 0.0
            debuglog("collfloor")
        Else
            moveentity(head, 0.0, 0.0, headdropspeed)
            rotateentity(head, curveangle(-90.0, entitypitch(head, $00), 20.0), entityyaw(head, $00), entityroll(head, $00), $00)
            rotateentity(camera, curveangle((entitypitch(head, $00) - 40.0), entitypitch(camera, $00), 40.0), entityyaw(camera, $00), entityroll(camera, $00), $00)
            headdropspeed = (headdropspeed - (0.002 * fpsfactor))
        EndIf
    EndIf
    If (rand($23, $01) = $01) Then
        local8 = createpivot($00)
        positionentity(local8, entityx(camera, $01), entityy(camera, $01), entityz(camera, $01), $00)
        rotateentity(local8, 0.0, rnd(360.0, 0.0), 0.0, $00)
        If (rand($02, $01) = $01) Then
            moveentity(local8, 0.0, rnd(-0.5, 0.5), rnd(0.5, 1.0))
        Else
            moveentity(local8, 0.0, rnd(-0.5, 0.5), rnd(0.5, 1.0))
        EndIf
        local9 = createparticle(entityx(local8, $00), entityy(local8, $00), entityz(local8, $00), $02, 0.002, 0.0, $12C)
        local9\Field8 = 0.001
        rotateentity(local9\Field1, rnd(-20.0, 20.0), rnd(360.0, 0.0), 0.0, $00)
        local9\Field15 = -0.00001
        freeentity(local8)
    EndIf
    If (((((mousex() > mouse_right_limit) Or (mousex() < mouse_left_limit)) Or (mousey() > mouse_bottom_limit)) Or (mousey() < mouse_top_limit)) <> 0) Then
        movemouse(viewport_center_x, viewport_center_y)
    EndIf
    If (wearinggasmask <> 0) Then
        showentity(gasmaskoverlay)
        If (gasmaskbreathchn = $00) Then
            gasmaskbreathchn = playsound(gasmaskbreath)
        ElseIf (channelplaying(gasmaskbreathchn) = $00) Then
            gasmaskbreathchn = playsound(gasmaskbreath)
        EndIf
    Else
        If (gasmaskbreathchn <> $00) Then
            If (channelplaying(gasmaskbreathchn) <> 0) Then
                stopchannel(gasmaskbreathchn)
            EndIf
        EndIf
        hideentity(gasmaskoverlay)
    EndIf
    Return $00
End Function
