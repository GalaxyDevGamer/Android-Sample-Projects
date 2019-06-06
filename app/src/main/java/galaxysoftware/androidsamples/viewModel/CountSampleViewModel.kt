package galaxysoftware.androidsamples.viewModel

import androidx.lifecycle.ViewModel;

class CountSampleViewModel : ViewModel() {
    // TODO: Implement the ViewModel
    var count = 0

    fun addCount() = count++

    fun resetCount() {
        count = 0
    }
}
