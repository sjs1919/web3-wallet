package com.sjs.wallet.account.service.impl;

import com.sjs.wallet.account.service.AccountService;
import org.springframework.stereotype.Service;

/**
 * 账户业务实现。
 */
@Service
public class AccountServiceImpl implements AccountService {

    @Override
    public String health() {
        return "account-service alive";
    }
}
