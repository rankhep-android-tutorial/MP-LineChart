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
import android.util.Log
import android.view.View
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet
import com.github.mikephil.charting.components.YAxis
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.components.AxisBase
import com.github.mikephil.charting.formatter.IAxisValueFormatter
import java.text.SimpleDateFormat
import java.util.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        val points = intArrayOf(5, 3, 7, 8, 4, 3, 3, 6, 4, 1)

//        val graphview = findViewById<View>(R.id.GraphView) as GraphView
//
//        //단위는 1씩, 원점은 0, 총 10줄로 나누어진 그래프를 그린다
//        graphview.setPoints(points, 1, 4, 10)
//        graphview.drawForBeforeDrawView()

        val entries = ArrayList<Entry>().apply {
            add(Entry(1f, 1f))
            add(Entry(2f, 2f))
            add(Entry(3f, 0f))
            add(Entry(4f, 4f))
            add(Entry(5f, 3f))
            add(Entry(6f, 3f))
            add(Entry(7f, 3f))
        }

        val lineDataSet = LineDataSet(entries, "")
        lineDataSet.run {
            lineWidth = 5f
            circleRadius = 8f
            setCircleColor(Color.parseColor("#FFA1B4DC"))
            setCircleColorHole(Color.BLUE)
            color = Color.parseColor("#FFA1B4DC")
            setDrawCircleHole(false)
            setDrawCircles(true)
            setDrawHorizontalHighlightIndicator(false)
            setDrawHighlightIndicators(false)
            setDrawValues(false)
        }


        val lineData = LineData(lineDataSet)
        chart.data = lineData

        val dateFormat = SimpleDateFormat("MM")
        val date = Date()
        var mon = dateFormat.format(date)

        var month = HashMap<Int, String>()
        month.run {
            put(1, "11")
            put(2, "12")
            put(3, "01")
            put(4, mon)
            put(5, "03")
            put(6, "04")
            put(7, "05")
//            put(8, "8")
//            put(9, "9")
//            put(10, "10")
//            put(11, "11")
//            put(12, "12")

        }
        val xAxis = chart.xAxis
        xAxis.run {
            position = XAxis.XAxisPosition.BOTTOM
            textColor = Color.BLACK
            enableGridDashedLine(8f, 24f, 0f)
//            axisMinimum = 1f        //x좌표의 최솟값
//            axisMaximum = 12f        //x좌표의 최댓값
            setLabelCount(7, true)
            valueFormatter = IAxisValueFormatter { value, axis -> month[value.toInt()].toString() }
            setDrawGridLines(false)
        }
        val yLAxis = chart.axisLeft
        yLAxis.run {
            setDrawGridLines(false)
            setDrawLabels(false)    //데이터 값
            setDrawAxisLine(false)  //선
//            textColor = Color.BLACK
        }


        val yRAxis = chart.axisRight
        yRAxis.run {
            setDrawGridLines(false)
            setDrawLabels(false)
            setDrawAxisLine(false)
        }


        val description = Description()
        description.text = ""

        chart.isDoubleTapToZoomEnabled = false
        chart.setDrawGridBackground(false)
        chart.description = description
//        chart.animateY(2000, Easing.EasingOption.EaseInCubic)
        chart.invalidate()
    }
}

