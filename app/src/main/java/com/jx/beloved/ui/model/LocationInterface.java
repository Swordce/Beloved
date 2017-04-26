package com.jx.beloved.ui.model;

import com.amap.api.location.AMapLocation;

/**
 * Created by zwj on 2017/4/7.
 */

public interface LocationInterface {
    void initLocation();
    void startLocation();
    void locationSuccess(AMapLocation aMapLocation);
    void locationFailed(String errInfo);
}
