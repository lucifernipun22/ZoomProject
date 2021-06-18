package com.masai.masaiconference.dummyPackage;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class PaginationModel implements Serializable {

	@SerializedName("total_count")
	private int totalCount;

	@SerializedName("count")
	private int count;

	@SerializedName("offset")
	private int offset;

	public int getTotalCount(){
		return totalCount;
	}

	public int getCount(){
		return count;
	}

	public int getOffset(){
		return offset;
	}
}