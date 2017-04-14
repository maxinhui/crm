package top.builbu.business.user.entity;  

import java.util.Date;

    
  
public class UscMember {  
	    /**
	     *
	     *会员主键*
	    **/
        private Long memberId;  
	    /**
	     *
	     *创建店铺*
	    **/
        private String createStore;  
	    /**
	     *
	     *归属店铺*
	    **/
        private String belongStore;  
	    /**
	     *
	     *会员卡号
	    **/
        private String cardNo;  
	    /**
	     *
	     *会员等级*
	    **/
        private Integer memberLevel;  
	    /**
	     *
	     *会员头像
	    **/
        private String memberImage;  
	    /**
	     *
	     *来源渠道一级分类
	    **/
        private String firstClassify;  
	    /**
	     *
	     *来源渠道二级分类
	    **/
        private String secondClassify;  
	    /**
	     *
	     *来源渠道三级分类
	    **/
        private String thirdClassify;  
	    /**
	     *
	     *最近一次消费日期
	    **/
        private Date lastBuyDate;  
	    /**
	     *
	     *创建日期*
	    **/
        private Date createDate;  
	    /**
	     *
	     *会员状态*
	    **/
        private Integer memberStatus;  
	    /**
	     *
	     *时间戳
	    **/
        private Date ts;  
          
          
        
        public Long getMemberId(){  
            return this.memberId;  
        }  
       
        public void setMemberId(Long memberId){            
           
            this.memberId = memberId;
                    
        }  
          
                 
        
        public String getCreateStore(){  
            return this.createStore;  
        }  
       
        public void setCreateStore(String createStore){            
           
            this.createStore = createStore;
                    
        }  
          
                 
        
        public String getBelongStore(){  
            return this.belongStore;  
        }  
       
        public void setBelongStore(String belongStore){            
           
            this.belongStore = belongStore;
                    
        }  
          
                 
        
        public String getCardNo(){  
            return this.cardNo;  
        }  
       
        public void setCardNo(String cardNo){            
           
            this.cardNo = cardNo;
                    
        }  
          
                 
        
        public Integer getMemberLevel(){  
            return this.memberLevel;  
        }  
       
        public void setMemberLevel(Integer memberLevel){            
           
            this.memberLevel = memberLevel;
                    
        }  
          
                 
        
        public String getMemberImage(){  
            return this.memberImage;  
        }  
       
        public void setMemberImage(String memberImage){            
           
            this.memberImage = memberImage;
                    
        }  
          
                 
        
        public String getFirstClassify(){  
            return this.firstClassify;  
        }  
       
        public void setFirstClassify(String firstClassify){            
           
            this.firstClassify = firstClassify;
                    
        }  
          
                 
        
        public String getSecondClassify(){  
            return this.secondClassify;  
        }  
       
        public void setSecondClassify(String secondClassify){            
           
            this.secondClassify = secondClassify;
                    
        }  
          
                 
        
        public String getThirdClassify(){  
            return this.thirdClassify;  
        }  
       
        public void setThirdClassify(String thirdClassify){            
           
            this.thirdClassify = thirdClassify;
                    
        }  
          
                 
        
        public Date getLastBuyDate(){  
            return this.lastBuyDate;  
        }  
       
        public void setLastBuyDate(Date lastBuyDate){            
           
            this.lastBuyDate = lastBuyDate;
                    
        }  
          
                 
        
        public Date getCreateDate(){  
            return this.createDate;  
        }  
       
        public void setCreateDate(Date createDate){            
           
            this.createDate = createDate;
                    
        }  
          
                 
        
        public Integer getMemberStatus(){  
            return this.memberStatus;  
        }  
       
        public void setMemberStatus(Integer memberStatus){            
           
            this.memberStatus = memberStatus;
                    
        }  
          
                 
        
        public Date getTs(){  
            return this.ts;  
        }  
       
        public void setTs(Date ts){            
           
            this.ts = ts;
                    
        }  
          
                 
}  

