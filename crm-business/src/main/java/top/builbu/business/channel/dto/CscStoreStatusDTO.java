package top.builbu.business.channel.dto;  

import java.util.Date;      
  
public class CscStoreStatusDTO {  
	    /**
	     *
	     *级别主键
	    **/
        private Long statusId;  
	    /**
	     *
	     *外部系统对应主键
	    **/
        private String esrowId;  
	    /**
	     *
	     *显示顺序
	    **/
        private Integer sequenceId;  
	    /**
	     *
	     *级别名称
	    **/
        private String statusName;  
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
          
          
        public Long getStatusId(){  
            return this.statusId;  
        }  
       
        public void setStatusId(Long statusId){  
            this.statusId = statusId;
        } 
         
        public String getEsrowId(){  
            return this.esrowId;  
        }  
       
        public void setEsrowId(String esrowId){  
            this.esrowId = esrowId == "" ? null : esrowId.trim();
        } 
         
        public Integer getSequenceId(){  
            return this.sequenceId;  
        }  
       
        public void setSequenceId(Integer sequenceId){  
            this.sequenceId = sequenceId;
        } 
         
        public String getStatusName(){  
            return this.statusName;  
        }  
       
        public void setStatusName(String statusName){  
            this.statusName = statusName == "" ? null : statusName.trim();
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