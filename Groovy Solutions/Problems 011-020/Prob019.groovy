/*You are given the following information, but you may prefer to do some research for yourself.

    1 Jan 1900 was a Monday.
    Thirty days has September,
    April, June and November.
    All the rest have thirty-one,
    Saving February alone,
    Which has twenty-eight, rain or shine.
    And on leap years, twenty-nine.
    A leap year occurs on any year evenly divisible by 4, but not on a century unless it is divisible by 400.

How many Sundays fell on the first of the month during the twentieth century (1 Jan 1901 to 31 Dec 2000)?*/

def prob019(){
	cnt = 0
	year = 1901
	day = 366
	firstOfJan = [:]
	normYear=[0, 31, 59, 90, 120, 151, 181, 212, 243, 273, 304, 334]
	leapYear=[0, 31, 60, 91, 121, 152, 182, 213, 244, 274, 305, 335]
	while(year<=2000){
		firstOfJan[year] = day
		if (year%4==0)
			day+=366
		else
			day+=365
		year++
	}
	firstOfJan.each {
		if(it.key%4==0){
			for(num in leapYear)
				if((it.value+num)%7==0)
					cnt++
		}
		else{
			for(num in normYear)
				if((it.value+num)%7==0)
					cnt++
		}
	}
	cnt
}

println prob019()