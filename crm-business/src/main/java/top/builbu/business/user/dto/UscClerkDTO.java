package top.builbu.business.user.dto;  

import java.util.Date;     
  
public class UscClerkDTO {  
	    /**
	     *
	     *记录行主键
	    **/
        private Long rowId;  
	    /**
	     *
	     *营业员主键*
	    **/
        private Long clerkId;  
	    /**
	     *
	     *归属店铺
	    **/
        private String belongStore;  
	    /**
	     *
	     *入职日期
	    **/
        private Date entryDate;  
	    /**
	     *
	     *是否店长(Y-是 N-否)
	    **/
        private String isManager;  
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
         
        public Long getClerkId(){  
            return this.clerkId;  
        }  
       
        public void setClerkId(Long clerkId){  
            this.clerkId = clerkId;
        } 
         
        public String getBelongStore(){  
            return this.belongStore;  
        }  
       
        public void setBelongStore(String belongStore){  
            this.belongStore = belongStore == "" ? null : belongStore.trim();
        } 
         
        public Date getEntryDate(){  
            return this.entryDate;  
        }  
       
        public void setEntryDate(Date entryDate){  
            this.entryDate = entryDate;
        } 
         
        public String getIsManager(){  
            return this.isManager;  
        }  
       
        public void setIsManager(String isManager){  
            this.isManager = isManager == "" ? null : isManager.trim();
        } 
         
        public Date getTs(){  
            return this.ts;  
        }  
       
        public void setTs(Date ts){  
            this.ts = ts;
        } 
         
}  