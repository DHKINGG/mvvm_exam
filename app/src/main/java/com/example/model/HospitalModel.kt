package com.example.model

import com.google.gson.annotations.SerializedName

data class HospitalModel (
    @SerializedName("LOCALDATA_010101_GN") var localDataModel : LocalDataModel
)