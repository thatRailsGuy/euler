# Ruby v 1.9.3
# Prob1
#   Part a:
#     the number 160701 can be written as the sum of 160701 consecutive odd integers, from -160699 to 160701.

# However, if the question was to read positive odd integers as suggested by the example given, the answer would be:
# The sum of 391 consecutive positive odd numbers, beginning at 21 and ending at 801

def prob1a_positive(x)
  if x % 4 == 2             #Eliminate numbers with no solution
    return "There is no set of consecutive odd integers which adds to give you #{x}"
  end
  y = Math.sqrt(x).floor    #largest number of consecutive odd integers that sum to n possible is sqrt (n)
  if x % 2 != y % 2         #If number is odd, must be sum of odd number of odds
    y -=1
  end
  begin                     #Countdown by 2 until either a solution is found or there is no solution
    y-=2
  end until (x) % y == 0 || (x - y * y) < 0
  a = (x - y * y) / y + 1   #a is first number in series
  "The sum of #{y} consecutive positive odd numbers, beginning at #{a} and ending at #{a + 2*y - 2}"
end

puts prob1a_positive(160701)

#   Part b:
#     All odd numbers n are sum of odd integers -(n-2) to n. (-1 and 1 do not work)
#     All multiples of 4, n, are sum of consecutive odd integers (n/2 + 1) and (n/2 - 1)
#     All n such that n%4 = 2 are not the sum of consecutive odd integers
#
#			Since all numbers greater than 0 cancel out with corresponding negatives, and negatives less than -1000000 also count, the real answer is -infinity.
# 		However, if you look for sum of numbers that can be written as sum of two or more consecutive odd integers, the answer is 374999499999. This problem gets even harder if you only allow consecutive positive odd integers.

def prob1b(i)
  x = (i+2)/4               #sum of numbers n such that n%4==2 less than i
  i*(i+1)/2 - 2*x*x -1      #sum of numbers 2 through i minus sum of even non multiples of 4
end

puts prob1b(999999)
