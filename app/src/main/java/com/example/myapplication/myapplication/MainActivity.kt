package com.example.myapplication.myapplication

import android.os.Bundle
import android.view.Surface
import android.view.WindowManager
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplication.myapplication.ui.theme.MyApplicationTheme
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import java.util.Collections
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.text.font.FontWeight


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON)
        setContent {
            MyApplicationTheme {
                // A surface container using the 'background' color from the theme

                    MyApp()

            }
        }
    }
}

@Composable
fun Greeting(name: String) {

    var expanded by remember { mutableStateOf(false) }

    val extraPadding by animateDpAsState(

        if (expanded) 48.dp else 0.dp,
        animationSpec = spring(
            dampingRatio = Spring.DampingRatioMediumBouncy,
            stiffness = Spring.StiffnessLow
        )
    )




    Surface(
        color = MaterialTheme.colors.primary,
        modifier = Modifier.padding(
            vertical = 4.dp, horizontal = 8.dp
        )
    ) {

        Row(
            modifier = Modifier.padding(24.dp)
        ) {
            Column(
                modifier =
                Modifier.weight(1f).padding(bottom = extraPadding.coerceAtLeast(0.dp))
            ) {
                Text(text = "Hello ")
                Text(text = name, style = MaterialTheme.typography.h4.copy(
                    fontWeight = FontWeight
                        (900)
                )
                )


            }
            OutlinedButton(
                onClick = { expanded = !expanded }


            ) {
                Text(if (expanded) "Show less" else "show more")
            }

        }


    }


}

@Preview(showBackground = true, widthDp = 320)
@Composable
fun DefaultPreview() {
    MyApplicationTheme {
        Greetings()
    }
}

@Composable
fun MyApp() {
   var shouldShowOnBoarding by rememberSaveable() {  mutableStateOf(true) }

    if (shouldShowOnBoarding){
        OnBoardingScreen(onContinueClicked = {shouldShowOnBoarding = false});




    }else{
           Greetings()
    }




}
@Composable
fun  OnBoardingScreen( onContinueClicked : () -> Unit   ){
 // var shouldShowOnBoarding by remember { mutableStateOf(true) }

   Surface {
       Column (modifier = Modifier.fillMaxSize(),
       verticalArrangement = Arrangement.Center,
           horizontalAlignment = Alignment.CenterHorizontally

           ){
           Text("welcome to the basic codelab")
           Button(modifier = Modifier.padding(vertical = 20.dp),
               onClick = onContinueClicked





               ){
           Text("continue")
           }
       }
   }


}

 @Preview (showBackground = true, widthDp = 320, heightDp = 320)
@Composable
fun OnBoardingPreview(){
     MyApplicationTheme{
         OnBoardingScreen  ( onContinueClicked = {})
     }
 }

@Composable
private fun Greetings ( names: List<String> = List(1000)  {"$it"}) {

    LazyColumn (modifier =  Modifier.padding(vertical = 4.dp)){

        items( items = names ) {
            name ->
            Greeting( name )



        }
    }




}



































































































