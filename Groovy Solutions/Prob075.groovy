def prob075(){
	tripCount = [:]
	list = new HashSet()
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
		if(it.value ==1)
			list<<it.key
	}
	list.size()
}

def genTriples(){
	map = [:]
	for(a in 1..1500000){
		for(b in a..1500000){
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

println prob075()