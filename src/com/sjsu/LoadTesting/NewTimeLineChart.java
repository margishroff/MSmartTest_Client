 package com.sjsu.LoadTesting;
 

 import com.vaadin.addon.charts.Chart;
 
import com.vaadin.addon.charts.model.ChartType;
import com.vaadin.addon.charts.model.Configuration;
import com.vaadin.addon.charts.model.DataSeries;
import com.vaadin.addon.charts.model.HorizontalAlign;
import com.vaadin.addon.charts.model.LayoutDirection;
import com.vaadin.addon.charts.model.Legend;
import com.vaadin.addon.charts.model.ListSeries;
import com.vaadin.addon.charts.model.PlotOptionsColumn;
import com.vaadin.addon.charts.model.PlotOptionsSpline;
import com.vaadin.addon.charts.model.Tooltip;
import com.vaadin.addon.charts.model.VerticalAlign;
import com.vaadin.addon.charts.model.XAxis;
import com.vaadin.addon.charts.model.YAxis;
import com.vaadin.addon.charts.model.ZoomType;
import com.vaadin.addon.charts.model.style.SolidColor;
import com.vaadin.addon.charts.model.style.Style;
import com.vaadin.addon.timeline.Timeline;
import com.vaadin.data.Item;
import com.vaadin.ui.Component;

public class NewTimeLineChart  {

	public String getDescription() {
        return "Dual axes, line and column";
    }

    public Component getChart() {
        Chart chart = new Chart();

        Configuration conf = chart.getConfiguration();

        conf.getChart().setZoomType(ZoomType.XY);

        conf.setTitle("Response time & Latency of JMeter Test Result");
        conf.setSubTitle("MSmartTest");

        XAxis x = new XAxis();
       // x.setCategories("Thread1","Thread2","Thread3","Thread4","Thread5");
        String[] thread_arr = new String[Load_Constants.arrays_thread.size()];
        thread_arr = Load_Constants.arrays_thread.toArray(thread_arr);
        
        
        x.setCategories(thread_arr);
        conf.addxAxis(x);

        YAxis primary = new YAxis();
        primary.setTitle("Latency");
        Style style = new Style();
        style.setColor(new SolidColor("#89A54E"));
        primary.getTitle().setStyle(style);
        conf.addyAxis(primary);

        YAxis snd = new YAxis();
        snd.setTitle("Response Time (ms)");
        snd.setOpposite(true);
        style = new Style();
        style.setColor(new SolidColor("#4572A7"));
        snd.getTitle().setStyle(style);
        conf.addyAxis(snd);

        Tooltip tooltip = new Tooltip();
      //  tooltip.setFormatter("this.x +': '+ this.y + (this.series.name == 'Response Time' ? ' ms' )");
        //tooltip.setFormatter("this.x +': '+ this.y )");
        conf.setTooltip(tooltip);

        Legend legend = new Legend();
        legend.setLayout(LayoutDirection.VERTICAL);
        legend.setHorizontalAlign(HorizontalAlign.LEFT);
        legend.setX(120);
        legend.setVerticalAlign(VerticalAlign.TOP);
        legend.setY(100);
        legend.setFloating(true);
        legend.setBackgroundColor("#FFFFFF");
        conf.setLegend(legend);

       
        String[] thread_res = new String[Load_Constants.arrays_thread.size()];
        //thread_res = Load_Constants.arrays_response.toArray(thread_res);
        thread_res=Load_Constants.arrays_response.toArray(thread_res);
         
       
        final Number[] ints = new Number[thread_res.length];
        for (int i=0; i < thread_res.length; i++) {
            ints[i] = Integer.parseInt(thread_res[i]);
        }
       
        DataSeries series = new DataSeries();
        series.setPlotOptions(new PlotOptionsColumn());
        
       // PlotOptionsSpline pl=new PlotOptionsSpline();
        //series.setPlotOptions(pl);
        series.setName("Response Time");
        //series.setData(res_time);
        series.setData(ints);
        
        System.out.println("Response time array" + Load_Constants.arrays_response);
        System.out.println("Response time numbber array" + thread_res);
        
       // series.setData(response_arr);
        series.setyAxis(1);
        conf.addSeries(series);

        String[] thread_lat = new String[Load_Constants.arrays_thread.size()];
        
        thread_lat=Load_Constants.arrays_latency.toArray(thread_lat);
         
       
        final Number[] lats = new Number[thread_lat.length];
        for (int i=0; i < thread_lat.length; i++) {
            lats[i] = Integer.parseInt(thread_lat[i]);
        }
       
        series = new DataSeries();
        PlotOptionsSpline plotOptions = new PlotOptionsSpline();
        series.setPlotOptions(plotOptions);
        series.setName("Latency");
        series.setData(lats);
        plotOptions.setColor(new SolidColor("#89A54E"));
        conf.addSeries(series);

        return chart;
    }
}