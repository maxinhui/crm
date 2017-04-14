package top.builbu.business.province.dto;  

import java.util.Date;      
  
public class AreaDTO {  
	    /**
	     *
	     *
	    **/
        private Integer id;  
	    /**
	     *
	     *
	    **/
        private String areaid;  
	    /**
	     *
	     *
	    **/
        private String area;  
	    /**
	     *
	     *
	    **/
        private String cityid;  
          
          
        public Integer getId(){  
            return this.id;  
        }  
       
        public void setId(Integer id){  
            this.id = id;
        } 
         
        public String getAreaid(){  
            return this.areaid;  
        }  
       
        public void setAreaid(String areaid){  
            this.areaid = areaid == "" ? null : areaid.trim();
        } 
         
        public String getArea(){  
            return this.area;  
        }  
       
        public void setArea(String area){  
            this.area = area == "" ? null : area.trim();
        } 
         
        public String getCityid(){  
            return this.cityid;  
        }  
       
        public void setCityid(String cityid){  
            this.cityid = cityid == "" ? null : cityid.trim();
        } 
         
}  