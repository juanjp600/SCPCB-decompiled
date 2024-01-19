Function createevent.events(arg0$, arg1$, arg2%, arg3#)
    Local local0%
    Local local1%
    Local local2%
    Local local3.events
    Local local4.events
    Local local5.rooms
    local0 = $00
    local1 = $00
    If (0.0 = arg3) Then
        For local5 = Each rooms
            local1 = (local1 + $01)
            If (((arg1 = "") Or (arg1 = local5\Field7\Field4)) <> 0) Then
                local2 = $00
                For local4 = Each events
                    If (local4\Field1 = local5) Then
                        local2 = $01
                        Exit
                    EndIf
                Next
                local0 = (local0 + $01)
                If (((local0 >= arg2) And (local2 = $00)) <> 0) Then
                    local3 = (New events)
                    local3\Field0 = arg0
                    local3\Field1 = local5
                    Return local3
                EndIf
            EndIf
        Next
    Else
        For local5 = Each rooms
            If (((arg1 = "") Or (arg1 = local5\Field7\Field4)) <> 0) Then
                local2 = $00
                For local4 = Each events
                    If (local4\Field1 = local5) Then
                        local2 = $01
                        Exit
                    EndIf
                Next
                If (((arg3 > rnd(0.0, 1.0)) And (local2 = $00)) <> 0) Then
                    local3 = (New events)
                    local3\Field0 = arg0
                    local3\Field1 = local5
                EndIf
            EndIf
        Next
    EndIf
    Return Null
    Return Null
End Function
