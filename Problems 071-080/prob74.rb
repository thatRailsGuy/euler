require 'set'

@list = Hash.new
for i in 0..9
  @list[i] = (1..i).reduce(1, :*)
end

def sum_of_factorials(x)
  temp = x
  temp2 = 0
  sum = 0
  while temp >0
    sum += @list[temp % 10]
    temp = temp /10
  end
  sum
end

def prob74
  chain = Set.new
  list = []
  for i in 1..999999
    temp = i
    chain = Set.new
    until chain.include?(temp)
      chain << temp
      temp = sum_of_factorials(temp)
    end
    if chain.size == 60
      puts i
      list << i
    end
  end
  list.size
end

p prob74