Function kill%()
    If (godmode <> 0) Then
        Return $00
    EndIf
    If (0.0 <= killtimer) Then
        killanim = rand($00, $01)
        playsound(deathsfx($00))
        If (selectedmode = $01) Then
            deletedir(((savepath + currsave) + "\"))
            loadsavegames()
        EndIf
        killtimer = min(-1.0, killtimer)
        showentity(head)
        positionentity(head, entityx(camera, $01), entityy(camera, $01), entityz(camera, $01), $01)
        resetentity(head)
        rotateentity(head, 0.0, entityyaw(camera, $00), 0.0, $00)
    EndIf
    Return $00
End Function
