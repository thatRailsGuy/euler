one = %w[1 2 3 4 5 6 7 8 9]
two = %w[4 5 6 7 8 9]
three = %w[5 6 7 8 9]
four = %w[6 7 8 9]
five = %w[7 8 9]
six = %w[7 8 9]
seven = %w[8 9]
eight = %w[8 9]
nine = %w[8 9]
ten = %w[8 9]
# nine goes 11 more
cnt = 1
for i in 1..30
  cnt *= 9
  puts "#{i} #{Math.log10(cnt).floor+1}"
end