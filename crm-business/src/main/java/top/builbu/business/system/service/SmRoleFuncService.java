package top.builbu.business.system.service;


import top.builbu.business.system.dto.SmRoleFuncDTO;
import top.builbu.business.system.entity.SmRoleFunc;
import top.builbu.common.dto.PageDTO;
import top.builbu.common.dto.ResultDO;
import top.builbu.common.util.page.Pagination;

public interface SmRoleFuncService{
     
     PageDTO<SmRoleFuncDTO> selectByList(SmRoleFuncDTO dto, Pagination page);
     
     ResultDO<SmRoleFunc> selectById(Long id);
     
     ResultDO<?> save(SmRoleFuncDTO dto);

     ResultDO<?> update(SmRoleFuncDTO dto);
     
     ResultDO<?> deleteById(Long id);
     
     ResultDO<?> deleteByCheck(Long[] delids);

     /**
      * 所有數據
      * @param dto
      * @return
      */
	 PageDTO<SmRoleFuncDTO> selectByInfo(SmRoleFuncDTO dto);

	 /**
	  * 添加权限关系
	  * @param menuId
	  * @param buttonId
	 * @param oddId 
	  * @param roleId
	  * @return
	  */
	 ResultDO<?> add(Long[] menuId, Long[] buttonId, Long[] oddId, Long roleId);
}
