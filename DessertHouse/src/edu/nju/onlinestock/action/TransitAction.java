package edu.nju.onlinestock.action;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;

import edu.nju.onlinestock.service.MemberService;
import edu.nju.onlinestock.model.Member;

public class TransitAction extends BaseAction {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	@Autowired
	private MemberService memberService;

	public MemberService getMemberService() {
		return memberService;
	}

	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
	}

	private String success = "success";

	
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
        ServletContext sc = request.getServletContext();
		
		int pid = Integer.parseInt(request.getParameter("pid"));
		sc.setAttribute("pid", pid);

		
		return success;
	}

}
