package top.builbu.business.system.service.impl;

import java.util.ArrayList;
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
import top.builbu.business.system.dto.SmRoleDTO;
import top.builbu.business.system.dto.SmUserRoleDTO;
import top.builbu.business.system.entity.SmUserRole;
import top.builbu.business.system.service.SmUserRoleService;
import top.builbu.business.system.repository.SmUserRoleMapper;
@Slf4j
@Service
public class SmUserRoleServiceImpl implements SmUserRoleService{
 
    @Autowired
	private SmUserRoleMapper smUserRoleMapper;
	
	
	@Override
	public PageDTO<SmUserRoleDTO> selectByList(SmUserRoleDTO dto,Pagination page ){
	    PageDTO<SmUserRoleDTO> pageDo = new PageDTO<SmUserRoleDTO>();
	    List<SmUserRoleDTO> result = smUserRoleMapper.selectByList(dto,page.getCurrentResult(),page.getPageSize());
		if(null!=result&&result.size()>0){
		    pageDo.setList(result);
		   
		}
		 pageDo.setPageCurrent(page.getPageCurrent());
		 pageDo.setPageSize(page.getPageSize());
		 pageDo.setTotal(smUserRoleMapper.selectByCount(dto));
		return pageDo;
	}
	
    @Override
	public ResultDO<SmUserRole> selectById(Long id){
	    ResultDO<SmUserRole> resultDo = null;
	    if(null!=id&&!"".equals(id)){
	        SmUserRole result = smUserRoleMapper.selectByPrimaryKey(id);
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
    public ResultDO<?> save(SmUserRoleDTO dto){
    	ResultDO<?> result = null;
    	SmUserRole record = new SmUserRole(); 
    	BeanUtils.copyProperties(dto, record);
    	Integer rowId = smUserRoleMapper.insert(record);
    	if(null != rowId && rowId > 0){
    		result = new ResultDO<>(BaseResultCode.COMMON_MESSAGE_CHENGGONG,Boolean.TRUE);
    		result.setTabid("smUserRoleList");
    	}else{
    		result = new ResultDO<>(BaseResultCode.COMMON_MESSAGE_LOSE,Boolean.FALSE);
    		result.setCloseCurrent(Boolean.FALSE);
    	}
    	return result;
    }
    
    @Override
    public ResultDO<?> update(SmUserRoleDTO dto){
    	ResultDO<?> result = null;
    	SmUserRole record = new SmUserRole();
    	BeanUtils.copyProperties(dto, record);
    	Integer rowId = smUserRoleMapper.updateByPrimaryKey(record);
    	if(null != rowId && rowId > 0){
    		result = new ResultDO<>(BaseResultCode.COMMON_MESSAGE_CHENGGONG,Boolean.TRUE);
    		result.setTabid("smUserRoleList");
    	}else{
    		result = new ResultDO<>(BaseResultCode.COMMON_MESSAGE_LOSE,Boolean.FALSE);
    		result.setCloseCurrent(Boolean.FALSE);
    	}
    	return result;
    }
    
    @Override
    public ResultDO<?> deleteById(Long id){
    	ResultDO<?> result = null;
    	Integer rowId = smUserRoleMapper.deleteByPrimaryKey(id);
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
    	Integer rowId = smUserRoleMapper.deleteByAll(delids);
    	if(null != rowId && rowId > 0){
    		result = new ResultDO<>(BaseResultCode.COMMON_MESSAGE_CHENGGONG,Boolean.TRUE);
    	}else{
    		result = new ResultDO<>(BaseResultCode.COMMON_MESSAGE_LOSE,Boolean.FALSE);
    		result.setCloseCurrent(Boolean.FALSE);
    	}
    	return result;
    }
    
    @Override
    public PageDTO<SmUserRoleDTO> selectByInfo(SmUserRoleDTO dto){
    	PageDTO<SmUserRoleDTO> result = new PageDTO<SmUserRoleDTO>();
    	List<SmUserRoleDTO> list = smUserRoleMapper.selectByInfo(dto);
    	if(null != list && list.size()>0){
    		result.setList(list);
    	}
    	return result;
    }

	@Override
	public ResultDO<?> add(Long[] roleId, Long[] oddId, Long userId) {
		ResultDO<?> result = null;
		Integer rowId = null;
		List<SmUserRoleDTO> urList = new ArrayList<SmUserRoleDTO>();
		SmUserRoleDTO urDTO = null;
		if(null != roleId && roleId.length>0){
			for(Long id : roleId){
				urDTO = new SmUserRoleDTO();
				urDTO.setRoleId(id);
				urDTO.setUserId(userId);
				urList.add(urDTO); 
			}
		}
		
		if(null != oddId && oddId.length>0){
		 List<Long> oddList = new ArrayList<Long>();
		   for(Long id : oddId){
			   oddList.add(id);
		   }
		   for(int i = 0;i<oddList.size();i++){
			   Long oId = oddList.get(i);
			   for(int l = 0;l<urList.size();l++){
				   urDTO = urList.get(l);
				   if(oId.equals(urDTO.getRoleId())){
					   oddList.remove(oId);
					   urList.remove(urDTO);
				   }
			   }
		   }
		   if(oddList.size()>0){
			   rowId = smUserRoleMapper.deleteByRoleAll(oddList, userId);
		   }
		   if(urList.size()>0){
			   rowId = smUserRoleMapper.saveList(urList);
		   }
		}else{
			rowId = smUserRoleMapper.saveList(urList);
		}
		if(null != rowId && rowId > 0){
    		result = new ResultDO<>(BaseResultCode.COMMON_MESSAGE_CHENGGONG,Boolean.TRUE);
    		
    	}else{
    		result = new ResultDO<>(BaseResultCode.COMMON_MESSAGE_LOSE,Boolean.FALSE);
    		result.setCloseCurrent(Boolean.FALSE);
    	}
		return result;
	}
}
