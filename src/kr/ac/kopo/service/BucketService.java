package kr.ac.kopo.service;

import java.util.List;

import kr.ac.kopo.dao.BucketDAO;
import kr.ac.kopo.vo.BucketVO;

public class BucketService {
	private BucketDAO bucketdao;

	public BucketService() {
		bucketdao = new BucketDAO();
	}

	public void addBucket(String name, int price, int qty, String cd) {
		bucketdao.insert(ServiceFactory.getMemberInstance().getNo(), name, price, qty, cd);
	}
	
	public List<BucketVO> view(){
		return bucketdao.select(ServiceFactory.getMemberInstance().getNo());
	}
	
	public boolean updateOne(String book_cd, int qty) {
		return bucketdao.update(ServiceFactory.getMemberInstance().getNo(), book_cd, qty);
	}
	
	public boolean deleteOne(String book_cd) {
		return bucketdao.delete(ServiceFactory.getMemberInstance().getNo(), book_cd);
	}
	
	public boolean deleteAll() {
		return bucketdao.delete(ServiceFactory.getMemberInstance().getNo());
	}
}
