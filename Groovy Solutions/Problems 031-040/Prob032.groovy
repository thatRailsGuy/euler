/*We shall say that an n-digit number is pandigital if it makes use of all the digits 1 to n exactly once; for example, the 5-digit number, 15234, is 1 through 5 pandigital.

The product 7254 is unusual, as the identity, 39 × 186 = 7254, containing multiplicand, multiplier, and product is 1 through 9 pandigital.

Find the sum of all products whose multiplicand/multiplier/product identity can be written as a 1 through 9 pandigital.
HINT: Some products can be obtained in more than one way so be sure to only include it once in your sum.*/

/*Returns true if a string is pandigital*/
def isPandigital(String str){
	str.length() == str.replaceAll("0","").toSet().size()
}

def prob032(){
	list = new HashSet()
	for (i in 2..100){
		start = 1234
		if (i>9)
			start = 123
		for (j in start..(10000/i+1)){
			if (isPandigital(""+i+j+(i*j)))
				list << i*j
		}
	}
	list.sum()
}

println prob032()