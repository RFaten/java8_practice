package com.epam.jmp.service;

import com.epam.jmp.dto.BankCard;
import com.epam.jmp.dto.Subscription;
import com.epam.jmp.dto.User;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public interface Service {

    void subscribe(BankCard bankCard);
    public List<Subscription> getAllSubscriptions();

    Optional<Subscription> getSubscriptionByBankCardNumber(String cardNumber);

    void addUser(User user);
    List<User> getAllUsers();
    default double getAverageUsersAge() {
        return getAllUsers()
                .stream()
                .map(User::getBirthday)
                .mapToLong(birthday -> ChronoUnit.YEARS.between(birthday, LocalDate.now()))
                .average()
                .orElse(0);
    }
    static boolean isPayableUser(User user) {
        return ChronoUnit.YEARS.between(user.getBirthday(), LocalDate.now()) > 18;
    }
}
