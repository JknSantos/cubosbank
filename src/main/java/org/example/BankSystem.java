package org.example;


import java.util.HashMap;
import java.util.List;
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

        System.out.println("Digite o endereço de cobrança: ");
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

    public void deleteAccount() {
        System.out.println("Digite o cpf: ");
        String cpf = scanner.nextLine();

        if (accountsDatabase.containsKey(cpf)) {
            accountsDatabase.remove(cpf);
            System.out.println("Conta bancaria removida com sucesso!");
        } else {
            System.out.println("Conta não encontrada!");
        }
    }

    public void actionsAccountAfterLogin(String indetifier, String password) {
        BankAccount bankAccount = accountsDatabase.get(indetifier);
        int option;
        do {
            System.out.println("Escolha uma opção: ");
            System.out.println("1 - Saque");
            System.out.println("2 - Depositar");
            System.out.println("3 - Transferir");
            System.out.println("4 - Extrato");
            System.out.println("0 - Sair");

            option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    System.out.println("Digite a quantidade: ");
                    int quantidadeSaque = scanner.nextInt();
                    scanner.nextLine();
                    bankAccount.withdraw(quantidadeSaque);
                    break;
                case 2:
                    System.out.println("Digite a quantidade: ");
                    int quantidadeDeposito = scanner.nextInt();
                    scanner.nextLine();
                    bankAccount.deposit(quantidadeDeposito);
                    break;
                case 3:
                    //TODO a ser implementado
                    System.out.println("Digite a quantidade: ");
                    int quantidadeTransferencia = scanner.nextInt();
                    scanner.nextLine();
                    break;
                case 4:
                    List<String> transactions = bankAccount.getTransactions();
                    System.out.println(transactions);

                    System.out.println("1. Imprimir extrato");
                    System.out.println("0. voltar");
                    option = scanner.nextInt();
                    scanner.nextLine();
                    if (option == 1) {
                        bankAccount.printStatement();
                    } else {
                        System.out.println("Voltando ao menu");
                    }
                case 0:
                    System.out.println("Até a proxima " + bankAccount.getCustomerName());
            }
        } while (option != 0);
    }

    public void login() {

        System.out.println("Login...");
        System.out.println("Digite seu CPF: ");
        String cpf = scanner.nextLine();
        System.out.println("Digite sua senha: ");
        String password = scanner.nextLine();

        if (accountsDatabase.containsKey(cpf)) {
            BankAccount bankAccount = accountsDatabase.get(cpf);
            boolean passwordMatch = bankAccount.verifyPassword(password);

            if (passwordMatch) {
                System.out.println("Usuario logado com sucesso. Bem vindo(a) " + bankAccount.getCustomerName());
                System.out.println("Saldo atual: " + bankAccount.getBalance());
                actionsAccountAfterLogin(cpf, password);
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
                case 1:
                    bankSystem.login();
                    break;
                case 2:
                    bankSystem.createAccount();
                    break;
                case 3:
                    System.out.println("Deletar conta...");
                    bankSystem.deleteAccount();
                default:
                    System.out.println("Operação invalida. Tente novamente.");
            }
        } while (option != 0);

    }
}