package com.masai.masaiconference.dummyPackage;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class LoopingModel implements Serializable {

	@SerializedName("mp4_size")
	private String mp4Size;

	@SerializedName("mp4")
	private String mp4;

	public String getMp4Size(){
		return mp4Size;
	}

	public String getMp4(){
		return mp4;
	}
}