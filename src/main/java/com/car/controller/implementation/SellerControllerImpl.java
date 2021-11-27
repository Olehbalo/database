
package com.car.controller.implementation;


import com.car.model.dao.implementation.SellerDAOImpl;
import com.car.model.entity.Seller;


public class SellerControllerImpl extends AbstractControllerImp<Seller> {
    public SellerControllerImpl() {
        super(new SellerDAOImpl());
    }
}