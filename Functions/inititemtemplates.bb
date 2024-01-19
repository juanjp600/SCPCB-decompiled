Function inititemtemplates%()
    Local local0.itemtemplates
    local0 = createitemtemplate("Some SCP-420-J", "420", "GFX\items\420.x", "GFX\items\INV420.jpg", "", 0.0005, "", "")
    local0\Field2 = $02
    createitemtemplate("Level 1 Key Card", "key1", "GFX\items\keycard.x", "GFX\items\INVkey1.jpg", "", 0.0004, "GFX\items\keycard1.jpg", "")
    createitemtemplate("Level 2 Key Card", "key2", "GFX\items\keycard.x", "GFX\items\INVkey2.jpg", "", 0.0004, "GFX\items\keycard2.jpg", "")
    createitemtemplate("Level 3 Key Card", "key3", "GFX\items\keycard.x", "GFX\items\INVkey3.jpg", "", 0.0004, "GFX\items\keycard3.jpg", "")
    createitemtemplate("Level 4 Key Card", "key4", "GFX\items\keycard.x", "GFX\items\INVkey4.jpg", "", 0.0004, "GFX\items\keycard4.jpg", "")
    createitemtemplate("Level 5 Key Card", "key5", "GFX\items\keycard.x", "GFX\items\INVkey5.jpg", "", 0.0004, "GFX\items\keycard5.jpg", "")
    createitemtemplate("Playing Card", "misc", "GFX\items\keycard.x", "GFX\items\INVcard.jpg", "", 0.0004, "GFX\items\card.jpg", "")
    createitemtemplate("Mastercard", "misc", "GFX\items\keycard.x", "GFX\items\INVmastercard.jpg", "", 0.0004, "GFX\items\mastercard.jpg", "")
    createitemtemplate("Key Card Omni", "key6", "GFX\items\keycard.x", "GFX\items\INVkeyomni.jpg", "", 0.0004, "GFX\items\keycardomni.jpg", "")
    local0 = createitemtemplate("Document SCP-079", "paper", "GFX\items\paper.x", "GFX\items\INVpaper.jpg", "GFX\items\doc079.jpg", 0.003, "", "")
    local0\Field2 = $00
    local0 = createitemtemplate("Document SCP-895", "paper", "GFX\items\paper.x", "GFX\items\INVpaper.jpg", "GFX\items\doc895.jpg", 0.003, "", "")
    local0\Field2 = $00
    local0 = createitemtemplate("Document SCP-860", "paper", "GFX\items\paper.x", "GFX\items\INVpaper.jpg", "GFX\items\doc860.jpg", 0.003, "", "")
    local0\Field2 = $00
    local0 = createitemtemplate("SCP-093 Recovered Materials", "paper", "GFX\items\paper.x", "GFX\items\INVpaper.jpg", "GFX\items\doc093rm.jpg", 0.003, "", "")
    local0\Field2 = $00
    local0 = createitemtemplate("Document SCP-106", "paper", "GFX\items\paper.x", "GFX\items\INVpaper.jpg", "GFX\items\doc106.jpg", 0.003, "", "")
    local0\Field2 = $00
    local0 = createitemtemplate("Document SCP-682", "paper", "GFX\items\paper.x", "GFX\items\INVpaper.jpg", "GFX\items\doc682.jpg", 0.003, "", "")
    local0\Field2 = $00
    local0 = createitemtemplate("Document SCP-173", "paper", "GFX\items\paper.x", "GFX\items\INVpaper.jpg", "GFX\items\doc173.jpg", 0.003, "", "")
    local0\Field2 = $00
    local0 = createitemtemplate("Document SCP-372", "paper", "GFX\items\paper.x", "GFX\items\INVpaper.jpg", "GFX\items\doc372.jpg", 0.003, "", "")
    local0\Field2 = $00
    local0 = createitemtemplate("Nuclear Device Document", "paper", "GFX\items\paper.x", "GFX\items\INVpaper.jpg", "GFX\items\docNDP.jpg", 0.003, "", "")
    local0\Field2 = $00
    local0 = createitemtemplate("Note from Daniel", "paper", "GFX\items\paper.x", "GFX\items\INVpaper.jpg", "GFX\items\docdan.jpg", 0.003, "", "")
    local0\Field2 = $00
    local0 = createitemtemplate("Burnt Note", "paper", "GFX\items\paper.x", "GFX\items\INVbn.jpg", "GFX\items\bn.it", 0.003, "", "")
    local0\Field7 = burntnote
    local0\Field2 = $00
    local0 = createitemtemplate("Mysterious Note", "paper", "GFX\items\paper.x", "GFX\items\INVpaper.jpg", "GFX\items\sn.it", 0.003, "", "")
    local0\Field2 = $00
    local0 = createitemtemplate("Mobile Task Forces", "paper", "GFX\items\paper.x", "GFX\items\INVpaper.jpg", "GFX\items\docMTF.jpg", 0.003, "", "")
    local0\Field2 = $00
    local0 = createitemtemplate("Mobile Task Force Epsilon-11", "paper", "GFX\items\paper.x", "GFX\items\INVpaper.jpg", "GFX\items\docNTF.jpg", 0.003, "", "")
    local0\Field2 = $00
    local0 = createitemtemplate("Security Clearance Levels", "paper", "GFX\items\paper.x", "GFX\items\INVpaper.jpg", "GFX\items\docSC.jpg", 0.003, "", "")
    local0\Field2 = $00
    local0 = createitemtemplate("Object Classes", "paper", "GFX\items\paper.x", "GFX\items\INVpaper.jpg", "GFX\items\docOBJC.jpg", 0.003, "", "")
    local0\Field2 = $00
    local0 = createitemtemplate("Document", "paper", "GFX\items\paper.x", "GFX\items\INVpaper.jpg", "GFX\items\docRAND3.jpg", 0.003, "", "")
    local0\Field2 = $00
    local0 = createitemtemplate("Note", "paper", "GFX\items\paper.x", "GFX\items\INVpaper.jpg", "GFX\items\docRAND2.jpg", 0.003, "", "")
    local0\Field2 = $00
    local0 = createitemtemplate("Notification", "paper", "GFX\items\paper.x", "GFX\items\INVpaper.jpg", "GFX\items\docRAND1.jpg", 0.003, "", "")
    local0\Field2 = $00
    local0 = createitemtemplate("Incident Report SCP-106-0204", "paper", "GFX\items\paper.x", "GFX\items\INVpaper.jpg", "GFX\items\docIR106.jpg", 0.003, "", "")
    local0\Field2 = $00
    local0 = createitemtemplate("Gas Mask", "gasmask", "GFX\items\gasmask.b3d", "GFX\items\INVgasmask.jpg", "", 0.02, "", "")
    local0\Field2 = $02
    local0 = createitemtemplate("Gas Mask", "supergasmask", "GFX\items\gasmask.b3d", "GFX\items\INVgasmask.jpg", "", 0.021, "", "")
    local0\Field2 = $02
    createitemtemplate("9V Battery", "bat", "GFX\items\battery.x", "GFX\items\INVbattery.jpg", "", 0.0002, "", "")
    local0 = createitemtemplate("Origami", "misc", "GFX\items\origami.b3d", "GFX\items\INVorigami.jpg", "", 0.003, "", "")
    local0\Field2 = $00
    createitemtemplate("Electronical components", "misc", "GFX\items\electronics.x", "GFX\items\INVelectronics.jpg", "", 0.0011, "", "")
    createitemtemplate("S-NAV 300 Navigator", "nav", "GFX\items\navigator.x", "GFX\items\INVnavigator.jpg", "GFX\items\navigator.png", 0.0011, "", "")
    createitemtemplate("S-NAV Navigator", "nav", "GFX\items\navigator.x", "GFX\items\INVnavigator.jpg", "GFX\items\navigator.png", 0.0011, "", "")
    createitemtemplate("S-NAV Navigator Ultimate", "nav", "GFX\items\navigator.x", "GFX\items\INVnavigator.jpg", "GFX\items\navigator.png", 0.0011, "", "")
    createitemtemplate("S-NAV 310 Navigator", "nav", "GFX\items\navigator.x", "GFX\items\INVnavigator.jpg", "GFX\items\navigator.png", 0.0011, "", "")
    createitemtemplate("Radio Transceiver", "radio", "GFX\items\radio.x", "GFX\items\INVradio.jpg", "GFX\items\radio.png", 0.001, "", "")
    createitemtemplate("Radio Transceiver", "fineradio", "GFX\items\radio.x", "GFX\items\INVradio.jpg", "GFX\items\radio.png", 0.001, "", "")
    createitemtemplate("Radio Transceiver", "veryfineradio", "GFX\items\radio.x", "GFX\items\INVradio.jpg", "GFX\items\radio.png", 0.001, "", "")
    createitemtemplate("Radio Transceiver", "18vradio", "GFX\items\radio.x", "GFX\items\INVradio.jpg", "GFX\items\radio.png", 0.0012, "", "")
    local0 = createitemtemplate("Cigarette", "cigarette", "GFX\items\420.x", "GFX\items\INV420.jpg", "", 0.0004, "", "")
    local0\Field2 = $02
    local0 = createitemtemplate("Joint", "420s", "GFX\items\420.x", "GFX\items\INV420.jpg", "", 0.0004, "", "")
    local0\Field2 = $02
    local0 = createitemtemplate("Smelly Joint", "420s", "GFX\items\420.x", "GFX\items\INV420.jpg", "", 0.0004, "", "")
    local0\Field2 = $02
    createitemtemplate("18V Battery", "18vbat", "GFX\items\battery.x", "GFX\items\INVbattery.jpg", "", 0.0003, "", "")
    createitemtemplate("Strange Battery", "killbat", "GFX\items\battery.x", "GFX\items\INVbattery.jpg", "", 0.0003, "", "")
    createitemtemplate("Eyedrops", "fineeyedrops", "GFX\items\eyedrops.b3d", "GFX\items\INVeyedrops.jpg", "", 0.0012, "", "")
    createitemtemplate("Eyedrops", "supereyedrops", "GFX\items\eyedrops.b3d", "GFX\items\INVeyedrops.jpg", "", 0.0012, "", "")
    local0 = createitemtemplate("ReVision Eyedrops", "eyedrops", "GFX\items\eyedrops.b3d", "GFX\items\INVeyedrops.jpg", "", 0.0012, "", "")
    createitemtemplate("RedVision Eyedrops", "eyedrops", "GFX\items\eyedrops.b3d", "GFX\items\INVeyedropsred.jpg", "", 0.0012, "GFX\items\eyedropsred.jpg", "")
    Return $00
End Function
