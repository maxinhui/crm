package top.builbu.business.shiro.filter;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.web.filter.AccessControlFilter;

import top.builbu.business.user.dto.MemberDTO;
import top.builbu.common.dto.UserCode;

/**
 * 
 * 
 * 判断登录
 * 
 */

public class LoginFilter  extends AccessControlFilter {
	
	@Override
	protected boolean isAccessAllowed(ServletRequest request,
			ServletResponse response, Object mappedValue) throws Exception {
		
		MemberDTO memberDTO = (MemberDTO) SecurityUtils.getSubject().getSession().getAttribute(UserCode.LOGINUSER);
		
		if(null != memberDTO || isLoginRequest(request, response)){// && isEnabled()
            return Boolean.TRUE;
        } 
		if (ShiroFilterUtils.isAjax(request)) {// ajax请求
//			Map<String,String> resultMap = new HashMap<String, String>();
//			
//			resultMap.put("login_status", "300");
//			resultMap.put("message", "\u5F53\u524D\u7528\u6237\u6CA1\u6709\u767B\u5F55\uFF01");//当前用户没有登录！
//			ShiroFilterUtils.out(response, resultMap);
			
			
		}
		return Boolean.FALSE ;
            
	}

	@Override
	protected boolean onAccessDenied(ServletRequest request, ServletResponse response)
			throws Exception {
		//保存Request和Response 到登录后的链接
		saveRequestAndRedirectToLogin(request, response);
		return Boolean.FALSE ;
	}
	

}
