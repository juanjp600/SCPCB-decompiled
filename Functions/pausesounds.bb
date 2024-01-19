Function pausesounds%()
    Local local0.events
    Local local1.doors
    For local0 = Each events
        If (local0\Field5 <> $00) Then
            If (channelplaying(local0\Field5) <> 0) Then
                pausechannel(local0\Field5)
            EndIf
        EndIf
        If (local0\Field6 <> $00) Then
            If (channelplaying(local0\Field6) <> 0) Then
                pausechannel(local0\Field6)
            EndIf
        EndIf
    Next
    For local1 = Each doors
        If (local1\Field13 <> $00) Then
            If (channelplaying(local1\Field13) <> 0) Then
                pausechannel(local1\Field13)
            EndIf
        EndIf
    Next
    If (ambientsfxchn <> $00) Then
        If (channelplaying(ambientsfxchn) <> 0) Then
            pausechannel(ambientsfxchn)
        EndIf
    EndIf
    Return $00
End Function
