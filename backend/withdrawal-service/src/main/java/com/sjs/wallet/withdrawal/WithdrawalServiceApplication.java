package com.sjs.wallet.withdrawal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 提现服务入口：提现签名与广播。
 */
@SpringBootApplication(scanBasePackages = "com.sjs.wallet")
@EnableDiscoveryClient
public class WithdrawalServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(WithdrawalServiceApplication.class, args);
    }
}
