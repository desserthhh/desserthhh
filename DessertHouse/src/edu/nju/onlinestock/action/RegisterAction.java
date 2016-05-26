package edu.nju.onlinestock.action;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;

import edu.nju.onlinestock.service.MemberService;
import edu.nju.onlinestock.model.Member;

public class RegisterAction extends BaseAction {
	private String name;
	private int tel;
	private String password;
	
	@Autowired
	private MemberService memberService;
	public MemberService getMemberService() {
		return memberService;
	}


	private String success = "success";
	private String input = "input";
	private String exist = "exist";
	private String run = "run";

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getTel() {
		return tel;
	}

	public void setTel(int tel) {
		this.tel = tel;
	}

	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
	}

	
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("registerAction！");
		System.out.println(request.getParameter("name"));
		if(request.getParameter("name")==""||request.getParameter("password")==""||request.getParameter("confirm")==""||request.getParameter("tel")==""){
			return input;
		}
		try{
			if(request.getParameter("password")!=null&&request.getParameter("password").equals(request.getParameter("confirm"))){
				setName(request.getParameter("name"));
				setPassword(request.getParameter("password"));
				setTel(Integer.parseInt(request.getParameter("tel")));
			}
			else{
				return input;
			}			
			Member member = new Member(name, password,tel,0,0);
			System.out.println("tel:"+member.getTel()+";"+"password:"+member.getPassword());
			Member m = memberService.registerMember(member);
			
			ServletContext sc = request.getServletContext();
			
			if(m != null){
				sc.setAttribute("accountType", "member");
				sc.setAttribute("account", Integer.toString(member.getAccount()));
				sc.setAttribute("account_name", name);
				return success;
			}else{
				return exist;
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return run;
	}

}
