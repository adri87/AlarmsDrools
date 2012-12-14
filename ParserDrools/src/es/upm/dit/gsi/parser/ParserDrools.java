package es.upm.dit.gsi.parser; 

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;

public class ParserDrools {
	
	/**
	 * @param urlFile
	 * @param nameFile
	 */
	public static void parserFileToDrl(String urlFile ,String nameFile){
		try {
			//Create a new file .drl in root parser´s folder
			File drl = new File("./drlFiles/"+nameFile);
			drl.createNewFile();
			BufferedWriter bw = new BufferedWriter(new FileWriter(drl));
			bw.write("package es.upm.dit.gsi.prueba\n\n");
			bw.write("import es.upm.dit.gsi.parser\n\n");

			// Read the file that we must convert to .drl
			FileInputStream f = new FileInputStream(urlFile);
			DataInputStream in = new DataInputStream(f);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String strLine, rule;
			
			while ((strLine = br.readLine()) != null) {
				if (strLine.contains("<")){
					// Extract data
					rule = (String) strLine.subSequence(strLine.indexOf("<"), strLine.indexOf(">"));
					String when = rule.substring(2, rule.indexOf("}"));
					String then = rule.substring(rule.indexOf("},{")+3, rule.length()-1);
					String nameRule = strLine.substring(1, strLine.indexOf(",")-1);
					
					// Write data in file .drl 
					bw.write("rule \"" +nameRule+"\"\n");
					bw.write("\twhen\n");
					if (when.contains(",")){
						String[] whenaux = when.split(",");
						for (int i = 0; i < whenaux.length; i++) {
							bw.write("\t\t"+whenaux[i]+"\n");
						}
					}else{
						bw.write("\t\t"+when+"\n");
					}
					bw.write("\tthen\n");
					if (then.contains(",")){
						String[] thenaux = when.split(",");
						for (int i = 0; i < thenaux.length; i++) {
							bw.write("\t\t"+thenaux[i]+"\n");
						}
					}else{
						bw.write("\t\t"+then+"\n");
					}
					bw.write("end\n");
					bw.write("\n");
				}
			}
			// Close the connections
			in.close();
			bw.close();
		} catch (Exception e) {
			System.err.println("Error: " + e.getMessage());
		}
	}
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		parserFileToDrl("./FilesToParser/antequera_alimentacion_meanperformance.txt", "antequera_alimentacionantequera_alimentacion_meanperformance.drl");
		parserFileToDrl("./FilesToParser/antequera_luces_meanperformance.txt", "antequera_alimentacionantequera_luces_meanperformance.drl");
		parserFileToDrl("./FilesToParser/antequera_general_meanperformance.txt", "antequera_alimentacionantequera_general_meanperformance.drl");
	}
	
}
