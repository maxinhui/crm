package top.builbu.business.system.service;

import java.util.Set;

import top.builbu.business.system.dto.SmMenuDTO;
import top.builbu.business.system.entity.SmMenu;
import top.builbu.common.dto.PageDTO;
import top.builbu.common.dto.ResultDO;
import top.builbu.common.util.page.Pagination;

public interface SmMenuService{
     
     PageDTO<SmMenuDTO> selectByList(SmMenuDTO dto, Pagination page);
     
     ResultDO<SmMenu> selectById(Long id);
     
     ResultDO<?> save(SmMenuDTO dto);

     ResultDO<?> update(SmMenuDTO dto);
     
     ResultDO<?> deleteById(Long id);
     
     ResultDO<?> deleteByCheck(Long[] delids);

     /**
      * 所有数据
      * @param dto
      * @return
      */
	 PageDTO<SmMenuDTO> selectByInfo(SmMenuDTO dto);

	 /**
	  * roleId 查询角色所属列表
	  * @param roleId
	  * @return
	  */
	ResultDO<Set<SmMenuDTO>> selectByRoleId(Long roleId);
}
