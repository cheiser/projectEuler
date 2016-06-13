__author__ = 'Mattis'

# for every 10 we get one more of for each step and for every 100 two off and so on
# maybe the string approach is fast enough....

tempString = ""
for i in range(1, 1000001):
    tempString = tempString + str(i)
    #print("i: " + str(i))

multiplier = 1
for i in range(1, 8):
    print(str(multiplier) + " is " + tempString[multiplier-1])
    multiplier *= 10

print("The result is: " + str(int(tempString[0]) * int(tempString[9]) * int(tempString[99]) * int(tempString[999]) *
                           int(tempString[9999]) * int(tempString[99999]) * int(tempString[999999])))