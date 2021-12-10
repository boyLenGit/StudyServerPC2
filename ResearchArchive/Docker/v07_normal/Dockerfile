FROM meadml/cuda10.0-cudnn7-devel-ubuntu16.04-python3.6
MAINTAINER LenDocker01<1024552631@qq.com>

COPY Remote . /home/testdocker/

RUN apt-get update -y
RUN apt-get upgrade -y
RUN apt-get install -y vim
RUN apt-get install -y net-tools
RUN apt-get install -y curl
RUN apt-get install -y openssh-server
COPY /LenLib/sshd_config /etc/ssh/sshd_config
COPY /LenLib/ssh_config /etc/ssh/ssh_config
RUN apt-get install -y libpci3
RUN apt-get install -y zip


COPY /LenLib/LenStartBash.sh /usr/boylen/LenStartBash.sh
RUN chmod 777 /usr/boylen/LenStartBash.sh

ENTRYPOINT /usr/boylen/LenStartBash.sh

EXPOSE 22
EXPOSE 8000
