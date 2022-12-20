import math
#print("Hello world")
for i in range(1, 3):
    data = (int(input("enter a number ")))
    temp = data
    d1 = data % 5
    if d1 == 0:
        print("this number is divisible by 5")
    else:
            output = round(temp/5)
            output += 1
            output *= 5
            fin = output - d1
            print("you need to add ", fin, " to not get any remainder")
            print()

# question 2:
name = input("what is your name?")
midterm = (int(input("enter midterm grade: ")))
final_Grade = (int(input("enter final grade: ")))
homework_Grade = (int(input("enter homework grade: ")))

overall_Grade = midterm * 0.4 + final_Grade * 0.5 + homework_Grade * .1
if overall_Grade >= 93:
    print(name)
    print("Congratulations, you got an A!")
elif overall_Grade >= 85:
    print(name)
    print("Congratulations, you got a A-!")
elif overall_Grade >= 75:
    print(name)
    print("Congratulations, you got a B+!")
elif overall_Grade >= 65:
    print(name)
    print("Congratulations, you got a C")
else:
    print(name)
    print("You got an F")

# question 3:
for i in range(1, 3):
    number = (float(input("Enter a number ")))
    print('Absolute value of ', number, " is ", abs(number))
    print()

# question 4:
name1 = (input("enter first name: "))
name2 = (input("enter second name: "))
name3 = (input("enter third name: "))
arr = [name1, name2, name3]
arr.sort()
print("names in alphabetical order: ")
for i in arr:
    print(i)
