package com.masai.masaiconference.dummyPackage;

import com.example.retrofitgify.Model.MetaModel;
import com.example.retrofitgify.Model.PaginationModel;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class ResponseModel implements Serializable {

	@SerializedName("data")
	private List<DataModel> data;

	@SerializedName("pagination")
	private com.example.retrofitgify.Model.PaginationModel pagination;

	@SerializedName("meta")
	private com.example.retrofitgify.Model.MetaModel meta;

	public List<DataModel> getData(){
		return data;
	}

	public com.example.retrofitgify.Model.PaginationModel getPagination(){
		return pagination;
	}

	public com.example.retrofitgify.Model.MetaModel getMeta(){
		return meta;
	}
}