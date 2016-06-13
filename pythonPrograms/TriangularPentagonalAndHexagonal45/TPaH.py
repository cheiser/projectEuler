__author__ = 'Mattis'

import math

# two possible solutions could be to either use a counter for each array of numbers and increase the smallest one until
# all of them have the same actual value
# or
# utilize the previous code and just increase the triangular value and then use the getXXXIndex on the resulting value
# for each value and see if it equals the corresponding value in each of the XXX array's

def getPentagonNumbers(triangleMaxNr):
    tempArr = [0] * triangleMaxNr
    for i in range(1, triangleMaxNr):
        tempArr[i] = (1/2) * i * ((i*3)-1)
    return tempArr

def getPentagonIndex(nr):
    return int(math.sqrt((nr*(2/3)))) + 1


def getTriangularNumbers(triangleMaxNr):
    tempArr = [0] * triangleMaxNr
    for i in range(1, triangleMaxNr):
        tempArr[i] = (1/2) * i * ((i+1))
    return tempArr

def getTriangularIndex(nr):
    return int(math.sqrt((nr*(2))))


def getHexagonalNumbers(triangleMaxNr):
    tempArr = [0] * triangleMaxNr
    for i in range(1, triangleMaxNr):
        tempArr[i] = i * ((i*2)-1)
    return tempArr

def getHexagonalIndex(nr):
    return int(math.sqrt((nr/2))) + 1

maxNrs = 10000000
triangularNumbers = getTriangularNumbers(maxNrs)
pentagonNumbers = getPentagonNumbers(maxNrs)
hexagonalNumbers = getHexagonalNumbers(maxNrs)

for i in range(286, maxNrs):
    triNum = triangularNumbers[i]
    if ((pentagonNumbers[getPentagonIndex(triNum)] == triNum) and
        hexagonalNumbers[getHexagonalIndex(triNum)] == triNum):
        print("the triangular number is: " + str(triNum) + " at index " + str(i))
