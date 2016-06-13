__author__ = 'Mattis'

import math


def getPentagonNumbers(triangleMaxNr):
    tempArr = [0] * triangleMaxNr
    for i in range(1, triangleMaxNr):
        tempArr[i] = (1/2) * i * ((i*3)-1)
    return tempArr

def getPentagonIndex(nr):
    return int(math.sqrt((nr*(2/3)))) + 1

nrOfPentagonNumbers = 1000000
pentagonNumbers = getPentagonNumbers(nrOfPentagonNumbers)

# fastest way should be to look at x steps in front of the number we are looking at and then increase x once we reach
# the end of the numbers until we find a pair which fulfills the conditions

stepsAHeadCounter = 1
keepLooking = True

while(keepLooking):
    for i in range(1, 10000):
        pnIPS = pentagonNumbers[getPentagonIndex(pentagonNumbers[i] + pentagonNumbers[i+stepsAHeadCounter])]
        iPSPn = (pentagonNumbers[i] + pentagonNumbers[i+stepsAHeadCounter])

        pnSMI = pentagonNumbers[getPentagonIndex(pentagonNumbers[i+stepsAHeadCounter] - pentagonNumbers[i])]
        sMIPN = (pentagonNumbers[i+stepsAHeadCounter] - pentagonNumbers[i])

        # if pnIPS == iPSPn:
            # print("THE SAME: " + str(iPSPn) + " using " + str(i) + " and " + str(i+stepsAHeadCounter))
        if (pnSMI == sMIPN) and (pnIPS == iPSPn):
            print("THE SAME: " + str(pnSMI) + " using " + str(i) + " and " + str(i+stepsAHeadCounter))
        ''' print("pnIPS: " + str(pnIPS))
        print("iPSPn: " + str(iPSPn))
        print("pnSMI: " + str(pnSMI))
        print("sMIPN: " + str(sMIPN))'''
        if (pentagonNumbers[getPentagonIndex(pentagonNumbers[i] + pentagonNumbers[i+stepsAHeadCounter])] ==
                (pentagonNumbers[i] + pentagonNumbers[i+stepsAHeadCounter]) and
                pentagonNumbers[getPentagonIndex(pentagonNumbers[i+stepsAHeadCounter] - pentagonNumbers[i])] ==
            pentagonNumbers[i+stepsAHeadCounter] - pentagonNumbers[i]):

            print("found the numbers: " + str(i) + " and " + str(i+stepsAHeadCounter) + " with d: " +
                  str(pentagonNumbers[i+stepsAHeadCounter] - pentagonNumbers[i]))
            keepLooking = False
            break
    stepsAHeadCounter += 1