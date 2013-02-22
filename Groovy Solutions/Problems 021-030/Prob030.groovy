/*Surprisingly there are only three numbers that can be written as the sum of fourth powers of their digits:

    1634 = 14 + 64 + 34 + 44
    8208 = 84 + 24 + 04 + 84
    9474 = 94 + 44 + 74 + 44

As 1 = 14 is not a sum it is not included.

The sum of these numbers is 1634 + 8208 + 9474 = 19316.

Find the sum of all the numbers that can be written as the sum of fifth powers of their digits.*/

def prob030(){
	list = new ArrayList()
	for(i in 10..999999){
		str = i.toString()
		sum = 0
		str.each(){
			sum += it.toInteger()**5
		}
		if (sum==i){
			list<<i
		}
	}
	list.sum()
}

println prob030()