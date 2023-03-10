package com.example.basic_text_app

import android.annotation.SuppressLint
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Message
import android.util.Log
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText

import android.widget.TextView
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {

    private lateinit var enter:EditText
    private lateinit var message: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        enter = findViewById(R.id.entertext)
        message =findViewById(R.id.textView)

        val main_button:Button = findViewById(R.id.button)
        main_button.setOnClickListener {button_update()  }

    }

    private fun button_update(){

        //save  the entering data in username variable
        val username = enter.text

        val motivationmessage = listOf("keep working hard","never give up","keep your head up!","nothing is not easy until you make it easy","no one comes for yous")
        val index =( 0..4).random()
        val currentmessage = motivationmessage[index]
        //clear the editText and use settext because editText's reuire an
        message.setText("")
        if (username.toString() == ""){
            message.text = "make sure to enter your name "
        }else{
            //update the textview to display our message
            message.text = "Hello $username  $currentmessage"

        }
        hidekeyboard()

    }
    //hide the keyboard using an inputmethomanager
    private fun hidekeyboard(){
        val key = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        key.hideSoftInputFromWindow(message.windowToken,0)
    }


}
