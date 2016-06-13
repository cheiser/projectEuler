__author__ = 'Mattis'

import math

# generate the 400 first triangle words and save them as an array which we can do quick indexing in later,
# could just when indexing multiply with 2 and take the square-root and round down, not a nice solution but works as
# long as triangleMaxNr is small enough

# todo: add file I/O

def getTriangleNumbers(triangleMaxNr):
    tempArr = [0] * triangleMaxNr
    for i in range(1, triangleMaxNr):
        tempArr[i] = (1/2) * i * (i+1)
    return tempArr


def getTriangleIndex(nr):
    return int(math.sqrt((nr*2)))

def getWordSumForWord(word):
    word = word.upper()
    wordSum = 0

    for i in range(0, len(word)):
        if ord(word[i]) >= 65 and ord(word[i]) <= 91:
            temp = (ord(word[i])-64)
            # print("adding " + str(temp) + " to wordSum")
            wordSum += temp
    return wordSum

fileHandler = open('p042_words.txt', 'r') # w for write, r for read, a for append, r+ for read and write
triangleNumbers = getTriangleNumbers(1200)

'''
fileHandler.read() # reads the entire file
fileHandler.read(10) # reads 10 characters from the file
fileHandler.readline() # reads a line from the file
fileHandler.write('data') # writes the string "data" to the file
fileHandler.tell() # returns the current file-pointer index
fileHandler.seek(2) # sets the file-pointer index to the second byte in the file
fileHandler.seek(-3, 2) # sets the pointer to three bytes from the end, arg2 = 0: beginning, 1:cur index,2: start at end
'''

allWords = fileHandler.read()
allWordsArray = allWords.split(",")

triangleWordCount = 0

for i in range(0, len(allWordsArray)):
    wordSum = getWordSumForWord(allWordsArray[i])
    if triangleNumbers[getTriangleIndex(wordSum)] == wordSum:
        triangleWordCount += 1
    '''print("word " + str(i) + ": " + allWordsArray[i] + " wordsum: " +
          str(getWordSumForWord(allWordsArray[i])) + " ", end="")
    if i % 10 == 0:
        print()'''


print("total number of triangle words: " + str(triangleWordCount))







