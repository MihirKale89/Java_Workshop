package app.canvas.mihir.multiconverterapp.Classes;


import app.canvas.mihir.multiconverterapp.Interfaces.ConverterInterface;

/**
 * Created by Mihir on 11-Feb-15.
 */
public class TemperatureConverter implements ConverterInterface {
    int fahrenheit;
    double centigrade;

    public int getFahrenheit() {
        return fahrenheit;
    }

    public double getCentigrade() {
        return centigrade;
    }

    public void setFahrenheit(int fahrenheit) {
        this.fahrenheit = fahrenheit;
    }

    public void setCentigrade(int fahrenheit) {
        this.centigrade = convertX_to_Y((double)fahrenheit);
    }

    @Override
    public double convertX_to_Y(double value) {
        return (value  -  32) * 5/9;
    }
}
