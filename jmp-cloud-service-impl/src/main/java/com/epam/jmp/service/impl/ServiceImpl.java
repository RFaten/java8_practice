package com.epam.jmp.service.impl;

import com.epam.jmp.dao.SubscriptionDAO;
import com.epam.jmp.dao.UserDAO;
import com.epam.jmp.dto.BankCard;
import com.epam.jmp.dto.Subscription;
import com.epam.jmp.dto.SubscriptionNotFoundException;
import com.epam.jmp.dto.User;
import com.epam.jmp.service.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;


public class ServiceImpl implements Service {
    SubscriptionDAO subscriptionDAO;
    UserDAO userDAO;

    public ServiceImpl() {
        subscriptionDAO = new SubscriptionDAO();
        userDAO = new UserDAO();
    }

    @Override
    public void subscribe(BankCard bankCard) {
        subscriptionDAO.addSubscription(new Subscription(bankCard.getNumber(), LocalDate.now()));
    }


    @Override
    public List<Subscription> getAllSubscriptions() {
        return subscriptionDAO.getAllSubscriptions();
    }

    @Override
    public Subscription getSubscriptionByBankCardNumber(String cardNumber) {
        return subscriptionDAO
                .getAllSubscriptions()
                .stream()
                .filter(s -> s.getBankcard().equals(cardNumber))
                .findFirst()
                .orElseThrow(() -> new SubscriptionNotFoundException("No subscription was found for card number " + cardNumber));
    }

    @Override
    public void addUser(User user) {
        userDAO.addUser(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userDAO.getAllUsers();
    }

    @Override
    public List<Subscription> getAllSubscriptionsByCondition(Predicate<Subscription> predicate) {
        return getAllSubscriptions().stream().filter(predicate).collect(Collectors.toUnmodifiableList());
    }
}
