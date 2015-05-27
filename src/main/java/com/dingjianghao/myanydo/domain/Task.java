package com.dingjianghao.myanydo.domain;

import java.util.Date;

import com.dingjianghao.oum.repository.biz.interafce.Identifiable;

public class Task implements Identifiable{
	private String id;
	private String title;

	private String content;
	private Date time;
	private boolean repeatable;
	private RepeatMode repeatMode;

	public Task(String id, String title, String content, Date time,
			boolean repeatable, RepeatMode repeatMode) {
		this.id = id;
		this.title = title;
		this.content = content;
		this.time = time;
		this.repeatable = repeatable;
		this.repeatMode = repeatMode;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public boolean isRepeatable() {
		return repeatable;
	}

	public void setRepeatable(boolean repeatable) {
		this.repeatable = repeatable;
	}

	public RepeatMode getRepeatMode() {
		return repeatMode;
	}

	public void setRepeatMode(RepeatMode repeatMode) {
		this.repeatMode = repeatMode;
	}

}
