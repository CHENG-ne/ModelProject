package com.cheng.normal.base.enums;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

/**
 * @author cheng
 * @date 2017年8月17日  上午11:07:27
 */
public class StatusEnums {

	/**
	 * 用户状态
	 * @author cheng
	 * @date 2017年8月17日  上午11:09:12
	 */
    public enum UserStatus {
    	/**生效*/
    	ENABLED("00", "生效"),
    	/**冻结*/
    	BLOCK("01", "冻结"),
    	/**关闭*/
    	CLOSE("99", "关闭") ;

        /** 枚举代码 */
        private String code;
        /** 枚举值名称 */
        private String desc;

        public String getCode() {
            return code;
        }

        public String getDesc() {
            return desc;
        }
        /**
         * 私有构造函数
         * @param code  枚举代码
         * @param desc 枚举值名称
         */
        private UserStatus(String code, String desc) {
            this.code = code;
            this.desc = desc;
        }

        /**
         * 根据枚举代码获取枚举对象，如果code对应的枚举不存在，则返回null
         * @param code 枚举代码
         * @return     对应的枚举对象
         */
        public static UserStatus getByCode(String code) {
            for (UserStatus enumObject : UserStatus.values()) {
                if (StringUtils.equals(code, enumObject.getCode())) {
                    return enumObject;
                }
            }
            return null;
        }

        /**
        * 作为数据字典Map返回
        * 
        * @return 枚举值map
        */
        public static Map<String, String> getDictMap() {
            Map<String, String> map = new HashMap<String, String>();
            UserStatus[] arr = UserStatus.values();
            for (int i = 0; i < arr.length; i++) {
                map.put(arr[i].getCode(), arr[i].getDesc());
            }
            return map;

        }
        
        /**
         * 作为数据字典列表返回
         * 
         * @return 枚举值list
         */
        public static List<Map<String, String>> getDict() {
        	
        	List<Map<String, String>> list = new ArrayList<Map<String, String>>();
        	UserStatus[] arr = UserStatus.values();
        	for (int i = 0; i < arr.length; i++) {
        		Map<String, String> map = new HashMap<String, String>();
        		map.put(arr[i].getCode(), arr[i].getDesc());
        		list.add(map);
        	}
        	return list;
        	
        }
    }
}
