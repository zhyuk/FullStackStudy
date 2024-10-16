package com.springbook.view.controller;

import java.io.File;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

import com.springbook.biz.board.BoardService;
import com.springbook.biz.board.BoardVO;

@Controller
@SessionAttributes("board")
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	

	String realPath = "c:/swork/ten/src/main/webapp/img/" ;

	@ModelAttribute("conditionMap")
	public Map<String, String> searchConditionMap() {
		Map<String, String> conditionMap = new HashMap<String, String>();
		conditionMap.put("내용", "CONTENT");
		conditionMap.put("제목", "TITLE");
		return conditionMap;
	}

	//상대경로 추가시 
//	public String insertBoard(MultipartHttpServletRequest request, BoardVO vo) throws IllegalStateException, IOException {
	@RequestMapping(value = "/insertBoard.do", method=RequestMethod.POST)
	public String insertBoard(BoardVO vo) throws IllegalStateException, IOException {
		MultipartFile uplodFile = vo.getUploadFile();
		//상대 경로 추가 시 realPath 추가
	    //realPath = request.getSession().getServletContext().getRealPath("/img/");
		if(!(uplodFile == null || uplodFile.isEmpty())) {
			String fileName = uplodFile.getOriginalFilename(); //"abc.jpg"
			vo.setFilename(fileName);
			uplodFile.transferTo(new File(realPath+fileName));
		}
		boardService.insertBoard(vo);
		return "getBoardList.do";
	}

	// 글 수정
	@RequestMapping("/updateBoard.do")
	public String updateBoard(@ModelAttribute("board") BoardVO vo, HttpSession session) {
		if( vo.getWriter().equals(session.getAttribute("userName").toString()) ){
			boardService.updateBoard(vo);
			return "getBoardList.do";
		}else {
			return "getBoard.do?error=1";
		}
		
	}

	// 글 삭제
	@RequestMapping("/deleteBoard.do")
	public String deleteBoard(BoardVO vo, HttpSession session) {
		vo = boardService.getBoard(vo);
		if( vo.getWriter().equals(session.getAttribute("userName").toString()) ) {
			if(vo.getFilename()!=null) {
				System.out.println("파일삭제: "+realPath + vo.getFilename());
				File f = new File(realPath + vo.getFilename());		
				f.delete();
			}
			boardService.deleteBoard(vo);
			return "getBoardList.do";
		}else {
			return "getBoard.do?error=1";
		}
	}

	// 글 상세 조회
	@RequestMapping("/getBoard.do")
	public String getBoard(BoardVO vo, Model model) {
		model.addAttribute("board", boardService.getBoard(vo));
		return "WEB-INF/board/getBoard.jsp";
	}

	// 글 목록
	@RequestMapping("/getBoardList.do")
	public String getBoardListPost(BoardVO vo, Model model) {
		System.out.println("글 목록 검색 처리");

		model.addAttribute("boardList", boardService.getBoardList(vo));
		return "WEB-INF/board/getBoardList.jsp";
	}
	
	//파일다운로드
	@RequestMapping(value="/download.do", method=RequestMethod.GET)
    public void fileDownLoad(@RequestParam(value="filename", required=false) String filename, HttpServletRequest request, HttpServletResponse response) throws IOException {
		System.out.println("파일 다운로드");
		if (!(filename == null || filename.equals(""))) {
	        //요청파일 정보 불러오기
		    //realPath = request.getSession().getServletContext().getRealPath("/img/");
	        File file = new File(realPath+filename);
	
			//한글은 http 헤더에 사용할 수 없기 때문에 파일명은 영문으로 인코딩하여 헤더에 적용한다
			String fn = new String(file.getName().getBytes(), "iso_8859_1");
	
			//ContentType설정
			byte[] bytes = org.springframework.util.FileCopyUtils.copyToByteArray(file);
			response.setHeader("Content-Disposition", "attachment; filename=\""+ fn + "\"");
			response.setContentLength(bytes.length);
	//			response.setContentType("image/jpeg");
	        
			response.getOutputStream().write(bytes);
	        response.getOutputStream().flush();
	        response.getOutputStream().close();
        }
    }
	
	
}
