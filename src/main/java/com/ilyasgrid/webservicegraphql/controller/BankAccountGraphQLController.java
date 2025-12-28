package com.ilyasgrid.webservicegraphql.controller;

import com.ilyasgrid.webservicegraphql.dto.ReceiveAccount;
import com.ilyasgrid.webservicegraphql.dto.RequestAccount;
import com.ilyasgrid.webservicegraphql.service.BankAccountService;
import lombok.NoArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/graphql")
@NoArgsConstructor
public class BankAccountGraphQLController {
    private BankAccountService bankAccountService;

    public BankAccountGraphQLController(BankAccountService bankAccountService) {
        this.bankAccountService = bankAccountService;
    }
    @QueryMapping
    public List<ReceiveAccount> getAllAccounts() {
        return bankAccountService.getAllAccounts();
    }
    @MutationMapping
    public RequestAccount addAccount(@Argument RequestAccount bankAccount) {
        return bankAccountService.addAccount(bankAccount)
                .orElseThrow(() -> new RuntimeException("Save failed"));
    }
}
