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

        binding.tvDefaultDetails.text =
            getString(R.string.intent_details,
                fullName,
                nickname,
                age.toString(),
                address)
    }

    private fun bundleIntent() {
        val Bundle = intent.extras //this variable is a question
        val fullName = Bundle?.getString(ActivityStart.BUNDLE_FULL_NAME)
        val nickname = Bundle?.getString(ActivityStart.BUNDLE_NICKNAME)
        val age = Bundle?.getInt(ActivityStart.BUNDLE_AGE, 0)
        val address = Bundle?.getString(ActivityStart.BUNDLE_ADDRESS)

        binding.tvBundleDetails.text =
            getString(R.string.intent_details,
                fullName,
                nickname,
                age.toString(),
                address)
    }

    private fun serializableIntent() {
        val user = intent.getSerializableExtra(ActivityStart.USER_SERIALIZABLE) as? User1

        if (user != null) {
            binding.tvSerializableDetails.text =
                getString(R.string.intent_details,
                    user.fullName,
                    user.nickname,
                    user.age.toString(),
                    user.address)
        } else {
            binding.tvSerializableDetails.text =
                getString(R.string.intent_details,
                    null,
                    null,
                    "0",
                    null)
        }
    }

    private fun parcelableIntent() {
        val user = intent.getParcelableExtra<User2>(ActivityStart.USER_PARCELABLE)

        if (user != null) {
            binding.tvParcelableDetails.text =
                getString(R.string.intent_details,
                    user.fullName,
                    user.nickname,
                    user.age.toString(),
                    user.address)
        } else {
            binding.tvParcelableDetails.text =
                getString(R.string.intent_details,
                    null,
                    null,
                    "0",
                    null)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}