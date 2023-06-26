package com.mps.think.setup.service;

 
import java.util.List;

import com.mps.think.setup.model.TransactionReasons;
import com.mps.think.setup.vo.TransactionReasonsVO;

 
public interface TransactionReasonsService {

	public List<TransactionReasons> findAllTransactionReasons();

	public TransactionReasons saveTransactionReasons(TransactionReasonsVO transactionReasonsVO);

	public TransactionReasons updateTransactionReasons(TransactionReasonsVO transactionReasonsVO);

	public TransactionReasons findbyTransactionReasonsId(Integer transactionReasonsId);

	public TransactionReasons deleteByTransactionReasonsId(Integer transactionReasonsId);

	public List<TransactionReasons> getAllTransactionReasonsForPublisher(Integer pubId);

}
