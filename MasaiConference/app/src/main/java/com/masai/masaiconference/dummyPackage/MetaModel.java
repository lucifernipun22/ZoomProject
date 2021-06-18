package com.masai.masaiconference.dummyPackage;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class MetaModel implements Serializable {

	@SerializedName("status")
	private int status;

	@SerializedName("msg")
	private String msg;

	@SerializedName("response_id")
	private String responseId;

	public int getStatus(){
		return status;
	}

	public String getMsg(){
		return msg;
	}

	public String getResponseId(){
		return responseId;
	}
}