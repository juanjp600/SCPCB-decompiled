Function moveplayer%()
    Local local0#
    Local local1#
    Local local2%
    Local local3#
    Local local4#
    Local local5%
    Local local6#
    Local local7%
    Local local8%
    Local local9.decals
    local0 = 1.0
    local1 = 0.02
    If (superman <> 0) Then
        local1 = (local1 * 3.0)
        supermantimer = (supermantimer + fpsfactor)
        camerashake = (sin((supermantimer / 5.0)) * (supermantimer / 1500.0))
        If (3500.0 < supermantimer) Then
            kill()
            showentity(fog)
        Else
            blurtimer = 500.0
            hideentity(fog)
        EndIf
    EndIf
    stamina = min(((0.15 * fpsfactor) + stamina), 100.0)
    For local2 = $00 To $09 Step $01
        If (inventory(local2) <> Null) Then
            If (inventory(local2)\Field1\Field1 = "finevest") Then
                stamina = max(stamina, 60.0)
            EndIf
        EndIf
    Next
    If (0.001 > (Abs (crouchstate - (Float crouch)))) Then
        crouchstate = (Float crouch)
    Else
        crouchstate = curvevalue((Float crouch), crouchstate, 10.0)
    EndIf
    If (noclip = $00) Then
        If (((((keydown($D0) Or keydown($1F)) Xor keydown($C8)) Or keydown($11)) Or ((keydown($CB) Or keydown($1E)) Xor (keydown($CD) Or keydown($20)))) <> 0) Then
            If ((((crouch = $00) And (keydown($2A) Or keydown($36))) And (0.0 < stamina)) <> 0) Then
                local0 = 2.5
                stamina = (stamina - (fpsfactor * 0.6))
                If (0.0 >= stamina) Then
                    stamina = -10.0
                EndIf
            EndIf
            If (playerroom\Field7\Field4 = "pocketdimension") Then
                stamina = 0.0
                local1 = 0.01
                local0 = 1.0
            EndIf
            If (selecteditem <> Null) Then
                If (((selecteditem\Field1\Field1 = "firstaid") Or (selecteditem\Field1\Field1 = "finefirstaid")) <> 0) Then
                    local0 = 0.0
                ElseIf (selecteditem\Field1\Field1 = "firstaid2") Then
                    local0 = 0.0
                EndIf
            EndIf
            local4 = (shake Mod 360.0)
            shake = ((((min(local0, 1.5) * fpsfactor) * 7.0) + shake) Mod 720.0)
            If (((180.0 > local4) And (180.0 <= (shake Mod 360.0))) <> 0) Then
                If (playerroom\Field7\Field4 = "pocketdimension") Then
                    local5 = playsound(steppdsfx(rand($00, $02)))
                    channelvolume(local5, (1.0 - ((Float crouch) * 0.4)))
                ElseIf (1.0 = local0) Then
                    playersoundvolume = max(4.0, playersoundvolume)
                    local5 = playsound(stepsfx(playerroom\Field7\Field8, $01, rand($00, $03)))
                    channelvolume(local5, (1.0 - ((Float crouch) * 0.6)))
                Else
                    playersoundvolume = max((2.5 - ((Float crouch) * 0.6)), playersoundvolume)
                    local5 = playsound(stepsfx(playerroom\Field7\Field8, $00, rand($00, $03)))
                    channelvolume(local5, (1.0 - ((Float crouch) * 0.6)))
                EndIf
            EndIf
        EndIf
    ElseIf ((keydown($2A) Or keydown($36)) <> 0) Then
        local0 = 2.5
    ElseIf (keydown($1D) <> 0) Then
        local0 = 0.5
    EndIf
    If (keyhit($1D) <> 0) Then
        crouch = (crouch = $00)
    EndIf
    local6 = (((local1 * local0) * fpsfactor) / (1.0 + crouchstate))
    If (noclip <> 0) Then
        shake = 0.0
        currspeed = 0.0
        crouchstate = 0.0
        crouch = $00
        rotateentity(collider, wrapangle(entitypitch(camera, $00)), wrapangle(entityyaw(camera, $00)), 0.0, $00)
        local6 = (local6 * 2.0)
        If ((keydown($D0) Or keydown($1F)) <> 0) Then
            moveentity(collider, 0.0, 0.0, (- local6))
        EndIf
        If ((keydown($C8) Or keydown($11)) <> 0) Then
            moveentity(collider, 0.0, 0.0, local6)
        EndIf
        If ((keydown($CB) Or keydown($1E)) <> 0) Then
            moveentity(collider, (- local6), 0.0, 0.0)
        EndIf
        If ((keydown($CD) Or keydown($20)) <> 0) Then
            moveentity(collider, local6, 0.0, 0.0)
        EndIf
        resetentity(collider)
    Else
        local6 = (local6 / max(((injuries + 3.0) / 3.0), 1.0))
        If (0.5 < injuries) Then
            local6 = (min((sin((shake / 2.0)) + 1.2), 1.0) * local6)
        EndIf
        local4 = 0.0
        If ((keydown($D0) Or keydown($1F)) <> 0) Then
            local4 = 1.0
            local3 = 180.0
            If ((keydown($CB) Or keydown($1E)) <> 0) Then
                local3 = 135.0
            EndIf
            If ((keydown($CD) Or keydown($20)) <> 0) Then
                local3 = -135.0
            EndIf
        ElseIf ((keydown($C8) Or keydown($11)) <> 0) Then
            local4 = 1.0
            local3 = 0.0
            If ((keydown($CB) Or keydown($1E)) <> 0) Then
                local3 = 45.0
            EndIf
            If ((keydown($CD) Or keydown($20)) <> 0) Then
                local3 = -45.0
            EndIf
        Else
            If ((keydown($CB) Or keydown($1E)) <> 0) Then
                local3 = 90.0
                local4 = 1.0
            EndIf
            If ((keydown($CD) Or keydown($20)) <> 0) Then
                local3 = -90.0
                local4 = 1.0
            EndIf
        EndIf
        local3 = wrapangle(((entityyaw(collider, $01) + local3) + 90.0))
        If ((Int local4) <> 0) Then
            currspeed = curvevalue(local6, currspeed, 20.0)
        Else
            currspeed = max(curvevalue(0.0, (currspeed - 0.1), 5.0), 0.0)
        EndIf
        translateentity(collider, (cos(local3) * currspeed), 0.0, (sin(local3) * currspeed), $01)
        local7 = $00
        For local2 = $01 To countcollisions(collider) Step $01
            If ((entityy(collider, $00) - 0.25) > collisiony(collider, local2)) Then
                local7 = $01
            EndIf
        Next
        If (local7 = $01) Then
            If (-0.07 > dropspeed) Then
                If (playerroom\Field7\Field4 = "pocketdimension") Then
                    playsound(steppdsfx(rand($00, $02)))
                Else
                    playsound(stepsfx(playerroom\Field7\Field8, $00, rand($00, $03)))
                EndIf
                playersoundvolume = max(3.0, playersoundvolume)
            EndIf
            dropspeed = 0.0
        Else
            dropspeed = min(max((dropspeed - (0.006 * fpsfactor)), -2.0), 0.0)
        EndIf
        translateentity(collider, 0.0, dropspeed, 0.0, $00)
    EndIf
    If (1.0 < injuries) Then
        local6 = bloodloss
        blurtimer = max(max(((sin(((Float millisecs()) / 100.0)) * bloodloss) * 30.0), ((bloodloss * 2.0) * (2.0 - crouchstate))), blurtimer)
        bloodloss = min((((min(injuries, 3.5) / 300.0) * fpsfactor) + bloodloss), 100.0)
        If (((60.0 >= local6) And (60.0 < bloodloss)) <> 0) Then
            msg = "You are feeling weak from the blood loss"
            msgtimer = 280.0
        EndIf
    EndIf
    If (0.0 < bloodloss) Then
        If (min(injuries, 4.0) > rnd(200.0, 0.0)) Then
            local8 = createpivot($00)
            positionentity(local8, (entityx(collider, $00) + rnd(-0.05, 0.05)), (entityy(collider, $00) - 0.05), (entityz(collider, $00) + rnd(-0.05, 0.05)), $00)
            turnentity(local8, 90.0, 0.0, 0.0, $00)
            entitypick(local8, 0.3)
            debuglog("verta tippuu")
            local9 = createdecal(rand($0F, $10), pickedx(), (pickedy() + 0.005), pickedz(), 90.0, (Float rand($168, $01)), 0.0)
            local9\Field2 = (rnd(0.03, 0.08) * min(injuries, 3.0))
            entityalpha(local9\Field0, 1.0)
            scalesprite(local9\Field0, local9\Field2, local9\Field2)
            local5 = playsound(dripsfx(rand($00, $02)))
            channelvolume(local5, rnd(0.0, 0.8))
            channelpitch(local5, rand($4E20, $7530))
            freeentity(local8)
        EndIf
        currcamerazoom = max(currcamerazoom, (((sin(((Float millisecs()) / 20.0)) + 1.0) * bloodloss) * 0.2))
        If (60.0 < bloodloss) Then
            crouch = $01
        EndIf
        If (100.0 <= bloodloss) Then
            kill()
            heartbeatvolume = 0.0
        ElseIf (80.0 < bloodloss) Then
            heartbeatrate = max((150.0 - ((bloodloss - 80.0) * 5.0)), heartbeatrate)
            heartbeatvolume = max(heartbeatvolume, (((bloodloss - 80.0) * (1.0 / 80.0)) + 0.75))
        ElseIf (35.0 < bloodloss) Then
            heartbeatrate = max((70.0 + bloodloss), heartbeatrate)
            heartbeatvolume = max(heartbeatvolume, ((bloodloss - 35.0) / 60.0))
        EndIf
    EndIf
    If (keyhit($39) <> 0) Then
        blinktimer = 0.0
    EndIf
    If ((keydown($39) And (-10.0 > blinktimer)) <> 0) Then
        blinktimer = -10.0
    EndIf
    If (((playerroom <> Null) And $00) <> 0) Then
        Select playerroom\Field7\Field4
            Case "room173","start"
            Case "room2tunnel"
        End Select
    EndIf
    If (0.0 < heartbeatvolume) Then
        If (0.0 >= heartbeattimer) Then
            local5 = playsound(heartbeatsfx)
            channelvolume(local5, heartbeatvolume)
            heartbeattimer = ((60.0 / max(heartbeatrate, 1.0)) * 70.0)
        Else
            heartbeattimer = (heartbeattimer - fpsfactor)
        EndIf
        heartbeatvolume = max((heartbeatvolume - (fpsfactor * 0.1)), 0.0)
    EndIf
    Return $00
End Function
