package top.builbu.business.system.entity;  

import java.util.Date;     
  
public class SmRole {  
	    /**
	     *
	     *角色主键
	    **/
        private Long roleId;  
	    /**
	     *
	     *角色编号
	    **/
        private String roleNo;  
	    /**
	     *
	     *角色名称
	    **/
        private String roleName;  
	    /**
	     *
	     *备注说明
	    **/
        private String remark;  
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
          
          
        
        public Long getRoleId(){  
            return this.roleId;  
        }  
       
        public void setRoleId(Long roleId){            
           
            this.roleId = roleId;
                    
        }  
          
                 
        
        public String getRoleNo(){  
            return this.roleNo;  
        }  
       
        public void setRoleNo(String roleNo){            
           
            this.roleNo = roleNo;
                    
        }  
          
                 
        
        public String getRoleName(){  
            return this.roleName;  
        }  
       
        public void setRoleName(String roleName){            
           
            this.roleName = roleName;
                    
        }  
          
                 
        
        public String getRemark(){  
            return this.remark;  
        }  
       
        public void setRemark(String remark){            
           
            this.remark = remark;
                    
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

