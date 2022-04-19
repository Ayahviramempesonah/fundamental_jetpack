package com.example.myapplication.myapplication

import android.os.Bundle
import android.view.Surface
import android.view.WindowManager
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplication.myapplication.ui.theme.MyApplicationTheme
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON)
        setContent {
            MyApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    MyApp()
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {

    val expanded = remember { mutableStateOf(false) }

    val extraPadding = if (expanded.value) 48.dp else 0.dp

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
                Modifier.weight(1f).padding(bottom = extraPadding)
            ) {
                Text(text = "Hello ")
                Text(text = name)


            }
            OutlinedButton(
                onClick = { expanded.value = !expanded.value }


            ) {
                Text(if (expanded.value) "Show less" else "show more")
            }

        }


    }


}

@Preview(showBackground = true, widthDp = 320)
@Composable
fun DefaultPreview() {
    MyApplicationTheme {
        MyApp()
    }
}

@Composable
fun MyApp(/*names: List<String> = listOf("world", "jetpack awesome", "ayah tamvan amamh cantik yang punya"*/) {
   var shouldShowOnBoarding by remember { mutableStateOf(true) }

    if (shouldShowOnBoarding){
        OnBoardingScreen(){

        }

        }else{
           Greetings()
    }


   Greetings()


}
@Composable
fun  OnBoardingScreen( onContinueClicked : () -> Unit   ){
   var shouldShowOnBoarding by remember { mutableStateOf(true) }

   Surface {
       Column (modifier = Modifier.fillMaxSize(),
       verticalArrangement = Arrangement.Center,
           horizontalAlignment = Alignment.CenterHorizontally

           ){
           Text("welcome to the basic codelab")
           Button(modifier = Modifier.padding(vertical = 24.dp),
               onClick = { shouldShowOnBoarding = false  }





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
         OnBoardingPreview()
     }
 }

@Composable
private fun Greetings ( names: List<String> = listOf("world","compose")    ) {

    Column(modifier =  Modifier.padding(vertical = 4.dp)){
        for (name in names) {
            Greetings(name = name)
        }
    }




}



































































































