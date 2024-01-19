Function slidebar#(arg0%, arg1%, arg2%, arg3#)
    If (mousedown1 <> 0) Then
        If (((((mousex() >= arg0) And (mousex() <= ((arg0 + arg2) + $0E))) And (mousey() >= arg1)) And (mousey() <= (arg1 + $14))) <> 0) Then
            arg3 = min(max((Float (((mousex() - arg0) * $64) / arg2)), 0.0), 100.0)
        EndIf
    EndIf
    color($FF, $FF, $FF)
    rect(arg0, arg1, (arg2 + $0E), $14, $00)
    drawimage(blinkmeterimg, (Int (((((Float arg2) * arg3) / 100.0) + (Float arg0)) + 3.0)), (arg1 + $03), $00)
    Return arg3
    Return 0.0
End Function
