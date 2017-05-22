package br.com.teste5A.processor;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import br.com.teste5A.objects.Lap;
import br.com.teste5A.utils.Utils;

public class ReadFile {

	private String		fileName; 
	private List<Lap>	listLaps;
	
	
	public ReadFile(String fileName,List<Lap> listLaps){
		this.fileName 	= fileName;
		this.listLaps	= listLaps;
	}
	
	public void readFile() {
		List<String> lines= null;
		Path file = FileSystems.getDefault().getPath(fileName);
		try {
			lines = Files.readAllLines(file, StandardCharsets.UTF_8);
			lines.remove(0);
			for (String line : lines) {
				createLap(line); 
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void createLap(String lapString){
		Lap lap = new Lap();
		lapString = Utils.preparString(lapString);
		String[] lapSplint = lapString.split(";");
		lap.setTime(Utils.converStringToDate(lapSplint[0]));
		lap.setPilot(Utils.converStringPilot(lapSplint[1]));
		lap.setLapNamber(Integer.parseInt(lapSplint[2]));
		lap.setTimeSpend(Utils.converStringToDate(lapSplint[3]));
		lap.setSpeed(Utils.convertStringToFloat(lapSplint[4]));
		
		listLaps.add(lap);
	}
}
