package top.builbu.website.system.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;

import top.builbu.business.system.dto.SmMenuDTO;
import top.builbu.business.system.dto.SmRoleDTO;
import top.builbu.business.system.dto.SmRoleFuncDTO;
import top.builbu.business.system.dto.SmUserRoleDTO;
import top.builbu.business.system.entity.SmUserRole;
import top.builbu.business.system.service.SmRoleService;
import top.builbu.business.system.service.SmUserRoleService;
import top.builbu.business.user.dto.UscUserDTO;
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
@RequestMapping("/smUserRole")
public class SmUserRoleController {

	@Autowired
	private SmUserRoleService smUserRoleService;
	
	@Autowired
	private SmRoleService smRoleService;
	
	
	@RequestMapping("/selectByList")
	public String selectByList(HttpServletRequest request,SmUserRoleDTO dto,Pagination page){
		log.info(JSONObject.toJSONString(page));
		PageDTO<SmUserRoleDTO> result = null;
		try{
		    result = smUserRoleService.selectByList(dto,page);
		    request.setAttribute("pageDTO", result);
		    request.setAttribute("searchDTO", dto);
		    return "/system/smUserRoleList";
	    } catch (Exception e) {
			log.info(ExceptionUtils.getStackTrace(e));
			return ResultCode.ERROR;
		}
		
	}
	
	
	
	@RequestMapping("/selectById")
	public String selectById(HttpServletRequest request,Long id){
	  ResultDO<SmUserRole> result = null;
	    try{
		    result = smUserRoleService.selectById(id);
		    if(result.isSuccess()){
		       request.setAttribute("module",result.getModule());
		       return "/system/smUserRoleEdit";
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
	public ResultDO<?> save(SmUserRoleDTO dto){
		ResultDO<?> result = null;
		 try{
			 result = smUserRoleService.save(dto);
			} catch (Exception e) {
			 log.info(ExceptionUtils.getStackTrace(e));
			 result = new ResultDO<>(BaseResultCode.COMMON_FAIL,Boolean.FALSE);
			 result.setCloseCurrent(Boolean.FALSE);
			}
		 return result;
	}
	
	
	@ResponseBody
	@RequestMapping("/update")
    public ResultDO<?> update(SmUserRoleDTO dto){
    	ResultDO<?> result = null;
    	 try{
			 result = smUserRoleService.update(dto);
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
			 result = smUserRoleService.deleteById(id);
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
   		 result  =  smUserRoleService.deleteByCheck(delids);
		} catch (Exception e) {
		 log.info(ExceptionUtils.getStackTrace(e));
		 result = new ResultDO<>(BaseResultCode.COMMON_FAIL,Boolean.FALSE);
		 result.setCloseCurrent(Boolean.FALSE);
		}
		 return result;
    }
    
    
    @RequestMapping("/selectByInfo")
    public String selectByInfo(HttpServletRequest request,HttpSession session,SmRoleDTO dto,Long userId){
    	PageDTO<SmRoleDTO> result = null;
    	PageDTO<SmUserRoleDTO> resultF = null;
    	try {   		
    		result = smRoleService.selectByInfo(dto);
    		SmUserRoleDTO fDTO = new SmUserRoleDTO();
    		fDTO.setUserId(userId);
    		fDTO.setValidFlag("Y");
    		resultF = smUserRoleService.selectByInfo(fDTO);
    		request.setAttribute("pageDTO", result);
    		request.setAttribute("pageFTO", resultF);
    		request.setAttribute("userId", userId);
    		return "/user/roleByUser";
		} catch (Exception e) {
			log.info(ExceptionUtils.getStackTrace(e));
			return ResultCode.ERROR;
		}
    }
    
    @ResponseBody
   	@RequestMapping("/add")
   	public ResultDO<?> add(Long[] roleId,HttpSession session,Long[] oddId,Long userId){
   		ResultDO<?> result = null;
   		 try{
   			
   			 result = smUserRoleService.add(roleId,oddId,userId);
   			} catch (Exception e) {
   			 log.info(ExceptionUtils.getStackTrace(e));
   			 result = new ResultDO<>(BaseResultCode.COMMON_FAIL,Boolean.FALSE);
   			 result.setCloseCurrent(Boolean.FALSE);
   			}
   		 return result;
   	}
    
}