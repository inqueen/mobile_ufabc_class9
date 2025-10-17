package com.dani.atividade9

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ResultActivity : AppCompatActivity() {

    private lateinit var backBtn: Button
    private lateinit var resultTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_result)

        resultTextView = findViewById(R.id.act2_result)

        val intent = intent
        val finalCount = intent.getIntExtra(MainActivity.USER_COUNT, 0)
        resultTextView.text = "$finalCount"

        backBtn = findViewById(R.id.return_btn)

        backBtn.setOnClickListener {
            setCountResetResult()
            finish()
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun setCountResetResult() {
        val returnIntent = intent
        returnIntent.putExtra(MainActivity.RESET_FLAG, true)
        setResult(RESULT_OK, returnIntent)
    }
}