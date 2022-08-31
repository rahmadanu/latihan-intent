package com.example.latihan_intent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.latihan_intent.databinding.ActivityEndBinding

class ActivityEnd : AppCompatActivity() {

    private var _binding: ActivityEndBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityEndBinding.inflate(layoutInflater)
        setContentView(binding.root)

        defaultIntent()
        bundleIntent()
        serializableIntent()
        parcelableIntent()
    }

    private fun defaultIntent() {
        val fullName = intent.getStringExtra(ActivityStart.DEFAULT_FULL_NAME)
        val nickname = intent.getStringExtra(ActivityStart.DEFAULT_NICKNAME)
        val age = intent.getIntExtra(ActivityStart.DEFAULT_AGE, 0)
        val address = intent.getStringExtra(ActivityStart.DEFAULT_ADDRESS)

        binding.apply {
            tvDefaultFullName.text = fullName
            tvDefaultNickname.text = nickname
            tvDefaultAge.text = age.toString()
            tvDefaultAddress.text = address
        }
    }

    private fun bundleIntent() {
        val Bundle = intent.extras //this variable is a question
        val fullName = Bundle?.getString(ActivityStart.BUNDLE_FULL_NAME)
        val nickname = Bundle?.getString(ActivityStart.BUNDLE_NICKNAME)
        val age = Bundle?.getInt(ActivityStart.BUNDLE_AGE, 0)
        val address = Bundle?.getString(ActivityStart.BUNDLE_ADDRESS)

        binding.apply {
            tvBundleFullName.text = fullName
            tvBundleNickname.text = nickname
            tvBundleAge.text = age.toString()
            tvBundleAddress.text = address
        }
    }

    private fun serializableIntent() {
        val user = intent.getSerializableExtra(ActivityStart.USER_SERIALIZABLE) as? User1

        binding.apply {
            if (user != null) {
                tvSerializableFullName.text = user.fullName
                tvSerializableNickname.text = user.nickName
                tvSerializableAge.text = user.age.toString()
                tvSerializableAddress.text = user.address
            } else {
                tvSerializableAge.text = "0"
            }
        }
    }

    private fun parcelableIntent() {
        val user = intent.getParcelableExtra<User2>(ActivityStart.USER_PARCELABLE)

        binding.apply {
            if (user != null) {
                tvParcelableFullName.text = user.fullName
                tvParcelableNickname.text = user.nickName
                tvParcelableAge.text = user.age.toString()
                tvParcelableAddress.text = user.address
            } else {
                tvParcelableAge.text = "0"
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}