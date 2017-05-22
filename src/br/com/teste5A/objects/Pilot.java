package br.com.teste5A.objects;

public class Pilot {
	private Integer number;
	private String 	name;
	
	
	public Integer getNumber() {
		return number;
	}
	public void setNumber(Integer number) {
		this.number = number;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	public boolean equals(Pilot obj) {
		if(obj.getNumber().equals(this.number))
			return true;
		else
			return false;
	}
}
