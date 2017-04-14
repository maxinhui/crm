package top.builbu.business.province.service;

import top.builbu.business.province.dto.ProvinceDTO;
import top.builbu.business.province.entity.Province;
import top.builbu.common.dto.PageDTO;
import top.builbu.common.dto.ResultDO;
import top.builbu.common.util.page.Pagination;

public interface ProvinceService{
     
     PageDTO<ProvinceDTO> selectByList(ProvinceDTO dto, Pagination page);
     
     ResultDO<Province> selectById(Integer id);
     
     ResultDO<?> save(ProvinceDTO dto);

     ResultDO<?> update(ProvinceDTO dto);
     
     ResultDO<?> deleteById(Integer id);
     
     ResultDO<?> deleteByCheck(Integer[] delids);
}
