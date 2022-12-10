import turtle
import random

tom = turtle.Turtle()
turtle.colormode(255)
tom.speed(0)
tom.begin_fill()
for i in range(20):
	tom.circle(random.randint(5,50))
	tom.pencolor((random.randint(0,255),random.randint(0,255),random.randint(0,255)))
	tom.penup()
	tom.goto(random.randint(-50,50),random.randint(-50,50))
	tom.pendown()
	tom.pensize(random.randint(1,10))
tom.end_fill()
turtle.done()
