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
import top.builbu.business.user.dto.UscMemberWcpnDTO;
import top.builbu.business.user.entity.UscMemberWcpn;
import top.builbu.business.user.service.UscMemberWcpnService;
import top.builbu.business.user.repository.UscMemberWcpnMapper;
@Slf4j
@Service
public class UscMemberWcpnServiceImpl implements UscMemberWcpnService{
 
    @Autowired
	private UscMemberWcpnMapper uscMemberWcpnMapper;
	
	
	@Override
	public PageDTO<UscMemberWcpnDTO> selectByList(UscMemberWcpnDTO dto,Pagination page ){
	    PageDTO<UscMemberWcpnDTO> pageDo = new PageDTO<UscMemberWcpnDTO>();
	    List<UscMemberWcpnDTO> result = uscMemberWcpnMapper.selectByList(dto,page.getCurrentResult(),page.getPageSize());
		if(null!=result&&result.size()>0){
		    pageDo.setList(result);
		   
		}
		 pageDo.setPageCurrent(page.getPageCurrent());
		 pageDo.setPageSize(page.getPageSize());
		 pageDo.setTotal(uscMemberWcpnMapper.selectByCount(dto));
		return pageDo;
	}
	
    @Override
	public ResultDO<UscMemberWcpn> selectById(Long id){
	    ResultDO<UscMemberWcpn> resultDo = null;
	    if(null!=id&&!"".equals(id)){
	        UscMemberWcpn result = uscMemberWcpnMapper.selectByPrimaryKey(id);
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
    public ResultDO<?> save(UscMemberWcpnDTO dto){
    	ResultDO<?> result = null;
    	UscMemberWcpn record = new UscMemberWcpn(); 
    	BeanUtils.copyProperties(dto, record);
    	Integer rowId = uscMemberWcpnMapper.insert(record);
    	if(null != rowId && rowId > 0){
    		result = new ResultDO<>(BaseResultCode.COMMON_MESSAGE_CHENGGONG,Boolean.TRUE);
    		result.setTabid("uscMemberWcpnList");
    	}else{
    		result = new ResultDO<>(BaseResultCode.COMMON_MESSAGE_LOSE,Boolean.FALSE);
    		result.setCloseCurrent(Boolean.FALSE);
    	}
    	return result;
    }
    
    @Override
    public ResultDO<?> update(UscMemberWcpnDTO dto){
    	ResultDO<?> result = null;
    	UscMemberWcpn record = new UscMemberWcpn();
    	BeanUtils.copyProperties(dto, record);
    	Integer rowId = uscMemberWcpnMapper.updateByPrimaryKey(record);
    	if(null != rowId && rowId > 0){
    		result = new ResultDO<>(BaseResultCode.COMMON_MESSAGE_CHENGGONG,Boolean.TRUE);
    		result.setTabid("uscMemberWcpnList");
    	}else{
    		result = new ResultDO<>(BaseResultCode.COMMON_MESSAGE_LOSE,Boolean.FALSE);
    		result.setCloseCurrent(Boolean.FALSE);
    	}
    	return result;
    }
    
    @Override
    public ResultDO<?> deleteById(Long id){
    	ResultDO<?> result = null;
    	Integer rowId = uscMemberWcpnMapper.deleteByPrimaryKey(id);
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
    	Integer rowId = uscMemberWcpnMapper.deleteByAll(delids);
    	if(null != rowId && rowId > 0){
    		result = new ResultDO<>(BaseResultCode.COMMON_MESSAGE_CHENGGONG,Boolean.TRUE);
    	}else{
    		result = new ResultDO<>(BaseResultCode.COMMON_MESSAGE_LOSE,Boolean.FALSE);
    		result.setCloseCurrent(Boolean.FALSE);
    	}
    	return result;
    }
}
