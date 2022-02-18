# 聊天软件服务端
import socket
import LenTools.System.GetHost as GetHost
import multiprocessing
import psutil, time, os
import ItemRelease.LenBridge.Slave.resource as resource  # 不可删除
import ItemRelease.LenBridge.Slave.paths as paths
import ItemRelease.LenBridge.Master.library as library

host = GetHost.get_host_ip()
port = 20203
path_info = paths.cleanPath(paths.Bridge_root + '/info')
library.saveToJson(path_info, [port])


def lenMain():
    global port
    while True:
        print("[⊙ LenBridge] Server start, address is '{0}:{1}'.".format(host, port))
        socket1 = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
        try:
            socket1.bind((host, port))
        except OSError:
            port = port+1
            if port > 60000: port = 20000
            library.saveToJson(path_info, [port])
            continue
        socket1.listen(1)
        sock1, addr1 = socket1.accept()  # 设定连接方式是被动连接，等待主动方发来信息
        print('[⊙ LenBridge] Server Connected')
        info1 = sock1.recv(1024).decode()
        while 'STOP_SERVICE' not in info1:
            # 初始化识别
            info1 = info1.split('&')
            print('[⊙ LenBridge] Received:', info1)
            if info1[0] == 'STOP_SERVICE':
                print('[⊙ LenBridge] Server shutdown')
                break
            # 执行区
            exec('resource.{0}({1})'.format(info1[0], 'info1[1]'))
            sock1.send(info1[1].encode())  # 发送内容
            info1 = sock1.recv(1024).decode()  # 再次接收对方的数据，并解码，用作下一次循环使用。
        sock1.close()  # 关闭客户端套接字
        socket1.close()  # 关闭服务端套接字（本端）


def forceActivate():
    global port
    progress1 = multiprocessing.Process(target=lenMain, name='S01Len')
    progress1.start()
    progress_pid = progress1.pid
    print('[⊙ LenBridge] Progress guard start.')
    PROGRESS_STAT = 0
    while True:
        time.sleep(3)
        pid_name = str(psutil.Process(progress_pid).status())
        if pid_name == 'zombie':  # 服务出错，则重启服务
            PROGRESS_STAT = 0
            print('[⊙ LenGuard] Process stat: x. LenBridge is trying to restart it.')
            # 重启服务准备工作
            os.system('kill ' + str(progress_pid))
            progress1 = multiprocessing.Process(target=lenMain, name='S01Len')
            progress1.start()
            progress_pid = progress1.pid
        else:
            if PROGRESS_STAT != 1:
                print('[⊙ LenGuard] Process stat: √.')
            PROGRESS_STAT = 1
            continue


if __name__ == '__main__':
    forceActivate()
