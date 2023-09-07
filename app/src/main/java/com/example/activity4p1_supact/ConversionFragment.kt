package com.example.activity4p1_supact

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.activity4p1_supact.databinding.FragmentConversionBinding
import java.text.NumberFormat

class ConversionFragment : Fragment() {
    private lateinit var binding:FragmentConversionBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreate(savedInstanceState)
        binding = FragmentConversionBinding.inflate(layoutInflater)
        binding.bttnConvert.setOnClickListener { convertUnit () }
        return binding.root
    }
    private fun convertUnit() {
        val stringInTextField = binding.txtInput.text.toString()
        val enteredValue = stringInTextField.toDouble()
        if (binding.unitOptions.checkedRadioButtonId == R.id.option_kilograms) {
            val outputKg = enteredValue * 0.45359237
            val convertedUnitKg = NumberFormat.getNumberInstance().format(outputKg)
            binding.txtOutput.text = "Converted Unit: $convertedUnitKg kg"
        }
        else {
            val outputLbs = enteredValue / 0.45359237
            val convertedUnitLbs = NumberFormat.getNumberInstance().format(outputLbs)
            binding.txtOutput.text = "Converted Unit: $convertedUnitLbs lbs"
        }
    }
}