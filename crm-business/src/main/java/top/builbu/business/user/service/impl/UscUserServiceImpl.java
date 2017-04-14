package top.builbu.business.user.service.impl;


import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.beans.BeanUtils;

import com.alibaba.fastjson.JSONObject;

import lombok.extern.slf4j.Slf4j;
import top.builbu.common.util.DateUtil;
import top.builbu.common.util.RandomUtil;
import top.builbu.common.util.SHA1;
import top.builbu.common.util.page.Pagination;
import top.builbu.common.dto.PageDTO;
import top.builbu.common.dto.BaseResultCode;
import top.builbu.common.dto.ResultDO;
import top.builbu.core.util.entity.StoreNo;
import top.builbu.core.util.entity.UserType;
import top.builbu.business.user.dto.MemberDTO;
import top.builbu.business.user.dto.UscMemberDTO;
import top.builbu.business.user.dto.UscMemberWcpnDTO;
import top.builbu.business.user.dto.UscUserDTO;
import top.builbu.business.user.entity.UscMember;
import top.builbu.business.user.entity.UscMemberWcpn;
import top.builbu.business.user.entity.UscUser;
import top.builbu.business.user.service.UscMemberService;
import top.builbu.business.user.service.UscMemberWcpnService;
import top.builbu.business.user.service.UscUserService;
import top.builbu.business.user.repository.MemberMapper;
import top.builbu.business.user.repository.UscMemberMapper;
import top.builbu.business.user.repository.UscMemberWcpnMapper;
import top.builbu.business.user.repository.UscUserMapper;
@Slf4j
@Service
public class UscUserServiceImpl implements UscUserService{
 
    @Autowired
	private UscUserMapper uscUserMapper;
	
    @Autowired
    private MemberMapper memberMapper;
    @Autowired
    private UscMemberMapper uscMemberMapper;
    @Autowired
    private UscMemberWcpnMapper uscMemberWcpnMapper;
	@Override
	public PageDTO<MemberDTO> selectByList(MemberDTO dto,Pagination page ){
	    PageDTO<MemberDTO> pageDo = new PageDTO<MemberDTO>();
	    List<MemberDTO> result = memberMapper.selectByList(dto,page.getCurrentResult(),page.getPageSize());
		if(null!=result&&result.size()>0){
		    pageDo.setList(result);		   
		}
		 pageDo.setPageCurrent(page.getPageCurrent());
		 pageDo.setPageSize(page.getPageSize());
		 pageDo.setTotal(memberMapper.selectByCount(dto));
		return pageDo;
	}
	
