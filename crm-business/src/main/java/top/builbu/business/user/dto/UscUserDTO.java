package top.builbu.business.user.dto;  

import java.util.Date;

    
  
public class UscUserDTO {  
	    /**
	     *
	     *用户主键
	    **/
        private Long userId;  
	    /**
	     *
	     *用户编号*
	    **/
        private String userNo;  
	    /**
	     *
	     *用户昵称
	    **/
        private String nickName;  
	    /**
	     *
	     *用户名称
	    **/
        private String userName;  
	    /**
	     *
	     *登录密码
	    **/
        private String password;  
	    /**
	     *
	     *用户性别
	    **/
        private String gender;  
	    /**
	     *
	     *身份证号码
	    **/
        private String idCardNo;  
	    /**
	     *
	     *数据权限*
	    **/
        private Integer dataAuthority;  
	    /**
	     *
	     *用户所属部门主键
	    **/
        private Long deptId;  
	    /**
	     *
	     *手机号码
	    **/
        private String mobileNo;  
	    /**
	     *
	     *电子邮箱
	    **/
        private String emailNo;  
	    /**
	     *
	     *生日
	    **/
        private Date birthday;  
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
        private String address;  
	    /**
	     *
	     *用户类型*
	    **/
        private Integer userType;  
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
	     *锁定标识(Y-锁定 N-未锁定)
	    **/
        private String lockFlag;  
	    /**
	     *
	     *创建日期
	    **/
        private Integer createDate;  
	    /**
	     *
	     *时间戳
	    **/
        private Date ts;  



	
          
//        public UscUserDTO(UscUserDTO user) {
//               this.userId = user.getUserId();  
//   	           this.userNo = user.getUserNo();  
//   	           this.nickName = user.getNickName();  
//   	           this.userName = user.getUserName();  
//   	           this.password = user.getPassword();  
//   	           this.gender = user.getGender();  
//   	           this.idCardNo = user.getIdCardNo();  
//   	           this.dataAuthority = user.getDataAuthority();  
//   	           this.deptId = user.getDeptId();  
//   	           this.mobileNo = user.getMobileNo();  
//   	           this.emailNo = user.getEmailNo();  
//   	           this.birthday = user.getBirthday();  
//   	           this.province = user.getProvince();  
//   	           this.city = user.getCity();  
//   	           this.county = user.getCounty();  
//   	           this.town = user.getTown();  
//   	           this.address = user.getAddress();  
//   	           this.userType = user.getUserType();  
//   	           this.remark = user.getRemark();  
//   	           this.validFlag = user.getValidFlag();  
//   	           this.lockFlag = user.getLockFlag();  
//   	           this.createDate = user.getCreateDate();  
//   	           this.ts = user.getTs();   
//        	
//		}

		public Long getUserId(){  
            return this.userId;  
        }  
       
        public void setUserId(Long userId){  
            this.userId = userId;
        } 
         
        public String getUserNo(){  
            return this.userNo;  
        }  
       
        public void setUserNo(String userNo){  
            this.userNo = userNo == null ? null : userNo.trim();
        } 
         
        public String getNickName(){  
            return this.nickName;  
        }  
       
        public void setNickName(String nickName){  
            this.nickName = nickName == null ? null : nickName.trim();
        } 
         
        public String getUserName(){  
            return this.userName;  
        }  
       
        public void setUserName(String userName){  
            this.userName = userName == null ? null : userName.trim();
        } 
         
        public String getPassword(){  
            return this.password;  
        }  
       
        public void setPassword(String password){  
            this.password = password == null ? null : password.trim();
        } 
         
        public String getGender(){  
            return this.gender;  
        }  
       
        public void setGender(String gender){  
            this.gender = gender == null ? null : gender.trim();
        } 
         
        public String getIdCardNo(){  
            return this.idCardNo;  
        }  
       
        public void setIdCardNo(String idCardNo){  
            this.idCardNo = idCardNo == null ? null : idCardNo.trim();
        } 
         
        public Integer getDataAuthority(){  
            return this.dataAuthority;  
        }  
       
        public void setDataAuthority(Integer dataAuthority){  
            this.dataAuthority = dataAuthority;
        } 
         
        public Long getDeptId(){  
            return this.deptId;  
        }  
       
        public void setDeptId(Long deptId){  
            this.deptId = deptId;
        } 
         
        public String getMobileNo(){  
            return this.mobileNo;  
        }  
       
        public void setMobileNo(String mobileNo){  
            this.mobileNo = mobileNo == null ? null : mobileNo.trim();
        } 
         
        public String getEmailNo(){  
            return this.emailNo;  
        }  
       
        public void setEmailNo(String emailNo){  
            this.emailNo = emailNo == null ? null : emailNo.trim();
        } 
         
        public Date getBirthday(){  
            return this.birthday;  
        }  
       
        public void setBirthday(Date birthday){  
            this.birthday = birthday;
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
         
        public String getAddress(){  
            return this.address;  
        }  
       
        public void setAddress(String address){  
            this.address = address == null ? null : address.trim();
        } 
         
        public Integer getUserType(){  
            return this.userType;  
        }  
       
        public void setUserType(Integer userType){  
            this.userType = userType;
        } 
         
        public String getRemark(){  
            return this.remark;  
        }  
       
        public void setRemark(String remark){  
            this.remark = remark == null ? null : remark.trim();
        } 
         
        public String getValidFlag(){  
            return this.validFlag;  
        }  
       
        public void setValidFlag(String validFlag){  
            this.validFlag = validFlag == null ? null : validFlag.trim();
        } 
         
        public String getLockFlag(){  
            return this.lockFlag;  
        }  
       
        public void setLockFlag(String lockFlag){  
            this.lockFlag = lockFlag == null ? null : lockFlag.trim();
        } 
         
        public Integer getCreateDate(){  
            return this.createDate;  
        }  
       
        public void setCreateDate(Integer createDate){  
            this.createDate = createDate;
        } 
         
        public Date getTs(){  
            return this.ts;  
        }  
       
        public void setTs(Date ts){  
            this.ts = ts;
        } 
         
}  