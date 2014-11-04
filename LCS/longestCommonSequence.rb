
File.open(ARGV[0]).each_line do |line|
	output = ""
	line.chop!
	line = line.split(";")
	first = line[0].split("")
	second = line[1].split("")
	iterations = [first.length, second.length].max
	i = 0
	j = 0
	while i<iterations-1
		temp = ""
		while j<iterations -1
		end
		if temp.length > output.length
			output = temp
		end
	end
	puts output == "MJAU"
end