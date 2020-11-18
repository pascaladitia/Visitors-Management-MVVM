package com.pascal.myapplication.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.pascal.myapplication.model.visitors.ResponseAction
import com.pascal.myapplication.model.visitors.ResponseVisitors
import com.pascal.myapplication.repo.RepositoryVisitors

class ViewModelHome(application: Application) : AndroidViewModel(application) {

    val repository = RepositoryVisitors(application.applicationContext)

    var responseData = MutableLiveData<ResponseVisitors>()
    var responseDelete = MutableLiveData<ResponseAction>()
    var responseInput = MutableLiveData<ResponseAction>()
    var responseUpdate = MutableLiveData<ResponseAction>()
    var isError = MutableLiveData<Throwable>()
    var isLoading = MutableLiveData<Boolean>()

    fun getDataView() {
        isLoading.value = true

        repository.getData({
            isLoading.value = false
            responseData.value = it
        }, {
            isLoading.value = false
            isError.value = it
        })
    }

    fun deleteDataView(id : String) {
        isLoading.value = true

        repository.hapusData(id, {
            isLoading.value = false
            responseDelete.value = it
            getDataView()
        } , {
            isLoading.value = false
            isError.value = it
        })
    }

    fun inputDataView(nama: String, address: String, nohp: String, profession: String, visitors: String) {

        repository.inputData(nama, address, nohp, profession, visitors, {
            responseInput.value = it
        }, {
            isError.value = it
        })
    }

    fun updateDataView(id: String, nama: String, address: String, nohp: String, profession: String, visitors: String) {
        repository.updateData(id, nama, address, nohp, profession, visitors, {
            responseUpdate.value = it
        }, {
            isError.value = it
        })
    }
}