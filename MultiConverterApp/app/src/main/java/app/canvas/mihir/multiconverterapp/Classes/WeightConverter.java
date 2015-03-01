package app.canvas.mihir.multiconverterapp.Classes;


import app.canvas.mihir.multiconverterapp.Interfaces.ConverterInterface;

/**
 * Created by Mihir on 11-Feb-15.
 */
public class WeightConverter implements ConverterInterface {

    private int ounces;
    private double grams;

    public int getOunces() {
        return ounces;
    }

    public double getGrams() {
        return grams;
    }

    public void setOunces(int ounces) {
        this.ounces = ounces;
    }

    public void setGrams(int pounds) {
        this.grams = convertX_to_Y((double)pounds);
    }

    @Override
    public double convertX_to_Y(double value) {
        return value * 28.3495;
    }
}
