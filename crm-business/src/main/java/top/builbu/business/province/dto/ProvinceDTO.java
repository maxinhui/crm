package top.builbu.business.province.dto;  

import java.util.Date;      
  
public class ProvinceDTO {  
	    /**
	     *
	     *
	    **/
        private Integer id;  
	    /**
	     *
	     *
	    **/
        private String provinceid;  
	    /**
	     *
	     *
	    **/
        private String province;  
          
          
        public Integer getId(){  
            return this.id;  
        }  
       
        public void setId(Integer id){  
            this.id = id;
        } 
         
        public String getProvinceid(){  
            return this.provinceid;  
        }  
       
        public void setProvinceid(String provinceid){  
            this.provinceid = provinceid == "" ? null : provinceid.trim();
        } 
         
        public String getProvince(){  
            return this.province;  
        }  
       
        public void setProvince(String province){  
            this.province = province == "" ? null : province.trim();
        } 
         
}  