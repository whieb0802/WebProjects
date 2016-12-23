package service;


import java.sql.Time;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

import javassist.expr.NewArray;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.whieb.digitalhome.service.ParameterService;
import com.whieb.digitalhome.util.Parameter;

public class ParameterServiceTest {
	
	private static ParameterService ps;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		try {
			ApplicationContext cxt = new ClassPathXmlApplicationContext("beans*.xml");
			ps = (ParameterService)cxt.getBean("parameterService");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testAdd(){
		int topN = ps.getTopN();
		System.out.println(ps.getConfig().getValue(Parameter.ASSOCIATION_MINCONFIDENCE));
		System.out.println(topN);
	}
	
	@Test
	public void testTime(){
		Date date = new Date();
//		Timestamp timestamp = new Timestamp(time)
		Date date2 = nDaysAfterOneDate(date, 0);
		date2.toString();
        SimpleDateFormat   df   =   new   SimpleDateFormat("yyyy-MM-dd");
		System.out.println(date2);
	}
	
	public   String   nDaysAfterOneDateString(String   basicDate,int   n)   {  
        SimpleDateFormat   df   =   new   SimpleDateFormat("yyyy-MM-dd");  
        Date   tmpDate   =   null;  
        try   {  
            tmpDate   =   df.parse(basicDate);  
        }  
        catch(Exception   e){  
            //   日期型字符串格式错误  
        }  
        long   nDay=(tmpDate.getTime()/(24*60*60*1000)+1+n)*(24*60*60*1000);  
        tmpDate.setTime(nDay);  
 
        return   df.format(tmpDate);  
    }  

	   //   给定一个日期，返回加减n天后的日期  
    public   Date   nDaysAfterOneDate(Date   basicDate,int   n)   {  
        long   nDay=(basicDate.getTime()/(24*60*60*1000)+1+n)*(24*60*60*1000);  
        basicDate.setTime(nDay);  
 
        return   basicDate;  
    }  

	

}
