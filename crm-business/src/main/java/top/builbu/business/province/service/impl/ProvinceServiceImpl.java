package top.builbu.business.province.service.impl;

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
import top.builbu.business.province.dto.ProvinceDTO;
import top.builbu.business.province.entity.Province;
import top.builbu.business.province.service.ProvinceService;
import top.builbu.business.province.repository.ProvinceMapper;
@Slf4j
@Service
public class ProvinceServiceImpl implements ProvinceService{
 
    @Autowired
	private ProvinceMapper provinceMapper;
	
	
	@Override
	public PageDTO<ProvinceDTO> selectByList(ProvinceDTO dto,Pagination page ){
	    PageDTO<ProvinceDTO> pageDo = new PageDTO<ProvinceDTO>();
	    List<ProvinceDTO> result = provinceMapper.selectByList(dto,page.getCurrentResult(),page.getPageSize());
		if(null!=result&&result.size()>0){
		    pageDo.setList(result);
		   
		}
		 pageDo.setPageCurrent(page.getPageCurrent());
		 pageDo.setPageSize(page.getPageSize());
		 pageDo.setTotal(provinceMapper.selectByCount(dto));
		return pageDo;
	}
	
    @Override
	public ResultDO<Province> selectById(Integer id){
	    ResultDO<Province> resultDo = null;
	    if(null!=id&&!"".equals(id)){
	        Province result = provinceMapper.selectByPrimaryKey(id);
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
    public ResultDO<?> save(ProvinceDTO dto){
    	ResultDO<?> result = null;
    	Province record = new Province(); 
    	BeanUtils.copyProperties(dto, record);
    	Integer rowId = provinceMapper.insert(record);
    	if(null != rowId && rowId > 0){
    		result = new ResultDO<>(BaseResultCode.COMMON_MESSAGE_CHENGGONG,Boolean.TRUE);
    		result.setTabid("provinceList");
    	}else{
    		result = new ResultDO<>(BaseResultCode.COMMON_MESSAGE_LOSE,Boolean.FALSE);
    		result.setCloseCurrent(Boolean.FALSE);
    	}
    	return result;
    }
    
    @Override
    public ResultDO<?> update(ProvinceDTO dto){
    	ResultDO<?> result = null;
    	Province record = new Province();
    	BeanUtils.copyProperties(dto, record);
    	Integer rowId = provinceMapper.updateByPrimaryKey(record);
    	if(null != rowId && rowId > 0){
    		result = new ResultDO<>(BaseResultCode.COMMON_MESSAGE_CHENGGONG,Boolean.TRUE);
    		result.setTabid("provinceList");
    	}else{
    		result = new ResultDO<>(BaseResultCode.COMMON_MESSAGE_LOSE,Boolean.FALSE);
    		result.setCloseCurrent(Boolean.FALSE);
    	}
    	return result;
    }
    
    @Override
    public ResultDO<?> deleteById(Integer id){
    	ResultDO<?> result = null;
    	Integer rowId = provinceMapper.deleteByPrimaryKey(id);
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
    	Integer rowId = provinceMapper.deleteByAll(delids);
    	if(null != rowId && rowId > 0){
    		result = new ResultDO<>(BaseResultCode.COMMON_MESSAGE_CHENGGONG,Boolean.TRUE);
    	}else{
    		result = new ResultDO<>(BaseResultCode.COMMON_MESSAGE_LOSE,Boolean.FALSE);
    		result.setCloseCurrent(Boolean.FALSE);
    	}
    	return result;
    }
}
