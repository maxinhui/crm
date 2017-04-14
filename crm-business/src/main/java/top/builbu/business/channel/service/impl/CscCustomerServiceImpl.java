package top.builbu.business.channel.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.beans.BeanUtils;

import com.alibaba.fastjson.JSONObject;

import lombok.extern.slf4j.Slf4j;
import top.builbu.common.util.SHA1;
import top.builbu.common.util.page.Pagination;
import top.builbu.common.dto.PageDTO;
import top.builbu.common.dto.BaseResultCode;
import top.builbu.common.dto.ResultDO;
import top.builbu.core.util.entity.Password;
import top.builbu.core.util.entity.StoreNo;
import top.builbu.core.util.entity.UserType;
import top.builbu.business.channel.dto.CscCustomerDTO;
import top.builbu.business.channel.dto.CscStoreDTO;
import top.builbu.business.channel.entity.CscCustomer;
import top.builbu.business.channel.service.CscCustomerService;
import top.builbu.business.channel.service.CscStoreService;
import top.builbu.business.channel.repository.CscCustomerMapper;
import top.builbu.business.system.dto.SmUserStoreDTO;
import top.builbu.business.system.service.SmUserStoreService;
import top.builbu.business.user.dto.MemberDTO;
import top.builbu.business.user.dto.UscUserDTO;
import top.builbu.business.user.service.UscClerkService;
import top.builbu.business.user.service.UscUserService;
@Slf4j
@Service
public class CscCustomerServiceImpl implements CscCustomerService{
 
    @Autowired
	private CscCustomerMapper cscCustomerMapper;
	
    @Autowired
    private UscUserService uscUserService;
    
    @Autowired
    private SmUserStoreService smUserStoreService;
    
    @Autowired
    private UscClerkService uscClerkService; 
    
    @Autowired
    private CscStoreService cscStoreService;
	
	@Override
	public PageDTO<CscCustomerDTO> selectByList(CscCustomerDTO dto,Pagination page ){
	    PageDTO<CscCustomerDTO> pageDo = new PageDTO<CscCustomerDTO>();
	    List<CscCustomerDTO> result = cscCustomerMapper.selectByList(dto,page.getCurrentResult(),page.getPageSize());
		if(null!=result&&result.size()>0){
		    pageDo.setList(result);
		   
		}
		 pageDo.setPageCurrent(page.getPageCurrent());
		 pageDo.setPageSize(page.getPageSize());
		 pageDo.setTotal(cscCustomerMapper.selectByCount(dto));
		return pageDo;
	}
	
    @Override
	public ResultDO<CscCustomer> selectById(Long id){
	    ResultDO<CscCustomer> resultDo = null;
	    if(null!=id&&!"".equals(id)){
	        CscCustomer result = cscCustomerMapper.selectByPrimaryKey(id);
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
    public ResultDO<?> save(CscCustomerDTO dto){
    	ResultDO<?> result = null;
    	MemberDTO me = new MemberDTO();
    	me.setMobileNo(dto.getContactNumber());
    	me.setUserName(dto.getContacts());  	
    	me.setCreateStore(dto.getCustomerNo());
    	me.setBelongStore(dto.getCustomerNo());
    	me.setUserType(UserType.customerType);
    	me.setPassword(SHA1.Encrypt(dto.getCustomerNo()+Password.psw, ""));
    	ResultDO<Long> usc = uscUserService.create(me);
    	if(usc.isSuccess()){
    		CscCustomer record = new CscCustomer(); 
        	BeanUtils.copyProperties(dto, record);
        	record.setUserId(usc.getModule());
        	Integer rowId = cscCustomerMapper.insert(record);
        	if(null != rowId && rowId > 0){
        		SmUserStoreDTO usd = new SmUserStoreDTO();
        		usd.setUserId(usc.getModule());
        		usd.setStoreNo(dto.getCustomerNo());
        		result = smUserStoreService.save(usd);
        		if(result.isSuccess()){
        		  result = new ResultDO<>(BaseResultCode.COMMON_MESSAGE_CHENGGONG,Boolean.TRUE);
        		  result.setTabid("cscCustomerList");
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
    public ResultDO<?> update(CscCustomerDTO dto){
    	ResultDO<?> result = null;
    	UscUserDTO me = new UscUserDTO();
    	me.setMobileNo(dto.getContactNumber());
    	me.setUserName(dto.getContacts());
    	me.setUserId(dto.getUserId());
    	result = uscUserService.update(me);
    	if(result.isSuccess()){
    		CscCustomer record = new CscCustomer();
        	BeanUtils.copyProperties(dto, record);
        	Integer rowId = cscCustomerMapper.updateByPrimaryKey(record);
        	if(null != rowId && rowId > 0){
        		result = new ResultDO<>(BaseResultCode.COMMON_MESSAGE_CHENGGONG,Boolean.TRUE);
        		result.setTabid("cscCustomerList");
        	}else{
        		result = new ResultDO<>(BaseResultCode.COMMON_MESSAGE_LOSE,Boolean.FALSE);
        		result.setCloseCurrent(Boolean.FALSE);
        	}
    	}else{
    		result = new ResultDO<>(BaseResultCode.COMMON_MESSAGE_LOSE,Boolean.FALSE);
    		result.setCloseCurrent(Boolean.FALSE);
    	}
    	
    	return result;
    }
    
    @Override
    public ResultDO<?> deleteById(Long id){
    	ResultDO<?> result = null;
    	CscCustomer customer = cscCustomerMapper.selectByPrimaryKey(id);
    	UscUserDTO userDTO = new UscUserDTO();
    	userDTO.setUserId(customer.getUserId());
    	userDTO.setUserType(UserType.memberType);
    	result = uscUserService.update(userDTO);//修改
    	if(result.isSuccess()){
    		CscStoreDTO storeDTO = new CscStoreDTO();
    		storeDTO.setCustomerNo(customer.getCustomerNo());
    		ResultDO<List<CscStoreDTO>> storeList = cscStoreService.selectByInfo(storeDTO);
    		if(storeList.isSuccess()){
    			for(CscStoreDTO dto : storeList.getModule()){
    				result = uscClerkService.updateByStore(dto.getStoreNo());
    				if(!result.isSuccess()){
    					break;
    				}
    			}
    		}
    		if(result.isSuccess()){
    			Integer rowId = cscCustomerMapper.deleteByPrimaryKey(id);
            	if(null != rowId && rowId > 0){
            		result = new ResultDO<>(BaseResultCode.COMMON_MESSAGE_CHENGGONG,Boolean.TRUE);
            	}else{
            		result = new ResultDO<>(BaseResultCode.COMMON_MESSAGE_LOSE,Boolean.FALSE);
            	}
    		}
    		
    	}
    	
    	return result;
    }
    
    @Override
    public ResultDO<?> deleteByCheck(Long[] delids){
    	ResultDO<?> result = null;
    	Integer rowId = cscCustomerMapper.deleteByAll(delids);
    	if(null != rowId && rowId > 0){
    		result = new ResultDO<>(BaseResultCode.COMMON_MESSAGE_CHENGGONG,Boolean.TRUE);
    	}else{
    		result = new ResultDO<>(BaseResultCode.COMMON_MESSAGE_LOSE,Boolean.FALSE);
    		result.setCloseCurrent(Boolean.FALSE);
    	}
    	return result;
    }
}
