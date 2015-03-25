package io.dwak.kotlintest

import android.os.Bundle
import android.support.v7.app.ActionBarActivity
import android.util.Log
import android.widget.Button
import android.widget.TextView

public class MainActivity : ActionBarActivity() {
    val TAG = this.javaClass.getSimpleName();
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
                        Log.d(TAG, "$it")
                        counter++
                    })
            testText.setText("$counter")
        }

        val testObject = TestObject(name = "Vishnu", id = 1)
        Log.d(TAG, "$testObject")
        Log.d(TAG, testObject.name)
        Log.d(TAG, testObject.name.toAlternateCase())
    }

    fun isEven(value : Int) : Boolean = value % 2 == 0
    fun isOdd(value : Int) : Boolean = !isEven(value)

    // Play with extensions
    fun String.toAlternateCase() : String {
        var upperCase = false
        var newString: String = ""
        this.forEach {
            when {
                !upperCase -> {
                    newString += Character.toUpperCase(it)
                }
                else -> {
                    newString += Character.toLowerCase(it)
                }
            }

            upperCase = !upperCase
        }

        return newString
    }

}