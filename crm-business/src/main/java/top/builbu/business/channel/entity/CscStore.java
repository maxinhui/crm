package top.builbu.business.channel.entity;  

import java.util.Date;      
  
public class CscStore {  
	    /**
	     *
	     *
	    **/
        private Long storeId;  
	    /**
	     *
	     *店铺编号
	    **/
        private String storeNo;  
	    /**
	     *
	     *店铺名称
	    **/
        private String storeName;  
	    /**
	     *
	     *经销商编号
	    **/
        private String customerNo;  
	    /**
	     *
	     *所在城市
	    **/
        private String cityName;  
	    /**
	     *
	     *店铺经营性质
	    **/
        private Long storeNature;  
	    /**
	     *
	     *店铺状态
	    **/
        private Long storeStatus;  
	    /**
	     *
	     *店铺级别
	    **/
        private Long storeLevel;  
	    /**
	     *
	     *开业日期
	    **/
        private Date startDate;  
	    /**
	     *
	     *卖场面积
	    **/
        private String businessArea;  
	    /**
	     *
	     *省/直辖市
	    **/
        private Long province;  
	    /**
	     *
	     *地级市/市辖区/市辖县
	    **/
        private Long city;  
	    /**
	     *
	     *县级市/区/县
	    **/
        private Long county;  
	    /**
	     *
	     *乡/镇/街道
	    **/
        private Long town;  
	    /**
	     *
	     *详细地址
	    **/
        private String detailAddr;  
	    /**
	     *
	     *经度
	    **/
        private String longitude;  
	    /**
	     *
	     *纬度
	    **/
        private String latitude;  
	    /**
	     *
	     *所在楼层
	    **/
        private String floor;  
	    /**
	     *
	     *经营品牌
	    **/
        private String manageBrand;  
	    /**
	     *
	     *编制人数
	    **/
        private Integer planStaff;  
	    /**
	     *
	     *实际人数
	    **/
        private Integer factStaff;  
	    /**
	     *
	     *店长姓名
	    **/
        private String storeManagerName;  
	    /**
	     *
	     *店长联系电话
	    **/
        private String storeManagerTel;  
	    /**
	     *
	     *主管
	    **/
        private String supervisorName;  
	    /**
	     *
	     *客流监控(Y-有 N-无)
	    **/
        private String trafficMonitoring;  
	    /**
	     *
	     *视频监控(Y-有 N-无)
	    **/
        private String videoMonitoring;  
	    /**
	     *
	     *有效标识(Y-有效 N-作废)
	    **/
        private String validFlag;  
        
        private Long userId;
	    /**
	     *
	     *外部标识(Y-有效 N-作废)
	    **/
        private String esValidFlag;  
	    /**
	     *
	     *时间戳
	    **/
        private Date ts;  
          
          
        
        public Long getStoreId(){  
            return this.storeId;  
        }  
       
        public void setStoreId(Long storeId){            
           
            this.storeId = storeId;
                    
        }  
          
                 
        
        public String getStoreNo(){  
            return this.storeNo;  
        }  
       
        public void setStoreNo(String storeNo){            
           
            this.storeNo = storeNo;
                    
        }  
          
                 
        
        public String getStoreName(){  
            return this.storeName;  
        }  
       
        public void setStoreName(String storeName){            
           
            this.storeName = storeName;
                    
        }  
          
                 
        
        public String getCustomerNo(){  
            return this.customerNo;  
        }  
       
        public void setCustomerNo(String customerNo){            
           
            this.customerNo = customerNo;
                    
        }  
          
                 
        
        public String getCityName(){  
            return this.cityName;  
        }  
       
        public void setCityName(String cityName){            
           
            this.cityName = cityName;
                    
        }  
          
                 
        
        public Long getStoreNature(){  
            return this.storeNature;  
        }  
       
        public void setStoreNature(Long storeNature){            
           
            this.storeNature = storeNature;
                    
        }  
          
                 
        
        public Long getStoreStatus(){  
            return this.storeStatus;  
        }  
       
        public void setStoreStatus(Long storeStatus){            
           
            this.storeStatus = storeStatus;
                    
        }  
          
                 
        
        public Long getStoreLevel(){  
            return this.storeLevel;  
        }  
       
        public void setStoreLevel(Long storeLevel){            
           
            this.storeLevel = storeLevel;
                    
        }  
          
                 
        
