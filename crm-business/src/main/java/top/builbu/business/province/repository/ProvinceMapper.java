package top.builbu.business.province.repository;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import top.builbu.business.province.dto.ProvinceDTO;
import top.builbu.business.province.entity.Province;

@Repository
public interface ProvinceMapper {

    /**
     * 列表
     * @param dto
     * @return
     */
    List<ProvinceDTO> selectByList(@Param("dto")ProvinceDTO dto,@Param("offset")Integer offset,@Param("limit")Integer limit);
    
    /**
     *主键查询
     *
     */
    Province selectByPrimaryKey(Integer id); 

   
    /**
     *主键查询
     *
     */
    int deleteByPrimaryKey(Integer id); 

      
    /**
     *插入
     *
     */
    int insert(Province record); 
      
    /**
     * 修改
     *
     */  
    int updateByPrimaryKey(Province record);  
    
    /**
     * 批量删除
     *
     */  
    int deleteByAll(@Param("delids")Integer[] delids);
    
    int selectByCount(@Param("dto")ProvinceDTO dto);

}
