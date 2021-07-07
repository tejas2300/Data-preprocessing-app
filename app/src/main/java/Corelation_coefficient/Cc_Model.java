package Corelation_coefficient;

public class Cc_Model {
    private String xatbt;
    private String yatbt;
    private String xyatbt;

    public Cc_Model(String xatbt, String yatbt, String xyatbt) {
        this.xatbt = xatbt;
        this.yatbt = yatbt;
        this.xyatbt = xyatbt;
    }



    public String getXatbt() {
        return xatbt;
    }

    public void setXatbt(String xatbt) {
        this.xatbt = xatbt;
    }

    public String getYatbt() {
        return yatbt;
    }

    public void setYatbt(String yatbt) {
        this.yatbt = yatbt;
    }

    public String getXyatbt() {
        return xyatbt;
    }

    public void setXyatbt(String xyatbt) {
        this.xyatbt = xyatbt;
    }
}