        public Date getStartDate(){  
            return this.startDate;  
        }  
       
        public void setStartDate(Date startDate){            
           
            this.startDate = startDate;
                    
        }  
          
                 
        
        public String getBusinessArea(){  
            return this.businessArea;  
        }  
       
        public void setBusinessArea(String businessArea){            
           
            this.businessArea = businessArea;
                    
        }  
          
                 
        
        public Long getProvince(){  
            return this.province;  
        }  
       
        public void setProvince(Long province){            
           
            this.province = province;
                    
        }  
          
                 
        
        public Long getCity(){  
            return this.city;  
        }  
       
        public void setCity(Long city){            
           
            this.city = city;
                    
        }  
          
                 
        
        public Long getCounty(){  
            return this.county;  
        }  
       
        public void setCounty(Long county){            
           
            this.county = county;
                    
        }  
          
                 
        
        public Long getTown(){  
            return this.town;  
        }  
       
        public void setTown(Long town){            
           
            this.town = town;
                    
        }  
          
                 
        
        public String getDetailAddr(){  
            return this.detailAddr;  
        }  
       
        public void setDetailAddr(String detailAddr){            
           
            this.detailAddr = detailAddr;
                    
        }  
          
                 
        
        public String getLongitude(){  
            return this.longitude;  
        }  
       
        public void setLongitude(String longitude){            
           
            this.longitude = longitude;
                    
        }  
          
                 
        
        public String getLatitude(){  
            return this.latitude;  
        }  
       
        public void setLatitude(String latitude){            
           
            this.latitude = latitude;
                    
        }  
          
                 
        
        public String getFloor(){  
            return this.floor;  
        }  
       
        public void setFloor(String floor){            
           
            this.floor = floor;
                    
        }  
          
                 
        
        public String getManageBrand(){  
            return this.manageBrand;  
        }  
       
        public void setManageBrand(String manageBrand){            
           
            this.manageBrand = manageBrand;
                    
        }  
          
                 
        
        public Integer getPlanStaff(){  
            return this.planStaff;  
        }  
       
        public void setPlanStaff(Integer planStaff){            
           
            this.planStaff = planStaff;
                    
        }  
          
                 
        
        public Integer getFactStaff(){  
            return this.factStaff;  
        }  
       
        public void setFactStaff(Integer factStaff){            
           
            this.factStaff = factStaff;
                    
        }  
          
                 
        
        public String getStoreManagerName(){  
            return this.storeManagerName;  
        }  
       
        public void setStoreManagerName(String storeManagerName){            
           
            this.storeManagerName = storeManagerName;
                    
        }  
          
                 
        
        public String getStoreManagerTel(){  
            return this.storeManagerTel;  
        }  
       
        public void setStoreManagerTel(String storeManagerTel){            
           
            this.storeManagerTel = storeManagerTel;
                    
        }  
          
                 
        
        public String getSupervisorName(){  
            return this.supervisorName;  
        }  
       
        public void setSupervisorName(String supervisorName){            
           
            this.supervisorName = supervisorName;
                    
        }  
          
                 
        
        public String getTrafficMonitoring(){  
            return this.trafficMonitoring;  
        }  
       
        public void setTrafficMonitoring(String trafficMonitoring){            
           
            this.trafficMonitoring = trafficMonitoring;
                    
        }  
          
                 
        
        public String getVideoMonitoring(){  
            return this.videoMonitoring;  
        }  
       
        public void setVideoMonitoring(String videoMonitoring){            
           
            this.videoMonitoring = videoMonitoring;
                    
        }  
          
                 
        
        public String getValidFlag(){  
            return this.validFlag;  
        }  
       
        public void setValidFlag(String validFlag){            
           
            this.validFlag = validFlag;
                    
        }  
          
                 
        
        public String getEsValidFlag(){  
            return this.esValidFlag;  
        }  
       
        public void setEsValidFlag(String esValidFlag){            
           
            this.esValidFlag = esValidFlag;
                    
        }  
          
                 
        
        public Date getTs(){  
            return this.ts;  
        }  
       
        public void setTs(Date ts){            
           
            this.ts = ts;
                    
        }

		public Long getUserId() {
			return userId;
		}

		public void setUserId(Long userId) {
			this.userId = userId;
		}  
          
                 
}  

