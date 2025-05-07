package kr.ac.kopo.service;

import java.util.List;
import java.util.Random;

import kr.ac.kopo.dao.OrderDAO;
import kr.ac.kopo.vo.BucketVO;
import kr.ac.kopo.vo.OrderVO;

public class OrderService {
	private OrderDAO orderdao;
	
	public OrderService() {
		orderdao = new OrderDAO();
	}
	
	public List<OrderVO> search(int user_no){
		return orderdao.select(user_no);
	}
	
	public boolean insert(List<BucketVO> lst) {
		String invoice = "#"+String.format("%05d", ServiceFactory.getMemberInstance().getNo()) + randomNumber();
		return orderdao.insert(lst, ServiceFactory.getMemberInstance().getNo(), ServiceFactory.getMemberInstance().getName(), invoice);
	}
	
	public String randomNumber() {
		Random random = new Random();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 8; i++) {
			sb.append(random.nextInt(10));
		}
		return sb.toString();
	}

}
