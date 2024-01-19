Function fillroom%(arg0.rooms)
    Local local0.doors
    Local local1.doors
    Local local2.securitycams
    Local local3.items
    Local local4%
    Local local5%
    Local local6%
    Local local7%
    Local local8%
    Local local9%
    Local local10%
    Local local12.emitters
    Local local13%
    Local local14%
    Local local15%
    Local local16.decals
    Local local17%
    Local local18%
    Local local19%
    Local local20%
    Local local21$
    Local local22.materials
    Local local23%
    Local local25%
    Local local26#
    Local local28.lighttemplates
    Local local29%
    Select arg0\Field6\Field4
        Case "lockroom"
            local0 = createdoor(arg0\Field0, (arg0\Field2 - (736.0 * roomscale)), 0.0, (arg0\Field4 - (104.0 * roomscale)), 0.0, $01, arg0\Field1, $00, $00, "")
            local0\Field9 = $15E
            local0\Field16 = $00
            local0\Field5 = $00
            entityparent(local0\Field3[$00], $00, $01)
            positionentity(local0\Field3[$00], (arg0\Field2 - (288.0 * roomscale)), 0.7, (arg0\Field4 - (640.0 * roomscale)), $00)
            entityparent(local0\Field3[$00], arg0\Field1, $01)
            freeentity(local0\Field3[$01])
            local0\Field3[$01] = $00
            local1 = createdoor(arg0\Field0, ((104.0 * roomscale) + arg0\Field2), 0.0, ((736.0 * roomscale) + arg0\Field4), 270.0, $01, arg0\Field1, $00, $00, "")
            local1\Field9 = $15E
            local1\Field16 = $00
            local1\Field5 = $00
            entityparent(local1\Field3[$00], $00, $01)
            positionentity(local1\Field3[$00], ((640.0 * roomscale) + arg0\Field2), 0.7, ((288.0 * roomscale) + arg0\Field4), $00)
            rotateentity(local1\Field3[$00], 0.0, 90.0, 0.0, $00)
            entityparent(local1\Field3[$00], arg0\Field1, $01)
            freeentity(local1\Field3[$01])
            local1\Field3[$01] = $00
            local0\Field17 = local1
            local1\Field17 = local0
            local2 = createsecuritycam((arg0\Field2 - (688.0 * roomscale)), ((384.0 * roomscale) + arg0\Field3), ((688.0 * roomscale) + arg0\Field4), arg0, $01)
            local2\Field11 = 225.0
            local2\Field12 = 45.0
            turnentity(local2\Field3, 40.0, 0.0, 0.0, $00)
            entityparent(local2\Field0, arg0\Field1, $01)
            positionentity(local2\Field4, ((668.0 * roomscale) + arg0\Field2), 1.1, (arg0\Field4 - (96.0 * roomscale)), $00)
            turnentity(local2\Field4, 0.0, 90.0, 0.0, $00)
            entityparent(local2\Field4, arg0\Field1, $01)
            local2 = createsecuritycam((arg0\Field2 - (112.0 * roomscale)), ((384.0 * roomscale) + arg0\Field3), ((112.0 * roomscale) + arg0\Field4), arg0, $01)
            local2\Field11 = 45.0
            local2\Field12 = 45.0
            turnentity(local2\Field3, 40.0, 0.0, 0.0, $00)
            entityparent(local2\Field0, arg0\Field1, $01)
            positionentity(local2\Field4, ((96.0 * roomscale) + arg0\Field2), 1.1, (arg0\Field4 - (668.0 * roomscale)), $00)
            entityparent(local2\Field4, arg0\Field1, $01)
            local12 = createemitter((arg0\Field2 - (175.0 * roomscale)), (344.0 * roomscale), ((656.0 * roomscale) + arg0\Field4), $00)
            turnentity(local12\Field0, 90.0, 0.0, 0.0, $01)
            entityparent(local12\Field0, arg0\Field1, $01)
            local12\Field10 = 3.0
            local12\Field9 = 0.035
            local12\Field11 = (1.0 / 400.0)
            local12 = createemitter((arg0\Field2 - (655.0 * roomscale)), (344.0 * roomscale), ((240.0 * roomscale) + arg0\Field4), $00)
            turnentity(local12\Field0, 90.0, 0.0, 0.0, $01)
            entityparent(local12\Field0, arg0\Field1, $01)
            local12\Field10 = 3.0
            local12\Field9 = 0.035
            local12\Field11 = (1.0 / 400.0)
        Case "exit1"
            local1 = createdoor(arg0\Field0, arg0\Field2, 0.0, ((1024.0 * roomscale) + arg0\Field4), 0.0, $00, arg0\Field1, $00, $00, "")
            local1\Field15 = $01
            local1\Field16 = $00
            local1\Field5 = $00
        Case "exit2"
            local1 = createdoor(arg0\Field0, arg0\Field2, 0.0, ((1024.0 * roomscale) + arg0\Field4), 0.0, $00, arg0\Field1, $00, $00, "")
            local1\Field15 = $00
            local1\Field16 = $00
            local1\Field5 = $00
        Case "roompj"
            local3 = createitem("Document SCP-372", "paper", ((800.0 * roomscale) + arg0\Field2), ((256.0 * roomscale) + arg0\Field3), ((80.0 * roomscale) + arg0\Field4))
            entityparent(local3\Field0, arg0\Field1, $01)
        Case "room079"
            local0 = createdoor(arg0\Field0, arg0\Field2, (-448.0 * roomscale), ((1136.0 * roomscale) + arg0\Field4), 0.0, $00, arg0\Field1, $01, $03, "")
            local0\Field8 = $01
            local0\Field16 = $00
            local0\Field5 = $00
            positionentity(local0\Field3[$01], ((224.0 * roomscale) + arg0\Field2), (-250.0 * roomscale), ((918.0 * roomscale) + arg0\Field4), $01)
            positionentity(local0\Field3[$00], (arg0\Field2 - (240.0 * roomscale)), (-250.0 * roomscale), ((1366.0 * roomscale) + arg0\Field4), $01)
            arg0\Field11[$00] = createdoor(arg0\Field0, ((384.0 * roomscale) + arg0\Field2), (-448.0 * roomscale), ((3088.0 * roomscale) + arg0\Field4), 0.0, $00, arg0\Field1, $01, $03, "")
            arg0\Field11[$00]\Field8 = $01
            arg0\Field11[$00]\Field16 = $00
            arg0\Field11[$00]\Field5 = $00
            positionentity(arg0\Field11[$00]\Field3[$01], ((736.0 * roomscale) + arg0\Field2), (-250.0 * roomscale), ((2870.0 * roomscale) + arg0\Field4), $01)
            positionentity(arg0\Field11[$00]\Field3[$00], ((128.0 * roomscale) + arg0\Field2), (-250.0 * roomscale), ((3286.0 * roomscale) + arg0\Field4), $01)
            arg0\Field10[$00] = loadanimmesh("GFX\map\079.b3d", $00)
            scaleentity(arg0\Field10[$00], 1.3, 1.3, 1.3, $01)
            positionentity(arg0\Field10[$00], (arg0\Field2 - (560.0 * roomscale)), (-560.0 * roomscale), ((4736.0 * roomscale) + arg0\Field4), $01)
            entityparent(arg0\Field10[$00], arg0\Field1, $01)
            arg0\Field10[$01] = createsprite(arg0\Field10[$00])
            spriteviewmode(arg0\Field10[$01], $02)
            positionentity(arg0\Field10[$01], 0.082, 0.119, 0.01, $00)
            scalesprite(arg0\Field10[$01], 0.09, 0.0725)
            turnentity(arg0\Field10[$01], 0.0, 13.0, 0.0, $00)
            moveentity(arg0\Field10[$01], 0.0, 0.0, -0.022)
            entitytexture(arg0\Field10[$01], oldaipics($00), $00, $00)
            hideentity(arg0\Field10[$01])
        Case "room2pit"
            local4 = $00
            For local5 = $FFFFFFFF To $01 Step $02
                For local7 = $FFFFFFFF To $01 Step $01
                    local12 = createemitter((((202.0 * roomscale) * (Float local5)) + arg0\Field2), (8.0 * roomscale), (((256.0 * roomscale) * (Float local7)) + arg0\Field4), $00)
                    arg0\Field10[local4] = local12\Field0
                    If (local4 < $03) Then
                        turnentity(local12\Field0, 0.0, -90.0, 0.0, $01)
                    Else
                        turnentity(local12\Field0, 0.0, 90.0, 0.0, $01)
                    EndIf
                    turnentity(local12\Field0, -45.0, 0.0, 0.0, $01)
                    entityparent(local12\Field0, arg0\Field1, $01)
                    local4 = (local4 + $01)
                Next
            Next
            arg0\Field10[$06] = createpivot($00)
            positionentity(arg0\Field10[$06], ((640.0 * roomscale) + arg0\Field2), (8.0 * roomscale), (arg0\Field4 - (896.0 * roomscale)), $00)
            entityparent(arg0\Field10[$06], arg0\Field1, $01)
            arg0\Field10[$07] = createpivot($00)
            positionentity(arg0\Field10[$07], (arg0\Field2 - (864.0 * roomscale)), (-400.0 * roomscale), (arg0\Field4 - (632.0 * roomscale)), $00)
            entityparent(arg0\Field10[$07], arg0\Field1, $01)
        Case "room2testroom2"
            arg0\Field10[$00] = createpivot($00)
            positionentity(arg0\Field10[$00], (arg0\Field2 - (640.0 * roomscale)), 0.5, (arg0\Field4 - (912.0 * roomscale)), $00)
            entityparent(arg0\Field10[$00], arg0\Field1, $01)
            arg0\Field10[$01] = createpivot($00)
            positionentity(arg0\Field10[$01], (arg0\Field2 - (632.0 * roomscale)), 0.5, (arg0\Field4 - (192.0 * roomscale)), $00)
            entityparent(arg0\Field10[$01], arg0\Field1, $01)
            local13 = loadtexture("GFX\map\glass.png", $03)
            arg0\Field10[$02] = createsprite($00)
            entitytexture(arg0\Field10[$02], local13, $00, $00)
            spriteviewmode(arg0\Field10[$02], $02)
            scalesprite(arg0\Field10[$02], ((182.0 * roomscale) * 0.5), ((192.0 * roomscale) * 0.5))
            positionentity(arg0\Field10[$02], (arg0\Field2 - (595.0 * roomscale)), (224.0 * roomscale), (arg0\Field4 - (208.0 * roomscale)), $00)
            turnentity(arg0\Field10[$02], 0.0, 180.0, 0.0, $00)
            entityparent(arg0\Field10[$02], arg0\Field1, $01)
            freetexture(local13)
            local0 = createdoor(arg0\Field0, (arg0\Field2 - (240.0 * roomscale)), 0.0, ((640.0 * roomscale) + arg0\Field4), 90.0, $00, arg0\Field1, $00, $00, "")
            local0\Field16 = $00
            local0\Field5 = $00
            local0 = createdoor(arg0\Field0, (arg0\Field2 - (512.0 * roomscale)), 0.0, ((384.0 * roomscale) + arg0\Field4), 0.0, $00, arg0\Field1, $00, $00, "")
            local0\Field16 = $00
            local0\Field5 = $00
            local0 = createdoor(arg0\Field0, (arg0\Field2 - (816.0 * roomscale)), 0.0, (arg0\Field4 - (208.0 * roomscale)), 0.0, $00, arg0\Field1, $00, $00, "")
            local0\Field16 = $00
            local0\Field5 = $00
            freeentity(local0\Field3[$00])
            freeentity(local0\Field3[$01])
        Case "room2toilets"
            arg0\Field10[$00] = createpivot($00)
            positionentity(arg0\Field10[$00], ((1040.0 * roomscale) + arg0\Field2), (192.0 * roomscale), arg0\Field4, $00)
            entityparent(arg0\Field10[$00], arg0\Field1, $01)
        Case "room2sroom"
            local0 = createdoor(arg0\Field0, ((1440.0 * roomscale) + arg0\Field2), (224.0 * roomscale), ((32.0 * roomscale) + arg0\Field4), 90.0, $00, arg0\Field1, $00, $04, "")
            local0\Field16 = $00
            local0\Field5 = $00
            local3 = createitem("Some SCP-420-J", "420", ((1776.0 * roomscale) + arg0\Field2), ((400.0 * roomscale) + arg0\Field3), ((427.0 * roomscale) + arg0\Field4))
            entityparent(local3\Field0, arg0\Field1, $01)
            local3 = createitem("Some SCP-420-J", "420", ((1808.0 * roomscale) + arg0\Field2), ((400.0 * roomscale) + arg0\Field3), ((435.0 * roomscale) + arg0\Field4))
            entityparent(local3\Field0, arg0\Field1, $01)
            local3 = createitem("Level 5 Key Card", "key5", ((2232.0 * roomscale) + arg0\Field2), ((392.0 * roomscale) + arg0\Field3), ((387.0 * roomscale) + arg0\Field4))
            rotateentity(local3\Field0, 0.0, (Float arg0\Field5), 0.0, $01)
            entityparent(local3\Field0, arg0\Field1, $01)
            local3 = createitem("Nuclear Device Document", "paper", ((2248.0 * roomscale) + arg0\Field2), ((440.0 * roomscale) + arg0\Field3), ((372.0 * roomscale) + arg0\Field4))
            entityparent(local3\Field0, arg0\Field1, $01)
            local3 = createitem("Email Print", "paper", ((2023.0 * roomscale) + arg0\Field2), ((392.0 * roomscale) + arg0\Field3), (arg0\Field4 - (61.0 * roomscale)))
            entityparent(local3\Field0, arg0\Field1, $01)
            local3 = createitem("Radio Transceiver", "radio", ((2240.0 * roomscale) + arg0\Field2), ((320.0 * roomscale) + arg0\Field3), ((128.0 * roomscale) + arg0\Field4))
            entityparent(local3\Field0, arg0\Field1, $01)
        Case "room2poffices"
            local0 = createdoor(arg0\Field0, ((240.0 * roomscale) + arg0\Field2), 0.0, ((448.0 * roomscale) + arg0\Field4), 90.0, $00, arg0\Field1, $00, $00, accesscode)
            local0\Field16 = $00
            local0\Field5 = $00
            local0 = createdoor(arg0\Field0, (arg0\Field2 - (496.0 * roomscale)), 0.0, arg0\Field4, 90.0, $00, arg0\Field1, $00, $00, "ABCD")
            local0\Field16 = $00
            local0\Field5 = $00
            local0\Field4 = $01
            local0 = createdoor(arg0\Field0, ((240.0 * roomscale) + arg0\Field2), 0.0, (arg0\Field4 - (576.0 * roomscale)), 90.0, $00, arg0\Field1, $00, $00, "7816")
            local0\Field16 = $00
            local0\Field5 = $00
            local3 = createitem("Secret Note", "paper", ((736.0 * roomscale) + arg0\Field2), ((224.0 * roomscale) + arg0\Field3), ((544.0 * roomscale) + arg0\Field4))
            entityparent(local3\Field0, arg0\Field1, $01)
            local3 = createitem("Incident Report SCP-106-0204", "paper", ((704.0 * roomscale) + arg0\Field2), ((183.0 * roomscale) + arg0\Field3), (arg0\Field4 - (576.0 * roomscale)))
            entityparent(local3\Field0, arg0\Field1, $01)
        Case "room2tunnel"
            arg0\Field10[$00] = createpivot($00)
            positionentity(arg0\Field10[$00], ((2640.0 * roomscale) + arg0\Field2), (-2496.0 * roomscale), ((400.0 * roomscale) + arg0\Field4), $00)
            entityparent(arg0\Field10[$00], arg0\Field1, $01)
            arg0\Field10[$01] = createpivot($00)
            positionentity(arg0\Field10[$01], (arg0\Field2 - (4336.0 * roomscale)), (-2496.0 * roomscale), (arg0\Field4 - (2512.0 * roomscale)), $00)
            entityparent(arg0\Field10[$01], arg0\Field1, $01)
            arg0\Field10[$02] = createpivot($00)
            positionentity(arg0\Field10[$02], ((552.0 * roomscale) + arg0\Field2), (240.0 * roomscale), ((656.0 * roomscale) + arg0\Field4), $00)
            entityparent(arg0\Field10[$02], arg0\Field1, $01)
            arg0\Field10[$03] = createpivot($00)
            positionentity(arg0\Field10[$03], (arg0\Field2 - (2040.0 * roomscale)), (-2256.0 * roomscale), (arg0\Field4 - (656.0 * roomscale)), $00)
            entityparent(arg0\Field10[$03], arg0\Field1, $01)
            arg0\Field10[$04] = createpivot($00)
            positionentity(arg0\Field10[$04], (arg0\Field2 - (552.0 * roomscale)), (240.0 * roomscale), (arg0\Field4 - (656.0 * roomscale)), $00)
            entityparent(arg0\Field10[$04], arg0\Field1, $01)
            arg0\Field10[$05] = createpivot($00)
            positionentity(arg0\Field10[$05], ((2072.0 * roomscale) + arg0\Field2), (-2256.0 * roomscale), ((656.0 * roomscale) + arg0\Field4), $00)
            entityparent(arg0\Field10[$05], arg0\Field1, $01)
            arg0\Field11[$00] = createdoor(arg0\Field0, ((264.0 * roomscale) + arg0\Field2), 0.0, ((656.0 * roomscale) + arg0\Field4), 90.0, $01, arg0\Field1, $00, $00, "")
            arg0\Field11[$00]\Field16 = $00
            arg0\Field11[$00]\Field5 = $01
            positionentity(arg0\Field11[$00]\Field3[$01], ((224.0 * roomscale) + arg0\Field2), 0.7, ((480.0 * roomscale) + arg0\Field4), $01)
            positionentity(arg0\Field11[$00]\Field3[$00], ((304.0 * roomscale) + arg0\Field2), 0.7, ((832.0 * roomscale) + arg0\Field4), $01)
            arg0\Field11[$01] = createdoor(arg0\Field0, (arg0\Field2 - (2328.0 * roomscale)), (-2496.0 * roomscale), (arg0\Field4 - (656.0 * roomscale)), 90.0, $00, arg0\Field1, $00, $00, "")
            arg0\Field11[$01]\Field16 = $00
            arg0\Field11[$01]\Field5 = $00
            positionentity(arg0\Field11[$01]\Field3[$00], (arg0\Field2 - (2288.0 * roomscale)), entityy(arg0\Field11[$01]\Field3[$00], $01), (arg0\Field4 - (480.0 * roomscale)), $01)
            positionentity(arg0\Field11[$01]\Field3[$01], (arg0\Field2 - (2368.0 * roomscale)), entityy(arg0\Field11[$01]\Field3[$01], $01), (arg0\Field4 - (800.0 * roomscale)), $01)
            arg0\Field11[$02] = createdoor(arg0\Field0, (arg0\Field2 - (264.0 * roomscale)), 0.0, (arg0\Field4 - (656.0 * roomscale)), 90.0, $01, arg0\Field1, $00, $00, "")
            arg0\Field11[$02]\Field16 = $00
            arg0\Field11[$02]\Field5 = $01
            positionentity(arg0\Field11[$02]\Field3[$00], (arg0\Field2 - (224.0 * roomscale)), 0.7, (arg0\Field4 - (480.0 * roomscale)), $01)
            positionentity(arg0\Field11[$02]\Field3[$01], (arg0\Field2 - (304.0 * roomscale)), 0.7, (arg0\Field4 - (832.0 * roomscale)), $01)
            arg0\Field11[$03] = createdoor(arg0\Field0, ((2360.0 * roomscale) + arg0\Field2), (-2496.0 * roomscale), ((656.0 * roomscale) + arg0\Field4), 90.0, $00, arg0\Field1, $00, $00, "")
            arg0\Field11[$03]\Field16 = $00
            arg0\Field11[$03]\Field5 = $00
            positionentity(arg0\Field11[$03]\Field3[$01], ((2320.0 * roomscale) + arg0\Field2), entityy(arg0\Field11[$03]\Field3[$00], $01), ((480.0 * roomscale) + arg0\Field4), $01)
            positionentity(arg0\Field11[$03]\Field3[$00], ((2432.0 * roomscale) + arg0\Field2), entityy(arg0\Field11[$03]\Field3[$01], $01), ((816.0 * roomscale) + arg0\Field4), $01)
        Case "tunnel"
            local2 = createsecuritycam(arg0\Field2, ((448.0 * roomscale) + arg0\Field3), arg0\Field4, arg0, $00)
            local2\Field19 = $01
        Case "tunnel2"
            arg0\Field10[$00] = createpivot($00)
            positionentity(arg0\Field10[$00], arg0\Field2, (544.0 * roomscale), ((512.0 * roomscale) + arg0\Field4), $00)
            entityparent(arg0\Field10[$00], arg0\Field1, $01)
            arg0\Field10[$01] = createpivot($00)
            positionentity(arg0\Field10[$01], arg0\Field2, (544.0 * roomscale), (arg0\Field4 - (512.0 * roomscale)), $00)
            entityparent(arg0\Field10[$01], arg0\Field1, $01)
        Case "room2pipes"
            arg0\Field10[$00] = createpivot($00)
            positionentity(arg0\Field10[$00], ((368.0 * roomscale) + arg0\Field2), 0.0, arg0\Field4, $00)
            entityparent(arg0\Field10[$00], arg0\Field1, $01)
            arg0\Field10[$01] = createpivot($00)
            positionentity(arg0\Field10[$01], (arg0\Field2 - (368.0 * roomscale)), 0.0, arg0\Field4, $00)
            entityparent(arg0\Field10[$01], arg0\Field1, $01)
            arg0\Field10[$02] = createpivot($00)
            positionentity(arg0\Field10[$02], (((224.0 * roomscale) + arg0\Field2) - 0.005), (192.0 * roomscale), arg0\Field4, $00)
            entityparent(arg0\Field10[$02], arg0\Field1, $01)
            arg0\Field10[$03] = createpivot($00)
            positionentity(arg0\Field10[$03], ((arg0\Field2 - (224.0 * roomscale)) + 0.005), (192.0 * roomscale), arg0\Field4, $00)
            entityparent(arg0\Field10[$03], arg0\Field1, $01)
        Case "room3pit"
            local12 = createemitter(((512.0 * roomscale) + arg0\Field2), (-76.0 * roomscale), (arg0\Field4 - (688.0 * roomscale)), $00)
            turnentity(local12\Field0, -90.0, 0.0, 0.0, $00)
            entityparent(local12\Field0, arg0\Field1, $01)
            local12\Field10 = 35.0
            local12 = createemitter((arg0\Field2 - (512.0 * roomscale)), (-76.0 * roomscale), (arg0\Field4 - (688.0 * roomscale)), $00)
            turnentity(local12\Field0, -90.0, 0.0, 0.0, $00)
            entityparent(local12\Field0, arg0\Field1, $01)
            local12\Field10 = 35.0
        Case "testroom"
            For local5 = $00 To $01 Step $01
                For local7 = $FFFFFFFF To $01 Step $01
                    arg0\Field10[((local5 * $03) + (local7 + $01))] = createpivot($00)
                    positionentity(arg0\Field10[((local5 * $03) + (local7 + $01))], ((((280.0 * (Float local5)) + -236.0) * roomscale) + arg0\Field2), (-700.0 * roomscale), (((384.0 * (Float local7)) * roomscale) + arg0\Field4), $00)
                    entityparent(arg0\Field10[((local5 * $03) + (local7 + $01))], arg0\Field1, $01)
                Next
            Next
            arg0\Field10[$06] = createpivot($00)
            positionentity(arg0\Field10[$06], ((754.0 * roomscale) + arg0\Field2), (arg0\Field3 - (1248.0 * roomscale)), arg0\Field4, $00)
            entityparent(arg0\Field10[$06], arg0\Field1, $01)
            local2 = createsecuritycam(((744.0 * roomscale) + arg0\Field2), (arg0\Field3 - (856.0 * roomscale)), ((236.0 * roomscale) + arg0\Field4), arg0, $00)
            local2\Field19 = $01
            local0 = createdoor(arg0\Field0, (arg0\Field2 - (624.0 * roomscale)), (-1280.0 * roomscale), arg0\Field4, 90.0, $01, arg0\Field1, $00, $00, "")
            local3 = createitem("Document SCP-682", "paper", ((656.0 * roomscale) + arg0\Field2), (arg0\Field3 - (1200.0 * roomscale)), (arg0\Field4 - (16.0 * roomscale)))
            entityparent(local3\Field0, arg0\Field1, $01)
        Case "room2closets"
            local3 = createitem("Document SCP-173", "paper", ((692.0 * roomscale) + arg0\Field2), ((172.0 * roomscale) + arg0\Field3), ((463.0 * roomscale) + arg0\Field4))
            entityparent(local3\Field0, arg0\Field1, $01)
            local3 = createitem("Gas Mask", "gasmask", ((698.0 * roomscale) + arg0\Field2), ((236.0 * roomscale) + arg0\Field3), ((623.0 * roomscale) + arg0\Field4))
            scaleentity(local3\Field0, 0.02, 0.02, 0.02, $00)
            entityparent(local3\Field0, arg0\Field1, $01)
            local3 = createitem("9V Battery", "bat", ((703.0 * roomscale) + arg0\Field2), ((184.0 * roomscale) + arg0\Field3), (arg0\Field4 - (501.0 * roomscale)))
            entityparent(local3\Field0, arg0\Field1, $01)
            If (rand($02, $01) = $01) Then
                local3 = createitem("9V Battery", "bat", ((695.0 * roomscale) + arg0\Field2), ((184.0 * roomscale) + arg0\Field3), (arg0\Field4 - (525.0 * roomscale)))
                entityparent(local3\Field0, arg0\Field1, $01)
            EndIf
            If (rand($02, $01) = $01) Then
                local3 = createitem("9V Battery", "bat", ((708.0 * roomscale) + arg0\Field2), ((184.0 * roomscale) + arg0\Field3), (arg0\Field4 - (565.0 * roomscale)))
                entityparent(local3\Field0, arg0\Field1, $01)
            EndIf
        Case "room2offices"
            local3 = createitem("Document SCP-106", "paper", ((404.0 * roomscale) + arg0\Field2), ((145.0 * roomscale) + arg0\Field3), ((559.0 * roomscale) + arg0\Field4))
            entityparent(local3\Field0, arg0\Field1, $01)
            local3 = createitem("Level 2 Key Card", "key2", (arg0\Field2 - (156.0 * roomscale)), ((151.0 * roomscale) + arg0\Field3), ((72.0 * roomscale) + arg0\Field4))
            entityparent(local3\Field0, arg0\Field1, $01)
            local3 = createitem("S-NAV 300 Navigator", "nav", ((372.0 * roomscale) + arg0\Field2), ((153.0 * roomscale) + arg0\Field3), ((944.0 * roomscale) + arg0\Field4))
            local3\Field5 = 20.0
            entityparent(local3\Field0, arg0\Field1, $01)
            local3 = createitem("Notification", "paper", (arg0\Field2 - (137.0 * roomscale)), ((153.0 * roomscale) + arg0\Field3), ((464.0 * roomscale) + arg0\Field4))
            entityparent(local3\Field0, arg0\Field1, $01)
        Case "room2offices2"
            local3 = createitem("Level 1 Key Card", "key1", (arg0\Field2 - (368.0 * roomscale)), (arg0\Field3 - (48.0 * roomscale)), ((80.0 * roomscale) + arg0\Field4))
            local14 = loadtexture("GFX\items\keycard1.jpg", $01)
            entitytexture(local3\Field0, local14, $00, $00)
            entityparent(local3\Field0, arg0\Field1, $01)
            local3 = createitem("Document SCP-895", "paper", (arg0\Field2 - (800.0 * roomscale)), (arg0\Field3 - (48.0 * roomscale)), ((368.0 * roomscale) + arg0\Field4))
            entityparent(local3\Field0, arg0\Field1, $01)
            If (rand($02, $01) = $01) Then
                local3 = createitem("Document SCP-860", "paper", (arg0\Field2 - (800.0 * roomscale)), (arg0\Field3 - (48.0 * roomscale)), (arg0\Field4 - (464.0 * roomscale)))
            Else
                local3 = createitem("SCP-093 Recovered Materials", "paper", (arg0\Field2 - (800.0 * roomscale)), (arg0\Field3 - (48.0 * roomscale)), (arg0\Field4 - (464.0 * roomscale)))
            EndIf
            entityparent(local3\Field0, arg0\Field1, $01)
            local3 = createitem("S-NAV 300 Navigator", "nav", (arg0\Field2 - (336.0 * roomscale)), (arg0\Field3 - (48.0 * roomscale)), (arg0\Field4 - (480.0 * roomscale)))
            local3\Field5 = 28.0
            entityparent(local3\Field0, arg0\Field1, $01)
        Case "room2offices3"
            If (rand($02, $01) = $01) Then
                local3 = createitem("Mobile Task Forces", "paper", ((744.0 * roomscale) + arg0\Field2), ((240.0 * roomscale) + arg0\Field3), ((944.0 * roomscale) + arg0\Field4))
                entityparent(local3\Field0, arg0\Field1, $01)
            Else
                local3 = createitem("Security Clearance Levels", "paper", ((680.0 * roomscale) + arg0\Field2), ((240.0 * roomscale) + arg0\Field3), ((944.0 * roomscale) + arg0\Field4))
                entityparent(local3\Field0, arg0\Field1, $01)
            EndIf
            local3 = createitem("Object Classes", "paper", ((160.0 * roomscale) + arg0\Field2), ((240.0 * roomscale) + arg0\Field3), ((568.0 * roomscale) + arg0\Field4))
            entityparent(local3\Field0, arg0\Field1, $01)
            local3 = createitem("Document", "paper", (arg0\Field2 - (1440.0 * roomscale)), ((624.0 * roomscale) + arg0\Field3), ((152.0 * roomscale) + arg0\Field4))
            entityparent(local3\Field0, arg0\Field1, $01)
            local3 = createitem("Radio Transceiver", "radio", (arg0\Field2 - (1184.0 * roomscale)), ((480.0 * roomscale) + arg0\Field3), (arg0\Field4 - (800.0 * roomscale)))
            entityparent(local3\Field0, arg0\Field1, $01)
            For local4 = $00 To rand($00, $01) Step $01
                local3 = createitem("ReVision Eyedrops", "eyedrops", (arg0\Field2 - (1529.0 * roomscale)), ((563.0 * roomscale) + arg0\Field3), ((arg0\Field4 - (572.0 * roomscale)) + ((Float local4) * 0.05)))
                entityparent(local3\Field0, arg0\Field1, $01)
            Next
            local3 = createitem("9V Battery", "bat", (arg0\Field2 - (1545.0 * roomscale)), ((603.0 * roomscale) + arg0\Field3), (arg0\Field4 - (372.0 * roomscale)))
            entityparent(local3\Field0, arg0\Field1, $01)
            If (rand($02, $01) = $01) Then
                local3 = createitem("9V Battery", "bat", (arg0\Field2 - (1540.0 * roomscale)), ((603.0 * roomscale) + arg0\Field3), (arg0\Field4 - (340.0 * roomscale)))
                entityparent(local3\Field0, arg0\Field1, $01)
            EndIf
            If (rand($02, $01) = $01) Then
                local3 = createitem("9V Battery", "bat", (arg0\Field2 - (1529.0 * roomscale)), ((603.0 * roomscale) + arg0\Field3), (arg0\Field4 - (308.0 * roomscale)))
                entityparent(local3\Field0, arg0\Field1, $01)
            EndIf
        Case "start"
            arg0\Field11[$01] = createdoor(arg0\Field0, ((288.0 * roomscale) + arg0\Field2), 0.0, ((384.0 * roomscale) + arg0\Field4), 90.0, $01, $00, $01, $00, "")
            arg0\Field11[$01]\Field4 = $00
            arg0\Field11[$01]\Field16 = $00
            arg0\Field11[$01]\Field8 = $01
            arg0\Field11[$01]\Field5 = $01
            freeentity(arg0\Field11[$01]\Field3[$00])
            arg0\Field11[$01]\Field3[$00] = $00
            freeentity(arg0\Field11[$01]\Field3[$01])
            arg0\Field11[$01]\Field3[$01] = $00
        Case "coffin"
            local0 = createdoor(arg0\Field0, arg0\Field2, 0.0, (arg0\Field4 - (448.0 * roomscale)), 0.0, $00, arg0\Field1, $01, $02, "")
            local0\Field8 = $01
            local0\Field16 = $00
            local0\Field5 = $00
            positionentity(local0\Field3[$00], (arg0\Field2 - (384.0 * roomscale)), 0.7, (arg0\Field4 - (280.0 * roomscale)), $01)
            local2 = createsecuritycam((arg0\Field2 - (320.0 * roomscale)), ((704.0 * roomscale) + arg0\Field3), ((288.0 * roomscale) + arg0\Field4), arg0, $01)
            local2\Field11 = 225.0
            local2\Field12 = 45.0
            local2\Field20 = $01
            turnentity(local2\Field3, 120.0, 0.0, 0.0, $00)
            entityparent(local2\Field0, arg0\Field1, $01)
            positionentity(local2\Field4, (arg0\Field2 - (800.0 * roomscale)), (288.0 * roomscale), (arg0\Field4 - (350.0 * roomscale)), $00)
            entityparent(local2\Field4, arg0\Field1, $01)
            turnentity(local2\Field4, 0.0, 180.0, 0.0, $00)
            arg0\Field10[$00] = createpivot($00)
            positionentity(arg0\Field10[$00], arg0\Field2, (-1320.0 * roomscale), ((2304.0 * roomscale) + arg0\Field4), $00)
            entityparent(arg0\Field10[$00], arg0\Field1, $01)
            local3 = createitem("Document SCP-895", "paper", (arg0\Field2 - (688.0 * roomscale)), ((133.0 * roomscale) + arg0\Field3), (arg0\Field4 - (304.0 * roomscale)))
            entityparent(local3\Field0, arg0\Field1, $01)
        Case "room2tesla"
            arg0\Field10[$00] = createpivot($00)
            positionentity(arg0\Field10[$00], (arg0\Field2 - (114.0 * roomscale)), 0.0, arg0\Field4, $00)
            entityparent(arg0\Field10[$00], arg0\Field1, $01)
            arg0\Field10[$01] = createpivot($00)
            positionentity(arg0\Field10[$01], ((114.0 * roomscale) + arg0\Field2), 0.0, arg0\Field4, $00)
            entityparent(arg0\Field10[$01], arg0\Field1, $01)
            arg0\Field10[$02] = createpivot($00)
            positionentity(arg0\Field10[$02], arg0\Field2, 0.0, arg0\Field4, $00)
            entityparent(arg0\Field10[$02], arg0\Field1, $01)
            arg0\Field10[$03] = createsprite($00)
            entitytexture(arg0\Field10[$03], teslatexture, $00, $00)
            spriteviewmode(arg0\Field10[$03], $02)
            entityblend(arg0\Field10[$03], local15)
            entityfx(arg0\Field10[$03], $19)
            positionentity(arg0\Field10[$03], arg0\Field2, 0.8, arg0\Field4, $00)
            hideentity(arg0\Field10[$03])
            entityparent(arg0\Field10[$03], arg0\Field1, $01)
        Case "room2doors"
            local0 = createdoor(arg0\Field0, arg0\Field2, 0.0, ((528.0 * roomscale) + arg0\Field4), 0.0, $01, arg0\Field1, $00, $00, "")
            local0\Field16 = $00
            positionentity(local0\Field3[$00], (arg0\Field2 - (832.0 * roomscale)), 0.7, ((160.0 * roomscale) + arg0\Field4), $01)
            positionentity(local0\Field3[$01], (arg0\Field2 - (224.0 * roomscale)), 0.7, ((896.0 * roomscale) + arg0\Field4), $01)
            rotateentity(local0\Field3[$01], 0.0, 90.0, 0.0, $01)
            local1 = createdoor(arg0\Field0, arg0\Field2, 0.0, (arg0\Field4 - (528.0 * roomscale)), 180.0, $01, arg0\Field1, $00, $00, "")
            local1\Field16 = $00
            freeentity(local1\Field3[$00])
            positionentity(local1\Field3[$01], (arg0\Field2 - (224.0 * roomscale)), 0.7, (arg0\Field4 - (896.0 * roomscale)), $01)
            rotateentity(local1\Field3[$01], 0.0, 90.0, 0.0, $01)
            arg0\Field10[$00] = createpivot($00)
            positionentity(arg0\Field10[$00], (arg0\Field2 - (832.0 * roomscale)), 0.5, arg0\Field4, $00)
            entityparent(arg0\Field10[$00], arg0\Field1, $01)
            local1\Field17 = local0
            local0\Field17 = local1
            local0\Field5 = $00
            local1\Field5 = $01
        Case "914"
            local0 = createdoor(arg0\Field0, arg0\Field2, 0.0, (arg0\Field4 - (368.0 * roomscale)), 0.0, $00, arg0\Field1, $01, $02, "")
            local0\Field8 = $01
            local0\Field16 = $00
            local0\Field5 = $00
            positionentity(local0\Field3[$00], (arg0\Field2 - (496.0 * roomscale)), 0.7, (arg0\Field4 - (272.0 * roomscale)), $01)
            turnentity(local0\Field3[$00], 0.0, 90.0, 0.0, $00)
            arg0\Field10[$00] = loadmesh("GFX\map\914key.x", $00)
            arg0\Field10[$01] = loadmesh("GFX\map\914knob.x", $00)
            For local4 = $00 To $01 Step $01
                scaleentity(arg0\Field10[local4], roomscale, roomscale, roomscale, $00)
                entitypickmode(arg0\Field10[local4], $02, $01)
            Next
            positionentity(arg0\Field10[$00], arg0\Field2, ((190.0 * roomscale) + arg0\Field3), ((374.0 * roomscale) + arg0\Field4), $00)
            positionentity(arg0\Field10[$01], arg0\Field2, ((230.0 * roomscale) + arg0\Field3), ((374.0 * roomscale) + arg0\Field4), $00)
            entityparent(arg0\Field10[$00], arg0\Field1, $01)
            entityparent(arg0\Field10[$01], arg0\Field1, $01)
            local0 = createdoor(arg0\Field0, (arg0\Field2 - (624.0 * roomscale)), 0.0, ((528.0 * roomscale) + arg0\Field4), 180.0, $01, arg0\Field1, $00, $00, "")
            freeentity(local0\Field1)
            local0\Field1 = $00
            freeentity(local0\Field3[$00])
            local0\Field3[$00] = $00
            freeentity(local0\Field3[$01])
            local0\Field3[$01] = $00
            arg0\Field11[$00] = local0
            local0\Field16 = $00
            local0 = createdoor(arg0\Field0, ((816.0 * roomscale) + arg0\Field2), 0.0, ((528.0 * roomscale) + arg0\Field4), 180.0, $01, arg0\Field1, $00, $00, "")
            freeentity(local0\Field1)
            local0\Field1 = $00
            freeentity(local0\Field3[$00])
            local0\Field3[$00] = $00
            freeentity(local0\Field3[$01])
            local0\Field3[$01] = $00
            arg0\Field11[$01] = local0
            local0\Field16 = $00
            arg0\Field10[$02] = createpivot($00)
            arg0\Field10[$03] = createpivot($00)
            positionentity(arg0\Field10[$02], (arg0\Field2 - (712.0 * roomscale)), 0.5, ((640.0 * roomscale) + arg0\Field4), $00)
            positionentity(arg0\Field10[$03], ((728.0 * roomscale) + arg0\Field2), 0.5, ((640.0 * roomscale) + arg0\Field4), $00)
            entityparent(arg0\Field10[$02], arg0\Field1, $01)
            entityparent(arg0\Field10[$03], arg0\Field1, $01)
            local3 = createitem("Note", "paper", ((954.0 * roomscale) + arg0\Field2), ((228.0 * roomscale) + arg0\Field3), ((127.0 * roomscale) + arg0\Field4))
            entityparent(local3\Field0, arg0\Field1, $01)
        Case "room173"
            arg0\Field10[$00] = createpivot($00)
            positionentity(arg0\Field10[$00], (entityx(arg0\Field1, $00) + (40.0 * roomscale)), (430.0 * roomscale), (entityz(arg0\Field1, $00) + (1052.0 * roomscale)), $00)
            arg0\Field10[$01] = createpivot($00)
            positionentity(arg0\Field10[$01], (entityx(arg0\Field1, $00) - (80.0 * roomscale)), (100.0 * roomscale), (entityz(arg0\Field1, $00) + (526.0 * roomscale)), $00)
            arg0\Field10[$02] = createpivot($00)
            positionentity(arg0\Field10[$02], (entityx(arg0\Field1, $00) - (128.0 * roomscale)), (100.0 * roomscale), (entityz(arg0\Field1, $00) + (320.0 * roomscale)), $00)
            arg0\Field10[$03] = createpivot($00)
            positionentity(arg0\Field10[$03], (entityx(arg0\Field1, $00) + (660.0 * roomscale)), (100.0 * roomscale), (entityz(arg0\Field1, $00) + (526.0 * roomscale)), $00)
            arg0\Field10[$04] = createpivot($00)
            positionentity(arg0\Field10[$04], (entityx(arg0\Field1, $00) + (700.0 * roomscale)), (100.0 * roomscale), (entityz(arg0\Field1, $00) + (320.0 * roomscale)), $00)
            arg0\Field10[$05] = createpivot($00)
            positionentity(arg0\Field10[$05], (entityx(arg0\Field1, $00) + (1472.0 * roomscale)), (100.0 * roomscale), (entityz(arg0\Field1, $00) + (912.0 * roomscale)), $00)
            For local4 = $00 To $05 Step $01
                entityparent(arg0\Field10[local4], arg0\Field1, $01)
            Next
            arg0\Field11[$00] = createdoor(arg0\Field0, entityx(arg0\Field1, $00), 0.0, (entityz(arg0\Field1, $00) - 4.0), 0.0, $00, $00, $00, $00, "")
            arg0\Field11[$00]\Field4 = $01
            arg0\Field11[$00]\Field16 = $00
            arg0\Field11[$00]\Field5 = $00
            arg0\Field11[$01] = createdoor(arg0\Field0, (entityx(arg0\Field1, $00) + (288.0 * roomscale)), 0.0, (entityz(arg0\Field1, $00) + (384.0 * roomscale)), 90.0, $01, $00, $01, $00, "")
            arg0\Field11[$01]\Field16 = $00
            arg0\Field11[$01]\Field8 = $01
            arg0\Field11[$01]\Field5 = $01
            freeentity(arg0\Field11[$01]\Field3[$00])
            arg0\Field11[$01]\Field3[$00] = $00
            freeentity(arg0\Field11[$01]\Field3[$01])
            arg0\Field11[$01]\Field3[$01] = $00
            local16 = createdecal(rand($04, $05), entityx(arg0\Field10[$05], $01), 0.002, entityz(arg0\Field10[$05], $01), 90.0, rnd(360.0, 0.0), 0.0)
            local16\Field2 = 1.2
            scalesprite(local16\Field0, local16\Field2, local16\Field2)
            For local5 = $00 To $01 Step $01
                For local7 = $00 To $01 Step $01
                    local16 = createdecal(rand($04, $06), ((((700.0 * roomscale) + arg0\Field2) + (((Float local5) * 700.0) * roomscale)) + rnd(-0.5, 0.5)), rnd(0.001, 0.0018), ((((Float ($258 * local7)) * roomscale) + arg0\Field4) + rnd(-0.5, 0.5)), 90.0, rnd(360.0, 0.0), 0.0)
                    local16\Field2 = rnd(0.5, 0.8)
                    local16\Field4 = rnd(0.8, 1.0)
                    scalesprite(local16\Field0, local16\Field2, local16\Field2)
                Next
            Next
            addlight(arg0, (arg0\Field2 - (224.0 * roomscale)), ((640.0 * roomscale) + arg0\Field3), ((128.0 * roomscale) + arg0\Field4), $02, 2.0, $C8, $C8, $C8)
            addlight(arg0, (arg0\Field2 - (1056.0 * roomscale)), ((608.0 * roomscale) + arg0\Field3), ((416.0 * roomscale) + arg0\Field4), $02, 2.0, $C8, $C8, $C8)
        Case "room2ccont"
            local0 = createdoor(arg0\Field0, ((64.0 * roomscale) + arg0\Field2), 0.0, ((368.0 * roomscale) + arg0\Field4), 180.0, $00, arg0\Field1, $00, $01, "")
            local0\Field16 = $00
            local0\Field5 = $00
            For local17 = $00 To $02 Step $01
                arg0\Field10[(local17 Shl $01)] = loadmesh("GFX\map\leverbase.x", $00)
                arg0\Field10[((local17 Shl $01) + $01)] = loadmesh("GFX\map\leverhandle.x", $00)
                For local4 = $00 To $01 Step $01
                    scaleentity(arg0\Field10[((local17 Shl $01) + local4)], 0.04, 0.04, 0.04, $00)
                    positionentity(arg0\Field10[((local17 Shl $01) + local4)], (arg0\Field2 - (240.0 * roomscale)), ((1104.0 * roomscale) + arg0\Field3), (((632.0 - (64.0 * (Float local17))) * roomscale) + arg0\Field4), $01)
                    entityparent(arg0\Field10[((local17 Shl $01) + local4)], arg0\Field1, $01)
                Next
                rotateentity(arg0\Field10[(local17 Shl $01)], 0.0, -90.0, 0.0, $00)
                rotateentity(arg0\Field10[((local17 Shl $01) + $01)], 10.0, -270.0, 0.0, $00)
                entitypickmode(arg0\Field10[((local17 Shl $01) + $01)], $01, $00)
                entityradius(arg0\Field10[((local17 Shl $01) + $01)], 0.1, 0.0)
            Next
        Case "room106"
            local0 = createdoor(arg0\Field0, (arg0\Field2 - (968.0 * roomscale)), (-764.0 * roomscale), ((1392.0 * roomscale) + arg0\Field4), 0.0, $00, arg0\Field1, $00, $03, "")
            local0\Field16 = $00
            local0\Field5 = $00
            local0 = createdoor(arg0\Field0, arg0\Field2, 0.0, (arg0\Field4 - (464.0 * roomscale)), 0.0, $00, arg0\Field1, $00, $03, "")
            local0\Field16 = $00
            local0\Field5 = $00
            local0 = createdoor(arg0\Field0, (arg0\Field2 - (624.0 * roomscale)), (-1280.0 * roomscale), arg0\Field4, 90.0, $00, arg0\Field1, $00, $04, "")
            local0\Field16 = $00
            local0\Field5 = $00
            arg0\Field10[$06] = loadmesh("GFX\map\room1062.b3d", $00)
            scaleentity(arg0\Field10[$06], roomscale, roomscale, roomscale, $00)
            entitytype(arg0\Field10[$06], $01, $00)
            entitypickmode(arg0\Field10[$06], $03, $01)
            positionentity(arg0\Field10[$06], ((784.0 * roomscale) + arg0\Field2), (-980.0 * roomscale), ((720.0 * roomscale) + arg0\Field4), $01)
            If (bumpenabled <> 0) Then
                For local4 = $01 To countsurfaces(arg0\Field10[$06]) Step $01
                    local18 = getsurface(arg0\Field10[$06], local4)
                    local19 = getsurfacebrush(local18)
                    local20 = getbrushtexture(local19, $01)
                    local21 = strippath(texturename(local20))
                    For local22 = Each materials
                        If (local21 = local22\Field0) Then
                            local8 = getbrushtexture(local19, $00)
                            local9 = getbrushtexture(local19, $01)
                            brushtexture(local19, local8, $00, $00)
                            brushtexture(local19, local22\Field2, $00, $01)
                            brushtexture(local19, local9, $00, $02)
                            paintsurface(local18, local19)
                            Exit
                        EndIf
                    Next
                Next
            EndIf
            entityparent(arg0\Field10[$06], arg0\Field1, $01)
            For local17 = $00 To $02 Step $02
                arg0\Field10[local17] = loadmesh("GFX\map\leverbase.x", $00)
                arg0\Field10[(local17 + $01)] = loadmesh("GFX\map\leverhandle.x", $00)
                For local4 = $00 To $01 Step $01
                    scaleentity(arg0\Field10[(local17 + local4)], 0.04, 0.04, 0.04, $00)
                    positionentity(arg0\Field10[(local17 + local4)], (arg0\Field2 - ((555.0 - (81.0 * (Float (local17 Sar $01)))) * roomscale)), (arg0\Field3 - (576.0 * roomscale)), ((3040.0 * roomscale) + arg0\Field4), $01)
                    entityparent(arg0\Field10[(local17 + local4)], arg0\Field1, $01)
                Next
                rotateentity(arg0\Field10[local17], 0.0, 0.0, 0.0, $00)
                rotateentity(arg0\Field10[(local17 + $01)], 10.0, -180.0, 0.0, $00)
                entitypickmode(arg0\Field10[(local17 + $01)], $01, $00)
                entityradius(arg0\Field10[(local17 + $01)], 0.1, 0.0)
            Next
            rotateentity(arg0\Field10[$01], 81.0, -180.0, 0.0, $00)
            rotateentity(arg0\Field10[$03], -81.0, -180.0, 0.0, $00)
            arg0\Field10[$04] = createbutton((arg0\Field2 - (146.0 * roomscale)), (arg0\Field3 - (576.0 * roomscale)), ((3045.0 * roomscale) + arg0\Field4), 0.0, 0.0, 0.0)
            entityparent(arg0\Field10[$04], arg0\Field1, $01)
            local2 = createsecuritycam(((768.0 * roomscale) + arg0\Field2), ((1392.0 * roomscale) + arg0\Field3), ((1696.0 * roomscale) + arg0\Field4), arg0, $01)
            local2\Field11 = 315.0
            local2\Field12 = 20.0
            turnentity(local2\Field3, 45.0, 0.0, 0.0, $00)
            entityparent(local2\Field0, arg0\Field1, $01)
            arg0\Field10[$07] = local2\Field3
            positionentity(local2\Field4, (arg0\Field2 - (272.0 * roomscale)), (-544.0 * roomscale), ((3020.0 * roomscale) + arg0\Field4), $00)
            turnentity(local2\Field4, 0.0, -10.0, 0.0, $00)
            entityparent(local2\Field4, arg0\Field1, $01)
            arg0\Field12[$00] = createnpc($04, ((1088.0 * roomscale) + arg0\Field2), (1096.0 * roomscale), ((1728.0 * roomscale) + arg0\Field4))
            arg0\Field10[$05] = createpivot($00)
            turnentity(arg0\Field10[$05], 0.0, 180.0, 0.0, $00)
            positionentity(arg0\Field10[$05], ((1088.0 * roomscale) + arg0\Field2), (1096.0 * roomscale), ((1728.0 * roomscale) + arg0\Field4), $00)
            entityparent(arg0\Field10[$05], arg0\Field1, $01)
        Case "pocketdimension"
            local23 = loadmesh("GFX\map\pocketdimension2.b3d", $00)
            arg0\Field10[$08] = loadmesh("GFX\map\pocketdimension3.b3d", $00)
            arg0\Field10[$09] = loadmesh("GFX\map\pocketdimension4.b3d", $00)
            arg0\Field10[$0A] = copymesh(arg0\Field10[$09], $00)
            arg0\Field10[$0B] = loadmesh("GFX\map\pocketdimension5.b3d", $00)
            createitem("Burnt Note", "paper", entityx(arg0\Field1, $00), 0.5, (entityz(arg0\Field1, $00) + 3.5))
            For local17 = $00 To $04 Step $01
                Select local17
                    Case $00
                        local25 = local23
                    Case $01
                        local25 = arg0\Field10[$08]
                    Case $02
                        local25 = arg0\Field10[$09]
                    Case $03
                        local25 = arg0\Field10[$0A]
                    Case $04
                        local25 = arg0\Field10[$0B]
                End Select
                If (bumpenabled <> 0) Then
                    For local4 = $01 To countsurfaces(local25) Step $01
                        local18 = getsurface(local25, local4)
                        local19 = getsurfacebrush(local18)
                        local20 = getbrushtexture(local19, $01)
                        local21 = strippath(texturename(local20))
                        For local22 = Each materials
                            If (local21 = local22\Field0) Then
                                local8 = getbrushtexture(local19, $00)
                                local9 = getbrushtexture(local19, $01)
                                brushtexture(local19, local8, $00, $00)
                                brushtexture(local19, local22\Field2, $00, $01)
                                brushtexture(local19, local9, $00, $02)
                                paintsurface(local18, local19)
                                Exit
                            EndIf
                        Next
                    Next
                EndIf
            Next
            For local4 = $08 To $0B Step $01
                scaleentity(arg0\Field10[local4], roomscale, roomscale, roomscale, $00)
                entitytype(arg0\Field10[local4], $01, $00)
                entitypickmode(arg0\Field10[local4], $03, $01)
                positionentity(arg0\Field10[local4], arg0\Field2, arg0\Field3, (arg0\Field4 + 32.0), $01)
            Next
            scaleentity(arg0\Field10[$0A], (roomscale * 1.5), (roomscale * 2.0), (roomscale * 1.5), $01)
            positionentity(arg0\Field10[$0B], arg0\Field2, arg0\Field3, (arg0\Field4 + 64.0), $01)
            For local4 = $01 To $08 Step $01
                arg0\Field10[(local4 - $01)] = copymesh(local23, $00)
                scaleentity(arg0\Field10[(local4 - $01)], roomscale, roomscale, roomscale, $00)
                local26 = ((Float (local4 - $01)) * 45.0)
                entitytype(arg0\Field10[(local4 - $01)], $01, $00)
                entitypickmode(arg0\Field10[(local4 - $01)], $03, $01)
                rotateentity(arg0\Field10[(local4 - $01)], 0.0, (local26 - 90.0), 0.0, $00)
                positionentity(arg0\Field10[(local4 - $01)], (((512.0 * roomscale) * cos(local26)) + arg0\Field2), 0.0, (((512.0 * roomscale) * sin(local26)) + arg0\Field4), $00)
                entityparent(arg0\Field10[(local4 - $01)], arg0\Field1, $01)
                If (local4 < $06) Then
                    local16 = createdecal((local4 + $07), ((((512.0 * roomscale) * cos(local26)) * 3.0) + arg0\Field2), 0.02, ((((512.0 * roomscale) * sin(local26)) * 3.0) + arg0\Field4), 90.0, (local26 - 90.0), 0.0)
                    local16\Field2 = rnd(0.5, 0.5)
                    scalesprite(local16\Field0, local16\Field2, local16\Field2)
                    entityfx(local16\Field0, $09)
                    entityblend(local16\Field0, $02)
                EndIf
            Next
            For local4 = $0C To $10 Step $01
                arg0\Field10[local4] = createpivot(arg0\Field10[$0B])
                Select local4
                    Case $0C
                        positionentity(arg0\Field10[local4], arg0\Field2, ((200.0 * roomscale) + arg0\Field3), (arg0\Field4 + 64.0), $01)
                    Case $0D
                        positionentity(arg0\Field10[local4], ((390.0 * roomscale) + arg0\Field2), ((200.0 * roomscale) + arg0\Field3), ((arg0\Field4 + 64.0) + (272.0 * roomscale)), $01)
                    Case $0E
                        positionentity(arg0\Field10[local4], ((838.0 * roomscale) + arg0\Field2), ((200.0 * roomscale) + arg0\Field3), ((arg0\Field4 + 64.0) - (551.0 * roomscale)), $01)
                    Case $0F
                        positionentity(arg0\Field10[local4], (arg0\Field2 - (139.0 * roomscale)), ((200.0 * roomscale) + arg0\Field3), ((arg0\Field4 + 64.0) + (1201.0 * roomscale)), $01)
                    Case $10
                        positionentity(arg0\Field10[local4], (arg0\Field2 - (1238.0 * roomscale)), (arg0\Field3 - (1664.0 * roomscale)), ((arg0\Field4 + 64.0) + (381.0 * roomscale)), $01)
                End Select
            Next
            freetexture(local20)
            freeentity(local23)
    End Select
    For local28 = Each lighttemplates
        If (local28\Field0 = arg0\Field6) Then
            local29 = addlight(arg0, (arg0\Field2 + local28\Field2), (arg0\Field3 + local28\Field3), (arg0\Field4 + local28\Field4), local28\Field1, local28\Field5, local28\Field6, local28\Field7, local28\Field8)
            If (local29 <> $00) Then
                debuglog(((((((((((arg0\Field6\Field4 + " - ") + (Str local28\Field2)) + ", ") + (Str local28\Field3)) + ", ") + (Str local28\Field4)) + " - ") + (Str local28\Field5)) + ", ") + (Str local28\Field6)))
                If (local28\Field1 = $03) Then
                    lightconeangles(local29, (Float local28\Field11), local28\Field12)
                    rotateentity(local29, local28\Field9, local28\Field10, 0.0, $00)
                EndIf
            Else
                debuglog((arg0\Field6\Field4 + " - light error"))
            EndIf
        EndIf
    Next
    Return $00
End Function
