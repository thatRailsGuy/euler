/*If p is the perimeter of a right angle triangle with integral length sides, {a,b,c}, there are exactly three solutions for p = 120.

{20,48,52}, {24,45,51}, {30,40,50}

For which value of p ≤ 1000, is the number of solutions maximised?*/

def prob039(){
	tripCount = [:]
	genTriples().each(){
		temp = it.key+it.value+Math.sqrt(it.key**2 + it.value**2)
		if (tripCount.containsKey(temp)){
			tripCount[temp]++
		}else{
			tripCount[temp]=1
		}
	}
	max = 0
	maxI = 0
	tripCount.each(){
		if (it.value > max){
			max = it.value
			maxI = it.key
		}
	}
	tripCount
}

def genTriples(){
	map = [:]
	for(a in 1..1000){
		for(b in a..1000){
			c = (int)Math.sqrt(a**2+b**2)
			if (c**2==a**2+b**2){
				if(a+b+c<=1000){
					map[a]= b
				}
			}
		}
	}
	map
}

println prob039()