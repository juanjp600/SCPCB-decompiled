Function createemitter.emitters(arg0#, arg1#, arg2#, arg3%)
    Local local0.emitters
    Local local1%
    Local local2.rooms
    local0 = (New emitters)
    local0\Field0 = createpivot($00)
    positionentity(local0\Field0, arg0, arg1, arg2, $01)
    local1 = arg3
    If (local1 = $00) Then
        local0\Field1 = 0.03
        local0\Field4 = -0.2
        local0\Field5 = $C8
        local0\Field11 = 0.005
        local0\Field9 = 0.01
        local0\Field10 = 20.0
    EndIf
    For local2 = Each rooms
        If (((4.0 > (Abs (entityx(local0\Field0, $00) - entityx(local2\Field1, $00)))) And (4.0 > (Abs (entityz(local0\Field0, $00) - entityz(local2\Field1, $00))))) <> 0) Then
            local0\Field7 = local2
        EndIf
    Next
    Return local0
    Return Null
End Function
