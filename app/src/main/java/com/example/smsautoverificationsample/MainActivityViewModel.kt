package com.example.smsautoverificationsample

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainActivityViewModel : ViewModel() {
    private val _phoneNumberLiveData: MutableLiveData<String?> = MutableLiveData()
    private val _smsCodeLiveData: MutableLiveData<Int?> = MutableLiveData()

    fun phoneNumber(): MutableLiveData<String?> {
        return _phoneNumberLiveData
    }

    fun smsCode(): MutableLiveData<Int?> {
        return _smsCodeLiveData
    }
}