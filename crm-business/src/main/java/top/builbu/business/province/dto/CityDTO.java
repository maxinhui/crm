package top.builbu.business.province.dto;  

import java.util.Date;      
  
public class CityDTO {  
	    /**
	     *
	     *
	    **/
        private Integer id;  
	    /**
	     *
	     *
	    **/
        private String cityid;  
	    /**
	     *
	     *
	    **/
        private String city;  
	    /**
	     *
	     *
	    **/
        private String provinceid;  
          
          
        public Integer getId(){  
            return this.id;  
        }  
       
        public void setId(Integer id){  
            this.id = id;
        } 
         
        public String getCityid(){  
            return this.cityid;  
        }  
       
        public void setCityid(String cityid){  
            this.cityid = cityid == "" ? null : cityid.trim();
        } 
         
        public String getCity(){  
            return this.city;  
        }  
       
        public void setCity(String city){  
            this.city = city == "" ? null : city.trim();
        } 
         
        public String getProvinceid(){  
            return this.provinceid;  
        }  
       
        public void setProvinceid(String provinceid){  
            this.provinceid = provinceid == "" ? null : provinceid.trim();
        } 
         
}  