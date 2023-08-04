package com.example.project1_calculator

sealed class CalculatorOperation(val Symbol:String){
    object Add:CalculatorOperation("+")
    object Subtract:CalculatorOperation("-")
    object Multiply:CalculatorOperation("\u00D7")
    object Divide:CalculatorOperation("\u00F7")
}