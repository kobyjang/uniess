package co.micol.potal.board.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;


public interface BoardService {
	List<BoardVO> boardSelectList();
	BoardVO boardSelect(BoardVO vo);
	int boardInsert(BoardVO vo);
	int boardUpdate(BoardVO vo);
	int boardDelete(BoardVO vo);
	void boardHit(int n);
	

	List<BoardVO> boardSearchList(@Param("key") String key, @Param("val") String val); 		
	void boardNoupdate(int n); 
	//����¡ó���� �۸��

	public List<BoardVO> listCri(Criteria cri) throws Exception;
	//DB ���̺� �ִ� ��� �� ���� ��� �� ����
	public int pageCount() throws Exception;
	
}
