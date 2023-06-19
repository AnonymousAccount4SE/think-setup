package com.mps.think.setup.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//import com.mps.think.setup.model.CustomerDetails;
import com.mps.think.setup.service.SubmitJobService;
import com.mps.think.setup.vo.SubmitJobVO;
//
//import org.apache.poi.ss.usermodel.*;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.MediaType;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//import java.io.ByteArrayInputStream;
//import java.io.ByteArrayOutputStream;
//import java.io.IOException;

@RestController
@CrossOrigin
public class SubmitJobController {
	
	@Autowired
	SubmitJobService submitJobService;
	
	@GetMapping("/getAllsubmitJob")
	public ResponseEntity<?> getAllSubmitJob() {
		return ResponseEntity.ok(submitJobService.getAllSubmitJob());
	}
	
	@PostMapping("/savesubmitJob")
	public ResponseEntity<?> saveSubmitJob(@RequestBody SubmitJobVO id) {
		return ResponseEntity.ok(submitJobService.saveSubmitJob(id));
	}
	
	@PostMapping("/updatesubmitJob")
	public ResponseEntity<?> updateJobQueue(@RequestBody SubmitJobVO id) {
		return ResponseEntity.ok(submitJobService.updateSubmitJob(id));
	}
	
	@PostMapping("/findbysubmitJobId")
	public ResponseEntity<?> findbyJobQueueId(@RequestBody Integer id) {
		return ResponseEntity.ok(submitJobService.findbySubmitJobId(id));
	}
	
	@DeleteMapping("/deletebysubmitJobId")
	public ResponseEntity<?> deletebyJobQueueId(@RequestBody Integer id) {
		return ResponseEntity.ok(submitJobService.deleteBySubmitJobId(id));
	}

	@PostMapping("/findAllSubmitJobByPubId")
	public ResponseEntity<?> getAllTaxonomyForPublisher( @RequestBody Integer publisherId) {
		return ResponseEntity.ok(submitJobService.findAllSubmitJobByPubId(publisherId));
	}
	
	@PostMapping("/updateProcessJobInDb")
	public ResponseEntity<?> updateProcessJobInDb(@RequestParam String jobStatus,@RequestParam Integer jobId) {
		return ResponseEntity.ok(submitJobService.updateProcessJobInDb(jobStatus, jobId));
	}
	
//	 @GetMapping("/download")
//	    public ResponseEntity<InputStreamResource> downloadExcel(@RequestParam Integer jobId) throws IOException {
//	        // Fetch data from the database
//	         List<CustomerDetails> data = submitJobService.listOfCustomer(jobId);
//
//	        // Create Excel workbook and sheet
//	        XSSFWorkbook workbook = new XSSFWorkbook();
//	        Sheet sheet = workbook.createSheet("Data Sheet");
//
//	        // Create header row
//	        Row headerRow = sheet.createRow(0);
//	        headerRow.createCell(0).setCellValue("Column 1");
//	        headerRow.createCell(1).setCellValue("Column 2");
//	        // Add more header cells as needed
//
//	        // Create data rows
//	        int rowIndex = 1;
//	        for (Object item : data) {
//	            Row dataRow = sheet.createRow(rowIndex++);
//	            dataRow.createCell(0).setCellValue(item.);
//	            dataRow.createCell(1).setCellValue(item.getColumn2());
//	            // Add more cells with corresponding data as needed
//	        }
//
//	        // Write workbook to ByteArrayOutputStream
//	        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
//	        workbook.write(outputStream);
//
//	        // Set response headers
//	        HttpHeaders headers = new HttpHeaders();
//	        headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=data.xlsx");
//
//	        // Create InputStreamResource from the ByteArrayOutputStream
//	        InputStreamResource resource = new InputStreamResource(new ByteArrayInputStream(outputStream.toByteArray()));
//
//	        // Return the ResponseEntity with headers and InputStreamResource
//	        return ResponseEntity.ok()
//	                .headers(headers)
//	                .contentType(MediaType.APPLICATION_OCTET_STREAM)
//	                .body(resource);
//	    }
}
