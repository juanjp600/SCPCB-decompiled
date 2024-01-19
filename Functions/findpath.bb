Function findpath%(arg0.npcs, arg1#, arg2#, arg3#)
    Local local0%
    Local local1#
    Local local2#
    Local local3#
    Local local4%
    Local local5#
    Local local6.waypoints
    Local local7.waypoints
    Local local8.waypoints
    Local local9%
    Local local10%
    Local local11.waypoints
    Local local12#
    Local local13.waypoints
    Local local14%
    For local6 = Each waypoints
        local6\Field3 = $00
        local6\Field6 = 0.0
        local6\Field7 = 0.0
        local6\Field8 = 0.0
    Next
    arg0\Field32 = $00
    arg0\Field34 = $00
    For local9 = $00 To $13 Step $01
        arg0\Field31[local9] = Null
    Next
    local0 = createpivot($00)
    positionentity(local0, entityx(arg0\Field4, $01), (entityy(arg0\Field4, $01) + 0.15), entityz(arg0\Field4, $01), $00)
    local10 = createpivot($00)
    positionentity(local10, arg1, arg2, arg3, $01)
    local1 = 10000.0
    For local6 = Each waypoints
        local3 = (Abs (entityx(local6\Field0, $01) - entityx(local0, $01)))
        If (8.0 > local3) Then
            local5 = (Abs (entityz(local6\Field0, $01) - entityz(local0, $01)))
            If (8.0 > local5) Then
                If (8.0 > (Abs (entityy(local6\Field0, $01) - entityy(local0, $01)))) Then
                    local2 = ((Abs (entityy(local6\Field0, $01) - entityy(local10, $01))) + (local3 + local5))
                    local2 = ((entitydistance(local6\Field0, arg0\Field4) * 2.0) + local2)
                    If (local1 > local2) Then
                        If (entityvisible(local6\Field0, local0) <> 0) Then
                            local1 = local2
                            local7 = local6
                        EndIf
                    EndIf
                EndIf
            EndIf
        EndIf
    Next
    freeentity(local0)
    If (local7 = Null) Then
        debuglog("startpoint=null")
        Return $02
    EndIf
    local7\Field3 = $01
    local1 = 20.0
    For local6 = Each waypoints
        local3 = (Abs (entityx(local10, $01) - entityx(local6\Field0, $01)))
        If (8.0 >= local3) Then
            local5 = (Abs (entityz(local10, $01) - entityz(local6\Field0, $01)))
            If (8.0 >= local5) Then
                local2 = ((Abs (entityy(local6\Field0, $01) - entityy(local10, $01))) + (local3 + local5))
                If (local1 > local2) Then
                    local1 = local2
                    local8 = local6
                EndIf
            EndIf
        EndIf
    Next
    freeentity(local10)
    If (local8 = local7) Then
        debuglog("startpoint=endpoint")
        If (0.4 > local1) Then
            Return $00
        Else
            arg0\Field31[$00] = local8
            Return $01
        EndIf
    EndIf
    If (local8 = Null) Then
        debuglog("endpoint=null")
        Return $02
    EndIf
    Repeat
        local0 = $00
        local11 = Null
        local1 = 10000.0
        For local6 = Each waypoints
            If (local6\Field3 = $01) Then
                local0 = $01
                If (local1 > local6\Field6) Then
                    local1 = local6\Field6
                    local11 = local6
                EndIf
            EndIf
        Next
        If (local11 <> Null) Then
            local6 = local11
            local6\Field3 = $02
            debuglog(("Roomname: " + local6\Field2\Field7\Field4))
            For local9 = $00 To $04 Step $01
                If (local6\Field4[local9] <> Null) Then
                    If (local6\Field4[local9]\Field3 < $02) Then
                        If (local6\Field4[local9]\Field3 = $01) Then
                            local12 = (local6\Field5[local9] + local6\Field7)
                            If (arg0\Field5 = $08) Then
                                If (local6\Field4[local9]\Field1 = Null) Then
                                    local12 = (local12 + 0.5)
                                EndIf
                            EndIf
                            If (local12 < local6\Field4[local9]\Field7) Then
                                local6\Field4[local9]\Field7 = local12
                                local6\Field4[local9]\Field6 = (local6\Field4[local9]\Field7 + local6\Field4[local9]\Field8)
                                local6\Field4[local9]\Field9 = local6
                            EndIf
                        Else
                            local6\Field4[local9]\Field8 = ((Abs (entityx(local6\Field4[local9]\Field0, $01) - entityx(local8\Field0, $01))) + (Abs (entityz(local6\Field4[local9]\Field0, $01) - entityz(local8\Field0, $01))))
                            local12 = (local6\Field5[local9] + local6\Field7)
                            If (arg0\Field5 = $08) Then
                                If (local6\Field4[local9]\Field1 = Null) Then
                                    local12 = (local12 + 0.5)
                                EndIf
                            EndIf
                            local6\Field4[local9]\Field7 = local12
                            local6\Field4[local9]\Field6 = (local6\Field7 + local6\Field8)
                            local6\Field4[local9]\Field9 = local6
                            local6\Field4[local9]\Field3 = $01
                        EndIf
                    EndIf
                EndIf
            Next
        ElseIf (local8\Field3 > $00) Then
            local7\Field9 = Null
            local8\Field3 = $02
            Exit
        EndIf
        If (local8\Field3 > $00) Then
            local7\Field9 = Null
            local8\Field3 = $02
            Exit
        EndIf
    Until (local0 = $00)
    If (local8\Field3 > $00) Then
        local13 = local8
        local14 = $00
        Repeat
            local14 = (local14 + $01)
            local13 = local13\Field9
        Until (local13 = Null)
        debuglog(("length: " + (Str local14)))
        local13 = local8
        For local9 = $00 To (local14 - $01) Step $01
            local0 = $00
            If (local14 < $14) Then
                arg0\Field31[((local14 - $01) - local9)] = local13
            ElseIf (local9 < $14) Then
                arg0\Field31[($13 - local9)] = local6
            EndIf
            If (local13 = local7) Then
                Return $01
            EndIf
            If (local13\Field9 <> Null) Then
                local13 = local13\Field9
            Else
                Exit
            EndIf
        Next
    Else
        debuglog("FUNCTION FindPath() - reitti? ei l?ytynyt")
        Return $02
    EndIf
    Return $00
End Function
