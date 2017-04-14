package top.builbu.business.shiro.service.impl;

import java.util.Set;

import top.builbu.business.system.dto.SmMenuDTO;

public class listTemp {

    static String listTP = "";
    static String bs = "http://localhost:8080/crm-website";
//    <ul class="menu-items" data-tit="设置" data-faicon="list">'+
//    '<li><a href="${request.contextPath}/smRole/selectByList" data-options="{id:"smRoleList", faicon:'hand-o-up'}">角色权限管理</a><b><i class="fa fa-angle-down"></i></b></li>
//    <li><a href="${request.contextPath}/smRoleFunc/selectByInfo?parentMenuId=0&validFlag=Y" data-options="{id:'smButtnList', faicon:'caret-square-o-down'}">菜单权限管理</a></li>
//</ul>
//
//<ul class="menu-items" data-tit="人员管理" data-faicon="list">
//    <li><a href="${request.contextPath}/uscUser/selectByList?userType=1" data-options="{id:'uscUserList', faicon:'th-large'}">管理员管理</a></li>
//</ul>

   public static String listT(Set<SmMenuDTO> result){
	   for(SmMenuDTO dto : result){
		   if("1".equals(dto.getMenuLevel())){
			   listTP += "<ul class='menu-items' data-tit='"+dto.getMenuName()+"' data-faicon='list'>";
			   
			   for(SmMenuDTO dto1 : result){
				   if("2".equals(dto1.getMenuLevel())){
					   if("/smRoleFunc/selectByInfo".equals(dto1.getPageUrl())){
				           listTP += "<li><a href='"+bs+dto1.getPageUrl()+"?parentMenuId=0&validFlag=Y' data-options='{id:"+dto1.getPageUrl().split("\\/")[1]+"List, faicon:hand-o-up}'>"+dto1.getMenuName()+"</a><b><i class='fa fa-angle-down'></i></b></li>";
					   }else if("/uscUser/selectByList".equals(dto1.getPageUrl())){
						   listTP += "<li><a href='"+bs+dto1.getPageUrl()+"?userType=1' data-options='{id:'"+dto1.getPageUrl().split("\\/")[1]+"List', faicon:'hand-o-up'}'>"+dto1.getMenuName()+"</a><b><i class='fa fa-angle-down'></i></b></li>";   
					   }else{
						   listTP += "<li><a href='"+bs+dto1.getPageUrl()+"' data-options='{id:'"+dto1.getPageUrl().split("\\/")[1]+"List', faicon:'hand-o-up'}'>"+dto1.getMenuName()+"</a><b><i class='fa fa-angle-down'></i></b></li>";   
					   }
					   
				   }
			   }
			   listTP += "</ul>";
		   }
	   }
	   return listTP;
   }
}
