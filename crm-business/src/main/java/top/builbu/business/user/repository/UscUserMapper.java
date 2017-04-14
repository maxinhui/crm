package top.builbu.business.user.repository;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import top.builbu.business.user.dto.UscUserDTO;
import top.builbu.business.user.entity.UscUser;

@Repository
public interface UscUserMapper {

    /**
     * 列表
     * @param dto
     * @return
     */
    List<UscUserDTO> selectByList(@Param("dto")UscUserDTO dto,@Param("offset")Integer offset,@Param("limit")Integer limit);
    
    /**
     *主键查询
     *
     */
    UscUser selectByPrimaryKey(Long user_id); 

   
    /**
     *主键查询
     *
     */
    int deleteByPrimaryKey(Long user_id); 

      
    /**
     *插入
     *
     */
    int insert(UscUser record); 
      
    /**
     * 修改
     *
     */  
    int updateByPrimaryKey(UscUser record);  
    
    /**
     * 批量删除
     *
     */  
    int deleteByAll(@Param("delids")Long[] delids);
    
    int selectByCount(@Param("dto")UscUserDTO dto);
    
    

}
