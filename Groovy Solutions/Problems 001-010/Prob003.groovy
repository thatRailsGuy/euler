/*The prime factors of 13195 are 5, 7, 13 and 29.

What is the largest prime factor of the number 600851475143 ?*/

def prob003(long n){
	for(long i = 2; i<=n/i; i++){
	        while (n%i==0){
	            print "$i "
	            n= n/i
	        }
	    }
	    if (n>0)
	        print n
}