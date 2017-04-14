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
import top.builbu.business.channel.dto.CscStoreNatureDTO;
import top.builbu.business.channel.entity.CscStoreNature;
import top.builbu.business.channel.service.CscStoreNatureService;
import top.builbu.business.channel.repository.CscStoreNatureMapper;
@Slf4j
@Service
public class CscStoreNatureServiceImpl implements CscStoreNatureService{
 
    @Autowired
	private CscStoreNatureMapper cscStoreNatureMapper;
	
	
	@Override
	public PageDTO<CscStoreNatureDTO> selectByList(CscStoreNatureDTO dto,Pagination page ){
	    PageDTO<CscStoreNatureDTO> pageDo = new PageDTO<CscStoreNatureDTO>();
	    List<CscStoreNatureDTO> result = cscStoreNatureMapper.selectByList(dto,page.getCurrentResult(),page.getPageSize());
		if(null!=result&&result.size()>0){
		    pageDo.setList(result);
		   
		}
		 pageDo.setPageCurrent(page.getPageCurrent());
		 pageDo.setPageSize(page.getPageSize());
		 pageDo.setTotal(cscStoreNatureMapper.selectByCount(dto));
		return pageDo;
	}
	
    @Override
	public ResultDO<CscStoreNature> selectById(Long id){
	    ResultDO<CscStoreNature> resultDo = null;
	    if(null!=id&&!"".equals(id)){
	        CscStoreNature result = cscStoreNatureMapper.selectByPrimaryKey(id);
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
    public ResultDO<?> save(CscStoreNatureDTO dto){
    	ResultDO<?> result = null;
    	CscStoreNature record = new CscStoreNature(); 
    	BeanUtils.copyProperties(dto, record);
    	Integer rowId = cscStoreNatureMapper.insert(record);
    	if(null != rowId && rowId > 0){
    		result = new ResultDO<>(BaseResultCode.COMMON_MESSAGE_CHENGGONG,Boolean.TRUE);
    		result.setTabid("cscStoreNatureList");
    	}else{
    		result = new ResultDO<>(BaseResultCode.COMMON_MESSAGE_LOSE,Boolean.FALSE);
    		result.setCloseCurrent(Boolean.FALSE);
    	}
    	return result;
    }
    
    @Override
    public ResultDO<?> update(CscStoreNatureDTO dto){
    	ResultDO<?> result = null;
    	CscStoreNature record = new CscStoreNature();
    	BeanUtils.copyProperties(dto, record);
    	Integer rowId = cscStoreNatureMapper.updateByPrimaryKey(record);
    	if(null != rowId && rowId > 0){
    		result = new ResultDO<>(BaseResultCode.COMMON_MESSAGE_CHENGGONG,Boolean.TRUE);
    		result.setTabid("cscStoreNatureList");
    	}else{
    		result = new ResultDO<>(BaseResultCode.COMMON_MESSAGE_LOSE,Boolean.FALSE);
    		result.setCloseCurrent(Boolean.FALSE);
    	}
    	return result;
    }
    
    @Override
    public ResultDO<?> deleteById(Long id){
    	ResultDO<?> result = null;
    	Integer rowId = cscStoreNatureMapper.deleteByPrimaryKey(id);
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
    	Integer rowId = cscStoreNatureMapper.deleteByAll(delids);
    	if(null != rowId && rowId > 0){
    		result = new ResultDO<>(BaseResultCode.COMMON_MESSAGE_CHENGGONG,Boolean.TRUE);
    	}else{
    		result = new ResultDO<>(BaseResultCode.COMMON_MESSAGE_LOSE,Boolean.FALSE);
    		result.setCloseCurrent(Boolean.FALSE);
    	}
    	return result;
    }
}
