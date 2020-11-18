package com.pascal.myapplication.model.visitors

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ResponseVisitors(

	@field:SerializedName("data")
	val data: List<DataItem?>? = null,

	@field:SerializedName("message")
	val message: String? = null,

	@field:SerializedName("isSuccess")
	val isSuccess: Boolean? = null
) : Parcelable

@Parcelize
data class DataItem(

	@field:SerializedName("profession")
	val profession: String? = null,

	@field:SerializedName("visitors")
	val visitors: String? = null,

	@field:SerializedName("address")
	val address: String? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("nohp")
	val nohp: String? = null,

	@field:SerializedName("id")
	val id: String? = null
) : Parcelable
