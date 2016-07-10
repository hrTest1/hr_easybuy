package sdkd.com.ec.util;

import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * Created by sdust on 2016/7/10.
 */
public class DateUtil {
    public static String parseDateToStr(Date date, String format)
    {
        SimpleDateFormat sdf=new SimpleDateFormat(format);
        String dateStr=sdf.format(date);
        return dateStr;
    }
}
