package edu.nju.onlinestock.action;

import javax.persistence.Access;
import javax.servlet.ServletContext;

import org.aspectj.weaver.patterns.IfPointcut.IfFalsePointcut;
import org.springframework.beans.factory.annotation.Autowired;

import edu.nju.onlinestock.service.MemberService;
import edu.nju.onlinestock.model.Member;
import edu.nju.onlinestock.service.WaiterService;
import edu.nju.onlinestock.model.Waiter;
import edu.nju.onlinestock.service.ManagerService;
import edu.nju.onlinestock.model.Manager;

//public class LoginAction implements Action {
public class LoginAction extends BaseAction {
	/**
	 * 
	 */
	private int account;
	public WaiterService getWaiterService() {
		return waiterService;
	}

	public void setWaiterService(WaiterService waiterService) {
		this.waiterService = waiterService;
	}

	public ManagerService getManagerService() {
		return managerService;
	}

	public void setManagerService(ManagerService managerService) {
		this.managerService = managerService;
	}

	public MemberService getMemberService() {
		return memberService;
	}


	private String password;
	
	@Autowired
	private MemberService memberService;
	private WaiterService waiterService;
	private ManagerService managerService;
	private String success_member = "member";
	private String success_waiter = "waiter";
	private String input = "input";

	private String ISBOUND = "cardIsBound";
	
	public int getAccount() {
		return account;
	}

	public void setAccount(int account) {
		this.account = account;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
	}

	
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		if(request.getParameter("id")==""||request.getParameter("ps")==""){
			return input;
		}
		try{
			setAccount(Integer.parseInt(request.getParameter("id")));
			setPassword(request.getParameter("ps"));
			Member member = new Member(account, password);
			Waiter waiter = new Waiter(account, password);
			Manager manager = new Manager(account, password);
			System.out.println("account:"+waiter.getAccount()+";"+"password:"+manager.getPassword());
			
			ServletContext sc = request.getServletContext();
			
			if(memberService.checkLogin(member)){
				sc.setAttribute("accountType", "member");
				
				sc.setAttribute("account", Integer.toString(member.getAccount()));
				String name = memberService.getNameByAccount(account);
				System.out.println(name);
				sc.setAttribute("account_name", name);
				
				return success_member;
			}else if(waiterService.checkLogin(waiter)){
				sc.setAttribute("accountType", "waiter");
				sc.setAttribute("account", Integer.toString(waiter.getAccount()));
				String name = waiterService.getNameByAccount(account);
				sc.setAttribute("account_name", name);
				if(waiter.getAccount()==11){sc.setAttribute("pwaiter","pwaiter");}
				
				return success_waiter;
			}else if(managerService.checkLogin(manager)){
				sc.setAttribute("accountType", "manager");
				sc.setAttribute("account", Integer.toString(manager.getAccount()));
				String name = managerService.getNameByAccount(account);
				sc.setAttribute("account_name", name);
				
				return success_waiter;
			}else{
				return input;
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return input;
	}

}
