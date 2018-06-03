package matsumana.com.omikujiapp

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        val button = findViewById(R.id.button_id)
        getOmikujiButton.setOnClickListener {
            // 画面上に文字を出力
//            Log.v("MainActivity","Button Clicked")
            val results = arrayOf("大吉","吉","中吉","小吉","末吉","凶","大凶")

//            val n = Random().nextInt(10 )
            val n = Random().nextInt(results.count())

            if(n == 0){
//                resultTextView.setTextColor(Color.RED)
//                resultTextView.setTextColor(Color.parseColor("#ff0000"))
                resultTextView.setTextColor(Color.argb(255,255,0,0))
            }else{
                resultTextView.setTextColor(Color.parseColor("#808080"))
            }

//            resultTextView.text = n.toString()
            resultTextView.text = results.get(n)
        }
    }
}
