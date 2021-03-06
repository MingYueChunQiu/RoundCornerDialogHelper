package com.mingyuechunqiu.roundcornerdialoghelperproject;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.mingyuechunqiu.roundcornerdialoghelper.bean.RCDHTextOption;
import com.mingyuechunqiu.roundcornerdialoghelper.bean.RoundCornerDialogHelperOption;
import com.mingyuechunqiu.roundcornerdialoghelper.dialogFragment.RoundCornerDialogFragment;
import com.mingyuechunqiu.roundcornerdialoghelper.framework.OnRCDHClickLeftButtonListener;
import com.mingyuechunqiu.roundcornerdialoghelper.framework.OnRCDHClickRightButtonListener;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AppCompatButton btnTest = findViewById(R.id.btn_test);
        AppCompatButton btnCustom = findViewById(R.id.btn_custom);
        btnTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RoundCornerDialogFragment fragment = RoundCornerDialogFragment.newInstance();
                fragment.show(getSupportFragmentManager(), RoundCornerDialogFragment.class.getSimpleName());
            }
        });
        btnCustom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RCDHTextOption textOption = new RCDHTextOption.Builder()
                        .setTextColor(Color.RED)
                        .setGravity(Gravity.RIGHT)
                        .setTextSize(20)
                        .build();
                RoundCornerDialogHelperOption option = new RoundCornerDialogHelperOption.Builder()
                        .setCornerRadius(20)
                        .setBgColor(Color.RED)
                        .setTitleTextSize(24)
                        .setTitlePadding(30)
                        .setTitleTextAppearance(R.style.AppCompatTextView_BOLD_ITALIC)
                        .setTitleBgColor(Color.GRAY)
                        .setContentBgColor(Color.GREEN)
                        .setLeftButtonTextColor(Color.GREEN)
                        .setLeftButtonBgColor(Color.BLUE)
                        .setRightButtonTextOption(textOption)
                        .setRightButtonTextColor(Color.BLACK)
                        .setWidth(getResources().getDisplayMetrics().widthPixels)
                        .setHeight(getResources().getDisplayMetrics().heightPixels)
                        .setCancelable(false)
                        .setWindowAnimationStyleResId(R.style.Dialog_Animation)
                        .setOnRCDHClickLeftButtonListener(new OnRCDHClickLeftButtonListener() {
                            @Override
                            public void onClickLeftButton(RoundCornerDialogFragment fragment, TextView v) {
                                Toast.makeText(MainActivity.this, "左边", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setOnRCDHClickRightButtonListener(new OnRCDHClickRightButtonListener() {
                            @Override
                            public void onClickRightButton(RoundCornerDialogFragment fragment, TextView v) {
                                Toast.makeText(MainActivity.this, "右边", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .build();
                RoundCornerDialogFragment fragment = RoundCornerDialogFragment.newInstance(option);
                fragment.show(getSupportFragmentManager(), RoundCornerDialogFragment.class.getSimpleName());
            }
        });
    }
}
