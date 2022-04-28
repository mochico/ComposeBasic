package app.mochico.composebasic

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val viewModel: MainViewModel by viewModels()

        setContent {
            MainScreenContent(viewModel)
        }
    }
}

@Composable
fun MainScreenContent(viewModel: MainViewModel) {
    val state by viewModel.state.collectAsState()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(text = state.counter.count.toString())
        TextButton(
            onClick = viewModel::countUp
        ) {
            Text(text = "count up")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CounterPreview() {
    MainScreenContent(viewModel = MainViewModel())
}

@Preview(showBackground = true)
@Composable
fun TextPreview() {
    Text(text = "hello world")
}