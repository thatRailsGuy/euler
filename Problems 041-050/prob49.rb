# The arithmetic sequence, 1487, 4817, 8147, in which each of the terms increases by 3330, is unusual in two ways: (i) each of the three terms are prime, and, (ii) each of the 4-digit numbers are permutations of one another.
# 
# There are no arithmetic sequences made up of three 1-, 2-, or 3-digit primes, exhibiting this property, but there is one other 4-digit increasing sequence.
# 
# What 12-digit number do you form by concatenating the three terms in this sequence?

require '../Euler'

def prob49
  solutions = []
  for i in 1000..9999
    temp = []
    i.permutations.each do |x|
      temp << x if x.prime?
    end
    temp = temp.uniq.sort
    l = temp.size
    for i in 0..l
      for j in (i+1)..(l-1)
        for k in (j+1)..(l-1)
          if temp[k] - temp[j] == temp[j] - temp[i]
             str = "#{temp[i]}#{temp[j]}#{temp[k]}"
             solutions << str if str.length == 12
             # puts str if str.length == 12
          end
        end
      end
    end
  end
  solutions.uniq.sort
end

puts prob49