package com.mutakin.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val btnRoll: FloatingActionButton = findViewById(R.id.btn_roll)

        btnRoll.setOnClickListener {
            rollDice()
        }
    }

    private fun rollDice() {
        val resultText: TextView = findViewById(R.id.result_text)
        val dice: ImageView = findViewById(R.id.dice)
        val randomInt = Random.nextInt(6) + 1

        val animation = AnimationUtils.loadAnimation(this, R.anim.dice_animation)
        dice.startAnimation(animation)

        Handler().postDelayed({

            var drawable: Int = when (randomInt) {
                1 -> R.drawable.dice_1
                2 -> R.drawable.dice_2
                3 -> R.drawable.dice_3
                4 -> R.drawable.dice_4
                5 -> R.drawable.dice_5
                6 -> R.drawable.dice_6
                else -> R.drawable.empty_dice
            }

            dice.setImageDrawable(resources.getDrawable(drawable, applicationContext.theme))
            resultText.text = "$randomInt"
        }, 800)


    }

}