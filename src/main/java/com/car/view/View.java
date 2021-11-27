package com.car.view;


import com.car.controller.implementation.*;
import com.car.model.entity.*;

import java.util.Scanner;

public class View {
    private static final String ERROR_INVALID_KEY_INPUT = ViewOperations.ERROR_INVALID_KEY_INPUT;
    private static final String EXIT_KEY = ViewOperations.EXIT_KEY;
    private static final String CAR_KEY = "0";
    private static final String ADDRES_KEY = "1";
    private static final String CAR_DEALESHIP_KEY = "2";
    private static final String CAR_TYPE_KEY = "3";
    private static final String CHARACTERISTIC_KEY = "4";
    private static final String COMMENT_KEY = "5";
    private static final String CUSTOMER_KEY = "6";
    private static final String SELLER_KEY = "7";
    private static final String SITE_KEY = "8";
    private static final String TEST_DRIVE_KEY = "9";
    private static final String GET_ALL_KEY = "0";
    private static final String GET_BY_ID_KEY = "1";
    private static final String UPDATE_KEY = "2";
    private static final String CREATE_KEY = "3";
    private static final String DELETE_KEY = "4";
    static Scanner input = new Scanner(System.in);

    private static void printSeparator() {
        System.out.println("--------------------------------------");
    }

    private static String printMainMenu() {
        System.out.println("Choose table to work with:");
        System.out.println(CAR_KEY + "-" + "Car");
        System.out.println(ADDRES_KEY + "-" + "Addres");
        System.out.println(CAR_DEALESHIP_KEY + "-" + "CarDealership");
        System.out.println(CAR_TYPE_KEY + "-" + "CarType");
        System.out.println(CHARACTERISTIC_KEY + "-" + "Characteristic");
        System.out.println(COMMENT_KEY + "-" + "Comment");
        System.out.println(CUSTOMER_KEY + "-" + "Customer");
        System.out.println(SELLER_KEY + "-" + "Seller");
        System.out.println(SITE_KEY + "-" + "Site");
        System.out.println(TEST_DRIVE_KEY + "-" + "TestDrive");
        System.out.println(EXIT_KEY + "-" + "Exit");
        return input.nextLine().toUpperCase();
    }

    private static String printTableMenu() {
        System.out.println("Choose what to do");
        System.out.println(GET_ALL_KEY + "-" + "Get all rows");
        System.out.println(GET_BY_ID_KEY + "-" + "Get row by id");
        System.out.println(UPDATE_KEY + "-" + "Update row");
        System.out.println(CREATE_KEY + "-" + "Create row");
        System.out.println(DELETE_KEY + "-" + "Delete row");
        System.out.println(EXIT_KEY + "-" + "Return to main menu");
        return input.nextLine().toUpperCase();
    }

    public static void execute() {

        main_label:
        while (true) {
            Class currentClass;
            AbstractControllerImp controller;
            ViewOperations viewOperations;

            String mainMenuInput = printMainMenu();
            switch (mainMenuInput) {
                case CAR_KEY:
                    currentClass = Car.class;
                    controller = new CarControllerImpl();
                    break;
                case ADDRES_KEY:
                    currentClass = Addres.class;
                    controller = new AddresControllerImpl();
                    break;
                case CAR_DEALESHIP_KEY:
                    currentClass = CarDealership.class;
                    controller = new CarDealershipControllerImpl();
                    break;
                case CAR_TYPE_KEY:
                    currentClass = CarType.class;
                    controller = new CarTypeControllerImpl();
                    break;
                case CHARACTERISTIC_KEY:
                    currentClass = Characteristic.class;
                    controller = new CharacteristicControllerImpl();
                    break;
                case COMMENT_KEY:
                    currentClass = Comment.class;
                    controller = new CommentControllerImpl();
                    break;
                case CUSTOMER_KEY:
                    currentClass = Customer.class;
                    controller = new CustomerControllerImpl();
                    break;
                case SELLER_KEY:
                    currentClass = Seller.class;
                    controller = new SellerControllerImpl();
                    break;
                case SITE_KEY:
                    currentClass = Site.class;
                    controller = new SiteControllerImpl();
                    break;
                case TEST_DRIVE_KEY:
                    currentClass = TestDrive.class;
                    controller = new TestDriveControllerImpl();
                    break;
                case EXIT_KEY:
                    break main_label;
                default:
                    System.out.println(ERROR_INVALID_KEY_INPUT);
                    continue;
            }
            printSeparator();
            viewOperations = new ViewOperations(controller, currentClass);
            table_label:
            while (true) {
                System.out.println("You are working with " + currentClass.getSimpleName() + " table");
                String tableMenuInput = printTableMenu();
                printSeparator();
                switch (tableMenuInput) {
                    case GET_ALL_KEY:
                        viewOperations.findAll();
                        break;
                    case GET_BY_ID_KEY:
                        viewOperations.get();
                        break;
                    case UPDATE_KEY:
                        viewOperations.update();
                        break;
                    case CREATE_KEY:
                        viewOperations.create();
                        break;
                    case DELETE_KEY:
                        viewOperations.delete();
                        break;
                    case EXIT_KEY:
                        break table_label;
                    default:
                        System.out.println(ERROR_INVALID_KEY_INPUT);
                }
                printSeparator();
            }
        }
    }
}