package com.lagou.edu.service;

import com.lagou.edu.pojo.Account;

import java.util.List;

public interface AccountService {
    List<Account> queryAccountList() throws Exception;
}
