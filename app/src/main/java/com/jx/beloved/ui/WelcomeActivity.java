package com.jx.beloved.ui;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.amap.api.location.AMapLocation;
import com.jx.beloved.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class WelcomeActivity extends BaseActivity {


    @BindView(R.id.tvCityName)
    TextView tvCityName;
    @BindView(R.id.tvWeather)
    TextView tvWeather;

    @Override
    protected void initContentView(Bundle savedInstanceState) {
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        startLocation();
    }

    @Override
    public void locationSuccess(AMapLocation aMapLocation) {
        tvCityName.setText(aMapLocation.getCity());
    }

    @Override
    public void locationFailed(String errInfo) {
        Toast.makeText(this,errInfo,Toast.LENGTH_SHORT).show();
    }
}
