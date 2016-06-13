__author__ = 'Mattis'

# returns true if the number is pandigital, nr must be passed as a string
def isPandigital(nr):
    if len(nr) != 9:
        return False
    digits = [False] * (9+1)
    for i in range(0, 9):
        if int(nr[i]) == 0:
            return False
        elif digits[int(nr[i])]:
            return False
        else:
            digits[int(nr[i])] = True

    return True


print("is Pandigital: " + str(isPandigital(str(923546781))))
largest = 0

# ugly solution.... should be a much easier way
for i in range(1, 9876):
    j = 1
    concatenated = ""
    while(True):
        if len(concatenated) >= 9:
            break
        concatenated = concatenated + str(i*j)
        j += 1

    if isPandigital(concatenated):
        if int(concatenated) > largest:
            largest = int(concatenated)

print("largest: " + str(largest))