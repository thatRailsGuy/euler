/*We shall say that an n-digit number is pandigital if it makes use of all the digits 1 to n exactly once. For example, 2143 is a 4-digit pandigital and is also prime.

What is the largest n-digit pandigital prime that exists?
*/

//7 digits or less, 8 and 9 are divisible by 3

def permutations(val, yield) {
	    permutations(0, -1, val, yield)
	}
	 
	def permutations(k, id, val, yield) {
	    id++
	    val[k] = id
	    if (id == val.size()) yield(val)
	    for (t in 0..<val.size()) {
	        if (val[t] == 0) permutations(t , id, val, yield)
	    }
	    id -= 1
	    val[k] = 0
	}
	 
	def primes = []
	 
	permutations([0]*7) {
	    def n = it.join("").toBigInteger()
	    if (n.isProbablePrime(100)) primes << n
	}
	 
	def answer = primes.max()

println answer