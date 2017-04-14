package top.builbu.website.system.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.alibaba.fastjson.JSONObject;
import top.builbu.business.system.dto.SmMenuDTO;
import top.builbu.business.system.entity.SmMenu;
import top.builbu.business.system.service.SmMenuService;
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
@RequestMapping("/smMenu")
public class SmMenuController {

	@Autowired
	private SmMenuService smMenuService;
	
	
	
	@RequestMapping("/selectByList")
	public String selectByList(HttpServletRequest request,SmMenuDTO dto,Pagination page){
		log.info(JSONObject.toJSONString(page));
		PageDTO<SmMenuDTO> result = null;
		try{
		    result = smMenuService.selectByList(dto,page);
		    request.setAttribute("pageDTO", result);
		    request.setAttribute("searchDTO", dto);
		    return "/system/smMenuList";
	    } catch (Exception e) {
			log.info(ExceptionUtils.getStackTrace(e));
			return ResultCode.ERROR;
		}
		
	}
	
	
	
	@RequestMapping("/selectById")
	public String selectById(HttpServletRequest request,Long id){
	  ResultDO<SmMenu> result = null;
	    try{
		    result = smMenuService.selectById(id);
		    if(result.isSuccess()){
		       request.setAttribute("module",result.getModule());
		       return "/system/smMenuEdit";
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
	public ResultDO<?> save(SmMenuDTO dto){
		ResultDO<?> result = null;
		 try{
			 result = smMenuService.save(dto);
			} catch (Exception e) {
			 log.info(ExceptionUtils.getStackTrace(e));
			 result = new ResultDO<>(BaseResultCode.COMMON_FAIL,Boolean.FALSE);
			 result.setCloseCurrent(Boolean.FALSE);
			}
		 return result;
	}
	
	
	@ResponseBody
	@RequestMapping("/update")
    public ResultDO<?> update(SmMenuDTO dto){
    	ResultDO<?> result = null;
    	 try{
			 result = smMenuService.update(dto);
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
			 result = smMenuService.deleteById(id);
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
   		 result  =  smMenuService.deleteByCheck(delids);
		} catch (Exception e) {
		 log.info(ExceptionUtils.getStackTrace(e));
		 result = new ResultDO<>(BaseResultCode.COMMON_FAIL,Boolean.FALSE);
		 result.setCloseCurrent(Boolean.FALSE);
		}
		 return result;
    }
    
	@RequestMapping("/lookup")
	public String lookup(HttpServletRequest request,SmMenuDTO dto,Pagination page){
		log.info(JSONObject.toJSONString(page));
		PageDTO<SmMenuDTO> result = null;
		try{
		    result = smMenuService.selectByList(dto,page);
		    request.setAttribute("pageDTO", result);
		    return "/system/smMenuLookup";
	    } catch (Exception e) {
			log.info(ExceptionUtils.getStackTrace(e));
			return ResultCode.ERROR;
		}
		
	}
    
	@RequestMapping("/blookup")
	public String blookup(HttpServletRequest request,SmMenuDTO dto,Pagination page){
		log.info(JSONObject.toJSONString(page));
		PageDTO<SmMenuDTO> result = null;
		try{
		    result = smMenuService.selectByList(dto,page);
		    request.setAttribute("pageDTO", result);
		    return "/system/smButtonLookup";
	    } catch (Exception e) {
			log.info(ExceptionUtils.getStackTrace(e));
			return ResultCode.ERROR;
		}
		
	}
}