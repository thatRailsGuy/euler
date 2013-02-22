/*215 = 32768 and the sum of its digits is 3 + 2 + 7 + 6 + 8 = 26.

What is the sum of the digits of the number 21000?*/

def prob016(){
	Euler euler = new Euler()
	l:for(i in 1..1000)
	{
		sum = 0
		println "$i:\t${2**i} \t${euler.sumDigits(2**i)}"
	}
}

prob016()