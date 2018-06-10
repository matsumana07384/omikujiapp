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

//            val results = arrayOf("大吉","吉","中吉","小吉","末吉","凶","大凶")
//            val n = Random().nextInt(10 )
//            val n = Random().nextInt(results.count())

            val results = OmikujiResults.values()

            val n = Random().nextInt(OmikujiResults.values().count())
            val omikujiImage = findViewById<View>(R.id.resultOmikuji) as ImageView

            //インスタンス化
//            outPutOmikuji(omikuji = results[n])


            when(results[n]){

                OmikujiResults.大吉 -> omikujiImage.setImageResource(R.drawable.omikuji_daikichi)

                OmikujiResults.吉 -> omikujiImage.setImageResource(R.drawable.omikuji_kichi)

                OmikujiResults.中吉 -> omikujiImage.setImageResource(R.drawable.omikuji_chuukichi)

                OmikujiResults.小吉 -> omikujiImage.setImageResource(R.drawable.omikuji_syoukichi)

                OmikujiResults.末吉 -> omikujiImage.setImageResource(R.drawable.omikuji_suekichi)

                OmikujiResults.凶 -> omikujiImage.setImageResource(R.drawable.omikuji_kyou)

                OmikujiResults.大凶 -> omikujiImage.setImageResource(R.drawable.omikuji_daikyou)


            }

//            resultTextView.text = results[n].toString()


//            if (results[n] === OmikujiResults.大吉 ){
////                resultTextView.setTextColor(Color.RED)
////                resultTextView.setTextColor(Color.parseColor("#ff0000"))
////                ↑でも同じ色を出すことができる
//                resultTextView.setTextColor(Color.argb(255,255,0,0))
//                //おみくじを変える
//                omikujiImage.setImageResource(R.drawable.omikuji_daikichi)
//
//            }else if (results[n] === OmikujiResults.中吉 ){
//                //おみくじを変える
//                omikujiImage.setImageResource(R.drawable.omikuji_chuukichi)
//
//            }
//            else{
//                resultTextView.setTextColor(Color.parseColor("#808080"))
//                omikujiImage.setImageResource(R.drawable.omikuji)
//
//            }

//            resultTextView.text = n.toString()
//            resultTextView.text = results.get(n)
            resultTextView.text = results.get(n).toString()
        }
    }
  }


