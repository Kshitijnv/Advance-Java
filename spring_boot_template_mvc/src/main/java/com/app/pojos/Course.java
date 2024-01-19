package com.app.pojos;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity

/*
 * @Entity public class Course {
 * 
 * @Id
 * 
 * @GeneratedValue(strategy = GenerationType.IDENTITY) private Long id;
 * 
 * @NotNull private String name;
 * 
 * @NotNull private String type;
 * 
 * @NotNull private Integer duration;
 * 
 * @NotNull
 * 
 * @Min(100000)
 * 
 * @Max(400000) private Integer fee;
 * 
 * // getters and setters }
 * 
 */
public class Course {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	private String name;

	@NotNull
	private String type;

	@NotNull
	private Integer duration;

	@NotNull
	@Min(100000)
	@Max(400000)
	private Integer fee;

	public Course() {
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Integer getDuration() {
		return duration;
	}

	public void setDuration(Integer duration) {
		this.duration = duration;
	}

	public Integer getFee() {
		return fee;
	}

	public void setFee(Integer fee) {
		this.fee = fee;
	}

	@Override
	public String toString() {
		return "Course [id=" + id + ", name=" + name + ", type=" + type + ", duration=" + duration + ", fee=" + fee
				+ "]";
	}

}
