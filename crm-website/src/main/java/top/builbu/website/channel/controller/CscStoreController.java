package top.builbu.website.channel.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;

import top.builbu.business.channel.dto.CscCustomerDTO;
import top.builbu.business.channel.dto.CscStoreDTO;
import top.builbu.business.channel.entity.CscStore;
import top.builbu.business.channel.service.CscStoreService;
import top.builbu.business.user.dto.MemberDTO;
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
@RequestMapping("/cscStore")
public class CscStoreController {

	@Autowired
	private CscStoreService cscStoreService;
	
	@RequestMapping("/add")
	public String add(HttpServletRequest request,HttpSession session){
		MemberDTO member = (MemberDTO) session.getAttribute(UserCode.LOGINUSER);
		request.setAttribute("memberDTO", member);
		log.info("for ： cscStoreAdd");
		return "/channel/cscStoreAdd";
	}
	
	
	@RequestMapping("/selectByList")
	public String selectByList(HttpServletRequest request,CscStoreDTO dto,Pagination page){
		log.info(JSONObject.toJSONString(page));
		PageDTO<CscStoreDTO> result = null;
		try{
		    result = cscStoreService.selectByList(dto,page);
		    request.setAttribute("pageDTO", result);
		    request.setAttribute("searchDTO", dto);
		    return "/channel/cscStoreList";
	    } catch (Exception e) {
			log.info(ExceptionUtils.getStackTrace(e));
			return ResultCode.ERROR;
		}
		
	}
	
	
	
	@RequestMapping("/selectById")
	public String selectById(HttpServletRequest request,Long id){
	  ResultDO<CscStore> result = null;
	    try{
		    result = cscStoreService.selectById(id);
		    if(result.isSuccess()){
		       request.setAttribute("module",result.getModule());
		       return "/channel/cscStoreEdit";
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
	public ResultDO<?> save(CscStoreDTO dto){
		ResultDO<?> result = null;
		 try{
			 result = cscStoreService.save(dto);
			} catch (Exception e) {
			 log.info(ExceptionUtils.getStackTrace(e));
			 result = new ResultDO<>(BaseResultCode.COMMON_FAIL,Boolean.FALSE);
			 result.setCloseCurrent(Boolean.FALSE);
			}
		 return result;
	}
	
	
	@ResponseBody
	@RequestMapping("/update")
    public ResultDO<?> update(CscStoreDTO dto){
    	ResultDO<?> result = null;
    	 try{
			 result = cscStoreService.update(dto);
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
			 result = cscStoreService.deleteById(id);
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
   		 result  =  cscStoreService.deleteByCheck(delids);
		} catch (Exception e) {
		 log.info(ExceptionUtils.getStackTrace(e));
		 result = new ResultDO<>(BaseResultCode.COMMON_FAIL,Boolean.FALSE);
		 result.setCloseCurrent(Boolean.FALSE);
		}
		 return result;
    }
    
    
    @RequestMapping("/lookup")
   	public String lookup(HttpServletRequest request,CscStoreDTO dto,Pagination page){
   		log.info(JSONObject.toJSONString(page));
   		PageDTO<CscStoreDTO> result = null;
   		try{
   		    result = cscStoreService.selectByList(dto,page);
   		    request.setAttribute("pageDTO", result);
   		    request.setAttribute("searchDTO", dto);
   		    return "/channel/storeLookup";
   	    } catch (Exception e) {
   			log.info(ExceptionUtils.getStackTrace(e));
   			return ResultCode.ERROR;
   		}
   		
   	}
}