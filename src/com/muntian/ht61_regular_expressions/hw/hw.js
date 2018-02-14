function isUpperCaseFirstLetter(str) {
    console.log(str[0]);
    if(str.search(/[A-ZА-Я]/) == 0){
       return true;
   }
   return false;
}

function isValidEmail(str) {
    var re = /[^@]{1,64}\/\[@]{1}\/\[^\.]{1}\/\.*\/\[\.]\/\[a-z]{1,6}/;
}

function trimString(str) {
    return str;
}

function formatCurrency(num) {
    return String(num);
}

