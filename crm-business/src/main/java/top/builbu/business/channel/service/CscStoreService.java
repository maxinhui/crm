package top.builbu.business.channel.service;

import java.util.List;

import top.builbu.business.channel.dto.CscStoreDTO;
import top.builbu.business.channel.entity.CscStore;
import top.builbu.common.dto.PageDTO;
import top.builbu.common.dto.ResultDO;
import top.builbu.common.util.page.Pagination;

public interface CscStoreService{
     
     PageDTO<CscStoreDTO> selectByList(CscStoreDTO dto, Pagination page);
     
     ResultDO<CscStore> selectById(Long id);
     
     ResultDO<?> save(CscStoreDTO dto);

     ResultDO<?> update(CscStoreDTO dto);
     
     ResultDO<?> deleteById(Long id);
     
     ResultDO<?> deleteByCheck(Long[] delids);

     /**
      * 全部数据
      * @param dto
      * @return
      */
	 ResultDO<List<CscStoreDTO>> selectByInfo(CscStoreDTO dto);
}
