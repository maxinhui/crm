package top.builbu.business.system.entity;  

import java.util.Date;      
  
public class SmUserOrg {  
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
	     *组织类型*
	    **/
        private String orgType;  
	    /**
	     *
	     *组织编号
	    **/
        private String orgNo;  
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
          
                 
        
        public String getOrgType(){  
            return this.orgType;  
        }  
       
        public void setOrgType(String orgType){            
           
            this.orgType = orgType;
                    
        }  
          
                 
        
        public String getOrgNo(){  
            return this.orgNo;  
        }  
       
        public void setOrgNo(String orgNo){            
           
            this.orgNo = orgNo;
                    
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

