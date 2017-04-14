package top.builbu.business.system.service.impl;

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
import top.builbu.business.system.dto.SmUserOrgDTO;
import top.builbu.business.system.entity.SmUserOrg;
import top.builbu.business.system.service.SmUserOrgService;
import top.builbu.business.system.repository.SmUserOrgMapper;
@Slf4j
@Service
public class SmUserOrgServiceImpl implements SmUserOrgService{
 
    @Autowired
	private SmUserOrgMapper smUserOrgMapper;
	
	
	@Override
	public PageDTO<SmUserOrgDTO> selectByList(SmUserOrgDTO dto,Pagination page ){
	    PageDTO<SmUserOrgDTO> pageDo = new PageDTO<SmUserOrgDTO>();
	    List<SmUserOrgDTO> result = smUserOrgMapper.selectByList(dto,page.getCurrentResult(),page.getPageSize());
		if(null!=result&&result.size()>0){
		    pageDo.setList(result);
		   
		}
		 pageDo.setPageCurrent(page.getPageCurrent());
		 pageDo.setPageSize(page.getPageSize());
		 pageDo.setTotal(smUserOrgMapper.selectByCount(dto));
		return pageDo;
	}
	
    @Override
	public ResultDO<SmUserOrg> selectById(Long id){
	    ResultDO<SmUserOrg> resultDo = null;
	    if(null!=id&&!"".equals(id)){
	        SmUserOrg result = smUserOrgMapper.selectByPrimaryKey(id);
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
    public ResultDO<?> save(SmUserOrgDTO dto){
    	ResultDO<?> result = null;
    	SmUserOrg record = new SmUserOrg(); 
    	BeanUtils.copyProperties(dto, record);
    	Integer rowId = smUserOrgMapper.insert(record);
    	if(null != rowId && rowId > 0){
    		result = new ResultDO<>(BaseResultCode.COMMON_MESSAGE_CHENGGONG,Boolean.TRUE);
    		result.setTabid("smUserOrgList");
    	}else{
    		result = new ResultDO<>(BaseResultCode.COMMON_MESSAGE_LOSE,Boolean.FALSE);
    		result.setCloseCurrent(Boolean.FALSE);
    	}
    	return result;
    }
    
    @Override
    public ResultDO<?> update(SmUserOrgDTO dto){
    	ResultDO<?> result = null;
    	SmUserOrg record = new SmUserOrg();
    	BeanUtils.copyProperties(dto, record);
    	Integer rowId = smUserOrgMapper.updateByPrimaryKey(record);
    	if(null != rowId && rowId > 0){
    		result = new ResultDO<>(BaseResultCode.COMMON_MESSAGE_CHENGGONG,Boolean.TRUE);
    		result.setTabid("smUserOrgList");
    	}else{
    		result = new ResultDO<>(BaseResultCode.COMMON_MESSAGE_LOSE,Boolean.FALSE);
    		result.setCloseCurrent(Boolean.FALSE);
    	}
    	return result;
    }
    
    @Override
    public ResultDO<?> deleteById(Long id){
    	ResultDO<?> result = null;
    	Integer rowId = smUserOrgMapper.deleteByPrimaryKey(id);
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
    	Integer rowId = smUserOrgMapper.deleteByAll(delids);
    	if(null != rowId && rowId > 0){
    		result = new ResultDO<>(BaseResultCode.COMMON_MESSAGE_CHENGGONG,Boolean.TRUE);
    	}else{
    		result = new ResultDO<>(BaseResultCode.COMMON_MESSAGE_LOSE,Boolean.FALSE);
    		result.setCloseCurrent(Boolean.FALSE);
    	}
    	return result;
    }
}
