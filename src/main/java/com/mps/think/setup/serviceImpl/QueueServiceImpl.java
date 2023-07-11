package com.mps.think.setup.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mps.think.setup.model.Queue;
import com.mps.think.setup.repo.QueueRepo;
import com.mps.think.setup.service.QueueService;
import com.mps.think.setup.vo.QueueVO;

@Service
public class QueueServiceImpl implements QueueService {
	
	@Autowired
	private QueueRepo queueRepo;
	
	@Autowired
	private ObjectMapper mapper;

	@Override
	public List<Queue> getAllQueue() {
		return queueRepo.findAll();
	}

	@Override
	public Queue saveQueue(QueueVO queue) {
		return queueRepo.saveAndFlush(mapper.convertValue(queue, Queue.class));
	}

	@Override
	public Queue updateQueue(QueueVO queue) {
		return queueRepo.saveAndFlush(mapper.convertValue(queue, Queue.class));
	}

	@Override
	public Queue findbyQueueId(Integer id) {
		 return queueRepo.findById(id).get();
	}

	@Override
	public Queue deleteByQueueId(Integer id) {
		Queue delete = findbyQueueId(id);
		queueRepo.delete(delete);
		return delete;
	}

	@Override
	public List<Queue> findAllQueueByPubId(Integer id) {
		return queueRepo.findByPubIdId(id);
	}

}
