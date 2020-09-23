package com.laaltentech.abou.myapplication.iot.owner.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.google.gson.Gson
import com.laaltentech.abou.myapplication.R
import com.laaltentech.abou.myapplication.databinding.FragmentMainLayoutBinding
import com.laaltentech.abou.myapplication.di.Injectable
import com.laaltentech.abou.myapplication.iot.observer.IoTMainViewModel
import com.laaltentech.abou.myapplication.network.Status
import com.laaltentech.abou.myapplication.util.AppExecutors
import javax.inject.Inject

class IoTFragment : Fragment(), Injectable {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    lateinit var binding : FragmentMainLayoutBinding

    private val newIoTMainViewModel: IoTMainViewModel by lazy {
        ViewModelProviders.of(activity!!, viewModelFactory)
            .get(IoTMainViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_main_layout, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        viewModelInit()
        newIoTMainViewModel.apiCall.value = "available"

        binding.blueSwitch.setOnCheckedChangeListener { _, isChecked ->



            if (isChecked){
                newIoTMainViewModel.ioTDataTable.blueSwitch = "01"
            }

            else{
                newIoTMainViewModel.ioTDataTable.blueSwitch = "00"
            }

            newIoTMainViewModel.apiCall.value = "available"


        }

        binding.redSwitch.setOnCheckedChangeListener { _, isChecked ->



            if (isChecked){
                newIoTMainViewModel.ioTDataTable.redSwitch = "01"
            }

            else{
                newIoTMainViewModel.ioTDataTable.redSwitch = "00"
            }

            newIoTMainViewModel.apiCall.value = "available"


        }

        binding.greenSwitch.setOnCheckedChangeListener { _, isChecked ->



            if (isChecked){
                newIoTMainViewModel.ioTDataTable.greenSwitch = "01"
            }

            else{
                newIoTMainViewModel.ioTDataTable.greenSwitch = "00"
            }

            newIoTMainViewModel.apiCall.value = "available"


        }

        super.onActivityCreated(savedInstanceState)
    }

    fun viewModelInit(){
        newIoTMainViewModel.let {
            it.results.observe(viewLifecycleOwner, Observer { item ->
                when(item.status){
                    Status.SUCCESS -> {
                        Log.e("TAG", "Data fetch was successful ${Gson().toJson(item.data)}")
                    }

                    Status.LOADING -> {
                        Log.e("TAG", "Data fetch Loading ${Gson().toJson(item.data)}")
                    }

                    Status.ERROR -> {
                        Log.e("TAG", "Data fetch error")
                    }
                }
            })
        }
    }
}