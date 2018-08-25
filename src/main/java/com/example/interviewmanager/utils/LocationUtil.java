package com.example.interviewmanager.utils;

import android.content.Context;

import com.baidu.location.BDAbstractLocationListener;
import com.baidu.location.BDLocation;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.example.interviewmanager.entity.Location;

public class LocationUtil {
    private Context mContext;
    public LocationClient mLocationClient=null;
    private MyLocationListener myLocationListener=new MyLocationListener();
    public LocationUtil(Context mContext) {
        this.mContext = mContext;
        mLocationClient=new LocationClient(mContext);
        mLocationClient.registerLocationListener(myLocationListener);
    }

    public void getLocation(){

        LocationClientOption option=new LocationClientOption();
        option.setIsNeedAddress(true);
        mLocationClient.setLocOption(option);
        mLocationClient.start();
    }
    public class MyLocationListener extends BDAbstractLocationListener {

        @Override
        public void onReceiveLocation(BDLocation bdLocation) {
            Location location =new Location();
            location.setAddress(bdLocation.getAddrStr());
            location.setCity(bdLocation.getCity());
            location.setProvince(bdLocation.getProvince());
            location.setDistrict(bdLocation.getDistrict());
            location.setStreet(bdLocation.getStreet());
            DBUtil dbUtil=new DBUtil(mContext);
            dbUtil.insertLocation(location);
        }
    }
}
