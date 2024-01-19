Function use914%(arg0.items, arg1$, arg2#, arg3#, arg4#)
    Local local0.items
    Local local1%
    Local local4.decals
    Select arg0\Field11
        Case "Document SCP-106","Document","Security Clearance Levels","Mobile Task Forces","Object Classes","Document SCP-173","Document SCP-895","Document SCP-079","Origami","Document SCP-860","Document SCP-682","Document SCP-860-1","SCP-093 Recovered Materials"
            Select arg1
                Case "rough","coarse"
                    local4 = createdecal($07, arg2, ((8.0 * roomscale) + 0.005), arg4, 90.0, (Float rand($168, $01)), 0.0)
                    local4\Field2 = 0.12
                    scalesprite(local4\Field0, local4\Field2, local4\Field2)
                Case "1:1"
                    Select rand($04, $01)
                        Case $01
                            local0 = createitem("Document SCP-106", "paper", arg2, arg3, arg4, "GFX\items\paper.x", "GFX\items\INVpaper.jpg", "GFX\items\doc106.jpg", 0.003, "")
                        Case $02
                            local0 = createitem("Document SCP-079", "paper", arg2, arg3, arg4, "GFX\items\paper.x", "GFX\items\INVpaper.jpg", "GFX\items\doc079.jpg", 0.003, "")
                        Case $03
                            local0 = createitem("Document SCP-173", "paper", arg2, arg3, arg4, "GFX\items\paper.x", "GFX\items\INVpaper.jpg", "GFX\items\doc173.jpg", 0.003, "")
                        Case $04
                            local0 = createitem("Document SCP-895", "paper", arg2, arg3, arg4, "GFX\items\paper.x", "GFX\items\INVpaper.jpg", "GFX\items\doc895.jpg", 0.003, "")
                        Case $05
                            local0 = createitem("Document SCP-682", "paper", arg2, arg3, arg4, "GFX\items\paper.x", "GFX\items\INVpaper.jpg", "GFX\items\doc682.jpg", 0.003, "")
                        Case $06
                            local0 = createitem("Document SCP-860", "paper", arg2, arg3, arg4, "GFX\items\paper.x", "GFX\items\INVpaper.jpg", "GFX\items\doc860.jpg", 0.003, "")
                    End Select
                    local0\Field9 = $00
                Case "fine","very fine"
                    local0 = createitem("Origami", "misc", arg2, arg3, arg4, "GFX\items\origami.b3d", "GFX\items\INVorigami.jpg", "", 0.003, "")
                    local0\Field9 = $00
            End Select
            removeitem(arg0)
        Case "Level 1 Key Card","Level 2 Key Card","Level 3 Key Card","Level 4 Key Card","Level 5 Key Card","Key Card"
            Select arg1
                Case "rough","coarse"
                    local4 = createdecal($07, arg2, ((8.0 * roomscale) + 0.005), arg4, 90.0, (Float rand($168, $01)), 0.0)
                    local4\Field2 = 0.07
                    scalesprite(local4\Field0, local4\Field2, local4\Field2)
                Case "1:1"
                    local0 = createitem("Playing Card", "misc", arg2, arg3, arg4, "GFX\items\keycard.x", "GFX\items\INVcard.jpg", "", 0.0004, "")
                    local1 = loadtexture("GFX\items\card.jpg", $01)
                    entitytexture(local0\Field0, local1, $00, $00)
                    freetexture(local1)
                Case "fine"
                    Select arg0\Field11
                        Case "Level 1 Key Card"
                            local0 = createitem("Level 2 Key Card", "key2", arg2, arg3, arg4, "GFX\items\keycard.x", "GFX\items\INVkey2.jpg", "", 0.0004, "")
                            local1 = loadtexture("GFX\items\keycard2.jpg", $01)
                        Case "Level 2 Key Card"
                            local0 = createitem("Level 3 Key Card", "key3", arg2, arg3, arg4, "GFX\items\keycard.x", "GFX\items\INVkey3.jpg", "", 0.0004, "")
                            local1 = loadtexture("GFX\items\keycard3.jpg", $01)
                        Case "Level 3 Key Card"
                            local0 = createitem("Level 4 Key Card", "key4", arg2, arg3, arg4, "GFX\items\keycard.x", "GFX\items\INVkey4.jpg", "", 0.0004, "")
                            local1 = loadtexture("GFX\items\keycard4.jpg", $01)
                        Case "Level 4 Key Card"
                            local0 = createitem("Level 5 Key Card", "key5", arg2, arg3, arg4, "GFX\items\keycard.x", "GFX\items\INVkey5.jpg", "", 0.0004, "")
                            local1 = loadtexture("GFX\items\keycard5.jpg", $01)
                        Case "Level 5 Key Card"
                            local0 = createitem("Key Card Omni", "key6", arg2, arg3, arg4, "GFX\items\keycard.x", "GFX\items\INVkeyomni.jpg", "", 0.0004, "")
                            local1 = loadtexture("GFX\items\keycardomni.jpg", $01)
                    End Select
                    entitytexture(local0\Field0, local1, $00, $00)
                    freetexture(local1)
                Case "very fine"
                    If (rand($03, $01) = $01) Then
                        local0 = createitem("Mastercard", "misc", arg2, arg3, arg4, "GFX\items\keycard.x", "GFX\items\INVmastercard.jpg", "", 0.0004, "")
                        local1 = loadtexture("GFX\items\mastercard.jpg", $01)
                        entitytexture(local0\Field0, local1, $00, $00)
                    Else
                        local0 = createitem("Key Card Omni", "key6", arg2, arg3, arg4, "GFX\items\keycard.x", "GFX\items\INVkeyomni.jpg", "", 0.0004, "")
                        local1 = loadtexture("GFX\items\keycardomni.jpg", $01)
                        entitytexture(local0\Field0, local1, $00, $00)
                    EndIf
                    freetexture(local1)
            End Select
            removeitem(arg0)
        Case "Key Card Omni"
            Select arg1
                Case "rough","coarse"
                    local4 = createdecal($07, arg2, ((8.0 * roomscale) + 0.005), arg4, 90.0, (Float rand($168, $01)), 0.0)
                    local4\Field2 = 0.07
                    scalesprite(local4\Field0, local4\Field2, local4\Field2)
                Case "1:1"
                    If (rand($02, $01) = $01) Then
                        local0 = createitem("Mastercard", "misc", arg2, arg3, arg4, "GFX\items\keycard.x", "GFX\items\INVmastercard.jpg", "", 0.0004, "")
                        local1 = loadtexture("GFX\items\mastercard.jpg", $01)
                        entitytexture(local0\Field0, local1, $00, $00)
                    Else
                        local0 = createitem("Playing Card", "misc", arg2, arg3, arg4, "GFX\items\keycard.x", "GFX\items\INVcard.jpg", "", 0.0004, "")
                        local1 = loadtexture("GFX\items\card.jpg", $01)
                        entitytexture(local0\Field0, local1, $00, $00)
                    EndIf
                    freetexture(local1)
                Case "fine","very fine"
                    local0 = createitem("Key Card Omni", "key6", arg2, arg3, arg4, "GFX\items\keycard.x", "GFX\items\INVkeyomni.jpg", "", 0.0004, "")
                    local1 = loadtexture("GFX\items\keycardomni.jpg", $01)
                    entitytexture(local0\Field0, local1, $00, $00)
            End Select
            removeitem(arg0)
        Case "Playing Card"
            Select arg1
                Case "rough","coarse"
                    local4 = createdecal($07, arg2, ((8.0 * roomscale) + 0.005), arg4, 90.0, (Float rand($168, $01)), 0.0)
                    local4\Field2 = 0.07
                    scalesprite(local4\Field0, local4\Field2, local4\Field2)
                Case "1:1","fine","very fine"
                    If (rand($02, $01) = $01) Then
                        local0 = createitem("Mastercard", "misc", arg2, arg3, arg4, "GFX\items\keycard.x", "GFX\items\INVmastercard.jpg", "", 0.0004, "")
                        local1 = loadtexture("GFX\items\mastercard.jpg", $01)
                        entitytexture(local0\Field0, local1, $00, $00)
                    Else
                        local0 = createitem("Level 2 Key Card", "key2", arg2, arg3, arg4, "GFX\items\keycard.x", "GFX\items\INVkey2.jpg", "", 0.0004, "")
                        local1 = loadtexture("GFX\items\keycard2.jpg", $01)
                        entitytexture(local0\Field0, local1, $00, $00)
                    EndIf
                    freetexture(local1)
            End Select
            removeitem(arg0)
        Case "S-NAV 300 Navigator","S-NAV 310 Navigator","S-NAV Navigator","S-NAV Navigator Ultimate"
            Select arg1
                Case "rough","coarse"
                    local0 = createitem("Electronical components", "misc", arg2, arg3, arg4, "GFX\items\electronics.x", "GFX\items\INVelectronics.jpg", "", 0.0011, "")
                Case "1:1"
                    local0 = createitem("S-NAV Navigator", "nav", arg2, arg3, arg4, "GFX\items\navigator.x", "GFX\items\INVnavigator.jpg", "GFX\items\navigator.png", 0.0011, "")
                    local0\Field8 = 100.0
                Case "fine"
                    local0 = createitem("S-NAV 310 Navigator", "nav", arg2, arg3, arg4, "GFX\items\navigator.x", "GFX\items\INVnavigator.jpg", "GFX\items\navigator.png", 0.0011, "")
                    local0\Field8 = 100.0
                Case "very fine"
                    local0 = createitem("S-NAV Navigator Ultimate", "nav", arg2, arg3, arg4, "GFX\items\navigator.x", "GFX\items\INVnavigator.jpg", "GFX\items\navigator.png", 0.0011, "")
                    local0\Field8 = 101.0
            End Select
            removeitem(arg0)
        Case "Some SCP-420-J","Cigarette"
            Select arg1
                Case "rough","coarse"
                    local4 = createdecal($00, arg2, ((8.0 * roomscale) + 0.01), arg4, 90.0, (Float rand($168, $01)), 0.0)
                    local4\Field2 = 0.2
                    entityalpha(local4\Field0, 0.8)
                    scalesprite(local4\Field0, local4\Field2, local4\Field2)
                Case "1:1"
                    local0 = createitem("Cigarette", "cigarette", (arg2 + 1.5), (arg3 + 0.5), (arg4 + 1.0), "GFX\items\420.x", "GFX\items\INV420.jpg", "", 0.0004, "")
                    local0\Field9 = $02
                Case "fine"
                    local0 = createitem("Joint", "420s", (arg2 + 1.5), (arg3 + 0.5), (arg4 + 1.0), "GFX\items\420.x", "GFX\items\INV420.jpg", "", 0.0004, "")
                    local0\Field9 = $02
                Case "very fine"
                    local0 = createitem("Smelly Joint", "420s", (arg2 + 1.5), (arg3 + 0.5), (arg4 + 1.0), "GFX\items\420.x", "GFX\items\INV420.jpg", "", 0.0004, "")
                    local0\Field9 = $02
            End Select
            removeitem(arg0)
        Case "9V Battery","18V Battery","Strange Battery"
            Select arg1
                Case "rough","coarse"
                    local4 = createdecal($00, arg2, ((8.0 * roomscale) + 0.01), arg4, 90.0, (Float rand($168, $01)), 0.0)
                    local4\Field2 = 0.2
                    entityalpha(local4\Field0, 0.8)
                    scalesprite(local4\Field0, local4\Field2, local4\Field2)
                Case "1:1"
                    local0 = createitem("18V Battery", "18vbat", arg2, arg3, arg4, "GFX\items\battery.x", "GFX\items\INVbattery.jpg", "", 0.0003, "")
                Case "fine"
                    local0 = createitem("Strange Battery", "killbat", arg2, arg3, arg4, "GFX\items\battery.x", "GFX\items\INVbattery.jpg", "", 0.0003, "")
                Case "very fine"
                    local0 = createitem("Strange Battery", "killbat", arg2, arg3, arg4, "GFX\items\battery.x", "GFX\items\INVbattery.jpg", "", 0.0003, "")
            End Select
            removeitem(arg0)
        Case "ReVision Eyedrops"
            Select arg1
                Case "rough","coarse"
                    local4 = createdecal($00, arg2, ((8.0 * roomscale) + 0.01), arg4, 90.0, (Float rand($168, $01)), 0.0)
                    local4\Field2 = 0.2
                    entityalpha(local4\Field0, 0.8)
                    scalesprite(local4\Field0, local4\Field2, local4\Field2)
                Case "1:1"
                    local0 = createitem("ReVision Eyedrops", "eyedrops", arg2, arg3, arg4, "GFX\items\eyedrops.b3d", "GFX\items\INVeyedropsred.jpg", "", 0.0012, "GFX\items\eyedropsbump.jpg")
                    local1 = loadtexture("GFX\items\eyedropsred.jpg", $01)
                    entitytexture(local0\Field0, local1, $00, $00)
                    freetexture(local1)
                    local0\Field9 = $01
                Case "fine"
                    local0 = createitem("Eyedrops", "fineeyedrops", arg2, arg3, arg4, "GFX\items\eyedrops.b3d", "GFX\items\INVeyedrops.jpg", "", 0.0012, "GFX\items\eyedropsbump.jpg")
                    local0\Field9 = $01
                Case "very fine"
                    local0 = createitem("Eyedrops", "supereyedrops", arg2, arg3, arg4, "GFX\items\eyedrops.b3d", "GFX\items\INVeyedrops.jpg", "", 0.0012, "GFX\items\eyedropsbump.jpg")
                    local0\Field9 = $01
            End Select
            removeitem(arg0)
        Default
            positionentity(arg0\Field0, arg2, arg3, arg4, $00)
            resetentity(arg0\Field0)
    End Select
    If (local0 <> Null) Then
        entitytype(local0\Field0, $03, $00)
    EndIf
    Return $00
End Function
