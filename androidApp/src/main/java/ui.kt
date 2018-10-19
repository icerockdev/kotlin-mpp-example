package org.konan.multiplatform

import android.app.Application
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.LinearLayout
import android.widget.TextView
import shared.model.repository.GitHubRepository
import kotlin.properties.Delegates

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        println("Application init")

        val repository = GitHubRepository()
        repository.loadRepositories()
    }
}

class MainActivity : AppCompatActivity() {

    private var rootLayout: LinearLayout by Delegates.notNull()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rootLayout = findViewById(R.id.main_view) as LinearLayout
        rootLayout.removeAllViews()

        val tv = TextView(this)
        rootLayout.addView(tv)
    }
}