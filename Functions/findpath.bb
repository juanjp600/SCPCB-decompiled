Function findpath%(arg0.npcs, arg1#, arg2#, arg3#)
    Local local0%
    Local local1#
    Local local2#
    Local local3.waypoints
    Local local4.waypoints
    Local local5.waypoints
    Local local6%
    Local local7%
    Local local8.waypoints
    Local local9.waypoints
    Local local10%
    For local3 = Each waypoints
        local3\Field3 = $00
        local3\Field6 = 0.0
        local3\Field7 = 0.0
        local3\Field8 = 0.0
    Next
    arg0\Field32 = $00
    arg0\Field34 = $00
    For local6 = $00 To $13 Step $01
        arg0\Field31[local6] = Null
    Next
    local0 = createpivot($00)
    positionentity(local0, entityx(arg0\Field4, $01), (entityy(arg0\Field4, $01) + 0.15), entityz(arg0\Field4, $01), $00)
    local7 = createpivot($00)
    positionentity(local7, arg1, arg2, arg3, $01)
    local1 = 10000.0
    For local3 = Each waypoints
        If (20.0 > ((Abs (entityx(local3\Field0, $01) - entityx(local0, $01))) + (Abs (entityz(local3\Field0, $01) - entityz(local0, $01))))) Then
            If (8.0 > (Abs (entityy(local3\Field0, $01) - entityy(local0, $01)))) Then
                local2 = (((Abs (entityx(local3\Field0, $01) - entityx(local7, $01))) + (Abs (entityz(local3\Field0, $01) - entityz(local7, $01)))) + (Abs (entityy(local3\Field0, $01) - entityy(local7, $01))))
                If (local1 > local2) Then
                    If (entityvisible(local3\Field0, local0) <> 0) Then
                        local1 = local2
                        local4 = local3
                    EndIf
                EndIf
            EndIf
        EndIf
    Next
    freeentity(local0)
    If (local4 = Null) Then
        debuglog("startpoint=null")
        Return $02
    EndIf
    local4\Field3 = $01
    local1 = 20.0
    For local3 = Each waypoints
        If (20.0 > ((Abs (entityx(local7, $01) - entityx(local3\Field0, $01))) + (Abs (entityz(local7, $01) - entityz(local3\Field0, $01))))) Then
            local2 = (((Abs (entityx(local3\Field0, $01) - entityx(local7, $01))) + (Abs (entityz(local3\Field0, $01) - entityz(local7, $01)))) + (Abs (entityy(local3\Field0, $01) - entityy(local7, $01))))
            If (local1 > local2) Then
                local1 = local2
                local5 = local3
            EndIf
        EndIf
    Next
    freeentity(local7)
    If (local5 = local4) Then
        debuglog("startpoint=endpoint")
        Return $00
    EndIf
    If (local5 = Null) Then
        debuglog("endpoint=null")
        Return $02
    EndIf
    Repeat
        local0 = $00
        local8 = Null
        local1 = 10000.0
        For local3 = Each waypoints
            If (local3\Field3 = $01) Then
                local0 = $01
                If (local1 > local3\Field6) Then
                    local1 = local3\Field6
                    local8 = local3
                EndIf
            EndIf
        Next
        If (local8 <> Null) Then
            local3 = local8
            local3\Field3 = $02
            debuglog(("Roomname: " + local3\Field2\Field7\Field4))
            For local6 = $00 To $04 Step $01
                If (local3\Field4[local6] <> Null) Then
                    If (local3\Field4[local6]\Field3 < $02) Then
                        If (local3\Field4[local6]\Field3 = $01) Then
                            If (local3\Field4[local6]\Field7 > (local3\Field5[local6] + local3\Field7)) Then
                                local3\Field4[local6]\Field7 = (local3\Field5[local6] + local3\Field7)
                                local3\Field4[local6]\Field6 = (local3\Field4[local6]\Field7 + local3\Field4[local6]\Field8)
                                local3\Field4[local6]\Field9 = local3
                            EndIf
                        Else
                            local3\Field4[local6]\Field8 = ((Abs (entityx(local3\Field4[local6]\Field0, $01) - entityx(local5\Field0, $01))) + (Abs (entityz(local3\Field4[local6]\Field0, $01) - entityz(local5\Field0, $01))))
                            local3\Field4[local6]\Field7 = (local3\Field5[local6] + local3\Field7)
                            local3\Field4[local6]\Field6 = (local3\Field7 + local3\Field8)
                            local3\Field4[local6]\Field9 = local3
                            local3\Field4[local6]\Field3 = $01
                        EndIf
                    EndIf
                EndIf
            Next
        ElseIf (local5\Field3 > $00) Then
            local4\Field9 = Null
            local5\Field3 = $02
            Exit
        EndIf
        If (local5\Field3 > $00) Then
            local4\Field9 = Null
            local5\Field3 = $02
            Exit
        EndIf
    Until (local0 = $00)
    If (local5\Field3 > $00) Then
        local9 = local5
        local10 = $00
        Repeat
            local10 = (local10 + $01)
            local9 = local9\Field9
        Until (local9 = Null)
        debuglog(("length: " + (Str local10)))
        local9 = local5
        For local6 = $00 To (local10 - $01) Step $01
            local0 = $00
            If (local10 < $14) Then
                arg0\Field31[((local10 - $01) - local6)] = local9
            ElseIf (local6 < $14) Then
                arg0\Field31[($13 - local6)] = local3
            EndIf
            If (local9 = local4) Then
                Return $01
            EndIf
            If (local9\Field9 <> Null) Then
                local9 = local9\Field9
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
