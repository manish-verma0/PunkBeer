package com.manish.punkbeer.data.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Entity("beers")
@Parcelize
data class Beer(
    @PrimaryKey
    @SerializedName("id") var id: Int? = null,
    @SerializedName("name") var name: String? = null,
    @SerializedName("tagline") var tagline: String? = null,
    @SerializedName("first_brewed") var firstBrewed: String? = null,
    @SerializedName("description") var description: String? = null,
    @SerializedName("image_url") var imageUrl: String? = null,
    @SerializedName("abv") var abv: Double? = null,
    @SerializedName("ph") var ph: Double? = null,
    @SerializedName("brewers_tips") var brewersTips: String? = null,
    @SerializedName("contributed_by") var contributedBy: String? = null

) : Parcelable