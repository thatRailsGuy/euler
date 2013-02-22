final BigDecimal PHI = (1+Math.sqrt(5))/2

/*Calculates the numth fibonacci number*/
def fibonacci(num){
	Math.floor(((1+Math.sqrt(5))/2)**num/Math.sqrt(5)+1/2)
}

/*Returns a map of the prime factorization of the form [factor:power]

For Example, primeFactors(100) yields the map [2:2 5:2]*/
def primeFactors(long n){
	factors = [:]
	while (n%2==0){
		if (factors[2] != null)
			factors[2]=factors[2]+1
		else
			factors[2]=1
		n= n/2
	}
	for(long i = 3; i<=n/i; i+=2){
		while (n%i==0){
			if (factors[i] != null)
				factors[i]=factors[i]+1
			else
				factors[i]=1
			n= n/i
		}
	}
	if (n>1){
		factors[n]=1
	}
	//println "factors - $factors"
	return factors
}

/*Returns true if given n is prime*/
def isPrime(long n){
	if (n<2)
		return false
	if (n<4)
		return true
	if (n%2==0)
		return false
	for (i=3; i<=Math.sqrt(n); i+=2){
		if (n%i==0)
			return false
	}
	return true
}

/*Creates a new file primesTo<num>.txt with all the primes up to that number*/
def primesTo(num){
	file = new File("primesTo${num}.txt")
	boolean[] primeArray = new boolean[num+1]
	for (i in 2..num) {
		primeArray[i] = true
	}
	for (i = 2; i**2<=num; i++){
		if ( primeArray[i]){
			for (j=i; i*j<=num; j++){
				primeArray[i*j]=false
			}
		}
	}
	for (i in 2..num){
		if (primeArray[i])
			file << "$i \n"
	}
}

/*Reads the file primesTo<num>.txt created by primesTo(num)*/
def getPrimesTo(num){
	file = new File("primesTo${num}.txt")
	file.readLines()
}

/*Returns the number of divisors a number has*/
def numDivisors(num){
	total = 1
	primeFactors(num).each() { 
		total*=(it.value+1)
	}
	return total
}

/*Returns the number of digits in a number*/
def sumDigits(num){
	sum = 0
	for(i in 1..num.toString().length()){
		sum+=(num.toString().charAt(i-1)-48)
	}
	return sum
}

/*Returns n!*/
def factorial(n) { 
	if (n==0||n==1){
		return 1
	}
	BigInteger total = 1
	for(i in 1..n){
		total = total * i
	}
	total
}

/*returns combinations nCr*/
def C(n,r){
	return factorial(n)/(factorial(r)*factorial(n-r))
}

/*Returns all factors of a number*/
def factors(long num){
	prime = primeFactors(num)
	factors = new HashSet()
	factors<<1
	prime.each{
		for(i in 1..it.value){
			len = factors.size()
			tmp = new HashSet()
			for (j in factors){
				tmp.add(j)
				tmp.add(j*it.key)
			}
			factors = tmp
		}
	}
	factors.sort()
}

/*Returns all prime factors of a number*/
def properFactors(long num){
	tmp = factors(num).toList()
	tmp.remove(tmp.size()-1)
	tmp
}

/*Accepts a list of strings and returns list of integers*/
def listToInt(list){
	temp = new ArrayList()
	list.each(){temp<<it.toInteger()}
	temp
}

/*Returns true if a string is pandigital*/
def isPandigital(String str){
	str.length() == str.replaceAll("0","").toSet().size()
}

/*Returns binary string from int*/
def toBinary(num){
	tmp = (int)num
	str = ""
	while(tmp>0){
		str = tmp%2+str
		tmp = (int)(tmp/2)
	}
	str
}

/*Creates a new file <num>TriangularNumbers.txt with num Triangular numbers*/
def triangularNumbers(num){
	file = new File("${num}TriangularNumbers.txt")
	cnt = 1
	for (i in 1..num){
		file<<cnt+"\n"
		cnt+= i+1
	}
}

/*Reads the file <num>TriangularNumbers.txt created by TriangularNumbers(num)*/
def getTriangularNumbers(num){
	file = new File("${num}TriangularNumbers.txt")
	file.readLines()
}

primesTo(1000000000)
