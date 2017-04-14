package top.builbu.business.channel.repository;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import top.builbu.business.channel.dto.CscStoreDTO;
import top.builbu.business.channel.entity.CscStore;

@Repository
public interface CscStoreMapper {

    /**
     * 列表
     * @param dto
     * @return
     */
    List<CscStoreDTO> selectByList(@Param("dto")CscStoreDTO dto,@Param("offset")Integer offset,@Param("limit")Integer limit);
    
    /**
     *主键查询
     *
     */
    CscStore selectByPrimaryKey(Long store_id); 

   
    /**
     *主键查询
     *
     */
    int deleteByPrimaryKey(Long store_id); 

      
    /**
     *插入
     *
     */
    int insert(CscStore record); 
      
    /**
     * 修改
     *
     */  
    int updateByPrimaryKey(CscStore record);  
    
    /**
     * 批量删除
     *
     */  
    int deleteByAll(@Param("delids")Long[] delids);
    
    int selectByCount(@Param("dto")CscStoreDTO dto);
    
    /**
     * 全部数据
     * @param dto
     * @return
     */
    List<CscStoreDTO> selectByInfo(@Param("dto")CscStoreDTO dto);
}
