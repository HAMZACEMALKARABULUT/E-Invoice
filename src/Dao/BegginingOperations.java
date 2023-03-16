package dao;

import entity.Customer;
import entity.Product;
import service.ProductService;

public class BegginingOperations {
    public static void InstertSampleCustomers(){
        Customer customer=new Customer();
        Customer customer1=new Customer();
        Customer customer2=new Customer();
        Customer customer3=new Customer();
        Customer customer4=new Customer();
        Customer customer5=new Customer();

        customer.setName("hamza");
        customer.setSurname("karabulut");
        customer.setIdentifier("14234234422");
        customer.setMail("hamzacml456@gmail.com");
        customer.setTelNo("05443234323");
        customer.setTaxAdministration("istanbul");
        customer.setTitle("asdvd");

        customer1.setName("CEMAL");
        customer1.setSurname("karabulut");
        customer1.setIdentifier("1443324234");
        customer1.setMail("hmzcml@yaani.com");
        customer1.setTelNo("023423423");
        customer1.setTaxAdministration("istanbul");
        customer1.setTitle("texxxx");

        customer2.setName("hamza");
        customer2.setSurname("karabulut");
        customer2.setIdentifier("1432422342");
        customer2.setMail("hamzacml456@gmail.com");
        customer2.setTelNo("06556665454");
        customer2.setTaxAdministration("istanbul");
        customer2.setTitle("nass");


        customer3.setName("hamza");
        customer3.setSurname("karabulut");
        customer3.setIdentifier("143422344324");
        customer3.setMail("hamzacml456@gmail.com");
        customer3.setTelNo("054354232342");
        customer3.setTaxAdministration("istanbul");
        customer3.setTitle("05423234234");


        customer4.setName("hamza");
        customer4.setSurname("karabulut");
        customer4.setIdentifier("12434234423");
        customer4.setMail("hamzacml456@gmail.com");
        customer4.setTelNo("05423423243");
        customer4.setTaxAdministration("istanbul");
        customer4.setTitle("02342342323");

        customer5.setName("hamza");
        customer5.setSurname("karabulut");
        customer5.setIdentifier("143243248");
        customer5.setMail("hamzacml456@gmail.com");
        customer5.setTelNo("05434234423");
        customer5.setTaxAdministration("istanbul");
        customer5.setTitle("054234234");


         CustomerDao.saveCustomer(customer);
         CustomerDao.saveCustomer(customer1);
         CustomerDao.saveCustomer(customer2);
         CustomerDao.saveCustomer(customer3);
         CustomerDao.saveCustomer(customer4);
         CustomerDao.saveCustomer(customer5);

         Product product=new Product();
         Product product1=new Product();
         Product product2=new Product();
         Product product3=new Product();
         Product product4=new Product();
         Product product5=new Product();
        Product product6=new Product();


        product.setName("elma");
        product.setBrand("");
        product.setBarcode("12345643213");
        product.setQuantity(1000);
        product.setUnitPrice(15.99);
        product.setVatRate((short) 18);

        product1.setName("armut");
        product1.setBrand("");
        product1.setBarcode("34232423");
        product1.setQuantity(1000);
        product1.setUnitPrice(18.99);
        product1.setVatRate((short) 18);


        product2.setName("karpuz");
        product2.setBrand("");
        product2.setBarcode("3423423");
        product2.setQuantity(1000);
        product2.setUnitPrice(3.99);
        product2.setVatRate((short) 1);

        product3.setName("domates");
        product3.setBrand("");
        product3.setBarcode("sdafasf");
        product3.setQuantity(1000);
        product3.setUnitPrice(14.99);
        product3.setVatRate((short) 18);

        product4.setName("patlıcan");
        product4.setBrand("");
        product4.setBarcode("1232343213");
        product4.setQuantity(1000);
        product4.setUnitPrice(20.99);
        product4.setVatRate((short) 8);


        product5.setName("mandalina");
        product5.setBrand("");
        product5.setBarcode("12345643213");
        product5.setQuantity(1000);
        product5.setUnitPrice(11.99);
        product5.setVatRate((short) 1);

        product6.setName("limon");
        product6.setBrand("");
        product6.setBarcode("12343324123");
        product6.setQuantity(1000);
        product6.setUnitPrice(9.99);
        product6.setVatRate((short) 8);


        ProductService.createProduct(product);
        ProductService.createProduct(product1);
        ProductService.createProduct(product2);
        ProductService.createProduct(product3);
        ProductService.createProduct(product4);
        ProductService.createProduct(product5);
        ProductService.createProduct(product6);



    }
}
