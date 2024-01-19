Function usedoor%(arg0.doors)
    Local local0%
    If (arg0\Field11 > $00) Then
        If (selecteditem = Null) Then
            msg = "You need a key card to operate the door"
            msgtimer = 350.0
            Return $00
        Else
            local0 = $00
            Select selecteditem\Field10
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
                msg = "You need a key card to operate the door"
                msgtimer = 350.0
                Return $00
            ElseIf (local0 >= arg0\Field11) Then
                msg = "You inserted the key card into the slot"
                msgtimer = 350.0
                selecteditem = Null
            Else
                msg = "You need a key card with a higher security clearance to operate the door"
                msgtimer = 350.0
                selecteditem = Null
                Return $00
            EndIf
        EndIf
    ElseIf (arg0\Field4 <> 0) Then
        msg = "It seems to be locked"
        msgtimer = 350.0
        Return $00
    EndIf
    arg0\Field5 = (arg0\Field5 = $00)
    If (arg0\Field14 <> Null) Then
        arg0\Field14\Field5 = (arg0\Field14\Field5 = $00)
    EndIf
    If (arg0\Field5 <> 0) Then
        If (arg0\Field14 <> Null) Then
            arg0\Field14\Field10 = (Float arg0\Field14\Field9)
        EndIf
        arg0\Field10 = (Float arg0\Field9)
        If (arg0\Field8 = $01) Then
            playsound2(bigdooropensfx, camera, arg0\Field0, 10.0, 1.0)
        Else
            playsound2(opendoorsfx(rand($00, $02)), camera, arg0\Field0, 10.0, 1.0)
        EndIf
    ElseIf (arg0\Field8 = $01) Then
        playsound2(bigdoorclosesfx, camera, arg0\Field0, 10.0, 1.0)
    Else
        playsound2(closedoorsfx(rand($00, $02)), camera, arg0\Field0, 10.0, 1.0)
    EndIf
    Return $00
End Function
