__author__ = 'Mattis'

# todo: SOME GOOD FUNCTIONALITY FOR LIBRARIES
import math

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

def isPandigital(prime):
    strPrime = str(prime)
    numberArray = [0] * 10
    for i in range(0, len(strPrime)):
        numberArray[int(strPrime[i])] += 1

    for i in range(1, len(strPrime)+1):
        if numberArray[i] != 1:
            return False
    return True

primeMaxLimit = 987654322
primes = getPrimes(int(math.sqrt(primeMaxLimit))+1)

def isPrime(number):
    # check all primes less than equal to the numbers square root and if it is not divisable by any of them then it must
    # be a primes aswell
    if number < len(primes):
        return primes[number]
    nrSqrt = int(math.sqrt(number))+1
    for i in range(2, nrSqrt):
        if primes[i]:
            if (number % i) == 0:
                return False

    return True

# assumes permutate is string, returns array of all the permutations of "permutate"
def permutations(permutate):
    permsArr = [['a'] * len(permutate)] * math.factorial(len(permutate))
    permutationsA(permutate, "", [0, 0], permsArr)
    return permsArr

# todo: check if currentString changes
def permutationsA(permutate, currentString, arrPointer, permArray):
    if len(permutate) == 0:
        permArray[arrPointer[0]] = currentString
        arrPointer[0] += 1
    for i in range(0, len(permutate)):
        permutationsA(stringMinus(permutate, i), currentString + permutate[i], arrPointer, permArray)

def stringMinus(string1, minusIndex):
    newString = ""
    for i in range(0, len(string1)):
        if i != minusIndex:
            newString = newString + string1[i]
    return newString


primeArrayPan = [2, 3, 5, 7, 11, 13, 17]

def isSubstringDivisible(panDigNr):
    primeIndex = 0
    for i in range(1, 8):
        number = (int(panDigNr[i] + panDigNr[i+1] + panDigNr[i+2]))
        # todo: checking the wrong thing, should check if it is divisible with a prime not if it is a prime
        if (number % primeArrayPan[primeIndex]) != 0:
            return False
        primeIndex += 1
    return True


panDigPerms = permutations("0123456789")

sumP = 0
for panDig in panDigPerms:
    # print("one pandigital permutation: " + str(panDig))
    if isSubstringDivisible(panDig):
        print("is substring divisible: " + str(panDig))
        sumP += int(panDig)

print("the sum is: " + str(sumP))




