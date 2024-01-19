Function strippath$(arg0$)
    Local local0%
    Local local1$
    Local local2$
    If (len(arg0) > $00) Then
        local0 = len(arg0)
        While (local0 >= $01)
            local1 = mid(arg0, local0, $01)
            If (((local1 = "\") Or (local1 = "/")) <> 0) Then
                Return local2
            Else
                local2 = (local1 + local2)
            EndIf
            local0 = (local0 + $FFFFFFFF)
        Wend
    EndIf
    Return local2
    Return ""
End Function
