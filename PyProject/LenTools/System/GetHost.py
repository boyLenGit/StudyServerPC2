import socket


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
    # For Test
    print(get_host_ip())
    import sys
    print(sys.path)
