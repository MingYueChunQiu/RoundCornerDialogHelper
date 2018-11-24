package com.mingyuechunqiu.roundcornerdialoghelperproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.view.View;

import com.mingyuechunqiu.roundcornerdialoghelper.dialogFragment.RoundCornerDialogFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AppCompatButton btnTest = findViewById(R.id.btn_test);
        btnTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RoundCornerDialogFragment fragment = RoundCornerDialogFragment.newInstance(null);
                fragment.show(getSupportFragmentManager(), RoundCornerDialogFragment.class.getSimpleName());
            }
        });
    }
}
