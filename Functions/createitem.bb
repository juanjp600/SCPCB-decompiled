Function createitem.items(arg0$, arg1$, arg2#, arg3#, arg4#)
    Local local0.items
    Local local1.itemtemplates
    Local local2%
    Local local3%
    Local local4%
    Local local5%
    Local local6%
    Local local7%
    Local local8%
    Local local9%
    local0 = (New items)
    arg0 = lower(arg0)
    arg1 = lower(arg1)
    For local1 = Each itemtemplates
        If (((lower(local1\Field0) = arg0) And (lower(local1\Field1) = arg1)) <> 0) Then
            local0\Field1 = local1
            local0\Field0 = copyentity(local1\Field3, $00)
        EndIf
    Next
    If (local0\Field1 = Null) Then
        runtimeerror((((("Item template not found (" + arg0) + ", ") + arg1) + ")"))
    EndIf
    resetentity(local0\Field0)
    positionentity(local0\Field0, arg2, arg3, arg4, $00)
    rotateentity(local0\Field0, 0.0, (Float rand($168, $01)), 0.0, $00)
    Return local0
    local0\Field0 = loadmesh((Str local2), $00)
    If ((local3 And $00) <> 0) Then
        For local4 = $01 To countsurfaces(local0\Field0) Step $01
            local5 = getsurface(local0\Field0, local4)
            local6 = getsurfacebrush(local5)
            local7 = getbrushtexture(local6, $01)
            local8 = loadtexture((Str local3), $01)
            brushtexture(local6, local9, $00, $00)
            brushtexture(local6, local8, $00, $01)
            paintsurface(local5, local6)
            freetexture(local7)
            freebrush(local6)
            freetexture(local8)
        Next
    EndIf
    Return Null
End Function
