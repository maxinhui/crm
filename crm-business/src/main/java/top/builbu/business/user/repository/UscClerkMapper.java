package top.builbu.business.user.repository;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import top.builbu.business.user.dto.UscClerkDTO;
import top.builbu.business.user.entity.UscClerk;

@Repository
public interface UscClerkMapper {

    /**
     * 列表
     * @param dto
     * @return
     */
    List<UscClerkDTO> selectByList(@Param("dto")UscClerkDTO dto,@Param("offset")Integer offset,@Param("limit")Integer limit);
    
    /**
     *主键查询
     *
     */
    UscClerk selectByPrimaryKey(Integer row_id); 

   
    /**
     *主键查询
     *
     */
    int deleteByPrimaryKey(Integer row_id); 

      
    /**
     *插入
     *
     */
    int insert(UscClerk record); 
      
    /**
     * 修改
     *
     */  
    int updateByPrimaryKey(UscClerk record);  
    
    /**
     * 批量删除
     *
     */  
    int deleteByAll(@Param("delids")Integer[] delids);
    
    int selectByCount(@Param("dto")UscClerkDTO dto);
    
    /**
     * 维护门店与店员关系
     * @param record
     * @return
     */
    int updateByStore(@Param("belongStore")String belongStore);

}
