package self.art.common.interceptor;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;

public class RefererCheckInterceptor implements HandlerInterceptor {
	private static final Logger LOGGER = LoggerFactory.getLogger(RefererCheckInterceptor.class);

	@Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws NullPointerException, ClassNotFoundException, IOException {
        try{
            //정상경로가 아닌 경우 처리
			String referer = request.getHeader("Referer");
			
			if( referer == null ){
				String url = request.getContextPath() + "/common/errorAuth.do";
            	response.sendRedirect(url);
				return false;
			}else{
				if(referer.indexOf("localhost") < 0) {
					String url = request.getContextPath() + "/common/errorAuth.do";
	            	response.sendRedirect(url);
					return false;
					
				}
				
			}
			

        }catch (Throwable e) {
        	LOGGER.error("에러발생 : {}", "Error At : "+(this.getClass().getName()));
        	try {
        		LOGGER.error("에러발생 : {}", "Error For Error Logging");
			} catch (Throwable er) {
				LOGGER.error("에러발생 : {}", "Error For Error Logging");
			} 
        }

        return true;
    }

}
