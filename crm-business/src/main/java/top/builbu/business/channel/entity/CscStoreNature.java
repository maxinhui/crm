package top.builbu.business.channel.entity;  

import java.util.Date;      
  
public class CscStoreNature {  
	    /**
	     *
	     *经营性质主键
	    **/
        private Long natureId;  
	    /**
	     *
	     *外部系统对应主键
	    **/
        private String esrowId;  
	    /**
	     *
	     *经营性质名称
	    **/
        private String natureName;  
	    /**
	     *
	     *有效标识(Y-有效 N-作废)
	    **/
        private String validFlag;  
	    /**
	     *
	     *时间戳
	    **/
        private Date ts;  
          
          
        
        public Long getNatureId(){  
            return this.natureId;  
        }  
       
        public void setNatureId(Long natureId){            
           
            this.natureId = natureId;
                    
        }  
          
                 
        
        public String getEsrowId(){  
            return this.esrowId;  
        }  
       
        public void setEsrowId(String esrowId){            
           
            this.esrowId = esrowId;
                    
        }  
          
                 
        
        public String getNatureName(){  
            return this.natureName;  
        }  
       
        public void setNatureName(String natureName){            
           
            this.natureName = natureName;
                    
        }  
          
                 
        
        public String getValidFlag(){  
            return this.validFlag;  
        }  
       
        public void setValidFlag(String validFlag){            
           
            this.validFlag = validFlag;
                    
        }  
          
                 
        
        public Date getTs(){  
            return this.ts;  
        }  
       
        public void setTs(Date ts){            
           
            this.ts = ts;
                    
        }  
          
                 
}  

