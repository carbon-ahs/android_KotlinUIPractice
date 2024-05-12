package com.axiagroups.kotlinuipractice

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.axiagroups.kotlinuipractice.ui.theme.KotlinUIPracticeTheme
import com.axiagroups.kotlinuipractice.viewModels.MainActivityViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApp {
                MainContent(MainActivityViewModel())
            }
        }
    }
}

@Composable
fun MyApp(content: @Composable () -> Unit) {
    KotlinUIPracticeTheme {
        MainContent(MainActivityViewModel())
    }
}

@Composable
fun MainContent(mainActivityViewModel: MainActivityViewModel?) {
    mainActivityViewModel?.counter?.observeAsState()?.value.let {  }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(2.dp),
            horizontalArrangement = Arrangement.SpaceEvenly

        ) {

            Button(onClick = { mainActivityViewModel?.incrementCounter?.invoke() }, modifier = Modifier.padding(8.dp)) {
                Text(text = "+")
            }
            Text(text = "${mainActivityViewModel?.counter?.value}")
            Button(onClick = { mainActivityViewModel?.decrementCounter?.invoke() }, modifier = Modifier.padding(8.dp)) {
                Text(text = "-")
            }

        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyApp {
        MainContent(MainActivityViewModel())
    }
}