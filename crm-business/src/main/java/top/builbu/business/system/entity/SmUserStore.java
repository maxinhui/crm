package top.builbu.business.system.entity;  

import java.util.Date;    
  
public class SmUserStore {  
	    /**
	     *
	     *记录行主键
	    **/
        private Long rowId;  
	    /**
	     *
	     *用户主键
	    **/
        private Long userId;  
	    /**
	     *
	     *店铺编号
	    **/
        private String storeNo;  
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
          
          
        
        public Long getRowId(){  
            return this.rowId;  
        }  
       
        public void setRowId(Long rowId){            
           
            this.rowId = rowId;
                    
        }  
          
                 
        
        public Long getUserId(){  
            return this.userId;  
        }  
       
        public void setUserId(Long userId){            
           
            this.userId = userId;
                    
        }  
          
                 
        
        public String getStoreNo(){  
            return this.storeNo;  
        }  
       
        public void setStoreNo(String storeNo){            
           
            this.storeNo = storeNo;
                    
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

