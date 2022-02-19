# 聊天软件服务端
import time, socket
import ItemRelease.LenBridge.Slave.paths as paths
import ItemRelease.LenBridge.Master.library as library
path_info = paths.cleanPath(paths.Bridge_root + '/info')


def scheduler(func_name, params):
    """
    :param func_name:
    :param params: 必须是list格式
    :return:
    """
    socket2 = socket.socket()
    host = library.get_host_ip()
    port = library.readFromJson(path_info)[0]
    # 连接并传参
    path_data = library.saveToJson(paths.cleanPath(paths.Bridge_root+'/Slave/exchange/'+func_name), params)
    socket2.connect((host, port))
    print('> Client Connected address:', host, port)
    send_data = '{0}&{1}'.format(func_name, path_data)
    socket2.send(send_data.encode())
    # 接收回复
    receive = socket2.recv(1024).decode()
    print('> LenBridge result:', receive)
    # 结束通信
    time.sleep(1)
    send_data = 'STOP_SERVICE'
    socket2.sendall(send_data.encode())
    socket2.close()
    return library.readFromJson(receive)


if __name__ == '__main__':
    print(scheduler('addNumber', [1, 2]))