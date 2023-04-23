FROM ubuntu:latest AS BASE

WORKDIR /home/snow/

# 更新 apt-get 包管理器
RUN sed -i s@/archive.ubuntu.com/@/mirrors.tuna.tsinghua.edu.cn/@g /etc/apt/sources.list \
    && apt-get clean \
    && apt-get update -y \
    && apt-get upgrade -y \
    && apt autoremove \
    && apt-get install -y wget curl tmux mysql-server openjdk-17-jre

EXPOSE 5173 38643

# 复制文件
COPY backend-0.0.1-SNAPSHOT.jar backend/src/main/resources/library/mysql-connector-java-8.0.30.jar /home/snow/
COPY scripts/ /home/snow/scripts
COPY frontend/dist/ /home/snow/frontend

# 启动前端和后端
RUN curl -sL https://deb.nodesource.com/setup_19.x | bash - \
    && apt update -y && apt upgrade -y && apt install -y nodejs \
    && npm install -g serve && apt autoremove

RUN wget https://artifacts.elastic.co/downloads/elasticsearch/elasticsearch-7.15.1-linux-x86_64.tar.gz \
    && tar -xzvf elasticsearch-7.15.1-linux-x86_64.tar.gz \
    && rm -rf elasticsearch-7.15.1-linux-x86_64.tar.gz \
    && elasticsearch-7.15.1/bin/elasticsearch-plugin install https://github.com/medcl/elasticsearch-analysis-ik/releases/download/v7.15.1/elasticsearch-analysis-ik-7.15.1.zip \
    && elasticsearch-7.15.1/bin/elasticsearch & sleep 30

CMD /home/snow/scripts/start.sh