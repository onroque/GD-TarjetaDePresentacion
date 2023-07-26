package com.example.gd_tarjetadepresentacion

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.googlefonts.Font
import androidx.compose.ui.text.googlefonts.GoogleFont
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.gd_tarjetadepresentacion.ui.theme.GDTarjetaDePresentacionTheme

val provider = GoogleFont.Provider(
    providerAuthority = "com.google.android.gms.fonts",
    providerPackage = "com.google.android.gms",
    certificates = R.array.com_google_android_gms_fonts_certs
)

class MainActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



        setContent {
            GDTarjetaDePresentacionTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!", modifier = modifier
    )
}

@Composable
fun BusinessCard() {
    Column(
        Modifier
            .fillMaxSize()
            .background(Color(0xFF073042))
    ) {

        HeaderOfBusinessCard(
            painterResource(id = R.drawable.android_logo),
            "Jennifer Doe",
            "Android Developer Extraordinaire",
            modifier = Modifier.weight(7f)
        )

        RowsOfBusinessCard(painter = painterResource(id = androidx.core.R.drawable.notification_bg_normal), text = "Telefono")

    }

}

@Composable
fun HeaderOfBusinessCard(
    painter: Painter,
    name: String = "Jennifer Doe",
    message: String = "Android Developer Extraordinaire",
    modifier: Modifier = Modifier
) {

    Column(
        modifier.fillMaxSize(), verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painter,
            contentDescription = stringResource(R.string.icon_of_android_studio),
            modifier = Modifier
                .fillMaxWidth(0.25f)
                .align(Alignment.CenterHorizontally)
        )

        Text(
            text = name,
            fontSize = 42.sp,
            fontFamily = FontFamily(
                Font(
                    googleFont = GoogleFont(stringResource(R.string.font_family_01)),
                    fontProvider = provider,
                    weight = FontWeight.W200
                )
            ),
            color = Color.White,
            modifier = Modifier
                .padding(all = 8.dp)
                .align(Alignment.CenterHorizontally)
        )

        Text(
            text = message,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF3cda83),
            fontSize = 12.sp,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
    }
}

@Composable
fun RowsOfBusinessCard(
    painter: Painter,
    text: String = "Phone number",
    modifier: Modifier = Modifier
) {
    Row(
        Modifier
            .fillMaxWidth()
            .border(BorderStroke(width = 1.dp, color = Color.White))
    ) {
        Image(painter = painter, contentDescription = null, modifier = Modifier.weight(1f))
        Text(text = text, color = Color(0xFFFFFFFF), modifier = Modifier.weight(3f))
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    GDTarjetaDePresentacionTheme {
        BusinessCard()
    }
}