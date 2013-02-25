# Have changed some names, old scripts may need to be updated.

require 'mathn'
PHI = (1+Math.sqrt(5))/2

class Integer
  # returns true if number is prime
  def prime?
    if self == 2
      return true
    elsif self <= 1 || self % 2 == 0
      return false
    else
      (3 .. Math.sqrt(self)).step(2) do |i|
        if self % i == 0
          return false
        end
      end
      return true
    end
  end
  
  # returns Euler's totient function, phi
  def totient
    self * self.prime_factors.each.map { |p| 1 - 1.0 / p }.reduce(1, :*)
  end
  
  # returns whether a number is a perfect cube
  def cube?
    (self**(1.0/3.0).floor)**3 == self
  end
  
  # returns all permutations of a number
  def permutations
    self.to_s.chars.to_a.permutation.map(&:join).collect{|i| i.to_i}.sort.uniq
  end
  
  # returns whether a number is a pentagonal number
  def pent_number?
    if Math.sqrt(24*self + 1).floor**2 == 24 * self + 1 && Math.sqrt(24*self + 1)%6 == 5
      return true
    end
    false
  end
  
  # returns whether a number is a triangular number
  def tri_number?
    Math.sqrt(8 * self + 1).floor**2 == 8 * self + 1
  end
  
  # returns the nth hexagonal number
  def hex_number
    self * (2 * self - 1)
  end

  # returns the roman numeral of an integer
  def romanize
    letters = %w[ M     CM   D    CD   C    XC  L   XL  X   IX V  IV I ]
    values  =   [ 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 ]
    n = self
    c = 0 # Avoid reallocating count.
    letters.zip(values).map{|l,v| c, n = n.divmod v; l*c}.join ''
  end
  
  # returns the nth fibonacci number
  def fibonacci
    (PHI**self/Math.sqrt(5)+0.5).floor
  end
  
  # returns prime factors
  def prime_factors
    self.prime_division.map{|p,e| p}
  end
  
  # returns all factors
  def factors
    primes, powers = self.prime_division.transpose
    exponents = powers.map{|i| (0..i).to_a}
    divisors = exponents.shift.product(*exponents).map do |powers|
      primes.zip(powers).map{|prime, power| prime ** power}.inject(:*)
    end
    divisors.sort
  end
  
  # return number of factors
  def num_factors
    factors = 1
    self.prime_division.each{|p,e| factors *= (e+1)}
    factors
  end
  
  # returns the sum of number's digits
  def sum_digits
    dup = self
    sum = 0
    while dup>0
      sum += dup%10
      dup = (dup - dup % 10)/10
    end
    sum
  end
  
  # returns nCr
  def comb(r)
    self.factorial/(r.factorial*(self-r).factorial)
  end
    
  # returns n!
  def factorial
    (1..self).inject(:*) || 1
  end
  
  # return array of primes less than n
  def primes_up_to
    sieve(self)
  end
  
end

class String
  # returns an integer of a roman number
  def deromanize
    r = self.dup.upcase
    n = 0
    until r.empty? do
      case
      when r.start_with?('M')  then v = 1000; len = 1
      when r.start_with?('CM') then v = 900;  len = 2
      when r.start_with?('D')  then v = 500;  len = 1
      when r.start_with?('CD') then v = 400;  len = 2
      when r.start_with?('C')  then v = 100;  len = 1
      when r.start_with?('XC') then v = 90;   len = 2
      when r.start_with?('L')  then v = 50;   len = 1
      when r.start_with?('XL') then v = 40;   len = 2
      when r.start_with?('X')  then v = 10;   len = 1
      when r.start_with?('IX') then v = 9;    len = 2
      when r.start_with?('V')  then v = 5;    len = 1
      when r.start_with?('IV') then v = 4;    len = 2
      when r.start_with?('I')  then v = 1;    len = 1
      else
        raise ArgumentError.new("invalid roman numerals: " + self)
      end
      n += v
      r[0 .. len-1] = ""
    end
    n
  end
  
  def permutations
    self.chars.to_a.permutation.map(&:join)
  end
  
end

def sieve(x)
  max = Integer(x || 100)
  sieve = [nil, nil] + (2 .. max).to_a
  (2 .. Math.sqrt(max)).each do |i|
    next unless sieve[i]
    (i*i).step(max, i) do |j|
      sieve[j] = nil
    end
  end
  sieve.compact
end