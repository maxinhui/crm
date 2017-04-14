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
import top.builbu.business.user.dto.UscMemberDTO;
import top.builbu.business.user.entity.UscMember;
import top.builbu.business.user.service.UscMemberService;
import top.builbu.business.user.repository.UscMemberMapper;
@Slf4j
@Service
public class UscMemberServiceImpl implements UscMemberService{
 
    @Autowired
	private UscMemberMapper uscMemberMapper;
	
	
	@Override
	public PageDTO<UscMemberDTO> selectByList(UscMemberDTO dto,Pagination page ){
	    PageDTO<UscMemberDTO> pageDo = new PageDTO<UscMemberDTO>();
	    List<UscMemberDTO> result = uscMemberMapper.selectByList(dto,page.getCurrentResult(),page.getPageSize());
		if(null!=result&&result.size()>0){
		    pageDo.setList(result);
		   
		}
		 pageDo.setPageCurrent(page.getPageCurrent());
		 pageDo.setPageSize(page.getPageSize());
		 pageDo.setTotal(uscMemberMapper.selectByCount(dto));
		return pageDo;
	}
	
    @Override
	public ResultDO<UscMember> selectById(Integer id){
	    ResultDO<UscMember> resultDo = null;
	    if(null!=id&&!"".equals(id)){
	        UscMember result = uscMemberMapper.selectByPrimaryKey(id);
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
    public ResultDO<?> save(UscMemberDTO dto){
    	ResultDO<?> result = null;
    	UscMember record = new UscMember(); 
    	BeanUtils.copyProperties(dto, record);
    	Integer rowId = uscMemberMapper.insert(record);
    	if(null != rowId && rowId > 0){
    		result = new ResultDO<>(BaseResultCode.COMMON_MESSAGE_CHENGGONG,Boolean.TRUE);
    		result.setTabid("uscMemberList");
    	}else{
    		result = new ResultDO<>(BaseResultCode.COMMON_MESSAGE_LOSE,Boolean.FALSE);
    		result.setCloseCurrent(Boolean.FALSE);
    	}
    	return result;
    }
    
    @Override
    public ResultDO<?> update(UscMemberDTO dto){
    	ResultDO<?> result = null;
    	UscMember record = new UscMember();
    	BeanUtils.copyProperties(dto, record);
    	Integer rowId = uscMemberMapper.updateByPrimaryKey(record);
    	if(null != rowId && rowId > 0){
    		result = new ResultDO<>(BaseResultCode.COMMON_MESSAGE_CHENGGONG,Boolean.TRUE);
    		result.setTabid("uscMemberList");
    	}else{
    		result = new ResultDO<>(BaseResultCode.COMMON_MESSAGE_LOSE,Boolean.FALSE);
    		result.setCloseCurrent(Boolean.FALSE);
    	}
    	return result;
    }
    
    @Override
    public ResultDO<?> deleteById(Integer id){
    	ResultDO<?> result = null;
    	Integer rowId = uscMemberMapper.deleteByPrimaryKey(id);
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
    	Integer rowId = uscMemberMapper.deleteByAll(delids);
    	if(null != rowId && rowId > 0){
    		result = new ResultDO<>(BaseResultCode.COMMON_MESSAGE_CHENGGONG,Boolean.TRUE);
    	}else{
    		result = new ResultDO<>(BaseResultCode.COMMON_MESSAGE_LOSE,Boolean.FALSE);
    		result.setCloseCurrent(Boolean.FALSE);
    	}
    	return result;
    }
}
