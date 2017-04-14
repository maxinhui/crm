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
import top.builbu.core.util.entity.UserType;
import top.builbu.business.channel.dto.CscStoreDTO;
import top.builbu.business.channel.entity.CscStore;
import top.builbu.business.channel.service.CscStoreService;
import top.builbu.business.channel.repository.CscStoreMapper;
import top.builbu.business.system.dto.SmUserStoreDTO;
import top.builbu.business.system.service.SmUserStoreService;
import top.builbu.business.user.dto.MemberDTO;
import top.builbu.business.user.dto.UscClerkDTO;
import top.builbu.business.user.dto.UscUserDTO;
import top.builbu.business.user.service.UscClerkService;
import top.builbu.business.user.service.UscUserService;
@Slf4j
@Service
public class CscStoreServiceImpl implements CscStoreService{
 
    @Autowired
	private CscStoreMapper cscStoreMapper;
	
    @Autowired
    private UscUserService uscUserService;
    
    @Autowired
    private SmUserStoreService smUserStoreService;
    
    @Autowired
    private UscClerkService uscClerkService;
    
	@Override
	public PageDTO<CscStoreDTO> selectByList(CscStoreDTO dto,Pagination page ){
	    PageDTO<CscStoreDTO> pageDo = new PageDTO<CscStoreDTO>();
	    List<CscStoreDTO> result = cscStoreMapper.selectByList(dto,page.getCurrentResult(),page.getPageSize());
		if(null!=result&&result.size()>0){
		    pageDo.setList(result);
		   
		}
		 pageDo.setPageCurrent(page.getPageCurrent());
		 pageDo.setPageSize(page.getPageSize());
		 pageDo.setTotal(cscStoreMapper.selectByCount(dto));
		return pageDo;
	}
	
	@Override
	public ResultDO<List<CscStoreDTO>> selectByInfo(CscStoreDTO dto ){
	    ResultDO<List<CscStoreDTO>> resultDo = null;
	    List<CscStoreDTO> result = cscStoreMapper.selectByInfo(dto);
		if(null!=result&&result.size()>0){
		    resultDo = new ResultDO<List<CscStoreDTO>>(result);
		}else{
			 resultDo = new ResultDO<>(BaseResultCode.COMMON_NO_DATA,Boolean.FALSE);
		}
		return resultDo;
	}
	
    @Override
	public ResultDO<CscStore> selectById(Long id){
	    ResultDO<CscStore> resultDo = null;
	    if(null!=id&&!"".equals(id)){
	        CscStore result = cscStoreMapper.selectByPrimaryKey(id);
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
	
    //*保存门店
    @Override
    public ResultDO<?> save(CscStoreDTO dto){
    	ResultDO<?> result = null;
    	MemberDTO me = new MemberDTO();
    	me.setMobileNo(dto.getStoreManagerTel());
    	me.setUserName(dto.getStoreManagerName());
    	me.setCreateStore(dto.getStoreNo());
    	me.setBelongStore(dto.getCustomerNo());
    	me.setUserType(UserType.clerkType);
    	me.setPassword(SHA1.Encrypt(dto.getStoreNo()+Password.psw, ""));
    	ResultDO<Long> usc = uscUserService.create(me);//创建门店店长
    	if(usc.isSuccess()){
    		CscStore record = new CscStore(); 
        	BeanUtils.copyProperties(dto, record);
        	record.setUserId(usc.getModule());
        	Integer rowId = cscStoreMapper.insert(record);//创建门店
        	if(null != rowId && rowId > 0){
        		SmUserStoreDTO usd = new SmUserStoreDTO();
        		usd.setUserId(usc.getModule());
        		usd.setStoreNo(dto.getStoreNo());
        		result = smUserStoreService.save(usd);//门店与店长关系
        		if(result.isSuccess()){
        			UscClerkDTO clerk = new UscClerkDTO();
        			clerk.setBelongStore(dto.getStoreNo());
        			clerk.setClerkId(usc.getModule());
        			result = uscClerkService.save(clerk);//店员关系表保存
        			if(result.isSuccess()){
        			   result = new ResultDO<>(BaseResultCode.COMMON_MESSAGE_CHENGGONG,Boolean.TRUE);
               		   result.setTabid("cscStoreList");
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
    public ResultDO<?> update(CscStoreDTO dto){
    	ResultDO<?> result = null;
    	UscUserDTO me = new UscUserDTO();
    	me.setMobileNo(dto.getStoreManagerTel());
    	me.setUserName(dto.getStoreManagerName());
    	me.setUserId(dto.getUserId());
    	result = uscUserService.update(me);
    	if(result.isSuccess()){
    		CscStore record = new CscStore();
        	BeanUtils.copyProperties(dto, record);
        	Integer rowId = cscStoreMapper.updateByPrimaryKey(record);
        	if(null != rowId && rowId > 0){
        		result = new ResultDO<>(BaseResultCode.COMMON_MESSAGE_CHENGGONG,Boolean.TRUE);
        		result.setTabid("cscStoreList");
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
    	CscStore store = cscStoreMapper.selectByPrimaryKey(id);
    	result = uscClerkService.updateByStore(store.getStoreNo());
    	if(result.isSuccess()){
    		Integer rowId = cscStoreMapper.deleteByPrimaryKey(id);
        	if(null != rowId && rowId > 0){
        		result = new ResultDO<>(BaseResultCode.COMMON_MESSAGE_CHENGGONG,Boolean.TRUE);
        	}else{
        		result = new ResultDO<>(BaseResultCode.COMMON_MESSAGE_LOSE,Boolean.FALSE);
        	}
    	}  	
    	return result;
    }
    
    @Override
    public ResultDO<?> deleteByCheck(Long[] delids){
    	ResultDO<?> result = null;
    	Integer rowId = cscStoreMapper.deleteByAll(delids);
    	if(null != rowId && rowId > 0){
    		result = new ResultDO<>(BaseResultCode.COMMON_MESSAGE_CHENGGONG,Boolean.TRUE);
    	}else{
    		result = new ResultDO<>(BaseResultCode.COMMON_MESSAGE_LOSE,Boolean.FALSE);
    		result.setCloseCurrent(Boolean.FALSE);
    	}
    	return result;
    }
}
