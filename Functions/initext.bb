Function initext%()
    If ("1.17" <> extversion()) Then
        runtimeerror((((("ERROR! FastExstension library - Incorrect versions for FastExt.dll (v" + extversion()) + ") And FastExt.bb (v") + "1.17") + ")"))
    Else
        debuglog("Init FastExtension library v1.17successful")
    EndIf
    If (fe_initextflag = $00) Then
        fe_initextflag = $01
        fe_pivotsys = createpivot($00)
        deinitpostprocess()
        initext_((Int systemproperty("Direct3DDevice7")), backbuffer(), gfxdrivercapsex)
    EndIf
    Return $00
End Function
