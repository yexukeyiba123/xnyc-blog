function getTimeOfyyyyMMddHHmmssSSS() {
    var date = new Date();
    return String(date.getFullYear()) +
    addOneZeroChar(date.getMonth() + 1) +
    addOneZeroChar(date.getDate()) +
    addOneZeroChar(date.getHours()) +
    addOneZeroChar(date.getMinutes()) +
    addOneZeroChar(date.getSeconds()) +
    addTwoZeroChar(date.getMilliseconds());
}

//前面补齐一个零
function addOneZeroChar(c) {
    return c <= 9 ? "0" + c : c;
}

//前面补齐两个零
function addTwoZeroChar(c) {
    if (c <= 9) {
        return "00" + c;
    } else if (c <= 99) {
        return "0" + c;
    } else {
        return String(c);
    }
}