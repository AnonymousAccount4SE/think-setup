package com.mps.think.setup.service;

import java.util.List;
import java.util.Optional;

import org.springframework.web.multipart.MultipartFile;

import com.mps.think.setup.model.MailTemplate;
import com.mps.think.setup.model.MakePayment;
import com.mps.think.setup.model.SendInvoice;
import com.mps.think.setup.vo.MailTemplateVO;
import com.mps.think.setup.vo.MakePaymentVO;
import com.mps.think.setup.vo.SendInvoiceVO;

public interface MakePaymentService {
	
	public List<MakePayment> findAllMakePaymentByPubId(Integer pubId);
	
	public List<MakePayment> saveMakePayment(MakePaymentVO makePaymentVO);
	
	public MakePayment updateMakePayment(MakePaymentVO makePaymentVO);
	
	public MakePayment findByOrderId(Integer orderId);
	
	public Optional<MakePayment> findByMakePaymentId(Integer id);
	
	public MailTemplateVO sendPaymentLink(MailTemplateVO mailTemplateVO);
	
	public SendInvoiceVO sendInvoiceToCust(SendInvoiceVO sendInvoiceVO,MultipartFile file);

	public List<MakePayment> getAllMakePayment();

}
