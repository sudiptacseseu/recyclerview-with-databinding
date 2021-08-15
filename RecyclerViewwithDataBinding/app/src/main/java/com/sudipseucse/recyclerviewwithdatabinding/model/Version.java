package com.sudipseucse.recyclerviewwithdatabinding.model;

public class Version {

    public String androidVersion, androidName, apiLevel;

    public Version(String androidName, String androidVersion, String apiLevel) {

        this.androidName = androidName;
        this.androidVersion = androidVersion;
        this.apiLevel = apiLevel;
    }
}
