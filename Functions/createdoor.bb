Function createdoor.doors(arg0#, arg1#, arg2#, arg3#, arg4%, arg5%, arg6%, arg7%)
    Local local0.doors
    Local local1%
    local0 = (New doors)
    If (arg6 <> 0) Then
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
    local0\Field12 = doortempid
    doortempid = (doortempid + $01)
    scaleentity(local0\Field2, (1.0 / 256.0), (1.0 / 256.0), (1.0 / 256.0), $00)
    entitytype(local0\Field0, $01, $00)
    entitytype(local0\Field1, $01, $00)
    local0\Field11 = arg7
    For local1 = $00 To $01 Step $01
        If (arg7 <> 0) Then
            local0\Field3[local1] = copymesh(buttonkeyobj, $00)
        Else
            local0\Field3[local1] = copymesh(buttonobj, $00)
        EndIf
        scaleentity(local0\Field3[local1], 0.03, 0.03, 0.03, $00)
    Next
    If (arg6 <> 0) Then
        positionentity(local0\Field3[$00], (arg0 - (432.0 * roomscale)), (arg1 + 0.7), ((192.0 * roomscale) + arg2), $00)
        positionentity(local0\Field3[$01], ((432.0 * roomscale) + arg0), (arg1 + 0.7), (arg2 - (192.0 * roomscale)), $00)
        rotateentity(local0\Field3[$00], 0.0, 90.0, 0.0, $00)
        rotateentity(local0\Field3[$01], 0.0, 270.0, 0.0, $00)
    Else
        positionentity(local0\Field3[$00], (arg0 + 0.6), (arg1 + 0.7), (arg2 - 0.1), $00)
        positionentity(local0\Field3[$01], (arg0 - 0.6), (arg1 + 0.7), (arg2 + 0.1), $00)
        rotateentity(local0\Field3[$01], 0.0, 180.0, 0.0, $00)
    EndIf
    positionentity(local0\Field0, arg0, arg1, arg2, $00)
    If (local0\Field1 <> $00) Then
        positionentity(local0\Field1, arg0, arg1, arg2, $00)
        If (arg6 <> 0) Then
            rotateentity(local0\Field1, 0.0, arg3, 0.0, $00)
        Else
            rotateentity(local0\Field1, 0.0, (arg3 + 180.0), 0.0, $00)
        EndIf
        entityparent(local0\Field1, arg5, $01)
    EndIf
    positionentity(local0\Field2, arg0, arg1, arg2, $00)
    entityparent(local0\Field2, arg5, $01)
    entityparent(local0\Field0, arg5, $01)
    entityparent(local0\Field3[$00], local0\Field2, $01)
    entityparent(local0\Field3[$01], local0\Field2, $01)
    rotateentity(local0\Field0, 0.0, arg3, 0.0, $00)
    rotateentity(local0\Field2, 0.0, arg3, 0.0, $00)
    local0\Field6 = (Int arg3)
    local0\Field5 = arg4
    entitypickmode(local0\Field0, $03, $01)
    makecollbox(local0\Field0)
    If (local0\Field1 <> $00) Then
        entitypickmode(local0\Field1, $03, $01)
        makecollbox(local0\Field1)
    EndIf
    entitypickmode(local0\Field3[$00], $02, $01)
    entitypickmode(local0\Field3[$01], $02, $01)
    entitypickmode(local0\Field0, $02, $01)
    If (((local0\Field5 And (arg6 = $00)) And (rand($08, $01) = $01)) <> 0) Then
        local0\Field13 = $01
    EndIf
    Return local0
    Return Null
End Function
