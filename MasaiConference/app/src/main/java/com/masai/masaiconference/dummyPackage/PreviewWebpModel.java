package com.masai.masaiconference.dummyPackage;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class PreviewWebpModel implements Serializable {

	@SerializedName("height")
	private String height;

	@SerializedName("width")
	private String width;

	@SerializedName("size")
	private String size;

	@SerializedName("url")
	private String url;

	public String getHeight(){
		return height;
	}

	public String getWidth(){
		return width;
	}

	public String getSize(){
		return size;
	}

	public String getUrl(){
		return url;
	}
}