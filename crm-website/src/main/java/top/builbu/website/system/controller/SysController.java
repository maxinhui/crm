package top.builbu.website.system.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import top.builbu.business.user.dto.MemberDTO;
import top.builbu.common.dto.ResultCode;
import top.builbu.common.dto.ResultDO;
import top.builbu.common.util.RandomUtil;



@Slf4j
@Controller
@RequestMapping("/sys")
public class SysController {
    
	
	/**
	 * 登录
	 * @param request
	 * @param session
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping("/loginLoad")
	public String loginLoad(HttpServletRequest request,HttpSession session){
		log.info("for:loginindex");
        ResultDO<MemberDTO> result = (ResultDO<MemberDTO>) session.getAttribute(ResultCode.RESULTDATA);
        if(result != null){
        	request.setAttribute(ResultCode.MESSAGE, result);
        }
        String random = (String) session.getAttribute(ResultCode.RANDOMKEY);
        if(null != random && !"".equals(random)){
        	session.removeAttribute(ResultCode.RANDOMKEY);
        }
        
        random = RandomUtil.randomInt(6);
        session.setAttribute(ResultCode.RANDOMKEY, random);
		return "/login/login";
	}
	
	
	/**
	 * 超时登录页
	 * @param request
	 * @param session
	 * @return
	 */
	@RequestMapping("/loginTimeOut")
	public String loginTimeOut(HttpSession session){
		log.info("for:loginindex");
        
        String random = RandomUtil.randomInt(6);
        session.setAttribute(ResultCode.RANDOMKEY, random);
		return "/login/login_timeout";
	}
	
	/**
	 * 超时中转页
	 * @param request
	 * @param session
	 * @return
	 */
	@RequestMapping("/timeOut")
	public String timeOut(HttpServletRequest request,HttpSession session){
		log.info("for:timeOut");       
		return "/login/timeout";
	}
	
	
	
	@RequestMapping("/forLoad")
	public String forLoad(String html){
		log.info("for:"+html);
		return html;
	}
	
	

}
