package com.mps.think.setup.vo;

import java.util.Date;

import com.mps.think.setup.model.Queue;

public class DayEndEmailQueueVO {
	
	private Integer id;
	private Integer every;
	private String intervalUnit;
	private Date initialStartDateTime;
	private Integer priority;
	private Queue defaultJobQueue;

	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getEvery() {
		return every;
	}

	public void setEvery(Integer every) {
		this.every = every;
	}

	public String getIntervalUnit() {
		return intervalUnit;
	}

	public void setIntervalUnit(String intervalUnit) {
		this.intervalUnit = intervalUnit;
	}

	public Date getInitialStartDateTime() {
		return initialStartDateTime;
	}

	public void setInitialStartDateTime(Date initialStartDateTime) {
		this.initialStartDateTime = initialStartDateTime;
	}

	public Integer getPriority() {
		return priority;
	}

	public void setPriority(Integer priority) {
		this.priority = priority;
	}

	public Queue getDefaultJobQueue() {
		return defaultJobQueue;
	}

	public void setDefaultJobQueue(Queue defaultJobQueue) {
		this.defaultJobQueue = defaultJobQueue;
	}

	@Override
	public String toString() {
		return "DayEndEmailQueueVO [id=" + id + ", every=" + every + ", intervalUnit=" + intervalUnit
				+ ", initialStartDateTime=" + initialStartDateTime + ", priority=" + priority + ", defaultJobQueue="
				+ defaultJobQueue + "]";
	}


}
