package top.builbu.business.system.service;

import java.util.Set;

import top.builbu.business.system.dto.SmButtonDTO;
import top.builbu.business.system.entity.SmButton;
import top.builbu.common.dto.PageDTO;
import top.builbu.common.dto.ResultDO;
import top.builbu.common.util.page.Pagination;

public interface SmButtonService{
     
     PageDTO<SmButtonDTO> selectByList(SmButtonDTO dto, Pagination page);
     
     ResultDO<SmButton> selectById(Long id);
     
     ResultDO<?> save(SmButtonDTO dto);

     ResultDO<?> update(SmButtonDTO dto);
     
     ResultDO<?> deleteById(Long id);
     
     ResultDO<?> deleteByCheck(Long[] delids);

     /**
      * 所有数据
      * @param dto
      * @return
      */
	 PageDTO<SmButtonDTO> selectByInfo(SmButtonDTO dto);

	 /**
	  * 角色所属按钮
	  * @param roleId
	  * @return
	  */
	ResultDO<Set<SmButtonDTO>> selectyByRoleId(Long roleId);
}
