Function createnpc.npcs(arg0%, arg1#, arg2#, arg3#)
    Local local0.npcs
    Local local1#
    Local local3%
    Local local4%
    Local local5%
    Local local6%
    Local local7%
    Local local8%
    local0 = (New npcs)
    local0\Field3 = arg0
    Select arg0
        Case $01
            local0\Field2 = createpivot($00)
            entityradius(local0\Field2, 0.32, 0.0)
            entitytype(local0\Field2, $02, $00)
            local0\Field5 = $01
            local0\Field0 = loadmesh("GFX\npcs\173mesh.3ds", $00)
            scaleentity(local0\Field0, (0.35 / meshdepth(local0\Field0)), (0.35 / meshdepth(local0\Field0)), (0.35 / meshdepth(local0\Field0)), $00)
            If (bumpenabled <> 0) Then
                local3 = loadtexture("GFX\npcs\173tex2.jpg", $01)
                local4 = loadtexture("GFX\npcs\173_norm.jpg", $01)
                local5 = loadtexture("GFX\npcs\173_spec.jpg", $01)
                textureblend(local4, $1603)
                textureblend(local5, $1200)
                entitytexture(local0\Field0, local4, $00, $00)
                entitytexture(local0\Field0, local5, $00, $01)
                entitytexture(local0\Field0, local3, $00, $02)
            EndIf
            local0\Field11 = (getinifloat("DATA\SCPs.ini", "SCP-173", "speed") / 100.0)
        Case $02
            local0\Field2 = createpivot($00)
            entityradius(local0\Field2, 0.2, 0.0)
            entitytype(local0\Field2, $02, $00)
            local0\Field0 = loadanimmesh("GFX\npcs\106.b3d", $00)
            local0\Field6 = 20.0
            local1 = (0.25 / meshwidth(local0\Field0))
            scaleentity(local0\Field0, local1, local1, local1, $00)
            local6 = loadtexture("GFX\npcs\oldmaneyes.jpg", $01)
            local0\Field11 = (getinifloat("DATA\SCPs.ini", "SCP-106", "speed") / 100.0)
            local0\Field1 = createsprite($00)
            scalesprite(local0\Field1, 0.03, 0.03)
            entitytexture(local0\Field1, local6, $00, $00)
            entityblend(local0\Field1, local7)
            entityfx(local0\Field1, $09)
            spriteviewmode(local0\Field1, $02)
        Case $03
            local0\Field2 = createpivot($00)
            entityradius(local0\Field2, 0.2, 0.0)
            entitytype(local0\Field2, $02, $00)
            local0\Field0 = loadanimmesh("GFX\npcs\guard.b3d", $00)
            local1 = (0.4 / meshwidth(local0\Field0))
            scaleentity(local0\Field0, local1, local1, local1, $00)
        Case $04
            local0\Field2 = createpivot($00)
            entityradius(local0\Field2, 0.32, 0.0)
            entitytype(local0\Field2, $02, $00)
            local0\Field0 = loadanimmesh("GFX\npcs\106.b3d", $00)
            local8 = loadtexture("GFX\npcs\classd.jpg", $01)
            entitytexture(local0\Field0, local8, $00, $00)
            local0\Field6 = 200.0
            local1 = (0.25 / meshwidth(local0\Field0))
            scaleentity(local0\Field0, local1, local1, local1, $00)
        Case $06
            local0\Field2 = createpivot($00)
            entityradius(local0\Field2, 0.2, 0.0)
            local0\Field0 = loadanimmesh("GFX\npcs\372.b3d", $00)
            local1 = (0.35 / meshwidth(local0\Field0))
            scaleentity(local0\Field0, local1, local1, local1, $00)
    End Select
    positionentity(local0\Field2, arg1, arg2, arg3, $00)
    positionentity(local0\Field0, arg1, arg2, arg3, $00)
    resetentity(local0\Field2)
    Return local0
    Return Null
End Function
