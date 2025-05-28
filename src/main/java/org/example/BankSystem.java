package org.example;


import java.util.HashMap;
import java.util.Scanner;

public class BankSystem {

    private HashMap<String, BankAccount> accountsDatabase;
    private Scanner scanner;

    public BankSystem(HashMap<String, BankAccount> accountsDatabase, Scanner scanner) {
        this.accountsDatabase = accountsDatabase;
        this.scanner = scanner;
    }

    public void createAccount() {
        System.out.println("Criando uma nova conta:");

        System.out.println("Digite o nome do cliente: ");
        String name = scanner.nextLine();

        System.out.println("Digite o endereço de cobbrança: ");
        String address = scanner.nextLine();

        System.out.println("Digite uma senha: ");
        String password = scanner.nextLine();

        System.out.println("Digite o saldo Inicial: ");
        double balance = scanner.nextDouble();
        scanner.nextLine();

        System.out.println("Digite o tipo da conta: (1 para física, 2 para jurídica):");
        int accountType = scanner.nextInt();
        scanner.nextLine();

        if (accountType == 1) {
            System.out.println("Digite o CPF: ");
            String cpf = scanner.nextLine();
            PersonalAccount personalAccount = new PersonalAccount(name, address, balance, password, cpf);
            accountsDatabase.put(cpf, personalAccount);
            System.out.println("Conta pessoal criada com sucesso!");
        } else if (accountType == 2) {
            System.out.println("Digite o CNPJ: ");
            String cnpj = scanner.nextLine();
            PersonalAccount personalAccount = new PersonalAccount(name, address, balance, password, cnpj);
            accountsDatabase.put(cnpj, personalAccount);
            System.out.println("Conta pessoal criada com sucesso!");
        } else {
            System.out.println("Operação inválida!");
        }
    }

    public void login(String indetifier, String password) {
        if (accountsDatabase.containsKey(indetifier)) {
            BankAccount bankAccount = accountsDatabase.get(indetifier);
            boolean passwordMatch = bankAccount.verifyPassword(password);

            if (passwordMatch) {
                System.out.println("Usuario logado com sucesso. Bem vindo(a) " + bankAccount.getCustomerName());
            }
        } else {
            System.out.println("Conta não encontrada");
        }
    }

    public static void main(String[] args) {
        HashMap<String, BankAccount> accounts = new HashMap<>();
        Scanner scanner = new Scanner(System.in);

        BankSystem bankSystem = new BankSystem(accounts, scanner);

        int option;
        do {
            System.out.println("Seja bem vindo(a) ao CubosBank");
            System.out.println("1. Login");
            System.out.println("2. Criar conta");
            System.out.println("3. Deletar conta");
            System.out.println("0. Sair");
            System.out.println("Digite a opção desejada: ");

            option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Operação invalida. Tente novamente.");
            }
        } while (option != 0);

    }
}