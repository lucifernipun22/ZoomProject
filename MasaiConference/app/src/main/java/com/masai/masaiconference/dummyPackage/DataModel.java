package com.masai.masaiconference.dummyPackage;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class DataModel implements Serializable {

	@SerializedName("type")
	private String type;

	@SerializedName("id")
	private String id;

	@SerializedName("url")
	private String url;

	@SerializedName("slug")
	private String slug;

	@SerializedName("bitly_gif_url")
	private String bitlyGifUrl;

	@SerializedName("bitly_url")
	private String bitlyUrl;

	@SerializedName("embed_url")
	private String embedUrl;

	@SerializedName("username")
	private String username;

	@SerializedName("source")
	private String source;

	@SerializedName("title")
	private String title;

	@SerializedName("rating")
	private String rating;

	@SerializedName("content_url")
	private String contentUrl;

	@SerializedName("source_tld")
	private String sourceTld;

	@SerializedName("source_post_url")
	private String sourcePostUrl;

	@SerializedName("is_sticker")
	private int isSticker;

	@SerializedName("import_datetime")
	private String importDatetime;

	@SerializedName("trending_datetime")
	private String trendingDatetime;

	@SerializedName("images")
	private ImagesModel images;

	@SerializedName("analytics_response_payload")
	private String analyticsResponsePayload;

	@SerializedName("analytics")
	private AnalyticsModel analytics;

	public String getType(){
		return type;
	}

	public String getId(){
		return id;
	}

	public String getUrl(){
		return url;
	}

	public String getSlug(){
		return slug;
	}

	public String getBitlyGifUrl(){
		return bitlyGifUrl;
	}

	public String getBitlyUrl(){
		return bitlyUrl;
	}

	public String getEmbedUrl(){
		return embedUrl;
	}

	public String getUsername(){
		return username;
	}

	public String getSource(){
		return source;
	}

	public String getTitle(){
		return title;
	}

	public String getRating(){
		return rating;
	}

	public String getContentUrl(){
		return contentUrl;
	}

	public String getSourceTld(){
		return sourceTld;
	}

	public String getSourcePostUrl(){
		return sourcePostUrl;
	}

	public int getIsSticker(){
		return isSticker;
	}

	public String getImportDatetime(){
		return importDatetime;
	}

	public String getTrendingDatetime(){
		return trendingDatetime;
	}

	public ImagesModel getImages(){
		return images;
	}

	public String getAnalyticsResponsePayload(){
		return analyticsResponsePayload;
	}

	public AnalyticsModel getAnalytics(){
		return analytics;
	}
}