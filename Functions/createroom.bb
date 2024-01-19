Function createroom.rooms(arg0%, arg1%, arg2#, arg3#, arg4#, arg5$)
    Local local0.rooms
    Local local1.roomtemplates
    Local local2#
    Local local3%
    Local local4%
    local0 = (New rooms)
    local0\Field0 = arg0
    local0\Field3 = arg2
    local0\Field4 = arg3
    local0\Field5 = arg4
    If (arg5 <> "") Then
        debuglog(arg5)
        arg5 = lower(arg5)
        For local1 = Each roomtemplates
            If (local1\Field4 = arg5) Then
                local0\Field7 = local1
                If (playerlevel = arg0) Then
                    local0\Field2 = copyentity(local1\Field0, $00)
                    scaleentity(local0\Field2, roomscale, roomscale, roomscale, $00)
                    entitytype(local0\Field2, $01, $00)
                    entitypickmode(local0\Field2, $02, $01)
                Else
                    local0\Field2 = createpivot($00)
                EndIf
                positionentity(local0\Field2, arg2, arg3, arg4, $00)
                fillroom(local0)
                Return local0
            EndIf
        Next
    EndIf
    local3 = $00
    For local1 = Each roomtemplates
        If (local1\Field3 = arg1) Then
            local3 = (local3 + local1\Field6)
        EndIf
    Next
    local4 = rand(local3, $01)
    local3 = $00
    For local1 = Each roomtemplates
        If (local1\Field3 = arg1) Then
            local3 = (local3 + local1\Field6)
            If (((local4 > (local3 - local1\Field6)) And (local4 <= local3)) <> 0) Then
                local0\Field7 = local1
                local0\Field2 = copyentity(local1\Field0, $00)
                local2 = (1.0 / 256.0)
                scaleentity(local0\Field2, local2, local2, local2, $00)
                positionentity(local0\Field2, arg2, arg3, arg4, $00)
                entitytype(local0\Field2, $01, $00)
                entitypickmode(local0\Field2, $03, $01)
                fillroom(local0)
                Return local0
            EndIf
        EndIf
    Next
    Return Null
End Function
