import turtle

#validation: draw face based on options
emo = input('s:sad, h:happy ')
print()

show_screen = turtle.Screen()
tur = turtle.Turtle(shape= 'turtle')
tur.color('orange', 'orange')

#filling and drawing the circle
tur.begin_fill()
tur.circle(100)
tur.end_fill()
tur.penup()

tur.color('black','brown')

#left eye
tur.goto(-30,135)
tur.pendown()
tur.dot(25)
tur.penup()

#right eye
tur.goto(30,135)
tur.pendown()
tur.dot(25)
tur.penup()

if emo == 'h':
#mouth
    tur.goto(-60,60)
    tur.pendown()
    tur.setheading(-60)
    tur.circle(70,120)

# draw tongue
    tur.goto(-10, 45)
    tur.down()
    tur.right(180)
    tur.fillcolor('red')
    tur.begin_fill()
    tur.circle(10, 180)
    tur.end_fill()

else:
    tur.goto(60,60)
    tur.pendown()
    tur.setheading(120)
    tur.circle(70,120)

turtle.done()