package com.example.visitcard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.visitcard.ui.theme.VisitCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            VisitCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    VisitCardApp()
                }
            }
        }
    }
}

@Composable
fun VisitCardApp() {
    Column (
        modifier = Modifier
            .background(color = Color(0xFF012531))
            .fillMaxWidth()
            .fillMaxHeight(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        Column (
            modifier = Modifier
                .wrapContentWidth(Alignment.CenterHorizontally)
                .padding(16.dp)
        ){
            Image(
                painter = painterResource(R.drawable.android_logo),
                contentDescription = null,
                modifier = Modifier
                    .padding(top = 8.dp, bottom= 8.dp, start = 130.dp,end = 130.dp)
            )
            Text( //User Name
                stringResource(R.string.full_name),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 12.dp, bottom = 4.dp),
                textAlign = TextAlign.Center,
                color = Color(0xFFFFFFFF),
                fontSize = 50.sp
            )
            Text( //Android Developer
                stringResource(R.string.title),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 8.dp),
                textAlign = TextAlign.Center,
                color = Color(0xFF3ddc84),
                fontWeight = Bold
            )
        }
        Spacer(modifier = Modifier.height(150.dp))
        Divider(
            color = Color(0xFF525E63),
            modifier = Modifier.fillMaxWidth().width(1.dp)
        )
        Column (
            modifier = Modifier
                .wrapContentWidth(Alignment.CenterHorizontally)
                .padding(start = 24.dp,end = 24.dp)
        ) {
            ContactDB(
                iconImage = painterResource(R.drawable.ic_phone),
                infoDB = stringResource(R.string.phone_number)
            )
        }
        Divider(
            color = Color(0xFF525E63),
            modifier = Modifier.fillMaxWidth().width(1.dp)
        )
        Column (
            modifier = Modifier
                .wrapContentWidth(Alignment.CenterHorizontally)
                .padding(start = 24.dp,end = 24.dp)
        ) {
            ContactDB(
                iconImage = painterResource(R.drawable.ic_share),
                infoDB = stringResource(R.string.share)
            )
        }
        Divider(
            color = Color(0xFF525E63),
            modifier = Modifier.fillMaxWidth().width(1.dp)
        )
        Column (
            modifier = Modifier
                .wrapContentWidth(Alignment.CenterHorizontally)
                .padding(start = 24.dp,end = 24.dp)
        ) {
            ContactDB(
                iconImage = painterResource(R.drawable.ic_email),
                infoDB = stringResource(R.string.email)
            )
        }
    }
}

@Composable
private fun ContactDB(
    iconImage: Painter,
    infoDB: String,
    modifier: Modifier = Modifier
) {
    Row (
        modifier = modifier
            .fillMaxWidth()
            .wrapContentWidth(Alignment.CenterHorizontally)
            ){
        Image(
            painter = iconImage,
            contentDescription = null,
            modifier = modifier
                .padding(start = 32.dp, top = 8.dp, bottom = 8.dp, end = 24.dp)
        )
        Text(
            text = infoDB,
            textAlign = TextAlign.Start,
            color = Color(0xFFFFFFFF),
            modifier = modifier
                .fillMaxWidth()
                .padding(start = 12.dp, top = 8.dp, bottom = 8.dp, end = 24.dp)
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview() {
    VisitCardTheme {
        VisitCardApp()
    }
}