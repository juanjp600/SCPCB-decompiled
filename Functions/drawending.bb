Function drawending%()
    Local local0%
    Local local1%
    Local local2%
    Local local3%
    Local local4%
    Local local5.itemtemplates
    Local local6.rooms
    Local local9%
    Local local10%
    Local local11%
    Local local12%
    fpsfactor = 0.0
    endingtimer = (endingtimer - fpsfactor2)
    Select lower(selectedending)
        Case "b2","a1"
            clscolor((Int max(((endingtimer * 2.8) + 255.0), 0.0)), (Int max(((endingtimer * 2.8) + 255.0), 0.0)), (Int max(((endingtimer * 2.8) + 255.0), 0.0)), $FF, 1.0)
        Default
            clscolor($00, $00, $00, $FF, 1.0)
    End Select
    shouldplay = $00
    cls($01, $01)
    If (-200.0 > endingtimer) Then
        If (endingscreen = $00) Then
            endingscreen = loadimage("GFX\endingscreen.pt")
            local4 = loadsound("SFX\Ending.ogg")
            playsound(local4)
            playsound(lightsfx)
        EndIf
        If (-700.0 < endingtimer) Then
            If (min(((Abs endingtimer) - 200.0), 155.0) > (Float rand($01, $96))) Then
                drawimage(endingscreen, ((graphicwidth Sar $01) - $190), ((graphicheight Sar $01) - $190), $00)
            Else
                color($00, $00, $00)
                rect($64, $64, (graphicwidth - $C8), (graphicheight - $C8), $01)
                color($FF, $FF, $FF)
            EndIf
            If (((-450.0 < (endingtimer + fpsfactor2)) And (-450.0 >= endingtimer)) <> 0) Then
                debuglog(lower(selectedending))
                Select lower(selectedending)
                    Case "a1"
                        tempsound2 = loadsound("SFX\EndingA1.ogg")
                        playsound(tempsound2)
                    Case "b1"
                        tempsound2 = loadsound("SFX\EndingB1.ogg")
                        playsound(tempsound2)
                    Case "b2"
                        tempsound2 = loadsound("SFX\EndingB2.ogg")
                        playsound(tempsound2)
                    Case "b3"
                        tempsound2 = loadsound("SFX\EndingB3.ogg")
                        playsound(tempsound2)
                End Select
            EndIf
        Else
            drawimage(endingscreen, ((graphicwidth Sar $01) - $190), ((graphicheight Sar $01) - $190), $00)
            If (-1000.0 > endingtimer) Then
                local2 = imagewidth(pausemenuimg)
                local3 = imageheight(pausemenuimg)
                local0 = ((graphicwidth Sar $01) - (local2 Sar $01))
                local1 = ((graphicheight Sar $01) - (local3 Sar $01))
                drawimage(pausemenuimg, local0, local1, $00)
                color($FF, $FF, $FF)
                setfont(font2)
                text((((local2 Sar $01) + local0) + $28), (local1 + $14), "THE END", $01, $00)
                setfont(font1)
                local0 = (local0 + $84)
                local1 = (local1 + $7A)
                local9 = $00
                local10 = $00
                For local6 = Each rooms
                    local9 = (local9 + $01)
                    local10 = (local10 + local6\Field1)
                Next
                local11 = $00
                local12 = $00
                For local5 = Each itemtemplates
                    If (local5\Field1 = "paper") Then
                        local11 = (local11 + $01)
                        local12 = (local12 + local5\Field3)
                    EndIf
                Next
                local4 = (((($01 + achv420) + achv106) + achv372) + achv895)
                local4 = ((((local4 + achv079) + achv914) + achv789) + achv096)
                text(local0, local1, ("SCPs encountered: " + (Str local4)), $00, $00)
                text(local0, (local1 + $14), ((("Rooms found: " + (Str local10)) + "/") + (Str local9)), $00, $00)
                text(local0, (local1 + $28), ((("Documents discovered: " + (Str local12)) + "/") + (Str local11)), $00, $00)
                text(local0, (local1 + $3C), ("Items refined in SCP-914: " + (Str refineditems)), $00, $00)
                drawtick(local0, (local1 + $64), achvconsole, $01)
                text((local0 + $28), (local1 + $64), "Didn't use console commands", $00, $00)
                drawtick(local0, (local1 + $82), contained106, $01)
                text((local0 + $28), (local1 + $82), "Contained SCP-106", $00, $00)
                drawtick(local0, (local1 + $A0), achvpd, $01)
                text((local0 + $28), (local1 + $A0), "Escaped the pocket dimension", $00, $00)
                drawtick(local0, (local1 + $BE), achvtesla, $01)
                text((local0 + $28), (local1 + $BE), "Lured SCP-106 through a Tesla Gate", $00, $00)
                drawtick(local0, (local1 + $DC), achvsnav, $01)
                text((local0 + $28), (local1 + $DC), "Obtained S-NAV Ultimate", $00, $00)
                drawtick(local0, (local1 + $FA), achvomni, $01)
                text((local0 + $28), (local1 + $FA), "Obtained Key Card Omni", $00, $00)
                drawtick(local0, (local1 + $118), achvmaynard, $01)
                text((local0 + $28), (local1 + $118), "Entered Dr. Maynard's office", $00, $00)
                drawtick(local0, (local1 + $136), achvharp, $01)
                text((local0 + $28), (local1 + $136), "Entered Dr. Harp's office", $00, $00)
                local0 = ((graphicwidth Sar $01) - (local2 Sar $01))
                local1 = ((graphicheight Sar $01) - (local3 Sar $01))
                local0 = (local0 + (local2 Sar $01))
                local1 = ((local1 + local3) - $64)
                If (drawbutton((local0 - $6E), local1, $12C, $3C, "MAIN MENU", $01) <> 0) Then
                    tempsound = loadsound("SFX\breath.ogg")
                    playsound(tempsound)
                    nullgame()
                    menuopen = $00
                    mainmenuopen = $01
                    mainmenutab = $00
                    currsave = ""
                    flushkeys()
                EndIf
            EndIf
        EndIf
    EndIf
    setfont(font1)
    Return $00
End Function
