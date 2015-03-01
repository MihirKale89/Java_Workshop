package app.canvas.mihir.multiconverterapp.Activities;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import app.canvas.mihir.multiconverterapp.Classes.LengthConverter;
import app.canvas.mihir.multiconverterapp.Classes.TemperatureConverter;
import app.canvas.mihir.multiconverterapp.Classes.WeightConverter;
import app.canvas.mihir.multiconverterapp.R;

import static android.R.layout.simple_spinner_item;


public class MainActivity extends ActionBarActivity implements AdapterView.OnItemSelectedListener, SeekBar.OnSeekBarChangeListener, AdapterView.OnItemClickListener {

    Spinner spinner;
    SeekBar seekBar;
    TextView tvX1, tvX2, tvY1, tvY2;
    // Create an ArrayAdapter using the string array and a default spinner layout
    ArrayAdapter<CharSequence> adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Specify the layout to use when the list of choices appears
        adapter = ArrayAdapter.createFromResource(this,
                R.array.conversion_options, simple_spinner_item);
        spinner = (Spinner) findViewById(R.id.spinnerOptions);
        seekBar = (SeekBar) findViewById(R.id.seekBarConverter);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);
        //spinner.setOnItemClickListener(this);
        spinner.setOnItemSelectedListener(this);
        seekBar.setOnSeekBarChangeListener(this);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }





    public void updateValues(int progress) {
        TemperatureConverter tc = new TemperatureConverter();
        LengthConverter lc = new LengthConverter();
        WeightConverter wc = new WeightConverter();
        tvX1 = (TextView) findViewById(R.id.hllX1);
        tvX2 = (TextView) findViewById(R.id.hllX2);
        tvY1 = (TextView) findViewById(R.id.hllY1);
        tvY2 = (TextView) findViewById(R.id.hllY2);
        switch (spinner.getSelectedItemPosition()){
            case 0:
                tvX1.setText("Fahrenheit: ");
                tvX2.setText("");
                tvY1.setText("Celsius: ");
                tvY2.setText("");
                tc.setFahrenheit(progress);
                tc.setCentigrade(progress);
                tvX1.append(""+tc.getFahrenheit());
                tvY1.append(""+(int)tc.getCentigrade());
                break;
            case 1:
                tvX1.setText("Pounds: ");
                tvX2.setText("Oz: ");
                tvY1.setText("Kgs: ");
                tvY2.setText("Grams: ");
                wc.setOunces(progress);
                wc.setGrams(progress);
                tvX1.append(""+wc.getOunces()/16);
                tvX2.append(""+wc.getOunces()%16);
                tvY1.append(""+(int)wc.getGrams()/1000);
                tvY2.append(""+(int)wc.getGrams()%1000);
                break;
            case 2:
                tvX1.setText("Feet: ");
                tvX2.setText("Inches: ");
                tvY1.setText("Meters: ");
                tvY2.setText("Cms: ");
                lc.setInches(progress);
                lc.setCentimeters(progress);
                tvX1.append(""+lc.getInches()/12);
                tvX2.append(""+lc.getInches()%12);
                tvY1.append(""+(int)lc.getCentimeters()/100);
                tvY2.append(""+(int)lc.getCentimeters()%100);

                break;
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        tvX1 = (TextView) findViewById(R.id.hllX1);
        tvX2 = (TextView) findViewById(R.id.hllX2);
        tvY1 = (TextView) findViewById(R.id.hllY1);
        tvY2 = (TextView) findViewById(R.id.hllY2);
        seekBar = (SeekBar) findViewById(R.id.seekBarConverter);
        seekBar.setProgress(0);
        switch (spinner.getSelectedItemPosition()){
            case 0:
                tvX1.setText("Fahrenheit: ");
                tvX2.setText("");
                tvY1.setText("Celsius: ");
                tvY2.setText("");
                break;
            case 1:
                tvX1.setText("Pounds: ");
                tvX2.setText("Oz: ");
                tvY1.setText("Kgs: ");
                tvY2.setText("Grams: ");
                break;
            case 2:
                tvX1.setText("Feet: ");
                tvX2.setText("Inches: ");
                tvY1.setText("Meters: ");
                tvY2.setText("Cms: ");
                break;
        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        updateValues(progress);
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }
}
