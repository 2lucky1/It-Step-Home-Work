window.onload = function () {
    //Create variable as menu visibility indicator
    let isOpen = false;
    //Get menu button
    let btn = document.getElementById('btn');
    //Get menu content
    let menuBlock = document.getElementById('menu_content');
    console.log('btn=' + btn);
    //Add event to menu button
    document.getElementById('btn').onclick = function () {
        //Check if the menu is open or not. In accordance with the results, open or close the menu
        if (!isOpen) {
            menuBlock.setAttribute("class", "menuOpen");
            btn.setAttribute('class', "menu_item");
            isOpen = true;
        } else {
            menuBlock.setAttribute("class", "menuClose");
            btn.setAttribute('class', "button");
            isOpen = false;
        }
    };

    //Gallery
    //Get number of pictures in our gallery
    let numberOfPictures = document.getElementById("showedImage").getElementsByTagName("img").length;
    //Initialize index of current image. Index will be equals id of an image. First image has id=0,
    //that's why currentIndex = 0
    let currentIndex = 0;

    //Add event to button "back"
    document.getElementById("back").onclick = function () {
        //Get current image and make it invisible
        document.getElementById("" + currentIndex).setAttribute("class", "inVisible");
        //Check if current element was the first picture, go to the last one.
        // If current element isn't the first, go to the previous element in the list
        if (currentIndex) {
            currentIndex -= 1;
        } else {
            currentIndex = (numberOfPictures - 1);
        }
        console.log("after" + currentIndex);
        //Get new current element and make it visible
        document.getElementById("" + currentIndex).setAttribute("class", "visible");
    };

    //Add event to button "next"
    document.getElementById("next").onclick = function () {
        //Get current image and make it invisible
        document.getElementById("" + currentIndex).setAttribute("class", "inVisible");
        //Check if current element was the lust picture, go to the first one.
        // If current element isn't the lust, go to the next element in the list
        if (currentIndex===(numberOfPictures-1)) {
            currentIndex = 0;
        } else {
            currentIndex +=1;
        }
        //Get new current element and make it visible
        document.getElementById("" + currentIndex).setAttribute("class", "visible");
    }
};
