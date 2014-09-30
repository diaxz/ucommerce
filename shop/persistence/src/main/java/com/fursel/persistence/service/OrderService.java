/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fursel.persistence.service;

import com.fursel.persistence.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 *
 * @author Dias Nurul Arifin <dias@nsiapay.net>
 */
public interface OrderService {
    
    public Page<Order> getOrders(Pageable pageable, String keywords);
    
}
