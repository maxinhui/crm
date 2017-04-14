package top.builbu.business.user.repository;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import top.builbu.business.user.dto.UscMemberWcpnDTO;
import top.builbu.business.user.entity.UscMemberWcpn;

@Repository
public interface UscMemberWcpnMapper {

    /**
     * 列表
     * @param dto
     * @return
     */
    List<UscMemberWcpnDTO> selectByList(@Param("dto")UscMemberWcpnDTO dto,@Param("offset")Integer offset,@Param("limit")Integer limit);
    
    /**
     *主键查询
     *
     */
    UscMemberWcpn selectByPrimaryKey(Long row_id); 

   
    /**
     *主键查询
     *
     */
    int deleteByPrimaryKey(Long row_id); 

      
    /**
     *插入
     *
     */
    int insert(UscMemberWcpn record); 
      
    /**
     * 修改
     *
     */  
    int updateByPrimaryKey(UscMemberWcpn record);  
    
    /**
     * 批量删除
     *
     */  
    int deleteByAll(@Param("delids")Long[] delids);
    
    int selectByCount(@Param("dto")UscMemberWcpnDTO dto);

}
