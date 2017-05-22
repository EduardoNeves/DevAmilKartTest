package br.com.teste5A;

import java.util.ArrayList;
import java.util.List;

import br.com.teste5A.objects.Lap;
import br.com.teste5A.processor.RaceResult;
import br.com.teste5A.processor.ReadFile;

public class Start {
	static ReadFile 	fileProcessor;
	static List<Lap>	listLaps =  new ArrayList<Lap>();
	static RaceResult	raceProcessor;

	public static void main(String[] args) {	
		validateArgs(args);
		fileProcessor = new ReadFile(args[0],listLaps);
		fileProcessor.readFile();
		
		raceProcessor = new RaceResult(listLaps);
		
		raceProcessor.rank();
		raceProcessor.fastestLap();
		raceProcessor.pilotFastestLap();
		
		raceProcessor.averagePilotSpeed();
		raceProcessor.timeAfterFrist();
	}
	
	public static void validateArgs(String[] args) {
		if(args.length==0){
			System.out.println("Favor informar o nome do arquivo de log.");
			System.exit(1);
		}
	}

}
