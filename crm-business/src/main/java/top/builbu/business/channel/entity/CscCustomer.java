package top.builbu.business.channel.entity;  

import java.util.Date;      
  
public class CscCustomer {  
	    /**
	     *
	     *
	    **/
        private Long rowId;  
	    /**
	     *
	     *经销商编号
	    **/
        private String customerNo;  
	    /**
	     *
	     *经销商名称(简称)
	    **/
        private String customerName;  
	    /**
	     *
	     *经销商全称
	    **/
        private String customerFullName;  
	    /**
	     *
	     *公司编号
	    **/
        private String corpNo;  
	    /**
	     *
	     *经销商地址
	    **/
        private String customerAddress;  
	    /**
	     *
	     *联系人
	    **/
        private String contacts;  
	    /**
	     *
	     *联系电话
	    **/
        private String contactNumber;  
	    /**
	     *
	     *是否POS店铺
	    **/
        private String isPosStore;  
	    /**
	     *
	     *会员类型
	    **/
        private Long userId;  
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
          
                 
        
        public String getCustomerNo(){  
            return this.customerNo;  
        }  
       
        public void setCustomerNo(String customerNo){            
           
            this.customerNo = customerNo;
                    
        }  
          
                 
        
        public String getCustomerName(){  
            return this.customerName;  
        }  
       
        public void setCustomerName(String customerName){            
           
            this.customerName = customerName;
                    
        }  
          
                 
        
        public String getCustomerFullName(){  
            return this.customerFullName;  
        }  
       
        public void setCustomerFullName(String customerFullName){            
           
            this.customerFullName = customerFullName;
                    
        }  
          
                 
        
        public String getCorpNo(){  
            return this.corpNo;  
        }  
       
        public void setCorpNo(String corpNo){            
           
            this.corpNo = corpNo;
                    
        }  
          
                 
        
        public String getCustomerAddress(){  
            return this.customerAddress;  
        }  
       
        public void setCustomerAddress(String customerAddress){            
           
            this.customerAddress = customerAddress;
                    
        }  
          
                 
        
        public String getContacts(){  
            return this.contacts;  
        }  
       
        public void setContacts(String contacts){            
           
            this.contacts = contacts;
                    
        }  
          
                 
        
        public String getContactNumber(){  
            return this.contactNumber;  
        }  
       
        public void setContactNumber(String contactNumber){            
           
            this.contactNumber = contactNumber;
                    
        }  
          
                 
        
        public String getIsPosStore(){  
            return this.isPosStore;  
        }  
       
        public void setIsPosStore(String isPosStore){            
           
            this.isPosStore = isPosStore;
                    
        }  
          
                 
        
        public Long getUserId(){  
            return this.userId;  
        }  
       
        public void setUserId(Long userId){            
           
            this.userId = userId;
                    
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

