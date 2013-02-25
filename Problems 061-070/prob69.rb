require '../Euler'

puts (2..1000000).map { |n| [n / (n.totient), n] }.max[1]