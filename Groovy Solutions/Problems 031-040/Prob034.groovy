/*145 is a curious number, as 1! + 4! + 5! = 1 + 24 + 120 = 145.

Find the sum of all numbers which are equal to the sum of the factorial of their digits.

Note: as 1! = 1 and 2! = 2 are not sums they are not included.*/

/*Factorion*/
def prob034(){
	sumA = 0
	for (i in 10..2540160){
		if(i == factSum(i)){
			println i
			sumA += i
		}
	}
	sumA
}

def factSum(num){
	Euler euler = new Euler()
	sum = 0
	num.toString().toList().each(){
		sum += euler.factorial(it.toInteger())
	}
	sum
}

println prob034()