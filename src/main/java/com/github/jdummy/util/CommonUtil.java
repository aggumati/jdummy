package com.github.jdummy.util;

import java.text.SimpleDateFormat;
import java.util.AbstractMap;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;

/**
*
* @author Deny
*/
public class CommonUtil {
		
	public static Boolean isNotNullOrEmpty(Object object) {
       return !isNullOrEmpty(object);
	}

   
	@SuppressWarnings("rawtypes")
	public static Boolean isNullOrEmpty(Object object) {
       if (object == null) {
           return true;
       } else {
           if (object instanceof Collection) {
               if (((Collection) object).isEmpty()) {
                   return true;
               }
           } else if (object instanceof AbstractMap) {
               if (((AbstractMap) object).isEmpty()) {
                   return true;
               }
           } else if (object instanceof Long) {
               if (Long.parseLong(object.toString()) == 0) {
                   return true;
               }
           } else {
               if (object.toString().trim().equals("")) {
                   return true;
               }
           }
           return false;
       }
	}
   
	public static Integer calcDateDiffInMonths(Date from, Date to) {
       Integer months = 0;

       Calendar now = Calendar.getInstance();
       Calendar later = Calendar.getInstance();

       now.setTime(from);
       later.setTime(to);
       now.add(Calendar.MONTH, 1);

       while (!now.after(later)) {
           months++;
           now.add(Calendar.MONTH, 1);
       }

       if (now.get(Calendar.MONTH) != later.get(Calendar.MONTH)) {
           months++;
       }

       return months;
	}

	public static Integer calcDateDiffInDays(Date from, Date to) {

       Integer days = 0;

       Calendar now = Calendar.getInstance();
       Calendar later = Calendar.getInstance();

       now.setTime(from);
       later.setTime(to);
       now.add(Calendar.DATE, 1);

       while (!now.after(later)) {
           days++;
           now.add(Calendar.DATE, 1);
       }

       return days;
	}

	public static String calcDateDiffToString(Date startDate, Date endDate) {
       Calendar calStart = Calendar.getInstance();
       calStart.setTime(startDate);

       Calendar calEnd = Calendar.getInstance();
       calEnd.setTime(endDate);

       return CommonUtil.calcDateDiffToString(calStart, calEnd);
	}

	public static String calcDateDiffToString(Calendar startDate,
           Calendar endDate) {
       String result = "";

       int yearDiff = 0;
       int monthDiff = 0;
       int dateDiff = 0;

       Calendar walker = startDate;

       while (walker.before(endDate)) {
           if (walker.get(Calendar.YEAR) < endDate.get(Calendar.YEAR)) {
               yearDiff++;
               walker.add(Calendar.YEAR, 1);

               if (walker.after(endDate)) {
                   yearDiff--;
                   walker.add(Calendar.YEAR, -1);
                   monthDiff++;
                   walker.add(Calendar.MONTH, 1);

                   if (walker.after(endDate)) {
                       monthDiff--;
                       walker.add(Calendar.MONTH, -1);
                       dateDiff++;
                       walker.add(Calendar.DATE, 1);
                   }
               }
           } else if (walker.get(Calendar.MONTH) < endDate.get(Calendar.MONTH)) {
               monthDiff++;
               walker.add(Calendar.MONTH, 1);

               if (walker.after(endDate)) {
                   monthDiff--;
                   walker.add(Calendar.MONTH, -1);

                   while (walker.get(Calendar.MONTH) < endDate.get(Calendar.MONTH)) {
                       dateDiff++;
                       walker.add(Calendar.DATE, 1);
                   }
               }
           } else {
               dateDiff++;
               walker.add(Calendar.DATE, 1);
           }
       }

       if (yearDiff > 1) {
           result = String.format("%d Years", yearDiff);
       } else if (yearDiff > 0) {
           result = String.format("%d Year", yearDiff);
       }

       if (monthDiff > 1) {
           result = String.format("%s %d Months", result, monthDiff);
       } else if (monthDiff > 0) {
           result = String.format("%s %d Month", result, monthDiff);
       }

       if (dateDiff > 1) {
           result = String.format("%s %d Days", result, dateDiff);
       } else if (dateDiff > 0) {
           result = String.format("%s %d Day", result, dateDiff);
       }

       return result;
	}
   
	public static Character convertBooleanToChar(Boolean val) {
       if (val) {
           return '1';
       } else {
           return '0';
       }

	}

	public static Boolean convertChartoBoolean(Character charx) {
       if (charx == '1') {
           return true;
       } else {
           return false;
       }

	}
	
	public static String dateToString(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyy");
		return sdf.format(date);
	}
	
	public static Boolean equalsString(String a, String b){
		return a.equals(b);
	}
	
	public static Boolean equalsInteger(Integer a, Integer b){
		return a.equals(b);
	}
	
	

}
