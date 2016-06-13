import math

# pass number as a string
def palindrome(number):
    for x in range(0, math.trunc(len(number)/2)):
        if number[x] != number[len(number)-(x+1)]:
            return False

    return True
    


# check to is the number we should check the numbers from 0 to "checkTo" for
# palindromes, checkTo non inclusive
def checkForPalindrome(checkTo):
    palindromeSum = 0
    for i in range(1, checkTo):
        intString = str(i);
        boolString = str(bin(i))
        boolString = boolString[2:len(boolString)] # get substring, 0 indexed
        # print(intString + " " + boolString)
        if(palindrome(intString) and palindrome(boolString)):
            # print("got an double palindrome")
            palindromeSum = palindromeSum + i
    print("the total sum is: " + str(palindromeSum))




if __name__ == '__main__':
    checkForPalindrome(1000000)
