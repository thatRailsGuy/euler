/*A Pythagorean triplet is a set of three natural numbers, a < b < c, for which,
a2 + b2 = c2

For example, 32 + 42 = 9 + 16 = 25 = 52.

There exists exactly one Pythagorean triplet for which a + b + c = 1000.
Find the product abc.*/

def prob009(){
	//c is longest side (>334) but a+b>c holds for triangles
	//
	for (c in 334..499){
		for(a in 1..(c/2+1)){
			if (a**2 + (1000-a-c)**2 - c**2 == 0){
				println "$a : ${1000-a-c} : $c product: ${a*c*(1000-a-c)}"
				break
			}
		}
	}
}