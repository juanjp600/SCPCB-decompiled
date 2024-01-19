Function updateconsole%()
    Local local0%
    Local local1%
    Local local2%
    Local local3%
    Local local4$
    Local local5%
    Local local6%
    Local local7%
    Local local8%
    Local local9%
    Local local10%
    Local local13.rooms
    Local local14.items
    Local local15%
    Local local16.consolemsg
    If (consoleopen <> 0) Then
        local0 = $14
        local1 = $14
        local2 = $190
        local3 = $1F4
        color($FF, $FF, $FF)
        rect(local0, local1, local2, local3, $01)
        color($00, $00, $00)
        rect((local0 + $0A), (local1 + $0A), (local2 - $14), (local3 - $3C), $01)
        rect((local0 + $0A), ((local1 + local3) - $28), (local2 - $14), $1E, $01)
        color($FF, $FF, $FF)
        text((local0 + $1E), ((local1 + local3) - $23), consoleinput, $00, $00)
        selectedinputbox = $02
        consoleinput = inputbox((local0 + $0A), ((local1 + local3) - $28), (local2 - $14), $1E, consoleinput, $02)
        consoleinput = left(consoleinput, $32)
        If ((keyhit($1C) And (consoleinput <> "")) <> 0) Then
            If (instr(consoleinput, " ", $01) > $00) Then
                local4 = lower(left(consoleinput, (instr(consoleinput, " ", $01) - $01)))
            Else
                local4 = lower(consoleinput)
            EndIf
            Select lower(local4)
                Case "status"
                    createconsolemsg("Status: ")
                    createconsolemsg(((((("Coordinates: " + (Str entityx(collider, $00))) + ", ") + (Str entityy(collider, $00))) + ", ") + (Str entityz(collider, $00))))
                    createconsolemsg(("Room: " + playerroom\Field5\Field4))
                    createconsolemsg(("Stamina: " + (Str stamina)))
                    createconsolemsg(("Blinktimer: " + (Str blinktimer)))
                Case "teleport"
                    local4 = lower(right(consoleinput, (len(consoleinput) - instr(consoleinput, " ", $01))))
                    Select local4
                        Case "895","scp-895"
                            local4 = "coffin"
                        Case "scp-914"
                            local4 = "914"
                        Case "offices","office"
                            local4 = "room2offices"
                    End Select
                    For local13 = Each rooms
                        If (local13\Field5\Field4 = local4) Then
                            positionentity(collider, entityx(local13\Field0, $00), 0.7, entityz(local13\Field0, $00), $00)
                            resetentity(collider)
                            playerroom = local13
                            Exit
                        EndIf
                    Next
                Case "spawnitem"
                    local4 = lower(right(consoleinput, (len(consoleinput) - instr(consoleinput, " ", $01))))
                    For local14 = Each items
                        If ((Int lower((Str (local14\Field11 = local4)))) <> 0) Then
                            createitem(local14\Field11, local14\Field10, entityx(collider, $00), entityy(collider, $00), entityz(collider, $00), local14\Field3, local14\Field4, local14\Field5, local14\Field7, "")
                            entitytype(local14\Field0, $03, $00)
                            Exit
                        EndIf
                    Next
                    createconsolemsg((local4 + " spawned"))
                Case "173speed"
                    local4 = lower(right(consoleinput, (len(consoleinput) - instr(consoleinput, " ", $01))))
                    curr173\Field11 = (Float local4)
                    createconsolemsg(("173;s speed set to " + local4))
                Case "106speed"
                    local4 = lower(right(consoleinput, (len(consoleinput) - instr(consoleinput, " ", $01))))
                    curr106\Field11 = (Float local4)
                    createconsolemsg(("106;s speed set to " + local4))
                Case "173state"
                    createconsolemsg("SCP-173")
                    createconsolemsg(((((("Position: " + (Str entityx(curr173\Field0, $00))) + ", ") + (Str entityy(curr173\Field0, $00))) + ", ") + (Str entityz(curr173\Field0, $00))))
                    createconsolemsg(("Idle: " + (Str curr173\Field12)))
                    createconsolemsg(("State: " + (Str curr173\Field6)))
                Case "106state"
                    createconsolemsg("SCP-106")
                    createconsolemsg(((((("Position: " + (Str entityx(curr106\Field0, $00))) + ", ") + (Str entityy(curr106\Field0, $00))) + ", ") + (Str entityz(curr106\Field0, $00))))
                    createconsolemsg(("Idle: " + (Str curr106\Field12)))
                    createconsolemsg(("State: " + (Str curr106\Field6)))
                Case "disable173"
                    curr173\Field12 = $01
                Case "enable173"
                    curr173\Field12 = $00
                Case "disable106"
                    curr106\Field12 = $01
                    curr106\Field6 = 200000.0
                Case "enable106"
                    curr106\Field12 = $00
                Case "sanic"
                    superman = $01
                    createconsolemsg("GOTTA GO FAST")
                Case "godmode"
                    godmode = $01
                    createconsolemsg("GODMODE")
                Default
                    createconsolemsg("Command not found")
            End Select
            consoleinput = ""
        EndIf
        local15 = ((local1 + local3) - $46)
        For local16 = Each consolemsg
            If (local15 < (local1 + $14)) Then
                Delete local16
            Else
                text((local0 + $1E), local15, local16\Field0, $00, $00)
                local15 = (local15 - $0F)
            EndIf
        Next
    EndIf
    Return $00
End Function
