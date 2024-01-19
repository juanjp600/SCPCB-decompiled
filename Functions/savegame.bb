Function savegame%(arg0$)
    Local local0%
    Local local1%
    Local local2%
    Local local3%
    Local local4%
    Local local5.rooms
    Local local6.doors
    Local local7.npcs
    Local local8.decals
    Local local9.events
    Local local10.items
    Local local11%
    gamesaved = $01
    createdir(arg0)
    local3 = writefile((arg0 + "save.txt"))
    writeint(local3, playtime)
    writefloat(local3, entityx(collider, $00))
    writefloat(local3, entityy(collider, $00))
    writefloat(local3, entityz(collider, $00))
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
    writefloat(local3, timer513)
    writeint(local3, mapwidth)
    writeint(local3, mapheight)
    For local0 = $00 To (mapwidth - $01) Step $01
        For local1 = $00 To (mapheight - $01) Step $01
            writeint(local3, maptemp(local0, local1))
            writebyte(local3, mapfound(local0, local1))
        Next
    Next
    writeint(local3, $278)
    local4 = $00
    For local5 = Each rooms
        local4 = (local4 + $01)
    Next
    writeint(local3, local4)
    For local5 = Each rooms
        writeint(local3, local5\Field5\Field1)
        writeint(local3, local5\Field4)
        writefloat(local3, local5\Field1)
        writefloat(local3, local5\Field2)
        writefloat(local3, local5\Field3)
        If (playerroom = local5) Then
            writebyte(local3, $01)
        Else
            writebyte(local3, $00)
        EndIf
    Next
    writeint(local3, $3BA)
    local4 = $00
    For local6 = Each doors
        local4 = (local4 + $01)
    Next
    writeint(local3, local4)
    For local6 = Each doors
        writefloat(local3, entityx(local6\Field2, $00))
        writefloat(local3, entityz(local6\Field2, $00))
        writebyte(local3, local6\Field5)
        writefloat(local3, local6\Field7)
        writebyte(local3, local6\Field4)
        writebyte(local3, local6\Field13)
        writefloat(local3, entityx(local6\Field0, $01))
        writefloat(local3, entityz(local6\Field0, $01))
        If (local6\Field1 <> $00) Then
            writefloat(local3, entityx(local6\Field1, $01))
            writefloat(local3, entityz(local6\Field1, $01))
        Else
            writefloat(local3, 0.0)
            writefloat(local3, 0.0)
        EndIf
        writebyte(local3, local6\Field9)
        writefloat(local3, local6\Field10)
    Next
    writeint(local3, $71)
    local4 = $00
    For local7 = Each npcs
        local4 = (local4 + $01)
    Next
    writeint(local3, local4)
    For local7 = Each npcs
        writebyte(local3, local7\Field3)
        writefloat(local3, entityx(local7\Field2, $00))
        writefloat(local3, entityy(local7\Field2, $00))
        writefloat(local3, entityz(local7\Field2, $00))
        writefloat(local3, entitypitch(local7\Field2, $00))
        writefloat(local3, entityyaw(local7\Field2, $00))
        writefloat(local3, entityroll(local7\Field2, $00))
        writefloat(local3, local7\Field6)
        writeint(local3, local7\Field7)
        writebyte(local3, local7\Field12)
        writefloat(local3, local7\Field15)
        writeint(local3, local7\Field14)
        writefloat(local3, local7\Field19)
        writefloat(local3, local7\Field20)
        writefloat(local3, local7\Field21)
        writefloat(local3, animtime(local7\Field0))
    Next
    writeint(local3, $735)
    debuglog("1845")
    local4 = $00
    For local8 = Each decals
        local4 = (local4 + $01)
    Next
    writeint(local3, local4)
    For local8 = Each decals
        writeint(local3, local8\Field5)
        writefloat(local3, local8\Field7)
        writefloat(local3, local8\Field8)
        writefloat(local3, local8\Field9)
        writefloat(local3, local8\Field10)
        writefloat(local3, local8\Field11)
        writefloat(local3, local8\Field12)
        debuglog("eeeeeeeeee")
        writefloat(local3, local8\Field2)
        writefloat(local3, local8\Field4)
        writefloat(local3, local8\Field3)
        writefloat(local3, local8\Field6)
    Next
    local4 = $00
    For local9 = Each events
        local4 = (local4 + $01)
    Next
    writeint(local3, local4)
    For local9 = Each events
        writestring(local3, local9\Field0)
        writefloat(local3, local9\Field2)
        writefloat(local3, entityx(local9\Field1\Field0, $00))
        writefloat(local3, entityz(local9\Field1\Field0, $00))
    Next
    local4 = $00
    For local10 = Each items
        local4 = (local4 + $01)
    Next
    writeint(local3, local4)
    For local10 = Each items
        writestring(local3, local10\Field11)
        writestring(local3, local10\Field10)
        writestring(local3, local10\Field3)
        writestring(local3, local10\Field5)
        writestring(local3, local10\Field4)
        writefloat(local3, local10\Field7)
        writefloat(local3, entityx(local10\Field0, $01))
        writefloat(local3, entityy(local10\Field0, $01))
        writefloat(local3, entityz(local10\Field0, $01))
        writefloat(local3, entitypitch(local10\Field0, $00))
        writefloat(local3, entityyaw(local10\Field0, $00))
        writefloat(local3, local10\Field8)
        writebyte(local3, local10\Field9)
        writebyte(local3, local10\Field12)
        If (selecteditem = local10) Then
            writebyte(local3, $01)
        Else
            writebyte(local3, $00)
        EndIf
        local11 = $00
        For local2 = $00 To $04 Step $01
            If (inventory(local2) = local10) Then
                local11 = $01
                Exit
            EndIf
        Next
        If (local11 <> 0) Then
            writebyte(local3, local2)
        Else
            writebyte(local3, $42)
        EndIf
    Next
    writeint(local3, $3E2)
    debuglog("994")
    closefile(local3)
    Return $00
End Function
