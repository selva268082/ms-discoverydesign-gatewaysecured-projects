package com.java8.features;

 

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class DateFormat {

    public static void main(String[] args) {
        List<String> dates = changeDateFormat(Arrays.asList("2010/03/30", "15/12/2016", "11-15-2012", "20130720"));
        for(String date : dates) {
            System.out.println(date);
        }
    }

    public static List<String> changeDateFormat(List<String> dates) {
        String s;
        Format formatter;
        Date date = new Date();
        formatter = new SimpleDateFormat("yyyyMMdd");
// 2012-12-01
        List lst=new ArrayList();
        for(String dateF: dates){
            s = formatter.format(date);
           // System.out.println(s);
            lst.add(s);
        }
        return lst;

    }
}
