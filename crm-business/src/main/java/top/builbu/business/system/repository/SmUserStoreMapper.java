package top.builbu.business.system.repository;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import top.builbu.business.system.dto.SmUserStoreDTO;
import top.builbu.business.system.entity.SmUserStore;

@Repository
public interface SmUserStoreMapper {

    /**
     * 列表
     * @param dto
     * @return
     */
    List<SmUserStoreDTO> selectByList(@Param("dto")SmUserStoreDTO dto,@Param("offset")Integer offset,@Param("limit")Integer limit);
    
    /**
     *主键查询
     *
     */
    SmUserStore selectByPrimaryKey(Long row_id); 

   
    /**
     *主键查询
     *
     */
    int deleteByPrimaryKey(Long row_id); 

      
    /**
     *插入
     *
     */
    int insert(SmUserStore record); 
      
    /**
     * 修改
     *
     */  
    int updateByPrimaryKey(SmUserStore record);  
    
    /**
     * 批量删除
     *
     */  
    int deleteByAll(@Param("delids")Long[] delids);
    
    int selectByCount(@Param("dto")SmUserStoreDTO dto);

}
