Function rinput$(arg0$)
    Local local0%
    Local local1%
    local0 = getkey()
    local1 = len(arg0)
    If (local0 = $08) Then
        local0 = $00
        If (local1 > $00) Then
            arg0 = left(arg0, (local1 - $01))
        EndIf
    EndIf
    If (((local0 = $0D) Or (local0 = $00)) <> 0) Then
        Return arg0
    ElseIf ((((((local0 > $00) And (local0 < $07)) Or (local0 > $1A)) And (local0 < $20)) Or (local0 = $09)) <> 0) Then
        Return arg0
    Else
        arg0 = (arg0 + chr(local0))
        Return arg0
    EndIf
    Return ""
End Function
