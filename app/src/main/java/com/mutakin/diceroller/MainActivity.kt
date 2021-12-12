package com.mutakin.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    private lateinit var btnRoll: FloatingActionButton
    private lateinit var diceImage: ImageView
    private lateinit var resultText: TextView
    private lateinit var animation: Animation
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        btnRoll = findViewById(R.id.btn_roll)
        diceImage = findViewById(R.id.dice)
        resultText = findViewById(R.id.result_text)
        animation = AnimationUtils.loadAnimation(this, R.anim.dice_animation)

        btnRoll.setOnClickListener {
            rollDice()
        }
    }

    private fun rollDice() {
        val randomInt = Random.nextInt(6) + 1
        diceImage.startAnimation(animation)

        Handler().postDelayed({
            val drawable: Int = when (randomInt) {
                1 -> R.drawable.dice_1
                2 -> R.drawable.dice_2
                3 -> R.drawable.dice_3
                4 -> R.drawable.dice_4
                5 -> R.drawable.dice_5
                6 -> R.drawable.dice_6
                else -> R.drawable.empty_dice
            }

            diceImage.setImageResource(drawable)
            resultText.text = "$randomInt"
        }, 800)


    }

}