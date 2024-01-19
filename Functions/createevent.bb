Function createevent.events(arg0$, arg1$, arg2%, arg3#)
    Local local0.events
    Local local1%
    Local local2%
    Local local3%
    Local local4.rooms
    Local local5.events
    local0 = (New events)
    local0\Field0 = arg0
    local1 = $00
    local2 = $00
    If (0.0 = arg3) Then
        For local4 = Each rooms
            local2 = (local2 + $01)
            If (((arg1 = "") Or (arg1 = local4\Field5\Field4)) <> 0) Then
                local3 = $00
                For local5 = Each events
                    If (local5\Field1 = local4) Then
                        local3 = $01
                        Exit
                    EndIf
                Next
                local1 = (local1 + $01)
                If (((local1 >= arg2) And (local3 = $00)) <> 0) Then
                    local0\Field1 = local4
                    Exit
                EndIf
            EndIf
        Next
    Else
        For local4 = Each rooms
            If (((arg1 = "") Or (arg1 = local4\Field5\Field4)) <> 0) Then
                local3 = $00
                For local5 = Each events
                    If (local5\Field1 = local4) Then
                        local3 = $01
                        Exit
                    EndIf
                Next
                If (((arg3 > rnd(0.0, 1.0)) And (local3 = $00)) <> 0) Then
                    local0\Field1 = local4
                    Exit
                EndIf
            EndIf
        Next
    EndIf
    If (local0\Field1 = Null) Then
        Delete local0
        Return Null
    EndIf
    Return local0
    Return Null
End Function
