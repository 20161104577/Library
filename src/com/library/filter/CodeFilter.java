package com.library.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.library.bean.ReaderBean;

@WebFilter("/CodeFilter")
public class CodeFilter implements Filter {

    public CodeFilter() {
        // TODO Auto-generated constructor stub
    }

	public void destroy() {
		// TODO Auto-generated method stub
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse)response;
		/*
		 * HttpSession session = req.getSession(); String path = req.getRequestURI();
		 * Object empID1 = session.getAttribute("READER"); Object empID2 =
		 * session.getAttribute("USERBEAN");
		 * 
		 * if(path.indexOf("/Library/LoAndRe/index.html") >-1 ||
		 * path.indexOf("/Library/LoAndRe/readerlogin.jsp") >-1 ||
		 * path.indexOf("/Library/LoAndRe/operatorlogin.jsp") >-1 ||
		 * path.indexOf("/Library/LoAndRe/readerregist.jsp") >-1) {
		 * System.out.println("此网页不过滤"); chain.doFilter(req, resp); return; }
		 * System.out.println("READER is "+ empID1); System.out.println("USERBEAN is "+
		 * empID2); if(empID1 == null ||"".equals(empID1) || empID2 == null
		 * ||"".equals(empID2)) { resp.sendRedirect("/Library/LoAndRe/index.html");
		 * return; } else { chain.doFilter(req, resp); }
		 */
		
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html; charset=utf-8");
		// pass the request along the filter chain
		chain.doFilter(req, resp);
	}

	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
