# API 契约（api-spec）

> **前后端接口唯一事实源**。后端改接口必须更新本文档；前端对接必须先查本文档，核对 8 项清单，禁止凭空捏造。
> 关联规则：`rules/common/api-contract.md`、`rules/stack-java/api.md`

## 约定

- 统一前缀：`/api/v1`
- 网关：`gateway`（8080）→ `lb://` 各服务，`StripPrefix=2`（去掉 `/api/v1`）
- 统一响应：`{ "code": 0, "message": "success", "data": ... }`（common `Result`），失败 data 为 null
- 错误码表：`docs/03-design/error-codes.md`
- 分页响应：`{ "list": [], "total": N, "page": 1, "pageSize": 20 }`

## 接口清单

### 账户服务（account-service，端口 8081，网关路径 `/api/v1/account/**`）

| 方法 | 路径 | 说明 | 请求 | 响应 |
|------|------|------|------|------|
| GET | `/api/v1/account/health` | 健康检查 | - | `Result<String>` |

> 最小学习闭环待扩展接口（本地链转账 + 余额查询）：
> - 地址生成（助记词 → 地址）
> - 余额查询（原生币 / ERC-20）
> - 转账（签名 → 广播）
> - 交易状态查询

### 网关（gateway，8080）

| 方法 | 路径 | 说明 |
|------|------|------|
| GET | `/api/v1/account/health` | 经网关路由到 account-service |
