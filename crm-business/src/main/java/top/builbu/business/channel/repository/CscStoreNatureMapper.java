package top.builbu.business.channel.repository;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import top.builbu.business.channel.dto.CscStoreNatureDTO;
import top.builbu.business.channel.entity.CscStoreNature;

@Repository
public interface CscStoreNatureMapper {

    /**
     * 列表
     * @param dto
     * @return
     */
    List<CscStoreNatureDTO> selectByList(@Param("dto")CscStoreNatureDTO dto,@Param("offset")Integer offset,@Param("limit")Integer limit);
    
    /**
     *主键查询
     *
     */
    CscStoreNature selectByPrimaryKey(Long nature_id); 

   
    /**
     *主键查询
     *
     */
    int deleteByPrimaryKey(Long nature_id); 

      
    /**
     *插入
     *
     */
    int insert(CscStoreNature record); 
      
    /**
     * 修改
     *
     */  
    int updateByPrimaryKey(CscStoreNature record);  
    
    /**
     * 批量删除
     *
     */  
    int deleteByAll(@Param("delids")Long[] delids);
    
    int selectByCount(@Param("dto")CscStoreNatureDTO dto);

}
