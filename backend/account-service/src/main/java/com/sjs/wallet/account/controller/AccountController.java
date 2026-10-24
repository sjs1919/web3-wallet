package com.sjs.wallet.account.controller;

import com.sjs.wallet.account.service.AccountService;
import com.sjs.wallet.common.result.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 账户接口：参数校验 + 调 Service + 组装响应，不含业务逻辑。
 */
@RestController
@RequestMapping("/account")
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/health")
    public Result<String> health() {
        return Result.success(accountService.health());
    }
}
