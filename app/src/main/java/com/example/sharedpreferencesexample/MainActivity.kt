package com.example.sharedpreferencesexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private lateinit var nameText: EditText
    private lateinit var emailText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize the name and email EditText fields from the corresponding views in the layout
        nameText = findViewById(R.id.name_text)
        emailText = findViewById(R.id.email_text)
    }



    fun saveData(view: View) {

        // Create a SharedPreferences instance for edit
        val sharedPreferences = getPreferences(MODE_PRIVATE)
        val editor = sharedPreferences.edit()

        // save name
        editor.putString("name", nameText.text.toString())
        // save email
        editor.putString("email", emailText.text.toString())

        // apply changes -- DO NOT FORGET!!!
        editor.apply()

        Toast.makeText(this, "Saved!", Toast.LENGTH_SHORT).show()
    }


    fun loadData(view: View) {

        // Create a SharedPreferences instance to retrieve data
        val sharedPreferences = getPreferences(MODE_PRIVATE)
        // Get name
        val name = sharedPreferences.getString("name", "")
        // Get email
        val email = sharedPreferences.getString("email", "")

        // Set the obtained values to editTexts
        nameText.setText(name)
        emailText.setText(email)

    }


    fun clear(view: View) {

        // This method is pretty much the same as saveData method but
        // it clears/forgets the previously saved data

        // Create a shared preferences file for edit
        val sharedPreferences = getPreferences(MODE_PRIVATE)
        val editor = sharedPreferences.edit()

        // Clear the saved data (if previously saved )
        editor.clear()
        // apply changes
        editor.apply()

        // Clear the editTexts as well
        nameText.text.clear()
        emailText.text.clear()

        Toast.makeText(this, "Cleared!", Toast.LENGTH_SHORT).show()
    }
}