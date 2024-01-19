Function initloadingscreens%(arg0$)
    Local local0$
    Local local1%
    Local local2%
    Local local3%
    Local local4%
    Local local5$
    Local local6%
    Local local7.loadingscreens
    local4 = $00
    local5 = ""
    local6 = openfile(arg0)
    While (eof(local6) = $00)
        local0 = trim(readline(local6))
        If (left(local0, $01) = "[") Then
            local0 = mid(local0, $02, (len(local0) - $02))
            local7 = (New loadingscreens)
            loadingscreenamount = (loadingscreenamount + $01)
            local7\Field2 = loadingscreenamount
            local7\Field3 = local0
            local7\Field0 = getinistring(arg0, local0, "image path")
            For local2 = $00 To $04 Step $01
                local7\Field7[local2] = getinistring(arg0, local0, ("text" + (Str (local2 + $01))))
                If (local7\Field7[local2] <> "") Then
                    local7\Field8 = (local7\Field8 + $01)
                EndIf
            Next
            local7\Field6 = getiniint(arg0, local0, "disablebackground")
            Select lower(getinistring(arg0, local0, "align x"))
                Case "left"
                    local7\Field4 = $FFFFFFFF
                Case "middle","center"
                    local7\Field4 = $00
                Case "right"
                    local7\Field4 = $01
            End Select
            Select lower(getinistring(arg0, local0, "align y"))
                Case "top","up"
                    local7\Field5 = $FFFFFFFF
                Case "middle","center"
                    local7\Field5 = $00
                Case "bottom","down"
                    local7\Field5 = $01
            End Select
        EndIf
    Wend
    closefile(local6)
    Return $00
End Function
