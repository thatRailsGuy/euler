require '../Euler'
require '../poker/rank'


def prob54
  file = File.new("poker.txt", "r")
  while (line = file.gets)
    return line.split[0..4].sort
  end
  file.close
end

