function isUpperCaseFirstLetter(str) {
    console.log(str[0]);
    return str.search(/[A-ZА-ЯЁ]/) === 0;
}

function isValidEmail(str) {
    var re = /^([^.][a-zA-Z0-9._-]+)@([^.@])(.+)\.([a-z]{2,6})$/;
    return re.test(str);
}

function trimString(str) {
    let arrStr = str.match(/\S+/ig);
    return arrStr.join(" ");
}

function thousandsSeparators(num) {
    let strNum = "" + num;
    let arrStrNum = strNum.match(/./ig);
    let dotIdx = arrStrNum.indexOf(".");
    if (dotIdx === -1) {
        dotIdx = arrStrNum.length;
    }
    let count = 0;
    for (let i = dotIdx; i > 0; i--) {
        if (count % 3 === 0 && count !== 0) {
            arrStrNum.splice(i, 0, ",");
        }
        count++;
    }
    return arrStrNum.join("");
}
