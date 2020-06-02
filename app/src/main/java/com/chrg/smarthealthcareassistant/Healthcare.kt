package com.chrg.smarthealthcareassistant

class Healthcare {

    var name:String? = null
    var speciality: String? = null
    var des:String? = null
    var image:Int? = null
    var price:Int? = null
    var timing:String? = null
    constructor(name:String,speciality: String, des:String, image:Int, price: Int, timing: String) {
        this.name = name
        this.speciality = speciality
        this.des = des
        this.image = image
        this.price = price
        this.timing = timing
    }
}