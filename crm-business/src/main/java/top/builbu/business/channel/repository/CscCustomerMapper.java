package top.builbu.business.channel.repository;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import top.builbu.business.channel.dto.CscCustomerDTO;
import top.builbu.business.channel.entity.CscCustomer;

@Repository
public interface CscCustomerMapper {

    /**
     * 列表
     * @param dto
     * @return
     */
    List<CscCustomerDTO> selectByList(@Param("dto")CscCustomerDTO dto,@Param("offset")Integer offset,@Param("limit")Integer limit);
    
    /**
     *主键查询
     *
     */
    CscCustomer selectByPrimaryKey(Long row_id); 

   
    /**
     *主键查询
     *
     */
    int deleteByPrimaryKey(Long row_id); 

      
    /**
     *插入
     *
     */
    int insert(CscCustomer record); 
      
    /**
     * 修改
     *
     */  
    int updateByPrimaryKey(CscCustomer record);  
    
    /**
     * 批量删除
     *
     */  
    int deleteByAll(@Param("delids")Long[] delids);
    
    int selectByCount(@Param("dto")CscCustomerDTO dto);

}
