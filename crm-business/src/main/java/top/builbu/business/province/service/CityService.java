package top.builbu.business.province.service;

import top.builbu.business.province.dto.CityDTO;
import top.builbu.business.province.entity.City;
import top.builbu.common.dto.PageDTO;
import top.builbu.common.dto.ResultDO;
import top.builbu.common.util.page.Pagination;

public interface CityService{
     
     PageDTO<CityDTO> selectByList(CityDTO dto, Pagination page);
     
     ResultDO<City> selectById(Integer id);
     
     ResultDO<?> save(CityDTO dto);

     ResultDO<?> update(CityDTO dto);
     
     ResultDO<?> deleteById(Integer id);
     
     ResultDO<?> deleteByCheck(Integer[] delids);
}
