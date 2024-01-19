Function initnewgame%()
    Local local0.doors
    Local local1.items
    Local local2.securitycams
    Local local3.rooms
    Local local4%
    Local local5.decals
    Local local6.roomtemplates
    drawloading($3C)
    createmap()
    drawloading($46)
    curr173 = createnpc($01, 0.0, -30.0, 0.0)
    curr106 = createnpc($02, 0.0, -30.0, 0.0)
    curr106\Field6 = 63000.0
    For local0 = Each doors
        entityparent(local0\Field0, $00, $01)
        If (local0\Field1 > $00) Then
            entityparent(local0\Field1, $00, $01)
        EndIf
        If (local0\Field2 > $00) Then
            entityparent(local0\Field2, $00, $01)
        EndIf
        If (local0\Field3[$00] > $00) Then
            entityparent(local0\Field3[$00], $00, $01)
        EndIf
        If (local0\Field3[$01] > $00) Then
            entityparent(local0\Field3[$01], $00, $01)
        EndIf
        If (((local0\Field1 <> $00) And (local0\Field8 = $00)) <> 0) Then
            moveentity(local0\Field0, 0.0, 0.0, (8.0 * roomscale))
            moveentity(local0\Field1, 0.0, 0.0, (8.0 * roomscale))
        EndIf
    Next
    For local1 = Each items
        entitytype(local1\Field0, $03, $00)
        entityparent(local1\Field0, $00, $01)
    Next
    drawloading($50)
    For local2 = Each securitycams
        local2\Field11 = (entityyaw(local2\Field0, $00) + local2\Field11)
        entityparent(local2\Field0, $00, $01)
    Next
    For local3 = Each rooms
        For local4 = $00 To $13 Step $01
            If (local3\Field7[local4] <> $00) Then
                entityparent(local3\Field7[local4], $00, $01)
            EndIf
        Next
        If (local3\Field6\Field7 = $00) Then
            If (rand($04, $01) = $01) Then
                local5 = createdecal(rand($02, $03), (entityx(local3\Field1, $00) + rnd(-2.0, 2.0)), 0.003, (entityz(local3\Field1, $00) + rnd(-2.0, 2.0)), 90.0, (Float rand($168, $01)), 0.0)
                local5\Field2 = rnd(0.1, 0.4)
                scalesprite(local5\Field0, local5\Field2, local5\Field2)
                entityalpha(local5\Field0, rnd(0.85, 0.95))
            EndIf
            If (rand($04, $01) = $01) Then
                local5 = createdecal($00, (entityx(local3\Field1, $00) + rnd(-2.0, 2.0)), 0.003, (entityz(local3\Field1, $00) + rnd(-2.0, 2.0)), 90.0, (Float rand($168, $01)), 0.0)
                local5\Field2 = rnd(0.5, 0.7)
                entityalpha(local5\Field0, 0.7)
                local5\Field5 = $01
                scalesprite(local5\Field0, local5\Field2, local5\Field2)
                entityalpha(local5\Field0, rnd(0.7, 0.85))
            EndIf
        EndIf
        If ((((local3\Field6\Field4 = "start") And (introenabled = $00)) Or ((local3\Field6\Field4 = "room173") And introenabled)) <> 0) Then
            positionentity(collider, entityx(local3\Field1, $00), 1.0, entityz(local3\Field1, $00), $00)
            playerroom = local3
        EndIf
    Next
    For local6 = Each roomtemplates
        freeentity(local6\Field0)
    Next
    turnentity(collider, 0.0, (Float rand($A0, $C8)), 0.0, $00)
    resetentity(collider)
    initevents()
    movemouse($140, $F0)
    setfont(font1)
    hidepointer()
    blinktimer = 560.0
    stamina = 100.0
    For local4 = $00 To $46 Step $01
        fpsfactor = 1.0
        flushkeys()
        moveplayer()
        updatedoors()
        updatenpcs()
        updateworld(1.0)
        cls($01, $01)
        drawloading(((local4 / $28) + $50))
    Next
    dropspeed = 0.0
    prevtime = millisecs()
    Return $00
End Function
