package com.jx.beloved.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;
import com.jx.beloved.ui.model.LocationInterface;

/**
 * Created by zwj on 2017/4/6.
 */

public abstract class BaseActivity extends AppCompatActivity implements AMapLocationListener,LocationInterface {
    private AMapLocationClient mLocationClient;
    public BaseActivity() {

    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initLocation();
        initContentView(savedInstanceState);
    }

    @Override
    public void initLocation() {
        mLocationClient = new AMapLocationClient(this);
        AMapLocationClientOption option = new AMapLocationClientOption();
        option.setLocationMode(AMapLocationClientOption.AMapLocationMode.Battery_Saving);
        option.setOnceLocation(true);
        mLocationClient.setLocationListener(this);
        mLocationClient.setLocationOption(option);
    }

    @Override
    public void startLocation() {
        mLocationClient.startLocation();
    }

    @Override
    protected void onDestroy() {
        if(mLocationClient != null) {
            mLocationClient.onDestroy();
        }
        super.onDestroy();
    }

    @Override
    public void onLocationChanged(AMapLocation aMapLocation) {
        locationResult(aMapLocation);
    }

    @Override
    public void locationSuccess(AMapLocation aMapLocation) {

    }

    @Override
    public void locationFailed(String errInfo) {

    }

    private void locationResult(AMapLocation aMapLocation) {
        if(aMapLocation != null) {
            if(aMapLocation.getErrorCode() == 0) {
                locationSuccess(aMapLocation);
            }else {
                locationFailed(aMapLocation.getErrorInfo());
            }
        }
    }

    protected abstract void initContentView(Bundle savedInstanceState);

}
