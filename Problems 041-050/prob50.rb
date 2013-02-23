# The prime 41, can be written as the sum of six consecutive primes:
#
# 41 = 2 + 3 + 5 + 7 + 11 + 13
# This is the longest sum of consecutive primes that adds to a prime below one-hundred.
#
#The longest sum of consecutive primes below one-thousand that adds to a prime, contains 21 terms, and is equal to 953.
#
# Which prime, below one-million, can be written as the sum of the most consecutive primes?

require '../Euler'

def prob50
  sieve = sieve(1000000)
  num = sieve.size - 1
  i = 546 # any more and first i primes sum greater than 1000000
  max = 0
  max_prime = 0
  until i < 2
    j = 0
    until sieve[j..(i+j)].inject(:+) > 1000000
      if sieve.include?(sieve[j..(i+j)].inject(:+))
        return sieve[j..(i+j)].inject(:+)
      end
      j += 1
    end
    i -= 1
  end
end

puts prob50