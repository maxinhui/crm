package top.builbu.business.system.dto;  

import java.util.Date;

  
  
public class SmButtonDTO {  
	    /**
	     *
	     *按钮主键
	    **/
        private Long buttonId;  
	    /**
	     *
	     *按钮编号
	    **/
        private String buttonNo;  
	    /**
	     *
	     *按钮名称
	    **/
        private String buttonName;  
	    /**
	     *
	     *按钮类型(预留)
	    **/
        private String buttonType;  
	    /**
	     *
	     *所属菜单主键
	    **/
        private Long menuId;  
	    /**
	     *
	     *按钮访问路径
	    **/
        private String buttonUrl;  
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
          
          
        public Long getButtonId(){  
            return this.buttonId;  
        }  
       
        public void setButtonId(Long buttonId){  
            this.buttonId = buttonId;
        } 
         
        public String getButtonNo(){  
            return this.buttonNo;  
        }  
       
        public void setButtonNo(String buttonNo){  
            this.buttonNo = buttonNo == "" ? null : buttonNo.trim();
        } 
         
        public String getButtonName(){  
            return this.buttonName;  
        }  
       
        public void setButtonName(String buttonName){  
            this.buttonName = buttonName == "" ? null : buttonName.trim();
        } 
         
        public String getButtonType(){  
            return this.buttonType;  
        }  
       
        public void setButtonType(String buttonType){  
            this.buttonType = buttonType == "" ? null : buttonType.trim();
        } 
         
        public Long getMenuId(){  
            return this.menuId;  
        }  
       
        public void setMenuId(Long menuId){  
            this.menuId = menuId;
        } 
         
        public String getButtonUrl(){  
            return this.buttonUrl;  
        }  
       
        public void setButtonUrl(String buttonUrl){  
            this.buttonUrl = buttonUrl == "" ? null : buttonUrl.trim();
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