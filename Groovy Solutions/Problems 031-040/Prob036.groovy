/*The decimal number, 585 = 10010010012 (binary), is palindromic in both bases.

Find the sum of all numbers, less than one million, which are palindromic in base 10 and base 2.

(Please note that the palindromic number, in either base, may not include leading zeros.)*/

def prob036(){
	list = new ArrayList()
	for (i in 1..1000000){
		if (i.toString() == i.toString().reverse()){
			str = toBinary(i)
			if(str == str.reverse()){
				list << i
			}
		}
	}
	list.sum()
}

/*Returns binary string from int*/
def toBinary(num){
	tmp = (int)num
	str = ""
	while(tmp>0){
		str = tmp%2+str
		tmp = (int)(tmp/2)
	}
	str
}

println prob036()