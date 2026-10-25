package com.sjs.wallet.deposit.controller;

import com.sjs.wallet.common.result.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 充值扫描接口。
 */
@RestController
@RequestMapping("/deposit")
public class DepositScannerController {

    @GetMapping("/health")
    public Result<String> health() {
        return Result.success("deposit-scanner is up");
    }
}
