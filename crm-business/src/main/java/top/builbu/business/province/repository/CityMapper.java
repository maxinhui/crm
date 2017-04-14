package top.builbu.business.province.repository;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import top.builbu.business.province.dto.CityDTO;
import top.builbu.business.province.entity.City;

@Repository
public interface CityMapper {

    /**
     * 列表
     * @param dto
     * @return
     */
    List<CityDTO> selectByList(@Param("dto")CityDTO dto,@Param("offset")Integer offset,@Param("limit")Integer limit);
    
    /**
     *主键查询
     *
     */
    City selectByPrimaryKey(Integer id); 

   
    /**
     *主键查询
     *
     */
    int deleteByPrimaryKey(Integer id); 

      
    /**
     *插入
     *
     */
    int insert(City record); 
      
    /**
     * 修改
     *
     */  
    int updateByPrimaryKey(City record);  
    
    /**
     * 批量删除
     *
     */  
    int deleteByAll(@Param("delids")Integer[] delids);
    
    int selectByCount(@Param("dto")CityDTO dto);

}
