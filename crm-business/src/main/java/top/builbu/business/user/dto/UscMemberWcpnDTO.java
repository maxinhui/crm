package top.builbu.business.user.dto;  

import java.util.Date;      
  
public class UscMemberWcpnDTO {  
	    /**
	     *
	     *记录行主键
	    **/
        private Long rowId;  
	    /**
	     *
	     *会员主键
	    **/
        private Long memberId;  
	    /**
	     *
	     *微信公众号编码
	    **/
        private String publicNo;  
	    /**
	     *
	     *对应微信公众号ID
	    **/
        private String openId;  
	    /**
	     *
	     *是否关注
	    **/
        private String isSub;  
	    /**
	     *
	     *备注说明
	    **/
        private String remark;  
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
         
        public Long getMemberId(){  
            return this.memberId;  
        }  
       
        public void setMemberId(Long memberId){  
            this.memberId = memberId;
        } 
         
        public String getPublicNo(){  
            return this.publicNo;  
        }  
       
        public void setPublicNo(String publicNo){  
            this.publicNo = publicNo == null ? null : publicNo.trim();
        } 
         
        public String getOpenId(){  
            return this.openId;  
        }  
       
        public void setOpenId(String openId){  
            this.openId = openId == null ? null : openId.trim();
        } 
         
        public String getIsSub(){  
            return this.isSub;  
        }  
       
        public void setIsSub(String isSub){  
            this.isSub = isSub == null ? null : isSub.trim();
        } 
         
        public String getRemark(){  
            return this.remark;  
        }  
       
        public void setRemark(String remark){  
            this.remark = remark == null ? null : remark.trim();
        } 
         
        public Date getTs(){  
            return this.ts;  
        }  
       
        public void setTs(Date ts){  
            this.ts = ts;
        } 
         
}  