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
import top.builbu.business.system.dto.SmRoleDTO;
import top.builbu.business.system.entity.SmRole;
import top.builbu.business.system.service.SmRoleService;
import top.builbu.business.system.repository.SmRoleMapper;
@Slf4j
@Service
public class SmRoleServiceImpl implements SmRoleService{
 
    @Autowired
	private SmRoleMapper smRoleMapper;
	
	
	@Override
	public PageDTO<SmRoleDTO> selectByList(SmRoleDTO dto,Pagination page ){
	    PageDTO<SmRoleDTO> pageDo = new PageDTO<SmRoleDTO>();
	    List<SmRoleDTO> result = smRoleMapper.selectByList(dto,page.getCurrentResult(),page.getPageSize());
		if(null!=result&&result.size()>0){
		    pageDo.setList(result);
		   
		}
		 pageDo.setPageCurrent(page.getPageCurrent());
		 pageDo.setPageSize(page.getPageSize());
		 pageDo.setTotal(smRoleMapper.selectByCount(dto));
		return pageDo;
	}
	
    @Override
	public ResultDO<SmRole> selectById(Long id){
	    ResultDO<SmRole> resultDo = null;
	    if(null!=id&&!"".equals(id)){
	        SmRole result = smRoleMapper.selectByPrimaryKey(id);
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
    public ResultDO<?> save(SmRoleDTO dto){
    	ResultDO<?> result = null;
    	SmRole record = new SmRole(); 
    	BeanUtils.copyProperties(dto, record);
    	record.setRoleNo(RandomUtil.randomNo("Ro"));
    	Integer rowId = smRoleMapper.insert(record);
    	if(null != rowId && rowId > 0){
    		result = new ResultDO<>(BaseResultCode.COMMON_MESSAGE_CHENGGONG,Boolean.TRUE);
    		result.setTabid("smRoleList");
    	}else{
    		result = new ResultDO<>(BaseResultCode.COMMON_MESSAGE_LOSE,Boolean.FALSE);
    		result.setCloseCurrent(Boolean.FALSE);
    	}
    	return result;
    }
    
    @Override
    public ResultDO<?> update(SmRoleDTO dto){
    	ResultDO<?> result = null;
    	SmRole record = new SmRole();
    	BeanUtils.copyProperties(dto, record);
    	Integer rowId = smRoleMapper.updateByPrimaryKey(record);
    	if(null != rowId && rowId > 0){
    		result = new ResultDO<>(BaseResultCode.COMMON_MESSAGE_CHENGGONG,Boolean.TRUE);
    		result.setTabid("smRoleList");
    	}else{
    		result = new ResultDO<>(BaseResultCode.COMMON_MESSAGE_LOSE,Boolean.FALSE);
    		result.setCloseCurrent(Boolean.FALSE);
    	}
    	return result;
    }
    
    @Override
    public ResultDO<?> deleteById(Long id){
    	ResultDO<?> result = null;
    	Integer rowId = smRoleMapper.deleteByPrimaryKey(id);
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
    	Integer rowId = smRoleMapper.deleteByAll(delids);
    	if(null != rowId && rowId > 0){
    		result = new ResultDO<>(BaseResultCode.COMMON_MESSAGE_CHENGGONG,Boolean.TRUE);
    	}else{
    		result = new ResultDO<>(BaseResultCode.COMMON_MESSAGE_LOSE,Boolean.FALSE);
    		result.setCloseCurrent(Boolean.FALSE);
    	}
    	return result;
    }
    
    
    @Override
    public PageDTO<SmRoleDTO> selectByInfo(SmRoleDTO dto){
    	PageDTO<SmRoleDTO> result = new PageDTO<SmRoleDTO>();
    	List<SmRoleDTO> list = smRoleMapper.selectByInfo(dto);
    	if(null != list && list.size()>0){
    		result.setList(list);
    	}
    	return result;
    }
    
    
    @Override
    public ResultDO<Set<SmRoleDTO>> selectByUserId(Long userId){
    	ResultDO<Set<SmRoleDTO>> resultDo = null;
        if(null != userId && !"".equals(userId)){
        	Set<SmRoleDTO> roleSet = smRoleMapper.slelctByUserId(userId);
        	if(null != roleSet){
        		resultDo = new ResultDO<>(roleSet);
        	}else{
        		resultDo = new ResultDO<>(BaseResultCode.COMMON_NO_DATA,Boolean.FALSE);
        	}
        }else{
                resultDo = new ResultDO<>(BaseResultCode.COMMON_WRONG_PARAMS,Boolean.FALSE);
    	}  
        return resultDo;
    }
}
