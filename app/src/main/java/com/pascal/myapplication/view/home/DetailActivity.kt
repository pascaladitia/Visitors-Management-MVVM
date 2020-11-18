package com.pascal.myapplication.view.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.pascal.myapplication.R
import com.pascal.myapplication.model.visitors.DataItem
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {

    private var item: DataItem? = null
    private var getName: String? = null
    private var getAddress: String? = null
    private var getNohp: String? = null
    private var getProfession: String? = null
    private var getVisitors: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        getParcel()
    }

    private fun getParcel() {
        item = intent.getParcelableExtra("data")
        getName = item?.name
        getAddress = item?.address
        getNohp = item?.nohp
        getProfession = item?.profession
        getVisitors = item?.visitors

        detail_name.setText(getName)
        detail_address.setText(getAddress)
        detail_nohp.setText(getNohp)
        detail_profession.setText(getProfession)
        detail_visitors.setText(getVisitors)

        btn_detailBack.setOnClickListener {
            onBackPressed()
        }
    }
}