#!/bin/bash
# 本地开发：后台启动全部后端服务（Nacos/MySQL/Redis 需先用 docker compose 拉起）
# 用法：bash deploy/start-services.sh
# 说明：日志写到 /root/logs/web3-wallet/<module>.log；停止用 deploy/stop-services.sh
set -e
cd "$(dirname "$0")/../backend"

LOG_DIR=/root/logs/web3-wallet
mkdir -p "$LOG_DIR"

start_one() {
  local module="$1"
  DB_PASSWORD=root nohup mvn -q -pl "$module" spring-boot:run > "$LOG_DIR/$module.log" 2>&1 &
  echo "started $module -> $LOG_DIR/$module.log (pid $!)"
}

start_one account-service
start_one deposit-scanner
start_one withdrawal-service
start_one gateway
echo "all services launching"
