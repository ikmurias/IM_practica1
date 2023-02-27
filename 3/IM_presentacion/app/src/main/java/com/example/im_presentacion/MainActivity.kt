package com.example.im_presentacion

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.im_presentacion.ui.theme.IM_presentacionTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            IM_presentacionTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun tarjeta_presentacion(){
    val nombre: String  = stringResource(R.string.nombre)
    val titulo: String = stringResource(R.string.titulo)
    val numero: String = stringResource(R.string.numero)
    val social: String = stringResource(R.string.social)
    val email: String = stringResource(R.string.email)
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Image(modifier = Modifier
            .height(20.dp)
            .width(20.dp),painter = painterResource(R.drawable.ic_launcher_background), contentDescription = null)
        Text(text= nombre, fontSize = 20.sp)
        Text(text = titulo, fontSize = 10.sp)
        Spacer(modifier = Modifier.height(30.dp))
        Row {
            Image(
                painter = painterResource(R.drawable.ic_launcher_background),
                contentDescription = null,
                modifier = Modifier
                    .width(10.dp)
                    .width(10.dp)
            )
            Text(text = numero)
        }
        Row {
            Image(
                painter = painterResource(R.drawable.ic_launcher_background),
                contentDescription = null,
                modifier = Modifier
                    .width(10.dp)
                    .width(10.dp)
            )
            Text(text = social)
        }
        Row {
            Image(
                painter = painterResource(R.drawable.ic_launcher_background),
                contentDescription = null,
                modifier = Modifier
                    .width(10.dp)
                    .width(10.dp)
            )
            Text(text = email)
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    IM_presentacionTheme {
        tarjeta_presentacion()
    }
}