package com.pratwib.myrecyclerview

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide

class DetailActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_NAME = "extra_name"
        const val EXTRA_PHOTO = "extra_photo"
        const val EXTRA_AGE = "extra_age"
        const val EXTRA_PRICE = "extra_price"
        const val EXTRA_POSITION = "extra_position"
        const val EXTRA_DESCRIPTION = "extra_description"
        const val EXTRA_LINK = "extra_link"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val actionbar = supportActionBar
        actionbar!!.title = "Detail"
        actionbar.setDisplayHomeAsUpEnabled(true)

        val tvFootballerName: TextView = findViewById(R.id.tv_footballer_name)
        val imgFootballerPhoto: ImageView = findViewById(R.id.img_footballer_photo)
        val tvFootballerAge: TextView = findViewById(R.id.tv_footballer_age)
        val tvFootballerPrice: TextView = findViewById(R.id.tv_footballer_price)
        val tvFootballerPosition: TextView = findViewById(R.id.tv_footballer_position)
        val tvFootballerDesc: TextView = findViewById(R.id.tv_footballer_description)
        val shareButton: Button = findViewById(R.id.bt_share)

        val footballerName = intent.getStringExtra(EXTRA_NAME)
        val footballerPhoto = intent.getStringExtra(EXTRA_PHOTO)
        val footballerAge = intent.getStringExtra(EXTRA_AGE)
        val footballerPrice = intent.getStringExtra(EXTRA_PRICE)
        val footballerPosition = intent.getStringExtra(EXTRA_POSITION)
        val footballerDesc = intent.getStringExtra(EXTRA_DESCRIPTION)
        val footballerLink = intent.getStringExtra(EXTRA_LINK)

        tvFootballerName.text = footballerName
        Glide.with(this)
            .load(footballerPhoto)
            .into(imgFootballerPhoto)
        tvFootballerAge.text = footballerAge
        tvFootballerPrice.text = footballerPrice
        tvFootballerPosition.text = footballerPosition
        tvFootballerDesc.text = footballerDesc

        shareButton.setOnClickListener {
            val goShare = Intent()
            goShare.action = Intent.ACTION_SEND
            goShare.putExtra(Intent.EXTRA_TEXT, "Hey look at this Best Footballer 2022: $footballerLink")
            goShare.type = "text/plain"
            startActivity(Intent.createChooser(goShare, "Share to:"))
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}