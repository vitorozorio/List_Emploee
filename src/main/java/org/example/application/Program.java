package org.example.application;

import org.example.entities.Employee;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {


        // Define o padrão de localização para Estados Unidos, afetando formatos de números, datas, etc.
        Locale.setDefault(Locale.US);
        // Inicializa um Scanner para captura de entrada do usuário
        Scanner sc = new Scanner(System.in);

        // Solicita ao usuário para inserir o caminho do arquivo e lê essa entrada
        System.out.print("Entre com o caminho da pasta: ");
        String path = sc.nextLine();

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







        } catch (IOException e) {
            // Caso ocorra uma exceção de IO, imprime a mensagem de erro
            System.out.println("Erro: " + e.getMessage());
        }
        // Fecha o scanner para evitar vazamento de recursos
        sc.close();

     }

    }


