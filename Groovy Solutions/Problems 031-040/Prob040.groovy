/*An irrational decimal fraction is created by concatenating the positive integers:

0.123456789101112131415161718192021...

It can be seen that the 12th digit of the fractional part is 1.

If dn represents the nth digit of the fractional part, find the value of the following expression.

d1 × d10 × d100 × d1000 × d10000 × d100000 × d1000000*/

def prob040(){
	str =" "
	cnt =1
	product = 1
	while (str.length()<=1000001){
		str = str + cnt
		cnt++
	}
	for (i in 0..6){
		product *= (""+str.charAt(10**i)).toInteger()
	}
	product
}

println prob040()