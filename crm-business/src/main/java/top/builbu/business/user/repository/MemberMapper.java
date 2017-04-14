package top.builbu.business.user.repository;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import top.builbu.business.user.dto.MemberDTO;
import top.builbu.business.user.dto.UscUserDTO;
import top.builbu.business.user.entity.UscUser;

@Repository
public interface MemberMapper {

    /**
     * 列表
     * @param dto
     * @return
     */
    List<MemberDTO> selectByList(@Param("dto")MemberDTO dto,@Param("offset")Integer offset,@Param("limit")Integer limit);
    
    /**
     *主键查询
     *
     */
    MemberDTO selectByPrimaryKey(Long user_id); 

   
    /**
     *主键查询
     *
     */
    int deleteByPrimaryKey(Long user_id); 

      
    /**
     *插入
     *
     */
    int insert(UscUser record); 
      
    /**
     * 修改
     *
     */  
    int updateByPrimaryKey(UscUser record);  
    
    /**
     * 批量删除
     *
     */  
    int deleteByAll(@Param("delids")Long[] delids);
    
    int selectByCount(@Param("dto")MemberDTO dto);
    
    /**
     * 登录
     * @param loginName
     * @param passWord
     * @return
     */
    MemberDTO login(@Param("loginName")String loginName,@Param("passWord")String passWord); 
 
}
