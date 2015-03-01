package app.canvas.mihir.multiconverterapp.Classes;


import app.canvas.mihir.multiconverterapp.Interfaces.ConverterInterface;

/**
 * Created by Mihir on 11-Feb-15.
 */
public class LengthConverter implements ConverterInterface {

    private int inches;
    private double centimeters;

    public int getInches() {
        return inches;
    }

    public double getCentimeters() {
        return centimeters;
    }

    public void setInches(int inches) {
        this.inches = inches;
    }

    public void setCentimeters(int inches) {
        this.centimeters = convertX_to_Y((double)inches);
    }

    @Override
    public double convertX_to_Y(double value) {
        return value * 2.54;
    }
}
