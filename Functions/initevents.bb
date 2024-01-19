Function initevents%()
    createevent("room173", "room173", $00, 0.0)
    createevent("alarm", "start", $00, 0.0)
    createevent("pocketdimension", "pocketdimension", $00, 0.0)
    createevent("tunnel106", "tunnel", $00, 0.07)
    If (rand($03, $01) < $03) Then
        createevent("lockroom173", "lockroom", $00, 0.0)
    EndIf
    createevent("lockroom173", "lockroom", $00, 0.3)
    createevent("room2doors173", "room2doors", $00, 0.3)
    createevent("testroom173", "room2testroom2", $00, 0.0)
    If (rand($03, $01) < $03) Then
        createevent("coffin106", "coffin", $00, 0.0)
    Else
        createevent("coffin", "coffin", $00, 0.0)
    EndIf
    createevent("pj", "roompj", $00, 0.0)
    createevent("914", "914", $00, 0.0)
    createevent("buttghost", "room2toilets", $00, 0.8)
    createevent("room2pipes106", "room2pipes", rand($00, $03), 0.0)
    createevent("room2pit", "room2pit", $00, 0.3)
    createevent("testroom", "testroom", $00, 0.0)
    If (rand($04, $01) < $04) Then
    EndIf
    createevent("room2ccont", "room2ccont", $00, 0.0)
    Return $00
End Function
