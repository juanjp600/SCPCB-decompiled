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
    Local local14#
    Local local15$
    Local local16#
    Local local17%
    Local local18%
    Local local19%
    Local local20.lighttemplates
    Local local21$
    Local local22#
    Local local23#
    Local local24#
    Local local25%
    Local local26%
    Local local27%
    Local local28%
    Local local29$
    Local local30.materials
    Local local31%
    Local local32%
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
            Case "light"
                local11 = (entityx(local8, $00) * roomscale)
                local12 = (entityy(local8, $00) * roomscale)
                local13 = (entityz(local8, $00) * roomscale)
                If ((((0.0 <> local11) Or (0.0 <> local12)) Or (0.0 <> local13)) <> 0) Then
                    local14 = ((Float keyvalue(local8, "range", "1")) / 1000.0)
                    local15 = keyvalue(local8, "color", "255 255 255")
                    local16 = min(((Float keyvalue(local8, "intensity", "1.0")) * 0.8), 1.0)
                    local17 = (Int ((Float (Int piece(local15, $01, " "))) * local16))
                    local18 = (Int ((Float (Int piece(local15, $02, " "))) * local16))
                    local19 = (Int ((Float (Int piece(local15, $03, " "))) * local16))
                    addtemplight(arg1, local11, local12, local13, $02, local14, local17, local18, local19)
                EndIf
            Case "spotlight"
                local11 = (entityx(local8, $00) * roomscale)
                local12 = (entityy(local8, $00) * roomscale)
                local13 = (entityz(local8, $00) * roomscale)
                If ((((0.0 <> local11) Or (0.0 <> local12)) Or (0.0 <> local13)) <> 0) Then
                    local14 = ((Float keyvalue(local8, "range", "1")) / 700.0)
                    local15 = keyvalue(local8, "color", "255 255 255")
                    local16 = min(((Float keyvalue(local8, "intensity", "1.0")) * 0.8), 1.0)
                    local17 = (Int ((Float (Int piece(local15, $01, " "))) * local16))
                    local18 = (Int ((Float (Int piece(local15, $02, " "))) * local16))
                    local19 = (Int ((Float (Int piece(local15, $03, " "))) * local16))
                    local20 = addtemplight(arg1, local11, local12, local13, $03, local14, local17, local18, local19)
                    local21 = keyvalue(local8, "angles", "0 0 0")
                    local22 = (Float piece(local21, $01, " "))
                    local23 = (Float piece(local21, $02, " "))
                    local20\Field9 = local22
                    local20\Field10 = local23
                    local20\Field11 = (Int keyvalue(local8, "innerconeangle", ""))
                    local20\Field12 = (Float (Int keyvalue(local8, "outerconeangle", "")))
                EndIf
            Case "field_hit"
                entityparent(local8, local4, $01)
                entityalpha(local8, 0.0)
                local7 = (local7 - $01)
            Case "playerstart"
                local21 = keyvalue(local8, "angles", "0 0 0")
                local22 = (Float piece(local21, $01, " "))
                local23 = (Float piece(local21, $02, " "))
                local24 = (Float piece(local21, $03, " "))
                If (local25 <> 0) Then
                    positionentity(local25, entityx(local8, $00), entityy(local8, $00), entityz(local8, $00), $00)
                    rotateentity(local25, local22, local23, local24, $00)
                EndIf
        End Select
    Next
    debuglog(arg0)
    If (bumpenabled <> 0) Then
        For local26 = $01 To countsurfaces(local3) Step $01
            local27 = getsurface(local3, local26)
            local19 = getsurfacebrush(local27)
            local28 = getbrushtexture(local19, $01)
            local29 = strippath(texturename(local28))
            debuglog(local29)
            For local30 = Each materials
                If (local29 = local30\Field0) Then
                    local31 = getbrushtexture(local19, $00)
                    debuglog(("1: " + strippath(texturename(local31))))
                    local32 = getbrushtexture(local19, $01)
                    debuglog(("2: " + strippath(texturename(local32))))
                    brushtexture(local19, local31, $00, $00)
                    brushtexture(local19, local30\Field2, $00, $01)
                    brushtexture(local19, local32, $00, $02)
                    paintsurface(local27, local19)
                    If (strippath(texturename(local31)) <> "") Then
                        freetexture(local31)
                    EndIf
                    If (strippath(texturename(local32)) <> "") Then
                        freetexture(local32)
                    EndIf
                    Exit
                EndIf
            Next
            freetexture(local28)
            freebrush(local19)
        Next
    EndIf
    freeentity(local0)
    Return local1
    Return $00
End Function
