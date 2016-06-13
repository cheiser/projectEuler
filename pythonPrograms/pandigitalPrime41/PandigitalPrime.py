__author__ = 'Mattis'

import math
# biggest possible pandigital == 987654321(0)?

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


largestPrimePandigital = 0





permutates = permutations("1234567") # largest prime so far: 7652413

for perm in permutates:
    if isPrime(int(perm)):
        print("got a prime: " + perm)
        if isPandigital(int(perm)) and int(perm) > largestPrimePandigital:
            largestPrimePandigital = int(perm)



# todo: only check permutations of 123456789....
'''for i in range(123456789, 987654322):
    if isPrime(i):
        if isPandigital(i) and i > largestPrimePandigital:
            largestPrimePandigital = i
'''
# print("isPrime: " + str(isPrime(123456789)))

print("the largest pandigital primes is: " + str(largestPrimePandigital))
print("is pandigital: " + str(isPandigital(654321)))






