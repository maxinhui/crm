package top.builbu.business.system.repository;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import top.builbu.business.system.dto.SmUserRoleDTO;
import top.builbu.business.system.entity.SmRoleFunc;
import top.builbu.business.system.entity.SmUserRole;

@Repository
public interface SmUserRoleMapper {

    /**
     * 列表
     * @param dto
     * @return
     */
    List<SmUserRoleDTO> selectByList(@Param("dto")SmUserRoleDTO dto,@Param("offset")Integer offset,@Param("limit")Integer limit);
    
    /**
     *主键查询
     *
     */
    SmUserRole selectByPrimaryKey(Long row_id); 

   
    /**
     *主键查询
     *
     */
    int deleteByPrimaryKey(Long row_id); 

      
    /**
     *插入
     *
     */
    int insert(SmUserRole record); 
      
    /**
     * 修改
     *
     */  
    int updateByPrimaryKey(SmUserRole record);  
    
    /**
     * 批量删除
     *
     */  
    int deleteByAll(@Param("delids")Long[] delids);
    
    int selectByCount(@Param("dto")SmUserRoleDTO dto);
    
    
    /**
     * 所有数据
     * @param dto
     * @return
     */
    List<SmUserRoleDTO> selectByInfo(@Param("dto")SmUserRoleDTO dto);
    
    /**
     * 批量插入
     * @param list
     * @return
     */
    int saveList(@Param("list")List<SmUserRoleDTO> list);
    
    /**
     * 批量刪除
     */
    int deleteByRoleAll(@Param("delids")List<Long> delids,@Param("userId")Long userId);


}
