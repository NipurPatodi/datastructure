"""
a = [1, 2, 3]
b = [4, 5, 6]
# zipping
c = [x + y for (x, y) in zip(a, b)]
print(c)
## combining into one
d = [(x, y) for x in a for y in b]
## appending
e=a+b
print (e)
## filtering
print (d)
print (set([x+y for x in a for y in b]) )
"""



def fab(n):
    i=0
    j=1
    while(i<n):
        yield(i)
        t=j
        j=j+i
        i=t

x=fab(10)
print(x.__next__())
print(x.__next__())
print(x.__next__())
print(x.__next__())
print(x.__next__())
print(x.__next__())
print(x.__next__())
print(x.__next__())
print(x.__next__())

class t(object):
    def __init(self):
        pass