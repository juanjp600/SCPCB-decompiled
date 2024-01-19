Function moveplayer%()
    Local local0#
    Local local1#
    Local local2%
    Local local3#
    Local local4#
    Local local5%
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
    If (((((keydown($D0) Or keydown($1F)) Xor keydown($C8)) Or keydown($11)) Or ((keydown($CB) Or keydown($1E)) Xor (keydown($CD) Or keydown($20)))) <> 0) Then
        local3 = (shake Mod 360.0)
        If (((keydown($2A) Or keydown($36)) And (0.0 < stamina)) <> 0) Then
            local0 = 2.5
            stamina = (stamina - (fpsfactor * 0.7))
            If (0.0 >= stamina) Then
                stamina = -10.0
            EndIf
        EndIf
        If (playerroom\Field6\Field4 = "pocketdimension") Then
            stamina = 0.0
            local1 = 0.01
            local0 = 1.0
        EndIf
        shake = ((((min(local0, 1.5) * fpsfactor) * 7.0) + shake) Mod 720.0)
        If (((180.0 > local3) And (180.0 <= (shake Mod 360.0))) <> 0) Then
            If (playerroom\Field6\Field4 = "pocketdimension") Then
                playsound(steppdsfx(rand($00, $02)))
            ElseIf (1.0 = local0) Then
                playsound(stepsfx(playerroom\Field6\Field8, $01, rand($00, $03)))
            Else
                playsound(stepsfx(playerroom\Field6\Field8, $00, rand($00, $03)))
            EndIf
        EndIf
    EndIf
    local4 = ((local1 * local0) * fpsfactor)
    If ((keydown($D0) Or keydown($1F)) <> 0) Then
        moveentity(collider, 0.0, 0.0, (- local4))
    EndIf
    If ((keydown($C8) Or keydown($11)) <> 0) Then
        moveentity(collider, 0.0, 0.0, local4)
    EndIf
    If ((keydown($CB) Or keydown($1E)) <> 0) Then
        moveentity(collider, (- local4), 0.0, 0.0)
    EndIf
    If ((keydown($CD) Or keydown($20)) <> 0) Then
        moveentity(collider, local4, 0.0, 0.0)
    EndIf
    local5 = $00
    For local2 = $01 To countcollisions(collider) Step $01
        If ((entityy(collider, $00) - 0.25) > collisiony(collider, local2)) Then
            local5 = $01
        EndIf
    Next
    If (keyhit($39) <> 0) Then
        blinktimer = 0.0
    EndIf
    If ((keydown($39) And (-10.0 > blinktimer)) <> 0) Then
        blinktimer = -10.0
    EndIf
    If (local5 = $01) Then
        dropspeed = 0.0
    Else
        dropspeed = min(max((dropspeed - (0.006 * fpsfactor)), -2.0), 0.0)
    EndIf
    moveentity(collider, 0.0, dropspeed, 0.0)
    If (playerroom <> Null) Then
        Select playerroom\Field6\Field4
            Case "room173","start","pocketdimension"
                positionentity(collider, entityx(collider, $00), max(entityy(collider, $00), 0.31), entityz(collider, $00), $00)
            Case "room2tunnel"
                positionentity(collider, entityx(collider, $00), max(entityy(collider, $00), -3.448), entityz(collider, $00), $00)
        End Select
    EndIf
    Return $00
End Function
