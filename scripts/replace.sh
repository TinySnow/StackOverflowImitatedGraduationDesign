#!/usr/bin/env bash

set -Eexuo pipefail

# 将分隔符暂时保存
split=$IFS

# 定义分隔符为回车
IFS=$'\n'

function recursion {

    cd $1

    # 列出当前目录下所有文件和文件夹
    local list=$(ls)

    # 循环处理 list 中的项
    for one in $list; do

        # 如果是一个目录，则进入目录下
        if [[ -d $one ]]; then

            # 递归处理
            recursion $one

        else
            # 打印当前正在处理的文件
            filename=${one%.*}

            sed -i -e "s/ruoyi/tinysnow/g" ${filename}.java
        fi

    done

    cd ../
}

# 顶级文件夹处理
recursion $1

# 将分隔符定义回去
IFS=$split

# 输出完成
echo "done."