package com.example.activity4p1_supact

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.findNavController
import com.example.activity4p1_supact.databinding.ActivityMainBinding
import com.example.activity4p1_supact.databinding.FragmentWelcomeBinding

class WelcomeFragment : Fragment() {
    private lateinit var binding: FragmentWelcomeBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreate(savedInstanceState)
        binding = FragmentWelcomeBinding.inflate(layoutInflater)

        binding.btnCancel.setOnClickListener { clearUserPass() }
        binding.btnLogin.setOnClickListener { view: View ->
            val username = binding.txtUsername
            val password = binding.txtPassword

            val inputUsername = checkUsername()
            val inputPassword = checkPassword()

            when {
                TextUtils.isEmpty(username.text.toString().trim()) ->{
                    username.error = "Error: Required field is empty."
                }
                TextUtils.isEmpty(password.text.toString().trim()) ->{
                    password.error = "Error: Required field is empty."
                }

                else -> {
                    if (inputUsername && inputPassword) {
                        view.findNavController().navigate(R.id.action_welcomeFragment_to_homeFragment)
                        Toast.makeText(activity, "Welcome Angel Isip!", Toast.LENGTH_SHORT).show()
                    }
                    else {
                        Toast.makeText(
                            activity,
                            "Error: Incorrect username or password.",
                            Toast.LENGTH_SHORT
                        ).show()
                        clearUserPass()
                    }
                }
            }
        }
        return binding.root
    }
    private fun checkUsername() : Boolean {
        val username = binding.txtUsername.text.toString()
        return (username == "qammisip")
    }

    private fun checkPassword() : Boolean {
        val password = binding.txtPassword.text.toString()
        return (password == "1910781")
    }

    private fun clearUserPass() {
        binding.txtUsername.setText("")
        binding.txtPassword.setText("")
    }
}