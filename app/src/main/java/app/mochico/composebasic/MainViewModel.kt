package app.mochico.composebasic

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update

open class MainViewModel: ViewModel() {
    val state = MutableStateFlow(MainScreenState())

    fun countUp() {
        state.update {
            it.copy(
                counter = it.counter.copy(
                    count = it.counter.count.inc()
                )
            )
        }
    }
}