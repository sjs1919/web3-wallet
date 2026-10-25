# todo-基础设施-2026-10-25

> 目标：补齐微服务基础设施 — Nacos 注册中心 + 全模块骨架 + 网关路由端到端跑通。业务逻辑（余额查询/转账）下轮开始。
> 范围确认：2026-10-25 用户选定「先补基础设施」。

## T1 启动基础依赖（Nacos / MySQL / Redis）

- [x] WSL `service docker start` 启动 docker 守护进程
- [x] `docker compose -f deploy/docker-compose.yml up -d` 拉起 3 个容器
- [x] 验证：Nacos 8848 可达、MySQL 3306 连接、Redis 6379 ping
- 验收：`docker compose ps` 三个服务 up；curl `http://127.0.0.1:8848/nacos` 返回 302（登录页跳转）
- 结果：Nacos=302 ✅ / MySQL=web3_wallet 库已建 ✅ / Redis=PONG ✅

## T2 新建 deposit-scanner / withdrawal-service 骨架

- [x] 父 pom `backend/pom.xml` modules 增加两个模块
- [x] `deposit-scanner`：pom + `DepositScannerApplication` + `DepositScannerController(/health)` + application.yml（端口 8082，nacos discovery，name=deposit-scanner）
- [x] `withdrawal-service`：pom + `WithdrawalServiceApplication` + `WithdrawalController(/health)` + application.yml（端口 8083，nacos discovery，name=withdrawal-service）
- 验收：两个模块编译通过；注册后 Nacos 控制台服务列表可见
- 附加：修复 common `GlobalExceptionHandler` 未被扫描问题 — 各服务主类加 `scanBasePackages="com.sjs.wallet"`（account-service 一并修）

## T3 后端编译 + 测试门禁

- [x] `cd backend && mvn clean install -DskipTests` 全模块编译通过
- [x] `mvn test` 通过（现有用例全绿，无测试模块跳过）
- 验收：编译无错误；测试 0 fail
- 结果：5 模块 jar 全部生成（common/gateway/account-service/deposit-scanner/withdrawal-service）✅

## T4 端到端验证（Nacos + 网关路由）

- [x] 启动 account-service（8081）、gateway（8080）、deposit-scanner（8082）、withdrawal-service（8083）
- [x] Nacos 控制台（8848/nacos）服务列表可见 4 个服务
- [x] 网关路由：`curl http://127.0.0.1:8080/api/v1/account/health` 返回 `Result.success`
- 验收：4 服务注册 + 网关 health 通
- 结果：Nacos 服务列表 = gateway/account-service/withdrawal-service/deposit-scanner（4/4）✅
- 结果：直连 8081/8082/8083 health 全通 ✅；网关 8080 路由 ✅
- **坑**：gateway 首次 503 — 缺 `spring-cloud-starter-loadbalancer`（`lb://` 无法解析），补依赖后恢复

## 踩坑记录

- [ ] 新坑追加 `docs/pitfalls/`
