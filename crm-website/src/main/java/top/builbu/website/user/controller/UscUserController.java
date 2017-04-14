package top.builbu.website.user.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;

import top.builbu.business.user.dto.MemberDTO;
import top.builbu.business.user.dto.UscUserDTO;
import top.builbu.business.user.entity.UscUser;
import top.builbu.business.user.service.UscUserService;
import top.builbu.common.dto.PageDTO;
import top.builbu.common.dto.ResultDO;
import top.builbu.common.dto.ResultCode;
import top.builbu.common.dto.BaseResultCode;
import top.builbu.common.dto.UserCode;
import top.builbu.common.util.page.Pagination;

import org.springframework.web.multipart.MultipartFile;

import top.builbu.core.util.UploadUtil;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/uscUser")
public class UscUserController {

	@Autowired
	private UscUserService uscUserService;
	
	@RequestMapping("/forAdd")
	public String forAdd(HttpServletRequest request,Integer userType,HttpSession session){
		log.info("forUserType : "+userType);
		request.setAttribute("userType", userType);//添加人员的类型
		MemberDTO member = (MemberDTO) session.getAttribute(UserCode.LOGINUSER);
		request.setAttribute("memberDTO", member);//操作人员
		log.info(member.getPassword());
		return "/user/uscUserAdd";
	}
	
	/**
	 * 管理員列表
	 * @param request
	 * @param dto
	 * @param page
	 * @return
	 */
	@RequestMapping("/selectByList")
	public String selectByList(HttpServletRequest request,MemberDTO dto,Pagination page){
		log.info(JSONObject.toJSONString(page));
		PageDTO<MemberDTO> result = null;
		try{
		    result = uscUserService.selectByList(dto,page);
		    request.setAttribute("pageDTO", result);
		    request.setAttribute("searchDTO", dto);
		    request.setAttribute("userType", dto.getUserType());
		    return "/user/uscUserList";
	    } catch (Exception e) {
			log.info(ExceptionUtils.getStackTrace(e));
			return ResultCode.ERROR;
		}
		
	}
	
	/**
	 * 会员列表
	 * @param request
	 * @param dto
	 * @param page
	 * @return
	 */
	@RequestMapping("/selectByUserList")
	public String selectByUserList(HttpServletRequest request,MemberDTO dto,Pagination page){
		log.info(JSONObject.toJSONString(page));
		PageDTO<MemberDTO> result = null;
		try{
		    result = uscUserService.selectByList(dto,page);
		    request.setAttribute("pageDTO", result);
		    request.setAttribute("searchDTO", dto);
		    request.setAttribute("userType", dto.getUserType());
		    return "/user/uscUserList";
	    } catch (Exception e) {
			log.info(ExceptionUtils.getStackTrace(e));
			return ResultCode.ERROR;
		}
		
	}
	
	/**
	 * 经销商列表
	 * @param request
	 * @param dto
	 * @param page
	 * @return
	 */
	@RequestMapping("/selectByCusList")
	public String selectByCusList(HttpServletRequest request,MemberDTO dto,Pagination page){
		log.info(JSONObject.toJSONString(page));
		PageDTO<MemberDTO> result = null;
		try{
		    result = uscUserService.selectByList(dto,page);
		    request.setAttribute("pageDTO", result);
		    request.setAttribute("searchDTO", dto);
		    request.setAttribute("userType", dto.getUserType());
		    return "/user/uscUserList";
	    } catch (Exception e) {
			log.info(ExceptionUtils.getStackTrace(e));
			return ResultCode.ERROR;
		}
		
	}
	
	/**
	 * 店员列表
	 * @param request
	 * @param dto
	 * @param page
	 * @return
	 */
	@RequestMapping("/selectByStoreList")
	public String selectStoreList(HttpServletRequest request,MemberDTO dto,Pagination page){
		log.info(JSONObject.toJSONString(page));
		PageDTO<MemberDTO> result = null;
		try{
		    result = uscUserService.selectByList(dto,page);
		    request.setAttribute("pageDTO", result);
		    request.setAttribute("searchDTO", dto);
		    request.setAttribute("userType", dto.getUserType());
		    return "/user/uscUserList";
	    } catch (Exception e) {
			log.info(ExceptionUtils.getStackTrace(e));
			return ResultCode.ERROR;
		}
		
	}
	
	@RequestMapping("/selectById")
	public String selectById(HttpServletRequest request,Long id){
	  ResultDO<MemberDTO> result = null;
	    try{
		    result = uscUserService.selectById(id);
		    if(result.isSuccess()){
		       request.setAttribute("module",result.getModule());
		       return "/user/uscUserEdit";
		    }else{
		       return ResultCode.ERROR;
		    }
		} catch (Exception e) {
			log.info(ExceptionUtils.getStackTrace(e));
			return ResultCode.ERROR;
		}
		
	}
	
	
    @ResponseBody
	@RequestMapping("/save")
	public ResultDO<?> save(MemberDTO dto){
		ResultDO<?> result = null;
		 try{
			 result = uscUserService.save(dto);
			} catch (Exception e) {
			 log.info(ExceptionUtils.getStackTrace(e));
			 result = new ResultDO<>(BaseResultCode.COMMON_FAIL,Boolean.FALSE);
			 result.setCloseCurrent(Boolean.FALSE);
			}
		 return result;
	}
	
	
	@ResponseBody
	@RequestMapping("/update")
    public ResultDO<?> update(UscUserDTO dto){
    	ResultDO<?> result = null;
    	 try{
    		 log.info(dto.getGender());
			 result = uscUserService.update(dto);
			} catch (Exception e) {
			 log.info(ExceptionUtils.getStackTrace(e));
			 result = new ResultDO<>(BaseResultCode.COMMON_FAIL,Boolean.FALSE);
			 result.setCloseCurrent(Boolean.FALSE);
			}
		 return result;
    }
    
    @ResponseBody
	@RequestMapping("/deleteById")
    public ResultDO<?> deleteById(Long id){
    	ResultDO<?> result = null;
    	 try{
			 result = uscUserService.deleteById(id);
			} catch (Exception e) {
			 log.info(ExceptionUtils.getStackTrace(e));
			 result = new ResultDO<>(BaseResultCode.COMMON_FAIL,Boolean.FALSE);
			 result.setCloseCurrent(Boolean.FALSE);
			}
		 return result;
    }
    
    @ResponseBody
	@RequestMapping("/deleteByCheck")
    public ResultDO<?> deleteByCheck(Long[] delids){
    	ResultDO<?> result = null;
   	 try{
   		 result  =  uscUserService.deleteByCheck(delids);
		} catch (Exception e) {
		 log.info(ExceptionUtils.getStackTrace(e));
		 result = new ResultDO<>(BaseResultCode.COMMON_FAIL,Boolean.FALSE);
		 result.setCloseCurrent(Boolean.FALSE);
		}
		 return result;
    }
    
    
    @ResponseBody
	@RequestMapping("/login")
    public ResultDO<?> login(String name ,String pass){
    	ResultDO<?> result = null;
   	 try{
   		 result  =  uscUserService.login(name, pass);
		} catch (Exception e) {
		 log.info(ExceptionUtils.getStackTrace(e));
		 result = new ResultDO<>(BaseResultCode.COMMON_FAIL,Boolean.FALSE);
		 result.setCloseCurrent(Boolean.FALSE);
		}
		 return result;
    }
    
    
    
}