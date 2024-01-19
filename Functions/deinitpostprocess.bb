Function deinitpostprocess%()
    If (fe_initpostprocessflag <> $00) Then
        If (fe_postprocesstexture1 <> $00) Then
            freetexture(fe_postprocesstexture1)
        EndIf
        If (fe_postprocesstexture2 <> $00) Then
            freetexture(fe_postprocesstexture2)
        EndIf
        If (fe_postprocesstexture3 <> $00) Then
            freetexture(fe_postprocesstexture3)
        EndIf
        If (fe_postprocesstexture4 <> $00) Then
            freetexture(fe_postprocesstexture4)
        EndIf
        If (fe_postprocesstexture5 <> $00) Then
            freetexture(fe_postprocesstexture5)
        EndIf
        fe_initpostprocessflag = $00
    EndIf
    Return $00
End Function
