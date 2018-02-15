package com.example.alec.tipcalculatorfix;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private CheckBox split;
    private EditText billAmt;
    private EditText dinerNo;
    private SeekBar bar;
    private TextView barLabel;
    private TextView finalAnswer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        billAmt = findViewById(R.id.billAmtInput);
        dinerNo = findViewById(R.id.dinerNoInput);
        bar = findViewById(R.id.seek);
        barLabel = findViewById(R.id.barLabel);
        finalAnswer = findViewById(R.id.finalAnswer);
        split = findViewById(R.id.split);

        bar.setOnSeekBarChangeListener(
                new SeekBar.OnSeekBarChangeListener() {
                    @Override
                    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                        barLabel.setText(i+"");
                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {

                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {

                    }
                }
        );
    }

    public void buttonPressed(View v){
        int progress = bar.getProgress();
        Toast.makeText(this, "Progress: "+progress, Toast.LENGTH_SHORT).show();


        if(split.isChecked()){
            finalAnswer.setText( ((Double.parseDouble(billAmt.getText().toString())*progress)/Double.parseDouble(dinerNo.getText().toString()))/100 + "");
        }
        else{
            finalAnswer.setText( Double.parseDouble(billAmt.getText().toString())*progress/100 + "");
        }
    }
}
