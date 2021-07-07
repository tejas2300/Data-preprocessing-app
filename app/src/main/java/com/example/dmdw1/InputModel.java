package com.example.dmdw1;

public class InputModel {
    private String xvalue;
    private String yvalue;
    private String xyvalue;

    public InputModel(String xvalue, String yvalue, String xyvalue) {
        this.xvalue = xvalue;
        this.yvalue = yvalue;
        this.xyvalue = xyvalue;
    }


    public String getXvalue() {
        return xvalue;
    }

    public void setXvalue(String xvalue) {
        this.xvalue = xvalue;
    }

    public String getYvalue() {
        return yvalue;
    }

    public void setYvalue(String yvalue) {
        this.yvalue = yvalue;
    }

    public String getXyvalue() {
        return xyvalue;
    }

    public void setXyvalue(String xyvalue) {
        this.xyvalue = xyvalue;
    }
}
