package edu.nju.onlinestock.action;

import javax.servlet.ServletContext;

public class LoginoutAction extends BaseAction{
	@Override
	public String execute() throws Exception {
		ServletContext sc = request.getServletContext();
		sc.setAttribute("account_name", null);
		String success = "success";
		return success;
	}
}
