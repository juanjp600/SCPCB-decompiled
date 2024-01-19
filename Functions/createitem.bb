Function createitem.items(arg0$, arg1$, arg2#, arg3#, arg4#)
    Local local0.items
    Local local1.itemtemplates
    local0 = (New items)
    arg0 = lower(arg0)
    arg1 = lower(arg1)
    For local1 = Each itemtemplates
        If (((lower(local1\Field0) = arg0) And (lower(local1\Field1) = arg1)) <> 0) Then
            local0\Field1 = local1
            local0\Field0 = copyentity(local1\Field4, $00)
            showentity(local0\Field0)
        EndIf
    Next
    If (local0\Field1 = Null) Then
        runtimeerror((((("Item template not found (" + arg0) + ", ") + arg1) + ")"))
    EndIf
    resetentity(local0\Field0)
    positionentity(local0\Field0, arg2, arg3, arg4, $00)
    rotateentity(local0\Field0, 0.0, (Float rand($168, $01)), 0.0, $00)
    local0\Field5 = entitydistance(collider, local0\Field0)
    Return local0
    Return Null
End Function
