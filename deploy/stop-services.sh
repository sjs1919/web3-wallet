#!/bin/bash
# 停止全部后端服务（spring-boot:run 进程）
# 用法：bash deploy/stop-services.sh
pkill -f 'spring-boot:run' && echo "services stopped" || echo "no services running"
