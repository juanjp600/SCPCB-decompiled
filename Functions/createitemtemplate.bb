Function createitemtemplate.itemtemplates(arg0$, arg1$, arg2$, arg3$, arg4$, arg5#, arg6$, arg7$)
    Local local0.itemtemplates
    Local local1%
    Local local2%
    local0 = (New itemtemplates)
    local0\Field4 = loadmesh(arg2, $00)
    If (arg6 <> "") Then
        local2 = loadtexture(arg6, $01)
        entitytexture(local0\Field4, local2, $00, $00)
    EndIf
    local0\Field8 = arg5
    scaleentity(local0\Field4, arg5, arg5, arg5, $00)
    local0\Field5 = loadimage(arg3)
    maskimage(local0\Field5, $FF, $00, $FF)
    local0\Field6 = arg4
    local0\Field1 = arg1
    local0\Field0 = arg0
    local0\Field2 = $01
    entityradius(local0\Field4, 0.01, 0.0)
    entitypickmode(local0\Field4, $03, $00)
    makecollbox(local0\Field4)
    hideentity(local0\Field4)
    Return local0
    Return Null
End Function
