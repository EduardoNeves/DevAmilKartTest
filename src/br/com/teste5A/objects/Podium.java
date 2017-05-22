package br.com.teste5A.objects;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Podium{
	private Integer position;
	private Pilot pilot;
	private List<Lap> laps = new ArrayList<Lap>();
	private Date totalTime;
	private Date averageTime;
	
	public Integer getPosition() {
		return position;
	}
	public void setPosition(Integer position) {
		this.position = position;
	}
	public Pilot getPilot() {
		return pilot;
	}
	public void setPilot(Pilot pilot) {
		this.pilot = pilot;
	}
	public List<Lap> getLaps() {
		return laps;
	}
	public void setLaps(List<Lap> laps) {
		this.laps = laps;
	}
	public Date getTotalTime() {
		return totalTime;
	}
	public void setTotalTime(Date totalTime) {
		this.totalTime = totalTime;
	}
	public Date getAverageTime() {
		return averageTime;
	}
	public void setAverageTime(Date averageTime) {
		this.averageTime = averageTime;
	}
}
