package top.builbu.business.shiro.service.impl;

import java.util.HashSet;
import java.util.Set;

import lombok.extern.slf4j.Slf4j;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import top.builbu.business.system.dto.SmButtonDTO;
import top.builbu.business.system.dto.SmMenuDTO;
import top.builbu.business.system.dto.SmRoleDTO;
import top.builbu.business.system.service.SmButtonService;
import top.builbu.business.system.service.SmMenuService;
import top.builbu.business.system.service.SmRoleService;
import top.builbu.business.user.dto.MemberDTO;
import top.builbu.business.user.dto.UscUserDTO;
import top.builbu.business.user.service.UscUserService;
import top.builbu.common.dto.ResultDO;
import top.builbu.common.dto.UserCode;
import top.builbu.common.util.SHA1;

@Slf4j  
@Service
public class UserRealmServiceImpl extends AuthorizingRealm {

	    @Autowired
	    private UscUserService uscUserService;
	
	    @Autowired
	    private SmRoleService smRoleService;
	    
	    @Autowired
	    private SmMenuService smMenuService;
	    
	    @Autowired
	    private SmButtonService smButtonService;
		@Override
		protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
			// String username = (String) principals.getPrimaryPrincipal();  
			
			MemberDTO memberDTO = (MemberDTO) SecurityUtils.getSubject().getSession().getAttribute(UserCode.LOGINUSER);
			log.info(memberDTO.getUserId()+"");
		        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo(); 
		        ResultDO<Set<SmRoleDTO>> roleSet = smRoleService.selectByUserId(memberDTO.getUserId());
		        ResultDO<Set<SmMenuDTO>> menuSet = null;
		        ResultDO<Set<SmButtonDTO>> buttonSet = null;
		        Set<SmMenuDTO> setMenu = null;
		        Set<String> role = null;
		        Set<String> permissions = null;
		        if(roleSet.isSuccess()){
		        	setMenu = new HashSet<SmMenuDTO>();
		        	role = new HashSet<String>();
		        	permissions =  new HashSet<String>();
	                for(SmRoleDTO roleDTO : roleSet.getModule()){
	                	role.add(roleDTO.getRoleName());
	                	menuSet = smMenuService.selectByRoleId(roleDTO.getRoleId());
	                	if(menuSet.isSuccess()){
	                		for(SmMenuDTO menuDTO : menuSet.getModule()){
	                			setMenu.add(menuDTO);
	                			log.info(menuDTO.getPageUrl());
	                			permissions.add(menuDTO.getPageUrl());
	                		}
	                	}
	                	buttonSet = smButtonService.selectyByRoleId(roleDTO.getRoleId());
	                	if(buttonSet.isSuccess()){
	                		for(SmButtonDTO buttonDTO : buttonSet.getModule()){
	                			log.info(buttonDTO.getButtonUrl());
	                			permissions.add(buttonDTO.getButtonUrl());
	                		}
	                	}
	                }
	                this.setSession("setTP", setMenu);
	                authorizationInfo.setRoles(role);
	                authorizationInfo.setStringPermissions(permissions);
		        }
		        return authorizationInfo;  
		}

		
		@Override
		protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken) throws AuthenticationException {
			 UsernamePasswordToken token = (UsernamePasswordToken)authcToken;  
			 String loginName = String.valueOf(token.getUsername());
			 String passWord = String.valueOf(token.getPassword());
			 MemberDTO resultDTO = null;
			 ResultDO<MemberDTO> result = uscUserService.login(loginName, passWord);
			
			 if (result.isSuccess()) {  
				 resultDTO = result.getModule();
		        }else{
		        	log.info("NO USER");
		            throw new UnknownAccountException();//没找到帐号  
		        }  
			 if("Y".equals(resultDTO.getLockFlag())) {  
		            throw new LockedAccountException(); //帐号锁定  
		        }  
			 log.info(resultDTO.getUserName());
//			  //交给AuthenticatingRealm使用CredentialsMatcher进行密码匹配，如果觉得人家的不好可以自定义实现  
		        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(  
		        		resultDTO.getUserName(), //用户名  
		        		resultDTO.getPassword(), //密码  
		                getName()  //realm name  
		        );
		        this.setSession(UserCode.LOGINUSER, resultDTO);
		        return authenticationInfo; 
			
		}  
	  
	
		/** 
	     * 将一些数据放到ShiroSession中,以便于其它地方使用 
	     * @see  比如Controller,使用时直接用HttpSession.getAttribute(key)就可以取到 
	     */  
	    private void setSession(Object key, Object value){  
	        Subject currentUser = SecurityUtils.getSubject();  
	        if(null != currentUser){  
	            Session session = currentUser.getSession();  
	            System.out.println("Session默认超时时间为[" + session.getTimeout() + "]毫秒");  
	            if(null != session){  
	                session.setAttribute(key, value);  
	            }  
	        }  
	    } 
	  
	    /**
	     * 清空当前用户权限信息
	     */
		public  void clearCachedAuthorizationInfo() {
			PrincipalCollection principalCollection = SecurityUtils.getSubject().getPrincipals();
			SimplePrincipalCollection principals = new SimplePrincipalCollection(
					principalCollection, getName());
			super.clearCachedAuthorizationInfo(principals);
		}
		/**
		 * 指定principalCollection 清除
		 */
		public void clearCachedAuthorizationInfo(PrincipalCollection principalCollection) {
			SimplePrincipalCollection principals = new SimplePrincipalCollection(
					principalCollection, getName());
			super.clearCachedAuthorizationInfo(principals);
		}
	    
	}

