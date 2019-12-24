package com.example.help.menulist.graph;


import android.content.Intent;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;

import com.example.help.DBHelper;
import com.example.help.R;

import org.achartengine.ChartFactory;
import org.achartengine.GraphicalView;
import org.achartengine.chart.BarChart;
import org.achartengine.model.XYMultipleSeriesDataset;
import org.achartengine.model.XYSeries;
import org.achartengine.renderer.XYMultipleSeriesRenderer;
import org.achartengine.renderer.XYSeriesRenderer;

public class graph_next extends AppCompatActivity{

    private GraphicalView mChartView;

    private String[] mMonth = new String[]{
            "나의 배출량", "평균 배출량"
    };
    static int my=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graph_next);

        Intent intent = getIntent(); // 보여주기 식으로 정보를 받기 위해 선언

        my+=intent.getIntExtra("my",0); // 입력

        drawChart(my, 930);
    }

    private void drawChart(int my, int avg) {

        int[] x = {0, 1};
        int[] income = {my, avg};

        XYSeries incomeSeries = new XYSeries("");

        for(int i = 0; i<x.length; i++){
            incomeSeries.add(i, income[i]);
        }

        XYMultipleSeriesDataset dataset = new XYMultipleSeriesDataset();

        dataset.addSeries(incomeSeries);

        XYSeriesRenderer incomeRenderer = new XYSeriesRenderer();

        incomeRenderer.setColor(Color.parseColor("#A7BF8B")); // 그래프 색

        incomeRenderer.setFillPoints(true);

        incomeRenderer.setLineWidth(2);

        incomeRenderer.setDisplayChartValues(true);

        incomeRenderer.setChartValuesTextSize(50); // 그래프 위 글씨 크기

        incomeRenderer.setChartValuesTextAlign(Paint.Align.RIGHT); // 그래프 위 글씨 위치

        incomeRenderer.setDisplayChartValuesDistance(10); // 차트 값 저항 설정

        XYMultipleSeriesRenderer multiRenderer = new XYMultipleSeriesRenderer();

        multiRenderer.setOrientation(XYMultipleSeriesRenderer.Orientation.HORIZONTAL);

        multiRenderer.setXLabels(0);

        //multiRenderer.setChartTitle("title");

        //multiRenderer.setXTitle("X title");

        //multiRenderer.setYTitle("Y title");

        //multiRenderer.setChartTitleTextSize(28);

        //multiRenderer.setAxisTitleTextSize(24);

        multiRenderer.setLabelsTextSize(45); // x text 크기 (나의 배출량, 평균 배출량)

        multiRenderer.setXLabelsColor(Color.WHITE); // x축 글자 색상

        //multiRenderer.setMarginsColor(Color.WHITE); // 마진값 색상

        multiRenderer.setAxesColor(Color.WHITE); // x축 경계선 색상

        multiRenderer.setZoomButtonsVisible(false); // 확대 축소 가시성 설정

        multiRenderer.setPanEnabled(false,false); // 그래프를 사용하여 양쪽 축에서 이동하는 팬 열성 설정

        multiRenderer.setClickEnabled(false);

        multiRenderer.setZoomEnabled(false,false); // 양쪽 축에서 확대/축소를 false으로 설정

        multiRenderer.setShowGridY(false); // y축에 표시할 선 설정

        multiRenderer.setShowGridX(false); // x축에 표시할 선 설정

        multiRenderer.setFitLegend(true); // 화면 크기에 맞게 ?? 설정

        multiRenderer.setShowGrid(false); // 화면에 선표시 설정

        multiRenderer.setZoomEnabled(false); // 줌 기능을 false로 설정

        multiRenderer.setExternalZoomEnabled(false); // 외부 확대/축소 기능을 false로 설정

        multiRenderer.setAntialiasing(true); // 서식을 지정할 그래프의 선 표시 설정(그래픽 사용)

        multiRenderer.setInScroll(false); //스크롤을 false로 설정

        multiRenderer.setLegendHeight(10); // 그래프의 범례 높이 설정

        multiRenderer.setXLabelsAlign(Paint.Align.CENTER); // x축 레이블 정렬 설정

        multiRenderer.setYLabelsAlign(Paint.Align.LEFT); // y축 레이블 정렬 설정

        multiRenderer.setTextTypeface("sans_serif", Typeface.NORMAL); // 텍스트 스타일 설정

        multiRenderer.setYLabels(0); // y축에 표시할 값의 없음 설정

        multiRenderer.setYAxisMin(0);

        multiRenderer.setYAxisMax(1000); // y축 최대값 설정. 그래프 내에서 정적 값을 사용하기 때문에 y축 최대값을 1000으로 설정할 겁니다. , 동적 값을 사용하는 경우 최대 y 값을 가져오고 여기에 설정하십시오.

        multiRenderer.setXAxisMin(-1.2); // 그래프를 오른쪽으로 0.5로 이동하는 데 사용되는 설정

        multiRenderer.setXAxisMax(2.2); // x축에 표시할 최대값 설정

        multiRenderer.setBarSpacing(0.5); //두 막대 사이의 막대 크기 또는 공간 설정

        multiRenderer.setBackgroundColor(Color.TRANSPARENT); // 그래프의 배경색을 투명하게 설정

        multiRenderer.setMarginsColor(Color.parseColor("#A7BF8B")); // 그래프의 여백 색상을 투명하게 설정

        multiRenderer.setApplyBackgroundColor(true);

        multiRenderer.setMargins(new int[]{1, 1, 50, 1}); // 그래프의 여백 크기 설정(맨 위, 왼쪽, 아래쪽, 오른쪽)

        for(int i = 0; i<x.length; i++){
            multiRenderer.addXTextLabel(i,mMonth[i]);
        }
        // multipleRender 및 discuseRender를 다중 렌더러에 추가
        // 참고: 데이터세트와 렌더러를 다중 렌더러에 추가하는 순서는 동일해야 한다.
        multiRenderer.addSeriesRenderer(incomeRenderer);

        LinearLayout layout = (LinearLayout)findViewById(R.id.char_bar); // 이 부분은 xml에 그래프를 표시하는데 사용된다.

        layout.removeAllViews(); // 차트를 그리기 전에 뷰를 모두 제거하십시오.

        mChartView = ChartFactory.getBarChartView(this,dataset,multiRenderer, BarChart.Type.DEFAULT); // 도면 막대 차트

        layout.addView(mChartView, new LinearLayout.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT, LinearLayout.LayoutParams.FILL_PARENT));
    }
}
