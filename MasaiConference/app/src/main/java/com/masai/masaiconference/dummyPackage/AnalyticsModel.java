package com.masai.masaiconference.dummyPackage;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class AnalyticsModel implements Serializable {

	@SerializedName("onload")
	private OnloadModel onload;

	@SerializedName("onclick")
	private OnclickModel onclick;

	@SerializedName("onsent")
	private OnsentModel onsent;

	public OnloadModel getOnload(){
		return onload;
	}

	public OnclickModel getOnclick(){
		return onclick;
	}

	public OnsentModel getOnsent(){
		return onsent;
	}
}