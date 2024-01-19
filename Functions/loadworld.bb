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
    Local local14.tempwaypoints
    Local local15#
    Local local16$
    Local local17#
    Local local18%
    Local local19%
    Local local20%
    Local local21.lighttemplates
    Local local22$
    Local local23#
    Local local24#
    Local local25#
    Local local26%
    Local local27%
    Local local28%
    Local local29%
    Local local30$
    Local local31.materials
    Local local32%
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
            Case "waypoint"
                local11 = (entityx(local8, $00) * roomscale)
                local12 = (entityy(local8, $00) * roomscale)
                local13 = (entityz(local8, $00) * roomscale)
                local14 = (New tempwaypoints)
                local14\Field3 = arg1
                local14\Field0 = local11
                local14\Field1 = local12
                local14\Field2 = local13
            Case "light"
                local11 = (entityx(local8, $00) * roomscale)
                local12 = (entityy(local8, $00) * roomscale)
                local13 = (entityz(local8, $00) * roomscale)
                If ((((0.0 <> local11) Or (0.0 <> local12)) Or (0.0 <> local13)) <> 0) Then
                    local15 = ((Float keyvalue(local8, "range", "1")) / 1000.0)
                    local16 = keyvalue(local8, "color", "255 255 255")
                    local17 = min(((Float keyvalue(local8, "intensity", "1.0")) * 0.8), 1.0)
                    local18 = (Int ((Float (Int piece(local16, $01, " "))) * local17))
                    local19 = (Int ((Float (Int piece(local16, $02, " "))) * local17))
                    local20 = (Int ((Float (Int piece(local16, $03, " "))) * local17))
                    addtemplight(arg1, local11, local12, local13, $02, local15, local18, local19, local20)
                EndIf
            Case "spotlight"
                local11 = (entityx(local8, $00) * roomscale)
                local12 = (entityy(local8, $00) * roomscale)
                local13 = (entityz(local8, $00) * roomscale)
                If ((((0.0 <> local11) Or (0.0 <> local12)) Or (0.0 <> local13)) <> 0) Then
                    local15 = ((Float keyvalue(local8, "range", "1")) / 700.0)
                    local16 = keyvalue(local8, "color", "255 255 255")
                    local17 = min(((Float keyvalue(local8, "intensity", "1.0")) * 0.8), 1.0)
                    local18 = (Int ((Float (Int piece(local16, $01, " "))) * local17))
                    local19 = (Int ((Float (Int piece(local16, $02, " "))) * local17))
                    local20 = (Int ((Float (Int piece(local16, $03, " "))) * local17))
                    local21 = addtemplight(arg1, local11, local12, local13, $03, local15, local18, local19, local20)
                    local22 = keyvalue(local8, "angles", "0 0 0")
                    local23 = (Float piece(local22, $01, " "))
                    local24 = (Float piece(local22, $02, " "))
                    local21\Field9 = local23
                    local21\Field10 = local24
                    local21\Field11 = (Int keyvalue(local8, "innerconeangle", ""))
                    local21\Field12 = (Float (Int keyvalue(local8, "outerconeangle", "")))
                EndIf
            Case "field_hit"
                entityparent(local8, local4, $01)
                entityalpha(local8, 0.0)
                local7 = (local7 - $01)
            Case "playerstart"
                local22 = keyvalue(local8, "angles", "0 0 0")
                local23 = (Float piece(local22, $01, " "))
                local24 = (Float piece(local22, $02, " "))
                local25 = (Float piece(local22, $03, " "))
                If (local26 <> 0) Then
                    positionentity(local26, entityx(local8, $00), entityy(local8, $00), entityz(local8, $00), $00)
                    rotateentity(local26, local23, local24, local25, $00)
                EndIf
        End Select
    Next
    debuglog(arg0)
    If (bumpenabled <> 0) Then
        For local27 = $01 To countsurfaces(local3) Step $01
            local28 = getsurface(local3, local27)
            local20 = getsurfacebrush(local28)
            local29 = getbrushtexture(local20, $01)
            local30 = strippath(texturename(local29))
            debuglog(local30)
            For local31 = Each materials
                If (local30 = local31\Field0) Then
                    local32 = getbrushtexture(local20, $00)
                    debuglog(("1: " + strippath(texturename(local32))))
                    local33 = getbrushtexture(local20, $01)
                    debuglog(("2: " + strippath(texturename(local33))))
                    brushtexture(local20, local32, $00, $00)
                    brushtexture(local20, local31\Field2, $00, $01)
                    brushtexture(local20, local33, $00, $02)
                    paintsurface(local28, local20)
                    If (strippath(texturename(local32)) <> "") Then
                        freetexture(local32)
                    EndIf
                    If (strippath(texturename(local33)) <> "") Then
                        freetexture(local33)
                    EndIf
                    Exit
                EndIf
            Next
            freetexture(local29)
            freebrush(local20)
        Next
    EndIf
    freeentity(local0)
    Return local1
    Return $00
End Function
