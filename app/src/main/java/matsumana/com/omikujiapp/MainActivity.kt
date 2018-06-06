package matsumana.com.omikujiapp

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import android.widget.ImageView



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

            val omikujiImage = findViewById<View>(R.id.resultOmikuji) as ImageView


            if (results[n] === "大吉" ){
//                resultTextView.setTextColor(Color.RED)
//                resultTextView.setTextColor(Color.parseColor("#ff0000"))
//                ↑でも同じ色を出すことができる
                resultTextView.setTextColor(Color.argb(255,255,0,0))
                //おみくじを変える
                omikujiImage.setImageResource(R.drawable.omikuji_daikichi)

            }else{
                resultTextView.setTextColor(Color.parseColor("#808080"))
                omikujiImage.setImageResource(R.drawable.omikuji)
            }

//            resultTextView.text = n.toString()
            resultTextView.text = results.get(n)
        }
    }
}


