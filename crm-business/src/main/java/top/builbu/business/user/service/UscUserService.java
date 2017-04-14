package top.builbu.business.user.service;

import top.builbu.business.user.dto.MemberDTO;
import top.builbu.business.user.dto.UscUserDTO;
import top.builbu.business.user.entity.UscUser;
import top.builbu.common.dto.PageDTO;
import top.builbu.common.dto.ResultDO;
import top.builbu.common.util.page.Pagination;

public interface UscUserService{
     
	PageDTO<MemberDTO> selectByList(MemberDTO dto, Pagination page);
     
     ResultDO<MemberDTO> selectById(Long id);
     
     ResultDO<?> save(MemberDTO dto);

     ResultDO<?> update(UscUserDTO dto);
     
     ResultDO<?> deleteById(Long id);
     
     ResultDO<?> deleteByCheck(Long[] delids);

	ResultDO<MemberDTO> login(String loginName, String passWord);

	ResultDO<Long> create(MemberDTO dto);

	

	
}
