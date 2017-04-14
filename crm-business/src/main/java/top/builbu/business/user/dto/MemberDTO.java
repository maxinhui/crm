package top.builbu.business.user.dto;

import java.util.Date;



public class MemberDTO {

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
   private Date createDate;  
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
   *会员状态*
  **/
  private Integer memberStatus;  

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
  */
 private String loginNo;
public Long getUserId() {
	return userId;
}
public void setUserId(Long userId) {
	this.userId = userId;
}
public String getUserNo() {
	return userNo;
}
public void setUserNo(String userNo) {
	this.userNo = userNo;
}
public String getNickName() {
	return nickName;
}
public void setNickName(String nickName) {
	this.nickName = nickName;
}
public String getUserName() {
	return userName;
}
public void setUserName(String userName) {
	this.userName = userName;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getGender() {
	return gender;
}
public void setGender(String gender) {
	this.gender = gender;
}
public String getIdCardNo() {
	return idCardNo;
}
public void setIdCardNo(String idCardNo) {
	this.idCardNo = idCardNo;
}
public Integer getDataAuthority() {
	return dataAuthority;
}
public void setDataAuthority(Integer dataAuthority) {
	this.dataAuthority = dataAuthority;
}
public Long getDeptId() {
	return deptId;
}
public void setDeptId(Long deptId) {
	this.deptId = deptId;
}
public String getMobileNo() {
	return mobileNo == "" ? null : mobileNo;
}
public void setMobileNo(String mobileNo) {
	this.mobileNo = mobileNo;
}
public String getEmailNo() {
	return emailNo;
}
public void setEmailNo(String emailNo) {
	this.emailNo = emailNo;
}
public Date getBirthday() {
	return birthday;
}
public void setBirthday(Date birthday) {
	this.birthday = birthday;
}
public Long getProvince() {
	return province;
}
public void setProvince(Long province) {
	this.province = province;
}
public Long getCity() {
	return city;
}
public void setCity(Long city) {
	this.city = city;
}
public Long getCounty() {
	return county;
}
public void setCounty(Long county) {
	this.county = county;
}
public Long getTown() {
	return town;
}
public void setTown(Long town) {
	this.town = town;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public Integer getUserType() {
	return userType;
}
public void setUserType(Integer userType) {
	this.userType = userType;
}
public String getRemark() {
	return remark;
}
public void setRemark(String remark) {
	this.remark = remark;
}
public String getValidFlag() {
	return validFlag;
}
public void setValidFlag(String validFlag) {
	this.validFlag = validFlag;
}
public String getLockFlag() {
	return lockFlag;
}
public void setLockFlag(String lockFlag) {
	this.lockFlag = lockFlag;
}
public Date getCreateDate() {
	return createDate;
}
public void setCreateDate(Date createDate) {
	this.createDate = createDate;
}
public Long getMemberId() {
	return memberId;
}
public void setMemberId(Long memberId) {
	this.memberId = memberId;
}
public String getCreateStore() {
	return createStore;
}
public void setCreateStore(String createStore) {
	this.createStore = createStore;
}
public String getBelongStore() {
	return belongStore;
}
public void setBelongStore(String belongStore) {
	this.belongStore = belongStore;
}
public String getCardNo() {
	return cardNo;
}
public void setCardNo(String cardNo) {
	this.cardNo = cardNo;
}
public Integer getMemberLevel() {
	return memberLevel;
}
public void setMemberLevel(Integer memberLevel) {
	this.memberLevel = memberLevel;
}
public String getMemberImage() {
	return memberImage;
}
public void setMemberImage(String memberImage) {
	this.memberImage = memberImage;
}
public String getFirstClassify() {
	return firstClassify;
}
public void setFirstClassify(String firstClassify) {
	this.firstClassify = firstClassify;
}
public String getSecondClassify() {
	return secondClassify;
}
public void setSecondClassify(String secondClassify) {
	this.secondClassify = secondClassify;
}
public String getThirdClassify() {
	return thirdClassify;
}
public void setThirdClassify(String thirdClassify) {
	this.thirdClassify = thirdClassify;
}
public Date getLastBuyDate() {
	return lastBuyDate;
}
public void setLastBuyDate(Date lastBuyDate) {
	this.lastBuyDate = lastBuyDate;
}
public Integer getMemberStatus() {
	return memberStatus;
}
public void setMemberStatus(Integer memberStatus) {
	this.memberStatus = memberStatus;
}
public String getPublicNo() {
	return publicNo;
}
public void setPublicNo(String publicNo) {
	this.publicNo = publicNo;
}
public String getOpenId() {
	return openId;
}
public void setOpenId(String openId) {
	this.openId = openId;
}
public String getIsSub() {
	return isSub;
}
public void setIsSub(String isSub) {
	this.isSub = isSub;
}
public String getLoginNo() {
	return loginNo;
}
public void setLoginNo(String loginNo) {
	this.loginNo = loginNo;
}

 
 
}
