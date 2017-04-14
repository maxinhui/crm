package top.builbu.business.system.dto;  

import java.util.Date;
  
public class SmUserRoleDTO {  
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
	     *角色主键
	    **/
        private Long roleId;  
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
         
        public Long getRoleId(){  
            return this.roleId;  
        }  
       
        public void setRoleId(Long roleId){  
            this.roleId = roleId;
        } 
         
        public String getValidFlag(){  
            return this.validFlag;  
        }  
       
        public void setValidFlag(String validFlag){  
            this.validFlag = validFlag == "" ? null : validFlag.trim();
        } 
         
        public Date getTs(){  
            return this.ts;  
        }  
       
        public void setTs(Date ts){  
            this.ts = ts;
        } 
         
}  