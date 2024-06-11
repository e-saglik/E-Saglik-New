
package filter;

import Entity.Admin;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;


@WebFilter("/*")
public class LoginFilter implements Filter{

	@Override
	public void doFilter(ServletRequest sr, ServletResponse sr1, FilterChain fc) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) sr;
		HttpServletResponse res = (HttpServletResponse) sr1;
		
		HttpSession session = req.getSession();
		
		Admin a = (Admin) session.getAttribute("validUser");
		
		System.out.println("----------------------********************");
		
		if ( a == null ) {
			res.sendRedirect(req.getContextPath() + "/login.xhtml");
		} else {
			fc.doFilter(sr, sr1);
		}
		
	}
	
}
