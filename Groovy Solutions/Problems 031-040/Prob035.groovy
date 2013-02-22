/*The number, 197, is called a circular prime because all rotations of the digits: 197, 971, and 719, are themselves prime.

There are thirteen such primes below 100: 2, 3, 5, 7, 11, 13, 17, 31, 37, 71, 73, 79, and 97.

How many circular primes are there below one million?*/

def prob035(){
	Euler euler = new Euler()
	circ = new HashSet([2,3,5,7,11,13,17,31,37,71,73,79,97])
	primes = new HashSet(euler.listToInt(euler.getPrimesTo(1000000)))
	
	for (prime in primes){
		notPrime = false
		for (rotation in euler.listToInt(numRotations(prime))){
			if (!primes.contains(rotation)){
				notPrime = true
				break
			}
		}
		if (!notPrime){
			euler.listToInt(numRotations(prime)).each(){
				circ.add(it)
			}
		}
	}
	circ.size()
}

def numRotations(int num){
	numRotations(num.toString())
}

def numRotations(String num){
	cnt = (int)Math.log10(num.toInteger())+1
	list = new ArrayList()
	for (i in 1..cnt){
		list<<num
		num = ""+ num.charAt(num.length()-1)+num.substring(0,num.length()-1)
	}
	list
}

println prob035()