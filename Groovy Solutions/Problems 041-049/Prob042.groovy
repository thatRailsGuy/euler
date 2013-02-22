/*The nth term of the sequence of triangle numbers is given by, tn = ½n(n+1); so the first ten triangle numbers are:

1, 3, 6, 10, 15, 21, 28, 36, 45, 55, ...

By converting each letter in a word to a number corresponding to its alphabetical position and adding these values we form a word value. For example, the word value for SKY is 19 + 11 + 25 = 55 = t10. If the word value is a triangle number then we shall call the word a triangle word.

Using words.txt (right click and 'Save Link/Target As...'), a 16K text file containing nearly two-thousand common English words, how many are triangle words?
*/

def prob042(){
	Euler euler = new Euler()
	tri = euler.getTriangularNumbers(1000)
	File file = new File("doc042.txt")
	cnt = 0
	list = file.splitEachLine(","){
		it
	}
	for (i in 0..list.size()-1){
		list[i] = list[i].substring(1,list[i].length()-1).toUpperCase()
	}
	for (i in 0..list.size()-1){
		sum = 0
		list[i].getChars().each(){
			sum += it - 64
		}
		if (tri.contains(sum.toString())){
			cnt ++
		}
	}
	cnt
}

println prob042()
