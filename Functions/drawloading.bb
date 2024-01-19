Function drawloading%(arg0%, arg1%)
    Local local0%
    Local local1%
    Local local2.loadingscreens
    Local local3%
    Local local4%
    Local local5$
    Local local6%
    Local local8%
    Local local9%
    If (arg0 = $00) Then
        loadingscreentext = $00
        For local2 = Each loadingscreens
            If (local2\Field1 <> $00) Then
                freeimage(local2\Field1)
                local2\Field1 = $00
            EndIf
        Next
        local3 = rand($01, loadingscreenamount)
        For local2 = Each loadingscreens
            If (local2\Field2 = local3) Then
                debuglog(local2\Field3)
                debuglog(local2\Field7[$00])
                debuglog(local2\Field7[$01])
                selectedloadingscreen = local2
                local2\Field1 = loadimage(("Loadingscreens\" + local2\Field0))
                debuglog(("Loadingscreens\" + local2\Field0))
                Exit
            EndIf
        Next
    EndIf
    color($FF, $FF, $FF)
    local4 = $01
    Repeat
        cls($01, $01)
        If (arg1 = $00) Then
            If ((Float arg0) > ((100.0 / (Float selectedloadingscreen\Field8)) * (Float (loadingscreentext + $01)))) Then
                loadingscreentext = (loadingscreentext + $01)
            EndIf
        EndIf
        If (selectedloadingscreen\Field6 = $00) Then
            drawimage(loadingback, ((graphicwidth Sar $01) - (imagewidth(loadingback) Sar $01)), ((graphicheight Sar $01) - (imageheight(loadingback) Sar $01)), $00)
        EndIf
        If (selectedloadingscreen\Field4 = $00) Then
            local0 = ((graphicwidth Sar $01) - (imagewidth(selectedloadingscreen\Field1) Sar $01))
        ElseIf (selectedloadingscreen\Field4 = $01) Then
            local0 = (graphicwidth - imagewidth(selectedloadingscreen\Field1))
        Else
            local0 = $00
        EndIf
        If (selectedloadingscreen\Field5 = $00) Then
            local1 = ((graphicheight Sar $01) - (imageheight(selectedloadingscreen\Field1) Sar $01))
        ElseIf (selectedloadingscreen\Field5 = $01) Then
            local1 = (graphicheight - imageheight(selectedloadingscreen\Field1))
        Else
            local1 = $00
        EndIf
        drawimage(selectedloadingscreen\Field1, local0, local1, $00)
        If (selectedloadingscreen\Field3 = "CWM") Then
            setfont(font2)
            local5 = ""
            local3 = rand($02, $09)
            For local6 = $00 To local3 Step $01
                local5 = (local5 + chr(rand($82, $FA)))
            Next
            text((graphicwidth Sar $01), ((graphicheight Sar $01) + $50), local5, $01, $01)
            If (arg0 = $00) Then
                Select rand($0A, $01)
                    Case $01
                        selectedloadingscreen\Field7[$00] = "A very fine radio might prove to be useful"
                    Case $02
                        selectedloadingscreen\Field7[$00] = "ThIS PLaCE WiLL BUrN"
                    Case $03
                        selectedloadingscreen\Field7[$00] = "You can't control it"
                    Case $04
                        selectedloadingscreen\Field7[$00] = "eof9nsd3jue4iwe1fgj"
                    Case $05
                        selectedloadingscreen\Field7[$00] = "YOU NEED TO TRUST IT"
                    Case $06,$07,$08
                        selectedloadingscreen\Field7[$00] = "???____??_???__????n?"
                    Case $09,$0A
                        selectedloadingscreen\Field7[$00] = "???????????"
                End Select
            EndIf
            local5 = selectedloadingscreen\Field7[$00]
            local3 = (len(selectedloadingscreen\Field7[$00]) - rand($05, $01))
            For local6 = $00 To rand($0A, $0F) Step $01
                local5 = replace(selectedloadingscreen\Field7[$00], mid(selectedloadingscreen\Field7[$00], rand($01, (len(local5) - $01)), $01), chr(rand($82, $FA)))
            Next
            setfont(font1)
            rowtext(local5, ((graphicwidth Sar $01) - $C8), ((graphicheight Sar $01) + $78), $190, $12C, $01, $00)
        Else
            setfont(font2)
            text((graphicwidth Sar $01), ((graphicheight Sar $01) + $50), selectedloadingscreen\Field3, $01, $01)
            setfont(font1)
            rowtext(selectedloadingscreen\Field7[loadingscreentext], ((graphicwidth Sar $01) - $C8), ((graphicheight Sar $01) + $78), $190, $12C, $01, $00)
        EndIf
        text((graphicwidth Sar $01), ((graphicheight Sar $01) - $64), (("LOADING - " + (Str arg0)) + " %"), $01, $01)
        local8 = $12C
        local9 = $14
        local0 = ((graphicwidth Sar $01) - (local8 Sar $01))
        local1 = (((graphicheight Sar $01) + $1E) - $64)
        rect(local0, local1, (local8 + $04), local9, $00)
        For local6 = $01 To (Int ((((Float arg0) / 100.0) * (Float (local8 - $02))) / 10.0)) Step $01
            drawimage(blinkmeterimg, ((local0 + $03) + ((local6 - $01) * $0A)), (local1 + $03), $00)
        Next
        If (arg0 = $64) Then
            If (local4 <> 0) Then
                playsound(horrorsfx($08))
            EndIf
            text((graphicwidth Sar $01), (graphicheight - $32), "PRESS ANY KEY", $01, $01)
        Else
            flushkeys()
            flushmouse()
        EndIf
        flip($01)
        local4 = $00
        If (arg0 <> $64) Then
            Exit
        EndIf
    Until (((getkey() <> $00) Or mousehit($01)) <> 0)
    Return $00
End Function
