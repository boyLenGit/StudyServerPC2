import json, socket


def saveToJson(filepath, data):
    # data为list结构，支持任意的维度，如三维list[[[1,2],3],4]
    with open(filepath + '.bridge', 'w') as jsonWrite:
        json.dump(data, jsonWrite)
    return filepath


def readFromJson(filepath):
    with open(filepath + '.bridge') as jsonRead:
        data = json.load(jsonRead)
    return data


def net_is_used(port):
    ip = get_host_ip()
    s = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
    try:
        s.connect((ip, port))
        s.shutdown(2)
        print('%s:%d is used' % (ip, port))
        return True
    except:
        print('%s:%d is unused' % (ip, port))
        return False


def get_host_ip():
    s = ''
    try:
        s = socket.socket(socket.AF_INET, socket.SOCK_DGRAM)
        s.connect(('8.8.8.8', 80))
        ip = s.getsockname()[0]
    finally:
        s.close()
    return ip


if __name__ == '__main__':
    list1 = [[1, 2, 3, 4, 5], ['Sfdf', [1, 3, 'rrt4']]]
    path = '/Users/mabolun/Project/Python/LenProject_py37/LenBridge_v3/Slave/exchange/test01'
    saveToJson(path, list1)
    reslut = readFromJson(path)
    print(reslut)
    # 查端口
    print(net_is_used(20202))