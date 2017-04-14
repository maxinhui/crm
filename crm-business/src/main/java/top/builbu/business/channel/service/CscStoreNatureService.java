package top.builbu.business.channel.service;

import top.builbu.business.channel.dto.CscStoreNatureDTO;
import top.builbu.business.channel.entity.CscStoreNature;
import top.builbu.common.dto.PageDTO;
import top.builbu.common.dto.ResultDO;
import top.builbu.common.util.page.Pagination;

public interface CscStoreNatureService{
     
     PageDTO<CscStoreNatureDTO> selectByList(CscStoreNatureDTO dto, Pagination page);
     
     ResultDO<CscStoreNature> selectById(Long id);
     
     ResultDO<?> save(CscStoreNatureDTO dto);

     ResultDO<?> update(CscStoreNatureDTO dto);
     
     ResultDO<?> deleteById(Long id);
     
     ResultDO<?> deleteByCheck(Long[] delids);
}
