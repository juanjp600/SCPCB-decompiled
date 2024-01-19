Function loadroommeshes%()
    Local local0%
    Local local1.roomtemplates
    Local local2%
    Local local3%
    local0 = $00
    For local1 = Each roomtemplates
        local0 = (local0 + $01)
    Next
    local2 = $00
    For local1 = Each roomtemplates
        local1\Field0 = loadworld(local1\Field2, local1)
        If (local1\Field0 = $00) Then
            runtimeerror((((("Failed to load map file " + chr($22)) + (Str local3)) + chr($22)) + "."))
        EndIf
        hideentity(local1\Field0)
        drawloading((Int (((20.0 / (Float local0)) * (Float local2)) + 40.0)))
        local2 = (local2 + $01)
    Next
    Return $00
End Function
