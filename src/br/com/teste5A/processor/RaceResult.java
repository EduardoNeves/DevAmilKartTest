package br.com.teste5A.processor;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import br.com.teste5A.objects.Lap;
import br.com.teste5A.objects.Podium;
import br.com.teste5A.utils.Utils;

public class RaceResult {
	private List<Lap>	 listLaps;
	private List<Podium> listPodium = new ArrayList<Podium>();


	public RaceResult(List<Lap> laps) {
		this.listLaps = laps;
	}
	
	public void rank() {
		for (Lap lap : this.listLaps) {
			Podium podium=null;
			Optional<Podium> tmpPodium = listPodium.stream()
										.filter(a -> a.getPilot().equals(lap.getPilot()))
										.findFirst();
			if(tmpPodium.isPresent()){
				podium=tmpPodium.get();
				podium.getLaps().add(lap);
				podium.setTotalTime(Utils.sumDates(podium.getTotalTime(), lap.getTimeSpend()));
				podium.setAverageTime(Utils.averageTime(podium.getTotalTime(), podium.getLaps().size()));
			}else{
				podium = new Podium();
				podium.setPilot(lap.getPilot());
				podium.getLaps().add(lap);
				podium.setTotalTime(lap.getTimeSpend());
				listPodium.add(podium);
			}
			
			
		}
		
		listPodium.sort((Podium p1, Podium p2)->p1.getAverageTime().compareTo(p2.getAverageTime()));
		
		Integer position = 0;
		System.out.println("********************************************************************************");
		System.out.format("%-25s%-7s%-7s%-6s%-25s%n","******************************","","CHEGADA","","******************************");
		System.out.println("********************************************************************************");
		System.out.format("%-10s%-15s%-20s%-15s%-20s%n","Chegada","Código Piloto","Nome Piloto","Qtde Voltas","Tempo Total de Prova");

		for (Podium podium : listPodium) {
			position++;
			podium.setPosition(position);
			System.out.format("%-10s%-15s%-20s%-15s%-20s%n",podium.getPosition().toString()+"º", podium.getPilot().getNumber().toString(), podium.getPilot().getName(), podium.getLaps().size(), Utils.formatDate(podium.getTotalTime().getTime()));
		}
	}
	
	public void fastestLap() {
		System.out.println("********************************************************************************");
		System.out.format("%-20s%-7s%-17s%-6s%-20s%n","*************************","","VOLTA MAIS RÁPIDA","","*************************");
		System.out.println("********************************************************************************");

		listLaps.sort((Lap l1, Lap l2)->l1.getTimeSpend().compareTo(l2.getTimeSpend()));
		Lap fastestLap = listLaps.get(0);
		
		System.out.format("%-10s%-17s%-15s%-20s%-16s%n","Volta","Código Piloto","Nome Piloto","Tempo da Volta","Velocidade Média");
		System.out.format("%-10s%-17s%-15s%-20s%-16s%n",fastestLap.getLapNamber().toString(),fastestLap.getPilot().getNumber().toString(),fastestLap.getPilot().getName(),Utils.formatDate(fastestLap.getTimeSpend().getTime()),fastestLap.getSpeed());
	}
	
	public void pilotFastestLap() {
		System.out.println("********************************************************************************");
		System.out.format("%-20s%-7s%-17s%-6s%-20s%n","********************","","VOLTA MAIS RÁPIDA POR PILOTO","","*******************");
		System.out.println("********************************************************************************");
		System.out.format("%-10s%-17s%-15s%-20s%-16s%n","Volta","Código Piloto","Nome Piloto","Tempo da Volta","Velocidade Média");
		
		for (Podium podium : listPodium) {
			podium.getLaps().sort((Lap l1, Lap l2)->l1.getTimeSpend().compareTo(l2.getTimeSpend()));
			Lap fastestLap = podium.getLaps().get(0);
			System.out.format("%-10s%-17s%-15s%-20s%-16s%n",fastestLap.getLapNamber().toString(),fastestLap.getPilot().getNumber().toString(),fastestLap.getPilot().getName(),Utils.formatDate(fastestLap.getTimeSpend().getTime()),fastestLap.getSpeed());
		}
	}
	
	public void averagePilotSpeed() {
		System.out.println("********************************************************************************");
		System.out.format("%-9s%-7s%-38s%-7s%-9s%n","*****************","","Velocidade Media Por Piloto da Corrida","","***********");
		System.out.println("********************************************************************************");
		System.out.format("%-14s%-16s%-25s%-15s%n","Código Piloto","Nome Piloto","Tempo Total da Corrida","Velocidade Média Total");
		
		for (Podium podium : listPodium) {
			long timeSpend = 0;
			Float speedTotal = new Float(0);
			for (Lap lap : podium.getLaps()) {
				timeSpend = timeSpend + (lap.getTimeSpend().getTime()-10800000);
				speedTotal = speedTotal+lap.getSpeed();
			}
			speedTotal = speedTotal/podium.getLaps().size();
			System.out.format("%-14s%-16s%-25s%-15s%n",podium.getPilot().getNumber().toString(),podium.getPilot().getName(),Utils.formatDate(timeSpend),speedTotal.toString());
		}
	}
	
	public void timeAfterFrist() {
		System.out.println("********************************************************************************");
		System.out.format("%-10s%-7s%-38s%-7s%-10s%n","*****************","","Tempo de chegada após o Primeiro","","***********");
		System.out.println("********************************************************************************");
		System.out.format("%-14s%-16s%-25s%-15s%n","Código Piloto","Nome Piloto","Tempo Total da Corrida","Tempo apos o Primeiro");
		
		long timeFrist = 0;
		for (Podium podium : listPodium) {
			long timeSpend = 0;
			for (Lap lap : podium.getLaps()) {
				timeSpend = timeSpend + (lap.getTimeSpend().getTime()-10800000);
			}
			if(timeFrist==0)timeFrist = timeSpend;
			System.out.format("%-14s%-16s%-25s%-15s%n",podium.getPilot().getNumber().toString(),podium.getPilot().getName(),Utils.formatDate(timeSpend),Utils.formatDate(timeSpend-timeFrist));
		}
	}
}
