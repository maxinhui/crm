package top.builbu.business.channel.service;

import top.builbu.business.channel.dto.CscStoreStatusDTO;
import top.builbu.business.channel.entity.CscStoreStatus;
import top.builbu.common.dto.PageDTO;
import top.builbu.common.dto.ResultDO;
import top.builbu.common.util.page.Pagination;

public interface CscStoreStatusService{
     
     PageDTO<CscStoreStatusDTO> selectByList(CscStoreStatusDTO dto, Pagination page);
     
     ResultDO<CscStoreStatus> selectById(Long id);
     
     ResultDO<?> save(CscStoreStatusDTO dto);

     ResultDO<?> update(CscStoreStatusDTO dto);
     
     ResultDO<?> deleteById(Long id);
     
     ResultDO<?> deleteByCheck(Long[] delids);
}
