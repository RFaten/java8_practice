package com.epam.jmp.dao;


import com.epam.jmp.dto.Subscription;

import java.util.ArrayList;
import java.util.List;

public class SubscriptionDAO {
    private final List<Subscription> subscriptions;

    public SubscriptionDAO() {
        subscriptions = new ArrayList<>();
    }

    public void addSubscription(Subscription subscription) {
        subscriptions.add(subscription);
    }

    public List<Subscription> getAllSubscriptions() {
        return subscriptions;
    }

}
