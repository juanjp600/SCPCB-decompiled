Function updateconsole%()
    Local local0%
    Local local1%
    Local local2%
    Local local3%
    Local local4$
    Local local5%
    Local local6%
    Local local7.events
    Local local8.rooms
    Local local9.items
    Local local10%
    Local local11%
    Local local12%
    Local local13%
    Local local15%
    Local local16%
    Local local17%
    Local local18%
    Local local19$
    Local local22%
    Local local25%
    Local local26.consolemsg
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
            achvconsole = $00
            If (instr(consoleinput, " ", $01) > $00) Then
                local4 = lower(left(consoleinput, (instr(consoleinput, " ", $01) - $01)))
            Else
                local4 = lower(consoleinput)
            EndIf
            Select lower(local4)
                Case "status"
                    createconsolemsg("******************************")
                    createconsolemsg("Status: ")
                    createconsolemsg("Coordinates: ")
                    createconsolemsg(((((("    - collider: " + (Str entityx(collider, $00))) + ", ") + (Str entityy(collider, $00))) + ", ") + (Str entityz(collider, $00))))
                    createconsolemsg(((((("    - camera: " + (Str entityx(camera, $00))) + ", ") + (Str entityy(camera, $00))) + ", ") + (Str entityz(camera, $00))))
                    createconsolemsg("Rotation: ")
                    createconsolemsg(((((("    - collider: " + (Str entitypitch(collider, $00))) + ", ") + (Str entityyaw(collider, $00))) + ", ") + (Str entityroll(collider, $00))))
                    createconsolemsg(((((("    - camera: " + (Str entitypitch(camera, $00))) + ", ") + (Str entityyaw(camera, $00))) + ", ") + (Str entityroll(camera, $00))))
                    createconsolemsg(("Room: " + playerroom\Field7\Field4))
                    For local7 = Each events
                        If (local7\Field1 = playerroom) Then
                            createconsolemsg(("Room event: " + local7\Field0))
                            createconsolemsg(("-    state: " + (Str local7\Field2)))
                            Exit
                        EndIf
                    Next
                    createconsolemsg(((("Room coordinates: " + (Str floor(((entityx(playerroom\Field2, $00) / 8.0) + 0.5)))) + ", ") + (Str floor(((entityz(playerroom\Field2, $00) / 8.0) + 0.5)))))
                    createconsolemsg(("Stamina: " + (Str stamina)))
                    createconsolemsg(("Death timer: " + (Str killtimer)))
                    createconsolemsg(("Blinktimer: " + (Str blinktimer)))
                    createconsolemsg(("Level: " + (Str playerlevel)))
                    createconsolemsg("******************************")
                Case "camerapick"
                    local15 = camerapick(camera, (Float (graphicwidth Sar $01)), (Float (graphicheight Sar $01)))
                    If (local15 = $00) Then
                        createconsolemsg("******************************")
                        createconsolemsg("No entity  picked")
                        createconsolemsg("******************************")
                    Else
                        createconsolemsg("******************************")
                        createconsolemsg("Picked entity:")
                        local16 = getsurface(local15, $01)
                        local17 = getsurfacebrush(local16)
                        local18 = getbrushtexture(local17, $00)
                        local19 = strippath(texturename(local18))
                        createconsolemsg(("Texture name: " + local19))
                        createconsolemsg(((((("Coordinates:" + (Str entityx(local15, $00))) + ", ") + (Str entityy(local15, $00))) + ", ") + (Str entityz(local15, $00))))
                        createconsolemsg("******************************")
                    EndIf
                Case "ending"
                    selectedending = lower(right(consoleinput, (len(consoleinput) - instr(consoleinput, " ", $01))))
                    killtimer = -0.1
                    endingtimer = -0.1
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
                    For local8 = Each rooms
                        If (local8\Field7\Field4 = local4) Then
                            positionentity(collider, entityx(local8\Field2, $00), 0.7, entityz(local8\Field2, $00), $00)
                            resetentity(collider)
                            updatedoors()
                            updaterooms()
                            playerroom = local8
                            Exit
                        EndIf
                    Next
                Case "spawnitem"
                    local4 = lower(right(consoleinput, (len(consoleinput) - instr(consoleinput, " ", $01))))
                    For local9 = Each items
                        If ((Int lower((Str (local9\Field1\Field0 = local4)))) <> 0) Then
                            createitem(local9\Field1\Field0, local9\Field1\Field1, entityx(collider, $00), entityy(collider, $00), entityz(collider, $00))
                            entitytype(local9\Field0, $03, $00)
                            Exit
                        EndIf
                    Next
                    createconsolemsg((local4 + " spawned"))
                Case "wireframe"
                    local4 = lower(right(consoleinput, (len(consoleinput) - instr(consoleinput, " ", $01))))
                    Select local4
                        Case "on","1","true"
                            wireframe($01)
                            createconsolemsg("WIREFRAME ON")
                        Case "off","0","false"
                            wireframe($00)
                            createconsolemsg("WIREFRAME OFF")
                    End Select
                Case "173speed"
                    local4 = lower(right(consoleinput, (len(consoleinput) - instr(consoleinput, " ", $01))))
                    curr173\Field17 = (Float local4)
                    createconsolemsg(("173;s speed set to " + local4))
                Case "106speed"
                    local4 = lower(right(consoleinput, (len(consoleinput) - instr(consoleinput, " ", $01))))
                    curr106\Field17 = (Float local4)
                    createconsolemsg(("106;s speed set to " + local4))
                Case "173state"
                    createconsolemsg("SCP-173")
                    createconsolemsg(((((("Position: " + (Str entityx(curr173\Field0, $00))) + ", ") + (Str entityy(curr173\Field0, $00))) + ", ") + (Str entityz(curr173\Field0, $00))))
                    createconsolemsg(("Idle: " + (Str curr173\Field19)))
                    createconsolemsg(("State: " + (Str curr173\Field9)))
                Case "106state"
                    createconsolemsg("SCP-106")
                    createconsolemsg(((((("Position: " + (Str entityx(curr106\Field0, $00))) + ", ") + (Str entityy(curr106\Field0, $00))) + ", ") + (Str entityz(curr106\Field0, $00))))
                    createconsolemsg(("Idle: " + (Str curr106\Field19)))
                    createconsolemsg(("State: " + (Str curr106\Field9)))
                Case "disable173"
                    curr173\Field19 = $01
                Case "enable173"
                    curr173\Field19 = $00
                Case "disable106"
                    curr106\Field19 = $01
                    curr106\Field9 = 200000.0
                    contained106 = $01
                Case "enable106"
                    curr106\Field19 = $00
                Case "halloween"
                    local22 = loadtexture("GFX\npcs\173h.pt", $01)
                    entitytexture(curr173\Field0, local22, $00, $02)
                Case "sanic"
                    superman = $01
                    createconsolemsg("GOTTA GO FAST")
                Case "scp-420-j","420","weed"
                    For local6 = $01 To $14 Step $01
                        If (rand($02, $01) = $01) Then
                            local9 = createitem("Some SCP-420-J", "420", ((cos((18.0 * (Float local6))) * rnd(0.3, 0.5)) + entityx(collider, $01)), entityy(camera, $01), ((sin((18.0 * (Float local6))) * rnd(0.3, 0.5)) + entityz(collider, $01)))
                        Else
                            local9 = createitem("Joint", "420s", ((cos((18.0 * (Float local6))) * rnd(0.3, 0.5)) + entityx(collider, $01)), entityy(camera, $01), ((sin((18.0 * (Float local6))) * rnd(0.3, 0.5)) + entityz(collider, $01)))
                        EndIf
                        entitytype(local9\Field0, $03, $00)
                    Next
                    tempsound = loadsound("SFX\Mandeville.ogg")
                    playsound(tempsound)
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
        local25 = ((local1 + local3) - $46)
        For local26 = Each consolemsg
            If (local25 < (local1 + $14)) Then
                Delete local26
            Else
                text((local0 + $1E), local25, local26\Field0, $00, $00)
                local25 = (local25 - $0F)
            EndIf
        Next
    EndIf
    Return $00
End Function
