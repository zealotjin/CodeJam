def sum_of_primes
	carmichael = [561,1105,1729,2465,2821,6601]
	result = 2
	iterations = 1000
	curr = 2
	while iterations-1>0
		if curr.prime? && !(carmichael.include?(curr))
			result += curr
			iterations -= 1
			puts curr
		end
		curr +=1
	end
	return result
end
class Fixnum
	def prime?
		x = 2**(self-1)
		if x%self ==1
			return true
		end
		return false
	end
end 
x = sum_of_primes
puts x == 3682913
puts 3682913 - x

