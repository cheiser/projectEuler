__author__ = 'Mattis'

import math

# relationship: pythagorian, sum of the two shortest's squares is equal to the longests squared and the triangle
# inequality theorem states that A + B > C where A and B are the shortest sides
# you also know that the three values must sum to p
# one angle must equal 90 degrees, so sin^2(A) + sin^2(B) = 1 and cos^2(A) + cos^2(B) = 1

# Try all P:
# for one p: Try a value for A and then just set B and C to what they have to be to fulfill the requirements
# and then just do this for all possible values of A


withinDistance = 0.02

def getMaxNrOfSolutions(maxPerimeter):
    maxNrOfSol = 0
    bestP = 1.0
    for i in range(1, maxPerimeter):
        print(str(i))
        nrOfSols = getNrOfSolutionForPerimeter(i)
        if nrOfSols > maxNrOfSol:
            maxNrOfSol = nrOfSols
            bestP = i

    return (maxNrOfSol, bestP)


def getNrOfSolutionForPerimeter(peri):
    nrOfSolutions = 0
    for a in range(1, int(peri/2)):
        for b in range(1, int(peri/2)):
            if ((a + b) < peri) and((math.pow(a, 2) + math.pow(b, 2)) == math.pow((peri-a-b), 2)):
                # print("possible solution with: " + str(a) + " " + str(b) + " and " + str(peri-a-b))
                nrOfSolutions += 1
            '''if (not(withinXOfY((math.pow(math.sin(a), 2) + math.pow(math.sin(b), 2)), 1, withinDistance)) or
                    not(withinXOfY((math.pow(math.cos(a), 2) + math.pow(math.cos(b), 2)), 1, withinDistance))):
                print("breaking with sin: " + str((math.pow(math.sin(a), 2) + math.pow(math.sin(b), 2))) + " and cos:" +
                      str((math.pow(math.cos(a), 2) + math.pow(math.cos(b), 2))))
                continue
            c = peri - (a+b)
            if c >= (a+b) or ((math.pow(a, 2) + math.pow(b, 2)) != math.pow(c, 2)):
                continue
            print("one solution for p: " + str(peri) + " is {" + str(a) + ", " + str(b) + ", " + str(c) + "}")
            nrOfSolutions += 1'''

    return nrOfSolutions / 2

# returns true if z is within x from y, eg. y=1.5, z=1.4, x=0.2 would return true while x=0.01 would return false
def withinXOfY(y, z, x):
    if math.fabs(z-y) <= x:
        return True
    else:
        return False


tempP = 1001
maxNr = getMaxNrOfSolutions(tempP)
print("the best max nr of solutions for p: " + str(tempP) + " is " + str(maxNr[0]) + " with p: " + str(maxNr[1]))




onetwenty = getNrOfSolutionForPerimeter(120)
print(str(onetwenty))