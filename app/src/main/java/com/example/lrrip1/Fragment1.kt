package com.example.lrrip1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup



import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.lrrip1.databinding.ActivityMainBinding
import com.example.lrrip1.databinding.Fragment1Binding

class Fragment1 : Fragment() {
    private lateinit var binding: Fragment1Binding // Используем привязку для Fragment1
    private lateinit var emailEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var submitButton: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = Fragment1Binding.inflate(inflater, container, false)
        val view = binding.root

        emailEditText = view.findViewById(R.id.editTextEmail)
        passwordEditText = view.findViewById(R.id.editTextPassword)
        submitButton = view.findViewById(R.id.buttonSubmit)

        submitButton.setOnClickListener {
            val email = emailEditText.text.toString().trim()
            val password = passwordEditText.text.toString().trim()

            if (email.isEmpty() || password.isEmpty()) {
                Toast.makeText(activity, "Введите почту и пароль", Toast.LENGTH_SHORT).show()
            } else if (!email.contains("@")) { // Проверяем, содержит ли почта символ "@"
                Toast.makeText(activity, "Введите корректный адрес электронной почты", Toast.LENGTH_SHORT).show()
            } else if (password.length < 4) { // Проверяем, что пароль содержит не менее 4 символов
                Toast.makeText(activity, "Пароль должен содержать не менее 4 символов", Toast.LENGTH_SHORT).show()
            } else {
                activity?.supportFragmentManager?.beginTransaction()?.replace(R.id.place_holder, Fragment2.newInstance())?.commit()
            }
        }
        return view
    }

    companion object {
        @JvmStatic
        fun newInstance() = Fragment1()
    }
}