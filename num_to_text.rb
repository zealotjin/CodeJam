def tens(first, second, text)
	output = ""
	ten_one = {0=>"Ten",1=>"Eleven",2=>"Twelve",3=>"Thirteen",4=>"Fourteen",5=>"Fifteen"}
	ten = {2=>"Twen",3=>"Thir",4=>"For",5=>"Fif"}
	if first == 1
		if second<=5
			output<<ten_one[second]
		else
			temp = text[second.to_s]
			output<< "#{temp}"<<"teen"
		end
	else
		temp = ten[first] || text[first]
		temp2 = text[second.to_s]
		output << "#{temp}"<<"ty"<< "#{temp2}"
	end
	return output
end

File.open(ARGV[0]).each_line do |line|
	x = line.split("")
	x.delete("\n")
	y = x.length
	text = {"1"=>"One", "2"=>"Two", "3"=>"Three", "4"=>"Four", "5"=>"Five","6"=>"Six","7"=>"Seven","8"=>"Eight","9"=>"Nine"}
	units = {1=>"", 2=>"ty", 0=>"Hundred"}
	units2 = {4 =>"Thousand", 7 =>"Million"}
	output = ""
	next_val = ""
	0.upto(y-1) do |i|
		if y%3 ==2 && x[i].to_i<=5 && x[i].to_i>0
			output <<tens(x[i].to_i,x[i+1].to_i,text)
			next_val = "next"
		else
			if next_val == "next"
				next_val = ""
				if y ==4 || y==7
					unit2 = units2[y]
					output<<"#{unit2}"
				end
				y-=1
				next
			else
				temp = text[x[i]]
				unit = units[y%3]
				output<<"#{temp}"
				if x[i].to_i != 0
					output<<"#{unit}"
				end
			end
			if y ==4 || y==7
				unit2 = units2[y]
				output<<"#{unit2}"
			end
		end
		y-=1
	end
	if x[0].to_i == 1 && x.length== 1
		output<<"Dollar"
	else
		output<<"Dollars"
	end
	puts output
end
