package by.st.data.entity.responses;

import by.st.data.entity.DataModel;

public class RateResponse implements DataModel {
    private int Cur_ID;
    private String Date;
    private String Cur_Abbreviation;
    private int Cur_Scale;
    private String Cur_Name;
    private double Cur_OfficialRate;

    public int getCur_ID() {
        return Cur_ID;
    }

    public String getDate() {
        return Date;
    }

    public String getCur_Abbreviation() {
        return Cur_Abbreviation;
    }

    public int getCur_Scale() {
        return Cur_Scale;
    }

    public String getCur_Name() {
        return Cur_Name;
    }

    public double getCur_OfficialRate() {
        return Cur_OfficialRate;
    }
}
