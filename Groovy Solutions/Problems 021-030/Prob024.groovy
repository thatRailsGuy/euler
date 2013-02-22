/*A permutation is an ordered arrangement of objects. For example, 3124 is one possible permutation of the digits 1, 2, 3 and 4. If all of the permutations are listed numerically or alphabetically, we call it lexicographic order. The lexicographic permutations of 0, 1 and 2 are:

012   021   102   120   201   210

What is the millionth lexicographic permutation of the digits 0, 1, 2, 3, 4, 5, 6, 7, 8 and 9?*/


//using factorial number system to solve
def prob024(){
	Euler euler = new Euler()
	temp = 999999
	num = 9
	factorial = euler.factorial(9)
	list = ["0","1","2","3","4","5","6","7","8","9"]
	map = [:]
	perm = ""
	for(i in 0..9){
		map[i]=0
	}
	while(temp>0){
		if (temp>=factorial){
			factors = (int)(temp/factorial)
			println "$num : $factors"
			temp -= factorial*factors
			map[num]=factors
		}else{
			num--
			factorial = euler.factorial(num)
		}
	}
	for(i in 9..0){
		perm += list.remove(map[i])
	}
	perm
}

println prob024()