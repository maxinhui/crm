package top.builbu.business.user.service;

import top.builbu.business.user.dto.UscClerkDTO;
import top.builbu.business.user.entity.UscClerk;
import top.builbu.common.dto.PageDTO;
import top.builbu.common.dto.ResultDO;
import top.builbu.common.util.page.Pagination;

public interface UscClerkService{
     
     PageDTO<UscClerkDTO> selectByList(UscClerkDTO dto, Pagination page);
     
     ResultDO<UscClerk> selectById(Integer id);
     
     ResultDO<?> save(UscClerkDTO dto);

     ResultDO<?> update(UscClerkDTO dto);
     
     ResultDO<?> deleteById(Integer id);
     
     ResultDO<?> deleteByCheck(Integer[] delids);

	ResultDO<?> updateByStore(String belongStore);
}
