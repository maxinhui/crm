package top.builbu.business.system.service;

import top.builbu.business.system.dto.SmUserStoreDTO;
import top.builbu.business.system.entity.SmUserStore;
import top.builbu.common.dto.PageDTO;
import top.builbu.common.dto.ResultDO;
import top.builbu.common.util.page.Pagination;

public interface SmUserStoreService{
     
     PageDTO<SmUserStoreDTO> selectByList(SmUserStoreDTO dto, Pagination page);
     
     ResultDO<SmUserStore> selectById(Long id);
     
     ResultDO<?> save(SmUserStoreDTO dto);

     ResultDO<?> update(SmUserStoreDTO dto);
     
     ResultDO<?> deleteById(Long id);
     
     ResultDO<?> deleteByCheck(Long[] delids);
}
