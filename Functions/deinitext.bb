Function deinitext%()
    If (fe_initextflag <> $00) Then
        fe_initextflag = $00
        setbuffer(backbuffer())
        deinitpostprocess()
        deinitext_()
    EndIf
    Return $00
End Function
