//Hamburger calculation

function Hamburger() {
    const SIZE_SMALL = "small";
    const SIZE_LARGE = "small";
    const STUFFING_CHEESE = "cheese";
    const STUFFING_SALAD = "salad";
    const STUFFING_POTATO = "potato";
    const TOPPING_MAYO = "mayo";
    const TOPPING_SPICE = "spice";

    var _size;
    var _stuffing;
    var _topping;
    var _calories = 0;


    /**
     * Add the additive to the hamburger. You can add
     * a few additives, provided that they are different.
     */
    this.addTopping = function (topping) {
        if(_topping.indexOf(topping)===-1){
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

function Topping() {
    var price;
    var calories;
}

function LargeSize() {
    var _price = 100;
    var calories = 40;

}