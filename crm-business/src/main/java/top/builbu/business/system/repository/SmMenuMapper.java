package top.builbu.business.system.repository;

import java.util.List;
import java.util.Set;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import top.builbu.business.system.dto.SmMenuDTO;
import top.builbu.business.system.entity.SmMenu;

@Repository
public interface SmMenuMapper {

    /**
     * 列表
     * @param dto
     * @return
     */
    List<SmMenuDTO> selectByList(@Param("dto")SmMenuDTO dto,@Param("offset")Integer offset,@Param("limit")Integer limit);
    
    /**
     *主键查询
     *
     */
    SmMenu selectByPrimaryKey(Long menu_id); 

   
    /**
     *主键查询
     *
     */
    int deleteByPrimaryKey(Long menu_id); 

      
    /**
     *插入
     *
     */
    int insert(SmMenu record); 
      
    /**
     * 修改
     *
     */  
    int updateByPrimaryKey(SmMenu record);  
    
    /**
     * 批量删除
     *
     */  
    int deleteByAll(@Param("delids")Long[] delids);
    
    int selectByCount(@Param("dto")SmMenuDTO dto);
    
    /**
     * 所有數據
     * @param dto
     * @return
     */
    List<SmMenuDTO> selectByInfo(@Param("dto")SmMenuDTO dto);
    
    /**
     * roleID 查詢角色所属列表
     * @param roleId
     * @return
     */
    Set<SmMenuDTO> selectByRoleId(@Param("roleId")Long roleId);

}
