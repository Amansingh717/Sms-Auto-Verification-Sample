package com.example.smsautoverificationsample

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.smsautoverificationsample.databinding.FragmentSmsVerificationResultBinding

class SmsVerificationResultFragment : Fragment() {

    private lateinit var mBinding: FragmentSmsVerificationResultBinding
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
        mBinding = FragmentSmsVerificationResultBinding.inflate(layoutInflater, container, false)
        activity?.onBackPressedDispatcher?.addCallback(viewLifecycleOwner, onBackPressedCallback)
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mActivityViewModel = ViewModelProvider(requireActivity())
            .get(MainActivityViewModel::class.java)
        
    }
}