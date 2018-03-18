//Hamburger calculation
"use strict";

//Creating of the class Ingredient and its heirs
class Ingredient {

    constructor(name, price, calories) {
        this._name = name;
        this._price = price;
        this._calories = calories;

    }

    getName() {
        return this._name;
    };

    getPrice() {
        return this._price;
    };

    getCalories() {
        return this._calories;
    };
}

class Topping extends Ingredient {

}

class Stuffing extends Ingredient {

}

class Size extends Ingredient {

}

class Hamburger {

    constructor(size, stuffing) {
        //Main fields of the hamburger
        this._size = size.toLowerCase();
        this._stuffing = stuffing.toLowerCase();
        this._toppingsNamesList = [];
        this._toppingsArray = [];

        //Lists of ingredients in the form of objects
        this.sizeList = [
            new Size("small", 50, 20),
            new Size("large", 100, 40)
        ];
        this.stuffingList = [
            new Stuffing("cheese", 10, 20),
            new Stuffing("salad", 20, 5),
            new Stuffing("potato", 15, 10)
        ];
        this.possibleToppingList = [
            new Topping("mayo", 20, 5),
            new Topping("spice", 15, 0)
        ];
    }

    /**
     * Check name of an ingredient
     * @param possibleList - list of correct names of ingredients
     * @param inputName - verifiable data
     * @return {boolean}
     */
    static dataChecking(possibleList, inputName) {
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
     * If the additive is already added, the method does nothing
     */
    addTopping(toppingName) {
        toppingName = toppingName.toLowerCase();
        //Input validation
        Hamburger.dataChecking(this.possibleToppingList, toppingName);
        //Check the existence of an additive in the list
        if (this._toppingsNamesList.indexOf(toppingName) === -1) {
            //Addition of topping name to the toppings names list
            this._toppingsNamesList.push(toppingName);
            //Addition of topping to the topping list (list of objects)
            for (let i = 0; i < this.possibleToppingList.length; i++) {
                if (this.possibleToppingList[i].getName() === toppingName) {
                    this._toppingsArray.push(this.possibleToppingList[i]);
                }
            }
        } else {
            throw Error("Already exist")
        }
    };

    /**
     * Remove the additive, provided that it was previously added.
     */
    removeTopping(toppingName) {
        toppingName = toppingName.toLowerCase();
        Hamburger.dataChecking(this.possibleToppingList, toppingName);
        let idx = this._toppingsNamesList.indexOf(toppingName);
        if (idx !== -1) {
            //Topping name deletion from name list
            this._toppingsNamesList.splice(idx, 1);
            //Topping deletion from toppings array
            for (let i = 0; i < this._toppingsArray.length; i++) {
                if (this._toppingsArray[i].getName() === toppingName) {
                    this._toppingsArray.splice(i, 1);
                }
            }
        } else {
            throw new Error("There is no such topping to delete")
        }
    };

    /**
     * Get additives list
     * @return {Array} Array of added additives
     */
    getToppings() {
        if(this._toppingsNamesList.length===0){
            return "Without additives";
        }
        return this._toppingsNamesList;
    };

    /**
     * Get size of the hamburger
     * @return {String}
     */
    getSize() {
        return this._size;
    };

    /**
     * Get stuffing of the hamburger
     * @return {String}
     */
    getStuffing() {
        return this._stuffing;
    };

    /**
     * Get price of the hamburger
     * @return {Number} Price in tugriks
     */
    calculatePrice() {
        let sizePrice = 0;
        let stuffingPrice = 0;
        let toppingPrice = 0;
        for (let i = 0; i < this.sizeList.length; i++) {
            if (this.sizeList[i].getName() === this._size) {
                sizePrice = this.sizeList[i].getPrice();
            }
        }

        for (let i = 0; i < this.stuffingList.length; i++) {
            if (this.stuffingList[i].getName() === this._stuffing) {
                stuffingPrice = this.stuffingList[i].getPrice();
            }
        }

        for (let i = 0; i < this._toppingsArray.length; i++) {
            toppingPrice += this._toppingsArray[i].getPrice();
        }

        return sizePrice + stuffingPrice + toppingPrice;
    };

    /**
     * Get caloricity
     * @return {Number} Caloricity in calories
     */
    calculateCalories() {
        let sizeCalories = 0;
        let stuffingCalories = 0;
        let toppingCalories = 0;

        for (let i = 0; i < this.sizeList.length; i++) {
            if (this.sizeList[i].getName() === this._size) {
                sizeCalories = this.sizeList[i].getCalories();
            }
        }

        for (let i = 0; i < this.stuffingList.length; i++) {
            if (this.stuffingList[i].getName() === this._stuffing) {
                stuffingCalories = this.stuffingList[i].getCalories();
            }
        }

        for (let i = 0; i < this._toppingsArray.length; i++) {
            toppingCalories += this._toppingsArray[i].getCalories();
        }
        return sizeCalories + stuffingCalories + toppingCalories;
    };

    /**
     * Displays all parameters of a hamburger in a string representation
     * @return {string}
     */
    toString() {
        return "Hamburger" +
            "\n\tsize:\t\t" + this.getSize() +
            "\n\tstuffing:\t" + this.getStuffing() +
            "\n\ttoppings:\t" + this.getToppings() +
            "\n\tcalories:\t" + this.calculateCalories() +
            "\n\tprice:\t\t" + this.calculatePrice();
    }
}
