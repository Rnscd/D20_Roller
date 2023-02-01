package com.example.d20roller

import android.os.Bundle
import android.webkit.WebSettings.TextSize
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.d20roller.ui.theme.D20RollerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            D20RollerTheme {
                DiceRollerApp()

            }
        }
    }
}
@Preview
@Composable
fun DiceRollerApp(){
    DiceWithButtonAndImage(modifier = Modifier
        .fillMaxSize()
        .wrapContentSize(Alignment.Center))


}

@Composable
fun DiceWithButtonAndImage(modifier : Modifier = Modifier) {
    var result by remember { mutableStateOf(1) }
    val imageResource = when(result){
        in 1..10 -> R.drawable.d20tr
        else -> R.drawable.d20t
    }


    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally) {

        Box(contentAlignment = Alignment.Center) {
            Image(
                painter = painterResource(id = imageResource),
                contentDescription = result.toString(),
                modifier = Modifier.size(300.dp)
            )
            Text(result.toString(), modifier = Modifier.size(100.dp), textAlign = TextAlign.Center,
                style = TextStyle(fontSize = 50.sp)
            )
        }
        Spacer (modifier = Modifier.height(60.dp))
        Button(onClick = { result = (1..20).random() }, modifier = Modifier.size(170.dp, 55.dp),
        colors = ButtonDefaults.buttonColors(backgroundColor = Color.Red)){
            Text(stringResource(R.string.roll))
        }

    }
}