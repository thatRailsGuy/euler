require '../Euler'

def prob52
  done = false
  i = 1
  until done
    temp = i.to_s.split(//).sort
    if temp ==  (2*i).to_s.split(//).sort && 
      temp == (3*i).to_s.split(//).sort &&
      temp == (4*i).to_s.split(//).sort &&
      temp == (5*i).to_s.split(//).sort &&
      temp == (6*i).to_s.split(//).sort
      return i
    end
    i += 1
  end
end

i = prob52
puts "#{i} #{2*i} #{3*i} #{4*i} #{5*i} #{6*i}"