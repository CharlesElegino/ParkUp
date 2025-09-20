package com.eldroid.parkup

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.textfield.TextInputLayout

class RegisterActivity : AppCompatActivity() {
    
    private lateinit var firstNameInput: EditText
    private lateinit var lastNameInput: EditText
    private lateinit var usernameInput: EditText
    private lateinit var passwordInput: EditText
    private lateinit var confirmPasswordInput: EditText
    private lateinit var registerButton: Button
    private lateinit var signInLink: TextView
    private lateinit var errorMessage: TextView
    
    private lateinit var firstNameLayout: TextInputLayout
    private lateinit var lastNameLayout: TextInputLayout
    private lateinit var usernameLayout: TextInputLayout
    private lateinit var passwordLayout: TextInputLayout
    private lateinit var confirmPasswordLayout: TextInputLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        initializeViews()
        setupClickListeners()
    }
    
    private fun initializeViews() {
        firstNameInput = findViewById(R.id.first_name_input)
        lastNameInput = findViewById(R.id.last_name_input)
        usernameInput = findViewById(R.id.username_input)
        passwordInput = findViewById(R.id.password_input)
        confirmPasswordInput = findViewById(R.id.confirm_password_input)
        
        firstNameLayout = findViewById(R.id.first_name_layout)
        lastNameLayout = findViewById(R.id.last_name_layout)
        usernameLayout = findViewById(R.id.username_layout)
        passwordLayout = findViewById(R.id.password_layout)
        confirmPasswordLayout = findViewById(R.id.confirm_password_layout)
        
        // Initialize buttons and other views
        registerButton = findViewById(R.id.register_button)
        signInLink = findViewById(R.id.sign_in_link)
        errorMessage = findViewById(R.id.error_message)
    }
    
    private fun setupClickListeners() {
        registerButton.setOnClickListener {
            validateAndRegister()
        }
        
        signInLink.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
    
    private fun validateAndRegister() {
        clearAllErrors()
        
        val isValid = validateAllFields()
        
        if (isValid) {
            performRegistration()
        }
    }
    
    private fun validateAllFields(): Boolean {
        var isValid = true
        
        if (!validateFirstName()) {
            isValid = false
        }
        
        if (!validateLastName()) {
            isValid = false
        }
        
        if (!validateUsername()) {
            isValid = false
        }
        
        if (!validatePassword()) {
            isValid = false
        }
        
        if (!validateConfirmPassword()) {
            isValid = false
        }
        
        return isValid
    }
    
    private fun validateFirstName(): Boolean {
        val firstName = firstNameInput.text.toString().trim()
        
        if (TextUtils.isEmpty(firstName)) {
            showFieldError(firstNameLayout, getString(R.string.first_name_required))
            return false
        }
        
        if (firstName.length < 2) {
            showFieldError(firstNameLayout, getString(R.string.first_name_too_short))
            return false
        }
        
        return true
    }
    
    private fun validateLastName(): Boolean {
        val lastName = lastNameInput.text.toString().trim()
        
        if (TextUtils.isEmpty(lastName)) {
            showFieldError(lastNameLayout, getString(R.string.last_name_required))
            return false
        }
        
        if (lastName.length < 2) {
            showFieldError(lastNameLayout, getString(R.string.last_name_too_short))
            return false
        }
        
        return true
    }
    
    private fun validateUsername(): Boolean {
        val username = usernameInput.text.toString().trim()
        
        if (TextUtils.isEmpty(username)) {
            showFieldError(usernameLayout, getString(R.string.username_required_register))
            return false
        }
        
        if (username.length < 3) {
            showFieldError(usernameLayout, getString(R.string.username_too_short))
            return false
        }
        
        if (!username.matches(Regex("^[a-zA-Z0-9_]+$"))) {
            showFieldError(usernameLayout, getString(R.string.username_invalid_chars))
            return false
        }
        
        return true
    }
    
    private fun validatePassword(): Boolean {
        val password = passwordInput.text.toString()
        
        if (TextUtils.isEmpty(password)) {
            showFieldError(passwordLayout, getString(R.string.password_required_register))
            return false
        }
        
        if (password.length < 6) {
            showFieldError(passwordLayout, getString(R.string.password_too_short))
            return false
        }
        
        // Check for at least one letter and one number
        if (!password.matches(Regex(".*[a-zA-Z].*")) || !password.matches(Regex(".*\\d.*"))) {
            showFieldError(passwordLayout, getString(R.string.password_weak))
            return false
        }
        
        return true
    }
    
    private fun validateConfirmPassword(): Boolean {
        val password = passwordInput.text.toString()
        val confirmPassword = confirmPasswordInput.text.toString()
        
        if (TextUtils.isEmpty(confirmPassword)) {
            showFieldError(confirmPasswordLayout, getString(R.string.confirm_password_required))
            return false
        }
        
        if (password != confirmPassword) {
            showFieldError(confirmPasswordLayout, getString(R.string.password_mismatch))
            return false
        }
        
        return true
    }
    
    private fun showFieldError(layout: TextInputLayout, message: String) {
        layout.error = message
        layout.isErrorEnabled = true
    }
    
    private fun clearAllErrors() {
        firstNameLayout.error = null
        firstNameLayout.isErrorEnabled = false
        
        lastNameLayout.error = null
        lastNameLayout.isErrorEnabled = false
        
        usernameLayout.error = null
        usernameLayout.isErrorEnabled = false
        
        passwordLayout.error = null
        passwordLayout.isErrorEnabled = false
        
        confirmPasswordLayout.error = null
        confirmPasswordLayout.isErrorEnabled = false

        errorMessage.visibility = TextView.GONE
    }
    
    private fun showErrorMessage(message: String) {
        errorMessage.text = message
        errorMessage.visibility = TextView.VISIBLE
    }
    
    private fun performRegistration() {
        Toast.makeText(this, getString(R.string.register_success), Toast.LENGTH_SHORT).show()
        val intent = Intent(this, LoginActivity::class.java)
        intent.putExtra("username", usernameInput.text.toString().trim())
        startActivity(intent)
        finish()
    }
}