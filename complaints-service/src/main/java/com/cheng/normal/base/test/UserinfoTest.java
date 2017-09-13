package com.cheng.normal.base.test;

import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.UUID;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cheng.normal.base.domain.Role;
import com.cheng.normal.base.domain.Userinfo;
import com.cheng.normal.base.enums.StatusEnums;
import com.cheng.normal.base.mapper.RoleMapper;
import com.cheng.normal.base.service.IUserinfoService;
import com.cheng.normal.base.util.MD5;
import com.cheng.normal.base.util.NumberConst;


/**
 * @author cheng
 * @date 2017年8月16日 上午11:28:46
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class UserinfoTest {
	@Autowired
	private IUserinfoService userinfoService;
	@Autowired
	private RoleMapper roleMapper;

	@Test
	public void insertUserinfoTest() throws Exception {
		/*Userinfo entity = new Userinfo(UUID.randomUUID().toString(), "cheng", MD5.encode("cheng"+"000000"), "炜程", true, 13800138000L, null, NumberConst.NUM_INT_ZERO, null, "admin",
				new Date(), "admin", new Date(), StatusEnums.UserStatus.ENABLED.getCode(), NumberConst.NUM_LONG_ZERO, true, "<备注信息>");*/
		String[] usernameArrs=new String[]{"Harry","Kate","Charlotter","Catherine","George","tom","mike","luck","ken","jack","jay","Jenson","Stanley","Kai","Darcie"};
		for (int i = 0; i < 30; i++) {
			String username="";
			if(i<15){
				username=usernameArrs[i];
			}else{
				username="test"+(i-14);
			}
			int randomNum = new Random().nextInt(900)+100;
			boolean result=false;
			boolean result2=false;
			if(randomNum>500){
				result=true;
			}
			if((randomNum>100&&randomNum<300)||(randomNum>500&&randomNum<800)){
				result2=true;
			}
			//随机日期
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
            Date start = format.parse("2017-1-1 00:00:01");// 构造开始日期  
            Date end = format.parse("2017-8-20 23:59:59");// 构造结束日期
            long rtn = start.getTime() + (long) (Math.random() * (end.getTime() - start.getTime())); 
            
			Userinfo entity = new Userinfo(UUID.randomUUID().toString(), username, MD5.encode(username+"000000"), username+"CN", result, 13800138000L+randomNum, null, NumberConst.NUM_INT_ZERO, null, "cheng",
					new Date(rtn), "cheng", new Date(rtn), StatusEnums.UserStatus.ENABLED.getCode(), NumberConst.NUM_LONG_ZERO, result2, "<备注信息>");
//			int resultCount = userinfoService.insertEntity(entity);
//			if(resultCount==1){
//				System.out.println("执行成功:"+i);
//			}
		}
	}
	
	@Test
	public void selectUserinfoTest() throws Exception {
		System.out.println(userinfoService.selectAll());
		
	}
	
	@Test
	public void insertRoleTest() throws Exception {
		Role role = new Role(null, "admin", 9, "管理员", 1, "system", new Date(), "system", new Date(), true);
		roleMapper.insertSelective(role);
	}
}