Function usedoor%(arg0.doors, arg1%)
    Local local0%
    Local local2%
    Local local3%
    Local local4#
    Local local5#
    Local local6#
    Local local7.doors
    If (arg0\Field11 > $00) Then
        If (selecteditem = Null) Then
            If (arg1 = $01) Then
                msg = "You need a key card to operate the door"
                msgtimer = 350.0
            EndIf
            Return $00
        Else
            local0 = $00
            Select selecteditem\Field1\Field1
                Case "key1"
                    local0 = $01
                Case "key2"
                    local0 = $02
                Case "key3"
                    local0 = $03
                Case "key4"
                    local0 = $04
                Case "key5"
                    local0 = $05
                Case "key6"
                    local0 = $06
                Default
                    local0 = $FFFFFFFF
            End Select
            If (local0 = $FFFFFFFF) Then
                If (arg1 = $01) Then
                    msg = "You need a key card to operate the door"
                    msgtimer = 350.0
                EndIf
                Return $00
            ElseIf (local0 >= arg0\Field11) Then
                If (arg1 = $01) Then
                    msg = "You inserted the key card into the slot"
                    msgtimer = 350.0
                EndIf
                selecteditem = Null
            Else
                If (arg1 = $01) Then
                    msg = "You need a key card with a higher security clearance to operate the door"
                    msgtimer = 350.0
                    selecteditem = Null
                EndIf
                Return $00
            EndIf
        EndIf
    ElseIf (arg0\Field4 <> 0) Then
        If (arg1 = $01) Then
            msg = "It seems to be locked"
            msgtimer = 350.0
        EndIf
        Return $00
    EndIf
    If (arg0\Field17 <> $42) Then
        local2 = playerlevel
        local3 = arg0\Field17
        For local7 = Each doors
            If (local7\Field17 = local2) Then
                pointentity(collider, arg0\Field0, 0.0)
                rotateentity(collider, 0.0, entityyaw(collider, $00), 0.0, $00)
                positionentity(collider, entityx(local7\Field0, $00), entityy(local7\Field0, $00), entityz(local7\Field0, $00), $00)
                moveentity(collider, 0.0, 0.0, 0.4)
                local4 = entityx(collider, $00)
                local5 = entityx(collider, $00)
                local6 = entityx(collider, $00)
            EndIf
        Next
        savegame(((savepath + currsave) + "\"))
        nullgame()
        playerlevel = local3
        loadentities()
        loadgame(((savepath + currsave) + "\"))
        initloadgame()
        playerlevel = local3
        Return $00
    Else
        arg0\Field5 = (arg0\Field5 = $00)
        If (arg0\Field19 <> Null) Then
            arg0\Field19\Field5 = (arg0\Field19\Field5 = $00)
        EndIf
        If (arg0\Field5 <> 0) Then
            If (arg0\Field19 <> Null) Then
                arg0\Field19\Field10 = (Float arg0\Field19\Field9)
            EndIf
            arg0\Field10 = (Float arg0\Field9)
            If (arg0\Field8 = $01) Then
                arg0\Field13 = playsound2(bigdooropensfx, camera, arg0\Field0, 10.0, 1.0, $01)
            Else
                arg0\Field13 = playsound2(opendoorsfx(rand($00, $02)), camera, arg0\Field0, 10.0, 1.0, $01)
            EndIf
        ElseIf (arg0\Field8 = $01) Then
            arg0\Field13 = playsound2(bigdoorclosesfx, camera, arg0\Field0, 10.0, 1.0, $01)
        Else
            arg0\Field13 = playsound2(closedoorsfx(rand($00, $02)), camera, arg0\Field0, 10.0, 1.0, $01)
        EndIf
    EndIf
    Return $00
End Function
