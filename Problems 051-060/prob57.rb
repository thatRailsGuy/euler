def prob57
  p = 3
  q = 2
  cnt = 0
  for i in 2..1000
    p,q = p + 2*q , p + q
    if p.to_s.length > q.to_s.length
      cnt += 1
    end
  end
  cnt
end

puts prob57