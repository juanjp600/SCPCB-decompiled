; SCP - Containment Breach v0.5.4_disasm
; Decompiled on 1/19/2024 5:17:58 PM

Include "Globals.bb"

Include "Functions/EntryPoint.bb"
Include "Functions/getiniint.bb"
Include "Functions/min.bb"
Include "Functions/max.bb"
Include "Functions/updatelauncher.bb"
Include "Functions/setbuffer.bb"
Include "Functions/initloadingscreens.bb"
Include "Functions/drawloading.bb"
Include "Functions/createconsolemsg.bb"
Include "Functions/getinifloat.bb"
Include "Functions/loadroomtemplates.bb"
Include "Functions/cls.bb"
Include "Functions/updatemusic.bb"
Include "Functions/updatemainmenu.bb"
Include "Functions/updatesecuritycams.bb"
Include "Functions/resumesounds.bb"
Include "Functions/pausesounds.bb"
Include "Functions/playsound2.bb"
Include "Functions/curvevalue.bb"
Include "Functions/updaterooms.bb"
Include "Functions/updateemitters.bb"
Include "Functions/mouselook.bb"
Include "Functions/moveplayer.bb"
Include "Functions/updatedoors.bb"
Include "Functions/updateevents.bb"
Include "Functions/updatedecals.bb"
Include "Functions/updatemtf.bb"
Include "Functions/updatenpcs.bb"
Include "Functions/updateitems.bb"
Include "Functions/updateparticles.bb"
Include "Functions/updatescreens.bb"
Include "Functions/updateblur.bb"
Include "Functions/savegame.bb"
Include "Functions/drawgui.bb"
Include "Functions/drawmenu.bb"
Include "Functions/drawending.bb"
Include "Functions/updateconsole.bb"
Include "Functions/getinistring.bb"
Include "Functions/initext.bb"
Include "Functions/mouseon.bb"
Include "Functions/limittext.bb"
Include "Functions/drawtick.bb"
Include "Functions/drawbutton.bb"
Include "Functions/putinivalue.bb"
Include "Functions/rowtext.bb"
Include "Functions/createroomtemplate.bb"
Include "Functions/drawtiledimagerect.bb"
Include "Functions/loadsavegames.bb"
Include "Functions/drawframe.bb"
Include "Functions/inputbox.bb"
Include "Functions/loadentities.bb"
Include "Functions/initnewgame.bb"
Include "Functions/loadgame.bb"
Include "Functions/initloadgame.bb"
Include "Functions/slidebar.bb"
Include "Functions/curveangle.bb"
Include "Functions/kill.bb"
Include "Functions/distance.bb"
Include "Functions/createparticle.bb"
Include "Functions/loopsound2.bb"
Include "Functions/wrapangle.bb"
Include "Functions/createnpc.bb"
Include "Functions/usedoor.bb"
Include "Functions/removenpc.bb"
Include "Functions/createemitter.bb"
Include "Functions/updateelevators.bb"
Include "Functions/updatelever.bb"
Include "Functions/findpath.bb"
Include "Functions/animate2.bb"
Include "Functions/createdecal.bb"
Include "Functions/getangle.bb"
Include "Functions/updatebutton.bb"
Include "Functions/use914.bb"
Include "Functions/playmtfmessage.bb"
Include "Functions/shoot.bb"
Include "Functions/removeitem.bb"
Include "Functions/removeparticle.bb"
Include "Functions/nullgame.bb"
Include "Functions/clscolor.bb"
Include "Functions/strippath.bb"
Include "Functions/createitem.bb"
Include "Functions/wireframe.bb"
Include "Functions/deinitpostprocess.bb"
Include "Functions/ini_filetostring.bb"
Include "Functions/ini_createkey.bb"
Include "Functions/ini_createsection.bb"
Include "Functions/rinput.bb"
Include "Functions/createblurimage.bb"
Include "Functions/textureblend.bb"
Include "Functions/inititemtemplates.bb"
Include "Functions/loadmaterials.bb"
Include "Functions/loadroommeshes.bb"
Include "Functions/createmap.bb"
Include "Functions/initwaypoints.bb"
Include "Functions/initevents.bb"
Include "Functions/createroom.bb"
Include "Functions/createdoor.bb"
Include "Functions/freetexture.bb"
Include "Functions/createitemtemplate.bb"
Include "Functions/loadworld.bb"
Include "Functions/createwaypoint.bb"
Include "Functions/createline.bb"
Include "Functions/createevent.bb"
Include "Functions/fillroom.bb"
Include "Functions/makecollbox.bb"
Include "Functions/keyvalue.bb"
Include "Functions/piece.bb"
Include "Functions/addtemplight.bb"
Include "Functions/createsecuritycam.bb"
Include "Functions/addlight.bb"
Include "Functions/createbutton.bb"
Include "Functions/createscreen.bb"
Include "Functions/entityscalex.bb"
Include "Functions/entityscaley.bb"
Include "Functions/entityscalez.bb"
Include "Functions/getmeshextents.bb"

Include "Types/consolemsg.bb"
Include "Types/decals.bb"
Include "Types/doors.bb"
Include "Types/emitters.bb"
Include "Types/events.bb"
Include "Types/gfxdrivercapsex_type.bb"
Include "Types/items.bb"
Include "Types/itemtemplates.bb"
Include "Types/lighttemplates.bb"
Include "Types/loadingscreens.bb"
Include "Types/materials.bb"
Include "Types/matrix3d.bb"
Include "Types/npcs.bb"
Include "Types/particles.bb"
Include "Types/rooms.bb"
Include "Types/roomtemplates.bb"
Include "Types/screens.bb"
Include "Types/securitycams.bb"
Include "Types/tempscreens.bb"
Include "Types/tempwaypoints.bb"
Include "Types/waypoints.bb"

Dim alarmsfx%(0)
Dim ambientsfx%(0)
Dim arrowimg%(0)
Dim bigdoorobj%(0)
Dim closedoorsfx%(0)
Dim coughsfx%(0)
Dim damagesfx%(0)
Dim deathsfx%(0)
Dim decaltextures%(0)
Dim decaysfx%(0)
Dim drawarrowicon%(0)
Dim gfxmodeheights%(0)
Dim gfxmodewidths%(0)
Dim gorepics%(0)
Dim horrorsfx%(0)
Dim introsfx%(0)
Dim inventory.items(0)
Dim lightspritetex%(0)
Dim mapfound%(0, 0, 0)
Dim mapname$(0, 0)
Dim maproomid%(0)
Dim maproom$(0, 0)
Dim maptemp%(0, 0, 0)
Dim menublinkduration%(0)
Dim menublinktimer%(0)
Dim mtfsfx%(0)
Dim music%(0)
Dim oldaipics%(0)
Dim oldmansfx%(0)
Dim opendoorsfx%(0)
Dim particletextures%(0)
Dim picksfx%(0)
Dim radiochn%(0)
Dim radiosfx%(0, 0)
Dim radiostate#(0)
Dim rustlesfx%(0)
Dim savegamedate%(0)
Dim savegames$(0)
Dim savegametime%(0)
Dim scp173sfx%(0)
Dim steppdsfx%(0)
Dim stepsfx%(0, 0, 0)

Const INFINITY# = (999.0) ^ (99999.0)
Const NAN# = (-1.0) ^ (0.5)

EntryPoint()
