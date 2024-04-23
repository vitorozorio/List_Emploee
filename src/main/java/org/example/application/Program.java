package org.example.application;

import org.example.entities.Employee;
import org.example.util.EmployeePredicate;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class Program {
    public static void main(String[] args) {
        //home/vitor/temp/Employee.txt


        // Define o padrão de localização para Estados Unidos, afetando formatos de números, datas, etc.
        Locale.setDefault(Locale.US);
        // Inicializa um Scanner para captura de entrada do usuário
        Scanner sc = new Scanner(System.in);

        // Solicita ao usuário para inserir o caminho do arquivo e lê essa entrada
        System.out.print("Entre com o caminho da pasta: ");
        String path = sc.nextLine();

        System.out.print("Entre com o salario minimo: ");
        Double min = sc.nextDouble();


        // Tenta abrir o arquivo no caminho especificado
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            // Lista para armazenar os objetos Product lidos do arquivo
            List<Employee> list = new ArrayList<>();

            // Lê a primeira linha do arquivo
            String line = br.readLine();
            while (line != null) {
                // Divide a linha em nome e preço baseado na vírgula
                String[] fields = line.split(",");
                // Adiciona um novo produto à lista com os dados extraídos
                list.add(new Employee(fields[0], fields[1], Double.parseDouble(fields[2])));
                // Lê a próxima linha do arquivo
                line = br.readLine();
            }

            Comparator<String> comp = (s1, s2) -> s1.toUpperCase().compareTo(s2.toUpperCase());

            List<String> email = list.stream()
                    .filter(p -> p.getSalary() > min)
                    .map( p -> p.getEmail())
                    .sorted(comp)
                    .collect(Collectors.toList());

            email.forEach(System.out::println);

            EmployeePredicate ep = new EmployeePredicate();

            double sum = ep.filteredSum(list, p -> p.getName().charAt(0) == 'M');
            System.out.println("Sum of salary of people whose name starts with 'M': " + String.format("%.2f", sum));



        } catch (IOException e) {
            // Caso ocorra uma exceção de IO, imprime a mensagem de erro
            System.out.println("Erro: " + e.getMessage());
        }
        // Fecha o scanner para evitar vazamento de recursos
        sc.close();

     }

    }


