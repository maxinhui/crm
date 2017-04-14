package top.builbu.business.system.entity;  

import java.util.Date;   
  
public class SmMenu {  
	    /**
	     *
	     *菜单主键
	    **/
        private Long menuId;  
	    /**
	     *
	     *菜单编号
	    **/
        private String menuNo;  
	    /**
	     *
	     *菜单名称
	    **/
        private String menuName;  
	    /**
	     *
	     *菜单显示顺序
	    **/
        private String displayOrder;  
	    /**
	     *
	     *菜单级别
	    **/
        private String menuLevel;  
	    /**
	     *
	     *菜单类别*
	    **/
        private Integer menuType;  
	    /**
	     *
	     *父级菜单主键
	    **/
        private Long parentMenuId;  
	    /**
	     *
	     *是否末级菜单(Y-是 N-否)
	    **/
        private String isLeaf;  
	    /**
	     *
	     *控制按钮权限(Y-是 N-否)
	    **/
        private String isButtonPower;  
	    /**
	     *
	     *是否报表菜单(Y-是 N-否)
	    **/
        private String isReport;  
	    /**
	     *
	     *页面访问路径
	    **/
        private String pageUrl;  
	    /**
	     *
	     *设计人员
	    **/
        private String designer;  
	    /**
	     *
	     *开发人员
	    **/
        private String developer;  
	    /**
	     *
	     *贡献人员
	    **/
        private String contributer;  
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
          
          
        
        public Long getMenuId(){  
            return this.menuId;  
        }  
       
        public void setMenuId(Long menuId){            
           
            this.menuId = menuId;
                    
        }  
          
                 
        
        public String getMenuNo(){  
            return this.menuNo;  
        }  
       
        public void setMenuNo(String menuNo){            
           
            this.menuNo = menuNo;
                    
        }  
          
                 
        
        public String getMenuName(){  
            return this.menuName;  
        }  
       
        public void setMenuName(String menuName){            
           
            this.menuName = menuName;
                    
        }  
          
                 
        
        public String getDisplayOrder(){  
            return this.displayOrder;  
        }  
       
        public void setDisplayOrder(String displayOrder){            
           
            this.displayOrder = displayOrder;
                    
        }  
          
                 
        
        public String getMenuLevel(){  
            return this.menuLevel;  
        }  
       
        public void setMenuLevel(String menuLevel){            
           
            this.menuLevel = menuLevel;
                    
        }  
          
                 
        
        public Integer getMenuType(){  
            return this.menuType;  
        }  
       
        public void setMenuType(Integer menuType){            
           
            this.menuType = menuType;
                    
        }  
          
                 
        
        public Long getParentMenuId(){  
            return this.parentMenuId;  
        }  
       
        public void setParentMenuId(Long parentMenuId){            
           
            this.parentMenuId = parentMenuId;
                    
        }  
          
                 
        
        public String getIsLeaf(){  
            return this.isLeaf;  
        }  
       
        public void setIsLeaf(String isLeaf){            
           
            this.isLeaf = isLeaf;
                    
        }  
          
                 
        
        public String getIsButtonPower(){  
            return this.isButtonPower;  
        }  
       
        public void setIsButtonPower(String isButtonPower){            
           
            this.isButtonPower = isButtonPower;
                    
        }  
          
                 
        
        public String getIsReport(){  
            return this.isReport;  
        }  
       
        public void setIsReport(String isReport){            
           
            this.isReport = isReport;
                    
        }  
          
                 
        
        public String getPageUrl(){  
            return this.pageUrl;  
        }  
       
        public void setPageUrl(String pageUrl){            
           
            this.pageUrl = pageUrl;
                    
        }  
          
                 
        
        public String getDesigner(){  
            return this.designer;  
        }  
       
        public void setDesigner(String designer){            
           
            this.designer = designer;
                    
        }  
          
                 
        
        public String getDeveloper(){  
            return this.developer;  
        }  
       
        public void setDeveloper(String developer){            
           
            this.developer = developer;
                    
        }  
          
                 
        
        public String getContributer(){  
            return this.contributer;  
        }  
       
        public void setContributer(String contributer){            
           
            this.contributer = contributer;
                    
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

