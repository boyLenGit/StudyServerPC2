Bridge_root = '/Users/mabolun/Project/Python/PyProject/ItemRelease/LenBridge'


def cleanPath(path):
    return path.replace("//", "/").replace("//", "/")


if __name__ == '__main__':
    print(cleanPath(Bridge_root+"////"))