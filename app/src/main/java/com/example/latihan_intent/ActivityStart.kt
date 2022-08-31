package com.example.latihan_intent

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.latihan_intent.databinding.ActivityStartBinding

class ActivityStart : AppCompatActivity() {

    private var _binding: ActivityStartBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityStartBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val fullName = binding.etFullName.text
        val nickname = binding.etNickname.text
        val age = binding.etAge.text
        val address = binding.etAddress.text

        binding.btnDefault.setOnClickListener {

            if (!isInputEmpty()) {
                val defaultIntent = Intent(this, ActivityEnd::class.java)
                defaultIntent.putExtra(DEFAULT_FULL_NAME, fullName.toString()) //why it must convert here
                defaultIntent.putExtra(DEFAULT_NICKNAME, nickname.toString())
                defaultIntent.putExtra(DEFAULT_AGE, age.toString().toInt())
                defaultIntent.putExtra(DEFAULT_ADDRESS, address.toString())

                startActivity(defaultIntent)
            }
        }

        binding.btnBundle.setOnClickListener {

            if (!isInputEmpty()) {
                val bundleIntent = Intent(this, ActivityEnd::class.java)
                val bundle = Bundle()
                bundle.putString(BUNDLE_FULL_NAME, fullName.toString())
                bundle.putString(BUNDLE_NICKNAME, nickname.toString())
                bundle.putInt(BUNDLE_AGE, age.toString().toInt())
                bundle.putString(BUNDLE_ADDRESS, address.toString())

                bundleIntent.putExtras(bundle)
                startActivity(bundleIntent)
            }
        }

        binding.btnSerializable.setOnClickListener {

            if (!isInputEmpty()) {
                val user = User1(
                    fullName.toString(),
                    nickname.toString(),
                    age.toString().toInt(),
                    address.toString()
                )

                val serializableIntent = Intent(this, ActivityEnd::class.java)
                serializableIntent.putExtra(USER_SERIALIZABLE, user)
                startActivity(serializableIntent)
            }
        }

        binding.btnParcelable.setOnClickListener {

            if (!isInputEmpty()) {
                val user = User2(
                    fullName.toString(),
                    nickname.toString(),
                    age.toString().toInt(),
                    address.toString()
                )

                val parcelableIntent = Intent(this, ActivityEnd::class.java)
                parcelableIntent.putExtra(USER_PARCELABLE, user)
                startActivity(parcelableIntent)
            }
        }
    }

    private fun isInputEmpty() : Boolean {
        binding.apply {
            if (etFullName.length() == 0) {
                etFullName.error = "Full name is required"
                return true
            }
            if (etNickname.length() == 0) {
                etNickname.error = "Nickname is required"
                return true
            }
            if (etAge.length() == 0) {
                etAge.error = "Age is required"
                return true
            }
            if (etAddress.length() == 0) {
                etAddress.error = "Address is required"
                return true
            }
        }
        return false
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    companion object {
        const val USER_SERIALIZABLE = "user_serializable"
        const val USER_PARCELABLE = "user_parcelable"

        const val DEFAULT_FULL_NAME = "default_full_name"
        const val DEFAULT_NICKNAME = "default_nickname"
        const val DEFAULT_AGE = "default_age"
        const val DEFAULT_ADDRESS = "default_address"

        const val BUNDLE_FULL_NAME = "bundle_full_name"
        const val BUNDLE_NICKNAME = "bundle_nickname"
        const val BUNDLE_AGE = "bundle_age"
        const val BUNDLE_ADDRESS = "bundle_address"
    }
}