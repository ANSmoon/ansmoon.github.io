package com.ssafit.movie.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "영상 정보 DTO")
public class Movie {
	private int id;
	private String link;
	private String title;
	private String channelName;
	private String category;
	private int viewCnt;

	public Movie() {
	}

	public Movie(int id, String link, String title, String channelName, String category, int viewCnt) {
		super();
		this.id = id;
		this.link = link;
		this.title = title;
		this.channelName = channelName;
		this.category = category;
		this.viewCnt = viewCnt;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getChannelName() {
		return channelName;
	}

	public void setChannelName(String channelName) {
		this.channelName = channelName;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getViewCnt() {
		return viewCnt;
	}

	public void setViewCnt(int viewCnt) {
		this.viewCnt = viewCnt;
	}

	@Override
	public String toString() {
		return "Movie [id=" + id + ", link=" + link + ", title=" + title + ", channelName=" + channelName
				+ ", category=" + category + ", viewCnt=" + viewCnt + "]";
	}
}