Function use914%(arg0.items, arg1$, arg2#, arg3#, arg4#)
    Local local0.items
    Local local1%
    Local local4.decals
    refineditems = (refineditems + $01)
    Select arg0\Field1\Field0
        Case "Document SCP-106","Note","Notification","Document","Security Clearance Levels","Mobile Task Forces","Object Classes","Document SCP-173","Document SCP-895","Document SCP-079","Origami","Document SCP-860","Document SCP-682","Document SCP-860-1","SCP-093 Recovered Materials"
            Select arg1
                Case "rough","coarse"
                    local4 = createdecal($07, arg2, ((8.0 * roomscale) + 0.005), arg4, 90.0, (Float rand($168, $01)), 0.0)
                    local4\Field2 = 0.12
                    scalesprite(local4\Field0, local4\Field2, local4\Field2)
                Case "1:1"
                    Select rand($06, $01)
                        Case $01
                            local0 = createitem("Document SCP-106", "paper", arg2, arg3, arg4)
                        Case $02
                            local0 = createitem("Document SCP-079", "paper", arg2, arg3, arg4)
                        Case $03
                            local0 = createitem("Document SCP-173", "paper", arg2, arg3, arg4)
                        Case $04
                            local0 = createitem("Document SCP-895", "paper", arg2, arg3, arg4)
                        Case $05
                            local0 = createitem("Document SCP-682", "paper", arg2, arg3, arg4)
                        Case $06
                            local0 = createitem("Document SCP-860", "paper", arg2, arg3, arg4)
                    End Select
                Case "fine","very fine"
                    local0 = createitem("Origami", "misc", arg2, arg3, arg4)
            End Select
            removeitem(arg0)
        Case "Gas Mask"
            Select arg1
                Case "rough","coarse"
                    local4 = createdecal($07, arg2, ((8.0 * roomscale) + 0.005), arg4, 90.0, (Float rand($168, $01)), 0.0)
                    local4\Field2 = 0.12
                    scalesprite(local4\Field0, local4\Field2, local4\Field2)
                Case "1:1"
                    positionentity(arg0\Field0, arg2, arg3, arg4, $00)
                    resetentity(arg0\Field0)
                    removeitem(arg0)
                Case "fine","very fine"
                    local0 = createitem("Gas Mask", "supergasmask", arg2, arg3, arg4)
                    removeitem(arg0)
            End Select
        Case "Ballistic Best"
            Select arg1
                Case "rough","coarse"
                    local4 = createdecal($07, arg2, ((8.0 * roomscale) + 0.005), arg4, 90.0, (Float rand($168, $01)), 0.0)
                    local4\Field2 = 0.12
                    scalesprite(local4\Field0, local4\Field2, local4\Field2)
                Case "1:1"
                    positionentity(arg0\Field0, arg2, arg3, arg4, $00)
                    resetentity(arg0\Field0)
                    removeitem(arg0)
                Case "fine"
                    local0 = createitem("Heavy Ballistic Vest", "finevest", arg2, arg3, arg4)
                    removeitem(arg0)
                Case "very fine"
                    local0 = createitem("Bulky Ballistic Vest", "finevest", arg2, arg3, arg4)
                    removeitem(arg0)
            End Select
        Case "First Aid Kit"
            Select arg1
                Case "rough","coarse"
                    local4 = createdecal($07, arg2, ((8.0 * roomscale) + 0.005), arg4, 90.0, (Float rand($168, $01)), 0.0)
                    local4\Field2 = 0.12
                    scalesprite(local4\Field0, local4\Field2, local4\Field2)
                Case "1:1"
                    local0 = createitem("Blue First Aid Kit", "firstaid2", arg2, arg3, arg4)
                    removeitem(arg0)
                Case "fine"
                    local0 = createitem("Small First Aid Kit", "finefirstaid", arg2, arg3, arg4)
                    removeitem(arg0)
                Case "very fine"
                    local0 = createitem("Strange Bottle", "veryfinefirstaid", arg2, arg3, arg4)
                    removeitem(arg0)
            End Select
        Case "Level 1 Key Card","Level 2 Key Card","Level 3 Key Card","Level 4 Key Card","Level 5 Key Card","Key Card"
            Select arg1
                Case "rough","coarse"
                    local4 = createdecal($07, arg2, ((8.0 * roomscale) + 0.005), arg4, 90.0, (Float rand($168, $01)), 0.0)
                    local4\Field2 = 0.07
                    scalesprite(local4\Field0, local4\Field2, local4\Field2)
                Case "1:1"
                    local0 = createitem("Playing Card", "misc", arg2, arg3, arg4)
                Case "fine"
                    Select arg0\Field1\Field0
                        Case "Level 1 Key Card"
                            local0 = createitem("Level 2 Key Card", "key2", arg2, arg3, arg4)
                        Case "Level 2 Key Card"
                            local0 = createitem("Level 3 Key Card", "key3", arg2, arg3, arg4)
                        Case "Level 3 Key Card"
                            local0 = createitem("Level 4 Key Card", "key4", arg2, arg3, arg4)
                        Case "Level 4 Key Card"
                            local0 = createitem("Level 5 Key Card", "key5", arg2, arg3, arg4)
                        Case "Level 5 Key Card"
                            local0 = createitem("Key Card Omni", "key6", arg2, arg3, arg4)
                    End Select
                Case "very fine"
                    If (rand($03, $01) = $01) Then
                        local0 = createitem("Mastercard", "misc", arg2, arg3, arg4)
                    Else
                        local0 = createitem("Key Card Omni", "key6", arg2, arg3, arg4)
                    EndIf
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
                        local0 = createitem("Mastercard", "misc", arg2, arg3, arg4)
                    Else
                        local0 = createitem("Playing Card", "misc", arg2, arg3, arg4)
                    EndIf
                Case "fine","very fine"
                    local0 = createitem("Key Card Omni", "key6", arg2, arg3, arg4)
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
                        local0 = createitem("Mastercard", "misc", arg2, arg3, arg4)
                    Else
                        local0 = createitem("Level 2 Key Card", "key2", arg2, arg3, arg4)
                    EndIf
            End Select
            removeitem(arg0)
        Case "S-NAV 300 Navigator","S-NAV 310 Navigator","S-NAV Navigator","S-NAV Navigator Ultimate"
            Select arg1
                Case "rough","coarse"
                    local0 = createitem("Electronical components", "misc", arg2, arg3, arg4)
                Case "1:1"
                    local0 = createitem("S-NAV Navigator", "nav", arg2, arg3, arg4)
                    local0\Field7 = 100.0
                Case "fine"
                    local0 = createitem("S-NAV 310 Navigator", "nav", arg2, arg3, arg4)
                    local0\Field7 = 100.0
                Case "very fine"
                    local0 = createitem("S-NAV Navigator Ultimate", "nav", arg2, arg3, arg4)
                    local0\Field7 = 101.0
            End Select
            removeitem(arg0)
        Case "Radio Transceiver"
            Select arg1
                Case "rough","coarse"
                    local0 = createitem("Electronical components", "misc", arg2, arg3, arg4)
                Case "1:1"
                    local0 = createitem("Radio Transceiver", "18vradio", arg2, arg3, arg4)
                    local0\Field7 = 100.0
                Case "fine"
                    local0 = createitem("Radio Transceiver", "fineradio", arg2, arg3, arg4)
                    local0\Field7 = 101.0
                Case "very fine"
                    local0 = createitem("Radio Transceiver", "veryfineradio", arg2, arg3, arg4)
                    local0\Field7 = 101.0
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
                    local0 = createitem("Cigarette", "cigarette", (arg2 + 1.5), (arg3 + 0.5), (arg4 + 1.0))
                Case "fine"
                    local0 = createitem("Joint", "420s", (arg2 + 1.5), (arg3 + 0.5), (arg4 + 1.0))
                Case "very fine"
                    local0 = createitem("Smelly Joint", "420s", (arg2 + 1.5), (arg3 + 0.5), (arg4 + 1.0))
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
                    local0 = createitem("18V Battery", "18vbat", arg2, arg3, arg4)
                Case "fine"
                    local0 = createitem("Strange Battery", "killbat", arg2, arg3, arg4)
                Case "very fine"
                    local0 = createitem("Strange Battery", "killbat", arg2, arg3, arg4)
            End Select
            removeitem(arg0)
        Case "ReVision Eyedrops","RedVision Eyedrops","Eyedrops"
            Select arg1
                Case "rough","coarse"
                    local4 = createdecal($00, arg2, ((8.0 * roomscale) + 0.01), arg4, 90.0, (Float rand($168, $01)), 0.0)
                    local4\Field2 = 0.2
                    entityalpha(local4\Field0, 0.8)
                    scalesprite(local4\Field0, local4\Field2, local4\Field2)
                Case "1:1"
                    local0 = createitem("RedVision Eyedrops", "eyedrops", arg2, arg3, arg4)
                Case "fine"
                    local0 = createitem("Eyedrops", "fineeyedrops", arg2, arg3, arg4)
                Case "very fine"
                    local0 = createitem("Eyedrops", "supereyedrops", arg2, arg3, arg4)
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
