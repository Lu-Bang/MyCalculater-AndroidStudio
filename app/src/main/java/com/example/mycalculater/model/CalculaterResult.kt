package com.example.mycalculater.model

import java.io.Serializable

class CalculaterResult(): Serializable {
    var result: String = ""
    var time: String = ""
    constructor(result: String, time: String) : this() {
        this.result = result
        this.time = time
    }
}