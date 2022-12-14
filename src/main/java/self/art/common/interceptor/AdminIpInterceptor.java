package self.art.common.interceptor;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.checkerframework.checker.units.qual.g;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;

public class AdminIpInterceptor implements HandlerInterceptor {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws NullPointerException, ClassNotFoundException, IOException {
		//HttpSession session = request.getSession();
		try {
			String confirmIp = request.getRemoteAddr();
			if(!"127.0.0.1".equals(confirmIp)) {
				return false;
			}
		} catch (Exception e) {
			e.toString();
		}
		return true;
	}
}
