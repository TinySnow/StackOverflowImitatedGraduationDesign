/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 80020
 Source Host           : localhost:3306
 Source Schema         : test

 Target Server Type    : MySQL
 Target Server Version : 80020
 File Encoding         : 65001

 Date: 03/05/2023 19:24:40
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for question
-- ----------------------------
DROP TABLE IF EXISTS `question`;
CREATE TABLE `question`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '问题 id，唯一凭证',
  `author` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '作者，关联 user 的 id',
  `title` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL COMMENT '文章标题',
  `content` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL COMMENT '文章内容',
  `reward` int(0) NULL DEFAULT NULL COMMENT '悬赏分数，标注最佳答案后进行事务性扣除',
  `created_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `updated_time` datetime(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间，若无更改可为空',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1047 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of question
-- ----------------------------
INSERT INTO `question` VALUES (1020, '2', 'Elastic Search 启用', '# Elastic Search 启用\n\n## 下载\n\n## 解压\n\n## 启动\n\n- 先启动一次，会自动生成一些配置文件\n- 如果启动报错\n\n```bash\nERROR: Elasticsearch exited unexpectedly\n```\n\n- 多半就是 jvm 内存问题\n\n  - 去 config 文件夹下面修改 jvm.options 文件\n  - 找到 `IMPORTANT: JVM heap size`\n  - 将下面的内容取消注释，4g 修改为 1g 即可\n\n  ```bash\n    ## -Xms4g\n    ## -Xmx4g\n  ```\n\n- 重新启动\n\n## 配置\n\n- 本地测试使用密码可能会比较麻烦\n- 生成配置文件之后，去 `elasticsearch.yml` 里面把最下方的所有 true 更改为 false 即可\n\n## 可视化\n\n### Kibana\n\n- 流程与上面一致\n- 启动后访问 [本地浏览器](http://localhost:5601)\n- 如果遇到报错 `This Elastic installation has strict security requirements enabled that your current browser does not meet.` 需要将 `csp.strict: false` 配置项添加至配置文件 `kibana.yml` 里\n  - 该配置项是使用了内容安全策略（CSP）防止浏览器受到攻击\n\n### ElasticSearch-Head\n\n- 此工具用起来比较简单\n\n## 注意\n\n- 中文默认分词器惨不忍睹，需要自己安装额外分词器\n- 查询比较特殊，要求 GET 请求携带数据体\n- 查询也可以用 POST，不是必须用 GET\n- 允许跨域需要在 `elasticsearch.yml` 中添加配置\n\n```yaml\n#开启跨域\nhttp.cors.enabled: true\n#允许所有\nhttp.cors.allow-origin: \"*\"\n```\n\n', NULL, '2023-05-03 19:09:27', NULL);
INSERT INTO `question` VALUES (1021, '2', 'Logstash 同步 MySQL 数据到 Elastic Search', '# Logstash 同步 MySQL 数据到 Elastic Search\n\n## 环境准备\n\n1. 下载 Logstash 并解压\n2. 下载 Elastic Search 并启动，参见 [Elastic Search 启用](https://tinysnow.github.io/技术/实践记录/ElasticSearch启用.html)\n3. 需要下载 MySQL Java Connector 到一个特定目录，路径后续会用到\n\n## 启动\n\n- 需要提前启动 Elastic Search 和 MySQL\n\n  - 因为 MySQL 服务一直挂在后台，所以其实可以不用管\n  - 但 Elastic Search 需要提前启动\n\n- 其实可以直接启动，但是会报 `pipelines.yml` 找不到工作流的错误\n\n  ```bash\n  # 省略一些 INFO 日志，来到报错行\n  ERROR: Pipelines YAML file is empty. Location: <path>/pipelines.yml\n  ```\n\n- 所以下一步配置工作流\n\n## 配置 pipelines.yml\n\n```yaml\n- pipeline.id: test\n  path.config: \"config/mysql.conf\"\n```\n\n- 将给出的例子取消注释\n  - id 随便取名，只适用于区分工作流的名字\n  - 指明该 config 的位置\n- 注意，此处的 config 的相对路径以 `logstash-<version>` 为根目录，所以需要加上 config 路径\n  - 即直接在 `pipelines.yml` 所在目录下新建 `mysql.conf`\n\n## 配置 mysql.conf\n\n- 观察到同级目录下还有一个 `logstash-sample.conf`\n  - 此为配置的模板文件，复制粘贴其格式即可\n- 配置自己所需要的 `mysql.conf`\n\n```ruby\n# Sample Logstash configuration for creating a simple\n# Beats -> Logstash -> Elasticsearch pipeline.\n\ninput {\n  stdin {}\n  jdbc {\n    # 区别 jdbc 的类型，在下面 output 的时候做判断\n    type => \"user\"\n    # 数据库连接地址，数据库需要修改\n    jdbc_connection_string => \"jdbc:mysql://127.0.0.1:3306/<database>?characterEncoding=UTF-8\"\n    # 数据库账号密码\n    jdbc_user => \"root\"\n    jdbc_password => \"password\"\n    # MySQL Connector 依赖包路径，相对路径没成功，所以这里笔者用的绝对路径\n    jdbc_driver_library => \"<path_to_connector>\"\n    # Driver Class 名字，跟普通 JDBC 相同\n    jdbc_driver_class => \"com.mysql.cj.jdbc.Driver\"\n    # 跟 statement_filepath 二选一配置，说明在下方\n    statement => \"SELECT * FROM user\"\n    ###################### 以下配置选择性添加 #############################\n    # 数据库重连尝试次数\n    connection_retry_attempts => \"3\"\n    # 判断数据库连接是否可用，默认 false\n    jdbc_validate_connection => \"true\"\n    # 数据库连接可用校验超时时间\n    jdbc_validation_timeout => \"3600\"\n    # 开启分页查询，默认 false\n    jdbc_paging_enabled => \"true\"\n    # 单次分页查询条数，默认 100000，若字段较多且更新频率较高，建议调低\n    jdbc_page_size => \"500\"\n    # 是否将字段名转换为小写，默认 true（如果有数据序列化、反序列化需求，建议改为 false）\n    lowercase_column_names => false\n    # SQL 日志级别，默认 info\n    sql_log_level => warn\n  }\n}\n\noutput {\n  if [type] == \"user\" {\n    elasticsearch {\n      hosts => [\"http://localhost:9200\"]\n      index => \"user\"\n      # 数据唯一索引，建议使用数据库的主键\n      # 此处 id 更改为该数据库表的主键名\n      document_id => \"%{id}\"\n    }\n  }\n}\n\n```\n\n- 说明\n  - 现根据 jdbc 配置连接数据库，所以 username, password, driver class, driver library 需要正确\n  - 然后执行设置的 statement，或者 statement_filepath 里面的 SQL 语句\n  - 将执行结果输出到 logstash 进行下一步 filter 清洗（此处没有设置 filter）\n  - 最后根据 jdbc 设置的 type 选择性输出到某一数据库\n\n## 再启动\n\n- 再启动即可看到数据导入的日志：\n\n```bash\n[2023-03-10T22:17:18,147][WARN ][logstash.inputs.jdbc     ][test][36d9eb008791f9c7d7369939a04c776115306dd4587ac6b11cef2da0d3147fda] (0.018373s) SELECT * FROM (SELECT * FROM user) AS `t1` LIMIT 500 OFFSET 0\n```\n\n- 根据这些日志也可以反推出流程（特别是里面的子查询，很显眼）\n\n## 检查数据\n\n- 如果不放心可以进 kibana 或者 发送一个请求 查看结果\n\n- ```bash\n  # 建议 MySQL 的每一张表都独立成一个 index，所以需要替换\n  # 对于上面的例子，替换成 user 即可\n  curl GET http://localhost:9200/<index>/_search\n  ```\n\n- 如果 total 里的条数和 MySQL 当中数据条数一致，就已经成功了', NULL, '2023-05-03 19:09:53', NULL);
INSERT INTO `question` VALUES (1022, '2', 'MySQL 与 Elastic Search 的数据同步尝试', '# MySQL 与 Elastic Search 的数据同步尝试\n\n## 起因\n\n1. 毕业设计想要集成一个搜索引擎\n2. MySQL 语句为正向搜索，效率低，不精准\n3. 考虑技术选型，决定使用 Elastic Search 倒排搜索\n4. 然后出现问题：Elastic Search 和 MySQL 之间的数据同步\n5. MySQL 为上游源（生产者），Elastic Search 为下游（消费者）\n6. 考虑两种方案：全量同步和增量同步\n7. 决定使用增量同步\n8. 增量同步目前流行方案为 Canal\n\n## 原理\n\n- Canal 伪装成 MySQL slave 从机，订阅 master MySQL 的 binlog，然后重放到 Elastic Search 数据库中\n\n## 前置准备\n\n- 参照 Canal [官方文档](https://github.com/alibaba/canal/wiki/QuickStart)\n\n1. 下载 canal-example, canal-adapter, canal-deployer, canal-admin 四个压缩包并到对应文件夹解压\n\n   - 建议专门建立一个编程环境的文件夹 environment\n\n2. 开启 MySQL binlog，此处使用 MySQL 8.0\n\n   - 找到 `my.ini`\n\n   - 添加内容\n\n     ```ini\n       [mysqld]\n       log-bin=mysql-bin # 开启 binlog\n       binlog-format=ROW # 选择 ROW 模式\n       server_id=1 # 配置 MySQL replaction 需要定义，不要和 canal 的 slaveId 重复\n     \n     ```\n\n   - 注意，如果下载的 MySQL 8.0 以上可以不用配置，因为默认开启\n\n   - 可以通过 `show variables like \'%log%\'` 查看\n\n   - 配置文件位置\n\n     - Windows：一般为 `C:\\ProgramData\\MySQL\\MySQL Server 5.6\\my.ini`\n     - Ubuntu：一般为 `/etc/mysql/mysql.conf.d/mysqld.cnf`\n\n   - 后续会迁移到 Docker 上\n\n3. 配置数据库用户并授权\n\n   - 按官方文档创建一个 `canal` 的用户，密码也为 `canal`\n\n     ```sql\n       CREATE USER canal IDENTIFIED BY \'canal\';  \n       GRANT SELECT, REPLICATION SLAVE, REPLICATION CLIENT ON *.* TO \'canal\'@\'%\';\n       -- GRANT ALL PRIVILEGES ON *.* TO \'canal\'@\'%\' ;\n       FLUSH PRIVILEGES;\n     \n     ```\n\n4. 配置 canal-deployer\n\n   - 打开 `conf/example` 文件夹，修改 `instance.properties`\n\n     ```properties\n       # position info\n       canal.instance.master.address=127.0.0.1:3306\n     \n       # username/password\n       canal.instance.dbUsername=root\n       canal.instance.dbPassword=\n     \n     ```\n\n   - 修改主机数据库地址和数据库用户名密码\n\n     - 此处的密码是需要连接到主机数据库的用户名和密码\n     - 不是 `canal` 此数据库用户的用户名和密码\n\n   - 其他配置项暂时不用管\n\n5. 开启 canal-deployer\n\n   - 进入 `bin` 目录开启 `startup.bat`(Windows) 或 `startup.sh`(Linux) 即可\n   - 查看日志是否启动成功\n   - 日志一般在 `logs` 文件夹\n     - `canal` 文件夹存放 canal 主服务器启动和停止的日志\n     - 其他文件夹记录该 instance 的 binlog 变动\n   - 注意，如果没有日志，或者日志报错不能启动，修改对应出错代码即可\n     - 因此处使用 JDK17 所以有些 java options 不支持\n     - 报错信息：`canal Unrecognized VM option \'AggressiveOpts\'`\n     - 在 `startup.bat`(Windows) 或 `startup.sh`(Linux) 删除 ` -XX:+AggressiveOpts` 即可\n       - 需要能看懂 bash 脚本，或者直接 <C-h> 搜索也可以\n\n## 使用 canal-example \n\n### 原因\n\n- 首先使用 example 观察是否能够成功运行和消费 binlog\n- 小步前进，成功后再使用更复杂的 adapter\n\n### 步骤\n\n1. canal-example 的配置文件不用改，可以直接运行 `startup.bat`(Windows) 或 `startup.sh`(Linux)\n   - conf 文件夹不要动\n2. 如果开启之后 logs 文件夹没有文件，说明 example 没有运行\n3. 错误日志就在 `bin` 文件夹下面的 `nohup.out` 文件里面\n   - 如果是 JDK17，也需要对应修改 `startup.bat`(Windows) 或 `startup.sh`(Linux)，详情参照[前置准备](#前置准备)第五步\n\n4. 修改完成之后再启动，即可在 logs 文件夹里观察到 example 的消费记录\n\n## 使用 canal-adapter\n\n1. 前置准备，参照 [Elastic Search 启用](https://tinysnow.github.io/技术/实践记录/ElasticSearch启用.html)\n2. 配置 application.yml\n   - srcDataSources 取消注释，改为自己的数据库信息\n     - url 也要改\n     - 如果有兴趣，也可以把 defaultDS 这个名字替换成任意名字，然后同步更改相应 es 文件夹里每一个 dataSourceKey 即可\n   - 注释 `- name: logger`\n   - 取消注释 es，并把 name 改为 es6 或者 es7，一定要改\n3. 配置对应 es 文件夹的每个 yml 文件\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n', NULL, '2023-05-03 19:10:22', NULL);
INSERT INTO `question` VALUES (1023, '2', 'Spring Doc 访问接口文档不显示的问题', '- 访问 /swagger-ui.html 重定向的页面，没有 api 显示\n- 因为用到 Spring Security，所以很有可能请求被拦截了，需要配置 Spring Security 访问 Spring Doc 资源\n  - 注意，Spring Doc 配置和以前 Spring Fox 的 Swagger 放行路径不太一样\n  - 这个导致困惑了好几天，最后根据 Doc 的 Default swagger 页面的 Explore 默认项试出来了\n\n```java\n@Bean\npublic SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {\n    http\n         // 其他配置项可以随便加\n         // Spring Fox 的 Swagger 需要放行 \"/swagger-resources/**\", \"/swagger-ui/**\"\n         // Spring Doc 的 Swagger 需要放行 \"/v2/**\"\n         // 这里放行 v2/v3 依据自己的 Spring Doc 版本决定\n            .antMatchers(\"/v3/**\").permitAll()\n            .anyRequest().authenticated();\n    return http.build();\n}\n```\n\n## ', NULL, '2023-05-03 19:11:04', NULL);
INSERT INTO `question` VALUES (1024, '2', '毕业设计环境准备（Normal Edition）', '## 前提\n\n- 电脑双系统，另一系统为 Ubuntu 22.04\n- 所有环境重新安装\n\n## 安装环境\n\n- 执行所需要的开发环境命令，如果没有会提示安装\n  - 如需要 `node`，没有 `node` 环境则会提示 `sudo apt install nodejs`\n  - 下面是所有环境安装命令\n\n```bash\nsudo apt install openjdk-17-jdk\nsudo apt install mysql-server\nsudo apt install maven\n\nsudo apt install npm\n# 安装 node 版本管理工具 n\nsudo npm install n -g\n# 使用 n 下载最新版\nsudo n stable\n# 然后刷新，否则容易出现 node -v 还是旧本版的情况\nhash -r\n# 特别提醒：node 旧版本不支持 await 等语法，运行不了代码，必须更新版本\n```\n\n## 设置 Maven\n\n```bash\n# 刚下下来的 Maven 的设置 settings.xml 都是默认的，需要自己配置\n# 配置完毕之后以后也就可以不用管了，保存在一个地方以后只用这个 settings.xml\n# 配置完毕之后，进入后端的文件夹，执行以下命令\n# Maven 会自动下载依赖\nmvn clean\nmvn install\n```\n\n- 这个时候可能还是不能运行 Spring Boot 项目\n- （VSCode 环境下）pom.xml 还是会有报错\n- 需要在 VSCode 的设置里添加下面的设置，让 VSCode 引用自定义的 settings.xml\n\n```json\n    \"java.configuration.maven.globalSettings\": \"/etc/maven/settings.xml\",\n    \"java.configuration.maven.userSettings\": \"/etc/maven/settings.xml\",\n```\n\n- 此处的路径根据自己保存的 settings.xml 确定，需要精确到 settings.xml 文件\n- 然后保存刷新一下，稍等片刻就好了\n\n## 配置 MySQL\n\n- 参考 [非官方安装指南](https://www.sjkjc.com/mysql/install-on-ubuntu/)\n- 先启动 MySQL 服务器\n\n```bash\nsudo systemctl start mysql\n```\n\n- 因为此处有 root（Linux 系统）的密码了，可以直接用这个密码\n\n```bash\n# 1. 如果弹出这个句子，可以不用更改 mysql 的 root 密码，想改也可以改\n\nChange the password for root ? ((Press y|Y for Yes, any other key for No) : n\n\n# 2. 如果出现以下段落，就需要重新设置密码\n\n# 2.1. 询问是否使用密码验证\n\nSecuring the MySQL server deployment.\n\nConnecting to MySQL using a blank password.\n\nVALIDATE PASSWORD COMPONENT can be used to test passwords\nand improve security. It checks the strength of password\nand allows the users to set only those passwords which are\nsecure enough. Would you like to setup VALIDATE PASSWORD component?\n\nPress y|Y for Yes, any other key for No:\n\n# 2.2. 密码强度三个级别\n\nThere are three levels of password validation policy:\n\nLOW    Length >= 8\nMEDIUM Length >= 8, numeric, mixed case, and special characters\nSTRONG Length >= 8, numeric, mixed case, special characters and dictionary                  file\n\nPlease enter 0 = LOW, 1 = MEDIUM and 2 = STRONG:\n\n# 2.3. 后面输入密码就可以\n\n# 3. 此处不重设密码，之后询问的所有内容，一路 y 即可\n\n# 4. 登陆 MySQL\n\nmysql -uroot -p\n```\n\n## 下载 Elastic Search\n\n- [链接](https://www.elastic.co/cn/downloads/elasticsearch)：注意不要下成 enterpise search 了\n- 根据自己版本下载\n- 解压后需要修改配置\n\n## VSCode 需要下载的插件\n\n- TypeScript Vue Plugin (Volar)\n- Extension Pack for Java\n- Vite\n- Material Icon Theme（只是为了好看，可以不下）\n\n## 进入 VSCode\n\n- 进入 frontend 前端文件夹，安装所需依赖\n\n```bash\nnpm install --registry=registry.npmmirror.com\n```\n\n- 然后运行项目即可\n\n', NULL, '2023-05-03 19:11:53', NULL);
INSERT INTO `question` VALUES (1025, '2', '连接 Github 出问题', '端口被拒，仔细查看 ssh 连接过程：\n\n```bash\nssh -vT git@github.com\n```\n\n若 DNS 解析错误，在 HOST 里面加上 github。\n\n## ', NULL, '2023-05-03 19:12:21', NULL);
INSERT INTO `question` VALUES (1026, '2', '缺少 javaee 依赖', '```shell\nCannot resolve symbol \'annotation\' / Add Java EE 6 Jars to Module Dependencies\n```\n\n在 `pom.xml` 中添加 javax 的 javaee-api 即可\n\n## ', NULL, '2023-05-03 19:12:52', NULL);
INSERT INTO `question` VALUES (1027, '2', '没有合适的驱动', '```shell\nNo suitable driver found for jdbc:mysql://localhost:3306/train?autoReconnect=true&useUnicode=true&characterEncoding=utf8&useSSL=true&serverTimezone=UTC\n```\n\n- 没有合适的驱动。\n- 在自己的取得连接的方法中 (`getConnection`) 加上以下代码：\n\n```java\nClass.forName(\"com.mysql.cj.jdbc.Driver\");\n```\n\n- 或者给自己的工程添加依赖 `Project Structure->Libraries->添加解析 jar 包`\n\n## ', NULL, '2023-05-03 19:13:16', NULL);
INSERT INTO `question` VALUES (1028, '2', '前端调用后端接口 404', '降低 tomcat 版本，从 10 降到 7。', NULL, '2023-05-03 19:13:37', NULL);
INSERT INTO `question` VALUES (1029, '2', 'VMware 在 Windows 上报错', '## VMware\n\n- VMware 与 Device/Credential Guard 不兼容。**注意：无法与 WSL 共存。**\n\n- ```powershell\n  # 解决方案：\n  bcdedit /set hypervisorlaunchtype off\n  # 重新开启：\n  bcdedit /set hypervisorlaunchtype auto\n  ```', NULL, '2023-05-03 19:14:04', NULL);
INSERT INTO `question` VALUES (1030, '2', 'Git 无法添加文件', '> error: \'<filename>\' does not have a commit checked out fatal: adding files failed when inputting \"git add .\" in command prompt\n\n- 删去子文件夹中的 `.git` 仓库。\n\n> If you have a subdirectory with a `.git` directory and try to `git add .` you will see this message.\n>\n> This can happen if you have a git repo and then create/clone another repo in a subdirectory under that repo.\n>\n> [https://stackoverflow.com/questions/56873278/how-to-fix-error-filename-does-not-have-a-commit-checked-out-fatal-adding](https://stackoverflow.com/questions/56873278/how-to-fix-error-filename-does-not-have-a-commit-checked-out-fatal-adding)', NULL, '2023-05-03 19:14:33', NULL);
INSERT INTO `question` VALUES (1031, '2', 'Git 无法远程提交文件', '> Support for password authentication was removed on August 13, 2021. Please use a personal access token instead.\n\n  在 `IntelliJ` 系列 `IDE` 中进行代码提交时，使用 `Github` 生成的 `Personal Access Token` 作为密码提交。`Github` 从 2021 年 8 月 13 日开始不再支持密码验证。\n\n> [https://github.blog/changelog/2021-08-12-git-password-authentication-is-shutting-down/](', NULL, '2023-05-03 19:14:54', NULL);
INSERT INTO `question` VALUES (1032, '2', 'Git 本地分支远程分支关联错误', '`git branch --set-upstream-to=origin/<correct_remote_branch_name> ` 建立正确的关联。\n\n- 注意：此处的 `origin` 是指当前所在的远程仓库，默认为此名字 。', NULL, '2023-05-03 19:15:17', NULL);
INSERT INTO `question` VALUES (1033, '2', 'Maven 程序包不存在', '- `java: 程序包 org.springframework.boot 不存在`\n- 删除 Maven 的 Repository 文件夹里的所有文件，重新下载（**请确保 Maven 一定配置正确了，并且 Maven 的 `settings.xml` 和 Repository 都存在**）。', NULL, '2023-05-03 19:15:44', NULL);
INSERT INTO `question` VALUES (1034, '2', 'Maven 依赖丢失', '- `Dependency \'org.springframework.boot:spring-boot-starter-web:\' not found`（pom.xml 报错）\n- 请正确配置 Maven（**确保 Maven 的 `settings.xml` 和 Repository 都存在**），然后 `mvn clean && mvn compile`。', NULL, '2023-05-03 19:16:06', NULL);
INSERT INTO `question` VALUES (1035, '2', '无法启动 SpringBoot 项目（IDEA 环境）', '### 无法启动 SpringBoot 项目\n\n#### IDEA 环境\n\n- 表现为没有绿色三角运行符号\n- 正确配置 Java（**一定要有环境变量**）和 Maven，然后 Project Structure，修改对应 SDKs，Language Level，和 Module Language Level。若还是无法启动，修改 pom.xml 里面的 java.version 或者升降 JDK 版本，然后重新 `mvn compile`。', NULL, '2023-05-03 19:16:40', NULL);
INSERT INTO `question` VALUES (1036, '2', '无法启动 SpringBoot 项目（Visual Studio Code 环境）', '#### Visual Studio Code 环境\n\n- pox 报错：\n\n  ```bash\n  Project build error: Non-resolvable parent POM for com.example:demo:0.0.1-SNAPSHOT: org.springframework.boot:spring-boot-starter-parent:pom:3.0.2 failed to transfer from https://repo.maven.apache.org/maven2 during a previous attempt. This failure was cached in the local repository and resolution is not reattempted until the update interval of central has elapsed or updates are forced. Original error: Could not transfer artifact org.springframework.boot:spring-boot-starter-parent:pom:3.0.2 from/to central (https://repo.maven.apache.org/maven2): Connect timed out and \'parent.relativePath\' points at no local POM\n  ```\n\n- 依赖没有正确下载或者加载，删掉默认文件夹（一般是 %USER_HOME%/.m2）重新编译下载就行。\n\n- Maven 在 VSCode 里面好像改不了默认 repository 的位置，不知道为什么', NULL, '2023-05-03 19:17:20', NULL);
INSERT INTO `question` VALUES (1037, '2', 'Maven 无法编译', '- pom.xml 所有配置项均正确，但就是运行不起来\n- 正确配置 Java（**一定要有环境变量**）和 Maven，确保 JDK 各个版本对应相同（如环境变量和 Project，Project 和 Module 等），最后确保 IDEA 能够处理当前 JDK 版本（如 IDEA2020 无法处理 JDK17，需要升级），然后重新 `mvn compile`。', NULL, '2023-05-03 19:17:44', NULL);
INSERT INTO `question` VALUES (1038, '2', 'Uniapp 从 HX 迁移到 WebStorm', '1. 根据 Uniapp 官网给出的命令建立项目\n2. 进入项目，粘贴已经写好的项目文件到 src 目录下\n\n- 文件清单\n  - UI Flamework\n  - App.vue\n  - pages\n  - etc\n- 粘贴 package.json 和 lockfile 到根目录下\n- 在 package.json 中添加相应的额外依赖\n  - 添加 sass-loader 时请务必注意版本问题\n  - 添加 sass-loader 时还要添加 sass 依赖\n\n3. 运行项目\n\n', NULL, '2023-05-03 19:18:30', NULL);
INSERT INTO `question` VALUES (1039, '2', 'Recovery + Root 掉落重新刷入方法（Android 系统）', '- 选择 F:\\Download 下的一个 recovery.img；\n  - 通常是 SHRP_vX.X_stable-Official_violet-XXXXXXXXXX.zip 解压之后得到的 recovery.img\n- 右键 Open in Windows Terminal；\n  - 或者 PowerShell 或者 cmd 也行\n- 输入命令：\n\n```shell\nfastboot flash recovery .\\recovery.img\n```\n\n- 等待刷好，进入 Recovery；\n- 选中 Magisk-vXX-X.zip 文件刷入；\n- 开机；\n- 开启 黑域，存储空间隔离，App Ops，Shizuku 等应用；\n- 若有需要，可上 Magisk 查看是否需要更新核心（Core）；\n- 使用。\n\n', NULL, '2023-05-03 19:19:03', NULL);
INSERT INTO `question` VALUES (1040, '2', 'sql 驱动连接不上，抛出 ClassNotFoundException', '## 解决方案：\n\n检查 sql 驱动版本与所装 sql 版本是否一致。', NULL, '2023-05-03 19:20:08', NULL);
INSERT INTO `question` VALUES (1041, '2', 'MyBatis 加载全局配置文件时出错', '## 解决方案：\n\n全局配置文件的路径应使用 `com/tinysnow/easyvote/conf/xml/mybatis-config.xml` 这种斜杠方式而非 . 的方式。', NULL, '2023-05-03 19:20:30', NULL);
INSERT INTO `question` VALUES (1042, '2', ' MyBatis 不能加载 properties 配置文件', '## 报错\n\n ` Cause: org.apache.ibatis.builder.BuilderException: Error parsing SQL Mapper Configuration. Cause: java.io.IOException: Could not find resource mysql-connection.properties `\n\n## 解决方案\n\n应使用全局的路径 `com/tinysnow/easyvote/conf/mysql-connection.properties` 结果正确。', NULL, '2023-05-03 19:21:20', NULL);
INSERT INTO `question` VALUES (1043, '2', 'MyBatis 不能加载 Mappers 中的 spl 映射配置文件', '## 解决方案：\n\n路径错了，以及没有使用 / 表示法，而使用 . 的表示法。', NULL, '2023-05-03 19:21:48', NULL);
INSERT INTO `question` VALUES (1044, '2', '绑定数据库两个异常的解决办法', '## 绑定数据库两个异常的解决办法\n\n第一个：`Type interface **************************** is not known to the MapperRegistry.`\n\n译文：MapperRegistry不知道类型接口com.tinysnow.easyvote.dao.intrfc.JdbcMethods。\n\n第二个：`Invalid bound statement (not found): ***********************.`\n\n译文：无效的绑定语句（未找到）：com.tinysnow.easyvote.dao.intrfc.JdbcMethods.insertUser。\n\n## 解决方案：\n\n映射文件里面的 namespace 路径应该用 . 号，而非 / 或 \\ ，路径的最后也不要带上文件后缀名，否则将认为文件后缀名所带的 . 号认为是下一个目标路径。并且在配置诸如   等的标签的时候，里面不要配置 databaseId 。 虽说不清楚啥原理，但这么改就好了。', NULL, '2023-05-03 19:22:25', NULL);
INSERT INTO `question` VALUES (1045, '2', '关于使用 Maven 管理依赖中 Mybatis 报错问题', '## 关于使用 Maven 管理依赖中 Mybatis 报错问题\n\n引入 properties 文件后在测试方法中测试最基础的 Mybatis 启动报错，两个异常如下：\n\n```bash\nCause: java.lang.NullPointerException\n at MyBatisStartTest.main(MyBatisStartTest.java:14)\n```\n\n```bash\njava.io.IOException: Could not find resource /mybatis-config.xml\n at MyBatisStartTest.main(MyBatisStartTest.java:14)\n```\n\n解决方案：\n\n1. 资源文件统一扔在 resources 目录下面；\n2. 测试方法中的路径字符串 ` String resource = \"mybatis-config.xml\";` 路径一定要正确，最保险的方法是使用 IDEA 的 copy -> path from source root ；\n3. 最重要的，报 NullPointerException 的原因是 mybatis-config.xml 文件中没有配置 environment 标签，一定要加上如下的代码，否则找死找不到，连接不到数据库。里面的数据库驱动标签什么的按实际情况配置。\n\n```xml\n    <environments default=\"development\">\n        <environment id=\"development\">\n            <transactionManager type=\"JDBC\"/>\n            <dataSource type=\"POOLED\">\n                <property name=\"driver\" value=\"${jdbc.driver}\"/>\n                <property name=\"url\" value=\"${jdbc.url}\"/>\n                <property name=\"username\" value=\"${jdbc.username}\"/>\n                <property name=\"password\" value=\"${jdbc.password}\"/>\n            </dataSource>\n        </environment>\n    </environments>\n```\n\n另，数据库驱动是使用 properties 标签引进来的。\n\n```xml\n<properties resource=\"database.properties\">\n</properties>\n```', NULL, '2023-05-03 19:22:54', NULL);
INSERT INTO `question` VALUES (1046, '2', '关于在 try 块中定义资源导致无法编译的问题', '## 解决方案：\n\n1. 进入 idea -> File -> Settings -> Build, Execution, Deployment -> Compiler -> Java Compiler -> 选择项目旁边的 Target bytecode version -> 改成8\n2. 进入  idea -> File -> Project Structure -> Modules -> Language Level -> 改成 Project default', NULL, '2023-05-03 19:23:16', NULL);

SET FOREIGN_KEY_CHECKS = 1;