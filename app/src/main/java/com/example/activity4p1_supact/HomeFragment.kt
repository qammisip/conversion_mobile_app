package com.example.activity4p1_supact

import android.os.Bundle
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.activity4p1_supact.databinding.ActivityMainBinding
import com.example.activity4p1_supact.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = DataBindingUtil.inflate<FragmentHomeBinding>(inflater,R.layout.fragment_home,container,false)
        binding.btnSelect.setOnClickListener { view : View ->

            when (binding.userOptions.checkedRadioButtonId) {
                R.id.option_tutorial -> view.findNavController().navigate(R.id.action_homeFragment_to_tutorialFragment)
                R.id.option_conversion -> view.findNavController().navigate(R.id.action_homeFragment_to_conversionFragment)
                else -> view.findNavController().navigate(R.id.action_homeFragment_to_quizFragment)
            }
        }
        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onCreateOptionsMenu(menu : Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.options_menu,menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item,requireView().findNavController()) || super.onOptionsItemSelected(item)
    }
}