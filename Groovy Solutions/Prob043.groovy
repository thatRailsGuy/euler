/*The number, 1406357289, is a 0 to 9 pandigital number because it is made up of each of the digits 0 to 9 in some order, but it also has a rather interesting sub-string divisibility property.

Let d1 be the 1st digit, d2 be the 2nd digit, and so on. In this way, we note the following:

    d2d3d4=406 is divisible by 2
    d3d4d5=063 is divisible by 3
    d4d5d6=635 is divisible by 5
    d5d6d7=357 is divisible by 7
    d6d7d8=572 is divisible by 11
    d7d8d9=728 is divisible by 13
    d8d9d10=289 is divisible by 17

Find the sum of all 0 to 9 pandigital numbers with this property.
*/




//Not my solution






def uniqueDigits(s) {
	  (s.toList() as Set).size()
	}
	 
	def getCandidates(lvl) {
	  def primes = [17, 13, 11, 7, 5, 3, 2]
	  def result = []
	  for (i in 1..<1000) {
	    def s = ("000" + i.toString())[-3..-1]
	    if ((i % primes[lvl] == 0) && (uniqueDigits(s) == 3)) result << s
	  }
	  return result
	}
	 
	def matchSets(p1, p2) {
	  def res = []
	  for (s1 in p1) {
	    p2.findAll { s2 -> (s1[-2..-1] == s2[0..1]) && (!s2.contains(s1[0])) }
	      .each { res << (s1[0] + it) }
	  }
	  return res
	}
	 
	def matching(lvl) {
	  if (lvl == 0) return getCandidates(lvl)
	  return matchSets(getCandidates(lvl), matching(lvl-1))
	}
	 
	def pandigitals = matching(6).collect {
	  for (n in "0".."9") {
	    if (!it.contains(n)) return n + it
	  }
	}
	 
	def answer = pandigitals.sum { it.toLong() }
	
	println answer