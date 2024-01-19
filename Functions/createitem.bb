Function createitem.items(arg0$, arg1$, arg2#, arg3#, arg4#, arg5$, arg6$, arg7$, arg8#, arg9$)
    Local local0.items
    Local local1%
    Local local2%
    Local local3%
    Local local4%
    Local local5%
    Local local6%
    local0 = (New items)
    local0\Field0 = loadmesh(arg5, $00)
    If ((Int arg9) <> 0) Then
        For local1 = $01 To countsurfaces(local0\Field0) Step $01
            local2 = getsurface(local0\Field0, local1)
            local3 = getsurfacebrush(local2)
            local4 = getbrushtexture(local3, $01)
            local5 = loadtexture(arg9, $01)
            brushtexture(local3, local6, $00, $00)
            brushtexture(local3, local5, $00, $01)
            paintsurface(local2, local3)
            freetexture(local4)
        Next
    EndIf
    local0\Field7 = arg8
    scaleentity(local0\Field0, arg8, arg8, arg8, $00)
    local0\Field3 = arg5
    local0\Field1 = loadimage(arg6)
    local0\Field4 = arg6
    local0\Field5 = arg7
    maskimage(local0\Field1, $FF, $00, $FF)
    If (arg7 <> "") Then
        local0\Field2 = loadimage(arg7)
        maskimage(local0\Field2, $FF, $00, $FF)
    EndIf
    local0\Field10 = arg1
    local0\Field11 = arg0
    local0\Field9 = $01
    resetentity(local0\Field0)
    positionentity(local0\Field0, arg2, arg3, arg4, $00)
    entityradius(local0\Field0, 0.01, 0.0)
    rotateentity(local0\Field0, 0.0, (Float rand($168, $01)), 0.0, $00)
    entitypickmode(local0\Field0, $03, $00)
    makecollbox(local0\Field0)
    Return local0
    Return Null
End Function
