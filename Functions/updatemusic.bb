Function updatemusic%()
    If (nowplaying <> shouldplay) Then
        currmusicvolume = max((currmusicvolume - (fpsfactor / 200.0)), 0.0)
        If (0.0 = currmusicvolume) Then
            nowplaying = shouldplay
            If (musicchn <> $00) Then
                stopchannel(musicchn)
            EndIf
        EndIf
    Else
        currmusicvolume = musicvolume
    EndIf
    If (shouldplay < $42) Then
        If (musicchn = $00) Then
            musicchn = playsound(music(shouldplay))
        ElseIf (channelplaying(musicchn) = $00) Then
            musicchn = playsound(music(shouldplay))
        EndIf
    EndIf
    channelvolume(musicchn, currmusicvolume)
    Return $00
End Function
