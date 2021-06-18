package com.masai.masaiconference.dummyPackage;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class FixedWidthDownsampledModel implements Serializable {

	@SerializedName("height")
	private String height;

	@SerializedName("width")
	private String width;

	@SerializedName("size")
	private String size;

	@SerializedName("url")
	private String url;

	@SerializedName("webp_size")
	private String webpSize;

	@SerializedName("webp")
	private String webp;

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

	public String getWebpSize(){
		return webpSize;
	}

	public String getWebp(){
		return webp;
	}
}