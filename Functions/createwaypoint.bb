Function createwaypoint.waypoints(arg0#, arg1#, arg2#, arg3.doors, arg4.rooms)
    Local local0.waypoints
    Return Null
    local0 = (New waypoints)
    local0\Field0 = createsprite($00)
    positionentity(local0\Field0, arg0, arg1, arg2, $00)
    scalesprite(local0\Field0, 0.15, 0.15)
    entitytexture(local0\Field0, lightspritetex($00), $00, $00)
    entityblend(local0\Field0, $03)
    local0\Field2 = arg4
    local0\Field1 = arg3
    Return local0
    Return Null
End Function
