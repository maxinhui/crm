package top.builbu.business.system.service;

import top.builbu.business.system.dto.SmUserRoleDTO;
import top.builbu.business.system.entity.SmUserRole;
import top.builbu.common.dto.PageDTO;
import top.builbu.common.dto.ResultDO;
import top.builbu.common.util.page.Pagination;

public interface SmUserRoleService{
     
     PageDTO<SmUserRoleDTO> selectByList(SmUserRoleDTO dto, Pagination page);
     
     ResultDO<SmUserRole> selectById(Long id);
     
     ResultDO<?> save(SmUserRoleDTO dto);

     ResultDO<?> update(SmUserRoleDTO dto);
     
     ResultDO<?> deleteById(Long id);
     
     ResultDO<?> deleteByCheck(Long[] delids);

     /**
      * 所有数据
      * @param dto
      * @return
      */
	PageDTO<SmUserRoleDTO> selectByInfo(SmUserRoleDTO dto);

	/**
	 * 添加角色权限
	 * @param roleId
	 * @param oddId
	 * @param userId
	 * @return
	 */
	ResultDO<?> add(Long[] roleId, Long[] oddId, Long userId);
}
