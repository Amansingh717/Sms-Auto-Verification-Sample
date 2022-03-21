package com.example.smsautoverificationsample

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.smsautoverificationsample.databinding.FragmentMethodSelectionBinding

class MethodSelectionFragment : Fragment() {

    lateinit var mBinding: FragmentMethodSelectionBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        mBinding = FragmentMethodSelectionBinding.inflate(layoutInflater, container, false)
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mBinding.btnMethodSelectionSmsRetrieverApi.setOnClickListener {
            findNavController().navigate(R.id.action_methodSelectionFragment_to_smsRetrieverFragment)
        }

        mBinding.btnMethodSelectionSmsUserConsentApi.setOnClickListener {
            findNavController().navigate(R.id.action_methodSelectionFragment_to_smsUserConsentFragment)
        }
    }
}