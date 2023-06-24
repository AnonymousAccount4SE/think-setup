package com.mps.think.setup.utils;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.mps.think.setup.vo.TaxRateCSV;
import com.opencsv.CSVReader;
@Component
public class ReadCSVDataAvalara {
//	private static final String CSV_FILE_PATH = "F:\\Think-2\\tax_avalara.csv";
//
//	public static void main(String[] args) {
//
//		System.out.println("Read Data Line by Line With Header \n");
//		readDataLineByLine(CSV_FILE_PATH);
//		System.out.println("_______________________________________________");
//	}

	public List<TaxRateCSV> readDataLineByLine(String file) throws IOException {

		

			// Create an object of filereader class
			// with CSV file as a parameter.
			FileReader filereader = new FileReader(file);
			List<TaxRateCSV> taxRate = new ArrayList<TaxRateCSV>();
			try (// create csvReader object passing
					// Flirter as parameter
					CSVReader csvReader = new CSVReader(filereader)) {
				String[] nextRecord;

				// we are going to read data line by line
				boolean firstLine = true;
				
				while ((nextRecord = csvReader.readNext()) != null) {
					if (firstLine) {
						firstLine = false;
						continue;
						} else {
						System.out.println("Print the next line :" + nextRecord);
						TaxRateCSV taxRateCSV = new TaxRateCSV();
						taxRateCSV.setTaxId(nextRecord[0]);
						taxRateCSV.setRegisteredForTax(nextRecord[1]);
						taxRateCSV.setForceTax(nextRecord[2]);
						taxRateCSV.setTaxType(nextRecord[3]);
						taxRateCSV.setTaxTypeDescription(nextRecord[4]);
						taxRateCSV.setTaxRateCategory(nextRecord[5]);
						taxRateCSV.setTaxRateCategoryDescription(nextRecord[6]);
						taxRateCSV.setRegion(nextRecord[7]);
						taxRateCSV.setCountry(nextRecord[8]);
						taxRateCSV.setCountryCode(nextRecord[9]);
						taxRateCSV.setPostalCode(nextRecord[10]);
						taxRateCSV.setState(nextRecord[11]);
						taxRateCSV.setStateCode(nextRecord[12]);
						taxRateCSV.setCity(nextRecord[13]);
						taxRateCSV.setCounty(nextRecord[14]);
						taxRateCSV.setStreetName(nextRecord[15]);
						taxRateCSV.setJurisdiction(nextRecord[16]);
						taxRateCSV.setCommodityCode(nextRecord[17]);
						taxRateCSV.setCommodityDescription(nextRecord[18]);
						taxRateCSV.setTaxComputeApi(nextRecord[19]);
						taxRateCSV.setAddressValidationApi(nextRecord[20]);
						taxRateCSV.setBasicRate(nextRecord[21]);
						taxRateCSV.setCommodityRate(nextRecord[22]);
						taxRateCSV.setJurisdictionRate(nextRecord[23]);
						taxRateCSV.setEffectiveDateForBasicRate(nextRecord[24]);
						taxRateCSV.setEffectiveDateForCommodityRate(nextRecord[25]);
						taxRateCSV.setEffectiveDateForJurisdictionRate(nextRecord[26]);
						taxRateCSV.setNoTaxMessageBasicRate(nextRecord[27]);
						taxRateCSV.setNoTaxMessageCommodityRate(nextRecord[28]);
						taxRateCSV.setNoTaxMessageJurisdictionRate(nextRecord[29]);
						taxRate.add(taxRateCSV);
						for (String cell : nextRecord) {
							
							System.out.print(cell + "\t");
							
						}
						}
					System.out.println();
				}
				csvReader.close();
			}
			finally {
				
				filereader.close();
				
				
			}
			return taxRate;
		} 

}
