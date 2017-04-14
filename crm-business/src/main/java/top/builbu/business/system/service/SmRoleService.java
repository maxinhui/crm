package top.builbu.business.system.service;

import java.util.Set;

import top.builbu.business.system.dto.SmRoleDTO;
import top.builbu.business.system.entity.SmRole;
import top.builbu.common.dto.PageDTO;
import top.builbu.common.dto.ResultDO;
import top.builbu.common.util.page.Pagination;

public interface SmRoleService{
     
     PageDTO<SmRoleDTO> selectByList(SmRoleDTO dto, Pagination page);
     
     ResultDO<SmRole> selectById(Long id);
     
     ResultDO<?> save(SmRoleDTO dto);

     ResultDO<?> update(SmRoleDTO dto);
     
     ResultDO<?> deleteById(Long id);
     
     ResultDO<?> deleteByCheck(Long[] delids);

     /**
      * 所有数据
      * @param dto
      * @return
      */
	 PageDTO<SmRoleDTO> selectByInfo(SmRoleDTO dto);

	 /**
	  * userId 查询所属角色
	  * @param userId
	  * @return
	  */
	ResultDO<Set<SmRoleDTO>> selectByUserId(Long userId);
}
