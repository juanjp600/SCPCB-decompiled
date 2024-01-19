Function nullgame%()
    Local local0%
    Local local1%
    Local local2%
    Local local3%
    Local local4.itemtemplates
    Local local5.screens
    Local local6.lighttemplates
    Local local7.doors
    Local local8.materials
    Local local9.waypoints
    Local local10.tempwaypoints
    Local local11.rooms
    Local local12.items
    Local local13.decals
    Local local14.npcs
    Local local15.events
    Local local16.securitycams
    Local local17.emitters
    Local local18.particles
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
    For local4 = Each itemtemplates
        local4\Field3 = $00
    Next
    dropspeed = 0.0
    selectedending = ""
    endingtimer = 0.0
    explosiontimer = 0.0
    camerashake = 0.0
    shake = 0.0
    lightflash = 0.0
    godmode = $00
    noclip = $00
    wearinggasmask = $00
    contained106 = $00
    mtftimer = 0.0
    For local0 = $00 To $09 Step $01
        mtfrooms[local0] = Null
        mtfroomstate[local0] = $00
    Next
    For local5 = Each screens
        If (local5\Field2 <> $00) Then
            freeimage(local5\Field2)
            local5\Field2 = $00
        EndIf
        Delete local5
    Next
    achv420 = $00
    achv106 = $00
    achv372 = $00
    achv895 = $00
    achv079 = $00
    achv914 = $00
    achv789 = $00
    achvtesla = $00
    achvmaynard = $00
    achvharp = $00
    achvpd = $00
    achvsnav = $00
    achvomni = $00
    achvconsole = $01
    refineditems = $00
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
    For local7 = Each doors
        Delete local7
    Next
    clearworld($01, $01, $01)
    For local6 = Each lighttemplates
        Delete local6
    Next
    For local8 = Each materials
        Delete local8
    Next
    For local9 = Each waypoints
        Delete local9
    Next
    For local10 = Each tempwaypoints
        Delete local10
    Next
    For local11 = Each rooms
        Delete local11
    Next
    For local4 = Each itemtemplates
        Delete local4
    Next
    For local12 = Each items
        Delete local12
    Next
    For local13 = Each decals
        Delete local13
    Next
    For local14 = Each npcs
        Delete local14
    Next
    curr173 = Null
    curr106 = Null
    For local15 = Each events
        Delete local15
    Next
    For local16 = Each securitycams
        Delete local16
    Next
    For local17 = Each emitters
        Delete local17
    Next
    For local18 = Each particles
        Delete local18
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
