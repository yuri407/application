package com.exampley.getsensorlist2;


import androidx.appcompat.app.AppCompatActivity;

import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    TextView mTxtSensors;
    SensorManager sensorMgr;
    List<Sensor> sensorList;
    Button mretrieve_sensors_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTxtSensors = findViewById(R.id.txtSensors);
        mTxtSensors.setMovementMethod(new ScrollingMovementMethod());
        mretrieve_sensors_btn = findViewById(R.id.retrieve_sensors_btn);
        mretrieve_sensors_btn.setOnClickListener(this);
    }
    @Override
    public void onClick(View view) {
        sensorMgr = (SensorManager) getSystemService(SENSOR_SERVICE);
        sensorList = sensorMgr.getSensorList(Sensor.TYPE_ALL);
        mTxtSensors.append("(# Sensor: " + sensorList.size() + ")\n\n");
        for (Sensor sensor : sensorList) {
            mTxtSensors.append("Sensor name :" + sensor.getName() + "\n");
            mTxtSensors.append("Sensor type :" + sensor.getType() + "\n\n");
        }

    }
}