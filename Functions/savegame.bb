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
    local3 = writefile((arg0 + "save.txt"))
    writeint(local3, playtime)
    writefloat(local3, entityx(collider, $00))
    writefloat(local3, entityy(collider, $00))
    writefloat(local3, entityz(collider, $00))
    writebyte(local3, playerlevel)
    writestring(local3, accesscode)
    writefloat(local3, entitypitch(collider, $00))
    writefloat(local3, entityyaw(collider, $00))
    writestring(local3, versionnumber)
    writefloat(local3, blinktimer)
    writefloat(local3, stamina)
    writefloat(local3, eyesuper)
    writefloat(local3, eyestuck)
    writefloat(local3, eyeirritation)
    writebyte(local3, selectedmode)
    writefloat(local3, sanity)
    writebyte(local3, wearinggasmask)
    writebyte(local3, superman)
    writefloat(local3, supermantimer)
    writebyte(local3, lightson)
    writefloat(local3, secondarylighton)
    writebyte(local3, remotedooron)
    writebyte(local3, soundtransmission)
    writebyte(local3, contained106)
    writebyte(local3, achv420)
    writebyte(local3, achv106)
    writebyte(local3, achv372)
    writebyte(local3, achv895)
    writebyte(local3, achv079)
    writebyte(local3, achv914)
    writebyte(local3, achv789)
    writebyte(local3, achvtesla)
    writebyte(local3, achvmaynard)
    writebyte(local3, achvharp)
    writebyte(local3, achvpd)
    writebyte(local3, achvsnav)
    writebyte(local3, achvomni)
    writebyte(local3, achvconsole)
    writeint(local3, refineditems)
    writeint(local3, mapwidth)
    writeint(local3, mapheight)
    For local4 = $00 To $00 Step $01
        For local0 = $00 To (mapwidth - $01) Step $01
            For local1 = $00 To (mapheight - $01) Step $01
                writeint(local3, maptemp(local4, local0, local1))
                writebyte(local3, mapfound(local4, local0, local1))
            Next
        Next
    Next
    writeint(local3, $278)
    local5 = $00
    For local6 = Each rooms
        local5 = (local5 + $01)
    Next
    writeint(local3, local5)
    For local6 = Each rooms
        writeint(local3, local6\Field7\Field1)
        writeint(local3, local6\Field6)
        writefloat(local3, local6\Field3)
        writefloat(local3, local6\Field4)
        writefloat(local3, local6\Field5)
        writebyte(local3, local6\Field1)
        writeint(local3, local6\Field0)
        If (playerroom = local6) Then
            writebyte(local3, $01)
        Else
            writebyte(local3, $00)
        EndIf
    Next
    writeint(local3, $3BA)
    local5 = $00
    For local7 = Each doors
        local5 = (local5 + $01)
    Next
    writeint(local3, local5)
    For local7 = Each doors
        writefloat(local3, entityx(local7\Field2, $00))
        writefloat(local3, entityz(local7\Field2, $00))
        writebyte(local3, local7\Field5)
        writefloat(local3, local7\Field7)
        writebyte(local3, local7\Field4)
        writebyte(local3, local7\Field18)
        writefloat(local3, entityx(local7\Field0, $01))
        writefloat(local3, entityz(local7\Field0, $01))
        If (local7\Field1 <> $00) Then
            writefloat(local3, entityx(local7\Field1, $01))
            writefloat(local3, entityz(local7\Field1, $01))
        Else
            writefloat(local3, 0.0)
            writefloat(local3, 0.0)
        EndIf
        writebyte(local3, local7\Field9)
        writefloat(local3, local7\Field10)
    Next
    writeint(local3, $71)
    local5 = $00
    For local8 = Each npcs
        local5 = (local5 + $01)
    Next
    writeint(local3, local5)
    For local8 = Each npcs
        writebyte(local3, local8\Field5)
        writefloat(local3, entityx(local8\Field4, $00))
        writefloat(local3, entityy(local8\Field4, $00))
        writefloat(local3, entityz(local8\Field4, $00))
        writefloat(local3, entitypitch(local8\Field4, $00))
        writefloat(local3, entityyaw(local8\Field4, $00))
        writefloat(local3, entityroll(local8\Field4, $00))
        writefloat(local3, local8\Field9)
        writefloat(local3, local8\Field10)
        writefloat(local3, local8\Field11)
        writeint(local3, local8\Field12)
        writebyte(local3, local8\Field19)
        writefloat(local3, local8\Field22)
        writeint(local3, local8\Field21)
        writeint(local3, (Int local8\Field18))
        writefloat(local3, local8\Field13)
        writefloat(local3, local8\Field20)
        writeint(local3, local8\Field6)
        If (local8\Field26 <> Null) Then
            writeint(local3, local8\Field26\Field6)
        Else
            writeint(local3, $00)
        EndIf
        writebyte(local3, local8\Field32)
        If (local8\Field32 = $01) Then
            For local2 = $00 To $13 Step $01
                If (local8\Field31[local2] <> Null) Then
                    writefloat(local3, entityx(local8\Field31[local2]\Field0, $00))
                    writefloat(local3, entityy(local8\Field31[local2]\Field0, $00))
                    writefloat(local3, entityz(local8\Field31[local2]\Field0, $00))
                Else
                    writefloat(local3, 0.0)
                    writefloat(local3, 0.0)
                    writefloat(local3, 0.0)
                EndIf
            Next
            writeint(local3, local8\Field34)
        EndIf
        writefloat(local3, local8\Field33)
        writefloat(local3, local8\Field28)
        writefloat(local3, local8\Field29)
        writefloat(local3, local8\Field30)
        writefloat(local3, animtime(local8\Field0))
    Next
    writeint(local3, $735)
    debuglog("1845")
    local5 = $00
    For local9 = Each decals
        local5 = (local5 + $01)
    Next
    writeint(local3, local5)
    For local9 = Each decals
        writeint(local3, local9\Field6)
        writefloat(local3, local9\Field9)
        writefloat(local3, local9\Field10)
        writefloat(local3, local9\Field11)
        writefloat(local3, local9\Field12)
        writefloat(local3, local9\Field13)
        writefloat(local3, local9\Field14)
        debuglog("eeeeeeeeee")
        writefloat(local3, local9\Field2)
        writefloat(local3, local9\Field4)
        writefloat(local3, local9\Field3)
        writefloat(local3, local9\Field7)
        writefloat(local3, local9\Field8)
    Next
    local5 = $00
    For local10 = Each events
        local5 = (local5 + $01)
    Next
    writeint(local3, local5)
    For local10 = Each events
        writestring(local3, local10\Field0)
        writefloat(local3, local10\Field2)
        writefloat(local3, local10\Field3)
        writefloat(local3, local10\Field4)
        writefloat(local3, entityx(local10\Field1\Field2, $00))
        writefloat(local3, entityz(local10\Field1\Field2, $00))
    Next
    local5 = $00
    For local11 = Each items
        local5 = (local5 + $01)
    Next
    writeint(local3, local5)
    For local11 = Each items
        writestring(local3, local11\Field1\Field0)
        writestring(local3, local11\Field1\Field1)
        writefloat(local3, entityx(local11\Field0, $01))
        writefloat(local3, entityy(local11\Field0, $01))
        writefloat(local3, entityz(local11\Field0, $01))
        writefloat(local3, entitypitch(local11\Field0, $00))
        writefloat(local3, entityyaw(local11\Field0, $00))
        writefloat(local3, local11\Field5)
        writebyte(local3, local11\Field7)
        If (selecteditem = local11) Then
            writebyte(local3, $01)
        Else
            writebyte(local3, $00)
        EndIf
        local12 = $00
        For local2 = $00 To $09 Step $01
            If (inventory(local2) = local11) Then
                local12 = $01
                Exit
            EndIf
        Next
        If (local12 <> 0) Then
            writebyte(local3, local2)
        Else
            writebyte(local3, $42)
        EndIf
    Next
    For local13 = Each itemtemplates
        writebyte(local3, local13\Field3)
    Next
    writeint(local3, $3E2)
    debuglog("994")
    closefile(local3)
    Return $00
End Function
