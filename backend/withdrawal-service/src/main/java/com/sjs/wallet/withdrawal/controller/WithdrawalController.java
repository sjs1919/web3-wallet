package com.sjs.wallet.withdrawal.controller;

import com.sjs.wallet.common.result.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 提现接口。
 */
@RestController
@RequestMapping("/withdrawal")
public class WithdrawalController {

    @GetMapping("/health")
    public Result<String> health() {
        return Result.success("withdrawal-service is up");
    }
}
