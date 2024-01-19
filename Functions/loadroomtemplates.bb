Function loadroomtemplates%(arg0$)
    Local local0$
    Local local1%
    Local local2%
    Local local3%
    Local local4.roomtemplates
    Local local5$
    Local local6%
    local4 = Null
    local5 = ""
    local6 = openfile(arg0)
    While (eof(local6) = $00)
        local0 = trim(readline(local6))
        If (left(local0, $01) = "[") Then
            local0 = mid(local0, $02, (len(local0) - $02))
            local5 = getinistring(arg0, local0, "mesh path")
            debuglog(local5)
            local4 = createroomtemplate(local5)
            local4\Field4 = local0
            local5 = getinistring(arg0, local0, "shape")
            Select local5
                Case "room1","1"
                    local4\Field3 = $01
                Case "room2","2"
                    local4\Field3 = $02
                Case "room2c","2c","2C"
                    local4\Field3 = $03
                Case "room3","3"
                    local4\Field3 = $04
                Case "room4","4"
                    local4\Field3 = $05
            End Select
            debuglog(((local4\Field4 + " - ") + (Str local4\Field3)))
            local4\Field6 = (Int max(min((Float getiniint(arg0, local0, "commonness")), 100.0), 0.0))
            local4\Field7 = getiniint(arg0, local0, "disabledecals")
            local4\Field8 = getiniint(arg0, local0, "walksound")
        EndIf
    Wend
    closefile(local6)
    Return $00
End Function
