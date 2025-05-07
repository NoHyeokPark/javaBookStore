package kr.ac.kopo.service;

import java.util.List;

import kr.ac.kopo.dao.AddressDAO;
import kr.ac.kopo.vo.AddressVO;

public class AddressService {
	private AddressDAO addDAO;

	public AddressService() {
		addDAO = new AddressDAO();
	}
	
	public List<AddressVO> view(){
		return addDAO.select(ServiceFactory.getMemberInstance().getNo());
	}
	
	public void insert(String name, String add) {
		addDAO.insert(name, add, ServiceFactory.getMemberInstance().getNo());
	}
}
