class Fixnum
  letters = %w[ M     CM   D    CD   C    XC  L   XL  X   IX V  IV I ]
  values  =   [ 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 ]
  LETTERS = letters.zip values

  def romanize
    n = self
    c = 0 # Avoid reallocating count.
    LETTERS.map{|l,v| c, n = n.divmod v; l*c}.join ''
  end
end

class String
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
end

def prob89
  sum = 0
  file = File.new("roman.txt", "r")
  while (line = file.gets)
    sum += line.strip.length - line.strip.deromanize.romanize.length
  end
  file.close
  sum
end

puts prob89