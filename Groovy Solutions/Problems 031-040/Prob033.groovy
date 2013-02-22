/*The fraction 49/98 is a curious fraction, as an inexperienced mathematician in attempting to simplify it may incorrectly believe that 49/98 = 4/8, which is correct, is obtained by cancelling the 9s.

We shall consider fractions like, 30/50 = 3/5, to be trivial examples.

There are exactly four non-trivial examples of this type of fraction, less than one in value, and containing two digits in the numerator and denominator.

If the product of these four fractions is given in its lowest common terms, find the value of the denominator.*/

def prob033(){
	map = [:]
	num = 1
	denom = 1
	for(i in 11..98){
		for(j in (i+1)..99){
			if(i%10 == (int)(j/10)){
				if((((int)(i/10))*(j))==(i*(j%10))){
					map[i]=j
				}
			}
		}
	}
	map.each(){
		num *= it.key
		denom *= it.value
	}
	println "$num : $denom"
}

println prob033()