package car.view;

import car.controller.implementation.*;
import car.model.entity.*;




import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class View {

    private final Map<String, Printable> menu = new LinkedHashMap<>();
    private static final Scanner SCANNER = new Scanner(System.in);


    private final AddresController addresController = new AddresController();
    private final CarController carController = new CarController();
    private final CarDealershipController carDealershipController = new CarDealershipController();
    private final CarTypeController carTypeController = new CarTypeController();
    private final CharacteristicController charcteristicController = new CharacteristicController();
    private final CommentController commentController = new CommentController();
    private final CustomerController customerControler = new CustomerController();
    private final SellerController sellerController = new SellerController();
    private final SiteController siteController = new SiteController();
    private final TestDriveController testDriveController = new TestDriveController();


    public View() {
        menu.put("11", this::getAllAddresses);
        menu.put("12", this::getAddresById);
        menu.put("13", this::createAddres);
        menu.put("14", this::updateAddres);
        menu.put("15", this::deleteAddres);

        menu.put("21", this::getAllCars);
        menu.put("22", this::getCarById);
        menu.put("23", this::createCar);
        menu.put("24", this::updateCar);
        menu.put("25", this::deleteCar);

        menu.put("31", this::getAllCarDealerships);
        menu.put("32", this::getCarDealershipById);
        menu.put("33", this::createCarDealership);
        menu.put("34", this::updateCarDealership);
        menu.put("35", this::deleteCarDealership);

        menu.put("41", this::getAllCharcteristics);
        menu.put("42", this::getCharacteristicById);
        menu.put("43", this::createCharcteristic);
        menu.put("44", this::updateCharcteristic);
        menu.put("45", this::deleteCharcteristic);

        menu.put("51", this::getAllComments);
        menu.put("52", this::getCommentById);
        menu.put("53", this::createComment);
        menu.put("54", this::updateComment);
        menu.put("55", this::deleteComment);

        menu.put("61", this::getAllSellers);
        menu.put("62", this::getSellerById);
        menu.put("63", this::createSeller);
        menu.put("64", this::updateSeller);
        menu.put("65", this::deleteSeller);

        menu.put("71", this::getAllCarTypes);
        menu.put("72", this::getCarTypeById);
        menu.put("73", this::createCarType);
        menu.put("74", this::updateCarType);
        menu.put("75", this::deleteCarType);

        menu.put("81", this::getAllSites);
        menu.put("82", this::getSiteById);
        menu.put("83", this::createSite);
        menu.put("84", this::updateSite);
        menu.put("85", this::deleteSite);

        menu.put("91", this::getAllTestDrives);
        menu.put("92", this::getTestDriveById);
        menu.put("93", this::createTestDrive);
        menu.put("94", this::updateTestDrive);
        menu.put("95", this::deleteTestDrive);

        menu.put("101", this::getAllCustomers);
        menu.put("102", this::getCustomerById);
        menu.put("103", this::createCustomer);
        menu.put("104", this::updateCustomer);
        menu.put("105", this::deleteCustomer);

    }

    public final void show() {
        String input;
        Menu showMenu = new Menu();
        showMenu.displayMenu();
        System.out.println("\nEnter numbers:\n");
        do {
            try {
                input = SCANNER.next();
                menu.get(input).print();
            } catch (Exception ignored) {
            }
        } while (SCANNER.hasNext());
    }
    private void getAllAddresses() throws SQLException {
        System.out.println("\n");
        System.out.println(addresController.findAll() + "\n");
    }

    private void getAddresById() throws SQLException {
        System.out.println("\nEnter ID: ");
        Integer id = SCANNER.nextInt();
        System.out.println(addresController.findById(id) + "\n");
    }

    private Addres getAddresInputs() {
        System.out.println("\nEnter city: ");
        String city = SCANNER.next();
        System.out.println("Enter street: ");
        String street = SCANNER.next();
        return new Addres(city, street);
    }

    private void createAddres() throws SQLException {
        System.out.println("\n");
        Addres addres = getAddresInputs();
        addresController.create(addres);
        System.out.println("Addres was successfully created!\n");
    }

    private void updateAddres() throws SQLException {
        System.out.println("\nEnter ID for updating: ");
        Integer id = SCANNER.nextInt();
        Addres addres = getAddresInputs();
        addres.setId(id);
        addresController.update(addres.getId(), addres);
        System.out.println("Updated addres with ID = " + id + "\n");
    }

    private void deleteAddres() throws SQLException {
        System.out.println("\nEnter ID to delete addres: ");
        int id = SCANNER.nextInt();
        addresController.delete(id);
        System.out.println("Deleted addres with ID = " + id + "\n");
    }


    private void getAllCars() throws SQLException {
        System.out.println("\n");
        System.out.println(carController.findAll() + "\n");
    }

    private void getCarById() throws SQLException {
        System.out.println("\nEnter id: ");
        Integer id = SCANNER.nextInt();
        System.out.println(addresController.findById(id) + "\n");
    }


    private Car getCarInputs() {
        System.out.println("\nEnter brand: ");
        String brand = SCANNER.next();
        System.out.println("Enter graduathion year: ");
        Integer graduathionYear = SCANNER.nextInt();
        System.out.println("Enter serNum: ");
        Integer serNum = SCANNER.nextInt();
        System.out.println("Enter is new: ");
        Boolean  isNew = SCANNER.nextBoolean();
        System.out.println("Enter is sold: ");
        Boolean isSold = SCANNER.nextBoolean();
        System.out.println("Enter comments id: ");
        Integer commentsId = SCANNER.nextInt();
        System.out.println("Enter seller id: ");
        Integer sellerId = SCANNER.nextInt();

        return new Car(brand, graduathionYear, serNum, isNew,
                isSold, commentsId,sellerId);
    }

    private void createCar() throws SQLException {
        System.out.println("\n");
        Car car = getCarInputs();
        carController.create(car);
        System.out.println("Car was successfully created!\n");
    }

    private void updateCar() throws SQLException {
        System.out.println("\nEnter ID for updating: ");
        Integer id = SCANNER.nextInt();
        Car car = getCarInputs();
        car.setId(id);
        carController.update(car.getId(), car);
        System.out.println("Updated car with id = " + id + "\n");
    }

    private void deleteCar() throws SQLException {
        System.out.println("\nEnter id to delete car: ");
        Integer id = SCANNER.nextInt();
        carController.delete(id);
        System.out.println("Deleted car with id = " + id + "\n");
    }


    private void getAllCarDealerships() throws SQLException {
        System.out.println("\n");
        System.out.println(carDealershipController.findAll() + "\n");
    }

    private void getCarDealershipById() throws SQLException {
        System.out.println("\nEnter Id: ");
        Integer id = SCANNER.nextInt();
        System.out.println(carDealershipController.findById(id) + "\n");
    }

    private CarDealership getCarDealershipInputs() {
        System.out.println("\nEnter id: ");
        Integer id = SCANNER.nextInt();
        System.out.println("Enter site: ");
        String site = SCANNER.next();
        System.out.println("Enter email: ");
        String email = SCANNER.next();
        System.out.println("Enter car id: ");
        Integer carId = SCANNER.nextInt();
        System.out.println("Enter addres id: ");
        Integer addresId = SCANNER.nextInt();
        return new CarDealership(id, site, email, carId, addresId);
    }

    private void createCarDealership() throws SQLException {
        System.out.println("\n");
        CarDealership carDealership = getCarDealershipInputs();
        carDealershipController.create(carDealership);
        System.out.println("CarDealership was successfully created!\n");
    }

    private void updateCarDealership() throws SQLException {
        System.out.println("\nEnter Name for updating: ");
        Integer id = SCANNER.nextInt();
        System.out.println("\nEnter country name for updating: ");
        String site = SCANNER.next();
        CarDealership carDealership = getCarDealershipInputs();
        carDealership.setId(id);
        carDealership.setSite(site);
        carDealershipController.update(carDealership.getId(), carDealership);
        System.out.println("Updated car dealership with id = " + id + "\n");
    }

    private void deleteCarDealership() throws SQLException {
        System.out.println("\nEnter id to delete region: ");
        Integer id = SCANNER.nextInt();
        carDealershipController.delete(id);
        System.out.println("Deleted car dealership with id = " + id + "\n");
    }


    private void getAllCharcteristics() throws SQLException {
        System.out.println("\n");
        System.out.println(charcteristicController.findAll() + "\n");
    }

    private void getCharacteristicById() throws SQLException {
        System.out.println("\nEnter ID: ");
        Integer id = SCANNER.nextInt();
        System.out.println(charcteristicController.findById(id) + "\n");
    }

    private Characteristic getCharacteristicInputs() {
        System.out.println("\nEnter drive: ");
        String drive = SCANNER.next();
        System.out.println("Enter color: ");
        String color = SCANNER.next();
        System.out.println("Enter car body: ");
        String carBody = SCANNER.next();
        System.out.println("Enter transmission : ");
        String transmission  = SCANNER.next();
        System.out.println("Enter car id : ");
        Integer carId  = SCANNER.nextInt();
        return new Characteristic(drive, color, carBody, transmission, carId);
    }

    private void createCharcteristic() throws SQLException {
        System.out.println("\n");
        Characteristic characteristic = getCharacteristicInputs();
        charcteristicController.create(characteristic);
        System.out.println("Characteristic was successfully created!\n");
    }

    private void updateCharcteristic() throws SQLException {
        System.out.println("\nEnter ID for updating: ");
        Integer id = SCANNER.nextInt();
        Characteristic characteristic = getCharacteristicInputs();
        characteristic.setId(id);
        charcteristicController.update(characteristic.getId(), characteristic);
        System.out.println("Updated characteristic with ID = " + id + "\n");
    }

    private void deleteCharcteristic() throws SQLException {
        System.out.println("\nEnter ID to delete characteristic: ");
        int id = SCANNER.nextInt();
        charcteristicController.delete(id);
        System.out.println("Deleted characteristic with ID = " + id + "\n");
    }

    private void getAllComments() throws SQLException {
        System.out.println("\n");
        System.out.println(commentController.findAll() + "\n");
    }
    private void getCommentById() throws SQLException {
        System.out.println("\nEnter ID: ");
        Integer id = SCANNER.nextInt();
        System.out.println(commentController.findById(id) + "\n");
    }

    private Comment getCommentInputs() {
        System.out.println("\nEnter name: ");
        String name = SCANNER.next();
        System.out.println("Enter messange: ");
        String messange= SCANNER.next();
        System.out.println("Enter customer id: ");
        Integer customerId = SCANNER.nextInt();
        return new Comment(name, messange,customerId );
    }

    private void createComment() throws SQLException {
        System.out.println("\n");
        Comment comment = getCommentInputs();
        commentController.create(comment);
        System.out.println("Comment was successfully created!\n");
    }

    private void updateComment() throws SQLException {
        System.out.println("\nEnter ID for updating: ");
        Integer id = SCANNER.nextInt();
        Comment comment = getCommentInputs();
        comment.setId(id);
        commentController.update(comment.getId(), comment);
        System.out.println("Updated Comment with ID = " + id + "\n");
    }

    private void deleteComment() throws SQLException {
        System.out.println("\nEnter ID to delete hotel: ");
        int id = SCANNER.nextInt();
        commentController.delete(id);
        System.out.println("Deleted Comment with ID = " + id + "\n");
    }


    private void getAllCustomers() throws SQLException {
        System.out.println("\n");
        System.out.println(customerControler.findAll() + "\n");
    }

    private void getCustomerById() throws SQLException {
        System.out.println("\nEnter ID: ");
        Integer id = SCANNER.nextInt();
        System.out.println(customerControler.findById(id) + "\n");
    }

    private Customer getCustomerInputs() {
        System.out.println("\nEnter first name: ");
        String firstName = SCANNER.next();
        System.out.println("Enter last name: ");
        String lastName = SCANNER.next();
        System.out.println("Enter email: ");
        String email = SCANNER.next();
        return new Customer(firstName, lastName, email);
    }

    private void createCustomer() throws SQLException {
        System.out.println("\n");
        Customer customer = getCustomerInputs();
        customerControler.create(customer);
        System.out.println("Customer was successfully created!\n");
    }

    private void updateCustomer() throws SQLException {
        System.out.println("\nEnter ID for updating: ");
        Integer id = SCANNER.nextInt();
        Customer customer = getCustomerInputs();
        customer.setId(id);
        customerControler.update(customer.getId(), customer);
        System.out.println("Updated customer with ID = " + id + "\n");
    }

    private void deleteCustomer() throws SQLException {
        System.out.println("\nEnter ID to delete customer: ");
        int id = SCANNER.nextInt();
        customerControler.delete(id);
        System.out.println("Deleted customer with ID = " + id + "\n");
    }


    private void getAllSellers() throws SQLException {
        System.out.println("\n");
        System.out.println(sellerController.findAll() + "\n");
    }

    private void getSellerById() throws SQLException {
        System.out.println("\nEnter ID: ");
        Integer id = SCANNER.nextInt();
        System.out.println(sellerController.findById(id) + "\n");
    }

    private Seller getSellerInputs() {
        System.out.println("\nEnter first name: ");
        String firstName = SCANNER.next();
        System.out.println("Enter email: ");
        String email = SCANNER.next();
        System.out.println("Enter last name: ");
        String lastName = SCANNER.next();
        System.out.println("Enter phone number: ");
        Integer phoneNumber = SCANNER.nextInt();

        return new Seller(firstName,email, lastName, phoneNumber);
    }

    private void createSeller() throws SQLException {
        System.out.println("\n");
        Seller seller = getSellerInputs();
        sellerController.create(seller);
        System.out.println("Seller was successfully created!\n");
    }

    private void updateSeller() throws SQLException {
        System.out.println("\nEnter ID for updating: ");
        Integer id = SCANNER.nextInt();
        Seller seller = getSellerInputs();
        seller.setId(id);
        sellerController.update(seller.getId(), seller);
        System.out.println("Updated seller with ID = " + id + "\n");
    }

    private void deleteSeller() throws SQLException {
        System.out.println("\nEnter ID to delete user: ");
        int id = SCANNER.nextInt();
        sellerController.delete(id);
        System.out.println("Deleted seller with ID = " + id + "\n");
    }


    private void getAllSites() throws SQLException {
        System.out.println("\n");
        System.out.println(siteController.findAll() + "\n");
    }

    private void getSiteById() throws SQLException {
        System.out.println("\nEnter ID: ");
        Integer id = SCANNER.nextInt();
        System.out.println(siteController.findById(id) + "\n");
    }

    private Site getSiteInputs() {
        System.out.println("\nEnter car Dealership Id: ");
        Integer carDealershipId = SCANNER.nextInt();
        System.out.println("Enter car id: ");
        Integer carId = SCANNER.nextInt();
        return new Site( carDealershipId, carId);
    }

    private void createSite() throws SQLException {
        System.out.println("\n");
        Site site = getSiteInputs();
        siteController.create(site);
        System.out.println("Site was successfully created!\n");
    }

    private void updateSite() throws SQLException {
        System.out.println("\nEnter ID for updating: ");
        Integer id = SCANNER.nextInt();
        Site site = getSiteInputs();
        site.setId(id);
        siteController.update(site.getId(), site);
        System.out.println("Updated site with ID = " + id + "\n");
    }

    private void deleteSite() throws SQLException {
        System.out.println("\nEnter ID to delete site: ");
        int id = SCANNER.nextInt();
        siteController.delete(id);
        System.out.println("Deleted site with ID = " + id + "\n");
    }


    private void getAllTestDrives() throws SQLException {
        System.out.println("\n");
        System.out.println(testDriveController.findAll() + "\n");
    }

    private void getTestDriveById() throws SQLException {
        System.out.println("\nEnter ID: ");
        Integer id = SCANNER.nextInt();
        System.out.println(testDriveController.findById(id) + "\n");
    }

    private TestDrive getTestDriveInputs() {
        System.out.println("\nEnter brand: ");
        String brand = SCANNER.next();
        System.out.println("Enter car id: ");
        Integer carId = SCANNER.nextInt();
        return new TestDrive(brand, carId);
    }

    private void createTestDrive() throws SQLException {
        System.out.println("\n");
        TestDrive testDrive = getTestDriveInputs();
        testDriveController.create(testDrive);
        System.out.println("Test drive was successfully created!\n");
    }

    private void updateTestDrive() throws SQLException {
        System.out.println("\nEnter ID for updating: ");
        Integer id = SCANNER.nextInt();
        TestDrive testDrive = getTestDriveInputs();
        testDrive.setId(id);
        testDriveController.update(testDrive.getId(), testDrive);
        System.out.println("Updated test drive  with ID = " + id + "\n");
    }

    private void deleteTestDrive() throws SQLException {
        System.out.println("\nEnter ID to delete test drive: ");
        int id = SCANNER.nextInt();
        testDriveController.delete(id);
        System.out.println("Deleted test drive  with ID = " + id + "\n");
    }

    private void getAllCarTypes() throws SQLException {
        System.out.println("\n");
        System.out.println(carTypeController.findAll() + "\n");
    }

    private void getCarTypeById() throws SQLException {
        System.out.println("\nEnter id: ");
        Integer id = SCANNER.nextInt();
        System.out.println(carTypeController.findById(id) + "\n");
    }

    private CarType getCarTypeInputs() {
        System.out.println("\nEnter car type: ");
        String type = SCANNER.next();
        System.out.println("Enter car id: ");
        Integer carId = SCANNER.nextInt();
        return new CarType(type, carId);
    }

    private void createCarType() throws SQLException {
        System.out.println("\n");
        CarType carType = getCarTypeInputs();
        carTypeController.create(carType);
        System.out.println("Car type was successfully created!\n");
    }

    private void updateCarType() throws SQLException {
        System.out.println("\nEnter ID for updating: ");
        Integer id = SCANNER.nextInt();
        CarType carType = getCarTypeInputs();
        carType.setId(id);
        carTypeController.update(carType.getId(), carType);
        System.out.println("Updated addres with ID = " + id + "\n");
    }

    private void deleteCarType() throws SQLException {
        System.out.println("\nEnter ID to delete car type: ");
        int id = SCANNER.nextInt();
        carTypeController.delete(id);
        System.out.println("Deleted car type with ID = " + id + "\n");
    }

}