package self.art.common.interceptor;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import self.art.common.collection.ProjectEnum;


public class CsrfCheckInterceptor implements HandlerInterceptor {
	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
	
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws NullPointerException, ClassNotFoundException, IOException {
    	boolean flag = false;
        try{
    		HttpSession session = request.getSession();
    		String sPageToken = (String)session.getAttribute(ProjectEnum.SESSION_ADMIN_KEY.adminKey());
    		String pageToken = (String)request.getParameter("pageToken");
    		
    		if( StringUtils.hasText(pageToken) && StringUtils.hasText(sPageToken) && pageToken.equals( sPageToken )){
    			flag = true;
    			session.removeAttribute(ProjectEnum.SESSION_ADMIN_KEY.adminKey());
    			
    		}else{
    			String url = "";
    			if( request.getRequestURI().indexOf("cudAction.do") > -1  ){
    				//사용자일 경우
    				url = request.getContextPath() + "/common/csrfErrorPop.do";
    			}
    			
    			response.sendRedirect(url);
    		}

        }catch(Throwable ex){
        	
        	try {
        		LOGGER.error("에러발생 : {}","ERROR");
            } catch (Throwable e) {
                LOGGER.error("에러발생 : {}","로그 전달 에러 ");
            }

        }


        return flag;
    }
    
}
