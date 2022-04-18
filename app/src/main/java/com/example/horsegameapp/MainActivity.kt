package com.example.horsegameapp

import android.graphics.Point
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.TypedValue
import android.view.View
import android.widget.ImageView
import android.widget.TableRow
import com.example.horsegameapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //setContentView(R.layout.activity_main)

        initScreenGame()

    }

    private fun initScreenGame() {
        setSizeBoard()
        hideMessage()
    }

    private fun setSizeBoard() {
        var iv: ImageView

        val display = windowManager.defaultDisplay
        val size = Point()
        display.getSize(size)
        val width = size.x

        var width_dp = (width / getResources().displayMetrics.density)

        var lateralMarginsDP = 0.0
        val width_cell = (width_dp - lateralMarginsDP)/8
        val height_cell = width_cell


        for(i in 0..7) {
            for(j in 0..7) {
                iv = findViewById(resources.getIdentifier("c$i$j", "id", packageName))

                var height = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
                    height_cell.toFloat(), getResources().displayMetrics).toInt()

                var width = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
                    width_cell.toFloat(), getResources().displayMetrics).toInt()

                iv.setLayoutParams(TableRow.LayoutParams(width, height))

            }
        }
    }

    private fun hideMessage() {
        binding.lyMessage.visibility = View.INVISIBLE
    }
}