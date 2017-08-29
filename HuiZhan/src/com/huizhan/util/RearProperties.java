package  com.huizhan.util;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class RearProperties {
	Properties props = new Properties();
	public String  getpath(String name) {
		  String path="";
		  try {
		   props.load(getClass().getClassLoader().getResourceAsStream(
		     "FilePaths.properties"));
		   path=props.getProperty(name);
		  } catch (Exception e) {
		   e.printStackTrace();
		  }
		return path;
	}
	/**
	 * 根据文件名和key得到value
	 * @param filename
	 * @param name
	 * @return
	 */
	public String getValue(String filename,String name) {
		  String value="";
		  try {
		       props.load(getClass().getClassLoader().getResourceAsStream(filename));
		       value=props.getProperty(name);
		  } catch (Exception e) {
		      e.printStackTrace();
		  }
		return value;
	}
	/**
	 * 根据文件名得到map
	 * @param filePath
	 * @return map
	 */
    @SuppressWarnings("unchecked")
	public Map readInMap(String filePath){
		Map<String,String> map = new HashMap<String,String>();
        try {
            props.load(getClass().getClassLoader().getResourceAsStream(filePath));
            Enumeration en = props.propertyNames();
             while (en.hasMoreElements()) {
                 String key = (String) en.nextElement();
                 String property = props.getProperty(key);
                 map.put(key,property);
             }
             props.clear();
             
        } catch (Exception e) {
           e.printStackTrace();
        }
		return map;
	}
	public static void main(String[] args) {
		RearProperties a = new RearProperties();
		String b = a.getpath("address");
		System.out.println(b);
	}
}
