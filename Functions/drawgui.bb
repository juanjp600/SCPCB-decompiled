Function drawgui%()
    Local local0%
    Local local1%
    Local local2%
    Local local3%
    Local local4%
    Local local5#
    Local local6#
    Local local7%
    Local local8%
    Local local9%
    Local local11%
    Local local12%
    Local local13%
    Local local14%
    Local local16%
    Local local17%
    Local local24$
    Local local27%
    Local local28%
    Local local29#
    Local local30%
    Local local31%
    Local local32%
    Local local33%
    If ((((menuopen Or (selecteddoor <> Null)) Or invopen) Or (0.0 > endingtimer)) <> 0) Then
        showpointer()
    Else
        hidepointer()
    EndIf
    If ((((closestbutton <> $00) And (selecteddoor = Null)) And (invopen = $00)) <> 0) Then
        local0 = createpivot($00)
        positionentity(local0, entityx(camera, $00), entityy(camera, $00), entityz(camera, $00), $00)
        pointentity(local0, closestbutton, 0.0)
        local5 = wrapangle((entityyaw(camera, $00) - entityyaw(local0, $00)))
        If (((90.0 < local5) And (180.0 >= local5)) <> 0) Then
            local5 = 90.0
        EndIf
        If (((180.0 < local5) And (270.0 > local5)) <> 0) Then
            local5 = 270.0
        EndIf
        local6 = wrapangle((entitypitch(camera, $00) - entitypitch(local0, $00)))
        If (((90.0 < local6) And (180.0 >= local6)) <> 0) Then
            local6 = 90.0
        EndIf
        If (((180.0 < local6) And (270.0 > local6)) <> 0) Then
            local6 = 270.0
        EndIf
        freeentity(local0)
        drawimage(handicon, (Int ((((Float (graphicwidth / $03)) * sin(local5)) + (Float (graphicwidth Sar $01))) - 32.0)), (Int (((Float (graphicheight Sar $01)) - ((Float (graphicheight / $03)) * sin(local6))) - 32.0)), $00)
        If (mouseup1 <> 0) Then
            mouseup1 = $00
            If (closestdoor <> Null) Then
                If (closestdoor\Field15 <> "") Then
                    selecteddoor = closestdoor
                Else
                    playsound2(buttonsfx, camera, closestbutton, 10.0, 1.0, $01)
                    usedoor(closestdoor, $01)
                EndIf
            EndIf
        EndIf
    EndIf
    If (selectedscreen <> Null) Then
        drawimage(selectedscreen\Field2, ((graphicwidth Sar $01) - (imagewidth(selectedscreen\Field2) Sar $01)), ((graphicheight Sar $01) - (imageheight(selectedscreen\Field2) Sar $01)), $00)
        If ((mouseup1 Or mousehit2) <> 0) Then
            freeimage(selectedscreen\Field2)
            selectedscreen\Field2 = $00
            selectedscreen = Null
            mouseup1 = $00
        EndIf
    EndIf
    If (closestitem <> Null) Then
        local0 = createpivot($00)
        positionentity(local0, entityx(camera, $00), entityy(camera, $00), entityz(camera, $00), $00)
        pointentity(local0, closestitem\Field0, 0.0)
        local5 = wrapangle((entityyaw(camera, $00) - entityyaw(local0, $00)))
        If (((90.0 < local5) And (180.0 >= local5)) <> 0) Then
            local5 = 90.0
        EndIf
        If (((180.0 < local5) And (270.0 > local5)) <> 0) Then
            local5 = 270.0
        EndIf
        local6 = wrapangle((entitypitch(camera, $00) - entitypitch(local0, $00)))
        If (((90.0 < local6) And (180.0 >= local6)) <> 0) Then
            local6 = 90.0
        EndIf
        If (((180.0 < local6) And (270.0 > local6)) <> 0) Then
            local6 = 270.0
        EndIf
        freeentity(local0)
        drawimage(handicon, (Int ((((Float (graphicwidth / $03)) * sin(local5)) + (Float (graphicwidth Sar $01))) - 32.0)), (Int (((Float (graphicheight Sar $01)) - ((Float (graphicheight / $03)) * sin(local6))) - 32.0)), $00)
    EndIf
    If (drawhandicon <> 0) Then
        drawimage(handicon, ((graphicwidth Sar $01) - $20), ((graphicheight Sar $01) - $20), $00)
    EndIf
    For local4 = $00 To $03 Step $01
        If (drawarrowicon(local4) <> 0) Then
            local1 = ((graphicwidth Sar $01) - $20)
            local2 = ((graphicheight Sar $01) - $20)
            Select local4
                Case $00
                    local2 = ((local2 - $40) - $05)
                Case $01
                    local1 = ((local1 + $40) + $05)
                Case $02
                    local2 = ((local2 + $40) + $05)
                Case $03
                    local1 = ((local1 - $05) - $40)
            End Select
            drawimage(handicon, local1, local2, $00)
            color($00, $00, $00)
            rect((local1 + $04), (local2 + $04), $38, $38, $01)
            drawimage(arrowimg(local4), (local1 + $15), (local2 + $15), $00)
            drawarrowicon(local4) = $00
        EndIf
    Next
    If (hudenabled <> 0) Then
        local11 = $CC
        local12 = $14
        local1 = $50
        local2 = (graphicheight - $5F)
        color($FF, $FF, $FF)
        rect(local1, local2, local11, local12, $00)
        color($57, $65, $69)
        If (60.0 > blinktimer) Then
            color($C8, $00, $00)
        EndIf
        For local4 = $01 To (Int (((blinktimer / 560.0) * (Float (local11 - $02))) / 10.0)) Step $01
            drawimage(blinkmeterimg, ((local1 + $03) + ((local4 - $01) * $0A)), (local2 + $03), $00)
        Next
        color($00, $00, $00)
        rect((local1 - $32), local2, $1E, $1E, $01)
        If (0.0 < eyeirritation) Then
            color($C8, $00, $00)
            rect(((local1 - $32) - $03), (local2 - $03), $24, $24, $01)
        EndIf
        color($FF, $FF, $FF)
        rect(((local1 - $32) - $01), (local2 - $01), $20, $20, $00)
        drawimage(blinkicon, (local1 - $32), local2, $00)
        local2 = (graphicheight - $37)
        color($FF, $FF, $FF)
        rect(local1, local2, local11, local12, $00)
        color($35, $44, $25)
        If (10.0 > stamina) Then
            color($C8, $00, $00)
        EndIf
        For local4 = $01 To (Int (((stamina / 100.0) * (Float (local11 - $02))) / 10.0)) Step $01
            drawimage(staminameterimg, ((local1 + $03) + ((local4 - $01) * $0A)), (local2 + $03), $00)
        Next
        color($00, $00, $00)
        rect((local1 - $32), local2, $1E, $1E, $01)
        color($FF, $FF, $FF)
        rect(((local1 - $32) - $01), (local2 - $01), $20, $20, $00)
        drawimage(sprinticon, (local1 - $32), local2, $00)
    EndIf
    local13 = invopen
    local14 = $42
    If (selecteddoor <> Null) Then
        selecteditem = Null
        local1 = ((graphicwidth Sar $01) - (imagewidth(keypadhud) Sar $01))
        local2 = ((graphicheight Sar $01) - (imageheight(keypadhud) Sar $01))
        drawimage(keypadhud, local1, local2, $00)
        If (keypadmsg <> "") Then
            keypadtimer = (keypadtimer - fpsfactor2)
            If (35.0 > (keypadtimer Mod 70.0)) Then
                text((graphicwidth Sar $01), (local2 + $7C), keypadmsg, $01, $01)
            EndIf
            If (0.0 >= keypadtimer) Then
                keypadmsg = ""
                selecteddoor = Null
            EndIf
        Else
            setfont(font2)
            text((graphicwidth Sar $01), (local2 + $7C), keypadinput, $01, $01)
            setfont(font1)
            text((graphicwidth Sar $01), (local2 + $46), "Access code: ", $01, $01)
        EndIf
        local1 = (local1 + $2A)
        local2 = (local2 + $E9)
        For local7 = $00 To $03 Step $01
            For local4 = $00 To $02 Step $01
                local8 = (($3D * local7) + local1)
                local9 = (($35 * local4) + local2)
                local0 = $00
                If ((mouseon(local8, local9, $36, $33) And (keypadmsg = "")) <> 0) Then
                    If (mouseup1 <> 0) Then
                        Select ((local7 + $01) + (local4 Shl $02))
                            Case $01,$02,$03
                                keypadinput = (keypadinput + (Str ((local7 + $01) + (local4 Shl $02))))
                            Case $04
                                keypadinput = (keypadinput + "0")
                            Case $05,$06,$07
                                keypadinput = (keypadinput + (Str (((local7 + $01) + (local4 Shl $02)) - $01)))
                            Case $08
                                debuglog(selecteddoor\Field15)
                                debuglog(keypadinput)
                                If (keypadinput = selecteddoor\Field15) Then
                                    If (selecteddoor\Field15 = accesscode) Then
                                        achvmaynard = $01
                                    ElseIf (selecteddoor\Field15 = "7816") Then
                                        achvharp = $01
                                    EndIf
                                    selecteddoor\Field4 = $00
                                    usedoor(selecteddoor, $01)
                                    selecteddoor = Null
                                Else
                                    keypadmsg = "ACCESS DENIED"
                                    keypadtimer = 210.0
                                    keypadinput = ""
                                EndIf
                            Case $09,$0A,$0B
                                keypadinput = (keypadinput + (Str (((local7 + $01) + (local4 Shl $02)) - $02)))
                            Case $0C
                                keypadinput = ""
                        End Select
                        If (len(keypadinput) > $04) Then
                            keypadinput = left(keypadinput, $04)
                        EndIf
                    EndIf
                    If (mousedown1 <> 0) Then
                        local0 = $01
                    EndIf
                Else
                    local0 = $00
                EndIf
                If (local0 = $01) Then
                    drawimage(buttondown, local8, local9, $00)
                Else
                    drawimage(buttonup, local8, local9, $00)
                EndIf
            Next
        Next
        If (fullscreen <> 0) Then
            drawimage(cursorimg, mousex(), mousey(), $00)
        EndIf
        If (mousehit2 <> 0) Then
            selecteddoor = Null
        EndIf
    Else
        keypadinput = ""
        keypadtimer = 0.0
        keypadmsg = ""
    EndIf
    If ((keyhit($01) And (0.0 = endingtimer)) <> 0) Then
        If (menuopen <> 0) Then
            resumesounds()
        Else
            pausesounds()
        EndIf
        menuopen = (menuopen = $00)
        selecteddoor = Null
        selectedscreen = Null
    EndIf
    If (invopen <> 0) Then
        selecteddoor = Null
        local11 = $46
        local12 = $46
        local16 = $23
        local1 = ((graphicwidth Sar $01) - ((((local11 * $0A) Sar $01) + (local16 Shl $02)) Sar $01))
        local2 = ((graphicheight Sar $01) - local12)
        itemamount = $00
        For local7 = $00 To $09 Step $01
            local17 = $00
            If (((mousex() > local1) And (mousex() < (local1 + local11))) <> 0) Then
                If (((mousey() > local2) And (mousey() < (local2 + local12))) <> 0) Then
                    local17 = $01
                EndIf
            EndIf
            If (local17 <> 0) Then
                local14 = local7
                color($FF, $00, $00)
                rect((local1 - $01), (local2 - $01), (local11 + $02), (local12 + $02), $01)
            EndIf
            color($FF, $FF, $FF)
            rect(local1, local2, local11, local12, $00)
            color($7D, $7D, $7D)
            rect((local1 + $01), (local2 + $01), (local11 - $02), (local12 - $02), $00)
            color($00, $00, $00)
            rect((local1 + $05), (local2 + $05), (local11 - $0A), (local12 - $0A), $01)
            If (inventory(local7) <> Null) Then
                If (((selecteditem <> inventory(local7)) Or local17) <> 0) Then
                    drawimage(inventory(local7)\Field1\Field5, (((local11 Sar $01) + local1) - $20), (((local12 Sar $01) + local2) - $20), $00)
                EndIf
            EndIf
            If (((inventory(local7) <> Null) And (selecteditem <> inventory(local7))) <> 0) Then
                If (local17 <> 0) Then
                    color($FF, $FF, $FF)
                    text(((local11 Sar $01) + local1), (((local2 + local12) + local16) - $0F), inventory(local7)\Field1\Field0, $01, $00)
                    If (selecteditem = Null) Then
                        If (mousehit1 <> 0) Then
                            selecteditem = inventory(local7)
                            mousehit1 = $00
                            If (doubleclick <> 0) Then
                                If (inventory(local7)\Field1\Field2 <> $42) Then
                                    playsound(picksfx(inventory(local7)\Field1\Field2))
                                EndIf
                                invopen = $00
                                doubleclick = $00
                            EndIf
                        EndIf
                    EndIf
                EndIf
                itemamount = (itemamount + $01)
            ElseIf ((local17 And mousehit1) <> 0) Then
                For local3 = $00 To $09 Step $01
                    If (inventory(local3) = selecteditem) Then
                        inventory(local3) = Null
                    EndIf
                Next
                inventory(local7) = selecteditem
            EndIf
            local1 = ((local1 + local11) + local16)
            If (local7 = $04) Then
                local2 = (local2 + (local12 Shl $01))
                local1 = ((graphicwidth Sar $01) - ((((local11 * $0A) Sar $01) + (local16 Shl $02)) Sar $01))
            EndIf
        Next
        If (selecteditem <> Null) Then
            If (mousedown1 <> 0) Then
                If (local14 = $42) Then
                    drawimage(selecteditem\Field1\Field5, (mousex() - (imagewidth(selecteditem\Field1\Field5) Sar $01)), (mousey() - (imageheight(selecteditem\Field1\Field5) Sar $01)), $00)
                ElseIf (selecteditem <> inventory(local14)) Then
                    drawimage(selecteditem\Field1\Field5, (mousex() - (imagewidth(selecteditem\Field1\Field5) Sar $01)), (mousey() - (imageheight(selecteditem\Field1\Field5) Sar $01)), $00)
                EndIf
            Else
                If (local14 = $42) Then
                    If (selecteditem\Field1\Field2 <> $42) Then
                        playsound(picksfx(selecteditem\Field1\Field2))
                    EndIf
                    showentity(selecteditem\Field0)
                    positionentity(selecteditem\Field0, entityx(camera, $00), entityy(camera, $00), entityz(camera, $00), $00)
                    rotateentity(selecteditem\Field0, entitypitch(camera, $00), entityyaw(camera, $00), 0.0, $00)
                    moveentity(selecteditem\Field0, 0.0, -0.1, 0.1)
                    rotateentity(selecteditem\Field0, 0.0, (Float rand($168, $01)), 0.0, $00)
                    resetentity(selecteditem\Field0)
                    selecteditem\Field7 = $00
                    For local3 = $00 To $09 Step $01
                        If (inventory(local3) = selecteditem) Then
                            inventory(local3) = Null
                        EndIf
                    Next
                    If (((selecteditem\Field1\Field1 = "gasmask") Or (selecteditem\Field1\Field1 = "supergasmask")) <> 0) Then
                        wearinggasmask = $00
                    EndIf
                    selecteditem = Null
                    invopen = $00
                    movemouse(viewport_center_x, viewport_center_y)
                Else
                    debuglog(("mouseslot " + (Str local14)))
                    If (inventory(local14) = Null) Then
                        For local3 = $00 To $09 Step $01
                            If (inventory(local3) = selecteditem) Then
                                inventory(local3) = Null
                            EndIf
                        Next
                        inventory(local14) = selecteditem
                        selecteditem = Null
                    ElseIf (inventory(local14) <> selecteditem) Then
                        Select selecteditem\Field1\Field1
                            Case "battery","bat"
                                Select inventory(local14)\Field1\Field0
                                    Case "S-NAV Navigator","S-NAV 300 Navigator","S-NAV 310 Navigator"
                                        If (selecteditem\Field1\Field2 <> $42) Then
                                            playsound(picksfx(selecteditem\Field1\Field2))
                                        EndIf
                                        removeitem(selecteditem)
                                        selecteditem = Null
                                        inventory(local14)\Field5 = 100.0
                                        msg = "You replaced the battery of the navigator"
                                        msgtimer = 350.0
                                    Case "S-NAV Navigator Ultimate"
                                        msg = "There seems to be no place for batteries in the navigator"
                                        msgtimer = 350.0
                                    Case "Radio Transceiver"
                                        Select inventory(local14)\Field1\Field1
                                            Case "fineradio","veryfineradio"
                                                msg = "There seems to be no place for batteries in the radio"
                                                msgtimer = 350.0
                                            Case "18vradio"
                                                msg = "The battery doesn't seem to fit"
                                                msgtimer = 350.0
                                            Case "radio"
                                                If (selecteditem\Field1\Field2 <> $42) Then
                                                    playsound(picksfx(selecteditem\Field1\Field2))
                                                EndIf
                                                removeitem(selecteditem)
                                                selecteditem = Null
                                                inventory(local14)\Field5 = 100.0
                                                msg = "You replaced the battery of the radio"
                                                msgtimer = 350.0
                                        End Select
                                    Default
                                        debuglog(inventory(local14)\Field1\Field0)
                                        msg = "This item can't be used this way"
                                        msgtimer = 350.0
                                End Select
                            Case "18vbat"
                                Select inventory(local14)\Field1\Field0
                                    Case "S-NAV Navigator","S-NAV 300 Navigator","S-NAV 310 Navigator"
                                        msg = "The battery doesn't seem to fit"
                                        msgtimer = 350.0
                                    Case "S-NAV Navigator Ultimate"
                                        msg = "There seems to be no place for batteries in the navigator"
                                        msgtimer = 350.0
                                    Case "Radio Transceiver"
                                        Select inventory(local14)\Field1\Field1
                                            Case "fineradio","veryfineradio"
                                                msg = "There seems to be no place for batteries in the radio"
                                                msgtimer = 350.0
                                            Case "18vradio"
                                                If (selecteditem\Field1\Field2 <> $42) Then
                                                    playsound(picksfx(selecteditem\Field1\Field2))
                                                EndIf
                                                removeitem(selecteditem)
                                                selecteditem = Null
                                                inventory(local14)\Field5 = 100.0
                                                msg = "You replaced the battery of the radio"
                                                msgtimer = 350.0
                                        End Select
                                    Default
                                        msg = "This item can't be used this way"
                                        msgtimer = 350.0
                                End Select
                            Default
                                msg = "This item can't be used this way"
                                msgtimer = 350.0
                        End Select
                    EndIf
                EndIf
                selecteditem = Null
            EndIf
        EndIf
        If (fullscreen <> 0) Then
            drawimage(cursorimg, mousex(), mousey(), $00)
        EndIf
    ElseIf (selecteditem <> Null) Then
        Select selecteditem\Field1\Field1
            Case "battery"
            Case "key1","key2","key3","key4","key5","key6","keyomni"
                drawimage(selecteditem\Field1\Field5, ((graphicwidth Sar $01) - (imagewidth(selecteditem\Field1\Field5) Sar $01)), ((graphicheight Sar $01) - (imageheight(selecteditem\Field1\Field5) Sar $01)), $00)
            Case "eyedrops"
                eyesuper = (Float (rand($14, $1E) * $46))
                blurtimer = 200.0
                removeitem(selecteditem)
            Case "fineeyedrops"
                eyesuper = (Float (rand($28, $32) * $46))
                blurtimer = 200.0
                removeitem(selecteditem)
            Case "supereyedrops"
                eyesuper = 70000.0
                eyestuck = 10000.0
                blurtimer = 1000.0
                removeitem(selecteditem)
            Case "paper"
                If (selecteditem\Field1\Field7 = $00) Then
                    selecteditem\Field1\Field7 = loadimage(selecteditem\Field1\Field6)
                EndIf
                drawimage(selecteditem\Field1\Field7, ((graphicwidth Sar $01) - (imagewidth(selecteditem\Field1\Field7) Sar $01)), ((graphicheight Sar $01) - (imageheight(selecteditem\Field1\Field7) Sar $01)), $00)
            Case "radio","18vradio","fineradio","veryfineradio"
                If (100.0 >= selecteditem\Field5) Then
                    selecteditem\Field5 = max(0.0, (selecteditem\Field5 - (fpsfactor * 0.01)))
                EndIf
                If (0.0 = radiostate($05)) Then
                    msg = "Use keys 1-5 to change the channel"
                    msgtimer = 350.0
                    radiostate($05) = 1.0
                EndIf
                local24 = ""
                local1 = ((graphicwidth - imagewidth(selecteditem\Field1\Field7)) + $78)
                local2 = ((graphicheight - imageheight(selecteditem\Field1\Field7)) - $1E)
                drawimage(selecteditem\Field1\Field7, local1, local2, $00)
                If (0.0 < selecteditem\Field5) Then
                    If (((playerroom\Field7\Field4 = "pocketdimension") Or (4.0 > coffindistance)) <> 0) Then
                        resumechannel(radiochn($00))
                        If (channelplaying(radiochn($00)) = $00) Then
                            radiochn($00) = playsound(radiostatic)
                        EndIf
                    Else
                        Select (Int selecteditem\Field6)
                            Case $00
                                resumechannel(radiochn($00))
                                If (channelplaying(radiochn($00)) = $00) Then
                                    radiochn($00) = playsound(radiostatic)
                                EndIf
                            Case $01
                                debuglog((Str radiostate($01)))
                                resumechannel(radiochn($01))
                                local24 = "        WARNING - CONTAINMENT BREACH          "
                                If (channelplaying(radiochn($01)) = $00) Then
                                    If (5.0 <= radiostate($01)) Then
                                        radiochn($01) = playsound(radiosfx($01, $01))
                                        radiostate($01) = 0.0
                                    Else
                                        radiostate($01) = (radiostate($01) + 1.0)
                                        radiochn($01) = playsound(radiosfx($01, $00))
                                    EndIf
                                EndIf
                            Case $02
                                resumechannel(radiochn($02))
                                local24 = "        SCP Foundation On-Site Radio          "
                                If (channelplaying(radiochn($02)) = $00) Then
                                    debuglog("bim")
                                    radiostate($02) = (radiostate($02) + 1.0)
                                    If (17.0 = radiostate($02)) Then
                                        radiostate($02) = 1.0
                                    EndIf
                                    If (ceil((radiostate($02) / 2.0)) = floor((radiostate($02) / 2.0))) Then
                                        radiochn($02) = playsound(radiosfx($02, (Int (radiostate($02) / 2.0))))
                                    Else
                                        radiochn($02) = playsound(radiosfx($02, $00))
                                    EndIf
                                EndIf
                            Case $03
                                resumechannel(radiochn($03))
                                local24 = "EMERGENCY CHANNEL - RESERVED FOR COMMUNICATION IN THE EVENT OF A CONTAINMENT BREACH"
                                If (channelplaying(radiochn($03)) = $00) Then
                                    radiochn($03) = playsound(radiostatic)
                                EndIf
                            Case $04
                                resumechannel(radiochn($06))
                                If (channelplaying(radiochn($06)) = $00) Then
                                    radiochn($06) = playsound(radiostatic)
                                EndIf
                                resumechannel(radiochn($04))
                                If (channelplaying(radiochn($04)) = $00) Then
                                    If (tempsound <> $00) Then
                                        freesound(tempsound)
                                        tempsound = $00
                                    EndIf
                                    If (((remotedooron = $00) And (0.0 = radiostate($08))) <> 0) Then
                                        tempsound = loadsound("SFX\radio\Chatter3.ogg")
                                        radiochn($04) = playsound(tempsound)
                                        radiostate($08) = 1.0
                                    Else
                                        radiostate($04) = (max((Float rand($FFFFFFF6, $01)), 0.0) + radiostate($04))
                                        Select radiostate($04)
                                            Case 10.0
                                                tempsound = loadsound("SFX\radio\OhGod.ogg")
                                                radiochn($04) = playsound(tempsound)
                                                radiostate($04) = (radiostate($04) + 1.0)
                                            Case 100.0
                                                tempsound = loadsound("SFX\radio\Chatter2.ogg")
                                                radiochn($04) = playsound(tempsound)
                                                radiostate($04) = (radiostate($04) + 1.0)
                                            Case 158.0
                                                tempsound = $00
                                                radiochn($04) = playsound(tempsound)
                                                radiostate($04) = (radiostate($04) + 1.0)
                                            Case 200.0
                                                tempsound = loadsound("SFX\radio\Chatter1.ogg")
                                                radiochn($04) = playsound(tempsound)
                                                radiostate($04) = (radiostate($04) + 1.0)
                                        End Select
                                    EndIf
                                EndIf
                            Case $05
                                resumechannel(radiochn($05))
                                If (channelplaying(radiochn($05)) = $00) Then
                                    radiochn($05) = playsound(radiostatic)
                                EndIf
                        End Select
                        If (keyhit($19) <> 0) Then
                            stopchannel(radiochn($02))
                        EndIf
                        color($E6, $DF, $CC)
                        text((local1 + $C3), (local2 + $10D), "CHN", $00, $00)
                        If (selecteditem\Field1\Field1 = "veryfineradio") Then
                            resumechannel(radiochn($00))
                            If (channelplaying(radiochn($00)) = $00) Then
                                radiochn($00) = playsound(radiostatic)
                            EndIf
                            radiostate($06) = (radiostate($06) + fpsfactor)
                            local0 = (Int mid(accesscode, (Int (radiostate($08) + 1.0)), $01))
                            If ((((radiostate($07) * 50.0) >= (radiostate($06) - fpsfactor)) And (radiostate($06) > (radiostate($07) * 50.0))) <> 0) Then
                                playsound(radiobuzz)
                                radiostate($07) = (radiostate($07) + 1.0)
                                If ((Float local0) <= radiostate($07)) Then
                                    radiostate($07) = 0.0
                                    radiostate($06) = -100.0
                                    radiostate($08) = (radiostate($08) + 1.0)
                                    If (4.0 = radiostate($08)) Then
                                        radiostate($08) = 0.0
                                        radiostate($06) = -200.0
                                    EndIf
                                EndIf
                            EndIf
                            setfont(font2)
                            text((local1 + $D6), (local2 + $136), (Str rand($00, $09)), $01, $01)
                        Else
                            For local4 = $02 To $06 Step $01
                                If (keyhit(local4) <> 0) Then
                                    If ((Float (local4 - $02)) <> selecteditem\Field6) Then
                                        playsound(radiosquelch)
                                        If (radiochn((Int selecteditem\Field6)) <> $00) Then
                                            pausechannel(radiochn((Int selecteditem\Field6)))
                                        EndIf
                                    EndIf
                                    selecteditem\Field6 = (Float (local4 - $02))
                                    If (radiochn((Int selecteditem\Field6)) <> $00) Then
                                        resumechannel(radiochn((Int selecteditem\Field6)))
                                    EndIf
                                EndIf
                            Next
                            setfont(font2)
                            text((local1 + $D6), (local2 + $136), (Str (Int (selecteditem\Field6 + 1.0))), $01, $01)
                        EndIf
                        setfont(font1)
                        If (local24 <> "") Then
                            text((local1 + $FA), (local2 + $145), right(left(local24, ((millisecs() / $1F4) Mod len(local24))), $07), $00, $00)
                        EndIf
                        local1 = (local1 + $141)
                        local2 = (local2 + $108)
                        If (100.0 >= selecteditem\Field5) Then
                            For local4 = $01 To $05 Step $01
                                If ((Float ($05 - local4)) < ceil((selecteditem\Field5 / 20.0))) Then
                                    rect((local1 - ($28 - (local4 * $06))), local2, ($28 - (local4 * $06)), $05, $01)
                                Else
                                    rect((local1 - ($28 - (local4 * $06))), local2, ($28 - (local4 * $06)), $05, $00)
                                EndIf
                                local2 = (local2 + $0A)
                            Next
                        EndIf
                    EndIf
                EndIf
            Case "cigarette"
                msg = "I don't have anything to light it with. Umm, what about that... Nevermind."
                msgtimer = 350.0
                removeitem(selecteditem)
            Case "420"
                msg = "MAN DATS SUM GOOD ASS SHIT"
                msgtimer = 350.0
                removeitem(selecteditem)
                blurtimer = 500.0
                achv420 = $01
                tempsound = loadsound("SFX\Mandeville.ogg")
                playsound(tempsound)
            Case "420s"
                msg = "UH WHERE... WHAT WAS I DOING AGAIN... MAN I NEED TO TAKE A NAP..."
                killtimer = -1.0
                msgtimer = 350.0
                removeitem(selecteditem)
            Case "gasmask"
                wearinggasmask = (wearinggasmask = $00)
                selecteditem = Null
            Case "supergasmask"
                If (wearinggasmask <> 0) Then
                    wearinggasmask = $00
                Else
                    wearinggasmask = $02
                EndIf
                selecteditem = Null
            Case "navigator","nav"
                If (100.0 >= selecteditem\Field5) Then
                    selecteditem\Field5 = max(0.0, (selecteditem\Field5 - (fpsfactor * 0.01)))
                EndIf
                local1 = ((graphicwidth Sar $01) + $07)
                local2 = ((graphicheight Sar $01) - $1C)
                local11 = $11F
                local12 = $100
                drawimage(selecteditem\Field1\Field7, ((graphicwidth Sar $01) - (imagewidth(selecteditem\Field1\Field7) Sar $01)), ((graphicheight Sar $01) - (imageheight(selecteditem\Field1\Field7) Sar $01)), $00)
                If (playerroom\Field7\Field4 = "pocketdimension") Then
                    If ((millisecs() Mod $3E8) > $12C) Then
                        text(local1, (((local12 Sar $01) + local2) - $50), "ERROR 06", $01, $00)
                        text(local1, (((local12 Sar $01) + local2) - $3C), "LOCATION UNKNOWN", $01, $00)
                    EndIf
                ElseIf (((0.0 < selecteditem\Field5) And ((1.0 < rnd((coffindistance + 15.0), 0.0)) Or (playerroom\Field7\Field4 <> "coffin"))) <> 0) Then
                    color($E6, $DF, $CC)
                    If (selecteditem\Field1\Field0 = "S-NAV Navigator") Then
                        color($FF, $00, $00)
                    EndIf
                    If ((millisecs() Mod $3E8) > $12C) Then
                        If (((selecteditem\Field1\Field0 <> "S-NAV 310 Navigator") And (selecteditem\Field1\Field0 <> "S-NAV Navigator Ultimate")) <> 0) Then
                            text(local1, (((local12 Sar $01) + local2) - $28), "COULDN'T CONNECT", $01, $00)
                            text(local1, (((local12 Sar $01) + local2) - $14), "TO MAP DATABASE", $01, $00)
                        EndIf
                        rect((local1 - $04), ((local2 - $04) - $07), $08, $08, $00)
                    EndIf
                    local27 = (Int floor(((entityx(playerroom\Field2, $00) / 8.0) + 0.5)))
                    local28 = (Int floor(((entityz(playerroom\Field2, $00) / 8.0) + 0.5)))
                    If (((selecteditem\Field1\Field0 = "S-NAV Navigator Ultimate") And ((millisecs() Mod $258) < $190)) <> 0) Then
                        local29 = entitydistance(camera, curr173\Field0)
                        local29 = (ceil((local29 / 8.0)) * 8.0)
                        If (32.0 > local29) Then
                            color($FF, $00, $00)
                            oval((Int ((Float local1) - (local29 * 3.0))), (Int ((Float (local2 - $07)) - (local29 * 3.0))), (Int ((local29 * 3.0) * 2.0)), (Int ((local29 * 3.0) * 2.0)), $00)
                            text(((local1 - (local11 Sar $01)) + $14), ((local2 - (local12 Sar $01)) + $14), "SCP-173", $00, $00)
                        EndIf
                        local29 = entitydistance(camera, curr106\Field0)
                        If (32.0 > local29) Then
                            color($FF, $00, $00)
                            oval((Int ((Float local1) - (local29 * 1.5))), (Int ((Float (local2 - $07)) - (local29 * 1.5))), (Int (local29 * 3.0)), (Int (local29 * 3.0)), $00)
                            text(((local1 - (local11 Sar $01)) + $14), ((local2 - (local12 Sar $01)) + $28), "SCP-106", $00, $00)
                        EndIf
                        If (playerroom\Field7\Field4 = "coffin") Then
                            If (8.0 > coffindistance) Then
                                local29 = rnd(4.0, 8.0)
                                color($FF, $00, $00)
                                oval((Int ((Float local1) - (local29 * 1.5))), (Int ((Float (local2 - $07)) - (local29 * 1.5))), (Int (local29 * 3.0)), (Int (local29 * 3.0)), $00)
                                text(((local1 - (local11 Sar $01)) + $14), ((local2 - (local12 Sar $01)) + $28), "SCP-895", $00, $00)
                            EndIf
                        EndIf
                    EndIf
                    local29 = 4.0
                    For local30 = (Int max(1.0, ((Float local27) - local29))) To (Int min((Float (mapwidth - $02)), ((Float local27) + local29))) Step $01
                        For local31 = (Int max(1.0, ((Float local28) - local29))) To (Int min((Float (mapheight - $02)), ((Float local28) + local29))) Step $01
                            If ((maptemp(playerlevel, local30, local31) And (((mapfound(playerlevel, local30, local31) > $00) Or (selecteditem\Field1\Field0 = "S-NAV 310 Navigator")) Or (selecteditem\Field1\Field0 = "S-NAV Navigator Ultimate"))) <> 0) Then
                                local32 = (((local27 - local30) * $18) + local1)
                                local33 = ((local2 - ((local28 - local31) * $18)) - $07)
                                If (playerroom\Field7\Field4 = "coffin") Then
                                    If (((8.0 > coffindistance) And (0.5 > rnd(coffindistance, 0.0))) <> 0) Then
                                        local32 = (Int (((15.0 - coffindistance) * rnd(-1.0, 1.0)) + (Float local32)))
                                        local33 = (Int (((15.0 - coffindistance) * rnd(-1.0, 1.0)) + (Float local33)))
                                    EndIf
                                EndIf
                                If (mapfound(playerlevel, local30, local31) = $01) Then
                                    color($73, $70, $66)
                                    If (selecteditem\Field1\Field0 = "S-NAV Navigator") Then
                                        color($80, $00, $00)
                                    EndIf
                                Else
                                    color($E6, $DF, $CC)
                                    If (selecteditem\Field1\Field0 = "S-NAV Navigator") Then
                                        color($FF, $00, $00)
                                    EndIf
                                EndIf
                                If (maptemp(playerlevel, (local30 + $01), local31) = $00) Then
                                    line((local32 - $0C), (local33 - $0C), (local32 - $0C), (local33 + $0C))
                                EndIf
                                If (maptemp(playerlevel, (local30 - $01), local31) = $00) Then
                                    line((local32 + $0C), (local33 - $0C), (local32 + $0C), (local33 + $0C))
                                EndIf
                                If (maptemp(playerlevel, local30, (local31 - $01)) = $00) Then
                                    line((local32 - $0C), (local33 - $0C), (local32 + $0C), (local33 - $0C))
                                EndIf
                                If (maptemp(playerlevel, local30, (local31 + $01)) = $00) Then
                                    line((local32 - $0C), (local33 + $0C), (local32 + $0C), (local33 + $0C))
                                EndIf
                            EndIf
                        Next
                    Next
                    local1 = (((graphicwidth Sar $01) + (local11 Sar $01)) - $0A)
                    local2 = ((graphicheight Sar $01) - (local12 Sar $01))
                    color($E6, $DF, $CC)
                    If (selecteditem\Field1\Field0 = "S-NAV Navigator") Then
                        color($FF, $00, $00)
                    EndIf
                    If (100.0 >= selecteditem\Field5) Then
                        text((local1 - $3C), (local2 - $14), "BATTERY", $00, $00)
                        For local4 = $01 To $05 Step $01
                            If ((Float ($05 - local4)) < ceil((selecteditem\Field5 / 20.0))) Then
                                rect((local1 - ($28 - (local4 * $06))), local2, ($28 - (local4 * $06)), $05, $01)
                            Else
                                rect((local1 - ($28 - (local4 * $06))), local2, ($28 - (local4 * $06)), $05, $00)
                            EndIf
                            local2 = (local2 + $0F)
                        Next
                    EndIf
                EndIf
        End Select
        If (mousehit2 <> 0) Then
            entityalpha(dark, 0.0)
            If (selecteditem\Field1\Field1 = "paper") Then
                If (selecteditem\Field1\Field7 <> $00) Then
                    freeimage(selecteditem\Field1\Field7)
                EndIf
                selecteditem\Field1\Field7 = $00
            EndIf
            If (selecteditem\Field1\Field2 <> $42) Then
                playsound(picksfx(selecteditem\Field1\Field2))
            EndIf
            selecteditem = Null
        EndIf
    EndIf
    If (selecteditem = Null) Then
        For local4 = $00 To $06 Step $01
            If (radiochn(local4) <> $00) Then
                If (channelplaying(radiochn(local4)) <> 0) Then
                    pausechannel(radiochn(local4))
                EndIf
            EndIf
        Next
    EndIf
    If ((local13 And (invopen = $00)) <> 0) Then
        movemouse(viewport_center_x, viewport_center_y)
    EndIf
    Return $00
End Function
