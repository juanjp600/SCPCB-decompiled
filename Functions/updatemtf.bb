Function updatemtf%()
    Local local0.rooms
    Local local1.npcs
    Local local2.rooms
    Local local4%
    Local local5%
    Local local6#
    Local local7#
    Local local8.npcs
    If (playerroom\Field7\Field4 = "exit1") Then
        Return $00
    EndIf
    If (mtfsfx($00) = $00) Then
        For local0 = Each rooms
            If (lower(local0\Field7\Field4) = "exit1") Then
                local2 = local0
                Exit
            EndIf
        Next
        If (local2 <> Null) Then
            If (30.0 > (Abs (entityz(local2\Field2, $00) - entityz(collider, $00)))) Then
                For local0 = Each rooms
                    Select lower(local0\Field7\Field4)
                        Case "exit1"
                            local2 = local0
                        Case "room106"
                            mtfrooms[$00] = local0
                        Case "roompj"
                            mtfrooms[$01] = local0
                        Case "room079"
                            mtfrooms[$02] = local0
                        Case "room2poffices"
                            mtfrooms[$03] = local0
                        Case "914"
                            mtfrooms[$04] = local0
                        Case "coffin"
                            mtfrooms[$05] = local0
                        Case "start"
                            mtfrooms[$06] = local0
                    End Select
                Next
                mtfsfx($00) = loadsound("SFX\MTF\Stop0.ogg")
                mtfsfx($01) = loadsound("SFX\MTF\Stop1.ogg")
                mtfsfx($02) = loadsound("SFX\MTF\Stop2.ogg")
                mtfsfx($03) = loadsound("SFX\MTF\ClassD0.ogg")
                mtfsfx($04) = loadsound("SFX\MTF\ClassD1.ogg")
                mtfsfx($05) = loadsound("SFX\MTF\Beep.ogg")
            EndIf
        EndIf
    EndIf
    If (0.0 = mtftimer) Then
        If (rand($1E, $01) = $01) Then
            If (local2 = Null) Then
                For local0 = Each rooms
                    If (lower(local0\Field7\Field4) = "exit1") Then
                        local2 = local0
                        Exit
                    EndIf
                Next
            ElseIf (30.0 > (Abs (entityz(local2\Field2, $00) - entityz(collider, $00)))) Then
                mtftimer = 1.0
                For local4 = $00 To $02 Step $01
                    local1 = createnpc($08, ((entityx(local2\Field2, $00) + (0.3 * (Float local4))) + (sin((Float local2\Field6)) * 5.0)), 0.5, ((entityz(local2\Field2, $00) + (0.3 * (Float local4))) - (cos((Float local2\Field6)) * 5.0)))
                    local1\Field12 = $00
                    If (local4 > $00) Then
                        local1\Field26 = (Before local1)
                        local1\Field9 = 4.0
                    EndIf
                Next
            EndIf
        EndIf
    Else
        mtftimer = (mtftimer + fpsfactor)
        If (700.0 < mtftimer) Then
            For local4 = $00 To $06 Step $01
                If (mtfroomstate[local4] = $01) Then
                    mtfroomstate[local4] = $00
                EndIf
                If (mtfroomstate[local4] = $03) Then
                    debuglog((("ei reitti? (" + mtfrooms[local4]\Field7\Field4) + "), ohitetaan"))
                EndIf
            Next
            For local1 = Each npcs
                If ((((local1\Field5 = $08) And (local1\Field12 = $00)) And (0.0 >= local1\Field10)) <> 0) Then
                    debuglog("asdfadsfasdfsdafasdfasdf")
                    If (local1\Field32 <> $01) Then
                        local6 = 500.0
                        For local4 = $00 To $06 Step $01
                            If (mtfrooms[local4] <> Null) Then
                                If (mtfroomstate[local4] = $00) Then
                                    local7 = entitydistance(local1\Field4, mtfrooms[local4]\Field2)
                                    If (local6 > local7) Then
                                        local6 = local7
                                        local5 = local4
                                    EndIf
                                EndIf
                            EndIf
                        Next
                        If (500.0 > local6) Then
                            debuglog(((mtfrooms[local5]\Field7\Field4 + ": ") + (Str local6)))
                            If (4.0 > distance(entityx(mtfrooms[local5]\Field2, $01), entityz(mtfrooms[local5]\Field2, $01), entityx(local1\Field4, $00), entityz(local1\Field4, $00))) Then
                                mtfroomstate[local5] = $02
                                For local8 = Each npcs
                                    If ((((local8 <> local1) And (local8\Field12 = local1\Field12)) And (local8\Field5 = $08)) <> 0) Then
                                        local8\Field9 = 0.0
                                    EndIf
                                Next
                                debuglog("room found")
                            Else
                                local1\Field32 = findpath(local1, entityx(mtfrooms[local5]\Field2, $00), 0.2, entityz(mtfrooms[local5]\Field2, $00))
                                If (local1\Field32 = $02) Then
                                    mtfroomstate[local5] = $03
                                    debuglog(("reitti? ei l?ytynyt, roomstate " + (Str mtfroomstate[local5])))
                                ElseIf (local1\Field32 = $01) Then
                                    For local8 = Each npcs
                                        If ((((local8 <> local1) And (local8\Field12 = local1\Field12)) And (local8\Field5 = $08)) <> 0) Then
                                            local8\Field9 = 4.0
                                            local8\Field26 = local1
                                        EndIf
                                    Next
                                    mtfroomstate[local5] = $01
                                    local1\Field9 = 3.0
                                EndIf
                            EndIf
                        EndIf
                    EndIf
                    Exit
                EndIf
            Next
            mtftimer = 1.0
        EndIf
    EndIf
    Return $00
End Function
