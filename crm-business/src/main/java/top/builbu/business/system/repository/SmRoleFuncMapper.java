package top.builbu.business.system.repository;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import top.builbu.business.system.dto.SmRoleFuncDTO;
import top.builbu.business.system.entity.SmRoleFunc;

@Repository
public interface SmRoleFuncMapper {

    /**
     * 列表
     * @param dto
     * @return
     */
    List<SmRoleFuncDTO> selectByList(@Param("dto")SmRoleFuncDTO dto,@Param("offset")Integer offset,@Param("limit")Integer limit);
    
    /**
     *主键查询
     *
     */
    SmRoleFunc selectByPrimaryKey(Long row_id); 

   
    /**
     *主键查询
     *
     */
    int deleteByPrimaryKey(Long row_id); 

      
    /**
     *插入
     *
     */
    int insert(SmRoleFunc record); 
      
    /**
     * 修改
     *
     */  
    int updateByPrimaryKey(SmRoleFunc record);  
    
    /**
     * 批量删除
     *
     */  
    int deleteByAll(@Param("delids")Long[] delids);
    
    int selectByCount(@Param("dto")SmRoleFuncDTO dto);
    
    /**
     * 所有數據
     * @param dto
     * @return
     */
    List<SmRoleFuncDTO> selectByInfo(@Param("dto")SmRoleFuncDTO dto);
    
    /**
     * 批量插入
     * @param list
     * @return
     */
    int saveList(@Param("list")List<SmRoleFunc> list);
    
    /**
     * 批量刪除
     */
    int deleteByRoleAll(@Param("delids")List<Long> delids,@Param("roleId")Long roleId);

}
