package com.pascal.myapplication.repo

import android.content.Context
import com.pascal.myapplication.model.visitors.ResponseAction
import com.pascal.myapplication.model.visitors.ResponseVisitors
import com.pascal.myapplication.network.ConfigNetwork
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers

class RepositoryVisitors(context: Context) {

    fun getData(responHandler: (ResponseVisitors) -> Unit, errorHandler: (Throwable) -> Unit) {
        ConfigNetwork.service().getData()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                responHandler(it)
            }, {
                errorHandler(it)
            })
    }

    fun hapusData(
        id: String,
        responHandler: (ResponseAction) -> Unit,
        errorHandler: (Throwable) -> Unit
    ) {
        ConfigNetwork.service().deleteData(id ?: "").subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                responHandler(it)
            }, {
                errorHandler(it)
            })
    }

    fun inputData(
        nama: String, address: String, nohp: String, profession: String, visitors: String,
        responHandler: (ResponseAction) -> Unit, errorHandler: (Throwable) -> Unit
    ) {

        if (nama.isNotEmpty() && address.isNotEmpty() && nohp.isNotEmpty()
            && profession.isNotEmpty() && visitors.isNotEmpty()) {

            ConfigNetwork.service().insertData(nama, address, nohp, profession, visitors)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    responHandler(it)
                }, {
                    errorHandler(it)
                })
        } else {
            errorHandler
        }
    }

    fun updateData(
        id: String, nama: String, address: String, nohp: String, profession: String, visitors: String,
        responHandler: (ResponseAction) -> Unit, errorHandler: (Throwable) -> Unit
    ) {

        if (nama.isNotEmpty() && address.isNotEmpty() && nohp.isNotEmpty()
            && profession.isNotEmpty() && visitors.isNotEmpty()) {

            ConfigNetwork.service().updateData(id, nama, address, nohp, profession, visitors)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    responHandler(it)
                }, {
                    errorHandler(it)
                })
        } else {
            errorHandler
        }
    }
}