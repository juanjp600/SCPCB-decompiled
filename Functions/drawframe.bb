Function drawframe%(arg0%, arg1%, arg2%, arg3%)
    color($FF, $FF, $FF)
    drawtiledimagerect(menuwhite, $00, (arg1 Mod $100), 512.0, 512.0, arg0, arg1, arg2, arg3)
    color($00, $00, $00)
    rect((arg0 + $04), (arg1 + $04), (arg2 - $08), (arg3 - $08), $01)
    color($FF, $FF, $FF)
    Return $00
End Function
