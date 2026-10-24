# web3-wallet 项目规范

## 定位

面向 Web3 学习与求职的钱包项目：Vue3 前端 + Java/Spring Cloud Alibaba 后端 + web3j 接链。业务参照 web3-learning「测试资产充值提现系统」：账户/地址管理 → 充值扫描 → 提现签名 → 对账。代码 + 文档 + 规范同仓。

## 红线

- 🚫 **禁止自动 git**：commit / push 必须用户发起
- 🚫 **私钥/助记词等敏感信息严禁入库**：只留占位符，真实值在 `docs/demo/credentials.local.md`（gitignored）或环境变量
- 🚫 **金额用 BigDecimal，禁止 float/double**
- 🚫 **未测试禁止部署**：`mvn test` 全过 + 前端 `npm run build` 成功才可提请部署

## 命令

| 命令 | 说明 |
|------|------|
| `mvn test` | 后端全量单测（WSL 下） |
| `mvn -pl <模块> test` | 单模块测试 |
| `mvn compile` | 后端编译 |
| `cd web && npm run build` | 前端构建（WSL 下，含 vue-tsc 类型检查） |
| `anvil` | 本地链（Foundry，默认 8545） |
| `mvn spring-boot:run` | 单服务启动 |

## 编码原则

1. **先思考** — 明假设、曝困惑、呈权衡；不默选、敢反对
2. **简单优先** — 最少代码解决问题；不预设扩展
3. **外科手术** — 只改要求的；不动相邻代码/格式
4. **目标驱动** — 先定义可验证标准；多步任务列「步骤→验证」清单

## 文档

- 文档仓：`docs/demo/`（01-requirements / 02-specs / 04-plans / 05-tasklist / 08-test / 09-reports / 10-deployment / 11-manuals）
- 任务登记：`docs/demo/05-tasklist/todo-<主题>-YYYYMMDD.md`（索引 `todo.md`）

## 环境

- Java 17、Node >= 18、Maven 3.9+
- 测试 / 构建 / Docker 在 **WSL** 下执行
- 本地链：Foundry `anvil`（默认 8545）
- 代理：家里 Clash `7890` / 公司 `3450`（如访问外部模型/源）
