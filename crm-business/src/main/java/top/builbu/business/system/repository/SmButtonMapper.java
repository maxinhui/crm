package top.builbu.business.system.repository;

import java.util.List;
import java.util.Set;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import top.builbu.business.system.dto.SmButtonDTO;
import top.builbu.business.system.entity.SmButton;

@Repository
public interface SmButtonMapper {

    /**
     * 列表
     * @param dto
     * @return
     */
    List<SmButtonDTO> selectByList(@Param("dto")SmButtonDTO dto,@Param("offset")Integer offset,@Param("limit")Integer limit);
    
    /**
     *主键查询
     *
     */
    SmButton selectByPrimaryKey(Long button_id); 

   
    /**
     *主键查询
     *
     */
    int deleteByPrimaryKey(Long button_id); 

      
    /**
     *插入
     *
     */
    int insert(SmButton record); 
      
    /**
     * 修改
     *
     */  
    int updateByPrimaryKey(SmButton record);  
    
    /**
     * 批量删除
     *
     */  
    int deleteByAll(@Param("delids")Long[] delids);
    
    int selectByCount(@Param("dto")SmButtonDTO dto);

    /**
     * 所有數據
     * @param dto
     * @return
     */
    List<SmButtonDTO> selectByInfo(@Param("dto")SmButtonDTO dto);
    
    /**
     * 角色所属按钮权限
     * @param roleId
     * @return
     */
    Set<SmButtonDTO> selectByRoleId(@Param("roleId")Long roleId);
    
}
