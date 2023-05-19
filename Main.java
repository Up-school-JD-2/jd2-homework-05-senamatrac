import com.upschool.senamatrac.homework5.data.CreditCart;
import com.upschool.senamatrac.homework5.data.User;
import com.upschool.senamatrac.homework5.exception.*;
import com.upschool.senamatrac.homework5.service.CartValidationService;
import com.upschool.senamatrac.homework5.service.ShoppingService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
        boolean isNotValid;
        System.out.print("İsim ve soyisim giriniz: ");
        String fullname ;
        do{
            fullname = sc.nextLine();
            if(!fullname.contains(" ") || fullname.split(" ").length != 2){
                System.out.println("Lütfen isim ve soy isminizi aralarına boşluk koyarak giriniz");
            }
        }while(!fullname.contains(" ") || fullname.split(" ").length != 2);

        System.out.println("Lütfen kart bilgilerini giriniz:");
        String cartNumber;
        String lastValidDate;
        String ccv;
        String amount;

        System.out.println("Kart numarası: ");
        do {
            isNotValid = false;
            cartNumber = sc.nextLine();
            try {
                CartValidationService.isValidateCartNumber(cartNumber);
            } catch (InvalidCartNumberException e) {
                System.out.println(e.getMessage());
                isNotValid = true;
                System.out.println("Lütfen tekrar giriniz:");
            }
        } while (isNotValid);

        System.out.println("Son kullanma tarihi:");
        do {
            isNotValid = false;
            lastValidDate = sc.nextLine();
            try {
                CartValidationService.isValidateDate(lastValidDate);
            } catch (InvalidDateException e) {
                System.out.println(e.getMessage());
                isNotValid = true;
                System.out.println("Lütfen tekrar giriniz:");
            }
        } while (isNotValid);

        System.out.println("Güvenlik kodu:");
        do {
            isNotValid = false;
            ccv = sc.nextLine();
            try {
                CartValidationService.isValidateCCV(ccv);
            } catch (InvalidCCVException e) {
                System.out.println(e.getMessage());
                isNotValid = true;
                System.out.println("Lütfen tekrar giriniz:");
            }
        } while (isNotValid);


        System.out.println("Ödeme tutarını giriniz:");
        do {
            isNotValid = false;
            amount = sc.nextLine();
            try {
                ShoppingService.isValidateAmountFormat(amount);
            } catch (InvalidAmountException e) {
                System.out.println(e.getMessage());
                isNotValid = true;
                System.out.println("Lütfen tekrar giriniz:");
            }
        } while (isNotValid);

        String[] nameSplit = fullname.split(" ");
        int i = 0;
        boolean failed;
        do {
            failed = false;
            try {
                ShoppingService.pay(Double.parseDouble(amount), new CreditCart(cartNumber, lastValidDate, ccv, new User(nameSplit[0], nameSplit[1])));
               } catch (SystemNotWorkingException e) {
                failed = true;
                System.out.println(e.getMessage() + " random number is "+e.getRandomCause());
                i++;
                if (i < 2) {
                    System.out.println("Tekrar deneniyor...");
                }
            }
        } while (failed && (i<2));

        if(!failed){
            System.out.println("Ödeme işleme başarılı.İyi günler");
        }else{
            System.out.println("Sistem şuanda yanıt vermiyor daha sonra tekrar deneyiniz.");
        }
    }
}
