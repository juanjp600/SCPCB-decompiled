Function loadworld%(arg0$, arg1.roomtemplates)
    Local local0%
    Local local1%
    Local local2%
    Local local3%
    Local local4%
    Local local5%
    Local local6%
    Local local7%
    Local local8%
    Local local9$
    Local local11#
    Local local12#
    Local local13#
    Local local14.tempscreens
    Local local15.tempwaypoints
    Local local16#
    Local local17$
    Local local18#
    Local local19%
    Local local20%
    Local local21%
    Local local22.lighttemplates
    Local local23$
    Local local24#
    Local local25#
    Local local26#
    Local local27%
    Local local28%
    Local local29%
    Local local30%
    Local local31$
    Local local32.materials
    Local local33%
    local0 = loadanimmesh(arg0, $00)
    If (local0 = $00) Then
        Return $00
    EndIf
    local1 = createpivot($00)
    local2 = createpivot(local1)
    local3 = createmesh(local1)
    local4 = createpivot(local1)
    local5 = createpivot(local1)
    local6 = createpivot(local1)
    entitytype(local4, $01, $00)
    For local7 = $01 To countchildren(local0) Step $01
        local8 = getchild(local0, local7)
        local9 = lower(keyvalue(local8, "classname", ""))
        Select local9
            Case "mesh"
                entityparent(local8, local2, $01)
                entitytype(local8, $01, $00)
                entitypickmode(local8, $02, $01)
                local7 = (local7 - $01)
            Case "brush"
                rotatemesh(local8, entitypitch(local8, $00), entityyaw(local8, $00), entityroll(local8, $00))
                positionmesh(local8, entityx(local8, $00), entityy(local8, $00), entityz(local8, $00))
                addmesh(local8, local3)
                entityalpha(local8, 0.0)
                entitytype(local8, $01, $00)
                entityalpha(local8, 0.0)
                entityparent(local8, local4, $01)
                entitypickmode(local8, $02, $01)
                local7 = (local7 - $01)
            Case "item"
            Case "screen"
                local11 = (entityx(local8, $00) * roomscale)
                local12 = (entityy(local8, $00) * roomscale)
                local13 = (entityz(local8, $00) * roomscale)
                If ((((0.0 <> local11) Or (0.0 <> local12)) Or (0.0 <> local13)) <> 0) Then
                    local14 = (New tempscreens)
                    local14\Field1 = local11
                    local14\Field2 = local12
                    local14\Field3 = local13
                    local14\Field0 = keyvalue(local8, "imgpath", "")
                    local14\Field4 = arg1
                EndIf
            Case "waypoint"
                local11 = (entityx(local8, $00) * roomscale)
                local12 = (entityy(local8, $00) * roomscale)
                local13 = (entityz(local8, $00) * roomscale)
                local15 = (New tempwaypoints)
                local15\Field3 = arg1
                local15\Field0 = local11
                local15\Field1 = local12
                local15\Field2 = local13
            Case "light"
                local11 = (entityx(local8, $00) * roomscale)
                local12 = (entityy(local8, $00) * roomscale)
                local13 = (entityz(local8, $00) * roomscale)
                If ((((0.0 <> local11) Or (0.0 <> local12)) Or (0.0 <> local13)) <> 0) Then
                    local16 = ((Float keyvalue(local8, "range", "1")) / 1000.0)
                    local17 = keyvalue(local8, "color", "255 255 255")
                    local18 = min(((Float keyvalue(local8, "intensity", "1.0")) * 0.8), 1.0)
                    local19 = (Int ((Float (Int piece(local17, $01, " "))) * local18))
                    local20 = (Int ((Float (Int piece(local17, $02, " "))) * local18))
                    local21 = (Int ((Float (Int piece(local17, $03, " "))) * local18))
                    addtemplight(arg1, local11, local12, local13, $02, local16, local19, local20, local21)
                EndIf
            Case "spotlight"
                local11 = (entityx(local8, $00) * roomscale)
                local12 = (entityy(local8, $00) * roomscale)
                local13 = (entityz(local8, $00) * roomscale)
                If ((((0.0 <> local11) Or (0.0 <> local12)) Or (0.0 <> local13)) <> 0) Then
                    local16 = ((Float keyvalue(local8, "range", "1")) / 700.0)
                    local17 = keyvalue(local8, "color", "255 255 255")
                    local18 = min(((Float keyvalue(local8, "intensity", "1.0")) * 0.8), 1.0)
                    local19 = (Int ((Float (Int piece(local17, $01, " "))) * local18))
                    local20 = (Int ((Float (Int piece(local17, $02, " "))) * local18))
                    local21 = (Int ((Float (Int piece(local17, $03, " "))) * local18))
                    local22 = addtemplight(arg1, local11, local12, local13, $03, local16, local19, local20, local21)
                    local23 = keyvalue(local8, "angles", "0 0 0")
                    local24 = (Float piece(local23, $01, " "))
                    local25 = (Float piece(local23, $02, " "))
                    local22\Field9 = local24
                    local22\Field10 = local25
                    local22\Field11 = (Int keyvalue(local8, "innerconeangle", ""))
                    local22\Field12 = (Float (Int keyvalue(local8, "outerconeangle", "")))
                EndIf
            Case "field_hit"
                entityparent(local8, local4, $01)
                entityalpha(local8, 0.0)
                local7 = (local7 - $01)
            Case "playerstart"
                local23 = keyvalue(local8, "angles", "0 0 0")
                local24 = (Float piece(local23, $01, " "))
                local25 = (Float piece(local23, $02, " "))
                local26 = (Float piece(local23, $03, " "))
                If (local27 <> 0) Then
                    positionentity(local27, entityx(local8, $00), entityy(local8, $00), entityz(local8, $00), $00)
                    rotateentity(local27, local24, local25, local26, $00)
                EndIf
        End Select
    Next
    If (bumpenabled <> 0) Then
        For local28 = $01 To countsurfaces(local3) Step $01
            local29 = getsurface(local3, local28)
            local21 = getsurfacebrush(local29)
            local30 = getbrushtexture(local21, $01)
            local31 = strippath(texturename(local30))
            For local32 = Each materials
                If (local31 = local32\Field0) Then
                    local33 = getbrushtexture(local21, $00)
                    brushtexture(local21, local33, $00, $00)
                    brushtexture(local21, local32\Field2, $00, $01)
                    brushtexture(local21, local30, $00, $02)
                    paintsurface(local29, local21)
                    If (strippath(texturename(local33)) <> "") Then
                        freetexture(local33)
                    EndIf
                    Exit
                EndIf
            Next
            freetexture(local30)
            freebrush(local21)
        Next
    EndIf
    entityfx(local3, $01)
    freeentity(local0)
    Return local1
    Return $00
End Function
