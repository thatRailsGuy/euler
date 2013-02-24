require '../Euler'

def prob56
  max = 0
  for i in 1..99
    for j in 1..99
      sum = (i**j).sum_digits
      if sum > max
        max = sum
      end
    end
  end
  max
end

puts prob56