package com.example.labeledslider

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.labeledslider.ui.theme.LabeledSliderTheme
import androidx.compose.runtime.remember
import androidx.compose.runtime.mutableStateOf
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Slider
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.setValue



class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LabeledSliderTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Column(
                        modifier = Modifier.padding(innerPadding).padding(16.dp)
                    ){
                   LabelSlider()
                   }
                }
            }
        }
    }
}

@Composable
fun LabelSlider(modifier:  Modifier = Modifier) {
    var sliderPosition by remember { mutableStateOf(0f) }

    Column (
        modifier = modifier.padding(8.dp)
    ) {

        Text(text = "Slider Value: ${sliderPosition.toInt()}", modifier = Modifier.padding(top = 8.dp))
        Slider(
            value = sliderPosition,
            onValueChange = {  sliderPosition = it },
            valueRange = 0f..100f,
            modifier = Modifier.fillMaxWidth()
        )


    }

}

@Preview(showBackground = true)
@Composable
fun LabelSliderPreview() {
    LabeledSliderTheme {
        LabelSlider()
    }
}