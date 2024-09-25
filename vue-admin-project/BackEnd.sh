#!/bin/bash
# 配置部分
JAR_PATH="./BackEnd/target/BackEnd-0.0.1-SNAPSHOT.jar"
LOG_PATH="./logs/BackEnd.log"       # 日志文件的路径
PID_FILE="/tmp/BackEnd.pid"              # PID 文件存储路径

start() {
    if [ -f "$PID_FILE" ]; then
        echo "后端服务器已经在运行 (PID: $(cat $PID_FILE))"
    else
        echo "启动后端服务器..."
        nohup java -jar $JAR_PATH > $LOG_PATH 2>&1 &
        echo $! > $PID_FILE
        echo "后端服务器已启动，PID: $(cat $PID_FILE)"
    fi
}

stop() {
    if [ -f "$PID_FILE" ]; then
        PID=$(cat $PID_FILE)
        echo "停止后端服务器 (PID: $PID)..."
        kill $PID
        rm -f $PID_FILE
        echo "后端服务器已停止"
    else
        echo "后端服务器未运行"
    fi
}

status() {
    if [ -f "$PID_FILE" ]; then
        PID=$(cat $PID_FILE)
        if ps -p $PID > /dev/null; then
            echo "后端服务器正在运行 (PID: $PID)"
        else
            echo "PID 文件存在，但后端服务器未运行"
        fi
    else
        echo "后端服务器未运行"
    fi
}

log() {
    if [ -f "$LOG_PATH" ]; then
        echo "显示日志..."
        tail -f $LOG_PATH
    else
        echo "日志文件不存在"
    fi
}

case "$1" in
    start)
        start
        ;;
    stop)
        stop
        ;;
    status)
        status
        ;;
    log)
        log
        ;;
    *)
        echo "使用: $0 {start|stop|status|log}"
        exit 1
esac

