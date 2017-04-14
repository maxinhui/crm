package top.builbu.business.user.service;

import top.builbu.business.user.dto.UscMemberWcpnDTO;
import top.builbu.business.user.entity.UscMemberWcpn;
import top.builbu.common.dto.PageDTO;
import top.builbu.common.dto.ResultDO;
import top.builbu.common.util.page.Pagination;

public interface UscMemberWcpnService{
     
     PageDTO<UscMemberWcpnDTO> selectByList(UscMemberWcpnDTO dto, Pagination page);
     
     ResultDO<UscMemberWcpn> selectById(Long id);
     
     ResultDO<?> save(UscMemberWcpnDTO dto);

     ResultDO<?> update(UscMemberWcpnDTO dto);
     
     ResultDO<?> deleteById(Long id);
     
     ResultDO<?> deleteByCheck(Long[] delids);
}
