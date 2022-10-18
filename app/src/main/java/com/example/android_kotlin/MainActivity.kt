package com.example.android_kotlin;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.view.View;

class MainActivity : AppCompatActivity()
{
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val ed_name = findViewById<EditText>(R.id.ed_name)
        val tv_text = findViewById<TextView>(R.id.tv_text)
        val tv_name = findViewById<TextView>(R.id.tv_name)
        val tv_winner = findViewById<TextView>(R.id.tv_winner)
        val tv_mmora = findViewById<TextView>(R.id.tv_mmora)
        val tv_cmora = findViewById<TextView>(R.id.tv_cmora)
        val btn_scissor = findViewById<RadioButton>(R.id.btn_scissor)
        val btn_stone = findViewById<RadioButton>(R.id.btn_stone)
        val btn_paper = findViewById<RadioButton>(R.id.btn_paper)
        val btn_mora = findViewById<Button>(R.id.btn_mora)

        btn_mora.setOnClickListener{
            if (ed_name.length() < 1)
                tv_text.text = "請輸入玩家姓名"
            else {
                tv_name.text = (String.format("名字\n%s", ed_name.getText().toString()));
                if (btn_scissor.isChecked)
                    tv_mmora.text = "我方出拳\n剪刀"
                else if (btn_stone.isChecked)
                    tv_mmora.text = "我方出拳\n石頭"
                else
                    tv_mmora.text = "我方出拳\n布"

                val computer = (Math.random() * 3).toInt()
                if (computer == 0)
                    tv_cmora.text = "電腦出拳\n剪刀"
                else if (computer == 1)
                    tv_cmora.text = "電腦出拳\n石頭"
                else
                    tv_cmora.text = "電腦出拳\n布"

                if ((btn_scissor.isChecked && computer == 2) ||
                    (btn_stone.isChecked && computer == 0) ||
                    (btn_paper.isChecked && computer == 1))
                {
                    tv_winner.text = "勝利者\n" + ed_name.text
                    tv_text.text = "恭喜你獲勝了!!!"

                } else if ((btn_scissor.isChecked && computer == 1) ||
                    (btn_stone.isChecked && computer == 2) ||
                    (btn_paper.isChecked && computer == 0)
                ) {
                    tv_winner.text = "勝利者\n電腦"
                    tv_text.text = "可惜,電腦獲勝了!"
                } else {
                    tv_winner.text = "勝利者\n平手"
                    tv_text.text = "平局,請再試一次!"
                }
            }
        };
    }
}