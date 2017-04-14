package top.builbu.business.system.service.impl;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.beans.BeanUtils;

import com.alibaba.fastjson.JSONObject;

import lombok.extern.slf4j.Slf4j;
import top.builbu.common.util.RandomUtil;
import top.builbu.common.util.page.Pagination;
import top.builbu.common.dto.PageDTO;
import top.builbu.common.dto.BaseResultCode;
import top.builbu.common.dto.ResultDO;
import top.builbu.business.system.dto.SmButtonDTO;
import top.builbu.business.system.entity.SmButton;
import top.builbu.business.system.service.SmButtonService;
import top.builbu.business.system.repository.SmButtonMapper;
@Slf4j
@Service
public class SmButtonServiceImpl implements SmButtonService{
 
    @Autowired
	private SmButtonMapper smButtonMapper;
	
	
	@Override
	public PageDTO<SmButtonDTO> selectByList(SmButtonDTO dto,Pagination page ){
	    PageDTO<SmButtonDTO> pageDo = new PageDTO<SmButtonDTO>();
	    List<SmButtonDTO> result = smButtonMapper.selectByList(dto,page.getCurrentResult(),page.getPageSize());
		if(null!=result&&result.size()>0){
		    pageDo.setList(result);
		   
		}
		 pageDo.setPageCurrent(page.getPageCurrent());
		 pageDo.setPageSize(page.getPageSize());
		 pageDo.setTotal(smButtonMapper.selectByCount(dto));
		return pageDo;
	}
	
    @Override
	public ResultDO<SmButton> selectById(Long id){
	    ResultDO<SmButton> resultDo = null;
	    if(null!=id&&!"".equals(id)){
	        SmButton result = smButtonMapper.selectByPrimaryKey(id);
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
    public ResultDO<?> save(SmButtonDTO dto){
    	ResultDO<?> result = null;
    	SmButton record = new SmButton(); 
    	BeanUtils.copyProperties(dto, record);
    	record.setButtonNo(RandomUtil.randomNo("Bu"));
    	Integer rowId = smButtonMapper.insert(record);
    	if(null != rowId && rowId > 0){
    		result = new ResultDO<>(BaseResultCode.COMMON_MESSAGE_CHENGGONG,Boolean.TRUE);
    		result.setTabid("smButtonList");
    	}else{
    		result = new ResultDO<>(BaseResultCode.COMMON_MESSAGE_LOSE,Boolean.FALSE);
    		result.setCloseCurrent(Boolean.FALSE);
    	}
    	return result;
    }
    
    @Override
    public ResultDO<?> update(SmButtonDTO dto){
    	ResultDO<?> result = null;
    	SmButton record = new SmButton();
    	BeanUtils.copyProperties(dto, record);
    	Integer rowId = smButtonMapper.updateByPrimaryKey(record);
    	if(null != rowId && rowId > 0){
    		result = new ResultDO<>(BaseResultCode.COMMON_MESSAGE_CHENGGONG,Boolean.TRUE);
    		result.setTabid("smButtonList");
    	}else{
    		result = new ResultDO<>(BaseResultCode.COMMON_MESSAGE_LOSE,Boolean.FALSE);
    		result.setCloseCurrent(Boolean.FALSE);
    	}
    	return result;
    }
    
    @Override
    public ResultDO<?> deleteById(Long id){
    	ResultDO<?> result = null;
    	Integer rowId = smButtonMapper.deleteByPrimaryKey(id);
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
    	Integer rowId = smButtonMapper.deleteByAll(delids);
    	if(null != rowId && rowId > 0){
    		result = new ResultDO<>(BaseResultCode.COMMON_MESSAGE_CHENGGONG,Boolean.TRUE);
    	}else{
    		result = new ResultDO<>(BaseResultCode.COMMON_MESSAGE_LOSE,Boolean.FALSE);
    		result.setCloseCurrent(Boolean.FALSE);
    	}
    	return result;
    }
    
    
    @Override
    public PageDTO<SmButtonDTO> selectByInfo(SmButtonDTO dto){
    	PageDTO<SmButtonDTO> result = new PageDTO<SmButtonDTO>();
    	List<SmButtonDTO> list = smButtonMapper.selectByInfo(dto);
    	if(null != list && list.size()>0){
    		result.setList(list);
    	}
    	return result;
    }
    
    @Override
    public ResultDO<Set<SmButtonDTO>> selectyByRoleId(Long roleId){
    	ResultDO<Set<SmButtonDTO>> resultDo = null;
    	if(null != roleId && !"".equals(roleId)){
    		Set<SmButtonDTO> result = smButtonMapper.selectByRoleId(roleId);
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
}
