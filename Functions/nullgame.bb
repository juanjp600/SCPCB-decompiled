Function nullgame%()
    Local local0%
    Local local1%
    Local local2%
    Local local3.doors
    Local local4.lighttemplates
    Local local5.materials
    Local local6.rooms
    Local local7.items
    Local local8.decals
    Local local9.npcs
    Local local10.events
    Local local11.securitycams
    Local local12.emitters
    Local local13.particles
    doortempid = $00
    roomtempid = $00
    gamesaved = $00
    For local1 = $00 To (mapwidth - $01) Step $01
        For local2 = $00 To (mapheight - $01) Step $01
            maptemp(local1, local2) = $00
            mapfound(local1, local2) = $00
        Next
    Next
    godmode = $00
    wearinggasmask = $00
    eyeirritation = 0.0
    eyestuck = 0.0
    eyesuper = 0.0
    timer513 = 0.0
    killtimer = 0.0
    stamina = 100.0
    blurtimer = 0.0
    superman = $00
    supermantimer = 0.0
    msg = ""
    msgtimer = 0.0
    selecteditem = Null
    For local0 = $00 To $04 Step $01
        inventory(local0) = Null
    Next
    selecteditem = Null
    closestbutton = $00
    For local3 = Each doors
        Delete local3
    Next
    For local4 = Each lighttemplates
        Delete local4
    Next
    For local5 = Each materials
        Delete local5
    Next
    For local6 = Each rooms
        Delete local6
    Next
    For local7 = Each items
        Delete local7
    Next
    For local8 = Each decals
        Delete local8
    Next
    For local9 = Each npcs
        Delete local9
    Next
    curr173 = Null
    curr106 = Null
    For local10 = Each events
        Delete local10
    Next
    For local11 = Each securitycams
        Delete local11
    Next
    For local12 = Each emitters
        Delete local12
    Next
    For local13 = Each particles
        Delete local13
    Next
    debuglog("d")
    debuglog("ccccccc")
    clearworld($01, $01, $01)
    Return $00
End Function
