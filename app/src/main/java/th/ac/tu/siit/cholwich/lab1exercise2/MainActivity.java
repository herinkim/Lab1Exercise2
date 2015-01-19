package th.ac.tu.siit.cholwich.lab1exercise2;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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

    public void convertTemperature(View v) {

        // Get the user input to convert the temperature
        EditText etInput = (EditText) findViewById(R.id.etInput);
        String s = etInput.getText().toString();
        double inputVal = Double.parseDouble(s);


        // Get the input temperature type
        RadioGroup rgFrom = (RadioGroup) findViewById(R.id.rgFrom);
        int convertFrom = rgFrom.getCheckedRadioButtonId();

        // Get the output temperature type
        RadioGroup rgTo = (RadioGroup) findViewById(R.id.rgTo);
        int convertTo = rgTo.getCheckedRadioButtonId();

        double result = inputVal;

        // Check what the input temperature type is
        if (convertFrom == R.id.rbFrmC)
        {
            // Convert from Celsius
            if(convertTo == R.id.rbToF)
            {
                // Convert to Fahrenheit
                result = inputVal * (9.0/5.0) + 32;
            }
            else if(convertTo == R.id.rbToK)
            {
                // Convert to Kelvin
                result = inputVal + 273.15;
            }
        }
        else if(convertFrom == R.id.rbFrmF)
        {
            // Convert from Fahrenheit
            if(convertTo == R.id.rbToC)
            {
                // Convert to Celsius
                result = (inputVal-32)*(5.0/9.0);
            }
            else if(convertTo == R.id.rbToK)
            {
                // Convert to Kelvin
                result = (inputVal + 459.67)*(5.0/9.0);
            }

        }
        else if (convertFrom == R.id.rbFrmK)
        {
            // Convert from Kelvin
            if(convertTo == R.id.rbToC)
            {
                // Convert to Celsius
                result = inputVal - 273.15;

            }
            else if(convertTo == R.id.rbToF)
            {
                // Convert to Fahrenheit
                result = inputVal*(5.0/9.0) -459.67;
            }
        }

        TextView t = (TextView) findViewById(R.id.tvOutput);
        t.setText(Double.toString(result));
    }
}
