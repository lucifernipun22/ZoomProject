package com.masai.masaiconference.dummyPackage;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class OriginalMp4Model implements Serializable {

	@SerializedName("height")
	private String height;

	@SerializedName("width")
	private String width;

	@SerializedName("mp4_size")
	private String mp4Size;

	@SerializedName("mp4")
	private String mp4;

	public String getHeight(){
		return height;
	}

	public String getWidth(){
		return width;
	}

	public String getMp4Size(){
		return mp4Size;
	}

	public String getMp4(){
		return mp4;
	}
}