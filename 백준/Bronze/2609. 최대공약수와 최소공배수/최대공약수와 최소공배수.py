def gcd_fun(x,y):
    while y != 0:
        r = x % y
        x, y = y, r
    return x

a, b = map(int, input().split(" "))
if b > a:
    a, b = b, a
#a>b

gcd = gcd_fun(a,b)
print(gcd)

lcm = a * b // gcd
print(lcm)