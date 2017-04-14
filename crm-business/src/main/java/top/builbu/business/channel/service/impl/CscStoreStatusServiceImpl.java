package top.builbu.business.channel.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.beans.BeanUtils;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import top.builbu.common.util.page.Pagination;
import top.builbu.common.dto.PageDTO;
import top.builbu.common.dto.BaseResultCode;
import top.builbu.common.dto.ResultDO;
import top.builbu.business.channel.dto.CscStoreStatusDTO;
import top.builbu.business.channel.entity.CscStoreStatus;
import top.builbu.business.channel.service.CscStoreStatusService;
import top.builbu.business.channel.repository.CscStoreStatusMapper;
@Slf4j
@Service
public class CscStoreStatusServiceImpl implements CscStoreStatusService{
 
    @Autowired
	private CscStoreStatusMapper cscStoreStatusMapper;
	
	
	@Override
	public PageDTO<CscStoreStatusDTO> selectByList(CscStoreStatusDTO dto,Pagination page ){
	    PageDTO<CscStoreStatusDTO> pageDo = new PageDTO<CscStoreStatusDTO>();
	    List<CscStoreStatusDTO> result = cscStoreStatusMapper.selectByList(dto,page.getCurrentResult(),page.getPageSize());
		if(null!=result&&result.size()>0){
		    pageDo.setList(result);
		   
		}
		 pageDo.setPageCurrent(page.getPageCurrent());
		 pageDo.setPageSize(page.getPageSize());
		 pageDo.setTotal(cscStoreStatusMapper.selectByCount(dto));
		return pageDo;
	}
	
    @Override
	public ResultDO<CscStoreStatus> selectById(Long id){
	    ResultDO<CscStoreStatus> resultDo = null;
	    if(null!=id&&!"".equals(id)){
	        CscStoreStatus result = cscStoreStatusMapper.selectByPrimaryKey(id);
	        if(null!=result){
	            resultDo = new ResultDO<>(result);
	        }else{
	            resultDo = new ResultDO<>(BaseResultCode.COMMON_NO_DATA,Boolean.FALSE);
	        }
	    }else{
	        resultDo = new ResultDO<>(BaseResultCode.COMMON_WRONG_PARAMS,Boolean.FALSE);
	    }
	    return resultDo;
	}
	
    @Override
    public ResultDO<?> save(CscStoreStatusDTO dto){
    	ResultDO<?> result = null;
    	CscStoreStatus record = new CscStoreStatus(); 
    	BeanUtils.copyProperties(dto, record);
    	Integer rowId = cscStoreStatusMapper.insert(record);
    	if(null != rowId && rowId > 0){
    		result = new ResultDO<>(BaseResultCode.COMMON_MESSAGE_CHENGGONG,Boolean.TRUE);
    		result.setTabid("cscStoreStatusList");
    	}else{
    		result = new ResultDO<>(BaseResultCode.COMMON_MESSAGE_LOSE,Boolean.FALSE);
    		result.setCloseCurrent(Boolean.FALSE);
    	}
    	return result;
    }
    
    @Override
    public ResultDO<?> update(CscStoreStatusDTO dto){
    	ResultDO<?> result = null;
    	CscStoreStatus record = new CscStoreStatus();
    	BeanUtils.copyProperties(dto, record);
    	Integer rowId = cscStoreStatusMapper.updateByPrimaryKey(record);
    	if(null != rowId && rowId > 0){
    		result = new ResultDO<>(BaseResultCode.COMMON_MESSAGE_CHENGGONG,Boolean.TRUE);
    		result.setTabid("cscStoreStatusList");
    	}else{
    		result = new ResultDO<>(BaseResultCode.COMMON_MESSAGE_LOSE,Boolean.FALSE);
    		result.setCloseCurrent(Boolean.FALSE);
    	}
    	return result;
    }
    
    @Override
    public ResultDO<?> deleteById(Long id){
    	ResultDO<?> result = null;
    	Integer rowId = cscStoreStatusMapper.deleteByPrimaryKey(id);
    	if(null != rowId && rowId > 0){
    		result = new ResultDO<>(BaseResultCode.COMMON_MESSAGE_CHENGGONG,Boolean.TRUE);
    	}else{
    		result = new ResultDO<>(BaseResultCode.COMMON_MESSAGE_LOSE,Boolean.FALSE);
    	}
    	return result;
    }
    
    @Override
    public ResultDO<?> deleteByCheck(Long[] delids){
    	ResultDO<?> result = null;
    	Integer rowId = cscStoreStatusMapper.deleteByAll(delids);
    	if(null != rowId && rowId > 0){
    		result = new ResultDO<>(BaseResultCode.COMMON_MESSAGE_CHENGGONG,Boolean.TRUE);
    	}else{
    		result = new ResultDO<>(BaseResultCode.COMMON_MESSAGE_LOSE,Boolean.FALSE);
    		result.setCloseCurrent(Boolean.FALSE);
    	}
    	return result;
    }
}
