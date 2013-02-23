def isLych?(x,n)
	if n>50
		return true
	else
		sum = x + x.to_s.reverse.to_i
		if sum.to_s == sum.to_s.reverse
			return false
		else
			return isLych?(sum, n+1)
		end
	end
end

def prob55
	cnt = 0
	for i in 1..9999
		if isLych?(i,1)
			cnt += 1
		end
	end
	cnt
end

puts prob55