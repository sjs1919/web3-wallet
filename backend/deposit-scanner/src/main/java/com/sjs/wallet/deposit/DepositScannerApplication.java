package com.sjs.wallet.deposit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 充值扫描服务入口：扫链确认充值入账。
 */
@SpringBootApplication(scanBasePackages = "com.sjs.wallet")
@EnableDiscoveryClient
public class DepositScannerApplication {

    public static void main(String[] args) {
        SpringApplication.run(DepositScannerApplication.class, args);
    }
}
