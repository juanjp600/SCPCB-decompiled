Function moveplayer%()
    Local local0#
    Local local1#
    Local local2%
    Local local3#
    Local local4#
    Local local5#
    Local local6%
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
    If (noclip = $00) Then
        If (((((keydown($D0) Or keydown($1F)) Xor keydown($C8)) Or keydown($11)) Or ((keydown($CB) Or keydown($1E)) Xor (keydown($CD) Or keydown($20)))) <> 0) Then
            If (((keydown($2A) Or keydown($36)) And (0.0 < stamina)) <> 0) Then
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
            local4 = (shake Mod 360.0)
            shake = ((((min(local0, 1.5) * fpsfactor) * 7.0) + shake) Mod 720.0)
            If (((180.0 > local4) And (180.0 <= (shake Mod 360.0))) <> 0) Then
                If (playerroom\Field7\Field4 = "pocketdimension") Then
                    playsound(steppdsfx(rand($00, $02)))
                Else
                    debuglog("bim")
                    If (1.0 = local0) Then
                        playersoundvolume = max(4.0, playersoundvolume)
                        playsound(stepsfx(playerroom\Field7\Field8, $01, rand($00, $03)))
                    Else
                        playersoundvolume = max(2.5, playersoundvolume)
                        playsound(stepsfx(playerroom\Field7\Field8, $00, rand($00, $03)))
                    EndIf
                EndIf
            EndIf
        EndIf
    ElseIf ((keydown($2A) Or keydown($36)) <> 0) Then
        local0 = 2.5
    ElseIf (keydown($1D) <> 0) Then
        local0 = 0.5
    EndIf
    local5 = ((local1 * local0) * fpsfactor)
    If (noclip <> 0) Then
        shake = 0.0
        currspeed = 0.0
        rotateentity(collider, wrapangle(entitypitch(camera, $00)), wrapangle(entityyaw(camera, $00)), 0.0, $00)
        local5 = (local5 * 2.0)
        If ((keydown($D0) Or keydown($1F)) <> 0) Then
            moveentity(collider, 0.0, 0.0, (- local5))
        EndIf
        If ((keydown($C8) Or keydown($11)) <> 0) Then
            moveentity(collider, 0.0, 0.0, local5)
        EndIf
        If ((keydown($CB) Or keydown($1E)) <> 0) Then
            moveentity(collider, (- local5), 0.0, 0.0)
        EndIf
        If ((keydown($CD) Or keydown($20)) <> 0) Then
            moveentity(collider, local5, 0.0, 0.0)
        EndIf
        resetentity(collider)
    Else
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
            currspeed = curvevalue(local5, currspeed, 20.0)
        Else
            currspeed = max(curvevalue(0.0, (currspeed - 0.1), 5.0), 0.0)
        EndIf
        translateentity(collider, (cos(local3) * currspeed), 0.0, (sin(local3) * currspeed), $01)
        local6 = $00
        For local2 = $01 To countcollisions(collider) Step $01
            If ((entityy(collider, $00) - 0.25) > collisiony(collider, local2)) Then
                local6 = $01
            EndIf
        Next
        If (local6 = $01) Then
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
    If (keyhit($39) <> 0) Then
        blinktimer = 0.0
    EndIf
    If ((keydown($39) And (-10.0 > blinktimer)) <> 0) Then
        blinktimer = -10.0
    EndIf
    If (playerroom <> Null) Then
        Select playerroom\Field7\Field4
            Case "room173","start"
            Case "room2tunnel"
        End Select
    EndIf
    Return $00
End Function
