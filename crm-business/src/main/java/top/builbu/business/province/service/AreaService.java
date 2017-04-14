package top.builbu.business.province.service;

import top.builbu.business.province.dto.AreaDTO;
import top.builbu.business.province.entity.Area;
import top.builbu.common.dto.PageDTO;
import top.builbu.common.dto.ResultDO;
import top.builbu.common.util.page.Pagination;

public interface AreaService{
     
     PageDTO<AreaDTO> selectByList(AreaDTO dto, Pagination page);
     
     ResultDO<Area> selectById(Integer id);
     
     ResultDO<?> save(AreaDTO dto);

     ResultDO<?> update(AreaDTO dto);
     
     ResultDO<?> deleteById(Integer id);
     
     ResultDO<?> deleteByCheck(Integer[] delids);
}
