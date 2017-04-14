package top.builbu.business.province.repository;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import top.builbu.business.province.dto.AreaDTO;
import top.builbu.business.province.entity.Area;

@Repository
public interface AreaMapper {

    /**
     * 列表
     * @param dto
     * @return
     */
    List<AreaDTO> selectByList(@Param("dto")AreaDTO dto,@Param("offset")Integer offset,@Param("limit")Integer limit);
    
    /**
     *主键查询
     *
     */
    Area selectByPrimaryKey(Integer id); 

   
    /**
     *主键查询
     *
     */
    int deleteByPrimaryKey(Integer id); 

      
    /**
     *插入
     *
     */
    int insert(Area record); 
      
    /**
     * 修改
     *
     */  
    int updateByPrimaryKey(Area record);  
    
    /**
     * 批量删除
     *
     */  
    int deleteByAll(@Param("delids")Integer[] delids);
    
    int selectByCount(@Param("dto")AreaDTO dto);

}
