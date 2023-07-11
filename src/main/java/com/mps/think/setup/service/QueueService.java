package com.mps.think.setup.service;
import java.util.List;
import org.springframework.stereotype.Service;
import com.mps.think.setup.model.Queue;

import com.mps.think.setup.vo.QueueVO;

@Service
public interface QueueService {
	
	public List<Queue> getAllQueue();
	
	public Queue saveQueue(QueueVO queue);

	public Queue updateQueue(QueueVO queue);

	public Queue findbyQueueId(Integer id);
	
	public Queue deleteByQueueId(Integer id);
	
	public List<Queue> findAllQueueByPubId(Integer id);

}
