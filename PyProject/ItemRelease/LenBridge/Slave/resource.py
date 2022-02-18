# 存放该环境下需要被调用的算法函数。可以是一行的代码调用，也可以是全部的算法逻辑
import ItemRelease.LenBridge.Master.library as library
import time


#
def addNumber(path):
    # --------------- ↓读取数据↓ ---------------
    list1 = library.readFromJson(path)
    # --------------- ↓逻辑代码↓ ---------------
    num1, num2 = list1[0], list1[1]
    result = num1 + num2
    # --------------- ↓写入结果↓ ---------------
    library.saveToJson(path, [result, 4])
