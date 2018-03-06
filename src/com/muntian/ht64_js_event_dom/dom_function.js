var addArrayToDOM = function (iD, dataArray) {
    //Validation of iD and data array
    if (iD && dataArray && dataArray.length) {
        //Id type definition
        if (typeof iD === "string" || iD instanceof Element) {
            //Assign element to the variable iD if iD is string
            if (typeof iD === "string") {
                iD = document.getElementById(iD);
                if (!iD) {
                    return false;
                }
            }
            // Type checking of dataArray elements
            for (let i = 0; i < dataArray.length; i++) {
                if (typeof dataArray[i] !== "string" && typeof dataArray[i] !== "number") {
                    return false;
                }
            }
            //Addition of dataArray elements to the HTML element
            for (let i = 0; i < dataArray.length; i++) {
                //Creation of a div for each element of the dataArray
                let div = document.createElement("div");
                //Paste each element in it's own div
                div.innerHTML = dataArray[i];
                //Create an id for each element
                div.id = "child" + i;
                //Add a div with an element to the parent HTML element
                iD.appendChild(div);
            }
            //In case of successful completion of the additional operation return true
            return true;
        } else return false;
    } else return false;
};