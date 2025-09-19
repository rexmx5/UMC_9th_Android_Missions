package com.example.simpleui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.simpleui.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 전달받은 상태 표시
        val selected = intent.getBooleanExtra("selected_mood", false)
        binding.tvResult.text = if (selected) "행복: 선택됨" else "행복: 선택 안 됨"

        binding.btnBack.setOnClickListener { finish() }
    }
}