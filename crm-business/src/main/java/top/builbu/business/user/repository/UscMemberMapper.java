package top.builbu.business.user.repository;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import top.builbu.business.user.dto.UscMemberDTO;
import top.builbu.business.user.entity.UscMember;

@Repository
public interface UscMemberMapper {

    /**
     * 列表
     * @param dto
     * @return
     */
    List<UscMemberDTO> selectByList(@Param("dto")UscMemberDTO dto,@Param("offset")Integer offset,@Param("limit")Integer limit);
    
    /**
     *主键查询
     *
     */
    UscMember selectByPrimaryKey(Integer member_id); 

   
    /**
     *主键查询
     *
     */
    int deleteByPrimaryKey(Integer member_id); 

      
    /**
     *插入
     *
     */
    int insert(UscMember record); 
      
    /**
     * 修改
     *
     */  
    int updateByPrimaryKey(UscMember record);  
    
    /**
     * 批量删除
     *
     */  
    int deleteByAll(@Param("delids")Integer[] delids);
    
    int selectByCount(@Param("dto")UscMemberDTO dto);

}
