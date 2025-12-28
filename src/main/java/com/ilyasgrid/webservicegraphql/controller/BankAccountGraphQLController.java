package com.ilyasgrid.webservicegraphql.controller;

import com.ilyasgrid.webservicegraphql.dto.ReceiveAccount;
import com.ilyasgrid.webservicegraphql.dto.RequestAccount;
import com.ilyasgrid.webservicegraphql.service.BankAccountService;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/graphql")
@RequiredArgsConstructor
public class BankAccountGraphQLController {
    private final BankAccountService bankAccountService;

    @QueryMapping
    public List<ReceiveAccount> getAllAccounts() {
        return bankAccountService.getAllAccounts();
    }

    @MutationMapping
    public ReceiveAccount addAccount(@Argument RequestAccount bankAccount) { // Return ReceiveAccount
        return bankAccountService.addAccount(bankAccount)
                .orElseThrow(() -> new RuntimeException("Save failed"));
    }
}
