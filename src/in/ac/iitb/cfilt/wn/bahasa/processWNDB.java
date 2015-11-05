package in.ac.iitb.cfilt.wn.bahasa;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.sql.SQLException;

import in.ac.iitb.cfilt.common.io.UTFReader;

public class processWNDB {
	public static void main(String args[])throws Exception{
		System.out.println("Starting to read the Bahasa Wordnet File");
		readFile();
	}


	private static void readFile() throws IOException {
		
		UTFReader reader = new UTFReader("wn-msa-all.tab");
		File filedir = new File("bahasa-wordnet.syns");
		Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filedir),"UTF-8"));

		String line = null;
		int lineNumber=1;
		int idCount=1;
		reader.open();
		String prev = "";
		while ((line = reader.readLine()) != null ) {
			
			//System.out.println(line);
			String parts[] = line.split("\t");
			//System.out.println(parts[0]);
			if(prev.equals(parts[0])){
				
				//System.out.println("aala!");
				String word = parts[3];
				out.append(", "+word);
					
			}
			else{
				idCount++;
				prev=parts[0];
				//System.out.println(prev);
				String idPos[] = parts[0].split("-");
				String id = idPos[0];
				String pos="N/A";
				out.append("\n\nID\t::\t"+id+"\n");
				//System.out.println(idPos[1]);
				if(idPos[1].equals("n")){
					pos = "NOUN";
				}
				else if(idPos[1].equals("v")){
					pos = "VERB";
				}
				else if(idPos[1].equals("a")){
					pos = "ADJECTIVE";
				}
				else if(idPos[1].equals("r")){
					pos = "ADVERB";
				}
				/*if(idPos[1]=="s"){
					String pos = "adjectiveSatellite";
					System.out.println("Found");
				}*/
				out.append("CAT\t::\t"+pos+"\n");
				String gloss = "N/A";
				String example = "N/A";
				String word = parts[3];
				out.append("CONCEPT\t::\t"+gloss+"\n");
				out.append("EXAMPLE\t::\t"+example+"\n");
				out.append("SYNSET-BAHASA\t::\t"+word);
				
			}
			
			//System.out.println(parts[3]);
			
			lineNumber++;
			
			
		}
		System.out.println(lineNumber);
		System.out.println(idCount);
		out.flush();
		out.close();		
	}
}