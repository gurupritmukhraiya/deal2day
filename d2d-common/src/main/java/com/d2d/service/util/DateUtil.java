package com.d2d.service.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {
	
	private static SimpleDateFormat[] possibleFormats = new SimpleDateFormat[] {
			  new SimpleDateFormat("yyyy-MM-dd"),
			  new SimpleDateFormat("dd-MM-yyyy"),
			  new SimpleDateFormat("dd/MM/yyyy"),
			  new SimpleDateFormat("yyyy,MM,dd"),
			  new SimpleDateFormat("yyyy,MM,dd,HH,mm"),
			  new SimpleDateFormat("MM/dd/yyyy")};
	
	static{
		for (SimpleDateFormat format: possibleFormats){
			format.setLenient(false);
		}
	}
	
    public static long MM_DD_YYYY_TO_MILIS(String MM_DD_YYYY) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd/yyyy");
        try {
            Date date = simpleDateFormat.parse(MM_DD_YYYY);
            return date.getTime();
        }
        catch (ParseException e) {
            e.printStackTrace();
            return 0;
        }
    }
    
    public static long E_MMM_dd_HH_mm_ss_Z_yyyy_TO_MILIS(String E_MMM_dd_HH_mm_ss_Z_yyyy) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("E MMM dd HH:mm:ss Z yyyy");
        try {
            Date date = simpleDateFormat.parse(E_MMM_dd_HH_mm_ss_Z_yyyy);
            return date.getTime();
        }
        catch (ParseException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static String MILIS_TO_dd_MMM_yyyy(Long milis) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(milis);
        return formatter.format(calendar.getTime());
    }
    
    public static Date getDateFromAnyFormat(String dateStr){
    	Date retVal = null;
    	int index = 0;
    	while (retVal == null && index < possibleFormats.length) {
    		try {
    			retVal = possibleFormats[index++].parse(dateStr);
    		} catch (ParseException ex) { /* Do nothing */ }
    	}
    	return retVal;
    }

    public static void main(String[] args) {
    	Date date = getDateFromAnyFormat("30/10/2015");
    	System.out.println(date.toString());
    }
}

