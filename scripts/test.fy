fluffy = "Hello World"
print fluffy

life = 4
print "life is:"<<life

truth = true

fat = "I'm not fat"
fluffy = "I'm just fluffy"

if truth then
    print fat<<" "<<fluffy
end

if !truth then
    print "foo"
elsif truth then
    print "bar"
else
    print "foo"
end

for i,0,15 do
    if (i%3==0)&&(i%5==0) then
        print "FizzBuzz"
    elsif i%3==0 then
        print "Fizz"
    elsif i%5==0 then
        print "Buzz"
    else
        print i
    end
end

k = 2
i = 0

while i<k do
    print "blabla"
    i = i+1
end

fun compute x,y do
    return x+y
end

res = compute 5,6

print res