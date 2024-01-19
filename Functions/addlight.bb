Function addlight%(arg0.rooms, arg1#, arg2#, arg3#, arg4%, arg5#, arg6%, arg7%, arg8%)
    Local local0%
    Local local1%
    For local0 = $00 To $13 Step $01
        If (arg0\Field6[local0] = $00) Then
            arg0\Field6[local0] = createlight(arg4, $00)
            lightrange(arg0\Field6[local0], arg5)
            lightcolor(arg0\Field6[local0], (Float arg6), (Float arg7), (Float arg8))
            positionentity(arg0\Field6[local0], arg1, arg2, arg3, $01)
            entityparent(arg0\Field6[local0], arg0\Field0, $01)
            local1 = createsprite($00)
            positionentity(local1, arg1, arg2, arg3, $00)
            scalesprite(local1, 0.13, 0.13)
            entitytexture(local1, lightspritetex($00), $00, $00)
            entityblend(local1, $03)
            entityparent(local1, arg0\Field0, $01)
            Return arg0\Field6[local0]
        EndIf
    Next
    Return $00
End Function
