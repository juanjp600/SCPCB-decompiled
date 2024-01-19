Function createdoor.doors(arg0%, arg1#, arg2#, arg3#, arg4#, arg5.rooms, arg6%, arg7%, arg8%, arg9$)
    Local local0.doors
    Local local1%
    Local local2%
    If (arg5 <> Null) Then
        local1 = arg5\Field2
    EndIf
    local0 = (New doors)
    If (arg7 <> 0) Then
        local0\Field0 = copymesh(bigdoorobj($00), $00)
        scaleentity(local0\Field0, (55.0 * roomscale), (55.0 * roomscale), (55.0 * roomscale), $00)
        local0\Field1 = copymesh(bigdoorobj($01), $00)
        scaleentity(local0\Field1, (55.0 * roomscale), (55.0 * roomscale), (55.0 * roomscale), $00)
        local0\Field2 = copymesh(doorcoll, $00)
        scaleentity(local0\Field2, roomscale, roomscale, roomscale, $00)
        entitytype(local0\Field2, $01, $00)
        entityalpha(local0\Field2, 0.0)
    Else
        local0\Field0 = copymesh(doorobj, $00)
        scaleentity(local0\Field0, ((204.0 * roomscale) / meshwidth(local0\Field0)), ((312.0 * roomscale) / meshheight(local0\Field0)), ((16.0 * roomscale) / meshdepth(local0\Field0)), $00)
        local0\Field2 = copymesh(doorframeobj, $00)
        local0\Field1 = copymesh(doorobj, $00)
        scaleentity(local0\Field1, ((204.0 * roomscale) / meshwidth(local0\Field0)), ((312.0 * roomscale) / meshheight(local0\Field0)), ((16.0 * roomscale) / meshdepth(local0\Field0)), $00)
    EndIf
    local0\Field16 = doortempid
    doortempid = (doortempid + $01)
    scaleentity(local0\Field2, (1.0 / 256.0), (1.0 / 256.0), (1.0 / 256.0), $00)
    entitytype(local0\Field0, $01, $00)
    entitytype(local0\Field1, $01, $00)
    local0\Field11 = arg8
    local0\Field15 = arg9
    local0\Field17 = arg0
    local0\Field18 = $42
    For local2 = $00 To $01 Step $01
        If (arg9 <> "") Then
            local0\Field3[local2] = copymesh(buttoncodeobj, $00)
        ElseIf (arg8 <> 0) Then
            local0\Field3[local2] = copymesh(buttonkeyobj, $00)
        Else
            local0\Field3[local2] = copymesh(buttonobj, $00)
        EndIf
        scaleentity(local0\Field3[local2], 0.03, 0.03, 0.03, $00)
    Next
    If (arg7 <> 0) Then
        positionentity(local0\Field3[$00], (arg1 - (432.0 * roomscale)), (arg2 + 0.7), ((192.0 * roomscale) + arg3), $00)
        positionentity(local0\Field3[$01], ((432.0 * roomscale) + arg1), (arg2 + 0.7), (arg3 - (192.0 * roomscale)), $00)
        rotateentity(local0\Field3[$00], 0.0, 90.0, 0.0, $00)
        rotateentity(local0\Field3[$01], 0.0, 270.0, 0.0, $00)
    Else
        positionentity(local0\Field3[$00], (arg1 + 0.6), (arg2 + 0.7), (arg3 - 0.1), $00)
        positionentity(local0\Field3[$01], (arg1 - 0.6), (arg2 + 0.7), (arg3 + 0.1), $00)
        rotateentity(local0\Field3[$01], 0.0, 180.0, 0.0, $00)
    EndIf
    positionentity(local0\Field0, arg1, arg2, arg3, $00)
    If (local0\Field1 <> $00) Then
        positionentity(local0\Field1, arg1, arg2, arg3, $00)
        If (arg7 <> 0) Then
            rotateentity(local0\Field1, 0.0, arg4, 0.0, $00)
        Else
            rotateentity(local0\Field1, 0.0, (arg4 + 180.0), 0.0, $00)
        EndIf
        entityparent(local0\Field1, local1, $01)
    EndIf
    positionentity(local0\Field2, arg1, arg2, arg3, $00)
    entityparent(local0\Field2, local1, $01)
    entityparent(local0\Field0, local1, $01)
    entityparent(local0\Field3[$00], local0\Field2, $01)
    entityparent(local0\Field3[$01], local0\Field2, $01)
    rotateentity(local0\Field0, 0.0, arg4, 0.0, $00)
    rotateentity(local0\Field2, 0.0, arg4, 0.0, $00)
    local0\Field6 = (Int arg4)
    local0\Field5 = arg6
    entitypickmode(local0\Field0, $03, $01)
    makecollbox(local0\Field0)
    If (local0\Field1 <> $00) Then
        entitypickmode(local0\Field1, $03, $01)
        makecollbox(local0\Field1)
    EndIf
    entitypickmode(local0\Field3[$00], $02, $01)
    entitypickmode(local0\Field3[$01], $02, $01)
    If (((local0\Field5 And (arg7 = $00)) And (rand($08, $01) = $01)) <> 0) Then
        local0\Field19 = $01
    EndIf
    local0\Field12 = arg5
    Return local0
    Return Null
End Function
