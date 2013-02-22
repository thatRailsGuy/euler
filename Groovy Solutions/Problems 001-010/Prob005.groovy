/*2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder.

What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?*/

def prob005(){
	total = 1
	factors = [ : ]
	combined = [ : ]
	for(i in 1..20){
		factors = primeFactors(i)
		//println "$i has factors $factors"
		factors.each() {
			if(combined[it.key]==null)
				combined[it.key]=it.value
			else
				if (combined[it.key]<it.value)
					combined[it.key]=it.value
		}
	}
	combined.each(){
		for(i in 1..it.value){
			total *= it.key
		}
	}
	println total
}