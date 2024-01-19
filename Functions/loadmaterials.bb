Function loadmaterials%(arg0$)
    Local local0$
    Local local1%
    Local local2%
    Local local3%
    Local local4.materials
    Local local5$
    Local local6%
    local4 = Null
    local5 = ""
    local6 = openfile(arg0)
    While (eof(local6) = $00)
        local0 = trim(readline(local6))
        If (left(local0, $01) = "[") Then
            local0 = mid(local0, $02, (len(local0) - $02))
            local4 = (New materials)
            local4\Field0 = lower(local0)
            local4\Field1 = loadtexture(getinistring(arg0, local0, "diff"), $01)
            local4\Field2 = loadtexture(getinistring(arg0, local0, "bump"), $01)
            textureblend(local4\Field2, $1603)
        EndIf
    Wend
    closefile(local6)
    Return $00
End Function
