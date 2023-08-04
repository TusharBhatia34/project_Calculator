package com.example.project1_calculator

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel


// Display text size
// number of lines in display
// max number

// buttons in layout
class CalculatorViewModel: ViewModel()  {
    var state by mutableStateOf(State())
        private set

    fun onAction(actions: CalculatorActions){
        when(actions){
            is CalculatorActions.Calculation -> performCalculation()
            is CalculatorActions.Clear -> state = State()
            is CalculatorActions.Delete -> performDeletion()
            is CalculatorActions.Decimal -> performDecimal()
            is CalculatorActions.Numbers -> enterNumber(actions.number)
            is CalculatorActions.Operation -> enterOperation(actions.calculatorOperation.Symbol)
            is  CalculatorActions.Percentage -> performPercentage()
        }
    }

    private fun performPercentage() {
        var percentage_calculation:Double  // to store the calculated value of percentage
        var num:Double
        var calculated_num:String
        if(!state.Display.contains("+") &&!state.Display.contains("-")
            &&!state.Display.contains("\u00D7") &&!state.Display.contains("\u00F7"))
        {
             num = state.Display.toDouble()
            percentage_calculation  = (num*1)/100

            if (percentage_calculation.toString().endsWith(".0")){
                state=  state.copy(
                    Display =  percentage_calculation.toString().removeSuffix(".0")
                )
            }
            else{
                state =   state.copy(
                    Display = percentage_calculation.toString()
                )
            }
        }

        else{
            var indexNum = 1  // it will store the index of last time the operator was used and "1" here is just default and it will be change in for loop below
            for (i in state.Display.length-1 downTo  0){
                if(state.Display[i].equals('+')||state.Display[i].equals('-')
                    ||state.Display[i].equals('\u00F7') ||state.Display[i].equals('\u00D7')){
                    indexNum = i //storing index of last operator
                    break
                }
            }
             num = state.Display.substring(indexNum+1).toDouble()
         var display_num = state.Display.substring(0,indexNum+1)
            calculated_num = To_calculate(display_num.dropLast(1)).toString()

            percentage_calculation = (num*calculated_num.toDouble())/100

            if (percentage_calculation.toString().endsWith(".0")){
                state=  state.copy(
                    Display =  display_num + percentage_calculation.toString().removeSuffix(".0")
                )
            }
            else{
                state =   state.copy(
                    Display =  display_num + percentage_calculation.toString().take(5)
                )
            }

        }


    }

    private fun enterOperation(Symbol:String) {
        if(!state.Display.last().equals('+') &&!state.Display.last().equals('-')
            &&!state.Display.last().equals('\u00D7') &&!state.Display.last().equals('\u00F7')){
          state = state.copy(
                Display = state.Display + "$Symbol"
            )
        }

    }

    private fun enterNumber(number:Int) {
        if(state.Display.equals("0")){
            state = state.copy(
                Display = "$number"
            )
            return
        }
    state = state.copy(
            Display = state.Display + number
        )
    }

    private fun performDecimal() {

//the case of before adding any operator which is while writing first number
        if(!state.Display.contains("+") &&!state.Display.contains("-")
            &&!state.Display.contains("\u00D7") &&!state.Display.contains('\u00F7')&& !state.Display.contains("."))
        {
          state = state.copy(
                Display = state.Display + "."
            )
        }
        //  the case of after adding any operator
        else{
            var indexNum = 1  // it will store the index of last time the operator was used and "1" here is just default and it will be change in for loop below
            for (i in state.Display.length-1 downTo  0){
                if(state.Display[i].equals('+') ||state.Display[i].equals('-')
                    ||state.Display[i].equals('\u00D7') || state.Display[i].equals('\u00F7')){
                    indexNum = i //storing index of last operator
                    break
                }
            }

            val DecimalCheck =  state.Display.indexOf(".",  indexNum) //to check that there is no duplication of "."
            if (DecimalCheck==-1){  // if there is no decimal already then we can add decimal
               state= state.copy(
                    Display = state.Display + "."
                )
            }
        }
    }

    private fun performDeletion() {
        if(state.Display.length == 1){
           state= state.copy(
                Display = "0"
            )
        }
        else
            state = state.copy(
                Display = state.Display.dropLast(1)
            )
    }


    private fun performCalculation() {

var display_String = state.Display   // to store the string in which we want to calculate
       var Calculated_num:Double = To_calculate(display_String)

        // to remove .0 in then end
        if (Calculated_num.toString().endsWith(".0")){
            state = state.copy(
                Display = Calculated_num.toString().removeSuffix(".0")
            )
            return
        }

        state = state.copy(
            Display = Calculated_num.toString().take(5)
        )
    }

  private  fun To_calculate(display_String:String):Double{

      var element = ""  // to store the each part of string into list
      var list_of_elements = ArrayList<String>() // list to store the parts of string

// for loop to store elements into list // let's say "15+98" so list would be [15,+,98]
      for (i in 0 until display_String.length){

          if (display_String[i] == '+'||display_String[i]=='-' ||display_String[i] == '\u00D7'||display_String[i]=='\u00F7'){
              list_of_elements.add(element)
              list_of_elements.add(display_String[i].toString())
              element = ""
          }
          else if(i == display_String.length-1 ){
              element = element + display_String[i]
              list_of_elements.add(element)
          }
          else{
              element = element +  display_String[i]
          }
      }

      var Calculated_number:Double   // to filter multipication and division and to store the final calculated number

//  runs if we have to calculate divide and multiply numbers
      if(display_String.contains("\u00D7") || display_String.contains("\u00F7")){
          var i = 1
          while( i < list_of_elements.size){  // while loop to calculate divide and multiply and then updating the list let's say 15+100x2 so new list [15,+,200.0]
              if (i == list_of_elements.lastIndex){
                  break
              }
              else if (list_of_elements[i].equals("\u00F7")) {
                  Calculated_number = list_of_elements[i-1].toDouble() / list_of_elements[i+1].toDouble()
                  list_of_elements.set(i-1,Calculated_number.toString())
                  list_of_elements.removeAt(i+1)
                  list_of_elements.removeAt(i)
                  i = i-2

              }
              else if (list_of_elements[i].equals("\u00D7")) {
                  Calculated_number = list_of_elements[i-1].toDouble() * list_of_elements[i+1].toDouble()
                  list_of_elements.set(i-1,Calculated_number.toString())
                  list_of_elements.removeAt(i+1)
                  list_of_elements.removeAt(i)
                  i= i-2
              }

              i = i+2
          }
      }

      Calculated_number = list_of_elements[0].toDouble()  // if list only consist[200] or if it consist [200,+,80]

      // runs if there is still add or minus left in calculation
      if(display_String.contains("+") || display_String.contains("-")){
          for (i in 1 until list_of_elements.size step 2) { // let's say [98,+,90,-8] so above var will store 98.0 and then 98.0+90 then 188.0 - 8.0 so calculated_number = 180.0
              if( i == list_of_elements.lastIndex){
                  break
              }
              else if (list_of_elements[i] == "+") {
                  Calculated_number =  Calculated_number + list_of_elements[i+1].toDouble()
              }
              else if (list_of_elements[i]=="-") {
                  Calculated_number =  Calculated_number - list_of_elements[i+1].toDouble()
              }

          }}
        return Calculated_number
    }
    }

