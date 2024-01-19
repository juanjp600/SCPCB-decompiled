Function savegame%(arg0$)
    Local local0%
    Local local1%
    Local local2%
    Local local3%
    Local local4%
    Local local5%
    Local local6.rooms
    Local local7.doors
    Local local8.npcs
    Local local9.decals
    Local local10.events
    Local local11.items
    Local local12%
    Local local13.itemtemplates
    gamesaved = $01
    createdir(arg0)
    local4 = writefile((arg0 + "save.txt"))
    writeint(local4, playtime)
    writefloat(local4, entityx(collider, $00))
    writefloat(local4, entityy(collider, $00))
    writefloat(local4, entityz(collider, $00))
    writebyte(local4, playerlevel)
    writestring(local4, accesscode)
    writefloat(local4, entitypitch(collider, $00))
    writefloat(local4, entityyaw(collider, $00))
    writestring(local4, versionnumber)
    writefloat(local4, blinktimer)
    writefloat(local4, stamina)
    writefloat(local4, eyesuper)
    writefloat(local4, eyestuck)
    writefloat(local4, eyeirritation)
    writebyte(local4, selectedmode)
    writefloat(local4, sanity)
    writebyte(local4, wearinggasmask)
    writebyte(local4, superman)
    writefloat(local4, supermantimer)
    writebyte(local4, lightson)
    writestring(local4, randomseed)
    writefloat(local4, secondarylighton)
    writebyte(local4, remotedooron)
    writebyte(local4, soundtransmission)
    writebyte(local4, contained106)
    writebyte(local4, achv420)
    writebyte(local4, achv106)
    writebyte(local4, achv372)
    writebyte(local4, achv895)
    writebyte(local4, achv079)
    writebyte(local4, achv914)
    writebyte(local4, achv789)
    writebyte(local4, achvtesla)
    writebyte(local4, achvmaynard)
    writebyte(local4, achvharp)
    writebyte(local4, achvpd)
    writebyte(local4, achvsnav)
    writebyte(local4, achvomni)
    writebyte(local4, achvconsole)
    writeint(local4, refineditems)
    writeint(local4, mapwidth)
    writeint(local4, mapheight)
    For local5 = $00 To $00 Step $01
        For local0 = $00 To (mapwidth - $01) Step $01
            For local1 = $00 To (mapheight - $01) Step $01
                writeint(local4, maptemp(local5, local0, local1))
                writebyte(local4, mapfound(local5, local0, local1))
            Next
        Next
    Next
    writeint(local4, $278)
    local3 = $00
    For local6 = Each rooms
        local3 = (local3 + $01)
    Next
    writeint(local4, local3)
    For local6 = Each rooms
        writeint(local4, local6\Field7\Field1)
        writeint(local4, local6\Field6)
        writefloat(local4, local6\Field3)
        writefloat(local4, local6\Field4)
        writefloat(local4, local6\Field5)
        writebyte(local4, local6\Field1)
        writeint(local4, local6\Field0)
        If (playerroom = local6) Then
            writebyte(local4, $01)
        Else
            writebyte(local4, $00)
        EndIf
    Next
    writeint(local4, $3BA)
    local3 = $00
    For local7 = Each doors
        local3 = (local3 + $01)
    Next
    writeint(local4, local3)
    For local7 = Each doors
        writefloat(local4, entityx(local7\Field2, $00))
        writefloat(local4, entityz(local7\Field2, $00))
        writebyte(local4, local7\Field5)
        writefloat(local4, local7\Field7)
        writebyte(local4, local7\Field4)
        writebyte(local4, local7\Field19)
        writefloat(local4, entityx(local7\Field0, $01))
        writefloat(local4, entityz(local7\Field0, $01))
        If (local7\Field1 <> $00) Then
            writefloat(local4, entityx(local7\Field1, $01))
            writefloat(local4, entityz(local7\Field1, $01))
        Else
            writefloat(local4, 0.0)
            writefloat(local4, 0.0)
        EndIf
        writebyte(local4, local7\Field9)
        writefloat(local4, local7\Field10)
    Next
    writeint(local4, $71)
    local3 = $00
    For local8 = Each npcs
        local3 = (local3 + $01)
    Next
    writeint(local4, local3)
    For local8 = Each npcs
        writebyte(local4, local8\Field5)
        writefloat(local4, entityx(local8\Field4, $00))
        writefloat(local4, entityy(local8\Field4, $00))
        writefloat(local4, entityz(local8\Field4, $00))
        writefloat(local4, entitypitch(local8\Field4, $00))
        writefloat(local4, entityyaw(local8\Field4, $00))
        writefloat(local4, entityroll(local8\Field4, $00))
        writefloat(local4, local8\Field9)
        writefloat(local4, local8\Field10)
        writefloat(local4, local8\Field11)
        writeint(local4, local8\Field12)
        writebyte(local4, local8\Field19)
        writefloat(local4, local8\Field22)
        writeint(local4, local8\Field21)
        writeint(local4, (Int local8\Field18))
        writefloat(local4, local8\Field13)
        writefloat(local4, local8\Field20)
        writeint(local4, local8\Field6)
        If (local8\Field26 <> Null) Then
            writeint(local4, local8\Field26\Field6)
        Else
            writeint(local4, $00)
        EndIf
        writefloat(local4, local8\Field28)
        writefloat(local4, local8\Field29)
        writefloat(local4, local8\Field30)
        writefloat(local4, animtime(local8\Field0))
    Next
    writefloat(local4, mtftimer)
    For local2 = $00 To $06 Step $01
        If (mtfrooms[$00] <> Null) Then
            writestring(local4, mtfrooms[$00]\Field7\Field4)
        Else
            writestring(local4, "a")
        EndIf
        writeint(local4, mtfroomstate[local2])
    Next
    writeint(local4, $735)
    debuglog("1845")
    local3 = $00
    For local9 = Each decals
        local3 = (local3 + $01)
    Next
    writeint(local4, local3)
    For local9 = Each decals
        writeint(local4, local9\Field7)
        writefloat(local4, local9\Field10)
        writefloat(local4, local9\Field11)
        writefloat(local4, local9\Field12)
        writefloat(local4, local9\Field13)
        writefloat(local4, local9\Field14)
        writefloat(local4, local9\Field15)
        writebyte(local4, local9\Field5)
        writeint(local4, local9\Field6)
        debuglog("eeeeeeeeee")
        writefloat(local4, local9\Field2)
        writefloat(local4, local9\Field4)
        writefloat(local4, local9\Field3)
        writefloat(local4, local9\Field8)
        writefloat(local4, local9\Field9)
    Next
    local3 = $00
    For local10 = Each events
        local3 = (local3 + $01)
    Next
    writeint(local4, local3)
    For local10 = Each events
        writestring(local4, local10\Field0)
        writefloat(local4, local10\Field2)
        writefloat(local4, local10\Field3)
        writefloat(local4, local10\Field4)
        writefloat(local4, entityx(local10\Field1\Field2, $00))
        writefloat(local4, entityz(local10\Field1\Field2, $00))
    Next
    local3 = $00
    For local11 = Each items
        local3 = (local3 + $01)
    Next
    writeint(local4, local3)
    For local11 = Each items
        writestring(local4, local11\Field1\Field0)
        writestring(local4, local11\Field1\Field1)
        writefloat(local4, entityx(local11\Field0, $01))
        writefloat(local4, entityy(local11\Field0, $01))
        writefloat(local4, entityz(local11\Field0, $01))
        writefloat(local4, entitypitch(local11\Field0, $00))
        writefloat(local4, entityyaw(local11\Field0, $00))
        writefloat(local4, local11\Field5)
        writebyte(local4, local11\Field7)
        If (selecteditem = local11) Then
            writebyte(local4, $01)
        Else
            writebyte(local4, $00)
        EndIf
        local12 = $00
        For local2 = $00 To $09 Step $01
            If (inventory(local2) = local11) Then
                local12 = $01
                Exit
            EndIf
        Next
        If (local12 <> 0) Then
            writebyte(local4, local2)
        Else
            writebyte(local4, $42)
        EndIf
    Next
    For local13 = Each itemtemplates
        writebyte(local4, local13\Field3)
    Next
    writeint(local4, $3E2)
    debuglog("994")
    closefile(local4)
    Return $00
End Function
