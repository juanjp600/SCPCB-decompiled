Function updateitems%()
    Local local0%
    Local local1.items
    Local local2%
    Local local3%
    Local local4%
    closestitem = Null
    For local1 = Each items
        If (local1\Field9 = $00) Then
            If (0.0 >= local1\Field6) Then
                local1\Field5 = entitydistance(collider, local1\Field0)
                local1\Field6 = (Float rand($32, $5A))
            Else
                local1\Field6 = max(0.0, (local1\Field6 - fpsfactor))
            EndIf
            If (1.2 > local1\Field5) Then
                If (closestitem = Null) Then
                    If (entityinview(local1\Field0, camera) <> 0) Then
                        closestitem = local1
                    EndIf
                ElseIf (local1\Field5 < entitydistance(collider, closestitem\Field0)) Then
                    If (entityinview(local1\Field0, camera) <> 0) Then
                        closestitem = local1
                    EndIf
                EndIf
            EndIf
            If (local1\Field5 < (hidedistance * 0.5)) Then
                If (entitycollided(local1\Field0, $01) <> 0) Then
                    local1\Field2 = 0.0
                Else
                    local1\Field2 = (local1\Field2 - ((0.004 * fpsfactor) * 0.1))
                    translateentity(local1\Field0, 0.0, (local1\Field2 * fpsfactor), 0.0, $00)
                EndIf
                If (-20.0 > entityy(local1\Field0, $00)) Then
                    debuglog(("poistetaan: " + local1\Field1\Field0))
                    removeitem(local1)
                EndIf
            EndIf
        EndIf
    Next
    If (closestitem <> Null) Then
        If (mousehit1 <> 0) Then
            If (itemamount < $0A) Then
                For local0 = $00 To $09 Step $01
                    If (inventory(local0) = Null) Then
                        Select closestitem\Field1\Field1
                            Case "killbat"
                                showentity(light)
                                lightflash = 1.0
                                playsound(introsfx($0B))
                                kill()
                            Case "key6"
                                achvomni = $01
                            Case "veryfinevest"
                                msg = "The vest is too heavy to pick up"
                                msgtimer = 420.0
                                Exit
                            Case "firstaid","finefirstaid","veryfinefirstaid","firstaid2"
                                closestitem\Field7 = 0.0
                            Case "navigator","nav"
                                If (closestitem\Field1\Field0 = "S-NAV Navigator Ultimate") Then
                                    achvsnav = $01
                                EndIf
                        End Select
                        If (closestitem\Field1\Field2 <> $42) Then
                            playsound(picksfx(closestitem\Field1\Field2))
                        EndIf
                        closestitem\Field9 = $01
                        closestitem\Field1\Field3 = $01
                        inventory(local0) = closestitem
                        hideentity(closestitem\Field0)
                        Exit
                    EndIf
                Next
            Else
                msg = "You can't carry any more items"
                msgtimer = 350.0
            EndIf
        EndIf
    EndIf
    Return $00
End Function
