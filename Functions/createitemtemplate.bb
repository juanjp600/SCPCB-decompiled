Function createitemtemplate.itemtemplates(arg0$, arg1$, arg2$, arg3$, arg4$, arg5#, arg6$, arg7$)
    Local local0.itemtemplates
    Local local1%
    Local local2%
    Local local3%
    Local local4%
    Local local5%
    Local local6%
    local0 = (New itemtemplates)
    local0\Field3 = loadmesh(arg2, $00)
    If (arg6 <> "") Then
        local1 = loadtexture(arg6, $01)
        entitytexture(local0\Field3, local1, $00, $00)
    EndIf
    local0\Field6 = arg5
    scaleentity(local0\Field3, arg5, arg5, arg5, $00)
    local0\Field4 = loadimage(arg3)
    maskimage(local0\Field4, $FF, $00, $FF)
    If (arg4 <> "") Then
        local0\Field5 = loadimage(arg4)
        maskimage(local0\Field5, $FF, $00, $FF)
    EndIf
    local0\Field1 = arg1
    local0\Field0 = arg0
    local0\Field2 = $01
    entityradius(local0\Field3, 0.01, 0.0)
    entitypickmode(local0\Field3, $03, $00)
    makecollbox(local0\Field3)
    Return local0
    Return Null
End Function
