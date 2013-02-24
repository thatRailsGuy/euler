require '../Euler'

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