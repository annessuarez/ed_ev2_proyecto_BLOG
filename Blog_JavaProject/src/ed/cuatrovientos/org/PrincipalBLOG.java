package ed.cuatrovientos.org;

import java.util.Scanner;

public class PrincipalBLOG {
	private static Scanner scaner = new Scanner(System.in);

	public static void main(String[] args) {
		String option = "";	
		Blog blog = new Blog();

		do {
			menu();
			option = scaner.nextLine();
			stateMachine(option, blog);

		} while(!option.equals("5"));	
	}

	private static void menu() {
		System.out.println(" ");
		System.out.println("----Welcome to Blog Manager----");
		System.out.println("Select an option:");
		System.out.println("1. Add a new article");
		System.out.println("2. Delete an article");
		System.out.println("3. Show an article by ID");
		System.out.println("4. Show all articles in the Blog");
		System.out.println("5. Exit"); 
		System.out.print("Option: ");
	}
	
	private static void stateMachine(String option, Blog blog) {
		switch (option) {
			case "1":  // ADD ARTICLE
				System.out.println("1. Add a new article"); 
				System.out.print("Enter article ID (number): ");
				int id = Integer.parseInt(scaner.nextLine());
				System.out.print("Enter author username: ");
				String username = scaner.nextLine();
				System.out.print("Enter article title: ");
				String title = scaner.nextLine();
				System.out.print("Enter article content: ");
				String content = scaner.nextLine();

				User author = new User(username);
				Article article = new Article(id, title, content, author); 
				String result = blog.addArticle(article);
				System.out.println("\n" + result);
				break;

			case "2":  // REMOVE ARTICLE
				System.out.println("2. Delete an article");
				System.out.print("Enter article ID to delete: ");
				int idArticle = Integer.parseInt(scaner.nextLine());	        
				result = blog.removeArticle(idArticle);
				System.out.println("\n" + result);
				break;

			case "3":  // SHOW ARTICLE BY ID
				System.out.println("3. Show an article by ID");
				System.out.print("Enter article ID: ");
				idArticle = Integer.parseInt(scaner.nextLine());

				Article lookedArticle = blog.getArticle(idArticle);

				if (lookedArticle != null) {
					System.out.println("\nARTICLE FOUND");
					System.out.println("ID: " + lookedArticle.getIdArticle());
					System.out.println("Author: " + lookedArticle.getAuthor().getUsername());
					System.out.println("Title: " + lookedArticle.toString());
				} else {
					System.out.println("Article with ID " + idArticle + " not found.");
				}
				break;	
				
			case "4":  // SHOW ALL ARTICLES
				System.out.println("4. Show all articles in the Blog");
				String allArticlesText = blog.getAllArticles();
				System.out.println(allArticlesText);
				break;
				
			case "5":  // EXIT
				System.out.println("6. Exit");
				System.out.println("Goodbye!");
				break; 
				
			default:
				System.out.println("Invalid option");
				break;
		}
	}
}