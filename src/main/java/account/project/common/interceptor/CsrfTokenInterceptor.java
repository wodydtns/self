package account.project.common.interceptor;

import java.io.IOException;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import account.project.common.collection.ProjectEnum;

public class CsrfTokenInterceptor implements HandlerInterceptor {
	private static final Logger LOGGER = LoggerFactory.getLogger(CsrfTokenInterceptor.class);
    @Override
    public void postHandle(HttpServletRequest request,HttpServletResponse response,Object handler,ModelAndView model) throws NullPointerException, ClassNotFoundException, IOException {
    	
    	try{
    		
    		HttpSession session = request.getSession();
    		Random random = new Random();
    		random.setSeed(System.currentTimeMillis());
    		double ran = random.nextDouble();
    		String token = Double.toString(ran);
    		session.setAttribute(ProjectEnum.SESSION_ADMIN_KEY.adminKey(), token);
    		
    	}catch(Throwable ex){    		
    		try {
    			LOGGER.error("에러발생 : {}","ERROR");
            } catch (Throwable e) {
                LOGGER.error("에러발생 : {}","로그 전달 에러 ");
            }
    	}
    	
        try {
        	postHandle(request, response, handler, model);
        }catch (Throwable e) {
            LOGGER.error("에러발생 : {}", "Error At : "+(this.getClass().getName()));
            try {
            	LOGGER.error("에러발생 : {}","ERROR");
            } catch (Throwable er) {
                LOGGER.error("에러발생 : {}", "Error For Error Logging");
            }
        }
    }
}
