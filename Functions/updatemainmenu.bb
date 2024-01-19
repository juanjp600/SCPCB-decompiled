Function updatemainmenu%()
    Local local0%
    Local local1%
    Local local2%
    Local local3%
    Local local4%
    Local local6%
    Local local7$
    Local local10%
    Local local11%
    Local local13$
    Local local14%
    cls($01, $01)
    showpointer()
    drawimage(menuback, $00, $00, $00)
    If ((millisecs() Mod menublinktimer($00)) >= rand(menublinkduration($00), $01)) Then
        drawimage(menu173, (graphicwidth - imagewidth(menu173)), (graphicheight - imageheight(menu173)), $00)
    EndIf
    If (rand($12C, $01) = $01) Then
        menublinktimer($00) = rand($FA0, $1F40)
        menublinkduration($00) = rand($C8, $1F4)
    EndIf
    setfont(font1)
    menublinktimer($01) = (Int ((Float menublinktimer($01)) - fpsfactor))
    If (menublinktimer($01) < menublinkduration($01)) Then
        color($32, $32, $32)
        text((rand($FFFFFFFB, $05) + menustrx), (rand($FFFFFFFB, $05) + menustry), menustr, $01, $00)
        If (menublinktimer($01) < $00) Then
            menublinktimer($01) = rand($2BC, $320)
            menublinkduration($01) = rand($0A, $23)
            menustrx = (Int ((Float rand($2BC, $3E8)) * menuscale))
            menustry = (Int ((Float rand($64, $258)) * menuscale))
            Select rand($00, $15)
                Case $00,$02,$03
                    menustr = "DON'T BLINK"
                Case $04,$05
                    menustr = "Secure. Contain. Protect."
                Case $06,$07,$08
                    menustr = "You want happy endings? Fuck you."
                Case $09,$0A,$0B
                    menustr = "Sometimes we would have had time to scream."
                Case $0C,$13
                    menustr = "NIL"
                Case $0D
                    menustr = "NO"
                Case $0E
                    menustr = "black white black white black white gray"
                Case $0F
                    menustr = "Stone does not care"
                Case $10
                    menustr = "9341"
                Case $11
                    menustr = "It controls the doors"
                Case $12
                    menustr = "e8m106]af173o+079m895w914"
                Case $14
                    menustr = "It has taken over everything"
                Case $15
                    menustr = "Check out Fomalhauth"
            End Select
        EndIf
    EndIf
    setfont(font2)
    drawimage(menutext, ((graphicwidth Sar $01) - (imagewidth(menutext) Sar $01)), (Int (((Float graphicheight) - (20.0 * menuscale)) - (Float imageheight(menutext)))), $00)
    If ((Float graphicwidth) > (1240.0 * menuscale)) Then
        drawtiledimagerect(menuwhite, $00, $05, 512.0, (7.0 * menuscale), (Int (985.0 * menuscale)), (Int (407.0 * menuscale)), (Int (((Float graphicwidth) - (1240.0 * menuscale)) + 300.0)), (Int (7.0 * menuscale)))
    EndIf
    If (mainmenutab = $00) Then
        For local6 = $00 To $03 Step $01
            local4 = $00
            local0 = (Int (159.0 * menuscale))
            local1 = (Int ((Float (($64 * local6) + $11E)) * menuscale))
            local2 = (Int (400.0 * menuscale))
            local3 = (Int (70.0 * menuscale))
            If (mouseon(local0, local1, local2, local3) <> 0) Then
                If (mousehit1 <> 0) Then
                    local4 = $01
                EndIf
            EndIf
            Select local6
                Case $00
                    local7 = "NEW GAME"
                    randomseed = ""
                    If (local4 <> 0) Then
                        If (rand($0A, $01) = $01) Then
                            Select rand($0A, $01)
                                Case $01
                                    randomseed = "NIL"
                                Case $02
                                    randomseed = "NO"
                                Case $03
                                    randomseed = "d9341"
                                Case $04
                                    randomseed = "5CP_I73"
                                Case $05
                                    randomseed = "DONTBLINK"
                                Case $06
                                    randomseed = "CRUNCH"
                                Case $07
                                    randomseed = "die"
                                Case $08
                                    randomseed = "HTAED"
                                Case $09
                                    randomseed = "rustledjim"
                                Case $0A
                                    randomseed = "larry"
                            End Select
                        Else
                            local10 = rand($04, $08)
                            For local6 = $01 To local10 Step $01
                                If (rand($03, $01) = $01) Then
                                    randomseed = (randomseed + (Str rand($00, $09)))
                                Else
                                    randomseed = (randomseed + chr(rand($61, $7A)))
                                EndIf
                            Next
                        EndIf
                        mainmenutab = $01
                    EndIf
                Case $01
                    local7 = "LOAD GAME"
                    If (local4 <> 0) Then
                        loadsavegames()
                        mainmenutab = $02
                    EndIf
                Case $02
                    local7 = "OPTIONS"
                    If (local4 <> 0) Then
                        mainmenutab = $03
                    EndIf
                Case $03
                    local7 = "QUIT"
                    If (local4 <> 0) Then
                        end()
                    EndIf
            End Select
            drawbutton(local0, local1, local2, local3, local7, $01)
        Next
    Else
        local0 = (Int (159.0 * menuscale))
        local1 = (Int (286.0 * menuscale))
        local2 = (Int (400.0 * menuscale))
        local3 = (Int (70.0 * menuscale))
        drawframe(local0, local1, local2, local3)
        If (drawbutton((Int ((20.0 * menuscale) + (Float (local0 + local2)))), local1, (Int (((580.0 * menuscale) - (Float local2)) - (20.0 * menuscale))), local3, "BACK", $00) <> 0) Then
            local11 = mainmenutab
            If (local11 = $03) Then
                putinivalue(optionfile, "options", "music volume", (Str musicvolume))
                putinivalue(optionfile, "options", "mouse sensitivity", (Str mousesens))
                putinivalue(optionfile, "options", "invert mouse y", (Str invertmouse))
                putinivalue(optionfile, "options", "bump mapping enabled", (Str bumpenabled))
                putinivalue(optionfile, "options", "HUD enabled", (Str hudenabled))
            EndIf
            mainmenutab = $00
        EndIf
        local1 = (Int ((20.0 * menuscale) + (Float (local1 + local3))))
        local2 = (Int (580.0 * menuscale))
        local3 = (Int (300.0 * menuscale))
        drawframe(local0, local1, local2, local3)
        Select mainmenutab
            Case $01
                local0 = (Int (159.0 * menuscale))
                local1 = (Int (286.0 * menuscale))
                local2 = (Int (400.0 * menuscale))
                local3 = (Int (70.0 * menuscale))
                color($FF, $FF, $FF)
                setfont(font2)
                text(((local2 Sar $01) + local0), ((local3 Sar $01) + local1), "NEW GAME", $01, $01)
                local0 = (Int (160.0 * menuscale))
                local1 = (Int ((20.0 * menuscale) + (Float (local1 + local3))))
                local2 = (Int (580.0 * menuscale))
                local3 = (Int (296.0 * menuscale))
                setfont(font1)
                text((Int ((20.0 * menuscale) + (Float local0))), (Int ((20.0 * menuscale) + (Float local1))), "Name:", $00, $00)
                currsave = inputbox((Int ((100.0 * menuscale) + (Float local0))), (Int ((15.0 * menuscale) + (Float local1))), (Int (200.0 * menuscale)), (Int (30.0 * menuscale)), currsave, $01)
                currsave = left(currsave, $0F)
                text((Int ((20.0 * menuscale) + (Float local0))), (Int ((60.0 * menuscale) + (Float local1))), "Difficulty:", $00, $00)
                If (drawtick((Int ((20.0 * menuscale) + (Float local0))), (Int ((90.0 * menuscale) + (Float local1))), (selectedmode = $00), $00) <> 0) Then
                    selectedmode = $00
                EndIf
                If (drawtick((Int ((20.0 * menuscale) + (Float local0))), (Int ((120.0 * menuscale) + (Float local1))), (selectedmode = $01), $00) <> 0) Then
                    selectedmode = $01
                EndIf
                color($FF, $FF, $FF)
                text((Int ((60.0 * menuscale) + (Float local0))), (Int ((90.0 * menuscale) + (Float local1))), "EUCLID (normal saving)", $00, $00)
                text((Int ((60.0 * menuscale) + (Float local0))), (Int ((120.0 * menuscale) + (Float local1))), "KETER (permanent death)", $00, $00)
                text((Int ((20.0 * menuscale) + (Float local0))), (Int ((160.0 * menuscale) + (Float local1))), "Enable intro sequence:", $00, $00)
                introenabled = drawtick((Int ((200.0 * menuscale) + (Float local0))), (Int ((160.0 * menuscale) + (Float local1))), introenabled, $00)
                color($FF, $FF, $FF)
                text((Int ((20.0 * menuscale) + (Float local0))), (Int ((200.0 * menuscale) + (Float local1))), "Map seed:", $00, $00)
                randomseed = left(inputbox((Int ((150.0 * menuscale) + (Float local0))), (Int ((195.0 * menuscale) + (Float local1))), (Int (200.0 * menuscale)), (Int (30.0 * menuscale)), randomseed, $03), $0F)
                setfont(font2)
                If (drawbutton((Int ((420.0 * menuscale) + (Float local0))), (Int ((20.0 * menuscale) + (Float (local1 + local3)))), (Int (160.0 * menuscale)), (Int (70.0 * menuscale)), "START", $00) <> 0) Then
                    If (currsave <> "") Then
                        If (randomseed = "") Then
                            randomseed = (Str (Abs millisecs()))
                        Else
                            local13 = ""
                            For local6 = $01 To len(randomseed) Step $01
                                local13 = (local13 + (Str asc(mid(local13, local6, $01))))
                            Next
                            randomseed = (Str (Abs (Int local13)))
                        EndIf
                        seedrnd((Int randomseed))
                        local14 = $00
                        For local6 = $01 To savegameamount Step $01
                            If (savegames((local6 - $01)) = currsave) Then
                                local14 = (local14 + $01)
                            EndIf
                        Next
                        If (local14 > $00) Then
                            currsave = (((currsave + " (") + (Str (local14 + $01))) + ")")
                        EndIf
                        loadentities()
                        initnewgame()
                        mainmenuopen = $00
                        flushkeys()
                        flushmouse()
                    EndIf
                EndIf
            Case $02
                local0 = (Int (159.0 * menuscale))
                local1 = (Int (286.0 * menuscale))
                local2 = (Int (400.0 * menuscale))
                local3 = (Int (70.0 * menuscale))
                setfont(font2)
                color($FF, $FF, $FF)
                setfont(font2)
                text(((local2 Sar $01) + local0), ((local3 Sar $01) + local1), "LOAD GAME", $01, $01)
                setfont(font1)
                local0 = (Int (160.0 * menuscale))
                local1 = (Int ((20.0 * menuscale) + (Float (local1 + local3))))
                local2 = (Int (580.0 * menuscale))
                local3 = (Int (296.0 * menuscale))
                If (savegameamount = $00) Then
                    text((Int ((20.0 * menuscale) + (Float local0))), (Int ((20.0 * menuscale) + (Float local1))), "No saved games", $00, $00)
                Else
                    local0 = (Int ((20.0 * menuscale) + (Float local0)))
                    local1 = (Int ((20.0 * menuscale) + (Float local1)))
                    For local6 = $01 To savegameamount Step $01
                        rect(local0, local1, (Int (540.0 * menuscale)), (Int (70.0 * menuscale)), $01)
                        color($00, $00, $00)
                        rect((Int ((2.0 * menuscale) + (Float local0))), (Int ((2.0 * menuscale) + (Float local1))), (Int (536.0 * menuscale)), (Int (66.0 * menuscale)), $01)
                        color($FF, $FF, $FF)
                        text((Int ((20.0 * menuscale) + (Float local0))), (Int ((10.0 * menuscale) + (Float local1))), savegames((local6 - $01)), $00, $00)
                        If (drawbutton((Int ((200.0 * menuscale) + (Float local0))), (Int ((20.0 * menuscale) + (Float local1))), (Int (100.0 * menuscale)), (Int (30.0 * menuscale)), "Load", $00) <> 0) Then
                            loadentities()
                            loadgame(((savepath + savegames((local6 - $01))) + "\"))
                            currsave = savegames((local6 - $01))
                            initloadgame()
                            mainmenuopen = $00
                        EndIf
                        If (drawbutton((Int ((320.0 * menuscale) + (Float local0))), (Int ((20.0 * menuscale) + (Float local1))), (Int (100.0 * menuscale)), (Int (30.0 * menuscale)), "Delete", $00) <> 0) Then
                            deletefile((((currentdir() + savepath) + savegames((local6 - $01))) + "\save.txt"))
                            deletedir(((currentdir() + savepath) + savegames((local6 - $01))))
                            debuglog(((currentdir() + savepath) + savegames((local6 - $01))))
                            loadsavegames()
                            Exit
                        EndIf
                        local1 = (Int ((80.0 * menuscale) + (Float local1)))
                    Next
                EndIf
            Case $03
                local0 = (Int (159.0 * menuscale))
                local1 = (Int (286.0 * menuscale))
                local2 = (Int (400.0 * menuscale))
                local3 = (Int (70.0 * menuscale))
                color($FF, $FF, $FF)
                setfont(font2)
                text(((local2 Sar $01) + local0), ((local3 Sar $01) + local1), "OPTIONS", $01, $01)
                setfont(font1)
                local0 = (Int (160.0 * menuscale))
                local1 = (Int ((20.0 * menuscale) + (Float (local1 + local3))))
                local2 = (Int (580.0 * menuscale))
                local3 = (Int (300.0 * menuscale))
                setfont(font1)
                text((Int ((20.0 * menuscale) + (Float local0))), (Int ((20.0 * menuscale) + (Float local1))), "Mouse sensitivity:", $00, $00)
                mousesens = ((slidebar((Int ((240.0 * menuscale) + (Float local0))), (Int ((20.0 * menuscale) + (Float local1))), (Int (150.0 * menuscale)), ((mousesens + 0.5) * 100.0)) / 100.0) - 0.5)
                color($AA, $AA, $AA)
                text((Int ((180.0 * menuscale) + (Float local0))), (Int ((20.0 * menuscale) + (Float local1))), "LOW", $00, $00)
                text((Int ((426.0 * menuscale) + (Float local0))), (Int ((20.0 * menuscale) + (Float local1))), "HIGH", $00, $00)
                color($FF, $FF, $FF)
                text((Int ((20.0 * menuscale) + (Float local0))), (Int ((60.0 * menuscale) + (Float local1))), "Invert mouse Y-axis:", $00, $00)
                invertmouse = drawtick((Int ((200.0 * menuscale) + (Float local0))), (Int ((58.0 * menuscale) + (Float local1))), invertmouse, $00)
                color($FF, $FF, $FF)
                text((Int ((20.0 * menuscale) + (Float local0))), (Int ((100.0 * menuscale) + (Float local1))), "Music volume:", $00, $00)
                musicvolume = (slidebar((Int ((240.0 * menuscale) + (Float local0))), (Int ((100.0 * menuscale) + (Float local1))), (Int (150.0 * menuscale)), (musicvolume * 100.0)) / 100.0)
                color($AA, $AA, $AA)
                text((Int ((180.0 * menuscale) + (Float local0))), (Int ((100.0 * menuscale) + (Float local1))), "LOW", $00, $00)
                text((Int ((426.0 * menuscale) + (Float local0))), (Int ((100.0 * menuscale) + (Float local1))), "HIGH", $00, $00)
                color($FF, $FF, $FF)
                text((Int ((20.0 * menuscale) + (Float local0))), (Int ((140.0 * menuscale) + (Float local1))), "Enable HUD:", $00, $00)
                hudenabled = drawtick((Int ((200.0 * menuscale) + (Float local0))), (Int ((138.0 * menuscale) + (Float local1))), hudenabled, $00)
                color($FF, $FF, $FF)
                text((Int ((20.0 * menuscale) + (Float local0))), (Int ((180.0 * menuscale) + (Float local1))), "Enable bump mapping:", $00, $00)
                bumpenabled = drawtick((Int ((200.0 * menuscale) + (Float local0))), (Int ((178.0 * menuscale) + (Float local1))), bumpenabled, $00)
        End Select
    EndIf
    If (fullscreen <> 0) Then
        drawimage(cursorimg, mousex(), mousey(), $00)
    EndIf
    setfont(font1)
    Return $00
End Function
