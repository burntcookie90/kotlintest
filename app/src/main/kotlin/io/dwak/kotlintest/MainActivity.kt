package io.dwak.kotlintest

import android.os.Bundle
import android.support.v7.app.ActionBarActivity
import android.util.Log
import android.widget.Button
import android.widget.TextView

public class MainActivity : ActionBarActivity() {
    private var valueArray = Array(50000, { i -> i })

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val testText = findViewById(R.id.testText) as TextView
        val testButton = findViewById(R.id.testButton) as Button
        var counter = 0
        testButton.setOnClickListener {
            valueArray.filter { isEven(value = it) }
                    .map({ "Value: $it" })
                    .forEach({
                        Log.d("TEST", "$it")
                        counter++
                    })
            testText.setText("$counter")
        }
    }

    fun isEven(value : Int) : Boolean{
        return value % 2 == 0;
    }
}