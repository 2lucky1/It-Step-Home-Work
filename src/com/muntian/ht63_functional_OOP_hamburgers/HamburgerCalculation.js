//Hamburger calculation

//Creating of the class Ingredient
function Ingredient(name, price, calories) {
    let _name = name;
    let _price = price;
    let _calories = calories;

    this.getName = function () {
        return _name;
    };

    this.getPrice = function () {
        return _price;
    };

    this.getCalories = function () {
        return _calories;
    };
}

function Topping(name, price, calories) {
    Ingredient.apply(this, arguments);
}

function Stuffing(name, price, calories) {
    Ingredient.apply(this, arguments);
}

function Size(name, price, calories) {
    Ingredient.apply(this, arguments);
}

function Hamburger(size, stuffing) {
    let _this = this;

    //Lists of ingredients in the form of objects
    let sizeList = [
        new Size("small", 50, 20),
        new Size("large", 100, 40)
    ];

    let stuffingList = [
        new Stuffing("cheese", 10, 20),
        new Stuffing("salad", 20, 5),
        new Stuffing("potato", 15, 10)
    ];

    let possibleToppingList = [
        new Topping("mayo", 20, 5),
        new Topping("spice", 15, 0)
    ];

    //Main fields of the hamburger
    let _toppingsNamesList = [];
    let _size = size.toLowerCase();
    let _stuffing = stuffing.toLowerCase();
    let _toppingsArray = [];
    
    /**
     * Check name of an ingredient
     * If name is incorrect, throws error
     * @param possibleList - list of correct names of ingredients
     * @param inputName - verifiable data
     * @return {boolean}
     */
    this.dataChecking = function (possibleList, inputName) {
        for (let i = 0; i < possibleList.length; i++) {
            if (possibleList[i].getName() === inputName) {
                return true;
            }
        }
        throw new Error("Incorrect input of the ingredients name");
    };

    /**
     * Add the additive to the hamburger. You can add
     * a few additives, provided that they are different.
     * If the additive is already added, the method throws error
     */
    this.addTopping = function (toppingName) {
        toppingName = toppingName.toLowerCase();
        //Input validation
        _this.dataChecking(possibleToppingList, toppingName);
        //Check the existence of an additive in the list
        if (_toppingsNamesList.indexOf(toppingName) === -1) {
            //Addition of topping name to the toppings names list
            _toppingsNamesList.push(toppingName);
            //Addition of topping to the topping list (list of objects)
            for (let i = 0; i < possibleToppingList.length; i++) {
                if (possibleToppingList[i].getName() === toppingName) {
                    _toppingsArray.push(possibleToppingList[i]);
                }
            }
        }else {
            throw Error("Already exist")
        }
    };


    /**
     * Remove the additive, provided that it was previously added.
     * If the additive was not previously added, the method throws an error
     */
    this.removeTopping = function (toppingName) {
        toppingName = toppingName.toLowerCase();
        _this.dataChecking(possibleToppingList, toppingName);
        let idx = _toppingsNamesList.indexOf(toppingName);
        if (idx !== -1) {
            //Topping name deletion from name list
            _toppingsNamesList.splice(idx, 1);
            //Topping deletion from toppings array
            for (let i = 0; i < _toppingsArray.length; i++) {
                if (_toppingsArray[i].getName() === toppingName) {
                    _toppingsArray.splice(i, 1);
                }
            }
        } else {
            throw new Error("There is no such topping to delete")
        }
    };

    /**
     * Get additives list
     * @return {Array} Array of added additives or message,
     * if the hamburger has no additives
     */
    this.getToppings = function () {
        if(_toppingsNamesList.length===0){
            return "Without additives";
        }
        return _toppingsNamesList;
    };

    /**
     * Get size of the hamburger
     * @return {String}
     */
    this.getSize = function () {
        return _size;
    };

    /**
     * Get stuffing of the hamburger
     * @return {String}
     */
    this.getStuffing = function () {
        return _stuffing;
    };

    /**
     * Get price of the hamburger
     * @return {Number} Price in tugriks
     */
    this.calculatePrice = function () {
        let sizePrice = 0;
        let stuffingPrice = 0;
        let toppingPrice = 0;

        //Size price calculation
        for (let i = 0; i < sizeList.length; i++) {
            if (sizeList[i].getName() === _size) {
                sizePrice = sizeList[i].getPrice();
            }
        }

        //Stuffing price calculation
        for (let i = 0; i < stuffingList.length; i++) {
            if (stuffingList[i].getName() === _stuffing) {
                stuffingPrice = stuffingList[i].getPrice();
            }
        }

        //Toppings price calculation
        for (let i = 0; i < _toppingsArray.length; i++) {
            toppingPrice += _toppingsArray[i].getPrice();
        }

        return sizePrice + stuffingPrice + toppingPrice;
    };

    /**
     * Get caloricity
     * @return {Number} Caloricity in calories
     */
    this.calculateCalories = function () {
        let sizeCalories = 0;
        let stuffingCalories = 0;
        let toppingCalories = 0;

        //Size calories calculation
        for (let i = 0; i < sizeList.length; i++) {
            if (sizeList[i].getName() === _size) {
                sizeCalories = sizeList[i].getCalories();
            }
        }

        //Stuffing calories calculation
        for (let i = 0; i < stuffingList.length; i++) {
            if (stuffingList[i].getName() === _stuffing) {
                stuffingCalories = stuffingList[i].getCalories();
            }
        }

        //Toppings calories calculation
        for (let i = 0; i < _toppingsArray.length; i++) {
            toppingCalories += _toppingsArray[i].getCalories();
        }

        return sizeCalories + stuffingCalories + toppingCalories;
    };

    /**
     * Displays all parameters of a hamburger in a string representation
     * @return {string}
     */
    this.toString = function () {
        return "Hamburger" +
            "\n\tsize:\t\t" + this.getSize() +
            "\n\tstuffing:\t" + this.getStuffing() +
            "\n\ttoppings:\t" + this.getToppings() +
            "\n\tcalories:\t" + this.calculateCalories() +
            "\n\tprice:\t\t" + this.calculatePrice();
    }

}
