package com.sumedh.storiesapi.entities;

import java.time.LocalDate;
import java.util.Arrays;

public class User {

	private String id;
	private LocalDate created;
	private int karma;
	private String about;
	private int[] submitted;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public LocalDate getCreated() {
		return created;
	}

	public void setCreated(LocalDate created) {
		this.created = created;
	}

	public int getKarma() {
		return karma;
	}

	public void setKarma(int karma) {
		this.karma = karma;
	}

	public String getAbout() {
		return about;
	}

	public void setAbout(String about) {
		this.about = about;
	}

	public int[] getSubmitted() {
		return submitted;
	}

	public void setSubmitted(int[] submitted) {
		this.submitted = submitted;
	}

	public User() {
		super();
	}

	public User(String id, LocalDate created, int karma, String about, int[] submitted) {
		super();
		this.id = id;
		this.created = created;
		this.karma = karma;
		this.about = about;
		this.submitted = submitted;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", created=" + created + ", karma=" + karma + ", about=" + about + ", submitted="
				+ Arrays.toString(submitted) + "]";
	}

}
