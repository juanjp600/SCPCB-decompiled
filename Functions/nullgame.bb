Function nullgame%()
    Local local0%
    Local local1%
    Local local2%
    Local local3%
    Local local4.doors
    Local local5.lighttemplates
    Local local6.materials
    Local local7.waypoints
    Local local8.tempwaypoints
    Local local9.rooms
    Local local10.itemtemplates
    Local local11.items
    Local local12.decals
    Local local13.npcs
    Local local14.events
    Local local15.securitycams
    Local local16.emitters
    Local local17.particles
    doortempid = $00
    roomtempid = $00
    gamesaved = $00
    For local3 = $00 To $00 Step $01
        For local1 = $00 To (mapwidth - $01) Step $01
            For local2 = $00 To (mapheight - $01) Step $01
                maptemp(local3, local1, local2) = $00
                mapfound(local3, local1, local2) = $00
            Next
        Next
    Next
    dropspeed = 0.0
    godmode = $00
    noclip = $00
    wearinggasmask = $00
    consoleinput = ""
    consoleopen = $00
    playerlevel = $00
    eyeirritation = 0.0
    eyestuck = 0.0
    eyesuper = 0.0
    killtimer = 0.0
    stamina = 100.0
    blurtimer = 0.0
    superman = $00
    supermantimer = 0.0
    msg = ""
    msgtimer = 0.0
    selecteditem = Null
    For local0 = $00 To $09 Step $01
        inventory(local0) = Null
    Next
    selecteditem = Null
    closestbutton = $00
    For local4 = Each doors
        Delete local4
    Next
    For local5 = Each lighttemplates
        Delete local5
    Next
    For local6 = Each materials
        Delete local6
    Next
    For local7 = Each waypoints
        Delete local7
    Next
    For local8 = Each tempwaypoints
        Delete local8
    Next
    For local9 = Each rooms
        Delete local9
    Next
    For local10 = Each itemtemplates
        Delete local10
    Next
    For local11 = Each items
        Delete local11
    Next
    For local12 = Each decals
        Delete local12
    Next
    For local13 = Each npcs
        Delete local13
    Next
    curr173 = Null
    curr106 = Null
    For local14 = Each events
        Delete local14
    Next
    For local15 = Each securitycams
        Delete local15
    Next
    For local16 = Each emitters
        Delete local16
    Next
    For local17 = Each particles
        Delete local17
    Next
    debuglog("d")
    For local0 = $00 To $05 Step $01
        If (channelplaying(radiochn(local0)) <> 0) Then
            stopchannel(radiochn(local0))
        EndIf
    Next
    debuglog("ccccccc")
    clearworld($01, $01, $01)
    Return $00
End Function
