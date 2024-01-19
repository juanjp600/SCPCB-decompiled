Function updatelauncher%()
    Local local0%
    Local local1%
    Local local2%
    Local local3%
    Local local4%
    debuglog((((Str launcherwidth) + ", ") + (Str launcherheight)))
    menuscale = 1.0
    graphics3d(launcherwidth, launcherheight, $00, $02)
    initext()
    setbuffer(backbuffer())
    font1 = loadfont("GFX\TI-83.ttf", $12, $00, $00, $00)
    menuwhite = loadimage("GFX\menu\menuwhite.jpg")
    menublack = loadimage("GFX\menu\menublack.jpg")
    maskimage(menublack, $FF, $FF, $00)
    launcherimg = loadimage("GFX\menu\launcher.jpg")
    buttonsfx = loadsound("SFX\button.ogg")
    For local0 = $00 To $03 Step $01
        arrowimg(local0) = loadimage("GFX\menu\arrow.png")
        rotateimage(arrowimg(local0), (Float ($5A * local0)))
        handleimage(arrowimg(local0), $00, $00)
    Next
    For local0 = $01 To totalgfxmodes Step $01
        local1 = $00
        For local2 = $00 To (totalgfxmodes - $01) Step $01
            If (((gfxmodewidths(local2) = gfxmodewidth(local0)) And (gfxmodeheights(local2) = gfxmodeheight(local0))) <> 0) Then
                local1 = $01
                Exit
            EndIf
        Next
        If (local1 = $00) Then
            If (((graphicwidth = gfxmodewidth(local0)) And (graphicheight = gfxmodeheight(local0))) <> 0) Then
                selectedgfxmode = gfxmodes
            EndIf
            gfxmodewidths(gfxmodes) = gfxmodewidth(local0)
            gfxmodeheights(gfxmodes) = gfxmodeheight(local0)
            gfxmodes = (gfxmodes + $01)
        EndIf
    Next
    Repeat
        cls($01, $01)
        mousehit1 = mousehit($01)
        color($FF, $FF, $FF)
        drawimage(launcherimg, $00, $00, $00)
        text($14, $AF, "Resolution: ", $00, $00)
        local3 = $28
        local4 = $D7
        For local0 = $00 To (gfxmodes - $01) Step $01
            color($00, $00, $00)
            If (selectedgfxmode = local0) Then
                rect((local3 - $01), (local4 - $01), $64, $14, $00)
            EndIf
            text(local3, local4, (((Str gfxmodewidths(local0)) + "x") + (Str gfxmodeheights(local0))), $00, $00)
            If (mouseon((local3 - $01), (local4 - $01), $64, $14) <> 0) Then
                color($64, $64, $64)
                rect((local3 - $01), (local4 - $01), $64, $14, $00)
                If (mousehit1 <> 0) Then
                    selectedgfxmode = local0
                EndIf
            EndIf
            local4 = (local4 + $14)
            If (local4 >= (((launcherheight - $50) - $104) + $AF)) Then
                local4 = $D7
                local3 = (local3 + $64)
            EndIf
        Next
        color($FF, $FF, $FF)
        local3 = $1E
        local4 = $171
        rect((local3 - $0A), local4, $F0, $5F, $01)
        text((local3 - $0A), (local4 - $19), "Graphics:", $00, $00)
        local4 = (local4 + $0A)
        For local0 = $01 To countgfxdrivers() Step $01
            color($00, $00, $00)
            If (selectedgfxdriver = local0) Then
                rect((local3 - $01), (local4 - $01), $BE, $14, $00)
            EndIf
            limittext(gfxdrivername(local0), local3, local4, $BE)
            If (mouseon((local3 - $01), (local4 - $01), $BE, $14) <> 0) Then
                color($64, $64, $64)
                rect((local3 - $01), (local4 - $01), $BE, $14, $00)
                If (mousehit1 <> 0) Then
                    selectedgfxdriver = local0
                EndIf
            EndIf
            local4 = (local4 + $14)
        Next
        fullscreen = drawtick($1D6, $CF, fullscreen, $00)
        launcherenabled = drawtick($1D6, $F5, launcherenabled, $00)
        color($FF, $FF, $FF)
        text($1F9, $CF, "Fullscreen", $00, $00)
        text($1F9, $F7, "Use launcher", $00, $00)
        If (drawbutton(((launcherwidth - $1E) - $5A), ((launcherheight - $32) - $37), $64, $1E, "LAUNCH", $00) <> 0) Then
            graphicwidth = gfxmodewidths(selectedgfxmode)
            graphicheight = gfxmodeheights(selectedgfxmode)
            Exit
        EndIf
        If (drawbutton(((launcherwidth - $1E) - $5A), (launcherheight - $32), $64, $1E, "EXIT", $00) <> 0) Then
            end()
        EndIf
        flip($01)
    Forever
    putinivalue(optionfile, "options", "width", (Str gfxmodewidths(selectedgfxmode)))
    putinivalue(optionfile, "options", "height", (Str gfxmodeheights(selectedgfxmode)))
    If (fullscreen <> 0) Then
        putinivalue(optionfile, "options", "fullscreen", "true")
    Else
        putinivalue(optionfile, "options", "fullscreen", "false")
    EndIf
    If (launcherenabled <> 0) Then
        putinivalue(optionfile, "launcher", "launcher enabled", "true")
    Else
        putinivalue(optionfile, "launcher", "launcher enabled", "false")
    EndIf
    putinivalue(optionfile, "options", "audio driver", (Str selectedaudiodriver))
    putinivalue(optionfile, "options", "gfx driver", (Str selectedgfxdriver))
    Return $00
End Function
