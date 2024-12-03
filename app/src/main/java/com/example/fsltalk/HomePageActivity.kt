package com.example.fsltalk

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class HomePageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_homepage)

        val sadImageView: ImageView = findViewById(R.id.sadImageView)
        val saddImageView: ImageView = findViewById(R.id.saddImageView)
        val sadddImageView: ImageView = findViewById(R.id.sadddImageView)

        sadImageView.setOnClickListener {
            openYouTubeLink("https://www.youtube.com/watch?v=-jZVJe9oa-M")
        }

        saddImageView.setOnClickListener {
            openYouTubeLink("https://www.youtube.com/watch?v=Q3_Gw03jeus")
        }

        sadddImageView.setOnClickListener {
            openYouTubeLink("https://www.youtube.com/watch?v=PU3tNF54RQM")
        }
    }

    private fun openYouTubeLink(url: String) {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        startActivity(intent)
    }
}
