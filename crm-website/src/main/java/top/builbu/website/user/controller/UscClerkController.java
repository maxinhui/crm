package top.builbu.website.user.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.alibaba.fastjson.JSONObject;
import top.builbu.business.user.dto.UscClerkDTO;
import top.builbu.business.user.entity.UscClerk;
import top.builbu.business.user.service.UscClerkService;
import top.builbu.common.dto.PageDTO;
import top.builbu.common.dto.ResultDO;
import top.builbu.common.dto.ResultCode;
import top.builbu.common.dto.BaseResultCode;
import top.builbu.common.util.page.Pagination;
import org.springframework.web.multipart.MultipartFile;
import top.builbu.core.util.UploadUtil;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/uscClerk")
public class UscClerkController {

	@Autowired
	private UscClerkService uscClerkService;
	
	
	
	@RequestMapping("/selectByList")
	public String selectByList(HttpServletRequest request,UscClerkDTO dto,Pagination page){
		log.info(JSONObject.toJSONString(page));
		PageDTO<UscClerkDTO> result = null;
		try{
		    result = uscClerkService.selectByList(dto,page);
		    request.setAttribute("pageDTO", result);
		    request.setAttribute("searchDTO", dto);
		    return "/user/uscClerkList";
	    } catch (Exception e) {
			log.info(ExceptionUtils.getStackTrace(e));
			return ResultCode.ERROR;
		}
		
	}
	
	
	
	@RequestMapping("/selectById")
	public String selectById(HttpServletRequest request,Integer id){
	  ResultDO<UscClerk> result = null;
	    try{
		    result = uscClerkService.selectById(id);
		    if(result.isSuccess()){
		       request.setAttribute("module",result.getModule());
		       return "/user/uscClerkEdit";
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
	public ResultDO<?> save(UscClerkDTO dto){
		ResultDO<?> result = null;
		 try{
			 result = uscClerkService.save(dto);
			} catch (Exception e) {
			 log.info(ExceptionUtils.getStackTrace(e));
			 result = new ResultDO<>(BaseResultCode.COMMON_FAIL,Boolean.FALSE);
			 result.setCloseCurrent(Boolean.FALSE);
			}
		 return result;
	}
	
	
	@ResponseBody
	@RequestMapping("/update")
    public ResultDO<?> update(UscClerkDTO dto){
    	ResultDO<?> result = null;
    	 try{
			 result = uscClerkService.update(dto);
			} catch (Exception e) {
			 log.info(ExceptionUtils.getStackTrace(e));
			 result = new ResultDO<>(BaseResultCode.COMMON_FAIL,Boolean.FALSE);
			 result.setCloseCurrent(Boolean.FALSE);
			}
		 return result;
    }
    
    @ResponseBody
	@RequestMapping("/deleteById")
    public ResultDO<?> deleteById(Integer id){
    	ResultDO<?> result = null;
    	 try{
			 result = uscClerkService.deleteById(id);
			} catch (Exception e) {
			 log.info(ExceptionUtils.getStackTrace(e));
			 result = new ResultDO<>(BaseResultCode.COMMON_FAIL,Boolean.FALSE);
			 result.setCloseCurrent(Boolean.FALSE);
			}
		 return result;
    }
    
    @ResponseBody
	@RequestMapping("/deleteByCheck")
    public ResultDO<?> deleteByCheck(Integer[] delids){
    	ResultDO<?> result = null;
   	 try{
   		 result  =  uscClerkService.deleteByCheck(delids);
		} catch (Exception e) {
		 log.info(ExceptionUtils.getStackTrace(e));
		 result = new ResultDO<>(BaseResultCode.COMMON_FAIL,Boolean.FALSE);
		 result.setCloseCurrent(Boolean.FALSE);
		}
		 return result;
    }
    
}