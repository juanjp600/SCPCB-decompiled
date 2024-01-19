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
    Local local12.events
    Local local13%
    Local local14%
    Local local15%
    Local local16%
    Local local17$
    Local local19.rooms
    Local local20.items
    Local local23%
    Local local24.consolemsg
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
                    createconsolemsg("******************************")
                    createconsolemsg("Status: ")
                    createconsolemsg(((((("Coordinates: " + (Str entityx(collider, $00))) + ", ") + (Str entityy(collider, $00))) + ", ") + (Str entityz(collider, $00))))
                    createconsolemsg(("Room: " + playerroom\Field6\Field4))
                    For local12 = Each events
                        If (local12\Field1 = playerroom) Then
                            createconsolemsg(("Room event: " + local12\Field0))
                            createconsolemsg(("-    state: " + (Str local12\Field2)))
                            Exit
                        EndIf
                    Next
                    createconsolemsg(("Stamina: " + (Str stamina)))
                    createconsolemsg(("Blinktimer: " + (Str blinktimer)))
                    createconsolemsg(("Level: " + (Str playerlevel)))
                    createconsolemsg("******************************")
                Case "camerapick"
                    local13 = camerapick(camera, (Float (graphicwidth Sar $01)), (Float (graphicheight Sar $01)))
                    If (local13 = $00) Then
                        createconsolemsg("******************************")
                        createconsolemsg("No entity  picked")
                        createconsolemsg("******************************")
                    Else
                        createconsolemsg("******************************")
                        createconsolemsg("Picked entity:")
                        local14 = getsurface(local13, $01)
                        local15 = getsurfacebrush(local14)
                        local16 = getbrushtexture(local15, $00)
                        local17 = strippath(texturename(local16))
                        createconsolemsg(("Texture name: " + local17))
                        createconsolemsg(((((("Coordinates:" + (Str entityx(local13, $00))) + ", ") + (Str entityy(local13, $00))) + ", ") + (Str entityz(local13, $00))))
                        createconsolemsg("******************************")
                    EndIf
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
                    For local19 = Each rooms
                        If (local19\Field6\Field4 = local4) Then
                            positionentity(collider, entityx(local19\Field1, $00), 0.7, entityz(local19\Field1, $00), $00)
                            resetentity(collider)
                            playerroom = local19
                            Exit
                        EndIf
                    Next
                Case "spawnitem"
                    local4 = lower(right(consoleinput, (len(consoleinput) - instr(consoleinput, " ", $01))))
                    For local20 = Each items
                        If ((Int lower((Str (local20\Field1\Field0 = local4)))) <> 0) Then
                            createitem(local20\Field1\Field0, local20\Field1\Field1, entityx(collider, $00), entityy(collider, $00), entityz(collider, $00))
                            entitytype(local20\Field0, $03, $00)
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
                    local4 = lower(right(consoleinput, (len(consoleinput) - instr(consoleinput, " ", $01))))
                    Select local4
                        Case "on","1","true"
                            godmode = $01
                            createconsolemsg("GODMODE ON")
                        Case "off","0","false"
                            godmode = $00
                            createconsolemsg("GODMODE OFF")
                    End Select
                Case "noclip"
                    local4 = lower(right(consoleinput, (len(consoleinput) - instr(consoleinput, " ", $01))))
                    Select local4
                        Case "on","1","true"
                            noclip = $01
                            createconsolemsg("NOCLIP ON")
                        Case "off","0","false"
                            noclip = $00
                            createconsolemsg("NOCLIP OFF")
                            rotateentity(collider, 0.0, entityyaw(collider, $00), 0.0, $00)
                    End Select
                    dropspeed = 0.0
                Default
                    createconsolemsg("Command not found")
            End Select
            consoleinput = ""
        EndIf
        local23 = ((local1 + local3) - $46)
        For local24 = Each consolemsg
            If (local23 < (local1 + $14)) Then
                Delete local24
            Else
                text((local0 + $1E), local23, local24\Field0, $00, $00)
                local23 = (local23 - $0F)
            EndIf
        Next
    EndIf
    Return $00
End Function
