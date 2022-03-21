package com.example.smsautoverificationsample.usingSmsRetrieverApi

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.smsautoverificationsample.MainActivityViewModel
import com.example.smsautoverificationsample.R
import com.example.smsautoverificationsample.databinding.FragmentSmsRetrieverBinding

class SmsRetrieverFragment : Fragment() {

    private lateinit var mBinding: FragmentSmsRetrieverBinding
    private lateinit var mActivityViewModel: MainActivityViewModel
    private var onBackPressedCallback: OnBackPressedCallback =
        object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                mActivityViewModel.phoneNumber().value = null
                mActivityViewModel.smsCode().value = null
                isEnabled = false
                activity?.onBackPressed()
            }
        }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        mBinding = FragmentSmsRetrieverBinding.inflate(layoutInflater, container, false)
        activity?.onBackPressedDispatcher?.addCallback(viewLifecycleOwner, onBackPressedCallback)
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mActivityViewModel = ViewModelProvider(requireActivity())
            .get(MainActivityViewModel::class.java)
        mBinding.btnSmsRetrieverProceed.setOnClickListener {
            val textSms = mBinding.etSmsRetrieverCode.text
            if (!textSms.isNullOrEmpty()) {
                findNavController().navigate(R.id.action_smsRetrieverFragment_to_smsVerificationResultFragment)
            }
        }
    }
}