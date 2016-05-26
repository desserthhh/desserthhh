package filter;

//import java.io.IOException;
//
//import javax.servlet.Filter;
//import javax.servlet.FilterChain;
//import javax.servlet.FilterConfig;
//import javax.servlet.ServletException;
//import javax.servlet.ServletRequest;
//import javax.servlet.ServletResponse;
//import javax.servlet.annotation.WebFilter;
//import javax.servlet.annotation.WebInitParam;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpSession;
//
/////**
//// * Servlet Filter implementation class AuthorityFilter
//// */
//@WebFilter(filterName="authority",
//		urlPatterns="/jsp/*",
//		initParams={
//			@WebInitParam(name="encoding", value="utf-8"),
//			@WebInitParam(name="myaccount", value="/jsp/myaccount.jsp"),
//			@WebInitParam(name="seat", value="/jsp/seat.jsp")
//		})
//public class AuthorityFilter implements Filter {
public class AuthorityFilter {
//	private FilterConfig config;
//	
//    /**
//     * Default constructor. 
//     */
//    public AuthorityFilter() {
//        // TODO Auto-generated constructor stub
//    }
//
//	/**
//	 * @see Filter#destroy()
//	 */
//	public void destroy() {
//		// TODO Auto-generated method stub
//		this.config = null;
//	}
//
//	/**
//	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
//	 */
//	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
//		// TODO Auto-generated method stub
//		// place your code here
//		String encoding = config.getInitParameter("encoding");
//		String myaccount = config.getInitParameter("myaccount");
//		String seat = config.getInitParameter("seat");
//		
//		request.setCharacterEncoding(encoding);
//		HttpServletRequest req = (HttpServletRequest) request;
//		HttpSession session = req.getSession(true);
//		String requestPath = req.getServletPath();
//		if(session.getAttribute("memberAccount") == null
//				&& session.getAttribute("waiterAccount") == null
//				&& session.getAttribute("managerAccount") == null
//				&& !requestPath.endsWith(myaccount) 
//				&& !requestPath.endsWith(seat)){
////			System.out.println("Not Login");
//			request.setAttribute("tip", "������������������ ");
//			request.getRequestDispatcher(myaccount).forward(request, response);
//		} else {
//			// pass the request along the filter chain
////			System.out.println("Login");w
//			chain.doFilter(request, response);
//		}
//	}
//
//	/**
//	 * @see Filter#init(FilterConfig)
//	 */
//	public void init(FilterConfig fConfig) throws ServletException {
//		// TODO Auto-generated method stub
//		this.config = fConfig;
//	}

}