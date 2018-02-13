package rankhep.com.chart

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.github.mikephil.charting.animation.Easing
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.github.mikephil.charting.components.Description
import com.github.mikephil.charting.data.Entry
import kotlinx.android.synthetic.main.activity_main.*
import android.R.attr.entries
import android.view.View


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val points = intArrayOf(5, 3, 7, 8, 4, 3, 3, 6, 4, 1)

        val graphview = findViewById<View>(R.id.GraphView) as GraphView

        //단위는 1씩, 원점은 0, 총 10줄로 나누어진 그래프를 그린다
        graphview.setPoints(points, 1, 0, 10)
        graphview.drawForBeforeDrawView()
    }
}

