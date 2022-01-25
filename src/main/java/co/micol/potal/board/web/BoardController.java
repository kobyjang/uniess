package co.micol.potal.board.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


import co.micol.potal.board.service.BoardService;
import co.micol.potal.board.service.BoardVO;

@Controller
public class BoardController {

	@Autowired
	BoardService boardDao;
	
	//�씠�븯 Mapper 硫붿냼�뱶瑜� 留뚮뱾�뼱 以��떎
	@RequestMapping("/noticeList.do")
	public String noticeList( 
		 Model model) {
		
		System.out.println(boardDao.boardSelectList());
		
		

		model.addAttribute("boards", boardDao.boardSelectList());
	
		
		return "board/noticeList";
	}


	 
	
	@PostMapping("/boardRead.do")
	public String boardRead(BoardVO vo, Model model) {
		vo = boardDao.boardSelect(vo);
		
			model.addAttribute("board", vo);  //湲� �떞怨�
			
		return "board/boardRead";
	}
	//페이징처리한 글목록
	@RequestMapping(value = "/listCri", method = RequestMethod.GET)
	public void listCriGET(Criteria cri, Model model) throws Exception{
		l.info("C: listCri 겟 호출" + cri);
		model.addAttribute("boardList", service.listCri(cri));
	}

	//글목록보기(PageMaker객체 사용)
	// http://localhost:8088/board/listPage
	@RequestMapping(value = "/listPage", method = RequestMethod.GET)
	public void listPageGET(Criteria cri, Model model) throws Exception{
		l.info("C: cri는 "+cri);
		model.addAttribute("boardList", service.listCri(cri));

		PageMaker pm = new PageMaker();
		pm.setCri(cri);
		pm.setTotalCount(service.pageCount()); //DB의 전체ROW수 입력

		// 뷰페이지로 전달 
		model.addAttribute("pm", pm);
	}
}
//	
//	@PostMapping("/ajaxBoardSearch.do")
//	@ResponseBody
//	public List<BoardVO> ajaxBoardSearch(
//			@RequestParam("key") String key, @RequestParam("val") String val){	
//		
//		return boardDao.boardSearchList(key, val);
//	}
//	
//	@RequestMapping("/boardForm.do")
//	public String boardForm() {
//		return "board/boardForm";
//	}
//	
//	@PostMapping("/boardInsert.do")
//	public String boardInsert(BoardVO vo, HttpSession session) {
//		vo.setWriter((String) session.getAttribute("id"));
//		boardDao.boardInsert(vo);
//		return "redirect:noticeList.do";
//	}
//	
//	@PostMapping("/boardDelete.do")
//	public String boardDelete(BoardVO vo) {
//		int n = boardDao.boardDelete(vo);
//		if (n !=0) { //�궘�젣�썑 no 蹂�寃�
//			boardDao.boardNoupdate(vo.getNo());
//		}
//		return "redirect:noticeList.do";
//	}
//	@PostMapping("/boardUpdateForm.do")
//	public String boardUpdateForm(BoardVO vo, Model model, HttpSession session) {
//	   vo = boardDao.boardSelect(vo);
//	   if(vo != null) {
//		   if(vo.getWriter().equals((String) session.getAttribute("id"))) {
//			   model.addAttribute("board", vo); // 湲��떞怨�
//		   }else {
//			   model.addAttribute("message", "蹂몄씤�씠 �옉�꽦�븳 湲�留� �닔�젙媛��뒫�빀�땲�떎.");
//		   }
//	   }else {
//		   model.addAttribute("message", "寃뚯떆湲��씠 議댁옱�븯吏� �븡�뒿�땲�떎.");
//	   }
//	   return "board/boardUpdateForm";
//	}
//	
//	@PostMapping("/boardUpdate.do")
//	public String boardUpdate(BoardVO vo) {
//		boardDao.boardUpdate(vo);
//		return "redirect:noticeList.do";
//	}	
//}