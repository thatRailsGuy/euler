/*By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see that the 6th prime is 13.

What is the 10001st prime number?*/

def prob007(){	
	num=1
	cnt=2
	while(num<=10001){
		if (isPrime(cnt)){
			println "Prime # $num is $cnt"
			num++
		}
		cnt++
	}
}