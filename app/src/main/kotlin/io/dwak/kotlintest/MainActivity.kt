package io.dwak.kotlintest

import android.os.Bundle
import android.support.v7.app.ActionBarActivity
import android.util.Log
import android.widget.Button
import android.widget.Toast

public class MainActivity : ActionBarActivity() {
    private var valueArray = Array(50000, { i -> i })

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val testButton = findViewById(R.id.testButton) as Button
        var counter = 0
        testButton.setOnClickListener {
            valueArray.filter { it % 2 == 0 }
                    .map({ "Value: $it" })
                    .forEach { counter++ }
            Log.d("Test", "$counter")
        }

    }
}