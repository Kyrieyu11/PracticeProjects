#/bin/bash
LOG_PATH="../logs/FontEnd.log"
PID_FILE="/tmp/FontEnd.pid"
start() {
    if [ -f "$PID_FILE" ]; then
        echo "前端服务器已经在运行 (PID: $(cat $PID_FILE))"
    else
        echo "启动前端服务器..."
        cd ./vue-admin-template
        nohup npm run dev > $LOG_PATH 2>&1 &
        cd ../
        echo $! > $PID_FILE
        echo "前端服务器已启动，PID: $(cat $PID_FILE)"
    fi
}
stop() {
    if [ -f "$PID_FILE" ]; then
        PID=$(cat $PID_FILE)
        echo "停止前端服务 (PID: $PID)..."
        kill $PID
        rm -f $PID_FILE
        echo "前端服务已停止"
    else
        echo "前端服务未运行"
    fi
}

status() {
    if [ -f "$PID_FILE" ]; then
        PID=$(cat $PID_FILE)
        if ps -p $PID > /dev/null; then
            echo "前端服务正在运行 (PID: $PID)"
        else
            echo "PID 文件存在，但前端服务未运行"
        fi
    else
        echo "前端服务未运行"
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