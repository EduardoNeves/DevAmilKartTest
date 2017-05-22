package br.com.teste5A.objects;

import java.util.Date;

public class Lap {
	private Integer	lapNamber;
	private Pilot 	pilot;
	private Date 	time;
	private	Date	timeSpend;
	private Float	speed;
	
	public Integer getLapNamber() {
		return lapNamber;
	}
	public void setLapNamber(Integer lapNamber) {
		this.lapNamber = lapNamber;
	}
	public Pilot getPilot() {
		return pilot;
	}
	public void setPilot(Pilot pilot) {
		this.pilot = pilot;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public Date getTimeSpend() {
		return timeSpend;
	}
	public void setTimeSpend(Date timeSpend) {
		this.timeSpend = timeSpend;
	}
	public Float getSpeed() {
		return speed;
	}
	public void setSpeed(Float speed) {
		this.speed = speed;
	}
	
	
}
