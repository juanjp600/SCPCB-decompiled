Function initnewgame%()
    Local local0%
    Local local1.decals
    Local local2.doors
    Local local3.items
    Local local4.rooms
    Local local5.securitycams
    Local local6.roomtemplates
    Local local7.tempwaypoints
    drawloading($3C, $00)
    createmap()
    initwaypoints($3C)
    drawloading($4F, $00)
    achvconsole = $01
    curr173 = createnpc($01, 0.0, -30.0, 0.0)
    curr106 = createnpc($02, 0.0, -30.0, 0.0)
    curr106\Field9 = (Float (rand($0C, $11) * $1068))
    For local2 = Each doors
        entityparent(local2\Field0, $00, $01)
        If (local2\Field1 > $00) Then
            entityparent(local2\Field1, $00, $01)
        EndIf
        If (local2\Field2 > $00) Then
            entityparent(local2\Field2, $00, $01)
        EndIf
        If (local2\Field3[$00] > $00) Then
            entityparent(local2\Field3[$00], $00, $01)
        EndIf
        If (local2\Field3[$01] > $00) Then
            entityparent(local2\Field3[$01], $00, $01)
        EndIf
        If (((local2\Field1 <> $00) And (local2\Field8 = $00)) <> 0) Then
            moveentity(local2\Field0, 0.0, 0.0, (8.0 * roomscale))
            moveentity(local2\Field1, 0.0, 0.0, (8.0 * roomscale))
        EndIf
    Next
    For local3 = Each items
        entitytype(local3\Field0, $03, $00)
        entityparent(local3\Field0, $00, $01)
    Next
    drawloading($50, $00)
    For local5 = Each securitycams
        local5\Field11 = (entityyaw(local5\Field0, $00) + local5\Field11)
        entityparent(local5\Field0, $00, $01)
    Next
    For local4 = Each rooms
        For local0 = $00 To $13 Step $01
            If (local4\Field8[local0] <> $00) Then
                entityparent(local4\Field8[local0], $00, $01)
            EndIf
        Next
        If (local4\Field7\Field7 = $00) Then
            If (rand($04, $01) = $01) Then
                local1 = createdecal(rand($02, $03), (entityx(local4\Field2, $00) + rnd(-2.0, 2.0)), 0.003, (entityz(local4\Field2, $00) + rnd(-2.0, 2.0)), 90.0, (Float rand($168, $01)), 0.0)
                local1\Field2 = rnd(0.1, 0.4)
                scalesprite(local1\Field0, local1\Field2, local1\Field2)
                entityalpha(local1\Field0, rnd(0.85, 0.95))
            EndIf
            If (rand($04, $01) = $01) Then
                local1 = createdecal($00, (entityx(local4\Field2, $00) + rnd(-2.0, 2.0)), 0.003, (entityz(local4\Field2, $00) + rnd(-2.0, 2.0)), 90.0, (Float rand($168, $01)), 0.0)
                local1\Field2 = rnd(0.5, 0.7)
                entityalpha(local1\Field0, 0.7)
                local1\Field7 = $01
                scalesprite(local1\Field0, local1\Field2, local1\Field2)
                entityalpha(local1\Field0, rnd(0.7, 0.85))
            EndIf
        EndIf
        If ((((local4\Field7\Field4 = "start") And (introenabled = $00)) Or ((local4\Field7\Field4 = "room173") And introenabled)) <> 0) Then
            positionentity(collider, entityx(local4\Field2, $00), 1.0, entityz(local4\Field2, $00), $00)
            playerroom = local4
        EndIf
    Next
    For local6 = Each roomtemplates
        freeentity(local6\Field0)
    Next
    For local7 = Each tempwaypoints
        Delete local7
    Next
    turnentity(collider, 0.0, (Float rand($A0, $C8)), 0.0, $00)
    resetentity(collider)
    initevents()
    movemouse($140, $F0)
    setfont(font1)
    hidepointer()
    blinktimer = 560.0
    stamina = 100.0
    For local0 = $00 To $46 Step $01
        fpsfactor = 1.0
        flushkeys()
        moveplayer()
        updatedoors()
        updatenpcs()
        updateworld(1.0)
        drawloading(((Int ((Float local0) * 0.27)) + $50), $00)
    Next
    drawloading($64, $00)
    flushkeys()
    flushmouse()
    dropspeed = 0.0
    prevtime = millisecs()
    Return $00
End Function
