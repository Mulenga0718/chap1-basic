package howlong;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class VariableInit {
 

	 public double result() {
	 LocalDateTime endDateTime = LocalDateTime.of(2022,  8, 22, 18, 0, 0);
	 double remainDay = ChronoUnit.DAYS.between(LocalDate.now(), endDateTime);
	 return (Math.round((remainDay*100.0/232.0))/10.0);
}
	 public long remain() {
		 LocalDateTime endDateTime = LocalDateTime.of(2022,  8, 22, 18, 0, 0);
		 long remainDay = ChronoUnit.DAYS.between(LocalDate.now(), endDateTime);
		 return remainDay;
	 }
}

	
	

