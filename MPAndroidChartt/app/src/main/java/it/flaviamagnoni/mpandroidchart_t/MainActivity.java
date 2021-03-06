package it.flaviamagnoni.mpandroidchart_t;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new Holder();
    }

    class Holder implements View.OnClickListener{
        ImageView ivTitle;
        Button btnLineChart, btnBarChart, btnRadarChart, btnPieChart;
        Animation transBtnDx = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.translate_btn_dx);
        Animation transBtnSx = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.translate_btn_sx);
        Animation fadeIn = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade_in);

        Holder(){
            btnLineChart = findViewById(R.id.btnLineChart);
            btnBarChart = findViewById(R.id.btnBarChart);
            btnRadarChart = findViewById(R.id.btnRadarChart);
            btnPieChart = findViewById(R.id.btnPieChart);
            ivTitle = findViewById(R.id.ivTitle);

            btnLineChart.setOnClickListener(this);
            btnBarChart.setOnClickListener(this);
            btnRadarChart.setOnClickListener(this);
            btnPieChart.setOnClickListener(this);

            ivTitle.startAnimation(fadeIn);
            btnLineChart.startAnimation(transBtnSx);
            btnBarChart.startAnimation(transBtnDx);
            btnRadarChart.startAnimation(transBtnSx);
            btnPieChart.startAnimation(transBtnDx);

        }

        @Override
        public void onClick(View v) {
            if (v.getId()==R.id.btnLineChart)
                startActivity(new Intent(MainActivity.this, LineChartActivity.class));
            if (v.getId() == R.id.btnBarChart)
                startActivity(new Intent(MainActivity.this, BarChartActivity.class));
            if (v.getId() == R.id.btnRadarChart)
                startActivity(new Intent(MainActivity.this, RadarChartActivity.class));
            if (v.getId()== R.id.btnPieChart){
                startActivity(new Intent(MainActivity.this, PieChartActivity.class));
            }
        }
    }
}
