Function initevents%()
    Local local0.events
    createevent("room173", "room173", $00, 0.0)
    createevent("alarm", "start", $00, 0.0)
    createevent("pocketdimension", "pocketdimension", $00, 0.0)
    createevent("tunnel106", "tunnel", $00, 0.07)
    If (rand($03, $01) < $03) Then
        createevent("lockroom173", "lockroom", $00, 0.0)
    EndIf
    createevent("lockroom173", "lockroom", $00, 0.3)
    createevent("lockroom096", "lockroom2", $00, 0.0)
    createevent("tunnel2smoke", "tunnel2", $00, 0.2)
    createevent("tunnel2", "tunnel2", rand($00, $02), 0.0)
    createevent("room2doors173", "room2doors", $00, 0.5)
    createevent("room2offices2", "room2offices2", $00, 1.0)
    createevent("room2offices3", "room2offices3", $00, 1.0)
    createevent("room3servers", "room3servers", $00, 0.0)
    createevent("room3servers", "room3servers2", $00, 0.0)
    If (rand($05, $01) < $05) Then
        Select rand($03, $01)
            Case $01
                createevent("682roar", "tunnel", rand($00, $02), 0.0)
            Case $02
                createevent("682roar", "room3pit", rand($00, $02), 0.0)
            Case $03
                createevent("682roar", "room2offices", $00, 0.0)
        End Select
    EndIf
    createevent("testroom173", "room2testroom2", $00, 1.0)
    createevent("room2tesla", "room2tesla", $00, 0.9)
    local0 = createevent("room2nuke", "room2nuke", $00, 0.0)
    If (local0 <> Null) Then
        local0\Field2 = 1.0
    EndIf
    If (rand($05, $01) < $05) Then
        createevent("coffin106", "coffin", $00, 0.0)
    Else
        createevent("coffin", "coffin", $00, 0.0)
    EndIf
    createevent("room079", "room079", $00, 0.0)
    local0 = createevent("room106", "room106", $00, 0.0)
    If (local0 <> Null) Then
        local0\Field3 = 1.0
    EndIf
    createevent("pj", "roompj", $00, 0.0)
    createevent("914", "914", $00, 0.0)
    createevent("buttghost", "room2toilets", $00, 0.8)
    createevent("room2pipes106", "room2pipes", rand($00, $03), 0.0)
    createevent("room2pit", "room2pit", $00, 0.4)
    createevent("testroom", "testroom", $00, 0.0)
    createevent("room2tunnel", "room2tunnel", $00, 0.0)
    createevent("room2ccont", "room2ccont", $00, 0.0)
    createevent("gateaentrance", "gateaentrance", $00, 0.0)
    createevent("gatea", "gatea", $00, 0.0)
    createevent("exit1", "exit1", $00, 0.0)
    createevent("forest", "forest", $00, 0.0)
    Return $00
End Function
