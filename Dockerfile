FROM ubuntu:latest AS BASE

WORKDIR /home/snow/

# 更新 apt-get 包管理器
RUN sed -i s@/archive.ubuntu.com/@/mirrors.tuna.tsinghua.edu.cn/@g /etc/apt/sources.list \
    && apt-get clean \
    && apt-get update -y \
    && apt-get upgrade -y \
    && apt autoremove \
    && apt-get install -y wget curl tmux openjdk-17-jre git vim

EXPOSE 5173 38643

# 安装 Node 和启动前端服务所必要的 serve 程序
RUN curl -sL https://deb.nodesource.com/setup_19.x | bash - \
    && apt update -y && apt upgrade -y && apt install -y nodejs \
    && npm install -g serve && apt autoremove

# 安装 Elastic Search 和 IK 分词器
# RUN wget https://artifacts.elastic.co/downloads/elasticsearch/elasticsearch-7.15.1-linux-x86_64.tar.gz \
#     && tar -xzvf elasticsearch-7.15.1-linux-x86_64.tar.gz \
#     && rm -rf elasticsearch-7.15.1-linux-x86_64.tar.gz \
#     && elasticsearch-7.15.1/bin/elasticsearch-plugin install https://github.com/medcl/elasticsearch-analysis-ik/releases/download/v7.15.1/elasticsearch-analysis-ik-7.15.1.zip