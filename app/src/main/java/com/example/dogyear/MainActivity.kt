package com.example.dogyear

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.dogyear.ui.theme.DogYearTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DogYearTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color= MaterialTheme.colorScheme.background
                )
                {
                    AñosPerrunos()
                }
            }
        }
    }
}

@Composable
fun AñosPerrunos(){
    PosicionPantalla(
        titulo="Mis Años Perrunos",
        imagen= painterResource(id=R.drawable.perrunos)

    )
}
@Composable
private fun PosicionPantalla(titulo:String,imagen: Painter,modifier:Modifier=Modifier) {
    Column(
        modifier=modifier.padding(16.dp),

    ){
        var edad by remember {mutableStateOf("")}
        var resultado by remember {mutableStateOf("")
        }
        Image(
            painter=imagen,
            contentDescription =null,
            contentScale = ContentScale.FillHeight,
            alignment = Alignment.Center
        )
        Text(
            text=titulo,
            modifier=Modifier.padding(16.dp),
            textAlign = TextAlign.Center,
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily.Cursive
        )
        OutlinedTextField(
            value = edad,
            onValueChange = { edad = it },
            label = { Text("Mi edad humana")}

        )

        ElevatedButton(
            onClick = {
            var res=0
            res=edad.toInt() * 7
            resultado=res.toString()
        })
        {
            Text("Calcular")
            }

        OutlinedTextField(
                value = resultado,
                readOnly = true,
                onValueChange = { resultado = it },
                label = { Text("Edad Perruna") }
            )

    }

}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    DogYearTheme {
        AñosPerrunos() //Funcion de Años perrunos.
    }
}