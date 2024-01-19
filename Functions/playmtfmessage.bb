Function playmtfmessage%(arg0%)
    If (selecteditem <> Null) Then
        If (((3.0 = selecteditem\Field8) And (0.0 < selecteditem\Field7)) <> 0) Then
            Select selecteditem\Field1\Field1
                Case "radio","fineradio","18vradio"
                    If (radiochn($03) <> $00) Then
                        stopchannel(radiochn($03))
                    EndIf
                    radiochn($03) = playsound(arg0)
            End Select
        EndIf
    EndIf
    Return $00
End Function
