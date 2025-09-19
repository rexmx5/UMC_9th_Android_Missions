package com.example.simpleui

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.simpleui.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var selected = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 아이콘 클릭: 텍스트 색 토글 + 토스트
        binding.ivHappy.setOnClickListener {
            selected = !selected
            val color = if (selected)
                ContextCompat.getColor(this, android.R.color.holo_orange_dark)
            else
                ContextCompat.getColor(this, android.R.color.black)
            binding.tvHappy.setTextColor(color)
            Toast.makeText(this, if (selected) "행복 선택!" else "선택 해제", Toast.LENGTH_SHORT).show()
        }

        // 다음 화면으로 이동 (명시적 Intent)
        binding.btnNext.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
                .putExtra("selected_mood", selected)
            startActivity(intent)
        }
    }
}