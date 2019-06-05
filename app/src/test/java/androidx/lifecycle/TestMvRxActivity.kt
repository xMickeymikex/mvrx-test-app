package androidx.lifecycle

import com.airbnb.mvrx.BaseMvRxActivity

class TestMvRxActivity : BaseMvRxActivity() {

    fun addViewModel(viewModel: ViewModel) {
        viewModelStore.put(viewModel::class.java.name, viewModel)
    }
}