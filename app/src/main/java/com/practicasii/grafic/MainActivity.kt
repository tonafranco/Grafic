package com.practicasii.grafic

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.github.mikephil.charting.charts.PieChart
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry
import com.github.mikephil.charting.formatter.PercentFormatter
import com.github.mikephil.charting.utils.ColorTemplate
import com.practicasii.grafic.databinding.ActivityMainBinding
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        var myChart: PieChart = binding.pieChart1
        var dataList: ArrayList<PieEntry> = arrayListOf()

        for (i in 0 until 5){
            dataList.add(PieEntry((Math.random() * 5 + 5).toFloat()))
        }

        var dataSet = PieDataSet(dataList,"Resultados")

        val colors: ArrayList<Int> = ArrayList()
        for (c in ColorTemplate.VORDIPLOM_COLORS){
            colors.add(c)
        }
        dataSet.colors = colors


        var data = PieData(dataSet)
        data.setValueFormatter(PercentFormatter())
        data.setValueTextSize(20f)
        data.setValueTextColor(Color.BLACK)
        myChart.setData(data)

        binding.btnUpdate.setOnClickListener{
            dataList.clear()

            val texto = binding.etValues.text
            val bigArray = texto.split(",")
                for (number in bigArray){
                    dataList.add(PieEntry(number.toFloat()))
                }

            dataSet = PieDataSet(dataList, "Resultados")
            dataSet.colors = colors
            data = PieData(dataSet)
            data.setValueFormatter(PercentFormatter())
            data.setValueTextSize(20f)
            data.setValueTextColor(Color.BLACK)
            myChart.setData(data)
            setContentView(view)
        }

    }
}