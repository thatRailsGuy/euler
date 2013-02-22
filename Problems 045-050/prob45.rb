require '../class_extensions'

def prob45
  i = 144
  until i.hex_number.is_pentagonal? && i.hex_number.is_triangular?
    i += 1
  end
  i
end

puts prob45.hex_number