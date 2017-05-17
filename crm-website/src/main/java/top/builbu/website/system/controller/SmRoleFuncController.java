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
import top.builbu.business.system.dto.SmRoleFuncDTO;
import top.builbu.business.system.entity.SmRoleFunc;
import top.builbu.business.system.service.SmMenuService;
import top.builbu.business.system.service.SmRoleFuncService;
import top.builbu.business.user.dto.MemberDTO;
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
@RequestMapping("/smRoleFunc")
public class SmRoleFuncController {

	@Autowired
	private SmRoleFuncService smRoleFuncService;
	
	@Autowired
	private SmMenuService smMenuService;
	
	@RequestMapping("/selectByList")
	public String selectByList(HttpServletRequest request,SmRoleFuncDTO dto,Pagination page){
		log.info(JSONObject.toJSONString(page));
		PageDTO<SmRoleFuncDTO> result = null;
		try{
		    result = smRoleFuncService.selectByList(dto,page);
		    request.setAttribute("pageDTO", result);
		    request.setAttribute("searchDTO", dto);
		    return "/system/smRoleFuncList";
	    } catch (Exception e) {
			log.info(ExceptionUtils.getStackTrace(e));
			return ResultCode.ERROR;
		}
		
	}
	
	
	
	@RequestMapping("/selectById")
	public String selectById(HttpServletRequest request,Long id){
	  ResultDO<SmRoleFunc> result = null;
	    try{
		    result = smRoleFuncService.selectById(id);
		    if(result.isSuccess()){
		       request.setAttribute("module",result.getModule());
		       return "/system/smRoleFuncEdit";
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
	public ResultDO<?> save(SmRoleFuncDTO dto){
		ResultDO<?> result = null;
		 try{
			 result = smRoleFuncService.save(dto);
			} catch (Exception e) {
			 log.info(ExceptionUtils.getStackTrace(e));
			 result = new ResultDO<>(BaseResultCode.COMMON_FAIL,Boolean.FALSE);
			 result.setCloseCurrent(Boolean.FALSE);
			}
		 return result;
	}
	
	
	@ResponseBody
	@RequestMapping("/update")
    public ResultDO<?> update(SmRoleFuncDTO dto){
    	ResultDO<?> result = null;
    	 try{
			 result = smRoleFuncService.update(dto);
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
			 result = smRoleFuncService.deleteById(id);
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
   		 result  =  smRoleFuncService.deleteByCheck(delids);
		} catch (Exception e) {
		 log.info(ExceptionUtils.getStackTrace(e));
		 result = new ResultDO<>(BaseResultCode.COMMON_FAIL,Boolean.FALSE);
		 result.setCloseCurrent(Boolean.FALSE);
		}
		 return result;
    }
    
    
    @RequestMapping("/selectByInfo")
    public String selectByInfo(HttpServletRequest request,SmMenuDTO dto){
    	PageDTO<SmMenuDTO> result = null;
    	try {
    		result = smMenuService.selectByInfo(dto);
    		request.setAttribute("pageDTO", result);
    		return "/system/menuZtree";
		} catch (Exception e) {
			log.info(ExceptionUtils.getStackTrace(e));
			return ResultCode.ERROR;
		}
    }
    
    @RequestMapping("/selectByRole")
    public String selectByRole(HttpServletRequest request,HttpSession session,SmMenuDTO dto,Long roleId){
    	PageDTO<SmMenuDTO> result = null;
    	PageDTO<SmRoleFuncDTO> resultF = null;
    	try {
    		MemberDTO memberDTO = (MemberDTO) session.getAttribute(UserCode.LOGINUSER);
    		if(memberDTO.getUserType() == 3){//用户类型3经销商，添加查询条件是否对其开发
    			dto.setMenuType(1);
    		}
    		result = smMenuService.selectByInfo(dto);
    		SmRoleFuncDTO fDTO = new SmRoleFuncDTO();
    		fDTO.setRoleId(roleId);
    		fDTO.setValidFlag("Y");
    		
    		resultF = smRoleFuncService.selectByInfo(fDTO);
    		request.setAttribute("pageDTO", result);
    		request.setAttribute("pageFTO", resultF);
    		request.setAttribute("roleId", roleId);
    		return "/system/menuForRole";
		} catch (Exception e) {
			log.info(ExceptionUtils.getStackTrace(e));
			return ResultCode.ERROR;
		}
    }
    @ResponseBody
   	@RequestMapping("/add")
   	public ResultDO<?> add(Long[] menuId,Long[] buttonId,Long[] oddId,Long roleId){
   		ResultDO<?> result = null;
   		 try{
   			 result = smRoleFuncService.add(menuId,buttonId,oddId,roleId);
   			} catch (Exception e) {
   			 log.info(ExceptionUtils.getStackTrace(e));
   			 result = new ResultDO<>(BaseResultCode.COMMON_FAIL,Boolean.FALSE);
   			 result.setCloseCurrent(Boolean.FALSE);
   			}
   		 return result;
   	}
}