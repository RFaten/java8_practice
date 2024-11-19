package com.epam.jmp.run;

import com.epam.jmp.dto.BankCard;
import com.epam.jmp.dto.BankCardType;
import com.epam.jmp.dto.User;
import com.epam.jmp.bank.impl.BankImpl;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        User user1 = new User("Ali", "Adam", LocalDate.of(1990, 6, 15));
        BankImpl bank = new BankImpl();
        BankCard bankCard = bank.createBankCard(user1, BankCardType.CREDIT);
        System.out.println(bankCard);
    }
}