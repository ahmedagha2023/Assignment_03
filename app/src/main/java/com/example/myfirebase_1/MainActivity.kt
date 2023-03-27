package com.example.myfirebase_1

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var analytics: FirebaseAnalytics

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        analytics = Firebase.analytics

        btn_1.setOnClickListener {
            selectContentEvent("image1", "ImageView", "image")
        }

        btn_2.setOnClickListener {
            trackScreenEvent()
        }

        }

        fun selectContentEvent(id:String, name:String, contentType:String){
            analytics.logEvent(FirebaseAnalytics.Event.SELECT_CONTENT){
                param(FirebaseAnalytics.param.ITEM_ID, id)
                param(FirebaseAnalytics.param.ITEM_NAME, name)
                param(FirebaseAnalytics.param.CONTENT_TYPE, contentType)

            }



        }

        fun trackScreenEvent(){
            analytics.logEvent(FirebaseAnalytics.Event.SCREEN_VIEW){
                param(FirebaseAnalytics.param.SCREEN_VIEW, "main")
                param(FirebaseAnalytics.param.SCREEN_VIEW, "MainActivity")

            }

    }
}