
# Q!
first_name = input('Enter your first name: ')
last_name = input('Enter your last name: ')
print('Hello', first_name, last_name ) 
print()
# Q2

width = float(input('Input the width '))
height = float(input('Enter the height '))
area = width * height
print("The area of width: ", width)
print("and the area of height: ", height)
print("is: ", area)
print()

# Q3
_seconds = int(input('Enter a number in seconds: '))
m, s = divmod(_seconds, 60)
h, m = divmod(m, 60)
print(f'{h:d} hour {m:02d} minutes {s:02d} seconds')
