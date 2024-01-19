Function fillroom%(arg0.rooms)
    Local local0.doors
    Local local1.doors
    Local local2.securitycams
    Local local3.decals
    Local local4.items
    Local local5%
    Local local6%
    Local local7%
    Local local8%
    Local local9%
    Local local10%
    Local local11%
    Local local13.emitters
    Local local14%
    Local local15%
    Local local16.rooms
    Local local17%
    Local local18%
    Local local19%
    Local local21%
    Local local22%
    Local local23%
    Local local24.waypoints
    Local local25.waypoints
    Local local26%
    Local local27%
    Local local28%
    Local local29%
    Local local30$
    Local local31.materials
    Local local32%
    Local local34%
    Local local35#
    Local local37.lighttemplates
    Local local38%
    Local local39.tempscreens
    Local local40.tempwaypoints
    Select arg0\Field7\Field4
        Case "lockroom"
            local0 = createdoor(arg0\Field0, (arg0\Field3 - (736.0 * roomscale)), 0.0, (arg0\Field5 - (104.0 * roomscale)), 0.0, arg0, $01, $00, $00, "")
            local0\Field10 = $15E
            local0\Field21 = $00
            local0\Field5 = $00
            entityparent(local0\Field3[$00], $00, $01)
            positionentity(local0\Field3[$00], (arg0\Field3 - (288.0 * roomscale)), 0.7, (arg0\Field5 - (640.0 * roomscale)), $00)
            entityparent(local0\Field3[$00], arg0\Field2, $01)
            freeentity(local0\Field3[$01])
            local0\Field3[$01] = $00
            local1 = createdoor(arg0\Field0, ((104.0 * roomscale) + arg0\Field3), 0.0, ((736.0 * roomscale) + arg0\Field5), 270.0, arg0, $01, $00, $00, "")
            local1\Field10 = $15E
            local1\Field21 = $00
            local1\Field5 = $00
            entityparent(local1\Field3[$00], $00, $01)
            positionentity(local1\Field3[$00], ((640.0 * roomscale) + arg0\Field3), 0.7, ((288.0 * roomscale) + arg0\Field5), $00)
            rotateentity(local1\Field3[$00], 0.0, 90.0, 0.0, $00)
            entityparent(local1\Field3[$00], arg0\Field2, $01)
            freeentity(local1\Field3[$01])
            local1\Field3[$01] = $00
            local0\Field22 = local1
            local1\Field22 = local0
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
            local13 = createemitter((arg0\Field3 - (175.0 * roomscale)), (344.0 * roomscale), ((656.0 * roomscale) + arg0\Field5), $00)
            turnentity(local13\Field0, 90.0, 0.0, 0.0, $01)
            entityparent(local13\Field0, arg0\Field2, $01)
            local13\Field10 = 3.0
            local13\Field9 = 0.035
            local13\Field11 = (1.0 / 400.0)
            local13 = createemitter((arg0\Field3 - (655.0 * roomscale)), (344.0 * roomscale), ((240.0 * roomscale) + arg0\Field5), $00)
            turnentity(local13\Field0, 90.0, 0.0, 0.0, $01)
            entityparent(local13\Field0, arg0\Field2, $01)
            local13\Field10 = 3.0
            local13\Field9 = 0.035
            local13\Field11 = (1.0 / 400.0)
        Case "lockroom2"
            For local5 = $00 To $05 Step $01
                local3 = createdecal(rand($02, $03), ((rnd(-392.0, 520.0) * roomscale) + arg0\Field3), ((3.0 * roomscale) + rnd(0.0, 0.001)), ((rnd(-392.0, 520.0) * roomscale) + arg0\Field5), 90.0, rnd(360.0, 0.0), 0.0)
                local3\Field2 = rnd(0.3, 0.6)
                scalesprite(local3\Field0, local3\Field2, local3\Field2)
                createdecal(rand($0F, $10), ((rnd(-392.0, 520.0) * roomscale) + arg0\Field3), ((3.0 * roomscale) + rnd(0.0, 0.001)), ((rnd(-392.0, 520.0) * roomscale) + arg0\Field5), 90.0, rnd(360.0, 0.0), 0.0)
                local3\Field2 = rnd(0.1, 0.6)
                scalesprite(local3\Field0, local3\Field2, local3\Field2)
                createdecal(rand($0F, $10), (rnd(-0.5, 0.5) + arg0\Field3), ((3.0 * roomscale) + rnd(0.0, 0.001)), (rnd(-0.5, 0.5) + arg0\Field5), 90.0, rnd(360.0, 0.0), 0.0)
                local3\Field2 = rnd(0.1, 0.6)
                scalesprite(local3\Field0, local3\Field2, local3\Field2)
            Next
            local2 = createsecuritycam(((512.0 * roomscale) + arg0\Field3), ((384.0 * roomscale) + arg0\Field4), ((384.0 * roomscale) + arg0\Field5), arg0, $01)
            local2\Field11 = 135.0
            local2\Field12 = 45.0
            turnentity(local2\Field3, 40.0, 0.0, 0.0, $00)
            entityparent(local2\Field0, arg0\Field2, $01)
            positionentity(local2\Field4, ((668.0 * roomscale) + arg0\Field3), 1.1, (arg0\Field5 - (96.0 * roomscale)), $00)
            turnentity(local2\Field4, 0.0, 90.0, 0.0, $00)
            entityparent(local2\Field4, arg0\Field2, $01)
            local2 = createsecuritycam((arg0\Field3 - (384.0 * roomscale)), ((384.0 * roomscale) + arg0\Field4), (arg0\Field5 - (512.0 * roomscale)), arg0, $01)
            local2\Field11 = 315.0
            local2\Field12 = 45.0
            turnentity(local2\Field3, 40.0, 0.0, 0.0, $00)
            entityparent(local2\Field0, arg0\Field2, $01)
            positionentity(local2\Field4, ((96.0 * roomscale) + arg0\Field3), 1.1, (arg0\Field5 - (668.0 * roomscale)), $00)
            entityparent(local2\Field4, arg0\Field2, $01)
        Case "gatea"
            arg0\Field12[$02] = createdoor(arg0\Field0, (arg0\Field3 - (4064.0 * roomscale)), (10720.0 * roomscale), ((3952.0 * roomscale) + arg0\Field5), 0.0, arg0, $00, $00, $00, "")
            arg0\Field12[$02]\Field21 = $00
            arg0\Field12[$02]\Field5 = $00
            local1 = createdoor(arg0\Field0, arg0\Field3, (12000.0 * roomscale), (arg0\Field5 - (1024.0 * roomscale)), 0.0, arg0, $00, $00, $00, "")
            local1\Field21 = $00
            local1\Field5 = $00
            local1\Field4 = $01
            local1 = createdoor(arg0\Field0, (arg0\Field3 - (1440.0 * roomscale)), (11520.0 * roomscale), ((2328.0 * roomscale) + arg0\Field5), 0.0, arg0, $00, $00, $02, "")
            local1\Field21 = $00
            local1\Field5 = $00
            positionentity(local1\Field3[$00], (arg0\Field3 - (1320.0 * roomscale)), entityy(local1\Field3[$00], $01), ((2288.0 * roomscale) + arg0\Field5), $01)
            positionentity(local1\Field3[$01], (arg0\Field3 - (1584.0 * roomscale)), entityy(local1\Field3[$00], $01), ((2488.0 * roomscale) + arg0\Field5), $01)
            rotateentity(local1\Field3[$01], 0.0, 90.0, 0.0, $01)
            local1 = createdoor(arg0\Field0, (arg0\Field3 - (1440.0 * roomscale)), (11520.0 * roomscale), ((4352.0 * roomscale) + arg0\Field5), 0.0, arg0, $00, $00, $02, "")
            local1\Field21 = $00
            local1\Field5 = $00
            positionentity(local1\Field3[$00], (arg0\Field3 - (1320.0 * roomscale)), entityy(local1\Field3[$00], $01), ((4384.0 * roomscale) + arg0\Field5), $01)
            rotateentity(local1\Field3[$00], 0.0, 180.0, 0.0, $01)
            positionentity(local1\Field3[$01], (arg0\Field3 - (1584.0 * roomscale)), entityy(local1\Field3[$00], $01), ((4232.0 * roomscale) + arg0\Field5), $01)
            rotateentity(local1\Field3[$01], 0.0, 90.0, 0.0, $01)
            local14 = createsprite(arg0\Field2)
            scalesprite(local14, 20.0, 20.0)
            positionentity(local14, ((36.0 * roomscale) + arg0\Field3), (4492.0 * roomscale), ((1024.0 * roomscale) + arg0\Field5), $01)
            local15 = loadtexture("GFX\map\sun.jpg", $01)
            entitytexture(local14, local15, $00, $00)
            entityfx(local14, $09)
            entityblend(local14, $03)
            For local16 = Each rooms
                If (local16\Field7\Field4 = "exit1") Then
                    arg0\Field11[$01] = local16\Field11[$01]
                    arg0\Field11[$02] = local16\Field11[$02]
                ElseIf (local16\Field7\Field4 = "gateaentrance") Then
                    arg0\Field12[$01] = createdoor($00, ((1544.0 * roomscale) + arg0\Field3), (12000.0 * roomscale), (arg0\Field5 - (64.0 * roomscale)), 90.0, arg0, $00, $00, $00, "")
                    arg0\Field12[$01]\Field21 = $00
                    arg0\Field12[$01]\Field5 = $00
                    positionentity(arg0\Field12[$01]\Field3[$00], ((1584.0 * roomscale) + arg0\Field3), entityy(arg0\Field12[$01]\Field3[$00], $01), ((80.0 * roomscale) + arg0\Field5), $01)
                    positionentity(arg0\Field12[$01]\Field3[$01], ((1456.0 * roomscale) + arg0\Field3), entityy(arg0\Field12[$01]\Field3[$01], $01), (arg0\Field5 - (208.0 * roomscale)), $01)
                    local16\Field11[$01] = createpivot($00)
                    positionentity(local16\Field11[$01], ((1848.0 * roomscale) + arg0\Field3), (240.0 * roomscale), (arg0\Field5 - (64.0 * roomscale)), $01)
                    entityparent(local16\Field11[$01], arg0\Field2, $01)
                EndIf
            Next
            arg0\Field11[$03] = createpivot($00)
            positionentity(arg0\Field11[$03], ((1216.0 * roomscale) + arg0\Field3), 0.0, ((2112.0 * roomscale) + arg0\Field5), $01)
            entityparent(arg0\Field11[$03], arg0\Field2, $01)
            arg0\Field11[$04] = createpivot($00)
            positionentity(arg0\Field11[$04], arg0\Field3, (96.0 * roomscale), ((6400.0 * roomscale) + arg0\Field5), $01)
            entityparent(arg0\Field11[$04], arg0\Field2, $01)
            arg0\Field11[$05] = createpivot($00)
            positionentity(arg0\Field11[$05], ((1784.0 * roomscale) + arg0\Field3), (2124.0 * roomscale), ((4512.0 * roomscale) + arg0\Field5), $01)
            entityparent(arg0\Field11[$05], arg0\Field2, $01)
            arg0\Field11[$06] = createpivot($00)
            positionentity(arg0\Field11[$06], (arg0\Field3 - (5048.0 * roomscale)), (1912.0 * roomscale), ((4656.0 * roomscale) + arg0\Field5), $01)
            entityparent(arg0\Field11[$06], arg0\Field2, $01)
            arg0\Field11[$07] = createpivot($00)
            positionentity(arg0\Field11[$07], ((1824.0 * roomscale) + arg0\Field3), (224.0 * roomscale), ((7056.0 * roomscale) + arg0\Field5), $01)
            entityparent(arg0\Field11[$07], arg0\Field2, $01)
            arg0\Field11[$08] = createpivot($00)
            positionentity(arg0\Field11[$08], (arg0\Field3 - (1824.0 * roomscale)), (224.0 * roomscale), ((7056.0 * roomscale) + arg0\Field5), $01)
            entityparent(arg0\Field11[$08], arg0\Field2, $01)
            arg0\Field11[$09] = createpivot($00)
            positionentity(arg0\Field11[$09], ((2624.0 * roomscale) + arg0\Field3), (992.0 * roomscale), ((6157.0 * roomscale) + arg0\Field5), $01)
            entityparent(arg0\Field11[$09], arg0\Field2, $01)
            arg0\Field11[$0B] = createpivot($00)
            positionentity(arg0\Field11[$0B], (arg0\Field3 - (4064.0 * roomscale)), (-1248.0 * roomscale), (arg0\Field5 - (1696.0 * roomscale)), $01)
            entityparent(arg0\Field11[$0B], arg0\Field2, $01)
            arg0\Field11[$0D] = loadmesh("GFX\map\gateawall1.b3d", arg0\Field2)
            positionentity(arg0\Field11[$0D], (arg0\Field3 - (4308.0 * roomscale)), (-1045.0 * roomscale), ((544.0 * roomscale) + arg0\Field5), $01)
            entitycolor(arg0\Field11[$0D], 25.0, 25.0, 25.0)
            arg0\Field11[$0E] = loadmesh("GFX\map\gateawall2.b3d", arg0\Field2)
            positionentity(arg0\Field11[$0E], (arg0\Field3 - (3820.0 * roomscale)), (-1045.0 * roomscale), ((544.0 * roomscale) + arg0\Field5), $01)
            entitycolor(arg0\Field11[$0E], 25.0, 25.0, 25.0)
            arg0\Field11[$0F] = createpivot(arg0\Field2)
            positionentity(arg0\Field11[$0F], (arg0\Field3 - (3568.0 * roomscale)), (-1089.0 * roomscale), ((4944.0 * roomscale) + arg0\Field5), $01)
        Case "gateaentrance"
            arg0\Field12[$00] = createdoor($00, ((744.0 * roomscale) + arg0\Field3), 0.0, ((512.0 * roomscale) + arg0\Field5), 90.0, arg0, $01, $00, $00, "")
            arg0\Field12[$00]\Field21 = $00
            arg0\Field12[$00]\Field5 = $01
            positionentity(arg0\Field12[$00]\Field3[$01], ((688.0 * roomscale) + arg0\Field3), entityy(arg0\Field12[$00]\Field3[$01], $01), ((368.0 * roomscale) + arg0\Field5), $01)
            positionentity(arg0\Field12[$00]\Field3[$00], ((784.0 * roomscale) + arg0\Field3), entityy(arg0\Field12[$00]\Field3[$00], $01), ((656.0 * roomscale) + arg0\Field5), $01)
            arg0\Field11[$00] = createpivot($00)
            positionentity(arg0\Field11[$00], ((1048.0 * roomscale) + arg0\Field3), 0.0, ((512.0 * roomscale) + arg0\Field5), $01)
            entityparent(arg0\Field11[$00], arg0\Field2, $01)
        Case "exit1"
            arg0\Field11[$00] = loadmesh("GFX\map\exit1terrain.b3d", arg0\Field2)
            positionentity(arg0\Field11[$00], ((4356.0 * roomscale) + arg0\Field3), (9767.0 * roomscale), ((2588.0 * roomscale) + arg0\Field5), $01)
            scaleentity(arg0\Field11[$00], roomscale, roomscale, roomscale, $01)
            If ((bumpenabled And $00) <> 0) Then
                local17 = loadtexture("GFX\map\gravelbump.jpg", $01)
                textureblend(local17, $1603)
                For local5 = $01 To countsurfaces(arg0\Field11[$00]) Step $01
                    local18 = getsurface(arg0\Field11[$00], local5)
                    local19 = getsurfacebrush(local18)
                    local9 = getbrushtexture(local19, $00)
                    local10 = getbrushtexture(local19, $01)
                    Select strippath(texturename(local10))
                        Case "gravel.jpg","grass2.jpg"
                            brushtexture(local19, local9, $00, $00)
                            brushtexture(local19, local17, $00, $01)
                            brushtexture(local19, local10, $00, $02)
                            paintsurface(local18, local19)
                            If (strippath(texturename(local9)) <> "") Then
                                freetexture(local9)
                            EndIf
                            If (strippath(texturename(local10)) <> "") Then
                                freetexture(local10)
                            EndIf
                            freetexture(local21)
                            freebrush(local19)
                    End Select
                Next
            EndIf
            arg0\Field12[$04] = createdoor(arg0\Field0, arg0\Field3, 0.0, (arg0\Field5 - (320.0 * roomscale)), 0.0, arg0, $00, $01, $03, "")
            arg0\Field12[$04]\Field9 = $01
            arg0\Field12[$04]\Field21 = $00
            arg0\Field12[$04]\Field5 = $00
            positionentity(arg0\Field12[$04]\Field3[$01], arg0\Field3, 8.0, arg0\Field5, $01)
            positionentity(arg0\Field12[$04]\Field3[$00], arg0\Field3, 8.0, arg0\Field5, $01)
            arg0\Field13[$00] = createnpc($07, arg0\Field3, 100.0, arg0\Field5)
            arg0\Field13[$00]\Field9 = 1.0
            local14 = createsprite(arg0\Field2)
            scalesprite(local14, 20.0, 20.0)
            positionentity(local14, ((11040.0 * roomscale) + arg0\Field3), (15495.0 * roomscale), (arg0\Field5 - (6144.0 * roomscale)), $01)
            local15 = loadtexture("GFX\map\sun.jpg", $01)
            entitytexture(local14, local15, $00, $00)
            entityfx(local14, $09)
            entityblend(local14, $03)
            arg0\Field11[$01] = loadtexture("GFX\map\sky.jpg", $01)
            scaletexture(arg0\Field11[$01], 25.0, 25.0)
            sky1 = createplane($01, $00)
            entitytexture(sky1, arg0\Field11[$01], $00, $00)
            positionentity(sky1, 0.0, ((14800.0 * roomscale) + arg0\Field4), 0.0, $00)
            turnentity(sky1, 180.0, 0.0, 0.0, $00)
            entityfx(sky1, $01)
            entityorder(sky1, $3E8)
            entityalpha(sky1, 0.5)
            arg0\Field11[$02] = loadtexture("GFX\map\sky2.jpg", $01)
            scaletexture(arg0\Field11[$02], 35.0, 35.0)
            sky2 = createplane($01, $00)
            entitytexture(sky2, arg0\Field11[$02], $00, $00)
            positionentity(sky2, 0.0, ((14900.0 * roomscale) + arg0\Field4), 0.0, $00)
            entityorder(sky2, $7D0)
            turnentity(sky2, 180.0, 0.0, 0.0, $00)
            entityfx(sky2, $01)
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
            arg0\Field12[$00]\Field21 = $00
            arg0\Field12[$00]\Field5 = $01
            moveentity(arg0\Field12[$00]\Field3[$00], 0.0, 0.0, (22.0 * roomscale))
            moveentity(arg0\Field12[$00]\Field3[$01], 0.0, 0.0, (22.0 * roomscale))
            arg0\Field11[$08] = createpivot($00)
            positionentity(arg0\Field11[$08], ((720.0 * roomscale) + arg0\Field3), 0.0, ((1744.0 * roomscale) + arg0\Field5), $01)
            entityparent(arg0\Field11[$08], arg0\Field2, $01)
            arg0\Field12[$01] = createdoor($00, (arg0\Field3 - (5424.0 * roomscale)), (10784.0 * roomscale), (arg0\Field5 - (1380.0 * roomscale)), 0.0, arg0, $00, $00, $00, "")
            arg0\Field12[$01]\Field21 = $00
            arg0\Field12[$01]\Field5 = $00
            moveentity(arg0\Field12[$01]\Field3[$00], 0.0, 0.0, (22.0 * roomscale))
            moveentity(arg0\Field12[$01]\Field3[$01], 0.0, 0.0, (22.0 * roomscale))
            arg0\Field11[$09] = createpivot($00)
            positionentity(arg0\Field11[$09], (arg0\Field3 - (5424.0 * roomscale)), (10784.0 * roomscale), (arg0\Field5 - (1068.0 * roomscale)), $01)
            entityparent(arg0\Field11[$09], arg0\Field2, $01)
            arg0\Field12[$02] = createdoor($00, ((4352.0 * roomscale) + arg0\Field3), (10784.0 * roomscale), (arg0\Field5 - (492.0 * roomscale)), 0.0, arg0, $00, $00, $00, "")
            arg0\Field12[$02]\Field21 = $00
            arg0\Field12[$02]\Field5 = $00
            arg0\Field12[$03] = createdoor($00, ((4352.0 * roomscale) + arg0\Field3), (10784.0 * roomscale), ((500.0 * roomscale) + arg0\Field5), 0.0, arg0, $00, $00, $00, "")
            arg0\Field12[$03]\Field21 = $00
            arg0\Field12[$03]\Field5 = $00
            arg0\Field11[$0A] = createpivot($00)
            positionentity(arg0\Field11[$0A], ((4352.0 * roomscale) + arg0\Field3), (10778.0 * roomscale), ((1344.0 * roomscale) + arg0\Field5), $01)
            entityparent(arg0\Field11[$0A], arg0\Field2, $01)
            arg0\Field11[$0B] = createpivot($00)
            positionentity(arg0\Field11[$0B], ((2816.0 * roomscale) + arg0\Field3), (11024.0 * roomscale), (arg0\Field5 - (2816.0 * roomscale)), $01)
            entityparent(arg0\Field11[$0B], arg0\Field2, $01)
            arg0\Field12[$05] = createdoor($00, ((3248.0 * roomscale) + arg0\Field3), (9856.0 * roomscale), ((6400.0 * roomscale) + arg0\Field5), 0.0, arg0, $00, $00, $00, "ABCD")
            arg0\Field12[$05]\Field21 = $00
            arg0\Field12[$05]\Field5 = $00
            local0 = createdoor($00, ((3072.0 * roomscale) + arg0\Field3), (9856.0 * roomscale), ((5800.0 * roomscale) + arg0\Field5), 90.0, arg0, $00, $00, $03, "")
            local0\Field21 = $00
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
            local4 = createitem("Document SCP-372", "paper", ((800.0 * roomscale) + arg0\Field3), ((256.0 * roomscale) + arg0\Field4), ((80.0 * roomscale) + arg0\Field5))
            entityparent(local4\Field0, arg0\Field2, $01)
        Case "room079"
            local0 = createdoor(arg0\Field0, arg0\Field3, (-448.0 * roomscale), ((1136.0 * roomscale) + arg0\Field5), 0.0, arg0, $00, $01, $03, "")
            local0\Field9 = $01
            local0\Field21 = $00
            local0\Field5 = $00
            positionentity(local0\Field3[$01], ((224.0 * roomscale) + arg0\Field3), (-250.0 * roomscale), ((918.0 * roomscale) + arg0\Field5), $01)
            positionentity(local0\Field3[$00], (arg0\Field3 - (240.0 * roomscale)), (-250.0 * roomscale), ((1366.0 * roomscale) + arg0\Field5), $01)
            arg0\Field12[$00] = createdoor(arg0\Field0, ((1456.0 * roomscale) + arg0\Field3), (-448.0 * roomscale), ((976.0 * roomscale) + arg0\Field5), 0.0, arg0, $00, $01, $03, "")
            arg0\Field12[$00]\Field9 = $01
            arg0\Field12[$00]\Field21 = $00
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
            local5 = $00
            For local6 = $FFFFFFFF To $01 Step $02
                For local8 = $FFFFFFFF To $01 Step $01
                    local13 = createemitter((((202.0 * roomscale) * (Float local6)) + arg0\Field3), (8.0 * roomscale), (((256.0 * roomscale) * (Float local8)) + arg0\Field5), $00)
                    arg0\Field11[local5] = local13\Field0
                    If (local5 < $03) Then
                        turnentity(local13\Field0, 0.0, -90.0, 0.0, $01)
                    Else
                        turnentity(local13\Field0, 0.0, 90.0, 0.0, $01)
                    EndIf
                    turnentity(local13\Field0, -45.0, 0.0, 0.0, $01)
                    entityparent(local13\Field0, arg0\Field2, $01)
                    local5 = (local5 + $01)
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
            local0\Field21 = $00
            local0\Field5 = $00
            local0 = createdoor(arg0\Field0, (arg0\Field3 - (512.0 * roomscale)), 0.0, ((384.0 * roomscale) + arg0\Field5), 0.0, arg0, $00, $00, $00, "")
            local0\Field21 = $00
            local0\Field5 = $00
            local0 = createdoor(arg0\Field0, (arg0\Field3 - (816.0 * roomscale)), 0.0, (arg0\Field5 - (208.0 * roomscale)), 0.0, arg0, $00, $00, $00, "")
            local0\Field21 = $00
            local0\Field5 = $00
            freeentity(local0\Field3[$00])
            local0\Field3[$00] = $00
            freeentity(local0\Field3[$01])
            local0\Field3[$01] = $00
            local4 = createitem("Mobile Task Force Epsilon-11", "paper", (arg0\Field3 - (316.0 * roomscale)), ((272.0 * roomscale) + arg0\Field4), ((176.0 * roomscale) + arg0\Field5))
            entityparent(local4\Field0, arg0\Field2, $01)
        Case "room2toilets"
            arg0\Field11[$00] = createpivot($00)
            positionentity(arg0\Field11[$00], ((1040.0 * roomscale) + arg0\Field3), (192.0 * roomscale), arg0\Field5, $00)
            entityparent(arg0\Field11[$00], arg0\Field2, $01)
        Case "room2sroom"
            local0 = createdoor(arg0\Field0, ((1440.0 * roomscale) + arg0\Field3), (224.0 * roomscale), ((32.0 * roomscale) + arg0\Field5), 90.0, arg0, $00, $00, $04, "")
            local0\Field21 = $00
            local0\Field5 = $00
            local4 = createitem("Some SCP-420-J", "420", ((1776.0 * roomscale) + arg0\Field3), ((400.0 * roomscale) + arg0\Field4), ((427.0 * roomscale) + arg0\Field5))
            entityparent(local4\Field0, arg0\Field2, $01)
            local4 = createitem("Some SCP-420-J", "420", ((1808.0 * roomscale) + arg0\Field3), ((400.0 * roomscale) + arg0\Field4), ((435.0 * roomscale) + arg0\Field5))
            entityparent(local4\Field0, arg0\Field2, $01)
            local4 = createitem("Level 5 Key Card", "key5", ((2232.0 * roomscale) + arg0\Field3), ((392.0 * roomscale) + arg0\Field4), ((387.0 * roomscale) + arg0\Field5))
            rotateentity(local4\Field0, 0.0, (Float arg0\Field6), 0.0, $01)
            entityparent(local4\Field0, arg0\Field2, $01)
            local4 = createitem("Nuclear Device Document", "paper", ((2248.0 * roomscale) + arg0\Field3), ((440.0 * roomscale) + arg0\Field4), ((372.0 * roomscale) + arg0\Field5))
            entityparent(local4\Field0, arg0\Field2, $01)
            local4 = createitem("Radio Transceiver", "radio", ((2240.0 * roomscale) + arg0\Field3), ((320.0 * roomscale) + arg0\Field4), ((128.0 * roomscale) + arg0\Field5))
            entityparent(local4\Field0, arg0\Field2, $01)
        Case "room2poffices"
            local0 = createdoor(arg0\Field0, ((240.0 * roomscale) + arg0\Field3), 0.0, ((448.0 * roomscale) + arg0\Field5), 90.0, arg0, $00, $00, $00, (Str accesscode))
            positionentity(local0\Field3[$00], ((248.0 * roomscale) + arg0\Field3), entityy(local0\Field3[$00], $01), entityz(local0\Field3[$00], $01), $01)
            positionentity(local0\Field3[$01], ((232.0 * roomscale) + arg0\Field3), entityy(local0\Field3[$01], $01), entityz(local0\Field3[$01], $01), $01)
            local0\Field21 = $00
            local0\Field5 = $00
            local0 = createdoor(arg0\Field0, (arg0\Field3 - (496.0 * roomscale)), 0.0, arg0\Field5, 90.0, arg0, $00, $00, $00, "ABCD")
            positionentity(local0\Field3[$00], (arg0\Field3 - (488.0 * roomscale)), entityy(local0\Field3[$00], $01), entityz(local0\Field3[$00], $01), $01)
            positionentity(local0\Field3[$01], (arg0\Field3 - (504.0 * roomscale)), entityy(local0\Field3[$01], $01), entityz(local0\Field3[$01], $01), $01)
            local0\Field21 = $00
            local0\Field5 = $00
            local0\Field4 = $01
            local0 = createdoor(arg0\Field0, ((240.0 * roomscale) + arg0\Field3), 0.0, (arg0\Field5 - (576.0 * roomscale)), 90.0, arg0, $00, $00, $00, "7816")
            positionentity(local0\Field3[$00], ((248.0 * roomscale) + arg0\Field3), entityy(local0\Field3[$00], $01), entityz(local0\Field3[$00], $01), $01)
            positionentity(local0\Field3[$01], ((232.0 * roomscale) + arg0\Field3), entityy(local0\Field3[$01], $01), entityz(local0\Field3[$01], $01), $01)
            local0\Field21 = $00
            local0\Field5 = $00
            local4 = createitem("Mysterious Note", "paper", ((736.0 * roomscale) + arg0\Field3), ((224.0 * roomscale) + arg0\Field4), ((544.0 * roomscale) + arg0\Field5))
            entityparent(local4\Field0, arg0\Field2, $01)
            local4 = createitem("Ballistic Vest", "vest", ((608.0 * roomscale) + arg0\Field3), ((112.0 * roomscale) + arg0\Field4), ((32.0 * roomscale) + arg0\Field5))
            entityparent(local4\Field0, arg0\Field2, $01)
            rotateentity(local4\Field0, 0.0, 90.0, 0.0, $00)
            local4 = createitem("Incident Report SCP-106-0204", "paper", ((704.0 * roomscale) + arg0\Field3), ((183.0 * roomscale) + arg0\Field4), (arg0\Field5 - (576.0 * roomscale)))
            entityparent(local4\Field0, arg0\Field2, $01)
            local4 = createitem("First Aid Kit", "firstaid", ((912.0 * roomscale) + arg0\Field3), ((112.0 * roomscale) + arg0\Field4), (arg0\Field5 - (336.0 * roomscale)))
            entityparent(local4\Field0, arg0\Field2, $01)
            rotateentity(local4\Field0, 0.0, 90.0, 0.0, $00)
        Case "room2nuke"
            local0 = createdoor(arg0\Field0, ((576.0 * roomscale) + arg0\Field3), 0.0, (arg0\Field5 - (152.0 * roomscale)), 90.0, arg0, $00, $00, $05, "")
            local0\Field21 = $00
            local0\Field5 = $00
            positionentity(local0\Field3[$00], entityx(local0\Field3[$00], $01), entityy(local0\Field3[$00], $01), (arg0\Field5 - (284.0 * roomscale)), $01)
            positionentity(local0\Field3[$01], entityx(local0\Field3[$01], $01), entityy(local0\Field3[$01], $01), (arg0\Field5 - (284.0 * roomscale)), $01)
            local0 = createdoor(arg0\Field0, (arg0\Field3 - (544.0 * roomscale)), (1504.0 * roomscale), ((738.0 * roomscale) + arg0\Field5), 90.0, arg0, $00, $00, $05, "")
            local0\Field21 = $00
            local0\Field5 = $00
            positionentity(local0\Field3[$00], entityx(local0\Field3[$00], $01), entityy(local0\Field3[$00], $01), ((608.0 * roomscale) + arg0\Field5), $01)
            positionentity(local0\Field3[$01], entityx(local0\Field3[$01], $01), entityy(local0\Field3[$01], $01), ((608.0 * roomscale) + arg0\Field5), $01)
            arg0\Field12[$00] = createdoor(arg0\Field0, ((1192.0 * roomscale) + arg0\Field3), 0.0, arg0\Field5, 90.0, arg0, $01, $00, $00, "")
            arg0\Field12[$00]\Field21 = $00
            arg0\Field12[$00]\Field5 = $01
            arg0\Field11[$04] = createpivot($00)
            positionentity(arg0\Field11[$04], ((1496.0 * roomscale) + arg0\Field3), (240.0 * roomscale), arg0\Field5, $00)
            entityparent(arg0\Field11[$04], arg0\Field2, $01)
            arg0\Field12[$01] = createdoor(arg0\Field0, ((680.0 * roomscale) + arg0\Field3), (1504.0 * roomscale), arg0\Field5, 90.0, arg0, $00, $00, $00, "")
            arg0\Field12[$01]\Field21 = $00
            arg0\Field12[$01]\Field5 = $00
            arg0\Field11[$05] = createpivot($00)
            positionentity(arg0\Field11[$05], ((984.0 * roomscale) + arg0\Field3), (1744.0 * roomscale), arg0\Field5, $00)
            entityparent(arg0\Field11[$05], arg0\Field2, $01)
            For local23 = $00 To $01 Step $01
                arg0\Field11[(local23 Shl $01)] = loadmesh("GFX\map\leverbase.x", $00)
                arg0\Field11[((local23 Shl $01) + $01)] = loadmesh("GFX\map\leverhandle.x", $00)
                For local5 = $00 To $01 Step $01
                    scaleentity(arg0\Field11[((local23 Shl $01) + local5)], 0.04, 0.04, 0.04, $00)
                    positionentity(arg0\Field11[((local23 Shl $01) + local5)], (arg0\Field3 - (975.0 * roomscale)), ((1712.0 * roomscale) + arg0\Field4), (arg0\Field5 - ((502.0 - (132.0 * (Float local23))) * roomscale)), $01)
                    entityparent(arg0\Field11[((local23 Shl $01) + local5)], arg0\Field2, $01)
                Next
                rotateentity(arg0\Field11[(local23 Shl $01)], 0.0, -270.0, 0.0, $00)
                rotateentity(arg0\Field11[((local23 Shl $01) + $01)], 10.0, -450.0, 0.0, $00)
                entitypickmode(arg0\Field11[((local23 Shl $01) + $01)], $01, $00)
                entityradius(arg0\Field11[((local23 Shl $01) + $01)], 0.1, 0.0)
            Next
            local4 = createitem("Nuclear Device Document", "paper", (arg0\Field3 - (768.0 * roomscale)), ((1684.0 * roomscale) + arg0\Field4), (arg0\Field5 - (768.0 * roomscale)))
            entityparent(local4\Field0, arg0\Field2, $01)
            local4 = createitem("Ballistic Vest", "vest", (arg0\Field3 - (944.0 * roomscale)), ((1652.0 * roomscale) + arg0\Field4), (arg0\Field5 - (656.0 * roomscale)))
            entityparent(local4\Field0, arg0\Field2, $01)
            rotateentity(local4\Field0, 0.0, -90.0, 0.0, $00)
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
            arg0\Field12[$00]\Field21 = $00
            arg0\Field12[$00]\Field5 = $01
            positionentity(arg0\Field12[$00]\Field3[$01], ((224.0 * roomscale) + arg0\Field3), 0.7, ((480.0 * roomscale) + arg0\Field5), $01)
            positionentity(arg0\Field12[$00]\Field3[$00], ((304.0 * roomscale) + arg0\Field3), 0.7, ((832.0 * roomscale) + arg0\Field5), $01)
            arg0\Field12[$01] = createdoor(arg0\Field0, (arg0\Field3 - (2328.0 * roomscale)), (-2496.0 * roomscale), (arg0\Field5 - (656.0 * roomscale)), 90.0, arg0, $00, $00, $00, "")
            arg0\Field12[$01]\Field21 = $00
            arg0\Field12[$01]\Field5 = $00
            positionentity(arg0\Field12[$01]\Field3[$00], (arg0\Field3 - (2288.0 * roomscale)), entityy(arg0\Field12[$01]\Field3[$00], $01), (arg0\Field5 - (480.0 * roomscale)), $01)
            positionentity(arg0\Field12[$01]\Field3[$01], (arg0\Field3 - (2368.0 * roomscale)), entityy(arg0\Field12[$01]\Field3[$01], $01), (arg0\Field5 - (800.0 * roomscale)), $01)
            arg0\Field12[$02] = createdoor(arg0\Field0, (arg0\Field3 - (264.0 * roomscale)), 0.0, (arg0\Field5 - (656.0 * roomscale)), 90.0, arg0, $01, $00, $00, "")
            arg0\Field12[$02]\Field21 = $00
            arg0\Field12[$02]\Field5 = $01
            positionentity(arg0\Field12[$02]\Field3[$00], (arg0\Field3 - (224.0 * roomscale)), 0.7, (arg0\Field5 - (480.0 * roomscale)), $01)
            positionentity(arg0\Field12[$02]\Field3[$01], (arg0\Field3 - (304.0 * roomscale)), 0.7, (arg0\Field5 - (832.0 * roomscale)), $01)
            arg0\Field12[$03] = createdoor(arg0\Field0, ((2360.0 * roomscale) + arg0\Field3), (-2496.0 * roomscale), ((656.0 * roomscale) + arg0\Field5), 90.0, arg0, $00, $00, $00, "")
            arg0\Field12[$03]\Field21 = $00
            arg0\Field12[$03]\Field5 = $00
            positionentity(arg0\Field12[$03]\Field3[$01], ((2320.0 * roomscale) + arg0\Field3), entityy(arg0\Field12[$03]\Field3[$00], $01), ((480.0 * roomscale) + arg0\Field5), $01)
            positionentity(arg0\Field12[$03]\Field3[$00], ((2432.0 * roomscale) + arg0\Field3), entityy(arg0\Field12[$03]\Field3[$01], $01), ((816.0 * roomscale) + arg0\Field5), $01)
            local0 = createdoor($00, arg0\Field3, arg0\Field4, arg0\Field5, 0.0, arg0, $00, $01, $00, "ABCD")
            positionentity(local0\Field3[$00], ((224.0 * roomscale) + arg0\Field3), (arg0\Field4 + 0.7), (arg0\Field5 - (384.0 * roomscale)), $01)
            rotateentity(local0\Field3[$00], 0.0, -90.0, 0.0, $01)
            positionentity(local0\Field3[$01], (arg0\Field3 - (224.0 * roomscale)), (arg0\Field4 + 0.7), ((384.0 * roomscale) + arg0\Field5), $01)
            rotateentity(local0\Field3[$01], 0.0, 90.0, 0.0, $01)
            local4 = createitem("First Aid Kit", "firstaid", ((2848.0 * roomscale) + arg0\Field3), (arg0\Field4 - (2368.0 * roomscale)), (arg0\Field5 - (4568.0 * roomscale)))
            entityparent(local4\Field0, arg0\Field2, $01)
            rotateentity(local4\Field0, 0.0, 180.0, 0.0, $00)
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
            arg0\Field11[$00] = createpivot(arg0\Field2)
            positionentity(arg0\Field11[$00], ((368.0 * roomscale) + arg0\Field3), 0.0, arg0\Field5, $01)
            arg0\Field11[$01] = createpivot(arg0\Field2)
            positionentity(arg0\Field11[$01], (arg0\Field3 - (368.0 * roomscale)), 0.0, arg0\Field5, $01)
            arg0\Field11[$02] = createpivot(arg0\Field2)
            positionentity(arg0\Field11[$02], (((224.0 * roomscale) + arg0\Field3) - 0.005), (192.0 * roomscale), arg0\Field5, $01)
            arg0\Field11[$03] = createpivot(arg0\Field2)
            positionentity(arg0\Field11[$03], ((arg0\Field3 - (224.0 * roomscale)) + 0.005), (192.0 * roomscale), arg0\Field5, $01)
        Case "room3pit"
            local13 = createemitter(((512.0 * roomscale) + arg0\Field3), (-76.0 * roomscale), (arg0\Field5 - (688.0 * roomscale)), $00)
            turnentity(local13\Field0, -90.0, 0.0, 0.0, $00)
            entityparent(local13\Field0, arg0\Field2, $01)
            local13\Field10 = 35.0
            local13 = createemitter((arg0\Field3 - (512.0 * roomscale)), (-76.0 * roomscale), (arg0\Field5 - (688.0 * roomscale)), $00)
            turnentity(local13\Field0, -90.0, 0.0, 0.0, $00)
            entityparent(local13\Field0, arg0\Field2, $01)
            local13\Field10 = 35.0
        Case "room3servers"
            local4 = createitem("9V Battery", "bat", (arg0\Field3 - (132.0 * roomscale)), (arg0\Field4 - (368.0 * roomscale)), (arg0\Field5 - (648.0 * roomscale)))
            entityparent(local4\Field0, arg0\Field2, $01)
            If (rand($02, $01) = $01) Then
                local4 = createitem("9V Battery", "bat", (arg0\Field3 - (76.0 * roomscale)), (arg0\Field4 - (368.0 * roomscale)), (arg0\Field5 - (648.0 * roomscale)))
                entityparent(local4\Field0, arg0\Field2, $01)
            EndIf
            If (rand($02, $01) = $01) Then
                local4 = createitem("9V Battery", "bat", (arg0\Field3 - (196.0 * roomscale)), (arg0\Field4 - (368.0 * roomscale)), (arg0\Field5 - (648.0 * roomscale)))
                entityparent(local4\Field0, arg0\Field2, $01)
            EndIf
            local4 = createitem("S-NAV 300 Navigator", "nav", ((124.0 * roomscale) + arg0\Field3), (arg0\Field4 - (368.0 * roomscale)), (arg0\Field5 - (648.0 * roomscale)))
            local4\Field7 = 20.0
            entityparent(local4\Field0, arg0\Field2, $01)
            arg0\Field11[$00] = createpivot(arg0\Field2)
            positionentity(arg0\Field11[$00], ((736.0 * roomscale) + arg0\Field3), (-512.0 * roomscale), (arg0\Field5 - (400.0 * roomscale)), $01)
            arg0\Field11[$01] = createpivot(arg0\Field2)
            positionentity(arg0\Field11[$01], (arg0\Field3 - (552.0 * roomscale)), (-512.0 * roomscale), (arg0\Field5 - (528.0 * roomscale)), $01)
            arg0\Field11[$02] = createpivot(arg0\Field2)
            positionentity(arg0\Field11[$02], ((736.0 * roomscale) + arg0\Field3), (-512.0 * roomscale), ((272.0 * roomscale) + arg0\Field5), $01)
        Case "room3servers2"
            arg0\Field11[$00] = createpivot(arg0\Field2)
            positionentity(arg0\Field11[$00], (arg0\Field3 - (504.0 * roomscale)), (-512.0 * roomscale), ((271.0 * roomscale) + arg0\Field5), $01)
            arg0\Field11[$01] = createpivot(arg0\Field2)
            positionentity(arg0\Field11[$01], ((628.0 * roomscale) + arg0\Field3), (-512.0 * roomscale), ((271.0 * roomscale) + arg0\Field5), $01)
            arg0\Field11[$02] = createpivot(arg0\Field2)
            positionentity(arg0\Field11[$02], (arg0\Field3 - (532.0 * roomscale)), (-512.0 * roomscale), (arg0\Field5 - (877.0 * roomscale)), $01)
        Case "testroom"
            For local6 = $00 To $01 Step $01
                For local8 = $FFFFFFFF To $01 Step $01
                    arg0\Field11[((local6 * $03) + (local8 + $01))] = createpivot($00)
                    positionentity(arg0\Field11[((local6 * $03) + (local8 + $01))], ((((280.0 * (Float local6)) + -236.0) * roomscale) + arg0\Field3), (-700.0 * roomscale), (((384.0 * (Float local8)) * roomscale) + arg0\Field5), $00)
                    entityparent(arg0\Field11[((local6 * $03) + (local8 + $01))], arg0\Field2, $01)
                Next
            Next
            arg0\Field11[$06] = createpivot($00)
            positionentity(arg0\Field11[$06], ((754.0 * roomscale) + arg0\Field3), (arg0\Field4 - (1248.0 * roomscale)), arg0\Field5, $00)
            entityparent(arg0\Field11[$06], arg0\Field2, $01)
            local2 = createsecuritycam(((744.0 * roomscale) + arg0\Field3), (arg0\Field4 - (856.0 * roomscale)), ((236.0 * roomscale) + arg0\Field5), arg0, $00)
            local2\Field19 = $01
            local0 = createdoor(arg0\Field0, (arg0\Field3 - (624.0 * roomscale)), (-1280.0 * roomscale), arg0\Field5, 90.0, arg0, $01, $00, $00, "")
            local4 = createitem("Document SCP-682", "paper", ((656.0 * roomscale) + arg0\Field3), (arg0\Field4 - (1200.0 * roomscale)), (arg0\Field5 - (16.0 * roomscale)))
            entityparent(local4\Field0, arg0\Field2, $01)
        Case "room2closets"
            local4 = createitem("Document SCP-173", "paper", ((692.0 * roomscale) + arg0\Field3), ((172.0 * roomscale) + arg0\Field4), ((463.0 * roomscale) + arg0\Field5))
            entityparent(local4\Field0, arg0\Field2, $01)
            local4 = createitem("Gas Mask", "gasmask", ((698.0 * roomscale) + arg0\Field3), ((236.0 * roomscale) + arg0\Field4), ((623.0 * roomscale) + arg0\Field5))
            scaleentity(local4\Field0, 0.02, 0.02, 0.02, $00)
            entityparent(local4\Field0, arg0\Field2, $01)
            local4 = createitem("9V Battery", "bat", ((703.0 * roomscale) + arg0\Field3), ((184.0 * roomscale) + arg0\Field4), (arg0\Field5 - (501.0 * roomscale)))
            entityparent(local4\Field0, arg0\Field2, $01)
            If (rand($02, $01) = $01) Then
                local4 = createitem("9V Battery", "bat", ((695.0 * roomscale) + arg0\Field3), ((184.0 * roomscale) + arg0\Field4), (arg0\Field5 - (525.0 * roomscale)))
                entityparent(local4\Field0, arg0\Field2, $01)
            EndIf
            If (rand($02, $01) = $01) Then
                local4 = createitem("9V Battery", "bat", ((708.0 * roomscale) + arg0\Field3), ((184.0 * roomscale) + arg0\Field4), (arg0\Field5 - (565.0 * roomscale)))
                entityparent(local4\Field0, arg0\Field2, $01)
            EndIf
            local24 = createwaypoint(arg0\Field3, ((66.0 * roomscale) + arg0\Field4), ((292.0 * roomscale) + arg0\Field5), Null, arg0)
            local25 = createwaypoint(arg0\Field3, ((66.0 * roomscale) + arg0\Field4), (arg0\Field5 - (284.0 * roomscale)), Null, arg0)
            local24\Field4[$00] = local25
            local24\Field5[$00] = entitydistance(local24\Field0, local25\Field0)
            local25\Field4[$00] = local24
            local25\Field5[$00] = local24\Field5[$00]
        Case "room2offices"
            local4 = createitem("Document SCP-106", "paper", ((404.0 * roomscale) + arg0\Field3), ((145.0 * roomscale) + arg0\Field4), ((559.0 * roomscale) + arg0\Field5))
            entityparent(local4\Field0, arg0\Field2, $01)
            local4 = createitem("Level 2 Key Card", "key2", (arg0\Field3 - (156.0 * roomscale)), ((151.0 * roomscale) + arg0\Field4), ((72.0 * roomscale) + arg0\Field5))
            entityparent(local4\Field0, arg0\Field2, $01)
            local4 = createitem("S-NAV 300 Navigator", "nav", ((372.0 * roomscale) + arg0\Field3), ((153.0 * roomscale) + arg0\Field4), ((944.0 * roomscale) + arg0\Field5))
            local4\Field7 = 20.0
            entityparent(local4\Field0, arg0\Field2, $01)
            local4 = createitem("Notification", "paper", (arg0\Field3 - (137.0 * roomscale)), ((153.0 * roomscale) + arg0\Field4), ((464.0 * roomscale) + arg0\Field5))
            entityparent(local4\Field0, arg0\Field2, $01)
            local24 = createwaypoint((arg0\Field3 - (32.0 * roomscale)), ((66.0 * roomscale) + arg0\Field4), ((288.0 * roomscale) + arg0\Field5), Null, arg0)
            local25 = createwaypoint(arg0\Field3, ((66.0 * roomscale) + arg0\Field4), (arg0\Field5 - (448.0 * roomscale)), Null, arg0)
            local24\Field4[$00] = local25
            local24\Field5[$00] = entitydistance(local24\Field0, local25\Field0)
            local25\Field4[$00] = local24
            local25\Field5[$00] = local24\Field5[$00]
        Case "room2offices2"
            local4 = createitem("Level 1 Key Card", "key1", (arg0\Field3 - (368.0 * roomscale)), (arg0\Field4 - (48.0 * roomscale)), ((80.0 * roomscale) + arg0\Field5))
            local26 = loadtexture("GFX\items\keycard1.jpg", $01)
            entitytexture(local4\Field0, local26, $00, $00)
            entityparent(local4\Field0, arg0\Field2, $01)
            local4 = createitem("Document SCP-895", "paper", (arg0\Field3 - (800.0 * roomscale)), (arg0\Field4 - (48.0 * roomscale)), ((368.0 * roomscale) + arg0\Field5))
            entityparent(local4\Field0, arg0\Field2, $01)
            If (rand($02, $01) = $01) Then
                local4 = createitem("Document SCP-860", "paper", (arg0\Field3 - (800.0 * roomscale)), (arg0\Field4 - (48.0 * roomscale)), (arg0\Field5 - (464.0 * roomscale)))
            Else
                local4 = createitem("SCP-093 Recovered Materials", "paper", (arg0\Field3 - (800.0 * roomscale)), (arg0\Field4 - (48.0 * roomscale)), (arg0\Field5 - (464.0 * roomscale)))
            EndIf
            entityparent(local4\Field0, arg0\Field2, $01)
            local4 = createitem("S-NAV 300 Navigator", "nav", (arg0\Field3 - (336.0 * roomscale)), (arg0\Field4 - (48.0 * roomscale)), (arg0\Field5 - (480.0 * roomscale)))
            local4\Field7 = 28.0
            entityparent(local4\Field0, arg0\Field2, $01)
            arg0\Field11[$00] = loadmesh("GFX\npcs\duck_low_res.b3d", $00)
            scaleentity(arg0\Field11[$00], 0.07, 0.07, 0.07, $00)
            entityparent(arg0\Field11[$00], arg0\Field2, $01)
            arg0\Field11[$01] = createpivot(arg0\Field2)
            positionentity(arg0\Field11[$01], (arg0\Field3 - (808.0 * roomscale)), (-72.0 * roomscale), (arg0\Field5 - (40.0 * roomscale)), $01)
            arg0\Field11[$02] = createpivot(arg0\Field2)
            positionentity(arg0\Field11[$02], (arg0\Field3 - (488.0 * roomscale)), (160.0 * roomscale), ((700.0 * roomscale) + arg0\Field5), $01)
            arg0\Field11[$03] = createpivot(arg0\Field2)
            positionentity(arg0\Field11[$03], (arg0\Field3 - (488.0 * roomscale)), (160.0 * roomscale), (arg0\Field5 - (668.0 * roomscale)), $01)
            arg0\Field11[$04] = createpivot(arg0\Field2)
            positionentity(arg0\Field11[$04], (arg0\Field3 - (572.0 * roomscale)), (350.0 * roomscale), (arg0\Field5 - (4.0 * roomscale)), $01)
            local27 = rand($01, $04)
            positionentity(arg0\Field11[$00], entityx(arg0\Field11[local27], $01), entityy(arg0\Field11[local27], $01), entityz(arg0\Field11[local27], $01), $01)
        Case "room2offices3"
            If (rand($02, $01) = $01) Then
                local4 = createitem("Mobile Task Forces", "paper", ((744.0 * roomscale) + arg0\Field3), ((240.0 * roomscale) + arg0\Field4), ((944.0 * roomscale) + arg0\Field5))
                entityparent(local4\Field0, arg0\Field2, $01)
            Else
                local4 = createitem("Security Clearance Levels", "paper", ((680.0 * roomscale) + arg0\Field3), ((240.0 * roomscale) + arg0\Field4), ((944.0 * roomscale) + arg0\Field5))
                entityparent(local4\Field0, arg0\Field2, $01)
            EndIf
            local4 = createitem("Object Classes", "paper", ((160.0 * roomscale) + arg0\Field3), ((240.0 * roomscale) + arg0\Field4), ((568.0 * roomscale) + arg0\Field5))
            entityparent(local4\Field0, arg0\Field2, $01)
            local4 = createitem("Document", "paper", (arg0\Field3 - (1440.0 * roomscale)), ((624.0 * roomscale) + arg0\Field4), ((152.0 * roomscale) + arg0\Field5))
            entityparent(local4\Field0, arg0\Field2, $01)
            local4 = createitem("Radio Transceiver", "radio", (arg0\Field3 - (1184.0 * roomscale)), ((480.0 * roomscale) + arg0\Field4), (arg0\Field5 - (800.0 * roomscale)))
            entityparent(local4\Field0, arg0\Field2, $01)
            For local5 = $00 To rand($00, $01) Step $01
                local4 = createitem("ReVision Eyedrops", "eyedrops", (arg0\Field3 - (1529.0 * roomscale)), ((563.0 * roomscale) + arg0\Field4), ((arg0\Field5 - (572.0 * roomscale)) + ((Float local5) * 0.05)))
                entityparent(local4\Field0, arg0\Field2, $01)
            Next
            local4 = createitem("9V Battery", "bat", (arg0\Field3 - (1545.0 * roomscale)), ((603.0 * roomscale) + arg0\Field4), (arg0\Field5 - (372.0 * roomscale)))
            entityparent(local4\Field0, arg0\Field2, $01)
            If (rand($02, $01) = $01) Then
                local4 = createitem("9V Battery", "bat", (arg0\Field3 - (1540.0 * roomscale)), ((603.0 * roomscale) + arg0\Field4), (arg0\Field5 - (340.0 * roomscale)))
                entityparent(local4\Field0, arg0\Field2, $01)
            EndIf
            If (rand($02, $01) = $01) Then
                local4 = createitem("9V Battery", "bat", (arg0\Field3 - (1529.0 * roomscale)), ((603.0 * roomscale) + arg0\Field4), (arg0\Field5 - (308.0 * roomscale)))
                entityparent(local4\Field0, arg0\Field2, $01)
            EndIf
            arg0\Field12[$00] = createdoor(arg0\Field0, (arg0\Field3 - (1056.0 * roomscale)), (384.0 * roomscale), ((290.0 * roomscale) + arg0\Field5), 90.0, arg0, $01, $00, $00, "")
            arg0\Field12[$00]\Field21 = $00
            arg0\Field12[$00]\Field5 = $01
            positionentity(arg0\Field12[$00]\Field3[$00], entityx(arg0\Field12[$00]\Field3[$00], $01), entityy(arg0\Field12[$00]\Field3[$00], $01), ((161.0 * roomscale) + arg0\Field5), $01)
            positionentity(arg0\Field12[$00]\Field3[$01], entityx(arg0\Field12[$00]\Field3[$01], $01), entityy(arg0\Field12[$00]\Field3[$01], $01), ((161.0 * roomscale) + arg0\Field5), $01)
        Case "start"
            arg0\Field12[$01] = createdoor(arg0\Field0, ((288.0 * roomscale) + arg0\Field3), 0.0, ((384.0 * roomscale) + arg0\Field5), 90.0, arg0, $01, $01, $00, "")
            arg0\Field12[$01]\Field4 = $00
            arg0\Field12[$01]\Field21 = $00
            arg0\Field12[$01]\Field9 = $01
            arg0\Field12[$01]\Field5 = $01
            freeentity(arg0\Field12[$01]\Field3[$00])
            arg0\Field12[$01]\Field3[$00] = $00
            freeentity(arg0\Field12[$01]\Field3[$01])
            arg0\Field12[$01]\Field3[$01] = $00
            arg0\Field12[$02] = createdoor(arg0\Field0, (arg0\Field3 - (1008.0 * roomscale)), 0.0, (arg0\Field5 - (688.0 * roomscale)), 90.0, arg0, $01, $00, $00, "")
            arg0\Field12[$02]\Field21 = $00
            arg0\Field12[$02]\Field5 = $00
            arg0\Field12[$02]\Field4 = $01
            freeentity(arg0\Field12[$02]\Field3[$00])
            arg0\Field12[$02]\Field3[$00] = $00
            freeentity(arg0\Field12[$02]\Field3[$01])
            arg0\Field12[$02]\Field3[$01] = $00
        Case "coffin"
            local0 = createdoor(arg0\Field0, arg0\Field3, 0.0, (arg0\Field5 - (448.0 * roomscale)), 0.0, arg0, $00, $01, $02, "")
            local0\Field9 = $01
            local0\Field21 = $00
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
            local4 = createitem("Document SCP-895", "paper", (arg0\Field3 - (688.0 * roomscale)), ((133.0 * roomscale) + arg0\Field4), (arg0\Field5 - (304.0 * roomscale)))
            entityparent(local4\Field0, arg0\Field2, $01)
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
            entityblend(arg0\Field11[$03], local28)
            entityfx(arg0\Field11[$03], $19)
            positionentity(arg0\Field11[$03], arg0\Field3, 0.8, arg0\Field5, $00)
            hideentity(arg0\Field11[$03])
            entityparent(arg0\Field11[$03], arg0\Field2, $01)
        Case "room2doors"
            local0 = createdoor(arg0\Field0, arg0\Field3, 0.0, ((528.0 * roomscale) + arg0\Field5), 0.0, arg0, $01, $00, $00, "")
            local0\Field21 = $00
            positionentity(local0\Field3[$00], (arg0\Field3 - (832.0 * roomscale)), 0.7, ((160.0 * roomscale) + arg0\Field5), $01)
            positionentity(local0\Field3[$01], (arg0\Field3 - (224.0 * roomscale)), 0.7, ((896.0 * roomscale) + arg0\Field5), $01)
            rotateentity(local0\Field3[$01], 0.0, 90.0, 0.0, $01)
            local1 = createdoor(arg0\Field0, arg0\Field3, 0.0, (arg0\Field5 - (528.0 * roomscale)), 180.0, arg0, $01, $00, $00, "")
            local1\Field21 = $00
            freeentity(local1\Field3[$00])
            local1\Field3[$00] = $00
            positionentity(local1\Field3[$01], (arg0\Field3 - (224.0 * roomscale)), 0.7, (arg0\Field5 - (896.0 * roomscale)), $01)
            rotateentity(local1\Field3[$01], 0.0, 90.0, 0.0, $01)
            arg0\Field11[$00] = createpivot($00)
            positionentity(arg0\Field11[$00], (arg0\Field3 - (832.0 * roomscale)), 0.5, arg0\Field5, $00)
            entityparent(arg0\Field11[$00], arg0\Field2, $01)
            local1\Field22 = local0
            local0\Field22 = local1
            local0\Field5 = $00
            local1\Field5 = $01
        Case "914"
            local0 = createdoor(arg0\Field0, arg0\Field3, 0.0, (arg0\Field5 - (368.0 * roomscale)), 0.0, arg0, $00, $01, $02, "")
            local0\Field9 = $01
            local0\Field21 = $00
            local0\Field5 = $00
            positionentity(local0\Field3[$00], (arg0\Field3 - (496.0 * roomscale)), 0.7, (arg0\Field5 - (272.0 * roomscale)), $01)
            turnentity(local0\Field3[$00], 0.0, 90.0, 0.0, $00)
            arg0\Field11[$00] = loadmesh("GFX\map\914key.x", $00)
            arg0\Field11[$01] = loadmesh("GFX\map\914knob.x", $00)
            For local5 = $00 To $01 Step $01
                scaleentity(arg0\Field11[local5], roomscale, roomscale, roomscale, $00)
                entitypickmode(arg0\Field11[local5], $02, $01)
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
            local0\Field21 = $00
            local0 = createdoor(arg0\Field0, ((816.0 * roomscale) + arg0\Field3), 0.0, ((528.0 * roomscale) + arg0\Field5), 180.0, arg0, $01, $00, $00, "")
            freeentity(local0\Field1)
            local0\Field1 = $00
            freeentity(local0\Field3[$00])
            local0\Field3[$00] = $00
            freeentity(local0\Field3[$01])
            local0\Field3[$01] = $00
            arg0\Field12[$01] = local0
            local0\Field21 = $00
            arg0\Field11[$02] = createpivot($00)
            arg0\Field11[$03] = createpivot($00)
            positionentity(arg0\Field11[$02], (arg0\Field3 - (712.0 * roomscale)), 0.5, ((640.0 * roomscale) + arg0\Field5), $00)
            positionentity(arg0\Field11[$03], ((728.0 * roomscale) + arg0\Field3), 0.5, ((640.0 * roomscale) + arg0\Field5), $00)
            entityparent(arg0\Field11[$02], arg0\Field2, $01)
            entityparent(arg0\Field11[$03], arg0\Field2, $01)
            local4 = createitem("Note", "paper", ((954.0 * roomscale) + arg0\Field3), ((228.0 * roomscale) + arg0\Field4), ((127.0 * roomscale) + arg0\Field5))
            entityparent(local4\Field0, arg0\Field2, $01)
            local4 = createitem("First Aid Kit", "firstaid", ((960.0 * roomscale) + arg0\Field3), ((112.0 * roomscale) + arg0\Field4), (arg0\Field5 - (40.0 * roomscale)))
            entityparent(local4\Field0, arg0\Field2, $01)
            rotateentity(local4\Field0, 0.0, 90.0, 0.0, $00)
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
            For local5 = $00 To $05 Step $01
                entityparent(arg0\Field11[local5], arg0\Field2, $01)
            Next
            arg0\Field12[$00] = createdoor(arg0\Field0, entityx(arg0\Field2, $00), 0.0, (entityz(arg0\Field2, $00) - 4.0), 0.0, arg0, $00, $00, $00, "")
            arg0\Field12[$00]\Field4 = $01
            arg0\Field12[$00]\Field21 = $00
            arg0\Field12[$00]\Field5 = $00
            arg0\Field12[$01] = createdoor(arg0\Field0, (entityx(arg0\Field2, $00) + (288.0 * roomscale)), 0.0, (entityz(arg0\Field2, $00) + (384.0 * roomscale)), 90.0, arg0, $01, $01, $00, "")
            arg0\Field12[$01]\Field21 = $00
            arg0\Field12[$01]\Field9 = $01
            arg0\Field12[$01]\Field5 = $01
            freeentity(arg0\Field12[$01]\Field3[$00])
            arg0\Field12[$01]\Field3[$00] = $00
            freeentity(arg0\Field12[$01]\Field3[$01])
            arg0\Field12[$01]\Field3[$01] = $00
            local3 = createdecal(rand($04, $05), entityx(arg0\Field11[$05], $01), 0.002, entityz(arg0\Field11[$05], $01), 90.0, rnd(360.0, 0.0), 0.0)
            local3\Field2 = 1.2
            scalesprite(local3\Field0, local3\Field2, local3\Field2)
            For local6 = $00 To $01 Step $01
                For local8 = $00 To $01 Step $01
                    local3 = createdecal(rand($04, $06), ((((700.0 * roomscale) + arg0\Field3) + (((Float local6) * 700.0) * roomscale)) + rnd(-0.5, 0.5)), rnd(0.001, 0.0018), ((((Float ($258 * local8)) * roomscale) + arg0\Field5) + rnd(-0.5, 0.5)), 90.0, rnd(360.0, 0.0), 0.0)
                    local3\Field2 = rnd(0.5, 0.8)
                    local3\Field4 = rnd(0.8, 1.0)
                    scalesprite(local3\Field0, local3\Field2, local3\Field2)
                Next
            Next
            addlight(arg0, (arg0\Field3 - (224.0 * roomscale)), ((640.0 * roomscale) + arg0\Field4), ((128.0 * roomscale) + arg0\Field5), $02, 2.0, $C8, $C8, $C8)
            addlight(arg0, (arg0\Field3 - (1056.0 * roomscale)), ((608.0 * roomscale) + arg0\Field4), ((416.0 * roomscale) + arg0\Field5), $02, 2.0, $C8, $C8, $C8)
            arg0\Field12[$02] = createdoor(arg0\Field0, (arg0\Field3 - (1008.0 * roomscale)), 0.0, (arg0\Field5 - (688.0 * roomscale)), 90.0, arg0, $01, $00, $00, "")
            arg0\Field12[$02]\Field21 = $00
            arg0\Field12[$02]\Field5 = $00
            arg0\Field12[$02]\Field4 = $01
            freeentity(arg0\Field12[$02]\Field3[$00])
            arg0\Field12[$02]\Field3[$00] = $00
            freeentity(arg0\Field12[$02]\Field3[$01])
            arg0\Field12[$02]\Field3[$01] = $00
            arg0\Field12[$03] = createdoor(arg0\Field0, (arg0\Field3 - (2320.0 * roomscale)), 0.0, (arg0\Field5 - (1248.0 * roomscale)), 90.0, arg0, $01, $00, $00, "")
            arg0\Field12[$03]\Field21 = $00
            arg0\Field12[$03]\Field5 = $01
            arg0\Field12[$03]\Field4 = $01
            arg0\Field12[$04] = createdoor(arg0\Field0, (arg0\Field3 - (4352.0 * roomscale)), 0.0, (arg0\Field5 - (1248.0 * roomscale)), 90.0, arg0, $01, $00, $00, "")
            arg0\Field12[$04]\Field21 = $00
            arg0\Field12[$04]\Field5 = $01
            arg0\Field12[$04]\Field4 = $01
            arg0\Field12[$05] = createdoor(arg0\Field0, (arg0\Field3 - (5760.0 * roomscale)), 0.0, ((320.0 * roomscale) + arg0\Field5), 0.0, arg0, $01, $00, $00, "")
            arg0\Field12[$05]\Field21 = $00
            arg0\Field12[$05]\Field5 = $01
            arg0\Field12[$05]\Field4 = $01
            local0 = createdoor(arg0\Field0, (arg0\Field3 - (5760.0 * roomscale)), 0.0, ((1216.0 * roomscale) + arg0\Field5), 0.0, arg0, $00, $00, $00, "")
            local0\Field4 = $01
            local0\Field14 = $01
            local29 = loadtexture("GFX\map\Door02.jpg", $01)
            For local8 = $00 To $01 Step $01
                For local6 = $00 To $02 Step $01
                    local0 = createdoor(arg0\Field0, (arg0\Field3 - ((7424.0 - (512.0 * (Float local6))) * roomscale)), 0.0, (((1008.0 - (480.0 * (Float local8))) * roomscale) + arg0\Field5), (Float ((local8 = $00) * $B4)), arg0, $00, $00, $00, "")
                    entitytexture(local0\Field0, local29, $00, $00)
                    local0\Field4 = $01
                    freeentity(local0\Field1)
                    local0\Field1 = $00
                    freeentity(local0\Field3[$00])
                    local0\Field3[$00] = $00
                    freeentity(local0\Field3[$01])
                    local0\Field3[$01] = $00
                    local0\Field14 = $01
                Next
                For local6 = $00 To $06 Step $01
                    local0 = createdoor(arg0\Field0, (arg0\Field3 - ((5120.0 - (512.0 * (Float local6))) * roomscale)), 0.0, (((1008.0 - (480.0 * (Float local8))) * roomscale) + arg0\Field5), (Float ((local8 = $00) * $B4)), arg0, $00, $00, $00, "")
                    entitytexture(local0\Field0, local29, $00, $00)
                    local0\Field4 = $01
                    freeentity(local0\Field1)
                    local0\Field1 = $00
                    freeentity(local0\Field3[$00])
                    local0\Field3[$00] = $00
                    freeentity(local0\Field3[$01])
                    local0\Field3[$01] = $00
                    local0\Field14 = $01
                    If (((local6 = $04) And (local8 = $01)) <> 0) Then
                        arg0\Field12[$06] = local0
                    EndIf
                Next
            Next
            createitem("Class D Orientation Leaflet", "paper", (arg0\Field3 - (2914.0 * roomscale)), (170.0 * roomscale), ((40.0 * roomscale) + arg0\Field5))
        Case "room2ccont"
            local0 = createdoor(arg0\Field0, ((64.0 * roomscale) + arg0\Field3), 0.0, ((368.0 * roomscale) + arg0\Field5), 180.0, arg0, $00, $00, $01, "")
            local0\Field21 = $00
            local0\Field5 = $00
            local4 = createitem("Note from Daniel", "paper", (arg0\Field3 - (400.0 * roomscale)), (1040.0 * roomscale), ((115.0 * roomscale) + arg0\Field5))
            entityparent(local4\Field0, arg0\Field2, $01)
            For local23 = $00 To $02 Step $01
                arg0\Field11[(local23 Shl $01)] = loadmesh("GFX\map\leverbase.x", $00)
                arg0\Field11[((local23 Shl $01) + $01)] = loadmesh("GFX\map\leverhandle.x", $00)
                For local5 = $00 To $01 Step $01
                    scaleentity(arg0\Field11[((local23 Shl $01) + local5)], 0.04, 0.04, 0.04, $00)
                    positionentity(arg0\Field11[((local23 Shl $01) + local5)], (arg0\Field3 - (240.0 * roomscale)), ((1104.0 * roomscale) + arg0\Field4), (((632.0 - (64.0 * (Float local23))) * roomscale) + arg0\Field5), $01)
                    entityparent(arg0\Field11[((local23 Shl $01) + local5)], arg0\Field2, $01)
                Next
                rotateentity(arg0\Field11[(local23 Shl $01)], 0.0, -90.0, 0.0, $00)
                rotateentity(arg0\Field11[((local23 Shl $01) + $01)], 10.0, -270.0, 0.0, $00)
                entitypickmode(arg0\Field11[((local23 Shl $01) + $01)], $01, $00)
                entityradius(arg0\Field11[((local23 Shl $01) + $01)], 0.1, 0.0)
            Next
        Case "room106"
            local4 = createitem("Level 4 Key Card", "key4", (arg0\Field3 - (752.0 * roomscale)), (arg0\Field4 - (592.0 * roomscale)), ((3026.0 * roomscale) + arg0\Field5))
            entityparent(local4\Field0, arg0\Field2, $01)
            local0 = createdoor(arg0\Field0, (arg0\Field3 - (968.0 * roomscale)), (-764.0 * roomscale), ((1392.0 * roomscale) + arg0\Field5), 0.0, arg0, $00, $00, $03, "")
            local0\Field21 = $00
            local0\Field5 = $00
            local0 = createdoor(arg0\Field0, arg0\Field3, 0.0, (arg0\Field5 - (464.0 * roomscale)), 0.0, arg0, $00, $00, $03, "")
            local0\Field21 = $00
            local0\Field5 = $00
            local0 = createdoor(arg0\Field0, (arg0\Field3 - (624.0 * roomscale)), (-1280.0 * roomscale), arg0\Field5, 90.0, arg0, $00, $00, $04, "")
            local0\Field21 = $00
            local0\Field5 = $00
            arg0\Field11[$06] = loadmesh("GFX\map\room1062.b3d", $00)
            scaleentity(arg0\Field11[$06], roomscale, roomscale, roomscale, $00)
            entitytype(arg0\Field11[$06], $01, $00)
            entitypickmode(arg0\Field11[$06], $03, $01)
            positionentity(arg0\Field11[$06], ((784.0 * roomscale) + arg0\Field3), (-980.0 * roomscale), ((720.0 * roomscale) + arg0\Field5), $01)
            If (bumpenabled <> 0) Then
                For local5 = $01 To countsurfaces(arg0\Field11[$06]) Step $01
                    local18 = getsurface(arg0\Field11[$06], local5)
                    local19 = getsurfacebrush(local18)
                    local21 = getbrushtexture(local19, $01)
                    local30 = strippath(texturename(local21))
                    For local31 = Each materials
                        If (local30 = local31\Field0) Then
                            local9 = getbrushtexture(local19, $00)
                            local10 = getbrushtexture(local19, $01)
                            brushtexture(local19, local9, $00, $00)
                            brushtexture(local19, local31\Field2, $00, $01)
                            brushtexture(local19, local10, $00, $02)
                            paintsurface(local18, local19)
                            Exit
                        EndIf
                    Next
                Next
            EndIf
            entityparent(arg0\Field11[$06], arg0\Field2, $01)
            For local23 = $00 To $02 Step $02
                arg0\Field11[local23] = loadmesh("GFX\map\leverbase.x", $00)
                arg0\Field11[(local23 + $01)] = loadmesh("GFX\map\leverhandle.x", $00)
                For local5 = $00 To $01 Step $01
                    scaleentity(arg0\Field11[(local23 + local5)], 0.04, 0.04, 0.04, $00)
                    positionentity(arg0\Field11[(local23 + local5)], (arg0\Field3 - ((555.0 - (81.0 * (Float (local23 Sar $01)))) * roomscale)), (arg0\Field4 - (576.0 * roomscale)), ((3040.0 * roomscale) + arg0\Field5), $01)
                    entityparent(arg0\Field11[(local23 + local5)], arg0\Field2, $01)
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
            hideentity(arg0\Field13[$00]\Field0)
            arg0\Field11[$09] = createpivot(arg0\Field2)
            positionentity(arg0\Field11[$09], (arg0\Field3 - (272.0 * roomscale)), (arg0\Field4 - (672.0 * roomscale)), ((2736.0 * roomscale) + arg0\Field5), $01)
        Case "pocketdimension"
            local32 = loadmesh("GFX\map\pocketdimension2.b3d", $00)
            arg0\Field11[$08] = loadmesh("GFX\map\pocketdimension3.b3d", $00)
            arg0\Field11[$09] = loadmesh("GFX\map\pocketdimension4.b3d", $00)
            arg0\Field11[$0A] = copymesh(arg0\Field11[$09], $00)
            arg0\Field11[$0B] = loadmesh("GFX\map\pocketdimension5.b3d", $00)
            createitem("Burnt Note", "paper", entityx(arg0\Field2, $00), 0.5, (entityz(arg0\Field2, $00) + 3.5))
            For local23 = $00 To $04 Step $01
                Select local23
                    Case $00
                        local34 = local32
                    Case $01
                        local34 = arg0\Field11[$08]
                    Case $02
                        local34 = arg0\Field11[$09]
                    Case $03
                        local34 = arg0\Field11[$0A]
                    Case $04
                        local34 = arg0\Field11[$0B]
                End Select
                If (bumpenabled <> 0) Then
                    For local5 = $01 To countsurfaces(local34) Step $01
                        local18 = getsurface(local34, local5)
                        local19 = getsurfacebrush(local18)
                        local21 = getbrushtexture(local19, $01)
                        local30 = strippath(texturename(local21))
                        For local31 = Each materials
                            If (local30 = local31\Field0) Then
                                local9 = getbrushtexture(local19, $00)
                                local10 = getbrushtexture(local19, $01)
                                brushtexture(local19, local9, $00, $00)
                                brushtexture(local19, local31\Field2, $00, $01)
                                brushtexture(local19, local10, $00, $02)
                                paintsurface(local18, local19)
                                Exit
                            EndIf
                        Next
                    Next
                EndIf
            Next
            For local5 = $08 To $0B Step $01
                scaleentity(arg0\Field11[local5], roomscale, roomscale, roomscale, $00)
                entitytype(arg0\Field11[local5], $01, $00)
                entitypickmode(arg0\Field11[local5], $03, $01)
                positionentity(arg0\Field11[local5], arg0\Field3, arg0\Field4, (arg0\Field5 + 32.0), $01)
            Next
            scaleentity(arg0\Field11[$0A], (roomscale * 1.5), (roomscale * 2.0), (roomscale * 1.5), $01)
            positionentity(arg0\Field11[$0B], arg0\Field3, arg0\Field4, (arg0\Field5 + 64.0), $01)
            For local5 = $01 To $08 Step $01
                arg0\Field11[(local5 - $01)] = copymesh(local32, $00)
                scaleentity(arg0\Field11[(local5 - $01)], roomscale, roomscale, roomscale, $00)
                local35 = ((Float (local5 - $01)) * 45.0)
                entitytype(arg0\Field11[(local5 - $01)], $01, $00)
                entitypickmode(arg0\Field11[(local5 - $01)], $03, $01)
                rotateentity(arg0\Field11[(local5 - $01)], 0.0, (local35 - 90.0), 0.0, $00)
                positionentity(arg0\Field11[(local5 - $01)], (((512.0 * roomscale) * cos(local35)) + arg0\Field3), 0.0, (((512.0 * roomscale) * sin(local35)) + arg0\Field5), $00)
                entityparent(arg0\Field11[(local5 - $01)], arg0\Field2, $01)
                If (local5 < $06) Then
                    local3 = createdecal((local5 + $07), ((((512.0 * roomscale) * cos(local35)) * 3.0) + arg0\Field3), 0.02, ((((512.0 * roomscale) * sin(local35)) * 3.0) + arg0\Field5), 90.0, (local35 - 90.0), 0.0)
                    local3\Field2 = rnd(0.5, 0.5)
                    local3\Field5 = $02
                    local3\Field6 = $09
                    scalesprite(local3\Field0, local3\Field2, local3\Field2)
                    entityfx(local3\Field0, $09)
                    entityblend(local3\Field0, $02)
                EndIf
            Next
            For local5 = $0C To $10 Step $01
                arg0\Field11[local5] = createpivot(arg0\Field11[$0B])
                Select local5
                    Case $0C
                        positionentity(arg0\Field11[local5], arg0\Field3, ((200.0 * roomscale) + arg0\Field4), (arg0\Field5 + 64.0), $01)
                    Case $0D
                        positionentity(arg0\Field11[local5], ((390.0 * roomscale) + arg0\Field3), ((200.0 * roomscale) + arg0\Field4), ((arg0\Field5 + 64.0) + (272.0 * roomscale)), $01)
                    Case $0E
                        positionentity(arg0\Field11[local5], ((838.0 * roomscale) + arg0\Field3), ((200.0 * roomscale) + arg0\Field4), ((arg0\Field5 + 64.0) - (551.0 * roomscale)), $01)
                    Case $0F
                        positionentity(arg0\Field11[local5], (arg0\Field3 - (139.0 * roomscale)), ((200.0 * roomscale) + arg0\Field4), ((arg0\Field5 + 64.0) + (1201.0 * roomscale)), $01)
                    Case $10
                        positionentity(arg0\Field11[local5], (arg0\Field3 - (1238.0 * roomscale)), (arg0\Field4 - (1664.0 * roomscale)), ((arg0\Field5 + 64.0) + (381.0 * roomscale)), $01)
                End Select
            Next
            freetexture(local21)
            freeentity(local32)
    End Select
    For local37 = Each lighttemplates
        If (local37\Field0 = arg0\Field7) Then
            local38 = addlight(arg0, (arg0\Field3 + local37\Field2), (arg0\Field4 + local37\Field3), (arg0\Field5 + local37\Field4), local37\Field1, local37\Field5, local37\Field6, local37\Field7, local37\Field8)
            If (local38 <> $00) Then
                debuglog(((((((((((arg0\Field7\Field4 + " - ") + (Str local37\Field2)) + ", ") + (Str local37\Field3)) + ", ") + (Str local37\Field4)) + " - ") + (Str local37\Field5)) + ", ") + (Str local37\Field6)))
                If (local37\Field1 = $03) Then
                    lightconeangles(local38, (Float local37\Field11), local37\Field12)
                    rotateentity(local38, local37\Field9, local37\Field10, 0.0, $00)
                EndIf
            Else
                debuglog((arg0\Field7\Field4 + " - light error"))
            EndIf
        EndIf
    Next
    For local39 = Each tempscreens
        If (local39\Field4 = arg0\Field7) Then
            createscreen((arg0\Field3 + local39\Field1), (arg0\Field4 + local39\Field2), (arg0\Field5 + local39\Field3), local39\Field0, arg0)
        EndIf
    Next
    For local40 = Each tempwaypoints
        If (local40\Field3 = arg0\Field7) Then
            createwaypoint((arg0\Field3 + local40\Field0), (arg0\Field4 + local40\Field1), (arg0\Field5 + local40\Field2), Null, arg0)
        EndIf
    Next
    Return $00
End Function
