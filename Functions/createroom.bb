Function createroom.rooms(arg0%, arg1#, arg2#, arg3#, arg4$)
    Local local0.rooms
    Local local1.roomtemplates
    Local local2#
    Local local3%
    Local local4%
    local0 = (New rooms)
    local0\Field1 = arg1
    local0\Field2 = arg2
    local0\Field3 = arg3
    If (arg4 <> "") Then
        debuglog(arg4)
        arg4 = lower(arg4)
        For local1 = Each roomtemplates
            If (local1\Field4 = arg4) Then
                local0\Field5 = local1
                local0\Field0 = copyentity(local1\Field0, $00)
                local2 = (1.0 / 256.0)
                scaleentity(local0\Field0, local2, local2, local2, $00)
                positionentity(local0\Field0, arg1, arg2, arg3, $00)
                entitytype(local0\Field0, $01, $00)
                entitypickmode(local0\Field0, $02, $01)
                fillroom(local0)
                Return local0
            EndIf
        Next
    EndIf
    local3 = $00
    For local1 = Each roomtemplates
        If (local1\Field3 = arg0) Then
            local3 = (local3 + local1\Field6)
        EndIf
    Next
    local4 = rand(local3, $01)
    local3 = $00
    For local1 = Each roomtemplates
        If (local1\Field3 = arg0) Then
            local3 = (local3 + local1\Field6)
            If (((local4 > (local3 - local1\Field6)) And (local4 <= local3)) <> 0) Then
                local0\Field5 = local1
                local0\Field0 = copyentity(local1\Field0, $00)
                local2 = (1.0 / 256.0)
                scaleentity(local0\Field0, local2, local2, local2, $00)
                positionentity(local0\Field0, arg1, arg2, arg3, $00)
                entitytype(local0\Field0, $01, $00)
                entitypickmode(local0\Field0, $03, $01)
                fillroom(local0)
                Return local0
            EndIf
        EndIf
    Next
    Return Null
End Function
