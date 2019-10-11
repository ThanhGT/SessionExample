/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thanhtran.sessionexample.model;

/**
 *
 * @author Thanh Tran
 */
public class City {
    
    private String cityName;
    private String region;

    public City(String cityName, String region) {
        this.cityName = cityName;
        this.region = region;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }
    
    
    
}
