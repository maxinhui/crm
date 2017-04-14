package top.builbu.business.user.service;

import top.builbu.business.user.dto.UscMemberDTO;
import top.builbu.business.user.entity.UscMember;
import top.builbu.common.dto.PageDTO;
import top.builbu.common.dto.ResultDO;
import top.builbu.common.util.page.Pagination;

public interface UscMemberService{
     
     PageDTO<UscMemberDTO> selectByList(UscMemberDTO dto, Pagination page);
     
     ResultDO<UscMember> selectById(Integer id);
     
     ResultDO<?> save(UscMemberDTO dto);

     ResultDO<?> update(UscMemberDTO dto);
     
     ResultDO<?> deleteById(Integer id);
     
     ResultDO<?> deleteByCheck(Integer[] delids);
}
