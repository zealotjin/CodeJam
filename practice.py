from math import sqrt

def digit_span(x):
    max = 0
    print type(x)
    temp = x
    while(temp !=0):
        remainder = temp%10
        if max < remainder:
            max = remainder
        temp = (temp - remainder)/10        
    min = 10
    temp2 =x
    while(temp2 != 0):
        remainder2 = temp2%10
        if min >remainder2:
            min = remainder2
        temp2 = (temp2-remainder2)/10
    result = max - min
    return result


def next_square(x):
    num_greater_x = sqrt(x)//1 + 1
    return num_greater_x*num_greater_x





def ten_pairs(n):
	def partition(n,m):
		if n==0:
			return 0
		elif n%10 + m == 10:
			return 1 + partition(n/10,m)
		else:
			return partition(n/10,m)
	if n ==0:
		return 0
	return partition(n/10,n%10) + ten_pairs(n/10) 


def count_partitions(n,m):
	if n == 0:
		return 1
	elif n<0:
		return 0
	elif m == 0:
		return 0
	else:
		with_m = count_partitions(n-m,m)
		without_m = count_partitions(n,m-1)
	return with_m + without_m
"""
print count_partitions(6,4)
print count_partitions(5,4)
print ten_pairs(192837)
print ten_pairs(7823952)
print ten_pairs(55055)
print ten_pairs(9641469)
"""
def count_change(amount):
	def partition(n,m):
		if n == 0:
			return 1
		elif n<0:
			return 0
		elif m>n:
			return 0
		else:
			with_m = partition(n-m,m)
			without_m = partition(n,m*2)
		return with_m + without_m
	return partition(amount,1)

print count_change(7)
print count_change(10)
print count_change(20)
print count_change(100)

