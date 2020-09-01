package com.magician.aboutme

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.databinding.DataBindingUtil
import com.magician.aboutme.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private val myName:MyName=MyName("Aman Singh")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        binding=DataBindingUtil.setContentView(this,R.layout.activity_main)

        binding.myName=myName

        /*done_button.setOnClickListener {
            displayNickname(it)
        }*/

        binding.doneButton.setOnClickListener {
            displayNickname(it)
        }
    }

    private fun displayNickname(it: View?) {


        binding.apply {
            nicknameEdit.visibility=View.GONE
            myName?.nickname=nicknameEdit.text.toString()
            nicknameText.visibility=View.VISIBLE
            it?.visibility=View.GONE
            invalidateAll()
        }

        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(it?.windowToken, 0)
    }


}