package com.pascal.myapplication.view.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.pascal.myapplication.R
import com.pascal.myapplication.model.visitors.DataItem
import com.pascal.myapplication.model.visitors.ResponseAction
import com.pascal.myapplication.viewModel.ViewModelHome
import kotlinx.android.synthetic.main.activity_input.*

class InputActivity : AppCompatActivity() {

    private lateinit var viewModel : ViewModelHome
    private var item: DataItem? = null
    private var getName: String? = null
    private var getAddress: String? = null
    private var getNohp: String? = null
    private var getProfession: String? = null
    private var getVisitors: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_input)

        viewModel = ViewModelProviders.of(this).get(ViewModelHome::class.java)
        getParcel()
        attachObserve()
    }

    private fun getParcel() {
        item = intent.getParcelableExtra("data")
        getName = item?.name
        getAddress = item?.address
        getNohp = item?.nohp
        getProfession = item?.profession
        getVisitors = item?.visitors

        if (item != null) {
            input_name.setText(getName)
            input_address.setText(getAddress)
            input_nohp.setText(getNohp)
            input_profession.setText(getProfession)
            input_visitors.setText(getVisitors)

            btn_inputSave.text = "Update"
        }

        when (btn_inputSave.text) {
            "Update" -> {
                btn_inputSave.setOnClickListener {
                    item?.id?.let { it1 ->
                        viewModel.updateDataView(
                            it1,
                            input_name.text.toString(),
                            input_address.text.toString(),
                            input_nohp.text.toString(),
                            input_profession.text.toString(),
                            input_visitors.text.toString()
                        )
                    }
                }
            }
            else -> {
                btn_inputSave.setOnClickListener {
                    viewModel.inputDataView(
                        input_name.text.toString(),
                        input_address.text.toString(),
                        input_nohp.text.toString(),
                        input_profession.text.toString(),
                        input_visitors.text.toString()
                    )
                }
            }
        }

        btn_inputCancel.setOnClickListener {
            onBackPressed()
        }
    }

    private fun attachObserve() {
        viewModel.responseInput.observe(this, Observer { inputData(it) })
        viewModel.responseUpdate.observe(this, Observer { updateData(it) })
        viewModel.isError.observe(this, Observer { showError(it) })
    }

    private fun showError(it: Throwable?) {
        showToast(it?.message.toString())
    }

    private fun updateData(it: ResponseAction?) {
        showToast("Update Completed")
        finish()
    }

    private fun inputData(it: ResponseAction?) {
        showToast("Input Completed")
        finish()
    }

    private fun showToast(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }
}