# question 1:
for i in range(11, 111):
    if i % 2 == 0:
        print(i, end=" ")

print()
print()
# question 2:
i = 111
while i > 11:
    if i % 3 == 0:
        print(i, end=" ")
        i -= 3

print()
# Question 3:
row = (int(input("Enter Row ")))
column = (int(input("Enter Column ")))

for i in range(row):
    for j in range(column):
        print("*", end=" ")
    print()

print()
# Question 4
number = (int(input("Enter number ")))
for i in range(number):
    for j in range(number):
        print("*", end=" ")
    number -= 1
    print()

print()
# Question 5
number = (int(input("Enter number ")))
for i in range(number+1):
    for j in range(i):
        print("*", end=" ")
    print()

print()
# Question 6
number = (int(input("Enter number ")))
for i in range(1, number):
    for j in range(number):
        if i % 2 == 0:
            print("*", end=" ")
        else:
            print("+", end=" ")
    print()
