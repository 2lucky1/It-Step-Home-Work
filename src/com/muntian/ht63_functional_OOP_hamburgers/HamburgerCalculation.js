//Hamburger calculation

function Hamburger(size, stuffing) {

    //Creating instances of ingredients
    const mayo = new Topping("mayo", 20, 5);
    const spice = new Topping("spice", 15, 0);
    const cheese = new Stuffing("cheese", 10, 20);
    const salad = new Stuffing("salad", 20, 5);
    const potato = new Stuffing("potato", 15, 10);
    const smallSize = new Size("small", 50, 20);
    const largeSize = new Size("large", 100, 40);

    //Lists of ingredients in the form of objects
    var sizeList = [
        smallSize,
        largeSize
    ];

    var stuffingList = [
        cheese,
        salad,
        potato
    ];

    var possibleToppingList = [
        mayo,
        spice
    ];

    //Main fields of the hamburger
    var _toppingsNamesList;
    var _size = size;
    var _stuffing = stuffing;
    var _toppingsArray;

    //Getting of the size object by its name
    var getSizeObject = function (sizeName) {
        for(let i = 0; i < sizeList.length; i++){
            if(sizeList[i].name === sizeName ){
                return sizeList[i];
            }
        }
        return "Size not defined";
    };

    //Getting of the stuffing object by its name
    var getStuffingObject = function (stuffingName) {
        for(let i = 0; i < stuffingList.length; i++){
            if(stuffingList[i].name === stuffingName ){
                return stuffingList[i];
            }
        }
        return "No Stuffing";
    };


    //Creating of the class Ingredient
    function Ingredient(name, price, calories) {
        var _name;
        var _price;
        var _calories;

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

    /**
     * Add the additive to the hamburger. You can add
     * a few additives, provided that they are different.
     * If the additive is already added, the method does nothing
     */
    this.addTopping = function (toppingName) {
        if(_toppingsNamesList.indexOf(toppingName)===-1){
            //Addition of topping name to the toppings names list
            _toppingsNamesList.push(toppingName);

            //Addition of topping to the topping list
            for(let i = 0; i < possibleToppingList.length; i++){
                if(possibleToppingList[i].name === toppingName){
                    _toppingsArray.push(possibleToppingList[i]);
                }
            }
        }
    };

    /**
     * Remove the additive, provided that it was previously added.
     */
    this.removeTopping = function (toppingName) {
        let idx = _toppingsNamesList.indexOf(toppingName);
        if (idx !== -1) {
            //Topping name deletion from name list
            _toppingsNamesList.splice(idx, 1);
            //Topping deletion from toppings array
            for(let i = 0; i < _toppingsArray.length; i++){
                if(_toppingsArray[i].name === toppingName){
                    _toppingsArray.splice(i,1);
                }
            }
        }
    };

    /**
     * Get additives list
     * @return {Array} Array of added additives
     */
    getToppings = function () {
        return _toppingsNamesList;
    };

    /**
     * Get size of the hamburger
     */
    getSize = function () {
        return _size;
    };

    /**
     * Get stuffing of the hamburger
     */
    getStuffing = function () {
        return _stuffing;
    };

    /**
     * Get price of the hamburger
     * @return {Number} Price in tugriks
     */
    calculatePrice = function () {
        let sizePrice = getSizeObject(getSize()).getPrice();
        let stuffingPrice = getStuffingObject(getStuffing()).getPrice();
        let toppingPrice = 0;
        for(let i = 0; _toppingsArray.length; i++){
            toppingPrice += _toppingsArray[i].getPrice();
        }
        
        return sizePrice + stuffingPrice + toppingPrice; 
    };

    /**
     * Get caloricity
     * @return {Number} Caloricity in calories
     */
    calculateCalories = function () {
        let sizeCalories = getSizeObject(getSize()).getCalories();
        let stuffingCalories = getStuffingObject(getStuffing()).getCalories();
        let toppingCalories = 0;
        for(let i = 0; _toppingsArray.length; i++){
            toppingCalories += _toppingsArray[i].getCalories();
        }

        return sizeCalories + stuffingCalories + toppingCalories;
    };

}