    @Override
	public ResultDO<MemberDTO> selectById(Long id){
	    ResultDO<MemberDTO> resultDo = null;
	    if(null!=id&&!"".equals(id)){
	    	MemberDTO result = memberMapper.selectByPrimaryKey(id);
	        if(null!=result){
	        	log.info(JSONObject.toJSONString(result));
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
    public ResultDO<?> save(MemberDTO dto){
    	ResultDO<?> result = null;
    	MemberDTO d = new MemberDTO();
    	d.setMobileNo(dto.getMobileNo());
    	Integer count = memberMapper.selectByCount(d);
 		if(null!=count&&count == 0){//
 			UscUser record = new UscUser(); 
 	    	BeanUtils.copyProperties(dto, record);
 	    	record.setUserNo(RandomUtil.randomNo("Us"));
 	    	record.setCreateDate(new Date());
 	    	record.setPassword(SHA1.Encrypt(record.getMobileNo()+record.getPassword(), ""));
 	    	Integer rowId = uscUserMapper.insert(record);
 	    	if(null != rowId && rowId > 0){
 	    		UscMember member = new UscMember(); 
 	    		BeanUtils.copyProperties(dto, member);
 	    		member.setMemberId(record.getUserId());
 	    		member.setCreateDate(record.getCreateDate());
 	    		member.setCardNo(record.getUserNo());
 	    		member.setBelongStore(member.getCreateStore());
 	    		rowId = uscMemberMapper.insert(member);
 	    		if(null != rowId && rowId > 0){
 	    			UscMemberWcpn wcpn = new UscMemberWcpn();
 	    			BeanUtils.copyProperties(dto, wcpn);
 	    			wcpn.setMemberId(member.getMemberId());
 	    			rowId = uscMemberWcpnMapper.insert(wcpn);
 	    			if(null != rowId && rowId > 0){
 	    				result = new ResultDO<>(BaseResultCode.COMMON_MESSAGE_CHENGGONG,Boolean.TRUE);
 	    				result.setTabid("uscUserList");
 	    			}
 	    			
 	    		}   		
 	    	}else{
 	    		result = new ResultDO<>(BaseResultCode.COMMON_MESSAGE_LOSE,Boolean.FALSE);
 	    		result.setCloseCurrent(Boolean.FALSE);
 	    	}		   
 		}else{
 			result = new ResultDO<>(BaseResultCode.COMMON_NO,Boolean.FALSE);
	        result.setCloseCurrent(Boolean.FALSE);
 		}
    	
    	return result;
    }
    
    @Override
    public ResultDO<Long> create(MemberDTO dto){
    	ResultDO<Long> result = null;
    	MemberDTO d = new MemberDTO();
    	d.setMobileNo(dto.getMobileNo());
    	Integer count = memberMapper.selectByCount(d);
 		if(null!=count&&count == 0){//
 			UscUser record = new UscUser(); 
 	    	BeanUtils.copyProperties(dto, record);
 	    	record.setUserNo(RandomUtil.randomNo("Us"));
 	    	record.setCreateDate(new Date());
 	    	Integer rowId = uscUserMapper.insert(record);
 	    	if(null != rowId && rowId > 0){
 	    		UscMember member = new UscMember(); 
 	    		BeanUtils.copyProperties(dto, member);
 	    		member.setMemberId(record.getUserId());
 	    		member.setCardNo(record.getUserNo());
 	    		member.setCreateDate(record.getCreateDate());
 	    		rowId = uscMemberMapper.insert(member);
 	    		if(null != rowId && rowId > 0){
 	    			UscMemberWcpn wcpn = new UscMemberWcpn();
 	    			BeanUtils.copyProperties(dto, wcpn);
 	    			wcpn.setMemberId(member.getMemberId());
 	    			rowId = uscMemberWcpnMapper.insert(wcpn);
 	    			if(null != rowId && rowId > 0){
 	    				result = new ResultDO<Long>(record.getUserId());
 	    			}
 	    			
 	    		}   		
 	    	}else{
 	    		result = new ResultDO<>(BaseResultCode.COMMON_MESSAGE_LOSE,Boolean.FALSE);
 	    		result.setCloseCurrent(Boolean.FALSE);
 	    	}		   
 		}else{
 			result = new ResultDO<>(BaseResultCode.COMMON_NO,Boolean.FALSE);
	        result.setCloseCurrent(Boolean.FALSE);
 		}
    	
    	return result;
    }
    
    @Override
    public ResultDO<?> update(UscUserDTO dto){
    	ResultDO<?> result = null;
    	UscUser record = new UscUser();
    	BeanUtils.copyProperties(dto, record);
    	Integer rowId = uscUserMapper.updateByPrimaryKey(record);
    	if(null != rowId && rowId > 0){
    		result = new ResultDO<>(BaseResultCode.COMMON_MESSAGE_CHENGGONG,Boolean.TRUE);
    		result.setTabid("uscUserList");
    	}else{
    		result = new ResultDO<>(BaseResultCode.COMMON_MESSAGE_LOSE,Boolean.FALSE);
    		result.setCloseCurrent(Boolean.FALSE);
    	}
    	return result;
    }
    
    @Override
    public ResultDO<?> deleteById(Long id){
    	ResultDO<?> result = null;
    	Integer rowId = uscUserMapper.deleteByPrimaryKey(id);
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
    	Integer rowId = uscUserMapper.deleteByAll(delids);
    	if(null != rowId && rowId > 0){
    		result = new ResultDO<>(BaseResultCode.COMMON_MESSAGE_CHENGGONG,Boolean.TRUE);
    	}else{
    		result = new ResultDO<>(BaseResultCode.COMMON_MESSAGE_LOSE,Boolean.FALSE);
    		result.setCloseCurrent(Boolean.FALSE);
    	}
    	return result;
    }
    
    @Override
    public ResultDO<MemberDTO> login(String loginName,String passWord){
    	ResultDO<MemberDTO> result = null;
    	MemberDTO dto= memberMapper.login(loginName, passWord);
    	if(null != dto){
    		result = new ResultDO<>(dto);
    	}else{
    		result = new ResultDO<>(BaseResultCode.COMMON_MESSAGE_LOSE,Boolean.FALSE);
    	}
    	return result;
    }
    
}
