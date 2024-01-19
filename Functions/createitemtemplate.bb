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
    If (((arg7 <> "") And $00) <> 0) Then
        For local2 = $01 To countsurfaces(local0\Field3) Step $01
            local3 = getsurface(local0\Field3, local2)
            local4 = getsurfacebrush(local3)
            local5 = getbrushtexture(local4, $00)
            local6 = loadtexture(arg7, $01)
            textureblend(local6, $1603)
            brushtexture(local4, local6, $00, $00)
            brushtexture(local4, local5, $00, $01)
            paintsurface(local3, local4)
            debuglog("a")
            freetexture(local5)
            debuglog("b")
            freebrush(local4)
            debuglog("c")
            freetexture(local6)
        Next
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
