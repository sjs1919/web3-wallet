# web3-wallet · Web3 钱包（学习项目）

> 面向 Web3 学习的钱包项目：Vue3 前端 + Java/Spring Cloud Alibaba 后端 + web3j 接链。
> 业务参照 web3-learning「测试资产充值提现系统」，当前第一版为**最小学习闭环**（本地链转账 + 余额查询），验证技术栈可行性后再扩展充值/提现/对账。
>
> 开源地址：<https://github.com/sjs1919/web3-wallet>

## 技术栈

| 层 | 技术 |
|----|------|
| 前端 | Vue3 + TypeScript + Vite + Element Plus + Pinia |
| 后端 | Java 17 + Spring Boot 3.x + Spring Cloud Alibaba（Nacos + Gateway + OpenFeign） |
| 接链 | web3j（以太坊） |
| 存储 | MySQL + Redis |
| 链 | Foundry `anvil` 本地链 |

## 目录结构

```
web3-wallet/
├── backend/               # 后端（Maven 多模块根）
│   ├── pom.xml            # Maven 多模块根
│   ├── common/            # 公共模块（统一响应/异常/错误码）
│   ├── gateway/           # Spring Cloud Gateway 网关
│   ├── account-service/   # 账户/地址/钱包管理服务
│   ├── deposit-scanner/   # 充值扫描服务（后续阶段）
│   └── withdrawal-service/ # 提现签名服务（后续阶段）
├── web/                   # Vue3 前端
├── deploy/                # 部署相关（Dockerfile / docker-compose / 部署脚本）
├── docs/                  # 文档仓（01-requirements ~ 11-manuals）
├── rules/                 # 项目编码规范（common / stack-java / stack-vue3）
└── CLAUDE.md
```

## 快速开始（第一版·最小学习闭环）

1. 启动本地链：`anvil`（Foundry）
2. 启动 Nacos：`docker run -p 8848:8848 nacos/nacos-server`（或本地）
3. 启动后端服务：`cd backend && mvn -pl account-service spring-boot:run`
4. 启动前端：`cd web && npm install && npm run dev`

## 参照与路线

- 学习主线：`web3-learning` 仓库（12 周计划 / 主项目「测试资产充值提现系统」）
- 规范模板：`agent-learning/project-standards`（rules 三层体系，stack-java 为本项目新增）
- 单库协作：参照 `flex-fab-agent`（代码 + 文档 + 规范同仓）

## License

仅供个人学习使用。
