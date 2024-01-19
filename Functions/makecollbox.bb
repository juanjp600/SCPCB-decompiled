Function makecollbox%(arg0%)
    Local local0#
    Local local1#
    Local local2#
    local0 = entityscalex(arg0, $01)
    local1 = entityscaley(arg0, $01)
    local2 = entityscalez(arg0, $01)
    getmeshextents(arg0)
    entitybox(arg0, (mesh_minx * local0), (mesh_miny * local1), (mesh_minz * local2), (mesh_magx * local0), (mesh_magy * local1), (mesh_magz * local2))
    Return $00
End Function
