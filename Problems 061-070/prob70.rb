require '../Euler'

list = Hash.new
max = 0
maxi = 0
for i in 1..10000000
  tot = i.totient.to_i
  if i.to_s.chars.to_a.sort == tot.to_s.chars.to_a.sort
    if i.to_f/tot > max
      max = i.to_f/tot
      maxi = i
      puts i
    end
  end
end
puts maxi