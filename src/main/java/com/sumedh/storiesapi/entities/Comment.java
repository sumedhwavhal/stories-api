package com.sumedh.storiesapi.entities;

import java.io.Serializable;
import java.util.Arrays;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Comment implements Serializable{

	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private int id;
	@JsonIgnore
	private String type;
	private String by;
	@JsonIgnore
	private int time;
	private String text;
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private int parent;
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private int[] kids;

	@JsonIgnore
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

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

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
	
	@JsonIgnore
	public int getParent() {
		return parent;
	}

	public void setParent(int parent) {
		this.parent = parent;
	}

	@JsonIgnore
	public int[] getKids() {
		return kids;
	}

	public void setKids(int[] kids) {
		this.kids = kids;
	}

	public Comment(int id, String type, String by, int time, String text, int parent, int[] kids) {
		super();
		this.id = id;
		this.type = type;
		this.by = by;
		this.time = time;
		this.text = text;
		this.parent = parent;
		this.kids = kids;
	}

	public Comment() {
		super();
	}

	@Override
	public String toString() {
		return "Comment [id=" + id + ", type=" + type + ", by=" + by + ", time=" + time + ", text=" + text + ", parent="
				+ parent + ", kids=" + Arrays.toString(kids) + "]";
	}
}
