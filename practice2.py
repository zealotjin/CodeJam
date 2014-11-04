from operator import add, mul

def accumulate(combiner, start,n, term):
	"""Return the result of combining the first n terms in a sequence"""
	result = start
	while (n>0):
		result = combiner(result,term(n))
		n -= 1
	return result

def summation_using_accumulate(n,term):
	return accumulate(add,0,n,term)

def product_using_accumulate(n,term):
	return accumulate(mul,1,n,term)

def square(n):
	return n*n


print summation_using_accumulate(4,square)
print product_using_accumulate(4,square)


def double(f):
	def x(n):
		return f(f(n))
	return x


print double(square)(2)


def repeated(f,n):
	def x(p):
		temp = f
		m = n-1
		while (m>0):
			temp = compose1(f,temp)
			m-=1
		return temp(p)
	return x


def compose1(f,g):
	def h(x):
		return f(g(x))
	return h

print repeated(square,2)(5)
print repeated(square,4)(5)
