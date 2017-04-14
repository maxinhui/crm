package top.builbu.business.system.repository;

import java.util.List;
import java.util.Set;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import top.builbu.business.system.dto.SmRoleDTO;
import top.builbu.business.system.entity.SmRole;

@Repository
public interface SmRoleMapper {

    /**
     * 列表
     * @param dto
     * @return
     */
    List<SmRoleDTO> selectByList(@Param("dto")SmRoleDTO dto,@Param("offset")Integer offset,@Param("limit")Integer limit);
    
    /**
     *主键查询
     *
     */
    SmRole selectByPrimaryKey(Long role_id); 

   
    /**
     *主键查询
     *
     */
    int deleteByPrimaryKey(Long role_id); 

      
    /**
     *插入
     *
     */
    int insert(SmRole record); 
      
    /**
     * 修改
     *
     */  
    int updateByPrimaryKey(SmRole record);  
    
    /**
     * 批量删除
     *
     */  
    int deleteByAll(@Param("delids")Long[] delids);
    
    int selectByCount(@Param("dto")SmRoleDTO dto);

    /**
     * 所有数据
     * @param dto
     * @return
     */
    List<SmRoleDTO> selectByInfo(@Param("dto")SmRoleDTO dto);
    
    
    Set<SmRoleDTO> slelctByUserId(@Param("userId")Long userId);
}
