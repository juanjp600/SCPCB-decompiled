Function drawmenu%()
    Local local0%
    Local local1%
    Local local2%
    Local local3%
    If (menuopen <> 0) Then
        invopen = $00
        local2 = imagewidth(pausemenuimg)
        local3 = imageheight(pausemenuimg)
        local0 = ((graphicwidth Sar $01) - (local2 Sar $01))
        local1 = ((graphicheight Sar $01) - (local3 Sar $01))
        drawimage(pausemenuimg, local0, local1, $00)
        color($FF, $FF, $FF)
        local0 = (local0 + $84)
        local1 = (local1 + $7A)
        text(local0, local1, "Designation: D-9341", $00, $00)
        text(local0, (local1 + $14), "Name: [REDACTED]", $00, $00)
        text(local0, (local1 + $32), ("Save: " + currsave), $00, $00)
        text(local0, (local1 + $46), ("Map seed: " + randomseed), $00, $00)
        local0 = (local0 - $84)
        local1 = (local1 - $7A)
        local0 = (local0 + $31)
        local1 = (local1 - $05)
        If (0.0 <= killtimer) Then
            setfont(font2)
            text(((local2 Sar $01) + local0), (local1 + $14), "PAUSED", $01, $00)
            setfont(font1)
        Else
            setfont(font2)
            text(((local2 Sar $01) + local0), (local1 + $14), "YOU DIED", $01, $00)
            setfont(font1)
        EndIf
        local0 = (local0 - $4D)
        local1 = (local1 + $82)
        If (selectedmode = $00) Then
            If (0.0 <= killtimer) Then
                If (drawbutton((((local2 Sar $01) + local0) - $96), (local1 + $9A), $12C, $3C, "Resume", $01) <> 0) Then
                    menuopen = $00
                EndIf
                If (((playerroom\Field7\Field4 <> "room173") And (playerroom\Field7\Field4 <> "exit1")) <> 0) Then
                    If (drawbutton((((local2 Sar $01) + local0) - $96), ((local1 + $9A) + $50), $12C, $3C, "Save & quit", $01) <> 0) Then
                        savegame(((savepath + currsave) + "\"))
                        nullgame()
                        menuopen = $00
                        mainmenuopen = $01
                        mainmenutab = $00
                        currsave = ""
                        flushkeys()
                    EndIf
                Else
                    drawbutton((((local2 Sar $01) + local0) - $96), ((local1 + $9A) + $50), $12C, $3C, "", $01)
                    color($32, $32, $32)
                    text(((local2 Sar $01) + local0), (((local1 + $9A) + $50) + $1E), "Save & quit", $01, $01)
                EndIf
                If (drawbutton((((local2 Sar $01) + local0) - $96), ((local1 + $9A) + $A0), $12C, $3C, "Quit", $01) <> 0) Then
                    nullgame()
                    menuopen = $00
                    mainmenuopen = $01
                    mainmenutab = $00
                    currsave = ""
                    flushkeys()
                EndIf
            Else
                If (gamesaved <> 0) Then
                    If (drawbutton((((local2 Sar $01) + local0) - $96), (local1 + $9A), $12C, $3C, "Load game", $01) <> 0) Then
                        nullgame()
                        menuopen = $00
                        loadentities()
                        loadgame(((savepath + currsave) + "\"))
                        initloadgame()
                    EndIf
                Else
                    drawbutton((((local2 Sar $01) + local0) - $96), (local1 + $9A), $12C, $3C, "", $01)
                    color($32, $32, $32)
                    text(((local2 Sar $01) + local0), ((local1 + $9A) + $1E), "Load game", $01, $01)
                EndIf
                If (drawbutton((((local2 Sar $01) + local0) - $96), ((local1 + $9A) + $50), $12C, $3C, "Quit", $01) <> 0) Then
                    nullgame()
                    menuopen = $00
                    mainmenuopen = $01
                    mainmenutab = $00
                    currsave = ""
                    flushkeys()
                EndIf
            EndIf
        ElseIf (0.0 <= killtimer) Then
            If (drawbutton((((local2 Sar $01) + local0) - $96), (local1 + $9A), $12C, $3C, "Resume", $01) <> 0) Then
                menuopen = $00
            EndIf
            If (playerroom\Field7\Field4 <> "room173") Then
                If (drawbutton((((local2 Sar $01) + local0) - $96), ((local1 + $9A) + $50), $12C, $3C, "Save & quit", $01) <> 0) Then
                    savegame(((savepath + currsave) + "\"))
                    nullgame()
                    menuopen = $00
                    mainmenuopen = $01
                    mainmenutab = $00
                    currsave = ""
                    flushkeys()
                EndIf
            Else
                drawbutton((((local2 Sar $01) + local0) - $96), ((local1 + $9A) + $50), $12C, $3C, "", $01)
                color($32, $32, $32)
                text(((local2 Sar $01) + local0), (((local1 + $9A) + $50) + $1E), "Save & quit", $01, $01)
            EndIf
            If (drawbutton((((local2 Sar $01) + local0) - $96), ((local1 + $9A) + $A0), $12C, $3C, "Quit", $01) <> 0) Then
                nullgame()
                menuopen = $00
                mainmenuopen = $01
                mainmenutab = $00
                currsave = ""
                flushkeys()
            EndIf
        ElseIf (drawbutton((((local2 Sar $01) + local0) - $96), (local1 + $9A), $12C, $3C, "Quit", $01) <> 0) Then
            nullgame()
            menuopen = $00
            mainmenuopen = $01
            mainmenutab = $00
            currsave = ""
            flushkeys()
        EndIf
        If (fullscreen <> 0) Then
            drawimage(cursorimg, mousex(), mousey(), $00)
        EndIf
    EndIf
    setfont(font1)
    Return $00
End Function
