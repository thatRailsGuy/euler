/*A unit fraction contains 1 in the numerator. The decimal representation of the unit fractions with denominators 2 to 10 are given:

    1/2	= 	0.5
    1/3	= 	0.(3)
    1/4	= 	0.25
    1/5	= 	0.2
    1/6	= 	0.1(6)
    1/7	= 	0.(142857)
    1/8	= 	0.125
    1/9	= 	0.(1)
    1/10	= 	0.1

Where 0.1(6) means 0.166666..., and has a 1-digit recurring cycle. It can be seen that 1/7 has a 6-digit recurring cycle.

Find the value of d < 1000 for which 1/d contains the longest recurring cycle in its decimal fraction part.*/

def recurringCycle(num){
	remainders = [:]
	decimal = "0."
	remainder = 10
	while (remainder!=0){
		remainders[remainder]=decimal.length()-2
		while(remainder<num){
			remainder *= 10
			decimal +="0"
		}
		decimal+=(int)(remainder/num)
		remainder -= ((int)(remainder/num))*num
		remainder*=10
		if (remainders.containsKey(remainder)){
			return decimal.length() - 2 - remainders[remainder]
		}
	}
	return 0
}

def prob026(){
	most = 0
	num = 0
	for(i in 1..999){
		temp = recurringCycle(i)
		if (temp>most){
			most = temp
			num = i
		}
	}
	println num
}

prob026()