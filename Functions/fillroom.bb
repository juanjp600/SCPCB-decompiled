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
    Local local17%
    Local local18%
    Local local19%
    Local local20%
    Local local21%
    Local local22%
    Local local23%
    Local local24%
    Local local25%
    Local local26.decals
    Local local27$
    Local local28.materials
    Local local29%
    Local local31%
    Local local32#
    Local local34.lighttemplates
    Local local35%
    Local local36.tempscreens
    Local local37.tempwaypoints
    Select arg0\Field7\Field4
        Case "lockroom"
            local0 = createdoor(arg0\Field0, (arg0\Field3 - (736.0 * roomscale)), 0.0, (arg0\Field5 - (104.0 * roomscale)), 0.0, arg0, $01, $00, $00, "")
            local0\Field9 = $15E
            local0\Field19 = $00
            local0\Field5 = $00
            entityparent(local0\Field3[$00], $00, $01)
            positionentity(local0\Field3[$00], (arg0\Field3 - (288.0 * roomscale)), 0.7, (arg0\Field5 - (640.0 * roomscale)), $00)
            entityparent(local0\Field3[$00], arg0\Field2, $01)
            freeentity(local0\Field3[$01])
            local0\Field3[$01] = $00
            local1 = createdoor(arg0\Field0, ((104.0 * roomscale) + arg0\Field3), 0.0, ((736.0 * roomscale) + arg0\Field5), 270.0, arg0, $01, $00, $00, "")
            local1\Field9 = $15E
            local1\Field19 = $00
            local1\Field5 = $00
            entityparent(local1\Field3[$00], $00, $01)
            positionentity(local1\Field3[$00], ((640.0 * roomscale) + arg0\Field3), 0.7, ((288.0 * roomscale) + arg0\Field5), $00)
            rotateentity(local1\Field3[$00], 0.0, 90.0, 0.0, $00)
            entityparent(local1\Field3[$00], arg0\Field2, $01)
            freeentity(local1\Field3[$01])
            local1\Field3[$01] = $00
            local0\Field20 = local1
            local1\Field20 = local0
            local2 = createsecuritycam((arg0\Field3 - (688.0 * roomscale)), ((384.0 * roomscale) + arg0\Field4), ((688.0 * roomscale) + arg0\Field5), arg0, $01)
            local2\Field11 = 225.0
            local2\Field12 = 45.0
            turnentity(local2\Field3, 40.0, 0.0, 0.0, $00)
            entityparent(local2\Field0, arg0\Field2, $01)
            positionentity(local2\Field4, ((668.0 * roomscale) + arg0\Field3), 1.1, (arg0\Field5 - (96.0 * roomscale)), $00)
            turnentity(local2\Field4, 0.0, 90.0, 0.0, $00)
            entityparent(local2\Field4, arg0\Field2, $01)
            local2 = createsecuritycam((arg0\Field3 - (112.0 * roomscale)), ((384.0 * roomscale) + arg0\Field4), ((112.0 * roomscale) + arg0\Field5), arg0, $01)
            local2\Field11 = 45.0
            local2\Field12 = 45.0
            turnentity(local2\Field3, 40.0, 0.0, 0.0, $00)
            entityparent(local2\Field0, arg0\Field2, $01)
            positionentity(local2\Field4, ((96.0 * roomscale) + arg0\Field3), 1.1, (arg0\Field5 - (668.0 * roomscale)), $00)
            entityparent(local2\Field4, arg0\Field2, $01)
            local12 = createemitter((arg0\Field3 - (175.0 * roomscale)), (344.0 * roomscale), ((656.0 * roomscale) + arg0\Field5), $00)
            turnentity(local12\Field0, 90.0, 0.0, 0.0, $01)
            entityparent(local12\Field0, arg0\Field2, $01)
            local12\Field10 = 3.0
            local12\Field9 = 0.035
            local12\Field11 = (1.0 / 400.0)
            local12 = createemitter((arg0\Field3 - (655.0 * roomscale)), (344.0 * roomscale), ((240.0 * roomscale) + arg0\Field5), $00)
            turnentity(local12\Field0, 90.0, 0.0, 0.0, $01)
            entityparent(local12\Field0, arg0\Field2, $01)
            local12\Field10 = 3.0
            local12\Field9 = 0.035
            local12\Field11 = (1.0 / 400.0)
        Case "exit1"
            arg0\Field11[$00] = loadmesh("GFX\map\exit1terrain.b3d", arg0\Field2)
            positionentity(arg0\Field11[$00], ((4356.0 * roomscale) + arg0\Field3), (9767.0 * roomscale), ((2588.0 * roomscale) + arg0\Field5), $01)
            scaleentity(arg0\Field11[$00], roomscale, roomscale, roomscale, $01)
            If ((bumpenabled And $00) <> 0) Then
                local13 = loadtexture("GFX\map\gravelbump.jpg", $01)
                textureblend(local13, $1603)
                For local4 = $01 To countsurfaces(arg0\Field11[$00]) Step $01
                    local14 = getsurface(arg0\Field11[$00], local4)
                    local15 = getsurfacebrush(local14)
                    local8 = getbrushtexture(local15, $00)
                    local9 = getbrushtexture(local15, $01)
                    Select strippath(texturename(local9))
                        Case "gravel.jpg","grass2.jpg"
                            brushtexture(local15, local8, $00, $00)
                            brushtexture(local15, local13, $00, $01)
                            brushtexture(local15, local9, $00, $02)
                            paintsurface(local14, local15)
                            If (strippath(texturename(local8)) <> "") Then
                                freetexture(local8)
                            EndIf
                            If (strippath(texturename(local9)) <> "") Then
                                freetexture(local9)
                            EndIf
                            freetexture(local17)
                            freebrush(local15)
                    End Select
                Next
            EndIf
            arg0\Field12[$04] = createdoor(arg0\Field0, arg0\Field3, 0.0, (arg0\Field5 - (320.0 * roomscale)), 0.0, arg0, $00, $01, $03, "")
            arg0\Field12[$04]\Field8 = $01
            arg0\Field12[$04]\Field19 = $00
            arg0\Field12[$04]\Field5 = $00
            positionentity(arg0\Field12[$04]\Field3[$01], arg0\Field3, 8.0, arg0\Field5, $01)
            positionentity(arg0\Field12[$04]\Field3[$00], arg0\Field3, 8.0, arg0\Field5, $01)
            arg0\Field13[$00] = createnpc($07, arg0\Field3, 100.0, arg0\Field5)
            arg0\Field13[$00]\Field9 = 1.0
            local18 = createsprite(arg0\Field2)
            scalesprite(local18, 20.0, 20.0)
            positionentity(local18, ((11040.0 * roomscale) + arg0\Field3), (15495.0 * roomscale), (arg0\Field5 - (6144.0 * roomscale)), $01)
            local19 = loadtexture("GFX\map\sun.jpg", $01)
            entitytexture(local18, local19, $00, $00)
            entityfx(local18, $09)
            entityblend(local18, $03)
            arg0\Field11[$01] = loadtexture("GFX\map\sky.jpg", $01)
            scaletexture(arg0\Field11[$01], 25.0, 25.0)
            local20 = createplane($01, $00)
            entitytexture(local20, arg0\Field11[$01], $00, $00)
            positionentity(local20, 0.0, ((14800.0 * roomscale) + arg0\Field4), 0.0, $00)
            turnentity(local20, 180.0, 0.0, 0.0, $00)
            entityfx(local20, $01)
            entityparent(local20, arg0\Field2, $01)
            entityorder(local20, $3E8)
            entityalpha(local20, 0.5)
            arg0\Field11[$02] = loadtexture("GFX\map\sky2.jpg", $01)
            scaletexture(arg0\Field11[$02], 35.0, 35.0)
            local21 = createplane($01, $00)
            entitytexture(local21, arg0\Field11[$02], $00, $00)
            positionentity(local21, 0.0, ((14900.0 * roomscale) + arg0\Field4), 0.0, $00)
            entityorder(local21, $7D0)
            turnentity(local21, 180.0, 0.0, 0.0, $00)
            entityfx(local21, $01)
            entityparent(local21, arg0\Field2, $01)
            arg0\Field11[$03] = createpivot($00)
            positionentity(arg0\Field11[$03], (arg0\Field3 - (7680.0 * roomscale)), (10992.0 * roomscale), (arg0\Field5 - (27048.0 * roomscale)), $01)
            entityparent(arg0\Field11[$03], arg0\Field2, $01)
            arg0\Field11[$04] = createpivot($00)
            positionentity(arg0\Field11[$04], ((1088.0 * roomscale) + arg0\Field3), (12192.0 * roomscale), (arg0\Field5 - (4672.0 * roomscale)), $01)
            entityparent(arg0\Field11[$04], arg0\Field2, $01)
            arg0\Field11[$05] = createpivot($00)
            positionentity(arg0\Field11[$05], ((3264.0 * roomscale) + arg0\Field3), (12192.0 * roomscale), (arg0\Field5 - (4480.0 * roomscale)), $01)
            entityparent(arg0\Field11[$05], arg0\Field2, $01)
            arg0\Field11[$06] = createpivot($00)
            positionentity(arg0\Field11[$06], ((5192.0 * roomscale) + arg0\Field3), (12192.0 * roomscale), (arg0\Field5 - (1760.0 * roomscale)), $01)
            entityparent(arg0\Field11[$06], arg0\Field2, $01)
            arg0\Field11[$07] = createpivot($00)
            positionentity(arg0\Field11[$07], ((5192.0 * roomscale) + arg0\Field3), (12192.0 * roomscale), (arg0\Field5 - (4352.0 * roomscale)), $01)
            entityparent(arg0\Field11[$07], arg0\Field2, $01)
            arg0\Field12[$00] = createdoor($00, ((720.0 * roomscale) + arg0\Field3), 0.0, ((1432.0 * roomscale) + arg0\Field5), 0.0, arg0, $01, $00, $00, "")
            arg0\Field12[$00]\Field19 = $00
            arg0\Field12[$00]\Field5 = $01
            moveentity(arg0\Field12[$00]\Field3[$00], 0.0, 0.0, (22.0 * roomscale))
            moveentity(arg0\Field12[$00]\Field3[$01], 0.0, 0.0, (22.0 * roomscale))
            arg0\Field11[$08] = createpivot($00)
            positionentity(arg0\Field11[$08], ((720.0 * roomscale) + arg0\Field3), 0.0, ((1744.0 * roomscale) + arg0\Field5), $01)
            entityparent(arg0\Field11[$08], arg0\Field2, $01)
            arg0\Field12[$01] = createdoor($00, (arg0\Field3 - (5424.0 * roomscale)), (10784.0 * roomscale), (arg0\Field5 - (1380.0 * roomscale)), 0.0, arg0, $00, $00, $00, "")
            arg0\Field12[$01]\Field19 = $00
            arg0\Field12[$01]\Field5 = $00
            moveentity(arg0\Field12[$01]\Field3[$00], 0.0, 0.0, (22.0 * roomscale))
            moveentity(arg0\Field12[$01]\Field3[$01], 0.0, 0.0, (22.0 * roomscale))
            arg0\Field11[$09] = createpivot($00)
            positionentity(arg0\Field11[$09], (arg0\Field3 - (5424.0 * roomscale)), (10784.0 * roomscale), (arg0\Field5 - (1068.0 * roomscale)), $01)
            entityparent(arg0\Field11[$09], arg0\Field2, $01)
            arg0\Field12[$02] = createdoor($00, ((4352.0 * roomscale) + arg0\Field3), (10784.0 * roomscale), (arg0\Field5 - (492.0 * roomscale)), 0.0, arg0, $00, $00, $00, "")
            arg0\Field12[$02]\Field19 = $00
            arg0\Field12[$02]\Field5 = $00
            arg0\Field12[$03] = createdoor($00, ((4352.0 * roomscale) + arg0\Field3), (10784.0 * roomscale), ((500.0 * roomscale) + arg0\Field5), 0.0, arg0, $00, $00, $00, "")
            arg0\Field12[$03]\Field19 = $00
            arg0\Field12[$03]\Field5 = $00
            arg0\Field11[$0A] = createpivot($00)
            positionentity(arg0\Field11[$0A], ((4352.0 * roomscale) + arg0\Field3), (10778.0 * roomscale), ((1344.0 * roomscale) + arg0\Field5), $01)
            entityparent(arg0\Field11[$0A], arg0\Field2, $01)
            arg0\Field11[$0B] = createpivot($00)
            positionentity(arg0\Field11[$0B], ((2816.0 * roomscale) + arg0\Field3), (11024.0 * roomscale), (arg0\Field5 - (2816.0 * roomscale)), $01)
            entityparent(arg0\Field11[$0B], arg0\Field2, $01)
            arg0\Field12[$05] = createdoor($00, ((3248.0 * roomscale) + arg0\Field3), (9856.0 * roomscale), ((6400.0 * roomscale) + arg0\Field5), 0.0, arg0, $00, $00, $00, "ABCD")
            arg0\Field12[$05]\Field19 = $00
            arg0\Field12[$05]\Field5 = $00
            local0 = createdoor($00, ((3072.0 * roomscale) + arg0\Field3), (9856.0 * roomscale), ((5800.0 * roomscale) + arg0\Field5), 90.0, arg0, $00, $00, $03, "")
            local0\Field19 = $00
            local0\Field5 = $00
            arg0\Field11[$0E] = createpivot($00)
            positionentity(arg0\Field11[$0E], ((3536.0 * roomscale) + arg0\Field3), (10256.0 * roomscale), ((5512.0 * roomscale) + arg0\Field5), $01)
            entityparent(arg0\Field11[$0E], arg0\Field2, $01)
            arg0\Field11[$0F] = createpivot($00)
            positionentity(arg0\Field11[$0F], ((3536.0 * roomscale) + arg0\Field3), (10256.0 * roomscale), ((5824.0 * roomscale) + arg0\Field5), $01)
            entityparent(arg0\Field11[$0F], arg0\Field2, $01)
            arg0\Field11[$10] = createpivot($00)
            positionentity(arg0\Field11[$10], ((3856.0 * roomscale) + arg0\Field3), (10256.0 * roomscale), ((5512.0 * roomscale) + arg0\Field5), $01)
            entityparent(arg0\Field11[$10], arg0\Field2, $01)
            arg0\Field11[$11] = createpivot($00)
            positionentity(arg0\Field11[$11], ((3856.0 * roomscale) + arg0\Field3), (10256.0 * roomscale), ((5824.0 * roomscale) + arg0\Field5), $01)
            entityparent(arg0\Field11[$11], arg0\Field2, $01)
            arg0\Field11[$12] = createpivot($00)
            positionentity(arg0\Field11[$12], ((3727.0 * roomscale) + arg0\Field3), (10066.0 * roomscale), ((6623.0 * roomscale) + arg0\Field5), $01)
            entityparent(arg0\Field11[$12], arg0\Field2, $01)
            arg0\Field11[$13] = createpivot($00)
            positionentity(arg0\Field11[$13], ((3808.0 * roomscale) + arg0\Field3), (12320.0 * roomscale), (arg0\Field5 - (13568.0 * roomscale)), $01)
            entityparent(arg0\Field11[$13], arg0\Field2, $01)
        Case "roompj"
            local3 = createitem("Document SCP-372", "paper", ((800.0 * roomscale) + arg0\Field3), ((256.0 * roomscale) + arg0\Field4), ((80.0 * roomscale) + arg0\Field5))
            entityparent(local3\Field0, arg0\Field2, $01)
        Case "room079"
            local0 = createdoor(arg0\Field0, arg0\Field3, (-448.0 * roomscale), ((1136.0 * roomscale) + arg0\Field5), 0.0, arg0, $00, $01, $03, "")
            local0\Field8 = $01
            local0\Field19 = $00
            local0\Field5 = $00
            positionentity(local0\Field3[$01], ((224.0 * roomscale) + arg0\Field3), (-250.0 * roomscale), ((918.0 * roomscale) + arg0\Field5), $01)
            positionentity(local0\Field3[$00], (arg0\Field3 - (240.0 * roomscale)), (-250.0 * roomscale), ((1366.0 * roomscale) + arg0\Field5), $01)
            arg0\Field12[$00] = createdoor(arg0\Field0, ((1456.0 * roomscale) + arg0\Field3), (-448.0 * roomscale), ((976.0 * roomscale) + arg0\Field5), 0.0, arg0, $00, $01, $03, "")
            arg0\Field12[$00]\Field8 = $01
            arg0\Field12[$00]\Field19 = $00
            arg0\Field12[$00]\Field5 = $00
            positionentity(arg0\Field12[$00]\Field3[$01], ((1760.0 * roomscale) + arg0\Field3), (-250.0 * roomscale), ((1236.0 * roomscale) + arg0\Field5), $01)
            turnentity(arg0\Field12[$00]\Field3[$00], 0.0, -180.0, 0.0, $01)
            positionentity(arg0\Field12[$00]\Field3[$00], ((1760.0 * roomscale) + arg0\Field3), (-240.0 * roomscale), ((740.0 * roomscale) + arg0\Field5), $01)
            turnentity(arg0\Field12[$00]\Field3[$01], 0.0, 0.0, 0.0, $01)
            arg0\Field11[$00] = loadanimmesh("GFX\map\079.b3d", $00)
            scaleentity(arg0\Field11[$00], 1.3, 1.3, 1.3, $01)
            positionentity(arg0\Field11[$00], ((1856.0 * roomscale) + arg0\Field3), (-560.0 * roomscale), (arg0\Field5 - (672.0 * roomscale)), $01)
            entityparent(arg0\Field11[$00], arg0\Field2, $01)
            turnentity(arg0\Field11[$00], 0.0, 180.0, 0.0, $01)
            arg0\Field11[$01] = createsprite(arg0\Field11[$00])
            spriteviewmode(arg0\Field11[$01], $02)
            positionentity(arg0\Field11[$01], 0.082, 0.119, 0.01, $00)
            scalesprite(arg0\Field11[$01], 0.09, 0.0725)
            turnentity(arg0\Field11[$01], 0.0, 13.0, 0.0, $00)
            moveentity(arg0\Field11[$01], 0.0, 0.0, -0.022)
            entitytexture(arg0\Field11[$01], oldaipics($00), $00, $00)
            hideentity(arg0\Field11[$01])
        Case "room2pit"
            local4 = $00
            For local5 = $FFFFFFFF To $01 Step $02
                For local7 = $FFFFFFFF To $01 Step $01
                    local12 = createemitter((((202.0 * roomscale) * (Float local5)) + arg0\Field3), (8.0 * roomscale), (((256.0 * roomscale) * (Float local7)) + arg0\Field5), $00)
                    arg0\Field11[local4] = local12\Field0
                    If (local4 < $03) Then
                        turnentity(local12\Field0, 0.0, -90.0, 0.0, $01)
                    Else
                        turnentity(local12\Field0, 0.0, 90.0, 0.0, $01)
                    EndIf
                    turnentity(local12\Field0, -45.0, 0.0, 0.0, $01)
                    entityparent(local12\Field0, arg0\Field2, $01)
                    local4 = (local4 + $01)
                Next
            Next
            arg0\Field11[$06] = createpivot($00)
            positionentity(arg0\Field11[$06], ((640.0 * roomscale) + arg0\Field3), (8.0 * roomscale), (arg0\Field5 - (896.0 * roomscale)), $00)
            entityparent(arg0\Field11[$06], arg0\Field2, $01)
            arg0\Field11[$07] = createpivot($00)
            positionentity(arg0\Field11[$07], (arg0\Field3 - (864.0 * roomscale)), (-400.0 * roomscale), (arg0\Field5 - (632.0 * roomscale)), $00)
            entityparent(arg0\Field11[$07], arg0\Field2, $01)
        Case "room2testroom2"
            arg0\Field11[$00] = createpivot($00)
            positionentity(arg0\Field11[$00], (arg0\Field3 - (640.0 * roomscale)), 0.5, (arg0\Field5 - (912.0 * roomscale)), $00)
            entityparent(arg0\Field11[$00], arg0\Field2, $01)
            arg0\Field11[$01] = createpivot($00)
            positionentity(arg0\Field11[$01], (arg0\Field3 - (632.0 * roomscale)), 0.5, (arg0\Field5 - (16.0 * roomscale)), $00)
            entityparent(arg0\Field11[$01], arg0\Field2, $01)
            local22 = loadtexture("GFX\map\glass.png", $03)
            arg0\Field11[$02] = createsprite($00)
            entitytexture(arg0\Field11[$02], local22, $00, $00)
            spriteviewmode(arg0\Field11[$02], $02)
            scalesprite(arg0\Field11[$02], ((182.0 * roomscale) * 0.5), ((192.0 * roomscale) * 0.5))
            positionentity(arg0\Field11[$02], (arg0\Field3 - (595.0 * roomscale)), (224.0 * roomscale), (arg0\Field5 - (208.0 * roomscale)), $00)
            turnentity(arg0\Field11[$02], 0.0, 180.0, 0.0, $00)
            entityparent(arg0\Field11[$02], arg0\Field2, $01)
            freetexture(local22)
            local0 = createdoor(arg0\Field0, (arg0\Field3 - (240.0 * roomscale)), 0.0, ((640.0 * roomscale) + arg0\Field5), 90.0, arg0, $00, $00, $00, "")
            local0\Field19 = $00
            local0\Field5 = $00
            local0 = createdoor(arg0\Field0, (arg0\Field3 - (512.0 * roomscale)), 0.0, ((384.0 * roomscale) + arg0\Field5), 0.0, arg0, $00, $00, $00, "")
            local0\Field19 = $00
            local0\Field5 = $00
            local0 = createdoor(arg0\Field0, (arg0\Field3 - (816.0 * roomscale)), 0.0, (arg0\Field5 - (208.0 * roomscale)), 0.0, arg0, $00, $00, $00, "")
            local0\Field19 = $00
            local0\Field5 = $00
            freeentity(local0\Field3[$00])
            freeentity(local0\Field3[$01])
            local3 = createitem("Mobile Task Force Epsilon-11", "paper", (arg0\Field3 - (316.0 * roomscale)), ((272.0 * roomscale) + arg0\Field4), ((176.0 * roomscale) + arg0\Field5))
            entityparent(local3\Field0, arg0\Field2, $01)
        Case "room2toilets"
            arg0\Field11[$00] = createpivot($00)
            positionentity(arg0\Field11[$00], ((1040.0 * roomscale) + arg0\Field3), (192.0 * roomscale), arg0\Field5, $00)
            entityparent(arg0\Field11[$00], arg0\Field2, $01)
        Case "room2sroom"
            local0 = createdoor(arg0\Field0, ((1440.0 * roomscale) + arg0\Field3), (224.0 * roomscale), ((32.0 * roomscale) + arg0\Field5), 90.0, arg0, $00, $00, $04, "")
            local0\Field19 = $00
            local0\Field5 = $00
            local3 = createitem("Some SCP-420-J", "420", ((1776.0 * roomscale) + arg0\Field3), ((400.0 * roomscale) + arg0\Field4), ((427.0 * roomscale) + arg0\Field5))
            entityparent(local3\Field0, arg0\Field2, $01)
            local3 = createitem("Some SCP-420-J", "420", ((1808.0 * roomscale) + arg0\Field3), ((400.0 * roomscale) + arg0\Field4), ((435.0 * roomscale) + arg0\Field5))
            entityparent(local3\Field0, arg0\Field2, $01)
            local3 = createitem("Level 5 Key Card", "key5", ((2232.0 * roomscale) + arg0\Field3), ((392.0 * roomscale) + arg0\Field4), ((387.0 * roomscale) + arg0\Field5))
            rotateentity(local3\Field0, 0.0, (Float arg0\Field6), 0.0, $01)
            entityparent(local3\Field0, arg0\Field2, $01)
            local3 = createitem("Nuclear Device Document", "paper", ((2248.0 * roomscale) + arg0\Field3), ((440.0 * roomscale) + arg0\Field4), ((372.0 * roomscale) + arg0\Field5))
            entityparent(local3\Field0, arg0\Field2, $01)
            local3 = createitem("Radio Transceiver", "radio", ((2240.0 * roomscale) + arg0\Field3), ((320.0 * roomscale) + arg0\Field4), ((128.0 * roomscale) + arg0\Field5))
            entityparent(local3\Field0, arg0\Field2, $01)
        Case "room2poffices"
            local0 = createdoor(arg0\Field0, ((240.0 * roomscale) + arg0\Field3), 0.0, ((448.0 * roomscale) + arg0\Field5), 90.0, arg0, $00, $00, $00, accesscode)
            local0\Field19 = $00
            local0\Field5 = $00
            local0 = createdoor(arg0\Field0, (arg0\Field3 - (496.0 * roomscale)), 0.0, arg0\Field5, 90.0, arg0, $00, $00, $00, "ABCD")
            local0\Field19 = $00
            local0\Field5 = $00
            local0\Field4 = $01
            local0 = createdoor(arg0\Field0, ((240.0 * roomscale) + arg0\Field3), 0.0, (arg0\Field5 - (576.0 * roomscale)), 90.0, arg0, $00, $00, $00, "7816")
            local0\Field19 = $00
            local0\Field5 = $00
            local3 = createitem("Mysterious Note", "paper", ((736.0 * roomscale) + arg0\Field3), ((224.0 * roomscale) + arg0\Field4), ((544.0 * roomscale) + arg0\Field5))
            entityparent(local3\Field0, arg0\Field2, $01)
            local3 = createitem("Incident Report SCP-106-0204", "paper", ((704.0 * roomscale) + arg0\Field3), ((183.0 * roomscale) + arg0\Field4), (arg0\Field5 - (576.0 * roomscale)))
            entityparent(local3\Field0, arg0\Field2, $01)
        Case "room2nuke"
            local0 = createdoor(arg0\Field0, ((576.0 * roomscale) + arg0\Field3), 0.0, (arg0\Field5 - (152.0 * roomscale)), 90.0, arg0, $00, $00, $05, "")
            local0\Field19 = $00
            local0\Field5 = $00
            positionentity(local0\Field3[$00], entityx(local0\Field3[$00], $01), entityy(local0\Field3[$00], $01), (arg0\Field5 - (284.0 * roomscale)), $01)
            positionentity(local0\Field3[$01], entityx(local0\Field3[$01], $01), entityy(local0\Field3[$01], $01), (arg0\Field5 - (284.0 * roomscale)), $01)
            local0 = createdoor(arg0\Field0, (arg0\Field3 - (544.0 * roomscale)), (1504.0 * roomscale), ((738.0 * roomscale) + arg0\Field5), 90.0, arg0, $00, $00, $05, "")
            local0\Field19 = $00
            local0\Field5 = $00
            positionentity(local0\Field3[$00], entityx(local0\Field3[$00], $01), entityy(local0\Field3[$00], $01), ((608.0 * roomscale) + arg0\Field5), $01)
            positionentity(local0\Field3[$01], entityx(local0\Field3[$01], $01), entityy(local0\Field3[$01], $01), ((608.0 * roomscale) + arg0\Field5), $01)
            arg0\Field12[$00] = createdoor(arg0\Field0, ((1192.0 * roomscale) + arg0\Field3), 0.0, arg0\Field5, 90.0, arg0, $01, $00, $00, "")
            arg0\Field12[$00]\Field19 = $00
            arg0\Field12[$00]\Field5 = $01
            arg0\Field11[$04] = createpivot($00)
            positionentity(arg0\Field11[$04], ((1496.0 * roomscale) + arg0\Field3), (240.0 * roomscale), arg0\Field5, $00)
            entityparent(arg0\Field11[$04], arg0\Field2, $01)
            arg0\Field12[$01] = createdoor(arg0\Field0, ((680.0 * roomscale) + arg0\Field3), (1504.0 * roomscale), arg0\Field5, 90.0, arg0, $00, $00, $00, "")
            arg0\Field12[$01]\Field19 = $00
            arg0\Field12[$01]\Field5 = $00
            arg0\Field11[$05] = createpivot($00)
            positionentity(arg0\Field11[$05], ((984.0 * roomscale) + arg0\Field3), (1744.0 * roomscale), arg0\Field5, $00)
            entityparent(arg0\Field11[$05], arg0\Field2, $01)
            For local23 = $00 To $01 Step $01
                arg0\Field11[(local23 Shl $01)] = loadmesh("GFX\map\leverbase.x", $00)
                arg0\Field11[((local23 Shl $01) + $01)] = loadmesh("GFX\map\leverhandle.x", $00)
                For local4 = $00 To $01 Step $01
                    scaleentity(arg0\Field11[((local23 Shl $01) + local4)], 0.04, 0.04, 0.04, $00)
                    positionentity(arg0\Field11[((local23 Shl $01) + local4)], (arg0\Field3 - (975.0 * roomscale)), ((1712.0 * roomscale) + arg0\Field4), (arg0\Field5 - ((502.0 - (132.0 * (Float local23))) * roomscale)), $01)
                    entityparent(arg0\Field11[((local23 Shl $01) + local4)], arg0\Field2, $01)
                Next
                rotateentity(arg0\Field11[(local23 Shl $01)], 0.0, -270.0, 0.0, $00)
                rotateentity(arg0\Field11[((local23 Shl $01) + $01)], 10.0, -450.0, 0.0, $00)
                entitypickmode(arg0\Field11[((local23 Shl $01) + $01)], $01, $00)
                entityradius(arg0\Field11[((local23 Shl $01) + $01)], 0.1, 0.0)
            Next
            local3 = createitem("Nuclear Device Document", "paper", (arg0\Field3 - (768.0 * roomscale)), ((1684.0 * roomscale) + arg0\Field4), (arg0\Field5 - (768.0 * roomscale)))
            entityparent(local3\Field0, arg0\Field2, $01)
        Case "room2tunnel"
            arg0\Field11[$00] = createpivot($00)
            positionentity(arg0\Field11[$00], ((2640.0 * roomscale) + arg0\Field3), (-2496.0 * roomscale), ((400.0 * roomscale) + arg0\Field5), $00)
            entityparent(arg0\Field11[$00], arg0\Field2, $01)
            arg0\Field11[$01] = createpivot($00)
            positionentity(arg0\Field11[$01], (arg0\Field3 - (4336.0 * roomscale)), (-2496.0 * roomscale), (arg0\Field5 - (2512.0 * roomscale)), $00)
            entityparent(arg0\Field11[$01], arg0\Field2, $01)
            arg0\Field11[$02] = createpivot($00)
            positionentity(arg0\Field11[$02], ((552.0 * roomscale) + arg0\Field3), (240.0 * roomscale), ((656.0 * roomscale) + arg0\Field5), $00)
            entityparent(arg0\Field11[$02], arg0\Field2, $01)
            arg0\Field11[$03] = createpivot($00)
            positionentity(arg0\Field11[$03], (arg0\Field3 - (2040.0 * roomscale)), (-2256.0 * roomscale), (arg0\Field5 - (656.0 * roomscale)), $00)
            entityparent(arg0\Field11[$03], arg0\Field2, $01)
            arg0\Field11[$04] = createpivot($00)
            positionentity(arg0\Field11[$04], (arg0\Field3 - (552.0 * roomscale)), (240.0 * roomscale), (arg0\Field5 - (656.0 * roomscale)), $00)
            entityparent(arg0\Field11[$04], arg0\Field2, $01)
            arg0\Field11[$05] = createpivot($00)
            positionentity(arg0\Field11[$05], ((2072.0 * roomscale) + arg0\Field3), (-2256.0 * roomscale), ((656.0 * roomscale) + arg0\Field5), $00)
            entityparent(arg0\Field11[$05], arg0\Field2, $01)
            arg0\Field12[$00] = createdoor(arg0\Field0, ((264.0 * roomscale) + arg0\Field3), 0.0, ((656.0 * roomscale) + arg0\Field5), 90.0, arg0, $01, $00, $00, "")
            arg0\Field12[$00]\Field19 = $00
            arg0\Field12[$00]\Field5 = $01
            positionentity(arg0\Field12[$00]\Field3[$01], ((224.0 * roomscale) + arg0\Field3), 0.7, ((480.0 * roomscale) + arg0\Field5), $01)
            positionentity(arg0\Field12[$00]\Field3[$00], ((304.0 * roomscale) + arg0\Field3), 0.7, ((832.0 * roomscale) + arg0\Field5), $01)
            arg0\Field12[$01] = createdoor(arg0\Field0, (arg0\Field3 - (2328.0 * roomscale)), (-2496.0 * roomscale), (arg0\Field5 - (656.0 * roomscale)), 90.0, arg0, $00, $00, $00, "")
            arg0\Field12[$01]\Field19 = $00
            arg0\Field12[$01]\Field5 = $00
            positionentity(arg0\Field12[$01]\Field3[$00], (arg0\Field3 - (2288.0 * roomscale)), entityy(arg0\Field12[$01]\Field3[$00], $01), (arg0\Field5 - (480.0 * roomscale)), $01)
            positionentity(arg0\Field12[$01]\Field3[$01], (arg0\Field3 - (2368.0 * roomscale)), entityy(arg0\Field12[$01]\Field3[$01], $01), (arg0\Field5 - (800.0 * roomscale)), $01)
            arg0\Field12[$02] = createdoor(arg0\Field0, (arg0\Field3 - (264.0 * roomscale)), 0.0, (arg0\Field5 - (656.0 * roomscale)), 90.0, arg0, $01, $00, $00, "")
            arg0\Field12[$02]\Field19 = $00
            arg0\Field12[$02]\Field5 = $01
            positionentity(arg0\Field12[$02]\Field3[$00], (arg0\Field3 - (224.0 * roomscale)), 0.7, (arg0\Field5 - (480.0 * roomscale)), $01)
            positionentity(arg0\Field12[$02]\Field3[$01], (arg0\Field3 - (304.0 * roomscale)), 0.7, (arg0\Field5 - (832.0 * roomscale)), $01)
            arg0\Field12[$03] = createdoor(arg0\Field0, ((2360.0 * roomscale) + arg0\Field3), (-2496.0 * roomscale), ((656.0 * roomscale) + arg0\Field5), 90.0, arg0, $00, $00, $00, "")
            arg0\Field12[$03]\Field19 = $00
            arg0\Field12[$03]\Field5 = $00
            positionentity(arg0\Field12[$03]\Field3[$01], ((2320.0 * roomscale) + arg0\Field3), entityy(arg0\Field12[$03]\Field3[$00], $01), ((480.0 * roomscale) + arg0\Field5), $01)
            positionentity(arg0\Field12[$03]\Field3[$00], ((2432.0 * roomscale) + arg0\Field3), entityy(arg0\Field12[$03]\Field3[$01], $01), ((816.0 * roomscale) + arg0\Field5), $01)
            local0 = createdoor($00, arg0\Field3, arg0\Field4, arg0\Field5, 0.0, arg0, $00, $01, $00, "ABCD")
            positionentity(local0\Field3[$00], ((224.0 * roomscale) + arg0\Field3), (arg0\Field4 + 0.7), (arg0\Field5 - (384.0 * roomscale)), $01)
            rotateentity(local0\Field3[$00], 0.0, -90.0, 0.0, $01)
            positionentity(local0\Field3[$01], (arg0\Field3 - (224.0 * roomscale)), (arg0\Field4 + 0.7), ((384.0 * roomscale) + arg0\Field5), $01)
            rotateentity(local0\Field3[$01], 0.0, 90.0, 0.0, $01)
        Case "tunnel"
            local2 = createsecuritycam(arg0\Field3, ((448.0 * roomscale) + arg0\Field4), arg0\Field5, arg0, $00)
            local2\Field19 = $01
        Case "tunnel2"
            arg0\Field11[$00] = createpivot($00)
            positionentity(arg0\Field11[$00], arg0\Field3, (544.0 * roomscale), ((512.0 * roomscale) + arg0\Field5), $00)
            entityparent(arg0\Field11[$00], arg0\Field2, $01)
            arg0\Field11[$01] = createpivot($00)
            positionentity(arg0\Field11[$01], arg0\Field3, (544.0 * roomscale), (arg0\Field5 - (512.0 * roomscale)), $00)
            entityparent(arg0\Field11[$01], arg0\Field2, $01)
        Case "room2pipes"
            arg0\Field11[$00] = createpivot($00)
            positionentity(arg0\Field11[$00], ((368.0 * roomscale) + arg0\Field3), 0.0, arg0\Field5, $00)
            entityparent(arg0\Field11[$00], arg0\Field2, $01)
            arg0\Field11[$01] = createpivot($00)
            positionentity(arg0\Field11[$01], (arg0\Field3 - (368.0 * roomscale)), 0.0, arg0\Field5, $00)
            entityparent(arg0\Field11[$01], arg0\Field2, $01)
            arg0\Field11[$02] = createpivot($00)
            positionentity(arg0\Field11[$02], (((224.0 * roomscale) + arg0\Field3) - 0.005), (192.0 * roomscale), arg0\Field5, $00)
            entityparent(arg0\Field11[$02], arg0\Field2, $01)
            arg0\Field11[$03] = createpivot($00)
            positionentity(arg0\Field11[$03], ((arg0\Field3 - (224.0 * roomscale)) + 0.005), (192.0 * roomscale), arg0\Field5, $00)
            entityparent(arg0\Field11[$03], arg0\Field2, $01)
        Case "room3pit"
            local12 = createemitter(((512.0 * roomscale) + arg0\Field3), (-76.0 * roomscale), (arg0\Field5 - (688.0 * roomscale)), $00)
            turnentity(local12\Field0, -90.0, 0.0, 0.0, $00)
            entityparent(local12\Field0, arg0\Field2, $01)
            local12\Field10 = 35.0
            local12 = createemitter((arg0\Field3 - (512.0 * roomscale)), (-76.0 * roomscale), (arg0\Field5 - (688.0 * roomscale)), $00)
            turnentity(local12\Field0, -90.0, 0.0, 0.0, $00)
            entityparent(local12\Field0, arg0\Field2, $01)
            local12\Field10 = 35.0
        Case "testroom"
            For local5 = $00 To $01 Step $01
                For local7 = $FFFFFFFF To $01 Step $01
                    arg0\Field11[((local5 * $03) + (local7 + $01))] = createpivot($00)
                    positionentity(arg0\Field11[((local5 * $03) + (local7 + $01))], ((((280.0 * (Float local5)) + -236.0) * roomscale) + arg0\Field3), (-700.0 * roomscale), (((384.0 * (Float local7)) * roomscale) + arg0\Field5), $00)
                    entityparent(arg0\Field11[((local5 * $03) + (local7 + $01))], arg0\Field2, $01)
                Next
            Next
            arg0\Field11[$06] = createpivot($00)
            positionentity(arg0\Field11[$06], ((754.0 * roomscale) + arg0\Field3), (arg0\Field4 - (1248.0 * roomscale)), arg0\Field5, $00)
            entityparent(arg0\Field11[$06], arg0\Field2, $01)
            local2 = createsecuritycam(((744.0 * roomscale) + arg0\Field3), (arg0\Field4 - (856.0 * roomscale)), ((236.0 * roomscale) + arg0\Field5), arg0, $00)
            local2\Field19 = $01
            local0 = createdoor(arg0\Field0, (arg0\Field3 - (624.0 * roomscale)), (-1280.0 * roomscale), arg0\Field5, 90.0, arg0, $01, $00, $00, "")
            local3 = createitem("Document SCP-682", "paper", ((656.0 * roomscale) + arg0\Field3), (arg0\Field4 - (1200.0 * roomscale)), (arg0\Field5 - (16.0 * roomscale)))
            entityparent(local3\Field0, arg0\Field2, $01)
        Case "room2closets"
            local3 = createitem("Document SCP-173", "paper", ((692.0 * roomscale) + arg0\Field3), ((172.0 * roomscale) + arg0\Field4), ((463.0 * roomscale) + arg0\Field5))
            entityparent(local3\Field0, arg0\Field2, $01)
            local3 = createitem("Gas Mask", "gasmask", ((698.0 * roomscale) + arg0\Field3), ((236.0 * roomscale) + arg0\Field4), ((623.0 * roomscale) + arg0\Field5))
            scaleentity(local3\Field0, 0.02, 0.02, 0.02, $00)
            entityparent(local3\Field0, arg0\Field2, $01)
            local3 = createitem("9V Battery", "bat", ((703.0 * roomscale) + arg0\Field3), ((184.0 * roomscale) + arg0\Field4), (arg0\Field5 - (501.0 * roomscale)))
            entityparent(local3\Field0, arg0\Field2, $01)
            If (rand($02, $01) = $01) Then
                local3 = createitem("9V Battery", "bat", ((695.0 * roomscale) + arg0\Field3), ((184.0 * roomscale) + arg0\Field4), (arg0\Field5 - (525.0 * roomscale)))
                entityparent(local3\Field0, arg0\Field2, $01)
            EndIf
            If (rand($02, $01) = $01) Then
                local3 = createitem("9V Battery", "bat", ((708.0 * roomscale) + arg0\Field3), ((184.0 * roomscale) + arg0\Field4), (arg0\Field5 - (565.0 * roomscale)))
                entityparent(local3\Field0, arg0\Field2, $01)
            EndIf
        Case "room2offices"
            local3 = createitem("Document SCP-106", "paper", ((404.0 * roomscale) + arg0\Field3), ((145.0 * roomscale) + arg0\Field4), ((559.0 * roomscale) + arg0\Field5))
            entityparent(local3\Field0, arg0\Field2, $01)
            local3 = createitem("Level 2 Key Card", "key2", (arg0\Field3 - (156.0 * roomscale)), ((151.0 * roomscale) + arg0\Field4), ((72.0 * roomscale) + arg0\Field5))
            entityparent(local3\Field0, arg0\Field2, $01)
            local3 = createitem("S-NAV 300 Navigator", "nav", ((372.0 * roomscale) + arg0\Field3), ((153.0 * roomscale) + arg0\Field4), ((944.0 * roomscale) + arg0\Field5))
            local3\Field5 = 20.0
            entityparent(local3\Field0, arg0\Field2, $01)
            local3 = createitem("Notification", "paper", (arg0\Field3 - (137.0 * roomscale)), ((153.0 * roomscale) + arg0\Field4), ((464.0 * roomscale) + arg0\Field5))
            entityparent(local3\Field0, arg0\Field2, $01)
        Case "room2offices2"
            local3 = createitem("Level 1 Key Card", "key1", (arg0\Field3 - (368.0 * roomscale)), (arg0\Field4 - (48.0 * roomscale)), ((80.0 * roomscale) + arg0\Field5))
            local24 = loadtexture("GFX\items\keycard1.jpg", $01)
            entitytexture(local3\Field0, local24, $00, $00)
            entityparent(local3\Field0, arg0\Field2, $01)
            local3 = createitem("Document SCP-895", "paper", (arg0\Field3 - (800.0 * roomscale)), (arg0\Field4 - (48.0 * roomscale)), ((368.0 * roomscale) + arg0\Field5))
            entityparent(local3\Field0, arg0\Field2, $01)
            If (rand($02, $01) = $01) Then
                local3 = createitem("Document SCP-860", "paper", (arg0\Field3 - (800.0 * roomscale)), (arg0\Field4 - (48.0 * roomscale)), (arg0\Field5 - (464.0 * roomscale)))
            Else
                local3 = createitem("SCP-093 Recovered Materials", "paper", (arg0\Field3 - (800.0 * roomscale)), (arg0\Field4 - (48.0 * roomscale)), (arg0\Field5 - (464.0 * roomscale)))
            EndIf
            entityparent(local3\Field0, arg0\Field2, $01)
            local3 = createitem("S-NAV 300 Navigator", "nav", (arg0\Field3 - (336.0 * roomscale)), (arg0\Field4 - (48.0 * roomscale)), (arg0\Field5 - (480.0 * roomscale)))
            local3\Field5 = 28.0
            entityparent(local3\Field0, arg0\Field2, $01)
        Case "room2offices3"
            If (rand($02, $01) = $01) Then
                local3 = createitem("Mobile Task Forces", "paper", ((744.0 * roomscale) + arg0\Field3), ((240.0 * roomscale) + arg0\Field4), ((944.0 * roomscale) + arg0\Field5))
                entityparent(local3\Field0, arg0\Field2, $01)
            Else
                local3 = createitem("Security Clearance Levels", "paper", ((680.0 * roomscale) + arg0\Field3), ((240.0 * roomscale) + arg0\Field4), ((944.0 * roomscale) + arg0\Field5))
                entityparent(local3\Field0, arg0\Field2, $01)
            EndIf
            local3 = createitem("Object Classes", "paper", ((160.0 * roomscale) + arg0\Field3), ((240.0 * roomscale) + arg0\Field4), ((568.0 * roomscale) + arg0\Field5))
            entityparent(local3\Field0, arg0\Field2, $01)
            local3 = createitem("Document", "paper", (arg0\Field3 - (1440.0 * roomscale)), ((624.0 * roomscale) + arg0\Field4), ((152.0 * roomscale) + arg0\Field5))
            entityparent(local3\Field0, arg0\Field2, $01)
            local3 = createitem("Radio Transceiver", "radio", (arg0\Field3 - (1184.0 * roomscale)), ((480.0 * roomscale) + arg0\Field4), (arg0\Field5 - (800.0 * roomscale)))
            entityparent(local3\Field0, arg0\Field2, $01)
            For local4 = $00 To rand($00, $01) Step $01
                local3 = createitem("ReVision Eyedrops", "eyedrops", (arg0\Field3 - (1529.0 * roomscale)), ((563.0 * roomscale) + arg0\Field4), ((arg0\Field5 - (572.0 * roomscale)) + ((Float local4) * 0.05)))
                entityparent(local3\Field0, arg0\Field2, $01)
            Next
            local3 = createitem("9V Battery", "bat", (arg0\Field3 - (1545.0 * roomscale)), ((603.0 * roomscale) + arg0\Field4), (arg0\Field5 - (372.0 * roomscale)))
            entityparent(local3\Field0, arg0\Field2, $01)
            If (rand($02, $01) = $01) Then
                local3 = createitem("9V Battery", "bat", (arg0\Field3 - (1540.0 * roomscale)), ((603.0 * roomscale) + arg0\Field4), (arg0\Field5 - (340.0 * roomscale)))
                entityparent(local3\Field0, arg0\Field2, $01)
            EndIf
            If (rand($02, $01) = $01) Then
                local3 = createitem("9V Battery", "bat", (arg0\Field3 - (1529.0 * roomscale)), ((603.0 * roomscale) + arg0\Field4), (arg0\Field5 - (308.0 * roomscale)))
                entityparent(local3\Field0, arg0\Field2, $01)
            EndIf
            arg0\Field12[$00] = createdoor(arg0\Field0, (arg0\Field3 - (1056.0 * roomscale)), (384.0 * roomscale), ((290.0 * roomscale) + arg0\Field5), 90.0, arg0, $01, $00, $00, "")
            arg0\Field12[$00]\Field19 = $00
            arg0\Field12[$00]\Field5 = $01
            positionentity(arg0\Field12[$00]\Field3[$00], entityx(arg0\Field12[$00]\Field3[$00], $01), entityy(arg0\Field12[$00]\Field3[$00], $01), ((161.0 * roomscale) + arg0\Field5), $01)
            positionentity(arg0\Field12[$00]\Field3[$01], entityx(arg0\Field12[$00]\Field3[$01], $01), entityy(arg0\Field12[$00]\Field3[$01], $01), ((161.0 * roomscale) + arg0\Field5), $01)
        Case "start"
            arg0\Field12[$01] = createdoor(arg0\Field0, ((288.0 * roomscale) + arg0\Field3), 0.0, ((384.0 * roomscale) + arg0\Field5), 90.0, arg0, $01, $01, $00, "")
            arg0\Field12[$01]\Field4 = $00
            arg0\Field12[$01]\Field19 = $00
            arg0\Field12[$01]\Field8 = $01
            arg0\Field12[$01]\Field5 = $01
            freeentity(arg0\Field12[$01]\Field3[$00])
            arg0\Field12[$01]\Field3[$00] = $00
            freeentity(arg0\Field12[$01]\Field3[$01])
            arg0\Field12[$01]\Field3[$01] = $00
        Case "coffin"
            local0 = createdoor(arg0\Field0, arg0\Field3, 0.0, (arg0\Field5 - (448.0 * roomscale)), 0.0, arg0, $00, $01, $02, "")
            local0\Field8 = $01
            local0\Field19 = $00
            local0\Field5 = $00
            positionentity(local0\Field3[$00], (arg0\Field3 - (384.0 * roomscale)), 0.7, (arg0\Field5 - (280.0 * roomscale)), $01)
            local2 = createsecuritycam((arg0\Field3 - (320.0 * roomscale)), ((704.0 * roomscale) + arg0\Field4), ((288.0 * roomscale) + arg0\Field5), arg0, $01)
            local2\Field11 = 225.0
            local2\Field12 = 45.0
            local2\Field20 = $01
            turnentity(local2\Field3, 120.0, 0.0, 0.0, $00)
            entityparent(local2\Field0, arg0\Field2, $01)
            positionentity(local2\Field4, (arg0\Field3 - (800.0 * roomscale)), (288.0 * roomscale), (arg0\Field5 - (350.0 * roomscale)), $00)
            entityparent(local2\Field4, arg0\Field2, $01)
            turnentity(local2\Field4, 0.0, 180.0, 0.0, $00)
            arg0\Field11[$00] = createpivot($00)
            positionentity(arg0\Field11[$00], arg0\Field3, (-1320.0 * roomscale), ((2304.0 * roomscale) + arg0\Field5), $00)
            entityparent(arg0\Field11[$00], arg0\Field2, $01)
            local3 = createitem("Document SCP-895", "paper", (arg0\Field3 - (688.0 * roomscale)), ((133.0 * roomscale) + arg0\Field4), (arg0\Field5 - (304.0 * roomscale)))
            entityparent(local3\Field0, arg0\Field2, $01)
        Case "room2tesla"
            arg0\Field11[$00] = createpivot($00)
            positionentity(arg0\Field11[$00], (arg0\Field3 - (114.0 * roomscale)), 0.0, arg0\Field5, $00)
            entityparent(arg0\Field11[$00], arg0\Field2, $01)
            arg0\Field11[$01] = createpivot($00)
            positionentity(arg0\Field11[$01], ((114.0 * roomscale) + arg0\Field3), 0.0, arg0\Field5, $00)
            entityparent(arg0\Field11[$01], arg0\Field2, $01)
            arg0\Field11[$02] = createpivot($00)
            positionentity(arg0\Field11[$02], arg0\Field3, 0.0, arg0\Field5, $00)
            entityparent(arg0\Field11[$02], arg0\Field2, $01)
            arg0\Field11[$03] = createsprite($00)
            entitytexture(arg0\Field11[$03], teslatexture, $00, $00)
            spriteviewmode(arg0\Field11[$03], $02)
            entityblend(arg0\Field11[$03], local25)
            entityfx(arg0\Field11[$03], $19)
            positionentity(arg0\Field11[$03], arg0\Field3, 0.8, arg0\Field5, $00)
            hideentity(arg0\Field11[$03])
            entityparent(arg0\Field11[$03], arg0\Field2, $01)
        Case "room2doors"
            local0 = createdoor(arg0\Field0, arg0\Field3, 0.0, ((528.0 * roomscale) + arg0\Field5), 0.0, arg0, $01, $00, $00, "")
            local0\Field19 = $00
            positionentity(local0\Field3[$00], (arg0\Field3 - (832.0 * roomscale)), 0.7, ((160.0 * roomscale) + arg0\Field5), $01)
            positionentity(local0\Field3[$01], (arg0\Field3 - (224.0 * roomscale)), 0.7, ((896.0 * roomscale) + arg0\Field5), $01)
            rotateentity(local0\Field3[$01], 0.0, 90.0, 0.0, $01)
            local1 = createdoor(arg0\Field0, arg0\Field3, 0.0, (arg0\Field5 - (528.0 * roomscale)), 180.0, arg0, $01, $00, $00, "")
            local1\Field19 = $00
            freeentity(local1\Field3[$00])
            positionentity(local1\Field3[$01], (arg0\Field3 - (224.0 * roomscale)), 0.7, (arg0\Field5 - (896.0 * roomscale)), $01)
            rotateentity(local1\Field3[$01], 0.0, 90.0, 0.0, $01)
            arg0\Field11[$00] = createpivot($00)
            positionentity(arg0\Field11[$00], (arg0\Field3 - (832.0 * roomscale)), 0.5, arg0\Field5, $00)
            entityparent(arg0\Field11[$00], arg0\Field2, $01)
            local1\Field20 = local0
            local0\Field20 = local1
            local0\Field5 = $00
            local1\Field5 = $01
        Case "914"
            local0 = createdoor(arg0\Field0, arg0\Field3, 0.0, (arg0\Field5 - (368.0 * roomscale)), 0.0, arg0, $00, $01, $02, "")
            local0\Field8 = $01
            local0\Field19 = $00
            local0\Field5 = $00
            positionentity(local0\Field3[$00], (arg0\Field3 - (496.0 * roomscale)), 0.7, (arg0\Field5 - (272.0 * roomscale)), $01)
            turnentity(local0\Field3[$00], 0.0, 90.0, 0.0, $00)
            arg0\Field11[$00] = loadmesh("GFX\map\914key.x", $00)
            arg0\Field11[$01] = loadmesh("GFX\map\914knob.x", $00)
            For local4 = $00 To $01 Step $01
                scaleentity(arg0\Field11[local4], roomscale, roomscale, roomscale, $00)
                entitypickmode(arg0\Field11[local4], $02, $01)
            Next
            positionentity(arg0\Field11[$00], arg0\Field3, ((190.0 * roomscale) + arg0\Field4), ((374.0 * roomscale) + arg0\Field5), $00)
            positionentity(arg0\Field11[$01], arg0\Field3, ((230.0 * roomscale) + arg0\Field4), ((374.0 * roomscale) + arg0\Field5), $00)
            entityparent(arg0\Field11[$00], arg0\Field2, $01)
            entityparent(arg0\Field11[$01], arg0\Field2, $01)
            local0 = createdoor(arg0\Field0, (arg0\Field3 - (624.0 * roomscale)), 0.0, ((528.0 * roomscale) + arg0\Field5), 180.0, arg0, $01, $00, $00, "")
            freeentity(local0\Field1)
            local0\Field1 = $00
            freeentity(local0\Field3[$00])
            local0\Field3[$00] = $00
            freeentity(local0\Field3[$01])
            local0\Field3[$01] = $00
            arg0\Field12[$00] = local0
            local0\Field19 = $00
            local0 = createdoor(arg0\Field0, ((816.0 * roomscale) + arg0\Field3), 0.0, ((528.0 * roomscale) + arg0\Field5), 180.0, arg0, $01, $00, $00, "")
            freeentity(local0\Field1)
            local0\Field1 = $00
            freeentity(local0\Field3[$00])
            local0\Field3[$00] = $00
            freeentity(local0\Field3[$01])
            local0\Field3[$01] = $00
            arg0\Field12[$01] = local0
            local0\Field19 = $00
            arg0\Field11[$02] = createpivot($00)
            arg0\Field11[$03] = createpivot($00)
            positionentity(arg0\Field11[$02], (arg0\Field3 - (712.0 * roomscale)), 0.5, ((640.0 * roomscale) + arg0\Field5), $00)
            positionentity(arg0\Field11[$03], ((728.0 * roomscale) + arg0\Field3), 0.5, ((640.0 * roomscale) + arg0\Field5), $00)
            entityparent(arg0\Field11[$02], arg0\Field2, $01)
            entityparent(arg0\Field11[$03], arg0\Field2, $01)
            local3 = createitem("Note", "paper", ((954.0 * roomscale) + arg0\Field3), ((228.0 * roomscale) + arg0\Field4), ((127.0 * roomscale) + arg0\Field5))
            entityparent(local3\Field0, arg0\Field2, $01)
        Case "room173"
            arg0\Field11[$00] = createpivot($00)
            positionentity(arg0\Field11[$00], (entityx(arg0\Field2, $00) + (40.0 * roomscale)), (430.0 * roomscale), (entityz(arg0\Field2, $00) + (1052.0 * roomscale)), $00)
            arg0\Field11[$01] = createpivot($00)
            positionentity(arg0\Field11[$01], (entityx(arg0\Field2, $00) - (80.0 * roomscale)), (100.0 * roomscale), (entityz(arg0\Field2, $00) + (526.0 * roomscale)), $00)
            arg0\Field11[$02] = createpivot($00)
            positionentity(arg0\Field11[$02], (entityx(arg0\Field2, $00) - (128.0 * roomscale)), (100.0 * roomscale), (entityz(arg0\Field2, $00) + (320.0 * roomscale)), $00)
            arg0\Field11[$03] = createpivot($00)
            positionentity(arg0\Field11[$03], (entityx(arg0\Field2, $00) + (660.0 * roomscale)), (100.0 * roomscale), (entityz(arg0\Field2, $00) + (526.0 * roomscale)), $00)
            arg0\Field11[$04] = createpivot($00)
            positionentity(arg0\Field11[$04], (entityx(arg0\Field2, $00) + (700.0 * roomscale)), (100.0 * roomscale), (entityz(arg0\Field2, $00) + (320.0 * roomscale)), $00)
            arg0\Field11[$05] = createpivot($00)
            positionentity(arg0\Field11[$05], (entityx(arg0\Field2, $00) + (1472.0 * roomscale)), (100.0 * roomscale), (entityz(arg0\Field2, $00) + (912.0 * roomscale)), $00)
            For local4 = $00 To $05 Step $01
                entityparent(arg0\Field11[local4], arg0\Field2, $01)
            Next
            arg0\Field12[$00] = createdoor(arg0\Field0, entityx(arg0\Field2, $00), 0.0, (entityz(arg0\Field2, $00) - 4.0), 0.0, arg0, $00, $00, $00, "")
            arg0\Field12[$00]\Field4 = $01
            arg0\Field12[$00]\Field19 = $00
            arg0\Field12[$00]\Field5 = $00
            arg0\Field12[$01] = createdoor(arg0\Field0, (entityx(arg0\Field2, $00) + (288.0 * roomscale)), 0.0, (entityz(arg0\Field2, $00) + (384.0 * roomscale)), 90.0, arg0, $01, $01, $00, "")
            arg0\Field12[$01]\Field19 = $00
            arg0\Field12[$01]\Field8 = $01
            arg0\Field12[$01]\Field5 = $01
            freeentity(arg0\Field12[$01]\Field3[$00])
            arg0\Field12[$01]\Field3[$00] = $00
            freeentity(arg0\Field12[$01]\Field3[$01])
            arg0\Field12[$01]\Field3[$01] = $00
            local26 = createdecal(rand($04, $05), entityx(arg0\Field11[$05], $01), 0.002, entityz(arg0\Field11[$05], $01), 90.0, rnd(360.0, 0.0), 0.0)
            local26\Field2 = 1.2
            scalesprite(local26\Field0, local26\Field2, local26\Field2)
            For local5 = $00 To $01 Step $01
                For local7 = $00 To $01 Step $01
                    local26 = createdecal(rand($04, $06), ((((700.0 * roomscale) + arg0\Field3) + (((Float local5) * 700.0) * roomscale)) + rnd(-0.5, 0.5)), rnd(0.001, 0.0018), ((((Float ($258 * local7)) * roomscale) + arg0\Field5) + rnd(-0.5, 0.5)), 90.0, rnd(360.0, 0.0), 0.0)
                    local26\Field2 = rnd(0.5, 0.8)
                    local26\Field4 = rnd(0.8, 1.0)
                    scalesprite(local26\Field0, local26\Field2, local26\Field2)
                Next
            Next
            addlight(arg0, (arg0\Field3 - (224.0 * roomscale)), ((640.0 * roomscale) + arg0\Field4), ((128.0 * roomscale) + arg0\Field5), $02, 2.0, $C8, $C8, $C8)
            addlight(arg0, (arg0\Field3 - (1056.0 * roomscale)), ((608.0 * roomscale) + arg0\Field4), ((416.0 * roomscale) + arg0\Field5), $02, 2.0, $C8, $C8, $C8)
        Case "room2ccont"
            local0 = createdoor(arg0\Field0, ((64.0 * roomscale) + arg0\Field3), 0.0, ((368.0 * roomscale) + arg0\Field5), 180.0, arg0, $00, $00, $01, "")
            local0\Field19 = $00
            local0\Field5 = $00
            local3 = createitem("Note from Daniel", "paper", (arg0\Field3 - (400.0 * roomscale)), (1040.0 * roomscale), ((115.0 * roomscale) + arg0\Field5))
            entityparent(local3\Field0, arg0\Field2, $01)
            For local23 = $00 To $02 Step $01
                arg0\Field11[(local23 Shl $01)] = loadmesh("GFX\map\leverbase.x", $00)
                arg0\Field11[((local23 Shl $01) + $01)] = loadmesh("GFX\map\leverhandle.x", $00)
                For local4 = $00 To $01 Step $01
                    scaleentity(arg0\Field11[((local23 Shl $01) + local4)], 0.04, 0.04, 0.04, $00)
                    positionentity(arg0\Field11[((local23 Shl $01) + local4)], (arg0\Field3 - (240.0 * roomscale)), ((1104.0 * roomscale) + arg0\Field4), (((632.0 - (64.0 * (Float local23))) * roomscale) + arg0\Field5), $01)
                    entityparent(arg0\Field11[((local23 Shl $01) + local4)], arg0\Field2, $01)
                Next
                rotateentity(arg0\Field11[(local23 Shl $01)], 0.0, -90.0, 0.0, $00)
                rotateentity(arg0\Field11[((local23 Shl $01) + $01)], 10.0, -270.0, 0.0, $00)
                entitypickmode(arg0\Field11[((local23 Shl $01) + $01)], $01, $00)
                entityradius(arg0\Field11[((local23 Shl $01) + $01)], 0.1, 0.0)
            Next
        Case "room106"
            local3 = createitem("Level 4 Key Card", "key4", (arg0\Field3 - (752.0 * roomscale)), (arg0\Field4 - (592.0 * roomscale)), ((3026.0 * roomscale) + arg0\Field5))
            entityparent(local3\Field0, arg0\Field2, $01)
            local0 = createdoor(arg0\Field0, (arg0\Field3 - (968.0 * roomscale)), (-764.0 * roomscale), ((1392.0 * roomscale) + arg0\Field5), 0.0, arg0, $00, $00, $03, "")
            local0\Field19 = $00
            local0\Field5 = $00
            local0 = createdoor(arg0\Field0, arg0\Field3, 0.0, (arg0\Field5 - (464.0 * roomscale)), 0.0, arg0, $00, $00, $03, "")
            local0\Field19 = $00
            local0\Field5 = $00
            local0 = createdoor(arg0\Field0, (arg0\Field3 - (624.0 * roomscale)), (-1280.0 * roomscale), arg0\Field5, 90.0, arg0, $00, $00, $04, "")
            local0\Field19 = $00
            local0\Field5 = $00
            arg0\Field11[$06] = loadmesh("GFX\map\room1062.b3d", $00)
            scaleentity(arg0\Field11[$06], roomscale, roomscale, roomscale, $00)
            entitytype(arg0\Field11[$06], $01, $00)
            entitypickmode(arg0\Field11[$06], $03, $01)
            positionentity(arg0\Field11[$06], ((784.0 * roomscale) + arg0\Field3), (-980.0 * roomscale), ((720.0 * roomscale) + arg0\Field5), $01)
            If (bumpenabled <> 0) Then
                For local4 = $01 To countsurfaces(arg0\Field11[$06]) Step $01
                    local14 = getsurface(arg0\Field11[$06], local4)
                    local15 = getsurfacebrush(local14)
                    local17 = getbrushtexture(local15, $01)
                    local27 = strippath(texturename(local17))
                    For local28 = Each materials
                        If (local27 = local28\Field0) Then
                            local8 = getbrushtexture(local15, $00)
                            local9 = getbrushtexture(local15, $01)
                            brushtexture(local15, local8, $00, $00)
                            brushtexture(local15, local28\Field2, $00, $01)
                            brushtexture(local15, local9, $00, $02)
                            paintsurface(local14, local15)
                            Exit
                        EndIf
                    Next
                Next
            EndIf
            entityparent(arg0\Field11[$06], arg0\Field2, $01)
            For local23 = $00 To $02 Step $02
                arg0\Field11[local23] = loadmesh("GFX\map\leverbase.x", $00)
                arg0\Field11[(local23 + $01)] = loadmesh("GFX\map\leverhandle.x", $00)
                For local4 = $00 To $01 Step $01
                    scaleentity(arg0\Field11[(local23 + local4)], 0.04, 0.04, 0.04, $00)
                    positionentity(arg0\Field11[(local23 + local4)], (arg0\Field3 - ((555.0 - (81.0 * (Float (local23 Sar $01)))) * roomscale)), (arg0\Field4 - (576.0 * roomscale)), ((3040.0 * roomscale) + arg0\Field5), $01)
                    entityparent(arg0\Field11[(local23 + local4)], arg0\Field2, $01)
                Next
                rotateentity(arg0\Field11[local23], 0.0, 0.0, 0.0, $00)
                rotateentity(arg0\Field11[(local23 + $01)], 10.0, -180.0, 0.0, $00)
                entitypickmode(arg0\Field11[(local23 + $01)], $01, $00)
                entityradius(arg0\Field11[(local23 + $01)], 0.1, 0.0)
            Next
            rotateentity(arg0\Field11[$01], 81.0, -180.0, 0.0, $00)
            rotateentity(arg0\Field11[$03], -81.0, -180.0, 0.0, $00)
            arg0\Field11[$04] = createbutton((arg0\Field3 - (146.0 * roomscale)), (arg0\Field4 - (576.0 * roomscale)), ((3045.0 * roomscale) + arg0\Field5), 0.0, 0.0, 0.0)
            entityparent(arg0\Field11[$04], arg0\Field2, $01)
            local2 = createsecuritycam(((768.0 * roomscale) + arg0\Field3), ((1392.0 * roomscale) + arg0\Field4), ((1696.0 * roomscale) + arg0\Field5), arg0, $01)
            local2\Field11 = 315.0
            local2\Field12 = 20.0
            turnentity(local2\Field3, 45.0, 0.0, 0.0, $00)
            entityparent(local2\Field0, arg0\Field2, $01)
            arg0\Field11[$07] = local2\Field3
            arg0\Field11[$08] = local2\Field0
            positionentity(local2\Field4, (arg0\Field3 - (272.0 * roomscale)), (-544.0 * roomscale), ((3020.0 * roomscale) + arg0\Field5), $00)
            turnentity(local2\Field4, 0.0, -10.0, 0.0, $00)
            entityparent(local2\Field4, arg0\Field2, $01)
            arg0\Field13[$00] = createnpc($04, ((1088.0 * roomscale) + arg0\Field3), (1096.0 * roomscale), ((1728.0 * roomscale) + arg0\Field5))
            arg0\Field11[$05] = createpivot($00)
            turnentity(arg0\Field11[$05], 0.0, 180.0, 0.0, $00)
            positionentity(arg0\Field11[$05], ((1088.0 * roomscale) + arg0\Field3), (1096.0 * roomscale), ((1728.0 * roomscale) + arg0\Field5), $00)
            entityparent(arg0\Field11[$05], arg0\Field2, $01)
        Case "pocketdimension"
            local29 = loadmesh("GFX\map\pocketdimension2.b3d", $00)
            arg0\Field11[$08] = loadmesh("GFX\map\pocketdimension3.b3d", $00)
            arg0\Field11[$09] = loadmesh("GFX\map\pocketdimension4.b3d", $00)
            arg0\Field11[$0A] = copymesh(arg0\Field11[$09], $00)
            arg0\Field11[$0B] = loadmesh("GFX\map\pocketdimension5.b3d", $00)
            createitem("Burnt Note", "paper", entityx(arg0\Field2, $00), 0.5, (entityz(arg0\Field2, $00) + 3.5))
            For local23 = $00 To $04 Step $01
                Select local23
                    Case $00
                        local31 = local29
                    Case $01
                        local31 = arg0\Field11[$08]
                    Case $02
                        local31 = arg0\Field11[$09]
                    Case $03
                        local31 = arg0\Field11[$0A]
                    Case $04
                        local31 = arg0\Field11[$0B]
                End Select
                If (bumpenabled <> 0) Then
                    For local4 = $01 To countsurfaces(local31) Step $01
                        local14 = getsurface(local31, local4)
                        local15 = getsurfacebrush(local14)
                        local17 = getbrushtexture(local15, $01)
                        local27 = strippath(texturename(local17))
                        For local28 = Each materials
                            If (local27 = local28\Field0) Then
                                local8 = getbrushtexture(local15, $00)
                                local9 = getbrushtexture(local15, $01)
                                brushtexture(local15, local8, $00, $00)
                                brushtexture(local15, local28\Field2, $00, $01)
                                brushtexture(local15, local9, $00, $02)
                                paintsurface(local14, local15)
                                Exit
                            EndIf
                        Next
                    Next
                EndIf
            Next
            For local4 = $08 To $0B Step $01
                scaleentity(arg0\Field11[local4], roomscale, roomscale, roomscale, $00)
                entitytype(arg0\Field11[local4], $01, $00)
                entitypickmode(arg0\Field11[local4], $03, $01)
                positionentity(arg0\Field11[local4], arg0\Field3, arg0\Field4, (arg0\Field5 + 32.0), $01)
            Next
            scaleentity(arg0\Field11[$0A], (roomscale * 1.5), (roomscale * 2.0), (roomscale * 1.5), $01)
            positionentity(arg0\Field11[$0B], arg0\Field3, arg0\Field4, (arg0\Field5 + 64.0), $01)
            For local4 = $01 To $08 Step $01
                arg0\Field11[(local4 - $01)] = copymesh(local29, $00)
                scaleentity(arg0\Field11[(local4 - $01)], roomscale, roomscale, roomscale, $00)
                local32 = ((Float (local4 - $01)) * 45.0)
                entitytype(arg0\Field11[(local4 - $01)], $01, $00)
                entitypickmode(arg0\Field11[(local4 - $01)], $03, $01)
                rotateentity(arg0\Field11[(local4 - $01)], 0.0, (local32 - 90.0), 0.0, $00)
                positionentity(arg0\Field11[(local4 - $01)], (((512.0 * roomscale) * cos(local32)) + arg0\Field3), 0.0, (((512.0 * roomscale) * sin(local32)) + arg0\Field5), $00)
                entityparent(arg0\Field11[(local4 - $01)], arg0\Field2, $01)
                If (local4 < $06) Then
                    local26 = createdecal((local4 + $07), ((((512.0 * roomscale) * cos(local32)) * 3.0) + arg0\Field3), 0.02, ((((512.0 * roomscale) * sin(local32)) * 3.0) + arg0\Field5), 90.0, (local32 - 90.0), 0.0)
                    local26\Field2 = rnd(0.5, 0.5)
                    local26\Field5 = $02
                    local26\Field6 = $09
                    scalesprite(local26\Field0, local26\Field2, local26\Field2)
                    entityfx(local26\Field0, $09)
                    entityblend(local26\Field0, $02)
                EndIf
            Next
            For local4 = $0C To $10 Step $01
                arg0\Field11[local4] = createpivot(arg0\Field11[$0B])
                Select local4
                    Case $0C
                        positionentity(arg0\Field11[local4], arg0\Field3, ((200.0 * roomscale) + arg0\Field4), (arg0\Field5 + 64.0), $01)
                    Case $0D
                        positionentity(arg0\Field11[local4], ((390.0 * roomscale) + arg0\Field3), ((200.0 * roomscale) + arg0\Field4), ((arg0\Field5 + 64.0) + (272.0 * roomscale)), $01)
                    Case $0E
                        positionentity(arg0\Field11[local4], ((838.0 * roomscale) + arg0\Field3), ((200.0 * roomscale) + arg0\Field4), ((arg0\Field5 + 64.0) - (551.0 * roomscale)), $01)
                    Case $0F
                        positionentity(arg0\Field11[local4], (arg0\Field3 - (139.0 * roomscale)), ((200.0 * roomscale) + arg0\Field4), ((arg0\Field5 + 64.0) + (1201.0 * roomscale)), $01)
                    Case $10
                        positionentity(arg0\Field11[local4], (arg0\Field3 - (1238.0 * roomscale)), (arg0\Field4 - (1664.0 * roomscale)), ((arg0\Field5 + 64.0) + (381.0 * roomscale)), $01)
                End Select
            Next
            freetexture(local17)
            freeentity(local29)
    End Select
    For local34 = Each lighttemplates
        If (local34\Field0 = arg0\Field7) Then
            local35 = addlight(arg0, (arg0\Field3 + local34\Field2), (arg0\Field4 + local34\Field3), (arg0\Field5 + local34\Field4), local34\Field1, local34\Field5, local34\Field6, local34\Field7, local34\Field8)
            If (local35 <> $00) Then
                debuglog(((((((((((arg0\Field7\Field4 + " - ") + (Str local34\Field2)) + ", ") + (Str local34\Field3)) + ", ") + (Str local34\Field4)) + " - ") + (Str local34\Field5)) + ", ") + (Str local34\Field6)))
                If (local34\Field1 = $03) Then
                    lightconeangles(local35, (Float local34\Field11), local34\Field12)
                    rotateentity(local35, local34\Field9, local34\Field10, 0.0, $00)
                EndIf
            Else
                debuglog((arg0\Field7\Field4 + " - light error"))
            EndIf
        EndIf
    Next
    For local36 = Each tempscreens
        If (local36\Field4 = arg0\Field7) Then
            createscreen((arg0\Field3 + local36\Field1), (arg0\Field4 + local36\Field2), (arg0\Field5 + local36\Field3), local36\Field0, arg0)
        EndIf
    Next
    For local37 = Each tempwaypoints
        If (local37\Field3 = arg0\Field7) Then
            createwaypoint((arg0\Field3 + local37\Field0), (arg0\Field4 + local37\Field1), (arg0\Field5 + local37\Field2), Null, arg0)
        EndIf
    Next
    Return $00
End Function
