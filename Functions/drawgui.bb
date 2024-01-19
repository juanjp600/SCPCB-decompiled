Function drawgui%()
    Local local0%
    Local local1%
    Local local2%
    Local local3%
    Local local4#
    Local local5#
    Local local7%
    Local local8%
    Local local9%
    Local local10%
    Local local11%
    Local local12%
    Local local13%
    Local local14%
    Local local19%
    Local local20%
    Local local21#
    Local local22%
    Local local23%
    Local local24%
    Local local25%
    If (closestbutton <> $00) Then
        local0 = createpivot($00)
        positionentity(local0, entityx(camera, $00), entityy(camera, $00), entityz(camera, $00), $00)
        pointentity(local0, closestbutton, 0.0)
        local4 = wrapangle((entityyaw(camera, $00) - entityyaw(local0, $00)))
        If (((90.0 < local4) And (180.0 >= local4)) <> 0) Then
            local4 = 90.0
        EndIf
        If (((180.0 < local4) And (270.0 > local4)) <> 0) Then
            local4 = 270.0
        EndIf
        local5 = wrapangle((entitypitch(camera, $00) - entitypitch(local0, $00)))
        If (((90.0 < local5) And (180.0 >= local5)) <> 0) Then
            local5 = 90.0
        EndIf
        If (((180.0 < local5) And (270.0 > local5)) <> 0) Then
            local5 = 270.0
        EndIf
        freeentity(local0)
        drawimage(handicon, (Int ((((Float (graphicwidth / $03)) * sin(local4)) + (Float (graphicwidth Sar $01))) - 32.0)), (Int (((Float (graphicheight Sar $01)) - ((Float (graphicheight / $03)) * sin(local5))) - 32.0)), $00)
        If (mousehit1 <> 0) Then
            playsound2(buttonsfx, camera, closestbutton, 10.0, 1.0)
            usedoor(closestdoor)
        EndIf
    EndIf
    If (closestitem <> Null) Then
        local0 = createpivot($00)
        positionentity(local0, entityx(camera, $00), entityy(camera, $00), entityz(camera, $00), $00)
        pointentity(local0, closestitem\Field0, 0.0)
        local4 = wrapangle((entityyaw(camera, $00) - entityyaw(local0, $00)))
        If (((90.0 < local4) And (180.0 >= local4)) <> 0) Then
            local4 = 90.0
        EndIf
        If (((180.0 < local4) And (270.0 > local4)) <> 0) Then
            local4 = 270.0
        EndIf
        local5 = wrapangle((entitypitch(camera, $00) - entitypitch(local0, $00)))
        If (((90.0 < local5) And (180.0 >= local5)) <> 0) Then
            local5 = 90.0
        EndIf
        If (((180.0 < local5) And (270.0 > local5)) <> 0) Then
            local5 = 270.0
        EndIf
        freeentity(local0)
        drawimage(handicon, (Int ((((Float (graphicwidth / $03)) * sin(local4)) + (Float (graphicwidth Sar $01))) - 32.0)), (Int (((Float (graphicheight Sar $01)) - ((Float (graphicheight / $03)) * sin(local5))) - 32.0)), $00)
    EndIf
    If (drawhandicon <> 0) Then
        drawimage(handicon, ((graphicwidth Sar $01) - $20), ((graphicheight Sar $01) - $20), $00)
    EndIf
    For local3 = $00 To $03 Step $01
        If (drawarrowicon(local3) <> 0) Then
            local1 = ((graphicwidth Sar $01) - $20)
            local2 = ((graphicheight Sar $01) - $20)
            Select local3
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
            drawimage(arrowimg(local3), (local1 + $15), (local2 + $15), $00)
            drawarrowicon(local3) = $00
        EndIf
    Next
    local7 = $CC
    local8 = $14
    local1 = $50
    local2 = (graphicheight - $5F)
    color($FF, $FF, $FF)
    rect(local1, local2, local7, local8, $00)
    color($57, $65, $69)
    If (60.0 > blinktimer) Then
        color($C8, $00, $00)
    EndIf
    For local3 = $01 To (Int (((blinktimer / 560.0) * (Float (local7 - $02))) / 10.0)) Step $01
        drawimage(blinkmeterimg, ((local1 + $03) + ((local3 - $01) * $0A)), (local2 + $03), $00)
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
    rect(local1, local2, local7, local8, $00)
    color($35, $44, $25)
    If (10.0 > stamina) Then
        color($C8, $00, $00)
    EndIf
    For local3 = $01 To (Int (((stamina / 100.0) * (Float (local7 - $02))) / 10.0)) Step $01
        drawimage(staminameterimg, ((local1 + $03) + ((local3 - $01) * $0A)), (local2 + $03), $00)
    Next
    color($00, $00, $00)
    rect((local1 - $32), local2, $1E, $1E, $01)
    color($FF, $FF, $FF)
    rect(((local1 - $32) - $01), (local2 - $01), $20, $20, $00)
    drawimage(sprinticon, (local1 - $32), local2, $00)
    local9 = invopen
    local10 = $42
    If (keyhit($01) <> 0) Then
        menuopen = (menuopen = $00)
    EndIf
    If (invopen <> 0) Then
        showpointer()
        local7 = $46
        local8 = $46
        local11 = $23
        local1 = ((graphicwidth Sar $01) - (((local7 * $05) + (local11 Shl $02)) Sar $01))
        local2 = ((graphicheight Sar $01) - (local8 Sar $01))
        itemamount = $00
        For local12 = $00 To $04 Step $01
            local13 = $00
            If (((mousex() > local1) And (mousex() < (local1 + local7))) <> 0) Then
                If (((mousey() > local2) And (mousey() < (local2 + local8))) <> 0) Then
                    local13 = $01
                EndIf
            EndIf
            If (local13 <> 0) Then
                local10 = local12
                color($FF, $00, $00)
                rect((local1 - $01), (local2 - $01), (local7 + $02), (local8 + $02), $01)
            EndIf
            color($FF, $FF, $FF)
            rect(local1, local2, local7, local8, $00)
            color($7D, $7D, $7D)
            rect((local1 + $01), (local2 + $01), (local7 - $02), (local8 - $02), $00)
            color($00, $00, $00)
            rect((local1 + $05), (local2 + $05), (local7 - $0A), (local8 - $0A), $01)
            If (inventory(local12) <> Null) Then
                If (((selecteditem <> inventory(local12)) Or local13) <> 0) Then
                    drawimage(inventory(local12)\Field1, (((local7 Sar $01) + local1) - $20), (((local8 Sar $01) + local2) - $20), $00)
                EndIf
            EndIf
            If (((inventory(local12) <> Null) And (selecteditem <> inventory(local12))) <> 0) Then
                If (local13 <> 0) Then
                    color($FF, $FF, $FF)
                    text(((local7 Sar $01) + local1), ((local2 + local8) + local11), inventory(local12)\Field11, $01, $00)
                    If (selecteditem = Null) Then
                        If (mousehit1 <> 0) Then
                            selecteditem = inventory(local12)
                            mousehit1 = $00
                            If (doubleclick <> 0) Then
                                If (inventory(local12)\Field9 <> $42) Then
                                    playsound(picksfx(inventory(local12)\Field9))
                                EndIf
                                invopen = $00
                                doubleclick = $00
                            EndIf
                        EndIf
                    EndIf
                EndIf
                itemamount = (itemamount + $01)
            ElseIf ((local13 And mousehit1) <> 0) Then
                For local14 = $00 To $04 Step $01
                    If (inventory(local14) = selecteditem) Then
                        inventory(local14) = Null
                    EndIf
                Next
                inventory(local12) = selecteditem
            EndIf
            local1 = ((local1 + local7) + local11)
        Next
        If (selecteditem <> Null) Then
            If (mousedown1 <> 0) Then
                If (local10 = $42) Then
                    drawimage(selecteditem\Field1, (mousex() - (imagewidth(selecteditem\Field1) Sar $01)), (mousey() - (imageheight(selecteditem\Field1) Sar $01)), $00)
                ElseIf (selecteditem <> inventory(local10)) Then
                    drawimage(selecteditem\Field1, (mousex() - (imagewidth(selecteditem\Field1) Sar $01)), (mousey() - (imageheight(selecteditem\Field1) Sar $01)), $00)
                EndIf
            Else
                If (local10 = $42) Then
                    If (selecteditem\Field9 <> $42) Then
                        playsound(picksfx(selecteditem\Field9))
                    EndIf
                    showentity(selecteditem\Field0)
                    positionentity(selecteditem\Field0, entityx(camera, $00), entityy(camera, $00), entityz(camera, $00), $00)
                    rotateentity(selecteditem\Field0, entitypitch(camera, $00), entityyaw(camera, $00), 0.0, $00)
                    moveentity(selecteditem\Field0, 0.0, -0.1, 0.1)
                    rotateentity(selecteditem\Field0, 0.0, (Float rand($168, $01)), 0.0, $00)
                    resetentity(selecteditem\Field0)
                    selecteditem\Field12 = $00
                    For local14 = $00 To $04 Step $01
                        If (inventory(local14) = selecteditem) Then
                            inventory(local14) = Null
                        EndIf
                    Next
                    If (selecteditem\Field10 = "gasmask") Then
                        wearinggasmask = $00
                    EndIf
                    selecteditem = Null
                    invopen = $00
                    movemouse(viewport_center_x, viewport_center_y)
                Else
                    debuglog(("mouseslot " + (Str local10)))
                    If (inventory(local10) = Null) Then
                        For local14 = $00 To $04 Step $01
                            If (inventory(local14) = selecteditem) Then
                                inventory(local14) = Null
                            EndIf
                        Next
                        inventory(local10) = selecteditem
                        selecteditem = Null
                    ElseIf (inventory(local10) <> selecteditem) Then
                        Select selecteditem\Field10
                            Case "battery","bat"
                                Select inventory(local10)\Field11
                                    Case "S-NAV Navigator","S-NAV 300 Navigator","S-NAV 310 Navigator"
                                        If (selecteditem\Field9 <> $42) Then
                                            playsound(picksfx(selecteditem\Field9))
                                        EndIf
                                        removeitem(selecteditem)
                                        selecteditem = Null
                                        inventory(local10)\Field8 = 100.0
                                        msg = "You replaced the battery of the navigator"
                                        msgtimer = 350.0
                                    Case "S-NAV Navigator Ultimate"
                                        msg = "There seems to be no place for batteries in the navigator"
                                        msgtimer = 350.0
                                    Default
                                        debuglog(inventory(local10)\Field11)
                                        msg = "This item can't be used this way"
                                        msgtimer = 350.0
                                End Select
                            Case "18vbat"
                                Select inventory(local10)\Field11
                                    Case "S-NAV Navigator","S-NAV 300 Navigator","S-NAV 310 Navigator"
                                        msg = "The battery doesn't seem to fit"
                                        msgtimer = 350.0
                                    Case "S-NAV Navigator Ultimate"
                                        msg = "There seems to be no place for batteries in the navigator"
                                        msgtimer = 350.0
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
    Else
        hidepointer()
        If (selecteditem <> Null) Then
            Select selecteditem\Field10
                Case "battery"
                Case "key1","key2","key3","key4","key5","key6","keyomni"
                    drawimage(selecteditem\Field1, ((graphicwidth Sar $01) - (imagewidth(selecteditem\Field1) Sar $01)), ((graphicheight Sar $01) - (imageheight(selecteditem\Field1) Sar $01)), $00)
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
                    entityalpha(dark, 0.5)
                    drawimage(selecteditem\Field2, ((graphicwidth Sar $01) - (imagewidth(selecteditem\Field2) Sar $01)), ((graphicheight Sar $01) - (imageheight(selecteditem\Field2) Sar $01)), $00)
                Case "radio"
                    entityalpha(dark, 0.5)
                    drawimage(selecteditem\Field2, ((graphicwidth Sar $01) - (imagewidth(selecteditem\Field2) Sar $01)), ((graphicheight Sar $01) - (imageheight(selecteditem\Field2) Sar $01)), $00)
                Case "cigarette"
                    msg = "Nah, a cigarette won't help me relax in a situation like this"
                    msgtimer = 350.0
                    removeitem(selecteditem)
                Case "420"
                    msg = "MAN DATS SUM GOOD ASS SHIT"
                    msgtimer = 350.0
                    removeitem(selecteditem)
                Case "420s"
                    msg = "UH WHERE... WHAT WAS I DOING AGAIN... MAN I NEED TO TAKE A NAP..."
                    killtimer = -1.0
                    msgtimer = 350.0
                    removeitem(selecteditem)
                Case "gasmask"
                    wearinggasmask = (wearinggasmask = $00)
                    selecteditem = Null
                Case "navigator","nav"
                    If (100.0 >= selecteditem\Field8) Then
                        selecteditem\Field8 = max(0.0, (selecteditem\Field8 - (fpsfactor * 0.01)))
                    EndIf
                    local1 = ((graphicwidth Sar $01) + $07)
                    local2 = ((graphicheight Sar $01) - $1C)
                    local7 = $11F
                    local8 = $100
                    drawimage(selecteditem\Field2, ((graphicwidth Sar $01) - (imagewidth(selecteditem\Field2) Sar $01)), ((graphicheight Sar $01) - (imageheight(selecteditem\Field2) Sar $01)), $00)
                    If (playerroom\Field5\Field4 = "pocketdimension") Then
                        If ((millisecs() Mod $3E8) > $12C) Then
                            text(local1, (((local8 Sar $01) + local2) - $50), "ERROR 06", $01, $00)
                            text(local1, (((local8 Sar $01) + local2) - $3C), "LOCATION UNKNOWN", $01, $00)
                        EndIf
                    ElseIf (((0.0 < selecteditem\Field8) And ((1.0 < rnd((coffindistance + 15.0), 0.0)) Or (playerroom\Field5\Field4 <> "coffin"))) <> 0) Then
                        color($E6, $DF, $CC)
                        If (selecteditem\Field11 = "S-NAV Navigator") Then
                            color($FF, $00, $00)
                        EndIf
                        If ((millisecs() Mod $3E8) > $12C) Then
                            If (((selecteditem\Field11 <> "S-NAV 310 Navigator") And (selecteditem\Field11 <> "S-NAV Navigator Ultimate")) <> 0) Then
                                text(local1, (((local8 Sar $01) + local2) - $28), "COULDN'T CONNECT", $01, $00)
                                text(local1, (((local8 Sar $01) + local2) - $14), "TO MAP DATABASE", $01, $00)
                            EndIf
                            rect((local1 - $04), ((local2 - $04) - $07), $08, $08, $00)
                        EndIf
                        local19 = (Int floor(((entityx(playerroom\Field0, $00) / 8.0) + 0.5)))
                        local20 = (Int floor(((entityz(playerroom\Field0, $00) / 8.0) + 0.5)))
                        If (((selecteditem\Field11 = "S-NAV Navigator Ultimate") And ((millisecs() Mod $258) < $190)) <> 0) Then
                            local21 = entitydistance(camera, curr173\Field0)
                            local21 = (ceil((local21 / 8.0)) * 8.0)
                            If (32.0 > local21) Then
                                color($FF, $00, $00)
                                oval((Int ((Float local1) - (local21 * 3.0))), (Int ((Float (local2 - $07)) - (local21 * 3.0))), (Int ((local21 * 3.0) * 2.0)), (Int ((local21 * 3.0) * 2.0)), $00)
                                text(((local1 - (local7 Sar $01)) + $14), ((local2 - (local8 Sar $01)) + $14), "SCP-173", $00, $00)
                            EndIf
                            local21 = entitydistance(camera, curr106\Field0)
                            If (32.0 > local21) Then
                                color($FF, $00, $00)
                                oval((Int ((Float local1) - (local21 * 1.5))), (Int ((Float (local2 - $07)) - (local21 * 1.5))), (Int (local21 * 3.0)), (Int (local21 * 3.0)), $00)
                                text(((local1 - (local7 Sar $01)) + $14), ((local2 - (local8 Sar $01)) + $28), "SCP-106", $00, $00)
                            EndIf
                            If (playerroom\Field5\Field4 = "coffin") Then
                                If (8.0 > coffindistance) Then
                                    local21 = rnd(4.0, 8.0)
                                    color($FF, $00, $00)
                                    oval((Int ((Float local1) - (local21 * 1.5))), (Int ((Float (local2 - $07)) - (local21 * 1.5))), (Int (local21 * 3.0)), (Int (local21 * 3.0)), $00)
                                    text(((local1 - (local7 Sar $01)) + $14), ((local2 - (local8 Sar $01)) + $28), "SCP-895", $00, $00)
                                EndIf
                            EndIf
                        EndIf
                        local21 = 4.0
                        For local22 = (Int max(1.0, ((Float local19) - local21))) To (Int min((Float (mapwidth - $02)), ((Float local19) + local21))) Step $01
                            For local23 = (Int max(1.0, ((Float local20) - local21))) To (Int min((Float (mapheight - $02)), ((Float local20) + local21))) Step $01
                                local24 = (((local19 - local22) * $18) + local1)
                                local25 = ((local2 - ((local20 - local23) * $18)) - $07)
                                If (playerroom\Field5\Field4 = "coffin") Then
                                    If (((8.0 > coffindistance) And (0.5 > rnd(coffindistance, 0.0))) <> 0) Then
                                        local24 = (Int (((15.0 - coffindistance) * rnd(-1.0, 1.0)) + (Float local24)))
                                        local25 = (Int (((15.0 - coffindistance) * rnd(-1.0, 1.0)) + (Float local25)))
                                    EndIf
                                EndIf
                                If ((maptemp(local22, local23) And (((mapfound(local22, local23) > $00) Or (selecteditem\Field11 = "S-NAV 310 Navigator")) Or (selecteditem\Field11 = "S-NAV Navigator Ultimate"))) <> 0) Then
                                    If (mapfound(local22, local23) = $01) Then
                                        color($73, $70, $66)
                                        If (selecteditem\Field11 = "S-NAV Navigator") Then
                                            color($80, $00, $00)
                                        EndIf
                                    Else
                                        color($E6, $DF, $CC)
                                        If (selecteditem\Field11 = "S-NAV Navigator") Then
                                            color($FF, $00, $00)
                                        EndIf
                                    EndIf
                                    If (maptemp((local22 + $01), local23) = $00) Then
                                        line((local24 - $0C), (local25 - $0C), (local24 - $0C), (local25 + $0C))
                                    EndIf
                                    If (maptemp((local22 - $01), local23) = $00) Then
                                        line((local24 + $0C), (local25 - $0C), (local24 + $0C), (local25 + $0C))
                                    EndIf
                                    If (maptemp(local22, (local23 - $01)) = $00) Then
                                        line((local24 - $0C), (local25 - $0C), (local24 + $0C), (local25 - $0C))
                                    EndIf
                                    If (maptemp(local22, (local23 + $01)) = $00) Then
                                        line((local24 - $0C), (local25 + $0C), (local24 + $0C), (local25 + $0C))
                                    EndIf
                                EndIf
                            Next
                        Next
                        local1 = (((graphicwidth Sar $01) + (local7 Sar $01)) - $0A)
                        local2 = ((graphicheight Sar $01) - (local8 Sar $01))
                        color($E6, $DF, $CC)
                        If (selecteditem\Field11 = "S-NAV Navigator") Then
                            color($FF, $00, $00)
                        EndIf
                        If (100.0 >= selecteditem\Field8) Then
                            text((local1 - $3C), (local2 - $14), "BATTERY", $00, $00)
                            For local3 = $01 To $05 Step $01
                                If ((Float ($05 - local3)) < ceil((selecteditem\Field8 / 20.0))) Then
                                    rect((local1 - ($28 - (local3 * $06))), local2, ($28 - (local3 * $06)), $05, $01)
                                Else
                                    rect((local1 - ($28 - (local3 * $06))), local2, ($28 - (local3 * $06)), $05, $00)
                                EndIf
                                local2 = (local2 + $0F)
                            Next
                        EndIf
                    EndIf
            End Select
            If (mousehit2 <> 0) Then
                entityalpha(dark, 0.0)
                If (selecteditem\Field9 <> $42) Then
                    playsound(picksfx(selecteditem\Field9))
                EndIf
                selecteditem = Null
            EndIf
        EndIf
    EndIf
    If ((local9 And (invopen = $00)) <> 0) Then
        movemouse(viewport_center_x, viewport_center_y)
    EndIf
    Return $00
End Function
