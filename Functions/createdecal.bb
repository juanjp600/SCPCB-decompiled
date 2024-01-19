Function createdecal.decals(arg0%, arg1#, arg2#, arg3#, arg4#, arg5#, arg6#)
    Local local0.decals
    local0 = (New decals)
    local0\Field10 = arg1
    local0\Field11 = arg2
    local0\Field12 = arg3
    local0\Field13 = arg4
    local0\Field14 = arg5
    local0\Field15 = arg6
    local0\Field4 = 1.0
    local0\Field2 = 1.0
    local0\Field0 = createsprite($00)
    local0\Field5 = $01
    entitytexture(local0\Field0, decaltextures(arg0), $00, $00)
    entityfx(local0\Field0, $00)
    spriteviewmode(local0\Field0, $02)
    positionentity(local0\Field0, arg1, arg2, arg3, $00)
    rotateentity(local0\Field0, arg4, arg5, arg6, $00)
    local0\Field7 = arg0
    If (((decaltextures(arg0) = $00) Or (local0\Field0 = $00)) <> 0) Then
        Return Null
    EndIf
    Return local0
    Return Null
End Function
