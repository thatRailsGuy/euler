require 'mathn'

def prob47
  i = 1
  until i.prime_division.length == 4 && (i+1).prime_division.length == 4 && (i+2).prime_division.length == 4 && (i+3).prime_division.length == 4
    i += 1
  end
  i
end

puts prob47