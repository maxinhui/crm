package top.builbu.website.channel.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.alibaba.fastjson.JSONObject;
import top.builbu.business.channel.dto.CscStoreStatusDTO;
import top.builbu.business.channel.entity.CscStoreStatus;
import top.builbu.business.channel.service.CscStoreStatusService;
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
@RequestMapping("/cscStoreStatus")
public class CscStoreStatusController {

	@Autowired
	private CscStoreStatusService cscStoreStatusService;
	
	
	@RequestMapping("/add")
	public String add(){
		log.info("for ：cscStoreStatusAdd");
		return "/channel/cscStoreStatusAdd";
	}
	
	
	@RequestMapping("/selectByList")
	public String selectByList(HttpServletRequest request,CscStoreStatusDTO dto,Pagination page){
		log.info(JSONObject.toJSONString(page));
		PageDTO<CscStoreStatusDTO> result = null;
		try{
		    result = cscStoreStatusService.selectByList(dto,page);
		    request.setAttribute("pageDTO", result);
		    request.setAttribute("searchDTO", dto);
		    return "/channel/cscStoreStatusList";
	    } catch (Exception e) {
			log.info(ExceptionUtils.getStackTrace(e));
			return ResultCode.ERROR;
		}
		
	}
	
	
	
	@RequestMapping("/selectById")
	public String selectById(HttpServletRequest request,Long id){
	  ResultDO<CscStoreStatus> result = null;
	    try{
		    result = cscStoreStatusService.selectById(id);
		    if(result.isSuccess()){
		       request.setAttribute("module",result.getModule());
		       return "/channel/cscStoreStatusEdit";
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
	public ResultDO<?> save(CscStoreStatusDTO dto){
		ResultDO<?> result = null;
		 try{
			 result = cscStoreStatusService.save(dto);
			} catch (Exception e) {
			 log.info(ExceptionUtils.getStackTrace(e));
			 result = new ResultDO<>(BaseResultCode.COMMON_FAIL,Boolean.FALSE);
			 result.setCloseCurrent(Boolean.FALSE);
			}
		 return result;
	}
	
	
	@ResponseBody
	@RequestMapping("/update")
    public ResultDO<?> update(CscStoreStatusDTO dto){
    	ResultDO<?> result = null;
    	 try{
			 result = cscStoreStatusService.update(dto);
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
			 result = cscStoreStatusService.deleteById(id);
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
   		 result  =  cscStoreStatusService.deleteByCheck(delids);
		} catch (Exception e) {
		 log.info(ExceptionUtils.getStackTrace(e));
		 result = new ResultDO<>(BaseResultCode.COMMON_FAIL,Boolean.FALSE);
		 result.setCloseCurrent(Boolean.FALSE);
		}
		 return result;
    }
    
}