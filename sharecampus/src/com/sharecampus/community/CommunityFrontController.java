package com.sharecampus.community;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sharecampus.Result;

public class CommunityFrontController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	super.doGet(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		super.doPost(req, resp);
	}
	protected void doProcess(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String target = req.getRequestURI().substring(req.getContextPath().length());
		Result result = null;
		
		if(target.equals("/community/listDs.co")) {
			result = new CommunitySelectController().execute(req, resp);
//		커뮤니티 상세글을 DB에서 조회
		}else if(target.equals("/community/listDi.co")) {
//		커뮤니티 상세글을 DB에 추가
		}else if(target.equals("/community/listDd.co")) {
//		커뮤니티 상세글을 DB에서 삭제
		}else if(target.equals("/community/listDu.co")) {
//		커뮤니티 상세글을 DB에서 수정
		}
		
		if(result != null) {
			if(result.isRedirect()) {
				resp.sendRedirect(result.getPath());
				
			}else {
				req.getRequestDispatcher(result.getPath()).forward(req, resp);
			}
			
		}
		
	}
}
