package top.builbu.business.system.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.beans.BeanUtils;

import com.alibaba.fastjson.JSONObject;
import com.mysql.fabric.xmlrpc.base.Array;

import lombok.extern.slf4j.Slf4j;
import top.builbu.common.util.page.Pagination;
import top.builbu.common.dto.PageDTO;
import top.builbu.common.dto.BaseResultCode;
import top.builbu.common.dto.ResultDO;
import top.builbu.business.system.dto.SmRoleFuncDTO;
import top.builbu.business.system.entity.SmRoleFunc;
import top.builbu.business.system.service.SmRoleFuncService;
import top.builbu.business.system.repository.SmButtonMapper;
import top.builbu.business.system.repository.SmMenuMapper;
import top.builbu.business.system.repository.SmRoleFuncMapper;
@Slf4j
@Service
public class SmRoleFuncServiceImpl implements SmRoleFuncService{
 
    @Autowired
	private SmRoleFuncMapper smRoleFuncMapper;
	
    @Autowired
  	private SmButtonMapper smButtonMapper;
    
    @Autowired
	private SmMenuMapper smMenuMapper;
    
	@Override
	public PageDTO<SmRoleFuncDTO> selectByList(SmRoleFuncDTO dto,Pagination page ){
	    PageDTO<SmRoleFuncDTO> pageDo = new PageDTO<SmRoleFuncDTO>();
	    List<SmRoleFuncDTO> result = smRoleFuncMapper.selectByList(dto,page.getCurrentResult(),page.getPageSize());
		if(null!=result&&result.size()>0){
		    pageDo.setList(result);
		   
		}
		 pageDo.setPageCurrent(page.getPageCurrent());
		 pageDo.setPageSize(page.getPageSize());
		 pageDo.setTotal(smRoleFuncMapper.selectByCount(dto));
		return pageDo;
	}
	
    @Override
	public ResultDO<SmRoleFunc> selectById(Long id){
	    ResultDO<SmRoleFunc> resultDo = null;
	    if(null!=id&&!"".equals(id)){
	        SmRoleFunc result = smRoleFuncMapper.selectByPrimaryKey(id);
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
    public ResultDO<?> save(SmRoleFuncDTO dto){
    	ResultDO<?> result = null;
    	SmRoleFunc record = new SmRoleFunc(); 
    	BeanUtils.copyProperties(dto, record);
    	Integer rowId = smRoleFuncMapper.insert(record);
    	if(null != rowId && rowId > 0){
    		result = new ResultDO<>(BaseResultCode.COMMON_MESSAGE_CHENGGONG,Boolean.TRUE);
    		result.setTabid("smRoleFuncList");
    	}else{
    		result = new ResultDO<>(BaseResultCode.COMMON_MESSAGE_LOSE,Boolean.FALSE);
    		result.setCloseCurrent(Boolean.FALSE);
    	}
    	return result;
    }
    
    @Override
    public ResultDO<?> update(SmRoleFuncDTO dto){
    	ResultDO<?> result = null;
    	SmRoleFunc record = new SmRoleFunc();
    	BeanUtils.copyProperties(dto, record);
    	Integer rowId = smRoleFuncMapper.updateByPrimaryKey(record);
    	if(null != rowId && rowId > 0){
    		result = new ResultDO<>(BaseResultCode.COMMON_MESSAGE_CHENGGONG,Boolean.TRUE);
    		result.setTabid("smRoleFuncList");
    	}else{
    		result = new ResultDO<>(BaseResultCode.COMMON_MESSAGE_LOSE,Boolean.FALSE);
    		result.setCloseCurrent(Boolean.FALSE);
    	}
    	return result;
    }
    
    @Override
    public ResultDO<?> deleteById(Long id){
    	ResultDO<?> result = null;
    	Integer rowId = smRoleFuncMapper.deleteByPrimaryKey(id);
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
    	Integer rowId = smRoleFuncMapper.deleteByAll(delids);
    	if(null != rowId && rowId > 0){
    		result = new ResultDO<>(BaseResultCode.COMMON_MESSAGE_CHENGGONG,Boolean.TRUE);
    	}else{
    		result = new ResultDO<>(BaseResultCode.COMMON_MESSAGE_LOSE,Boolean.FALSE);
    		result.setCloseCurrent(Boolean.FALSE);
    	}
    	return result;
    }
    
    
    @Override
    public PageDTO<SmRoleFuncDTO> selectByInfo(SmRoleFuncDTO dto){
    	PageDTO<SmRoleFuncDTO> result = new PageDTO<SmRoleFuncDTO>();;
    	
    		List<SmRoleFuncDTO> list = smRoleFuncMapper.selectByInfo(dto);
    		if(null != list && list.size()>0){
    			result.setList(list);
    		}
    
    	return result;
    }

	@Override
	public ResultDO<?> add(Long[] menuId, Long[] buttonId,Long[] oddId, Long roleId) {
		ResultDO<?> result = null;
		Integer rowId = null;
		List<SmRoleFunc> funcList = new ArrayList<SmRoleFunc>();
		SmRoleFunc func =null;
		if(null != menuId && menuId.length>0){
			for(Long id : menuId){
				func = new SmRoleFunc();
				func.setFuncType(1);
				func.setFuncId(id);
				func.setRoleId(roleId);
				funcList.add(func);
			}
		}
		if(null != buttonId && buttonId.length>0){
			for(Long id : buttonId){
				func = new SmRoleFunc();
				func.setFuncType(2);
				func.setFuncId(id);
				func.setRoleId(roleId);
				funcList.add(func);
			}
		}
		
		if(null != oddId && oddId.length > 0){
		   List<Long> oddList = new ArrayList<Long>();
		   for(Long id : oddId){
			   oddList.add(id);
		   }

		

		   if(oddList.size()>0){//删除多余权限
			   rowId = smRoleFuncMapper.deleteByRoleAll(oddList, roleId);
		   }
		   if(funcList.size()>0){//添加权限
			   rowId = smRoleFuncMapper.saveList(funcList);
		   }
		}else{//添加权限			
			 rowId = smRoleFuncMapper.saveList(funcList);
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
