package com.epam.jmp.service.impl;

import com.epam.jmp.dao.SubscriptionDAO;
import com.epam.jmp.dao.UserDAO;
import com.epam.jmp.dto.BankCard;
import com.epam.jmp.dto.Subscription;
import com.epam.jmp.dto.User;
import com.epam.jmp.service.Service;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.Optional;


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
    public Optional<Subscription> getSubscriptionByBankCardNumber(String cardNumber) {
        return subscriptionDAO
                .getAllSubscriptions()
                .stream()
                .filter(s -> s.getBankcard().equals(cardNumber))
                .findFirst();
    }

    @Override
    public List<User> getAllUsers() {
        return userDAO.getAllUsers();
    }
}
