
package com.car.controller.implementation;


import com.car.model.dao.implementation.SiteDAOImpl;
import com.car.model.entity.Site;


public class SiteControllerImpl extends AbstractControllerImp<Site> {
    public SiteControllerImpl() {
        super(new SiteDAOImpl());
    }
}