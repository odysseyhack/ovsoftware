package com.ovsoftware.reti.domain;

import org.springframework.data.annotation.Id;

/**
 * Responsible for representing a Project.
 */

public class Project {
	
	@Id
	private long _id;
	private String name;
	private String description;
	private String category;
	private int target;
	private int progress;
	private String adress;
	private boolean active;

	public Project() {
		super();
	}

	public Project(String name, String description, String category, int target) {
		super();
		this.name = name;
		this.description = description;
		this.category = category;
		this.target = target;
	}

	public long getId() {
		return _id;
	}

	public void setId(long _id) {
		this._id = _id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getTarget() {
		return target;
	}

	public void setTarget(int target) {
		this.target = target;
	}

	public int getProgress() {
		return progress;
	}

	public void setProgress(int progress) {
		this.progress = progress;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}
}
