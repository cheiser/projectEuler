__author__ = 'Mattis'

import math
# a composite number is any number greater than one that is not a prime, i.e. has a divisor other than itself

# alg: generate a suitable list of primes, generate a suitable list of odd composite numbers
# generate a suitable list of 'twice a squares' and then just brute force that shit

def testFunction(first, second, third=3, *allOtherParamsAsTuples, **allUnmatchedKVPars):
    print(str(first) + " " + str(second) + " " + str(third))




def getPrimes(maxNr):
    primeArray = [True] * (maxNr+1) # creates an array of size maxNr with only true values
    indexPointer = 2
    secondPointer = 2
    secondPMultiplier = 2

    while(indexPointer <= maxNr):
        if primeArray[indexPointer]:
            while(True):
                secondPointer = indexPointer*secondPMultiplier
                if secondPointer > maxNr:
                    secondPMultiplier = 2
                    break
                primeArray[secondPointer] = False
                secondPMultiplier += 1
        indexPointer += 1

    primeArray[0] = False
    primeArray[1] = False # cause apparently 1 isn't a prime...

    return primeArray

def getOddCompositeNumbers(primeArray, maxNr):
    compArray = [False] * (maxNr+1)
    for i in range(1, maxNr+1):
        if not(primeArray[i]) and ((i % 2) == 1):
            compArray[i] = True

    return compArray


def getTwiceASquares(maxNr):
    tasNrs = [0] * (maxNr + 1)

    for i in range(1, maxNr+1):
        tasNrs[i] = math.pow(i, 2) * 2

    return tasNrs






