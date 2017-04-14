package top.builbu.business.channel.service;

import top.builbu.business.channel.dto.CscCustomerDTO;
import top.builbu.business.channel.entity.CscCustomer;
import top.builbu.common.dto.PageDTO;
import top.builbu.common.dto.ResultDO;
import top.builbu.common.util.page.Pagination;

public interface CscCustomerService{
     
     PageDTO<CscCustomerDTO> selectByList(CscCustomerDTO dto, Pagination page);
     
     ResultDO<CscCustomer> selectById(Long id);
     
     ResultDO<?> save(CscCustomerDTO dto);

     ResultDO<?> update(CscCustomerDTO dto);
     
     ResultDO<?> deleteById(Long id);
     
     ResultDO<?> deleteByCheck(Long[] delids);
}
