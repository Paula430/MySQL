package com.solvd.models;

import jakarta.xml.bind.annotation.adapters.XmlAdapter;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateAdapter extends XmlAdapter<String, Date> {

    private static final ThreadLocal<DateFormat> dateFormat = new ThreadLocal<DateFormat>() {

        @Override
        protected DateFormat initialValue() {
            return new SimpleDateFormat("yyyy.MMMM.dd");
        }
    };

    @Override
    public Date unmarshal(String v) throws Exception {
        return dateFormat.get().parse(v);
    }

    @Override
    public String marshal(Date v) throws Exception {
        return dateFormat.get().format(v);
    }
}
