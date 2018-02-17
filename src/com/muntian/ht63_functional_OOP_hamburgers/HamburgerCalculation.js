//Hamburger calculation

function Hamburger(size, stuffing) {

    const SIZE_SMALL = {
        name : "small",
        price : 50,
        calories : 20
    };
    const SIZE_LARGE = {
        name : "large",
        price : 50,
        calories : 20
    };
    const STUFFING_CHEESE = {
        name : "cheese",
        price : 50,
        calories : 20
    };
    const STUFFING_SALAD = {
        name : "salad",
        price : 50,
        calories : 20
    };
    const STUFFING_POTATO = {
        name : "potato",
        price : 50,
        calories : 20
    };
    const TOPPING_MAYO = {
        name : "mayo",
        price : 50,
        calories : 20
    };
    const TOPPING_SPICE = {
        name : "spice",
        price : 50,
        calories : 20
    };

    var sizeList = [
      "small",
      "large"
    ];

    var stuffingList = [
      "cheese",
      "salad",
      "potato"
    ];

    var toppingList =[
        "mayo",
        "spice"
    ];
    var _size;
    var _stuffing;
    var _topping;
    var _calories = 0;

    function Ingredients(name, price, calories) {
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

    function BurgerSize() {

    }

    var mayo = new Topping("mayo", 20, 5);
    var spice = new Topping("spice", 15, 0);
    var cheese = new Stuffing("cheese", 10, 20);
    var salad = new Stuffing("salad", 20, 5);
    var potato = new Stuffing("potato", 15, 10);
    var smallSize = new Size("small", 50, 20);
    var largeSize = new Size("large", 100, 40);


    /**
     * Add the additive to the hamburger. You can add
     * a few additives, provided that they are different.
     */
    this.addTopping = function (topping) {
        if(_topping.indexOf(topping.getName())===-1){
            _topping = topping;
        }
    };

    /**
     * Remove the additive, provided that it was previously added.
     */
    this.removeTopping = function (topping) {
        let idx = _topping.indexOf(topping);
        if(idx!==-1){
            _topping.splice(idx,1);
        }
    };

    /**
     * Get additives list
     * @return {Array} Array of added additives
     */
    getToppings = function () {
        return _topping;
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
        let price = 0;
        for (let i = 0; i < _topping.length; i++){
            switch(_topping[i]) {
                case TOPPING_MAYO:
                price += 20;
                    [break]

                case TOPPING_SPICE:
                ...
                    [break]

                default:
                ...
                    [break]
            }
        }
    };

    /**
     * Get caloricity
     * @return {Number} Caloricity in calories
     */
    calculateCalories = function () {

    };

}

function Ingredient() {
}

function Topping() {
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

function LargeSize() {
    Topping.call(this);
    var price = 100;
    var calories = 40;

}