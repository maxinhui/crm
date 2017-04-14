package top.builbu.business.system.service;

import top.builbu.business.system.dto.SmUserOrgDTO;
import top.builbu.business.system.entity.SmUserOrg;
import top.builbu.common.dto.PageDTO;
import top.builbu.common.dto.ResultDO;
import top.builbu.common.util.page.Pagination;

public interface SmUserOrgService{
     
     PageDTO<SmUserOrgDTO> selectByList(SmUserOrgDTO dto, Pagination page);
     
     ResultDO<SmUserOrg> selectById(Long id);
     
     ResultDO<?> save(SmUserOrgDTO dto);

     ResultDO<?> update(SmUserOrgDTO dto);
     
     ResultDO<?> deleteById(Long id);
     
     ResultDO<?> deleteByCheck(Long[] delids);
}
