/*Using names.txt (right click and 'Save Link/Target As...'), a 46K text file containing over five-thousand first names, begin by sorting it into alphabetical order. Then working out the alphabetical value for each name, multiply this value by its alphabetical position in the list to obtain a name score.

For example, when the list is sorted into alphabetical order, COLIN, which is worth 3 + 15 + 12 + 9 + 14 = 53, is the 938th name in the list. So, COLIN would obtain a score of 938 × 53 = 49714.

What is the total of all the name scores in the file?*/

def prob022(){
	File file = new File("doc022.txt")
	list = []
	list2 = []
	list = file.splitEachLine(","){
		it
	}
	for (i in 0..list.size()-1){
		list[i] = list[i].substring(1,list[i].length()-1).toUpperCase()
	}
	list.sort()
	for (i in 0..list.size()-1){
		sum = 0
		list[i].getChars().each(){
			sum += it - 64
		}
		list2<<(sum*(i+1))
	}
	list2.sum()
}
println prob022()
