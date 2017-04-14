package top.builbu.business.user.service.impl;

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
import top.builbu.business.user.dto.UscClerkDTO;
import top.builbu.business.user.entity.UscClerk;
import top.builbu.business.user.service.UscClerkService;
import top.builbu.business.user.repository.UscClerkMapper;
@Slf4j
@Service
public class UscClerkServiceImpl implements UscClerkService{
 
    @Autowired
	private UscClerkMapper uscClerkMapper;
	
	
	@Override
	public PageDTO<UscClerkDTO> selectByList(UscClerkDTO dto,Pagination page ){
	    PageDTO<UscClerkDTO> pageDo = new PageDTO<UscClerkDTO>();
	    List<UscClerkDTO> result = uscClerkMapper.selectByList(dto,page.getCurrentResult(),page.getPageSize());
		if(null!=result&&result.size()>0){
		    pageDo.setList(result);
		   
		}
		 pageDo.setPageCurrent(page.getPageCurrent());
		 pageDo.setPageSize(page.getPageSize());
		 pageDo.setTotal(uscClerkMapper.selectByCount(dto));
		return pageDo;
	}
	
    @Override
	public ResultDO<UscClerk> selectById(Integer id){
	    ResultDO<UscClerk> resultDo = null;
	    if(null!=id&&!"".equals(id)){
	        UscClerk result = uscClerkMapper.selectByPrimaryKey(id);
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
    public ResultDO<?> save(UscClerkDTO dto){
    	ResultDO<?> result = null;
    	UscClerk record = new UscClerk(); 
    	BeanUtils.copyProperties(dto, record);
    	Integer rowId = uscClerkMapper.insert(record);
    	if(null != rowId && rowId > 0){
    		result = new ResultDO<>(BaseResultCode.COMMON_MESSAGE_CHENGGONG,Boolean.TRUE);
    		result.setTabid("uscClerkList");
    	}else{
    		result = new ResultDO<>(BaseResultCode.COMMON_MESSAGE_LOSE,Boolean.FALSE);
    		result.setCloseCurrent(Boolean.FALSE);
    	}
    	return result;
    }
    
    @Override
    public ResultDO<?> update(UscClerkDTO dto){
    	ResultDO<?> result = null;
    	UscClerk record = new UscClerk();
    	BeanUtils.copyProperties(dto, record);
    	Integer rowId = uscClerkMapper.updateByPrimaryKey(record);
    	if(null != rowId && rowId > 0){
    		result = new ResultDO<>(BaseResultCode.COMMON_MESSAGE_CHENGGONG,Boolean.TRUE);
    		result.setTabid("uscClerkList");
    	}else{
    		result = new ResultDO<>(BaseResultCode.COMMON_MESSAGE_LOSE,Boolean.FALSE);
    		result.setCloseCurrent(Boolean.FALSE);
    	}
    	return result;
    }
    
    @Override
    public ResultDO<?> deleteById(Integer id){
    	ResultDO<?> result = null;
    	Integer rowId = uscClerkMapper.deleteByPrimaryKey(id);
    	if(null != rowId && rowId > 0){
    		result = new ResultDO<>(BaseResultCode.COMMON_MESSAGE_CHENGGONG,Boolean.TRUE);
    	}else{
    		result = new ResultDO<>(BaseResultCode.COMMON_MESSAGE_LOSE,Boolean.FALSE);
    	}
    	return result;
    }
    
    @Override
    public ResultDO<?> deleteByCheck(Integer[] delids){
    	ResultDO<?> result = null;
    	Integer rowId = uscClerkMapper.deleteByAll(delids);
    	if(null != rowId && rowId > 0){
    		result = new ResultDO<>(BaseResultCode.COMMON_MESSAGE_CHENGGONG,Boolean.TRUE);
    	}else{
    		result = new ResultDO<>(BaseResultCode.COMMON_MESSAGE_LOSE,Boolean.FALSE);
    		result.setCloseCurrent(Boolean.FALSE);
    	}
    	return result;
    }
    
    @Override
    public ResultDO<?> updateByStore(String belongStore){
    	ResultDO<?> result = null;
    	Integer rowId = uscClerkMapper.updateByStore(belongStore);
    	if(null != rowId && rowId > 0){
    		result = new ResultDO<>(BaseResultCode.COMMON_MESSAGE_CHENGGONG,Boolean.TRUE);
    		result.setTabid("uscClerkList");
    	}else{
    		result = new ResultDO<>(BaseResultCode.COMMON_MESSAGE_LOSE,Boolean.FALSE);
    		result.setCloseCurrent(Boolean.FALSE);
    	}
    	return result;
    }
}
