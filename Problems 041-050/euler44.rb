def pent(x)
	x*(x*3-1)/2
end

def isPent?(x)
	if x <= 0
		return false
	end
	temp = x * 24 + 1
	sqrt = Math.sqrt(temp).floor
	return sqrt**2 == temp && sqrt % 6 == 5
end

def prob44
	minD = -1
	i = 1
	j = i
	bool = false
	until bool
		i += 1
		j = i-1
		until (pent(i) - pent(j) > minD && minD != - 1) || j == 1
			j-= 1
			if isPent?(pent(i)-pent(j)) && isPent?(pent(i)+pent(j))
				puts "#{i} #{j} -- #{pent(i) - pent(j)}"
				minD = pent(i) - pent(j)
			end
		end
		if i == (pent(i) - pent(i-1) > minD && minD != - 1)
			bool = true
		end
	end
	minD
end

puts prob44