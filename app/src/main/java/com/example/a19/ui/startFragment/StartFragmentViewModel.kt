package com.example.a19.ui.startFragment

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.a19.data.RetrofitRepository
import com.example.a19.data.retrofit.CatFactModelModel
import kotlinx.coroutines.launch
import javax.inject.Inject

class StartFragmentViewModel(private val requestRepository: RetrofitRepository) : ViewModel() {

    fun getDataFromInternet():CatFactModelModel{
        var result = CatFactModelModel("",0)
        viewModelScope.launch {
            result = requestRepository.getUsers().body()!!
        }
        return result

    }
}

@Suppress("UNCHECKED_CAST")
class StartFragmentViewModelFactory @Inject constructor(private val retrofitRepository : RetrofitRepository) : ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return StartFragmentViewModel(retrofitRepository) as T
    }

}