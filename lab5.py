import random
import turtle

# 1: Write a program that finds number of characters in a string and prints it. (Do not use len() method)
string = input("Enter a string: ")
counter = 0

for s in string:
    counter = counter + 1
print("Length: ", counter)
print()
# 2 Write a program that counts number of vowels in string str.
string = input("Enter a string: ")
counter = 0

for s in string:
    if s == "a" or s == "e" or s == "i" or s == "o" or s == "u":
        counter = counter + 1
print("Vowels: ", counter)
print()

# 3 Randomly generate two numbers between 10 and 99 ( 2-digit number). Then check if they are reverse of each other.
firstNum = random.randint(10, 99)
secondNum = random.randint(10, 99)

print((firstNum))
print((secondNum))

reversed = 0

while firstNum != 0:
    hold = firstNum % 10
    reversed = reversed * 10 + hold
    firstNum //= 10

if reversed != secondNum:
    print("False")
else:
    print("true")
print()
# 4 Test the code below: has some syntax errors

tom = turtle.Turtle()
turtle.colormode(255)
tom.speed(0)
tom.begin_fill()
for i in range(20):
    tom.circle(random.randint(5, 50))
    tom.pencolor((random.randint(0, 255), random.randint(
        0, 255), random.randint(0, 255)))
    tom.penup()
    tom.goto(random.randint(-50, 50), random.randint(-50, 50))
    tom.pendown()
    tom.pensize(random.randint(1, 10))
tom.end_fill()
turtle.done()

# 5 Write a code that sorts three strings in ascending order and prints them.
str1 = "Alice"
str2 = "Carol"
str3 = "Bob"

if (str1 < str2 and str1 < str3):
    if (str2 < str3):
        print(str1, str2, str3)
    else:
        print(str1, str3, str2)
elif (str2 < str1 and str2 < str3):
    if (str1 < str3):
        print(str2, str1, str3)
    else:
        print(str2, str3, str1)
else:
    if (str1 < str2):
        print(str3, str1, str2)
    else:
        print(str3, str2, str1)
print()
# 6 What does the following code print? And understand why.
i = 5
while i > 2:
    j = i-1
    while j >= 1:
        print(i," ", j)
        j = j-1
        print()
    i = i - 1
print()