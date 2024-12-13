package com.example.test1

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    lateinit var usernameInput:EditText
    lateinit var passwordInput:EditText
    lateinit var loginBtn:Button
    class HomeFragment:Fragment(R.layout.fragment_home1)
    class NotificationFragment:Fragment(R.layout.fragment_notification2)
    class SettingsFragment:Fragment(R.layout.fragment_settings2)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets}


            bottomNavigationView.setOnNavigationItemSelectedListener { menuItem ->
                val selectedFragment = when (menuItem.itemId) {
                    R.id.home -> HomeFragment()
                    R.id.notification -> NotificationFragment()
                    R.id.settings -> SettingsFragment()
                    else -> null
                }

                selectedFragment?.let {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.container, it)
                        .commit()
                }

                true
            }
        usernameInput = findViewById(R.id.username_input)
        passwordInput = findViewById(R.id.password_input)
        loginBtn = findViewById(R.id.login_btn)

        loginBtn.setOnClickListener {
            val username = usernameInput.text.toString()
            val password = passwordInput.text.toString()
            Log.i("Test Credentials", "Username: $username and Password : $password")
        }
    }
}
