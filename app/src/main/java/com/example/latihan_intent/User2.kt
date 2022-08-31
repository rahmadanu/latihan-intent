package com.example.latihan_intent

import android.os.Parcel
import android.os.Parcelable

data class User2(
    val fullName: String?,
    val nickname: String?,
    val age: Int,
    val address: String?
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readInt(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(fullName)
        parcel.writeString(nickname)
        parcel.writeInt(age)
        parcel.writeString(address)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<User2> {
        override fun createFromParcel(parcel: Parcel): User2 {
            return User2(parcel)
        }

        override fun newArray(size: Int): Array<User2?> {
            return arrayOfNulls(size)
        }
    }
}
