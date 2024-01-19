Function createnpc.npcs(arg0%, arg1#, arg2#, arg3#)
    Local local0.npcs
    Local local1.npcs
    Local local2#
    Local local3%
    Local local4%
    Local local5%
    Local local6%
    Local local7%
    Local local8%
    Local local9%
    Local local10%
    Local local11%
    Local local12%
    Local local14%
    Local local16%
    Local local17%
    Local local18%
    Local local19%
    Local local20%
    Local local21%
    Local local22%
    local0 = (New npcs)
    local0\Field5 = arg0
    Select arg0
        Case $01
            local0\Field4 = createpivot($00)
            entityradius(local0\Field4, 0.32, 0.0)
            entitytype(local0\Field4, $02, $00)
            local0\Field8 = $01
            local0\Field0 = loadmesh("GFX\npcs\173.3ds", $00)
            local2 = (getinifloat("DATA\NPCs.ini", "SCP-173", "scale") / meshdepth(local0\Field0))
            scaleentity(local0\Field0, local2, local2, local2, $00)
            If (bumpenabled <> 0) Then
                local4 = loadtexture("GFX\npcs\173tex2.jpg", $01)
                local5 = loadtexture("GFX\npcs\173_norm.jpg", $01)
                local6 = loadtexture("GFX\npcs\173_spec.jpg", $01)
                textureblend(local5, $1603)
                textureblend(local6, $1200)
                entitytexture(local0\Field0, local6, $00, $00)
                entitytexture(local0\Field0, local5, $00, $01)
                entitytexture(local0\Field0, local4, $00, $02)
            EndIf
            local0\Field17 = (getinifloat("DATA\NPCs.ini", "SCP-173", "speed") / 100.0)
        Case $02
            local0\Field4 = createpivot($00)
            entityradius(local0\Field4, 0.2, 0.0)
            entitytype(local0\Field4, $02, $00)
            local0\Field0 = loadanimmesh("GFX\npcs\106.b3d", $00)
            local0\Field9 = 20.0
            If (bumpenabled <> 0) Then
                local7 = loadtexture("GFX\npcs\oldmanbump.jpg", $01)
                local8 = loadtexture("GFX\npcs\oldmanfacebump.jpg", $01)
                textureblend(local7, $1603)
                textureblend(local8, $1603)
                local14 = createtexture($100, $100, $41, $01)
                textureblend(local14, $03)
                setbuffer(texturebuffer(local14, $00))
                clscolor($96, $96, $96, $FF, 1.0)
                cls($01, $01)
                setbuffer(backbuffer())
                clscolor($00, $00, $00, $FF, 1.0)
                For local3 = $01 To countsurfaces(local0\Field0) Step $01
                    local10 = getsurface(local0\Field0, local3)
                    local11 = getsurfacebrush(local10)
                    local12 = getbrushtexture(local11, $00)
                    Select lower(strippath(texturename(local12)))
                        Case "oldman.jpg"
                            texturefilter((Str local12), $40)
                            brushtexture(local11, local14, $00, $00)
                            brushtexture(local11, local7, $00, $01)
                            brushtexture(local11, local12, $00, $02)
                            paintsurface(local10, local11)
                            If (strippath(texturename(local12)) <> "") Then
                                freetexture(local12)
                            EndIf
                            freetexture(local16)
                            freebrush(local11)
                        Case "oldmanface.jpg"
                            texturefilter((Str local12), $40)
                            brushtexture(local11, local14, $00, $00)
                            brushtexture(local11, local8, $00, $01)
                            brushtexture(local11, local12, $00, $02)
                            paintsurface(local10, local11)
                            If (strippath(texturename(local12)) <> "") Then
                                freetexture(local12)
                            EndIf
                            freetexture(local16)
                            freebrush(local11)
                    End Select
                Next
            EndIf
            local2 = (getinifloat("DATA\NPCs.ini", "SCP-106", "scale") / 2.56)
            scaleentity(local0\Field0, local2, local2, local2, $00)
            local17 = loadtexture("GFX\npcs\oldmaneyes.jpg", $01)
            local0\Field17 = (getinifloat("DATA\NPCs.ini", "SCP-106", "speed") / 100.0)
            local0\Field1 = createsprite($00)
            scalesprite(local0\Field1, 0.03, 0.03)
            entitytexture(local0\Field1, local17, $00, $00)
            entityblend(local0\Field1, local18)
            entityfx(local0\Field1, $09)
            spriteviewmode(local0\Field1, $02)
        Case $03
            local0\Field4 = createpivot($00)
            entityradius(local0\Field4, 0.15, 0.0)
            entitytype(local0\Field4, $02, $00)
            local0\Field0 = loadmesh("GFX\npcs\guard.3ds", $00)
            local0\Field17 = (getinifloat("DATA\NPCs.ini", "Guard", "speed") / 100.0)
            local2 = (getinifloat("DATA\NPCs.ini", "Guard", "scale") / 21.3)
            scaleentity(local0\Field0, local2, local2, local2, $00)
        Case $08
            local0\Field4 = createpivot($00)
            entityradius(local0\Field4, 0.2, 0.0)
            entitytype(local0\Field4, $02, $00)
            local0\Field0 = loadanimmesh("GFX\npcs\mtf.b3d", $00)
            local0\Field17 = (getinifloat("DATA\NPCs.ini", "MTF", "speed") / 100.0)
            local2 = ((getinifloat("DATA\NPCs.ini", "MTF", "scale") / meshwidth(local0\Field0)) * 4.0)
            scaleentity(local0\Field0, local2, local2, local2, $00)
        Case $04
            local0\Field4 = createpivot($00)
            entityradius(local0\Field4, 0.32, 0.0)
            entitytype(local0\Field4, $02, $00)
            local0\Field0 = loadanimmesh("GFX\npcs\106.b3d", $00)
            local19 = loadtexture("GFX\npcs\classd.jpg", $01)
            entitytexture(local0\Field0, local19, $00, $00)
            local0\Field9 = 200.0
            local2 = (0.25 / meshwidth(local0\Field0))
            scaleentity(local0\Field0, local2, local2, local2, $00)
        Case $06
            local0\Field4 = createpivot($00)
            entityradius(local0\Field4, 0.2, 0.0)
            local0\Field0 = loadanimmesh("GFX\npcs\372.b3d", $00)
            local2 = (0.35 / meshwidth(local0\Field0))
            scaleentity(local0\Field0, local2, local2, local2, $00)
        Case $07
            local0\Field4 = createpivot($00)
            entityradius(local0\Field4, 0.2, 0.0)
            local0\Field0 = loadanimmesh("GFX\apache.b3d", $00)
            local0\Field1 = loadanimmesh("GFX\apacherotor.b3d", local0\Field0)
            For local3 = $FFFFFFFF To $01 Step $02
                local20 = copyentity(local0\Field1, local0\Field1)
                rotateentity(local20, 0.0, (4.0 * (Float local3)), 0.0, $00)
                entityalpha(local20, 0.5)
            Next
            local0\Field2 = loadanimmesh("GFX\apacherotor2.b3d", local0\Field0)
            positionentity(local0\Field2, 0.0, 2.15, -5.48, $00)
            For local3 = $FFFFFFFF To $01 Step $02
                local21 = createlight($02, local0\Field0)
                lightrange(local21, 2.0)
                lightcolor(local21, 255.0, 255.0, 255.0)
                positionentity(local21, (1.65 * (Float local3)), 1.17, -0.25, $00)
                local22 = createsprite(local0\Field0)
                positionentity(local22, (1.65 * (Float local3)), 1.17, 0.0, $00)
                scalesprite(local22, 0.13, 0.13)
                entitytexture(local22, lightspritetex($00), $00, $00)
                entityblend(local22, $03)
                entityfx(local22, $09)
            Next
            local2 = 0.6
            scaleentity(local0\Field0, local2, local2, local2, $00)
    End Select
    positionentity(local0\Field4, arg1, arg2, arg3, $00)
    positionentity(local0\Field0, arg1, arg2, arg3, $00)
    resetentity(local0\Field4)
    local2 = 1.0
    For local1 = Each npcs
        If (local1\Field6 > $00) Then
            local2 = (local2 + 1.0)
        EndIf
    Next
    local0\Field6 = (Int local2)
    Return local0
    Return Null
End Function
