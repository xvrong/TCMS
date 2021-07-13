/*
 * @Author: xv_rong
 * 
 * @Date: 2021-07-10 16:50:40
 * 
 * @LastEditors: xv_rong
 * 
 * @LastEditTime: 2021-07-10 16:51:05
 * 
 * @Description: calculate age
 * 
 * @FilePath: \TCMS\src\Tool\calAge.java
 */
package Tool;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class calAge {
    public static int getAge(String birth) throws ParseException {
        //String str="2012-5-27";
        SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");
        Date date =sdf.parse(birth);
        Calendar c2 = Calendar.getInstance();
        c2.setTime(date);
        Calendar c1=Calendar.getInstance();
        //System.out.print(c1.get(Calendar.YEAR)-c2.get(Calendar.YEAR));
        return c1.get(Calendar.YEAR)-c2.get(Calendar.YEAR);

    }
}
