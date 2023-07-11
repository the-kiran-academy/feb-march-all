package com.jbk.serviceIMPL;

import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.jbk.model.Leaves;
import com.jbk.service.LeavesService;

@Service("leaveservice1")
public class LeavesServiceIMPL implements LeavesService {

	@Override
	public List<String> findLeavesDate(Leaves leaves) {
		List<String> list = new ArrayList<>();
		String startDate = leaves.getStartDate();
		String[] dmy = startDate.split("/");
		int day = Integer.parseInt(dmy[0]);
		int month = Integer.parseInt(dmy[1]);
		int year = Integer.parseInt(dmy[2]);
		Month m = Month.of(month);

		boolean isLeapYear = isLeapYear(year);

		for (int i = 0; i <= m.length(isLeapYear); i++) {
			boolean isWeekEnd;
			boolean iscompanyHoliday = false;
			LocalDate localDate = LocalDate.of(year, month, day);
			DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			String formattedDate = localDate.format(dateTimeFormatter);
			
			 isWeekEnd = isWeekEnd(localDate, leaves.getIsSaturdayHoliday(), leaves.getIsSundayHoliday());
			
			if(!isWeekEnd) {
				 iscompanyHoliday = isCompanyHoliday(formattedDate, leaves.getCompanyHoliday());

			}
			
			if (!isWeekEnd && !iscompanyHoliday) {
				list.add(formattedDate);

				if (list.size() == leaves.getNoOfLeaves()) {
					break;
				}
			}

			if (day == m.length(isLeapYear)) {
				System.out.println(m.getValue());
				if (m.getValue() == 12) {
					month = 1;
					day = 1;
					year = year + 1;
				} else {
					month = month + 1;
					day = 1;
				}
			} else {
				day = day + 1;
			}
		}

		return list;
	}

	public static boolean isWeekEnd(LocalDate localDate, boolean saturday, boolean sunday) {
		String dayOfWeek = localDate.getDayOfWeek().toString();

		boolean isWeekend = false;
		if (saturday) {
			if ("SATURDAY".equalsIgnoreCase(dayOfWeek)) {
				isWeekend = true;
			}
		}
		if (sunday) {
			if ("SUNDAY".equalsIgnoreCase(dayOfWeek)) {
				isWeekend = true;
			}
		}
		return isWeekend;

	}

	public boolean isCompanyHoliday(String formattedDate, List<String> holidays) {

		if (holidays.contains(formattedDate)) {
			return true;
		} else {
			return false;
		}

	}

	public boolean isLeapYear(int year) {
		boolean isLeapYear = false;
		if (year % 400 == 0) {
			isLeapYear = true;
		} else if (year % 100 == 0) {
			isLeapYear = false;
		} else if (year % 4 == 0) {
			isLeapYear = true;
		} else {
			isLeapYear = false;
		}
		return isLeapYear;

	}

}