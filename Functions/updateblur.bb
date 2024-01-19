Function updateblur%(arg0#)
    entityalpha(ark_blur_image, arg0)
    copyrect($00, $00, graphicwidth, graphicheight, (Int (1024.0 - (Float (graphicwidth Sar $01)))), (Int (1024.0 - (Float (graphicheight Sar $01)))), backbuffer(), texturebuffer(ark_blur_texture, $00))
    Return $00
End Function
