package top.builbu.business.system.repository;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import top.builbu.business.system.dto.SmUserOrgDTO;
import top.builbu.business.system.entity.SmUserOrg;

@Repository
public interface SmUserOrgMapper {

    /**
     * 列表
     * @param dto
     * @return
     */
    List<SmUserOrgDTO> selectByList(@Param("dto")SmUserOrgDTO dto,@Param("offset")Integer offset,@Param("limit")Integer limit);
    
    /**
     *主键查询
     *
     */
    SmUserOrg selectByPrimaryKey(Long row_id); 

   
    /**
     *主键查询
     *
     */
    int deleteByPrimaryKey(Long row_id); 

      
    /**
     *插入
     *
     */
    int insert(SmUserOrg record); 
      
    /**
     * 修改
     *
     */  
    int updateByPrimaryKey(SmUserOrg record);  
    
    /**
     * 批量删除
     *
     */  
    int deleteByAll(@Param("delids")Long[] delids);
    
    int selectByCount(@Param("dto")SmUserOrgDTO dto);

}
