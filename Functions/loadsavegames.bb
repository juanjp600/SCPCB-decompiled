Function loadsavegames%()
    Local local0%
    Local local1$
    Local local2%
    Local local3%
    Local local4%
    savegameamount = $00
    local0 = readdir(savepath)
    Repeat
        local1 = nextfile(local0)
        If (local1 = "") Then
            Exit
        EndIf
        If (filetype(((savepath + "\") + local1)) = $02) Then
            If (((local1 <> ".") And (local1 <> "..")) <> 0) Then
                savegameamount = (savegameamount + $01)
            EndIf
        EndIf
    Forever
    closedir(local0)
    Dim savegames$((savegameamount + $01))
    local0 = readdir(savepath)
    local2 = $00
    Repeat
        local1 = nextfile(local0)
        If (local1 = "") Then
            Exit
        EndIf
        If (filetype(((savepath + "\") + local1)) = $02) Then
            If (((local1 <> ".") And (local1 <> "..")) <> 0) Then
                savegames(local2) = local1
                local2 = (local2 + $01)
            EndIf
        EndIf
    Forever
    closedir(local0)
    Dim savegametime%((savegameamount + $01))
    Dim savegamedate%((local3 + $01))
    For local2 = $01 To local3 Step $01
        local4 = readfile(((savepath + savegames((local2 - $01))) + "\save.txt"))
        savegametime((local2 - $01)) = readint(local4)
        closefile(local4)
    Next
    Return $00
End Function
