__author__ = 'Mattis'

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

# returns true if the number is trunctable
def trunctable(primeArray, number):
    stringNumber = str(number)
    for i in range(1, len(stringNumber)):
        # print(str(stringNumber[i:]) + " and " + str(stringNumber[:-i]))
        if not(primeArray[int(stringNumber[i:])]) or not(primeArray[int(stringNumber[:-i])]):
            return False
    return True

greatestNr = 1000000
sum = 0
primeNumbers = getPrimes(greatestNr)
for i in range(11, greatestNr):
    if primeNumbers[i]:
        if trunctable(primeNumbers, i):
            print("adding: " + str(i))
            sum += i

print("is prime: " + str(primeNumbers[53]))
print("is truncatable: " + str(trunctable(primeNumbers, 3797)))
print("sum is: " + str(sum))
