/*The following iterative sequence is defined for the set of positive integers:

n → n/2 (n is even)
n → 3n + 1 (n is odd)

Using the rule above and starting with 13, we generate the following sequence:
13 → 40 → 20 → 10 → 5 → 16 → 8 → 4 → 2 → 1

It can be seen that this sequence (starting at 13 and finishing at 1) contains 10 terms. Although it has not been proved yet (Collatz Problem), it is thought that all starting numbers finish at 1.

Which starting number, under one million, produces the longest chain?

NOTE: Once the chain starts the terms are allowed to go above one million.*/

def prob014(){
	longest = 1
	longestTerms = 1
	long temp = 0
	tempTerms = 1
	for(i in 1..1000000){
		tempTerms = 1
		temp = i
		while (temp != 1){
			tempTerms++
			temp = prob014a(temp)	
		}
		if (tempTerms>longestTerms){
			longest = i
			longestTerms = tempTerms
			println "$i has $longestTerms terms"
		}
	}
}

def prob014a(num){
	if (num%2==0) 
		return num/2
	3*num+1
}