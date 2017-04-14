package top.builbu.business.system.service.impl;

import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
import top.builbu.business.shiro.service.impl.listTemp;
import top.builbu.business.system.dto.SmButtonDTO;
import top.builbu.business.system.dto.SmMenuDTO;
import top.builbu.business.system.entity.SmMenu;
import top.builbu.business.system.service.SmButtonService;
import top.builbu.business.system.service.SmMenuService;
import top.builbu.business.system.repository.SmButtonMapper;
import top.builbu.business.system.repository.SmMenuMapper;
@Slf4j
@Service
public class SmMenuServiceImpl implements SmMenuService{
 
    @Autowired
	private SmMenuMapper smMenuMapper;
	
    @Autowired
  	private SmButtonMapper smButtonMapper;
    
    @Autowired
  	private SmButtonService smButtonService;
    
    @Autowired  
    private  HttpServletRequest request; 
    
	@Override
	public PageDTO<SmMenuDTO> selectByList(SmMenuDTO dto,Pagination page ){
	    PageDTO<SmMenuDTO> pageDo = new PageDTO<SmMenuDTO>();
	    List<SmMenuDTO> result = smMenuMapper.selectByList(dto,page.getCurrentResult(),page.getPageSize());
		if(null!=result&&result.size()>0){
		    pageDo.setList(result);
		   
		}
		 pageDo.setPageCurrent(page.getPageCurrent());
		 pageDo.setPageSize(page.getPageSize());
		 pageDo.setTotal(smMenuMapper.selectByCount(dto));
		return pageDo;
	}
	
    @Override
	public ResultDO<SmMenu> selectById(Long id){
	    ResultDO<SmMenu> resultDo = null;
	    if(null!=id&&!"".equals(id)){
	        SmMenu result = smMenuMapper.selectByPrimaryKey(id);
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
    public ResultDO<?> save(SmMenuDTO dto){
    	ResultDO<?> result = null;
    	SmMenu record = new SmMenu(); 
    	BeanUtils.copyProperties(dto, record);
    	record.setMenuNo(RandomUtil.randomNo("Me"));
    	record.setDisplayOrder(record.getPageUrl().split("\\/")[1]);
    	Integer rowId = smMenuMapper.insert(record);
    	if(null != rowId && rowId > 0){
    		result = new ResultDO<>(BaseResultCode.COMMON_MESSAGE_CHENGGONG,Boolean.TRUE);
    		result.setTabid("smMenuList");
    	}else{
    		result = new ResultDO<>(BaseResultCode.COMMON_MESSAGE_LOSE,Boolean.FALSE);
    		result.setCloseCurrent(Boolean.FALSE);
    	}
    	return result;
    }
    
    @Override
    public ResultDO<?> update(SmMenuDTO dto){
    	ResultDO<?> result = null;
    	SmMenu record = new SmMenu();
    	BeanUtils.copyProperties(dto, record);
    	record.setDisplayOrder(record.getPageUrl().split("\\/")[1]);
    	Integer rowId = smMenuMapper.updateByPrimaryKey(record);
    	if(null != rowId && rowId > 0){
    		result = new ResultDO<>(BaseResultCode.COMMON_MESSAGE_CHENGGONG,Boolean.TRUE);
    		result.setTabid("smMenuList");
    	}else{
    		result = new ResultDO<>(BaseResultCode.COMMON_MESSAGE_LOSE,Boolean.FALSE);
    		result.setCloseCurrent(Boolean.FALSE);
    	}
    	return result;
    }
    
    @Override
    public ResultDO<?> deleteById(Long id){
    	ResultDO<?> result = null;
    	Integer rowId = smMenuMapper.deleteByPrimaryKey(id);
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
    	Integer rowId = smMenuMapper.deleteByAll(delids);
    	if(null != rowId && rowId > 0){
    		result = new ResultDO<>(BaseResultCode.COMMON_MESSAGE_CHENGGONG,Boolean.TRUE);
    	}else{
    		result = new ResultDO<>(BaseResultCode.COMMON_MESSAGE_LOSE,Boolean.FALSE);
    		result.setCloseCurrent(Boolean.FALSE);
    	}
    	return result;
    }
    
    
    @Override
    public PageDTO<SmMenuDTO> selectByInfo(SmMenuDTO dto){
    	PageDTO<SmMenuDTO> result = new PageDTO<SmMenuDTO>();
    	SmButtonDTO buttonDTO = null;
    	List<SmMenuDTO> list = smMenuMapper.selectByInfo(dto);
    	if(null != list && list.size()>0){
    		for(SmMenuDTO menuDTO : list){
    			dto.setParentMenuId(menuDTO.getMenuId());
    			dto.setValidFlag("Y");
    			List<SmMenuDTO> menuList = smMenuMapper.selectByInfo(dto);
    			if(null != menuList && menuList.size()>0){
    				for(SmMenuDTO menu : menuList){
    					buttonDTO = new SmButtonDTO();
        				buttonDTO.setMenuId(menu.getMenuId());
        				buttonDTO.setValidFlag("Y");
        				List<SmButtonDTO> buttonList = smButtonMapper.selectByInfo(buttonDTO);
        				menu.setButtonList(buttonList);
    				}  				
    			}
    			menuDTO.setMenuList(menuList);
    		}
    		result.setList(list);
    	}
    	return result;
    }
  
  
    @Override
    public ResultDO<Set<SmMenuDTO>> selectByRoleId(Long roleId){
    	ResultDO<Set<SmMenuDTO>> resultDo = null;
    	if(null != roleId && !"".equals(roleId)){
    		Set<SmMenuDTO> result = smMenuMapper.selectByRoleId(roleId);
    		if(null != result){
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
