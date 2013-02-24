require '../Euler'

def prob62
  cnt = 0
  i = 345
  until cnt >= 5
    cnt = 0
    i += 1
    list = (i**3).to_s.permutations
    list.uniq.each do |it|
      j = it.to_i
      if (j**(1.0/3)).floor**3==j
        puts j
        cnt += 1
      end
    end
    if i % 100 == 0
      puts i
    end
  end
  i
end

i =345
list = (i**3).to_s.permutations
list.each do |it|
  j = it.to_i
  puts j
end