function isUpperCaseFirstLetter(str) {
    console.log(str[0]);
    if(str.search(/[A-ZА-Я]/) == 0){
       return true;
   }
   return false;
}

function isValidEmail(str) {
    var re = /^[.]{1,64} + @ + \\.* + [\\.] + [a-z]{1,6}$/;
    return re.test(str);
}

function trimString(str) {
    return str;
}

function formatCurrency(num) {
    return String(num);
}

