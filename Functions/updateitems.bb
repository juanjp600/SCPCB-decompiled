Function updateitems%()
    Local local0.items
    Local local1#
    Local local2%
    Local local3$
    closestitem = Null
    For local0 = Each items
        If (local0\Field7 = $00) Then
            local1 = entitydistance(collider, local0\Field0)
            If (1.2 > local1) Then
                If (entityinview(local0\Field0, camera) <> 0) Then
                    If (closestitem = Null) Then
                        closestitem = local0
                    ElseIf (local1 < entitydistance(collider, closestitem\Field0)) Then
                        closestitem = local0
                    EndIf
                EndIf
            EndIf
            If (local1 < (hidedistance * 0.5)) Then
                If (entitycollided(local0\Field0, $01) <> 0) Then
                    local0\Field2 = 0.0
                Else
                    local0\Field2 = (local0\Field2 - ((0.004 * fpsfactor) * 0.1))
                    translateentity(local0\Field0, 0.0, (local0\Field2 * fpsfactor), 0.0, $00)
                EndIf
                If (-20.0 > entityy(local0\Field0, $00)) Then
                    debuglog(("poistetaan: " + local0\Field1\Field0))
                    removeitem(local0)
                EndIf
            EndIf
        EndIf
    Next
    If (closestitem <> Null) Then
        If (mousehit1 <> 0) Then
            If (itemamount < $0A) Then
                For local2 = $00 To $09 Step $01
                    If (inventory(local2) = Null) Then
                        local3 = closestitem\Field1\Field1
                        If (local3 = "killbat") Then
                            showentity(light)
                            lightflash = 1.0
                            playsound(introsfx($0B))
                            kill()
                        EndIf
                        If (closestitem\Field1\Field2 <> $42) Then
                            playsound(picksfx(closestitem\Field1\Field2))
                        EndIf
                        closestitem\Field7 = $01
                        inventory(local2) = closestitem
                        hideentity(closestitem\Field0)
                        Exit
                    EndIf
                Next
            Else
                msg = "You can;t carry any more items"
                msgtimer = 350.0
            EndIf
        EndIf
    EndIf
    Return $00
End Function
