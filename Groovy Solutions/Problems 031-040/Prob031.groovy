/*In England the currency is made up of pound, £, and pence, p, and there are eight coins in general circulation:

    1p, 2p, 5p, 10p, 20p, 50p, £1 (100p) and £2 (200p).

It is possible to make £2 in the following way:

    1×£1 + 1×50p + 2×20p + 1×5p + 1×2p + 3×1p

How many different ways can £2 be made using any number of coins?*/

def prob031(){
	cnt=0
	for(a in 0..1){
		for(b in 0..2){
			for(c in 0..4){
				for(d in 0..10){
					for(e in 0..20){
						for(f in 0..40){
							for(g in 0..100){
								if(a*200+b*100+c*50+d*20+e*10+f*5+g*2 <= 200){
									cnt++
								}
							}
						}
					}
				}
			}
		}
	}
	cnt
}

println prob031()