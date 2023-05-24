package com.izibiz.service.service;


import com.izibiz.service.adapter.CustomerAdapter;
import com.izibiz.service.domain.Customer;
import com.izibiz.service.enums.CustomerState;
import com.izibiz.service.enums.ErrorCode;
import com.izibiz.service.exception.CustomException;

import com.izibiz.service.validation.ValidationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {
    @Autowired
    CustomerAdapter customerAdapter;

    public Optional<Customer> createCustomer(Customer customer, Long userId) {


        customer.setUserId(userId);
        customer.setState(CustomerState.ACTIVE.toString());

        if (customer.getIdentifier() != null && ValidationUtil.isIdNo(customer.getIdentifier().toString())
                && !existsByIdentifierAndUserId(customer.getIdentifier(), userId)) {

            return personalDataControl(customer) ? customerAdapter.save(customer) : Optional.empty();
        } else if (customer.getIdentifier() != null && ValidationUtil.isTaxNo(customer.getIdentifier().toString())
                && !existsByIdentifierAndUserId(customer.getIdentifier(), userId)) {
            return companyDataControl(customer) ? customerAdapter.save(customer) : Optional.empty();
        }

        throw (new CustomException("Tc kimlik no veya vergi numarası benzersiz olmalıdır .", ErrorCode.REPEATING_IDENTIFIER));
    }

    public Boolean personalDataControl(Customer customer) {
        if (customer.getName() == null || !ValidationUtil.isText(customer.getName())) {
            throw (new CustomException("İsim bilgisini doğru girdiğinizden emin olunuz ", ErrorCode.MISSING_PARAMETER));
        } else if (customer.getSurname() == null || !ValidationUtil.isText(customer.getSurname())) {
            throw (new CustomException("Soyisim bilgisini doğru girdiğinizden emin olunuz ", ErrorCode.MISSING_PARAMETER));
        } else if (customer.getTelNo() == null || !ValidationUtil.isTelNo(customer.getTelNo())) {
            throw (new CustomException("Telefon bilgisini doğru girdiğinizden emin olunuz ", ErrorCode.MISSING_PARAMETER));
        } else if (!(customer.getMail() == null || ValidationUtil.isMail(customer.getMail()))) {
            throw (new CustomException("Mail bilgisini doğru girdiğinizden emin olunuz ", ErrorCode.MISSING_PARAMETER));
        } else if (!(customer.getTitle() == null || ValidationUtil.isText(customer.getTitle()))) {
            throw (new CustomException("Unvan bilgisini doğru girdiğinizden emin olunuz ", ErrorCode.MISSING_PARAMETER));
        } else if (!(customer.getTaxAdministration() == null || ValidationUtil.isText(customer.getTaxAdministration()))) {
            throw (new CustomException("Vergi Dairesi bilgisini doğru girdiğinizden emin olunuz ", ErrorCode.MISSING_PARAMETER));
        }
        return true;

    }

    public Boolean companyDataControl(Customer customer) {


        if (!(customer.getName() == null || ValidationUtil.isText(customer.getName()))) {
            throw (new CustomException("İsim bilgisini doğru girdiğinizden emin olunuz ", ErrorCode.MISSING_PARAMETER));
        } else if (!(customer.getSurname() == null || ValidationUtil.isText(customer.getSurname()))) {
            throw (new CustomException("Soyisim bilgisini doğru girdiğinizden emin olunuz ", ErrorCode.MISSING_PARAMETER));
        } else if (customer.getTelNo() == null || !ValidationUtil.isTelNo(customer.getTelNo())) {
            throw (new CustomException("Telefon bilgisini doğru girdiğinizden emin olunuz ", ErrorCode.MISSING_PARAMETER));
        } else if (!(customer.getMail() == null || ValidationUtil.isMail(customer.getMail()))) {
            throw (new CustomException("Mail bilgisini doğru girdiğinizden emin olunuz ", ErrorCode.MISSING_PARAMETER));
        } else if (customer.getTitle() == null || !ValidationUtil.isText(customer.getTitle())) {
            throw (new CustomException("Unvan bilgisini doğru girdiğinizden emin olunuz ", ErrorCode.MISSING_PARAMETER));
        } else if (customer.getTaxAdministration() == null || !ValidationUtil.isText(customer.getTaxAdministration())) {
            throw (new CustomException("Vergi dairesi bilgisini doğru girdiğinizden emin olunuz ", ErrorCode.MISSING_PARAMETER));
        }
        return true;
    }


    public Customer updateCustomer(Customer customer, Long userId) {
        if (customer.getIdentifier() != null && ValidationUtil.isIdNo(customer.getIdentifier().toString())
                && existsByIdentifierAndUserId(customer.getIdentifier(), userId)) {
            return personalDataControl(customer) ? customerAdapter.save(customer).get() :null;

        } else if (customer.getIdentifier() != null && ValidationUtil.isTaxNo(customer.getIdentifier().toString())
                && existsByIdentifierAndUserId(customer.getIdentifier(), userId)) {

            return companyDataControl(customer) ? customerAdapter.save(customer).get() :null ;
        }

        throw (new CustomException(("Tanımlayıcı bilgiler değiştirilememektedir."),ErrorCode.MISSING_PARAMETER));

    }

    public Boolean deleteCustomer(Long id, Long userId) {
        Optional<Customer> customer = findById(id, userId);
        if (customer.isPresent()) {
            if (customer.get().getState().equals(CustomerState.PASSIVE.toString())) {

                throw(new CustomException("Böyle bir müşteri bulunmamaktadır.",ErrorCode.RECORD_NOT_FOUND));
            } else {
                customer.get().setState(CustomerState.PASSIVE.toString());
                customerAdapter.save(customer.get());
                return true;
            }
        } else throw(new CustomException("Böyle bir müşteri bulunmamaktadır.",ErrorCode.RECORD_NOT_FOUND));
    }
    public List<Customer> getCustomers(Long userId) {

        return customerAdapter
                .findCustomersByUserId(userId);}
    public Optional<Customer> findById(Long id, Long userId) {

        return customerAdapter
                .findByUserIdAndId(userId, id);
    }
    public Boolean existsByIdentifierAndUserId(String identifier, Long userId) {

        return customerAdapter
                .existsByIdentifierAndUserId(identifier, userId);
    }
}

//mail zorunlu değil
//validasyon
//servise obje gönder
//tostring overrriding
//telefon no al zorunlu
//vergi dairesi al zorunlu




/*   public static String isTrueFormatCycle(String printText,String regex,boolean isNullable) {
         String inputText;
         if (isValidText( inputText= CustomerController.getInput(printText), regex, isNullable)) {

             return inputText;
         } else {
             System.out.println("Yanlış Formatta Giriş Yaptınız.\nDoğru Formatta Giriniz.");

             return isTrueFormatCycle(printText, regex, isNullable);
         }

     } */



