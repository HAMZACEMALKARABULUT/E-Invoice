package dao;

import entity.Customer;

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
        customer.setIdentifier("14306383828");
        customer.setMail("hamzacml456@gmail.com");
        customer.setTelNo("05435683873");
        customer.setTaxAdministration("istanbul");
        customer.setTitle("05435683873");

        customer1.setName("CEMAL");
        customer1.setSurname("karabulut");
        customer1.setIdentifier("14306333828");
        customer1.setMail("hmzcml@yaani.com");
        customer1.setTelNo("05435683873");
        customer1.setTaxAdministration("istanbul");
        customer1.setTitle("05435683873");

        customer2.setName("hamza");
        customer2.setSurname("karabulut");
        customer2.setIdentifier("14306383828");
        customer2.setMail("hamzacml456@gmail.com");
        customer2.setTelNo("05435683873");
        customer2.setTaxAdministration("istanbul");
        customer2.setTitle("05435683873");


        customer3.setName("hamza");
        customer3.setSurname("karabulut");
        customer3.setIdentifier("14306383828");
        customer3.setMail("hamzacml456@gmail.com");
        customer3.setTelNo("05435683873");
        customer3.setTaxAdministration("istanbul");
        customer3.setTitle("05435683873");


        customer4.setName("hamza");
        customer4.setSurname("karabulut");
        customer4.setIdentifier("14306383828");
        customer4.setMail("hamzacml456@gmail.com");
        customer4.setTelNo("05435683873");
        customer4.setTaxAdministration("istanbul");
        customer4.setTitle("05435683873");

        customer5.setName("hamza");
        customer5.setSurname("karabulut");
        customer5.setIdentifier("14306383828");
        customer5.setMail("hamzacml456@gmail.com");
        customer5.setTelNo("05435683873");
        customer5.setTaxAdministration("istanbul");
        customer5.setTitle("05435683873");


         CustomerDao.saveCustomer(customer);
         CustomerDao.saveCustomer(customer1);
         CustomerDao.saveCustomer(customer2);
         CustomerDao.saveCustomer(customer3);
         CustomerDao.saveCustomer(customer4);
         CustomerDao.saveCustomer(customer5);



    }
}
