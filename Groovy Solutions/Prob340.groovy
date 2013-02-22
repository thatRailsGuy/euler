//TODO prob340

def prob340(BigInteger numA,BigInteger numB,BigInteger numC){
	BigInteger total = 0
	for(i in 1..numB){
		total+=prob340helper(i,numA,numB,numC).trampoline()
	}
	println total
}

def prob340helper(BigInteger num, BigInteger numA,BigInteger numB,BigInteger numC){
	if (num>numB){
		return num - numC
	}
	return prob340helper(numA+prob340helper(numA+prob340helper(numA+prob340helper(numA+num,numA,numB,numC).trampoline(),numA,numB,numC).trampoline(),numA,numB,numC).trampoline(),numA,numB,numC).trampoline()
}