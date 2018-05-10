package common;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class CsvFile {
	
	public CSVParser loadCsv(String fileName) throws IOException
	{
		Reader reader = Files.newBufferedReader(Paths.get(fileName));
        CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT);
		return csvParser;
	}
	
	public void CSVSave(String fileName, List<List<String>> toFile, List<String> header) throws IOException
	{
        BufferedWriter writer = Files.newBufferedWriter(Paths.get(fileName));
        
        CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT);
        
        csvPrinter.printRecord(header.toArray());
        for (List<String> string : toFile) {
        	csvPrinter.printRecord(string.toArray());
		}
        csvPrinter.flush(); 
        csvPrinter.close();
	}

}
