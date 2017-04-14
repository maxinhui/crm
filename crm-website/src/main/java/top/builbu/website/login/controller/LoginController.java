package top.builbu.website.login.controller;

import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import lombok.extern.slf4j.Slf4j;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;

import top.builbu.business.system.dto.SmMenuDTO;
import top.builbu.business.user.dto.MemberDTO;
import top.builbu.business.user.dto.UscUserDTO;
import top.builbu.business.user.service.UscUserService;
import top.builbu.common.dto.BaseResultCode;
import top.builbu.common.dto.ResultCode;
import top.builbu.common.dto.ResultDO;
import top.builbu.common.dto.UserCode;
import top.builbu.common.util.SHA1;

@Slf4j
@Controller
@RequestMapping("/login")
public class LoginController {

	
	@Autowired
	private UscUserService uscUserService;
	

	
	
	@SuppressWarnings("unchecked")
	@RequestMapping("/loginIng")
	public String loginIng(String name,String pwd,String tokenKey,HttpServletRequest request,HttpSession session){
		log.info("for:"+name+"--"+pwd+"--"+tokenKey);
		ResultDO<MemberDTO> result = null;
		Subject currentUser = SecurityUtils.getSubject();
		String randomKey = (String) session.getAttribute(ResultCode.RANDOMKEY);
		if(null != tokenKey && !"".equals(tokenKey) && null != randomKey && !"".equals(randomKey) && randomKey.equals(tokenKey)){
						
			Set<SmMenuDTO> l = null;
			UsernamePasswordToken token = new UsernamePasswordToken(name,SHA1.Encrypt(name+pwd,""));
			token.setRememberMe(true);
			try {				
				currentUser.login(token);	
				currentUser.hasRole("admin");
				//String userID = (String) currentUser.getPrincipal();
				l = (Set<SmMenuDTO>) session.getAttribute("setTP");			
				request.setAttribute("TP", l);
				log.info("userID:"+l);
				result = new ResultDO<MemberDTO>(BaseResultCode.COMMON_MESSAGE_CHENGGONG,Boolean.TRUE);  
			} catch (UnknownAccountException uae) {  
	            result = new ResultDO<MemberDTO>(BaseResultCode.COMMON_NO_USER,Boolean.FALSE);  
	            log.error(uae.getMessage());
	        } catch (IncorrectCredentialsException ice) {  
	        	result = new ResultDO<MemberDTO>(BaseResultCode.COMMON_NO_USER,Boolean.FALSE);   
	        	log.error(ice.getMessage());
	        }  catch (AuthenticationException e) {
	        	result = new ResultDO<MemberDTO>(BaseResultCode.COMMON_NO_USER,Boolean.FALSE);  
	        	log.error(e.getMessage());
				token.clear();	
			}
        }else{
        	result = new ResultDO<MemberDTO>(BaseResultCode.COMMON_NO_CHECK,Boolean.FALSE);  
		}
			if(result.isSuccess()){
				result.setModule((MemberDTO)currentUser.getSession().getAttribute(UserCode.LOGINUSER));
				session.setAttribute(ResultCode.RESULTDATA,result);
				session.removeAttribute(ResultCode.RANDOMKEY);
				log.info("for:index 登录成功");
				return "/system/index";
			}else{
				session.setAttribute(ResultCode.RESULTDATA,result);
				log.info("for:login 登录失败");
				return "redirect:/sys/loginLoad";
			}		
	}
	

	
	/**
	 * 超时登录
	 * @param name
	 * @param pwd
	 * @param tokenKey
	 * @param request
	 * @param session
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/login")
	public String login(String name,String pwd,String tokenKey,HttpServletRequest request,HttpSession session){
		log.info("for:"+name+"--"+pwd+"--"+tokenKey);
		ResultDO<MemberDTO> result = null;
		Subject currentUser = SecurityUtils.getSubject();
		String randomKey = (String) session.getAttribute(ResultCode.RANDOMKEY);
		if(null != tokenKey && !"".equals(tokenKey) && null != randomKey && !"".equals(randomKey) && randomKey.equals(tokenKey)){
						
			UsernamePasswordToken token = new UsernamePasswordToken(name,SHA1.Encrypt(name+pwd,""));
			token.setRememberMe(true);
			try {				
				currentUser.login(token);	
				currentUser.hasRole("admin");
				result = new ResultDO<MemberDTO>(BaseResultCode.COMMON_MESSAGE_CHENGGONG,Boolean.TRUE);  
			} catch (UnknownAccountException uae) {  
	            result = new ResultDO<MemberDTO>(BaseResultCode.COMMON_NO_USER,Boolean.FALSE);  
	            log.error(uae.getMessage());
	        } catch (IncorrectCredentialsException ice) {  
	        	result = new ResultDO<MemberDTO>(BaseResultCode.COMMON_NO_USER,Boolean.FALSE);   
	        	log.error(ice.getMessage());
	        }  catch (AuthenticationException e) {
	        	result = new ResultDO<MemberDTO>(BaseResultCode.COMMON_NO_USER,Boolean.FALSE);  
	        	log.error(e.getMessage());
				token.clear();	
			}
        }else{
        	result = new ResultDO<MemberDTO>(BaseResultCode.COMMON_NO_CHECK,Boolean.FALSE);  
		}
			
		return JSONObject.toJSONString(result);
	}
	

	

}
