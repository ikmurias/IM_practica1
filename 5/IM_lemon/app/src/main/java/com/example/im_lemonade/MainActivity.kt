package com.example.im_lemonade

import android.graphics.drawable.Drawable
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.im_lemonade.ui.theme.IM_LemonadeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            IM_LemonadeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    LemonApp()
                }
            }
        }
    }
}

@Composable
fun LemonApp(){
    var state by remember {
        mutableStateOf(0)
    }
    var imageResource = when(state){
        0 -> R.drawable.lemon_tree
        1 -> R.drawable.lemon_squeeze
        2 -> R.drawable.lemon_drink
        else -> R.drawable.lemon_restart
    }
    var texto: String = when(state){
        0 -> stringResource(R.string.tap)
        1 -> stringResource(R.string.tap2)
        2 -> stringResource(id = R.string.tap3)
        else -> stringResource(id = R.string.tap4)
    }

    Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally){
        Text(texto)
        Button(onClick = {state = actualizarEstado(state)} , modifier = Modifier.background(color = Color.Transparent)) {
            Image(painter = painterResource(id = imageResource), contentDescription = texto)
        }
    }
}

fun actualizarEstado(state: Int): Int{
    if(state < 3){
        if(state == 1 ){
            if((0..3).random() == 2){
                return 2
            }else{
                return 1
            }
        }
        return state + 1
    }else{
        return 0
    }
    return 0
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    IM_LemonadeTheme {
        Greeting("Android")
    }
}