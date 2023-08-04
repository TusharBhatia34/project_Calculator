package com.example.project1_calculator

import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.project1_calculator.ui.theme.*

@Composable
fun NormalCalculatorUI(
    buttonSpacing: Dp = 8.dp,
    onClick:(CalculatorActions)->Unit,
    state:State

) {
    Box(modifier = Modifier
        .fillMaxSize()
        .background(DarkBlue)
          .padding(buttonSpacing)

    ){
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter)
            , verticalArrangement = Arrangement.spacedBy(buttonSpacing)
        ) {

//Text to display

    Text(
    text = state.Display,
    textAlign = TextAlign.End,
    modifier = Modifier
        .fillMaxWidth()
        .padding(16.dp)
        ,
    fontSize = 40.sp,
    fontWeight = FontWeight.Bold,
    color = Color.White,
)

            Divider(
                color = Color.White,
                modifier = Modifier
                    .padding(top = buttonSpacing, bottom = buttonSpacing)
                    .fillMaxWidth()
                    .height(0.5.dp)

            )


    Row(
        modifier = Modifier
            .fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
    ) {
        CustomButton(
            modifier = Modifier
                .background(buttonColor)

                .weight(1f),
            textColor = Orange,
            text = "AC",
            onClick = {
                onClick(CalculatorActions.Clear)
            }
        )
        CustomButton(
            modifier = Modifier
                .background(buttonColor)

                .weight(1f),
            textColor = darkYellow,
            text = "Del",
            onClick = {
                onClick(CalculatorActions.Delete)
            }
        )
        CustomButton(
            modifier = Modifier
                .background(buttonColor)

                .weight(1f),
            textColor = darkYellow,
            text = "%",
            onClick = {
                onClick(CalculatorActions.Percentage)
            }
        )
        CustomButton(
            modifier = Modifier
                .background(buttonColor)

                .weight(1f),
            textColor = darkYellow,
            text = "\u00F7",   //unicode for divide sign
            onClick = {
                onClick(CalculatorActions.Operation(CalculatorOperation.Divide))
            }

        )
    }
    Row(
        modifier = Modifier
            .fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
    ) {
        CustomButton(
            modifier = Modifier
                .background(buttonColor2)

                .weight(1f),
            textColor = Color.White,
            text = "7",
            onClick = {
                onClick(CalculatorActions.Numbers(7))
            },
        )
        CustomButton(
            modifier = Modifier
                .background(buttonColor2)

                .weight(1f),
            textColor = Color.White,
            text = "8",
            onClick = {
                onClick(CalculatorActions.Numbers(8))
            }
        )
        CustomButton(
            modifier = Modifier
                .background(buttonColor2)

                .weight(1f),
            textColor = Color.White,
            text = "9",
            onClick = {
                onClick(CalculatorActions.Numbers(9))
            }
        )
        CustomButton(
            modifier = Modifier
                .background(buttonColor)

                .weight(1f),
            textColor = darkYellow,
            text = "\u00D7",  //unicode for multiplication sign
            onClick = {
                onClick(CalculatorActions.Operation(CalculatorOperation.Multiply))
            }
        )
    }
    Row(
        modifier = Modifier
            .fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
    ) {
        CustomButton(
            modifier = Modifier
                .background(buttonColor2)

                .weight(1f),
            textColor = Color.White,
            text = "4",
            onClick = {
                onClick(CalculatorActions.Numbers(4))
            }
        )
        CustomButton(
            modifier = Modifier
                .background(buttonColor2)

                .weight(1f),
            textColor = Color.White,
            text = "5",
            onClick = {
                onClick(CalculatorActions.Numbers(5))
            }
        )
        CustomButton(
            modifier = Modifier
                .background(buttonColor2)

                .weight(1f),
            textColor = Color.White,
            text = "6",
            onClick = {
                onClick(CalculatorActions.Numbers(6))
            }
        )
        CustomButton(
            modifier = Modifier
                .background(buttonColor)

                .weight(1f),
            textColor = darkYellow,
            text = "-",
            onClick = {
                onClick(CalculatorActions.Operation(CalculatorOperation.Subtract))
            }
        )
    }
    Row(
        modifier = Modifier
            .fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
    ) {
        CustomButton(
            modifier = Modifier
                .background(buttonColor2)

                .weight(1f),
            textColor = Color.White,
            text = "1",
            onClick = {
                onClick(CalculatorActions.Numbers(1))
            }
        )
        CustomButton(
            modifier = Modifier
                .background(buttonColor2)

                .weight(1f),
            textColor = Color.White,
            text = "2",
            onClick = {
                onClick(CalculatorActions.Numbers(2))
            }
        )
        CustomButton(
            modifier = Modifier
                .background(buttonColor2)

                .weight(1f),
            textColor = Color.White,
            text = "3",
            onClick = {
                onClick(CalculatorActions.Numbers(3))
            }
        )
        CustomButton(
            modifier = Modifier
                .background(buttonColor)

                .weight(1f),
            textColor = darkYellow,
            text = "+",
            onClick = {
                onClick(CalculatorActions.Operation(CalculatorOperation.Add))
            }
        )
    }
    Row(
        modifier = Modifier
            .fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
    ) {
        CustomButton(
            modifier = Modifier
                .background(buttonColor)

                .weight(1f),
            textColor = Color.White,
            text = "0",
            onClick = {
                onClick(CalculatorActions.Numbers(0))
            }
        )

        CustomButton(
            modifier = Modifier
                .background(buttonColor)

                .weight(1f),
            textColor = Color.White,
            text = ".",
            onClick = {
                onClick(CalculatorActions.Decimal)
            }
        )
        CustomButton(
            modifier = Modifier
                .background(Orange)

                .weight(1f),
            textColor = Color.White,
            text = "=",
            onClick = {
                onClick(CalculatorActions.Calculation)
            }
        )
    }
}
        }
    }

