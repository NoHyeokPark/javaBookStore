package kr.ac.kopo.service;

import java.util.List;

import kr.ac.kopo.dao.CSBoardDAO;
import kr.ac.kopo.vo.CSBoardVO;

public class CSService {
	private CSBoardDAO csdao;

	public CSService() {
		csdao = new CSBoardDAO();
	}

	public void addCS(CSBoardVO v) {
		csdao.insertUser(v);
	}
	
	public List<CSBoardVO> searchBoardAll() {
		return csdao.selectAllBoard();
	}
	
	

}
