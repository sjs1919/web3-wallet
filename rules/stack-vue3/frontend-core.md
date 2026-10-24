# 前端核心规则（Vue3）

## 技术栈与风格（web3-wallet 特定）

参照 `token-hub/web-portal`（当前活跃前端）：

- 依赖：Vue 3.4 + Vite 5 + TypeScript 5.4 + Element Plus 2.6 + Pinia 2.1 + vue-router 4.3 + axios + echarts
- 测试：Vitest 2 + @vue/test-utils + Playwright
- **页面风格继承 SoybeanAdmin 绿色主题**：CSS 变量 `--el-color-primary: #18a058` 体系（含 light-3/5/7/8/9 + dark-2），主色变量定义在 `styles/variables.css`
- 布局手写：`components/`（AppLayout = AppHeader + Content + AppFooter / AuthLayout）
- 页面分类：`views/app`（业务页）/ `views/public`（登录/注册/首页公开页）
- 首页风格：冷蓝底 `--home-bg: #F7F9FB` + 科技网格底纹

## 架构

- **组件分层**：视图（页面路由级）/ 容器（数据编排）/ 逻辑（composable）/ UI 原子（纯展示），业务逻辑禁止写进 UI 组件
- **状态管理边界**：全局 store 只放跨页面共享态，页面私有状态留在组件内，禁止全局状态污染
- **路由权限守卫**：受保护路由必须走统一守卫，禁止组件内自行判断造成权限旁路
- **API 层抽象**：所有请求经统一 API 模块（封装基础地址/拦截器/错误处理），组件内禁止直接发裸请求

## 类型与状态

- 禁止用 `any` 兜底，类型必须完备（接口字段名/类型/可选性与 api-spec.md 一致）
- 每个异步视图必做**加载 / 空 / 错三态**，禁止只写成功路径

## 质量

- 可访问性 a11y：交互元素可键盘操作，图片有替代文本
- i18n：文案不硬编码（单语言项目可豁免，但需在项目 CLAUDE.md 声明）
- 性能：路由懒加载、长列表虚拟滚动、输入类操作防抖节流
- 禁止直接 DOM 操作绕过框架
- 样式作用域：组件样式必须 scoped 或模块化，禁止全局泄漏

## 硬约束

- 仅 Composition API + `<script setup lang="ts">`，禁止 Options API 新增代码
- 严禁 `v-html`；确需渲染富文本时必须经 DOMPurify 消毒
- 金额/价格展示使用统一格式化函数，禁止散落的手写精度处理

## 测试

> TDD 流程、三测分层、测什么/不测什么见 `common/testing.md`。本文件仅前端专属执行细节。

| 类型 | 框架 | 范围 |
|------|------|------|
| 组件逻辑 | Vitest + @vue/test-utils | composable / store / 校验函数 |
| UI 交互 | Vitest + @vue/test-utils | 按钮点击/表单提交/条件渲染 |
| 视觉回归 | Playwright 截图对比 | 核心页面 |
| E2E | Playwright | 关键用户流程（登录→操作→退出） |

- 测试文件与源文件同目录或 `__tests__/` 子目录
- 命名 `xxx.test.ts` 或 `xxx.spec.ts`
- 异步视图必测三态：加载中 → 成功 → 失败
- 表单必测：正常提交 + 必填校验 + 格式校验
- 权限必测：未登录重定向 + 无权限不可见
