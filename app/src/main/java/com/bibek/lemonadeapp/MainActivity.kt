package com.bibek.lemonadeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bibek.lemonadeapp.ui.theme.LemonadeAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LemonadeAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color.White),

                ) {
                   LemonadeApp()
                }
            }
        }
    }
}

@Composable
fun LemonadeApp() {

    LemonadeWithTextAndImage(
        modifier = Modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.Center)
            .background(Color.White)
    )


}


@Composable
fun  LemonadeWithTextAndImage(modifier : Modifier = Modifier ) {

    var imageNumber by remember { mutableStateOf(1)}

        val imageResource = when(imageNumber) {
                               1 -> R.drawable.lemon_tree
                                2,3,4, -> R.drawable.lemon_squeeze
                                5 -> R.drawable.lemon_drink
                                6 -> R.drawable.lemon_restart
                                else -> R.drawable.lemon_tree


        }

    val stringResourceValue =  when(imageNumber) {
                    1 -> R.string.tree_image_instruction
                    2, 3, 4 -> R.string.lemon_image_instruction
                    5 -> R.string.lemonade_image_instruction
                    6 -> R.string.empty_glass_image_instruction
                    else -> R.string.tree_image_instruction

    }


    Column(
        modifier = modifier,
       horizontalAlignment = Alignment.CenterHorizontally


    ) {
        Text(
            text = stringResource(stringResourceValue),
            modifier = Modifier.padding(bottom = 15.dp),
            fontSize = 20.sp,
            fontFamily = FontFamily.SansSerif

           )



        Box(
            modifier = Modifier.border(BorderStroke(4.dp,Color.Cyan),
                shape = RoundedCornerShape(8.dp)),



           ) {


            Image(
                painter = painterResource(imageResource)
                ,
                contentDescription = "1",
                modifier = Modifier
                    .padding(top = 10.dp, start = 10.dp, end = 10.dp, bottom = 10.dp)
                    .clickable(onClick = {
                        imageNumber++
                        if (imageNumber == 7) {
                            imageNumber = 1
                        }
                    })
            )

        }

    }



}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    LemonadeAppTheme {
        LemonadeApp()
    }
}