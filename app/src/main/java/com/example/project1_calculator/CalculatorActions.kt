package com.example.project1_calculator

sealed interface CalculatorActions {
    object Calculation : CalculatorActions
    object Clear : CalculatorActions
    object Delete : CalculatorActions
    object Decimal : CalculatorActions
    data class Operation(val calculatorOperation: CalculatorOperation) : CalculatorActions
    data class Numbers(val number: Int) : CalculatorActions
    object Percentage : CalculatorActions
}
