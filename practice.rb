File.open(ARGV[0]).each_line do |line|
	prev = 0
	curr = 1
	1.upto(line.to_i-1) do |x|
		temp = prev + curr
		prev = curr
		curr = temp
	end
	puts curr
end
