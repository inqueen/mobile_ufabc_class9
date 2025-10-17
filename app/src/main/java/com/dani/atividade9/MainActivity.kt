package com.dani.atividade9

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private var count: Int = 0
    private lateinit var incrementBtn: Button
    private lateinit var nextBtn: Button

    companion object {
        const val USER_COUNT = "count"
        const val RESET_FLAG = "reset"
    }

    private val resultLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        if (result.resultCode == RESULT_OK) {
            val data: Intent? = result.data

            val shouldReset = data?.getBooleanExtra(RESET_FLAG, false) ?: false
            if (shouldReset) {
                count = 0
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // INICIALIZAR OS COMPONENTES DO DESING
        incrementBtn = findViewById(R.id.act1_1_btn)
        nextBtn = findViewById(R.id.act1_2_btn)

        // EVENTO DO BOTÃO INCREMENTAR
        incrementBtn.setOnClickListener {
            count++
        }

        // EVENTO DO BOTÃO PRÓXIMA PÁGINA
        nextBtn.setOnClickListener {
            val intent = Intent(this, ResultActivity::class.java)
            intent.putExtra(USER_COUNT, count)
            resultLauncher.launch(intent)
        }
    }
}