import ItemRelease.LenBridge.Master.bridgeMaster as bridgeMaster
import random

def test_long_2vlist():
    list1 = []
    list2 = []
    for i1 in range(100):
        for i2 in range(200):
            list2.append(i2)
        list1.append(list2)
    result = bridgeMaster.scheduler("list2vSquare", list1)
    print(list1[5])
    print(result[5])


if __name__ == '__main__':
    test_long_2vlist()