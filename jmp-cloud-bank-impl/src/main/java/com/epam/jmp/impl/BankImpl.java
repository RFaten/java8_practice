package com.epam.jmp.impl;

import com.epam.jmp.dto.*;
import com.epam.jmp.service.Bank;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.function.BiFunction;

public class BankImpl implements Bank {
    Map<BankCardType, BiFunction<User, Double, BankCard>> cardCreator = new HashMap<>();

    public BankImpl() {
        cardCreator.put(BankCardType.CREDIT, (user, limit) -> new CreditBankCard(UUID.randomUUID().toString(), user, limit));
        cardCreator.put(BankCardType.DEBIT, (user, balance) -> new DebitBankCard(UUID.randomUUID().toString(), user, balance));
    }

    @Override
    public BankCard createBankCard(User user, BankCardType cardType) {
        return cardCreator.get(cardType).apply(user, 0d);
    }
}
