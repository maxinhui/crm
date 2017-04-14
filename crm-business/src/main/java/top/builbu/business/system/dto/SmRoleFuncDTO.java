package top.builbu.business.system.dto;  

import java.util.Date;      
  
public class SmRoleFuncDTO {  
	    /**
	     *
	     *记录行主键
	    **/
        private Long rowId;  
	    /**
	     *
	     *角色主键
	    **/
        private Long roleId;  
	    /**
	     *
	     *功能类型(1-菜单 2-按钮)
	    **/
        private Integer funcType;  
	    /**
	     *
	     *功能主键
	    **/
        private Long funcId;  
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
         
        public Long getRoleId(){  
            return this.roleId;  
        }  
       
        public void setRoleId(Long roleId){  
            this.roleId = roleId;
        } 
         
        public Integer getFuncType(){  
            return this.funcType;  
        }  
       
        public void setFuncType(Integer funcType){  
            this.funcType = funcType;
        } 
         
        public Long getFuncId(){  
            return this.funcId;  
        }  
       
        public void setFuncId(Long funcId){  
            this.funcId = funcId;
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