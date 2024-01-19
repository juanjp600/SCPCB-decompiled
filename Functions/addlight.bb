Function addlight%(arg0.rooms, arg1#, arg2#, arg3#, arg4%, arg5#, arg6%, arg7%, arg8%)
    Local local0%
    For local0 = $00 To $13 Step $01
        If (arg0\Field8[local0] = $00) Then
            arg0\Field8[local0] = createlight(arg4, $00)
            lightrange(arg0\Field8[local0], arg5)
            lightcolor(arg0\Field8[local0], (Float arg6), (Float arg7), (Float arg8))
            positionentity(arg0\Field8[local0], arg1, arg2, arg3, $01)
            entityparent(arg0\Field8[local0], arg0\Field2, $01)
            arg0\Field9[local0] = (((Float ((arg6 + arg7) + arg8)) / 255.0) / 3.0)
            arg0\Field10[local0] = createsprite($00)
            positionentity(arg0\Field10[local0], arg1, arg2, arg3, $00)
            scalesprite(arg0\Field10[local0], 0.13, 0.13)
            entitytexture(arg0\Field10[local0], lightspritetex($00), $00, $00)
            entityblend(arg0\Field10[local0], $03)
            entityparent(arg0\Field10[local0], arg0\Field2, $01)
            Return arg0\Field8[local0]
        EndIf
    Next
    Return $00
End Function
