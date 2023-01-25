package com.sumedh.storiesapi.entities;

import java.io.Serializable;
import java.util.Arrays;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Story implements Serializable{

	@Id
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private int id;
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private String type;
	@Column(name = "by_a")
	private String by;
	private int time;
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private int[] kids;
	private String url;
	private int score;
	private String title;
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private int descendants;
	
	@JsonIgnore
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	@JsonIgnore
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getBy() {
		return by;
	}

	public void setBy(String by) {
		this.by = by;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}

	@JsonIgnore
	public int[] getKids() {
		return kids;
	}

	public void setKids(int[] kids) {
		this.kids = kids;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	@JsonIgnore
	public int getDescendants() {
		return descendants;
	}

	public void setDescendants(int descendants) {
		this.descendants = descendants;
	}

	public Story(int id, String type, String by, int time, int[] kids, String url, int score, String title,
			int descendants) {
		super();
		this.id = id;
		this.type = type;
		this.by = by;
		this.time = time;
		this.kids = kids;
		this.url = url;
		this.score = score;
		this.title = title;
		this.descendants = descendants;
	}

	public Story() {
		super();
	}

	@Override
	public String toString() {
		return "Story [id=" + id + ", type=" + type + ", by=" + by + ", time=" + time + ", kids="
				+ Arrays.toString(kids) + ", url=" + url + ", score=" + score + ", title=" + title + ", descendants="
				+ descendants + "]";
	}

}
