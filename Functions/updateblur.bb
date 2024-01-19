Function updateblur%(arg0#)
    entityalpha(ark_blur_image, arg0)
    copyrect(((ark_sw Sar $01) - $400), ((ark_sh Sar $01) - $400), $800, $800, $00, $00, backbuffer(), texturebuffer(ark_blur_texture, $00))
    Return $00
End Function
