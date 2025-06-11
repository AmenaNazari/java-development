package com.pluralsight;

import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("This application needs a Username and Password to run!");
            System.exit(1);
        }

        String username = args[0];
        String password = args[1];

        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter the last name of the actors you want to search: ");
        String lastNameToSearch = scanner.nextLine();

        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setUrl("jdbc:mysql://localhost:3306/sakila");
        dataSource.setUsername(username);
        dataSource.setPassword(password);

        // Step 1: List actors by last name
        doSimpleQuery(dataSource, lastNameToSearch);

        // Step 2: Ask full name and get films
        System.out.print("Now enter the actor's FIRST name: ");
        String firstName = scanner.nextLine();

        System.out.print("Enter the actor's LAST name: ");
        String lastName = scanner.nextLine();

        getFilmsByActor(dataSource, firstName, lastName);

        // (Optional) From your original code
        doJoin(dataSource, lastNameToSearch);
    }

    public static void doSimpleQuery(BasicDataSource dataSource, String lastNameToSearch) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     """
                     SELECT first_name, last_name
                     FROM actor
                     WHERE last_name LIKE ?
                     ORDER BY last_name;
                     """
             )) {
            preparedStatement.setString(1, lastNameToSearch);

            try (ResultSet results = preparedStatement.executeQuery()) {
                while (results.next()) {
                    String firstName = results.getString("first_name");
                    String lastName = results.getString("last_name");

                    System.out.println("FirstName: " + firstName);
                    System.out.println("LastName: " + lastName);
                    System.out.println("===============================================");
                }
            }
        } catch (Exception ex) {
            System.out.println("An error has occurred!");
            ex.printStackTrace();
        }
    }

    public static void getFilmsByActor(BasicDataSource dataSource, String firstName, String lastName) {
        String sql = """
            SELECT f.title
            FROM film f
            JOIN film_actor fa ON f.film_id = fa.film_id
            JOIN actor a ON fa.actor_id = a.actor_id
            WHERE a.first_name = ? AND a.last_name = ?
            ORDER BY f.title;
            """;

        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, firstName);
            stmt.setString(2, lastName);

            try (ResultSet results = stmt.executeQuery()) {
                if (results.next()) {
                    System.out.println("Movies featuring " + firstName + " " + lastName + ":");
                    do {
                        System.out.println("- " + results.getString("title"));
                    } while (results.next());
                } else {
                    System.out.println("No movies found for that actor.");
                }
            }
        } catch (Exception ex) {
            System.out.println("An error occurred while retrieving films.");
            ex.printStackTrace();
        }
    }

    public static void doJoin(BasicDataSource dataSource, String lastNameToSearch) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "SELECT customer.first_name, customer.last_name, " +
                             "address.address, city.city, country.country " +
                             "FROM customer " +
                             "LEFT JOIN address ON customer.address_id = address.address_id " +
                             "LEFT JOIN city ON address.city_id = city.city_id " +
                             "LEFT JOIN country ON city.country_id = country.country_id " +
                             "WHERE customer.last_name LIKE ? " +
                             "ORDER BY customer.first_name;")) {

            preparedStatement.setString(1, lastNameToSearch);

            try (ResultSet results = preparedStatement.executeQuery()) {
                while (results.next()) {
                    System.out.printf("first_name = %s, last_name = %s, address = %s, city = %s, country = %s\n",
                            results.getString(1),
                            results.getString(2),
                            results.getString(3),
                            results.getString(4),
                            results.getString(5));
                }
            }
        } catch (Exception ex) {
            System.out.println("An error has occurred!");
            ex.printStackTrace();
        }
    }
}
