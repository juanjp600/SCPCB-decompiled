Function updateitems%()
    Local local0%
    Local local1.items
    Local local2#
    closestitem = Null
    For local1 = Each items
        If (local1\Field7 = $00) Then
            local2 = entitydistance(collider, local1\Field0)
            If (1.2 > local2) Then
                If (entityinview(local1\Field0, camera) <> 0) Then
                    If (closestitem = Null) Then
                        closestitem = local1
                    ElseIf (local2 < entitydistance(collider, closestitem\Field0)) Then
                        closestitem = local1
                    EndIf
                EndIf
            EndIf
            If (local2 < (hidedistance * 0.5)) Then
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
                            Case "keyomni"
                                achvomni = $01
                            Case "navigator","nav"
                                If (closestitem\Field1\Field0 = "S-NAV Navigator Ultimate") Then
                                    achvomni = $01
                                EndIf
                        End Select
                        If (closestitem\Field1\Field2 <> $42) Then
                            playsound(picksfx(closestitem\Field1\Field2))
                        EndIf
                        closestitem\Field7 = $01
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
