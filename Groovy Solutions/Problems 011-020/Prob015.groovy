/*Starting in the top left corner of a 2×2 grid, there are 6 routes (without backtracking) to the bottom right corner.

How many routes are there through a 20×20 grid?*/
//Can only go down or right

def prob015(){
	list = new long[21][21]
	list[0][0] = 1
	for (i in 0..20){
		list[i][0] = 1
		list[0][i] = 1
	}
	for (i in 1..20){
		for (j in 1..20){
			list[i][j]=list[i-1][j]+list[i][j-1]
		}
	}
	println list[20][20]
}