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
    Local local15%
    Local local16%
    Local local17$
    Local local18%
    Local local19%
    Local local20%
    local0 = (New npcs)
    local0\Field5 = arg0
    Select arg0
        Case $01
            local0\Field4 = createpivot($00)
            entityradius(local0\Field4, 0.32, 0.0)
            entitytype(local0\Field4, $02, $00)
            local0\Field8 = $01
            local0\Field0 = loadanimmesh("GFX\npcs\173_2.b3d", $00)
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
            setanimtime(local0\Field0, 68.0, $00)
            local0\Field17 = (getinifloat("DATA\NPCs.ini", "SCP-173", "speed") / 100.0)
        Case $02
            local0\Field4 = createpivot($00)
            entityradius(local0\Field4, 0.2, 0.0)
            entitytype(local0\Field4, $02, $00)
            local0\Field0 = loadanimmesh("GFX\npcs\106_2.b3d", $00)
            If (bumpenabled <> 0) Then
                local4 = loadtexture("GFX\npcs\106_diffuse.png", $01)
                local5 = loadtexture("GFX\npcs\106_normals.png", $01)
                textureblend(local5, $1603)
                entitytexture(local0\Field0, local5, $00, $00)
                entitytexture(local0\Field0, local4, $00, $01)
            EndIf
            local2 = (getinifloat("DATA\NPCs.ini", "SCP-106", "scale") / 2.2)
            scaleentity(local0\Field0, local2, local2, local2, $00)
            local14 = loadtexture("GFX\npcs\oldmaneyes.jpg", $01)
            local0\Field17 = (getinifloat("DATA\NPCs.ini", "SCP-106", "speed") / 100.0)
            local0\Field1 = createsprite($00)
            scalesprite(local0\Field1, 0.03, 0.03)
            entitytexture(local0\Field1, local14, $00, $00)
            entityblend(local0\Field1, local15)
            entityfx(local0\Field1, $09)
            spriteviewmode(local0\Field1, $02)
        Case $03
            local0\Field4 = createpivot($00)
            entityradius(local0\Field4, 0.2, 0.0)
            entitytype(local0\Field4, $02, $00)
            local0\Field0 = loadanimmesh("GFX\npcs\mtf.b3d", $00)
            local0\Field17 = (getinifloat("DATA\NPCs.ini", "Guard", "speed") / 100.0)
            local2 = ((getinifloat("DATA\NPCs.ini", "Guard", "scale") / 15.64) * 4.0)
            local16 = loadtexture("GFX\npcs\body.jpg", $01)
            For local3 = $01 To countsurfaces(local0\Field0) Step $01
                local10 = getsurface(local0\Field0, local3)
                local11 = getsurfacebrush(local10)
                local12 = getbrushtexture(local11, $00)
                debuglog(strippath(texturename(local12)))
                local17 = lower(strippath(texturename(local12)))
                If (local17 = "mtfbody.jpg") Then
                    texturefilter((Str local12), $40)
                    brushtexture(local11, local16, $00, $00)
                    paintsurface(local10, local11)
                    If (strippath(texturename(local12)) <> "") Then
                        freetexture(local12)
                    EndIf
                    freebrush(local11)
                EndIf
            Next
            scaleentity(local0\Field0, local2, local2, local2, $00)
        Case $08
            local0\Field4 = createpivot($00)
            entityradius(local0\Field4, 0.2, 0.0)
            entitytype(local0\Field4, $02, $00)
            local0\Field0 = loadanimmesh("GFX\npcs\mtf.b3d", $00)
            local0\Field17 = (getinifloat("DATA\NPCs.ini", "MTF", "speed") / 100.0)
            local2 = ((getinifloat("DATA\NPCs.ini", "MTF", "scale") / 15.64) * 4.0)
            scaleentity(local0\Field0, local2, local2, local2, $00)
        Case $04
            local0\Field4 = createpivot($00)
            entityradius(local0\Field4, 0.32, 0.0)
            entitytype(local0\Field4, $02, $00)
            local0\Field0 = loadanimmesh("GFX\npcs\classd.b3d", $00)
            local0\Field9 = 200.0
            local2 = (0.25 / meshwidth(local0\Field0))
            scaleentity(local0\Field0, local2, local2, local2, $00)
        Case $06
            local0\Field4 = createpivot($00)
            entityradius(local0\Field4, 0.2, 0.0)
            local0\Field0 = loadanimmesh("GFX\npcs\372.b3d", $00)
            local2 = (0.35 / meshwidth(local0\Field0))
            scaleentity(local0\Field0, local2, local2, local2, $00)
        Case $09
            local0\Field4 = createpivot($00)
            entityradius(local0\Field4, 0.2, 0.0)
            entitytype(local0\Field4, $02, $00)
            local0\Field0 = loadanimmesh("GFX\npcs\tsg_placeholder.b3d", $00)
            local0\Field17 = (getinifloat("DATA\NPCs.ini", "SCP-096", "speed") / 45.0)
            local2 = (getinifloat("DATA\NPCs.ini", "SCP-096", "scale") / 7.5)
            scaleentity(local0\Field0, local2, local2, local2, $00)
        Case $07
            local0\Field4 = createpivot($00)
            entityradius(local0\Field4, 0.2, 0.0)
            local0\Field0 = loadanimmesh("GFX\apache.b3d", $00)
            local0\Field1 = loadanimmesh("GFX\apacherotor.b3d", local0\Field0)
            For local3 = $FFFFFFFF To $01 Step $02
                local18 = copyentity(local0\Field1, local0\Field1)
                rotateentity(local18, 0.0, (4.0 * (Float local3)), 0.0, $00)
                entityalpha(local18, 0.5)
            Next
            local0\Field2 = loadanimmesh("GFX\apacherotor2.b3d", local0\Field0)
            positionentity(local0\Field2, 0.0, 2.15, -5.48, $00)
            entitytype(local0\Field4, $04, $00)
            entityradius(local0\Field4, 3.0, 0.0)
            For local3 = $FFFFFFFF To $01 Step $02
                local19 = createlight($02, local0\Field0)
                lightrange(local19, 2.0)
                lightcolor(local19, 255.0, 255.0, 255.0)
                positionentity(local19, (1.65 * (Float local3)), 1.17, -0.25, $00)
                local20 = createsprite(local0\Field0)
                positionentity(local20, (1.65 * (Float local3)), 1.17, 0.0, $00)
                scalesprite(local20, 0.13, 0.13)
                entitytexture(local20, lightspritetex($00), $00, $00)
                entityblend(local20, $03)
                entityfx(local20, $09)
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
