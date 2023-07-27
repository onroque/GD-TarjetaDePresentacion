package com.example.gd_tarjetadepresentacion

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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
                    BusinessCard()
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
            .background(Color(0xFF073042))
    ) {

        HeaderOfBusinessCard(
            painterResource(id = R.drawable.android_logo),
            "Jennifer Doe",
            "Android Developer Extraordinaire",
            modifier = Modifier.weight(1f)
        )

        RowsOfBusinessCard(
            painter = painterResource(id = R.drawable.phone),
            text = "+11 (123) 444 555 666",
            modifier = Modifier.weight(7f)
        )

        RowsOfBusinessCard(
            painter = painterResource(id = R.drawable.share),
            text = "@AndroidDev",
            modifier = Modifier.weight(7f)
        )

        RowsOfBusinessCard(
            painter = painterResource(id = R.drawable.email),
            text = "jen.dow@android.com",
            modifier = Modifier.weight(7f)
        )

        Spacer(modifier = Modifier.height(24.dp))

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
                .align(Alignment.CenterHorizontally),
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
    painter: Painter, text: String = "Phone number", contentDescription : String? = null, modifier: Modifier = Modifier
) {
    Divider(color = Color.White, thickness = 1.dp, modifier = Modifier.padding(start = 16.dp, end = 16.dp))

    Row(
        Modifier
            .fillMaxWidth()
            .height(50.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {


        androidx.compose.material3.Icon(
            painter = painter,
            contentDescription = contentDescription,
            modifier = Modifier
                .height(30.dp)
                .weight(1f)
                .fillMaxWidth(),
            tint = Color(0xFF3ddc84)
        )

        Text(
            text = text, color = Color(0xFFFFFFFF), fontSize = 16.sp, modifier = Modifier.weight(3f)
        )
    }


}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    GDTarjetaDePresentacionTheme {
        BusinessCard()
    }
}