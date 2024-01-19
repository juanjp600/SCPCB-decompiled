Function createconsolemsg%(arg0$)
    Local local0.consolemsg
    local0 = (New consolemsg)
    Insert local0 Before (First consolemsg)
    local0\Field0 = arg0
    Return $00
End Function
