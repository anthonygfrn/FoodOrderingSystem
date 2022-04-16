package com.food;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static String sessionAdminUsername;
    static int sessionAdminPassword;
    static int session = 0;

    static Data fileData;
    static Payment payment;

    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);

        fileData = new Data();
        payment = new Payment();

        ArrayList<Food> foodArrayList = new ArrayList<>();
        int foodIndex = 1;
        for (String foodPrice : fileData.FoodReturn().split(",")) {
            switch (foodIndex) {
                case 1:
                    foodArrayList.add(new Food("Pizza", Double.parseDouble(foodPrice)));
                    break;
                case 2:
                    foodArrayList.add(new Food("Hamburger", Double.parseDouble(foodPrice)));
                    break;
                case 3:
                    foodArrayList.add(new Food("Pasta", Double.parseDouble(foodPrice)));
                    break;
                case 4:
                    foodArrayList.add(new Food("Beef", Double.parseDouble(foodPrice)));
                    break;
                case 5:
                    foodArrayList.add(new Food("Salad", Double.parseDouble(foodPrice)));
                    break;
            }
            foodIndex++;
        }

        ArrayList<Admin> adminArrayList = new ArrayList<>();
        adminArrayList.add(new Admin("admin", 123));

        firstChoose:
        while (true) {
            int firstChoosed = 0; // Invariant
            if (session == 1) {
                firstChoosed = 2;
            } else if (session == 0) {
                System.out.println("Welcome To The Food Ordering System");
                System.out.println("Options Displaying...");

                System.out.println("1.FOOD MENU\n2.ADMIN LOGIN\n3.EXIT\n");
                System.out.println("Please Enter Your Choice: ");
                firstChoosed = input.nextInt();
                assert (firstChoosed > 0 && firstChoosed <= 3): "Input should be between 1-3";
            }

            if (firstChoosed == 1) {
                double total = 0;
                int again = 0;
                againChoose:
                while (again == 0) {
                    System.out.println("Food Menu. Please Select your Food");
                    int foodOutIndex = 1; // Invariant
                    for (Food foodObj : foodArrayList) {
                        System.out.println("Press " + foodOutIndex + " for " + foodObj.getName() + ". Price is " + foodObj.getPrice());
                        foodOutIndex++;
                    }
                    System.out.println("What do you want?");
                    int CostumerChoosed = input.nextInt();
                    int piece = 0;

                    switch (CostumerChoosed) { // Invariant
                        case 1:
                            System.out.println("You chose Pizza. ");
                            System.out.println("How many pizza do you want to buy?");
                            piece = input.nextInt();
                            assert (piece > 0): "Number of item must be more than 0";

                            System.out.println("Food Total price is " + payment.calculateFood(foodArrayList.get(CostumerChoosed - 1).getPrice(), piece));
                            total += payment.calculateFood(foodArrayList.get(CostumerChoosed - 1).getPrice(), piece);
                            System.out.println("Total Price is " + total);
                            break;
                        case 2:
                            System.out.println("You chose Hamburger. ");
                            System.out.println("How many Hamburger do you want to buy?");
                            piece = input.nextInt();
                            assert (piece > 0): "Number of item must be more than 0";

                            System.out.println("Food Total price is " + payment.calculateFood(foodArrayList.get(CostumerChoosed - 1).getPrice(), piece));
                            total += payment.calculateFood(foodArrayList.get(CostumerChoosed - 1).getPrice(), piece);
                            System.out.println("Total Price is " + total);
                            break;
                        case 3:
                            System.out.println("You chose Pasta. ");
                            System.out.println("How many Pasta do you want to buy?");
                            piece = input.nextInt();
                            assert (piece > 0): "Number of item must be more than 0";

                            System.out.println("Food Total price is " + payment.calculateFood(foodArrayList.get(CostumerChoosed - 1).getPrice(), piece));
                            total += payment.calculateFood(foodArrayList.get(CostumerChoosed - 1).getPrice(), piece);
                            System.out.println("Total Price is " + total);
                            break;
                        case 4:
                            System.out.println("You chose Beef. ");
                            System.out.println("How many Beef do you want to buy?");
                            piece = input.nextInt();
                            assert (piece > 0): "Number of item must be more than 0";

                            System.out.println("Food Total price is " + payment.calculateFood(foodArrayList.get(CostumerChoosed - 1).getPrice(), piece));
                            total += payment.calculateFood(foodArrayList.get(CostumerChoosed - 1).getPrice(), piece);
                            System.out.println("Total Price is " + total);
                            break;
                        case 5:
                            System.out.println("You chose Salad. ");
                            System.out.println("How many Salad do you want to buy?");
                            piece = input.nextInt();
                            assert (piece > 0): "Number of item must be more than 0";

                            System.out.println("Food Total price is " + payment.calculateFood(foodArrayList.get(CostumerChoosed - 1).getPrice(), piece));
                            total += payment.calculateFood(foodArrayList.get(CostumerChoosed - 1).getPrice(), piece);
                            System.out.println("Total Price is " + total);
                            break;
                        default:
                            assert false : "Input should be between 1-5";
                    }

                    System.out.println("Is there anything you want to add to your order?; if yes press 0 or no press 1");
                    again = input.nextInt(); // Invariant
                    assert (again >= 0 && again <= 1): "Input should be either 0 or 1";

                    if (again == 1) {
                        System.out.println("Please choice your payment method");
                        System.out.println("Press 1 to pay with Credit Card, press 2 to pay with cash");
                        int cash_or_card = 2;
                        cash_or_card = input.nextInt(); // invariant
                        assert ( cash_or_card > 0 &&  cash_or_card <= 2): "Input should be between 1-2";

                        int card_password;
                        double cashAmount;
                        double change = 0;

                        if (cash_or_card == 1) {
                            System.out.println("Please swipe the card.");
                            System.out.println("Process is in progress. Please wait...");
                            System.out.println("");
                            System.out.println("Please enter your card password: ");
                            card_password = input.nextInt();
                            System.out.println("Loading. ");
                            System.out.println("Amount paid:" + total + "Process completed. ");
                            System.out.println("Thanks for choosing us.");
                        } else if (cash_or_card == 2) {
                            System.out.println("Please enter cash amount");

                            cashAmount = input.nextDouble(); // invariant
                            assert (cashAmount >= 0): "Amount must be a positive number";
                            // code below can be used, but not suitable for production
                            // assert (cashAmount > total): "Amount must be more than total";

                            double cashAmount2, newCashAmount;

                            if (cashAmount < total) {

                                System.out.println("Not enough money");
                                double missingAmount = total - cashAmount;
                                System.out.println("Missing amount is: " + missingAmount);
                                System.out.println("Please give missing amount ");
                                cashAmount2 = input.nextDouble();
                                newCashAmount = cashAmount + cashAmount2;

                                if (newCashAmount > total) {
                                    change = cashAmount2 - total;
                                    System.out.println("Change is " + change + "Please take your change. ");
                                } else if (newCashAmount == total) {
                                    System.out.println("Payment is completed. ");
                                }

                            } else if (cashAmount > total) {
                                change = cashAmount - total;
                                System.out.println("Change is " + change + " Please take your change. ");
                            } else if (cashAmount == total) {
                                System.out.println("Payment is completed. ");
                            } else
                                System.out.println("Wrong choice. ");
                        }
                    }
                }
            } else if (firstChoosed == 2) {
                String username;
                int password;

                if (session == 0) {
                    System.out.println("Enter username: ");
                    username = input.next(); // Invariant
                    assert (username.equals("admin")) : "No Username with the name " + username + " is stored in the database"; // should only be used in production
                    controlFor:
                    for (Admin adminGelen : adminArrayList) {
                        if (username.equals(adminGelen.getUsername())) {
                            System.out.println("Enter password: ");
                            password = input.nextInt();
                            if (password == adminGelen.getPassword()) {
                                sessionAdminUsername = adminGelen.getUsername();
                                sessionAdminPassword = adminGelen.getPassword();
                                session = 1;
                                break controlFor;
                            } else {
                                System.out.println("Wrong Password");
                            }
                        } else {
                            System.out.println("Wrong username");
                        }
                    }
                }

                if (session == 1) {
                    System.out.println("Which product price do you want to update ? ");
                    System.out.println("Enter 1 For Pizza");
                    System.out.println("Enter 2 For Hamburger");
                    System.out.println("Enter 3 For Pasta");
                    System.out.println("Enter 4 For Beef");
                    System.out.println("Enter 5 For Salad");
                    System.out.println("Enter 6 For be unssession");
                    System.out.println("Enter 7 For exit");
                    int adminChoosed = input.nextInt(); // Invariant
                    double newPrice;
                    AdminPriceSwitch:
                    switch (adminChoosed) {
                        case 1:
                            System.out.println("Enter new price for Pizza");
                            newPrice = input.nextDouble();
                            fileData.FoodArr(adminChoosed, newPrice);
                            break AdminPriceSwitch;
                        case 2:
                            System.out.println("Enter new price for Hamburger");
                            newPrice = input.nextDouble();
                            fileData.FoodArr(adminChoosed, newPrice);
                            break AdminPriceSwitch;
                        case 3:
                            System.out.println("Enter new price for Pasta");
                            newPrice = input.nextDouble();
                            fileData.FoodArr(adminChoosed, newPrice);
                            break AdminPriceSwitch;
                        case 4:
                            System.out.println("Enter new price for Beef");
                            newPrice = input.nextDouble();
                            fileData.FoodArr(adminChoosed, newPrice);
                            break AdminPriceSwitch;
                        case 5:
                            System.out.println("Enter new price for Salad");
                            newPrice = input.nextDouble();
                            fileData.FoodArr(adminChoosed, newPrice);
                            break AdminPriceSwitch;
                        case 6:
                            session = 0;
                            break AdminPriceSwitch;
                        case 7:
                            System.exit(0);
                        default:
                            assert false : "Input should be between 1-7";
                    }
                }
            } else if (firstChoosed == 3) {
                System.out.println("Thank You");
                break firstChoose;
            }
        }
    }
}