Function drawloading%(arg0%)
    Local local0%
    Local local1%
    Local local2%
    Local local3%
    Local local4%
    If (arg0 = $00) Then
        If (rand($0A, $01) = $01) Then
            drawcwm = $01
        Else
            drawcwm = $00
        EndIf
    EndIf
    color($FF, $FF, $FF)
    cls($01, $00)
    setfont(font1)
    text((graphicwidth Sar $01), (graphicheight Sar $01), (("LOADING - " + (Str arg0)) + " %"), $01, $01)
    If (drawcwm <> 0) Then
        drawimage(cwmimg, (graphicwidth - $17C), (graphicheight - $20D), $00)
    EndIf
    local0 = $12C
    local1 = $14
    local2 = ((graphicwidth Sar $01) - (local0 Sar $01))
    local3 = ((graphicheight Sar $01) + $1E)
    rect(local2, local3, local0, local1, $00)
    For local4 = $01 To (Int ((((Float arg0) / 100.0) * (Float (local0 - $02))) / 10.0)) Step $01
        drawimage(blinkmeterimg, ((local2 + $03) + ((local4 - $01) * $0A)), (local3 + $03), $00)
    Next
    flip($01)
    Return $00
End Function
