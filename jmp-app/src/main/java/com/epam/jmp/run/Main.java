package com.epam.jmp.run;

import com.epam.jmp.dto.BankCard;
import com.epam.jmp.dto.BankCardType;
import com.epam.jmp.dto.User;
import com.epam.jmp.bank.impl.BankImpl;
import com.epam.jmp.bank.Bank;
import com.epam.jmp.service.Service;
import com.epam.jmp.service.impl.ServiceImpl;

import java.time.LocalDate;
import java.util.List;

public class Main {
    private static Bank bank = new BankImpl();
    private static Service service = new ServiceImpl();
    private static List<User> users;
    private static List<BankCard> creditCards;
    private static List<BankCard> debitCards;
    public static void main(String[] args) {
        createTestData();
        testBankCardCreationLogic();
        testServiceAddUserMethod();
        testServiceSubscribeMethod();
        testServiceGetSubscriptionByBankCardNumberMethod();
        testGetAverageUsersAge();
        testIsPayableUser();
    }

    private static void createTestData() {
        users =
                List.of(
                        new User("Ali", "Adam", LocalDate.of(1990, 6, 15)),
                        new User("Faten", "Rost", LocalDate.of(1991, 5, 14)),
                        new User("Danial", "Jackson", LocalDate.of(2009, 10, 11)),
                        new User("Kamila", "Noah", LocalDate.of(1985, 9, 22))
                );
        creditCards =
                users.stream().map((user) -> bank.createBankCard(user, BankCardType.CREDIT)).toList();
        debitCards =
                users.stream().map((user) -> bank.createBankCard(user, BankCardType.DEBIT)).toList();

    }


    private static void testBankCardCreationLogic() {
        System.out.println("*******Testing Bank Card Creation Logic*******");
        System.out.println("*******Credit Cards are:*******");
        System.out.println(creditCards);
        System.out.println("*******Debit Cards are:*******");
        System.out.println(debitCards);
    }

    private static void testServiceAddUserMethod() {
        users.forEach(service::addUser);
    }


    private static void testServiceSubscribeMethod() {
        creditCards.forEach(service::subscribe);
        System.out.println("*******Subscriptions created are:*******");
        service.getAllSubscriptions().forEach(System.out::println);

    }

    private static void testServiceGetSubscriptionByBankCardNumberMethod() {
        System.out.println("*******Testing Get Subscription By Bank Card Number :*******");
        System.out.println(service.getSubscriptionByBankCardNumber(creditCards.getFirst().getNumber()));
    }

    private static void testGetAverageUsersAge() {
        System.out.println("*******Average users age is:*******");
        System.out.println(service.getAverageUsersAge());
    }

    private static void testIsPayableUser() {
        System.out.println("*******Testing Is Payable User :*******");
        System.out.println(Service.isPayableUser(users.getFirst()));
        System.out.println(Service.isPayableUser(users.get(2)));
    }
}