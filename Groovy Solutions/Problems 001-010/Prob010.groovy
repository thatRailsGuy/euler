/*The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.

Find the sum of all the primes below two million.*/

def prob010(){
	long sum = 0
	for (i in getPrimesTo(2000000)){
		sum += Integer.parseInt(i.trim())
	}
	println sum
}