/*The number 3797 has an interesting property. Being prime itself, it is possible to continuously remove digits from left to right, and remain prime at each stage: 3797, 797, 97, and 7. Similarly we can work from right to left: 3797, 379, 37, and 3.

Find the sum of the only eleven primes that are both truncatable from left to right and right to left.

NOTE: 2, 3, 5, and 7 are not considered to be truncatable primes.*/

def prob037(){
	Euler euler = new Euler()
	primes = euler.listToInt(euler.getPrimesTo(1000000))
	cnt = 0
	list = new HashSet()
	
	outloop: for (prime in primes){
		if(prime>10)
		{
			primeStr = prime.toString()
			left = prime+" "
			right = " "+prime
			isPrime = true
			inloop: for(i in 0..(primeStr.length()-1)){
				left = left.substring(0,left.length()-1)
				right = right.substring(1)
				if(!euler.isPrime(right.toInteger())||!euler.isPrime(left.toInteger())){
					isPrime = false
					break inloop
				}
			}
			if (isPrime){
				list << prime
				println prime
				cnt++
				if (cnt>10)
					break
			}
		}
	}
	list.sum()
}

println prob037()