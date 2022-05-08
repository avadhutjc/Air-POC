package com.example.calendar_view;

import android.os.Bundle;
import android.app.Activity;
import android.graphics.Color;
import android.view.View;
import android.widget.LinearLayout;

public class GraphActivity extends Activity {
    LinearLayout linearChart;
    LinearLayout linearChart1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graph);
        linearChart = (LinearLayout) findViewById(R.id.linearChart);
        linearChart1 = (LinearLayout) findViewById(R.id.linearChart1);
        drawChart(5);
    }

    public void drawChart(int count) {
        System.out.println(count);

            View view = new View(this);
            View view1 = new View(this);
            view.setBackgroundColor(Color.parseColor("#ff6233"));
            view1.setBackgroundColor(Color.parseColor("#000000"));
            view.setLayoutParams(new LinearLayout.LayoutParams(50, 800));
            view1.setLayoutParams(new LinearLayout.LayoutParams(50, 600));
            LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) view.getLayoutParams();
            LinearLayout.LayoutParams params1 = (LinearLayout.LayoutParams) view.getLayoutParams();
            params.setMargins(30, 0, 10, 0);
            params1.setMargins(50, 0, 70, 0);
            view.setLayoutParams(params);
            view1.setLayoutParams(params1);
            linearChart.addView(view);
            linearChart1.addView(view1);

    }
}