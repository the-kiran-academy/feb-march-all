package com.jbk.serviceIMPL;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.jbk.model.Leaves;
import com.jbk.service.LeavesService;

@Service("leaveservice2")
public class LeavesServiceIMPL2 implements LeavesService {

	@Override
	public List<String> findLeavesDate(Leaves leaves) {
		  int noOfLeaves = leaves.getNoOfLeaves();
	        String startDateString = leaves.getStartDate();
	        boolean isSaturdayHoliday = leaves.getIsSaturdayHoliday();
	        boolean isSundayHoliday = leaves.getIsSundayHoliday();
	        List<String> companyHolidays = leaves.getCompanyHoliday();
	       
	        
	        List<String> leaveDates=null;

	        // Parse start date
	        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	        LocalDate startDate = LocalDate.parse(startDateString, formatter);

	        // Calculate leave allocation
	         leaveDates = calculateLeaveAllocation(noOfLeaves, startDate, isSaturdayHoliday, isSundayHoliday, companyHolidays);

	        // Print leave dates
	        System.out.println("Leave Allocation:");
	        for (String leaveDate : leaveDates) {
	            System.out.println(leaveDate);
	        }
			return leaveDates;
	    }

	    private static List<String> calculateLeaveAllocation(int noOfLeaves, LocalDate startDate, boolean isSaturdayHoliday, boolean isSundayHoliday, List<String> companyHolidays) {
	        List<String> leaveDates = new ArrayList<>();
	        LocalDate currentDate = startDate;

	        // Iterate until all leaves are allocated
	        while (leaveDates.size() < noOfLeaves) {
	            // Check if current date is a company holiday
	            if (companyHolidays.contains(currentDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")))) {
	                currentDate = currentDate.plusDays(1);
	                continue;
	            }

	            // Check if current date is a Saturday or Sunday holiday
	            if ((isSaturdayHoliday && currentDate.getDayOfWeek() == DayOfWeek.SATURDAY) || (isSundayHoliday && currentDate.getDayOfWeek() == DayOfWeek.SUNDAY)) {
	                currentDate = currentDate.plusDays(1);
	                continue;
	            }

	            // Allocate leave on the current date
	           
	            leaveDates.add( currentDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")).toString());
	            currentDate = currentDate.plusDays(1);
	        }

	        return leaveDates;
	    }
	
}
